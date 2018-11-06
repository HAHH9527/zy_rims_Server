package cn.hnkjxy.zy.rims.bean.json;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;

public class TDishEntityJson extends TDishEntity {
    private String dishImgBase64Str;

    public String getDishImgBase64Str() {
        return dishImgBase64Str;
    }

    public void setDishImgBase64Str(String dishImgBase64Str) {
        this.dishImgBase64Str = dishImgBase64Str;
    }
}
