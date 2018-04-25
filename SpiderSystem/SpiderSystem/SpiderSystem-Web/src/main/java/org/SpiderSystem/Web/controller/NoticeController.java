package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.pojo.Notice;
import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.service.INoticeService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value={"notice","notice_size","notice_pageNO","notice_count","notices"})
@RequestMapping(value="/notice")
public class NoticeController {
	
	@Resource
	private INoticeService noticeService;
	
	@RequestMapping(value="/update")
	public String toIndex(Model model){
		// int noticeId = Integer.parseInt(request.getParameter("id"));
		int total = noticeService.getNoticesCount();
		int noticeId = (int)Math.random()*total + 1;

        Notice notice = noticeService.getNoticeById(noticeId);
        // System.out.println(notice.getText());

        model.addAttribute("notice", notice);

        // System.out.println("com.cn.ssm.controller.UserController(Object).toIndex2");
        // System.out.println(user.getUserName());
        return "index";
	}
	
	@RequestMapping(value="/show")
	public String show(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
		// int total = noticeService.getNoticesCount();
		// model.addAttribute("notice_total", total);
		int size=6;
        model.addAttribute("notice_size",size);
        model.addAttribute("notice_pageNO",pageNO);
        model.addAttribute("notice_count",noticeService.getNoticesCount());
        model.addAttribute("notices", noticeService.getNoticesPage(pageNO, size));
        // System.out.println(noticeService.getNoticesPage(pageNO, size).size());
		return "data_notice";
	}
	
	
	//----------------------------------------------AJAX------------------------------------------
	/**
	 * 保存前端ajax传回的数据，无需刷新页面
	 */
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public void add(HttpServletRequest request, HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						if(noticeService.addNotice(
								Integer.parseInt(request.getParameter("noticeId")), 
					    	request.getParameter("noticeText")) == true){
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
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public void del(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						if(noticeService.delNotice(
								Integer.parseInt(request.getParameter("noticeId")))==true){
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
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
					public Map<String, Object> run() {
						// TODO Auto-generated method stub
						if(noticeService.updateNotice(
								Integer.parseInt(request.getParameter("noticeId")),
								request.getParameter("noticeText")) == true){
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
