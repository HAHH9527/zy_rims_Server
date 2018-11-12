package cn.hnkjxy.zy.rims.datebase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author 10248
 */
public class HibernateUtils {
    private Configuration configuration;
    protected SessionFactory factory;
    protected Session session;
    protected Transaction transaction;

    /**
     * 初始化
     */
    protected void initHibernate() {
        configuration = new Configuration();

        //设置配置文件
        configuration.configure("hibernate.cfg.xml");

        //创建session工厂
        factory = configuration.buildSessionFactory();

        //创建session对象
        session = factory.openSession();

        //创建事务对象
        session.beginTransaction();

        //获取事务对象
        transaction = session.getTransaction();
    }

    /**
     * 提交事务
     */
    protected void commitTransaction() {
        transaction.commit();
    }

    /**
     * 回滚
     */
    protected void rollbackTransaction() {
        transaction.rollback();
    }

    /**
     * 关闭Session
     */
    protected void closeSession() {
        //关闭session
        session.close();
    }

}
