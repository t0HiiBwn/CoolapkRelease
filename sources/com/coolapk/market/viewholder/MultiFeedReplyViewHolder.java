package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.databinding.ItemFeedReplyTextBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/viewholder/MultiFeedReplyViewHolder;", "Lcom/coolapk/market/viewholder/FeedReplyViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "feedType", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Ljava/lang/String;)V", "reply", "Lcom/coolapk/market/model/FeedReply;", "onPopulateSubReplyView", "", "Companion", "SubReplyAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiFeedReplyViewHolder.kt */
public class MultiFeedReplyViewHolder extends FeedReplyViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558723;
    private final String feedType;
    private FeedReply reply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiFeedReplyViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, String str) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(str, "feedType");
        this.feedType = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiFeedReplyViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, itemActionHandler, (i & 8) != 0 ? "" : str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0094  */
    @Override // com.coolapk.market.viewholder.FeedReplyViewHolder
    protected void onPopulateSubReplyView(FeedReply feedReply) {
        int i;
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        this.reply = feedReply;
        ItemFeedReplyBinding itemFeedReplyBinding = (ItemFeedReplyBinding) getBinding();
        if (feedReply.getReplyRowsMore() > 0) {
            TextView textView = itemFeedReplyBinding.moreSubReplyView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.moreSubReplyView");
            textView.setVisibility(0);
            TextView textView2 = itemFeedReplyBinding.moreSubReplyView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.moreSubReplyView");
            textView2.setText(getContext().getString(2131886864, Integer.valueOf(feedReply.getReplyNum())));
            itemFeedReplyBinding.moreSubReplyView.setOnClickListener(new MultiFeedReplyViewHolder$onPopulateSubReplyView$1(this, feedReply));
        } else {
            TextView textView3 = itemFeedReplyBinding.moreSubReplyView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.moreSubReplyView");
            textView3.setVisibility(8);
        }
        ImageView imageView = itemFeedReplyBinding.foldedSignView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.foldedSignView");
        if (feedReply.getBlockStatus() == 1) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isAdmin()) {
                i = 0;
                imageView.setVisibility(i);
                if (feedReply.getReplyRowsCount() <= 0) {
                    LinearLayout linearLayout = itemFeedReplyBinding.subReplyContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.subReplyContainer");
                    linearLayout.setVisibility(0);
                } else {
                    LinearLayout linearLayout2 = itemFeedReplyBinding.subReplyContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.subReplyContainer");
                    linearLayout2.setVisibility(8);
                }
                LinearAdapterLayout linearAdapterLayout = itemFeedReplyBinding.linearAdapterView;
                Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearAdapterView");
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                List<FeedReply> replyRows = feedReply.getReplyRows();
                Intrinsics.checkNotNullExpressionValue(replyRows, "reply.replyRows");
                linearAdapterLayout.setAdapter(new SubReplyAdapter(this, context, replyRows));
            }
        }
        i = 8;
        imageView.setVisibility(i);
        if (feedReply.getReplyRowsCount() <= 0) {
        }
        LinearAdapterLayout linearAdapterLayout = itemFeedReplyBinding.linearAdapterView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearAdapterView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        List<FeedReply> replyRows = feedReply.getReplyRows();
        Intrinsics.checkNotNullExpressionValue(replyRows, "reply.replyRows");
        linearAdapterLayout.setAdapter(new SubReplyAdapter(this, context, replyRows));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/MultiFeedReplyViewHolder$SubReplyAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/model/FeedReply;", "context", "Landroid/content/Context;", "list", "", "(Lcom/coolapk/market/viewholder/MultiFeedReplyViewHolder;Landroid/content/Context;Ljava/util/List;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MultiFeedReplyViewHolder.kt */
    public final class SubReplyAdapter extends ArrayAdapter<FeedReply> {
        final /* synthetic */ MultiFeedReplyViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SubReplyAdapter(MultiFeedReplyViewHolder multiFeedReplyViewHolder, Context context, List<? extends FeedReply> list) {
            super(context, 0, list);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "list");
            this.this$0 = multiFeedReplyViewHolder;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ItemFeedReplyTextBinding itemFeedReplyTextBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            if (view != null) {
                ViewDataBinding bind = DataBindingUtil.bind(view);
                Intrinsics.checkNotNull(bind);
                itemFeedReplyTextBinding = (ItemFeedReplyTextBinding) bind;
            } else {
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558727, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…eply_text, parent, false)");
                itemFeedReplyTextBinding = (ItemFeedReplyTextBinding) inflate;
            }
            TextView textView = itemFeedReplyTextBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "replyBinding.textView");
            Object item = getItem(i);
            Intrinsics.checkNotNull(item);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
            FeedReply feedReply = (FeedReply) item;
            TextViewBindingAdapters.setSubReplyText(textView, feedReply, this.this$0.getFeedReply().getUid());
            itemFeedReplyTextBinding.getRoot().setOnLongClickListener(new MultiFeedReplyViewHolder$SubReplyAdapter$getView$1(this, feedReply, textView));
            ViewUtil.clickListener(itemFeedReplyTextBinding.getRoot(), new MultiFeedReplyViewHolder$SubReplyAdapter$getView$2(this, feedReply));
            View root = itemFeedReplyTextBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "replyBinding.root");
            return root;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/MultiFeedReplyViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MultiFeedReplyViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
