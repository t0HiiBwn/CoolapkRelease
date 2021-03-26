package com.coolapk.market.view.product.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemProductSeriesBinding;
import com.coolapk.market.databinding.ItemProductSeriesChildBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductConfig;
import com.coolapk.market.view.product.ProductViewModel;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductSeriesBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/product/ProductViewModel;)V", "titleViewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "getViewModel", "()Lcom/coolapk/market/view/product/ProductViewModel;", "bindToContent", "", "data", "Companion", "ConfigAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductSeriesHolder.kt */
public final class ProductSeriesHolder extends GenericBindHolder<ItemProductSeriesBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558879;
    private final TitleViewPart titleViewPart;
    private final ProductViewModel viewModel;

    public final ProductViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductSeriesHolder(View view, DataBindingComponent dataBindingComponent, ProductViewModel productViewModel) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        this.viewModel = productViewModel;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        LinearLayout linearLayout = ((ItemProductSeriesBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        this.titleViewPart = companion.newInstance(linearLayout, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductSeriesHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        Product model = this.viewModel.getModel();
        this.titleViewPart.bindToContent(entity);
        String priceCurrency = model.getPriceCurrency();
        if (priceCurrency == null) {
            priceCurrency = "￥";
        }
        Intrinsics.checkNotNullExpressionValue(priceCurrency, "product.priceCurrency ?: \"￥\"");
        LinearAdapterLayout linearAdapterLayout = ((ItemProductSeriesBinding) getBinding()).linearAdapterView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearAdapterView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        List<ProductConfig> configRows = model.getConfigRows();
        Intrinsics.checkNotNullExpressionValue(configRows, "product.configRows");
        linearAdapterLayout.setAdapter(new ConfigAdapter(context, configRows, priceCurrency));
        ((ItemProductSeriesBinding) getBinding()).executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\f\u0010\u0013\u001a\u00020\b*\u00020\u0014H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesHolder$ConfigAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/model/ProductConfig;", "context", "Landroid/content/Context;", "list", "", "priceCurrency", "", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V", "getPriceCurrency", "()Ljava/lang/String;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "toPriceString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductSeriesHolder.kt */
    public static final class ConfigAdapter extends ArrayAdapter<ProductConfig> {
        private final String priceCurrency;

        public final String getPriceCurrency() {
            return this.priceCurrency;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConfigAdapter(Context context, List<? extends ProductConfig> list, String str) {
            super(context, 0, list);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(str, "priceCurrency");
            this.priceCurrency = str;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ItemProductSeriesChildBinding itemProductSeriesChildBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            if (view != null) {
                ViewDataBinding bind = DataBindingUtil.bind(view);
                Intrinsics.checkNotNull(bind);
                itemProductSeriesChildBinding = (ItemProductSeriesChildBinding) bind;
            } else {
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558880, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ies_child, parent, false)");
                itemProductSeriesChildBinding = (ItemProductSeriesChildBinding) inflate;
            }
            Object item = getItem(i);
            Intrinsics.checkNotNull(item);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
            ProductConfig productConfig = (ProductConfig) item;
            TextView textView = itemProductSeriesChildBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "childBinding.titleView");
            textView.setText(productConfig.getTitle());
            if (productConfig.getPrice() <= ((float) 0)) {
                TextView textView2 = itemProductSeriesChildBinding.subtitleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "childBinding.subtitleView");
                textView2.setVisibility(8);
            } else {
                TextView textView3 = itemProductSeriesChildBinding.subtitleView;
                Intrinsics.checkNotNullExpressionValue(textView3, "childBinding.subtitleView");
                textView3.setVisibility(0);
                TextView textView4 = itemProductSeriesChildBinding.subtitleView;
                Intrinsics.checkNotNullExpressionValue(textView4, "childBinding.subtitleView");
                textView4.setText(this.priceCurrency + toPriceString(productConfig.getPrice()));
            }
            View root = itemProductSeriesChildBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "childBinding.root");
            ViewExtendsKt.setUtilClickListener(root, new ProductSeriesHolder$ConfigAdapter$getView$1(this, productConfig));
            itemProductSeriesChildBinding.executePendingBindings();
            View root2 = itemProductSeriesChildBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "childBinding.root");
            return root2;
        }

        private final String toPriceString(float f) {
            String valueOf = String.valueOf(f);
            if (!StringsKt.endsWith$default(valueOf, ".0", false, 2, (Object) null)) {
                return valueOf;
            }
            Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String substring = valueOf.substring(0, valueOf.length() - 2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
    }
}
