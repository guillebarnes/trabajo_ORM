import controllers.PersonaController;
import controllers.UsuarioController;
import db.dao.UsuarioDAO;
import spark.Spark;

public class server {
    public static void main(String[] args) {
        Spark.port(9090);
        Spark.path("/usuario", UsuarioController::definePaths);
        Spark.path("/persona", PersonaController::definePaths);
    }
}
