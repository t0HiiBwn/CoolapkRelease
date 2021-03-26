package com.coolapk.market.viewholder;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemWebViewBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideFragmentImageLoader;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.coolapk.market.view.webview.VideoWebViewFragment;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.CoolWebView;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u001eH\u0002R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/coolapk/market/viewholder/WebViewCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "topHelper", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;)V", "binding", "Lcom/coolapk/market/databinding/ItemWebViewBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemWebViewBinding;", "card", "Lcom/coolapk/market/model/Entity;", "childFragment", "Lcom/coolapk/market/view/webview/VideoWebViewFragment;", "getChildFragment", "()Lcom/coolapk/market/view/webview/VideoWebViewFragment;", "setChildFragment", "(Lcom/coolapk/market/view/webview/VideoWebViewFragment;)V", "isResumed", "", "()Z", "setResumed", "(Z)V", "getTopHelper", "()Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "bindTo", "", "data", "", "enterFullScreen", "onClick", "view", "restoreToBlankPage", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WebViewCardViewHolder.kt */
public final class WebViewCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558990;
    private final ItemWebViewBinding binding;
    private Entity card;
    private VideoWebViewFragment childFragment;
    private boolean isResumed = true;
    private final EntityListFixTopHelper topHelper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewCardViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListFixTopHelper entityListFixTopHelper) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListFixTopHelper, "topHelper");
        this.topHelper = entityListFixTopHelper;
        ItemWebViewBinding itemWebViewBinding = (ItemWebViewBinding) getBinding();
        this.binding = itemWebViewBinding;
        Intrinsics.checkNotNullExpressionValue(itemWebViewBinding, "binding");
        WebViewCardViewHolder webViewCardViewHolder = this;
        ViewUtil.clickListener(itemWebViewBinding.getRoot(), webViewCardViewHolder);
        ViewUtil.clickListener(itemWebViewBinding.fullScreenButtom, webViewCardViewHolder);
    }

    public static final /* synthetic */ Entity access$getCard$p(WebViewCardViewHolder webViewCardViewHolder) {
        Entity entity = webViewCardViewHolder.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entity;
    }

    public final EntityListFixTopHelper getTopHelper() {
        return this.topHelper;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final ItemWebViewBinding getBinding() {
        return this.binding;
    }

    public final VideoWebViewFragment getChildFragment() {
        return this.childFragment;
    }

    public final void setChildFragment(VideoWebViewFragment videoWebViewFragment) {
        this.childFragment = videoWebViewFragment;
    }

    public final boolean isResumed() {
        return this.isResumed;
    }

    public final void setResumed(boolean z) {
        this.isResumed = z;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        WebView webView;
        Intrinsics.checkNotNullParameter(obj, "data");
        FrameLayout frameLayout = this.binding.holderView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.holderView");
        frameLayout.getLayoutParams().height = (int) ((((float) DisplayUtils.getDecorViewWidth(getContext())) / 16.0f) * 9.0f);
        FrameLayout frameLayout2 = this.binding.webViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.webViewContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        FrameLayout frameLayout3 = this.binding.holderView;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.holderView");
        layoutParams.height = frameLayout3.getLayoutParams().height;
        AspectRatioImageView aspectRatioImageView = this.binding.coverView;
        Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.coverView");
        aspectRatioImageView.setAspectRatio(0.5625f);
        ItemWebViewBinding itemWebViewBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemWebViewBinding, "binding");
        if (!Intrinsics.areEqual(obj, itemWebViewBinding.getCard())) {
            Entity entity = (Entity) obj;
            this.card = entity;
            ItemWebViewBinding itemWebViewBinding2 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemWebViewBinding2, "binding");
            Entity entity2 = this.card;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            itemWebViewBinding2.setCard(entity2);
            this.binding.executePendingBindings();
            boolean z = true;
            if (EntityExtendsKt.getIntExtraData(entity, "fixTop", 0) != 1) {
                z = false;
            }
            String description = entity.getDescription();
            String str2 = "";
            if (description == null) {
                description = str2;
            }
            String decode = URLDecoder.decode(description, "UTF-8");
            String decode2 = URLDecoder.decode(EntityExtendsKt.getStringExtraData(entity, "useragent", str2), "UTF-8");
            if (TextUtils.isEmpty(entity.getPic())) {
                str = entity.getUrl();
                if (str == null) {
                    str = str2;
                }
            } else {
                str = "about:blank";
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (TextUtils.isEmpty(da…?: \"\") else \"about:blank\"");
            if (TextUtils.isEmpty(entity.getPic())) {
                AspectRatioImageView aspectRatioImageView2 = this.binding.coverView;
                Intrinsics.checkNotNullExpressionValue(aspectRatioImageView2, "binding.coverView");
                aspectRatioImageView2.setVisibility(8);
            } else {
                DataBindingComponent component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                AppHolder.getFragmentImageLoader().displayImage((BaseFragment) fragment, entity.getPic(), this.binding.coverView);
                AspectRatioImageView aspectRatioImageView3 = this.binding.coverView;
                Intrinsics.checkNotNullExpressionValue(aspectRatioImageView3, "binding.coverView");
                aspectRatioImageView3.setVisibility(0);
                this.binding.coverView.setOnClickListener(this);
            }
            VideoWebViewFragment videoWebViewFragment = this.childFragment;
            if (videoWebViewFragment == null) {
                VideoWebViewFragment.Companion companion = VideoWebViewFragment.Companion;
                if (str != null) {
                    str2 = str;
                }
                Intrinsics.checkNotNullExpressionValue(decode, "js");
                Intrinsics.checkNotNullExpressionValue(decode2, "ua");
                VideoWebViewFragment newInstance = companion.newInstance(str2, decode, decode2);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                newInstance.onAttach((Activity) ContextExtendsKt.requireAppCompatActivity(context));
                newInstance.onCreate(null);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                View onCreateView = newInstance.onCreateView(LayoutInflater.from(UiUtils.getActivityNullable(context2)), this.binding.webViewContainer, null);
                Intrinsics.checkNotNull(onCreateView);
                newInstance.onViewCreated(onCreateView, null);
                newInstance.onActivityCreated(null);
                CoolWebView coolWebView = newInstance.getBinding().webView;
                Intrinsics.checkNotNullExpressionValue(coolWebView, "it.binding.webView");
                CoolWebView coolWebView2 = coolWebView;
                ViewExtendsKt.detachFromParent(coolWebView2);
                this.binding.webViewContainer.addView(coolWebView2, 0);
                coolWebView.getLayoutParams().height = -1;
                this.childFragment = newInstance;
                ItemWebViewBinding itemWebViewBinding3 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemWebViewBinding3, "binding");
                itemWebViewBinding3.getRoot().addOnAttachStateChangeListener(new WebViewCardViewHolder$bindTo$2(this, z, newInstance));
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                AppHolder.getApplication().registerActivityLifecycleCallbacks(new WebViewCardViewHolder$bindTo$3(this, UiUtils.getActivityNullable(context3), newInstance));
            } else {
                if (videoWebViewFragment != null) {
                    Intrinsics.checkNotNullExpressionValue(decode, "js");
                    videoWebViewFragment.setInitJS(decode);
                }
                VideoWebViewFragment videoWebViewFragment2 = this.childFragment;
                if (videoWebViewFragment2 != null) {
                    Intrinsics.checkNotNullExpressionValue(decode2, "ua");
                    videoWebViewFragment2.setInitUA(decode2);
                }
                VideoWebViewFragment videoWebViewFragment3 = this.childFragment;
                if (!(videoWebViewFragment3 == null || (webView = videoWebViewFragment3.getWebView()) == null)) {
                    webView.loadUrl(str);
                }
            }
            if (z) {
                EntityListFixTopHelper entityListFixTopHelper = this.topHelper;
                FrameLayout frameLayout4 = this.binding.webViewContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.webViewContainer");
                FrameLayout frameLayout5 = frameLayout4;
                FrameLayout frameLayout6 = this.binding.holderView;
                Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.holderView");
                FrameLayout frameLayout7 = frameLayout6;
                Entity entity3 = this.card;
                if (entity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                entityListFixTopHelper.setFixTopView(frameLayout5, frameLayout7, entity3);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void restoreToBlankPage() {
        WebView webView;
        WebView webView2;
        Entity entity = this.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        if (TextUtils.isEmpty(entity.getPic())) {
            AspectRatioImageView aspectRatioImageView = this.binding.coverView;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.coverView");
            aspectRatioImageView.setVisibility(8);
            VideoWebViewFragment videoWebViewFragment = this.childFragment;
            if (videoWebViewFragment != null && (webView2 = videoWebViewFragment.getWebView()) != null) {
                Entity entity2 = this.card;
                if (entity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                String url = entity2.getUrl();
                if (url == null) {
                    url = "";
                }
                webView2.loadUrl(url);
                return;
            }
            return;
        }
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof BaseFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        GlideFragmentImageLoader fragmentImageLoader = AppHolder.getFragmentImageLoader();
        BaseFragment baseFragment = (BaseFragment) lifecycleOwner;
        Entity entity3 = this.card;
        if (entity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        fragmentImageLoader.displayImage(baseFragment, entity3.getPic(), this.binding.coverView);
        AspectRatioImageView aspectRatioImageView2 = this.binding.coverView;
        Intrinsics.checkNotNullExpressionValue(aspectRatioImageView2, "binding.coverView");
        aspectRatioImageView2.setVisibility(0);
        VideoWebViewFragment videoWebViewFragment2 = this.childFragment;
        if (videoWebViewFragment2 != null && (webView = videoWebViewFragment2.getWebView()) != null) {
            webView.loadUrl("about:blank");
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131362338) {
            VideoWebViewFragment videoWebViewFragment = this.childFragment;
            if (!(videoWebViewFragment == null || (webView = videoWebViewFragment.getWebView()) == null)) {
                Entity entity = this.card;
                if (entity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                String url = entity.getUrl();
                if (url == null) {
                    url = "";
                }
                webView.loadUrl(url);
            }
            AspectRatioImageView aspectRatioImageView = this.binding.coverView;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.coverView");
            aspectRatioImageView.setVisibility(8);
        } else if (id == 2131362598 || id == 2131362768) {
            enterFullScreen();
        }
    }

    private final void enterFullScreen() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (!(activityNullable instanceof BaseActivity)) {
            activityNullable = null;
        }
        BaseActivity baseActivity = (BaseActivity) activityNullable;
        if (baseActivity != null) {
            FrameLayout contentView = UiUtils.getContentView(baseActivity);
            int requestedOrientation = baseActivity.getRequestedOrientation();
            Window window = baseActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            this.topHelper.unsetTopView();
            FrameLayout frameLayout = this.binding.webViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.webViewContainer");
            FrameLayout frameLayout2 = frameLayout;
            ViewExtendsKt.detachFromParent(frameLayout2);
            FrameLayout frameLayout3 = this.binding.webViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.webViewContainer");
            frameLayout3.getLayoutParams().height = -1;
            FrameLayout frameLayout4 = new FrameLayout(baseActivity);
            frameLayout4.setBackgroundColor(-16777216);
            frameLayout4.setClickable(true);
            frameLayout4.addView(frameLayout2);
            contentView.addView(frameLayout4, new FrameLayout.LayoutParams(-1, -1));
            ImageView imageView = this.binding.fullScreenButtom;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.fullScreenButtom");
            imageView.setKeepScreenOn(true);
            Window window2 = baseActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "activity.window");
            View decorView2 = window2.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
            decorView2.setSystemUiVisibility(4102);
            baseActivity.setSlidrEnable(false);
            baseActivity.getWindow().addFlags(1024);
            baseActivity.setRequestedOrientation(0);
            this.binding.fullScreenButtom.setImageResource(2131230846);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.binding.fullScreenButtom, View.ALPHA, 1.0f, 0.0f, 0.8f, 0.3f, 0.6f, 0.3f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
            ofFloat.setDuration(4000L);
            ofFloat.start();
            WebViewCardViewHolder$enterFullScreen$exitFullScreenAction$1 webViewCardViewHolder$enterFullScreen$exitFullScreenAction$1 = new WebViewCardViewHolder$enterFullScreen$exitFullScreenAction$1(this, ofFloat, frameLayout4, frameLayout, baseActivity, requestedOrientation, systemUiVisibility);
            this.binding.fullScreenButtom.setOnClickListener(new WebViewCardViewHolder$enterFullScreen$1(webViewCardViewHolder$enterFullScreen$exitFullScreenAction$1));
            baseActivity.setOnBackPressListener(new WebViewCardViewHolder$enterFullScreen$2(webViewCardViewHolder$enterFullScreen$exitFullScreenAction$1));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/WebViewCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WebViewCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
