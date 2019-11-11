package com.hsd.service;
import com.hsd.model.News;
import com.hsd.core.Service;

import java.util.List;

public interface NewsService extends Service<News> {
    List<News> findByFunctionCode(String functionCode, String title);

    List<News> findPublishedByFunctionCode(String functionCode);
}
