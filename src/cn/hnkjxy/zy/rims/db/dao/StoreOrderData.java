package cn.hnkjxy.zy.rims.db.dao;

import cn.hnkjxy.zy.rims.bean.TOrderEntity;
import cn.hnkjxy.zy.rims.bean.json.OrderDishList_json;
import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class StoreOrderData {
    @Test
    public void testStoreOrderData() {
        Configuration configuration = new Configuration();
        //设置配置文件
        configuration.configure("hibernate.cfg.xml");

        //创建session工厂
        SessionFactory factory = configuration.buildSessionFactory();

        //创建session对象
        Session session = factory.openSession();

        //创建事务对象
        Transaction transaction = session.beginTransaction();
//        startDBManager();

        TOrderEntity orderEntity = new TOrderEntity();
        orderEntity.setDishList(creatJson());

        //持久化对象
        session.persist(orderEntity);

        //提交事务
        transaction.commit();

        //关闭session
//        closeSession();
        session.close();

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
