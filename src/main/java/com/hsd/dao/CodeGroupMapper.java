package com.hsd.dao;

import com.hsd.core.Mapper;
import com.hsd.model.CodeGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeGroupMapper extends Mapper<CodeGroup> {

    List<CodeGroup> filter(@Param("keyword") String keyword);
}