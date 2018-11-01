package com.mr.service;

import com.mr.model.TMallProduct;

import java.util.List;

/**
 * Created by yaodd on 2018/10/29.
 */
public interface SpuService {
    void saveSpu(TMallProduct spu , List<String> urlList);
}
