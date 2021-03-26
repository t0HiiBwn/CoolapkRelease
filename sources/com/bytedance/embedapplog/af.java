package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

class af extends u {
    private final Context e;

    af(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        aa.a(jSONObject, "access", bl.b(this.e));
        return true;
    }
}
