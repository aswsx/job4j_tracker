package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.model.City;

import java.util.List;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 08/08/2022 - 21:37
 */
public class CityStore {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public City create(City city) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public List<City> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<City> result = session.createQuery("from City").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
