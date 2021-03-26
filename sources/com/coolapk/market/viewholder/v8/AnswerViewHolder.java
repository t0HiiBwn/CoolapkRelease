package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemAnswerViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0014\b\u0016\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001eB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/AnswerViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemAnswerViewBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "nineImageHotPlug", "com/coolapk/market/viewholder/v8/AnswerViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/viewholder/v8/AnswerViewHolder$nineImageHotPlug$1;", "relativeInfoHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "bindToContent", "", "hideInfoView", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AnswerViewHolder.kt */
public class AnswerViewHolder extends GenericBindHolder<ItemAnswerViewBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558587;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final AnswerViewHolder$nineImageHotPlug$1 nineImageHotPlug;
    private final BaseFeedRelativeHotPlug relativeInfoHotPlug;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnswerViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Space space = ((ItemAnswerViewBinding) getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.nineImageHotPlug = new AnswerViewHolder$nineImageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        this.headerViewPart$delegate = LazyKt.lazy(new AnswerViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space2 = ((ItemAnswerViewBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new BaseFeedRelativeHotPlug(space2, dataBindingComponent, null, false, 12, null);
        ItemAnswerViewBinding itemAnswerViewBinding = (ItemAnswerViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAnswerViewBinding, "binding");
        itemAnswerViewBinding.setClick(this);
        ItemAnswerViewBinding itemAnswerViewBinding2 = (ItemAnswerViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAnswerViewBinding2, "binding");
        itemAnswerViewBinding2.setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemAnswerViewBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.AnswerViewHolder.AnonymousClass1 */
            final /* synthetic */ AnswerViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed feed = this.this$0.feed;
                if (feed == null) {
                    return true;
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(feed, context);
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/AnswerViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AnswerViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.nineImageHotPlug.onRecycled();
        this.relativeInfoHotPlug.onRecycled();
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.feed = feed2;
        ItemAnswerViewBinding itemAnswerViewBinding = (ItemAnswerViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAnswerViewBinding, "binding");
        itemAnswerViewBinding.setModel(feed2);
        getHeaderViewPart().bindTo(feed2);
        this.nineImageHotPlug.bindTo(EntityExtendsKt.getHtmlPicArray(feed2));
        this.relativeInfoHotPlug.bindTo(feed2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[Answer]");
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 38.0f), 0);
        spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[Answer]"), 0, spannableStringBuilder.length(), 33);
        String messageTitle = feed2.getMessageTitle();
        if (messageTitle == null) {
            messageTitle = "";
        }
        spannableStringBuilder.append((CharSequence) messageTitle);
        CoolEllipsizeTextView coolEllipsizeTextView = itemAnswerViewBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
        ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView, 2, spannableStringBuilder, null, false, 12, null);
        String message = feed2.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "feed.message");
        SpannableStringBuilder convert = LinkTextUtils.convert(new Regex("[\\n\\r]").replace(message, " "), AppHolder.getAppTheme().getColorAccent(), null);
        CoolEllipsizeTextView coolEllipsizeTextView2 = itemAnswerViewBinding.textView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.textView");
        ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView2, 3, convert, null, false, 12, null);
        itemAnswerViewBinding.executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemAnswerViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 == null) {
            return;
        }
        if (view.getId() != 2131362200) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
    }

    public final void hideInfoView() {
        getHeaderViewPart().hideFromWhereView();
    }
}
