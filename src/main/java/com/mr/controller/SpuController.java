package com.mr.controller;

import com.mr.model.TMallProduct;
import com.mr.service.SpuService;
import com.mr.util.MyFileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yaodd on 2018/10/29.
 * 商品
 */
@Controller
public class SpuController {

    @Autowired
    private SpuService spuService;


    //跳转到增加页面
    @RequestMapping("toAddSpuPage")
    public String  toAddSpuPage(TMallProduct spu , ModelMap map){
        map.put("spu",spu);
        return "spu-add";
    }

    /**
     * 增加spu对象
     * @param spu
     * @param imgs
     * @return
     */
    @RequestMapping("addSpu")
    public ModelAndView addSpu(TMallProduct spu,
                               @RequestParam MultipartFile[] imgs){

        //上传图片，并且将图片的路径存放spu对象中。
        List<String> urlList = MyFileUploadUtil.upload_image(imgs);

        spu.setShpTp(urlList.get(0));
        //添加spu、商品图片
        spuService.saveSpu(spu , urlList);

        //重定向并且返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("flbh1",spu.getFlbh1());
        mv.addObject("flbh2",spu.getFlbh2());
        mv.addObject("ppId",spu.getPpId());
        mv.setViewName("redirect:toAddSpuPage.do");
        return mv;
    }

}
