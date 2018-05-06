package org.SpiderSystem.Web.util;

import org.apdplat.word.segmentation.SegmentationAlgorithm;

/**
 * 常量配置
 * @author zzy
 *
 */
public class ConstantConfig {
	
	// 数据预处理停止状态
	public static final int PRE_PROCESS_CHECK_STOP = 0;
	
	// 数据预处理运行状态
	public static final int PRE_PROCESS_CHECK_RUN = 1;
	
	// 数据预处理完成状态
	public static final int PRE_PROCESS_CHECK_SUCCESS = 2;
	
	/**
	 * Word分词器算法:
	 * 正向最大匹配算法：MaximumMatching
	 * 逆向最大匹配算法：ReverseMaximumMatching
	 * 正向最小匹配算法：MinimumMatching
	 * 逆向最小匹配算法：ReverseMinimumMatching
	 * 双向最大匹配算法：BidirectionalMaximumMatching
	 * 双向最小匹配算法：BidirectionalMinimumMatching
	 * 双向最大最小匹配算法：BidirectionalMaximumMinimumMatching
	 * 全切分算法：FullSegmentation
	 * 最少词数算法：MinimalWordCount
	 * 最大Ngram分值算法：MaxNgramScore
	 * 如不指定，默认使用双向最大匹配算法：BidirectionalMaximumMatching
	 */
	// 数据分词算法总数
	public static final int SEGMENT_NUMBER = 10;
	
	// 数据分词停止状态
	public static final int SEGMENT_PROCESS_CHECK_STOP = 0;
		
	// 数据分词运行状态
	public static final int SEGMENT_PROCESS_CHECK_RUN = 1;
	
	// 数据分词完成状态
	public static final int SEGMENT_PROCESS_CHECK_SUCCESS = 2;
	
	// xml文件路径
	public static final String XML_PATH = "data_process/news_data.xml";
	
	// 分词文件路径
	public static final String[] SEGMENT_PATH = {
			"data_process/news_data_segment_MaximumMatching.txt",
			"data_process/news_data_segment_ReverseMaximumMatching.txt",
			"data_process/news_data_segment_MinimumMatching.txt",
			"data_process/news_data_segment_ReverseMinimumMatching.txt",
			"data_process/news_data_segment_BidirectionalMaximumMatching.txt",
			"data_process/news_data_segment_BidirectionalMinimumMatching.txt",
			"data_process/news_data_segment_BidirectionalMaximumMinimumMatching.txt",
			"data_process/news_data_segment_FullSegmentation.txt",
			"data_process/news_data_segment_MinimalWordCount.txt",
			"data_process/news_data_segment_MaxNgramScore.txt"
	};
	
	// 词频文件路径
	public static final String[] FREQUENCY_PATH = {
			"data_process/news_data_frequency_MaximumMatching.txt",
			"data_process/news_data_frequency_ReverseMaximumMatching.txt",
			"data_process/news_data_frequency_MinimumMatching.txt",
			"data_process/news_data_frequency_ReverseMinimumMatching.txt",
			"data_process/news_data_frequency_BidirectionalMaximumMatching.txt",
			"data_process/news_data_frequency_BidirectionalMinimumMatching.txt",
			"data_process/news_data_frequency_BidirectionalMaximumMinimumMatching.txt",
			"data_process/news_data_frequency_FullSegmentation.txt",
			"data_process/news_data_frequency_MinimalWordCount.txt",
			"data_process/news_data_frequency_MaxNgramScore.txt"
	};
	
	// 算法
	public static final SegmentationAlgorithm[] ALGORITHM = {
			SegmentationAlgorithm.MaximumMatching,
			SegmentationAlgorithm.ReverseMaximumMatching,
			SegmentationAlgorithm.MinimumMatching,
			SegmentationAlgorithm.ReverseMinimumMatching,
			SegmentationAlgorithm.BidirectionalMaximumMatching,
			SegmentationAlgorithm.BidirectionalMinimumMatching,
			SegmentationAlgorithm.BidirectionalMaximumMinimumMatching,
			SegmentationAlgorithm.FullSegmentation,
			SegmentationAlgorithm.MinimalWordCount,
			SegmentationAlgorithm.MaxNgramScore
	};
			
			
}
