package db.dao;

import db.EntityManagerHelper;
import entities.Ciudad;
import entities.Persona;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
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

    public static Persona findByDni(int dni){
            List<Persona> personas = PersonaDAO.findAll();
            for(Persona p : personas){
                if(p.getDni().getNroDni() == dni)
                    return p;
            }
            return null;
    }
    public static void actualizarDatos(Persona persona){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().refresh(persona);
        EntityManagerHelper.commit();
    }
}
