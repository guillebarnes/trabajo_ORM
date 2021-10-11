package entities.estados;

import javax.persistence.*;

@Entity
@Table(name = "estado")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "estado_tipo")
public abstract class Estado {
    @Id
    @GeneratedValue
    private int id;

    public Estado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract boolean confirmada();
    public abstract boolean rechazada();
    public abstract boolean pendiente();
}
