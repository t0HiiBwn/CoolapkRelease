package com.coolapk.market.view.cardlist;

import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import group.infotech.drawable.dsl.ShapesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/cardlist/ListTopBackgroundDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "topHeight", "", "bgColor", "(II)V", "bottomDrawable", "Landroid/graphics/drawable/GradientDrawable;", "topDrawable", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ListTopBackgroundDecoration.kt */
public final class ListTopBackgroundDecoration extends RecyclerView.ItemDecoration {
    private final int bgColor;
    private final GradientDrawable bottomDrawable;
    private final GradientDrawable topDrawable;
    private final int topHeight;

    public ListTopBackgroundDecoration() {
        this(0, 0, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListTopBackgroundDecoration(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 50 : i, (i3 & 2) != 0 ? AppHolder.getAppTheme().getColorPrimary() : i2);
    }

    public ListTopBackgroundDecoration(int i, int i2) {
        this.topHeight = i;
        this.bgColor = i2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        ShapesKt.setSolidColor(gradientDrawable, i2);
        Unit unit = Unit.INSTANCE;
        this.topDrawable = gradientDrawable;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable2.setColors(new int[]{i2, 0});
        Unit unit2 = Unit.INSTANCE;
        this.bottomDrawable = gradientDrawable2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        int i = -recyclerView.computeVerticalScrollOffset();
        int width = recyclerView.getWidth();
        int dp = NumberExtendsKt.getDp(Integer.valueOf(this.topHeight)) + i;
        this.topDrawable.setBounds(0, i, width, dp);
        this.topDrawable.draw(canvas);
        this.bottomDrawable.setBounds(0, dp, width, NumberExtendsKt.getDp((Number) 50) + dp);
        this.bottomDrawable.draw(canvas);
    }
}
