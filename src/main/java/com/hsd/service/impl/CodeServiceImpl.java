package com.hsd.service.impl;

import com.hsd.core.AbstractService;
import com.hsd.dao.CodeMapper;
import com.hsd.model.Code;
import com.hsd.service.CacheService;
import com.hsd.service.CodeService;
import com.hsd.util.QueryUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@Transactional
public class CodeServiceImpl extends AbstractService<Code> implements CodeService {
    @Resource
    private CodeMapper codeMapper;

    @Resource
    private CacheService cacheService;


    @Override
    public List<Code> listByType(String type) {
        if (StringUtils.isEmpty(type)) {
            return null;
        }
        HashMap<String, LinkedHashMap<String, Code>> codeMap = cacheService.getAllCodes();
        if(codeMap.get(type) == null) {
            return null;
        }
        return new ArrayList<Code>(codeMap.get(type).values());
    }

    @Override
    public List<Code> listCodeByCond(String keyword, String codeGroupCode) {
        if (keyword != null) {
            keyword = QueryUtil.replaceSpecialCharactorsForLikeParam(keyword);
        }
        return codeMapper.listCodeByCond(keyword,codeGroupCode);
    }

    @Override
    public String getCodeDesc(String type, String code) {
        if (StringUtils.isEmpty(type) || StringUtils.isEmpty(code))
            return null;
        HashMap<String, LinkedHashMap<String, Code>> codeMap = cacheService.getAllCodes();
        if(codeMap.get(type) == null) {
            return null;
        }
        Code codeObject = codeMap.get(type).get(code);
        if(codeObject==null)
            return null;
        return codeObject.getName();
    }

    @Override
    public void saveCode(Code code) {
        super.save(code);
        cacheService.refreshCache("getAllCodes");
    }

    @Override
    public void updateCode(Code code) {
        super.updateByPK(code);
        cacheService.refreshCache("getAllCodes");
    }

}
