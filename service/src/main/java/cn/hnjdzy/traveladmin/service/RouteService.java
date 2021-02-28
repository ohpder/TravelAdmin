package cn.hnjdzy.traveladmin.service;

import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.domain.Route;
import cn.hnjdzy.traveladmin.domain.Seller;

import java.util.List;

public interface RouteService {
    List<Route> findAllRoute(Integer pageNum, Integer pageSize);

    List<Seller> findAllSeller();

    List<Category> findAllCategory();

    void saveRoute(Route route);

    void delRoute(int[] ids);

    List<Route> findAllRoute(Integer pageNum, Integer pageSize, Integer sId);


    List<Route> findAllRouteByCategory(Integer pageNum, Integer pageSize, Integer cId);

    Route getRouteById(Integer rid);

    void updateRouteNoFile(Route route);

    void updateRoute(Route route);
}
