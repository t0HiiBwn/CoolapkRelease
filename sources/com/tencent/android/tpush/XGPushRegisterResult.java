package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGPushRegisterResult implements XGIResult {
    long a = 0;
    String b = "";
    String c = "";
    String d = "";
    short e = 0;
    String f = "";
    String g = "";
    int h = 100;

    XGPushRegisterResult() {
    }

    public long getAccessId() {
        return this.a;
    }

    public String getFacilityIdentity() {
        return this.b;
    }

    public String getAccount() {
        return this.c;
    }

    public String getTicket() {
        return this.d;
    }

    public short getTicketType() {
        return this.e;
    }

    public String getToken() {
        return this.f;
    }

    public String getOtherPushToken() {
        return this.g;
    }

    public int getPushChannel() {
        return this.h;
    }

    public String toString() {
        return "TPushRegisterMessage [accessId=" + this.a + ", deviceId=" + this.b + ", account=" + this.c + ", ticket=" + this.d + ", ticketType=" + ((int) this.e) + ", token=" + this.f + ", pushChannel=" + this.h + "]";
    }

    @Override // com.tencent.android.tpush.XGIResult
    public void parseIntent(Intent intent) {
        try {
            this.a = intent.getLongExtra("accId", -1);
            this.b = intent.getStringExtra("deviceId");
            this.c = intent.getStringExtra("account");
            this.d = intent.getStringExtra("ticket");
            this.e = intent.getShortExtra("ticketType", 0);
            this.f = intent.getStringExtra("token");
        } catch (Throwable unused) {
            TLogger.w("XGPushRegisterResult", "unexpected for parseIntent");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account", this.c);
            jSONObject.put("ticket", this.d);
            jSONObject.put("deviceId", this.b);
            jSONObject.put("ticketType", (int) this.e);
            jSONObject.put("token", this.f);
        } catch (Throwable unused) {
            TLogger.w("XGPushRegisterResult", "unexpected for toJson");
        }
        return jSONObject;
    }
}
