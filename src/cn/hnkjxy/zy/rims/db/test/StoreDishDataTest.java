package cn.hnkjxy.zy.rims.db.test;

import cn.hnkjxy.zy.rims.bean.dbEntity.TDishEntity;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 10248
 */
public class StoreDishDataTest extends HibernateUtils {

    @Test
    public void testStoreDishData() {

        //初始化
        initHibernate();

        TDishEntity dishEntity = new TDishEntity();
        dishEntity.setDishName("炒肉");
        dishEntity.setDishPrice(28.00);

        //持久化对象
        session.persist(dishEntity);

        //提交事务
        commitTransaction();

        //关闭session
        closeSession();

        System.out.println("successfully saved");
    }
}
