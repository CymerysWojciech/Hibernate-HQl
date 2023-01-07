package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Employee;

import java.util.List;

public class AggregateFunctionsApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        //        średnia return Double
        String avg = "SELECT avg(e.salary) FROM Employee e";
        //        suma return Long
        String sum = "SELECT sum(e.salary) FROM Employee e";
        //        min return Integer
        String min = "SELECT min(e.salary) FROM Employee e";
        //        max return Integer
        String max = "SELECT max(e.salary) FROM Employee e";
        Query query = session.createQuery(max);
        Integer result = (Integer) query.getSingleResult();
        session.getTransaction().commit();
        System.out.println(result);

        factory.close();
    }
}
