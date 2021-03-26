package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;

class dk implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ dj e;

    dk(dj djVar, String str, Context context, String str2, String str3) {
        this.e = djVar;
        this.a = str;
        this.b = context;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Context context;
        Context context2;
        String str3;
        String str4;
        dj djVar;
        dl dlVar;
        Context context3;
        if (!TextUtils.isEmpty(this.a)) {
            try {
                df.a(this.b, this.a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.c.equals(optString3)) {
                    if (this.d.equals(optString4)) {
                        if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                            context2 = this.b;
                            str3 = this.a;
                            str4 = "A receive a incorrect message with empty type";
                        } else {
                            this.e.b(optString3);
                            this.e.a(optString4);
                            di diVar = new di();
                            diVar.b(optString);
                            diVar.a(optString2);
                            diVar.a(optInt);
                            diVar.d(this.a);
                            if ("service".equals(optString5)) {
                                if (!TextUtils.isEmpty(optString)) {
                                    djVar = this.e;
                                    dlVar = dl.SERVICE_ACTION;
                                    context3 = this.b;
                                } else {
                                    diVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                    djVar = this.e;
                                    dlVar = dl.SERVICE_COMPONENT;
                                    context3 = this.b;
                                }
                            } else if (dl.ACTIVITY.e.equals(optString5)) {
                                djVar = this.e;
                                dlVar = dl.ACTIVITY;
                                context3 = this.b;
                            } else if (dl.PROVIDER.e.equals(optString5)) {
                                djVar = this.e;
                                dlVar = dl.PROVIDER;
                                context3 = this.b;
                            } else {
                                context2 = this.b;
                                str3 = this.a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                            djVar.a(dlVar, context3, diVar);
                            return;
                        }
                        df.a(context2, str3, 1008, str4);
                        return;
                    }
                }
                df.a(this.b, this.a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } catch (JSONException e2) {
                c.a(e2);
                context = this.b;
                str2 = this.a;
                str = "A meet a exception when receive the message";
            }
        } else {
            context = this.b;
            str2 = "null";
            str = "A receive a incorrect message with empty info";
            df.a(context, str2, 1008, str);
        }
    }
}
