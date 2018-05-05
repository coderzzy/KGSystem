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

@Controller
@RequestMapping(value="/newsDataAnalysis")
public class NewsDataAnalysisController {
	
	@Resource
	private INewsService newsService;
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "data_news_analysis";
	}
	
	@RequestMapping(value="/show")
	public void show(HttpServletRequest request,HttpServletResponse response){
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
}
