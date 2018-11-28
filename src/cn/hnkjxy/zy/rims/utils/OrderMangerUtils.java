package cn.hnkjxy.zy.rims.utils;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;
import cn.hnkjxy.zy.rims.bean.json.DishListJson;
import cn.hnkjxy.zy.rims.datebase.dao.OrderDao;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * @author 10248
 */
public class OrderMangerUtils {
    private static List<TableOrderEntity> waitingOrderList;
    private static Map<Integer, Double> dishPriceMap;
    private static String waitingOrderListJson;

    /**
     * 新建订单
     *
     * @param tableOrderEntity 新订单实体类
     * @return 新建成功返回订单id/失败返回-1
     */
    public static int newOrder(TableOrderEntity tableOrderEntity) {
        int ret;

        calculateOrder(tableOrderEntity);
        ret = new OrderDao().insertNewOrder(tableOrderEntity);

        updateWaitingOrderList();

        return ret;
    }

    /**
     * 更新订单信息
     *
     * @param tableOrderEntity 得到的更新内容
     * @return 更新成功或者失败
     */
    public static boolean updateOrder(TableOrderEntity tableOrderEntity) {
        boolean ret;

        calculateOrder(tableOrderEntity);
        if (tableOrderEntity.getOrderPrice() != null && tableOrderEntity.getOrderDiscount() != null) {
            tableOrderEntity.setOrderPriceReal(tableOrderEntity.getOrderPrice() * tableOrderEntity.getOrderDiscount());
        }

        ret = new OrderDao().updateOrder(tableOrderEntity);

        updateWaitingOrderList();

        return ret;
    }

    /**
     * 计算订单总价和折扣后价格
     * @param tableOrderEntity 需要计算的订单
     */
    public static void calculateOrder(TableOrderEntity tableOrderEntity) {
        List<Integer> dishList = new Gson().fromJson(tableOrderEntity.getDishList(), DishListJson.class).getDishList();
        tableOrderEntity.setOrderPrice(dishList.stream().mapToDouble(id -> dishPriceMap.get(id)).sum());
        tableOrderEntity.setOrderPriceReal(tableOrderEntity.getOrderPrice()
                * tableOrderEntity.getOrderDiscount() == 0 ? 1 : tableOrderEntity.getOrderDiscount());
    }

    /**
     * 更新未完成订单
     */
    public static void updateWaitingOrderList() {
        waitingOrderList = new OrderDao().getWaitingOrderList();
        waitingOrderListJson = new Gson().toJson(waitingOrderList);
    }

    public static void setDishPriceMap(Map<Integer, Double> dishPriceMap) {
        OrderMangerUtils.dishPriceMap = dishPriceMap;
    }

    public static String getWaitingOrderListJson() {
        return waitingOrderListJson;
    }
}
