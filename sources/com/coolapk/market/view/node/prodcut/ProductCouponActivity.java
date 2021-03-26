package com.coolapk.market.view.node.prodcut;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ProductCouponActivityBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductCoupon;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.node.prodcut.ProductCouponListFragment;
import com.coolapk.market.widget.view.SlideUpView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/ProductCouponActivityBinding;", "isBottomSheetRoundBackground", "", "product", "Lcom/coolapk/market/model/Product;", "getProduct", "()Lcom/coolapk/market/model/Product;", "product$delegate", "Lkotlin/Lazy;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "setBottomSheetRoundBackground", "isRound", "setupUi", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCouponActivity.kt */
public final class ProductCouponActivity extends BaseActivity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_PRODUCT = "PRODUCT";
    private ProductCouponActivityBinding binding;
    private boolean isBottomSheetRoundBackground;
    private final Lazy product$delegate = LazyKt.lazy(new ProductCouponActivity$product$2(this));

    private final Product getProduct() {
        return (Product) this.product$delegate.getValue();
    }

    @JvmStatic
    public static final void startActivity(Context context, Product product) {
        Companion.startActivity(context, product);
    }

    public static final /* synthetic */ ProductCouponActivityBinding access$getBinding$p(ProductCouponActivity productCouponActivity) {
        ProductCouponActivityBinding productCouponActivityBinding = productCouponActivity.binding;
        if (productCouponActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return productCouponActivityBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponActivity$Companion;", "", "()V", "KEY_PRODUCT", "", "startActivity", "", "context", "Landroid/content/Context;", "product", "Lcom/coolapk/market/model/Product;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCouponActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startActivity(Context context, Product product) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(product, "product");
            Intent intent = new Intent(context, ProductCouponActivity.class);
            intent.putExtra("PRODUCT", product);
            intent.addFlags(65536);
            context.startActivity(intent);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        super.onSetStatusBarColor();
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559108);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte….product_coupon_activity)");
        this.binding = (ProductCouponActivityBinding) contentView;
        setupUi();
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            ProductCouponListFragment.Companion companion = ProductCouponListFragment.Companion;
            Product product = getProduct();
            Intrinsics.checkNotNullExpressionValue(product, "product");
            List<ProductCoupon> couponList = product.getCouponList();
            Intrinsics.checkNotNull(couponList);
            Intrinsics.checkNotNullExpressionValue(couponList, "product.couponList!!");
            beginTransaction.add(2131362306, companion.newInstance(couponList)).commit();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ProductCouponActivityBinding productCouponActivityBinding = this.binding;
        if (productCouponActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        productCouponActivityBinding.bottomSheet.dismissView();
    }

    /* access modifiers changed from: private */
    public final void setBottomSheetRoundBackground(boolean z) {
        if (this.isBottomSheetRoundBackground != z) {
            this.isBottomSheetRoundBackground = z;
            if (z) {
                ProductCouponActivityBinding productCouponActivityBinding = this.binding;
                if (productCouponActivityBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                SlideUpView slideUpView = productCouponActivityBinding.bottomSheet;
                Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.bottomSheet");
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setGradientType(0);
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
                float dpf = NumberExtendsKt.getDpf((Number) 8);
                gradientDrawable.setCornerRadii(new float[]{dpf, dpf, dpf, dpf, 0.0f, 0.0f, 0.0f, 0.0f});
                Unit unit = Unit.INSTANCE;
                slideUpView.setBackground(gradientDrawable);
                return;
            }
            ProductCouponActivityBinding productCouponActivityBinding2 = this.binding;
            if (productCouponActivityBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SlideUpView slideUpView2 = productCouponActivityBinding2.bottomSheet;
            Intrinsics.checkNotNullExpressionValue(slideUpView2, "binding.bottomSheet");
            slideUpView2.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()));
        }
    }

    private final void setupUi() {
        ProductCouponActivityBinding productCouponActivityBinding = this.binding;
        if (productCouponActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = productCouponActivityBinding.bottomSheet;
        slideUpView.setInitTranslationY(NumberExtendsKt.getDpf((Number) 240));
        setBottomSheetRoundBackground(true);
        slideUpView.setCallback(new ProductCouponActivity$setupUi$$inlined$apply$lambda$1(this));
        ProductCouponActivityBinding productCouponActivityBinding2 = this.binding;
        if (productCouponActivityBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        productCouponActivityBinding2.mainContent.setOnClickListener(new ProductCouponActivity$setupUi$2(this));
        ProductCouponActivityBinding productCouponActivityBinding3 = this.binding;
        if (productCouponActivityBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        productCouponActivityBinding3.closeView.setOnClickListener(new ProductCouponActivity$setupUi$3(this));
    }
}
