import org.hibernate.Session;
import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;

import java.sql.*;
import java.util.Date;

public class PersistenciaSeguro {
    public void insertSeguro(Session sesion, Seguro seguro) {
       sesion.beginTransaction();
       sesion.save(seguro);
       sesion.getTransaction().commit();
    }

    public Seguro getSeguro(Session sesion, int idSeguro) {
        Seguro seguro = (Seguro)sesion.get(Seguro.class, idSeguro);
        return seguro;
    }

    public void updateSeguro(Session sesion, Seguro seguro) {
        sesion.beginTransaction();

        sesion.update(seguro);

        sesion.getTransaction().commit();
    }

    public void deleteSeguro(Session sesion, int idSeguro) {
        sesion.beginTransaction();
        Seguro seguro = getSeguro(sesion, idSeguro);
        sesion.delete(seguro);

        sesion.getTransaction().commit();
    }
}
