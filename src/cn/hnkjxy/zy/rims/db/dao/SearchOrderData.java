package cn.hnkjxy.zy.rims.db.dao;

import cn.hnkjxy.zy.rims.bean.TOrderEntity;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchOrderData extends HibernateUtils {
    @Test
    public void testSearchOrderData() {
        //初始化
//        Configuration configuration = new Configuration();
//        //设置配置文件
//        configuration.configure("hibernate.cfg.xml");
//
//        //创建session工厂
//        SessionFactory factory = configuration.buildSessionFactory();
//
//        //创建session对象
//        Session session = factory.openSession();
//
//        //创建事务对象
//        Transaction transaction = session.beginTransaction();

        startDBManager();

        transaction = session.beginTransaction();

        Query<TOrderEntity> query = session.createQuery("from TOrderEntity where tableId=:i");

        query.setParameter("i","A178");

        List<TOrderEntity> tOrderEntityList = query.list();

        tOrderEntityList.forEach(tOrderEntity -> {
            System.out.println(tOrderEntity.getOrderId());
            System.out.println(tOrderEntity.getTableId());
            System.out.println(tOrderEntity.getDishList());
        });

//        session.close();
        closeSession();

        System.out.println("successfully search");

    }
}
