package com.hsd.service.impl;

import com.hsd.core.AbstractService;
import com.hsd.dao.CodeGroupMapper;
import com.hsd.model.CodeGroup;
import com.hsd.service.CodeGroupService;
import com.hsd.util.QueryUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CodeGroupServiceImpl extends AbstractService<CodeGroup> implements CodeGroupService {
    @Resource
    private CodeGroupMapper tblCodeGroupMapper;

    @Override
    public List<CodeGroup> filter(String keyword) {
        keyword = QueryUtil.replaceSpecialCharactorsForLikeParam(keyword);
        return tblCodeGroupMapper.filter(keyword);
    }
}
