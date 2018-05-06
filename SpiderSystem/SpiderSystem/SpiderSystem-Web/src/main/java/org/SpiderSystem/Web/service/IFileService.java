package org.SpiderSystem.Web.service;

import java.io.IOException;
import java.util.List;

import org.SpiderSystem.Web.pojo.News;
import org.SpiderSystem.Web.util.DataEntity;
import org.jdom.JDOMException;

public interface IFileService {
	List<String> getLogs(int total);
	
	List<String> getXmls(int total);
	
	void setXmls(int id,News news,String fileName,String charset) throws IOException, JDOMException;
	
	List<DataEntity> getFrequency(String fileName,int total);
}
