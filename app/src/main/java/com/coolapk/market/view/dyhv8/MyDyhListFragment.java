package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.event.DyhHandleEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/dyhv8/MyDyhListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "isUserFollowList", "", "listType", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "onDestroy", "onDyhEvent", "event", "Lcom/coolapk/market/event/DyhHandleEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyDyhListFragment.kt */
public final class MyDyhListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";
    public static final String KEY_IS_FOLLOW = "IS_FOLLOW";
    public static final String LIST_TYPE_ALL = "allList";
    public static final String LIST_TYPE_FOLLOW = "followList";
    private boolean isUserFollowList;
    private String listType;

    @JvmStatic
    public static final MyDyhListFragment newInstance(boolean z, String str) {
        return Companion.newInstance(z, str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/dyhv8/MyDyhListFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_IS_FOLLOW", "LIST_TYPE_ALL", "LIST_TYPE_FOLLOW", "newInstance", "Lcom/coolapk/market/view/dyhv8/MyDyhListFragment;", "isFollowList", "", "type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MyDyhListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MyDyhListFragment newInstance(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            MyDyhListFragment myDyhListFragment = new MyDyhListFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_FOLLOW", z);
            bundle.putString("LIST_TYPE", str);
            Unit unit = Unit.INSTANCE;
            myDyhListFragment.setArguments(bundle);
            return myDyhListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isUserFollowList = requireArguments().getBoolean("IS_FOLLOW");
        String string = requireArguments().getString("LIST_TYPE");
        Intrinsics.checkNotNull(string);
        this.listType = string;
        setHasOptionsMenu(true);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558680).suitedMethod(MyDyhListFragment$onActivityCreated$1.INSTANCE).constructor(new MyDyhListFragment$onActivityCreated$2(this)).build(), 0);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            MenuItem add = menu.add(0, 2131362970, 0, "添加更多");
            add.setIcon(2131231489);
            add.setShowAsAction(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131362970) {
            return super.onOptionsItemSelected(menuItem);
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActionManagerCompat.startDataListActivity$default(requireActivity, "#V8_CHANNEL_DYH_RECOMMEND", "推荐订阅", null, 0, 24, null);
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Entity findLastEntity$default2;
        Entity findFirstEntity$default2;
        String str = null;
        if (this.isUserFollowList) {
            DataManager instance = DataManager.getInstance();
            String entityId = (!z || (findFirstEntity$default2 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default2.getEntityId();
            if (!z && (findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                str = findLastEntity$default2.getEntityId();
            }
            Observable<R> compose = instance.getUserFollowDyhList(i, entityId, str).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        }
        DataManager instance2 = DataManager.getInstance();
        String str2 = this.listType;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listType");
        }
        String entityId2 = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> compose2 = instance2.getDyhList(str2, i, entityId2, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose2, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose2;
    }

    @Subscribe
    public final void onDyhEvent(DyhHandleEvent dyhHandleEvent) {
        Intrinsics.checkNotNullParameter(dyhHandleEvent, "event");
        DyhModel dyhModel = dyhHandleEvent.getDyhModel();
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof DyhModel) {
                Intrinsics.checkNotNullExpressionValue(dyhModel, "dyhModel");
                if (TextUtils.equals(t.getId(), dyhModel.getId())) {
                    getDataList().set(i, dyhModel);
                    if (this.isUserFollowList && !dyhModel.isDyhFollowed()) {
                        getDataList().remove(i);
                    }
                }
            }
            i++;
        }
    }
}
