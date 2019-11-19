package com.mf.service.impl;

import com.mf.dao.NewsMapper;
import com.mf.model.News;
import com.mf.service.NewsService;
import com.mf.core.AbstractService;
import com.mf.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    @Resource
    private NewsMapper tblNewsMapper;

    @Override
    public List<News> findByFunctionCode(String functionCode, String title){
        return tblNewsMapper.findByFunctionCode(functionCode, title);
    }

    @Override
    public List<News> findPublishedByFunctionCode(String functionCode) {
        return tblNewsMapper.findPublishedByFunctionCode(functionCode, Constants.NewsStatus.RELEASED);
    }
}
