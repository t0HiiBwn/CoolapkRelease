package com.coolapk.market.view.product;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ProductPostViewBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.ViewTouchAnimatorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0012J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020 H\u0002J\u0006\u0010&\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/product/ProductPostView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/coolapk/market/databinding/ProductPostViewBinding;", "extraStartPaddingBottom", "", "getExtraStartPaddingBottom", "()I", "setExtraStartPaddingBottom", "(I)V", "isAnimating", "", "presenter", "Lcom/coolapk/market/view/product/ProductPresenter;", "getPresenter", "()Lcom/coolapk/market/view/product/ProductPresenter;", "setPresenter", "(Lcom/coolapk/market/view/product/ProductPresenter;)V", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "getViewModel", "()Lcom/coolapk/market/view/product/ProductViewModel;", "setViewModel", "(Lcom/coolapk/market/view/product/ProductViewModel;)V", "hideWithAnimator", "", "detach", "onClick", "v", "Landroid/view/View;", "requestDismiss", "showWithAnimator", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductPostView.kt */
public final class ProductPostView extends FrameLayout implements View.OnClickListener {
    private final ProductPostViewBinding binding;
    private int extraStartPaddingBottom;
    private boolean isAnimating;
    private ProductPresenter presenter;
    private ProductViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductPostView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131559118, this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…t_post_view, this, false)");
        ProductPostViewBinding productPostViewBinding = (ProductPostViewBinding) inflate;
        this.binding = productPostViewBinding;
        ProductPostView productPostView = this;
        productPostViewBinding.setClick(productPostView);
        View root = productPostViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setClickable(true);
        setOnClickListener(productPostView);
        View root2 = productPostViewBinding.getRoot();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        addView(root2, layoutParams);
        int contentBackgroundColor = AppHolder.getAppTheme().getContentBackgroundColor();
        int alphaComponent = ColorUtils.setAlphaComponent(contentBackgroundColor, (int) 244.79999999999998d);
        FrameLayout frameLayout = productPostViewBinding.bgView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bgView");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{alphaComponent, contentBackgroundColor});
        gradientDrawable.setShape(0);
        float dp2px = (float) ConvertUtils.dp2px(16.0f);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        frameLayout.setBackground(gradientDrawable);
        productPostViewBinding.itemView1.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView2.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView3.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView4.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView6.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView7.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductPostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131559118, this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…t_post_view, this, false)");
        ProductPostViewBinding productPostViewBinding = (ProductPostViewBinding) inflate;
        this.binding = productPostViewBinding;
        ProductPostView productPostView = this;
        productPostViewBinding.setClick(productPostView);
        View root = productPostViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setClickable(true);
        setOnClickListener(productPostView);
        View root2 = productPostViewBinding.getRoot();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        addView(root2, layoutParams);
        int contentBackgroundColor = AppHolder.getAppTheme().getContentBackgroundColor();
        int alphaComponent = ColorUtils.setAlphaComponent(contentBackgroundColor, (int) 244.79999999999998d);
        FrameLayout frameLayout = productPostViewBinding.bgView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bgView");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{alphaComponent, contentBackgroundColor});
        gradientDrawable.setShape(0);
        float dp2px = (float) ConvertUtils.dp2px(16.0f);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        frameLayout.setBackground(gradientDrawable);
        productPostViewBinding.itemView1.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView2.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView3.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView4.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView6.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
        productPostViewBinding.itemView7.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
    }

    public final ProductViewModel getViewModel() {
        return this.viewModel;
    }

    public final void setViewModel(ProductViewModel productViewModel) {
        this.viewModel = productViewModel;
    }

    public final ProductPresenter getPresenter() {
        return this.presenter;
    }

    public final void setPresenter(ProductPresenter productPresenter) {
        this.presenter = productPresenter;
    }

    public final int getExtraStartPaddingBottom() {
        return this.extraStartPaddingBottom;
    }

    public final void setExtraStartPaddingBottom(int i) {
        this.extraStartPaddingBottom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Product model;
        Intrinsics.checkNotNullParameter(view, "v");
        if (Intrinsics.areEqual(view, this) || Intrinsics.areEqual(view, this.binding.getRoot())) {
            requestDismiss();
            return;
        }
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel != null && (model = productViewModel.getModel()) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null) {
                switch (view.getId()) {
                    case 2131362780:
                        ProductPresenter productPresenter = this.presenter;
                        if (productPresenter != null) {
                            productPresenter.commentProduct(activityNullable, model);
                        }
                        hideWithAnimator$default(this, false, 1, null);
                        return;
                    case 2131362781:
                    case 2131362782:
                    case 2131362783:
                    case 2131362787:
                    default:
                        return;
                    case 2131362784:
                        if (productViewModel.getRatingScore() > 0) {
                            Toast.show$default(getContext(), "不可重复点评", 0, false, 12, null);
                            return;
                        }
                        ProductPresenter productPresenter2 = this.presenter;
                        if (productPresenter2 != null) {
                            ProductPresenter.ratingProduct$default(productPresenter2, productViewModel, activityNullable, 0, false, 12, null);
                        }
                        hideWithAnimator$default(this, false, 1, null);
                        return;
                    case 2131362785:
                        FeedUIConfig build = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.uiConfigForQuestion(), activityNullable, model).title("").build();
                        FeedMultiPart build2 = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForQuestion(), model).message("").build();
                        StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("提问");
                        ActionManager.startQuestionTitleV8Activity(activityNullable, build, build2);
                        hideWithAnimator$default(this, false, 1, null);
                        return;
                    case 2131362786:
                        Activity activity = activityNullable;
                        FeedUIConfig build3 = FeedArgsFactoryKt.applyProduct(FeedArgsFactoryKt.applyHtml(FeedArgsFactory.uiConfigForFeed(activity)), activity, model).title("发图文").build();
                        FeedMultiPart build4 = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), model).build();
                        StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("图文评测");
                        ActionManager.startSubmitFeedV8Activity(activityNullable, build3, build4);
                        hideWithAnimator$default(this, false, 1, null);
                        return;
                    case 2131362788:
                        StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("视频");
                        ActionManager.startProductShareVideoActivity(activityNullable, model);
                        hideWithAnimator$default(this, false, 1, null);
                        return;
                    case 2131362789:
                        if (!model.isReleased()) {
                            Toast.show$default(getContext(), "产品暂未发布，无法发布二手", 0, false, 12, null);
                            return;
                        }
                        StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("二手");
                        ActionManager.startNewSecondHandFromPhoneBaActivity(activityNullable, model);
                        hideWithAnimator$default(this, false, 1, null);
                        return;
                }
            }
        }
    }

    public static /* synthetic */ void hideWithAnimator$default(ProductPostView productPostView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        productPostView.hideWithAnimator(z);
    }

    public final void hideWithAnimator(boolean z) {
        FrameLayout frameLayout = this.binding.bgView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bgView");
        int width = frameLayout.getWidth() - NumberExtendsKt.getDp((Number) 36);
        int height = (frameLayout.getHeight() - this.extraStartPaddingBottom) - NumberExtendsKt.getDp((Number) 36);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(frameLayout, width, height, (float) Math.sqrt((double) ((width * width) + (height * height))), 20.0f);
        Intrinsics.checkNotNullExpressionValue(createCircularReveal, "animator");
        createCircularReveal.setDuration(200);
        ExtraExtendsKt.addListeners$default(createCircularReveal, null, new ProductPostView$hideWithAnimator$1(this, z), 1, null);
        createCircularReveal.start();
        this.isAnimating = true;
    }

    private final void requestDismiss() {
        if (!this.isAnimating) {
            hideWithAnimator$default(this, false, 1, null);
        }
    }

    public final void showWithAnimator() {
        getViewTreeObserver().addOnPreDrawListener(new ProductPostView$showWithAnimator$$inlined$doOnNextPreDraw$1(this, this));
    }
}
