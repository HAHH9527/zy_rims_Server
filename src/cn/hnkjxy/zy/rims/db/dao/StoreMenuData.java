package cn.hnkjxy.zy.rims.db.dao;

import cn.hnkjxy.zy.rims.bean.TMenuEntity;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class StoreMenuData extends HibernateUtils {

    @Test
    public void testStoreMenuData() {

        //初始化
        openSession();

        //创建事务对象
        transaction = session.beginTransaction();

        TMenuEntity menuEntity = new TMenuEntity();
        menuEntity.setDishName("炒肉");
        menuEntity.setDishPrice(new BigDecimal(28));

        //持久化对象
        session.persist(menuEntity);

        //提交事务
        transaction.commit();

        //关闭session
        closeSession();

        System.out.println("successfully saved");
    }
}
