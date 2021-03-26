package com.coolapk.market.widget.multitype;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/widget/multitype/BindDataInterceptor;", "", "onBindData", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BindDataInterceptor.kt */
public interface BindDataInterceptor {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: BindDataInterceptor.kt */
    public static final class DefaultImpls {
        public static void onViewAttachedToWindow(BindDataInterceptor bindDataInterceptor, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
        }

        public static void onViewDetachedFromWindow(BindDataInterceptor bindDataInterceptor, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
        }
    }

    void onBindData(RecyclerView.ViewHolder viewHolder, Object obj);

    void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder);

    void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder);
}
