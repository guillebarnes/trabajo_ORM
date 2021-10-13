import db.EntityManagerHelper;
import db.dao.PersonaDAO;
import db.dao.UsuarioDAO;
import entities.Dni;
import entities.Persona;
import entities.Usuario;
import org.junit.Test;

import java.util.List;

public class EntityManagerTest {

    @Test
    public void pruebaInsert(){
        PersonaDAO.save(new Persona(new Dni("DNI", 99999999), "Roberto", "Carlos"));
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
            System.out.println(p.getNombre());
    }
}
