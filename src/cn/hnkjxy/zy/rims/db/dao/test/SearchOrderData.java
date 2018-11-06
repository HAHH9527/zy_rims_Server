package cn.hnkjxy.zy.rims.db.dao.test;

import cn.hnkjxy.zy.rims.bean.dbEntity.TOrderEntity;
import cn.hnkjxy.zy.rims.db.HibernateUtils;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchOrderData extends HibernateUtils {
    @Test
    public void testSearchOrderData() {
        //初始化
        openSession();

        transaction = session.beginTransaction();

        Query<TOrderEntity> query = session.createQuery("from TOrderEntity where tableId=:i");

        query.setParameter("i", "A178");

        List<TOrderEntity> tOrderEntityList = query.list();

        tOrderEntityList.forEach(tOrderEntity -> {
            System.out.println(tOrderEntity.getOrderId());
            System.out.println(tOrderEntity.getTableId());
            System.out.println(tOrderEntity.getDishList());
        });

        closeSession();

        System.out.println("successfully search");

    }
}
