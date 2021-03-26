package com.coolapk.market.util;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ0\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/util/ActivityResultAdapter;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "currentReqCode", "", "requests", "Landroid/util/SparseArray;", "Lkotlin/Function2;", "Landroid/content/Intent;", "", "Lcom/coolapk/market/util/ActivityResultCallback2;", "onActivityResult", "", "requestCode", "resultCode", "data", "startActivityForResult", "i", "callback", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActivityResultAdapter.kt */
public final class ActivityResultAdapter {
    public static final Companion Companion = new Companion(null);
    private static final int REQUEST_CODE_START = 16328;
    private final Activity activity;
    private int currentReqCode = REQUEST_CODE_START;
    private final SparseArray<Function2<Integer, Intent, Unit>> requests = new SparseArray<>();

    public ActivityResultAdapter(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/util/ActivityResultAdapter$Companion;", "", "()V", "REQUEST_CODE_START", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ActivityResultAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void startActivityForResult(Intent intent, Function2<? super Integer, ? super Intent, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        int i = this.currentReqCode + 1;
        this.currentReqCode = i;
        this.requests.put(i, function2);
        this.activity.startActivityForResult(intent, this.currentReqCode);
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        Function2<Integer, Intent, Unit> function2 = this.requests.get(i);
        if (function2 == null) {
            return false;
        }
        function2.invoke(Integer.valueOf(i2), intent);
        this.requests.remove(i);
        return true;
    }
}
