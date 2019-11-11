package com.hsd.service.impl;

import com.hsd.dao.NewsMapper;
import com.hsd.model.News;
import com.hsd.service.NewsService;
import com.hsd.core.AbstractService;
import com.hsd.util.Constants;
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
