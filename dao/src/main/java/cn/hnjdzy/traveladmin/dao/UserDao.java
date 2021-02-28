package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    @Select("select * from tab_user")
    @Results({
            @Result(id = true ,property = "uid",column = "uid"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "telephone",column = "telephone"),
            @Result(property = "email",column = "email"),
            @Result(property = "status",column = "status"),
            @Result(property = "code",column = "code")
    })
    List<UserInfo> findAll();
    @Insert("insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email},#{status},#{code})")
    void saveUser(UserInfo userInfo);
    @Delete("delete from tab_user where uid = #{uid}")
    void delUser(int uid);
    @Select("select * from tab_user where uid = #{uid}")
    @Results({
            @Result(id = true ,property = "uid",column = "uid"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "telephone",column = "telephone"),
            @Result(property = "email",column = "email"),
            @Result(property = "status",column = "status"),
            @Result(property = "code",column = "code")
    })
    UserInfo findOneById(int uid);

    @Update("update tab_user set username = #{username},password = #{password},name = #{name},birthday = #{birthday},sex = #{sex},email = #{email},status = #{status} where uid = #{uid}")
    void update(UserInfo userInfo);
}
