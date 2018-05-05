package org.SpiderSystem.Web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件读取类
 * @author zzy
 *
 */
public class MyFileReader {
	
	/**
	 * 文件按行读取
	 * @param fileName
	 * @param charset
	 * @param total  读取的行数
	 * @return
	 */
	public static List<String> read(String fileName, String charset, int total){
		File file = new File(fileName);  
        BufferedReader reader = null; 
        List<String> list = new LinkedList<String>();
        try {  
            // System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null && line++ <= total) {  
                // 显示行号  
                // System.out.println("line " + line + ": " + tempString);   
                list.add(tempString);
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        } 
        return list;
	}
	
	
	/** 
     * 倒着按行读取文件
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
