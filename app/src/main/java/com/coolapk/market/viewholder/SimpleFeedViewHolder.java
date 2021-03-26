package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSimpleFeedBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/viewholder/SimpleFeedViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSimpleFeedBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "mFeed", "picPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getPicPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "picPart$delegate", "bindHeaderViewPart", "", "bindToContent", "data", "onClick", "view", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGroupListViewHolder.kt */
public final class SimpleFeedViewHolder extends GenericBindHolder<ItemSimpleFeedBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558930;
    private final Lazy headerViewPart$delegate;
    private Feed mFeed;
    private final Lazy picPart$delegate;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public final NinePicViewPart getPicPart() {
        return (NinePicViewPart) this.picPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleFeedViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.headerViewPart$delegate = LazyKt.lazy(new SimpleFeedViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.picPart$delegate = LazyKt.lazy(new SimpleFeedViewHolder$picPart$2(this, dataBindingComponent));
        ((ItemSimpleFeedBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.SimpleFeedViewHolder.AnonymousClass1 */
            final /* synthetic */ SimpleFeedViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.this$0.showItemDialog();
                Unit unit = Unit.INSTANCE;
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SimpleFeedViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGroupListViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        this.mFeed = feed;
        ItemSimpleFeedBinding itemSimpleFeedBinding = (ItemSimpleFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSimpleFeedBinding, "binding");
        itemSimpleFeedBinding.setClick(this);
        ItemSimpleFeedBinding itemSimpleFeedBinding2 = (ItemSimpleFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSimpleFeedBinding2, "binding");
        itemSimpleFeedBinding2.setModel(feed);
        ItemSimpleFeedBinding itemSimpleFeedBinding3 = (ItemSimpleFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSimpleFeedBinding3, "binding");
        itemSimpleFeedBinding3.setTransformer(new CircleTransform(false, 0, 3, null));
        getPicPart().bindToContent(EntityExtendsKt.getHtmlPicArray(feed));
        ((ItemSimpleFeedBinding) getBinding()).executePendingBindings();
        TextView textView = ((ItemSimpleFeedBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "data.message");
        String replace = new Regex("[\\n\\r]").replace(message, " ");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886656));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        Unit unit = Unit.INSTANCE;
        ViewExtendsKt.setBriefMessage(textView, 90, replace, spannableStringBuilder);
        bindHeaderViewPart();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemSimpleFeedBinding itemSimpleFeedBinding4 = (ItemSimpleFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSimpleFeedBinding4, "binding");
        View root = itemSimpleFeedBinding4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed.getFeedTypeName());
    }

    private final void bindHeaderViewPart() {
        FeedIntegratedHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed = this.mFeed;
        if (feed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
        }
        headerViewPart.bindTo(feed);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed = this.mFeed;
        if (feed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
        }
        switch (view.getId()) {
            case 2131362200:
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed), null, null, 12, null);
                return;
            case 2131362595:
                CharSequence text = ((TextView) view).getText();
                if (text instanceof SpannableString) {
                    URLSpan[] uRLSpanArr = (URLSpan[]) ((SpannableString) text).getSpans(0, text.length(), URLSpan.class);
                    if (uRLSpanArr.length > 0) {
                        uRLSpanArr[0].onClick(view);
                        return;
                    }
                    return;
                }
                return;
            case 2131362970:
                showItemDialog();
                return;
            case 2131363877:
                ActionManager.startUserSpaceActivity(view, feed.getUid(), feed.getUserAvatar());
                return;
            default:
                super.onClick(view);
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        Feed feed = this.mFeed;
        if (feed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityExtendsKt.showItemDialog(feed, context);
    }
}
