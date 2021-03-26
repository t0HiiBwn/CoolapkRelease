package com.coolapk.market.viewholder;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemMessageCardBinding;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.ShapeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/viewholder/MessageCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageCardViewHolder.kt */
public final class MessageCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558825;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageCardViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        EntityCard entityCard = (EntityCard) obj;
        ItemMessageCardBinding itemMessageCardBinding = (ItemMessageCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemMessageCardBinding, "binding");
        itemMessageCardBinding.setMessage(entityCard.getDescription());
        itemMessageCardBinding.setTitle(entityCard.getTitle());
        itemMessageCardBinding.executePendingBindings();
        ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getColorAccent());
        colorDrawable.setAlpha(26);
        Drawable createSelectableItemBackgroundWith = ShapeUtils.createSelectableItemBackgroundWith(getContext(), colorDrawable);
        TextView textView = itemMessageCardBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setBackground(createSelectableItemBackgroundWith);
        this.itemView.requestLayout();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/MessageCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MessageCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
