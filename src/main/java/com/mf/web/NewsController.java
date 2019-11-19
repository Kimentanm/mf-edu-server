package com.mf.web;

import com.mf.core.Result;
import com.mf.core.ResultGenerator;
import com.mf.model.News;
import com.mf.model.User;
import com.mf.security.SecurityUtils;
import com.mf.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mf.service.UserService;
import com.mf.util.Constants;
import com.mf.util.QueryUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;
    @Resource
    private UserService userService;

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody News news) {
        news.setStatus(Constants.NewsStatus.UNRELEASE);
        newsService.save(news);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除新闻
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        newsService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 修改新闻
     * @param news
     * @return
     */
    @PutMapping
    public Result update(@Validated @RequestBody News news) {
        newsService.updateByPK(news);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查看新闻详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        News news = newsService.findById(id);
        User user = userService.findById(news.getPublishUserId());
        news.setUser(user);
        return ResultGenerator.genSuccessResult(news);
    }

    /**
     * 发布新闻
     * @param id
     * @return
     */
    @GetMapping("/publish/{id}")
    public Result publishNews(@PathVariable Long id) {
        News news = newsService.findById(id);
        news.setPublishDate(LocalDateTime.now());
        news.setPublishUserId(SecurityUtils.getCurrentUserId());
        news.setStatus(Constants.NewsStatus.RELEASED);
        newsService.updateByPKSelective(news);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 撤销发布
     * @param id
     * @return
     */
    @GetMapping("/repeal/{id}")
    public Result repealNews(@PathVariable Long id) {
        News news = newsService.findById(id);
        news.setPublishDate(null);
        news.setPublishUserId(null);
        news.setStatus(Constants.NewsStatus.UNRELEASE);
        newsService.updateByPKSelective(news);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 根据分类获取新闻列表
     * @param page
     * @param size
     * @param functionCode
     * @param title
     * @return
     */
    @GetMapping("/function/code")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size,
                       @RequestParam(required = false) String functionCode,
    @RequestParam String title) {
        PageHelper.startPage(page, size);
        List<News> list = newsService.findByFunctionCode(functionCode, QueryUtil.replaceSpecialCharactorsForLikeParam(title));
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据分类获取已发布的新闻
     * @param page
     * @param size
     * @param functionCode
     * @return
     */
    @GetMapping("/function/code/published")
    public Result listPublished(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size,
                       @RequestParam String functionCode) {
        PageHelper.startPage(page, size);
        List<News> list = newsService.findPublishedByFunctionCode(functionCode);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
