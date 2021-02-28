package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.domain.Route;
import cn.hnjdzy.traveladmin.domain.Seller;
import cn.hnjdzy.traveladmin.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteDao {
    @Select("select * from tab_route")
    @Results({
            @Result(id = true , column = "rid",property = "rid"),
            @Result(column = "rname",property = "rname"),
            @Result(column = "price",property = "price"),
            @Result(column = "routeIntroduce",property = "routeIntroduce"),
            @Result(column = "rflag",property = "rflag"),
            @Result(column = "rdate",property = "rdate"),
            @Result(column = "isThemeTour",property = "isThemeTour"),
            @Result(column = "count",property = "count"),
            @Result(column = "cid",property = "cid"),
            @Result(column = "rimage",property = "rimage"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "sourceId",property = "sourceId"),
            @Result(column = "cid",property = "category",javaType = Category.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.CategoryDao.findById")),
            @Result(column = "sid",property = "seller",javaType = Seller.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.SellerDao.findById")),
            @Result(column = "rid",property = "routeImgList",javaType = List.class,many = @Many(select = "cn.hnjdzy.traveladmin.dao.RouteImageDao.findByRouteId"))
    })
    List<Route> findAll();
    @Insert("insert into tab_route values (#{rid},#{rname},#{price},#{routeIntroduce},#{rflag},#{rdate},#{isThemeTour},0,#{cid},#{rimage},#{sid},#{sourceId})")
    void saveRoute(Route route);
    @Delete("delete from tab_route where sid = #{sid}")
    void delRouteBySid(int sid);
    @Delete("delete from tab_route where cid = #{cId}")
    void delRouteByCategoryId(int cId);
    @Delete("delete from tab_route where rid = #{rid}")
    void delRouteByRId(int rid);
    @Select("select * from tab_route where rid = #{rid}")
    @Results({
            @Result(id = true , column = "rid",property = "rid"),
            @Result(column = "rname",property = "rname"),
            @Result(column = "price",property = "price"),
            @Result(column = "routeIntroduce",property = "routeIntroduce"),
            @Result(column = "rflag",property = "rflag"),
            @Result(column = "rdate",property = "rdate"),
            @Result(column = "isThemeTour",property = "isThemeTour"),
            @Result(column = "count",property = "count"),
            @Result(column = "cid",property = "cid"),
            @Result(column = "rimage",property = "rimage"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "sourceId",property = "sourceId"),
            @Result(column = "cid",property = "category",javaType = Category.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.CategoryDao.findById")),
            @Result(column = "sid",property = "seller",javaType = Seller.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.SellerDao.findById")),
            @Result(column = "rid",property = "routeImgList",javaType = List.class,many = @Many(select = "cn.hnjdzy.traveladmin.dao.RouteImageDao.findByRouteId"))
    })
    Route findOneById(int rid);
    @Select("select * from tab_route where sid = #{sid}")
    @Results({
            @Result(id = true , column = "rid",property = "rid"),
            @Result(column = "rname",property = "rname"),
            @Result(column = "price",property = "price"),
            @Result(column = "routeIntroduce",property = "routeIntroduce"),
            @Result(column = "rflag",property = "rflag"),
            @Result(column = "rdate",property = "rdate"),
            @Result(column = "isThemeTour",property = "isThemeTour"),
            @Result(column = "count",property = "count"),
            @Result(column = "cid",property = "cid"),
            @Result(column = "rimage",property = "rimage"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "sourceId",property = "sourceId"),
            @Result(column = "cid",property = "category",javaType = Category.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.CategoryDao.findById")),
            @Result(column = "sid",property = "seller",javaType = Seller.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.SellerDao.findById")),
            @Result(column = "rid",property = "routeImgList",javaType = List.class,many = @Many(select = "cn.hnjdzy.traveladmin.dao.RouteImageDao.findByRouteId"))
    })
    List<Route> findAllBySellerId(Integer sId);
    @Select("select * from tab_route where cid = #{cId}")
    @Results({
            @Result(id = true , column = "rid",property = "rid"),
            @Result(column = "rname",property = "rname"),
            @Result(column = "price",property = "price"),
            @Result(column = "routeIntroduce",property = "routeIntroduce"),
            @Result(column = "rflag",property = "rflag"),
            @Result(column = "rdate",property = "rdate"),
            @Result(column = "isThemeTour",property = "isThemeTour"),
            @Result(column = "count",property = "count"),
            @Result(column = "cid",property = "cid"),
            @Result(column = "rimage",property = "rimage"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "sourceId",property = "sourceId"),
            @Result(column = "cid",property = "category",javaType = Category.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.CategoryDao.findById")),
            @Result(column = "sid",property = "seller",javaType = Seller.class,one = @One(select = "cn.hnjdzy.traveladmin.dao.SellerDao.findById")),
            @Result(column = "rid",property = "routeImgList",javaType = List.class,many = @Many(select = "cn.hnjdzy.traveladmin.dao.RouteImageDao.findByRouteId"))
    })
    List<Route> findAllRouteByCategory(Integer cId);
    @Update("update tab_route set rname=#{rname}, price=#{price},rdate=#{rdate}, routeIntroduce=#{routeIntroduce}, rflag=#{rflag}, isThemeTour=#{isThemeTour}, cid=#{cid}, sid=#{sid} where rid = #{rid}")
    void updateRouteNoFile(Route route);
    @Update("update tab_route set rname=#{rname}, price=#{price},rdate=#{rdate}, routeIntroduce=#{routeIntroduce}, rflag=#{rflag}, isThemeTour=#{isThemeTour}, cid=#{cid}, sid=#{sid},rimage=#{rimage} where rid = #{rid}")
    void updateRoute(Route route);
}
