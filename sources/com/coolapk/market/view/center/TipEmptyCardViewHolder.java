package com.coolapk.market.view.center;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemTipEmptyBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/center/TipEmptyCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemTipEmptyBinding;", "kotlin.jvm.PlatformType", "model", "Lcom/coolapk/market/model/EntityCard;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TipEmptyCardViewHolder.kt */
public final class TipEmptyCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558960;
    private final ItemTipEmptyBinding binding = ((ItemTipEmptyBinding) getBinding());
    private EntityCard model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipEmptyCardViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/TipEmptyCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TipEmptyCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        this.model = (EntityCard) obj;
        ItemTipEmptyBinding itemTipEmptyBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemTipEmptyBinding, "binding");
        itemTipEmptyBinding.setClick(this);
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        EntityCard entityCard = this.model;
        String str = null;
        textView.setText(entityCard != null ? entityCard.getTitle() : null);
        TextView textView2 = this.binding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subTitleView");
        EntityCard entityCard2 = this.model;
        textView2.setText(entityCard2 != null ? entityCard2.getSubTitle() : null);
        TextView textView3 = this.binding.tipsView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tipsView");
        EntityCard entityCard3 = this.model;
        if (entityCard3 != null) {
            str = EntityExtendsKt.getStringExtraData(entityCard3, "placeHolder", "什么都没有");
        }
        textView3.setText(str);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131363455) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            EntityCard entityCard = this.model;
            if (entityCard != null) {
                str = entityCard.getUrl();
            }
            ActionManagerCompat.startActivityByUrl$default(context, str, null, null, 12, null);
        }
    }
}
