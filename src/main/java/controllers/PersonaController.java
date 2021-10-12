package controllers;

import com.google.gson.Gson;
import db.dao.PersonaDAO;
import entities.Persona;
import spark.Request;
import spark.Response;
import spark.Spark;

public class PersonaController {
    public static void definePaths(){
        Spark.get("/id", PersonaController::id);
    }

    public static String id(Request req, Response res){
        res.type("application/json");

        Gson gson = new Gson();

        int idRecibido = Integer.parseInt(req.queryParams("id"));

        Persona persona = PersonaDAO.findById(idRecibido);


        res.status(200);

        return gson.toJson(persona);
    }
}
