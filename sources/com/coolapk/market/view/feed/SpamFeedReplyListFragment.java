package com.coolapk.market.view.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.databinding.ItemReplyListBinding;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.user.UserReplyListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.UserReplyViewHolder;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

public class SpamFeedReplyListFragment extends UserReplyListFragment {
    private String channel;
    private String spamType;
    private String subType;

    @Override // com.coolapk.market.view.user.UserReplyListFragment
    @Subscribe
    public void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
    }

    public static SpamFeedReplyListFragment newInstance() {
        Bundle bundle = new Bundle();
        SpamFeedReplyListFragment spamFeedReplyListFragment = new SpamFeedReplyListFragment();
        spamFeedReplyListFragment.setArguments(bundle);
        return spamFeedReplyListFragment;
    }

    public static SpamFeedReplyListFragment newInstance(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("spamType", str2);
        bundle.putString("subType", str3);
        bundle.putString("channel", str);
        SpamFeedReplyListFragment spamFeedReplyListFragment = new SpamFeedReplyListFragment();
        spamFeedReplyListFragment.setArguments(bundle);
        return spamFeedReplyListFragment;
    }

    @Override // com.coolapk.market.view.user.UserReplyListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channel = getArguments().getString("channel");
        this.spamType = getArguments().getString("spamType");
        this.subType = getArguments().getString("subType");
    }

    @Override // com.coolapk.market.view.user.UserReplyListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        FeedReply feedReply = (FeedReply) EntityUtils.findFirstItem(getDataList(), "feed_reply");
        FeedReply feedReply2 = (FeedReply) EntityUtils.findLastItem(getDataList(), "feed_reply");
        return DataManager.getInstance().getSpamFeedReplyList(this.channel, this.spamType, this.subType, i, feedReply != null ? feedReply.getId() : null, feedReply2 != null ? feedReply2.getId() : null).map(RxUtils.checkResultToData());
    }

    @Override // com.coolapk.market.view.user.UserReplyListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new UserReplyViewHolder(LayoutInflater.from(getActivity()).inflate(i, viewGroup, false), getComponent(), null) {
            /* class com.coolapk.market.view.feed.SpamFeedReplyListFragment.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.UserReplyViewHolder
            public void bindToContent(final FeedReply feedReply) {
                super.bindToContent(feedReply);
                ((ItemReplyListBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.coolapk.market.view.feed.SpamFeedReplyListFragment.AnonymousClass1.AnonymousClass1 */

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        EntityExtendsKt.showItemDialog(feedReply, SpamFeedReplyListFragment.this.getActivity());
                        return false;
                    }
                });
            }
        };
    }
}
