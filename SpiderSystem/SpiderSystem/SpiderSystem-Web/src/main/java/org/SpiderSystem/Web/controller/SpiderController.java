package org.SpiderSystem.Web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.service.INewsService;
import org.SpiderSystem.Web.service.ISpiderService;
import org.SpiderSystem.Web.util.SpiderProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/spider")
public class SpiderController {
	
	@Resource
	private INewsService newsService;
	
	@Resource
	private ISpiderService spiderService;
	
	@RequestMapping(value="/start")
	public String start(){
		/*
		SpiderService.start("http://www.199it.com", "http://www.199it.com/.*html",
				new HashMap<String,String>(){
			{
				put("title","h1.entry-title");
				put("text","div.entry-content");
				put("date","time.entry-date");
			}
		},
				"199it"
		);
		*/
		spiderService.start(
				SpiderProperties.getUrlSeed(),
				SpiderProperties.getRegexRule(),
				SpiderProperties.getItemMap(),
				SpiderProperties.getMissionName()
				);
		return "admin_index";
	}
	
	@RequestMapping(value="/stop")
	public String stop(){
		spiderService.stop();
		return "admin_index";
	}
	
	@RequestMapping(value="/check")
	public String check(Model model){
		spiderService.check(model);
		return "spider_system";
	}
	
	/**
	 * 直接爬取数据存储数据库，此部分暂时不把依赖提升到view层
	 * @return
	 */
	@RequestMapping(value="/mysql")
	public String mysql(){
		spiderService.mysql("http://www.199it.com", "http://www.199it.com/.*html",
				newsService
				/*
				new HashMap<String,String>(){
			{
				put("title","h1.entry-title");
				put("content","div.entry-content");
				put("date","time.entry-date");
			}
		}*/
		);
		return "admin_index";
	}
	
	
	//----------------------------------------------AJAX------------------------------------------
	/**
	 * 保存前端ajax传回的数据，无需刷新页面
	 */
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response){
		String jsonResult = getJSONString(request);
	    renderData(response, jsonResult);
	}
	
	private String getJSONString(HttpServletRequest request) {
		//故意构造一个数组，使返回的数据为json数组，数据更复杂些
	    List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>(5);
	    Map<String, Object> map1 = new HashMap<String, Object>(10);
	    //可以获得ajax请求中的参数
	    /*
	    map1.put("a", request.getParameter("a"));
	    map1.put("b", request.getParameter("b"));
	    map1.put("c", request.getParameter("c"));
	    */
	    // System.out.println(request.getParameter("UrlSeed")+request.getParameter("RegexRule")+request.getParameter("mission"));
	    // System.out.println(request.getParameter("items"));
	    String items = request.getParameter("itemMap");
	    items = items.substring(1,items.length()-1); // 去除{}
	    SpiderProperties.update(request.getParameter("urlSeed"), 
	    		request.getParameter("regexRule"), 
	    		items, 
	    		request.getParameter("missionName"));
	    
	    System.out.println(SpiderProperties.getUrlSeed());
	    System.out.println(SpiderProperties.getRegexRule());
	    for(Map.Entry<String,String> entry : SpiderProperties.getItemMap().entrySet()){
	    	System.out.println(entry.getKey()+":"+entry.getValue());
	    }
	    System.out.println(SpiderProperties.getMissionName());
	  
	    map1.put("result", "success");
	    datas.add(map1);
	    /*
	    //故意构造一个数组，使返回的数据为json数组，数据更复杂些
	    Map<String, Object> map2 = new HashMap<String, Object>(10);
	    map2.put("a", "11");
	    map2.put("b", "22");
	    map2.put("c", "33");
	    datas.add(map2);
	    */
	    String jsonResult = JSON.toJSONString(datas);
	    return jsonResult;
	    
	}
	
	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 * 
	 * @param response
	 * @param data
	 */
	private void renderData(HttpServletResponse response, String data){
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != printWriter){
				printWriter.flush();
				printWriter.close();
			}
		}
		
	}
}
