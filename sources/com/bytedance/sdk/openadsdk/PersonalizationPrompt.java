package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonalizationPrompt {
    private String a;
    private String b;

    public static PersonalizationPrompt parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        PersonalizationPrompt personalizationPrompt = new PersonalizationPrompt();
        personalizationPrompt.b(optString);
        personalizationPrompt.a(optString2);
        return personalizationPrompt;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("url", getUrl());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String getUrl() {
        return this.b;
    }

    private void a(String str) {
        this.b = str;
    }

    public String getName() {
        return this.a;
    }

    private void b(String str) {
        this.a = str;
    }
}
