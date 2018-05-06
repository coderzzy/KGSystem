package org.SpiderSystem.Web.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.SpiderSystem.Web.service.IJsonService;

import com.alibaba.fastjson.JSON;

/**
 * 对Ajax的数据进行解包、封包
 * @author zzy
 *
 */
public class AjaxProcessor {
	
	public static String getJSONString(HttpServletRequest request,IJsonService jsonService) {
		//故意构造一个数组，使返回的数据为json数组，数据更复杂些
	    // List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>(5);
	    Map<String, Object> map = null;
	    
	    /**
	     * 处理数据
	     */
	    if((map =jsonService.run())==null){
	    	map = new HashMap<String,Object>();
	    	map.put("result", "error");
	    }
	    
	    /*
	    if(noticeService.addNotice(
	    		Integer.parseInt(request.getParameter("noticeId")), 
	    		request.getParameter("noticeText")) == true){
	    	map1.put("result", "success");
	    }else{
	    	map1.put("result", "error");
	    }
	    */
	    
	    // datas.add(map1);
	    String jsonResult = JSON.toJSONString(map);
	    return jsonResult;
	    
	}
	
	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 * 
	 * @param response
	 * @param data
	 */
	public static void renderData(HttpServletResponse response, String data){
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			printWriter.print(JSON.parse(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != printWriter){
				printWriter.flush();
				printWriter.close();
			}
		}
		
	}
}