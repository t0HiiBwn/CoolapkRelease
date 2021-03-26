package com.coolapk.market.view.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemRelativeChildBinding;
import com.coolapk.market.databinding.ItemSponsorSelfDrawBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.ad.EntityAdHelper;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.view.SimpleImageView;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/ad/SponsorSelfDrawViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "view", "Landroid/view/View;", "entityAdHelper", "Lcom/coolapk/market/view/ad/EntityAdHelper;", "(Landroid/view/View;Lcom/coolapk/market/view/ad/EntityAdHelper;)V", "binding", "Lcom/coolapk/market/databinding/ItemSponsorSelfDrawBinding;", "kotlin.jvm.PlatformType", "data", "Lcom/coolapk/market/model/Entity;", "lastAd", "", "bindTo", "", "getPositionInDataList", "", "onAdBan", "adInfo", "Lcom/coolapk/market/view/ad/AdInfo;", "onAdClose", "onAdLoadFail", "onAdLoadSuccess", "selfDrawForGDT", "ad", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "selfDrawForTTFeedAd", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "updateContentView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawViewHolder.kt */
public final class SponsorSelfDrawViewHolder extends BindingViewHolder implements EntityAdHelper.AdViewHolderCallback {
    public static final Companion Companion = new Companion(null);
    private static final Integer[] ICONS = {2131231749, 2131231746, 2131231751};
    public static final int LAYOUT_ID = 2131558946;
    private final ItemSponsorSelfDrawBinding binding;
    private Entity data;
    private final EntityAdHelper entityAdHelper;
    private Object lastAd;

