package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedDetailViewV8Binding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.reply.FeedFollowableHeaderViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailViewHolderV8.kt */
final class FeedDetailViewHolderV8$headerViewPart$2 extends Lambda implements Function0<FeedFollowableHeaderViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedDetailViewHolderV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailViewHolderV8$headerViewPart$2(FeedDetailViewHolderV8 feedDetailViewHolderV8, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedDetailViewHolderV8;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedFollowableHeaderViewPart invoke() {
        FeedFollowableHeaderViewPart feedFollowableHeaderViewPart = new FeedFollowableHeaderViewPart(this.$component, this.this$0.getPresenter());
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        Space space = ((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).headerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.headerSpaceView");
        ViewParent parent = space.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        feedFollowableHeaderViewPart.createView(from, (ViewGroup) parent);
        ViewUtil.replaceView(((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).headerSpaceView, feedFollowableHeaderViewPart.getView());
        View view = feedFollowableHeaderViewPart.getView();
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), NumberExtendsKt.getDp((Number) 12));
        return feedFollowableHeaderViewPart;
    }
}
