package com.coolapk.market.view.center;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
final class CenterUserMenuPresenter$requestSaveMenuDataInServe$2 implements Runnable {
    final /* synthetic */ CenterUserMenuPresenter this$0;

    CenterUserMenuPresenter$requestSaveMenuDataInServe$2(CenterUserMenuPresenter centerUserMenuPresenter) {
        this.this$0 = centerUserMenuPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.saveInServeRunnable = null;
        JSONArray jSONArray = new JSONArray();
        for (String str : StringsKt.split$default((CharSequence) this.this$0.getLastLoadedActivityMenuData(), new String[]{","}, false, 0, 6, (Object) null)) {
            jSONArray.put(str);
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "JSONArray().apply {\n    …\n            }.toString()");
        DataManager.getInstance().updateTitleConfig("my_setting_tab_config", jSONArray2).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
            /* class com.coolapk.market.view.center.CenterUserMenuPresenter$requestSaveMenuDataInServe$2.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(AppHolder.getApplication(), th);
            }
        });
    }
}
