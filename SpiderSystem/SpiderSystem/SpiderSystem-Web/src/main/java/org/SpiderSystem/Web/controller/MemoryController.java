package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 内存信息模块Controller器
 * @author zzy
 *
 */
@Controller
@RequestMapping(value="/memory")
public class MemoryController {
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "memory_system";
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
						map.put("value", Runtime.getRuntime().freeMemory()/1024/1024);
						
						
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
}