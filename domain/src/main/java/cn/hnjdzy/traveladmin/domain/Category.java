package cn.hnjdzy.traveladmin.domain;

import java.util.List;

public class Category {
    private int cId;//分类id
    private String cName;//分类名称
    private List<Route> routes;//该分类下的所有路线图

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
