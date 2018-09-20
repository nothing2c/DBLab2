import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by t00036478 on 08/02/2018.
 */
public class TestAutoCreate {
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
        public void persistTrade(Trade trade) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(trade);
            session.getTransaction().commit();
        }

        private void findMovie(int movieId) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = (Movie)session.load(Movie.class, movieId);
            System.out.println("Movie:"+movie.getDirector());
            session.getTransaction().commit();
    }

    private void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("from Movie").list();
        session.getTransaction().commit();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i).getTitle());
        }
    }

    public static void main(String[] args){
            TestAutoCreate manager = new TestAutoCreate();
            manager.initSessionFactory();

            manager.findMovie(6);

            manager.findAll();

            /*
            Trade trade = new Trade();
            trade.setTradeId(1233);
            trade.setQuantity(20.0);
            trade.setSecurity("not secure");
            System.out.println(trade);

            manager.persistTrade(trade);*/
        }
    }

