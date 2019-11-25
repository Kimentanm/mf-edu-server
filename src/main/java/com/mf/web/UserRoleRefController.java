package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;

import com.mf.model.UserRoleRef;
import com.mf.service.UserRoleRefService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@RestController
@RequestMapping("/user/role/ref")
public class UserRoleRefController {

    @Resource
    private UserRoleRefService userRoleRefService;

    @PostMapping
    public Result add(@Validated @RequestBody UserRoleRef userRoleRef) {
        userRoleRefService.save(userRoleRef);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userRoleRefService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody UserRoleRef userRoleRef) {
        userRoleRefService.updateByPK(userRoleRef);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        UserRoleRef userRoleRef = userRoleRefService.findById(id);
        return ResultGenerator.genSuccessResult(userRoleRef);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserRoleRef> list = userRoleRefService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}