package com.coolapk.market.view.feed.reply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.FeedCommentBarBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001 B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\tH\u0014R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyCommentBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/FeedCommentBarBinding;", "Lcom/coolapk/market/model/FeedReply;", "Landroid/view/View$OnClickListener;", "()V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "feedReply", "getFeedReply", "()Lcom/coolapk/market/model/FeedReply;", "setFeedReply", "(Lcom/coolapk/market/model/FeedReply;)V", "insetBottom", "paddingBottom", "", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyCommentBarViewPart.kt */
public final class FeedReplyCommentBarViewPart extends BindingViewPart<FeedCommentBarBinding, FeedReply> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Function1<? super View, Unit> externalListener;
    private FeedReply feedReply;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyCommentBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/FeedReplyCommentBarViewPart;", "feedReply", "Lcom/coolapk/market/model/FeedReply;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyCommentBarViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedReplyCommentBarViewPart newInstance(FeedReply feedReply, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(feedReply, "feedReply");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            FeedReplyCommentBarViewPart feedReplyCommentBarViewPart = new FeedReplyCommentBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            feedReplyCommentBarViewPart.createView(from, viewGroup);
            feedReplyCommentBarViewPart.bindToContent(feedReply);
            return feedReplyCommentBarViewPart;
        }
    }

    public final FeedReply getFeedReply() {
        return this.feedReply;
    }

    public final void setFeedReply(FeedReply feedReply2) {
        this.feedReply = feedReply2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit>, kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> */
    public final Function1<View, Unit> getExternalListener() {
        return this.externalListener;
    }

    public final void setExternalListener(Function1<? super View, Unit> function1) {
        this.externalListener = function1;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public FeedCommentBarBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558558, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…nt_bar, viewGroup, false)");
        return (FeedCommentBarBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((FeedCommentBarBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
        FrameLayout frameLayout = ((FeedCommentBarBinding) getBinding()).likeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.likeView");
        ViewExtendsKt.disableAccessibilityClick(frameLayout);
    }

    public final void insetBottom(int i) {
        ((FeedCommentBarBinding) getBinding()).rootView.setPadding(0, 0, 0, i);
        ((FeedCommentBarBinding) getBinding()).rootView.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(FeedReply feedReply2) {
        Intrinsics.checkNotNullParameter(feedReply2, "data");
        super.onBindToContent((FeedReplyCommentBarViewPart) feedReply2);
        if (!Intrinsics.areEqual(this.feedReply, feedReply2)) {
            FrameLayout frameLayout = ((FeedCommentBarBinding) getBinding()).commentView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentView");
            frameLayout.setVisibility(8);
            FrameLayout frameLayout2 = ((FeedCommentBarBinding) getBinding()).likeView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.likeView");
            frameLayout2.setVisibility(8);
            FrameLayout frameLayout3 = ((FeedCommentBarBinding) getBinding()).shareView;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.shareView");
            frameLayout3.setVisibility(8);
            FrameLayout frameLayout4 = ((FeedCommentBarBinding) getBinding()).starView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.starView");
            frameLayout4.setVisibility(8);
            this.feedReply = feedReply2;
            ((FeedCommentBarBinding) getBinding()).setClick(this);
            ((FeedCommentBarBinding) getBinding()).executePendingBindings();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        Function1<? super View, Unit> function1 = this.externalListener;
        if (function1 != null) {
            function1.invoke(view);
        }
    }
}
