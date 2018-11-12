package cn.hnkjxy.zy.rims.datebase.dao;

import cn.hnkjxy.zy.rims.bean.dbEntity.TOrderEntity;
import cn.hnkjxy.zy.rims.datebase.HibernateUtils;
import cn.hnkjxy.zy.rims.datebase.impl.OrderImpl;

/**
 * @author 10248
 */
public class OrderDao extends HibernateUtils implements OrderImpl {

    @Override
    public int insertNewOrder(TOrderEntity newOrder) {
        return -1;
    }

    @Override
    public TOrderEntity findOrderById(int orderId) {
        return null;
    }

    @Override
    public boolean updateOrderById(TOrderEntity updateOrder) {
        return false;
    }
}
