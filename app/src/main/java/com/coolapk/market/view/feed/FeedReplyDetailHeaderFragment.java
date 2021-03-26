package com.coolapk.market.view.feed;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedReplyDetailHeaderBinding;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.feed.reply.FeedReplyCommentBarViewPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailHeaderFragment;", "Lcom/coolapk/market/view/feed/FeedReplyDetailFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/FeedReplyDetailHeaderBinding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/FeedReplyDetailHeaderBinding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/FeedReplyDetailHeaderBinding;)V", "commentBarViewPart", "Lcom/coolapk/market/view/feed/reply/FeedReplyCommentBarViewPart;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFeedReplyLoaded", "", "feedReply", "Lcom/coolapk/market/model/FeedReply;", "onRequestResponse", "", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "onViewCreated", "view", "setupCommentBar", "updateRecyclerViewBottomInset", "rect", "Landroid/graphics/Rect;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailHeaderFragment.kt */
public class FeedReplyDetailHeaderFragment extends FeedReplyDetailFragment {
    public static final Companion Companion = new Companion(null);
    public FeedReplyDetailHeaderBinding binding;
    private FeedReplyCommentBarViewPart commentBarViewPart;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailHeaderFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/FeedReplyDetailFragment;", "parentReply", "Lcom/coolapk/market/model/FeedReply;", "parentReplyId", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyDetailHeaderFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedReplyDetailFragment newInstance(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "parentReply");
            FeedReplyDetailHeaderFragment feedReplyDetailHeaderFragment = new FeedReplyDetailHeaderFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feedReply);
            Unit unit = Unit.INSTANCE;
            feedReplyDetailHeaderFragment.setArguments(bundle);
            return feedReplyDetailHeaderFragment;
        }

        public final FeedReplyDetailFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "parentReplyId");
            FeedReplyDetailHeaderFragment feedReplyDetailHeaderFragment = new FeedReplyDetailHeaderFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_feed_id", str);
            Unit unit = Unit.INSTANCE;
            feedReplyDetailHeaderFragment.setArguments(bundle);
            return feedReplyDetailHeaderFragment;
        }
    }

    public final FeedReplyDetailHeaderBinding getBinding$presentation_coolapkAppRelease() {
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding = this.binding;
        if (feedReplyDetailHeaderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return feedReplyDetailHeaderBinding;
    }

    public final void setBinding$presentation_coolapkAppRelease(FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding) {
        Intrinsics.checkNotNullParameter(feedReplyDetailHeaderBinding, "<set-?>");
        this.binding = feedReplyDetailHeaderBinding;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558561, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…header, container, false)");
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding = (FeedReplyDetailHeaderBinding) inflate;
        this.binding = feedReplyDetailHeaderBinding;
        if (feedReplyDetailHeaderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailHeaderBinding.linearView.addView(onCreateView);
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding2 = this.binding;
        if (feedReplyDetailHeaderBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return feedReplyDetailHeaderBinding2.getRoot();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Drawable drawable = ResourceUtils.getDrawable(getActivity(), 2131231200);
        drawable.mutate().setColorFilter(AppHolder.getAppTheme().getTextColorSecondary(), PorterDuff.Mode.SRC_IN);
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding = this.binding;
        if (feedReplyDetailHeaderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailHeaderBinding.toolbar.setTitleTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding2 = this.binding;
        if (feedReplyDetailHeaderBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = feedReplyDetailHeaderBinding2.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        toolbar.setNavigationIcon(drawable);
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding3 = this.binding;
        if (feedReplyDetailHeaderBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailHeaderBinding3.toolbar.setNavigationOnClickListener(new FeedReplyDetailHeaderFragment$onViewCreated$1(this));
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding4 = this.binding;
        if (feedReplyDetailHeaderBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailHeaderBinding4.actionView.setOnClickListener(new FeedReplyDetailHeaderFragment$onViewCreated$2(this));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), rect.bottom + NumberExtendsKt.getDp((Number) 52));
    }

    @Override // com.coolapk.market.view.feed.FeedReplyDetailFragment
    protected void onFeedReplyLoaded(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "feedReply");
        super.onFeedReplyLoaded(feedReply);
        setupCommentBar(feedReply);
        FeedReplyDetailHeaderBinding feedReplyDetailHeaderBinding = this.binding;
        if (feedReplyDetailHeaderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = feedReplyDetailHeaderBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        toolbar.setTitle(StringUtils.titleWithNum(getString(2131886791), feedReply.getReplyNum()));
    }

    public void setupCommentBar(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "feedReply");
        if (this.commentBarViewPart == null) {
            View view = getView();
            FrameLayout.LayoutParams layoutParams = null;
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                FeedReplyCommentBarViewPart newInstance = FeedReplyCommentBarViewPart.Companion.newInstance(feedReply, frameLayout);
                newInstance.setExternalListener(new FeedReplyDetailHeaderFragment$setupCommentBar$1(this, feedReply));
                View view2 = newInstance.getView();
                frameLayout.addView(view2);
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = layoutParams2;
                }
                FrameLayout.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.gravity = 80;
                    layoutParams3.width = -1;
                    layoutParams3.height = -2;
                }
                view2.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
                view2.setVisibility(0);
                view2.setTranslationY(NumberExtendsKt.getDpf((Number) 48));
                view2.animate().translationY(NumberExtendsKt.getDpf((Number) 0)).setDuration(500).start();
                ViewExtents2Kt.tryListenWindowsInset(view2, new FeedReplyDetailHeaderFragment$setupCommentBar$3(newInstance));
                Lifecycle lifecycle = getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
                LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedReplyDetailHeaderFragment$setupCommentBar$4(frameLayout, view2));
                this.commentBarViewPart = newInstance;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.feed.FeedReplyDetailFragment, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (z) {
            getRecyclerView().post(new FeedReplyDetailHeaderFragment$onRequestResponse$1(this));
        }
        return onRequestResponse;
    }
}
