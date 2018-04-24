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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;

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
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public void add(HttpServletRequest request, HttpServletResponse response){
		String jsonResult = getJSONString(request);
	    renderData(response, jsonResult);
	}
	
	private String getJSONString(HttpServletRequest request) {
		//故意构造一个数组，使返回的数据为json数组，数据更复杂些
	    List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>(5);
	    Map<String, Object> map1 = new HashMap<String, Object>(10);
	    
	    /**
	     * 处理数据
	     */
	    
	    datas.add(map1);
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
