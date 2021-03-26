package com.coolapk.market.view.product.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemProductSeriesHorizontalBinding;
import com.coolapk.market.event.ProductEventKt;
import com.coolapk.market.event.ProductEventRequester;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.view.FollowStyleTextView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesHorizonHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemProductSeriesHorizontalBinding;", "kotlin.jvm.PlatformType", "data", "Lcom/coolapk/market/view/product/viewholder/ProductLocalData;", "bindTo", "", "", "onClick", "view", "setFollowText", "subtitleView", "Landroid/widget/TextView;", "actionView", "isFollow", "", "hotNum", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductSeriesHorizonHolder.kt */
public final class ProductSeriesHorizonHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558882;
    private final ItemProductSeriesHorizontalBinding binding;
    private ProductLocalData data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductSeriesHorizonHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding = (ItemProductSeriesHorizontalBinding) getBinding();
        this.binding = itemProductSeriesHorizontalBinding;
        Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding, "binding");
        itemProductSeriesHorizontalBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesHorizonHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductSeriesHorizonHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        if (obj instanceof ProductLocalData) {
            ProductLocalData productLocalData = (ProductLocalData) obj;
            this.data = productLocalData;
            ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding = this.binding;
            Product[] products = productLocalData.getProducts();
            Product product = null;
            int i = 0;
            itemProductSeriesHorizontalBinding.setModel1(products != null ? (Product) ArraysKt.getOrNull(products, 0) : null);
            Product[] products2 = productLocalData.getProducts();
            boolean z = true;
            itemProductSeriesHorizontalBinding.setModel2(products2 != null ? (Product) ArraysKt.getOrNull(products2, 1) : null);
            Product[] products3 = productLocalData.getProducts();
            if (products3 != null) {
                product = (Product) ArraysKt.getOrNull(products3, 2);
            }
            itemProductSeriesHorizontalBinding.setModel3(product);
            ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding2 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding2, "binding");
            Product model1 = itemProductSeriesHorizontalBinding2.getModel1();
            if (model1 != null) {
                TextView textView = this.binding.subtitleView1;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.subtitleView1");
                FollowStyleTextView followStyleTextView = this.binding.actionButton1;
                Intrinsics.checkNotNullExpressionValue(followStyleTextView, "binding.actionButton1");
                FollowStyleTextView followStyleTextView2 = followStyleTextView;
                UserAction userAction = model1.getUserAction();
                Intrinsics.checkNotNullExpressionValue(userAction, "userAction");
                setFollowText(textView, followStyleTextView2, userAction.getFollow() == 1, model1.getHotNum());
            }
            ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding3 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding3, "binding");
            Product model2 = itemProductSeriesHorizontalBinding3.getModel2();
            if (model2 != null) {
                TextView textView2 = this.binding.subtitleView2;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.subtitleView2");
                FollowStyleTextView followStyleTextView3 = this.binding.actionButton2;
                Intrinsics.checkNotNullExpressionValue(followStyleTextView3, "binding.actionButton2");
                FollowStyleTextView followStyleTextView4 = followStyleTextView3;
                UserAction userAction2 = model2.getUserAction();
                Intrinsics.checkNotNullExpressionValue(userAction2, "userAction");
                setFollowText(textView2, followStyleTextView4, userAction2.getFollow() == 1, model2.getHotNum());
            }
            ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding4 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding4, "binding");
            Product model3 = itemProductSeriesHorizontalBinding4.getModel3();
            if (model3 != null) {
                TextView textView3 = this.binding.subtitleView3;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.subtitleView3");
                FollowStyleTextView followStyleTextView5 = this.binding.actionButton3;
                Intrinsics.checkNotNullExpressionValue(followStyleTextView5, "binding.actionButton3");
                FollowStyleTextView followStyleTextView6 = followStyleTextView5;
                UserAction userAction3 = model3.getUserAction();
                Intrinsics.checkNotNullExpressionValue(userAction3, "userAction");
                if (userAction3.getFollow() != 1) {
                    z = false;
                }
                setFollowText(textView3, followStyleTextView6, z, model3.getHotNum());
            }
            Entity moreCard = productLocalData.getMoreCard();
            LinearLayout linearLayout = this.binding.actionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionContainer");
            if (moreCard == null) {
                i = 8;
            }
            linearLayout.setVisibility(i);
            this.binding.executePendingBindings();
        }
    }

    /* access modifiers changed from: private */
    public final void setFollowText(TextView textView, TextView textView2, boolean z, int i) {
        textView.setText(KotlinExtendKt.toDisplayString(i) + "热度");
        textView2.setSelected(z);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        boolean z = false;
        switch (view.getId()) {
            case 2131361879:
                ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding, "binding");
                Product model1 = itemProductSeriesHorizontalBinding.getModel1();
                if (model1 != null) {
                    Intrinsics.checkNotNullExpressionValue(model1, "binding.model1 ?: return");
                    UserAction userAction = model1.getUserAction();
                    Intrinsics.checkNotNullExpressionValue(userAction, "product.userAction");
                    if (userAction.getFollow() == 1) {
                        z = true;
                    }
                    ProductEventRequester productEventRequester = ProductEventRequester.INSTANCE;
                    String id = model1.getId();
                    if (id != null) {
                        str = id;
                    } else {
                        str = "";
                    }
                    if (ProductEventRequester.requestFollow$default(productEventRequester, str, !z, new ProductSeriesHorizonHolder$onClick$accepted$1(this, model1), null, 8, null)) {
                        int handleOnStateChange = ProductEventKt.handleOnStateChange(model1.getFollowNum(), z);
                        TextView textView = this.binding.subtitleView1;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.subtitleView1");
                        FollowStyleTextView followStyleTextView = this.binding.actionButton1;
                        Intrinsics.checkNotNullExpressionValue(followStyleTextView, "binding.actionButton1");
                        setFollowText(textView, followStyleTextView, !z, handleOnStateChange);
                        return;
                    }
                    return;
                }
                return;
            case 2131361880:
                ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding2 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding2, "binding");
                Product model2 = itemProductSeriesHorizontalBinding2.getModel2();
                if (model2 != null) {
                    Intrinsics.checkNotNullExpressionValue(model2, "binding.model2 ?: return");
                    UserAction userAction2 = model2.getUserAction();
                    Intrinsics.checkNotNullExpressionValue(userAction2, "product.userAction");
                    if (userAction2.getFollow() == 1) {
                        z = true;
                    }
                    ProductEventRequester productEventRequester2 = ProductEventRequester.INSTANCE;
                    String id2 = model2.getId();
                    if (id2 != null) {
                        str2 = id2;
                    } else {
                        str2 = "";
                    }
                    if (ProductEventRequester.requestFollow$default(productEventRequester2, str2, !z, new ProductSeriesHorizonHolder$onClick$accepted$2(this, model2), null, 8, null)) {
                        int handleOnStateChange2 = ProductEventKt.handleOnStateChange(model2.getFollowNum(), z);
                        TextView textView2 = this.binding.subtitleView2;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subtitleView2");
                        FollowStyleTextView followStyleTextView2 = this.binding.actionButton2;
                        Intrinsics.checkNotNullExpressionValue(followStyleTextView2, "binding.actionButton2");
                        setFollowText(textView2, followStyleTextView2, !z, handleOnStateChange2);
                        return;
                    }
                    return;
                }
                return;
            case 2131361881:
                ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding3 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding3, "binding");
                Product model3 = itemProductSeriesHorizontalBinding3.getModel3();
                if (model3 != null) {
                    Intrinsics.checkNotNullExpressionValue(model3, "binding.model3 ?: return");
                    UserAction userAction3 = model3.getUserAction();
                    Intrinsics.checkNotNullExpressionValue(userAction3, "product.userAction");
                    if (userAction3.getFollow() == 1) {
                        z = true;
                    }
                    ProductEventRequester productEventRequester3 = ProductEventRequester.INSTANCE;
                    String id3 = model3.getId();
                    if (id3 != null) {
                        str3 = id3;
                    } else {
                        str3 = "";
                    }
                    if (ProductEventRequester.requestFollow$default(productEventRequester3, str3, !z, new ProductSeriesHorizonHolder$onClick$accepted$3(this, model3), null, 8, null)) {
                        int handleOnStateChange3 = ProductEventKt.handleOnStateChange(model3.getFollowNum(), z);
                        TextView textView3 = this.binding.subtitleView3;
                        Intrinsics.checkNotNullExpressionValue(textView3, "binding.subtitleView3");
                        FollowStyleTextView followStyleTextView3 = this.binding.actionButton3;
                        Intrinsics.checkNotNullExpressionValue(followStyleTextView3, "binding.actionButton3");
                        setFollowText(textView3, followStyleTextView3, !z, handleOnStateChange3);
                        return;
                    }
                    return;
                }
                return;
            case 2131361982:
                ProductLocalData productLocalData = this.data;
                if (productLocalData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                Entity moreCard = productLocalData.getMoreCard();
                if (moreCard != null) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl(context, moreCard.getUrl(), moreCard.getTitle(), moreCard.getSubTitle());
                    return;
                }
                return;
            case 2131362780:
                ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding4 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding4, "binding");
                Product model12 = itemProductSeriesHorizontalBinding4.getModel1();
                if (model12 != null) {
                    Intrinsics.checkNotNullExpressionValue(model12, "binding.model1 ?: return");
                    ActionManager.startProductActivity(getContext(), model12.getId());
                    return;
                }
                return;
            case 2131362784:
                ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding5 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding5, "binding");
                Product model22 = itemProductSeriesHorizontalBinding5.getModel2();
                if (model22 != null) {
                    Intrinsics.checkNotNullExpressionValue(model22, "binding.model2 ?: return");
                    ActionManager.startProductActivity(getContext(), model22.getId());
                    return;
                }
                return;
            case 2131362785:
                ItemProductSeriesHorizontalBinding itemProductSeriesHorizontalBinding6 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesHorizontalBinding6, "binding");
                Product model32 = itemProductSeriesHorizontalBinding6.getModel3();
                if (model32 != null) {
                    Intrinsics.checkNotNullExpressionValue(model32, "binding.model3 ?: return");
                    ActionManager.startProductActivity(getContext(), model32.getId());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
