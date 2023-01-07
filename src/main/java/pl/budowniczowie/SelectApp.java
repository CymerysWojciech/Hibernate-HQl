package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Employee;

import java.util.List;

public class SelectApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String select = "SELECT firstName, lastName FROM Employee";
        Query query = session.createQuery(select);
        List<Object[]> list = query.getResultList();
        session.getTransaction().commit();
        for (Object[] value:list) {
            System.out.println(value[0]+" "+value[1]);
        }

        factory.close();
    }
}
