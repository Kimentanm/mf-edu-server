package com.mf.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Code;

import java.util.List;
import javax.annotation.Resource;

import com.mf.service.CodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/code"})
public class CodeController {
    @Resource
    private CodeService codeService;

    /**
     * 添加编码
     * @param code
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody Code code) {
        this.codeService.saveCode(code);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除编码
     * @param id
     * @return
     */
    @DeleteMapping({"/{id}"})
    public Result delete(@PathVariable Long id) {
        this.codeService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新编码
     * @param code
     * @return
     */
    @PutMapping
    public Result update(@Validated @RequestBody Code code) {
        this.codeService.updateCode(code);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查看编码详情
     * @param id
     * @return
     */
    @GetMapping({"/{id}"})
    public Result detail(@PathVariable Long id) {
        Code code = this.codeService.findById(id);
        return ResultGenerator.genSuccessResult(code);
    }

    /**
     * 根据编码组获取编码列表
     * @param type
     * @return
     */
    @GetMapping({"/type"})
    public Result listByGroup(@RequestParam String type) {
        List<Code> codeList = this.codeService.listCodeByCond(null, type);
        return ResultGenerator.genSuccessResult(codeList);
    }

    /**
     * 根据编码名模糊查询
     * @param page
     * @param size
     * @param keyword
     * @param codeGroupCode
     * @return
     */
    @GetMapping({"/list"})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(required = false) String keyword, @RequestParam(required = false) String codeGroupCode) {
        PageHelper.startPage(page, size);
        List<Code> list = this.codeService.listCodeByCond(keyword, codeGroupCode);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 获取所有编码列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page.intValue(), size.intValue());
        List<Code> list = this.codeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据编码组和编码名称获取编码
     * @param type
     * @param code
     * @return
     */
    @GetMapping("/name")
    public Result name(@RequestParam String type, @RequestParam String code){
        String name = this.codeService.getCodeDesc(type, code);
        return ResultGenerator.genSuccessResult(name);
    }
}
