package Utilities;

import org.json.JSONObject;

public class Json {
    public static JSONObject create(Object value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", value);
        return jsonObject;
    }
}
