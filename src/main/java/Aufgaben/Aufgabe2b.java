package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aufgabe2b {
    //Url in Get muss ..sorted/ hinzugefügt werden

    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(2);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        long find = jsonObject.getLong("k");

        JSONArray arr = jsonObject.getJSONArray("list");

        int i = 0;
        boolean running = true;
        int end = arr.length();
        int middle = arr.length() / 2;
        while (running) {
            int erg = Long.compare(find, arr.getLong(middle));
            if (erg == 0) {
                i = middle;
                running = false;
            } else if (erg < 0) {
                end = middle;
                middle = middle / 2;
            } else {
                middle = (middle + end) /2;
            }
        }
        System.out.println("Die Position ist: " + i);
        Post.send(Json.create(i), 2);

    }
}
