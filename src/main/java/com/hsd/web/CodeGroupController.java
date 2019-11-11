package com.hsd.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsd.core.Result;
import com.hsd.core.ResultGenerator;
import com.hsd.model.CodeGroup;
import com.hsd.service.CodeGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/codeGroup")
public class CodeGroupController {
    @Resource
    private CodeGroupService codeGroupService;

    /**
     *
     * @param codeGroup
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody CodeGroup codeGroup) {
        codeGroupService.save(codeGroup);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除编码组
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        codeGroupService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新编码组
     * @param codeGroup
     * @return
     */
    @PutMapping
    public Result update(@Validated @RequestBody CodeGroup codeGroup) {
        codeGroupService.updateByPK(codeGroup);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 获取编码组详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        CodeGroup codeGroup = codeGroupService.findById(id);
        return ResultGenerator.genSuccessResult(codeGroup);
    }

    /**
     * 获取所有编码组数据列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CodeGroup> list = codeGroupService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据编码组名称筛选
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    @GetMapping("/filter")
    public Result filter(@RequestParam(defaultValue = "0") Integer page,
                         @RequestParam(defaultValue = "0") Integer size,
                         @RequestParam(required = false) String keyword) {
        PageHelper.startPage(page, size);
        List<CodeGroup> list = codeGroupService.filter(keyword);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
