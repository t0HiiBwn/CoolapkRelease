package com.coolapk.market.view.goods;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DataItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0011H\u0014J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J \u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\b\u0010!\u001a\u00020\u0013H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsSearchMainListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "historyDataSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "historyLines", "Ljava/util/concurrent/atomic/AtomicInteger;", "showAllHistory", "Ljava/util/concurrent/atomic/AtomicBoolean;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "loadHistory", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onDestroy", "onRequestResponse", "data", "updateItemSearchHistory", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsSearchMainListFragment.kt */
public final class GoodsSearchMainListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String ENTITY_TYPE_HOT_WORDS = "HOT_WORDS";
    private static final int ITEM_TYPE_SEARCH_HISTORY = 1;
    private final ArrayList<String> historyDataSet = new ArrayList<>();
    private AtomicInteger historyLines = new AtomicInteger(1);
    private AtomicBoolean showAllHistory = new AtomicBoolean(false);

    @JvmStatic
    public static final GoodsSearchMainListFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsSearchMainListFragment$Companion;", "", "()V", "ENTITY_TYPE_HOT_WORDS", "", "ITEM_TYPE_SEARCH_HISTORY", "", "newInstance", "Lcom/coolapk/market/view/goods/GoodsSearchMainListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsSearchMainListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GoodsSearchMainListFragment newInstance() {
            return new GoodsSearchMainListFragment();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(null, 0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131559132).suitedMethod(GoodsSearchMainListFragment$onActivityCreated$1.INSTANCE).constructor(new GoodsSearchMainListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131559133).suitedMethod(GoodsSearchMainListFragment$onActivityCreated$3.INSTANCE).constructor(new GoodsSearchMainListFragment$onActivityCreated$4(this)).resetItemViewType(2131562586).build(), 0, 2, null);
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new GoodsSearchMainListFragment$onActivityCreated$5());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new GoodsSearchMainListFragment$onActivityCreated$6());
        loadHistory();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Observable<R> map = instance.getGoodsSearchHotWords().compose(RxUtils.apiCommonToData()).map(GoodsSearchMainListFragment$onCreateRequest$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…DS).string(it).build()) }");
        return map;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        return defaultOnResponse(z, list);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof DataItem) || ((DataItem) obj).getItemType() != 1) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return -1;
    }

    public final void loadHistory() {
        this.historyDataSet.clear();
        this.historyDataSet.addAll(GoodsSearchHistoryHelper.INSTANCE.getHistory());
        updateItemSearchHistory();
    }

    private final void updateItemSearchHistory() {
        if (this.historyDataSet.isEmpty()) {
            Iterator<Parcelable> it2 = getDataList().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                Parcelable next = it2.next();
                if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 1) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                getDataList().remove(i);
            }
        } else {
            Iterator<Parcelable> it3 = getDataList().iterator();
            int i2 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i2 = -1;
                    break;
                }
                Parcelable next2 = it3.next();
                if ((next2 instanceof DataItem) && ((DataItem) next2).getItemType() == 1) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                getDataList().add(new DataItem(1));
            } else {
                getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i2);
            }
        }
        updateContentUI();
    }
}
