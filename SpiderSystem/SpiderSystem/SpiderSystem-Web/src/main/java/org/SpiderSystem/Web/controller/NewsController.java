package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.pojo.News;
import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.service.INewsService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value={"news_size","news_pageNO","news_count","news"})
@RequestMapping(value="/news")
public class NewsController {
	
	@Resource
	private INewsService newsService;
	
	@RequestMapping(value="/show")
	public String show(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
		// int total = noticeService.getNoticesCount();
		// model.addAttribute("notice_total", total);
		int size=6;
        model.addAttribute("news_size",size);
        model.addAttribute("news_pageNO",pageNO);
        model.addAttribute("news_count",newsService.getNewsCount());
        model.addAttribute("news", newsService.getNewsPage(pageNO, size));
        // System.out.println(noticeService.getNoticesPage(pageNO, size).size());
		return "data_news";
	}
	
	
	//----------------------------------------------AJAX------------------------------------------
	/**
	 * 保存前端ajax传回的数据，无需刷新页面
	 */
	
	@RequestMapping(value="/select",method = RequestMethod.POST)
	public void select(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						News news = newsService.getNewsById(Integer.parseInt(request.getParameter("newsId")));
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("result", "success");
						map.put("title", news.getTitle());
						map.put("content", news.getContent());
						// System.out.println(news.getTitle());
						// System.out.println(news.getContent());
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
	
	@RequestMapping(value="/del",method = RequestMethod.POST)
	public void del(HttpServletRequest request, HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						if(newsService.delNews(
								Integer.parseInt(request.getParameter("newsId"))
								)==true){
							Map<String,Object> map = new HashMap<String,Object>();
							map.put("result", "success");
							return map;
						}else{
							return null;
						}
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
}
