package com.mf.service.impl;

import com.mf.core.AbstractService;
import com.mf.core.ResultCode;
import com.mf.core.ResultGenerator;
import com.mf.core.ServiceException;
import com.mf.dao.UserMapper;
import com.mf.dto.FileResultDTO;
import com.mf.dto.LoginDTO;
import com.mf.model.Role;
import com.mf.model.Student;
import com.mf.model.Teacher;
import com.mf.model.User;
import com.mf.security.SecurityUtils;
import com.mf.service.*;
import com.mf.util.Constants;
import com.mf.util.QiniuyunServiceManager;
import com.mf.util.QueryUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper tblUserMapper;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserRoleRefService userRoleRefService;
    @Resource
    private RoleService roleService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentService studentService;
    @Resource
    private QiniuyunServiceManager qm;

    @Override
    public User findByLoginName(String loginName) {
        User user = new User();
        user.setLoginName(loginName);
        return findOne(user);
    }

    @Override
    public Long saveUser(User user) {
        User checkUser = this.findByLoginName(user.getLoginName());
        if (checkUser != null) {
            throw new ServiceException(ResultCode.USER_EXIST);
        }
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (StringUtils.isEmpty(user.getType())) {
            user.setType(Constants.UserType.ADMIN);
        }
        Long result = super.save(user);
        if (user.getRoleIds() != null && user.getRoleIds().size() > 0) {
            userRoleRefService.saveUserRole(result, user.getRoleIds());
        }
        return result;
    }

    @Override
    public User getUserIdentity(Long userId) {
        User user = findById(userId);
        if (user != null) {
            List<Role> roles = roleService.findRolesByUserId(userId);
            user.setRoles(roles);
            user.setRoleIds(roles.stream().map(role -> role.getId()).collect(Collectors.toList()));
        }
        return user;
    }

    @Override
    public int updateAdmin(User user) {
        int result = 0;
        User u = findById(user.getId());
        if (StringUtils.isNotBlank(user.getLoginName())) {
            u.setLoginName(user.getLoginName());
        }
        if (StringUtils.isNotBlank(user.getName())) {
            u.setName(user.getName());
        }
        if (StringUtils.isNotBlank(user.getMobile())) {
            u.setMobile(user.getMobile());
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            u.setEmail(user.getEmail());
        }
        if (StringUtils.isNotBlank(user.getImageUrl())) {
            u.setImageUrl(user.getImageUrl());
        }
        List<Role> roles = roleService.findRolesByUserId(user.getId());
        if (CollectionUtils.isNotEmpty(roles)) {
            //??????????????????????????????
            roles.forEach(role -> {
                role.setIsDelete(true);
                roleService.updateByPKSelective(role);
            });
        }
        result = super.updateByPK(u);
        if (user.getRoleIds() != null && user.getRoleIds().size() > 0) {
            userRoleRefService.saveUserRole(user.getId(), user.getRoleIds());
        }
        return result;
    }

    @Override
    public List<User> listUserPage(String keyword) {
        if (keyword != null) {
            keyword = QueryUtil.replaceSpecialCharactorsForLikeParam(keyword);
        }
        return tblUserMapper.listUserPage(keyword);
    }

    @Override
    public void deleteUser(Long userId) {
        List<Role> roles = roleService.findRolesByUserId(userId);
        if (CollectionUtils.isNotEmpty(roles)) {
            //??????????????????????????????
            roles.forEach(role -> {
                role.setIsDelete(true);
                roleService.updateByPKSelective(role);
            });
        }
        User user = findById(userId);
        user.setIsDelete(true);
        updateByPKSelective(user);
    }

    @Override
    public void updatePassword(LoginDTO model) {
        switch (model.getType()) {
            case "ADMIN" : {
                User user = findById(model.getId());
                user.setPassword(passwordEncoder.encode(model.getPassword()));
                updateByPKSelective(user);
                break;
            }
            case "TEACHER" : {
                Teacher teacher = teacherService.findById(model.getId());
                teacher.setPassword(passwordEncoder.encode(model.getPassword()));
                teacherService.updateByPKSelective(teacher);
                break;
            }
            case "STUDENT" : {
                Student student = studentService.findById(model.getId());
                student.setPassword(passwordEncoder.encode(model.getPassword()));
                studentService.updateByPKSelective(student);
                break;
            }
            default:
        }
    }

    @Override
    public void updateImageUrl(String imageUrl) {
        tblUserMapper.updateImageUrl(SecurityUtils.getCurrentUserId(), imageUrl);
    }

    @Override
    public void uploadUserAvatar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String type = SecurityUtils.getCurrentUserType();
            MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
            Iterator<String> iter = mr.getFileNames();
            while (iter.hasNext()) {
                FileResultDTO result = qm.uploadInputStream(mr.getFile(iter.next()).getBytes(), null);
                String imageUrl = result.getLocation();
                Long userId = SecurityUtils.getCurrentUserId();
                switch (type) {
                    case "ADMIN" : {
                        updateImageUrl(imageUrl);
                        break;
                    }
                    case "TEACHER" : {
                        Teacher teacher = teacherService.findById(userId);
                        teacher.setImageUrl(imageUrl);
                        teacherService.updateByPKSelective(teacher);
                        break;
                    }
                    case "STUDENT" : {
                        Student student = studentService.findById(userId);
                        student.setImageUrl(imageUrl);
                        studentService.updateByPKSelective(student);
                        break;
                    }
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
