package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.service.ILogService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/log")
public class LogController {
	
	@Resource
	ILogService logService;
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "log_system";
	}
	
	//----------------------------------------------AJAX------------------------------------------
	@RequestMapping(value="/show",method = RequestMethod.POST)
	public void show(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						Map<String,Object> map = new HashMap<String,Object>();
						List<String> list = logService.getLogs(200);
						if(list != null){
							map.put("result", "success");
							// System.out.println(list.size());
							String[] desc = new String[list.size()];
							list.toArray(desc);
							map.put("array",desc);
						}else{
							map.put("result", "error");
						}
						return map;
					}
		});
		AjaxProcessor.renderData(response, jsonResult);
	}
	
}
