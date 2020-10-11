package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aufgabe12 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(12);
        String jsonString = jsonObject.toString();
        //tring jsonString = "{\"k\":40,\"list\":[8,18,11,36,]}";
        //JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonString);

        int k = jsonObject.getInt("k");

        JSONArray arr = jsonObject.getJSONArray("list");
        int[] zahlen = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getInt(i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < zahlen.length; i++) {
            int summe = 0;
            int count = 0;
            for (int j = i; j < zahlen.length; j++) {
                summe = summe + zahlen[j];
                count++;
                if (summe >= k) {
                    if (count < min) {
                        min = count;
                    }
                    break;
                }
            }

        }
        System.out.println("mein Ergebnis: " + min);
        Post.send(Json.create(min), 12);
    }
}
