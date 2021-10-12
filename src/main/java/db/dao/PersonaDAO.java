package db.dao;

import db.EntityManagerHelper;
import entities.Persona;

public class PersonaDAO {
    public static void save(Persona persona){
        EntityManagerHelper.beginTransaction();

            EntityManagerHelper.getEntityManager().persist(persona);

        EntityManagerHelper.commit();
    }
    public static Persona findById(int id){
        return EntityManagerHelper.getEntityManager().find(Persona.class, id);
    }
}
