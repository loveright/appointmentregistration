package com.by.appregistration.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.by.appregistration.model.cmn.Dict;
import com.by.appregistration.model.hosp.HospitalSet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {

    // 根据id查询子列表
    List<Dict> findChildData(Long id);

    void exportDictData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}
