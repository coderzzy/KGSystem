package org.SpiderSystem.Web.service;

import java.util.Map;

/**
 * 用于Ajax中json数据与数据库的对接操作
 * @author zzy
 *
 */
public interface IJsonService {
	Map<String,Object> run();
}
