package org.SpiderSystem.Web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/log")
public class LogController {
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "log_system";
	}
}