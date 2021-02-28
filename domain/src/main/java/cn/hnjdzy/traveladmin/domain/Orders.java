package cn.hnjdzy.traveladmin.domain;

import cn.hnjdzy.traveladmin.utils.DateUtils;

import java.util.Date;

public class Orders {
    private int oid;//订单id
    private String onumber;//订单号码
    private int uid;//订单用户id
    private int rid;//订单商品id
    private Date odate;//下单时间
    private String odateStr;
    private UserInfo userInfo;//订单用户信息
    private Route route;//订单商品信息

    public String getOdateStr() {
        if (odate!=null){
            odateStr= DateUtils.date2String(odate,"yyyy-MM-dd HH:mm:ss");
        }
        return odateStr;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public void setOdateStr(String odateStr) {
        this.odateStr = odateStr;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public UserInfo getUserInfo() {
        return  userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
