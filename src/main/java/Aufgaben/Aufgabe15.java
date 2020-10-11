package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class Aufgabe15 {
    public static void main(String[] args) {
        String zeile = Get.aufgabeJson(15).getString("word");
        System.out.println(zeile);
        String[] split = zeile.split("[^a-zA-Z0-9]");
        List<Character> buchstaben = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            char[] tmp = split[i].toLowerCase().toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] != '.' || tmp[j] != '\'' || tmp[j] != ',') buchstaben.add(tmp[j]);
            }
        }
        boolean erg = true;
        for (int i = 0; i < buchstaben.size(); i++) {
            System.out.print(buchstaben.get(i) + " ");
            if (buchstaben.get(i) != buchstaben.get(buchstaben.size() - 1 - i)) erg = false;
        }
        System.out.println();
        System.out.println(Json.create(erg));
        Post.send(Json.create(erg), 15);
    }
}
