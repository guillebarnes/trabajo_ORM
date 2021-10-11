package entities;

import entities.estados.Confirmada;
import entities.estados.Pendiente;
import entities.estados.Rechazada;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_dni", referencedColumnName = "id", nullable = false)
    private Dni dni;

    @Column(name = "usuario_nombre", nullable = false)
    private String nombre;

    @Column(name = "usuario_apellido", nullable = false)
    private String apellido;

    @Column(name = "usuario_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @OneToOne
    @JoinColumn(name = "usuario_ciudad", referencedColumnName = "id", nullable = true)
    private Ciudad ciudad;

    @OneToOne
    @JoinColumn(name = "usuario_localidad", referencedColumnName = "id", nullable = true)
    private Ciudad localidad;

    //revisar
    @Transient
    private String foto;

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "delegacion_persona")
    private List<Delegacion> delegados = new ArrayList<>();

    public Persona(Dni dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId(){
        return this.id;
    }

    public Dni getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Ciudad localidad) {
        this.localidad = localidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Delegacion> getDelegados() {
        return delegados;
    }

    public void setDelegados(List<Delegacion> delegados) {
        this.delegados = delegados;
    }

    public void agregarDelegado(Persona persona){
        this.delegados.add(new Delegacion(persona, new Pendiente()));
        //persona debe confirmar la delegacion
    }
    public void confirmarDelegacion(Delegacion delegacion){
        delegacion.setEstado(new Confirmada());
    }
    public void rechazarDelegacion(Delegacion delegacion){
        delegacion.setEstado(new Rechazada());
    }
}
