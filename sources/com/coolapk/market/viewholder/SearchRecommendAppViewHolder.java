package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.ServiceApp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/viewholder/SearchRecommendAppViewHolder;", "Lcom/coolapk/market/viewholder/ServiceAppViewHolder;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ServiceAppBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ServiceAppBinding;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchRecommendAppViewHolder.kt */
public final class SearchRecommendAppViewHolder extends ServiceAppViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558924;
    private final ServiceAppBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchRecommendAppViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        ServiceAppBinding serviceAppBinding = (ServiceAppBinding) getBinding();
        this.binding = serviceAppBinding;
        TextView textView = serviceAppBinding.marketInfoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.marketInfoView");
        textView.setVisibility(8);
        LinearLayout linearLayout = serviceAppBinding.headerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.headerView");
        linearLayout.setGravity(16);
        ImageView imageView = serviceAppBinding.iconView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
        imageView.getLayoutParams().height = NumberExtendsKt.getDp((Number) 36);
        ImageView imageView2 = serviceAppBinding.iconView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.iconView");
        imageView2.getLayoutParams().width = NumberExtendsKt.getDp((Number) 36);
        TextView textView2 = serviceAppBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setTextSize(14.0f);
        TextView textView3 = serviceAppBinding.apkInfoView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.apkInfoView");
        textView3.setTextSize(12.0f);
        TextView textView4 = serviceAppBinding.newTagView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.newTagView");
        textView4.setTextSize(12.0f);
        TextView textView5 = serviceAppBinding.extraTextView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.extraTextView");
        textView5.setTextSize(12.0f);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchRecommendAppViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchRecommendAppViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final ServiceAppBinding getBinding() {
        return this.binding;
    }

    @Override // com.coolapk.market.viewholder.ServiceAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        super.bindTo(obj);
        ServiceApp serviceApp = (ServiceApp) obj;
        TextView textView = this.binding.apkInfoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.apkInfoView");
        textView.setText(serviceApp.getApkSizeFormat() + "  " + serviceApp.getDownCount() + "下载");
        TextView textView2 = this.binding.introductionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.introductionView");
        textView2.setVisibility(8);
    }
}
