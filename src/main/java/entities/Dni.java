package entities;

import javax.persistence.*;

@Entity
@Table(name = "dni")
public class Dni {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "dni_tipo")
    private String tipoDni;

    @Column(name = "dni_nro")
    private int nroDni;

    public Dni(String tipoDni, int nroDni) {
        this.tipoDni = tipoDni;
        this.nroDni = nroDni;
    }

    public Dni() {
    }

    public int getId() { return id; }

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public int getNroDni() {
        return nroDni;
    }

    public void setNroDni(int nroDni) {
        this.nroDni = nroDni;
    }
}
