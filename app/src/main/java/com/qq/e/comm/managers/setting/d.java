package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;

class d extends e {
    d() {
    }

    d(String str) {
        super(str);
    }

    final Object a(String str) {
        return this.a.opt(str);
    }

    final void a(String str, Object obj) {
        try {
            this.a.putOpt(str, obj);
        } catch (JSONException e) {
            GDTLogger.e("Exception while update setting", e);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.a.toString() + "]";
    }
}
