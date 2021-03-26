package com.coolapk.market.view.webview;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Property;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedCommentBarBinding;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.dyhv8.DyhActionPresenter;
import com.coolapk.market.view.dyhv8.DyhArticleCommentBarViewPart;
import com.coolapk.market.widget.CoolWebView;
import com.coolapk.market.widget.Toast;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016J \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u001a\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/coolapk/market/view/webview/DyhBrowserFragment;", "Lcom/coolapk/market/view/webview/WebViewFragment;", "Lcom/coolapk/market/widget/CoolWebView$OnWebViewScrollCallback;", "()V", "commentBarViewPart", "Lcom/coolapk/market/view/dyhv8/DyhArticleCommentBarViewPart;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "dyhArticlePresenter", "Lcom/coolapk/market/view/dyhv8/DyhActionPresenter;", "favResrouce", "", "favedResrouce", "isDown", "", "isFaved", "isLiked", "isSignFaved", "isSignLiked", "isUp", "likeResrouce", "likedResrouce", "oldY", "posting", "scrollDistance", "dyhArticleFav", "", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onFav", "textView", "Landroid/widget/TextView;", "imageView", "Landroid/widget/ImageView;", "onLike", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onScroll", "dx", "dy", "isUpGlide", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupCommentBar", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhBrowserFragemnt.kt */
public class DyhBrowserFragment extends WebViewFragment implements CoolWebView.OnWebViewScrollCallback {
    public static final Companion Companion = new Companion(null);
    private DyhArticleCommentBarViewPart commentBarViewPart;
    private DyhArticle dyhArticle;
    private DyhActionPresenter dyhArticlePresenter;
    private final int favResrouce = 2131231559;
    private final int favedResrouce = 2131231557;
    private boolean isDown;
    private boolean isFaved;
    private boolean isLiked;
    private boolean isSignFaved;
    private boolean isSignLiked;
    private boolean isUp;
    private final int likeResrouce = 2131231682;
    private final int likedResrouce = 2131231246;
    private int oldY;
    private boolean posting;
    private int scrollDistance;

