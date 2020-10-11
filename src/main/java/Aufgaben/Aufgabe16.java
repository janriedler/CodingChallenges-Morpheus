package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Aufgabe16 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(16);
        //JSONObject jsonObject = new JSONObject("{\"list\":[27,199,58,47,109,179,67,202,59,221,204,52,230,89,228,66]}");
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        JSONArray arr = jsonObject.getJSONArray("list");
        int[] zahlen = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            zahlen[i] = arr.getInt(i);
        }
        Arrays.sort(zahlen);
        System.out.println(Arrays.toString(zahlen));
        int count = 1;
        for (int i = 0; i < zahlen.length - 1; i++) {
            boolean check = true;
            int tmp = 1;
            while (check) {
                if (zahlen[i + 1] == zahlen[i] + 1) {
                    tmp++;
                    i++;
                }
                else check = false;
                if (i+1 == zahlen.length) break;
            }
            if (tmp > count) count = tmp;
        }
        System.out.println(count);
        Post.send(Json.create(count), 16);
    }
}
