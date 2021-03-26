package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedGoodsInfoBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\nH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedGoodsInfoBinding;", "Lcom/coolapk/market/viewholder/GoodsSimpleInfo;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsInfoViewPart.kt */
public final class FeedGoodsInfoViewPart extends BindingViewPart<ItemFeedGoodsInfoBinding, GoodsSimpleInfo> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558705;
    private final DataBindingComponent component;

    public FeedGoodsInfoViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGoodsInfoViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedGoodsInfoBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558705, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedGoodsInfoBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(GoodsSimpleInfo goodsSimpleInfo) {
        Intrinsics.checkNotNullParameter(goodsSimpleInfo, "data");
        super.onBindToContent((FeedGoodsInfoViewPart) goodsSimpleInfo);
        ItemFeedGoodsInfoBinding itemFeedGoodsInfoBinding = (ItemFeedGoodsInfoBinding) getBinding();
        itemFeedGoodsInfoBinding.setModel(goodsSimpleInfo);
        itemFeedGoodsInfoBinding.setSubTitle(goodsSimpleInfo.getCategory());
        itemFeedGoodsInfoBinding.executePendingBindings();
        TextView textView = itemFeedGoodsInfoBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        ViewExtendsKt.applyText(textView, new FeedGoodsInfoViewPart$onBindToContent$1(goodsSimpleInfo));
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemFeedGoodsInfoBinding) getBinding()).setClick(this);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        GoodsSimpleInfo model = ((ItemFeedGoodsInfoBinding) getBinding()).getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            int id = view.getId();
            if (id == 2131361981) {
                ActionManagerCompat.startActivityByUrl$default(getContext(), model.getSellUrl(), null, null, 12, null);
            } else if (id == 2131362768) {
                ActionManagerCompat.startActivityByUrl$default(getContext(), model.getExtraUrl(), null, null, 12, null);
            }
        }
    }
}
