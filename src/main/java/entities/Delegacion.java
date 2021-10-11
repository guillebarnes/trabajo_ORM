package entities;

import entities.estados.Estado;

import javax.persistence.*;
@Entity
@Table(name="delegacion")
public class Delegacion {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "delegacion_delegado", referencedColumnName = "id")
    private Persona delegado;

    @OneToOne
    @JoinColumn(name = "delegacion_estado", referencedColumnName = "id")
    private Estado estado;

    public Delegacion(Persona delegado, Estado estado) {
        this.delegado = delegado;
        this.estado = estado;
    }

    public Persona getDelegado() {
        return delegado;
    }

    public void setDelegado(Persona delegado) {
        this.delegado = delegado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
