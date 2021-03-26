package com.coolapk.market.view.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.event.FeedReplyLikeEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SimpleVXDividerDecoration;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.UserReplyViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

public class UserReplyListFragment extends NewAsyncListFragment<List<Entity>> {
    public static final String EXTRA_UID = "uid";
    private static final String KEY_DATA = "DATA";
    private DataBindingComponent component;
    private ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private AdapterListChangedCallback onListChangeCallback;

    public static UserReplyListFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        UserReplyListFragment userReplyListFragment = new UserReplyListFragment();
        userReplyListFragment.setArguments(bundle);
        return userReplyListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String string = getArguments().getString("uid");
        FeedReply feedReply = (FeedReply) EntityUtils.findFirstItem(getDataList(), "feed_reply");
        FeedReply feedReply2 = (FeedReply) EntityUtils.findLastItem(getDataList(), "feed_reply");
        DataManager instance = DataManager.getInstance();
        String str = null;
        String id = feedReply != null ? feedReply.getId() : null;
        if (feedReply2 != null) {
            str = feedReply2.getId();
        }
        return instance.getUserReplyList(string, i, id, str).map(RxUtils.checkResultToData());
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.component = new FragmentBindingComponent(this);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
        EventBus.getDefault().register(this);
    }

    public DataBindingComponent getComponent() {
        return this.component;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886826), 0);
        setAdapter(new DataAdapter());
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        SimpleVXDividerDecoration simpleVXDividerDecoration = new SimpleVXDividerDecoration(getRecyclerView().getAdapter(), this.dataList);
        simpleVXDividerDecoration.addDividerRule(new SingleDividerRule(DividerData.H8DP));
        simpleVXDividerDecoration.addDividerRule(new TopBottomDividerRule(DividerData.H8DP, DividerData.H8DP));
        getRecyclerView().addItemDecoration(simpleVXDividerDecoration);
        setRefreshEnable(true);
        setLoadMoreEnable(true);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Subscribe
    public void onFeedReplyDelete(FeedReplyDeleteEvent feedReplyDeleteEvent) {
        List<Entity> dataList2 = getDataList();
        for (int i = 0; i < dataList2.size(); i++) {
            if (dataList2.get(i).getId().equals(feedReplyDeleteEvent.getFeedReply().getId())) {
                dataList2.remove(i);
            }
        }
    }

    @Subscribe
    public void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        int i = 0;
        if (userBlockedEvent.getIsInBlackList() > 0) {
            List<Entity> dataList2 = getDataList();
            while (i < dataList2.size()) {
                Entity entity = dataList2.get(i);
                if (entity instanceof FeedReply) {
                    FeedReply feedReply = (FeedReply) entity;
                    FeedReply removeFeedReply = userBlockedEvent.removeFeedReply(feedReply);
                    if (removeFeedReply == null) {
                        dataList2.remove(i);
                        i--;
                    } else if (removeFeedReply != feedReply) {
                        dataList2.set(i, removeFeedReply);
                    }
                }
                i++;
            }
        }
    }

    @Subscribe
    public void onFeedReply(FeedReplyEvent feedReplyEvent) {
        if (getArguments() != null) {
            String string = getArguments().getString("uid");
            LoginSession loginSession = DataManager.getInstance().getLoginSession();
            if (TextUtils.equals(string, loginSession.getUid())) {
                FeedReply feedReply = feedReplyEvent.getFeedReply();
                if (feedReply.getUid().equals(loginSession.getUid())) {
                    getDataList().add(0, feedReply);
                    updateContentUI();
                }
            }
        }
    }

    @Subscribe
    public void onFeedReplyLike(FeedReplyLikeEvent feedReplyLikeEvent) {
        List<Entity> dataList2 = getDataList();
        int findFeedReplyIndexById = FeedUtils.findFeedReplyIndexById(dataList2, feedReplyLikeEvent.getId());
        if (findFeedReplyIndexById >= 0) {
            getDataList().set(findFeedReplyIndexById, feedReplyLikeEvent.handleEvent((FeedReply) dataList2.get(findFeedReplyIndexById)));
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        AdapterListChangedCallback adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
            this.onListChangeCallback = null;
        }
        AdapterListChangedCallback adapterListChangedCallback2 = new AdapterListChangedCallback(adapter);
        this.onListChangeCallback = adapterListChangedCallback2;
        this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return isDataLoaded();
    }

    public List<Entity> getDataList() {
        return this.dataList;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<Entity> list) {
        boolean z2 = false;
        if (list != null && !list.isEmpty()) {
            if (z) {
                getDataList().addAll(0, list);
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(list);
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

    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new UserReplyViewHolder(LayoutInflater.from(getActivity()).inflate(i, viewGroup, false), this.component, null);
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558905;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return UserReplyListFragment.this.onCreateViewHolder(viewGroup, i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(UserReplyListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UserReplyListFragment.this.getDataList().size();
        }
    }
}
