package com.coolapk.market.view.feed.vote;

import android.app.Activity;
import com.coolapk.market.view.base.ActionItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0012*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J+\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/vote/DialogBuilderHelper;", "T", "", "()V", "globalInterceptors", "", "Lcom/coolapk/market/view/feed/vote/DialogBuildingInterceptor;", "addInterceptor", "", "interceptor", "handleDataList", "dataList", "Lcom/coolapk/market/view/base/ActionItem;", "data", "activity", "Landroid/app/Activity;", "(Ljava/util/List;Ljava/lang/Object;Landroid/app/Activity;)V", "removeInterceptor", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDialogInterceptor.kt */
public final class DialogBuilderHelper<T> {
    public static final Companion Companion = new Companion(null);
    private static final HashMap<String, DialogBuilderHelper<?>> sDialogBuilderHelperMap = new HashMap<>();
    private final List<DialogBuildingInterceptor<T>> globalInterceptors;

    private DialogBuilderHelper() {
        this.globalInterceptors = new ArrayList();
    }

    public /* synthetic */ DialogBuilderHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\n\b\u0001\u0010\t\u0018\u0001*\u00020\u0001H\bJ\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u00020\u0005R2\u0010\u0003\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/vote/DialogBuilderHelper$Companion;", "", "()V", "sDialogBuilderHelperMap", "Ljava/util/HashMap;", "", "Lcom/coolapk/market/view/feed/vote/DialogBuilderHelper;", "Lkotlin/collections/HashMap;", "of", "T", "ofClassName", "className", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedDialogInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ <T> DialogBuilderHelper<T> of() {
            Intrinsics.reifiedOperationMarker(4, "T");
            String name = Object.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
            DialogBuilderHelper<T> dialogBuilderHelper = (DialogBuilderHelper<T>) ofClassName(name);
            Objects.requireNonNull(dialogBuilderHelper, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.DialogBuilderHelper<T>");
            return dialogBuilderHelper;
        }

        public final DialogBuilderHelper<?> ofClassName(String str) {
            Intrinsics.checkNotNullParameter(str, "className");
            HashMap hashMap = DialogBuilderHelper.sDialogBuilderHelperMap;
            Object obj = hashMap.get(str);
            if (obj == null) {
                obj = new DialogBuilderHelper(null);
                hashMap.put(str, obj);
            }
            return (DialogBuilderHelper) obj;
        }
    }

    public final void addInterceptor(DialogBuildingInterceptor<T> dialogBuildingInterceptor) {
        Intrinsics.checkNotNullParameter(dialogBuildingInterceptor, "interceptor");
        this.globalInterceptors.add(dialogBuildingInterceptor);
    }

    public final void removeInterceptor(DialogBuildingInterceptor<T> dialogBuildingInterceptor) {
        Intrinsics.checkNotNullParameter(dialogBuildingInterceptor, "interceptor");
        this.globalInterceptors.remove(dialogBuildingInterceptor);
    }

    public final void handleDataList(List<ActionItem> list, T t, Activity activity) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(t, "data");
        for (T t2 : this.globalInterceptors) {
            if (t2.shouldIntercept(t, activity)) {
                t2.modifyDataList(list, t);
            }
        }
    }
}
