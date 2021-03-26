package com.coolapk.market.view.splash;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.SplashViewBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import java.io.File;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.ReplaySubject;
import rx.subscriptions.CompositeSubscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0002R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/splash/SplashViewV9;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/coolapk/market/databinding/SplashViewBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/SplashViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "subscription", "Lrx/subscriptions/CompositeSubscription;", "createLoadTask", "Lrx/Observable;", "", "destroy", "", "enterTheWallpaperFeed", "executeImageTask", "onDetachedFromWindow", "onImageLoad", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashViewV9.kt */
public final class SplashViewV9 extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private final Lazy binding$delegate = LazyKt.lazy(new SplashViewV9$binding$2(this));
    private final CompositeSubscription subscription = new CompositeSubscription();

    private final SplashViewBinding getBinding() {
        return (SplashViewBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashViewV9(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        FrameLayout frameLayout = getBinding().clickView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.clickView");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).height = DisplayUtils.getHeightPixels(getContext()) / 2;
        executeImageTask();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashViewV9(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        FrameLayout frameLayout = getBinding().clickView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.clickView");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).height = DisplayUtils.getHeightPixels(getContext()) / 2;
        executeImageTask();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashViewV9(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        FrameLayout frameLayout = getBinding().clickView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.clickView");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).height = DisplayUtils.getHeightPixels(getContext()) / 2;
        executeImageTask();
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
            EntityCard imageCard = appSetting.getImageCard();
            File splashImageFile = AppHolder.getAppSetting().getSplashImageFile(context);
            return (imageCard == null || splashImageFile == null || !splashImageFile.exists()) ? false : true;
        }
    }

    private final void executeImageTask() {
        this.subscription.add(createLoadTask().observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super Boolean>) new SplashViewV9$executeImageTask$subscription$1()));
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final Observable<Boolean> createLoadTask() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        File splashImageFile = AppHolder.getAppSetting().getSplashImageFile(getContext());
        if (imageCard == null || splashImageFile == null || !splashImageFile.exists()) {
            Observable<Boolean> just = Observable.just(false);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(false)");
            return just;
        }
        ReplaySubject create = ReplaySubject.create();
        Observable<Boolean> asObservable = create.asObservable();
        Intrinsics.checkNotNullExpressionValue(asObservable, "replaySubject.asObservable()");
        Intrinsics.checkNotNullExpressionValue(GlideApp.with(getContext()).load(splashImageFile.toURI().toString()).diskCacheStrategy(DiskCacheStrategy.DATA).listener((RequestListener) new SplashViewV9$createLoadTask$1(this, create)).into(getBinding().imageView), "GlideApp.with(context)\n … .into(binding.imageView)");
        return asObservable;
    }

    /* access modifiers changed from: private */
    public final void onImageLoad() {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        ThemeUtils.setNavigationBarColor((Activity) context, 1711276032);
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        if (imageCard != null) {
            AppHolder.getAppSetting().markImageLoaded();
            TextView textView = getBinding().userNameView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameView");
            textView.setText(imageCard.getDescription());
            getBinding().clickView.setOnClickListener(new SplashViewV9$onImageLoad$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void enterTheWallpaperFeed() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        if (imageCard != null) {
            String url = imageCard.getUrl();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl(context, url, imageCard.getTitle(), imageCard.getSubTitle());
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroy();
    }

    private final void destroy() {
        RxUtils.unsubscribe(this.subscription);
    }
}
