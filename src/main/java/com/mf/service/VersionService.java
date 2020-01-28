package com.mf.service;

import com.mf.core.Service;
import com.mf.dto.FileResultDTO;
import com.mf.model.Version;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/12/26.
 */
public interface VersionService extends Service<Version> {

    Version getLastVersionInfo(String type);

    List<FileResultDTO> resourceUpload(HttpServletRequest request);
}