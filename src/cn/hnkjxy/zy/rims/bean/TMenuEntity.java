package cn.hnkjxy.zy.rims.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_menu", schema = "zy_rims")
public class TMenuEntity {
    private int dishId;
    private String dishName;
    private Double dishPrice;
    private String dishImgSrc;
    private String dishImgName;
    private String dishIntroduced;

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
    @Column(name = "dish_img_src")
    public String getDishImgSrc() {
        return dishImgSrc;
    }

    public void setDishImgSrc(String dishImgSrc) {
        this.dishImgSrc = dishImgSrc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TMenuEntity that = (TMenuEntity) o;
        return dishId == that.dishId &&
                Objects.equals(dishName, that.dishName) &&
                Objects.equals(dishPrice, that.dishPrice) &&
                Objects.equals(dishImgSrc, that.dishImgSrc) &&
                Objects.equals(dishImgName, that.dishImgName) &&
                Objects.equals(dishIntroduced, that.dishIntroduced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, dishName, dishPrice, dishImgSrc, dishImgName, dishIntroduced);
    }
}
