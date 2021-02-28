package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.Orders;
import cn.hnjdzy.traveladmin.domain.Route;
import cn.hnjdzy.traveladmin.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersDao {
    @Select("select * from tab_orders")
    @Results({
            @Result(id = true,property = "oid",column = "oid"),
            @Result(property = "onumber",column = "onumber"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "rid",column = "rid"),
            @Result(property = "odate",column = "odate"),
            @Result(property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.UserDao.findOneById")),
            @Result(property = "route",column = "rid",javaType = Route.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.RouteDao.findOneById"))
    })
    List<Orders> findAll();


    @Delete("delete from tab_orders where oid = #{oid}")
    void delOrders(int oid);
   /* @Select("select * from tab_orders where uid = #{uid}")
    @Results({
            @Result(id = true,property = "oid",column = "oid"),
            @Result(property = "onumber",column = "onumber"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "rid",column = "rid"),
            @Result(property = "odate",column = "odate"),
            @Result(property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.UserDao.findOneById")),
            @Result(property = "route",column = "rid",javaType = Route.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.RouteDao.findOneById"))
    })
    List<Orders> findByUserId(int uid);*/
    @Select("select * from tab_orders where uid = #{uid}")
    @Results({
            @Result(id = true,property = "oid",column = "oid"),
            @Result(property = "onumber",column = "onumber"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "rid",column = "rid"),
            @Result(property = "odate",column = "odate"),
            @Result(property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.UserDao.findOneById")),
            @Result(property = "route",column = "rid",javaType = Route.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.RouteDao.findOneById"))
    })
    List<Orders> findAllByUserId(Integer uid);
}
