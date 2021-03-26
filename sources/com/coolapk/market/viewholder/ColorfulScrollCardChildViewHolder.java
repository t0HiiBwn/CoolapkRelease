package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemColorfulScrollCardChildBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.SimplePaletteBackgroundTarget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/ColorfulScrollCardChildViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemColorfulScrollCardChildBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "callback", "Lkotlin/Function0;", "Lcom/coolapk/market/model/EntityCard;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "bindToContent", "", "data", "loadBackground", "imageUrl", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ColorfulScrollCardViewHolder.kt */
final class ColorfulScrollCardChildViewHolder extends GenericBindHolder<ItemColorfulScrollCardChildBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558664;
    private final Function0<EntityCard> callback;

    public final Function0<EntityCard> getCallback() {
        return this.callback;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends com.coolapk.market.model.EntityCard> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColorfulScrollCardChildViewHolder(View view, DataBindingComponent dataBindingComponent, Function0<? extends EntityCard> function0) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.callback = function0;
        ItemColorfulScrollCardChildBinding itemColorfulScrollCardChildBinding = (ItemColorfulScrollCardChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemColorfulScrollCardChildBinding, "binding");
        itemColorfulScrollCardChildBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ColorfulScrollCardChildViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ColorfulScrollCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        String str;
        Intrinsics.checkNotNullParameter(entity, "data");
        ItemColorfulScrollCardChildBinding itemColorfulScrollCardChildBinding = (ItemColorfulScrollCardChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemColorfulScrollCardChildBinding, "binding");
        if (!Intrinsics.areEqual(itemColorfulScrollCardChildBinding.getModel(), entity)) {
            String str2 = "";
            boolean z = true;
            int i = 0;
            if (entity instanceof Product) {
                Product product = (Product) entity;
                String subTitle = product.getSubTitle();
                if (!(subTitle == null || subTitle.length() == 0)) {
                    z = false;
                }
                if (z) {
                    str = EntityExtendsKt.getDisplayPerferRatingScore(product) + "分  " + KotlinExtendKt.toDisplayString(product.getRatingTotalNum()) + "人点评";
                } else {
                    str = product.getSubTitle();
                    if (str == null) {
                        str = str2;
                    }
                }
                TextView textView = ((ItemColorfulScrollCardChildBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
                textView.setText(str);
                TextView textView2 = ((ItemColorfulScrollCardChildBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.infoView");
                textView2.setVisibility(0);
            } else {
                TextView textView3 = ((ItemColorfulScrollCardChildBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.infoView");
                textView3.setText(entity.getSubTitle());
                TextView textView4 = ((ItemColorfulScrollCardChildBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.infoView");
                TextView textView5 = textView4;
                String subTitle2 = entity.getSubTitle();
                if (!(true ^ (subTitle2 == null || subTitle2.length() == 0))) {
                    i = 8;
                }
                textView5.setVisibility(i);
            }
            String pic = entity.getPic();
            if (pic == null) {
                pic = entity.getLogo();
            }
            if (pic != null) {
                str2 = pic;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "data.pic ?: data.logo ?: \"\"");
            loadBackground(str2);
            ItemColorfulScrollCardChildBinding itemColorfulScrollCardChildBinding2 = (ItemColorfulScrollCardChildBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemColorfulScrollCardChildBinding2, "binding");
            itemColorfulScrollCardChildBinding2.setModel(entity);
            ((ItemColorfulScrollCardChildBinding) getBinding()).executePendingBindings();
        }
    }

    private final void loadBackground(String str) {
        GlideRequest transform = GlideApp.with(getContext()).as(PaletteBitmap.class).load(str).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24));
        LinearLayout linearLayout = ((ItemColorfulScrollCardChildBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        transform.into((GlideRequest) new SimplePaletteBackgroundTarget(linearLayout));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemColorfulScrollCardChildBinding itemColorfulScrollCardChildBinding = (ItemColorfulScrollCardChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemColorfulScrollCardChildBinding, "binding");
        Entity model = itemColorfulScrollCardChildBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            if (view.getId() != 2131362779) {
                super.onClick(view);
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl(context, model.getUrl(), model.getTitle(), model.getSubTitle());
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            DataBindingComponent component = getComponent();
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof BaseFragment)) {
                fragment = null;
            }
            BaseFragment baseFragment = (BaseFragment) fragment;
            StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, model, getAdapterPosition(), this.callback.invoke(), null, 16, null);
        }
    }
}
