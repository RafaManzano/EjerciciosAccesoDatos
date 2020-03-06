import clase.AsistenciaMedica;
import clase.Seguro;
import org.hibernate.Session;

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

    public void insertAsistenciaMedica(Session sesion, AsistenciaMedica asistenciaMedica) {
        sesion.beginTransaction();
        sesion.save(asistenciaMedica);
        sesion.getTransaction().commit();
    }

    public AsistenciaMedica getAsistenciaMedica(Session sesion, int idAsistenciaMedica) {
        AsistenciaMedica asistenciaMedica = (AsistenciaMedica)sesion.get(AsistenciaMedica.class, idAsistenciaMedica);
        return asistenciaMedica;
    }

    public void updateAsistenciaMedica(Session sesion, AsistenciaMedica asistenciaMedica) {
        sesion.beginTransaction();

        sesion.update(asistenciaMedica);

        sesion.getTransaction().commit();
    }

    public void deleteAsistenciaMedica(Session sesion, int idAsistenciaMedica) {
        sesion.beginTransaction();
        AsistenciaMedica asistenciaMedica = getAsistenciaMedica(sesion, idAsistenciaMedica);
        sesion.delete(asistenciaMedica);

        sesion.getTransaction().commit();
    }
}
