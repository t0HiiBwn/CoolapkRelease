package com.coolapk.market.view.product;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.event.ProductEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.product.viewholder.ProductLocalData;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/product/ProductSeriesListFragment;", "Lcom/coolapk/market/view/product/SupportVerticalModeFragment;", "()V", "convertToBrandProductData", "", "Landroid/os/Parcelable;", "data", "Lcom/coolapk/market/model/Entity;", "verticalModel", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "", "onProductEvent", "event", "Lcom/coolapk/market/event/ProductEvent;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductSeriesListFragment.kt */
public final class ProductSeriesListFragment extends SupportVerticalModeFragment {
    public static final Companion Companion = new Companion(null);
    private static final String ENTITY_TYPE_GROUP_MORE = "productGroupMore";
    private static final String ENTITY_TYPE_GROUP_TITLE = "productGroupTitle";
    public static final String EXTRA_BRAND_ID = "extra_brand_id";
    public static final String EXTRA_BRAND_TYPE = "extra_brand_type";
    public static final String LOCAL_TYPE_HORIZON_PRODUCTS = "horizon_products";
    public static final String LOCAL_TYPE_SERIES_MORE = "series_more";
    public static final String LOCAL_TYPE_SERIES_TITLE = "series_title";
    public static final String LOCAL_TYPE_VERTICAL_PRODUCT = "vertical_product";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/product/ProductSeriesListFragment$Companion;", "", "()V", "ENTITY_TYPE_GROUP_MORE", "", "ENTITY_TYPE_GROUP_TITLE", "EXTRA_BRAND_ID", "EXTRA_BRAND_TYPE", "LOCAL_TYPE_HORIZON_PRODUCTS", "LOCAL_TYPE_SERIES_MORE", "LOCAL_TYPE_SERIES_TITLE", "LOCAL_TYPE_VERTICAL_PRODUCT", "newInstance", "Lcom/coolapk/market/view/product/ProductSeriesListFragment;", "brandID", "brandType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductSeriesListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductSeriesListFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "brandID");
            Intrinsics.checkNotNullParameter(str2, "brandType");
            ProductSeriesListFragment productSeriesListFragment = new ProductSeriesListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_brand_id", str);
            bundle.putString("extra_brand_type", str2);
            Unit unit = Unit.INSTANCE;
            productSeriesListFragment.setArguments(bundle);
            return productSeriesListFragment;
        }
    }

    @Override // com.coolapk.market.view.product.SupportVerticalModeFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof AlphaToolbarActivity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.AlphaToolbarActivity");
            int navigationBarHeight = ((AlphaToolbarActivity) activity).getNavigationBarHeight();
            boolean z = navigationBarHeight == 0;
            int dp = NumberExtendsKt.getDp((Number) 64);
            if (z) {
                navigationBarHeight = dp;
            }
            getRecyclerView().setPadding(0, 0, 0, navigationBarHeight);
        }
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new ProductSeriesListFragment$onActivityCreated$1());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558878).suitedMethod(ProductSeriesListFragment$onActivityCreated$2.INSTANCE).constructor(new ProductSeriesListFragment$onActivityCreated$3(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558877).suitedMethod(ProductSeriesListFragment$onActivityCreated$4.INSTANCE).constructor(new ProductSeriesListFragment$onActivityCreated$5(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558876).suitedMethod(ProductSeriesListFragment$onActivityCreated$6.INSTANCE).constructor(new ProductSeriesListFragment$onActivityCreated$7(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558875).suitedMethod(ProductSeriesListFragment$onActivityCreated$8.INSTANCE).constructor(new ProductSeriesListFragment$onActivityCreated$9(this)).build(), 0, 2, null);
    }

    @Subscribe
    public final void onProductEvent(ProductEvent productEvent) {
        Intrinsics.checkNotNullParameter(productEvent, "event");
        boolean z = false;
        int i = 0;
        for (T t : getLoadedDataList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2 instanceof Product) {
                T t3 = t2;
                if (productEvent.canMatchUpWith(t3)) {
                    getLoadedDataList().set(i, productEvent.patch(t3));
                    z = true;
                }
            }
            i = i2;
        }
        if (z) {
            requestLoadedDataListChanged();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String string = requireArguments().getString("extra_brand_type");
        String string2 = requireArguments().getString("extra_brand_id");
        DataManager instance = DataManager.getInstance();
        Entity entity = (Entity) CollectionsKt.firstOrNull((List<? extends Object>) getLoadedDataList());
        String entityId = entity != null ? entity.getEntityId() : null;
        Entity entity2 = (Entity) CollectionsKt.lastOrNull((List<? extends Object>) getLoadedDataList());
        Observable<R> compose = instance.getProductSeries(string2, string, i, entityId, entity2 != null ? entity2.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.product.SupportVerticalModeFragment
    public List<Parcelable> convertToBrandProductData(List<? extends Entity> list, boolean z) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(list, "data");
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (T t : list) {
                if (Intrinsics.areEqual(t.getEntityTemplate(), "productGroupTitle")) {
                    String title = t.getTitle();
                    if (title != null) {
                        str2 = title;
                    } else {
                        str2 = "";
                    }
                    arrayList.add(new ProductLocalData("series_title", str2, null, null, null, 28, null));
                } else if (Intrinsics.areEqual(t.getEntityTemplate(), "productGroupMore")) {
                    arrayList.add(new ProductLocalData("series_more", null, null, null, t, 14, null));
                } else if (t instanceof Product) {
                    arrayList.add(new ProductLocalData("vertical_product", null, t, null, null, 26, null));
                } else {
                    arrayList.add(t);
                }
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (T t2 : list) {
                if (t2 instanceof Product) {
                    arrayList2.add(t2);
                    if (arrayList2.size() == 3) {
                        Object[] array = arrayList2.toArray(new Product[0]);
                        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                        arrayList.add(new ProductLocalData("horizon_products", null, null, (Product[]) array, null, 22, null));
                        arrayList2.clear();
                    }
                } else if (Intrinsics.areEqual(t2.getEntityTemplate(), "productGroupMore")) {
                    Object[] array2 = arrayList2.toArray(new Product[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    arrayList.add(new ProductLocalData("horizon_products", null, null, (Product[]) array2, t2, 6, null));
                    arrayList2.clear();
                } else {
                    ArrayList arrayList3 = arrayList2;
                    if (!arrayList3.isEmpty()) {
                        Object[] array3 = arrayList3.toArray(new Product[0]);
                        Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
                        arrayList.add(new ProductLocalData("horizon_products", null, null, (Product[]) array3, null, 22, null));
                        arrayList2.clear();
                    }
                    if (Intrinsics.areEqual(t2.getEntityTemplate(), "productGroupTitle")) {
                        String title2 = t2.getTitle();
                        if (title2 != null) {
                            str = title2;
                        } else {
                            str = "";
                        }
                        arrayList.add(new ProductLocalData("series_title", str, null, null, null, 28, null));
                    } else {
                        arrayList.add(t2);
                    }
                }
            }
            ArrayList arrayList4 = arrayList2;
            if (!arrayList4.isEmpty()) {
                Object[] array4 = arrayList4.toArray(new Product[0]);
                Objects.requireNonNull(array4, "null cannot be cast to non-null type kotlin.Array<T>");
                arrayList.add(new ProductLocalData("horizon_products", null, null, (Product[]) array4, null, 22, null));
                arrayList2.clear();
            }
        }
        return arrayList;
    }
}
