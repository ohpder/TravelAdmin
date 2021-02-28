package cn.hnjdzy.traveladmin.domain;

import java.util.List;

public class Route {
    private int rid;//线路id，必输
    private String rname;//线路名称，必输
    private double price;//价格，必输
    private String routeIntroduce;//线路介绍
    private String rflag;   //是否上架，必输，0代表没有上架，1代表是上架
    private String rdate;   //上架时间
    private String isThemeTour;//是否主题旅游，必输，0代表不是，1代表是
    private int count;//收藏数量
    private int cid;//所属分类，必输
    private String rimage;//缩略图
    private int sid;//所属商家
    private String sourceId;//抓取数据的来源id
    private Category category;//所属分类
    private Seller seller;//所属商家
    private List<RouteImg> routeImgList;//商品详情图片列表
    private String rflagStr;
    private String isThemeTourStr;

    @Override
    public String toString() {
        return "Route{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", price=" + price +
                ", routeIntroduce='" + routeIntroduce + '\'' +
                ", rflag=" + rflag +
                ", rdate='" + rdate + '\'' +
                ", isThemeTour=" + isThemeTour +
                ", count=" + count +
                ", cid=" + cid +
                ", rimage='" + rimage + '\'' +
                ", sid=" + sid +
                ", sourceId='" + sourceId + '\'' +
                ", category=" + category +
                ", seller=" + seller +
                ", routeImgList=" + routeImgList +
                ", rflagStr='" + rflagStr + '\'' +
                ", isThemeTourStr='" + isThemeTourStr + '\'' +
                '}';
    }

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public String getIsThemeTour() {
        return isThemeTour;
    }

    public void setIsThemeTour(String isThemeTour) {
        this.isThemeTour = isThemeTour;
    }

    public String getRflagStr() {
        if (rflag.equals("0")){
            rflagStr="未上架";
        }

        if (rflag.equals("1")){
            rflagStr="已上架";
        }
        return rflagStr;
    }

    public void setRflagStr(String rflagStr) {
        this.rflagStr = rflagStr;
    }

    public String getIsThemeTourStr() {
        if (isThemeTour.equals("0")){
            isThemeTourStr="否";
        }
        if (isThemeTour.equals("1")){
            isThemeTourStr="是";
        }
        return isThemeTourStr;
    }

    public void setIsThemeTourStr(String isThemeTourStr) {
        this.isThemeTourStr = isThemeTourStr;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRouteIntroduce() {
        return routeIntroduce;
    }

    public void setRouteIntroduce(String routeIntroduce) {
        this.routeIntroduce = routeIntroduce;
    }


    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<RouteImg> getRouteImgList() {
        return routeImgList;
    }

    public void setRouteImgList(List<RouteImg> routeImgList) {
        this.routeImgList = routeImgList;
    }
}
