package com.coolapk.market.view.node.prodcut;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemProductCouponBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.ProductCoupon;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "adapter", "Lcom/coolapk/market/view/node/prodcut/ProductCouponViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/ItemProductCouponBinding;", "kotlin.jvm.PlatformType", "productCoupon", "Lcom/coolapk/market/model/ProductCoupon;", "bindTo", "", "data", "", "onClick", "view", "showDevices", "show", "", "anim", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCouponViewHolder.kt */
public final class ProductCouponViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558871;
    private final DataAdapter adapter;
    private final ItemProductCouponBinding binding;
    private ProductCoupon productCoupon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductCouponViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        ItemProductCouponBinding itemProductCouponBinding = (ItemProductCouponBinding) getBinding();
        this.binding = itemProductCouponBinding;
        TextView textView = itemProductCouponBinding.rmbView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.rmbView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
        TextView textView2 = itemProductCouponBinding.moneyView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.moneyView");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView2.setTypeface(ProductGlobalData.getNumberTypeface(context2));
        ProductCouponViewHolder productCouponViewHolder = this;
        itemProductCouponBinding.itemLeftView.setOnClickListener(productCouponViewHolder);
        itemProductCouponBinding.itemRightView.setOnClickListener(productCouponViewHolder);
        DataAdapter dataAdapter = new DataAdapter();
        BaseMultiTypeAdapter.register$default(dataAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558872).suitedMethod(ProductCouponViewHolder$1$1.INSTANCE).constructor(ProductCouponViewHolder$1$2.INSTANCE).build(), 0, 2, null);
        Unit unit = Unit.INSTANCE;
        this.adapter = dataAdapter;
        RecyclerView recyclerView = itemProductCouponBinding.deviceListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.deviceListView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = itemProductCouponBinding.deviceListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.deviceListView");
        recyclerView2.setAdapter(dataAdapter);
        boolean isDarkTheme = AppHolder.getAppTheme().isDarkTheme();
        itemProductCouponBinding.itemView.setBackgroundResource(isDarkTheme ? 2131230857 : 2131230856);
        itemProductCouponBinding.actionDivider.setColor(Color.parseColor(isDarkTheme ? "#595959" : "#D9D9D9"));
        itemProductCouponBinding.deviceDivider.setImageDrawable(new ColorDrawable(Color.parseColor(isDarkTheme ? "#404040" : "#E6E6E6")));
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        RecyclerViewDivider build = companion.with(context3).asSpace().size(NumberExtendsKt.getDp((Number) 8)).build();
        RecyclerView recyclerView3 = itemProductCouponBinding.deviceListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.deviceListView");
        build.addTo(recyclerView3);
        TextView textView3 = itemProductCouponBinding.priceView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.priceView");
        TextPaint paint = textView3.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "binding.priceView.paint");
        paint.setFlags(16);
        TextView textView4 = itemProductCouponBinding.priceView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.priceView");
        TextPaint paint2 = textView4.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint2, "binding.priceView.paint");
        paint2.setAntiAlias(true);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCouponViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void showDevices(boolean z, boolean z2) {
        if (z2) {
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            ViewParent parent = linearLayout.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setDuration(150L);
            Unit unit = Unit.INSTANCE;
            TransitionManager.beginDelayedTransition((ViewGroup) parent, autoTransition);
        }
        ImageView imageView = this.binding.deviceDivider;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.deviceDivider");
        int i = 0;
        imageView.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = this.binding.deviceListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.deviceListView");
        if (!z) {
            i = 8;
        }
        recyclerView.setVisibility(i);
        ImageView imageView2 = this.binding.deviceArrow;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.deviceArrow");
        imageView2.setRotation(z ? 180.0f : 0.0f);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.ProductCoupon");
        this.productCoupon = (ProductCoupon) obj;
        ItemProductCouponBinding itemProductCouponBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemProductCouponBinding, "binding");
        ProductCoupon productCoupon2 = this.productCoupon;
        if (productCoupon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCoupon");
        }
        itemProductCouponBinding.setCoupon(productCoupon2);
        this.binding.executePendingBindings();
        DataAdapter dataAdapter = this.adapter;
        ProductCoupon productCoupon3 = this.productCoupon;
        if (productCoupon3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCoupon");
        }
        dataAdapter.setList(productCoupon3.getProductRows());
        this.adapter.notifyDataSetChanged();
        ProductCoupon productCoupon4 = this.productCoupon;
        if (productCoupon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCoupon");
        }
        String useCouponPrice = productCoupon4.getUseCouponPrice();
        if (useCouponPrice == null || !StringsKt.endsWith$default(useCouponPrice, "起", false, 2, (Object) null)) {
            TextView textView = this.binding.useCouponPriceView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.useCouponPriceView");
            ProductCoupon productCoupon5 = this.productCoupon;
            if (productCoupon5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productCoupon");
            }
            textView.setText(productCoupon5.getUseCouponPrice());
            return;
        }
        ProductCoupon productCoupon6 = this.productCoupon;
        if (productCoupon6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCoupon");
        }
        SpannableString spannableString = new SpannableString(productCoupon6.getUseCouponPrice());
        spannableString.setSpan(new RelativeSizeSpan(0.6f), spannableString.length() - 1, spannableString.length(), 33);
        TextView textView2 = this.binding.useCouponPriceView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.useCouponPriceView");
        textView2.setText(spannableString);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362767) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProductCoupon productCoupon2 = this.productCoupon;
        if (productCoupon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCoupon");
        }
        ActionManagerCompat.startActivityByUrl$default(context, productCoupon2.getOpenUrl(), null, null, 12, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponViewHolder$DataAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "(Lcom/coolapk/market/view/node/prodcut/ProductCouponViewHolder;)V", "list", "", "", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCouponViewHolder.kt */
    private final class DataAdapter extends BaseMultiTypeAdapter {
        private List<String> list;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        public final List<String> getList() {
            return this.list;
        }

        public final void setList(List<String> list2) {
            this.list = list2;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            List<String> list2 = this.list;
            Intrinsics.checkNotNull(list2);
            return list2.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list2 = this.list;
            if (list2 != null) {
                return list2.size();
            }
            return 0;
        }
    }
}
