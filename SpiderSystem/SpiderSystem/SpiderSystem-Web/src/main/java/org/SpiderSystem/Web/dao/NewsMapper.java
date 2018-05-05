package org.SpiderSystem.Web.dao;

import java.util.List;

import org.SpiderSystem.Web.pojo.News;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    
    
    /**
     * 获得全部新闻表信息并且分页
     */
    List<News> getNewsPage(@Param("skip") int skip,@Param("size") int size);
    
    int getNewsCount();
    
    int getNewsBlankCount();
    
    int getNewsCountLikeYear(@Param("year") String year);
}