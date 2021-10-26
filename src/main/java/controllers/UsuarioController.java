package controllers;

import db.dao.PersonaDAO;
import db.dao.UsuarioDAO;
import entities.Persona;
import entities.Usuario;
import spark.Request;
import spark.Response;
import spark.Spark;

public class UsuarioController {
    public static void definePaths() {
        Spark.get("/", UsuarioController::check);
        Spark.post("/", UsuarioController::registrar);
    }

    public static String check(Request req, Response res) {
        res.type("application/json");

        String usuario = req.queryParams("user");
        String contraseña = req.queryParams("password");

        Long respuesta = UsuarioDAO.usuarioValido(usuario, contraseña);

        res.status(200);
        if (respuesta == 1) {
            return "{\"status\":200, \"msg\":Sesion iniciada correctamente}";
        } else {
            return "{\"status\":200, \"msg\":Usuario o contraseña incorrecta}";
        }
    }

    public static String registrar(Request req, Response res) {
            Persona persona = PersonaDAO.findByDni(Integer.parseInt(req.queryParams("dni")));

            Long respuesta = UsuarioDAO.usuarioValido(req.queryParams("user"), req.queryParams("password"));
            if(respuesta == 1)
                return "{\"status\":200, \"msg\":Ya existe usuario con ese nombre}";
            else{
                if(persona != null) {
                    Usuario usuarioNuevo = new Usuario();
                    usuarioNuevo.setUsuario(req.queryParams("user"));
                    usuarioNuevo.setContrasena(req.queryParams("password"));
                    usuarioNuevo.setAdministrador(false);
                    usuarioNuevo.setDatos(persona);
                    UsuarioDAO.save(usuarioNuevo);
                    return "{\"status\":200, \"msg\":Usuario creado correctamente}";
                }
                else
                    return "{\"status\":200, \"msg\":Usted no se puede registrar porque no se encuentra empadronado con ese dni}";

            }
        }
}
