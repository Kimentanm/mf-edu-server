package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Code;

import java.util.List;

public interface CodeService extends Service<Code> {

    List<Code> listCodeByCond(String keyword, String codeGroupCode);

    List<Code> listByType(String type);

    String getCodeDesc(String type, String code);

    void saveCode(Code code);

    void updateCode(Code code);
}
