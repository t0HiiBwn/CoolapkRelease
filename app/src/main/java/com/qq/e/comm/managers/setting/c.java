package com.qq.e.comm.managers.setting;

import org.json.JSONObject;

final class c extends e {
    c() {
    }

    c(String str) {
        super(str);
    }

    final Object a(String str, String str2) {
        JSONObject optJSONObject = this.a.optJSONObject(str2);
        if (optJSONObject != null) {
            return optJSONObject.opt(str);
        }
        return null;
    }
}
