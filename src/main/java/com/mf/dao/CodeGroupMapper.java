package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.CodeGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeGroupMapper extends Mapper<CodeGroup> {

    List<CodeGroup> filter(@Param("keyword") String keyword);
}