package cn.hnkjxy.zy.rims.db.impl;

import cn.hnkjxy.zy.rims.bean.dbEntity.TOrderEntity;

/**
 * @author 10248
 */
public interface OrderImpl {

    /**
     * 添加新订单
     *
     * @param newOrder 新订单实体类
     * @return 添加成功返回订单id/失败返回-1
     */
    int insertNewOrder(TOrderEntity newOrder);

    /**
     * 通过订单id查找订单
     *
     * @param orderId 订单id
     * @return 订单实体类(查询不到返回null)
     */
    TOrderEntity findOrderById(int orderId);

    /**
     * 通过订单id更新订单内容
     *
     * @param updateOrder 订单内容
     * @return 更新是否成功
     */
    boolean updateOrderById(TOrderEntity updateOrder);
}
