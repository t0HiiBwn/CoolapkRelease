package com.coolapk.market.view.node.prodcut;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.ProductCoupon;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000  2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0014R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X.¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/ProductCoupon;", "()V", "adapter", "Lcom/coolapk/market/view/node/prodcut/ProductCouponListFragment$DataAdapter;", "couponList", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "getCouponList", "()Ljava/util/ArrayList;", "couponList$delegate", "Lkotlin/Lazy;", "shouldShowDevice", "Landroid/util/SparseBooleanArray;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "", "page", "", "onRequestFailure", "error", "", "onRequestResponse", "result", "shouldShowList", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCouponListFragment.kt */
public final class ProductCouponListFragment extends NewAsyncListFragment<List<? extends ProductCoupon>> {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_COUPON_LIST = "COUPON_LIST";
    private DataAdapter adapter;
    private final Lazy couponList$delegate = LazyKt.lazy(new ProductCouponListFragment$couponList$2(this));
    private final SparseBooleanArray shouldShowDevice = new SparseBooleanArray();

    /* access modifiers changed from: private */
    public final ArrayList<ProductCoupon> getCouponList() {
        return (ArrayList) this.couponList$delegate.getValue();
    }

    @JvmStatic
    public static final ProductCouponListFragment newInstance(List<? extends ProductCoupon> list) {
        return Companion.newInstance(list);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponListFragment$Companion;", "", "()V", "KEY_COUPON_LIST", "", "newInstance", "Lcom/coolapk/market/view/node/prodcut/ProductCouponListFragment;", "couponList", "", "Lcom/coolapk/market/model/ProductCoupon;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCouponListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ProductCouponListFragment newInstance(List<? extends ProductCoupon> list) {
            Intrinsics.checkNotNullParameter(list, "couponList");
            ProductCouponListFragment productCouponListFragment = new ProductCouponListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("COUPON_LIST", new ArrayList<>(list));
            Unit unit = Unit.INSTANCE;
            productCouponListFragment.setArguments(bundle);
            return productCouponListFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<ProductCoupon>> onCreateRequest(boolean z, int i) {
        Observable<List<ProductCoupon>> just = Observable.just(getCouponList());
        if (!(just instanceof Observable)) {
            just = null;
        }
        Intrinsics.checkNotNull(just);
        return just;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.adapter = new DataAdapter();
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(dataAdapter);
        DataAdapter dataAdapter2 = this.adapter;
        if (dataAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(dataAdapter2, SimpleViewHolderFactor.Companion.withLayoutId(2131558871).suitedMethod(ProductCouponListFragment$onActivityCreated$1.INSTANCE).constructor(new ProductCouponListFragment$onActivityCreated$2(this)).doAfterBind(new ProductCouponListFragment$onActivityCreated$3(this)).build(), 0, 2, null);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView3);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165322);
        getRecyclerView().setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        RecyclerViewDivider build = companion.with(requireActivity).asSpace().size(NumberExtendsKt.getDp((Number) 8)).build();
        RecyclerView recyclerView4 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
        build.addTo(recyclerView4);
        View emptyView = getEmptyView();
        Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
        emptyView.setTranslationY(NumberExtendsKt.getDpf((Number) -142));
        View loadingView = getLoadingView();
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        loadingView.setTranslationY(NumberExtendsKt.getDpf((Number) -142));
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends ProductCoupon> list) {
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        dataAdapter.notifyDataSetChanged();
        updateContentUI();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getCouponList().size() > 0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductCouponListFragment$DataAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "(Lcom/coolapk/market/view/node/prodcut/ProductCouponListFragment;)V", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductCouponListFragment.kt */
    private final class DataAdapter extends BaseMultiTypeAdapter {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            Object obj = ProductCouponListFragment.this.getCouponList().get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "couponList[position]");
            return obj;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProductCouponListFragment.this.getCouponList().size();
        }
    }
}
