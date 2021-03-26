package com.coolapk.market.view.settings.settingsynch;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "it", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SettingSynchronized.kt */
final class SettingSynchronized$upLoadPostButton$1<T, R> implements Func1<Result<String>, Observable<? extends Result<String>>> {
    public static final SettingSynchronized$upLoadPostButton$1 INSTANCE = new SettingSynchronized$upLoadPostButton$1();

    SettingSynchronized$upLoadPostButton$1() {
    }

    public final Observable<? extends Result<String>> call(Result<String> result) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("POST_BUTTON_SETTING_KEY", "CUSTOM");
        return DataManager.getInstance().updateConfig("system_config", jSONObject.toString());
    }
}
