package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;

import java.util.ArrayList;
import java.util.List;

//Manchmal kommt Java Heap Space Exption, die Zahlen sind zu groß... Sonst stimmt aber

public class Aufgabe6 {
    public static void main(String[] args) {
        long dezimal = Long.parseLong(Get.aufgabeString(6));
        System.out.println(dezimal);

        List<Long> binärsystem = new ArrayList<>();
        long tmp = 1L;
        while (tmp < dezimal) {
            binärsystem.add(tmp);
            tmp = tmp * 2;
        }
        StringBuilder erg = new StringBuilder("");
        long act = 0L;
        while (binärsystem.size() > 0) {
            long test = Long.sum(binärsystem.get(binärsystem.size() - 1), act);
            binärsystem.remove(binärsystem.size() - 1);
            if (test > dezimal) {
                erg.append(0);
            } else {
                act = test;
                erg.append(1);
            }
        }
        System.out.println(erg);
        System.out.println(act);
        Post.send(Json.create(erg.toString()), 6);
    }
}
