package com.mr.service.impl;

/**
 * Created by yaodd on 2018/10/30.
 */

import com.mr.mapper.AttrMapper;
import com.mr.model.OBJECTTMallAttr;
import com.mr.model.TMallAttrVO;
import com.mr.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrMapper attrMapper;

    /**
     * 增加属性和属性值
     * @param flbh2
     * @param attrVO
     */
    @Override
    public void saveAttr(Integer flbh2, TMallAttrVO attrVO) {

        List<OBJECTTMallAttr> attrList = attrVO.getAttrList();
        for (int i = 0; i < attrList.size(); i++) {
            //1:增加属性。传递 flbh2
            OBJECTTMallAttr attr = attrList.get(i);
            attr.setFlbh2(flbh2);
            attrMapper.saveAttr(attr);

            //2:增加valuelist ,获取到自增的id
            Map<String ,Object> valueMap = new HashMap<>();
            valueMap.put("shxmId",attr.getId());
            valueMap.put("valueList",attr.getValueList());

            attrMapper.saveValue(valueMap);
        }
    }

    @Override
    public List<OBJECTTMallAttr> findAttrByclass2(Integer flbh2) {

        return attrMapper.findAttrByclass2(flbh2);
    }
}
