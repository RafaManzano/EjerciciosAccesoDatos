import clase.AsistenciaMedica;
import clase.Seguro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;
import java.util.Date;

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
            Seguro seguro = new Seguro(311, "12345678Z", "Juan", "Cano", "Morales", 38, 3, new Date());
            pers.insertSeguro(session, seguro);
            AsistenciaMedica asistenciaMedica1=new AsistenciaMedica(311, seguro, "Ir al médico de cabecera por fiebre", "Valencia");
            AsistenciaMedica asistenciaMedica2=new AsistenciaMedica(312, seguro, "Operacion de apendicitis", "Castellón");
            pers.insertAsistenciaMedica(session, asistenciaMedica1);
            pers.insertAsistenciaMedica(session, asistenciaMedica2);
        } finally {
            session.close();
        }
    }
}