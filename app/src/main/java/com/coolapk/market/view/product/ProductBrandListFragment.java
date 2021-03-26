package com.coolapk.market.view.product;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.view.product.BaseLeftCategoryFragment;
import com.coolapk.market.view.product.ProductSeriesListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/product/ProductBrandListFragment;", "Lcom/coolapk/market/view/product/BaseLeftCategoryFragment;", "()V", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/coolapk/market/model/Entity;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductBrandListFragment.kt */
public final class ProductBrandListFragment extends BaseLeftCategoryFragment {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/product/ProductBrandListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/product/ProductBrandListFragment;", "list", "", "Lcom/coolapk/market/model/ProductBrand;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductBrandListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductBrandListFragment newInstance(List<? extends ProductBrand> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ProductBrandListFragment productBrandListFragment = new ProductBrandListFragment();
            productBrandListFragment.setArguments(BaseLeftCategoryFragment.Companion.createBundle$default(BaseLeftCategoryFragment.Companion, list, 0, 2, null));
            return productBrandListFragment;
        }
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment
    public Fragment onCreateFragment(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        if (entity instanceof ProductBrand) {
            ProductSeriesListFragment.Companion companion = ProductSeriesListFragment.Companion;
            ProductBrand productBrand = (ProductBrand) entity;
            String id = productBrand.getId();
            String str = "";
            if (id == null) {
                id = str;
            }
            String type = productBrand.getType();
            if (type != null) {
                str = type;
            }
            return companion.newInstance(id, str);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
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
