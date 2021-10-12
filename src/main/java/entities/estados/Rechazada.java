package entities.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("rechazada")
public class Rechazada extends Estado{

    public Rechazada() {
    }

    @Override
    public boolean rechazada() { return true; }

    @Override
    public boolean confirmada() { return false; }

    @Override
    public boolean pendiente() { return false; }
}
