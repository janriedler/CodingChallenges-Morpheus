package Aufgaben;

import Utilities.Get;
import Utilities.Json;
import Utilities.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//meistens Success, aber selbst in den Kommies steht das manchmal Fehler bei ihm rauskommen, sollte richtig sein
public class Aufgabe5 {
    public static void main(String[] args) {
        String rechnungOrg = Get.aufgabeString(5);
        System.out.println(rechnungOrg);
        String[] splited = rechnungOrg.split("\\s+");
        List<String> rechnung = new ArrayList<>(Arrays.asList(splited));

        while (rechnung.size() > 1) {
            for (int i = 0; i < rechnung.size(); i++) {
                if (!isZahl(rechnung.get(i))) {
                     if (isZahl(rechnung.get(i - 1)) && isZahl(rechnung.get(i - 2))) {
                        double tmp = rechne(rechnung.get(i - 2), rechnung.get(i - 1), rechnung.get(i));
                        rechnung.set(i - 2, String.valueOf(tmp));
                        rechnung.remove(i - 1);
                        rechnung.remove(i - 1);
                        break;
                    } else if (i <= rechnung.size() - 2 && isZahl(rechnung.get(i - 1)) && isZahl(rechnung.get(i + 1))) {
                         double tmp = rechne(rechnung.get(i - 1), rechnung.get(i + 1), rechnung.get(i));
                         rechnung.set(i - 1, String.valueOf(tmp));
                         rechnung.remove(i);
                         rechnung.remove(i);
                         break;
                     }
                }
            }
            for (int i = 0; i < rechnung.size(); i++) {
                System.out.print(rechnung.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println("Double Wert: " + rechnung.get(0));
        int erg = (int) Double.parseDouble(rechnung.get(0));
        System.out.println(Json.create(erg));
        Post.send(Json.create(erg),5);


    }

    private static double rechne(String zahl1, String zahl2, String rechner) {
        double zahlEins = Double.parseDouble(zahl1);
        double zahlZwei = Double.parseDouble(zahl2);
        switch (rechner) {
            case "+":
                return zahlEins + zahlZwei;
            case "*":
                return zahlEins * zahlZwei;
            case "-":
                return zahlEins - zahlZwei;
            default:
                return zahlEins / zahlZwei;
        }
    }

    private static boolean isZahl(String check) {
        return !check.equals("+") && !check.equals("-") && !check.equals("/") && !check.equals("*");
    }
}
