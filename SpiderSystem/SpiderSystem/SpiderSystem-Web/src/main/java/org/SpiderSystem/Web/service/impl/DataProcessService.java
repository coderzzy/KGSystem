package org.SpiderSystem.Web.service.impl;

import java.io.File;

import org.SpiderSystem.Web.service.IDataProcessService;
import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DataProcessService implements IDataProcessService{

	@Override
	public void runWord(String input,String output,String result,SegmentationAlgorithm algorithm){
		// TODO Auto-generated method stub
		
		//词频统计设置
		WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
		wordFrequencyStatistics.setRemoveStopWord(true);
		wordFrequencyStatistics.setSegmentationAlgorithm(algorithm);
		//对文件进行分词
		
		try {
			wordFrequencyStatistics.seg(new File(input), new File(output));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//输出词频统计结果
		wordFrequencyStatistics.dump(result);
	}

}