package com.mf.service;

import com.mf.core.Service;
import com.mf.model.User;

import java.util.List;

public interface UserService extends Service<User> {

    User findByLoginName(String loginName);

    Long saveUser(User user);

    User getUserIdentity(Long userId);

    int updateAdmin(User user);

    List<User> listUserPage(String keyword);

    void deleteUser(Long userId);

    void updatePassword(User user);

    void updateImageUrl(String location);
}
