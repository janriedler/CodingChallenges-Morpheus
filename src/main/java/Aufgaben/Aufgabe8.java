package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aufgabe8 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(8);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        int k = jsonObject.getInt("k");
        JSONArray arr = jsonObject.getJSONArray("list");
        int[] zahlen = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getInt(i);
        }

        int[] erg = new int[4];
        test: for (int i = 0; i < zahlen.length - 3; i++) {
            for (int j = i + 1; j < zahlen.length - 2; j++) {
                for (int l = j + 1; l < zahlen.length - 1; l++) {
                    for (int m = l + 1; m < zahlen.length; m++) {
                        if (k == zahlen[i] + zahlen[j] + zahlen[l] + zahlen[m]) {
                            erg[0] = i;
                            erg[1] = j;
                            erg[2] = l;
                            erg[3] = m;
                            System.out.println(Json.create(erg));
                            Post.send(Json.create(erg), 8);
                            break test;
                        }
                    }
                }
            }
        }
    }
}
