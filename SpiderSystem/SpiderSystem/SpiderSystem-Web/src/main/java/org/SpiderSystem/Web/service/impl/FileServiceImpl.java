package org.SpiderSystem.Web.service.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.SpiderSystem.Web.pojo.News;
import org.SpiderSystem.Web.service.IFileService;
import org.SpiderSystem.Web.util.DataEntity;
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


	@Override
	public List<DataEntity> getFrequency(String fileName, int total) {
		// TODO Auto-generated method stub
		List<String> result = MyFileReader.read(fileName, "UTF-8", total);
		if(!result.isEmpty()){
			List<DataEntity> list = new LinkedList<DataEntity>();
			for(String ss:result){
				// System.out.println(ss);
				list.add(new DataEntity(ss.split(" ")[0],Integer.valueOf(ss.split(" ")[1])));
			}
			return list;
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