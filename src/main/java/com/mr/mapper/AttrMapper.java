package com.mr.mapper;

import com.mr.model.OBJECTTMallAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yaodd on 2018/10/30.
 */
public interface AttrMapper {

    void saveValue(Map<String, Object> valueMap);

    void saveAttr( OBJECTTMallAttr attr);

    List<OBJECTTMallAttr> findAttrByclass2(@Param("flbh2") Integer flbh2);
}
