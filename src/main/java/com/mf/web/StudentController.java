package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultCode;
import com.mf.core.ResultGenerator;
import com.mf.model.Student;
import com.mf.security.SecurityUtils;
import com.mf.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/11/25.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping
    public Result add(@Validated @RequestBody Student student) {
        studentService.saveStudent(student);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Student student) {
        studentService.updateByPK(student);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return ResultGenerator.genSuccessResult(student);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Student> list = studentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 获取学生个人信息
     *
     * @return
     */
    @GetMapping("/identity")
    public Result getStudentIdentity() {
        Student user = studentService.getStudentIdentity(SecurityUtils.getCurrentUserId());
        if (user == null)
            ResultGenerator.genFailResult(ResultCode.USER_NOT_EXIST);
        return ResultGenerator.genSuccessResult(user);
    }
}