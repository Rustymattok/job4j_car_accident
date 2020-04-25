package ru.job4j.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.job4j.model.Accident;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
/**
 * Data BAse Hibernate class. All acitivities with Data
 */
public class AccidentRepository implements Store {
    private static  final AccidentRepository INSTANCE = new AccidentRepository();
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private AccidentRepository() {
    }

    public static AccidentRepository getINSTANCE() {
        return INSTANCE;
    }
    /**
     * Function method for lambda.
     * @param command - in description, session and tx.
     * @param <T> -  void or Object.
     * @return - Object or null.
     */
    private <T> T tx(final Function<Session, T> command) {
        final Session session =  factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        }finally {
            session.close();
        }
    }
    @Override
    public void add(Accident accident) {
        this.tx(session -> {
            session.save(accident);
            return null;
        });
    }
    /**
     * Method for parsing table accident
     * @return - all data in list.
     */
    @Override
    public List<Accident> get() {
        List<Accident> list = new LinkedList<>();
        Session session = factory.openSession();
        Query query = session.createQuery("from Accident");
        for (Object acc: query.list()) {
            Accident accident = (Accident) acc;
            list.add(accident);
        }
            session.close();
        return list;
    }
    @Override
    public void remove(Integer id) {
        this.tx(session -> {
            Accident accident = session.get(Accident.class,id);
            session.remove(accident);
            return null;
        });
    }
    @Override
    public void update(Integer id) {

    }
}