    public static final /* synthetic */ Entity access$getData$p(SponsorSelfDrawViewHolder sponsorSelfDrawViewHolder) {
        Entity entity = sponsorSelfDrawViewHolder.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return entity;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SponsorSelfDrawViewHolder(View view, EntityAdHelper entityAdHelper2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(entityAdHelper2, "entityAdHelper");
        this.entityAdHelper = entityAdHelper2;
        ItemSponsorSelfDrawBinding itemSponsorSelfDrawBinding = (ItemSponsorSelfDrawBinding) getBinding();
        this.binding = itemSponsorSelfDrawBinding;
        itemSponsorSelfDrawBinding.contentView.setAspectRatio(1.7777778f);
        itemSponsorSelfDrawBinding.contentView.removeAllViews();
        itemSponsorSelfDrawBinding.relativeView.iconView.setImageResource(2131231753);
        TextView textView = itemSponsorSelfDrawBinding.relativeView.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.relativeView.titleView");
        textView.setText("立即查看");
        ItemRelativeChildBinding itemRelativeChildBinding = itemSponsorSelfDrawBinding.relativeView;
        Intrinsics.checkNotNullExpressionValue(itemRelativeChildBinding, "binding.relativeView");
        View root = itemRelativeChildBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.relativeView.root");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(ResourceUtils.resolveData(getContext(), 2130968793));
        Unit unit = Unit.INSTANCE;
        root.setBackground(gradientDrawable);
        ItemRelativeChildBinding itemRelativeChildBinding2 = itemSponsorSelfDrawBinding.relativeView;
        Intrinsics.checkNotNullExpressionValue(itemRelativeChildBinding2, "binding.relativeView");
        View root2 = itemRelativeChildBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.relativeView.root");
        ViewExtendsKt.clipView$default(root2, 0, NumberExtendsKt.getDpf((Number) 3), 1, null);
        SimpleImageView simpleImageView = itemSponsorSelfDrawBinding.relativeView.iconView;
        Intrinsics.checkNotNullExpressionValue(simpleImageView, "binding.relativeView.iconView");
        ViewExtendsKt.clipView$default(simpleImageView, 0, NumberExtendsKt.getDpf((Number) 2), 1, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/ad/SponsorSelfDrawViewHolder$Companion;", "", "()V", "ICONS", "", "", "[Ljava/lang/Integer;", "LAYOUT_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SponsorSelfDrawViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        Entity entity = (Entity) obj;
        this.data = entity;
        this.binding.closeView.setOnClickListener(new SponsorSelfDrawViewHolder$bindTo$1(this, obj));
        this.entityAdHelper.requestLoadAd(entity, this);
        this.binding.adTextView.setBackgroundColor(AppHolder.getAppTheme().isDarkTheme() ? (int) 4280821800L : 561345909);
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdLoadSuccess() {
        Object firstData;
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        FeedAdSource findFeedAdSource = entityAdHelper2.findFeedAdSource(EntityExtendsKt.entityUniqueId(entity));
        if (findFeedAdSource != null && (firstData = findFeedAdSource.firstData()) != null) {
            Object obj = this.lastAd;
            this.lastAd = firstData;
            if ((firstData instanceof NativeUnifiedADData) && obj != firstData) {
                selfDrawForGDT((NativeUnifiedADData) firstData);
            } else if (firstData instanceof TTFeedAd) {
                selfDrawForTTFeedAd((TTFeedAd) firstData);
            }
        }
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdLoadFail() {
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        entityAdHelper2.requestCloseAd(EntityExtendsKt.entityUniqueId(entity), getAdapterPosition());
    }

    private final void selfDrawForGDT(NativeUnifiedADData nativeUnifiedADData) {
        String str;
        TextView textView = this.binding.relativeView.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.relativeView.titleView");
        if (nativeUnifiedADData.isAppAd()) {
        }
        textView.setText(str);
        this.binding.relativeView.iconView.setImageResource(2131231750);
        NativeAdContainer nativeAdContainer = this.binding.nativeAdContainer;
        Intrinsics.checkNotNullExpressionValue(nativeAdContainer, "binding.nativeAdContainer");
        if (!Intrinsics.areEqual(nativeAdContainer.getParent(), this.binding.coolapkCardView)) {
            NativeAdContainer nativeAdContainer2 = this.binding.nativeAdContainer;
            Intrinsics.checkNotNullExpressionValue(nativeAdContainer2, "binding.nativeAdContainer");
            ViewExtendsKt.detachFromParent(nativeAdContainer2);
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            ViewExtendsKt.detachFromParent(linearLayout);
            this.binding.coolapkCardView.removeAllViews();
            this.binding.coolapkCardView.addView(this.binding.nativeAdContainer, -1, -2);
            this.binding.nativeAdContainer.addView(this.binding.itemView, -1, -2);
        }
        this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawViewHolder$selfDrawForGDT$1(this, nativeUnifiedADData));
        updateContentView(nativeUnifiedADData);
    }

    private final void updateContentView(NativeUnifiedADData nativeUnifiedADData) {
        TextView textView = this.binding.topTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.topTextView");
        textView.setText(nativeUnifiedADData.getTitle());
        TextView textView2 = this.binding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        textView2.setText(nativeUnifiedADData.getDesc());
        this.binding.contentView.removeAllViews();
        Function1<? super Integer, Unit> function1 = null;
        this.binding.contentView.setOnMeasureWidth(function1);
        MediaView mediaView = this.binding.mediaView;
        Intrinsics.checkNotNullExpressionValue(mediaView, "binding.mediaView");
        EntityAdHelperKt.removeLastDelayAutoPlayListener(mediaView);
        int adPatternType = nativeUnifiedADData.getAdPatternType();
        if (adPatternType == 1) {
            AppHolder.getContextImageLoader().displayImage(getContext(), nativeUnifiedADData.getIconUrl(), this.binding.topImageView, 2131231162);
            MaxWidthFrameLayout maxWidthFrameLayout = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.contentView");
            maxWidthFrameLayout.setVisibility(0);
            this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawViewHolder$updateContentView$3(this));
            this.binding.contentView.addView(this.binding.contentImageView);
            AppHolder.getContextImageLoader().displayImage(getContext(), nativeUnifiedADData.getImgUrl(), this.binding.contentImageView, 2131231707);
        } else if (adPatternType == 2) {
            ImageView imageView = this.binding.topImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.topImageView");
            imageView.setVisibility(0);
            AppHolder.getContextImageLoader().displayImage(getContext(), nativeUnifiedADData.getIconUrl(), this.binding.topImageView, ImageLoaderOptions.newBuilder().placeHolder(new ColorDrawable(-16777216)).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
            MaxWidthFrameLayout maxWidthFrameLayout2 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.contentView");
            maxWidthFrameLayout2.setVisibility(0);
            this.binding.contentView.addView(this.binding.contentImageView);
            this.binding.contentView.addView(this.binding.mediaView);
            this.binding.contentView.setOnMeasureWidth(function1);
            ImageView imageView2 = this.binding.contentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.contentImageView");
            ImageView imageView3 = imageView2;
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                imageView3.setLayoutParams(layoutParams);
                AppHolder.getContextImageLoader().displayImage(getContext(), nativeUnifiedADData.getImgUrl(), this.binding.contentImageView, 2131231707);
                this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawViewHolder$updateContentView$2(this, nativeUnifiedADData));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        } else if (adPatternType == 3) {
            List<String> imgList = nativeUnifiedADData.getImgList();
            int abs = Math.abs(nativeUnifiedADData.getTitle().hashCode());
            Integer[] numArr = ICONS;
            this.binding.topImageView.setImageResource(numArr[abs % numArr.length].intValue());
            MaxWidthFrameLayout maxWidthFrameLayout3 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout3, "binding.contentView");
            maxWidthFrameLayout3.setVisibility(0);
            this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawViewHolder$updateContentView$4(this));
            this.binding.contentView.addView(this.binding.content3ImageContainer);
            AppHolder.getContextImageLoader().displayImage(getContext(), imgList.get(0), this.binding.contentImage1View, 2131231707);
            AppHolder.getContextImageLoader().displayImage(getContext(), imgList.get(1), this.binding.contentImage2View, 2131231707);
            AppHolder.getContextImageLoader().displayImage(getContext(), imgList.get(2), this.binding.contentImage3View, 2131231707);
        } else if (adPatternType == 4) {
            AppHolder.getContextImageLoader().displayImage(getContext(), nativeUnifiedADData.getImgUrl(), this.binding.topImageView, 2131231162);
            MaxWidthFrameLayout maxWidthFrameLayout4 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout4, "binding.contentView");
            maxWidthFrameLayout4.setVisibility(8);
        }
    }

