package com.mr.controller;

import com.mr.model.OBJECTTMallAttr;
import com.mr.model.TMallAttrVO;
import com.mr.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yaodd on 2018/10/30.
 */
@Controller
public class AttrController {

    @Autowired
    private AttrService attrService;

    /**
     * 跳转到属性增加页面
     * @param flbh2
     * @param map
     * @return
     */
    @RequestMapping("toAddAttrPage")
    public String toAddAttrPage(Integer flbh2, ModelMap map){

        map.put("flbh2",flbh2);

        return "attr-add";
    }

    /**
     * 添加方法
     * @return
     */
    @RequestMapping("/saveAttr")
    public ModelAndView saveAttr(Integer flbh2, TMallAttrVO attrVO){

        attrService.saveAttr(flbh2,attrVO);

        //重定向并且返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("flbh2",flbh2);
        mv.setViewName("redirect:toAddAttrPage.do");
        return mv;
    }

    /**
     * 返回属性列表内嵌页
     * @return
     */
    @RequestMapping("/findAttrByclass2")
    public String findAttrByclass2(Integer flbh2 , ModelMap map){

        List<OBJECTTMallAttr> list = attrService.findAttrByclass2(flbh2);

        map.put("list",list);
        return "innerAttrPage";
    }

}
