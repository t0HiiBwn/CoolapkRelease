package com.coolapk.market.view.base;

import android.app.Activity;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/base/CopyUserActionItem;", "Lcom/coolapk/market/view/base/CopyActionItem;", "userName", "", "(Ljava/lang/String;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public final class CopyUserActionItem extends CopyActionItem {
    /* JADX WARNING: Illegal instructions before constructor call */
    public CopyUserActionItem(String str) {
        super(r0, '@' + str + ' ');
        String str2;
        Intrinsics.checkNotNullParameter(str, "userName");
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity != null) {
            str2 = currentActivity.getString(2131886776, new Object[]{'@' + str + ' '});
        } else {
            str2 = null;
        }
        str2 = str2 == null ? "" : str2;
    }
}
