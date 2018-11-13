package cn.hnkjxy.zy.rims.datebase.dao;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;
import cn.hnkjxy.zy.rims.datebase.HibernateUtils;
import cn.hnkjxy.zy.rims.datebase.impl.OrderImpl;

/**
 * @author 10248
 */
public class OrderDao extends HibernateUtils implements OrderImpl {

    @Override
    public int insertNewOrder(TableOrderEntity newOrder) {
        return -1;
    }

    @Override
    public TableOrderEntity findOrderById(int orderId) {
        return null;
    }

    @Override
    public boolean updateOrderById(TableOrderEntity updateOrder) {
        return false;
    }
}
