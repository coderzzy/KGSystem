package org.SpiderSystem.Web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.pojo.Admin;
import org.SpiderSystem.Web.service.IAdminService;
import org.SpiderSystem.Web.service.IJsonService;
import org.SpiderSystem.Web.util.AjaxProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 管理员用户模块Controller器
 * @author zzy
 *
 */
@Controller
@SessionAttributes(value={"adminId"})
@RequestMapping(value="/admin")
public class AdminController {
	
	@Resource
	IAdminService adminService;
	
	/**
	 * 跳转总首页
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(){
		
		return "admin_index";
	}
	
	
	//----------------------------------------------AJAX------------------------------------------
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value="/submit",method = RequestMethod.POST)
	public void submit(HttpServletRequest request,HttpServletResponse response,Model model){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
						public Map<String, Object> run() {
						// TODO Auto-generated method stub
						// System.out.println(request.getParameter("adminEmail"));
						int adminId = adminService.isSubmit(
								request.getParameter("adminEmail"), 
								request.getParameter("adminPassword")
								);
						Map<String,Object> map = new HashMap<String,Object>();
						if(adminId > 0){
							model.addAttribute("adminId", adminId);
							map.put("result", "success");
						}else{
							map.put("result", "error");
						}
						return map;
					}
		});
		AjaxProcessor.renderData(response, jsonResult);
	}
	
	
	/**
	 * 显示个人信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/show",method = RequestMethod.POST)
	public void show(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
						public Map<String, Object> run() {
						// TODO Auto-generated method stub
						// System.out.println(request.getParameter("adminEmail"));
						Admin admin = adminService.getAdminById(
								Integer.parseInt(request.getParameter("adminId"))
								);
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("result", "success");
						map.put("adminName", admin.getName());
						map.put("adminEmail", admin.getEmail());
						map.put("adminTelephone", admin.getTelephone());
						map.put("adminQq", admin.getQq());
						map.put("adminTwitter", admin.getTwitter());
						map.put("adminIntro", admin.getIntro());
						return map;
					}
		});
		AjaxProcessor.renderData(response, jsonResult);
	}
	
	
	/**
	 * 保存修改的值
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public void save(HttpServletRequest request,HttpServletResponse response){
		String jsonResult = AjaxProcessor.getJSONString(request,
				new IJsonService(){
					@Override
						public Map<String, Object> run() {
						// TODO Auto-generated method stub
						// System.out.println(request.getParameter("adminEmail"));
						Map<String,Object> map = new HashMap<String,Object>();
						if(
							adminService.updateAdmin(
								Integer.parseInt(request.getParameter("adminId")),
								request.getParameter("adminEmail"),
								request.getParameter("adminName"),
								request.getParameter("adminPhone"),
								request.getParameter("adminQq"),
								request.getParameter("adminTwitter"),
								request.getParameter("adminIntro")
							)	
						){
							map.put("result", "success");
						}else{
							map.put("result", "error");
						}
						return map;
					}
		});
		AjaxProcessor.renderData(response, jsonResult);
	}
}
