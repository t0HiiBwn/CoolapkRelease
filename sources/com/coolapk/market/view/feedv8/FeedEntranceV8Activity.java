package com.coolapk.market.view.feedv8;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OneShotPreDrawListener;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.FeedEntranceItemsBinding;
import com.coolapk.market.databinding.FeedEntranceV8Binding;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.feedv8.draft.RoughDraftHelper;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import com.hjq.permissions.XXPermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004,-./B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0014J\b\u0010 \u001a\u00020\fH\u0014J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\fH\u0003J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\fH\u0002J\u001a\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020&H\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/FeedEntranceV8Binding;", "hasImage", "", "imageView", "Landroid/widget/ImageView;", "finish", "", "initBackgroundImageView", "isNavigationBarTranslucent", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEntranceItemClick", "item", "Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceType;", "onSetStatusBarColor", "onSetStatusBarDarkMode", "playDraftAnimation", "playHideAnimationAndFinish", "playShowAnimation", "setCloseButtonRotate", "value", "", "startQrCode", "zoomBig", "view", "scale", "zoomSmall", "Companion", "EntranceItem", "EntranceType", "EntranceViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity extends BaseActivity implements View.OnClickListener, TranslucentActivity {
    private static final int ALPHA_WITH_COOL_PIC = 128;
    private static final int ALPHA_WITH_NO_BACKGROUND = 240;
    private static final int ANIMATION_DURATION = 300;
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_BACKGROUND_ACTIVITY = "EXTRA_BACKGROUND_ACTIVITY";
    public static final int REQUEST_TOPIC_CODE = 2241;
    private FeedEntranceV8Binding binding;
    private boolean hasImage;
    private ImageView imageView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceType;", "", "(Ljava/lang/String;I)V", "Feed", "Article", "CoolPic", "Question", "Scan", "SecondHand", "Album", "Topic", "Goods", "GoodsList", "Vote", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedEntranceV8Activity.kt */
    private enum EntranceType {
        Feed,
        Article,
        CoolPic,
        Question,
        Scan,
        SecondHand,
        Album,
        Topic,
        Goods,
        GoodsList,
        Vote
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EntranceType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EntranceType.Scan.ordinal()] = 1;
            iArr[EntranceType.Feed.ordinal()] = 2;
            iArr[EntranceType.SecondHand.ordinal()] = 3;
            iArr[EntranceType.Album.ordinal()] = 4;
            iArr[EntranceType.CoolPic.ordinal()] = 5;
            iArr[EntranceType.Question.ordinal()] = 6;
            iArr[EntranceType.Vote.ordinal()] = 7;
            iArr[EntranceType.Topic.ordinal()] = 8;
            iArr[EntranceType.Article.ordinal()] = 9;
            iArr[EntranceType.Goods.ordinal()] = 10;
            iArr[EntranceType.GoodsList.ordinal()] = 11;
        }
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ FeedEntranceV8Binding access$getBinding$p(FeedEntranceV8Activity feedEntranceV8Activity) {
        FeedEntranceV8Binding feedEntranceV8Binding = feedEntranceV8Activity.binding;
        if (feedEntranceV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return feedEntranceV8Binding;
    }

    public static final /* synthetic */ ImageView access$getImageView$p(FeedEntranceV8Activity feedEntranceV8Activity) {
        ImageView imageView2 = feedEntranceV8Activity.imageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        return imageView2;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        super.onCreate(bundle);
        SharedPlayer optSharePlayer = VideoManager.INSTANCE.optSharePlayer();
        if (optSharePlayer != null) {
            optSharePlayer.detachPlayerBridge();
        }
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558559);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte….layout.feed_entrance_v8)");
        FeedEntranceV8Binding feedEntranceV8Binding = (FeedEntranceV8Binding) contentView;
        this.binding = feedEntranceV8Binding;
        if (feedEntranceV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding.setClick(this);
        FeedEntranceV8Binding feedEntranceV8Binding2 = this.binding;
        if (feedEntranceV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = feedEntranceV8Binding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getViewTreeObserver().addOnPreDrawListener(new FeedEntranceV8Activity$onCreate$$inlined$doOnNextPreDraw$1(root, this));
        setSlidrEnable(false);
        initBackgroundImageView();
        FeedEntranceV8Binding feedEntranceV8Binding3 = this.binding;
        if (feedEntranceV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding3.rootView.addOnInsetChangeListener(new FeedEntranceV8Activity$onCreate$2(this));
        List<? extends EntranceItem> invoke = FeedEntranceV8Activity$onCreate$3.INSTANCE.invoke();
        FeedEntranceV8Binding feedEntranceV8Binding4 = this.binding;
        if (feedEntranceV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = feedEntranceV8Binding4.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        FeedEntranceV8Binding feedEntranceV8Binding5 = this.binding;
        if (feedEntranceV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = feedEntranceV8Binding5.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setAdapter(new FeedEntranceV8Activity$onCreate$4(this, invoke));
        FeedEntranceV8Binding feedEntranceV8Binding6 = this.binding;
        if (feedEntranceV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding6.imageView1.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{(int) 2150023089L, (int) 4280729521L}));
        FeedEntranceV8Binding feedEntranceV8Binding7 = this.binding;
        if (feedEntranceV8Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding7.imageView2.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{(int) 2150024922L, (int) 4280731354L}));
        FeedEntranceV8Binding feedEntranceV8Binding8 = this.binding;
        if (feedEntranceV8Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = feedEntranceV8Binding8.topView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topView");
        LinearLayout linearLayout2 = linearLayout;
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(linearLayout2, new FeedEntranceV8Activity$onCreate$$inlined$doOnPreDraw$1(linearLayout2, this)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    private final void initBackgroundImageView() {
        FeedEntranceV8Binding feedEntranceV8Binding = this.binding;
        if (feedEntranceV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = feedEntranceV8Binding.imageBackground;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageBackground");
        this.imageView = imageView2;
        Activity activity = (Activity) AppHolder.getWeakValue("EXTRA_BACKGROUND_ACTIVITY");
        if (activity != null) {
            AppHolder.setWeakValue("EXTRA_BACKGROUND_ACTIVITY", null);
            ImageView imageView3 = this.imageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            }
            imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageView imageView4 = this.imageView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            }
            imageView4.setVisibility(4);
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "backgroundActivity.window");
            Observable.just(UiUtils.takeScaledSnapshot(window.getDecorView(), 8)).map(new FeedEntranceV8Activity$initBackgroundImageView$1(this)).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedEntranceV8Activity$initBackgroundImageView$2(this));
            return;
        }
        int alphaComponent = ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getMainBackgroundColor(), 240);
        ImageView imageView5 = this.imageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        imageView5.setImageDrawable(new ColorDrawable(alphaComponent));
    }

    /* access modifiers changed from: private */
    public final void playDraftAnimation() {
        int size = RoughDraftHelper.Companion.getInstance().getRoughDraftList().size();
        if (size == 0) {
            FeedEntranceV8Binding feedEntranceV8Binding = this.binding;
            if (feedEntranceV8Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = feedEntranceV8Binding.draftView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.draftView");
            linearLayout.setVisibility(8);
            return;
        }
        FeedEntranceV8Binding feedEntranceV8Binding2 = this.binding;
        if (feedEntranceV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = feedEntranceV8Binding2.draftTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.draftTextView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "你有%d篇草稿", Arrays.copyOf(new Object[]{Integer.valueOf(size)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        textView.setText(format);
        FeedEntranceV8Binding feedEntranceV8Binding3 = this.binding;
        if (feedEntranceV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = feedEntranceV8Binding3.draftTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.draftTextView");
        textView2.setVisibility(8);
        FeedEntranceV8Binding feedEntranceV8Binding4 = this.binding;
        if (feedEntranceV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TransitionManager.beginDelayedTransition(feedEntranceV8Binding4.draftView);
        FeedEntranceV8Binding feedEntranceV8Binding5 = this.binding;
        if (feedEntranceV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = feedEntranceV8Binding5.draftView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.draftView");
        linearLayout2.getLayoutParams().width = -2;
        FeedEntranceV8Binding feedEntranceV8Binding6 = this.binding;
        if (feedEntranceV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding6.draftView.requestLayout();
        FeedEntranceV8Binding feedEntranceV8Binding7 = this.binding;
        if (feedEntranceV8Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View childAt = feedEntranceV8Binding7.draftView.getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "binding.draftView.getChildAt(0)");
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = DisplayUtils.dp2px(getActivity(), 8.0f);
        FeedEntranceV8Binding feedEntranceV8Binding8 = this.binding;
        if (feedEntranceV8Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding8.draftView.getChildAt(0).requestLayout();
        FeedEntranceV8Binding feedEntranceV8Binding9 = this.binding;
        if (feedEntranceV8Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View childAt2 = feedEntranceV8Binding9.draftView.getChildAt(1);
        Intrinsics.checkNotNullExpressionValue(childAt2, "binding.draftView.getChildAt(1)");
        ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = DisplayUtils.dp2px(getActivity(), 12.0f);
        FeedEntranceV8Binding feedEntranceV8Binding10 = this.binding;
        if (feedEntranceV8Binding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding10.draftView.getChildAt(1).requestLayout();
        FeedEntranceV8Binding feedEntranceV8Binding11 = this.binding;
        if (feedEntranceV8Binding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = feedEntranceV8Binding11.draftTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.draftTextView");
        textView3.setVisibility(0);
        FeedEntranceV8Binding feedEntranceV8Binding12 = this.binding;
        if (feedEntranceV8Binding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding12.draftView.setOnClickListener(new FeedEntranceV8Activity$playDraftAnimation$1(this));
    }

    /* access modifiers changed from: private */
    public final void playShowAnimation() {
        FeedEntranceV8Binding feedEntranceV8Binding = this.binding;
        if (feedEntranceV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = feedEntranceV8Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        if (root.isAttachedToWindow()) {
            Rect rect = new Rect();
            FeedEntranceV8Binding feedEntranceV8Binding2 = this.binding;
            if (feedEntranceV8Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            feedEntranceV8Binding2.closeView.getGlobalVisibleRect(rect);
            FeedEntranceV8Binding feedEntranceV8Binding3 = this.binding;
            if (feedEntranceV8Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = feedEntranceV8Binding3.closeView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.closeView");
            int width = imageView2.getWidth() / 2;
            int centerX = rect.centerX();
            int centerY = rect.centerY();
            FeedEntranceV8Binding feedEntranceV8Binding4 = this.binding;
            if (feedEntranceV8Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View root2 = feedEntranceV8Binding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            int width2 = root2.getWidth();
            FeedEntranceV8Binding feedEntranceV8Binding5 = this.binding;
            if (feedEntranceV8Binding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View root3 = feedEntranceV8Binding5.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            int height = root3.getHeight();
            int sqrt = (int) Math.sqrt(Math.pow((double) (width2 / 2 > centerX ? width2 - centerX : centerX), 2.0d) + Math.pow((double) (height / 2 > centerX ? height - centerY : centerY), 2.0d));
            FeedEntranceV8Binding feedEntranceV8Binding6 = this.binding;
            if (feedEntranceV8Binding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(feedEntranceV8Binding6.getRoot(), centerX, centerY, (float) width, (float) sqrt);
            Intrinsics.checkNotNullExpressionValue(createCircularReveal, "animator");
            long j = (long) 300;
            createCircularReveal.setDuration(j);
            createCircularReveal.addListener(new FeedEntranceV8Activity$playShowAnimation$1(this));
            createCircularReveal.start();
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new FeedEntranceV8Activity$playShowAnimation$2(this));
            valueAnimator.setDuration(j);
            valueAnimator.start();
            FeedEntranceV8Binding feedEntranceV8Binding7 = this.binding;
            if (feedEntranceV8Binding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            RecyclerView recyclerView = feedEntranceV8Binding7.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            recyclerView.setOverScrollMode(2);
            FeedEntranceV8Binding feedEntranceV8Binding8 = this.binding;
            if (feedEntranceV8Binding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            feedEntranceV8Binding8.recyclerView.post(new FeedEntranceV8Activity$playShowAnimation$3(this));
            FeedEntranceV8Binding feedEntranceV8Binding9 = this.binding;
            if (feedEntranceV8Binding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            feedEntranceV8Binding9.itemView1.setOnTouchListener(new FeedEntranceV8Activity$playShowAnimation$4(this));
            FeedEntranceV8Binding feedEntranceV8Binding10 = this.binding;
            if (feedEntranceV8Binding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            feedEntranceV8Binding10.itemView2.setOnTouchListener(new FeedEntranceV8Activity$playShowAnimation$5(this));
            FeedEntranceV8Binding feedEntranceV8Binding11 = this.binding;
            if (feedEntranceV8Binding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            feedEntranceV8Binding11.recyclerView.addOnItemTouchListener(new FeedEntranceV8Activity$playShowAnimation$6(this));
        }
    }

    static /* synthetic */ void zoomBig$default(FeedEntranceV8Activity feedEntranceV8Activity, View view, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.2f;
        }
        feedEntranceV8Activity.zoomBig(view, f);
    }

    /* access modifiers changed from: private */
    public final void zoomBig(View view, float f) {
        view.animate().scaleX(f).setDuration(100).scaleY(f).start();
    }

    /* access modifiers changed from: private */
    public final void zoomSmall(View view) {
        view.animate().scaleX(1.0f).setDuration(100).scaleY(1.0f).start();
    }

    /* access modifiers changed from: private */
    public final void setCloseButtonRotate(float f) {
        FeedEntranceV8Binding feedEntranceV8Binding = this.binding;
        if (feedEntranceV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = feedEntranceV8Binding.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.closeView");
        imageView2.setRotation((float) ((int) (f * ((float) 135))));
    }

    private final void playHideAnimationAndFinish() {
        Rect rect = new Rect();
        FeedEntranceV8Binding feedEntranceV8Binding = this.binding;
        if (feedEntranceV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedEntranceV8Binding.closeView.getGlobalVisibleRect(rect);
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        FeedEntranceV8Binding feedEntranceV8Binding2 = this.binding;
        if (feedEntranceV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = feedEntranceV8Binding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        int width = root.getWidth();
        FeedEntranceV8Binding feedEntranceV8Binding3 = this.binding;
        if (feedEntranceV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root2 = feedEntranceV8Binding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        int height = root2.getHeight();
        int sqrt = (int) Math.sqrt(Math.pow((double) (width / 2 > centerX ? width - centerX : centerX), 2.0d) + Math.pow((double) (height / 2 > centerX ? height - centerY : centerY), 2.0d));
        FeedEntranceV8Binding feedEntranceV8Binding4 = this.binding;
        if (feedEntranceV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(feedEntranceV8Binding4.getRoot(), centerX, centerY, (float) sqrt, 0.0f);
        Intrinsics.checkNotNullExpressionValue(createCircularReveal, "animator");
        long j = (long) 300;
        createCircularReveal.setDuration(j);
        createCircularReveal.addListener(new FeedEntranceV8Activity$playHideAnimationAndFinish$1(this));
        createCircularReveal.start();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(1.0f, 0.0f);
        valueAnimator.addUpdateListener(new FeedEntranceV8Activity$playHideAnimationAndFinish$2(this));
        valueAnimator.setDuration(j);
        valueAnimator.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131362257:
            case 2131362908:
                playHideAnimationAndFinish();
                return;
            case 2131362769:
                onEntranceItemClick(EntranceType.Feed);
                return;
            case 2131362773:
                onEntranceItemClick(EntranceType.Article);
                return;
            case 2131363321:
            case 2131363588:
                ActionManager.startSearchActivity(getActivity());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void onEntranceItemClick(EntranceType entranceType) {
        switch (WhenMappings.$EnumSwitchMapping$0[entranceType.ordinal()]) {
            case 1:
                startQrCode();
                StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("二维码");
                return;
            case 2:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    BaseActivity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactory.uiConfigForFeed(activity).relativeInfoPickable(true).build(), FeedArgsFactory.multiPartForFeed().build());
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("动态");
                    finish();
                    return;
                }
                return;
            case 3:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    ActionManager.startNewSecondHandActivity(this);
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("二手");
                    finish();
                    return;
                }
                return;
            case 4:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    SimpleDialog simpleDialog = new SimpleDialog();
                    simpleDialog.setTitle("选择创建类型");
                    simpleDialog.setMessage("【应用集】：创建并向酷友分享你优质、有趣、个性的应用合集，并介绍每款应用的美妙之处\n【备份单】：个人、私密的云应用备份列表，不做应用过滤，让你的App列表不再怕丢失");
                    simpleDialog.setNeutralButton("创建应用集", new FeedEntranceV8Activity$onEntranceItemClick$1(this));
                    simpleDialog.setPositiveButton("创建备份单", new FeedEntranceV8Activity$onEntranceItemClick$2(this));
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    simpleDialog.show(supportFragmentManager, (String) null);
                    return;
                }
                return;
            case 5:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    ActionManager.startPhotoPickerActivity(this, 9, (List<String>) null);
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("酷图");
                    return;
                }
                return;
            case 6:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    ActionManager.startQuestionTitleV8Activity(getActivity());
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("提问");
                    finish();
                    return;
                }
                return;
            case 7:
                if (UserPermissionChecker.INSTANCE.getCanCreateNewVote()) {
                    BaseActivity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactory.uiConfigForVote(activity2).build(), FeedArgsFactory.multiPartForVote().build());
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("投票");
                    finish();
                    return;
                }
                return;
            case 8:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    ActionManager.startPickTopicActivity(this, 2241);
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("话题");
                    return;
                }
                return;
            case 9:
                if (ActionManager.checkLogin(getActivity()).booleanValue()) {
                    StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("图文");
                    BaseActivity activity3 = getActivity();
                    BaseActivity activity4 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity4, "getActivity()");
                    ActionManager.startSubmitFeedV8Activity(activity3, FeedArgsFactory.uiConfigForHtmlFeed(activity4), FeedArgsFactory.multiPartForFeed().build());
                    finish();
                    return;
                }
                return;
            case 10:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        BaseActivity activity5 = getActivity();
                        BaseActivity activity6 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity6, "getActivity()");
                        ActionManager.startSubmitFeedV8Activity(activity5, FeedArgsFactory.uiConfigForForwardGoods$default(activity6, null, 2, null), FeedArgsFactory.multiPartForGoods$default(null, 1, null));
                        StatisticHelper.Companion.getInstance().recordFeedEntranceClickEvent("好物");
                        finish();
                        return;
                    }
                    return;
                }
                return;
            case 11:
                ActionManager.startCreateGoodsListActivity(getActivity());
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        playHideAnimationAndFinish();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode() {
        ThemeUtils.setDarkStatusIconBar(getActivity(), !AppTheme.Companion.isDarkTheme(AppHolder.getAppTheme().getCurrentThemeId()));
    }

    private final void startQrCode() {
        XXPermissions permission = XXPermissions.with((FragmentActivity) this).permission("android.permission.CAMERA");
        Intrinsics.checkNotNullExpressionValue(permission, "XXPermissions.with(this)…nifest.permission.CAMERA)");
        LibraryExtentsKt.asObservable(permission).subscribe((Subscriber<? super Boolean>) new FeedEntranceV8Activity$startQrCode$1(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Topic topic;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            if (i == 3925) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    Toast.show$default(getActivity(), getString(2131886934), 0, false, 12, null);
                    return;
                }
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                FeedMultiPart multiPartForCoolPic = FeedArgsFactory.multiPartForCoolPic(activity);
                BaseActivity activity2 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                FeedUIConfig uiConfigForCoolPic = FeedArgsFactory.uiConfigForCoolPic(activity2);
                Iterator<String> it2 = stringArrayListExtra.iterator();
                while (it2.hasNext()) {
                    multiPartForCoolPic.imageUriList().add(ImageUrl.create(CoolFileUtils.wrap(it2.next()), null));
                }
                ActionManager.startSubmitFeedV8Activity(getActivity(), uiConfigForCoolPic, multiPartForCoolPic);
                finish();
            } else if (i == 2241 && (topic = (Topic) intent.getParcelableExtra("KEY_TOPIC_MODEL")) != null) {
                FeedMultiPart build = FeedArgsFactoryKt.applyTopic(FeedArgsFactory.multiPartForFeed(), topic).build();
                BaseActivity activity3 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity3, "activity");
                FeedUIConfig.Builder uiConfigForFeed = FeedArgsFactory.uiConfigForFeed(activity3);
                BaseActivity activity4 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity4, "activity");
                ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactoryKt.applyTopic(uiConfigForFeed, activity4, topic).build(), build);
                finish();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceItem;", "", "type", "Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceType;", "title", "", "bgColor", "", "drawable", "isNew", "", "(Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceType;Ljava/lang/String;IIZ)V", "getBgColor", "()I", "getDrawable", "()Z", "getTitle", "()Ljava/lang/String;", "getType", "()Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedEntranceV8Activity.kt */
    private static final class EntranceItem {
        private final int bgColor;
        private final int drawable;
        private final boolean isNew;
        private final String title;
        private final EntranceType type;

        public static /* synthetic */ EntranceItem copy$default(EntranceItem entranceItem, EntranceType entranceType, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                entranceType = entranceItem.type;
            }
            if ((i3 & 2) != 0) {
                str = entranceItem.title;
            }
            if ((i3 & 4) != 0) {
                i = entranceItem.bgColor;
            }
            if ((i3 & 8) != 0) {
                i2 = entranceItem.drawable;
            }
            if ((i3 & 16) != 0) {
                z = entranceItem.isNew;
            }
            return entranceItem.copy(entranceType, str, i, i2, z);
        }

        public final EntranceType component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final int component3() {
            return this.bgColor;
        }

        public final int component4() {
            return this.drawable;
        }

        public final boolean component5() {
            return this.isNew;
        }

        public final EntranceItem copy(EntranceType entranceType, String str, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(entranceType, "type");
            Intrinsics.checkNotNullParameter(str, "title");
            return new EntranceItem(entranceType, str, i, i2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EntranceItem)) {
                return false;
            }
            EntranceItem entranceItem = (EntranceItem) obj;
            return Intrinsics.areEqual(this.type, entranceItem.type) && Intrinsics.areEqual(this.title, entranceItem.title) && this.bgColor == entranceItem.bgColor && this.drawable == entranceItem.drawable && this.isNew == entranceItem.isNew;
        }

        public int hashCode() {
            EntranceType entranceType = this.type;
            int i = 0;
            int hashCode = (entranceType != null ? entranceType.hashCode() : 0) * 31;
            String str = this.title;
            if (str != null) {
                i = str.hashCode();
            }
            int i2 = (((((hashCode + i) * 31) + this.bgColor) * 31) + this.drawable) * 31;
            boolean z = this.isNew;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        public String toString() {
            return "EntranceItem(type=" + this.type + ", title=" + this.title + ", bgColor=" + this.bgColor + ", drawable=" + this.drawable + ", isNew=" + this.isNew + ")";
        }

        public EntranceItem(EntranceType entranceType, String str, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(entranceType, "type");
            Intrinsics.checkNotNullParameter(str, "title");
            this.type = entranceType;
            this.title = str;
            this.bgColor = i;
            this.drawable = i2;
            this.isNew = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ EntranceItem(EntranceType entranceType, String str, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(entranceType, str, i, i2, (i3 & 16) != 0 ? false : z);
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final int getDrawable() {
            return this.drawable;
        }

        public final String getTitle() {
            return this.title;
        }

        public final EntranceType getType() {
            return this.type;
        }

        public final boolean isNew() {
            return this.isNew;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "(Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity;Landroid/view/View;)V", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedEntranceV8Activity.kt */
    private final class EntranceViewHolder extends BindingViewHolder {
        final /* synthetic */ FeedEntranceV8Activity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EntranceViewHolder(FeedEntranceV8Activity feedEntranceV8Activity, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = feedEntranceV8Activity;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            FeedEntranceItemsBinding feedEntranceItemsBinding = (FeedEntranceItemsBinding) getBinding();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.FeedEntranceV8Activity.EntranceItem");
            EntranceItem entranceItem = (EntranceItem) obj;
            TextView textView = feedEntranceItemsBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText(entranceItem.getTitle());
            feedEntranceItemsBinding.imageView.setImageResource(entranceItem.getDrawable());
            ImageView imageView = feedEntranceItemsBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
            imageView.setBackgroundTintList(ColorStateList.valueOf(entranceItem.getBgColor()));
            ImageView imageView2 = feedEntranceItemsBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageView");
            imageView2.setBackground(new ColorDrawable(entranceItem.getBgColor()));
            View view = feedEntranceItemsBinding.newBgView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.newBgView");
            int i = 0;
            view.setVisibility(entranceItem.isNew() ? 0 : 8);
            TextView textView2 = feedEntranceItemsBinding.newTagView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.newTagView");
            TextView textView3 = textView2;
            if (!entranceItem.isNew()) {
                i = 8;
            }
            textView3.setVisibility(i);
            feedEntranceItemsBinding.itemView.setOnClickListener(new FeedEntranceV8Activity$EntranceViewHolder$bindTo$1(this, obj));
            feedEntranceItemsBinding.executePendingBindings();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$Companion;", "", "()V", "ALPHA_WITH_COOL_PIC", "", "ALPHA_WITH_NO_BACKGROUND", "ANIMATION_DURATION", "EXTRA_BACKGROUND_ACTIVITY", "", "REQUEST_TOPIC_CODE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedEntranceV8Activity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
