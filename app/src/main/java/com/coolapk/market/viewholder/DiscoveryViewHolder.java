package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemDiscoveryViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0014\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001eB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/DiscoveryViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemDiscoveryViewBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "imageHotPlug", "com/coolapk/market/viewholder/DiscoveryViewHolder$imageHotPlug$1", "Lcom/coolapk/market/viewholder/DiscoveryViewHolder$imageHotPlug$1;", "relativeInfoHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "bindToContent", "", "onClick", "view", "onRecycled", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DiscoveryViewHolder.kt */
public final class DiscoveryViewHolder extends GenericBindHolder<ItemDiscoveryViewBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558671;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final DiscoveryViewHolder$imageHotPlug$1 imageHotPlug;
    private final BaseFeedRelativeHotPlug relativeInfoHotPlug;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscoveryViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.headerViewPart$delegate = LazyKt.lazy(new DiscoveryViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space = ((ItemDiscoveryViewBinding) getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.imageHotPlug = new DiscoveryViewHolder$imageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        Space space2 = ((ItemDiscoveryViewBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new BaseFeedRelativeHotPlug(space2, dataBindingComponent, null, false, 12, null);
        ((ItemDiscoveryViewBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.DiscoveryViewHolder.AnonymousClass1 */
            final /* synthetic */ DiscoveryViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.this$0.showItemDialog();
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/DiscoveryViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DiscoveryViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.feed = null;
        ItemDiscoveryViewBinding itemDiscoveryViewBinding = (ItemDiscoveryViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDiscoveryViewBinding, "binding");
        itemDiscoveryViewBinding.getModel();
        this.relativeInfoHotPlug.onRecycled();
        this.imageHotPlug.onRecycled();
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.feed = feed2;
        ItemDiscoveryViewBinding itemDiscoveryViewBinding = (ItemDiscoveryViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDiscoveryViewBinding, "binding");
        if (feed2 != itemDiscoveryViewBinding.getModel()) {
            itemDiscoveryViewBinding.setModel(feed2);
            itemDiscoveryViewBinding.setClick(this);
            itemDiscoveryViewBinding.executePendingBindings();
            getHeaderViewPart().bindTo(feed2);
            this.relativeInfoHotPlug.bindTo(feed2);
            DiscoveryViewHolder$imageHotPlug$1 discoveryViewHolder$imageHotPlug$1 = this.imageHotPlug;
            List<String> picArray = feed2.getPicArray();
            Intrinsics.checkNotNullExpressionValue(picArray, "feed.picArray");
            discoveryViewHolder$imageHotPlug$1.bindTo(picArray);
            TextView textView = itemDiscoveryViewBinding.textView;
            String message = feed2.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "feed.message");
            TextViewBindingAdapters.setTextViewLinkable(textView, new Regex("[\\n\\r]").replace(message, ""));
        } else {
            itemDiscoveryViewBinding.feedActionView.updateFeed(feed2);
        }
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemDiscoveryViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            switch (view.getId()) {
                case 2131361876:
                    if (!FeedUtils.isDiscoveryType(feed2.getFeedType())) {
                        return;
                    }
                    if (feed2.isIncludedDiscoveryFeed()) {
                        Context context = getContext();
                        Feed feed3 = this.feed;
                        Intrinsics.checkNotNull(feed3);
                        ActionManager.startAppViewActivity(context, feed3.getPackageName());
                        return;
                    }
                    Context context2 = getContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://www.coolapk.com");
                    String extraLinkUrl = feed2.getExtraLinkUrl();
                    Intrinsics.checkNotNull(extraLinkUrl);
                    sb.append(extraLinkUrl);
                    ActionManager.startExternalMarketByName(context2, sb.toString(), feed2.getExtraInfo(), feed2.getExtraKey());
                    return;
                case 2131362200:
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    ActionManagerCompat.startActivityByUrl$default(context3, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
                    return;
                case 2131362595:
                    CharSequence text = ((TextView) view).getText();
                    if (text instanceof SpannableString) {
                        URLSpan[] uRLSpanArr = (URLSpan[]) ((SpannableString) text).getSpans(0, text.length(), URLSpan.class);
                        Intrinsics.checkNotNullExpressionValue(uRLSpanArr, "spans");
                        if (!(uRLSpanArr.length == 0)) {
                            uRLSpanArr[0].onClick(view);
                            return;
                        }
                        return;
                    }
                    return;
                case 2131362707:
                    ActionManager.startPhotoViewActivity(view, feed2.getPic(), feed2.getMiddleSizePic());
                    return;
                case 2131362970:
                    showItemDialog();
                    return;
                case 2131363877:
                    ActionManager.startUserSpaceActivity(view, feed2.getUid(), feed2.getUserAvatar());
                    return;
                default:
                    super.onClick(view);
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            EntityExtendsKt.showItemDialog(feed2, context);
        }
    }
}
