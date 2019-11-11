package com.hsd.dao;

import com.hsd.core.Mapper;
import com.hsd.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<User> listUserPage(@Param("keyword") String keyword);

    void updateImageUrl(@Param("userId") Long userId, @Param("imageUrl")String imageUrl);
}