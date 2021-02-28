package cn.hnjdzy.traveladmin.controller;

import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.service.CategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllSeller(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        List<Category> categories = categoryService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(categories);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("category-list");
        return mv;
    }
    @RequestMapping("/del.do")
    public String delCategory(int[] ids){
        categoryService.delCategory(ids);
        return "redirect:findAll.do";
    }
    @RequestMapping("/saveCategory.do")
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:findAll.do";
    }

    @RequestMapping("/getCategoryById.do")
    public ModelAndView getCategoryById(Integer cId){

        ModelAndView mv = new ModelAndView();
        Category category = categoryService.getCategoryById(cId);
        mv.addObject("category",category);
        mv.setViewName("category-update");
        return mv;
    }
    @RequestMapping("/updateCategory.do")
    public String updateCategory(Category category){
        categoryService.updateCategory(category);
        return "redirect:findAll.do";
    }
}
