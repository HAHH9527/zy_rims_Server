package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10248
 */
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

    /**
     * 往菜单列表中添加菜品
     *
     * @param tableDishEntity 添加的菜品
     */
    public void addList(TableDishEntity tableDishEntity) {
        list.add(tableDishEntity);
    }

    public List<TableDishEntity> getList() {
        return list;
    }

}
