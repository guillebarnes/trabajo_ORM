import spark.Spark;

public class server {
    public static void main(String[] args) {
        Spark.port(9000);
        Spark.get("/ping", (request, response) -> "pong");
    }
}
