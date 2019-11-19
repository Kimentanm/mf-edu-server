package com.mf.service.impl;

import com.mf.core.AbstractService;
import com.mf.dao.CodeGroupMapper;
import com.mf.model.CodeGroup;
import com.mf.service.CodeGroupService;
import com.mf.util.QueryUtil;
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
