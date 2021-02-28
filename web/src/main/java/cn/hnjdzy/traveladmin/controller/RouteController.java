package cn.hnjdzy.traveladmin.controller;

import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.domain.Route;
import cn.hnjdzy.traveladmin.domain.RouteImg;
import cn.hnjdzy.traveladmin.domain.Seller;
import cn.hnjdzy.traveladmin.service.CategoryService;
import cn.hnjdzy.traveladmin.service.RouteService;
import cn.hnjdzy.traveladmin.service.SellerService;
import cn.hnjdzy.traveladmin.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllRoute(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize,
                                     @RequestParam(name = "sId",required = false) Integer sId,
                                     @RequestParam(name = "cId",required = false) Integer cId){
        List<Route> routes = null;
        if (sId==null&&cId==null){
            routes=  routeService.findAllRoute(pageNum,pageSize);
        }else if (cId==null&&sId!=null){
            routes =  routeService.findAllRoute(pageNum,pageSize,sId);
        }else if (cId!=null&&sId==null){
            routes = routeService.findAllRouteByCategory(pageNum,pageSize,cId);
        }
        PageInfo pageInfo = new PageInfo(routes);
        ModelAndView mv = new ModelAndView();
        mv.addObject(pageInfo);
        mv.addObject("sId",sId);
        mv.addObject("cId",cId);
        mv.setViewName("route-list");
        return mv;
    }
    @RequestMapping("/addRoute.do")
    public ModelAndView addRoute(){
        ModelAndView mv = new ModelAndView();
        List<Seller> sellers =routeService.findAllSeller();
        mv.addObject("sellers",sellers);
        List<Category> categories =routeService.findAllCategory();
        mv.addObject("categories",categories);
        mv.setViewName("route-add");
        return mv;
    }
    @RequestMapping("/saveRoute.do")
    public String saveRoute(HttpServletRequest request,@RequestParam String rname,@RequestParam String price,
                            @RequestParam String routeIntroduce,@RequestParam String rflag,@RequestParam String isThemeTour,
                            @RequestParam String sid,@RequestParam String cid,
                            MultipartFile rimageFile) throws IOException {
        Route route = new Route();
        route.setRname(rname);
        route.setPrice(Double.parseDouble(price));
        route.setRouteIntroduce(routeIntroduce);
        route.setRflag(rflag);
        if (rflag.equals("1")){
            route.setRdate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        }
        route.setIsThemeTour(isThemeTour);
        route.setSid(Integer.parseInt(sid));
        cid = cid.replace(",", "");
        route.setCid(Integer.parseInt(cid));
        String path = request.getServletContext().getRealPath("img/product/small/");
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        String rimageFileName =  "m3"+UUID.randomUUID().toString().replace("-", "")+".jpg";
        route.setRimage("img/product/small/"+rimageFileName);
        rimageFile.transferTo(new File(path,rimageFileName));
        route.setSourceId(new Random().nextInt(89999)+10000+"");
        routeService.saveRoute(route);
        return "redirect:findAll.do";
    }
    @RequestMapping("/del.do")
    public String delRoute(int[] ids){
        routeService.delRoute(ids);
        return "redirect:findAll.do";
    }
    @RequestMapping("/getRouteById.do")
    public ModelAndView getRouteById(Integer rid){
        ModelAndView mv = new ModelAndView();
        Route route = routeService.getRouteById(rid);
        mv.addObject("route",route);
        List<Seller> sellers =routeService.findAllSeller();
        mv.addObject("sellers",sellers);
        List<Category> categories =routeService.findAllCategory();
        mv.addObject("categories",categories);
        mv.setViewName("route-update");
        return mv;
    }
    @RequestMapping("/updateRoute.do")
    public String updateRoute(HttpServletRequest request,@RequestParam String rname,@RequestParam String price,
                              @RequestParam String routeIntroduce,@RequestParam Integer rflag,@RequestParam String isThemeTour,
                              @RequestParam String sid,@RequestParam String cid,@RequestParam Integer rid,
                              MultipartFile rimageFile) throws IOException {
        Route route = new Route();
        route.setRid(rid);
        route.setRname(rname);
        route.setPrice(Double.parseDouble(price));
        route.setRouteIntroduce(routeIntroduce);
        route.setRflag(String.valueOf(rflag));
        route.setIsThemeTour(isThemeTour);
        route.setSid(Integer.parseInt(sid));
        cid = cid.replace(",", "");
        route.setCid(Integer.parseInt(cid));
        if (rflag==1){
            route.setRdate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        }


        if (rimageFile!=null){
            String path = request.getServletContext().getRealPath("img/product/small/");
            File file = new File(path);
            if(!file.exists()){
                // 创建该文件夹
                file.mkdirs();
            }
            String rimageFileName =  "m3"+UUID.randomUUID().toString().replace("-", "")+".jpg";
            route.setRimage("img/product/small/"+rimageFileName);
            rimageFile.transferTo(new File(path,rimageFileName));
            routeService.updateRoute(route);
        }else {
            routeService.updateRouteNoFile(route);
        }
        return "redirect:findAll.do";
    }
}
