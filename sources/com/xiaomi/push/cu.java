package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;
import org.json.JSONObject;

public class cu extends cw {
    public cu(Context context, int i) {
        super(context, i);
    }

    private String f() {
        Bundle extras;
        StringBuilder sb = new StringBuilder();
        try {
            Intent registerReceiver = this.d.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (!(registerReceiver == null || (extras = registerReceiver.getExtras()) == null)) {
                Set<String> keySet = extras.keySet();
                JSONObject jSONObject = new JSONObject();
                if (keySet != null && keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject.put(str, String.valueOf(extras.get(str)));
                            } catch (Exception unused) {
                            }
                        }
                    }
                    sb.append(jSONObject);
                }
            }
        } catch (Exception unused2) {
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 20;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        return f();
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.Battery;
    }
}
