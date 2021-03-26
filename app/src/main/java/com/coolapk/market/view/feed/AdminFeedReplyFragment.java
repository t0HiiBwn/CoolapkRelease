package com.coolapk.market.view.feed;

import android.os.Bundle;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.user.UserReplyListFragment;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

public class AdminFeedReplyFragment extends UserReplyListFragment {
    private boolean isFolded;

    @Override // com.coolapk.market.view.user.UserReplyListFragment
    @Subscribe
    public void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
    }

    public static AdminFeedReplyFragment newInstance(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isFolded", z);
        AdminFeedReplyFragment adminFeedReplyFragment = new AdminFeedReplyFragment();
        adminFeedReplyFragment.setArguments(bundle);
        return adminFeedReplyFragment;
    }

    @Override // com.coolapk.market.view.user.UserReplyListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isFolded = getArguments().getBoolean("isFolded");
    }

    @Override // com.coolapk.market.view.user.UserReplyListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        FeedReply feedReply = (FeedReply) EntityUtils.findFirstItem(getDataList(), "feed_reply");
        FeedReply feedReply2 = (FeedReply) EntityUtils.findLastItem(getDataList(), "feed_reply");
        String str = null;
        if (this.isFolded) {
            DataManager instance = DataManager.getInstance();
            String id = feedReply != null ? feedReply.getId() : null;
            if (feedReply2 != null) {
                str = feedReply2.getId();
            }
            return instance.getAdminNewestList("feed_reply", i, id, str, 1).map(RxUtils.checkResultToData());
        }
        DataManager instance2 = DataManager.getInstance();
        String id2 = feedReply != null ? feedReply.getId() : null;
        if (feedReply2 != null) {
            str = feedReply2.getId();
        }
        return instance2.getAdminNewestList("feed_reply", i, id2, str).map(RxUtils.checkResultToData());
    }
}
