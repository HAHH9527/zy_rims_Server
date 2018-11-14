package cn.hnkjxy.zy.rims.datebase.dao;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.datebase.HibernateUtils;
import cn.hnkjxy.zy.rims.datebase.impl.DishImpl;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author 10248
 */
public class DishDao extends HibernateUtils implements DishImpl {
    @Override
    public int insertNewDish(TableDishEntity newDish) {
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
    public TableDishEntity findDishById(int dishId) {
        TableDishEntity dish;

        initHibernate();

        try {
            dish = session.get(TableDishEntity.class, dishId);
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
    public boolean updateDishById(TableDishEntity updateDish) {
        return false;
    }

    @Override
    public boolean deleteDishById(int dishId) {
        boolean ret;

        initHibernate();

        TableDishEntity deleteEntity = new TableDishEntity();
        deleteEntity.setDishId(dishId);

        try {
            session.delete(deleteEntity);
            commitTransaction();
            ret = true;
        } catch (Exception e) {
            rollbackTransaction();
            ret = false;
            e.printStackTrace();
        } finally {
            closeFinally();
        }

        return ret;
    }

    @Override
    public List<TableDishEntity> getMenu() {
        List<TableDishEntity> list;

        initHibernate();

        try {
            Query<TableDishEntity> query = session.createQuery("from TableDishEntity", TableDishEntity.class);
            list = query.list();
        } catch (Exception e) {
            rollbackTransaction();
            list = null;
            e.printStackTrace();
        } finally {
            closeFinally();
        }

        return list;
    }
}
