package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Course;
import com.mf.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科目Controller
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * 新增科目
     */
    @PostMapping
    public Result add(@Validated @RequestBody Course course) {
        courseService.save(course);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除科目
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新科目
     */
    @PutMapping
    public Result update(@Validated @RequestBody Course course) {
        courseService.updateByPK(course);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询科目
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Course course = courseService.findById(id);
        return ResultGenerator.genSuccessResult(course);
    }

    /**
     * 获取科目列表
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Course> list = courseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}