package com.coolapk.market.view.product.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemIconLinkGridCardItemBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemIconLinkGridCardItemBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconGridHorizonCardViewHolder.kt */
final class DataViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558787;
    private final ItemIconLinkGridCardItemBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        ItemIconLinkGridCardItemBinding itemIconLinkGridCardItemBinding = (ItemIconLinkGridCardItemBinding) getBinding();
        this.binding = itemIconLinkGridCardItemBinding;
        ImageView imageView = itemIconLinkGridCardItemBinding.iconView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
        ViewExtendsKt.clipView$default(imageView, 0, (float) NumberExtendsKt.getDp((Number) 4), 1, null);
        ImageView imageView2 = itemIconLinkGridCardItemBinding.iconView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.iconView");
        ImageView imageView3 = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = NumberExtendsKt.getDp((Number) 64);
            layoutParams.height = NumberExtendsKt.getDp((Number) 32);
            imageView3.setLayoutParams(layoutParams);
            LinearLayout linearLayout = itemIconLinkGridCardItemBinding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            LinearLayout linearLayout2 = linearLayout;
            ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = -2;
                linearLayout2.setLayoutParams(layoutParams2);
                itemIconLinkGridCardItemBinding.itemView.setOnClickListener(this);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconGridHorizonCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemIconLinkGridCardItemBinding itemIconLinkGridCardItemBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconLinkGridCardItemBinding, "binding");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        itemIconLinkGridCardItemBinding.setEntity((Entity) obj);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemIconLinkGridCardItemBinding itemIconLinkGridCardItemBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconLinkGridCardItemBinding, "binding");
        Entity entity = itemIconLinkGridCardItemBinding.getEntity();
        if (entity != null) {
            Intrinsics.checkNotNullExpressionValue(entity, "binding.entity ?: return");
            if (view.getId() == 2131362779) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            }
        }
    }
}
