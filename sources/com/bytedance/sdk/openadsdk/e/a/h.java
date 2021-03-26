package com.bytedance.sdk.openadsdk.e.a;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataConverterActual */
class h {
    private l a;

    static h a(l lVar) {
        return new h(lVar);
    }

    private h(l lVar) {
        this.a = lVar;
    }

    <T> T a(String str, Type type) throws JSONException {
        a(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.a.a(str, type);
    }

    <T> String a(T t) {
        String str;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            str = t.toString();
        } else {
            str = this.a.a(t);
        }
        a(str);
        return str;
    }

    private static void a(String str) {
        if (!str.startsWith("{") || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
        }
    }
}
