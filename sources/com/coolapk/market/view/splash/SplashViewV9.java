package com.coolapk.market.view.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.SplashViewBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.widget.view.ShapedImageView;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001,B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ4\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&2\u0006\u0010'\u001a\u00020 H\u0016J>\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010'\u001a\u00020 H\u0016R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R#\u0010\u001a\u001a\n \u000f*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/coolapk/market/view/splash/SplashViewV9;", "Landroid/widget/FrameLayout;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/coolapk/market/databinding/SplashViewBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/SplashViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "eventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "getEventListener", "()Lcom/coolapk/market/view/ad/OnAdEventListener;", "setEventListener", "(Lcom/coolapk/market/view/ad/OnAdEventListener;)V", "imageCard", "Lcom/coolapk/market/model/EntityCard;", "getImageCard", "()Lcom/coolapk/market/model/EntityCard;", "imageCard$delegate", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashViewV9.kt */
public final class SplashViewV9 extends FrameLayout implements RequestListener<Drawable> {
    public static final Companion Companion = new Companion(null);
    private final Lazy binding$delegate = LazyKt.lazy(new SplashViewV9$binding$2(this));
    private OnAdEventListener eventListener;
    private final Lazy imageCard$delegate = LazyKt.lazy(SplashViewV9$imageCard$2.INSTANCE);

    /* access modifiers changed from: private */
    public final SplashViewBinding getBinding() {
        return (SplashViewBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EntityCard getImageCard() {
        return (EntityCard) this.imageCard$delegate.getValue();
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    public SplashViewV9(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        if (getImageCard() != null) {
            GlideRequests with = GlideApp.with(this);
            EntityCard imageCard = getImageCard();
            Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
            with.load(imageCard.getPic()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener((RequestListener) this).into(getBinding().imageView);
            getBinding().imageView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.coolapk.market.view.splash.SplashViewV9.AnonymousClass1 */
                final /* synthetic */ SplashViewV9 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    EntityCard imageCard = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
                    String url = imageCard.getUrl();
                    EntityCard imageCard2 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard2, "imageCard");
                    String title = imageCard2.getTitle();
                    EntityCard imageCard3 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard3, "imageCard");
                    ActionManagerCompat.startActivityByUrl(context, url, title, imageCard3.getSubTitle());
                    EntityCard imageCard4 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard4, "imageCard");
                    String title2 = imageCard4.getTitle();
                    if (title2 == null) {
                        EntityCard imageCard5 = this.this$0.getImageCard();
                        Intrinsics.checkNotNullExpressionValue(imageCard5, "imageCard");
                        title2 = imageCard5.getPic();
                    }
                    if (title2 != null) {
                        StatisticHelper.Companion.getInstance().recordSplashClick(title2);
                    }
                    OnAdEventListener eventListener = this.this$0.getEventListener();
                    if (eventListener != null) {
                        ShapedImageView shapedImageView = this.this$0.getBinding().imageView;
                        Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.imageView");
                        eventListener.onAdClick(shapedImageView, this.this$0.getImageCard());
                    }
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    public SplashViewV9(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        if (getImageCard() != null) {
            GlideRequests with = GlideApp.with(this);
            EntityCard imageCard = getImageCard();
            Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
            with.load(imageCard.getPic()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener((RequestListener) this).into(getBinding().imageView);
            getBinding().imageView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.coolapk.market.view.splash.SplashViewV9.AnonymousClass1 */
                final /* synthetic */ SplashViewV9 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    EntityCard imageCard = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
                    String url = imageCard.getUrl();
                    EntityCard imageCard2 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard2, "imageCard");
                    String title = imageCard2.getTitle();
                    EntityCard imageCard3 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard3, "imageCard");
                    ActionManagerCompat.startActivityByUrl(context, url, title, imageCard3.getSubTitle());
                    EntityCard imageCard4 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard4, "imageCard");
                    String title2 = imageCard4.getTitle();
                    if (title2 == null) {
                        EntityCard imageCard5 = this.this$0.getImageCard();
                        Intrinsics.checkNotNullExpressionValue(imageCard5, "imageCard");
                        title2 = imageCard5.getPic();
                    }
                    if (title2 != null) {
                        StatisticHelper.Companion.getInstance().recordSplashClick(title2);
                    }
                    OnAdEventListener eventListener = this.this$0.getEventListener();
                    if (eventListener != null) {
                        ShapedImageView shapedImageView = this.this$0.getBinding().imageView;
                        Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.imageView");
                        eventListener.onAdClick(shapedImageView, this.this$0.getImageCard());
                    }
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    public SplashViewV9(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        if (getImageCard() != null) {
            GlideRequests with = GlideApp.with(this);
            EntityCard imageCard = getImageCard();
            Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
            with.load(imageCard.getPic()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener((RequestListener) this).into(getBinding().imageView);
            getBinding().imageView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.coolapk.market.view.splash.SplashViewV9.AnonymousClass1 */
                final /* synthetic */ SplashViewV9 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    EntityCard imageCard = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
                    String url = imageCard.getUrl();
                    EntityCard imageCard2 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard2, "imageCard");
                    String title = imageCard2.getTitle();
                    EntityCard imageCard3 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard3, "imageCard");
                    ActionManagerCompat.startActivityByUrl(context, url, title, imageCard3.getSubTitle());
                    EntityCard imageCard4 = this.this$0.getImageCard();
                    Intrinsics.checkNotNullExpressionValue(imageCard4, "imageCard");
                    String title2 = imageCard4.getTitle();
                    if (title2 == null) {
                        EntityCard imageCard5 = this.this$0.getImageCard();
                        Intrinsics.checkNotNullExpressionValue(imageCard5, "imageCard");
                        title2 = imageCard5.getPic();
                    }
                    if (title2 != null) {
                        StatisticHelper.Companion.getInstance().recordSplashClick(title2);
                    }
                    OnAdEventListener eventListener = this.this$0.getEventListener();
                    if (eventListener != null) {
                        ShapedImageView shapedImageView = this.this$0.getBinding().imageView;
                        Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.imageView");
                        eventListener.onAdClick(shapedImageView, this.this$0.getImageCard());
                    }
                }
            });
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/splash/SplashViewV9$Companion;", "", "()V", "hasData", "", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SplashViewV9.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean hasData(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            return appSetting.getImageCard() != null;
        }
    }

    public final OnAdEventListener getEventListener() {
        return this.eventListener;
    }

    public final void setEventListener(OnAdEventListener onAdEventListener) {
        this.eventListener = onAdEventListener;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        if (getImageCard() == null) {
            return false;
        }
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        ThemeUtils.setNavigationBarColor((Activity) context, 1711276032);
        AppHolder.getAppSetting().markImageLoaded();
        EntityCard imageCard = getImageCard();
        Intrinsics.checkNotNullExpressionValue(imageCard, "imageCard");
        String title = imageCard.getTitle();
        if (title == null) {
            EntityCard imageCard2 = getImageCard();
            Intrinsics.checkNotNullExpressionValue(imageCard2, "imageCard");
            title = imageCard2.getPic();
        }
        if (title != null) {
            StatisticHelper.Companion.getInstance().recordSplashExpose(title);
        }
        OnAdEventListener onAdEventListener = this.eventListener;
        if (onAdEventListener == null) {
            return false;
        }
        onAdEventListener.onAdShow(getImageCard());
        return false;
    }
}
