package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedGoodsCategory;
import com.coolapk.market.view.feedv8.GoodsContentHolder;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0017J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/view/feedv8/GoodsContentHolder$showCategoryDialog$2", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
public final class GoodsContentHolder$showCategoryDialog$2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final /* synthetic */ List $categoryRows;
    final /* synthetic */ Activity $context;
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ FeedGoods $feedGoods;
    final /* synthetic */ Ref.IntRef $selectId;
    final /* synthetic */ Ref.ObjectRef $tempSelectId;
    final /* synthetic */ GoodsContentHolder this$0;

    GoodsContentHolder$showCategoryDialog$2(GoodsContentHolder goodsContentHolder, Activity activity, List list, Ref.ObjectRef objectRef, Ref.IntRef intRef, FeedGoods feedGoods, Function0 function0) {
        this.this$0 = goodsContentHolder;
        this.$context = activity;
        this.$categoryRows = list;
        this.$tempSelectId = objectRef;
        this.$selectId = intRef;
        this.$feedGoods = feedGoods;
        this.$dismissAction = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        FrameLayout frameLayout = new FrameLayout(this.$context);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, NumberExtendsKt.getDp((Number) 40));
        layoutParams.setMargins(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 8));
        Unit unit = Unit.INSTANCE;
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(this.$context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        Unit unit2 = Unit.INSTANCE;
        frameLayout.addView(textView);
        Unit unit3 = Unit.INSTANCE;
        return new GoodsContentHolder.SimpleViewHolder(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$categoryRows.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        FeedGoodsCategory feedGoodsCategory = (FeedGoodsCategory) this.$categoryRows.get(i);
        View view = ((GoodsContentHolder.SimpleViewHolder) viewHolder).itemView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        View childAt = frameLayout.getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) childAt;
        Intrinsics.checkNotNullExpressionValue(feedGoodsCategory, "data");
        textView.setText(feedGoodsCategory.getTitle());
        GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$1 goodsContentHolder$showCategoryDialog$2$onBindViewHolder$1 = new GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$1(this, feedGoodsCategory, textView, frameLayout);
        goodsContentHolder$showCategoryDialog$2$onBindViewHolder$1.invoke();
        ViewExtendsKt.clipView$default(frameLayout, 0, NumberExtendsKt.getDpf((Number) 4), 1, null);
        frameLayout.setOnTouchListener(new GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$2(this, feedGoodsCategory, goodsContentHolder$showCategoryDialog$2$onBindViewHolder$1, frameLayout));
        frameLayout.setOnClickListener(new GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$3(this, feedGoodsCategory));
    }
}
