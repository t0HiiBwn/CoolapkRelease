package com.coolapk.market.view.product;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.view.product.ProductCategoryDataListFragment;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/product/ProductCategoryListFragment;", "Lcom/coolapk/market/view/product/BaseLeftCategoryFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/coolapk/market/model/Entity;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCategoryListFragment.kt */
public final class ProductCategoryListFragment extends BaseLeftCategoryFragment {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/product/ProductCategoryListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/product/ProductCategoryListFragment;", "list", "", "Lcom/coolapk/market/model/ProductBrand;", "initIndex", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCategoryListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductCategoryListFragment newInstance(List<? extends ProductBrand> list, int i) {
            Intrinsics.checkNotNullParameter(list, "list");
            ProductCategoryListFragment productCategoryListFragment = new ProductCategoryListFragment();
            productCategoryListFragment.setArguments(BaseLeftCategoryFragment.Companion.createBundle(list, i));
            return productCategoryListFragment;
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
        super.onActivityCreated(bundle);
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView, "binding.recyclerView");
        ViewExtents2Kt.tryListenWindowsInset(preventAutoScrollRecyclerView, new ProductCategoryListFragment$onActivityCreated$1(this));
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        MenuItem add = menu.add(0, 2131361960, 100, 2131886390);
        add.setIcon(2131231534);
        add.setShowAsAction(2);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361960) {
            return super.onOptionsItemSelected(menuItem);
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActionManagerCompat.startActivityByUrl$default(requireActivity, "searchSpot://product?title=数码吧", null, null, 12, null);
        return true;
    }
}
