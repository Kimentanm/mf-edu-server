package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Version;
import com.mf.service.VersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版本信息Controller
 */
@RestController
@RequestMapping("/version")
public class VersionController {

    @Resource
    private VersionService versionService;

    /**
     * 增加版本信息
     */
    @PostMapping
    public Result add(@Validated @RequestBody Version version) {
        versionService.save(version);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除版本信息（软删除）
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        versionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新版本信息
     */
    @PutMapping
    public Result update(@Validated @RequestBody Version version) {
        versionService.updateByPK(version);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询版本信息
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Version version = versionService.findById(id);
        return ResultGenerator.genSuccessResult(version);
    }

    /**
     * 获取版本列表
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Version> list = versionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 获取最新的版本信息
     */
    @PostMapping("/last")
    public Result getLastVersionInfo(@RequestParam("type") String type) {
        Version version = versionService.getLastVersionInfo(type);
        return ResultGenerator.genSuccessResult(version);
    }
}