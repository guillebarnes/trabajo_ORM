package entities.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pendiente")
public class Pendiente extends Estado{

    public Pendiente() {
    }

    @Override
    public boolean pendiente() { return true; }

    @Override
    public boolean confirmada() { return false; }

    @Override
    public boolean rechazada() { return false; }
}
