package cn.hnjdzy.traveladmin.service.impl;

import cn.hnjdzy.traveladmin.dao.UserDao;
import cn.hnjdzy.traveladmin.domain.UserInfo;
import cn.hnjdzy.traveladmin.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserInfo> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userDao.findAll();
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        userDao.saveUser(userInfo);
    }

    @Override
    public void delUser(int[] ids) {

        for (int id : ids) {
            userDao.delUser(id);
        }
    }

    @Override
    public UserInfo findUserById(int uid) {
        return userDao.findOneById(uid);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userDao.update(userInfo);
    }
}
