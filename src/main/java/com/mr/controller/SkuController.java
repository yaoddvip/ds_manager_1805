package com.mr.controller;

import com.mr.model.OBJECTTMallAttr;
import com.mr.model.TMallProduct;
import com.mr.model.TMallSku;
import com.mr.model.TMallSkuVO;
import com.mr.service.AttrService;
import com.mr.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yaodd on 2018/10/31.
 */
@Controller
public class SkuController {

    @Autowired
    private SkuService skuService;

    @Autowired
    private AttrService attrService;

    @RequestMapping("toAddSkuPage")
    public String toAddSkuPage(Integer flbh1, Integer flbh2, ModelMap map){
        //查询属性
        List<OBJECTTMallAttr> attrList = attrService.findAttrByclass2(flbh2);

        map.put("flbh1",flbh1);
        map.put("flbh2",flbh2);
        map.put("attrList",attrList);
        return  "sku-add";
    }

    /**
     * 查询spu通过 tmId 、 flbh2
     * @return
     */
    @ResponseBody
    @RequestMapping("selectSpu")
    public List<TMallProduct> selectSpu(TMallProduct spu){
        List<TMallProduct> list = skuService.selectSpu(spu);
        return list;
    }

    /**
     * 增加sku、skuAttrValue
     * @param skuVO
     * @return
     */
    @RequestMapping("saveSku")
    public ModelAndView saveSku(TMallSkuVO skuVO ,Integer flbh1, Integer flbh2){

        skuService.saveSku(skuVO);

        //重定向并且返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("flbh1",flbh1);
        mv.addObject("flbh2",flbh2);
        mv.setViewName("redirect:toAddSkuPage.do");
        return mv;
    }

}
