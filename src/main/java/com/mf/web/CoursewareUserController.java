package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.CoursewareUser;
import com.mf.service.CoursewareUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2020/01/13.
 */
@RestController
@RequestMapping("/courseware/user")
public class CoursewareUserController {

    @Resource
    private CoursewareUserService coursewareUserService;

    @PostMapping
    public Result add(@Validated @RequestBody CoursewareUser coursewareUser) {
        coursewareUserService.save(coursewareUser);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        coursewareUserService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody CoursewareUser coursewareUser) {
        coursewareUserService.updateByPK(coursewareUser);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        CoursewareUser coursewareUser = coursewareUserService.findById(id);
        return ResultGenerator.genSuccessResult(coursewareUser);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CoursewareUser> list = coursewareUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}