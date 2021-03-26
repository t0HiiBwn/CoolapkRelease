package com.coolapk.market.manager;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "jsonObject", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
final class AppNotification$handleCloudInstallMessage$2<T> implements Action1<JSONObject> {
    public static final AppNotification$handleCloudInstallMessage$2 INSTANCE = new AppNotification$handleCloudInstallMessage$2();

    AppNotification$handleCloudInstallMessage$2() {
    }

    public final void call(JSONObject jSONObject) {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Application application2 = application;
        Toast.show$default(application2, application2.getString(2131887057, jSONObject.optString("title")), 0, false, 12, null);
    }
}
