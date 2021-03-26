package com.coolapk.market.view.product;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\fH\u0014R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/product/ProductCategoryListActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "brandList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/ProductBrand;", "subscription", "Lrx/Subscription;", "loadProductList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onDestroy", "onEmptyViewClick", "onSaveInstanceState", "outState", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCategoryListActivity.kt */
public final class ProductCategoryListActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_BRAND_LIST = "extra_brand_list";
    public static final String KEY_SELECTED_ID = "extra_selected_id";
    private ArrayList<ProductBrand> brandList;
    private Subscription subscription;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/product/ProductCategoryListActivity$Companion;", "", "()V", "EXTRA_BRAND_LIST", "", "KEY_SELECTED_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCategoryListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.brandList = bundle.getParcelableArrayList("extra_brand_list");
        }
        super.onCreate(bundle);
        setToolbarTitle("数码分类");
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
        }
    }

    private final void loadProductList() {
        if (!isLoading()) {
            setLoadingStart();
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            this.subscription = instance.getProductCategoryList().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new ProductCategoryListActivity$loadProductList$1(this));
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

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        ArrayList<ProductBrand> arrayList = this.brandList;
        if (arrayList == null || !(!arrayList.isEmpty())) {
            return null;
        }
        String stringExtra = getIntent().getStringExtra("extra_selected_id");
        ArrayList<ProductBrand> arrayList2 = arrayList;
        int i = 0;
        Iterator<ProductBrand> it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it2.next().getId(), stringExtra)) {
                break;
            } else {
                i++;
            }
        }
        return ProductCategoryListFragment.Companion.newInstance(arrayList2, i);
    }
}
