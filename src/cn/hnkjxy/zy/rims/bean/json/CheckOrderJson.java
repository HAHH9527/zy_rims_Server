package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;

import java.util.ArrayList;
import java.util.List;

public class CheckOrderJson extends TableOrderEntity {
    private List<TableDishEntity> list = new ArrayList<TableDishEntity>();

    public void setTableOrderEntity(TableOrderEntity tableOrderEntity) {
        this.setOrderId(tableOrderEntity.getOrderId());
        this.setTableId(tableOrderEntity.getTableId());
        this.setOrderStatus(tableOrderEntity.getOrderStatus());
        this.setUseTime(tableOrderEntity.getUseTime());
        this.setEndTime(tableOrderEntity.getEndTime());
        this.setDishList(tableOrderEntity.getDishList());
        this.setOrderPriceReal(tableOrderEntity.getOrderPrice());
        this.setOrderDiscount(tableOrderEntity.getOrderDiscount());
        this.setOrderPriceReal(tableOrderEntity.getOrderPrice());
        this.setOrderOther(tableOrderEntity.getOrderOther());
    }

    public void addList(TableDishEntity tableDishEntity) {
        list.add(tableDishEntity);
    }

    public List<TableDishEntity> getList() {
        return list;
    }

    public void setList(List<TableDishEntity> list) {
        this.list = list;
    }
}
