package com.coolapk.market.view.goods.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000fH\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDataListFragment;", "Lcom/coolapk/market/view/main/DataListFragment;", "()V", "viewModel", "Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "getViewModel", "()Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDataListFragment.kt */
public final class GoodsDataListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy viewModel$delegate = LazyKt.lazy(new GoodsDataListFragment$viewModel$2(this));

    public final GoodsDetailViewModel getViewModel() {
        return (GoodsDetailViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDataListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/goods/detail/GoodsDataListFragment;", "action", "", "title", "subTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsDataListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GoodsDataListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        public final GoodsDataListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "action");
            GoodsDataListFragment goodsDataListFragment = new GoodsDataListFragment();
            goodsDataListFragment.setArguments(DataListFragment.Companion.createArguments$default(DataListFragment.Companion, str, str2, str3, 0, 8, null));
            return goodsDataListFragment;
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        Drawable drawable = null;
        recyclerView.setBackground(drawable);
        View view = getView();
        if (view != null) {
            view.setBackground(drawable);
        }
        View loadingView = getLoadingView();
        Objects.requireNonNull(loadingView, "null cannot be cast to non-null type android.widget.ProgressBar");
        TintHelper.setTint((ProgressBar) loadingView, -1);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558709).suitedMethod(GoodsDataListFragment$onActivityCreated$1.INSTANCE).doAfterBind(GoodsDataListFragment$onActivityCreated$2.INSTANCE).constructor(new GoodsDataListFragment$onActivityCreated$3(this)).build(), -1);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Integer entityFixed;
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof EntityCard) || (entityFixed = ((EntityCard) obj).getEntityFixed()) == null || entityFixed.intValue() != 1) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return 0;
    }
}
