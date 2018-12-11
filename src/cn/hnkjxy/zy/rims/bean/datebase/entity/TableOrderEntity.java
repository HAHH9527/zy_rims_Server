package cn.hnkjxy.zy.rims.bean.datebase.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 10248
 */
@Entity
@Table(name = "t_order", schema = "zy_rims")
public class TableOrderEntity {
    private int orderId;
    private String tableId;
    private String orderStatus;
    private Timestamp useTime;
    private Timestamp endTime;
    private String dishList;
    private Double orderPrice;
    private Double orderDiscount;
    private Double orderPriceReal;
    private String orderOther;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "table_id")
    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "use_time")
    public Timestamp getUseTime() {
        return useTime;
    }

    public void setUseTime(Timestamp useTime) {
        this.useTime = useTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "dish_list")
    public String getDishList() {
        return dishList;
    }

    public void setDishList(String dishList) {
        this.dishList = dishList;
    }

    @Basic
    @Column(name = "order_price")
    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Basic
    @Column(name = "order_discount")
    public Double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    @Basic
    @Column(name = "order_price_real")
    public Double getOrderPriceReal() {
        return orderPriceReal;
    }

    public void setOrderPriceReal(Double orderPriceReal) {
        this.orderPriceReal = orderPriceReal;
    }

    @Basic
    @Column(name = "order_other")
    public String getOrderOther() {
        return orderOther;
    }

    public void setOrderOther(String orderOther) {
        this.orderOther = orderOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TableOrderEntity that = (TableOrderEntity) o;
        return orderId == that.orderId &&
                Objects.equals(tableId, that.tableId) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(useTime, that.useTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(dishList, that.dishList) &&
                Objects.equals(orderPrice, that.orderPrice) &&
                Objects.equals(orderDiscount, that.orderDiscount) &&
                Objects.equals(orderPriceReal, that.orderPriceReal) &&
                Objects.equals(orderOther, that.orderOther);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, tableId, orderStatus, useTime, endTime, dishList, orderPrice, orderDiscount, orderPriceReal, orderOther);
    }
}
