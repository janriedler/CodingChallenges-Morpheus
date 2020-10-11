package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aufgabe9 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(9);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        int k = jsonObject.getInt("k");
        JSONArray arr = jsonObject.getJSONArray("list");
        int[] zahlen = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getInt(i);
        }

        int[] erg = new int[2];
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < zahlen.length - 1; i++) {
            for (int j = i + 1; j < zahlen.length; j++) {
                if (k == zahlen[i] + zahlen[j]) {
                    if (j - i < distance) {
                        distance = j - i;
                        erg[0] = i;
                        erg[1] = j;
                    }
                }
            }
        }
        Post.send(Json.create(erg), 9);
    }
}
