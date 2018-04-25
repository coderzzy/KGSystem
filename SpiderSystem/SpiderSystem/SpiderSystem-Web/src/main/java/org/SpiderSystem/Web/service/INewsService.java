package org.SpiderSystem.Web.service;

import java.util.List;

import org.SpiderSystem.Web.pojo.News;

public interface INewsService {
	public boolean addNews(int newsId,String newsTitle,String newsContent,String newsTime,String newsUrl);
	
	public int getNewsCount();
	
	public List<News> getNewsPage(int pageNO, int size);
	
	public boolean delNews(int newsId);
	
	public News getNewsById(int newsId);
}
