package com.mf.service;

import com.mf.dto.FileResultDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CommonService {

    List<FileResultDTO> uploadFile(HttpServletRequest request);
}
