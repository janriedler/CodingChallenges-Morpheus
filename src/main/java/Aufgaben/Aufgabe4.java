package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aufgabe4 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(4);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        int k = jsonObject.getInt("k");

        JSONArray arr = jsonObject.getJSONArray("list");
        String[] zahlen = new String[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getString(i);
        }
        List<String> rotiert = Arrays.asList(zahlen);
        for (int i = 0; i < k; i++) {
            //Collections.rotate(rotiert,1);    Das wäre die perfekte Lösung, aber halt nicht selber
            String prev = rotiert.get(0);
            rotiert.set(0, rotiert.get(rotiert.size() - 1));
            for (int j = 0; j < rotiert.size() - 1; j++) {
                String next = rotiert.get(j + 1);
                rotiert.set(j + 1, prev);
                prev = next;

            }
        }
        String[] rotiertArr = rotiert.toArray(new String[0]);
        for (int i = 0; i < rotiertArr.length; i++) {
            System.out.print(rotiertArr[i] + " ");
        }
        System.out.println();
        Post.send(Json.create(rotiertArr), 4);
    }
}
