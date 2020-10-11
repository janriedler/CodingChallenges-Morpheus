package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;

public class Aufgabe10 {
    public static void main(String[] args) {
        String zahl = Get.aufgabeString(10);
        System.out.println(zahl);
        if (zahl.toLowerCase().equals("infinity") || zahl.toLowerCase().equals("inf")){
            Post.send("{\"token\":Infinity}", 10);
        } else if (zahl.contains("e")){
            char[] split = zahl.toCharArray();
            String tmp = "";
            for (int i = 0; i < split.length; i++) {
                if (split[i] == '+') {
                    System.out.println("Ja beginnt mit + ");
                }else if (split[i] != 'e') {
                    tmp = tmp + split[i];
                } else {
                    int e = Integer.parseInt(String.valueOf(split[i + 1]));
                    for (int j = 0; j < e; j++) {
                        tmp = tmp + 0;
                    }
                    break;
                }
            }
            System.out.println("{\"token\":"+ tmp + "}");
            Post.send("{\"token\":"+ tmp + "}", 10);
        } else if (zahl.contains(".")) {
            char[] split = zahl.toCharArray();
            String tmp = "";
            if (split[0] == '.') tmp = "0";
            for (int i = 0; i < split.length; i++) {
                if (split[i] != '+') {
                    tmp = tmp + split[i];
                }
            }
            System.out.println("{\"token\":"+ tmp + "}");
            Post.send("{\"token\":"+ tmp + "}", 10);
        }else {
            float erg = Float.parseFloat(zahl);
            System.out.println(Json.create(erg));
            Post.send(Json.create(erg), 10);
        }
    }
}
