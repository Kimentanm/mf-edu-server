package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.Courseware;
import com.mf.service.CoursewareService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mf.util.AsposeWordsUtils;
import com.mf.util.Constants;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课件Controller
 */
@RestController
@RequestMapping("/courseware")
public class CoursewareController {

    @Resource
    private CoursewareService coursewareService;

    /**
     * 新增课件
     */
    @PostMapping
    public Result add(@Validated @RequestBody Courseware courseware) {
        coursewareService.save(courseware);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除课件(软删除)
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        coursewareService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新课件
     */
    @PutMapping
    public Result update(@Validated @RequestBody Courseware courseware) {
        coursewareService.updateByPK(courseware);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询课件
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Courseware courseware = coursewareService.findById(id);
        return ResultGenerator.genSuccessResult(courseware);
    }

    /**
     * 获取分页课件列表
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Courseware> list = coursewareService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/public")
    public Result getAllPublic() {
        List<Courseware> coursewareList = coursewareService.findByType(Constants.CoursewareType.PUBLIC);
        return ResultGenerator.genSuccessResult(coursewareList);
    }

    @GetMapping("/word2pdf")
    public void getPdf() {
//        File word = new File("E:\\2020年阿基米德绩效管理启动说明2020.02.21.docx");
//        File pdf = new File("E:\\2020年阿基米德绩效管理启动说明2020.02.21.pdf");
//        try {
//            documentConverter.convert(word).to(pdf).execute();
//        } catch (OfficeException e) {
//            e.printStackTrace();
//        }
        AsposeWordsUtils.doc2pdf("D:\\files\\2020年阿基米德绩效管理启动说明2020.02.21.docx","D:\\files\\2020年阿基米德绩效管理启动说明2020.02.21.pdf");
    }
}