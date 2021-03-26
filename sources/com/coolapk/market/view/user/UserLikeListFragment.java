package com.coolapk.market.view.user;

import android.os.Bundle;
import com.coolapk.market.event.FeedReplyLikeEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/user/UserLikeListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "entityToId", "", "entity", "Lcom/coolapk/market/model/Entity;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "", "onFeedReplyLike", "event", "Lcom/coolapk/market/event/FeedReplyLikeEvent;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserLikeListFragment.kt */
public final class UserLikeListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_UID = "uid";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/UserLikeListFragment$Companion;", "", "()V", "EXTRA_UID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserLikeListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> compose = DataManager.getInstance().getUserLikeList(requireArguments().getString("uid"), i, entityToId(EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)), entityToId(EntityListFragment.findLastEntity$default(this, null, false, 3, null))).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558905, 2131231061).create());
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558905).suitedMethod(UserLikeListFragment$onActivityCreated$1.INSTANCE).constructor(new UserLikeListFragment$onActivityCreated$2(this)).build(), -1);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void onFeedReplyLike(FeedReplyLikeEvent feedReplyLikeEvent) {
        Intrinsics.checkNotNullParameter(feedReplyLikeEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof FeedReply) {
                if (Intrinsics.areEqual(t.getId(), feedReplyLikeEvent.getId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if ((t instanceof Feed) && Intrinsics.areEqual(t.getId(), feedReplyLikeEvent.getId())) {
                getDataList().remove(i);
                return;
            }
            i++;
        }
    }

    private final String entityToId(Entity entity) {
        if (entity == null) {
            return null;
        }
        if (entity instanceof Feed) {
            StringBuilder sb = new StringBuilder();
            Feed feed = (Feed) entity;
            sb.append(feed.getEntityType());
            sb.append("-");
            sb.append(feed.getId());
            return sb.toString();
        } else if (!(entity instanceof FeedReply)) {
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            FeedReply feedReply = (FeedReply) entity;
            sb2.append(feedReply.getEntityType());
            sb2.append("-");
            sb2.append(feedReply.getId());
            return sb2.toString();
        }
    }
}
