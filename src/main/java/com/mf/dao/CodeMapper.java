package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeMapper extends Mapper<Code> {
    List<Code> listCodeByCond(@Param("keyword") String keyword, @Param("codeGroupCode") String codeGroupCode);
}