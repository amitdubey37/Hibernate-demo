package hibernate.demo;

import hibernate.domains.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author1 = new Author();
        author1.setId(1);
        author1.setAge(20);
        author1.setFirstName("Amit");
        author1.setLastName("Dubey");
        author1.setDob(new Date());
        session.save(author1);
        session.getTransaction().commit();
        session.close();
    }
}
