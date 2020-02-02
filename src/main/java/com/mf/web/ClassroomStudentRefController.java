package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.ClassroomStudentRef;
import com.mf.service.ClassroomStudentRefService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/01/31.
*/
@RestController
@RequestMapping("/classroom/student/ref")
public class ClassroomStudentRefController {

    @Resource
    private ClassroomStudentRefService classroomStudentRefService;

    @PostMapping
    public Result add(@Validated @RequestBody ClassroomStudentRef classroomStudentRef) {
        classroomStudentRefService.save(classroomStudentRef);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        classroomStudentRefService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody ClassroomStudentRef classroomStudentRef) {
        classroomStudentRefService.updateByPK(classroomStudentRef);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        ClassroomStudentRef classroomStudentRef = classroomStudentRefService.findById(id);
        return ResultGenerator.genSuccessResult(classroomStudentRef);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ClassroomStudentRef> list = classroomStudentRefService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}