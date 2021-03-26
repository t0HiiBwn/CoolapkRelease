package com.coolapk.market.view.feedv8.article;

import android.text.Editable;
import android.view.View;
import com.coolapk.market.databinding.SubmitFeedArticleTextPartBinding;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleText;
import com.coolapk.market.view.feedv8.article.ArticleViewModel;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.LazyTextWatcher;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditFeedTextHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;)V", "isBindToContent", "", "getViewModel", "()Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleEditFeedTextHolder.kt */
public final class ArticleEditFeedTextHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559152;
    private boolean isBindToContent;
    private final ArticleViewModel viewModel;

    public final ArticleViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleEditFeedTextHolder(View view, ArticleViewModel articleViewModel) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(articleViewModel, "viewModel");
        this.viewModel = articleViewModel;
        final SubmitFeedArticleTextPartBinding submitFeedArticleTextPartBinding = (SubmitFeedArticleTextPartBinding) getBinding();
        submitFeedArticleTextPartBinding.etTitle.addTextChangedListener(new LazyTextWatcher(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTextHolder.AnonymousClass1 */
            final /* synthetic */ ArticleEditFeedTextHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                super.afterTextChanged(editable);
                if (this.this$0.getAdapterPosition() >= 0 && !this.this$0.isBindToContent) {
                    this.this$0.getViewModel().updateModel(this.this$0.getAdapterPosition(), new ArticleEditFeedTextHolder$1$afterTextChanged$1(this));
                    this.this$0.getViewModel().handleAction(ArticleViewModel.ActionType.CheckSubmittable);
                    this.this$0.getViewModel().handleAction(ArticleViewModel.ActionType.CheckTextLength);
                }
            }
        });
        submitFeedArticleTextPartBinding.etTitle.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        submitFeedArticleTextPartBinding.etTitle.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        submitFeedArticleTextPartBinding.etTitle.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new Runnable(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTextHolder.AnonymousClass2 */
            final /* synthetic */ ArticleEditFeedTextHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.getViewModel().handleAction(ArticleViewModel.ActionType.PickContacts);
            }
        }));
        ArticleEditText articleEditText = submitFeedArticleTextPartBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText, "binding.etTitle");
        articleEditText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedTextHolder.AnonymousClass3 */
            final /* synthetic */ ArticleEditFeedTextHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    ArticleEditFeedTextHolder articleEditFeedTextHolder = this.this$0;
                    articleEditFeedTextHolder.getViewModel().updateFocusPair(submitFeedArticleTextPartBinding.etTitle, articleEditFeedTextHolder);
                } else {
                    Pair<ArticleEditText, BindingViewHolder> focusPair = this.this$0.getViewModel().getFocusPair();
                    BindingViewHolder second = focusPair != null ? focusPair.getSecond() : null;
                    ArticleEditFeedTextHolder articleEditFeedTextHolder2 = this.this$0;
                    if (second == articleEditFeedTextHolder2) {
                        articleEditFeedTextHolder2.getViewModel().updateFocusPair(null, null);
                    }
                }
                if (z) {
                    this.this$0.getViewModel().getMenuEnable().setValue(true);
                }
            }
        });
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(obj, "data");
        this.isBindToContent = true;
        SubmitFeedArticleTextPartBinding submitFeedArticleTextPartBinding = (SubmitFeedArticleTextPartBinding) getBinding();
        ArticleText articleText = (ArticleText) obj;
        List<ArticleModel> value = this.viewModel.getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "viewModel.dataList.value!!");
        List<ArticleModel> list = value;
        ListIterator<ArticleModel> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            if (listIterator.previous().getType() == ArticleModel.Type.Text) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i == 1) {
            ArticleEditText articleEditText = submitFeedArticleTextPartBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(articleEditText, "binding.etTitle");
            articleEditText.setHint(this.viewModel.getFirstTextHint());
            ArticleEditText articleEditText2 = submitFeedArticleTextPartBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(articleEditText2, "binding.etTitle");
            articleEditText2.setMinLines(this.viewModel.getFirstTextMinLines());
        } else {
            ArticleEditText articleEditText3 = submitFeedArticleTextPartBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(articleEditText3, "binding.etTitle");
            articleEditText3.setHint("");
            ArticleEditText articleEditText4 = submitFeedArticleTextPartBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(articleEditText4, "binding.etTitle");
            articleEditText4.setMinLines(2);
        }
        submitFeedArticleTextPartBinding.etTitle.setText(articleText.getText());
        ArticleEditText articleEditText5 = submitFeedArticleTextPartBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(articleEditText5, "binding.etTitle");
        if (articleEditText5.isFocused()) {
            ArticleEditText articleEditText6 = submitFeedArticleTextPartBinding.etTitle;
            ArticleEditText articleEditText7 = submitFeedArticleTextPartBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(articleEditText7, "binding.etTitle");
            Editable text = articleEditText7.getText();
            Intrinsics.checkNotNull(text);
            articleEditText6.setSelection(text.length());
        }
        this.isBindToContent = false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditFeedTextHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleEditFeedTextHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
