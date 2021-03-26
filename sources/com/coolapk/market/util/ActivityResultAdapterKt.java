package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002*2\u0010\u0003\"\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"findActivityResultAdapter", "Lcom/coolapk/market/util/ActivityResultAdapter;", "Landroid/content/Context;", "ActivityResultCallback2", "Lkotlin/Function2;", "", "Landroid/content/Intent;", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ActivityResultAdapter.kt */
public final class ActivityResultAdapterKt {
    public static final ActivityResultAdapter findActivityResultAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$findActivityResultAdapter");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (!(activityNullable instanceof BaseActivity)) {
            activityNullable = null;
        }
        BaseActivity baseActivity = (BaseActivity) activityNullable;
        if (baseActivity != null) {
            return baseActivity.getActivityResultAdapter();
        }
        return null;
    }
}
