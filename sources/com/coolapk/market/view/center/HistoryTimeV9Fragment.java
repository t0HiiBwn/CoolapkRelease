package com.coolapk.market.view.center;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemNoMoreDataViewBinding;
import com.coolapk.market.databinding.ItemServiceAppTimeBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.viewholder.BindingViewHolder;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0014J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0002¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/center/HistoryTimeV9Fragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onRegisterCards", "onRequestResponse", "data", "onViewHistoryEvent", "event", "Lcom/coolapk/market/view/center/ViewHistoryDeleteEvent;", "updateTimeHolder", "getTimeDescription", "", "Lcom/coolapk/market/model/UserHistory;", "Companion", "NoMoreDataViewHolder", "TimeViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HistoryTimeV9Fragment.kt */
public final class HistoryTimeV9Fragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String ENTITY_TYPE_TIME = "entity_type_time";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/HistoryTimeV9Fragment$Companion;", "", "()V", "ENTITY_TYPE_TIME", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HistoryTimeV9Fragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(TopBottomDividerRule.Companion.getEMPTY());
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558980).suitedEntityType("history").constructor(new HistoryTimeV9Fragment$onRegisterCards$1(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558899).suitedEntityType("recent_login").constructor(new HistoryTimeV9Fragment$onRegisterCards$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558932).suitedEntityType("entity_type_time").constructor(HistoryTimeV9Fragment$onRegisterCards$3.INSTANCE).build(), 0, 2, null);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558844).suitedEntityType("NO_MORE_DATA").constructor(HistoryTimeV9Fragment$onRegisterCards$4.INSTANCE).build(), 0);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String str = null;
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String id = findFirstEntity$default != null ? findFirstEntity$default.getId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getId();
        }
        Observable<R> compose = instance.getUserHitHistory(i, id, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007e  */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeNoMoreDataView();
        int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "recent_login", null, false, false, 6, null);
        if (findFirstEntityIndex$default >= 0) {
            getDataList().remove(findFirstEntityIndex$default);
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (onRequestResponse || EntityListFragment.findFirstEntityIndex$default(this, "history", null, false, false, 14, null) < 0) {
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
                    if (getDataList().isEmpty()) {
                        List<Parcelable> dataList2 = getDataList();
                        HolderItem build2 = HolderItem.newBuilder().entityType("recent_login").string("您还没有浏览历史").build();
                        Intrinsics.checkNotNullExpressionValue(build2, "HolderItem.newBuilder().…tring(\"您还没有浏览历史\").build()");
                        dataList2.add(build2);
                        updateContentUI();
                    }
                    return onRequestResponse;
                }
            }
            updateTimeHolder();
            if (getDataList().isEmpty()) {
            }
            return onRequestResponse;
        }
        addNoMoreDataView();
        return onRequestResponse;
    }

    @Subscribe
    public final void onViewHistoryEvent(ViewHistoryDeleteEvent viewHistoryDeleteEvent) {
        Intrinsics.checkNotNullParameter(viewHistoryDeleteEvent, "event");
        String id = viewHistoryDeleteEvent.getData().getId();
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof UserHistory) && Intrinsics.areEqual(((UserHistory) next).getId(), id)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            String type = viewHistoryDeleteEvent.getType();
            int hashCode = type.hashCode();
            if (hashCode != -1335458389) {
                if (hashCode == 94746189 && type.equals("clear")) {
                    getDataList().clear();
                    reloadData();
                }
            } else if (type.equals("delete")) {
                getDataList().remove(i);
                updateTimeHolder();
            }
        }
    }

    private final void updateTimeHolder() {
        changeDataListAndAutoCalculateDiff(new HistoryTimeV9Fragment$updateTimeHolder$1(this));
    }

    /* access modifiers changed from: private */
    public final String getTimeDescription(UserHistory userHistory) {
        String historyTimeDescription = DateUtils.getHistoryTimeDescription(AppHolder.getApplication(), userHistory.getDateline());
        Intrinsics.checkNotNullExpressionValue(historyTimeDescription, "DateUtils.getHistoryTime…tApplication(), dateline)");
        return historyTimeDescription;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/center/HistoryTimeV9Fragment$NoMoreDataViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNoMoreDataViewBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HistoryTimeV9Fragment.kt */
    private static final class NoMoreDataViewHolder extends GenericBindHolder<ItemNoMoreDataViewBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558844;

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoMoreDataViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemNoMoreDataViewBinding itemNoMoreDataViewBinding = (ItemNoMoreDataViewBinding) getBinding();
            itemNoMoreDataViewBinding.textView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
            itemNoMoreDataViewBinding.textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            TextView textView = itemNoMoreDataViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setTextSize(12.0f);
            TextView textView2 = itemNoMoreDataViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setText(getContext().getString(2131887074));
            TextView textView3 = itemNoMoreDataViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
            textView3.getLayoutParams().height = -2;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/HistoryTimeV9Fragment$NoMoreDataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: HistoryTimeV9Fragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/HistoryTimeV9Fragment$TimeViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HistoryTimeV9Fragment.kt */
    private static final class TimeViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558932;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            ItemServiceAppTimeBinding itemServiceAppTimeBinding = (ItemServiceAppTimeBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemServiceAppTimeBinding, "binding");
            itemServiceAppTimeBinding.setTime(((HolderItem) obj).getString());
            itemServiceAppTimeBinding.executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/HistoryTimeV9Fragment$TimeViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: HistoryTimeV9Fragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
