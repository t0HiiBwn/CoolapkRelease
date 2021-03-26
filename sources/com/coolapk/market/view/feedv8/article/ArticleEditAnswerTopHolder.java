package com.coolapk.market.view.feedv8.article;

import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.SubmitFeedArticleTopAnswerBinding;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.viewholder.BindingViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditAnswerTopHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleEditAnswerTopHolder.kt */
public final class ArticleEditAnswerTopHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559161;
    private final ArticleViewModel viewModel;

    public final ArticleViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleEditAnswerTopHolder(View view, ArticleViewModel articleViewModel) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(articleViewModel, "viewModel");
        this.viewModel = articleViewModel;
        final SubmitFeedArticleTopAnswerBinding submitFeedArticleTopAnswerBinding = (SubmitFeedArticleTopAnswerBinding) getBinding();
        TextView textView = submitFeedArticleTopAnswerBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.etTitle");
        textView.setMaxEms(50);
        submitFeedArticleTopAnswerBinding.etTitle.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        if (articleViewModel.isAlertViewUserDismiss()) {
            FeedWarningBinding feedWarningBinding = submitFeedArticleTopAnswerBinding.alertView;
            Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
            View root = feedWarningBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
            root.setVisibility(8);
        }
        submitFeedArticleTopAnswerBinding.alertView.executePendingBindings();
        submitFeedArticleTopAnswerBinding.alertView.closeAlertView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditAnswerTopHolder.AnonymousClass1 */
            final /* synthetic */ ArticleEditAnswerTopHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedWarningBinding feedWarningBinding = submitFeedArticleTopAnswerBinding.alertView;
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
                    FeedWarningBinding feedWarningBinding2 = submitFeedArticleTopAnswerBinding.alertView;
                    Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                    View root2 = feedWarningBinding2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                    root2.setVisibility(8);
                    this.this$0.getViewModel().setAlertViewUserDismiss(true);
                }
            }
        });
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        TextView textView = ((SubmitFeedArticleTopAnswerBinding) getBinding()).etTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.etTitle");
        textView.setText(((ArticleNative) obj).getText());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditAnswerTopHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleEditAnswerTopHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
