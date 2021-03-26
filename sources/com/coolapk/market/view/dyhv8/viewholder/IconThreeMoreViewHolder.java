package com.coolapk.market.view.dyhv8.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemIconTitleViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0007J\b\u0010\u0012\u001a\u00020\fH\u0007J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fJ\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/IconThreeMoreViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemIconTitleViewBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "isShowFirstIcon", "", "isShowSecondIcon", "bindToContent", "", "data", "getIsShowFirstIcon", "getIsShowSecondIcon", "setShowFirstIcon", "showFirstIcon", "setShowSecondIcon", "showSecondIcon", "getMoreCount", "", "Lcom/coolapk/market/model/EntityCard;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconThreeMoreViewHolder.kt */
public final class IconThreeMoreViewHolder extends GenericBindHolder<ItemIconTitleViewBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558791;
    private boolean isShowFirstIcon;
    private boolean isShowSecondIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconThreeMoreViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/IconThreeMoreViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconThreeMoreViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard = (EntityCard) entity;
        ItemIconTitleViewBinding itemIconTitleViewBinding = (ItemIconTitleViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemIconTitleViewBinding, "binding");
        itemIconTitleViewBinding.setModel(entityCard);
        ItemIconTitleViewBinding itemIconTitleViewBinding2 = (ItemIconTitleViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemIconTitleViewBinding2, "binding");
        itemIconTitleViewBinding2.setHolder(this);
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "logoCard.entities!!");
        List<Entity> list = entities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(EntityExtendsKt.picOrLogo(t));
        }
        ArrayList arrayList2 = arrayList;
        if (CollectionUtils.isEmpty(arrayList2)) {
            setShowFirstIcon(false);
            setShowSecondIcon(false);
        } else if (arrayList2.isEmpty()) {
            setShowFirstIcon(false);
            setShowSecondIcon(false);
        } else if (arrayList2.size() == 1) {
            setShowSecondIcon(true);
            setShowFirstIcon(false);
            AppHolder.getContextImageLoader().displayImage(getContext(), (String) arrayList2.get(0), ((ItemIconTitleViewBinding) getBinding()).iconView1, 2131231162);
        } else {
            AppHolder.getContextImageLoader().displayImage(getContext(), (String) arrayList2.get(0), ((ItemIconTitleViewBinding) getBinding()).iconView0, 2131231162);
            AppHolder.getContextImageLoader().displayImage(getContext(), (String) arrayList2.get(1), ((ItemIconTitleViewBinding) getBinding()).iconView1, 2131231162);
            setShowSecondIcon(true);
            setShowFirstIcon(true);
        }
        TextView textView = ((ItemIconTitleViewBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.moreView");
        textView.setBackground(ShapeUtils.createCircleStorkShapeIcon(getContext(), AppHolder.getAppTheme().getColorAccent()));
        TextView textView2 = ((ItemIconTitleViewBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.moreView");
        textView2.setText(getMoreCount(entityCard));
        ((ItemIconTitleViewBinding) getBinding()).executePendingBindings();
        ItemIconTitleViewBinding itemIconTitleViewBinding3 = (ItemIconTitleViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemIconTitleViewBinding3, "binding");
        itemIconTitleViewBinding3.getRoot().setOnClickListener(new IconThreeMoreViewHolder$bindToContent$1(this));
    }

    @Bindable
    public final boolean getIsShowFirstIcon() {
        return this.isShowFirstIcon;
    }

    @Bindable
    public final boolean getIsShowSecondIcon() {
        return this.isShowSecondIcon;
    }

    public final void setShowFirstIcon(boolean z) {
        this.isShowFirstIcon = z;
        notifyPropertyChanged(174);
    }

    public final void setShowSecondIcon(boolean z) {
        this.isShowSecondIcon = z;
        notifyPropertyChanged(175);
    }

    private final String getMoreCount(EntityCard entityCard) {
        return EntityExtendsKt.getStringExtraData(entityCard, "moreCount", "0");
    }
}
