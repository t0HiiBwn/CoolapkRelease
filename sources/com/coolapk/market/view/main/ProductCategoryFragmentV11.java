package com.coolapk.market.view.main;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.databinding.LoadingViewBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.product.BaseLeftCategoryFragment;
import com.coolapk.market.view.product.ProductCategoryDataListFragment;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/main/ProductCategoryFragmentV11;", "Lcom/coolapk/market/view/product/BaseLeftCategoryFragment;", "()V", "isSupportDisplayInVerticalMode", "", "()Z", "loadData", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/coolapk/market/model/Entity;", "onSaveInstanceState", "outState", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCategoryFragmentV11.kt */
public final class ProductCategoryFragmentV11 extends BaseLeftCategoryFragment {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment
    public boolean isSupportDisplayInVerticalMode() {
        return false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/ProductCategoryFragmentV11$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/main/ProductCategoryFragmentV11;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCategoryFragmentV11.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductCategoryFragmentV11 newInstance() {
            ProductCategoryFragmentV11 productCategoryFragmentV11 = new ProductCategoryFragmentV11();
            productCategoryFragmentV11.setArguments(BaseLeftCategoryFragment.Companion.createBundle$default(BaseLeftCategoryFragment.Companion, CollectionsKt.emptyList(), 0, 2, null));
            return productCategoryFragmentV11;
        }
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment
    public Fragment onCreateFragment(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        if (entity instanceof ProductBrand) {
            ProductCategoryDataListFragment.Companion companion = ProductCategoryDataListFragment.Companion;
            ProductBrand productBrand = (ProductBrand) entity;
            String url = productBrand.getUrl();
            String str = "";
            if (url == null) {
                url = str;
            }
            String title = productBrand.getTitle();
            if (title == null) {
                title = str;
            }
            String subTitle = productBrand.getSubTitle();
            if (subTitle != null) {
                str = subTitle;
            }
            return companion.newInstance(url, title, str);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList parcelableArrayList;
        if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("DATA_LIST")) == null)) {
            getDataList().addAll(parcelableArrayList);
        }
        super.onActivityCreated(bundle);
        loadData();
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (!getDataList().isEmpty()) {
            bundle.putParcelableArrayList("DATA_LIST", getDataList());
        }
    }

    /* access modifiers changed from: private */
    public final void loadData() {
        if (getDataList().isEmpty()) {
            PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = getBinding().recyclerView;
            Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView, "binding.recyclerView");
            preventAutoScrollRecyclerView.setVisibility(8);
            LoadingViewBinding loadingViewBinding = getBinding().loadingView;
            Intrinsics.checkNotNullExpressionValue(loadingViewBinding, "binding.loadingView");
            BindingExtensionKt.setLoadingStart(loadingViewBinding);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getProductCategoryList().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new ProductCategoryFragmentV11$loadData$1(this));
            return;
        }
        LoadingViewBinding loadingViewBinding2 = getBinding().loadingView;
        Intrinsics.checkNotNullExpressionValue(loadingViewBinding2, "binding.loadingView");
        BindingExtensionKt.setLoadingFinished(loadingViewBinding2);
    }
}
