package entities;

public class Usuario {
    private String usuario;
    private String contrasena;
    private boolean administrador;
    private Persona datos;

    public Usuario(String usuario, String contrasena, boolean administrador) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.administrador = administrador;
    }

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
