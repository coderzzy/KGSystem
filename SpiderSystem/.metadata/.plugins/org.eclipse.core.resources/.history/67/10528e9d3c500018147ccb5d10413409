package org.SpiderSystem.Web.service.impl;

import java.io.IOException;
import java.util.List;

import org.SpiderSystem.Web.pojo.News;
import org.SpiderSystem.Web.service.IFileService;
import org.SpiderSystem.Web.util.JDomOutput;
import org.SpiderSystem.Web.util.MyFileReader;
import org.jdom.JDOMException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileServiceImpl implements IFileService{

	@Override
	public List<String> getLogs(int total) {
		// TODO Auto-generated method stub
		List<String> result = MyFileReader.readFromLast("logs/ssm.log", "UTF-8", total);
		if(!result.isEmpty()){
			return result;
		}else{
			return null;
		}
	}

	
	@Override
	public List<String> getXmls(int total) {
		// TODO Auto-generated method stub
		List<String> result = MyFileReader.read("data_process/news_data.xml", "UTF-8", total);
		if(!result.isEmpty()){
			return result;
		}else{
			return null;
		}
	}


	@Override
	public void setXmls(int id, News news, String fileName, String charset) throws IOException, JDOMException {
		// TODO Auto-generated method stub
		JDomOutput.execute(id++, news, "data_process/news_data.xml", "UTF-8");
	}
	
	/*
	public static void main(String[] args){
		new LogServiceImpl().getLogs();
	}
	*/

}
