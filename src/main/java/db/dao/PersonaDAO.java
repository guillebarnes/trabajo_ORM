package db.dao;

import db.EntityManagerHelper;
import entities.Persona;

import java.util.ArrayList;
import java.util.Iterator;
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
    public static void findAll(){
        EntityManagerHelper.getEntityManager().createQuery("SELECT id, 'persona_nombre', 'persona_apellido' FROM persona").getResultList();

        //debe retornar la lista de todas las personas registradas.
    }
}
