package com.mf.service;

import com.mf.model.Code;

import java.util.HashMap;
import java.util.LinkedHashMap;

//暂时集中放缓存方法，千万注意别嵌套调用
public interface CacheService {

    // 读取所有code数据，来自tbl_code
    HashMap<String, LinkedHashMap<String, Code>> getAllCodes();

    void refreshCache(String key);

}