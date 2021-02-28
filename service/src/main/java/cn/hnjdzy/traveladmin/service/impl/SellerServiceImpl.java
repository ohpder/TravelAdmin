package cn.hnjdzy.traveladmin.service.impl;

import cn.hnjdzy.traveladmin.dao.RouteDao;
import cn.hnjdzy.traveladmin.dao.RouteImageDao;
import cn.hnjdzy.traveladmin.dao.SellerDao;
import cn.hnjdzy.traveladmin.domain.Seller;
import cn.hnjdzy.traveladmin.service.SellerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerDao sellerDao;
    @Autowired
    private RouteImageDao routeImageDao;
    @Autowired
    private RouteDao routeDao;

    @Override
    public List<Seller> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sellerDao.findAll();
    }

    @Override
    public void saveSeller(Seller seller) {
        sellerDao.save(seller);
    }

    @Override
    public void delSeller(int[] ids) {

        for (int sid : ids) {
            routeImageDao.delRouteImageDaoBySid(sid);
            routeDao.delRouteBySid(sid);
            sellerDao.delSeller(sid);
        }
    }

    @Override
    public Seller getSellerById(Integer sId) {
        return sellerDao.findById(sId);
    }

    @Override
    public void updateSeller(Seller seller) {
        sellerDao.update(seller);
    }
}
