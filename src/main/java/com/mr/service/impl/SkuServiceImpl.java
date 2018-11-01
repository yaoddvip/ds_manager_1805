package com.mr.service.impl;

import com.mr.mapper.SkuMapper;
import com.mr.model.TMallProduct;
import com.mr.model.TMallSkuVO;
import com.mr.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaodd on 2018/10/31.
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public List<TMallProduct> selectSpu(TMallProduct spu) {
        return skuMapper.selectSpu(spu);
    }

    @Override
    public void saveSku(TMallSkuVO skuVO) {
        //增加sku
        skuMapper.saveSku(skuVO);
        //增加skuAttrValue
        Map<String,Object> map = new HashMap();
        map.put("shpId",skuVO.getShpId());
        map.put("skuId",skuVO.getId());
        map.put("attrValues",skuVO.getAttrValues());

        skuMapper.saveSkuAttrValue(map);
    }
}
