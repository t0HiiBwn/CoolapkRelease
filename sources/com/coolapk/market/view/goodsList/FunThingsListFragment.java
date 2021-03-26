package com.coolapk.market.view.goodsList;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/goodsList/FunThingsListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "isFirstLoad", "", "uid", "", "getUid", "()Ljava/lang/String;", "uid$delegate", "Lkotlin/Lazy;", "findEmptyHolderIndex", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestResponse", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FunThingsListFragment.kt */
public final class FunThingsListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String TYPE_EMPTY_HOLDER = "emptyHolder";
    private boolean isFirstLoad;
    private final Lazy uid$delegate = LazyKt.lazy(new FunThingsListFragment$uid$2(this));

    private final String getUid() {
        return (String) this.uid$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/goodsList/FunThingsListFragment$Companion;", "", "()V", "TYPE_EMPTY_HOLDER", "", "newInstance", "Lcom/coolapk/market/view/goodsList/FunThingsListFragment;", "uid", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FunThingsListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FunThingsListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            FunThingsListFragment funThingsListFragment = new FunThingsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("UID", str);
            Unit unit = Unit.INSTANCE;
            funThingsListFragment.setArguments(bundle);
            return funThingsListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String uid = getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (uid.length() == 0) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            if (requireActivity instanceof AlphaToolbarActivity) {
                ((AlphaToolbarActivity) requireActivity).setToolbarTitle("我的好物单");
            }
        }
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558672).suitedMethod(FunThingsListFragment$onActivityCreated$1.INSTANCE).constructor(new FunThingsListFragment$onActivityCreated$2(this)).build(), 0);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String uid = getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        setHasOptionsMenu(uid.length() == 0);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        String uid = getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (uid.length() == 0) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            str = loginSession.getUid();
            Intrinsics.checkNotNullExpressionValue(str, "session.uid");
        } else {
            str = getUid();
            Intrinsics.checkNotNullExpressionValue(str, "uid");
        }
        Observable<R> compose = DataManager.getInstance().getGoodsList(str, "", i, (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId(), (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId()).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        if (getDataList().isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (Intrinsics.areEqual(loginSession.getUid(), getUid())) {
                List<Parcelable> dataList = getDataList();
                HolderItem build = HolderItem.newBuilder().entityType("emptyHolder").build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…YPE_EMPTY_HOLDER).build()");
                dataList.add(build);
                updateContentUI();
                return onRequestResponse;
            }
        }
        int findEmptyHolderIndex = findEmptyHolderIndex();
        if (findEmptyHolderIndex >= 0) {
            getDataList().remove(findEmptyHolderIndex);
        }
        updateContentUI();
        return onRequestResponse;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131362982, 0, "创建").setShowAsAction(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131362982) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActionManager.startCreateGoodsListActivity(getActivity());
        return true;
    }

    private final int findEmptyHolderIndex() {
        int size = getDataList().size();
        for (int i = 0; i < size; i++) {
            Parcelable parcelable = getDataList().get(i);
            if ((parcelable instanceof Entity) && Intrinsics.areEqual(((Entity) parcelable).getEntityType(), "emptyHolder")) {
                return i;
            }
        }
        return -1;
    }
}