    public static final /* synthetic */ DyhArticle access$getDyhArticle$p(DyhBrowserFragment dyhBrowserFragment) {
        DyhArticle dyhArticle2 = dyhBrowserFragment.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        return dyhArticle2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/webview/DyhBrowserFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/webview/DyhBrowserFragment;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhBrowserFragemnt.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DyhBrowserFragment newInstance(DyhArticle dyhArticle) {
            Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
            DyhBrowserFragment dyhBrowserFragment = new DyhBrowserFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("DYHARTICLE", dyhArticle);
            dyhBrowserFragment.setArguments(bundle);
            return dyhBrowserFragment;
        }
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        WebView webView = getWebView();
        Objects.requireNonNull(webView, "null cannot be cast to non-null type com.coolapk.market.widget.CoolWebView");
        ((CoolWebView) webView).setOnWebViewScrollCallback(this);
        Parcelable parcelable = requireArguments().getParcelable("extra_action_type");
        Intrinsics.checkNotNull(parcelable);
        this.dyhArticle = (DyhArticle) parcelable;
        setupCommentBar();
        this.dyhArticlePresenter = DyhActionPresenter.getInstance();
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        if (dyhArticle2 != null) {
            MenuItem findItem = menu.findItem(2131361904);
            Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_favior)");
            DyhArticle dyhArticle3 = this.dyhArticle;
            if (dyhArticle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            Intrinsics.checkNotNull(dyhArticle3);
            findItem.setTitle(dyhArticle3.isFavorite() ? "已收藏" : "收藏");
            MenuItem findItem2 = menu.findItem(2131361904);
            Intrinsics.checkNotNullExpressionValue(findItem2, "menu.findItem(R.id.action_favior)");
            findItem2.setVisible(true);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0099: APUT  
      (r5v1 java.lang.Object[])
      (2 ??[int, float, short, byte, char])
      (wrap: java.lang.String : 0x0095: INVOKE  (r2v3 java.lang.String) = (r2v2 com.coolapk.market.model.DyhArticle) type: VIRTUAL call: com.coolapk.market.model.DyhArticle.getRedirectUrl():java.lang.String)
     */
    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        CoolWebView coolWebView = getBinding().webView;
        Intrinsics.checkNotNullExpressionValue(coolWebView, "binding.webView");
        String url = coolWebView.getUrl();
        switch (menuItem.getItemId()) {
            case 2131361883:
                coolWebView.clearCache(true);
                Toast.show(getWebView(), 2131887156);
                return true;
            case 2131361889:
                if (url != null) {
                    StringUtils.copyText(getActivity(), coolWebView.getUrl());
                    Toast.show(getWebView(), 2131887190);
                    return true;
                }
                break;
            case 2131361904:
                FragmentActivity activity = getActivity();
                DyhArticle dyhArticle2 = this.dyhArticle;
                if (dyhArticle2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
                }
                ActionManager.startCollectionSelectActivity(activity, dyhArticle2.getId(), "article");
                return true;
            case 2131361956:
                coolWebView.reload();
                return true;
            case 2131361968:
                if (coolWebView.getUrl() != null) {
                    String title = coolWebView.getTitle();
                    String title2 = coolWebView.getTitle();
                    if (title2 == null) {
                        title2 = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(title2, "mWebView.title ?: \"\"");
                    String reconvert = LinkTextUtils.reconvert(title2);
                    if (reconvert.length() > 240) {
                        StringBuilder sb = new StringBuilder();
                        Objects.requireNonNull(reconvert, "null cannot be cast to non-null type java.lang.String");
                        String substring = reconvert.substring(0, 240);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append("…");
                        reconvert = sb.toString();
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] objArr = new Object[3];
                    objArr[0] = reconvert;
                    objArr[1] = getString(2131886685);
                    DyhArticle dyhArticle3 = this.dyhArticle;
                    if (dyhArticle3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
                    }
                    objArr[2] = dyhArticle3.getRedirectUrl();
                    String format = String.format("%s  %s %s", Arrays.copyOf(objArr, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    ActionManager.shareText(getActivity(), title, format);
                    return true;
                }
                break;
            case 2131361985:
                if (coolWebView.getUrl() != null) {
                    ActionManager.startView(getActivity(), Uri.parse(coolWebView.getUrl()), null);
                    return true;
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void dyhArticleFav(DyhArticle dyhArticle2) {
        String str;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        UserAction userAction = dyhArticle2.getUserAction();
        Intrinsics.checkNotNull(userAction);
        Intrinsics.checkNotNullExpressionValue(userAction, "dyhArticle.userAction!!");
        booleanRef.element = userAction.getFavorite() > 0;
        if (booleanRef.element) {
            str = dyhArticle2.getFavNum() - 1 > 0 ? String.valueOf(dyhArticle2.getFavNum() - 1) : "";
        } else {
            str = String.valueOf(dyhArticle2.getFavNum() + 1);
        }
        DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle2);
        Integer valueOf = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str);
        Intrinsics.checkNotNullExpressionValue(valueOf, "if (TextUtils.isEmpty(ne…nteger.valueOf(newFavNum)");
        DyhArticle build = newBuilder.favNum(valueOf.intValue()).userAction(UserAction.newBuilder(dyhArticle2.getUserAction()).favorite(1 ^ (booleanRef.element ? 1 : 0)).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "DyhArticle.newBuilder(dy…\n                .build()");
        this.dyhArticle = build;
        Observable.just(Boolean.valueOf(booleanRef.element)).flatMap(new DyhBrowserFragment$dyhArticleFav$1(this, dyhArticle2)).compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new DyhBrowserFragment$dyhArticleFav$2(this, booleanRef));
    }

    private final void setupCommentBar() {
        FrameLayout frameLayout = getBinding().webRoot;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.webRoot");
        DyhArticleCommentBarViewPart.Companion companion = DyhArticleCommentBarViewPart.Companion;
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        DyhArticleCommentBarViewPart newInstance = companion.newInstance(dyhArticle2, frameLayout);
        newInstance.setExternalListener(new DyhBrowserFragment$setupCommentBar$1(this));
        View view = newInstance.getView();
        frameLayout.addView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 80;
            layoutParams2.width = -1;
            layoutParams2.height = -2;
        }
        view.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
        view.setVisibility(0);
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new DyhBrowserFragment$setupCommentBar$3(frameLayout, view));
        this.commentBarViewPart = newInstance;
    }

    @Override // com.coolapk.market.widget.CoolWebView.OnWebViewScrollCallback
    public void onScroll(int i, int i2, boolean z) {
        if (z) {
            this.isDown = false;
            if (!this.isUp) {
                this.isUp = true;
                DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart = this.commentBarViewPart;
                Intrinsics.checkNotNull(dyhArticleCommentBarViewPart);
                View root = ((FeedCommentBarBinding) dyhArticleCommentBarViewPart.getBinding()).getRoot();
                Property property = View.TRANSLATION_Y;
                DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart2 = this.commentBarViewPart;
                Intrinsics.checkNotNull(dyhArticleCommentBarViewPart2);
                View root2 = ((FeedCommentBarBinding) dyhArticleCommentBarViewPart2.getBinding()).getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "commentBarViewPart!!.binding.root");
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(root, property, (float) root2.getHeight());
                Intrinsics.checkNotNullExpressionValue(ofFloat, "valueAnimator");
                ofFloat.setDuration(200L);
                ofFloat.start();
                return;
            }
            return;
        }
        this.isUp = false;
        if (!this.isDown) {
            this.isDown = true;
            DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart3 = this.commentBarViewPart;
            Intrinsics.checkNotNull(dyhArticleCommentBarViewPart3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(((FeedCommentBarBinding) dyhArticleCommentBarViewPart3.getBinding()).getRoot(), View.TRANSLATION_Y, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "valueAnimator");
            ofFloat2.setDuration(200L);
            ofFloat2.start();
        }
    }

    private final void onLike(DyhArticle dyhArticle2, TextView textView, ImageView imageView) {
        int likeNum = dyhArticle2.getLikeNum();
        boolean isLiked2 = dyhArticle2.isLiked();
        textView.setText(likeNum > 0 ? String.valueOf(likeNum) : "");
        Drawable drawable = ContextCompat.getDrawable(requireActivity(), isLiked2 ? this.likedResrouce : this.likeResrouce);
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "ContextCompat.getDrawabl… likeResrouce)!!.mutate()");
        mutate.setTint(AppHolder.getAppTheme().getColorAccent());
        imageView.setImageDrawable(mutate);
        this.posting = false;
    }

    private final void onFav(DyhArticle dyhArticle2, TextView textView, ImageView imageView) {
        int favNum = dyhArticle2.getFavNum();
        boolean isFavorite = dyhArticle2.isFavorite();
        textView.setText(favNum > 0 ? String.valueOf(favNum) : "");
        Drawable drawable = ContextCompat.getDrawable(requireActivity(), isFavorite ? this.favedResrouce : this.favResrouce);
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "ContextCompat.getDrawabl…e favResrouce)!!.mutate()");
        mutate.setTint(AppHolder.getAppTheme().getColorAccent());
        imageView.setImageDrawable(mutate);
        this.posting = false;
    }
}
