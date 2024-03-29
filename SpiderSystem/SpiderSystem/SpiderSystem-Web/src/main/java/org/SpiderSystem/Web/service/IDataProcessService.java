package org.SpiderSystem.Web.service;

import org.apdplat.word.segmentation.SegmentationAlgorithm;

public interface IDataProcessService {
	
	/**
	 * Word分词器，多种算法
	 * @param input
	 * @param output
	 * @param result
	 * @param algorithm
	 */
	void runWord(String input, String output, String result, SegmentationAlgorithm algorithm);
}
