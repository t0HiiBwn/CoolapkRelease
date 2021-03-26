package com.coolapk.market.manager;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/ServiceApp;", "kotlin.jvm.PlatformType", "jsonObject", "Lorg/json/JSONObject;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
final class AppNotification$handleCloudInstallMessage$3<T, R> implements Func1<JSONObject, Observable<? extends Result<ServiceApp>>> {
    public static final AppNotification$handleCloudInstallMessage$3 INSTANCE = new AppNotification$handleCloudInstallMessage$3();

    AppNotification$handleCloudInstallMessage$3() {
    }

    public final Observable<? extends Result<ServiceApp>> call(JSONObject jSONObject) {
        return DataManager.getInstance().getCloudInstall(jSONObject.optString("id"));
    }
}
