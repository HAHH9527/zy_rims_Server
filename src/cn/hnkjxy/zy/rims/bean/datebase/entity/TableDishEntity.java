package cn.hnkjxy.zy.rims.bean.datebase.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 10248
 */
@Entity
@Table(name = "t_dish", schema = "zy_rims")
public class TableDishEntity {
    private int dishId;
    private String dishName;
    private Double dishPrice;
    private String dishImgName;
    private String dishIntroduced;
    private String dishClass;

    @Id
    @Column(name = "dish_id")
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "dish_name")
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Basic
    @Column(name = "dish_price")
    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Basic
    @Column(name = "dish_img_name")
    public String getDishImgName() {
        return dishImgName;
    }

    public void setDishImgName(String dishImgName) {
        this.dishImgName = dishImgName;
    }

    @Basic
    @Column(name = "dish_introduced")
    public String getDishIntroduced() {
        return dishIntroduced;
    }

    public void setDishIntroduced(String dishIntroduced) {
        this.dishIntroduced = dishIntroduced;
    }

    @Basic
    @Column(name = "dish_class")
    public String getDishClass() {
        return dishClass;
    }

    public void setDishClass(String dishClass) {
        this.dishClass = dishClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TableDishEntity that = (TableDishEntity) o;
        return dishId == that.dishId &&
                Objects.equals(dishName, that.dishName) &&
                Objects.equals(dishPrice, that.dishPrice) &&
                Objects.equals(dishImgName, that.dishImgName) &&
                Objects.equals(dishIntroduced, that.dishIntroduced) &&
                Objects.equals(dishClass, that.dishClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, dishName, dishPrice, dishImgName, dishIntroduced, dishClass);
    }
}
