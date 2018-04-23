package org.SpiderSystem.Web.service.spider.pageprocesser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.SpiderSystem.SpiderFramework.core.pageprocesser.PageProcessor;
import org.SpiderSystem.SpiderFramework.model.Page;
import org.SpiderSystem.Web.util.SpiderProperties;
import org.jsoup.nodes.Document;

/**
 * 页面解析器
 * @author zzy
 *
 */
public class SpiderPageProcessor implements PageProcessor{
	private Map<String, String> itemMap;
	
	public SpiderPageProcessor(Map<String,String> itemMap){
		this.itemMap = itemMap;
	}

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		//如果不匹配，则不进行解析！
        if (!Pattern.matches(
        		SpiderProperties.getRegexRule(), 
        		page.getUrlSeed().getUrl())) {
            return;
        }

        Document htmldoc = page.getDocument();
        //select返回的是一个数组，所以需要first，相关语法请google“jsoup select语法”和“cssquery”
        try {
        	// String title = htmldoc.select(".d_title").first().text();
            // String text = htmldoc.select(".d_detail").first().text();
        	
            // String title = htmldoc.select("h1.entry-title").first().text();
            // System.out.println(title);
            // String date = htmldoc.select("time.entry-date").first().text();
            // String text = htmldoc.select("div.entry-content").first().text();

            //用来存放爬取到的信息，供之后存储！map类型的即可，可以自定义各种嵌套！
            Map<String, String> items = new HashMap<String, String>();
            // items.put("title", title);
            // items.put("date", date);
            // items.put("text", text);
            
            // 遍历select_items，将爬取的值存入新的items
            for(Map.Entry<String, String> entry : itemMap.entrySet()){
            	items.put(entry.getKey(), htmldoc.select(entry.getValue()).first().text());
            }
            items.put("url", page.getUrlSeed().getUrl());

            //放入items中，之后会自动保存（如果你自己实现了下载器，请自己操作它。如下我自定义了自己的下载器，并将它保存到了文本中！）！
            page.setItems(items);
            // System.out.println("success");
        } catch (NullPointerException e) {
            // System.out.println("没有解析到相关东西！跳过");
        }
	}

}
