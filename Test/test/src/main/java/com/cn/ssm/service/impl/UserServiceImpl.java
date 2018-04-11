package com.cn.ssm.service.impl;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.cn.ssm.dao.UserMapper;
import com.cn.ssm.pojo.User;
import com.cn.ssm.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    public UserMapper userMapper;

    public User getUserById(int userId) {
        // TODO Auto-generated method stub

        return this.userMapper.selectByPrimaryKey(userId);
    }

}