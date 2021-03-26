package com.coolapk.market.widget.view;

import android.view.View;
import cn.lankton.flowlayout.FlowLayout;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.view.FloatExpandedMenuView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/widget/view/FloatExpandedMenuView$ConfigPageAdapter$getView$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FloatExpandedMenuView.kt */
final class FloatExpandedMenuView$ConfigPageAdapter$getView$$inlined$forEach$lambda$1 implements View.OnClickListener {
    final /* synthetic */ FlowLayout $flowLayout$inlined;
    final /* synthetic */ Entity $page;
    final /* synthetic */ FloatExpandedMenuView.ConfigPageAdapter this$0;

    FloatExpandedMenuView$ConfigPageAdapter$getView$$inlined$forEach$lambda$1(Entity entity, FloatExpandedMenuView.ConfigPageAdapter configPageAdapter, FlowLayout flowLayout) {
        this.$page = entity;
        this.this$0 = configPageAdapter;
        this.$flowLayout$inlined = flowLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<Entity, Unit> onPageClickListener = this.this$0.this$0.getOnPageClickListener();
        if (onPageClickListener != null) {
            onPageClickListener.invoke(this.$page);
        }
    }
}
