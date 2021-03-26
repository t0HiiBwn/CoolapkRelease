package com.coolapk.market.view.node.rating;

import android.os.Bundle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0010H\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058@X\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/node/rating/BaseRatingListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/node/rating/NodeRatingView;", "()V", "presenter", "Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "getPresenter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "presenter$delegate", "Lkotlin/Lazy;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onNodeRatingArgsChanged", "data", "Lcom/coolapk/market/view/node/rating/NodeRatingArgs;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseRatingListFragment.kt */
public class BaseRatingListFragment extends EntityListFragment implements NodeRatingView {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_SHOW_BUY_STATUS = "show_buyStatus";
    public static final String EXTRA_SHOW_OWNER_STATUS = "show_ownerStatus";
    public static final String EXTRA_TARGET_ID = "target_id";
    public static final String EXTRA_TARGET_TYPE = "target_type";
    public static final String EXTRA_TARGET_VERSION = "target_version";
    public static final String EXTRA_UID = "uid";
    private final Lazy presenter$delegate = LazyKt.lazy(new BaseRatingListFragment$presenter$2(this));

    public final NodeRatingPresenter getPresenter$presentation_coolapkAppRelease() {
        return (NodeRatingPresenter) this.presenter$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/node/rating/BaseRatingListFragment$Companion;", "", "()V", "EXTRA_SHOW_BUY_STATUS", "", "EXTRA_SHOW_OWNER_STATUS", "EXTRA_TARGET_ID", "EXTRA_TARGET_TYPE", "EXTRA_TARGET_VERSION", "EXTRA_UID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BaseRatingListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.getEMPTY()));
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        NodeRatingPresenter presenter$presentation_coolapkAppRelease = getPresenter$presentation_coolapkAppRelease();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, "nodeRating", null, false, true, 6, null);
        String str = null;
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity = findLastEntity("nodeRating", true);
        if (findLastEntity != null) {
            str = findLastEntity.getEntityId();
        }
        Observable<R> compose = presenter$presentation_coolapkAppRelease.getNodeRatingList(i, entityId, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "presenter.getNodeRatingL…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof HolderItem) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    @Override // com.coolapk.market.view.node.rating.NodeRatingView
    public void onNodeRatingArgsChanged(NodeRatingArgs nodeRatingArgs) {
        Intrinsics.checkNotNullParameter(nodeRatingArgs, "data");
        changeDataListAndAutoCalculateDiff(new BaseRatingListFragment$onNodeRatingArgsChanged$1(this));
        setPage(1);
        reloadData();
        addRefreshView();
    }
}
