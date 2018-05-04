package org.SpiderSystem.Web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public class LogsReader {
	
	/** 
     *  倒着读,最多读100行
     * @param filename 目标文件 
     * @param charset 目标文件的编码格式 
     * @param total 总共读多少行
     */  
    public static List<String> readFromLast(String filename, String charset, int total) {  
  
        RandomAccessFile rf = null; 
        List<String> list = new LinkedList<String>();
        try {  
            rf = new RandomAccessFile(filename, "r");  
            long len = rf.length();  
            long start = rf.getFilePointer();  
            long nextend = start + len - 1;  
            int line = 1;
            String tempString = null;
            
            rf.seek(nextend);  
            int c = -1;  
            // System.out.println("--------------------------------------------------------");
            while (nextend > start && line <= total) {
            	c = rf.read();  
                if (c == '\n' || c == '\r') { 
                    tempString = rf.readLine();  
                    if (tempString != null) {  
                    	// System.out.println(line);
                    	line++;
                        // System.out.println(new String(tempString.getBytes("ISO-8859-1"), charset));  
                    	list.add(new String(tempString.getBytes("ISO-8859-1"), charset));
                    } else {  
                        // System.out.println(tempString);  
                    	// System.out.println("the null String");
                    }  
                    nextend--;  
                }  
                nextend--;  
                rf.seek(nextend);  
                if (nextend == 0) {// 当文件指针退至文件开始处，输出第一行  
                    // System.out.println(rf.readLine());  
                    // System.out.println(new String(rf.readLine().getBytes("ISO-8859-1"), charset));
                	list.add(new String(rf.readLine().getBytes("ISO-8859-1"), charset));
                }  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (rf != null)  
                    rf.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        
        return list;
    }  
}
