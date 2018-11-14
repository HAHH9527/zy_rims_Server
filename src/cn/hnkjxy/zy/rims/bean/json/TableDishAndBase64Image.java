package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;

/**
 * @author 10248
 */
public class TableDishAndBase64Image extends TableDishEntity {
    private String dishImgBase64Str;

    public String getDishImgBase64Str() {
        return dishImgBase64Str;
    }

    public void setDishImgBase64Str(String dishImgBase64Str) {
        this.dishImgBase64Str = dishImgBase64Str;
    }
}
