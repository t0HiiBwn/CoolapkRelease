package com.coolapk.market.view.feed.article;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemArticleViewTextBinding;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feed/article/BottomSpaceViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "Lkotlin/Lazy;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BottomSpaceViewHolder.kt */
public final class BottomSpaceViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558617;
    public static final int VIEW_TYPE = 20897633;
    private final ArticleFragmentPresenter presenter;
    private final Lazy relativeInfoViewPart$delegate = LazyKt.lazy(new BottomSpaceViewHolder$relativeInfoViewPart$2(this));

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSpaceViewHolder(View view, DataBindingComponent dataBindingComponent, ArticleFragmentPresenter articleFragmentPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        Intrinsics.checkNotNullParameter(articleFragmentPresenter, "presenter");
        this.presenter = articleFragmentPresenter;
        TextView textView = ((ItemArticleViewTextBinding) getBinding()).etTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.etTitle");
        textView.setVisibility(8);
    }

    public final ArticleFragmentPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/article/BottomSpaceViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "VIEW_TYPE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BottomSpaceViewHolder.kt */
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
        getRelativeInfoViewPart().bindTo(this.presenter.getFeed());
    }
}
