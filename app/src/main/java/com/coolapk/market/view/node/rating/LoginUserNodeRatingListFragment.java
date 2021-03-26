package com.coolapk.market.view.node.rating;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/node/rating/LoginUserNodeRatingListFragment;", "Lcom/coolapk/market/view/node/rating/BaseRatingListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onNodeRatingDeleteEvent", "event", "Lcom/coolapk/market/view/node/rating/NodeRatingDeleteEvent;", "onRequestResponse", "", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginUserNodeRatingListFragment.kt */
public final class LoginUserNodeRatingListFragment extends BaseRatingListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_SELECTOR = "selector";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/rating/LoginUserNodeRatingListFragment$Companion;", "", "()V", "ENTITY_TYPE_SELECTOR", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginUserNodeRatingListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.node.rating.BaseRatingListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558816).suitedMethod(LoginUserNodeRatingListFragment$onActivityCreated$1.INSTANCE).constructor(new LoginUserNodeRatingListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558978).suitedMethod(LoginUserNodeRatingListFragment$onActivityCreated$3.INSTANCE).constructor(new LoginUserNodeRatingListFragment$onActivityCreated$4(this)).build(), 0, 2, null);
    }

    @Subscribe
    public final void onNodeRatingDeleteEvent(NodeRatingDeleteEvent nodeRatingDeleteEvent) {
        Intrinsics.checkNotNullParameter(nodeRatingDeleteEvent, "event");
        changeDataListAndAutoCalculateDiff(new LoginUserNodeRatingListFragment$onNodeRatingDeleteEvent$1(this, nodeRatingDeleteEvent));
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        Parcelable parcelable = (Parcelable) CollectionsKt.firstOrNull((List<? extends Object>) getDataList());
        int i = 0;
        if (!(parcelable instanceof HolderItem) || (!Intrinsics.areEqual(((HolderItem) parcelable).getEntityType(), "selector"))) {
            List<Parcelable> dataList = getDataList();
            HolderItem build = HolderItem.newBuilder().entityType("selector").build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…TY_TYPE_SELECTOR).build()");
            dataList.add(0, build);
        }
        if (!onRequestResponse && z) {
            Iterator<Parcelable> it2 = getDataList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (it2.next() instanceof NodeRating) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                addFullHintView("你还没有发过点评", null);
                updateContentUI();
            }
        }
        return onRequestResponse;
    }
}
