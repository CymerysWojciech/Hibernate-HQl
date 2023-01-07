package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Employee;

import java.util.List;

public class WhereApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String where = "FROM Employee WHERE salary<3000 OR salary >13000";
        String where1 = "FROM Employee WHERE salary is null ";
        String where2 = "FROM Employee WHERE lastName in ('Hutton','Wiśniewski') ";
        Query query = session.createQuery(where2);
        List<Employee> list = query.getResultList();
        session.getTransaction().commit();
        for(Employee employee: list){
            System.out.println(employee);
        }

        factory.close();
    }
}
