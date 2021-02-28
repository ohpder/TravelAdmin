package cn.hnjdzy.traveladmin.service.impl;

import cn.hnjdzy.traveladmin.dao.CategoryDao;
import cn.hnjdzy.traveladmin.dao.RouteDao;
import cn.hnjdzy.traveladmin.dao.RouteImageDao;
import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.service.CategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private RouteDao routeDao;
    @Autowired
    private RouteImageDao routeImageDao;
    @Override
    public List<Category> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return categoryDao.findAll();
    }

    @Override
    public void delCategory(int[] ids) {

        for (int cId : ids) {
            routeImageDao.delRouteImageDaoByCategoryId(cId);
            routeDao.delRouteByCategoryId(cId);
            categoryDao.delCategory(cId);
        }
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.add(category);
    }

    @Override
    public Category getCategoryById(Integer cId) {
        return categoryDao.findById(cId);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }
}
