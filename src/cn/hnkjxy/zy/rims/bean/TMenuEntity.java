package cn.hnkjxy.zy.rims.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 10248
 */
@Entity
@Table(name = "t_menu", schema = "zy_rims")
public class TMenuEntity {
    private int dishId;
    private String dishName;
    private BigDecimal dishPrice;
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
    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
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
                Objects.equals(dishIntroduced, that.dishIntroduced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, dishName, dishPrice, dishImgSrc, dishIntroduced);
    }
}
