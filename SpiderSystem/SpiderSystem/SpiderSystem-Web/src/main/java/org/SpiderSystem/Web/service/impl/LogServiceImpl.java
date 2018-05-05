package org.SpiderSystem.Web.service.impl;

import java.util.List;

import org.SpiderSystem.Web.service.ILogService;
import org.SpiderSystem.Web.util.LogsReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogServiceImpl implements ILogService{

	@Override
	public List<String> getLogs(int total) {
		// TODO Auto-generated method stub
		List<String> result = LogsReader.readFromLast("logs/ssm.log", "UTF-8", total);
		if(!result.isEmpty()){
			return result;
		}else{
			return null;
		}
	}

	@Override
	public List<String> getXmls(int total) {
		// TODO Auto-generated method stub
		List<String> result = LogsReader.read("data_process/news_data.xml", "UTF-8", total);
		if(!result.isEmpty()){
			return result;
		}else{
			return null;
		}
	}
	
	/*
	public static void main(String[] args){
		new LogServiceImpl().getLogs();
	}
	*/

}
