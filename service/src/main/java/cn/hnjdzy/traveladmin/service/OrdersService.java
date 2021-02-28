package cn.hnjdzy.traveladmin.service;

import cn.hnjdzy.traveladmin.domain.Orders;

import java.util.List;


public interface OrdersService {
    List<Orders> findAll(Integer pageNum, Integer pageSize,Integer uid);

    void delOrders(int[] ids);

    List<Orders> findAll(Integer pageNum, Integer pageSize);


}
