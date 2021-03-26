package com.coolapk.market.view.center;

import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemCardManagerTitleBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/center/CardManagerTitleViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemCardManagerTitleBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardManagerTitleViewHolder.kt */
public final class CardManagerTitleViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558633;
    private final ItemCardManagerTitleBinding binding = ((ItemCardManagerTitleBinding) getBinding());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardManagerTitleViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CardManagerTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CardManagerTitleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemCardManagerTitleBinding itemCardManagerTitleBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemCardManagerTitleBinding, "binding");
        itemCardManagerTitleBinding.setClick(this);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        Entity entity = (Entity) obj;
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(entity.getTitle());
        TextView textView2 = this.binding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subTitleView");
        String subTitle = entity.getSubTitle();
        if (subTitle == null) {
            subTitle = "卡片管理";
        }
        textView2.setText(subTitle);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131363437) {
            ActionManager.startCardManagerActivity(getContext());
        }
    }
}
