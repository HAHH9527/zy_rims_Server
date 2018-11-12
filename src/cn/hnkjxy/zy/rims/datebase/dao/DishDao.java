package cn.hnkjxy.zy.rims.datebase.dao;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;
import cn.hnkjxy.zy.rims.datebase.HibernateUtils;
import cn.hnkjxy.zy.rims.datebase.impl.DishImpl;

import java.util.List;

/**
 * @author 10248
 */
public class DishDao extends HibernateUtils implements DishImpl {
    @Override
    public int insertNewDish(TDishEntity newDish) {
        int retId;

        initHibernate();

        try {
            session.persist(newDish);
            commitTransaction();
            retId = newDish.getDishId();
        } catch (Exception e) {
            rollbackTransaction();
            retId = -1;
            e.printStackTrace();
        } finally {
            finalclose();
        }

        return retId;
    }

    @Override
    public TDishEntity findDishById(int dishId) {
        initHibernate();
        TDishEntity dish;
        try {
            dish = session.get(TDishEntity.class, dishId);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            dish = null;
            e.printStackTrace();
        } finally {
            finalclose();
        }

        return dish;
    }

    @Override
    public boolean updateDishById(TDishEntity updateDish) {
        return false;
    }

    @Override
    public boolean deleteDishById(int dishId) {
        return false;
    }

    @Override
    public List<TDishEntity> getMenu() {
        return null;
    }
}
