package cn.hnjdzy.traveladmin.controller;

import cn.hnjdzy.traveladmin.domain.Seller;
import cn.hnjdzy.traveladmin.service.SellerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllSeller(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){

        ModelAndView mv = new ModelAndView();
        List<Seller> sellers = sellerService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(sellers);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("seller-list");
        return mv;
    }
    @RequestMapping("/saveSeller.do")
    public String saveSeller(Seller seller){
        sellerService.saveSeller(seller);
        return "redirect:findAll.do";
    }
    @RequestMapping("/del.do")
    public String delSeller(int[] ids){
        sellerService.delSeller(ids);
        return "redirect:findAll.do";
    }
    @RequestMapping("/getSellerById.do")
    public ModelAndView getSellerById(Integer sId){
        ModelAndView mv = new ModelAndView();
        Seller seller = sellerService.getSellerById(sId);
        mv.addObject("seller",seller);
        mv.setViewName("seller-update");
        return mv;
    }
    @RequestMapping("/update.do")
    public String updateSeller(Seller seller){

        sellerService.updateSeller(seller);

        return "redirect:findAll.do";
    }
}
