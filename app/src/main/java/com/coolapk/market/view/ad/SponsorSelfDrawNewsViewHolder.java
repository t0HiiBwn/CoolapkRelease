package com.coolapk.market.view.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSponsorSelfDrawNewsBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.ad.EntityAdHelper;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
public final class SponsorSelfDrawNewsViewHolder extends BindingViewHolder implements EntityAdHelper.AdViewHolderCallback {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558940;
    private final ItemSponsorSelfDrawNewsBinding binding;
    private Entity data;
    private final EntityAdHelper entityAdHelper;
    private Object lastAd;

    public static final /* synthetic */ Entity access$getData$p(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder) {
        Entity entity = sponsorSelfDrawNewsViewHolder.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return entity;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SponsorSelfDrawNewsViewHolder(View view, EntityAdHelper entityAdHelper2, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(entityAdHelper2, "entityAdHelper");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.entityAdHelper = entityAdHelper2;
        ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding = (ItemSponsorSelfDrawNewsBinding) getBinding();
        this.binding = itemSponsorSelfDrawNewsBinding;
        itemSponsorSelfDrawNewsBinding.contentView.setAspectRatio(1.7777778f);
        itemSponsorSelfDrawNewsBinding.contentView.removeAllViews();
    }

    /* compiled from: SponsorSelfDrawNewsViewHolder.kt */
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
        this.binding.closeView.setOnClickListener(new SponsorSelfDrawNewsViewHolder$bindTo$1(this, obj));
        this.entityAdHelper.requestLoadAd(entity, this);
        this.binding.adTextView.setBackgroundColor(AppHolder.getAppTheme().isDarkTheme() ? (int) 4280821800L : 561345909);
        int widthPixels = (DisplayUtils.getWidthPixels(getContext()) - NumberExtendsKt.getDp((Number) 50)) / 3;
        CardView cardView = this.binding.imageCardView;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.imageCardView");
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        layoutParams.width = widthPixels;
        layoutParams.height = (int) (((double) widthPixels) * 0.75d);
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
        if (findFeedAdSource != null && (firstData = findFeedAdSource.firstData()) != null && this.lastAd != firstData) {
            this.lastAd = firstData;
            if (firstData instanceof NativeUnifiedADData) {
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
        NativeAdContainer nativeAdContainer = this.binding.nativeAdContainer;
        Intrinsics.checkNotNullExpressionValue(nativeAdContainer, "binding.nativeAdContainer");
        if (!Intrinsics.areEqual(nativeAdContainer.getParent(), this.binding.coolapkCardView)) {
            NativeAdContainer nativeAdContainer2 = this.binding.nativeAdContainer;
            Intrinsics.checkNotNullExpressionValue(nativeAdContainer2, "binding.nativeAdContainer");
            ViewExtendsKt.detachFromParent(nativeAdContainer2);
            RelativeLayout relativeLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.itemView");
            ViewExtendsKt.detachFromParent(relativeLayout);
            this.binding.coolapkCardView.removeAllViews();
            this.binding.coolapkCardView.addView(this.binding.nativeAdContainer, -1, -2);
            this.binding.nativeAdContainer.addView(this.binding.itemView, -1, -2);
        }
        this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawNewsViewHolder$selfDrawForGDT$1(this, nativeUnifiedADData));
        updateContentView(nativeUnifiedADData);
    }

    private final void updateContentView(NativeUnifiedADData nativeUnifiedADData) {
        TextView textView = this.binding.leftBottomText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.leftBottomText");
        textView.setText("广点通·" + nativeUnifiedADData.getTitle());
        CoolEllipsizeTextView coolEllipsizeTextView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
        coolEllipsizeTextView.setText(nativeUnifiedADData.getDesc());
        this.binding.contentView.removeAllViews();
        Function1<? super Integer, Unit> function1 = null;
        this.binding.contentView.setOnMeasureWidth(function1);
        MediaView mediaView = this.binding.mediaView;
        Intrinsics.checkNotNullExpressionValue(mediaView, "binding.mediaView");
        EntityAdHelperKt.removeLastDelayAutoPlayListener(mediaView);
        int adPatternType = nativeUnifiedADData.getAdPatternType();
        if (adPatternType == 1) {
            ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding, "binding");
            itemSponsorSelfDrawNewsBinding.setImageUrl(nativeUnifiedADData.getImgUrl());
            MaxWidthFrameLayout maxWidthFrameLayout = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.contentView");
            maxWidthFrameLayout.setVisibility(8);
        } else if (adPatternType == 2) {
            ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding2 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding2, "binding");
            itemSponsorSelfDrawNewsBinding2.setImageUrl(null);
            MaxWidthFrameLayout maxWidthFrameLayout2 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.contentView");
            maxWidthFrameLayout2.setVisibility(0);
            this.binding.contentView.addView(this.binding.contentImageView);
            this.binding.contentView.addView(this.binding.mediaView);
            this.binding.contentView.setOnMeasureWidth(function1);
            ImageView imageView = this.binding.contentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.contentImageView");
            ImageView imageView2 = imageView;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                imageView2.setLayoutParams(layoutParams);
                AppHolder.getContextImageLoader().displayImage(getContext(), nativeUnifiedADData.getImgUrl(), this.binding.contentImageView);
                this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawNewsViewHolder$updateContentView$2(this, nativeUnifiedADData));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        } else if (adPatternType == 3) {
            ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding3 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding3, "binding");
            itemSponsorSelfDrawNewsBinding3.setImageUrl(null);
            List<String> imgList = nativeUnifiedADData.getImgList();
            MaxWidthFrameLayout maxWidthFrameLayout3 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout3, "binding.contentView");
            maxWidthFrameLayout3.setVisibility(0);
            this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawNewsViewHolder$updateContentView$3(this));
            this.binding.contentView.addView(this.binding.content3ImageContainer);
            AppHolder.getContextImageLoader().displayImage(getContext(), imgList.get(0), this.binding.contentImage1View);
            AppHolder.getContextImageLoader().displayImage(getContext(), imgList.get(1), this.binding.contentImage2View);
            AppHolder.getContextImageLoader().displayImage(getContext(), imgList.get(2), this.binding.contentImage3View);
        } else if (adPatternType == 4) {
            ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding4 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding4, "binding");
            itemSponsorSelfDrawNewsBinding4.setImageUrl(null);
            MaxWidthFrameLayout maxWidthFrameLayout4 = this.binding.contentView;
            Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout4, "binding.contentView");
            maxWidthFrameLayout4.setVisibility(8);
        }
        this.binding.executePendingBindings();
    }

    private final void selfDrawForTTFeedAd(TTFeedAd tTFeedAd) {
        Activity currentActivity;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        if (UiUtils.getActivityNullable(context) == null && (currentActivity = AppHolder.getCurrentActivity()) != null) {
            tTFeedAd.setActivityForDownloadApp(currentActivity);
            Unit unit = Unit.INSTANCE;
        }
        NativeAdContainer nativeAdContainer = this.binding.nativeAdContainer;
        Intrinsics.checkNotNullExpressionValue(nativeAdContainer, "binding.nativeAdContainer");
        if (Intrinsics.areEqual(nativeAdContainer.getParent(), this.binding.coolapkCardView)) {
            NativeAdContainer nativeAdContainer2 = this.binding.nativeAdContainer;
            Intrinsics.checkNotNullExpressionValue(nativeAdContainer2, "binding.nativeAdContainer");
            ViewExtendsKt.detachFromParent(nativeAdContainer2);
            RelativeLayout relativeLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.itemView");
            ViewExtendsKt.detachFromParent(relativeLayout);
            this.binding.coolapkCardView.removeAllViews();
            this.binding.coolapkCardView.addView(this.binding.itemView, -1, -2);
        }
        updateContentView(tTFeedAd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x021f  */
    private final void updateContentView(TTFeedAd tTFeedAd) {
        TTAdDislike dislikeDialog;
        this.binding.contentView.removeAllViews();
        this.binding.ttMediaView.removeAllViews();
        String str = null;
        this.binding.contentView.setOnMeasureWidth(null);
        ArrayList arrayList = new ArrayList();
        int imageMode = tTFeedAd.getImageMode();
        if (!(imageMode == 2 || imageMode == 3)) {
            if (imageMode == 4) {
                ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding, "binding");
                itemSponsorSelfDrawNewsBinding.setImageUrl(null);
                MaxWidthFrameLayout maxWidthFrameLayout = this.binding.contentView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.contentView");
                maxWidthFrameLayout.setVisibility(0);
                this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawNewsViewHolder$updateContentView$4(this));
                this.binding.contentView.addView(this.binding.content3ImageContainer);
                List<TTImage> imageList = tTFeedAd.getImageList();
                GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(imageList, "imageList");
                TTImage tTImage = (TTImage) CollectionsKt.getOrNull(imageList, 0);
                contextImageLoader.displayImage(context, tTImage != null ? tTImage.getImageUrl() : null, this.binding.contentImage1View);
                GlideContextImageLoader contextImageLoader2 = AppHolder.getContextImageLoader();
                Context context2 = getContext();
                TTImage tTImage2 = (TTImage) CollectionsKt.getOrNull(imageList, 1);
                contextImageLoader2.displayImage(context2, tTImage2 != null ? tTImage2.getImageUrl() : null, this.binding.contentImage2View);
                GlideContextImageLoader contextImageLoader3 = AppHolder.getContextImageLoader();
                Context context3 = getContext();
                TTImage tTImage3 = (TTImage) CollectionsKt.getOrNull(imageList, 2);
                if (tTImage3 != null) {
                    str = tTImage3.getImageUrl();
                }
                contextImageLoader3.displayImage(context3, str, this.binding.contentImage3View);
                arrayList.addAll(CollectionsKt.listOf((Object[]) new ImageView[]{this.binding.contentImage1View, this.binding.contentImage2View, this.binding.contentImage3View}));
            } else if (imageMode == 5 || imageMode == 15) {
                ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding2 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding2, "binding");
                itemSponsorSelfDrawNewsBinding2.setImageUrl(null);
                MaxWidthFrameLayout maxWidthFrameLayout2 = this.binding.contentView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.contentView");
                maxWidthFrameLayout2.setVisibility(0);
                this.binding.contentView.addView(this.binding.contentImageView);
                List<TTImage> imageList2 = tTFeedAd.getImageList();
                Intrinsics.checkNotNullExpressionValue(imageList2, "ad.imageList");
                TTImage tTImage4 = (TTImage) CollectionsKt.firstOrNull((List<? extends Object>) imageList2);
                GlideContextImageLoader contextImageLoader4 = AppHolder.getContextImageLoader();
                Context context4 = getContext();
                if (tTImage4 != null) {
                    str = tTImage4.getImageUrl();
                }
                contextImageLoader4.displayImage(context4, str, this.binding.contentImageView);
                ImageView imageView = this.binding.contentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.contentImageView");
                arrayList.add(imageView);
                ImageView imageView2 = this.binding.contentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.contentImageView");
                ImageView imageView3 = imageView2;
                ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    imageView3.setLayoutParams(layoutParams);
                    tTFeedAd.setVideoAdListener(EntityAdHelperKt.getSIMPLE_TT_VIDEO_CALLBACK());
                    FrameLayout frameLayout = this.binding.ttMediaView;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.ttMediaView");
                    arrayList.add(frameLayout);
                    View adView = tTFeedAd.getAdView();
                    int adViewWidth = tTFeedAd.getAdViewWidth();
                    int adViewHeight = tTFeedAd.getAdViewHeight();
                    this.binding.contentView.addView(this.binding.ttMediaView);
                    this.binding.contentView.setOnMeasureWidth(new SponsorSelfDrawNewsViewHolder$updateContentView$6(this, adViewWidth, adViewHeight));
                    this.binding.contentView.postDelayed(new SponsorSelfDrawNewsViewHolder$sam$java_lang_Runnable$0(new SponsorSelfDrawNewsViewHolder$updateContentView$runnable$1(this, adView, tTFeedAd)), 1000);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else if (imageMode != 16) {
                MaxWidthFrameLayout maxWidthFrameLayout3 = this.binding.contentView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout3, "binding.contentView");
                maxWidthFrameLayout3.setVisibility(0);
            }
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            dislikeDialog = tTFeedAd.getDislikeDialog(UiUtils.getActivityNullable(context5));
            if (dislikeDialog != null) {
                Context context6 = getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "context");
                tTFeedAd.getDislikeDialog(UiUtils.getActivityNullable(context6)).setDislikeInteractionCallback(new SponsorSelfDrawNewsViewHolder$updateContentView$7(this));
            }
            this.binding.closeView.setOnClickListener(new SponsorSelfDrawNewsViewHolder$updateContentView$8(dislikeDialog));
            this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawNewsViewHolder$updateContentView$9(this, tTFeedAd, arrayList));
            TextView textView = this.binding.leftBottomText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.leftBottomText");
            textView.setText("穿山甲·" + tTFeedAd.getTitle());
            CoolEllipsizeTextView coolEllipsizeTextView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
            coolEllipsizeTextView.setText(tTFeedAd.getDescription());
            this.binding.executePendingBindings();
        }
        MaxWidthFrameLayout maxWidthFrameLayout4 = this.binding.contentView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout4, "binding.contentView");
        maxWidthFrameLayout4.setVisibility(8);
        List<TTImage> imageList3 = tTFeedAd.getImageList();
        Intrinsics.checkNotNullExpressionValue(imageList3, "ad.imageList");
        TTImage tTImage5 = (TTImage) CollectionsKt.firstOrNull((List<? extends Object>) imageList3);
        AppHolder.getContextImageLoader().displayImage(getContext(), tTImage5 != null ? tTImage5.getImageUrl() : null, this.binding.extraImageView);
        ItemSponsorSelfDrawNewsBinding itemSponsorSelfDrawNewsBinding3 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemSponsorSelfDrawNewsBinding3, "binding");
        if (tTImage5 != null) {
            str = tTImage5.getImageUrl();
        }
        itemSponsorSelfDrawNewsBinding3.setImageUrl(str);
        ImageView imageView4 = this.binding.extraImageView;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.extraImageView");
        arrayList.add(imageView4);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        dislikeDialog = tTFeedAd.getDislikeDialog(UiUtils.getActivityNullable(context5));
        if (dislikeDialog != null) {
        }
        this.binding.closeView.setOnClickListener(new SponsorSelfDrawNewsViewHolder$updateContentView$8(dislikeDialog));
        this.entityAdHelper.addNotBlockSmoothScrollTask(new SponsorSelfDrawNewsViewHolder$updateContentView$9(this, tTFeedAd, arrayList));
        TextView textView = this.binding.leftBottomText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.leftBottomText");
        textView.setText("穿山甲·" + tTFeedAd.getTitle());
        CoolEllipsizeTextView coolEllipsizeTextView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
        coolEllipsizeTextView.setText(tTFeedAd.getDescription());
        this.binding.executePendingBindings();
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