    private final void selfDrawForTTFeedAd(TTFeedAd tTFeedAd) {
        String str;
        Activity currentActivity;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        if (UiUtils.getActivityNullable(context) == null && (currentActivity = AppHolder.getCurrentActivity()) != null) {
            tTFeedAd.setActivityForDownloadApp(currentActivity);
            Unit unit = Unit.INSTANCE;
        }
        TextView textView = this.binding.relativeView.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.relativeView.titleView");
        if (tTFeedAd.getInteractionType() == 4) {
        }
        textView.setText(str);
        this.binding.relativeView.iconView.setImageResource(2131231748);
        NativeAdContainer nativeAdContainer = this.binding.nativeAdContainer;
        Intrinsics.checkNotNullExpressionValue(nativeAdContainer, "binding.nativeAdContainer");
        if (Intrinsics.areEqual(nativeAdContainer.getParent(), this.binding.coolapkCardView)) {
            NativeAdContainer nativeAdContainer2 = this.binding.nativeAdContainer;
            Intrinsics.checkNotNullExpressionValue(nativeAdContainer2, "binding.nativeAdContainer");
            ViewExtendsKt.detachFromParent(nativeAdContainer2);
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            ViewExtendsKt.detachFromParent(linearLayout);
            this.binding.coolapkCardView.removeAllViews();
            this.binding.coolapkCardView.addView(this.binding.itemView, -1, -2);
        }
        updateContentView(tTFeedAd);
    }

