package com.coolapk.market.view.photo;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.coolapk.market.util.UiUtils;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000fJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0006\u0010\u001f\u001a\u00020\u0016J\b\u0010 \u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/photo/SplashView;", "Landroid/widget/FrameLayout;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/coolapk/market/databinding/SplashViewBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/SplashViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "shouldAutoFinish", "", "showCountDown", "subscription", "Lrx/subscriptions/CompositeSubscription;", "createLoadTask", "Lrx/Observable;", "enterTheWallpaperFeed", "", "exeAutoFinish", "executeImageTask", "normalFinish", "onImageLoad", "setAutoFinish", "mAutoFinish", "setShowCountDown", "setVersionInfo", "show", "showWaitCount", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashView.kt */
public final class SplashView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static final int TIME_OUT_OF_IMAGE_LOAD = 2;
    private static final float TIME_OUT_OF_IMAGE_SHOW = 2.5f;
    private final Activity activity;
    private final Lazy binding$delegate;
    private boolean shouldAutoFinish;
    private boolean showCountDown;
    private final CompositeSubscription subscription;

    /* access modifiers changed from: private */
    public final SplashViewBinding getBinding() {
        return (SplashViewBinding) this.binding$delegate.getValue();
    }

    private SplashView(Activity activity2) {
        super(activity2);
        this.activity = activity2;
        this.binding$delegate = LazyKt.lazy(new SplashView$binding$2(this));
        this.subscription = new CompositeSubscription();
        SplashViewBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        binding.setTextColor(-1);
        LinearLayout linearLayout = getBinding().contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = UiUtils.getNavigationBarHeight(activity2);
        FrameLayout frameLayout = getBinding().clickView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.clickView");
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = DisplayUtils.getHeightPixels(getContext()) / 2;
        executeImageTask();
        if (this.showCountDown) {
            showWaitCount();
        }
    }

    public /* synthetic */ SplashView(Activity activity2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/photo/SplashView$Companion;", "", "()V", "TIME_OUT_OF_IMAGE_LOAD", "", "TIME_OUT_OF_IMAGE_SHOW", "", "create", "Lcom/coolapk/market/view/photo/SplashView;", "baseActivity", "Landroid/app/Activity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SplashView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SplashView create(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "baseActivity");
            return new SplashView(activity, null);
        }
    }

    public final SplashView setShowCountDown(boolean z) {
        this.showCountDown = z;
        return this;
    }

    public final SplashView setAutoFinish(boolean z) {
        this.shouldAutoFinish = z;
        return this;
    }

    public final void show() {
        Window window = this.activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Objects.requireNonNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(this, new ViewGroup.LayoutParams(-1, -1));
        setClickable(true);
    }

    private final void executeImageTask() {
        this.subscription.add(createLoadTask().ambWith(Observable.timer((long) 2, TimeUnit.SECONDS).map(SplashView$executeImageTask$subscription$1.INSTANCE)).take(1).observeOn(AndroidSchedulers.mainThread()).flatMap(SplashView$executeImageTask$subscription$2.INSTANCE).observeOn(AndroidSchedulers.mainThread()).doOnTerminate(new SplashView$executeImageTask$subscription$3(this)).subscribe((Subscriber<? super R>) new SplashView$executeImageTask$subscription$4()));
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final Observable<Boolean> createLoadTask() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        File splashImageFile = AppHolder.getAppSetting().getSplashImageFile(this.activity);
        if (imageCard == null || splashImageFile == null || !splashImageFile.exists()) {
            Observable<Boolean> just = Observable.just(false);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(false)");
            return just;
        }
        ReplaySubject create = ReplaySubject.create();
        Observable<Boolean> asObservable = create.asObservable();
        Intrinsics.checkNotNullExpressionValue(asObservable, "replaySubject.asObservable()");
        Intrinsics.checkNotNullExpressionValue(GlideApp.with(this.activity).load(splashImageFile.toURI().toString()).diskCacheStrategy(DiskCacheStrategy.DATA).listener((RequestListener) new SplashView$createLoadTask$1(this, create)).into(getBinding().imageView), "GlideApp.with(activity)\n…).into(binding.imageView)");
        return asObservable;
    }

    private final void showWaitCount() {
        this.subscription.add(Observable.interval(0, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new SplashView$showWaitCount$subscription$1(this)).subscribe((Subscriber<? super Long>) new SplashView$showWaitCount$subscription$2(this)));
    }

    /* access modifiers changed from: private */
    public final void onImageLoad() {
        ThemeUtils.setNavigationBarColor(this.activity, 1711276032);
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        if (imageCard != null) {
            AppHolder.getAppSetting().markImageLoaded();
            TextView textView = getBinding().userNameView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameView");
            textView.setText(imageCard.getDescription());
            getBinding().clickView.setOnClickListener(new SplashView$onImageLoad$1(this));
        }
    }

    private final void setVersionInfo() {
        try {
            PackageInfo packageInfo = this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 0);
            if (packageInfo != null) {
                TextView textView = getBinding().userNameView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameView");
                textView.setText(packageInfo.versionName);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void enterTheWallpaperFeed() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        if (imageCard != null) {
            ActionManagerCompat.startActivityByUrl(this.activity, imageCard.getUrl(), imageCard.getTitle(), imageCard.getSubTitle());
            normalFinish();
        }
    }

    /* access modifiers changed from: private */
    public final void exeAutoFinish() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(1.0f, 0.0f);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(500L);
        valueAnimator.addUpdateListener(new SplashView$exeAutoFinish$1(this));
        valueAnimator.addListener(new SplashView$exeAutoFinish$2(this));
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public final void normalFinish() {
        RxUtils.unsubscribe(this.subscription);
        this.activity.finish();
    }
}
