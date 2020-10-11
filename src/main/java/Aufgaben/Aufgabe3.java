package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class Aufgabe3 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(3);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        int kMax = jsonObject.getInt("k");

        JSONArray arr = jsonObject.getJSONArray("list");
        Long[] zahlen = new Long[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getLong(i);
        }
        Arrays.sort(zahlen);
        Post.send(Json.create(zahlen[arr.length() - kMax]), 3);
    }
}
