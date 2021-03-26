package com.coolapk.market.view.node.rating;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/node/rating/UserNodeRatingListFragment;", "Lcom/coolapk/market/view/node/rating/BaseRatingListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onNodeRatingDeleteEvent", "event", "Lcom/coolapk/market/view/node/rating/NodeRatingDeleteEvent;", "onRequestResponse", "", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserNodeRatingListFragment.kt */
public final class UserNodeRatingListFragment extends BaseRatingListFragment {
    @Override // com.coolapk.market.view.node.rating.BaseRatingListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558985).suitedMethod(UserNodeRatingListFragment$onActivityCreated$1.INSTANCE).constructor(new UserNodeRatingListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
    }

    @Subscribe
    public final void onNodeRatingDeleteEvent(NodeRatingDeleteEvent nodeRatingDeleteEvent) {
        Intrinsics.checkNotNullParameter(nodeRatingDeleteEvent, "event");
        changeDataListAndAutoCalculateDiff(new UserNodeRatingListFragment$onNodeRatingDeleteEvent$1(this, nodeRatingDeleteEvent));
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (z) {
            int i = 0;
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
                addFullHintView("还没有评分哦", null);
                updateContentUI();
            }
        }
        return onRequestResponse;
    }
}
