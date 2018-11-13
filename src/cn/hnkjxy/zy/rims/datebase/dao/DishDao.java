package cn.hnkjxy.zy.rims.datebase.dao;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;
import cn.hnkjxy.zy.rims.datebase.HibernateUtils;
import cn.hnkjxy.zy.rims.datebase.impl.DishImpl;
import org.hibernate.query.Query;

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
            closeFinally();
        }

        return retId;
    }

    @Override
    public TDishEntity findDishById(int dishId) {
        TDishEntity dish;

        initHibernate();

        try {
            dish = session.get(TDishEntity.class, dishId);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            dish = null;
            e.printStackTrace();
        } finally {
            closeFinally();
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
        List<TDishEntity> list = null;

        initHibernate();

        try {
            Query<TDishEntity> query = session.createQuery("from TDishEntity", TDishEntity.class);
            list = query.list();
        } catch (Exception e) {
            rollbackTransaction();
        } finally {
            closeFinally();
        }

        return list;
    }
}
