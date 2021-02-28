package cn.hnjdzy.traveladmin.controller;

import cn.hnjdzy.traveladmin.domain.UserInfo;
import cn.hnjdzy.traveladmin.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(userInfos);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/saveUser.do")
    public String saveUser(UserInfo userInfo){
        userInfo.setCode(UUID.randomUUID().toString());
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/del.do")
    public String delUser(@RequestParam(name = "ids",required = false) int[] ids){
        if (ids.length==0||ids==null)
        userService.delUser(ids);

        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserById.do")
    public ModelAndView findUserById(@RequestParam(name = "uid") int uid){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findUserById(uid);
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-update");
        return mv;
    }
    @RequestMapping("/updateUser.do")
    public String updateUser(UserInfo userInfo){
        userInfo.setCode(UUID.randomUUID().toString());
        userService.updateUser(userInfo);
        return "redirect:findAll.do";
    }
}
