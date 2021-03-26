package com.coolapk.market.view.userv9;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceHomeTabFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "data", "", "Lcom/coolapk/market/model/Entity;", "getData", "()Ljava/util/List;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceHomeTabFragment.kt */
public final class UserSpaceHomeTabFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_DATA = "UID";

    @JvmStatic
    public static final UserSpaceHomeTabFragment newInstance(ArrayList<Entity> arrayList) {
        return Companion.newInstance(arrayList);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceHomeTabFragment$Companion;", "", "()V", "EXTRA_DATA", "", "newInstance", "Lcom/coolapk/market/view/userv9/UserSpaceHomeTabFragment;", "dataList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserSpaceHomeTabFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserSpaceHomeTabFragment newInstance(ArrayList<Entity> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "dataList");
            UserSpaceHomeTabFragment userSpaceHomeTabFragment = new UserSpaceHomeTabFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("UID", arrayList);
            Unit unit = Unit.INSTANCE;
            userSpaceHomeTabFragment.setArguments(bundle);
            return userSpaceHomeTabFragment;
        }
    }

    private final List<Entity> getData() {
        ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("UID");
        Intrinsics.checkNotNull(parcelableArrayList);
        return parcelableArrayList;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        if (!getDataList().isEmpty()) {
            Observable<List<Entity>> just = Observable.just(CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(emptyList())");
            return just;
        }
        Observable<List<Entity>> just2 = Observable.just(getData());
        Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(data)");
        return just2;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof UserSpaceV9Activity) {
            RecyclerView recyclerView = getRecyclerView();
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.userv9.UserSpaceV9Activity");
            recyclerView.setPadding(0, 0, 0, ((UserSpaceV9Activity) activity).getPaddingBottom());
        }
    }
}
