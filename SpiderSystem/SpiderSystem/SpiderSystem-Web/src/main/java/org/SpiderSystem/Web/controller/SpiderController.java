package org.SpiderSystem.Web.controller;

import org.SpiderSystem.Web.TestThreadAfterWeb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/spider")
public class SpiderController {
	
	@RequestMapping(value="index")
	public String index(){
		
		return "spider_index";
	}
	
	@RequestMapping(value="/start")
	public String start(){
		TestThreadAfterWeb t = null;
		if(TestThreadAfterWeb.isNull()){
			// 获取单例对象，启动线程标志位
			t = TestThreadAfterWeb.getSingleton();
			t.startme();
		}		
		if(t != null){
			t.start();
		}
		return "spider_index";
	}
	
	@RequestMapping(value="/stop")
	public String stop(){
		TestThreadAfterWeb t = null;
		if(!TestThreadAfterWeb.isNull()){
			// 获取单例对象，关闭线程标志位
			t = TestThreadAfterWeb.getSingleton();
			t.stopme();
		}		
		TestThreadAfterWeb.setNull();
		
		return "spider_index";
	}
	
	@RequestMapping(value="/check")
	public String check(Model model){
		if(TestThreadAfterWeb.isNull()==true){
			model.addAttribute("state", "the state of stopping");
		}else{
			model.addAttribute("state", "the state of running");
		}
		return "spider_result";
	}
}
