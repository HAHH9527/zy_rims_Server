package cn.hnkjxy.zy.rims.utils;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;
import cn.hnkjxy.zy.rims.bean.json.CheckOrderJson;
import cn.hnkjxy.zy.rims.bean.json.DishListJson;
import cn.hnkjxy.zy.rims.datebase.dao.OrderDao;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 10248
 */
public class OrderMangerUtils {
    private static List<TableOrderEntity> waitingOrderList;
    private static List<TableOrderEntity> historyOrderList;
    private static Map<Integer, TableOrderEntity> waitingOrderMap;
    private static String waitingOrderListJson;
    private static String historyOrderListJson;

    /**
     * 新建订单
     *
     * @param tableOrderEntity 新订单实体类
     * @return 新建成功返回订单id/失败返回-1
     */
    public static int newOrder(TableOrderEntity tableOrderEntity) {
        int ret;

//        calculateOrder(tableOrderEntity);
        ret = new OrderDao().insertNewOrder(tableOrderEntity);

        updateOrderList();

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

//        calculateOrder(tableOrderEntity);
        if (tableOrderEntity.getOrderPrice() != null && tableOrderEntity.getOrderDiscount() != null) {
            tableOrderEntity.setOrderPriceReal(tableOrderEntity.getOrderPrice() * tableOrderEntity.getOrderDiscount());
        }

        ret = new OrderDao().updateOrder(tableOrderEntity);

        updateOrderList();

        return ret;
    }

    public static String getOrderToCheck(int orderId) {
        CheckOrderJson checkOrderJson = new CheckOrderJson();
        checkOrderJson.setTableOrderEntity(waitingOrderMap.get(orderId));

        DishListJson dishIdListJson = new Gson().fromJson(checkOrderJson.getDishList(), DishListJson.class);

        dishIdListJson.getDishList().forEach(i -> checkOrderJson.addList(MenuMangerUtils.getDishMap().get(i)));

        return new Gson().toJson(checkOrderJson);
    }

    /**
     * 更新订单
     */
    public static void updateOrderList() {
        updateWaitingOrderList();
        updateHistoryOrderList();
    }

    /**
     * 更新未完成订单
     */
    private static void updateWaitingOrderList() {
        waitingOrderList = new OrderDao().getWaitingOrderList();
        waitingOrderListJson = new Gson().toJson(waitingOrderList);

        waitingOrderMap = waitingOrderList.stream().collect(
                Collectors.toMap(TableOrderEntity::getOrderId, Function.identity(), (oldValue, newValue) -> newValue)
        );
    }

    /**
     * 更新历史订单
     */
    private static void updateHistoryOrderList() {
        historyOrderList = new OrderDao().getHistoryOrderList();
        historyOrderListJson = new Gson().toJson(historyOrderList);
    }

    public static String getWaitingOrderListJson() {
        return waitingOrderListJson;
    }

    public static String getHistoryOrderListJson() {
        return historyOrderListJson;
    }
}
