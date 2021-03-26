package com.coolapk.market.view.sencondhand;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0014J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001aH\u0014R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductBrandListActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "brandList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/ProductBrand;", "dataType", "", "dealType", "product", "Lcom/coolapk/market/model/Product;", "getProduct", "()Lcom/coolapk/market/model/Product;", "setProduct", "(Lcom/coolapk/market/model/Product;)V", "subscription", "Lrx/Subscription;", "loadProductList", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onDestroy", "onEmptyViewClick", "onSaveInstanceState", "outState", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandProductBrandListActivity.kt */
public final class SecondHandProductBrandListActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_BRAND_LIST = "extra_brand_list";
    public static final String EXTRA_DATA_DEAL_TYPE = "extra_data_deal_type";
    public static final String EXTRA_DATA_TYPE = "extra_data_type";
    public static final int REQUEST_CODE = 2323;
    public static final int TYPE_DATA_ERSHOU = 2;
    public static final int TYPE_DATA_FILTER = 3;
    private ArrayList<ProductBrand> brandList;
    private int dataType;
    private int dealType;
    private Product product;
    private Subscription subscription;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductBrandListActivity$Companion;", "", "()V", "EXTRA_BRAND_LIST", "", "EXTRA_DATA_DEAL_TYPE", "EXTRA_DATA_TYPE", "REQUEST_CODE", "", "TYPE_DATA_ERSHOU", "TYPE_DATA_FILTER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandProductBrandListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Product getProduct() {
        return this.product;
    }

    public final void setProduct(Product product2) {
        this.product = product2;
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.brandList = bundle.getParcelableArrayList("extra_brand_list");
            this.dealType = bundle.getInt("extra_data_deal_type");
        }
        this.dataType = getIntent().getIntExtra("extra_data_type", 2);
        this.dealType = getIntent().getIntExtra("extra_data_deal_type", 0);
        super.onCreate(bundle);
        setToolbarTitle("品牌分类");
        if (this.brandList == null) {
            loadProductList();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ArrayList<ProductBrand> arrayList = this.brandList;
        if (arrayList != null) {
            bundle.putParcelableArrayList("extra_brand_list", arrayList);
            bundle.putInt("extra_data_deal_type", this.dealType);
        }
    }

    private final void loadProductList() {
        if (!isLoading()) {
            setLoadingStart();
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            this.subscription = instance.getSecondHandProductBrandList().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new SecondHandProductBrandListActivity$loadProductList$1(this));
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public void onEmptyViewClick() {
        loadProductList();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = null;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 5555) {
            Intent intent2 = new Intent();
            intent2.putParcelableArrayListExtra("paramsList", intent.getParcelableArrayListExtra("paramsList"));
            intent2.putExtra("json", intent.getStringExtra("json"));
            intent2.putExtra("product", this.product);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        ArrayList<ProductBrand> arrayList = this.brandList;
        if (arrayList == null || !(!arrayList.isEmpty())) {
            return null;
        }
        return SecondHandProductBrandListFragment.Companion.newInstance(arrayList, this.dataType, this.dealType);
    }
}
