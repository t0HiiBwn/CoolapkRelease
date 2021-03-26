package com.coolapk.market.view.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J*\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u001a\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J&\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0014J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u001dH\u0014R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/LiveUser;", "()V", "banType", "", "getBanType", "()I", "banType$delegate", "Lkotlin/Lazy;", "dataList", "Landroidx/databinding/ObservableArrayList;", "liveId", "", "getLiveId", "()Ljava/lang/String;", "liveId$delegate", "findFirstItem", "findLastItem", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "isRefresh", "", "page", "onRequestFailure", "error", "", "onRequestResponse", "result", "onSaveInstanceState", "outState", "shouldShowList", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BannedUserListFragment.kt */
public final class BannedUserListFragment extends NewAsyncListFragment<Result<List<? extends LiveUser>>> {
    public static final int BAN_TYPE_ALL = 1;
    public static final int BAN_TYPE_PIC = 2;
    public static final Companion Companion = new Companion(null);
    public static final String KEY_BAN_TYPE = "BAN_TYPE";
    private static final String KEY_DATA = "DATA";
    public static final String KEY_LIVE_ID = "LIVE_ID";
    private final Lazy banType$delegate = LazyKt.lazy(new BannedUserListFragment$banType$2(this));
    private final ObservableArrayList<LiveUser> dataList = new ObservableArrayList<>();
    private final Lazy liveId$delegate = LazyKt.lazy(new BannedUserListFragment$liveId$2(this));

    /* access modifiers changed from: private */
    public final int getBanType() {
        return ((Number) this.banType$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final String getLiveId() {
        return (String) this.liveId$delegate.getValue();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public /* bridge */ /* synthetic */ boolean onRequestResponse(boolean z, Result<List<? extends LiveUser>> result) {
        return onRequestResponse(z, (Result<List<LiveUser>>) result);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserListFragment$Companion;", "", "()V", "BAN_TYPE_ALL", "", "BAN_TYPE_PIC", "KEY_BAN_TYPE", "", "KEY_DATA", "KEY_LIVE_ID", "newInstance", "Lcom/coolapk/market/view/live/BannedUserListFragment;", "liveId", "banType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BannedUserListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BannedUserListFragment newInstance(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "liveId");
            BannedUserListFragment bannedUserListFragment = new BannedUserListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LIVE_ID", str);
            bundle.putInt("BAN_TYPE", i);
            Unit unit = Unit.INSTANCE;
            bannedUserListFragment.setArguments(bundle);
            return bannedUserListFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558974, 2131231062).last(2131231062).create());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 48));
        DataAdapter dataAdapter = new DataAdapter();
        setAdapter(dataAdapter);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(dataAdapter));
        if (getUserVisibleHint()) {
            initData();
        }
    }

    protected boolean onRequestResponse(boolean z, Result<List<LiveUser>> result) {
        boolean z2 = false;
        if (result != null && !CollectionUtils.isEmpty(result.getData())) {
            if (z) {
                this.dataList.addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                this.dataList.addAll(result.getData());
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<Result<List<LiveUser>>> onCreateRequest(boolean z, int i) {
        Observable<Result<List<LiveUser>>> liveBannedUserList = DataManager.getInstance().getLiveBannedUserList(getLiveId(), getBanType(), i, findFirstItem(), findLastItem());
        Intrinsics.checkNotNullExpressionValue(liveBannedUserList, "DataManager.getInstance(…stItem(), findLastItem())");
        return liveBannedUserList;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public final String findFirstItem() {
        if (this.dataList.size() <= 0) {
            return null;
        }
        Object obj = this.dataList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "dataList[0]");
        return ((LiveUser) obj).getId();
    }

    public final String findLastItem() {
        if (this.dataList.size() <= 0) {
            return null;
        }
        ObservableArrayList<LiveUser> observableArrayList = this.dataList;
        Object obj = observableArrayList.get(observableArrayList.size() - 1);
        Intrinsics.checkNotNullExpressionValue(obj, "dataList[dataList.size - 1]");
        return ((LiveUser) obj).getId();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserListFragment$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "(Lcom/coolapk/market/view/live/BannedUserListFragment;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BannedUserListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558974;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558974, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new BannedUserViewHolder(inflate, new FragmentBindingComponent(BannedUserListFragment.this), new BannedUserListFragment$DataAdapter$onCreateViewHolder$1(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return BannedUserListFragment.this.dataList.size();
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.bindTo(BannedUserListFragment.this.dataList.get(i));
        }
    }
}
