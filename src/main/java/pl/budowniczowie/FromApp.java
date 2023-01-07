package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Employee;

import java.util.List;

public class FromApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String from = "FROM Employee";
        Query query = session.createQuery(from);
        List<Employee> list = query.getResultList();
        session.getTransaction().commit();
        for(Employee employee: list){
            System.out.println(employee);
        }

        factory.close();
    }
}
