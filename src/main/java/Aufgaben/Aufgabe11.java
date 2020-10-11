package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;

import java.util.Stack;

public class Aufgabe11 {
    public static void main(String[] args) {
        String aufgabe = Get.aufgabeString(11);
        System.out.println(aufgabe);
        char[] split = aufgabe.toCharArray();
        System.out.println("Das Ergebnis ist: " + check(split));
        Post.send(Json.create(check(split)), 11);
    }

    private static boolean check(char[] split) {
        Stack<Character> offene = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i] == '(') {
                offene.add(split[i]);
            } if (split[i] == ')') {
                if (offene.size() == 0) {
                    return false;
                } else {
                    offene.pop();
                }
            }
        }
        if (offene.size() == 0) return true;
        else return false;
    }


}
