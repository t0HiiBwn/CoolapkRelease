package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedLayoutV8Binding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.viewholder.FeedExtraTypeViewPart;
import com.coolapk.market.widget.hotplug.ViewPartHotPlug;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¨\u0006\r"}, d2 = {"com/coolapk/market/viewholder/v8/FeedViewHolderV8$extraTypeHotPlug$1", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "Lcom/coolapk/market/model/Feed;", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "shouldShowView", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedViewHolderV8.kt */
public final class FeedViewHolderV8$extraTypeHotPlug$1 extends ViewPartHotPlug<FeedExtraTypeViewPart, Feed> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedViewHolderV8 this$0;

    /* access modifiers changed from: protected */
    public void onViewPartLoad(FeedExtraTypeViewPart feedExtraTypeViewPart) {
        Intrinsics.checkNotNullParameter(feedExtraTypeViewPart, "viewPart");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedViewHolderV8$extraTypeHotPlug$1(FeedViewHolderV8 feedViewHolderV8, DataBindingComponent dataBindingComponent, int i, ViewPartPool viewPartPool) {
        super(i, viewPartPool, false, 4, null);
        this.this$0 = feedViewHolderV8;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowView(Feed feed) {
        String mediaInfo;
        Intrinsics.checkNotNullParameter(feed, "data");
        List<Entity> extraEntities = feed.getExtraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "data.extraEntities");
        if (!extraEntities.isEmpty()) {
            return false;
        }
        String extraTitle = feed.getExtraTitle();
        if (extraTitle == null || extraTitle.length() == 0) {
            return false;
        }
        if ((Intrinsics.areEqual(feed.getExtraType(), "apk") && !AppHolder.getAppMetadata().isCommunityMode()) || (mediaInfo = feed.getMediaInfo()) == null || mediaInfo.length() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(FeedExtraTypeViewPart feedExtraTypeViewPart) {
        Intrinsics.checkNotNullParameter(feedExtraTypeViewPart, "viewPart");
        ((ItemFeedLayoutV8Binding) this.this$0.getBinding()).extraApkTypeContainer.removeAllViews();
        ((ItemFeedLayoutV8Binding) this.this$0.getBinding()).extraTypeContainer.removeAllViews();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public FeedExtraTypeViewPart createViewPart() {
        FeedExtraTypeViewPart feedExtraTypeViewPart = new FeedExtraTypeViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        feedExtraTypeViewPart.createView(from, ((ItemFeedLayoutV8Binding) this.this$0.getBinding()).cardView);
        return feedExtraTypeViewPart;
    }

    /* access modifiers changed from: protected */
    public void bindData(FeedExtraTypeViewPart feedExtraTypeViewPart, Feed feed) {
        Intrinsics.checkNotNullParameter(feedExtraTypeViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(feed, "data");
        if (Intrinsics.areEqual(FeedViewHolderV8.access$getFeed$p(this.this$0).getExtraType(), "apk")) {
            if (!Intrinsics.areEqual(((ItemFeedLayoutV8Binding) this.this$0.getBinding()).extraApkTypeContainer.getChildAt(0), feedExtraTypeViewPart.getView())) {
                ViewExtendsKt.detachFromParent(feedExtraTypeViewPart.getView());
                ((ItemFeedLayoutV8Binding) this.this$0.getBinding()).extraApkTypeContainer.addView(feedExtraTypeViewPart.getView());
            }
        } else if (!Intrinsics.areEqual(((ItemFeedLayoutV8Binding) this.this$0.getBinding()).extraTypeContainer.getChildAt(0), feedExtraTypeViewPart.getView())) {
            ViewExtendsKt.detachFromParent(feedExtraTypeViewPart.getView());
            ((ItemFeedLayoutV8Binding) this.this$0.getBinding()).extraTypeContainer.addView(feedExtraTypeViewPart.getView());
        }
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(feedExtraTypeViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = ConvertUtils.dp2px(12.0f);
            marginParams.leftMargin = ResourceUtils.getDimen(this.this$0.getContext(), 2131165382);
            marginParams.rightMargin = ResourceUtils.getDimen(this.this$0.getContext(), 2131165382);
            marginParams.bottomMargin = 0;
        }
        feedExtraTypeViewPart.bindToContent(FeedViewHolderV8.access$getFeed$p(this.this$0));
    }
}
