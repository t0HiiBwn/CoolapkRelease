package com.coolapk.market.view.cardlist.divider;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.SparseArrayKt;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0016J(\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\u0017H\u0016J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020\u0017R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/SimpleVXDividerDecoration;", "Lcom/coolapk/market/view/cardlist/divider/VXDividerDecoration;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "dataList", "", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Ljava/util/List;)V", "loader", "Lkotlin/Function1;", "", "", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;)V", "dataLoader", "defaultMarginRule", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "dividerRuleList", "Ljava/util/LinkedList;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "viewMarginDataArray", "Landroid/util/SparseArray;", "viewMarginRuleList", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "addDividerRule", "", "rule", "addViewMarginRule", "getCachedViewMarginData", "position", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getViewMarginData", "onAdapterAnyDataChanged", "setDefaultMarginRule", "marginRule", "setDefaultNoMargin", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleVXDividerDecoration.kt */
public final class SimpleVXDividerDecoration extends VXDividerDecoration {
    private final Function1<Integer, Object> dataLoader;
    private ViewMarginData defaultMarginRule = ViewMarginData.Companion.getDEFAULT();
    private LinkedList<DividerRule> dividerRuleList = new LinkedList<>();
    private final SparseArray<ViewMarginData> viewMarginDataArray = new SparseArray<>();
    private LinkedList<ViewMarginRule> viewMarginRuleList = new LinkedList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleVXDividerDecoration(RecyclerView.Adapter<?> adapter, final List<?> list) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.dataLoader = new Function1<Integer, Object>() {
            /* class com.coolapk.market.view.cardlist.divider.SimpleVXDividerDecoration.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return CollectionsKt.getOrNull(list, i);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleVXDividerDecoration(RecyclerView.Adapter<?> adapter, Function1<? super Integer, ? extends Object> function1) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(function1, "loader");
        this.dataLoader = function1;
    }

    @Override // com.coolapk.market.view.cardlist.divider.VXDividerDecoration
    public DividerData getDividerData(int i) {
        Iterator<T> it2 = this.dividerRuleList.iterator();
        while (it2.hasNext()) {
            DividerData dividerData = it2.next().getDividerData(i, this.dataLoader.invoke(Integer.valueOf(i)), this.dataLoader.invoke(Integer.valueOf(i + 1)));
            if (dividerData != null) {
                return dividerData;
            }
        }
        if (i == -1 && !getCachedViewMarginData(0).isEmpty()) {
            return DividerData.Companion.getH12DP();
        }
        if (this.dataLoader.invoke(Integer.valueOf(i + 1)) != null || getCachedViewMarginData(i).isEmpty()) {
            return DividerData.Companion.getEMPTY();
        }
        return DividerData.Companion.getH12DP();
    }

    public final void addDividerRule(DividerRule dividerRule) {
        Intrinsics.checkNotNullParameter(dividerRule, "rule");
        this.dividerRuleList.addFirst(dividerRule);
    }

    public final void setDefaultNoMargin() {
        setDefaultMarginRule(ViewMarginData.Companion.getEMPTY());
    }

    public final void setDefaultMarginRule(ViewMarginData viewMarginData) {
        Intrinsics.checkNotNullParameter(viewMarginData, "marginRule");
        if (!Intrinsics.areEqual(this.defaultMarginRule, viewMarginData)) {
            this.defaultMarginRule = viewMarginData;
            onAdapterAnyDataChanged();
        }
    }

    @Override // com.coolapk.market.view.cardlist.divider.VXDividerDecoration
    public void onAdapterAnyDataChanged() {
        super.onAdapterAnyDataChanged();
        Iterator valueIterator = SparseArrayKt.valueIterator(this.viewMarginDataArray);
        while (valueIterator.hasNext()) {
            ((ViewMarginData) valueIterator.next()).recycle();
        }
        this.viewMarginDataArray.clear();
    }

    @Override // com.coolapk.market.view.cardlist.divider.VXDividerDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition <= getItemCount$presentation_coolapkAppRelease() - 1) {
            ViewMarginData cachedViewMarginData = getCachedViewMarginData(childAdapterPosition);
            rect.left = cachedViewMarginData.getLeftMargin();
            rect.right = cachedViewMarginData.getRightMargin();
        }
    }

    private final ViewMarginData getCachedViewMarginData(int i) {
        if (this.viewMarginDataArray.indexOfKey(i) >= 0) {
            ViewMarginData viewMarginData = this.viewMarginDataArray.get(i);
            Intrinsics.checkNotNullExpressionValue(viewMarginData, "viewMarginDataArray.get(position)");
            return viewMarginData;
        }
        ViewMarginData viewMarginData2 = getViewMarginData(i);
        this.viewMarginDataArray.put(i, viewMarginData2);
        return viewMarginData2;
    }

    private final ViewMarginData getViewMarginData(int i) {
        Object invoke = this.dataLoader.invoke(Integer.valueOf(i));
        if (invoke == null) {
            return this.defaultMarginRule;
        }
        Iterator<T> it2 = this.viewMarginRuleList.iterator();
        while (it2.hasNext()) {
            ViewMarginData viewMarginData = it2.next().getViewMarginData(i, invoke, this.defaultMarginRule);
            if (viewMarginData != null) {
                return viewMarginData;
            }
        }
        return this.defaultMarginRule;
    }

    public final void addViewMarginRule(ViewMarginRule viewMarginRule) {
        Intrinsics.checkNotNullParameter(viewMarginRule, "rule");
        this.viewMarginRuleList.addFirst(viewMarginRule);
    }
}
