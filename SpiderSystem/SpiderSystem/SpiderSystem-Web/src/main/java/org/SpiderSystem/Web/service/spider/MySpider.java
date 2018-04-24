package org.SpiderSystem.Web.service.spider;

import org.SpiderSystem.SpiderFramework.core.downloader.Downloader;
import org.SpiderSystem.SpiderFramework.core.downloader.PreDefine.HttpClientPoolDownloader;
import org.SpiderSystem.SpiderFramework.core.pageprocesser.PageProcessor;
import org.SpiderSystem.SpiderFramework.core.pageprocesser.PreDefine.TextPageProcessor;
import org.SpiderSystem.SpiderFramework.core.saver.PreDefine.ConsoleSaver;
import org.SpiderSystem.SpiderFramework.core.saver.Saver;
import org.SpiderSystem.SpiderFramework.core.scheduler.PreDefine.QueueScheduler;
import org.SpiderSystem.SpiderFramework.core.scheduler.Scheduler;
import org.SpiderSystem.SpiderFramework.model.Page;
import org.SpiderSystem.SpiderFramework.model.RegexRule;
import org.SpiderSystem.SpiderFramework.model.UrlSeed;
import org.SpiderSystem.SpiderFramework.utils.TimeSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 全局爬虫线程，单例模式
 * @author zzy
 *
 */
public class MySpider extends Thread{
	private static MySpider singleton;
	private boolean runflag = true;

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Scheduler scheduler;
    private Downloader downloader;
    private PageProcessor pageProcessor;
    private Saver saver;

    //新种子的过滤器，只有通过正则的，才会加入到待爬取种子队列
    private RegexRule regexRule;

    private int threadNum = 5;//线程池大小。默认5个爬虫在进行。
    private ThreadPoolExecutor pool;
    
    private MySpider() {
        setDefaultComponents();
        regexRule = new RegexRule();
    }
    
    public void startme(){
		this.runflag = true;
	}
	
	public void stopme(){
		this.runflag = false;
	}
	
	public static boolean isNull(){
		if(singleton == null){
			return true;
		}else{
			return false;
		}
	}
	
	public static MySpider getSingleton(){
		if(singleton == null){
			synchronized(MySpider.class){
				if(singleton == null){
					singleton = MySpider.build();
				}
			}
		}
		
		return singleton;
	}
	
	/**
	 * 将对象置null，触发GC
	 */
	public static void setNull(){
		singleton = null;
	}
	

    /**
     * 最多几个爬虫在进行。
     * 默认5个。
     *
     * @param threadNum 线程数量
     * @return 自己
     */
    public MySpider thread(int threadNum) {
        this.threadNum = threadNum;
        if (threadNum <= 0) {
            this.threadNum = 5;
        }
        pool = new ThreadPoolExecutor(threadNum, threadNum,
                1500L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        return this;
    }

    public static MySpider build() {
        return new MySpider();
    }

    public MySpider setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
        return this;
    }

    public MySpider setDownloader(Downloader d) {
        this.downloader = d;
        return this;
    }

    public MySpider setProcessor(PageProcessor p) {
        this.pageProcessor = p;
        return this;
    }

    public MySpider setSaver(Saver s) {
        this.saver = s;
        return this;
    }

    /**
     * 添加初始化种子，可以多个
     *
     * @param url url
     * @return Spider
     */
    public MySpider addUrlSeed(String url) {
        scheduler.push(new UrlSeed(url));
        return this;
    }

    /**
     * 添加新种子需要满足的正则信息（正则规则有两种，正正则和反正则）
     * <p>
     * URL符合正则规则需要满足下面条件：
     * 1.至少能匹配一条正正则
     * 2.不能和任何反正则匹配
     * 举例：
     * 正正则示例：+a.*c是一条正正则，正则的内容为a.*c，起始加号表示正正则
     * 反正则示例：-a.*c时一条反正则，正则的内容为a.*c，起始减号表示反正则
     * 如果一个规则的起始字符不为加号且不为减号，则该正则为正正则，正则的内容为自身
     * 例如a.*c是一条正正则，正则的内容为a.*c
     *
     * @param regex 正则
     * @return Spider
     */
    public MySpider addRegexRule(String regex) {
        regexRule.addRule(regex);
        return this;
    }

    private MySpider setDefaultComponents() {

        thread(threadNum);

        if (scheduler == null) {
            scheduler = new QueueScheduler();
        }
        if (downloader == null) {
            downloader = new HttpClientPoolDownloader();
        }
        if (pageProcessor == null) {
            pageProcessor = new TextPageProcessor();
        }
        if (saver == null) {
            saver = new ConsoleSaver();
        }
        return this;
    }

    public void run() {

        logger.info("爬虫启动!");


        UrlSeed urlSeed = null;
        while (runflag) {
            logger.info("当前线程池" + "已完成:" + pool.getCompletedTaskCount() + "   运行中：" + pool.getActiveCount() + "  最大运行:" + pool.getPoolSize() + " 等待队列:" + pool.getQueue().size());
            if (pool.getQueue().size() > pool.getCorePoolSize()) {
                //如果等待队列大于了100.就暂停接收新的url。不然会影响优先级队列的使用。
                TimeSleep.sleep(1000);
                continue;
            }
            urlSeed = scheduler.poll();
            if (urlSeed == null && pool.getActiveCount() == 0) {
                pool.shutdown();
                try {
                    pool.awaitTermination(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    logger.error("关闭线程池失败！", e);
                }
                logger.info("爬虫结束！");
                break;
            } else if (urlSeed == null) {
                //没有取到种子就等待!
                TimeSleep.sleep(1000);
            } else {
                logger.info("正在处理:" + urlSeed.getUrl() + "  优先级(默认:5):" + urlSeed.getPriority());
                pool.execute(new SpiderWork(urlSeed.clone()));
            }
        }
        singleton = null;

    }

	class SpiderWork implements Runnable {
	
	    private UrlSeed urlSeed;
	
	    SpiderWork(UrlSeed urlSeed) {
	
	        this.urlSeed = urlSeed;
	    }
	
	    public void run() {
	
	        logger.debug("线程:[" + Thread.currentThread().getName() + "]正在处理:" + urlSeed.getUrl());
	        logger.debug("当前线程池" + "已完成:" + pool.getCompletedTaskCount() + "   运行中：" + pool.getActiveCount() + "  最大运行:" + pool.getPoolSize() + " 等待队列:" + pool.getQueue().size());
	
	        //整个流程为:
	        // (download下载) ->  (pageProcessor解析处理) ->  (save存储)
	
	        Page nowPage = downloader.download(urlSeed);
	
	        pageProcessor.process(nowPage);
	        //正则处理
	        List<UrlSeed> urlSeedList = nowPage.links();
	        //                    System.out.println(seed.getUrl());
	        urlSeedList.removeIf(seed -> !regexRule.regex(seed.getUrl()));
	
	        nowPage.setNewUrlSeed(urlSeedList);
	        pageProcessor.processNewUrlSeeds(nowPage);
	
	        nowPage.getNewUrlSeed().forEach(seed -> scheduler.push(seed));
	
	        saver.save(nowPage);

        }
    }
}


