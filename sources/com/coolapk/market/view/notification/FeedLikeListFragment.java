package com.coolapk.market.view.notification;

import android.os.Bundle;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemNotificationAlbumLikeBinding;
import com.coolapk.market.databinding.ItemNotificationFeedLikeBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SimpleVXDividerDecoration;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.notification.FeedLikeContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserReplyLikeViewHolder;
import com.coolapk.market.widget.Toast;
import java.util.List;

public class FeedLikeListFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements FeedLikeContract.View {
    public static FeedLikeListFragment newInstance() {
        Bundle bundle = new Bundle();
        FeedLikeListFragment feedLikeListFragment = new FeedLikeListFragment();
        feedLikeListFragment.setArguments(bundle);
        return feedLikeListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        SimpleVXDividerDecoration simpleVXDividerDecoration = new SimpleVXDividerDecoration(getRecyclerView().getAdapter(), this.dataList);
        simpleVXDividerDecoration.addDividerRule(new SingleDividerRule(DividerData.H8DP));
        simpleVXDividerDecoration.addDividerRule(new TopBottomDividerRule(DividerData.H8DP, DividerData.H8DP));
        getRecyclerView().addItemDecoration(simpleVXDividerDecoration);
        AppHolder.getAppNotification().interceptInLifeCycle(this, new AppNotification.MessageIntercept() {
            /* class com.coolapk.market.view.notification.$$Lambda$FeedLikeListFragment$mmsv2nGrDHiBF7dRoXpMZ7EOjyE */

            @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
            public final boolean interceptNotification(PushMessage pushMessage) {
                return FeedLikeListFragment.this.lambda$onActivityCreated$1$FeedLikeListFragment(pushMessage);
            }
        });
        if (getUserVisibleHint()) {
            initData();
        }
    }

    public /* synthetic */ boolean lambda$onActivityCreated$1$FeedLikeListFragment(PushMessage pushMessage) {
        if (!"feedlike".equals(pushMessage.getType()) && (!"feedReplylike".equals(pushMessage.getType()) || !isResumed())) {
            return false;
        }
        AppHolder.getMainThreadHandler().post(new Runnable() {
            /* class com.coolapk.market.view.notification.$$Lambda$FeedLikeListFragment$6Kiyg2mNb6xVSn70LfEawwVmnTA */

            @Override // java.lang.Runnable
            public final void run() {
                FeedLikeListFragment.this.lambda$null$0$FeedLikeListFragment();
            }
        });
        return true;
    }

