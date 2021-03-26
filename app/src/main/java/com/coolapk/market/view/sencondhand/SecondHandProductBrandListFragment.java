package com.coolapk.market.view.sencondhand;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.view.product.BaseLeftCategoryFragment;
import com.coolapk.market.view.sencondhand.SecondHandProductSeriesListFragment;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductBrandListFragment;", "Lcom/coolapk/market/view/product/BaseLeftCategoryFragment;", "()V", "dataType", "", "getDataType", "()I", "dataType$delegate", "Lkotlin/Lazy;", "dealType", "getDealType", "dealType$delegate", "isSupportDisplayInVerticalMode", "", "()Z", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/coolapk/market/model/Entity;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandProductBrandListFragment.kt */
public final class SecondHandProductBrandListFragment extends BaseLeftCategoryFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_KEY_DATA_TYPE = "extra_key_data_type";
    private static final String EXTRA_KEY_DEAL_TYPE = "extra_key_deal_type";
    private final Lazy dataType$delegate = LazyKt.lazy(new SecondHandProductBrandListFragment$dataType$2(this));
    private final Lazy dealType$delegate = LazyKt.lazy(new SecondHandProductBrandListFragment$dealType$2(this));

    private final int getDataType() {
        return ((Number) this.dataType$delegate.getValue()).intValue();
    }

    private final int getDealType() {
        return ((Number) this.dealType$delegate.getValue()).intValue();
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment
    public boolean isSupportDisplayInVerticalMode() {
        return false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductBrandListFragment$Companion;", "", "()V", "EXTRA_KEY_DATA_TYPE", "", "EXTRA_KEY_DEAL_TYPE", "newInstance", "Lcom/coolapk/market/view/sencondhand/SecondHandProductBrandListFragment;", "list", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/ProductBrand;", "Lkotlin/collections/ArrayList;", "dataType", "", "dealType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandProductBrandListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SecondHandProductBrandListFragment newInstance(ArrayList<ProductBrand> arrayList, int i, int i2) {
            Intrinsics.checkNotNullParameter(arrayList, "list");
            SecondHandProductBrandListFragment secondHandProductBrandListFragment = new SecondHandProductBrandListFragment();
            Bundle createBundle$default = BaseLeftCategoryFragment.Companion.createBundle$default(BaseLeftCategoryFragment.Companion, arrayList, 0, 2, null);
            createBundle$default.putInt("extra_key_data_type", i);
            createBundle$default.putInt("extra_key_deal_type", i2);
            Unit unit = Unit.INSTANCE;
            secondHandProductBrandListFragment.setArguments(createBundle$default);
            return secondHandProductBrandListFragment;
        }
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof SecondHandProductBrandListActivity) {
            PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = getBinding().recyclerView;
            Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView, "binding.recyclerView");
            preventAutoScrollRecyclerView.setClipChildren(false);
            PreventAutoScrollRecyclerView preventAutoScrollRecyclerView2 = getBinding().recyclerView;
            Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView2, "binding.recyclerView");
            preventAutoScrollRecyclerView2.setClipToPadding(false);
            PreventAutoScrollRecyclerView preventAutoScrollRecyclerView3 = getBinding().recyclerView;
            Intrinsics.checkNotNullExpressionValue(preventAutoScrollRecyclerView3, "binding.recyclerView");
            ViewExtents2Kt.tryListenWindowsInset(preventAutoScrollRecyclerView3, new SecondHandProductBrandListFragment$onActivityCreated$1(this));
        }
    }

    @Override // com.coolapk.market.view.product.BaseLeftCategoryFragment
    public Fragment onCreateFragment(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        if (entity instanceof ProductBrand) {
            SecondHandProductSeriesListFragment.Companion companion = SecondHandProductSeriesListFragment.Companion;
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
            return companion.newInstance(id, str, getDataType(), getDealType());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
