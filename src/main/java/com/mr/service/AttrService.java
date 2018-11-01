package com.mr.service;

import com.mr.model.OBJECTTMallAttr;
import com.mr.model.TMallAttrVO;

import java.util.List;

/**
 * Created by yaodd on 2018/10/30.
 */
public interface AttrService {
    void saveAttr(Integer flbh2, TMallAttrVO attrVO);

    List<OBJECTTMallAttr> findAttrByclass2(Integer flbh2);
}
