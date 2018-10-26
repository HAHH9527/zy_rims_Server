package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.TMenuEntity;
import cn.hnkjxy.zy.rims.bean.TOrderEntity;

import java.util.List;

public class TOrderEntityJson extends TOrderEntity {
    private List<TMenuEntity> dishListI;

    public List<TMenuEntity> getDishListI() {
        return dishListI;
    }

    public void setDishListI(List<TMenuEntity> dishListI) {
        this.dishListI = dishListI;
    }
}
