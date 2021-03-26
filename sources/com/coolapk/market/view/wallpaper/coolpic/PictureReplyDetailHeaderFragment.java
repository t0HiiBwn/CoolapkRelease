package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.DropDownListener;
import com.coolapk.market.util.RecyclerViewDropDownListener;
import com.coolapk.market.view.feed.FeedReplyDetailFragment;
import com.coolapk.market.view.feed.FeedReplyDetailHeaderFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment;", "Lcom/coolapk/market/view/feed/FeedReplyDetailHeaderFragment;", "()V", "isAnimating", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestViewReplyDetail", "reply", "Lcom/coolapk/market/model/FeedReply;", "removeThisFragmentFromParent", "requestExitCommentView", "requestRestoreCommentView", "Companion", "PictureFeedReplyViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureReplyDetailHeaderFragment.kt */
public final class PictureReplyDetailHeaderFragment extends FeedReplyDetailHeaderFragment {
    public static final Companion Companion = new Companion(null);
    private boolean isAnimating;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/FeedReplyDetailFragment;", "parentReply", "Lcom/coolapk/market/model/FeedReply;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PictureReplyDetailHeaderFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedReplyDetailFragment newInstance(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "parentReply");
            PictureReplyDetailHeaderFragment pictureReplyDetailHeaderFragment = new PictureReplyDetailHeaderFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feedReply);
            Unit unit = Unit.INSTANCE;
            pictureReplyDetailHeaderFragment.setArguments(bundle);
            return pictureReplyDetailHeaderFragment;
        }
    }

    @Override // com.coolapk.market.view.feed.FeedReplyDetailFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBinding$presentation_coolapkAppRelease().getRoot().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        PictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1 pictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1 = new PictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1(this);
        getBinding$presentation_coolapkAppRelease().toolbar.setNavigationOnClickListener(new PictureReplyDetailHeaderFragment$onActivityCreated$1(this));
        Toolbar toolbar = getBinding$presentation_coolapkAppRelease().toolbar;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1 pictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$12 = pictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1;
        toolbar.setOnTouchListener(new DropDownListener(requireActivity, pictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$12));
        RecyclerView recyclerView = getRecyclerView();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        recyclerView.addOnItemTouchListener(new RecyclerViewDropDownListener(requireActivity2, pictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$12));
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558723).suitedEntityType("feed_reply").constructor(new PictureReplyDetailHeaderFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        View view = new View(getActivity());
        view.setBackgroundColor(AppHolder.getAppTheme().getCurrencyColorDivider());
        getBinding$presentation_coolapkAppRelease().frameView.addView(view, new FrameLayout.LayoutParams(-1, NumberExtendsKt.getDp(Double.valueOf(0.5d))));
    }

    public final void requestExitCommentView() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            View root = getBinding$presentation_coolapkAppRelease().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            float translationY = root.getTranslationY();
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new PictureReplyDetailHeaderFragment$requestExitCommentView$$inlined$apply$lambda$1(this, translationY));
            ExtraExtendsKt.addListeners$default(valueAnimator, null, new PictureReplyDetailHeaderFragment$requestExitCommentView$$inlined$apply$lambda$2(this, translationY), 1, null);
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void removeThisFragmentFromParent() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentManager supportFragmentManager = requireActivity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    /* access modifiers changed from: private */
    public final void requestRestoreCommentView() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            View root = getBinding$presentation_coolapkAppRelease().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            float translationY = root.getTranslationY();
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new PictureReplyDetailHeaderFragment$requestRestoreCommentView$$inlined$apply$lambda$1(this, translationY));
            ExtraExtendsKt.addListeners$default(valueAnimator, null, new PictureReplyDetailHeaderFragment$requestRestoreCommentView$$inlined$apply$lambda$2(this, translationY), 1, null);
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void onRequestViewReplyDetail(FeedReply feedReply) {
        if (!this.isAnimating) {
            View view = getView();
            FrameLayout frameLayout = null;
            ViewParent parent = view != null ? view.getParent() : null;
            if (parent instanceof FrameLayout) {
                frameLayout = parent;
            }
            FrameLayout frameLayout2 = frameLayout;
            if (frameLayout2 != null) {
                FeedReplyDetailFragment newInstance = Companion.newInstance(feedReply);
                newInstance.setUserVisibleHint(false);
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance, getTag()).commitAllowingStateLoss();
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager().executePendingTransactions();
                FrameLayout frameLayout3 = frameLayout2;
                frameLayout3.getViewTreeObserver().addOnPreDrawListener(new PictureReplyDetailHeaderFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1(frameLayout3, this, newInstance));
                this.isAnimating = true;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment$PictureFeedReplyViewHolder;", "Lcom/coolapk/market/view/feed/FeedReplyDetailFragment$FeedReplyDetailViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "rid", "", "(Lcom/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Ljava/lang/String;)V", "onPopulateSubReplyView", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PictureReplyDetailHeaderFragment.kt */
    public final class PictureFeedReplyViewHolder extends FeedReplyDetailFragment.FeedReplyDetailViewHolder {
        final /* synthetic */ PictureReplyDetailHeaderFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PictureFeedReplyViewHolder(PictureReplyDetailHeaderFragment pictureReplyDetailHeaderFragment, View view, DataBindingComponent dataBindingComponent, String str) {
            super(view, dataBindingComponent, str);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.this$0 = pictureReplyDetailHeaderFragment;
        }

        @Override // com.coolapk.market.viewholder.FeedReplyViewHolder
        protected void onPopulateSubReplyView(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "reply");
            super.onPopulateSubReplyView(feedReply);
            ((ItemFeedReplyBinding) getBinding()).moreSubReplyView.setOnClickListener(new PictureReplyDetailHeaderFragment$PictureFeedReplyViewHolder$onPopulateSubReplyView$1(this, feedReply));
        }
    }
}
