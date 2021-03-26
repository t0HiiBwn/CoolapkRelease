package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemImageTextCardChildBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.SimplePaletteBackgroundTarget;
import com.coolapk.market.widget.AspectRatioImageView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0002\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001#B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J8\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/coolapk/market/viewholder/ImageTextCardChildViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemImageTextCardChildBinding;", "Lcom/coolapk/market/model/Entity;", "Lcom/coolapk/market/app/OnImageLoadListener;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "parentHolder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;)V", "defaultColor", "", "getDefaultColor", "()I", "defaultColor$delegate", "Lkotlin/Lazy;", "entity", "getParentHolder", "()Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "bindToContent", "", "data", "onClick", "view", "onLoadComplete", "uri", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isFromMemory", "", "error", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageTextGridCardViewHolder.kt */
final class ImageTextCardChildViewHolder extends GenericBindHolder<ItemImageTextCardChildBinding, Entity> implements OnImageLoadListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558801;
    private final Lazy defaultColor$delegate = LazyKt.lazy(new ImageTextCardChildViewHolder$defaultColor$2(this));
    private Entity entity;
    private final TitleRecycleViewCardViewHolder parentHolder;

    /* access modifiers changed from: private */
    public final int getDefaultColor() {
        return ((Number) this.defaultColor$delegate.getValue()).intValue();
    }

    public final TitleRecycleViewCardViewHolder getParentHolder() {
        return this.parentHolder;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageTextCardChildViewHolder(View view, DataBindingComponent dataBindingComponent, TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "parentHolder");
        this.parentHolder = titleRecycleViewCardViewHolder;
        CardView cardView = ((ItemImageTextCardChildBinding) getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.cardView");
        ViewUtil.clickListener(cardView, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageTextCardChildViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageTextGridCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity2) {
        String str;
        Intrinsics.checkNotNullParameter(entity2, "data");
        ItemImageTextCardChildBinding itemImageTextCardChildBinding = (ItemImageTextCardChildBinding) getBinding();
        this.entity = entity2;
        Intrinsics.checkNotNullExpressionValue(itemImageTextCardChildBinding, "binding");
        itemImageTextCardChildBinding.setModel(entity2);
        itemImageTextCardChildBinding.executePendingBindings();
        DataBindingComponent component = getComponent();
        GridLayoutManager gridLayoutManager = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof Fragment)) {
            fragment = null;
        }
        if (fragment != null) {
            Entity entity3 = this.entity;
            if (entity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            boolean z = !TextUtils.isEmpty(entity3.getTitle());
            Integer stringToColor = ColorUtils.stringToColor(EntityExtendsKt.getStringExtraData(entity2, "textBackgroundColor", ""));
            Entity entity4 = this.entity;
            if (entity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            if (Intrinsics.areEqual(entity4.getEntityType(), "goodsList")) {
                Entity entity5 = this.entity;
                if (entity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                if (!(entity5 instanceof FunThings)) {
                    entity5 = null;
                }
                FunThings funThings = (FunThings) entity5;
                str = funThings != null ? funThings.getCoverPic() : null;
            } else {
                Entity entity6 = this.entity;
                if (entity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                str = entity6.getPic();
            }
            itemImageTextCardChildBinding.setCover(str);
            boolean z2 = false;
            if (z) {
                FrameLayout frameLayout = itemImageTextCardChildBinding.titleContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.titleContainer");
                frameLayout.setVisibility(0);
                if (stringToColor != null) {
                    itemImageTextCardChildBinding.titleContainer.setBackgroundColor(stringToColor.intValue());
                } else {
                    itemImageTextCardChildBinding.titleContainer.setBackgroundColor(getDefaultColor());
                    GlideRequest transform = GlideApp.with(getContext()).as(PaletteBitmap.class).load(str).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24));
                    FrameLayout frameLayout2 = itemImageTextCardChildBinding.titleContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.titleContainer");
                    Intrinsics.checkNotNullExpressionValue(transform.into((GlideRequest) new SimplePaletteBackgroundTarget(frameLayout2)), "GlideApp.with(context)\n …(binding.titleContainer))");
                }
                AspectRatioImageView aspectRatioImageView = itemImageTextCardChildBinding.imageView;
                Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.imageView");
                aspectRatioImageView.setAspectRatio(0.45f);
            } else {
                FrameLayout frameLayout3 = itemImageTextCardChildBinding.titleContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.titleContainer");
                frameLayout3.setVisibility(8);
                AspectRatioImageView aspectRatioImageView2 = itemImageTextCardChildBinding.imageView;
                Intrinsics.checkNotNullExpressionValue(aspectRatioImageView2, "binding.imageView");
                aspectRatioImageView2.setAspectRatio(0.5f);
            }
            AspectRatioImageView aspectRatioImageView3 = itemImageTextCardChildBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView3, "binding.imageView");
            ViewExtendsKt.darkForegroundIfNeed(aspectRatioImageView3);
            RecyclerView.LayoutManager layoutManager = this.parentHolder.getRecyclerView().getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                gridLayoutManager = layoutManager;
            }
            GridLayoutManager gridLayoutManager2 = gridLayoutManager;
            if (gridLayoutManager2 != null && gridLayoutManager2.getSpanCount() == 1) {
                z2 = true;
            }
            if (z2) {
                TextView textView = itemImageTextCardChildBinding.titleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                textView.setMinLines(1);
                TextView textView2 = itemImageTextCardChildBinding.titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setMaxLines(2);
                TextView textView3 = itemImageTextCardChildBinding.titleView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                textView3.setTextSize(16.0f);
                FrameLayout frameLayout4 = itemImageTextCardChildBinding.titleContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.titleContainer");
                FrameLayout frameLayout5 = frameLayout4;
                ViewGroup.LayoutParams layoutParams = frameLayout5.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = -2;
                    frameLayout5.setLayoutParams(layoutParams);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            itemImageTextCardChildBinding.titleView.setLines(2);
            TextView textView4 = itemImageTextCardChildBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
            textView4.setTextSize(14.0f);
            FrameLayout frameLayout6 = itemImageTextCardChildBinding.titleContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.titleContainer");
            FrameLayout frameLayout7 = frameLayout6;
            ViewGroup.LayoutParams layoutParams2 = frameLayout7.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = NumberExtendsKt.getDp((Number) 52);
                frameLayout7.setLayoutParams(layoutParams2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362205) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        String url = entity2.getUrl();
        Entity entity3 = this.entity;
        if (entity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        String title = entity3.getTitle();
        Entity entity4 = this.entity;
        if (entity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        ActionManagerCompat.startActivityByUrl(context, url, title, entity4.getSubTitle());
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = getComponent();
        String str = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        if (baseFragment != null) {
            str = baseFragment.getFixedRecordId();
        }
        Entity entity5 = this.entity;
        if (entity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        StatisticHelper.recordEntityEvent$default(instance, str, entity5, getAdapterPosition(), this.parentHolder.getCard(), null, 16, null);
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        Bitmap bitmap = null;
        if (!(drawable instanceof BitmapDrawable)) {
            drawable = null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            Palette.from(bitmap).generate(new ImageTextCardChildViewHolder$onLoadComplete$1(this));
        }
    }
}
