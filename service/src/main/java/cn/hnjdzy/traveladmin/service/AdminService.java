package cn.hnjdzy.traveladmin.service;

import cn.hnjdzy.traveladmin.domain.AdminInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService extends UserDetailsService {
    AdminInfo getAdminInfoByUsername(String username);
}
