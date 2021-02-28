package cn.hnjdzy.traveladmin.service;

import cn.hnjdzy.traveladmin.domain.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> findAll(Integer pageNum, Integer pageSize);

    void saveSeller(Seller seller);

    void delSeller(int[] ids);

    Seller getSellerById(Integer sId);

    void updateSeller(Seller seller);
}
