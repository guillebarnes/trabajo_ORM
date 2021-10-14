package entities;

import javax.persistence.*;

@Entity(name = "ciudad")
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ciudad_nombre")
    private String nombre;

    public Ciudad() {
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
