package db.dao;

import db.EntityManagerHelper;
import entities.Persona;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    public static void save(Persona persona){
        EntityManagerHelper.beginTransaction();

            EntityManagerHelper.getEntityManager().persist(persona);

        EntityManagerHelper.commit();
    }
    public static Persona findById(int id){
        return EntityManagerHelper.getEntityManager().find(Persona.class, id);
    }

    public static List<Persona> findAll(){
        EntityManagerHelper.beginTransaction();
            Query query = EntityManagerHelper.getEntityManager().createQuery("SELECT p FROM persona p");
            List<Persona> personas = new ArrayList<>();
            personas = query.getResultList();
            return personas;
    }

    public static Long findByDni(int dni){
        String query = "SELECT COUNT(*) FROM persona p INNER JOIN dni d ON p.persona_dni = d.id WHERE d.dni_nro = " + dni;
        return (Long) EntityManagerHelper.getEntityManager().createNativeQuery(query).getSingleResult();
    }
}
