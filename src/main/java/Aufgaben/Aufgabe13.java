package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe13 {
    public static void main(String[] args) {
        JSONObject jsonObject = Get.aufgabeJson(13);
        //JSONObject jsonObject = new JSONObject("{\"lista\":[9,14,15],\"listb\":[8,15,38,43]}");
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);

        JSONArray arr = jsonObject.getJSONArray("lista");
        int[] lista = new int[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            lista[i] = arr.getInt(i);
        }

        JSONArray arrb = jsonObject.getJSONArray("listb");
        int[] listb = new int[arrb.length()];
        for (int i = 0; i < arrb.length(); ++i) {
            listb[i] = arrb.getInt(i);
        }
        List<Integer> gesamt = new ArrayList<>();
        boolean fertigA = false;
        boolean fertigB = false;
        int zeigerA = 0;
        int zeigerB = 0;
        while (unnötig(zeigerA, lista.length, zeigerB, listb.length)) {
            if (zeigerA == lista.length) fertigA = true;
            if (zeigerB == listb.length) fertigB = true;
            if (!fertigA && !fertigB) {
                if (lista[zeigerA] <= listb[zeigerB]) {
                    gesamt.add(lista[zeigerA]);
                    zeigerA++;
                } else {
                    gesamt.add(listb[zeigerB]);
                    zeigerB++;
                }
            } else if (fertigA && !fertigB) {
                gesamt.add(listb[zeigerB]);
                zeigerB++;
            } else if (!fertigA && fertigB){
                gesamt.add(lista[zeigerA]);
                zeigerA++;
            }
        }


        for (Integer integer : gesamt) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        System.out.println(Json.create(gesamt));
        Post.send(Json.create(gesamt), 13);
    }

    private static boolean unnötig(int zeigera, int sizea, int zeigerb, int sizeb) {
        return zeigera != sizea || zeigerb != sizeb;
    }


}
