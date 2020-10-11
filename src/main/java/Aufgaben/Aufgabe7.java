package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aufgabe7 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(7);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        int k = jsonObject.getInt("k");
        JSONArray arr = jsonObject.getJSONArray("list");
        int[] zahlen = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getInt(i);
        }

        int[] erg = new int[2];
        test: for (int i = 0; i < zahlen.length - 1; i++) {
            for (int j = i + 1; j < zahlen.length; j++) {
                if (k == zahlen[i] + zahlen[j]) {
                    erg[0] = i;
                    erg[1] = j;
                    Post.send(Json.create(erg), 7);
                    break test;
                }
            }
        }
    }
}
