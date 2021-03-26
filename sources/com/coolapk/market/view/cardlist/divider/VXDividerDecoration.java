package com.coolapk.market.view.cardlist.divider;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.SparseArrayKt;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000 62\u00020\u0001:\u00016B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J8\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002J8\u0010!\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\tH&J(\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020/2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002J\b\u00101\u001a\u00020\u0017H\u0016J \u00102\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\u00172\b\b\u0001\u0010\b\u001a\u00020\tJ\u0012\u00104\u001a\u00020\u00172\n\u00105\u001a\u0006\u0012\u0002\b\u00030\u0003R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/VXDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "defaultColor", "", "dividerDataArray", "Landroid/util/SparseArray;", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "itemCount", "getItemCount$presentation_coolapkAppRelease", "()I", "observable", "Lcom/coolapk/market/view/cardlist/divider/SimpleAdapterDataObserver;", "paint", "Landroid/graphics/Paint;", "tmpRect", "Landroid/graphics/Rect;", "detach", "", "drawViewBottomDivider", "c", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "rect", "parentLeft", "parentRight", "color", "drawViewTopDivider", "getCachedDividerData", "rawPosition", "getDividerColor", "dividerData", "getDividerData", "getItemOffsets", "outRect", "view", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isFirstPosition", "", "isLastPosition", "onAdapterAnyDataChanged", "onDraw", "setDividerColor", "swapAdapter", "newAdapter", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXDividerDecoration.kt */
public abstract class VXDividerDecoration extends RecyclerView.ItemDecoration {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_COLOR = Integer.MAX_VALUE;
    private RecyclerView.Adapter<?> adapter;
    private int defaultColor;
    private final SparseArray<DividerData> dividerDataArray = new SparseArray<>();
    private final SimpleAdapterDataObserver observable;
    private final Paint paint = new Paint(1);
    private final Rect tmpRect = new Rect();

    public abstract DividerData getDividerData(int i);

    public VXDividerDecoration(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        this.adapter = adapter2;
        SimpleAdapterDataObserver simpleAdapterDataObserver = new SimpleAdapterDataObserver(new VXDividerDecoration$observable$1(this));
        this.observable = simpleAdapterDataObserver;
        this.adapter.registerAdapterDataObserver(simpleAdapterDataObserver);
    }

    public final RecyclerView.Adapter<?> getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/VXDividerDecoration$Companion;", "", "()V", "DEFAULT_COLOR", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VXDividerDecoration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getItemCount$presentation_coolapkAppRelease() {
        return this.adapter.getItemCount();
    }

    public final void setDividerColor(int i) {
        this.defaultColor = i;
    }

    private final DividerData getCachedDividerData(int i) {
        if (this.dividerDataArray.indexOfKey(i) >= 0) {
            DividerData dividerData = this.dividerDataArray.get(i);
            Intrinsics.checkNotNullExpressionValue(dividerData, "dividerDataArray.get(rawPosition)");
            return dividerData;
        }
        DividerData dividerData2 = getDividerData(i);
        this.dividerDataArray.put(i, dividerData2);
        return dividerData2;
    }

    public void onAdapterAnyDataChanged() {
        Iterator valueIterator = SparseArrayKt.valueIterator(this.dividerDataArray);
        while (valueIterator.hasNext()) {
            ((DividerData) valueIterator.next()).recycle();
        }
        this.dividerDataArray.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i));
            if (childAdapterPosition < getItemCount$presentation_coolapkAppRelease() - 1 && childAdapterPosition >= 0) {
                DividerData cachedDividerData = getCachedDividerData(childAdapterPosition);
                this.tmpRect.set(cachedDividerData.getLeftMargin(), 0, cachedDividerData.getRightMargin(), cachedDividerData.getHeight());
                View childAt = recyclerView.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
                drawViewBottomDivider(canvas, childAt, this.tmpRect, paddingLeft, width, getDividerColor(cachedDividerData));
            }
            if (childAdapterPosition == 0) {
                DividerData cachedDividerData2 = getCachedDividerData(-1);
                this.tmpRect.set(cachedDividerData2.getLeftMargin(), cachedDividerData2.getHeight(), cachedDividerData2.getRightMargin(), 0);
                View childAt2 = recyclerView.getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt2, "parent.getChildAt(0)");
                drawViewTopDivider(canvas, childAt2, this.tmpRect, paddingLeft, width, getDividerColor(cachedDividerData2));
            }
        }
    }

    private final int getDividerColor(DividerData dividerData) {
        if (dividerData.getColor() != null) {
            Integer color = dividerData.getColor();
            Intrinsics.checkNotNull(color);
            return color.intValue();
        } else if (dividerData.getHeight() == DividerData.Companion.getH1DP().getHeight()) {
            return AppHolder.getAppTheme().getCurrencyColorDivider();
        } else {
            return this.defaultColor;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition <= getItemCount$presentation_coolapkAppRelease() - 1) {
            rect.set(0, 0, 0, getCachedDividerData(childAdapterPosition).getHeight());
        }
        if (isFirstPosition(view, recyclerView)) {
            rect.top = getCachedDividerData(-1).getHeight();
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

    private final boolean isFirstPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == 0;
    }

    private final boolean isLastPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == getItemCount$presentation_coolapkAppRelease() - 1;
    }

    private final void drawViewTopDivider(Canvas canvas, View view, Rect rect, int i, int i2, int i3) {
        if (rect.top >= 0 && i3 != 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int top = view.getTop() - ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
            this.paint.setColor(i3);
            canvas.drawRect((float) (i + rect.left), (float) (top - rect.top), (float) (i2 - rect.right), (float) top, this.paint);
        }
    }

    private final void drawViewBottomDivider(Canvas canvas, View view, Rect rect, int i, int i2, int i3) {
        if (rect.bottom >= 0 && i3 != 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int bottom = view.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
            this.paint.setColor(i3);
            canvas.drawRect((float) (i + rect.left), (float) bottom, (float) (i2 - rect.right), (float) (rect.bottom + bottom), this.paint);
        }
    }
}
