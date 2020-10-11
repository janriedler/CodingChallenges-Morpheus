package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aufgabe2a {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(2);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        Long find = jsonObject.getLong("k");

        JSONArray arr = jsonObject.getJSONArray("list");
        for (int i = 0; i < arr.length(); ++i) {
            if (find.equals(arr.getLong(i))) {
                System.out.println("Der gefunde Wert ist an Stelle " + i);
                Post.send(Json.create(i), 2);
            }
        }
    }   
}
        