import spark.Spark;

public class main {
    public static void main(String[] args) {
        Spark.get("/ping", (request, response) -> "pong");
    }
}
