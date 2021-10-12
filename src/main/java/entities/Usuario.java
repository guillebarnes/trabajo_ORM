package entities;

import javax.persistence.*;

@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "usuario_nombre", unique = true)
    private String usuario;

    @Column(name = "usuario_password")
    private String contrasena;

    @Column(name = "usuario_permiso")
    private boolean administrador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_persona", referencedColumnName = "id")
    private Persona datos;

    public Usuario(String usuario, String contrasena, boolean administrador) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.administrador = administrador;
    }

    public Usuario() {
    }

    public int getId(){ return this.id; }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Persona getDatos() {
        return datos;
    }

    public void setDatos(Persona datos) {
        this.datos = datos;
    }
}
