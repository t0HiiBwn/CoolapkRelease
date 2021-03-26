package com.coolapk.market.view.notification;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.NotificationDeletedEvent;
import com.coolapk.market.event.NotificationReadEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Notification;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bH\u0014J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0007J\u0012\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0014J \u0010-\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010 \u001a\u000200H\u0007J\u001a\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u0002032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u00065"}, d2 = {"Lcom/coolapk/market/view/notification/NotificationListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "deleteAllNotification", "", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "notifyItemChanged", "position", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onDestroy", "onNotificationDeleted", "event", "Lcom/coolapk/market/event/NotificationDeletedEvent;", "onNotificationEvent", "notification", "Lcom/coolapk/market/manager/AppNotification;", "onNotificationRead", "Lcom/coolapk/market/event/NotificationReadEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestFailure", "error", "", "onRequestResponse", "data", "onUserBlockedEvent", "Lcom/coolapk/market/event/UserBlockedEvent;", "onViewCreated", "view", "Landroid/view/View;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NotificationListFragment.kt */
public final class NotificationListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String TYPE_NAVIGATION_ITEM = "type_navigation_item";

    @JvmStatic
    public static final NotificationListFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/notification/NotificationListFragment$Companion;", "", "()V", "TYPE_NAVIGATION_ITEM", "", "newInstance", "Lcom/coolapk/market/view/notification/NotificationListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NotificationListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NotificationListFragment newInstance() {
            Bundle bundle = new Bundle();
            NotificationListFragment notificationListFragment = new NotificationListFragment();
            notificationListFragment.setArguments(bundle);
            return notificationListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipToPadding(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipChildren(false);
        ViewExtents2Kt.tryListenWindowsInset(view, new NotificationListFragment$onViewCreated$1(this));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558842).constructor(new NotificationListFragment$onActivityCreated$1(this)).suitedMethod(NotificationListFragment$onActivityCreated$2.INSTANCE).build(), -1);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558846).constructor(new NotificationListFragment$onActivityCreated$3(this)).suitedMethod(NotificationListFragment$onActivityCreated$4.INSTANCE).build(), -1);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            MenuItemCompat.setShowAsAction(menu.add(0, 2131361891, 0, getString(2131886697)), 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361891) {
            return true;
        }
        String string = getString(2131886697);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_delete_notification)");
        String string2 = getString(2131886695);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_delete_all_notification)");
        ConfirmDialog newInstance = ConfirmDialog.newInstance(string, string2);
        newInstance.setOnOkRunnable(new NotificationListFragment$onOptionsItemSelected$1(this));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        newInstance.show(childFragmentManager, (String) null);
        return true;
    }

    /* access modifiers changed from: private */
    public final void deleteAllNotification() {
        DataManager.getInstance().deleteAllNotification("all").map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new NotificationListFragment$deleteAllNotification$1(this));
    }

    @Subscribe
    public final void onNotificationRead(NotificationReadEvent notificationReadEvent) {
        Intrinsics.checkNotNullParameter(notificationReadEvent, "event");
        int size = getDataList().size();
        for (int i = 0; i < size; i++) {
            if (getDataList().get(i) instanceof Notification) {
                Parcelable parcelable = getDataList().get(i);
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.Notification");
                Notification notification = (Notification) parcelable;
                if (!(!Intrinsics.areEqual(notification.getId(), notificationReadEvent.id)) && notification.getIsNew() > 0) {
                    Notification build = Notification.builder(notification).setIsNew(0).build();
                    List<Parcelable> dataList = getDataList();
                    Intrinsics.checkNotNullExpressionValue(build, "after");
                    dataList.set(i, build);
                    getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
                }
            }
        }
    }

    @Subscribe
    public final void onNotificationDeleted(NotificationDeletedEvent notificationDeletedEvent) {
        Intrinsics.checkNotNullParameter(notificationDeletedEvent, "event");
        int size = getDataList().size();
        for (int i = 0; i < size; i++) {
            if (getDataList().get(i) instanceof Notification) {
                Parcelable parcelable = getDataList().get(i);
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.Notification");
                if (!(!Intrinsics.areEqual(((Notification) parcelable).getId(), notificationDeletedEvent.getId()))) {
                    getDataList().remove(i);
                    return;
                }
            }
        }
    }

    @Subscribe
    public final void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        Intrinsics.checkNotNullParameter(userBlockedEvent, "event");
        int i = 0;
        if (userBlockedEvent.getIsInBlackList() > 0) {
            while (i < getDataList().size()) {
                Parcelable parcelable = getDataList().get(i);
                if ((parcelable instanceof Notification) && TextUtils.equals(userBlockedEvent.getUid(), ((Notification) parcelable).getFromUid())) {
                    getDataList().remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onNotificationEvent(AppNotification appNotification) {
        int size = getDataList().size();
        for (int i = 0; i < size; i++) {
            Parcelable parcelable = getDataList().get(i);
            if ((parcelable instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) parcelable).getEntityType(), "type_navigation_item")) {
                getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeHintOrRefreshView();
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (z && EntityListFragment.findFirstEntityIndex$default(this, "type_navigation_item", null, false, false, 2, null) < 0) {
            List<Parcelable> dataList = getDataList();
            HolderItem build = HolderItem.newBuilder().entityType("type_navigation_item").entityFixed(1).build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…                 .build()");
            dataList.add(0, build);
        }
        if (z && EntityListFragment.findFirstEntityIndex$default(this, "type_navigation_item", null, false, false, 2, null) >= 0) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(0);
        }
        if (!onRequestResponse && EntityListFragment.findFirstEntityIndex$default(this, "notification", null, false, false, 14, null) < 0) {
            addHintView("你还没有收到通知", null);
            updateContentUI();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof HolderItem) || !Intrinsics.areEqual(((HolderItem) obj).getEntityType(), "type_navigation_item")) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return -1;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        super.onRequestFailure(z, th);
        removeHintOrRefreshView();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> doOnNext = instance.getNotificationList(i, entityId, str).compose(RxUtils.apiCommonToData()).doOnNext(new NotificationListFragment$onCreateRequest$1(z));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "DataManager.getInstance(…      }\n                }");
        return doOnNext;
    }

    public final void notifyItemChanged(int i) {
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
    }
}
