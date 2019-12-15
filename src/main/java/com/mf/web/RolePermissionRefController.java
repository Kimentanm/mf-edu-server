package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.RolePermissionRef;
import com.mf.service.RolePermissionRefService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/12/11.
 */
@RestController
@RequestMapping("/role/permission/ref")
public class RolePermissionRefController {

    @Resource
    private RolePermissionRefService rolePermissionRefService;

    @PostMapping
    public Result add(@Validated @RequestBody RolePermissionRef rolePermissionRef) {
        rolePermissionRefService.save(rolePermissionRef);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        rolePermissionRefService.delete(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody RolePermissionRef rolePermissionRef) {
        rolePermissionRefService.updateByPK(rolePermissionRef);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        RolePermissionRef rolePermissionRef = rolePermissionRefService.findById(id);
        return ResultGenerator.genSuccessResult(rolePermissionRef);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RolePermissionRef> list = rolePermissionRefService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}