package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.RouteImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RouteImageDao {
    @Select("select * from tab_route_img where rid =#{rid}")
    List<RouteImg> findByRouteId(int rid);
    @Delete("delete from tab_route_img where rid in (select rid from tab_route where sid = #{sid})")
    void delRouteImageDaoBySid(int sid);
    @Delete("delete from tab_route_img where rid in (select rid from tab_route where cid = #{cId})")
    void delRouteImageDaoByCategoryId(int cId);
    @Delete("delete from tab_route_img where rid = #{rid}")
    void delRouteImageDaoByRId(int rid);
}
