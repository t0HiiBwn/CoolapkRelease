package com.coolapk.market.view.feed.article;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemArticleViewTextBinding;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleText;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleTextViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleTextViewHolder.kt */
public final class ArticleTextViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558617;
    private final ArticleFragmentPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleTextViewHolder(View view, DataBindingComponent dataBindingComponent, ArticleFragmentPresenter articleFragmentPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        Intrinsics.checkNotNullParameter(articleFragmentPresenter, "presenter");
        this.presenter = articleFragmentPresenter;
    }

    public final ArticleFragmentPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleTextViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleTextViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        List<ArticleModel> articleModelList = this.presenter.getArticleModelList();
        Integer intValue = ((HolderItem) obj).getIntValue();
        Intrinsics.checkNotNullExpressionValue(intValue, "(data as HolderItem).intValue");
        ArticleModel articleModel = articleModelList.get(intValue.intValue());
        Objects.requireNonNull(articleModel, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.ArticleText");
        ItemArticleViewTextBinding itemArticleViewTextBinding = (ItemArticleViewTextBinding) getBinding();
        TextViewBindingAdapters.setTextViewLinkable(itemArticleViewTextBinding.etTitle, ((ArticleText) articleModel).getText());
        if (this.presenter.getArticleModelList().size() == 1) {
            TextView textView = itemArticleViewTextBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.etTitle");
            textView.setMinLines(3);
            return;
        }
        TextView textView2 = itemArticleViewTextBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.etTitle");
        textView2.setMinLines(0);
    }
}
