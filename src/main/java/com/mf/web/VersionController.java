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
 * Created by CodeGenerator on 2019/12/26.
 */
@RestController
@RequestMapping("/version")
public class VersionController {

    @Resource
    private VersionService versionService;

    @PostMapping
    public Result add(@Validated @RequestBody Version version) {
        versionService.save(version);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        versionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Version version) {
        versionService.updateByPK(version);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Version version = versionService.findById(id);
        return ResultGenerator.genSuccessResult(version);
    }

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
    @GetMapping("/last")
    public Result getLastVersionInfo(@RequestParam("type") String type) {
        Version version = versionService.getLastVersionInfo(type);
        return ResultGenerator.genSuccessResult(version);
    }
}