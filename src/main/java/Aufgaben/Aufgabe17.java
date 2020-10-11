package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class Aufgabe17 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(17);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        JSONArray arr = jsonObject.getJSONArray("list");
        int[] zahlen = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getInt(i);
        }
        Arrays.sort(zahlen);
        boolean erg = false;
        for (int i = 0; i < zahlen.length - 1; i++) {
            if (zahlen[i] == zahlen[i+1]) erg = true;
        }

        Post.send(Json.create(erg), 17);
    }
}
