package controllers;

import db.dao.UsuarioDAO;
import spark.Request;
import spark.Response;
import spark.Spark;

public class UsuarioController {
    public static void definePaths(){
        Spark.get("/check", UsuarioController::check);
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
}
