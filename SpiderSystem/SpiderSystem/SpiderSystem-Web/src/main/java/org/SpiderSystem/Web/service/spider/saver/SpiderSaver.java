package org.SpiderSystem.Web.service.spider.saver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.SpiderSystem.SpiderFramework.core.saver.Saver;
import org.SpiderSystem.SpiderFramework.model.Page;

/**
 * 存储器
 * @author zzy
 *
 */
public class SpiderSaver implements Saver{
	private String fileRoot;
	
	public SpiderSaver(String missionName){
		String os_name = System.getProperty("os.name");
    	if(os_name.equals("Linux")){
    		fileRoot = "/home/ubuntu/Desktop/outputs/";
    	}else if(os_name.equals("Mac OS X")){
    		fileRoot = "/Users/zzy/Desktop/outputs/";
    	}else{
    		fileRoot = "./outputs/";
    	}
    	
    	fileRoot += missionName;
    	fileRoot += "/";
	}

	@Override
	public void save(Page page) {
		// TODO Auto-generated method stub
		//结果不为空就存储！
		
        if (page.getItems().size() != 0) {
            try {
            	// System.out.println("save the context");
            	
                // String fileRoot = System.getProperty("user.home") + "/Desktop/ScriptSpider/";
            	// System.out.println(System.getProperty("user.dir"));
            	
                File file = new File(fileRoot + (new Date().getTime()) + ".txt");
                File fileParent = file.getParentFile();
                if (!fileParent.exists()) {
                    fileParent.mkdirs();
                }
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                page.getItems().forEach((key, value) -> {
                    try {
                        fileWriter.append(key.toString() + "\n").append(value.toString() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fileWriter.flush();
                fileWriter.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
	}

}
