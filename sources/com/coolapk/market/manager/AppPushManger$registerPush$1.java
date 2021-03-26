package com.coolapk.market.manager;

import com.coolapk.market.util.LogUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/manager/AppPushManger$registerPush$1", "Lcom/tencent/android/tpush/XGIOperateCallback;", "onFail", "", "p0", "", "p1", "", "p2", "", "onSuccess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppPushManger.kt */
public final class AppPushManger$registerPush$1 implements XGIOperateCallback {
    final /* synthetic */ AppPushManger this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppPushManger$registerPush$1(AppPushManger appPushManger) {
        this.this$0 = appPushManger;
    }

    @Override // com.tencent.android.tpush.XGIOperateCallback
    public void onFail(Object obj, int i, String str) {
        LogUtils.d("TPush onFail", new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGIOperateCallback
    public void onSuccess(Object obj, int i) {
        this.this$0.isRegistered = true;
        this.this$0.registerUserAccount();
    }
}
