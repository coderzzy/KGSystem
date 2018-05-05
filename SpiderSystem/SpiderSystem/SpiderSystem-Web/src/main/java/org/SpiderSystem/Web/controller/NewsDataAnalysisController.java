package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.service.INewsService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据分析模块Controller器
 * @author zzy
 *
 */
@Controller
@RequestMapping(value="/newsDataAnalysis")
public class NewsDataAnalysisController {
	
	@Resource
	private INewsService newsService;
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "data_news_analysis";
	}
	
	/**
	 * 统计空白数据率
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/show_blank")
	public void show_blank(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("result", "success");
						
						// 空白数据率
						map.put("news_count", newsService.getNewsCount());
						map.put("news_count_blank", newsService.getNewsBlankCount());
						
						
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
	
	
	/**
	 * 统计日期分布
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/show_date")
	public void show_date(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						
						Map<String,Object> map = new HashMap<String,Object>();
						String[] date = new String[]{"2014","2015","2016","2017","2018"};
						int[] value = new int[date.length];
						for(int i=0;i<date.length;i++){
							value[i] = newsService.getNewsCountLikeYear(date[i]+"%");
							// System.out.println(value[i]);
						}						
						map.put("result", "success");
						map.put("date", date);
						map.put("value", value);
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
}
