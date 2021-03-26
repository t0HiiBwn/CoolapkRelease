package com.coolapk.market.view.center;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemNoMoreDataViewBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0014J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "isLoadFirstPage", "", "callParentFragmentUpdate", "", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "onRecentHistoryEvent", "event", "Lcom/coolapk/market/view/center/RecentHistoryEvent;", "onRegisterCards", "onRequestResponse", "data", "sortDataList", "NoMoreDataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentHistoryFragment.kt */
public final class RecentHistoryFragment extends EntityListFragment {
    private boolean isLoadFirstPage;

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558891).suitedEntityType("recentHistory").constructor(new RecentHistoryFragment$onRegisterCards$1(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558892).suitedEntityType("recent_login").constructor(new RecentHistoryFragment$onRegisterCards$2(this)).build(), 0, 2, null);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558837).suitedEntityType("NO_MORE_DATA").constructor(RecentHistoryFragment$onRegisterCards$3.INSTANCE).build(), 0);
    }

    @Subscribe
    public final void onRecentHistoryEvent(RecentHistoryEvent recentHistoryEvent) {
        Intrinsics.checkNotNullParameter(recentHistoryEvent, "event");
        String id = recentHistoryEvent.getData().getId();
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof RecentHistory) && Intrinsics.areEqual(((RecentHistory) next).getId(), id)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            String type = recentHistoryEvent.getType();
            LinearLayoutManager linearLayoutManager = null;
            switch (type.hashCode()) {
                case -1335458389:
                    if (type.equals("delete")) {
                        getDataList().remove(i);
                        return;
                    }
                    return;
                case -597840065:
                    if (type.equals("unset_top")) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        RecentHistory build = RecentHistory.newBuilder(recentHistoryEvent.getData()).setIsTop(0).build();
                        Intrinsics.checkNotNullExpressionValue(build, "RecentHistory.newBuilder…                 .build()");
                        dataList.add(0, build);
                        sortDataList();
                        RecyclerView recyclerView = getRecyclerView();
                        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager instanceof LinearLayoutManager) {
                            linearLayoutManager = layoutManager;
                        }
                        LinearLayoutManager linearLayoutManager2 = linearLayoutManager;
                        if (linearLayoutManager2 != null) {
                            linearLayoutManager2.scrollToPositionWithOffset(0, 0);
                            return;
                        }
                        return;
                    }
                    return;
                case 94746189:
                    if (type.equals("clear")) {
                        getDataList().clear();
                        reloadData();
                        return;
                    }
                    return;
                case 1985326072:
                    if (type.equals("set_top")) {
                        getDataList().remove(i);
                        List<Parcelable> dataList2 = getDataList();
                        RecentHistory build2 = RecentHistory.newBuilder(recentHistoryEvent.getData()).setIsTop(1).build();
                        Intrinsics.checkNotNullExpressionValue(build2, "RecentHistory.newBuilder…                 .build()");
                        dataList2.add(0, build2);
                        RecyclerView recyclerView2 = getRecyclerView();
                        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
                        RecyclerView.LayoutManager layoutManager2 = recyclerView2.getLayoutManager();
                        if (layoutManager2 instanceof LinearLayoutManager) {
                            linearLayoutManager = layoutManager2;
                        }
                        LinearLayoutManager linearLayoutManager3 = (LinearLayoutManager) linearLayoutManager;
                        if (linearLayoutManager3 != null) {
                            linearLayoutManager3.scrollToPositionWithOffset(0, 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void sortDataList() {
        changeDataListAndAutoCalculateDiff(RecentHistoryFragment$sortDataList$1.INSTANCE);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        callParentFragmentUpdate();
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        this.isLoadFirstPage = z2;
        DataManager instance = DataManager.getInstance();
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.getRecentHistoryList(i, null, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        if (this.isLoadFirstPage) {
            Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.intValue() < 20) {
                loadMore();
            }
        }
        int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "recent_login", null, false, false, 6, null);
        if (findFirstEntityIndex$default >= 0) {
            getDataList().remove(findFirstEntityIndex$default);
        }
        removeNoMoreDataView();
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (onRequestResponse) {
            sortDataList();
        }
        if (!onRequestResponse && EntityListFragment.findFirstEntityIndex$default(this, "recentHistory", null, false, false, 14, null) >= 0) {
            addNoMoreDataView();
        } else if (onRequestResponse && list != null && list.size() < 20) {
            addNoMoreDataView();
        }
        if (getDataList().isEmpty()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (!loginSession.isLogin()) {
                List<Parcelable> dataList = getDataList();
                HolderItem build = HolderItem.newBuilder().entityType("recent_login").build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…YPE_RECENT_LOGIN).build()");
                dataList.add(build);
                updateContentUI();
            }
        }
        if (getDataList().isEmpty()) {
            List<Parcelable> dataList2 = getDataList();
            HolderItem build2 = HolderItem.newBuilder().entityType("recent_login").string("最近没有常去记录").build();
            Intrinsics.checkNotNullExpressionValue(build2, "HolderItem.newBuilder().…tring(\"最近没有常去记录\").build()");
            dataList2.add(build2);
            updateContentUI();
        }
        return onRequestResponse;
    }

    private final void callParentFragmentUpdate() {
        Fragment parentFragment = getParentFragment();
        if ((parentFragment instanceof CenterToolsProvider) && parentFragment.isAdded()) {
            ((CenterToolsProvider) parentFragment).getCenterPresenter().requestReloadUserProfile();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryFragment$NoMoreDataViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNoMoreDataViewBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecentHistoryFragment.kt */
    private static final class NoMoreDataViewHolder extends GenericBindHolder<ItemNoMoreDataViewBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558837;

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoMoreDataViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemNoMoreDataViewBinding itemNoMoreDataViewBinding = (ItemNoMoreDataViewBinding) getBinding();
            itemNoMoreDataViewBinding.textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            TextView textView = itemNoMoreDataViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setTextSize(12.0f);
            TextView textView2 = itemNoMoreDataViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setText("常去记录由您的当日操作生成");
            TextView textView3 = itemNoMoreDataViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
            textView3.getLayoutParams().height = -2;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryFragment$NoMoreDataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: RecentHistoryFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
