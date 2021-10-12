package controllers;

import db.dao.PersonaDAO;
import db.dao.UsuarioDAO;
import entities.Usuario;
import spark.Request;
import spark.Response;
import spark.Spark;

public class UsuarioController {
    public static void definePaths(){
        Spark.get("/check", UsuarioController::check);
        Spark.post("/registrar", UsuarioController::registrar);
    }

    public static String check(Request req, Response res){
        res.type("application/json");

        String usuario = req.queryParams("user");
        String contraseña = req.queryParams("password");

        Long respuesta = UsuarioDAO.usuarioValido(usuario, contraseña);

        if(respuesta == 1){
            res.status(200);
            return "{\"status\":200, \"msg\":Sesion iniciada correctamente}";
        }

        else{
            res.status(200);
            return "{\"status\":200, \"msg\":Usuario o contraseña incorrecta}";
        }
    }
    public static String registrar(Request req, Response res){
        res.type("application/json");

        String dni = req.queryParams("dni");
        Long respuesta = PersonaDAO.findByDni(Integer.parseInt(dni));
        if(respuesta == 1){
            res.status(200);
            UsuarioDAO.save(new Usuario(req.queryParams("user"), req.queryParams("password"), false));
            return "{\"status\":200, \"msg\":Registro realizado con éxito}";
        }
        else {
            if(respuesta != 1){
                res.status(200);
                return "{\"status\":200, \"msg\":Usted no se encuentra empadronado y no puede registrarse}";
            }
            else{
                res.status(400);
                return "{\"status\":400, \"msg\":Error en el ingreso de datos}";
            }
        }
    }
}
