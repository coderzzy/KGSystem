package org.SpiderSystem.Web.service;

import java.io.IOException;
import java.util.List;

import org.SpiderSystem.Web.pojo.News;
import org.jdom.JDOMException;

public interface IFileService {
	List<String> getLogs(int total);
	
	List<String> getXmls(int total);
	
	void setXmls(int id,News news,String fileName,String charset) throws IOException, JDOMException;
}
