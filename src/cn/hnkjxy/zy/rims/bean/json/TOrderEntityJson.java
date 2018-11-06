package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;
import cn.hnkjxy.zy.rims.bean.dbEntity.TOrderEntity;

import java.util.List;

public class TOrderEntityJson extends TOrderEntity {
    private List<TDishEntity> dishListI;

    public List<TDishEntity> getDishListI() {
        return dishListI;
    }

    public void setDishListI(List<TDishEntity> dishListI) {
        this.dishListI = dishListI;
    }
}
