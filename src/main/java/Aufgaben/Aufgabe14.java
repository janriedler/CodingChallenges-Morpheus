package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe14 {
    static List<int[]> erg = new ArrayList<>();

    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(14);
        //JSONObject jsonObject = new JSONObject("{\"list\":[[47,53],[32,34],[31,43],[38,52]]}");
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        JSONArray arr = jsonObject.getJSONArray("list");
        for (int i = 0; i < arr.length(); i++) {
            JSONArray intervallJson = arr.getJSONArray(i);
            int[] intervall = new int[2];
            for (int j = 0; j < 2; j++) {
                intervall[j] = intervallJson.getInt(j);
            }
            calc(intervall);
        }
        Collections.sort(erg, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int i = 0; i < erg.size() - 1; i++) {
            if (erg.get(i)[1] >= erg.get(i+1)[0]) {
                int[] tmp = new int[2];
                tmp[0] = erg.get(i)[0];
                tmp[1] = erg.get(i + 1)[1];
                erg.set(i, tmp);
                erg.remove(i + 1);
                i--;
            }
        }
        System.out.println(Json.create(erg));
        Post.send(Json.create(erg), 14);

    }

    private static void calc(int[] intervall) {
        if (erg.size() == 0) erg.add(intervall);
        else {
            boolean change = false;
            for (int i = 0; i < erg.size(); i++) {
                if (intervall[0] < erg.get(i)[0] && intervall[1] > erg.get(i)[0]) {
                    change = true;
                    if (intervall[1] > erg.get(i)[1]) {
                        erg.set(i, intervall);
                    } else {
                        int[] tmp = new int[2];
                        tmp[0] = intervall[0];
                        tmp[1] = erg.get(i)[1];
                        erg.set(i, tmp);
                    }
                } else if (intervall[1] > erg.get(i)[1] && intervall[0] < erg.get(i)[1]) {
                    change = true;
                    int[] tmp = new int[2];
                    tmp[1] = intervall[1];
                    tmp[0] = erg.get(i)[0];
                    erg.set(i, tmp);
                }
            }
            if (!change) erg.add(intervall);
        }
    }
}
