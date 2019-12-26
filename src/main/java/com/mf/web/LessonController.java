package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Lesson;
import com.mf.service.LessonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程表Controller
 */
@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Resource
    private LessonService lessonService;

    /**
     * 新增课程
     */
    @PostMapping
    public Result add(@Validated @RequestBody Lesson lesson) {
        lessonService.save(lesson);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除课程（软删除）
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        lessonService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新课程
     */
    @PutMapping
    public Result update(@Validated @RequestBody Lesson lesson) {
        lessonService.updateByPK(lesson);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询课程
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Lesson lesson = lessonService.findById(id);
        return ResultGenerator.genSuccessResult(lesson);
    }

    /**
     * 获取课程列表
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Lesson> list = lessonService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}