package com.coolapk.market.viewholder.v8;

import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedSmallHeaderViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedSmallHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSmallHeaderViewBinding;", "Lcom/coolapk/market/model/Feed;", "dataBindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getDataBindingComponent", "()Landroidx/databinding/DataBindingComponent;", "mFeed", "onBindToContent", "", "data", "onClick", "view", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedSmallHeaderViewPart.kt */
public final class FeedSmallHeaderViewPart extends BindingViewPart<ItemFeedSmallHeaderViewBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558727;
    private final DataBindingComponent dataBindingComponent;
    private Feed mFeed;

    public FeedSmallHeaderViewPart(DataBindingComponent dataBindingComponent2) {
        Intrinsics.checkNotNullParameter(dataBindingComponent2, "dataBindingComponent");
        this.dataBindingComponent = dataBindingComponent2;
    }

    public final DataBindingComponent getDataBindingComponent() {
        return this.dataBindingComponent;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedSmallHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSmallHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedSmallHeaderViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558727, viewGroup, false, this.dataBindingComponent);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…se, dataBindingComponent)");
        return (ItemFeedSmallHeaderViewBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.onBindToContent((FeedSmallHeaderViewPart) feed);
        this.mFeed = feed;
        ((ItemFeedSmallHeaderViewBinding) getBinding()).setClick(this);
        ((ItemFeedSmallHeaderViewBinding) getBinding()).setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemFeedSmallHeaderViewBinding) getBinding()).setModel(feed);
        ((ItemFeedSmallHeaderViewBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed = this.mFeed;
        if (feed != null) {
            int id = view.getId();
            if (id == 2131362595) {
                CharSequence text = ((TextView) view).getText();
                if (text instanceof SpannableString) {
                    URLSpan[] uRLSpanArr = (URLSpan[]) ((SpannableString) text).getSpans(0, text.length(), URLSpan.class);
                    Intrinsics.checkNotNullExpressionValue(uRLSpanArr, "spans");
                    if (!(uRLSpanArr.length == 0)) {
                        uRLSpanArr[0].onClick(view);
                    }
                }
            } else if (id == 2131362970) {
                showItemDialog();
            } else if (id != 2131363877) {
                super.onClick(view);
            } else {
                ActionManager.startUserSpaceActivity(view, feed.getUid(), feed.getUserAvatar());
            }
        }
    }

    private final void showItemDialog() {
        Feed feed = this.mFeed;
        if (feed != null) {
            EntityExtendsKt.showItemDialog(feed, getContext());
        }
    }
}
