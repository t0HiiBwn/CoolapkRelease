package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPartKt;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.iview.ViewPart;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedExtraEntityViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "frameLayout", "Landroid/widget/FrameLayout;", "goodsInfoViewPart", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "getGoodsInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "goodsInfoViewPart$delegate", "Lkotlin/Lazy;", "bindTo", "", "data", "Lcom/coolapk/market/model/Feed;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedExtraEntityViewPart.kt */
public final class FeedExtraEntityViewPart extends ViewPart implements Recyclable {
    private final DataBindingComponent component;
    private FrameLayout frameLayout;
    private final Lazy goodsInfoViewPart$delegate = LazyKt.lazy(new FeedExtraEntityViewPart$goodsInfoViewPart$2(this));

    private final FeedGoodsInfoViewPart getGoodsInfoViewPart() {
        return (FeedGoodsInfoViewPart) this.goodsInfoViewPart$delegate.getValue();
    }

    public FeedExtraEntityViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public static final /* synthetic */ FrameLayout access$getFrameLayout$p(FeedExtraEntityViewPart feedExtraEntityViewPart) {
        FrameLayout frameLayout2 = feedExtraEntityViewPart.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        return frameLayout2;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FrameLayout frameLayout2 = new FrameLayout(layoutInflater.getContext());
        this.frameLayout = frameLayout2;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        return frameLayout2;
    }

    public final void bindTo(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        List<Entity> extraEntities = feed.getExtraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "data.extraEntities");
        Entity entity = (Entity) CollectionsKt.firstOrNull((List<? extends Object>) extraEntities);
        TextView textView = null;
        if (entity instanceof FeedGoods) {
            getGoodsInfoViewPart().bindToContent(FeedGoodsInfoViewPartKt.toGoodsSimpleInfo((FeedGoods) entity));
            textView = getGoodsInfoViewPart().getView();
        } else if (entity != null) {
            FrameLayout frameLayout2 = this.frameLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            TextView textView2 = new TextView(frameLayout2.getContext());
            textView2.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            textView2.setTextSize(16.0f);
            textView2.setText("暂不支持，请升级后再试");
            textView2.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16));
            textView = textView2;
        }
        FrameLayout frameLayout3 = this.frameLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        frameLayout3.removeAllViews();
        if (textView != null) {
            FrameLayout frameLayout4 = this.frameLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            frameLayout4.addView(textView);
            FrameLayout frameLayout5 = this.frameLayout;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            frameLayout5.setVisibility(0);
            return;
        }
        FrameLayout frameLayout6 = this.frameLayout;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        frameLayout6.setVisibility(8);
    }
}
