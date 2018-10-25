package cn.hnkjxy.zy.rims.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author 10248
 */
public class HibernateUtils {
    protected Configuration configuration;
    protected SessionFactory factory;
    protected Session session;
    protected Transaction transaction;

    protected void startDBManager() {
        configuration = new Configuration();

        //设置配置文件
        configuration.configure("hibernate.cfg.xml");

        //创建session工厂
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        factory = configuration.buildSessionFactory();

        //创建session对象
        session = factory.openSession();
    }

    protected void closeSession() {
        //关闭session
        session.close();
    }

}
