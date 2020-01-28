package com.mf.security;

import com.mf.model.*;
import com.mf.service.RoleService;
import com.mf.service.StudentService;
import com.mf.service.TeacherService;
import com.mf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private RoleService roleService;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String str) {
        log.debug("Authenticating {}", str);
        String[] split = str.split(":");
        String loginName = split[0];
        String type = split[1];
        String lowercaseLogin = loginName.toLowerCase();
        Long userId = null;
        String password = null;
        switch (type) {
            case "ADMIN" : {
                User user = userService.findByLoginName(loginName);
                userId = user.getId();
                password = user.getPassword();
                break;
            }
            case "TEACHER" : {
                Teacher teacher = teacherService.findByTeacherName(loginName);
                userId = teacher.getId();
                password = teacher.getPassword();
                break;
            }
            case "STUDENT" : {
                Student student = studentService.findByStudentName(loginName);
                userId = student.getId();
                password = student.getPassword();
                break;
            }
            default:
        }
        if(userId != null && password != null){
            List<Role> roleList = roleService.findRolesByUserId(userId);
            if (roleList == null || roleList.isEmpty()) {
                roleList = new ArrayList<>();
                Role role = new Role();
                role.setCode("ROLE_USER");
                roleList.add(role);
            }
            List<GrantedAuthority> grantedAuthorities = roleList.stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getCode()))
                    .collect(Collectors.toList());
            AuthenticatedUser authenticatedUser =
                    new AuthenticatedUser(lowercaseLogin, password, grantedAuthorities);
            authenticatedUser.setUserId(userId);
            authenticatedUser.setUserType(type);
            return authenticatedUser;
        }else{
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
                    "database");
        }
    }
}
