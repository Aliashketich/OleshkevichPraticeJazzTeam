package util;

import org.json.JSONObject;

public class httpUtils {
    public static JSONObject getJSONObjectFromResponseContext(StringBuilder responseContext) {
        String string = responseContext.toString();
        string = string.substring(3);
        string = string.substring(0, string.length() - 1);
        return new JSONObject(string);
    }
}
