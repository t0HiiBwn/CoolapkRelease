package com.coolapk.market.view.notification;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.NotificationReadEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Notification;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.notification.NotificationContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.NotificationViewHolder;
import com.coolapk.market.widget.Toast;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;
import rx.functions.Action1;

public class FollowMeListFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements NotificationContract.View {
    public static FollowMeListFragment newInstance() {
        Bundle bundle = new Bundle();
        FollowMeListFragment followMeListFragment = new FollowMeListFragment();
        followMeListFragment.setArguments(bundle);
        return followMeListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setPresenter(new FollowMePresenter(this));
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        AppHolder.getAppNotification().interceptInLifeCycle(this, new AppNotification.MessageIntercept() {
            /* class com.coolapk.market.view.notification.$$Lambda$FollowMeListFragment$L1glTA8OlJnY59ybScZVqLfXCU */

            @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
            public final boolean interceptNotification(PushMessage pushMessage) {
                return FollowMeListFragment.this.lambda$onActivityCreated$1$FollowMeListFragment(pushMessage);
            }
        });
        if (getUserVisibleHint()) {
            initData();
        }
        EventBus.getDefault().register(this);
    }

    public /* synthetic */ boolean lambda$onActivityCreated$1$FollowMeListFragment(PushMessage pushMessage) {
        if (!"contacts_follow".equals(pushMessage.getType()) || !isResumed()) {
            return false;
        }
        AppHolder.getMainThreadHandler().post(new Runnable() {
            /* class com.coolapk.market.view.notification.$$Lambda$FollowMeListFragment$SSOP3qQLJYZHU6yndNe0IPiBWZI */

            @Override // java.lang.Runnable
            public final void run() {
                FollowMeListFragment.this.lambda$null$0$FollowMeListFragment();
            }
        });
        return true;
    }

    public /* synthetic */ void lambda$null$0$FollowMeListFragment() {
        scrollToTop(true);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onNotificationRead(NotificationReadEvent notificationReadEvent) {
        List dataList = getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) instanceof Notification) {
                Notification notification = (Notification) dataList.get(i);
                if (notification.getId().equals(notificationReadEvent.id) && notification.getIsNew() > 0) {
                    setNotifyAdapter(false);
                    dataList.set(i, Notification.builder(notification).setIsNew(0).build());
                    getAdapter().notifyItemChanged(i);
                    setNotifyAdapter(true);
                }
            }
        }
    }

    @Subscribe
    public void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        int i = 0;
        if (userBlockedEvent.getIsInBlackList() > 0) {
            List dataList = getDataList();
            while (i < dataList.size()) {
                Entity entity = (Entity) dataList.get(i);
                if ((entity instanceof Notification) && TextUtils.equals(userBlockedEvent.getUid(), ((Notification) entity).getFromUid())) {
                    dataList.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        String entityType = ((Entity) getDataList().get(i)).getEntityType();
        entityType.hashCode();
        if (entityType.equals("notification")) {
            return 2131558849;
        }
        throw new RuntimeException("unknown View Type");
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(getActivity()).inflate(i, viewGroup, false);
        if (i == 2131558849) {
            return new NotificationViewHolder(inflate, getComponent(), null);
        }
        throw new RuntimeException("unknown View Type");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2 = false;
        if (result.getData() != null && !result.getData().isEmpty()) {
            if (z) {
                getDataList().addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(result.getData());
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.notification.NotificationContract.View
    public String findFirstItem() {
        for (int i = 0; i < getDataList().size(); i++) {
            if (((Entity) getDataList().get(i)).getEntityType().equals("notification")) {
                return ((Notification) getDataList().get(i)).getId();
            }
        }
        return null;
    }

    @Override // com.coolapk.market.view.notification.NotificationContract.View
    public String findLastItem() {
        for (int size = getDataList().size() - 1; size >= 0; size--) {
            if (((Entity) getDataList().get(size)).getEntityType().equals("notification")) {
                return ((Notification) getDataList().get(size)).getId();
            }
        }
        return null;
    }

    private static class FollowMePresenter extends NotificationContract.Presenter {
        private NotificationContract.View view;

        public FollowMePresenter(NotificationContract.View view2) {
            super(view2);
            this.view = view2;
        }

        @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
        protected Observable<Result<List<Entity>>> onCreateRequest(final boolean z, int i) {
            return DataManager.getInstance().getNotificationFollowMeList(i, this.view.findFirstItem(), this.view.findLastItem()).map(RxUtils.checkResult()).doOnNext(new Action1<Result<List<Entity>>>() {
                /* class com.coolapk.market.view.notification.FollowMeListFragment.FollowMePresenter.AnonymousClass1 */

                public void call(Result<List<Entity>> result) {
                    if (z) {
                        AppHolder.getAppNotification().clearByPage(6);
                    }
                }
            });
        }
    }
}
