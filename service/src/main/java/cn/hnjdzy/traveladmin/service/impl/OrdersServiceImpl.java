package cn.hnjdzy.traveladmin.service.impl;

import cn.hnjdzy.traveladmin.dao.OrdersDao;
import cn.hnjdzy.traveladmin.domain.Orders;
import cn.hnjdzy.traveladmin.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(Integer pageNum, Integer pageSize,Integer uid) {
        PageHelper.startPage(pageNum,pageSize);
        return ordersDao.findAllByUserId(uid);
    }

    @Override
    public void delOrders(int[] ids) {
        for (int oid : ids) {
            ordersDao.delOrders(oid);
        }
    }

    @Override
    public List<Orders> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ordersDao.findAll();
    }

}
