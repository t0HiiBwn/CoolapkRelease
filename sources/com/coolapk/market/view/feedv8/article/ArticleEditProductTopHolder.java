package com.coolapk.market.view.feedv8.article;

import android.content.res.ColorStateList;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.SubmitProductArticleTopPartBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.view.feedv8.ArticleRatingContentHolder;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.view.feedv8.SubmitExtraViewPart;
import com.coolapk.market.view.feedv8.article.ArticleViewModel;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.LazyTextWatcher;
import com.coolapk.market.widget.view.BadBadRatingBar;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditProductTopHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "content", "Lcom/coolapk/market/view/feedv8/ArticleRatingContentHolder;", "viewModel", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/ArticleRatingContentHolder;Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;)V", "getContent", "()Lcom/coolapk/market/view/feedv8/ArticleRatingContentHolder;", "getViewModel", "()Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "bindTo", "", "data", "", "updateBuyStateVisibility", "updateRatingScore", "score", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleEditProductTopHolder.kt */
public final class ArticleEditProductTopHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559173;
    private final ArticleRatingContentHolder content;
    private final ArticleViewModel viewModel;

    public final ArticleRatingContentHolder getContent() {
        return this.content;
    }

    public final ArticleViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleEditProductTopHolder(View view, ArticleRatingContentHolder articleRatingContentHolder, ArticleViewModel articleViewModel) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(articleRatingContentHolder, "content");
        Intrinsics.checkNotNullParameter(articleViewModel, "viewModel");
        this.content = articleRatingContentHolder;
        this.viewModel = articleViewModel;
        final SubmitProductArticleTopPartBinding submitProductArticleTopPartBinding = (SubmitProductArticleTopPartBinding) getBinding();
        submitProductArticleTopPartBinding.ivCover.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditProductTopHolder.AnonymousClass1 */
            final /* synthetic */ ArticleEditProductTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getContent().requestPickArticlePhoto();
            }
        });
        submitProductArticleTopPartBinding.etTitle.addTextChangedListener(new LazyTextWatcher(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditProductTopHolder.AnonymousClass2 */
            final /* synthetic */ ArticleEditProductTopHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                super.afterTextChanged(editable);
                if (this.this$0.getAdapterPosition() >= 0) {
                    this.this$0.getViewModel().updateModel(this.this$0.getAdapterPosition(), new ArticleEditProductTopHolder$2$afterTextChanged$1(editable));
                    this.this$0.getViewModel().handleAction(ArticleViewModel.ActionType.CheckSubmittable);
                }
            }
        });
        ArticleEditText articleEditText = submitProductArticleTopPartBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText, "binding.etTitle");
        articleEditText.setMaxEms(50);
        submitProductArticleTopPartBinding.etTitle.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        ArticleEditText articleEditText2 = submitProductArticleTopPartBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText2, "binding.etTitle");
        articleEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditProductTopHolder.AnonymousClass3 */
            final /* synthetic */ ArticleEditProductTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.this$0.getViewModel().getMenuEnable().setValue(false);
                }
            }
        });
        submitProductArticleTopPartBinding.closeView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditProductTopHolder.AnonymousClass4 */
            final /* synthetic */ ArticleEditProductTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.this$0.getAdapterPosition() >= 0) {
                    ArticleViewModel.updateDataList$default(this.this$0.getViewModel(), false, false, new Function1<List<ArticleModel>, Unit>(this) {
                        /* class com.coolapk.market.view.feedv8.article.ArticleEditProductTopHolder.AnonymousClass4.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<ArticleModel> list) {
                            invoke(list);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<ArticleModel> list) {
                            Intrinsics.checkNotNullParameter(list, "it");
                            int adapterPosition = this.this$0.this$0.getAdapterPosition();
                            ArticleModel articleModel = list.get(this.this$0.this$0.getAdapterPosition());
                            Objects.requireNonNull(articleModel, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.ArticleNative");
                            list.set(adapterPosition, ArticleNative.copy$default((ArticleNative) articleModel, null, "", null, 5, null));
                        }
                    }, 3, null);
                }
            }
        });
        submitProductArticleTopPartBinding.etTitle.addTextChangedListener(new CommentHelper.CharRejectHelper('\n'));
        SubmitExtraViewPart.Companion companion = SubmitExtraViewPart.Companion;
        LinearLayout linearLayout = submitProductArticleTopPartBinding.relativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
        companion.fillRelativeInfoViewIntoLayout(linearLayout, articleRatingContentHolder.getUiConfig(), new LinearLayout.LayoutParams(-1, NumberExtendsKt.getDp(Double.valueOf(0.5d))));
        BadBadRatingBar badBadRatingBar = submitProductArticleTopPartBinding.ratingBar;
        badBadRatingBar.setProgressBar(NumberExtendsKt.getDp((Number) 36), false);
        badBadRatingBar.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
        badBadRatingBar.setOnRatingBarChangeListener(new ArticleEditProductTopHolder$$special$$inlined$apply$lambda$1(this));
        if (articleViewModel.isAlertViewUserDismiss()) {
            FeedWarningBinding feedWarningBinding = submitProductArticleTopPartBinding.alertView;
            Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
            View root = feedWarningBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
            root.setVisibility(8);
        }
        submitProductArticleTopPartBinding.alertView.executePendingBindings();
        submitProductArticleTopPartBinding.alertView.closeAlertView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditProductTopHolder.AnonymousClass6 */
            final /* synthetic */ ArticleEditProductTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedWarningBinding feedWarningBinding = submitProductArticleTopPartBinding.alertView;
                Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
                View root = feedWarningBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
                ViewParent parent = root.getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    TransitionManager.beginDelayedTransition(viewGroup);
                    FeedWarningBinding feedWarningBinding2 = submitProductArticleTopPartBinding.alertView;
                    Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                    View root2 = feedWarningBinding2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                    root2.setVisibility(8);
                    this.this$0.getViewModel().setAlertViewUserDismiss(true);
                }
            }
        });
        TintHelper.setTint(submitProductArticleTopPartBinding.buyStateView, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
    }

    /* access modifiers changed from: private */
    public final void updateRatingScore(int i) {
        SubmitProductArticleTopPartBinding submitProductArticleTopPartBinding = (SubmitProductArticleTopPartBinding) getBinding();
        int constrain = KotlinExtendKt.constrain(i, 5, 0);
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar = submitProductArticleTopPartBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        TextView textView = submitProductArticleTopPartBinding.scoreTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreTextView");
        String targetType = this.content.getMultiPart().targetType();
        Intrinsics.checkNotNullExpressionValue(targetType, "content.multiPart.targetType()");
        ratingContentHelper.setRatingUI(badBadRatingBar, textView, targetType, constrain);
        ArticleRatingContentHolder articleRatingContentHolder = this.content;
        if (articleRatingContentHolder.getMultiPart().ratingScore1() != constrain) {
            FeedMultiPart build = articleRatingContentHolder.getMultiPart().newBuilder().ratingScore1(constrain).build();
            Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().r…Score1(realScore).build()");
            articleRatingContentHolder.updateMultiPart$presentation_coolapkAppRelease(build);
            articleRatingContentHolder.requestCheckSubmittable$presentation_coolapkAppRelease();
        }
        updateBuyStateVisibility();
    }

    private final void updateBuyStateVisibility() {
        FeedMultiPart multiPart = this.content.getMultiPart();
        SubmitProductArticleTopPartBinding submitProductArticleTopPartBinding = (SubmitProductArticleTopPartBinding) getBinding();
        if (multiPart.ratingScore1() > 0 || multiPart.buyStatus()) {
            CheckBox checkBox = submitProductArticleTopPartBinding.buyStateView;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.buyStateView");
            if ((checkBox.getVisibility() == 8) && Intrinsics.areEqual(multiPart.targetType(), "product_phone")) {
                CheckBox checkBox2 = submitProductArticleTopPartBinding.buyStateView;
                Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.buyStateView");
                ViewParent parent = checkBox2.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                TransitionManager.beginDelayedTransition((ViewGroup) parent);
                CheckBox checkBox3 = submitProductArticleTopPartBinding.buyStateView;
                Intrinsics.checkNotNullExpressionValue(checkBox3, "binding.buyStateView");
                checkBox3.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        SubmitProductArticleTopPartBinding submitProductArticleTopPartBinding = (SubmitProductArticleTopPartBinding) getBinding();
        ArticleNative articleNative = (ArticleNative) obj;
        submitProductArticleTopPartBinding.etTitle.setText(articleNative.getText());
        if (!TextUtils.isEmpty(articleNative.getImageUrl())) {
            ImageView imageView = submitProductArticleTopPartBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCover");
            ImageView imageView2 = imageView;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = DisplayUtils.getDecorViewWidth(getContext()) - NumberExtendsKt.getDp((Number) 32);
                layoutParams.height = (int) (((float) layoutParams.width) * 0.45f);
                imageView2.setLayoutParams(layoutParams);
                ImageView imageView3 = submitProductArticleTopPartBinding.closeView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.closeView");
                imageView3.setVisibility(0);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        } else {
            ImageView imageView4 = submitProductArticleTopPartBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivCover");
            ImageView imageView5 = imageView4;
            ViewGroup.LayoutParams layoutParams2 = imageView5.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = DisplayUtils.getDecorViewWidth(getContext()) - NumberExtendsKt.getDp((Number) 32);
                layoutParams2.height = NumberExtendsKt.getDp((Number) 80);
                imageView5.setLayoutParams(layoutParams2);
                ImageView imageView6 = submitProductArticleTopPartBinding.closeView;
                Intrinsics.checkNotNullExpressionValue(imageView6, "binding.closeView");
                imageView6.setVisibility(8);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        Uri parse = Uri.parse(StringUtils.notNull(articleNative.getImageUrl()));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(model.imageUrl))");
        Uri safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
        ImageView imageView7 = submitProductArticleTopPartBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(imageView7, "binding.ivCover");
        ViewGroup.LayoutParams layoutParams3 = imageView7.getLayoutParams();
        GlideApp.with(this.content.getActivity()).load(safeFileUri).skipMemoryCache(true).override(layoutParams3.width, layoutParams3.height).diskCacheStrategy(DiskCacheStrategy.NONE).into(submitProductArticleTopPartBinding.ivCover);
        FeedMultiPart multiPart = this.content.getMultiPart();
        submitProductArticleTopPartBinding.ratingBar.setRating((float) multiPart.ratingScore1());
        updateRatingScore(multiPart.ratingScore1());
        updateBuyStateVisibility();
        CheckBox checkBox = submitProductArticleTopPartBinding.buyStateView;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.buyStateView");
        checkBox.setChecked(multiPart.buyStatus());
        submitProductArticleTopPartBinding.buyStateView.setOnCheckedChangeListener(new ArticleEditProductTopHolder$bindTo$4(this, multiPart));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditProductTopHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleEditProductTopHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
