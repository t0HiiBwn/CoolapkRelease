package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedNewsBottomBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/viewholder/FeedArticleSourceViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedNewsBottomBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "bindTo", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArticleSourceViewPart.kt */
public final class FeedArticleSourceViewPart extends BindingViewPart<ItemFeedNewsBottomBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558709;
    private final DataBindingComponent component;

    public FeedArticleSourceViewPart() {
        this(null, 1, null);
    }

    public FeedArticleSourceViewPart(DataBindingComponent dataBindingComponent) {
        this.component = dataBindingComponent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedArticleSourceViewPart(DataBindingComponent dataBindingComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataBindingComponent);
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/FeedArticleSourceViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedArticleSourceViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "data");
            return EntityUtils.isFeedArticleNewsType(feed.getEntityTemplate());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedNewsBottomBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558709, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemFeedNewsBottomBinding) inflate;
    }

    public final void bindTo(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        ((ItemFeedNewsBottomBinding) getBinding()).setModel(feed);
        TextView textView = ((ItemFeedNewsBottomBinding) getBinding()).leftBottomText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.leftBottomText");
        textView.setText(feed.getUserName() + "  " + DateUtils.getTimeDescription(getContext(), feed.getLastUpdate()));
        ((ItemFeedNewsBottomBinding) getBinding()).executePendingBindings();
    }
}
