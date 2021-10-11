import db.EntityManagerHelper;
import entities.Dni;
import entities.Persona;
import org.junit.Test;

public class EntityManagerTest {

    @Test
    public void pruebaInsert(){
        EntityManagerHelper.beginTransaction();


        Persona persona = new Persona(new Dni("DNI", 98989899), "Guillermo", "Barnes");

        EntityManagerHelper.getEntityManager().persist(persona);

        EntityManagerHelper.commit();
    }
}
