package com.xlw.zerg.dao;

import com.xlw.zerg.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByOpenId(String openId);
    
    List<User> selectAll();

    int updateByPrimaryKey(User record);
}