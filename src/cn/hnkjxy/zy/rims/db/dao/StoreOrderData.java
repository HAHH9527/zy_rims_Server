package cn.hnkjxy.zy.rims.db.dao;

import cn.hnkjxy.zy.rims.bean.TOrderEntity;
import cn.hnkjxy.zy.rims.bean.json.OrderDishList_json;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class StoreOrderData extends HibernateUtils {
    @Test
    public void testStoreOrderData() {
        openSession();

        TOrderEntity orderEntity = new TOrderEntity();
        orderEntity.setDishList(creatJson());

        //持久化对象
        session.persist(orderEntity);

        //提交事务
        transaction.commit();

        //关闭session
        closeSession();

        System.out.println("successfully saved");
    }

    @Test
    public String creatJson() {
        Gson gson = new Gson();

        OrderDishList_json json = new OrderDishList_json();
        json.setDishList(new int[]{1, 2, 3});

        String jsonStr = gson.toJson(json);

        System.out.println(jsonStr);

        return jsonStr;
    }
}
