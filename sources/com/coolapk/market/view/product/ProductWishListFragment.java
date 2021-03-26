package com.coolapk.market.view.product;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.User;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/product/ProductWishListFragment;", "Lcom/coolapk/market/view/product/SimpleUserListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/User;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductWishListFragment.kt */
public final class ProductWishListFragment extends SimpleUserListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ID = "extra_id";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/product/ProductWishListFragment$Companion;", "", "()V", "EXTRA_ID", "", "newInstance", "Lcom/coolapk/market/view/product/ProductWishListFragment;", "id", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductWishListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductWishListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            ProductWishListFragment productWishListFragment = new ProductWishListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_id", str);
            Unit unit = Unit.INSTANCE;
            productWishListFragment.setArguments(bundle);
            return productWishListFragment;
        }
    }

    @Override // com.coolapk.market.view.product.SimpleUserListFragment, com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<User>> onCreateRequest(boolean z, int i) {
        String string = requireArguments().getString("extra_id");
        DataManager instance = DataManager.getInstance();
        User user = (User) CollectionsKt.firstOrNull((List<? extends Object>) getDataList());
        String str = null;
        String uid = user != null ? user.getUid() : null;
        User user2 = (User) CollectionsKt.lastOrNull((List<? extends Object>) getDataList());
        if (user2 != null) {
            str = user2.getUid();
        }
        Observable<R> compose = instance.getProductWishList(string, i, uid, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }
}
