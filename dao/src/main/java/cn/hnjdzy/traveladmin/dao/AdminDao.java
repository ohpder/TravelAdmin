package cn.hnjdzy.traveladmin.dao;

import cn.hnjdzy.traveladmin.domain.AdminInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    @Select("select * from tab_admin where username = #{username}")
     AdminInfo finAdminByUserName(String username);
}
