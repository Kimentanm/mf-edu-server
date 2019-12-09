package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Permission;
import com.mf.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/24.
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @PostMapping
    public Result add(@Validated @RequestBody Permission permission) {
        permissionService.save(permission);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        permissionService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Permission permission) {
        permissionService.updateByPK(permission);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Permission permission = permissionService.findById(id);
        return ResultGenerator.genSuccessResult(permission);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Permission> list = permissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 权限树列表
     * */
    @ApiOperation("权限树列表")
    @GetMapping("/permission-list")
    public Result getPermissionTree() {
        List<Permission> all = permissionService.findAll();
        Permission permission = new Permission();
        permission.setId(0L);
        permission.setPermissionName("全部权限");
        List<Permission> permissionChildren = permissionService.getPermissionChildren(permission, all);
        permission.setChildren(permissionChildren);
        return ResultGenerator.genSuccessResult(permission);
    }
}