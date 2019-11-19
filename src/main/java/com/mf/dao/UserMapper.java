package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<User> listUserPage(@Param("keyword") String keyword);

    void updateImageUrl(@Param("userId") Long userId, @Param("imageUrl")String imageUrl);
}