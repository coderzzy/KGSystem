package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.service.IFileService;
import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.SpiderSystem.Web.util.ConstantConfig;
import org.SpiderSystem.Web.util.DataEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 日志模块Controller层
 * @author zzy
 *
 */
@Controller
@RequestMapping(value="/log")
public class LogController {
	
	@Resource
	IFileService fileService;
	
	/**
	 * 跳转日志系统首页
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(){
		
		return "log_system";
	}
	
	//----------------------------------------------AJAX------------------------------------------
	/**
	 * 显示日志
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/show",method = RequestMethod.POST)
	public void show(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						Map<String,Object> map = new HashMap<String,Object>();
						List<String> list = fileService.getLogs(500);
						if(list != null){
							map.put("result", "success");
							map.put("path", System.getProperty("user.dir"));
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
	
	/**
	 * 显示xml文件
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/show_xml",method = RequestMethod.POST)
	public void show_xml(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						Map<String,Object> map = new HashMap<String,Object>();
						List<String> list = fileService.getXmls(500);
						if(list != null){
							map.put("result", "success");
							map.put("path", System.getProperty("user.dir"));
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
	
	
	@RequestMapping(value="/show_frequency",method = RequestMethod.POST)
	public void show_frequency(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						Map<String,Object> map = new HashMap<String,Object>();
						List<DataEntity> list = fileService.getFrequency(
								ConstantConfig.FREQUENCY_PATH[Integer.valueOf(request.getParameter("index"))-1], 
								300);
						if(list != null){
							map.put("result", "success");
							// map.put("path", System.getProperty("user.dir"));
							map.put("title", 
								ConstantConfig.ALGORITHM_NAME[Integer.valueOf(request.getParameter("index"))-1]);
							// System.out.println(list.size());
							
							List<String> list1 = new LinkedList<String>();
							List<Integer> list2 = new LinkedList<Integer>();
							for(DataEntity dataEntity : list){
								if(dataEntity.word.matches(".*\\d+.*")){
									// 去除含有数字的
									continue;
								}
								list1.add(dataEntity.word);
								list2.add(dataEntity.times);
							}
							String[] desc1 = new String[list1.size()];
							Integer[] desc2 = new Integer[list2.size()];
							list1.toArray(desc1);
							map.put("string",desc1);
							list2.toArray(desc2);
							map.put("integer", desc2);
						}else{
							map.put("result", "error");
						}
						return map;
					}
		});
		AjaxProcessor.renderData(response, jsonResult);
	}
	
}
