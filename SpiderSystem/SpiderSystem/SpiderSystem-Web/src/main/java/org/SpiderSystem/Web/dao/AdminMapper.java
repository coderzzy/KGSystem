package org.SpiderSystem.Web.dao;

import org.SpiderSystem.Web.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    int updateByPrimaryKeyWithoutPassword(Admin record);
    
    Integer isInAdmin(@Param("email")String email,@Param("password")String password);
}