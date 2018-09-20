import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class basicSports {

    private SessionFactory sessionFactory = null;
    // Creating SessionFactory using 4.2 version of Hibernate
    public void initSessionFactory(){
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory();
        }
    }
    public void persistSports(Sports sport) {
        Transaction tx = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(sport);
            tx.commit();
        }
        catch(HibernateException ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
        finally{
            session.close();
        }
    }
    public static void main(String[] args){
        BasicMovieManager manager = new BasicMovieManager();
        manager.initSessionFactory();

        Sports sport = new Sports();
        sport.setId(7);
        sport.setName("jim");
        sport.setDesc("yas");
        System.out.println(manager);

        persistSports(sport);



    }
}
