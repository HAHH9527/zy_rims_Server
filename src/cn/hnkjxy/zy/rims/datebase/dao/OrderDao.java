package cn.hnkjxy.zy.rims.datebase.dao;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;
import cn.hnkjxy.zy.rims.datebase.HibernateUtils;
import cn.hnkjxy.zy.rims.datebase.impl.OrderImpl;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author 10248
 */
public class OrderDao extends HibernateUtils implements OrderImpl {

    @Override
    public int insertNewOrder(TableOrderEntity newOrder) {
        int retId;

        initHibernate();

        try {
            session.persist(newOrder);
            commitTransaction();
            retId = newOrder.getOrderId();
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
    public TableOrderEntity findOrderById(int orderId) {
        TableOrderEntity order;

        initHibernate();

        order = session.get(TableOrderEntity.class, orderId);
        commitTransaction();
        closeFinally();

        return order;
    }

    @Override
    public boolean updateOrder(TableOrderEntity updateOrder) {
        boolean ret;

        initHibernate();

        try {
            session.merge(updateOrder);
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
    public boolean checkOrder(TableOrderEntity checkOrder) {
        boolean ret;

        initHibernate();

        try {
            Query query = session.createQuery("update TableOrderEntity set " +
                    "orderStatus=:orderStatus, " +
                    "endTime=:endTime, " +
                    "orderPrice=:orderPrice, " +
                    "orderDiscount=:orderDiscount, " +
                    "orderPriceReal=:orderPriceReal, " +
                    "orderOther=:orderOther " +
                    "where orderId=:orderId");
            query.setParameter("orderStatus", checkOrder.getOrderStatus());
            query.setParameter("endTime", checkOrder.getEndTime());
            query.setParameter("orderPrice", checkOrder.getOrderPrice());
            query.setParameter("orderDiscount", checkOrder.getOrderDiscount());
            query.setParameter("orderPriceReal", checkOrder.getOrderPriceReal());
            query.setParameter("orderOther", checkOrder.getOrderOther());
            query.setParameter("orderId", checkOrder.getOrderId());

            int n = query.executeUpdate();

            if (n==1) {
                ret = true;
            } else {
                ret = false;
            }

            commitTransaction();
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
    public List<TableOrderEntity> getWaitingOrderList() {
        List<TableOrderEntity> list;

        initHibernate();

        Query<TableOrderEntity> query = session.createQuery("from TableOrderEntity where orderStatus = :orderStatus");
        query.setParameter("orderStatus", "waiting");
        list = query.list();
        closeFinally();

        return list;
    }

    @Override
    public List<TableOrderEntity> getHistoryOrderList() {
        List<TableOrderEntity> list;

        initHibernate();

        Query<TableOrderEntity> query = session.createQuery("from TableOrderEntity where orderStatus = :orderStatus");
        query.setParameter("orderStatus", "check");
        list = query.list();
        closeFinally();

        return list;
    }
}
