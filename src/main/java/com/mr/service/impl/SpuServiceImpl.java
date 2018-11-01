package com.mr.service.impl;

import com.mr.mapper.SpuMapper;
import com.mr.model.TMallProduct;
import com.mr.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaodd on 2018/10/29.
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    /**
     * 添加spu、商品图片
     * @param spu
     * @param urlList
     */
    @Override
    public void saveSpu(TMallProduct spu , List<String> urlList) {
        //mybatis增加完数据之后获取自增的id
        //添加spu，
        spuMapper.saveSpu(spu);


        Map<String,Object> map = new HashMap<>();
        map.put("urlList",urlList);
        map.put("shpId",spu.getId());
        //添加图片(批量增加)
        spuMapper.saveSpuImgs(map);

    }
}
