package com.coolapk.market.view.feedv8.article;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.SubmitFeedArticleTopPartBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.ArticleFeedContentHolder2;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.view.feedv8.SubmitExtraViewPart;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.LazyTextWatcher;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditFeedTopHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "content", "Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "viewModel", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;)V", "getContent", "()Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "getViewModel", "()Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "bindTo", "", "data", "", "setRating", "rating", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleEditFeedTopHolder.kt */
public final class ArticleEditFeedTopHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559162;
    private final ArticleFeedContentHolder2 content;
    private final ArticleViewModel viewModel;

    public final ArticleFeedContentHolder2 getContent() {
        return this.content;
    }

    public final ArticleViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleEditFeedTopHolder(View view, ArticleFeedContentHolder2 articleFeedContentHolder2, ArticleViewModel articleViewModel) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(articleFeedContentHolder2, "content");
        Intrinsics.checkNotNullParameter(articleViewModel, "viewModel");
        this.content = articleFeedContentHolder2;
        this.viewModel = articleViewModel;
        final SubmitFeedArticleTopPartBinding submitFeedArticleTopPartBinding = (SubmitFeedArticleTopPartBinding) getBinding();
        submitFeedArticleTopPartBinding.ivCover.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass1 */
            final /* synthetic */ ArticleEditFeedTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getContent().requestPickArticlePhoto();
            }
        });
        submitFeedArticleTopPartBinding.etTitle.addTextChangedListener(new LazyTextWatcher(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass2 */
            final /* synthetic */ ArticleEditFeedTopHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                super.afterTextChanged(editable);
                if (this.this$0.getAdapterPosition() >= 0) {
                    this.this$0.getViewModel().updateModel(this.this$0.getAdapterPosition(), new ArticleEditFeedTopHolder$2$afterTextChanged$1(editable));
                }
            }
        });
        ArticleEditText articleEditText = submitFeedArticleTopPartBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText, "binding.etTitle");
        articleEditText.setMaxEms(50);
        submitFeedArticleTopPartBinding.etTitle.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        ArticleEditText articleEditText2 = submitFeedArticleTopPartBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText2, "binding.etTitle");
        articleEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass3 */
            final /* synthetic */ ArticleEditFeedTopHolder this$0;

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
        submitFeedArticleTopPartBinding.closeView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass4 */
            final /* synthetic */ ArticleEditFeedTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.this$0.getAdapterPosition() >= 0) {
                    ArticleViewModel.updateDataList$default(this.this$0.getViewModel(), false, false, new Function1<List<ArticleModel>, Unit>(this) {
                        /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass4.AnonymousClass1 */
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
        int i = 8;
        if (articleViewModel.isAlertViewUserDismiss()) {
            FeedWarningBinding feedWarningBinding = submitFeedArticleTopPartBinding.alertView;
            Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
            View root = feedWarningBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
            root.setVisibility(8);
        }
        submitFeedArticleTopPartBinding.alertView.executePendingBindings();
        submitFeedArticleTopPartBinding.alertView.closeAlertView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass5 */
            final /* synthetic */ ArticleEditFeedTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedWarningBinding feedWarningBinding = submitFeedArticleTopPartBinding.alertView;
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
                    FeedWarningBinding feedWarningBinding2 = submitFeedArticleTopPartBinding.alertView;
                    Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                    View root2 = feedWarningBinding2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                    root2.setVisibility(8);
                    this.this$0.getViewModel().setAlertViewUserDismiss(true);
                }
            }
        });
        submitFeedArticleTopPartBinding.etTitle.addTextChangedListener(new CommentHelper.CharRejectHelper('\n'));
        RatingBar ratingBar = submitFeedArticleTopPartBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ViewParent parent = ratingBar.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setVisibility(articleFeedContentHolder2.getUiConfig().isRatingBarVisible() ? 0 : i);
        ratingBar.setRating((float) articleFeedContentHolder2.getMultiPart().voteScore());
        setRating((float) articleFeedContentHolder2.getMultiPart().voteScore());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTopHolder.AnonymousClass6 */
            final /* synthetic */ ArticleEditFeedTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                this.this$0.setRating(f);
                this.this$0.getContent().requestCheckSubmittable$presentation_coolapkAppRelease();
            }
        });
        int resolveData = ResourceUtils.resolveData(articleFeedContentHolder2.getActivity(), 16842808);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        ratingBar.setBackgroundTintList(ColorStateList.valueOf(resolveData));
        ratingBar.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
        ratingBar.setProgressBackgroundTintList(ColorStateList.valueOf(resolveData));
        ratingBar.setProgressBackgroundTintMode(PorterDuff.Mode.SRC_IN);
        ratingBar.setProgressTintList(ColorStateList.valueOf(colorAccent));
        ratingBar.setProgressTintMode(PorterDuff.Mode.SRC_IN);
        ratingBar.setSecondaryProgressTintList(ColorStateList.valueOf(resolveData));
        ratingBar.setSecondaryProgressTintMode(PorterDuff.Mode.SRC_IN);
        SubmitExtraViewPart.Companion companion = SubmitExtraViewPart.Companion;
        LinearLayout linearLayout = submitFeedArticleTopPartBinding.relativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
        SubmitExtraViewPart.Companion.fillRelativeInfoViewIntoLayout$default(companion, linearLayout, articleFeedContentHolder2.getUiConfig(), null, 4, null);
    }

    /* access modifiers changed from: private */
    public final void setRating(float f) {
        TextView textView = ((SubmitFeedArticleTopPartBinding) getBinding()).ratingTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.ratingTextView");
        if (f >= ((float) 5)) {
            textView.setText(2131887003);
        } else if (f >= ((float) 4)) {
            textView.setText(2131887004);
        } else if (f >= ((float) 3)) {
            textView.setText(2131887009);
        } else if (f >= ((float) 2)) {
            textView.setText(2131887011);
        } else if (f >= ((float) 1)) {
            textView.setText(2131887007);
        } else {
            textView.setText(2131887010);
        }
        ArticleFeedContentHolder2 articleFeedContentHolder2 = this.content;
        FeedMultiPart build = FeedMultiPart.builder(articleFeedContentHolder2.getMultiPart()).voteScore((int) f).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder(co…\n                .build()");
        articleFeedContentHolder2.updateMultiPart$presentation_coolapkAppRelease(build);
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        SubmitFeedArticleTopPartBinding submitFeedArticleTopPartBinding = (SubmitFeedArticleTopPartBinding) getBinding();
        ArticleNative articleNative = (ArticleNative) obj;
        submitFeedArticleTopPartBinding.etTitle.setText(articleNative.getText());
        if (!TextUtils.isEmpty(articleNative.getImageUrl())) {
            ImageView imageView = submitFeedArticleTopPartBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCover");
            ImageView imageView2 = imageView;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = DisplayUtils.getDecorViewWidth(getContext()) - NumberExtendsKt.getDp((Number) 32);
                layoutParams.height = (int) (((float) layoutParams.width) * 0.45f);
                imageView2.setLayoutParams(layoutParams);
                ImageView imageView3 = submitFeedArticleTopPartBinding.closeView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.closeView");
                imageView3.setVisibility(0);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        } else {
            ImageView imageView4 = submitFeedArticleTopPartBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivCover");
            ImageView imageView5 = imageView4;
            ViewGroup.LayoutParams layoutParams2 = imageView5.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = DisplayUtils.getDecorViewWidth(getContext()) - NumberExtendsKt.getDp((Number) 32);
                layoutParams2.height = NumberExtendsKt.getDp((Number) 80);
                imageView5.setLayoutParams(layoutParams2);
                ImageView imageView6 = submitFeedArticleTopPartBinding.closeView;
                Intrinsics.checkNotNullExpressionValue(imageView6, "binding.closeView");
                imageView6.setVisibility(8);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        Uri parse = Uri.parse(StringUtils.notNull(articleNative.getImageUrl()));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(model.imageUrl))");
        Uri safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
        ImageView imageView7 = submitFeedArticleTopPartBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(imageView7, "binding.ivCover");
        ViewGroup.LayoutParams layoutParams3 = imageView7.getLayoutParams();
        GlideApp.with(this.content.getActivity()).load(safeFileUri).skipMemoryCache(true).override(layoutParams3.width, layoutParams3.height).diskCacheStrategy(DiskCacheStrategy.NONE).into(submitFeedArticleTopPartBinding.ivCover);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditFeedTopHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleEditFeedTopHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
