package hibernate.demo;

import hibernate.domains.Address;
import hibernate.domains.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address currentAddress = new Address();
        currentAddress.setLocation("New Delhi");
        currentAddress.setStreetNumber(131);
        currentAddress.setState("Delhi");

        Address permanent = new Address();
        permanent.setLocation("Mumbai");
        permanent.setStreetNumber(1314);
        permanent.setState("Maharastra");
        Set<String> subjects = new LinkedHashSet<String>();
        subjects.add("Groovy");
        subjects.add("Java");
        subjects.add("JavaScript");

        Author author1 = new Author();
        author1.setId(1);
        author1.setAge(20);
        author1.setFirstName("Amit");
        author1.setLastName("Dubey");
        author1.setDob(new Date());
        author1.setCurrentAddress(currentAddress);
        author1.setPermanentAddress(permanent);
        author1.setSubjects(subjects);
        session.save(author1);
        session.getTransaction().commit();
        session.close();
    }
}
