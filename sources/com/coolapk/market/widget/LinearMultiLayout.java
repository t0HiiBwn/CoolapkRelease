package com.coolapk.market.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/widget/LinearMultiLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Landroid/widget/BaseAdapter;", "observer", "Landroid/database/DataSetObserver;", "getObserver", "()Landroid/database/DataSetObserver;", "observer$delegate", "Lkotlin/Lazy;", "viewPool", "Lcom/coolapk/market/widget/LinearMultiLayout$ViewPool;", "getAdapter", "notifyDataSetChange", "", "setAdapter", "updateChildView", "ViewPool", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LinearMutliLayout.kt */
public final class LinearMultiLayout extends LinearLayout {
    private BaseAdapter adapter;
    private final Lazy observer$delegate = LazyKt.lazy(new LinearMultiLayout$observer$2(this));
    private final ViewPool viewPool = new ViewPool();

    private final DataSetObserver getObserver() {
        return (DataSetObserver) this.observer$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinearMultiLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public final void notifyDataSetChange() {
        updateChildView();
    }

    public final void setAdapter(BaseAdapter baseAdapter) {
        BaseAdapter baseAdapter2 = this.adapter;
        if (baseAdapter2 != baseAdapter) {
            if (baseAdapter2 != null) {
                baseAdapter2.unregisterDataSetObserver(getObserver());
                this.viewPool.clear();
            }
            this.adapter = baseAdapter;
            if (baseAdapter != null) {
                baseAdapter.registerDataSetObserver(getObserver());
            }
            updateChildView();
        }
    }

    public final BaseAdapter getAdapter() {
        return this.adapter;
    }

    /* access modifiers changed from: private */
    public final void updateChildView() {
        BaseAdapter baseAdapter = this.adapter;
        if (baseAdapter == null) {
            removeAllViews();
            this.viewPool.clear();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int count = baseAdapter.getCount();
        for (int i = 0; i < count; i++) {
            arrayList.add(baseAdapter.getView(i, this.viewPool.get(baseAdapter.getItemViewType(i)), this));
        }
        removeAllViewsInLayout();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "pendingAddViews[i]");
            View view = (View) obj;
            LinearLayout.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            addViewInLayout(view, i2, layoutParams);
        }
        requestLayout();
        invalidate();
        this.viewPool.clear();
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Object obj2 = arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj2, "pendingAddViews[i]");
            this.viewPool.put(baseAdapter.getItemViewType(i3), (View) obj2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/widget/LinearMultiLayout$ViewPool;", "", "()V", "viewTypeMap", "Ljava/util/HashMap;", "", "", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "clear", "", "get", "viewType", "put", "view", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LinearMutliLayout.kt */
    public static final class ViewPool {
        private final HashMap<Integer, List<View>> viewTypeMap = new HashMap<>();

        public final View get(int i) {
            List<View> list = this.viewTypeMap.get(Integer.valueOf(i));
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "viewTypeMap[viewType] ?: return null");
                if (!list.isEmpty()) {
                    return list.remove(0);
                }
            }
            return null;
        }

        public final void put(int i, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HashMap<Integer, List<View>> hashMap = this.viewTypeMap;
            Integer valueOf = Integer.valueOf(i);
            ArrayList arrayList = hashMap.get(valueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(valueOf, arrayList);
            }
            arrayList.add(view);
        }

        public final void clear() {
            this.viewTypeMap.clear();
        }
    }
}
