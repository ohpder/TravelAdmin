package cn.hnjdzy.traveladmin.service;

import cn.hnjdzy.traveladmin.domain.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> findAll(Integer pageNum, Integer pageSize);

    void saveUser(UserInfo userInfo);

    void delUser(int[] ids);

    UserInfo findUserById(int uid);

    void updateUser(UserInfo userInfo);
}
