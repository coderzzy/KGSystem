package org.SpiderSystem.Web.service.spider.saver;

import java.util.Map.Entry;

import org.SpiderSystem.SpiderFramework.core.saver.Saver;
import org.SpiderSystem.SpiderFramework.model.Page;
import org.SpiderSystem.Web.service.INewsService;

public class SQLSaver implements Saver{
	private static int count = 0;

	private INewsService newsService;
	
	public SQLSaver(INewsService newsService){
		this.newsService = newsService;
	}

	@Override
	public void save(Page page) {
		// TODO Auto-generated method stub		
		String title = "";
		String content = "";
		String time = "";
		String url = "";
		for(Entry<Object, Object> entry: page.getItems().entrySet()){
			// System.out.println(entry.getKey()+":"+entry.getValue());
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			if(key.equals("title")){
				title = value;
			}else if(key.equals("time")){
				time = value;
			}else if(key.equals("content")){
				content = value;
			}else if(key.equals("url")){
				url = value;
			}
		}
		
		// System.out.println("--"+title);
		// System.out.println("--"+content);
		// System.out.println("--"+time);
		// System.out.println("--"+url);
		
		if(newsService.addNews(++count, title, content, time, url)){
			// 成功
			// System.out.println("success");
		}else{
			// System.out.println("error");
		}
		
	}

}