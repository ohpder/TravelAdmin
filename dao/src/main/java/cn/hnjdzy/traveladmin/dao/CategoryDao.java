package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryDao {
    @Select("select * from tab_category")
    @Results({
            @Result(id = true,property = "cId",column = "cid"),
            @Result(property = "cName",column = "cname")
    })
    List<Category> findAll();
    @Select("select * from tab_category where cid = #{cid}")
    Category findById(int cid);
    @Delete("delete from tab_category where cid = #{cId}")
    void delCategory(int cId);
    @Insert("insert into tab_category(cName) values(#{cName})")
    void add(Category category);
    @Update("update tab_category set cname = #{cName} where cid =#{cId}")
    void update(Category category);
}
