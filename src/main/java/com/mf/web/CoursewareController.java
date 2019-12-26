package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Courseware;
import com.mf.service.CoursewareService;
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
@RequestMapping("/courseware")
public class CoursewareController {

    @Resource
    private CoursewareService coursewareService;

    @PostMapping
    public Result add(@Validated @RequestBody Courseware courseware) {
        coursewareService.save(courseware);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        coursewareService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Courseware courseware) {
        coursewareService.updateByPK(courseware);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Courseware courseware = coursewareService.findById(id);
        return ResultGenerator.genSuccessResult(courseware);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Courseware> list = coursewareService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}