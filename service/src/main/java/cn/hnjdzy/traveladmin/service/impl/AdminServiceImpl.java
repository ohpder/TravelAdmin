package cn.hnjdzy.traveladmin.service.impl;

import cn.hnjdzy.traveladmin.dao.AdminDao;
import cn.hnjdzy.traveladmin.domain.AdminInfo;
import cn.hnjdzy.traveladmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminInfo adminInfo = adminDao.finAdminByUserName(username);
        User user = new User(adminInfo.getUsername(), "{noop}" + adminInfo.getPassword(), getAuthority(adminInfo.getRole()));
        return user;
    }

    private Collection<SimpleGrantedAuthority> getAuthority(String role) {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_"+role));
        return list;
    }

    @Override
    public AdminInfo getAdminInfoByUsername(String username) {
        return null;
    }
}
