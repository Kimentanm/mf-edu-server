package com.hsd.dao;

import com.hsd.core.Mapper;
import com.hsd.model.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeMapper extends Mapper<Code> {
    List<Code> listCodeByCond(@Param("keyword") String keyword, @Param("codeGroupCode") String codeGroupCode);
}