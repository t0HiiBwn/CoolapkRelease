package com.coolapk.market.view.user;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemReceiverdReplyBinding;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SimpleVXDividerDecoration;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserReplyViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

public class UserReceivedReplyListFragment extends NewAsyncListFragment<List<Entity>> {
    private static final String KEY_DATA = "DATA";
    private DataBindingComponent component;
    private ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private AdapterListChangedCallback onListChangeCallback;

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        FeedReply feedReply = (FeedReply) EntityUtils.findFirstItem(getDataList(), "feed_reply");
        FeedReply feedReply2 = (FeedReply) EntityUtils.findLastItem(getDataList(), "feed_reply");
        DataManager instance = DataManager.getInstance();
        String str = null;
        String id = feedReply != null ? feedReply.getId() : null;
        if (feedReply2 != null) {
            str = feedReply2.getId();
        }
        return instance.getUserReplyToMeList(i, id, str).map(RxUtils.checkResultToData());
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
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886764), 0);
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
        EventBus.getDefault().register(this);
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
        LoginSession loginSession = DataManager.getInstance().getLoginSession();
        FeedReply feedReply = feedReplyEvent.getFeedReply();
        if (feedReply.getUid().equals(loginSession.getUid())) {
            getDataList().add(0, feedReply);
            updateContentUI();
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

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558898;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new UserReplyViewHolder(LayoutInflater.from(UserReceivedReplyListFragment.this.getActivity()).inflate(i, viewGroup, false), UserReceivedReplyListFragment.this.component, null);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(UserReceivedReplyListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UserReceivedReplyListFragment.this.getDataList().size();
        }
    }

    public class ReceivedFeedReplyViewHolder extends GenericBindHolder<ItemReceiverdReplyBinding, FeedReply> {
        public static final int LAYOUT_ID = 2131558890;
        private FeedReply mFeedReply;

        public ReceivedFeedReplyViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(final FeedReply feedReply) {
            this.mFeedReply = feedReply;
            ItemReceiverdReplyBinding itemReceiverdReplyBinding = (ItemReceiverdReplyBinding) getBinding();
            itemReceiverdReplyBinding.setClick(this);
            itemReceiverdReplyBinding.setModel(feedReply);
            itemReceiverdReplyBinding.setViewHolder(this);
            itemReceiverdReplyBinding.setTransformer(new CircleTransform());
            itemReceiverdReplyBinding.executePendingBindings();
            CharSequence text = itemReceiverdReplyBinding.infoView.getText();
            if (text instanceof SpannableString) {
                SpannableString spannableString = (SpannableString) text;
                for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, text.length(), URLSpan.class)) {
                    spannableString.removeSpan(uRLSpan);
                }
                itemReceiverdReplyBinding.infoView.setText(spannableString);
            }
            ((ItemReceiverdReplyBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.coolapk.market.view.user.UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    LoginSession loginSession = DataManager.getInstance().getLoginSession();
                    if ((!loginSession.isAdmin() && !loginSession.getUid().equals(feedReply.getUid())) || UserReceivedReplyListFragment.this.getClass() != UserReceivedReplyListFragment.class) {
                        return false;
                    }
                    ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(UserReceivedReplyListFragment.this.getString(2131886722), UserReceivedReplyListFragment.this.getString(2131886719, feedReply.getUserName(), feedReply.getMessage()));
                    newInstance.setDeleteTarget(feedReply);
                    newInstance.show(UserReceivedReplyListFragment.this.getChildFragmentManager(), (String) null);
                    return true;
                }
            });
        }

        @Bindable
        public String getSourceTitle() {
            if (this.mFeedReply.getReplyFeed() != null) {
                return "@" + this.mFeedReply.getReplyFeed().getUserName();
            } else if (this.mFeedReply.getReplyArticle() != null) {
                return this.mFeedReply.getReplyArticle().getDyhName();
            } else {
                return null;
            }
        }

        @Bindable
        public String getSourcePic() {
            if (this.mFeedReply.getReplyFeed() != null) {
                return this.mFeedReply.getReplyFeed().getXsPic();
            }
            if (this.mFeedReply.getReplyArticle() != null) {
                return this.mFeedReply.getReplyArticle().getThumbSquarePic();
            }
            return null;
        }

        @Bindable
        public String getSourceMsg() {
            if (this.mFeedReply.getReplyFeed() != null) {
                return this.mFeedReply.getReplyFeed().getMessage();
            }
            if (this.mFeedReply.getReplyArticle() != null) {
                return this.mFeedReply.getReplyArticle().getMessage();
            }
            return null;
        }

        @Bindable
        public boolean isShowContent() {
            return (this.mFeedReply.getReplyFeed() == null && this.mFeedReply.getReplyArticle() == null) ? false : true;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            FeedReply model = ((ItemReceiverdReplyBinding) getBinding()).getModel();
            int id = view.getId();
            if (id != 2131362200) {
                if (id == 2131362316) {
                    ActionManager.startActivityByUrl(getContext(), model.getUrl());
                } else if (id == 2131363877) {
                    ActionManager.startUserSpaceActivity(view, model.getUid(), model.getUserAvatar());
                }
            } else if (model.hasParentReply()) {
                ActionManager.startFeedReplyDetailActivity(UserReceivedReplyListFragment.this.getActivity(), model.getParentReplyId());
            } else {
                ActionManager.startFeedReplyDetailActivity(UserReceivedReplyListFragment.this.getActivity(), model);
            }
        }
    }
}
