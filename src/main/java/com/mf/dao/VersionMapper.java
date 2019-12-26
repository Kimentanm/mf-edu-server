package com.mf.dao;

import com.mf.core.Mapper;
import com.mf.model.Version;
import org.apache.ibatis.annotations.Param;

public interface VersionMapper extends Mapper<Version> {
    Version getLastVersionInfo(@Param("type") String type);
}