    private final void updateContentView(TTFeedAd tTFeedAd) {
        this.binding.contentView.removeAllViews();
        this.binding.ttMediaView.removeAllViews();
        String str = null;
        Function1<? super Integer, Unit> function1 = null;
        this.binding.contentView.setOnMeasureWidth(function1);
        ArrayList arrayList = new ArrayList();
        int imageMode = tTFeedAd.getImageMode();
        boolean z = true;
        if (imageMode == 2 || imageMode == 3) {
            MaxWidthFrameLayout maxWidthFrameLayout = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.contentView");
            maxWidthFrameLayout.setVisibility(0);
            this.binding.contentView.setOnMeasureWidth(function1);
            ImageView imageView = this.binding.contentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.contentImageView");
            ImageView imageView2 = imageView;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                imageView2.setLayoutParams(layoutParams);
                this.binding.contentView.addView(this.binding.contentImageView);
                List<TTImage> imageList = tTFeedAd.getImageList();
                Intrinsics.checkNotNullExpressionValue(imageList, "ad.imageList");
                TTImage tTImage = (TTImage) CollectionsKt.firstOrNull((List<? extends Object>) imageList);
                AppHolder.getContextImageLoader().displayImage(getContext(), tTImage != null ? tTImage.getImageUrl() : null, this.binding.contentImageView, 2131231707);
                ImageView imageView3 = this.binding.contentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.contentImageView");
                arrayList.add(imageView3);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        } else if (imageMode == 4) {
            MaxWidthFrameLayout maxWidthFrameLayout2 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.contentView");
            maxWidthFrameLayout2.setVisibility(0);
            this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawViewHolder$updateContentView$5(this));
            this.binding.contentView.addView(this.binding.content3ImageContainer);
            List<TTImage> imageList2 = tTFeedAd.getImageList();
            GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(imageList2, "imageList");
            TTImage tTImage2 = (TTImage) CollectionsKt.getOrNull(imageList2, 0);
            contextImageLoader.displayImage(context, tTImage2 != null ? tTImage2.getImageUrl() : null, this.binding.contentImage1View, 2131231707);
            GlideContextImageLoader contextImageLoader2 = AppHolder.getContextImageLoader();
            Context context2 = getContext();
            TTImage tTImage3 = (TTImage) CollectionsKt.getOrNull(imageList2, 1);
            contextImageLoader2.displayImage(context2, tTImage3 != null ? tTImage3.getImageUrl() : null, this.binding.contentImage2View, 2131231707);
            GlideContextImageLoader contextImageLoader3 = AppHolder.getContextImageLoader();
            Context context3 = getContext();
            TTImage tTImage4 = (TTImage) CollectionsKt.getOrNull(imageList2, 2);
            contextImageLoader3.displayImage(context3, tTImage4 != null ? tTImage4.getImageUrl() : null, this.binding.contentImage3View, 2131231707);
            arrayList.addAll(CollectionsKt.listOf((Object[]) new ImageView[]{this.binding.contentImage1View, this.binding.contentImage2View, this.binding.contentImage3View}));
        } else if (imageMode == 5 || imageMode == 15) {
            MaxWidthFrameLayout maxWidthFrameLayout3 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout3, "binding.contentView");
            maxWidthFrameLayout3.setVisibility(0);
            this.binding.contentView.addView(this.binding.contentImageView);
            List<TTImage> imageList3 = tTFeedAd.getImageList();
            Intrinsics.checkNotNullExpressionValue(imageList3, "ad.imageList");
            TTImage tTImage5 = (TTImage) CollectionsKt.firstOrNull((List<? extends Object>) imageList3);
            AppHolder.getContextImageLoader().displayImage(getContext(), tTImage5 != null ? tTImage5.getImageUrl() : null, this.binding.contentImageView, ImageLoaderOptions.newBuilder().placeHolder(new ColorDrawable(-16777216)).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
            ImageView imageView4 = this.binding.contentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.contentImageView");
            arrayList.add(imageView4);
            ImageView imageView5 = this.binding.contentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.contentImageView");
            ImageView imageView6 = imageView5;
            ViewGroup.LayoutParams layoutParams2 = imageView6.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                imageView6.setLayoutParams(layoutParams2);
                tTFeedAd.setVideoAdListener(EntityAdHelperKt.getSIMPLE_TT_VIDEO_CALLBACK());
                FrameLayout frameLayout = this.binding.ttMediaView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.ttMediaView");
                arrayList.add(frameLayout);
                View adView = tTFeedAd.getAdView();
                int adViewWidth = tTFeedAd.getAdViewWidth();
                int adViewHeight = tTFeedAd.getAdViewHeight();
                this.binding.contentView.addView(this.binding.ttMediaView);
                this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawViewHolder$updateContentView$9(this, adViewWidth, adViewHeight));
                this.binding.contentView.postDelayed(new SponsorSelfDrawViewHolder$sam$java_lang_Runnable$0(new SponsorSelfDrawViewHolder$updateContentView$runnable$1(this, adView, tTFeedAd)), 1000);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        } else if (imageMode != 16) {
            MaxWidthFrameLayout maxWidthFrameLayout4 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout4, "binding.contentView");
            maxWidthFrameLayout4.setVisibility(0);
        } else {
            MaxWidthFrameLayout maxWidthFrameLayout5 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout5, "binding.contentView");
            maxWidthFrameLayout5.setVisibility(0);
            this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawViewHolder$updateContentView$6(this));
            this.binding.contentView.addView(this.binding.contentImageView);
            List<TTImage> imageList4 = tTFeedAd.getImageList();
            Intrinsics.checkNotNullExpressionValue(imageList4, "ad.imageList");
            TTImage tTImage6 = (TTImage) CollectionsKt.firstOrNull((List<? extends Object>) imageList4);
            AppHolder.getContextImageLoader().displayImage(getContext(), tTImage6 != null ? tTImage6.getImageUrl() : null, this.binding.contentImageView, 2131231707);
            ImageView imageView7 = this.binding.contentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView7, "binding.contentImageView");
            arrayList.add(imageView7);
        }
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        TTAdDislike dislikeDialog = tTFeedAd.getDislikeDialog(UiUtils.getActivityNullable(context4));
        if (dislikeDialog != null) {
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            tTFeedAd.getDislikeDialog(UiUtils.getActivityNullable(context5)).setDislikeInteractionCallback(new SponsorSelfDrawViewHolder$updateContentView$10(this));
        }
        this.binding.closeView.setOnClickListener(new SponsorSelfDrawViewHolder$updateContentView$11(dislikeDialog));
        this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawViewHolder$updateContentView$12(this, tTFeedAd, arrayList));
        TextView textView = this.binding.topTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.topTextView");
        textView.setText(tTFeedAd.getTitle());
        TextView textView2 = this.binding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        textView2.setText(tTFeedAd.getDescription());
        int abs = Math.abs(tTFeedAd.getTitle().hashCode());
        Integer[] numArr = ICONS;
        int intValue = numArr[abs % numArr.length].intValue();
        TTImage icon = tTFeedAd.getIcon();
        if (!(icon != null && icon.isValid())) {
            icon = null;
        }
        if (icon != null) {
            str = icon.getImageUrl();
        }
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (!z) {
            AppHolder.getContextImageLoader().displayImage(getContext(), str, this.binding.topImageView, ImageLoaderOptions.newBuilder().errorRes(intValue).placeHolderRes(intValue).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
        } else {
            this.binding.topImageView.setImageResource(intValue);
        }
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdClose() {
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdClose(this);
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        entityAdHelper2.requestCloseAd(EntityExtendsKt.entityUniqueId(entity), getAdapterPosition());
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdBan(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdBan(this, adInfo);
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        entityAdHelper2.requestCloseAd(EntityExtendsKt.entityUniqueId(entity), getAdapterPosition());
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public int getPositionInDataList() {
        return getAdapterPosition();
    }
}
