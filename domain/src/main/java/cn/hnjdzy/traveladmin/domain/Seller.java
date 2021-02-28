package cn.hnjdzy.traveladmin.domain;

import java.util.List;

public class Seller {
    private int sId;//商家id
    private String sName;//商家名称
    private String consPhone;//商家电话
    private String address;//商家地址
    private List<Route> routes;


    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getConsPhone() {
        return consPhone;
    }

    public void setConsPhone(String consPhone) {
        this.consPhone = consPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
