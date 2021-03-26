package com.coolapk.market.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lcom/coolapk/market/manager/PushMessage;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
final class AppNotification$handleCloudInstallMessage$1<T, R> implements Func1<PushMessage, JSONObject> {
    public static final AppNotification$handleCloudInstallMessage$1 INSTANCE = new AppNotification$handleCloudInstallMessage$1();

    AppNotification$handleCloudInstallMessage$1() {
    }

    public final JSONObject call(PushMessage pushMessage) {
        try {
            return new JSONObject(pushMessage.component2());
        } catch (JSONException e) {
            RuntimeException propagate = Exceptions.propagate(e);
            Intrinsics.checkNotNullExpressionValue(propagate, "Exceptions.propagate(e)");
            throw propagate;
        }
    }
}
