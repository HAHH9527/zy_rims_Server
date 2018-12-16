package cn.hnkjxy.zy.rims.datebase.impl;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;

import java.util.List;

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
    int insertNewOrder(TableOrderEntity newOrder);

    /**
     * 通过订单id查找订单
     *
     * @param orderId 订单id
     * @return 订单实体类(查询不到返回null)
     */
    TableOrderEntity findOrderById(int orderId);

    /**
     * 通过订单id更新订单内容
     *
     * @param updateOrder 订单内容
     * @return 更新是否成功
     */
    boolean updateOrder(TableOrderEntity updateOrder);

    /**
     * 结算此订单
     * 因默认的全部更新会更新到其他字段
     * 所以新写一个方法
     *
     * @param checkOrder 结算的订单
     * @return 结算是否成功
     */
    boolean checkOrder(TableOrderEntity checkOrder);

    /**
     * 查找所有未完成订单
     *
     * @return 未完成订单list
     */
    List<TableOrderEntity> getWaitingOrderList();

    /**
     * 查找历史订单
     *
     * @return 历史订单list
     */
    List<TableOrderEntity> getHistoryOrderList();
}
