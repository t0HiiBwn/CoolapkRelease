package com.coolapk.market.view.sencondhand;

import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\nH&J\u001e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR4\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/sencondhand/CheckHelper;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "checkedArrays", "Landroid/util/SparseIntArray;", "getCheckedArrays", "()Landroid/util/SparseIntArray;", "checkedPostion", "", "getCheckedPostion", "()I", "setCheckedPostion", "(I)V", "handleStateChange", "Lkotlin/Function3;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "", "getHandleStateChange", "()Lkotlin/jvm/functions/Function3;", "setHandleStateChange", "(Lkotlin/jvm/functions/Function3;)V", "bindViewHolder", "viewHolder", "clickView", "Landroid/view/View;", "redID", "isCheckedPosition", "position", "stateChange", "checked", "type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CheckHelper.kt */
public abstract class CheckHelper {
    private final SparseIntArray checkedArrays = new SparseIntArray();
    private int checkedPostion = -1;
    private Function3<? super RecyclerView.ViewHolder, ? super Boolean, ? super Integer, Unit> handleStateChange;

    public abstract void bindViewHolder(RecyclerView.ViewHolder viewHolder, View view);

    public abstract boolean isCheckedPosition(int i);

    public CheckHelper(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public final void bindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View findViewById = viewHolder.itemView.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewHolder.itemView.findViewById<View>(redID)");
        bindViewHolder(viewHolder, findViewById);
    }

    public final void bindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        bindViewHolder(viewHolder, view);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function3<? super androidx.recyclerview.widget.RecyclerView$ViewHolder, ? super java.lang.Boolean, ? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function3<androidx.recyclerview.widget.RecyclerView$ViewHolder, java.lang.Boolean, java.lang.Integer, kotlin.Unit> */
    public final Function3<RecyclerView.ViewHolder, Boolean, Integer, Unit> getHandleStateChange() {
        return this.handleStateChange;
    }

    public final void setHandleStateChange(Function3<? super RecyclerView.ViewHolder, ? super Boolean, ? super Integer, Unit> function3) {
        this.handleStateChange = function3;
    }

    public final void stateChange(RecyclerView.ViewHolder viewHolder, boolean z, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        view.setSelected(z);
        Function3<? super RecyclerView.ViewHolder, ? super Boolean, ? super Integer, Unit> function3 = this.handleStateChange;
        if (function3 != null) {
            function3.invoke(viewHolder, Boolean.valueOf(z), Integer.valueOf(i));
        }
    }

    public final int getCheckedPostion() {
        return this.checkedPostion;
    }

    public final void setCheckedPostion(int i) {
        this.checkedPostion = i;
    }

    public final SparseIntArray getCheckedArrays() {
        return this.checkedArrays;
    }
}
