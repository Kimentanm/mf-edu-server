package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.ClassRoom;
import com.mf.security.SecurityUtils;
import com.mf.service.ClassRoomService;
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
@RequestMapping("/class/room")
public class ClassRoomController {

    @Resource
    private ClassRoomService classRoomService;

    @PostMapping
    public Result add(@Validated @RequestBody ClassRoom classRoom) {
        classRoomService.save(classRoom);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        classRoomService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody ClassRoom classRoom) {
        classRoomService.updateByPK(classRoom);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        ClassRoom classRoom = classRoomService.findById(id);
        return ResultGenerator.genSuccessResult(classRoom);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ClassRoom> list = classRoomService.findAllAndTeacherStudent();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/teacher")
    public Result getTeacherClassRoom() {
        List<ClassRoom> list = classRoomService.listByTeacherId(SecurityUtils.getCurrentUserId());
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/student")
    public Result getStudentClassRoom() {
        List<ClassRoom> list = classRoomService.listByStudentId(SecurityUtils.getCurrentUserId());
        return ResultGenerator.genSuccessResult(list);
    }
}