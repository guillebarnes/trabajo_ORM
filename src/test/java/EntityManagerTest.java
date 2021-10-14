import db.EntityManagerHelper;
import db.dao.PersonaDAO;
import db.dao.UsuarioDAO;
import entities.Ciudad;
import entities.Dni;
import entities.Persona;
import entities.Usuario;
import org.hibernate.Hibernate;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.util.Date;
import java.util.List;

public class EntityManagerTest {

    @Test
    public void pruebaInsert(){
        Persona persona = new Persona(new Dni("DNI", 33333333), "Macarena", "Gomez");
        persona.setCiudad(new Ciudad("Buenos Aires"));
        persona.setLocalidad(new Ciudad("Moreno"));
        persona.setFechaNac(new Date("8/18/1995"));
        PersonaDAO.save(persona);
    }

    @Test
    public void pruebaUser(){
        Usuario userPrueba = new Usuario("guillebarnes", "dds_2021", false);
        userPrueba.setDatos(new Persona(new Dni("DNI", 39340406), "Guillermo", "Barnes"));
        UsuarioDAO.save(userPrueba);
    }

    @Test
    public void pruebaUserValido(){
        System.out.println(UsuarioDAO.usuarioValido("guillebarnes", "dds_2021"));
    }
    @Test
    public void encontrarPersonaPorId(){
        Persona personaEncontrada = PersonaDAO.findById(2);
        System.out.println(personaEncontrada.getId() + " " + personaEncontrada.getNombre() + " " + personaEncontrada.getApellido() + " " +personaEncontrada.getDni().getNroDni());
    }
    @Test
    public void pruebaTodasLasPersonas(){
        List<Persona> personas = PersonaDAO.findAll();

        for(Persona p : personas)
            System.out.println(p.getNombre() + p.getDni().getNroDni());
    }
    @Test
    public void registrar() {
        try{
            Persona p = PersonaDAO.findByDni(39340409);
            System.out.println(p.getNombre());
        }
        catch(Exception e){
            System.out.println("No se encontro persona con ese dni");
        }
    }

    @Test
    public void actualizarDatos(){
        Persona persona = PersonaDAO.findById(1);
        persona.setCiudad(new Ciudad("Buenos Aires"));
        persona.setCiudad(new Ciudad("Moreno"));
        persona.setFechaNac(new Date(12/15/1995));
        PersonaDAO.actualizarDatos(persona);
    }
}
