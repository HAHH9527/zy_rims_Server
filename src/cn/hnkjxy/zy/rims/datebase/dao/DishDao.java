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

        dish = session.get(TableDishEntity.class, dishId);
        commitTransaction();
        closeFinally();

        return dish;
    }

    @Override
    public boolean updateDish(TableDishEntity updateDish) {
        boolean ret;

        initHibernate();

        try {
            session.merge(updateDish);
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

        Query<TableDishEntity> query = session.createQuery("from TableDishEntity", TableDishEntity.class);
        list = query.list();
        closeFinally();

        return list;
    }
}
