package org.SpiderSystem.Web;

import java.util.List;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

/**
 * 测试分词
 * @author zzy
 *
 */
public class TestWordSegment {
	public static void main(String[] args){
		List<Word> words = WordSegmenter.seg("杨尚川是APDPlat应用级产品开发平台的作者");
		for(Word each : words){
			System.out.println(each);
		}
	}
}