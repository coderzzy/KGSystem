package org.SpiderSystem.Web.dao;

import java.util.List;

import org.SpiderSystem.Web.pojo.Notice;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    /**
     * 获得全部公告表信息并且分页
     */
    List<Notice> getNoticesPage(@Param("skip") int skip,@Param("size") int size);
    
    int getNoticesCount();
}