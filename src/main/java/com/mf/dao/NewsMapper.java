package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper extends Mapper<News> {
    List<News> findPublishedByFunctionCode(@Param("functionCode") String functionCode, @Param("status")Integer status);

    List<News> findByFunctionCode(@Param("functionCode")String functionCode, @Param("title")String title);
}