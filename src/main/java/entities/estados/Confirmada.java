package entities.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("0")
public class Confirmada extends Estado {

    public Confirmada() {
    }

    @Override
    public boolean confirmada() { return true; }

    @Override
    public boolean rechazada() { return false; }

    @Override
    public boolean pendiente() { return false; }
}
