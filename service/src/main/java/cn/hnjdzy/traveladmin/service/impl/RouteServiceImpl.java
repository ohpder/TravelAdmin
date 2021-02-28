package cn.hnjdzy.traveladmin.service.impl;

import cn.hnjdzy.traveladmin.dao.CategoryDao;
import cn.hnjdzy.traveladmin.dao.RouteDao;
import cn.hnjdzy.traveladmin.dao.RouteImageDao;
import cn.hnjdzy.traveladmin.dao.SellerDao;
import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.domain.Route;
import cn.hnjdzy.traveladmin.domain.Seller;
import cn.hnjdzy.traveladmin.service.RouteService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteDao routeDao;
    @Autowired
    private SellerDao sellerDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private RouteImageDao routeImageDao;
    @Override
    public List<Route> findAllRoute(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return routeDao.findAll();
    }

    @Override
    public List<Seller> findAllSeller() {
        return sellerDao.findAll();
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAll();
    }

    @Override
    public void saveRoute(Route route) {
        routeDao.saveRoute(route);
    }

    @Override
    public void delRoute(int[] ids) {

        for (int rid : ids) {
            routeImageDao.delRouteImageDaoByRId(rid);
            routeDao.delRouteByRId(rid);
        }
    }

    @Override
    public List<Route> findAllRoute(Integer pageNum, Integer pageSize, Integer sId) {
        PageHelper.startPage(pageNum,pageSize);
        return routeDao.findAllBySellerId(sId);
    }

    @Override
    public List<Route> findAllRouteByCategory(Integer pageNum, Integer pageSize, Integer cId) {
        PageHelper.startPage(pageNum,pageSize);
        return routeDao.findAllRouteByCategory(cId);
    }

    @Override
    public Route getRouteById(Integer rid) {
        return routeDao.findOneById(rid);
    }

    @Override
    public void updateRouteNoFile(Route route) {
        routeDao.updateRouteNoFile(route);
    }

    @Override
    public void updateRoute(Route route) {
        routeDao.updateRoute(route);
    }
}
