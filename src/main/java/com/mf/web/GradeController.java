package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Grade;
import com.mf.service.GradeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 年级Controller
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Resource
    private GradeService gradeService;

    /**
     * 新增年级
     */
    @PostMapping
    public Result add(@Validated @RequestBody Grade grade) {
        gradeService.save(grade);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除年级（软删除）
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        gradeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新年级
     */
    @PutMapping
    public Result update(@Validated @RequestBody Grade grade) {
        gradeService.updateByPK(grade);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询年级
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Grade grade = gradeService.findById(id);
        return ResultGenerator.genSuccessResult(grade);
    }

    /**
     * 获取年级列表
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Grade> list = gradeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}