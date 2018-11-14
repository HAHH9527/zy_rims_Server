package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;

import java.util.List;

/**
 * @author 10248
 */
public class TableOrderEntityJson extends TableOrderEntity {
    private List<TableDishEntity> dishListI;

    public List<TableDishEntity> getDishListI() {
        return dishListI;
    }

    public void setDishListI(List<TableDishEntity> dishListI) {
        this.dishListI = dishListI;
    }
}
