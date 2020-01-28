package com.mf.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mf.core.Result;
import com.mf.core.ResultCode;
import com.mf.core.ResultGenerator;
import com.mf.dto.FileResultDTO;
import com.mf.dto.LoginDTO;
import com.mf.model.Student;
import com.mf.model.Teacher;
import com.mf.model.User;
import com.mf.security.SecurityUtils;
import com.mf.service.UserService;
import com.mf.util.QiniuyunServiceManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody User user) {
        userService.saveUser(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/withRoles/{id}")
    public Result withRoles(@PathVariable Long id) {
        User user = userService.getUserIdentity(id);
        return ResultGenerator.genSuccessResult(user);
    }

    /**
     * 获取用户个人信息
     * @return
     */
    @GetMapping("/identity")
    public Result getUserIdentity() {
        User user = userService.getUserIdentity(SecurityUtils.getCurrentUserId());
        if(user==null)
            ResultGenerator.genFailResult(ResultCode.USER_NOT_EXIST);
        return ResultGenerator.genSuccessResult(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping("/updateAdmin")
    public Result updateAdmin(@Validated @RequestBody User user) {
        userService.updateAdmin(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 获取用户列表并分页
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    @GetMapping("/listUserPage")
    public Result listUserPage(@RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue = "0") Integer size,
                               @RequestParam(required = false) String keyword) {
        PageHelper.startPage(page, size);
        List<User> list = userService.listUserPage(keyword);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 上传用户头像
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/avatar/upload")
    public Result uploadUserAvatar(HttpServletRequest request, HttpServletResponse response){
        userService.uploadUserAvatar(request, response);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新密码
     * @param user
     * @return
     */
    @PutMapping("/password")
    public Result updatePassword(@RequestBody LoginDTO user) {
        userService.updatePassword(user);
        return ResultGenerator.genSuccessResult();
    }
}
