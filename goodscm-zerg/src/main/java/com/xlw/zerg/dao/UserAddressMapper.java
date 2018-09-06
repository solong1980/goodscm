package com.xlw.zerg.dao;

import com.xlw.zerg.model.UserAddress;
import java.util.List;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAddress record);

    UserAddress selectByPrimaryKey(Integer id);

    List<UserAddress> selectAll();

    int updateByPrimaryKey(UserAddress record);

    List<UserAddress> selectByUserId(Integer uid);
}