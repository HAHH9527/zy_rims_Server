package cn.hnkjxy.zy.rims.db.dao.test;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 10248
 */
public class StoreDishData extends HibernateUtils {

    @Test
    public void testStoreDishData() {

        //初始化
        openSession();

        //创建事务对象
        transaction = session.beginTransaction();

        TDishEntity dishEntity = new TDishEntity();
        dishEntity.setDishName("炒肉");
        dishEntity.setDishPrice(28.00);

        //持久化对象
        session.persist(dishEntity);

        //提交事务
        transaction.commit();

        //关闭session
        closeSession();

        System.out.println("successfully saved");
    }
}
