package com.coolapk.market.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GsonUtils {
    public static String optString(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsString();
    }

    public static Long optLong(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return Long.valueOf(jsonElement.getAsLong());
    }

    public static Integer optInt(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return Integer.valueOf(jsonElement.getAsInt());
    }
}
