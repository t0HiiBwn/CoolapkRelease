package com.coolapk.market.widget.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.extend.NumberExtendsKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0003ABCB\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020 J8\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002J(\u0010*\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002J0\u0010/\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203H\u0002J(\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\fH\u0002J\u001a\u0010:\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u00020\fH\u0002J\u001a\u0010;\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u00020\fH\u0002J\u0018\u0010<\u001a\u0002032\u0006\u00106\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010=\u001a\u0002032\u0006\u00106\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0002J \u0010>\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0006\u00107\u001a\u000208H\u0016J\u0012\u0010?\u001a\u00020 2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030\u0003R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "callback", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$Callback;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$Callback;)V", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "bottomDividerHeight", "", "getCallback", "()Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$Callback;", "heightArray", "Landroid/util/SparseIntArray;", "itemCount", "getItemCount", "()I", "leftArray", "observable", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$AdapterObservable;", "outsideRectColorArray", "paint", "Landroid/graphics/Paint;", "rectColorArray", "rightArray", "tmpRect", "Landroid/graphics/Rect;", "topDividerHeight", "detach", "", "drawChildDivider", "c", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "rect", "position", "parentLeft", "parentRight", "drawFirstDivider", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "left", "right", "drawLastDivider", "index", "getEdgeDividerHeight", "isTop", "", "getItemOffsets", "outRect", "view", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getOutRect", "getOutsideRectColor", "getRectColor", "isFirstPosition", "isLastPosition", "onDraw", "swapAdapter", "newAdapter", "AdapterObservable", "Callback", "SimpleCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CustomizedItemDecoration.kt */
public class CustomizedItemDecoration extends RecyclerView.ItemDecoration {
    private RecyclerView.Adapter<?> adapter;
    private int bottomDividerHeight = Integer.MIN_VALUE;
    private final Callback callback;
    private final SparseIntArray heightArray = new SparseIntArray();
    private final SparseIntArray leftArray = new SparseIntArray();
    private final AdapterObservable observable;
    private final SparseIntArray outsideRectColorArray = new SparseIntArray();
    private final Paint paint = new Paint(1);
    private final SparseIntArray rectColorArray = new SparseIntArray();
    private final SparseIntArray rightArray = new SparseIntArray();
    private final Rect tmpRect = new Rect();
    private int topDividerHeight = Integer.MIN_VALUE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$Callback;", "", "getBottomDividerHeight", "", "getDrawRect", "", "outRect", "Landroid/graphics/Rect;", "position", "getOutsideRectColor", "rect", "getRectColor", "getTopDividerHeight", "getTopOrBottomDividerColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CustomizedItemDecoration.kt */
    public interface Callback {
        int getBottomDividerHeight();

        void getDrawRect(Rect rect, int i);

        int getOutsideRectColor(Rect rect, int i);

        int getRectColor(Rect rect, int i);

        int getTopDividerHeight();

        int getTopOrBottomDividerColor();
    }

    public final RecyclerView.Adapter<?> getAdapter() {
        return this.adapter;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public CustomizedItemDecoration(RecyclerView.Adapter<?> adapter2, Callback callback2) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.adapter = adapter2;
        this.callback = callback2;
        AdapterObservable adapterObservable = new AdapterObservable();
        this.observable = adapterObservable;
        this.adapter.registerAdapterDataObserver(adapterObservable);
    }

    private final int getItemCount() {
        return this.adapter.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i));
            if (childAdapterPosition >= getItemCount() - 1 || childAdapterPosition < 0) {
                z = true;
            } else {
                View childAt = recyclerView.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
                z = true;
                drawChildDivider(canvas, childAt, getOutRect(childAdapterPosition), childAdapterPosition, paddingLeft, width);
            }
            if (childAdapterPosition == 0 && getEdgeDividerHeight(z) != 0) {
                drawFirstDivider(canvas, recyclerView, paddingLeft, width);
            }
            int itemCount = getItemCount();
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            if (childAdapterPosition == itemCount - i2 && getEdgeDividerHeight(false) != 0) {
                drawLastDivider(canvas, recyclerView, paddingLeft, width, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition <= getItemCount() - 1) {
            rect.set(0, 0, 0, getOutRect(childAdapterPosition).bottom);
        }
        if (isFirstPosition(view, recyclerView)) {
            rect.top = getEdgeDividerHeight(true);
        }
        if (isLastPosition(view, recyclerView)) {
            rect.bottom = getEdgeDividerHeight(false);
        }
    }

    public final void detach() {
        this.adapter.unregisterAdapterDataObserver(this.observable);
    }

    public final void swapAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "newAdapter");
        this.adapter.unregisterAdapterDataObserver(this.observable);
        adapter2.registerAdapterDataObserver(this.observable);
        this.adapter = adapter2;
    }

    private final Rect getOutRect(int i) {
        if (this.leftArray.indexOfKey(i) >= 0) {
            this.tmpRect.set(this.leftArray.get(i), 0, this.rightArray.get(i), this.heightArray.get(i));
        } else {
            this.tmpRect.set(0, 0, 0, 0);
            this.callback.getDrawRect(this.tmpRect, i);
            this.leftArray.put(i, this.tmpRect.left);
            this.rightArray.put(i, this.tmpRect.right);
            this.heightArray.put(i, this.tmpRect.height());
            if (this.tmpRect.top != 0) {
                Rect rect = this.tmpRect;
                rect.bottom = rect.height();
                this.tmpRect.top = 0;
            }
        }
        return this.tmpRect;
    }

    private final int getEdgeDividerHeight(boolean z) {
        if (z) {
            if (this.topDividerHeight == Integer.MIN_VALUE) {
                this.topDividerHeight = this.callback.getTopDividerHeight();
            }
            return this.topDividerHeight;
        }
        if (this.bottomDividerHeight == Integer.MIN_VALUE) {
            this.bottomDividerHeight = this.callback.getBottomDividerHeight();
        }
        return this.bottomDividerHeight;
    }

    private final int getRectColor(Rect rect, int i) {
        if (this.rectColorArray.indexOfKey(i) >= 0) {
            return this.rectColorArray.get(i);
        }
        if (rect == null) {
            rect = getOutRect(i);
        }
        int rectColor = this.callback.getRectColor(rect, i);
        this.rectColorArray.put(i, rectColor);
        return rectColor;
    }

    private final int getOutsideRectColor(Rect rect, int i) {
        if (this.outsideRectColorArray.indexOfKey(i) >= 0) {
            return this.outsideRectColorArray.get(i);
        }
        if (rect == null) {
            rect = getOutRect(i);
        }
        int outsideRectColor = this.callback.getOutsideRectColor(rect, i);
        this.outsideRectColorArray.put(i, outsideRectColor);
        return outsideRectColor;
    }

    private final boolean isFirstPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == 0;
    }

    private final boolean isLastPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == getItemCount() - 1;
    }

    private final void drawFirstDivider(Canvas canvas, RecyclerView recyclerView, int i, int i2) {
        View childAt = recyclerView.getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "child");
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int top = childAt.getTop() - ((RecyclerView.LayoutParams) layoutParams).topMargin;
        if (top >= 0) {
            this.paint.setColor(this.callback.getTopOrBottomDividerColor());
            canvas.drawRect((float) i, (float) (top - getEdgeDividerHeight(true)), (float) i2, (float) top, this.paint);
        }
    }

    private final void drawLastDivider(Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3) {
        View childAt = recyclerView.getChildAt(i3);
        Intrinsics.checkNotNullExpressionValue(childAt, "child");
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
        int edgeDividerHeight = getEdgeDividerHeight(false) + bottom;
        if (edgeDividerHeight >= 0) {
            this.paint.setColor(this.callback.getTopOrBottomDividerColor());
            canvas.drawRect((float) i, (float) bottom, (float) i2, (float) edgeDividerHeight, this.paint);
        }
    }

    private final void drawChildDivider(Canvas canvas, View view, Rect rect, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int bottom = view.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
        if (rect.bottom >= 0) {
            int i4 = rect.bottom + bottom;
            this.paint.setColor(getRectColor(rect, i));
            float f = (float) bottom;
            float f2 = (float) i4;
            canvas.drawRect((float) (rect.left + i2), f, (float) (i3 - rect.right), f2, this.paint);
            int outsideRectColor = getOutsideRectColor(rect, i);
            if (outsideRectColor != 0) {
                this.paint.setColor(outsideRectColor);
                if (rect.left > 0) {
                    canvas.drawRect((float) i2, f, (float) rect.left, f2, this.paint);
                }
                if (rect.right > 0 && rect.right < i3) {
                    canvas.drawRect((float) (i3 - rect.right), f, (float) i3, f2, this.paint);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$AdapterObservable;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "(Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration;)V", "invalidateItemDividerData", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CustomizedItemDecoration.kt */
    public final class AdapterObservable extends RecyclerView.AdapterDataObserver {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AdapterObservable() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            invalidateItemDividerData();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            invalidateItemDividerData();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            invalidateItemDividerData();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            invalidateItemDividerData();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            invalidateItemDividerData();
        }

        public final void invalidateItemDividerData() {
            CustomizedItemDecoration.this.leftArray.clear();
            CustomizedItemDecoration.this.rightArray.clear();
            CustomizedItemDecoration.this.heightArray.clear();
            CustomizedItemDecoration.this.rectColorArray.clear();
            CustomizedItemDecoration.this.outsideRectColorArray.clear();
            CustomizedItemDecoration.this.topDividerHeight = Integer.MIN_VALUE;
            CustomizedItemDecoration.this.bottomDividerHeight = Integer.MIN_VALUE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$SimpleCallback;", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$Callback;", "()V", "appTheme", "Lcom/coolapk/market/AppTheme;", "kotlin.jvm.PlatformType", "getAppTheme", "()Lcom/coolapk/market/AppTheme;", "normalDividerHeight", "", "getNormalDividerHeight", "()I", "thinDividerHeight", "getThinDividerHeight", "getBottomDividerHeight", "getOutsideRectColor", "rect", "Landroid/graphics/Rect;", "position", "getRectColor", "getTopDividerHeight", "getTopOrBottomDividerColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CustomizedItemDecoration.kt */
    public static abstract class SimpleCallback implements Callback {
        private final AppTheme appTheme = AppHolder.getAppTheme();
        private final int normalDividerHeight = NumberExtendsKt.getDp((Number) 8);
        private final int thinDividerHeight = NumberExtendsKt.getDp(Double.valueOf(0.5d));

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getBottomDividerHeight() {
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getTopDividerHeight() {
            return 0;
        }

        public final int getThinDividerHeight() {
            return this.thinDividerHeight;
        }

        public final int getNormalDividerHeight() {
            return this.normalDividerHeight;
        }

        public final AppTheme getAppTheme() {
            return this.appTheme;
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getRectColor(Rect rect, int i) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            if (rect.height() == this.thinDividerHeight) {
                return this.appTheme.getCurrencyColorDivider();
            }
            return this.appTheme.getContentBackgroundDividerColor();
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getOutsideRectColor(Rect rect, int i) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return this.appTheme.getContentBackgroundColor();
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getTopOrBottomDividerColor() {
            return this.appTheme.getContentBackgroundDividerColor();
        }
    }
}
