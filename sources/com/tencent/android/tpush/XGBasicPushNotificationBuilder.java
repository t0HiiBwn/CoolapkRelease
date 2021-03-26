package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.util.Pair;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGBasicPushNotificationBuilder extends XGPushNotificationBuilder {
    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    protected void a(JSONObject jSONObject) {
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    protected void b(JSONObject jSONObject) {
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public String getType() {
        return "basic";
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public Pair<Notification, Object> buildNotification(Context context) {
        return a(context);
    }
}
