package Aufgaben;
import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.apache.log4j.BasicConfigurator;

public class Aufgabe1 {
    public static void main(String[] args) {
        String value = Get.aufgabeString(1);
        Post.send(Json.create(value), 1);
    }
}
