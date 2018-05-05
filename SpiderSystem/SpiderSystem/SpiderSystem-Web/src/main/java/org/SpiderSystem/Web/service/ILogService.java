package org.SpiderSystem.Web.service;

import java.util.List;

public interface ILogService {
	List<String> getLogs(int total);
	
	List<String> getXmls(int total);
}
