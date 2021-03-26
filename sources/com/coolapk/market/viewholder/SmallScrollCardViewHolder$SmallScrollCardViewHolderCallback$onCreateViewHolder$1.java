package com.coolapk.market.viewholder;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.viewholder.SmallScrollCardViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/SmallScrollCardViewHolder$SmallScrollCardViewHolderCallback$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/SmallScrollCardItemViewHolder;", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SmallScrollCardViewHolder.kt */
public final class SmallScrollCardViewHolder$SmallScrollCardViewHolderCallback$onCreateViewHolder$1 extends SmallScrollCardItemViewHolder {
    final /* synthetic */ TitleRecycleViewCardViewHolder $holder;
    final /* synthetic */ View $view;
    final /* synthetic */ SmallScrollCardViewHolder.SmallScrollCardViewHolderCallback this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmallScrollCardViewHolder$SmallScrollCardViewHolderCallback$onCreateViewHolder$1(SmallScrollCardViewHolder.SmallScrollCardViewHolderCallback smallScrollCardViewHolderCallback, TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, View view, View view2, DataBindingComponent dataBindingComponent) {
        super(view2, dataBindingComponent);
        this.this$0 = smallScrollCardViewHolderCallback;
        this.$holder = titleRecycleViewCardViewHolder;
        this.$view = view;
    }

    @Override // com.coolapk.market.viewholder.SmallScrollCardItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        setParentCard(this.$holder.getCard());
        setParentViewHolder(this.$holder);
        super.bindTo(obj);
        if (this.this$0.getLightTheme() || (this.this$0.hasPic)) {
            getBinding().titleView.setTextColor(-1);
            getBinding().infoView.setTextColor(-1);
            int parseColor = Color.parseColor("#FFB712");
            getBinding().scoreView.setTextColor(parseColor);
            ImageView imageView = getBinding().scoreViewIcon;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.scoreViewIcon");
            imageView.setImageTintList(ColorStateList.valueOf(parseColor));
            return;
        }
        getBinding().titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        getBinding().infoView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        getBinding().scoreView.setTextColor(colorAccent);
        ImageView imageView2 = getBinding().scoreViewIcon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.scoreViewIcon");
        imageView2.setImageTintList(ColorStateList.valueOf(colorAccent));
    }
}
