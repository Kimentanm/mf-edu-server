package com.mf.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Role;
import com.mf.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    public Result addRole(@Validated @RequestBody Role role) {
        roleService.add(role);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteRole/{id}")
    public Result deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新角色
     *
     * @param role
     * @return
     */
    @PutMapping("/updateRole")
    public Result updateRole(@Validated @RequestBody Role role) {
        roleService.updateRole(role);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 获取角色详情
     *
     * @param id
     * @return
     */
    @GetMapping("/detailInfo/{id}")
    public Result detailInfo(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        return ResultGenerator.genSuccessResult(role);
    }

    /**
     * 获取角色列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pageList")
    public Result pageList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Role> list = roleService.pageList();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
