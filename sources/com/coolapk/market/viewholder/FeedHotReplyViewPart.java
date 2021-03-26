package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemHotFeedReplyViewPartBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.cardlist.EntityDataHelper;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.HotReplyTagShape;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0017B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0014J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/FeedHotReplyViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemHotFeedReplyViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedHotReplyViewPart.kt */
public final class FeedHotReplyViewPart extends BindingViewPart<ItemHotFeedReplyViewPartBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558781;
    private final DataBindingComponent component;
    private Feed feed;

    public FeedHotReplyViewPart() {
        this(null, 1, null);
    }

    public FeedHotReplyViewPart(DataBindingComponent dataBindingComponent) {
        this.component = dataBindingComponent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedHotReplyViewPart(DataBindingComponent dataBindingComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataBindingComponent);
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/FeedHotReplyViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedHotReplyViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "data");
            List<FeedReply> replyRows = feed.getReplyRows();
            return (replyRows != null ? (FeedReply) CollectionsKt.lastOrNull(replyRows) : null) != null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemHotFeedReplyViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558781, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemHotFeedReplyViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemHotFeedReplyViewPartBinding) getBinding()).getRoot().setOnClickListener(this);
        TextView textView = ((ItemHotFeedReplyViewPartBinding) getBinding()).newTagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.newTagView");
        textView.setBackground(new ShapeDrawable(new HotReplyTagShape(0, 0, 3, null)));
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        EntityDataHelper.BaseAssistData baseAssistData;
        EntityListFragment entityListFragment;
        EntityDataHelper entityDataHelper$presentation_coolapkAppRelease;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedHotReplyViewPart) feed2);
        this.feed = feed2;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        List<FeedReply> replyRows = feed2.getReplyRows();
        EntityDataHelper.FeedAssistData feedAssistData = null;
        FeedReply feedReply = replyRows != null ? (FeedReply) CollectionsKt.firstOrNull((List<? extends Object>) replyRows) : null;
        int i = 8;
        if (feedReply == null) {
            View root = ((ItemHotFeedReplyViewPartBinding) getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setVisibility(8);
            return;
        }
        TextView textView = ((ItemHotFeedReplyViewPartBinding) getBinding()).newTagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.newTagView");
        textView.setText(feedReply.getExtraFlag());
        TextView textView2 = ((ItemHotFeedReplyViewPartBinding) getBinding()).newTagView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.newTagView");
        String extraFlag = feedReply.getExtraFlag();
        if (!(extraFlag == null || extraFlag.length() == 0)) {
            i = 0;
        }
        textView2.setVisibility(i);
        DataBindingComponent dataBindingComponent = this.component;
        if (dataBindingComponent == null || (entityListFragment = KotlinExtendKt.getEntityListFragment(dataBindingComponent)) == null || (entityDataHelper$presentation_coolapkAppRelease = entityListFragment.getEntityDataHelper$presentation_coolapkAppRelease()) == null) {
            baseAssistData = null;
        } else {
            Feed feed3 = this.feed;
            if (feed3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            baseAssistData = entityDataHelper$presentation_coolapkAppRelease.obtainAssistData(feed3);
        }
        if (baseAssistData instanceof EntityDataHelper.FeedAssistData) {
            feedAssistData = baseAssistData;
        }
        EntityDataHelper.FeedAssistData feedAssistData2 = feedAssistData;
        if (feedAssistData2 != null) {
            CoolEllipsizeTextView coolEllipsizeTextView = ((ItemHotFeedReplyViewPartBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
            coolEllipsizeTextView.setText(feedAssistData2.getReplyText());
            CoolEllipsizeTextView coolEllipsizeTextView2 = ((ItemHotFeedReplyViewPartBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.titleView");
            ViewExtendsKt.makeSpanClickable(coolEllipsizeTextView2);
        } else {
            TextViewBindingAdapters.setReplyText(((ItemHotFeedReplyViewPartBinding) getBinding()).titleView, feedReply);
        }
        CoolEllipsizeTextView coolEllipsizeTextView3 = ((ItemHotFeedReplyViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.titleView");
        coolEllipsizeTextView3.setMaxLines(3);
        View root2 = ((ItemHotFeedReplyViewPartBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        root2.setVisibility(0);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (Intrinsics.areEqual(view, ((ItemHotFeedReplyViewPartBinding) getBinding()).getRoot())) {
            Context context = getContext();
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            ActionManager.startFeedDetailActivity(context, feed2, null, 1);
        }
    }
}
