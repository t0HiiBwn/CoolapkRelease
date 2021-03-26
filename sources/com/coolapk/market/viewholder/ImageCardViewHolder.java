package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemImageCardBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.AspectRatioImageView;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "card", "Lcom/coolapk/market/model/Entity;", "random", "Ljava/util/Random;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageCardViewHolder.kt */
public final class ImageCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558794;
    private Entity card;
    private final Random random = new Random();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemImageCardBinding itemImageCardBinding = (ItemImageCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemImageCardBinding, "binding");
        ViewUtil.clickListener(itemImageCardBinding.getRoot(), this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        try {
            EntityCard entityCard = (EntityCard) obj;
            List<Entity> entities = entityCard.getEntities();
            Intrinsics.checkNotNull(entities);
            Random random2 = this.random;
            List<Entity> entities2 = entityCard.getEntities();
            Intrinsics.checkNotNull(entities2);
            this.card = entities.get(random2.nextInt(entities2.size()));
        } catch (Exception unused) {
            this.card = (Entity) obj;
        }
        ItemImageCardBinding itemImageCardBinding = (ItemImageCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemImageCardBinding, "binding");
        itemImageCardBinding.setCard(this.card);
        AspectRatioImageView aspectRatioImageView = itemImageCardBinding.imageView;
        Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.imageView");
        ViewExtendsKt.darkForegroundIfNeed(aspectRatioImageView);
        itemImageCardBinding.executePendingBindings();
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Integer num = null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        if (((ViewGroup.MarginLayoutParams) layoutParams) != null) {
            if (!(obj instanceof Entity)) {
                obj = null;
            }
            Entity entity = (Entity) obj;
            if (entity != null) {
                num = entity.getEntityFixed();
            }
            if (num != null && num.intValue() == 1 && getAdapterPosition() > 0) {
                this.itemView.setPadding(0, DisplayUtils.dp2px(getContext(), 12.0f), 0, DisplayUtils.dp2px(getContext(), 12.0f));
            } else {
                this.itemView.setPadding(0, 0, 0, 0);
            }
        }
        this.itemView.requestLayout();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (view.getId() == 2131362779) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Entity entity = this.card;
            Intrinsics.checkNotNull(entity);
            String url = entity.getUrl();
            Entity entity2 = this.card;
            Intrinsics.checkNotNull(entity2);
            String title = entity2.getTitle();
            Entity entity3 = this.card;
            Intrinsics.checkNotNull(entity3);
            ActionManagerCompat.startActivityByUrl(context, url, title, entity3.getSubTitle());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