    public /* synthetic */ void lambda$null$0$FeedLikeListFragment() {
        scrollToTop(true);
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        Entity entity = (Entity) getDataList().get(i);
        if (EntityUtils.isFeedType(entity.getEntityType())) {
            return 2131558851;
        }
        if (EntityUtils.isFeedreply(entity.getEntityType())) {
            return 2131558904;
        }
        if (EntityUtils.isAlbumType(entity.getEntityType())) {
            return 2131558850;
        }
        LogUtils.d("error viewType : %s", entity.toString());
        throw new RuntimeException("unknown type");
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(getActivity()).inflate(i, viewGroup, false);
        if (i == 2131558851) {
            return new FeedLikeViewHolder(inflate, getComponent(), null);
        }
        if (i == 2131558850) {
            return new AlbumLikeViewHolder(inflate, getComponent(), null);
        }
        if (i == 2131558904) {
            return new UserReplyLikeViewHolder(getActivity(), inflate, getComponent(), null);
        }
        return null;
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

    @Override // com.coolapk.market.view.notification.FeedLikeContract.View
    public String findFirstItem() {
        Entity findFirstFeedAndReplyType = EntityUtils.findFirstFeedAndReplyType(getDataList());
        if (findFirstFeedAndReplyType == null) {
            return null;
        }
        if (findFirstFeedAndReplyType instanceof Feed) {
            Feed feed = (Feed) findFirstFeedAndReplyType;
            return feed.getEntityType() + "-" + feed.getId() + "-" + feed.getLikeUid();
        } else if (!(findFirstFeedAndReplyType instanceof FeedReply)) {
            return null;
        } else {
            FeedReply feedReply = (FeedReply) findFirstFeedAndReplyType;
            return feedReply.getEntityType() + "-" + feedReply.getId() + "-" + feedReply.getLikeUid();
        }
    }

    @Override // com.coolapk.market.view.notification.FeedLikeContract.View
    public String findLastItem() {
        Entity findLastFeedAndReplyType = EntityUtils.findLastFeedAndReplyType(getDataList());
        if (findLastFeedAndReplyType == null) {
            return null;
        }
        if (findLastFeedAndReplyType instanceof Feed) {
            Feed feed = (Feed) findLastFeedAndReplyType;
            return feed.getEntityType() + "-" + feed.getId() + "-" + feed.getLikeUid();
        } else if (!(findLastFeedAndReplyType instanceof FeedReply)) {
            return null;
        } else {
            FeedReply feedReply = (FeedReply) findLastFeedAndReplyType;
            return feedReply.getEntityType() + "-" + feedReply.getId() + "-" + feedReply.getLikeUid();
        }
    }

    public class FeedLikeViewHolder extends GenericBindHolder<ItemNotificationFeedLikeBinding, Feed> {
        public static final int LAYOUT_ID = 2131558851;

        public FeedLikeViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(Feed feed) {
            ItemNotificationFeedLikeBinding itemNotificationFeedLikeBinding = (ItemNotificationFeedLikeBinding) getBinding();
            itemNotificationFeedLikeBinding.textView.setText(FeedLikeListFragment.this.getString(2131886960, feed.getFeedTypeName()));
            itemNotificationFeedLikeBinding.setClick(this);
            itemNotificationFeedLikeBinding.setModel(feed);
            itemNotificationFeedLikeBinding.setTransformer(new CircleTransform());
            itemNotificationFeedLikeBinding.executePendingBindings();
            LinkTextUtils.removeSpannable(itemNotificationFeedLikeBinding.infoView.getText(), URLSpan.class);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            Feed model = ((ItemNotificationFeedLikeBinding) getBinding()).getModel();
            int id = view.getId();
            if (id == 2131362322) {
                ActionManagerCompat.startActivityByUrl(getContext(), model.getUrl(), null, null);
            } else if (id == 2131363900) {
                ActionManager.startUserSpaceActivity(view, model.getLikeUid(), model.getLikeAvatar());
            }
        }
    }

    public class AlbumLikeViewHolder extends GenericBindHolder<ItemNotificationAlbumLikeBinding, Album> {
        public static final int LAYOUT_ID = 2131558850;

        public AlbumLikeViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(Album album) {
            ItemNotificationAlbumLikeBinding itemNotificationAlbumLikeBinding = (ItemNotificationAlbumLikeBinding) getBinding();
            itemNotificationAlbumLikeBinding.desView.setText("赞了你的应用集");
            itemNotificationAlbumLikeBinding.setClick(this);
            int i = 0;
            itemNotificationAlbumLikeBinding.userNameView.setText(String.format(getContext().getString(2131886643), album.getUserName(), Integer.valueOf(album.getTotalApkNum())));
            TextView textView = itemNotificationAlbumLikeBinding.recommendView;
            if (album.getRecommend() <= 0) {
                i = 8;
            }
            textView.setVisibility(i);
            itemNotificationAlbumLikeBinding.setModel(album);
            itemNotificationAlbumLikeBinding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            Album model = ((ItemNotificationAlbumLikeBinding) getBinding()).getModel();
            int id = view.getId();
            if (id == 2131362763) {
                ActionManagerCompat.startActivityByUrl(getContext(), model.getUrl(), null, null);
            } else if (id == 2131363900) {
                ActionManager.startUserSpaceActivity(view, model.getLikeUid(), model.getLikeAvatar());
            }
        }
    }
}
