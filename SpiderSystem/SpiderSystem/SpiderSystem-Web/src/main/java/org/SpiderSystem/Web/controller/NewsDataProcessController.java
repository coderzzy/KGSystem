package org.SpiderSystem.Web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.pojo.News;
import org.SpiderSystem.Web.service.IDataProcessService;
import org.SpiderSystem.Web.service.IFileService;
import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.service.INewsService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.SpiderSystem.Web.util.ConstantConfig;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 数据处理Controller器,包括预处理,分词和词频统计等
 * @author zzy
 *
 */
@Controller
@RequestMapping(value="/newsDataProcess")
public class NewsDataProcessController {
	
	private static Logger logger = LoggerFactory.getLogger(NewsDataProcessController.class);
	private static int preProcess_check = ConstantConfig.PRE_PROCESS_CHECK_STOP;
	private static int segmentProcess_check = ConstantConfig.SEGMENT_PROCESS_CHECK_STOP;
	
	@Resource
	private IFileService fileService;
	
	@Resource
	private INewsService newsService;
	
	@Resource
	private IDataProcessService dataProcessService;
	
	@RequestMapping(value="/index_pre")
	public String index_pre(){
		
		return "data_news_process_pre";
	}
	
	@RequestMapping(value="/index_wordSegment")
	public String index_wordSegment(){
		
		return "data_news_process_wordSegment";
	}
	
	/**
	 * 数据清洗，并且写入xml表格,去除空白、非法、过时数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/preProcess")
	public void preProcess(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						
						Map<String,Object> map = new HashMap<String,Object>();
						Thread thread = new Thread(){
							public void run(){
								preProcess_check = ConstantConfig.PRE_PROCESS_CHECK_RUN;
								int id = 1;
								int size=6;
								for(int i=0;i<newsService.getNewsCount()/size;i++){
									List<News> list = newsService.getNewsPage(i+1, size);
									for (Iterator<News> it = list.iterator(); it.hasNext();) {
									     News news = it.next();
									     // System.out.println("1:"+news.getTitle());
									     // System.out.println("2:"+news.getContent());
									     // System.out.println("3:"+news.getTime());
									     // System.out.println("4:"+news.getUrl());
									     if(news.getContent().equals("") || 
									    		 news.getTime().equals("") || 
									    		 news.getTitle().equals("") || 
									    		 news.getUrl().equals("")){
									    	 continue;
									    }
									     if(news.getTime().contains("2018") || 
									    		 news.getTime().contains("2017") ||
									    		 news.getTime().contains("2016")){
									    	 try {
										    	 fileService.setXmls(id++, news, "data_process/news_data.xml", "UTF-8");
										    	 logger.info("---------------the news of "+ (id-1) + " success into xml");
										    	 } catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
													preProcess_check = ConstantConfig.PRE_PROCESS_CHECK_STOP;
													return;
										    	 } catch (org.jdom.IllegalDataException e){
										    		 logger.error(e.getMessage());
										    		 continue;
												} catch (JDOMException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
													preProcess_check = ConstantConfig.PRE_PROCESS_CHECK_STOP;
													return;
												} 
									     }
									     
									}	
								}
								preProcess_check = ConstantConfig.PRE_PROCESS_CHECK_SUCCESS;
							}
						};
						thread.start();
						map.put("result", "success");
						
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
	
	@RequestMapping(value="/preProcess_check")
	public void preProcess_check(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						
						Map<String,Object> map = new HashMap<String,Object>();
						if(preProcess_check == ConstantConfig.PRE_PROCESS_CHECK_SUCCESS){
							map.put("result", "success");
						}else if (preProcess_check == ConstantConfig.PRE_PROCESS_CHECK_RUN){
							map.put("result", "run");
						}else{
							map.put("result", "stop");
						}
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
	
	@RequestMapping(value="/word_segment")
	public void word_segment(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						
						Map<String,Object> map = new HashMap<String,Object>();
						Thread thread = new Thread(){
							public void run(){
								segmentProcess_check = ConstantConfig.SEGMENT_PROCESS_CHECK_RUN;
								for(int i=0;i<ConstantConfig.SEGMENT_NUMBER;i++){
									dataProcessService.runWord(
											ConstantConfig.XML_PATH, 
											ConstantConfig.SEGMENT_PATH[i], 
											ConstantConfig.FREQUENCY_PATH[i], 
											ConstantConfig.ALGORITHM[i]);
									logger.info("the segment and frequency " + (i+1) + "has finished");
								}
								segmentProcess_check = ConstantConfig.SEGMENT_PROCESS_CHECK_SUCCESS;
							}
						};
						thread.start();
						map.put("result", "success");
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
	
	@RequestMapping(value="/segmentProcess_check")
	public void segmentProcess_check(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						
						Map<String,Object> map = new HashMap<String,Object>();
						if(segmentProcess_check == ConstantConfig.SEGMENT_PROCESS_CHECK_SUCCESS){
							map.put("result", "success");
						}else if (segmentProcess_check == ConstantConfig.SEGMENT_PROCESS_CHECK_RUN){
							map.put("result", "run");
						}else{
							map.put("result", "stop");
						}
						return map;
					}
		});
	    AjaxProcessor.renderData(response, jsonResult);
	}
}
