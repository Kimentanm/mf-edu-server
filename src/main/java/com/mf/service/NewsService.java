package com.mf.service;
import com.mf.model.News;
import com.mf.core.Service;

import java.util.List;

public interface NewsService extends Service<News> {
    List<News> findByFunctionCode(String functionCode, String title);

    List<News> findPublishedByFunctionCode(String functionCode);
}
