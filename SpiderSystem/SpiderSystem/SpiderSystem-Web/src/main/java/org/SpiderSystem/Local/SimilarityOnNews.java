package org.SpiderSystem.Local;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apdplat.word.WordFrequencyStatistics;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 用算法判断文本相似度
 * @author zzy
 *
 */
public class SimilarityOnNews {
	private static final String fileRoot = "/Users/zzy/Desktop/outputs/";
	private static final String fileNews = fileRoot + "news/";
	private static final String fileFrequency = fileRoot + "news_frequency/";
	
	/**
	 * PS:i = 4705、会报错
	 */
	public void createFrequency(){
		// 1.创建一个输入流，将xml文件加载到输入流
		InputStream in = null;
		try {
			in = new FileInputStream(fileRoot+"news_data.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		
		// 2.创建一个SAXBuilde对象
		SAXBuilder saxBuilder = new SAXBuilder();
		// 3.通过SAXBuilder的build方法将输入流加载到SAXBuilder中
		Document document = null;
		try {
			document = saxBuilder.build(in);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.通过Document对象获取xml文件的根节点
		Element rootElement = document.getRootElement();
		// 5.根据根节点获取子节点的List集合
		@SuppressWarnings("unchecked")
		List<Element> bookList = rootElement.getChildren();
		
		// System.out.println(bookList.get(0).getChild("content").getText());
		// System.out.println(bookList.size());
		//词频统计设置
		WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
		wordFrequencyStatistics.setRemoveStopWord(true);
		for(int i=4706;i<bookList.size();i++){
			//清除之前的统计结果
			wordFrequencyStatistics.reset();
			String text = bookList.get(i).getChild("content").getText();
			
			BufferedWriter bf = null;
			try {
				bf = new BufferedWriter(new FileWriter(fileNews+i+".txt"));
				bf.write(text);
				bf.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//开始分词
			wordFrequencyStatistics.seg(text);
			//输出词频统计结果
			wordFrequencyStatistics.dump(fileFrequency+ i +".txt");
			
			System.out.println("-------------------the " + i + "text-------------------");
		}
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new SimilarityOnNews().createFrequency();
	}
}