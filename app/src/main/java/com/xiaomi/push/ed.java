package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import org.json.JSONException;
import org.json.JSONObject;

class ed implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ec f396a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f397a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    ed(ec ecVar, String str, Context context, String str2, String str3) {
        this.f396a = ecVar;
        this.f397a = str;
        this.a = context;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Context context;
        Context context2;
        String str3;
        String str4;
        ec ecVar;
        ee eeVar;
        Context context3;
        if (!TextUtils.isEmpty(this.f397a)) {
            try {
                dy.a(this.a, this.f397a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f397a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.b.equals(optString3)) {
                    if (this.c.equals(optString4)) {
                        if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                            context2 = this.a;
                            str3 = this.f397a;
                            str4 = "A receive a incorrect message with empty type";
                        } else {
                            this.f396a.b(optString3);
                            this.f396a.a(optString4);
                            eb ebVar = new eb();
                            ebVar.b(optString);
                            ebVar.a(optString2);
                            ebVar.a(optInt);
                            ebVar.d(this.f397a);
                            if ("service".equals(optString5)) {
                                if (!TextUtils.isEmpty(optString)) {
                                    ecVar = this.f396a;
                                    eeVar = ee.SERVICE_ACTION;
                                    context3 = this.a;
                                } else {
                                    ebVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                    ecVar = this.f396a;
                                    eeVar = ee.SERVICE_COMPONENT;
                                    context3 = this.a;
                                }
                            } else if (ee.ACTIVITY.f399a.equals(optString5)) {
                                ecVar = this.f396a;
                                eeVar = ee.ACTIVITY;
                                context3 = this.a;
                            } else if (ee.PROVIDER.f399a.equals(optString5)) {
                                ecVar = this.f396a;
                                eeVar = ee.PROVIDER;
                                context3 = this.a;
                            } else {
                                context2 = this.a;
                                str3 = this.f397a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                            ecVar.a(eeVar, context3, ebVar);
                            return;
                        }
                        dy.a(context2, str3, 1008, str4);
                        return;
                    }
                }
                dy.a(this.a, this.f397a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } catch (JSONException e) {
                b.a(e);
                context = this.a;
                str2 = this.f397a;
                str = "A meet a exception when receive the message";
            }
        } else {
            context = this.a;
            str2 = "null";
            str = "A receive a incorrect message with empty info";
            dy.a(context, str2, 1008, str);
        }
    }
}
