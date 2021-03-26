package com.coolapk.market.view.feed.vote;

import android.app.Activity;
import com.coolapk.market.view.base.ActionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J#\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/feed/vote/DialogBuildingInterceptor;", "T", "", "modifyDataList", "", "dataList", "", "Lcom/coolapk/market/view/base/ActionItem;", "data", "(Ljava/util/List;Ljava/lang/Object;)V", "shouldIntercept", "", "anchorActivity", "Landroid/app/Activity;", "(Ljava/lang/Object;Landroid/app/Activity;)Z", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDialogInterceptor.kt */
public interface DialogBuildingInterceptor<T> {
    void modifyDataList(List<ActionItem> list, T t);

    boolean shouldIntercept(T t, Activity activity);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: FeedDialogInterceptor.kt */
    public static final class DefaultImpls {
        public static <T> boolean shouldIntercept(DialogBuildingInterceptor<T> dialogBuildingInterceptor, T t, Activity activity) {
            Intrinsics.checkNotNullParameter(t, "data");
            return false;
        }

        public static /* synthetic */ boolean shouldIntercept$default(DialogBuildingInterceptor dialogBuildingInterceptor, Object obj, Activity activity, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    activity = null;
                }
                return dialogBuildingInterceptor.shouldIntercept(obj, activity);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shouldIntercept");
        }
    }
}
