package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.Category;
import cn.hnjdzy.traveladmin.domain.Seller;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SellerDao {
    @Select("select * from tab_seller")
    @Results({
            @Result(id = true,property = "sId",column = "sid"),
            @Result(property = "sName",column = "sname"),
            @Result(property = "consPhone",column = "consPhone"),
            @Result(property = "address",column = "address"),
//            @Result(property = "routes",column = "sid",javaType = List.class,many = @Many(select = ""))
    })
    List<Seller> findAll();
    @Insert("insert into tab_seller values(#{sId},#{sName},#{consPhone},#{address})")
    void save(Seller seller);

    @Select("select * from tab_seller where sid = #{sid}")
    Seller findById(int sid);

    @Delete("delete from tab_seller where sid = #{id}")
    void delSeller(int id);
    @Update("update tab_seller set sname = #{sName},consphone = #{consPhone},address = #{address} where sid = #{sId}")
    void update(Seller seller);
}
