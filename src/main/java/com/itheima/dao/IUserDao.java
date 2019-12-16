package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findByUser(User user);

    List<User> findByIds(QueryVo vo);
}
