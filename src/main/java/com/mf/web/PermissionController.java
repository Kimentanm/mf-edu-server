package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.util.data.permission.PermissionListDTO;
import com.mf.model.Permission;
import com.mf.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GetMapping("/permission-list")
    public Result getPermissionTree() {
//        List<Permission> permissions = permissionService.getPermissionList(null);
//        List<PermissionListDTO> listDTOS = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(permissions)){
//            for (Permission permission : permissions) {
//                    PermissionListDTO permissionDTO = new PermissionListDTO().convertFrom(permission);
//                    if (CollectionUtils.isNotEmpty(permissionService.getPermissionList(permission.getId()))) {
//                        List<PermissionListDTO> dtos = permissionService.getPermissionList(permission.getId()).stream().map(permission1 ->
//                                new PermissionListDTO().convertFrom(permission1)).collect(Collectors.toList());
//                        permissionDTO.setSonPermissions(dtos);
//                    }
//                    listDTOS.add(permissionDTO);
//                }
//        }
        List<PermissionListDTO> getPermissionTree = permissionService.getPermissionTree();
        return ResultGenerator.genSuccessResult(getPermissionTree);
    }
}