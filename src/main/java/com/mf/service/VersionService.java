package com.mf.service;

import com.mf.core.Service;
import com.mf.model.Version;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
public interface VersionService extends Service<Version> {

    Version getLastVersionInfo(String type);
}