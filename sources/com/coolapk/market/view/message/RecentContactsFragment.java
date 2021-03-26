package com.coolapk.market.view.message;

import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.decoration.VerticalItemDecoration;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: RecentContactsFragment.kt */
public final class RecentContactsFragment extends NewAsyncListFragment<List<? extends Entity>> {
    public static final Companion Companion = new Companion(null);
    private MultiTypeAdapter adapter;
    private final FragmentBindingComponent bindingComponent = new FragmentBindingComponent(this);
    private ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private final Lazy entity$delegate = LazyKt.lazy(new RecentContactsFragment$entity$2(this));
    private final Lazy listCallback$delegate = LazyKt.lazy(new RecentContactsFragment$listCallback$2(this));

    public final Entity getEntity() {
        return (Entity) this.entity$delegate.getValue();
    }

    private final AdapterListChangedCallback<ObservableList<Entity>> getListCallback() {
        return (AdapterListChangedCallback) this.listCallback$delegate.getValue();
    }

    public static final RecentContactsFragment newInstance(Entity entity) {
        return Companion.newInstance(entity);
    }

    public static final /* synthetic */ MultiTypeAdapter access$getAdapter$p(RecentContactsFragment recentContactsFragment) {
        MultiTypeAdapter multiTypeAdapter = recentContactsFragment.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return multiTypeAdapter;
    }

    /* compiled from: RecentContactsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecentContactsFragment newInstance(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("entity", entity);
            RecentContactsFragment recentContactsFragment = new RecentContactsFragment();
            recentContactsFragment.setArguments(bundle);
            return recentContactsFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setItemAnimator(null);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        VerticalItemDecoration create = ItemDecorations.vertical(getActivity()).type(2131558660, 2131231052).create();
        Intrinsics.checkNotNullExpressionValue(create, "ItemDecorations.vertical…                .create()");
        getRecyclerView().addItemDecoration(create);
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        this.adapter = multiTypeAdapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(multiTypeAdapter);
        this.dataList.add(0, HolderItem.newBuilder().string("最近联系人").entityType("title").build());
        if (getUserVisibleHint()) {
            initData();
        }
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter2.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558660).suitedMethod(RecentContactsFragment$onActivityCreated$1.INSTANCE).constructor(new RecentContactsFragment$onActivityCreated$2(this)).build(), 0);
        MultiTypeAdapter multiTypeAdapter3 = this.adapter;
        if (multiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter3.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558954).suitedMethod(RecentContactsFragment$onActivityCreated$3.INSTANCE).constructor(RecentContactsFragment$onActivityCreated$4.INSTANCE).build(), 0);
        this.dataList.addOnListChangedCallback(getListCallback());
    }

    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        List<? extends Entity> list2 = list;
        boolean z2 = true;
        if (!CollectionUtils.isNotEmpty(list2)) {
            z2 = false;
        } else if (z) {
            ObservableArrayList<Entity> observableArrayList = this.dataList;
            Intrinsics.checkNotNull(list);
            observableArrayList.addAll(1, list2);
            if (!UiUtils.canScrollDown(getRecyclerView())) {
                getRecyclerView().smoothScrollToPosition(0);
            }
        } else {
            ObservableArrayList<Entity> observableArrayList2 = this.dataList;
            Intrinsics.checkNotNull(list);
            observableArrayList2.addAll(list2);
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> compose = DataManager.getInstance().recentChatUser(i, findFirstItem(), findLastItem()).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    public final String findFirstItem() {
        Contacts findFirstContactsType = EntityUtils.findFirstContactsType(this.dataList);
        if (findFirstContactsType != null) {
            return findFirstContactsType.getFollowUid();
        }
        return null;
    }

    public final String findLastItem() {
        Contacts findLastContactsType = EntityUtils.findLastContactsType(this.dataList);
        if (findLastContactsType != null) {
            return findLastContactsType.getFollowUid();
        }
        return null;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return !this.dataList.isEmpty();
    }
}
