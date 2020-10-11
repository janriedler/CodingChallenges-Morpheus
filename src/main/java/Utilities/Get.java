package Utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {
    public static String aufgabeString(int aufgabe) {
        try {
            return tryAufgabe(aufgabe);
        } catch (IOException e) {
            return "Fehler bei GET-Request";
        }
    }

    public static JSONObject aufgabeJson(int aufgabe) {
        try {
            JSONObject jsonObject = new JSONObject(aufgabeString(aufgabe));
            return jsonObject;
        }catch (JSONException err) {

        }
        return null;
    }

    private static String tryAufgabe(int aufgabe) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://cc.the-morpheus.de/challenges/" + aufgabe + "/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();

    }
}
