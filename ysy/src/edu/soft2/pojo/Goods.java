package edu.soft2.pojo;

/**
 *
 * @author 李昱
 *2021年9月7日
 *数据库goods表的实体类
 */
public class Goods {
    private String Goodsid,Title,UnitPrice,Discount,Cateid,Storeid,Roat,Description,PackingExpense;

    public String getGoodsid() {
        return Goodsid;
    }

    public void setGoodsid(String goodsid) {
        Goodsid = goodsid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getCateid() {
        return Cateid;
    }

    public void setCateid(String cateid) {
        Cateid = cateid;
    }

    public String getStoreid() {
        return Storeid;
    }

    public void setStoreid(String storeid) {
        Storeid = storeid;
    }

    public String getRoat() {
        return Roat;
    }

    public void setRoat(String roat) {
        Roat = roat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPackingExpense() {
        return PackingExpense;
    }

    public void setPackingExpense(String packingExpense) {
        PackingExpense = packingExpense;
    }

    @Override
    public String toString() {
        return "Goods [Goodsid=" + Goodsid + ", Title=" + Title + ", UnitPrice=" + UnitPrice + ", Discount=" + Discount
                + ", Cateid=" + Cateid + ", Storeid=" + Storeid + ", Roat=" + Roat + ", Description=" + Description
                + ", PackingExpense=" + PackingExpense + "]";
    }

    public Goods(String goodsid, String title, String unitPrice, String discount, String cateid, String storeid,
                 String roat, String description, String packingExpense) {
        super();
        Goodsid = goodsid;
        Title = title;
        UnitPrice = unitPrice;
        Discount = discount;
        Cateid = cateid;
        Storeid = storeid;
        Roat = roat;
        Description = description;
        PackingExpense = packingExpense;
    }

    public Goods() {
        super();
        // TODO Auto-generated constructor stub
    }

}

