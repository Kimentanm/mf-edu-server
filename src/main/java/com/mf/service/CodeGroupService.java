package com.mf.service;

import com.mf.core.Service;
import com.mf.model.CodeGroup;

import java.util.List;

public interface CodeGroupService extends Service<CodeGroup> {
    /**
     * filter
     *  根据name模糊查询
     *  @param keyword 关键字
     *  @return codeGroup
     */
    List<CodeGroup> filter(String keyword);
}
