package cn.hnkjxy.zy.rims.db.dao;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import cn.hnkjxy.zy.rims.db.impl.DishImpl;

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
            closeSession();
        }

        return retId;
    }

    @Override
    public TDishEntity findDishById(int dishId) {
        return null;
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
