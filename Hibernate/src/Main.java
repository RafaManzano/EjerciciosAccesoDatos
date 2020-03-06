import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        PersistenciaSeguro pers = new PersistenciaSeguro();
        try {
            /*
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
            */
            System.out.println("Introduciendo un nuevo seguro");
            pers.insertSeguro(session, new Seguro(3, "1a1s", "Rafa", "Manzano", "Medina", 24,1, new Date(2020, Calendar.MARCH,3)));
            System.out.println("Eliminamos al seguro 2");
            pers.deleteSeguro(session, 2);
        } finally {
            session.close();
        }
    }
}