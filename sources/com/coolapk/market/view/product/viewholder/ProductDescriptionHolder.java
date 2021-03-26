package com.coolapk.market.view.product.viewholder;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemProductDescriptionBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.view.product.ProductViewModel;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.TitleViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductDescriptionHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductDescriptionBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/product/ProductViewModel;)V", "titleViewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "getViewModel", "()Lcom/coolapk/market/view/product/ProductViewModel;", "bindToContent", "", "data", "createTagsIntoContainer", "tag", "", "onTagClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductDescriptionHolder.kt */
public final class ProductDescriptionHolder extends GenericBindHolder<ItemProductDescriptionBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558866;
    private final TitleViewPart titleViewPart;
    private final ProductViewModel viewModel;

    /* access modifiers changed from: private */
    public final void onTagClick(View view, String str) {
    }

    public final ProductViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductDescriptionHolder(View view, DataBindingComponent dataBindingComponent, ProductViewModel productViewModel) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        this.viewModel = productViewModel;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        LinearLayout linearLayout = ((ItemProductDescriptionBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        this.titleViewPart = companion.newInstance(linearLayout, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductDescriptionHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductDescriptionHolder.kt */
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
        TextView textView = ((ItemProductDescriptionBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
        textView.setText(model.getDescription());
        ((ItemProductDescriptionBinding) getBinding()).executePendingBindings();
    }

    private final void createTagsIntoContainer(String str) {
        int dp = NumberExtendsKt.getDp((Number) 6);
        int contentBackgroundDividerColor = AppHolder.getAppTheme().getContentBackgroundDividerColor();
        TextView textView = new TextView(getContext());
        TextView textView2 = textView;
        ViewExtendsKt.clipView(textView2, 0, (float) NumberExtendsKt.getDp((Number) 2));
        textView.setPadding(dp, dp, dp, dp);
        textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        textView.setBackground(ShapeUtils.createSelectableItemBackgroundWith(textView.getContext(), new ColorDrawable(contentBackgroundDividerColor)));
        textView.setOnClickListener(new ProductDescriptionHolder$createTagsIntoContainer$$inlined$apply$lambda$1(textView, this, dp, contentBackgroundDividerColor, str));
        textView.setIncludeFontPadding(false);
        textView.setTextSize(12.0f);
        textView.setText(str);
        ((ItemProductDescriptionBinding) getBinding()).tagsContainer.addView(textView2, -2, -2);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(textView2);
        if (marginParams != null) {
            marginParams.rightMargin = NumberExtendsKt.getDp((Number) 6);
        }
    }
}
