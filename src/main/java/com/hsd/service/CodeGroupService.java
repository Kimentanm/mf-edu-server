package com.hsd.service;

import com.hsd.core.Service;
import com.hsd.model.CodeGroup;

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
