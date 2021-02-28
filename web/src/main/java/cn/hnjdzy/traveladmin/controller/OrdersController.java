package cn.hnjdzy.traveladmin.controller;

import cn.hnjdzy.traveladmin.domain.Orders;
import cn.hnjdzy.traveladmin.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAllOrders(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize, Integer uid){

        ModelAndView mv = new ModelAndView();
        List<Orders> orders;
        if (uid==null){
             orders = ordersService.findAll(pageNum,pageSize);
        }else {
             orders = ordersService.findAll(pageNum,pageSize,uid);
        }
        PageInfo pageInfo = new PageInfo(orders);
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getPageNum());
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("uid",uid);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/del.do")
    public String delOrders(@RequestParam(name = "ids",required = false) int[] ids){
        ordersService.delOrders(ids);

        return "redirect:findAll.do";
    }

}
