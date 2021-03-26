package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.FeedContract;
import com.coolapk.market.view.userv9.UserSpaceV9Activity;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/cardlist/CompatFeedListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/feed/FeedContract$View;", "()V", "presenter", "Lcom/coolapk/market/view/feed/FeedContract$Presenter;", "findFirstItem", "", "findLastItem", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "setPresenter", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompatFeedListFragment.kt */
public class CompatFeedListFragment extends EntityListFragment implements FeedContract.View {
    public static final Companion Companion = new Companion(null);
    private FeedContract.Presenter presenter;

    @JvmStatic
    public static final CompatFeedListFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/cardlist/CompatFeedListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/cardlist/CompatFeedListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CompatFeedListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CompatFeedListFragment newInstance() {
            return new CompatFeedListFragment();
        }
    }

    public final void setPresenter(FeedContract.Presenter presenter2) {
        this.presenter = presenter2;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof UserSpaceV9Activity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.userv9.UserSpaceV9Activity");
            if (((UserSpaceV9Activity) activity).isInBlackList()) {
                setEmptyData("由于你的黑名单设置，该用户动态对你不可见", 0);
            }
        }
    }

    @Override // com.coolapk.market.view.feed.FeedContract.View
    public String findFirstItem() {
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        if (findFirstEntity$default != null) {
            return findFirstEntity$default.getEntityId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.feed.FeedContract.View
    public String findLastItem() {
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default != null) {
            return findLastEntity$default.getEntityId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        FeedContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Observable<List<Entity>> error = Observable.error(new RuntimeException("You need to setPresenter"));
            Intrinsics.checkNotNullExpressionValue(error, "Observable.error(Runtime…u need to setPresenter\"))");
            return error;
        }
        Observable<R> compose = presenter2.onCreateRequest(z, i).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "presenter.onCreateReques…xUtils.apiCommonToData())");
        return compose;
    }
}
