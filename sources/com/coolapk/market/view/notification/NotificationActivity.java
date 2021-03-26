package com.coolapk.market.view.notification;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;
import com.coolapk.market.view.message.NewMessageListFragment;
import com.coolapk.market.view.user.UserReceivedReplyListFragment;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;
import rx.functions.Action1;

public class NotificationActivity extends AlphaToolbarActivity {
    public static final String EXTRA_TAB = "tab";
    public static final int PRIVATE_MESSAGE_EDIT = 1;
    public static final int PRIVATE_MESSAGE_NORMAL = 0;
    private int messageState;

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        resetTabTitle();
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.notification.NotificationActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NotificationActivity.this.onBackPressed();
            }
        });
        this.binding.mainContent.addOnInsetChangeListener(new DrawSystemBarFrameLayout.OnInsetChangeListener() {
            /* class com.coolapk.market.view.notification.$$Lambda$NotificationActivity$KQ09JXy5MDrg6tUK0kt3DNKEclk */

            @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
            public final void onInsetChange(Rect rect) {
                NotificationActivity.this.lambda$onCreate$0$NotificationActivity(rect);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$NotificationActivity(Rect rect) {
        this.binding.contentView.setPadding(0, UiUtils.getActionBarSize(this) + rect.top, 0, 0);
    }

    public void setMessageState(int i) {
        this.messageState = i;
        getToolbar().setNavigationIcon(i == 1 ? 2131231200 : 2131231156);
        NewMessageListFragment newMessageListFragment = (NewMessageListFragment) getSupportFragmentManager().findFragmentById(2131362316);
        if (newMessageListFragment != null) {
            newMessageListFragment.updateEditState(i);
        }
    }

    public void updateDelView() {
        NewMessageListFragment newMessageListFragment = (NewMessageListFragment) getSupportFragmentManager().findFragmentById(2131362316);
        if (newMessageListFragment != null) {
            newMessageListFragment.updateDelView();
        }
    }

    public void setSelectAllState(boolean z) {
        NewMessageListFragment newMessageListFragment = (NewMessageListFragment) getSupportFragmentManager().findFragmentById(2131362316);
        if (newMessageListFragment != null) {
            newMessageListFragment.setSelectAllState(z);
        }
    }

    public int getMessageState() {
        return this.messageState;
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public BaseFragment onCreateFragment() {
        switch (getIntent().getIntExtra("tab", 1)) {
            case 0:
                return NotificationListFragment.newInstance();
            case 1:
            case 3:
                return CompatFeedListFragment.newInstance();
            case 2:
                return AtMeCommentFragment.newInstance();
            case 4:
                return NewMessageListFragment.newInstance();
            case 5:
                return FeedLikeListFragment.newInstance();
            case 6:
                return FollowMeListFragment.newInstance();
            default:
                throw new IllegalArgumentException();
        }
    }

    private void resetTabTitle() {
        String str;
        switch (getIntent().getIntExtra("tab", 1)) {
            case 0:
                str = getString(2131886903);
                break;
            case 1:
                str = getString(2131886894);
                break;
            case 2:
                str = getString(2131886892);
                break;
            case 3:
                str = getString(2131886906);
                break;
            case 4:
                str = getString(2131886904);
                break;
            case 5:
                str = getString(2131886897);
                break;
            case 6:
                str = getString(2131886895);
                break;
            default:
                throw new IllegalArgumentException();
        }
        setToolbarTitle(str);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    protected void onFragmentCreated(Fragment fragment) {
        super.onFragmentCreated(fragment);
        setPresenter(getIntent().getIntExtra("tab", 1), (BaseFragment) fragment);
    }

    private void setPresenter(int i, BaseFragment baseFragment) {
        switch (i) {
            case 0:
            case 6:
                return;
            case 1:
                CompatFeedListFragment compatFeedListFragment = (CompatFeedListFragment) baseFragment;
                compatFeedListFragment.setPresenter(new AtMeListPresenter(compatFeedListFragment));
                return;
            case 2:
                AtMeCommentFragment atMeCommentFragment = (AtMeCommentFragment) baseFragment;
                return;
            case 3:
                CompatFeedListFragment compatFeedListFragment2 = (CompatFeedListFragment) baseFragment;
                compatFeedListFragment2.setPresenter(new CommentMeListPresenter(compatFeedListFragment2));
                return;
            case 4:
                NewMessageListFragment newMessageListFragment = (NewMessageListFragment) baseFragment;
                return;
            case 5:
                FeedLikeListFragment feedLikeListFragment = (FeedLikeListFragment) baseFragment;
                feedLikeListFragment.setPresenter(new FeedLikeListPresenter(feedLikeListFragment));
                return;
            default:
                throw new IllegalArgumentException("position");
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        if (getMessageState() == 1) {
            setMessageState(0);
            return;
        }
        super.onBackPressed();
        if (getIntent().getIntExtra("tab", 0) != 0) {
            z = false;
        }
        if (z) {
            Intent parentActivityIntent = getParentActivityIntent();
            if (shouldUpRecreateTask(parentActivityIntent) || isTaskRoot()) {
                TaskStackBuilder.create(this).addNextIntentWithParentStack(parentActivityIntent).startActivities();
            } else if (AppHolder.getInstance().isMainActivityExist()) {
                finish();
            } else {
                navigateUpTo(parentActivityIntent);
            }
        }
    }

    public static class AtMeCommentFragment extends UserReceivedReplyListFragment {
        @Override // com.coolapk.market.view.user.UserReceivedReplyListFragment
        @Subscribe
        public void onFeedReply(FeedReplyEvent feedReplyEvent) {
        }

        @Override // com.coolapk.market.view.user.UserReceivedReplyListFragment
        @Subscribe
        public void onFeedReplyDelete(FeedReplyDeleteEvent feedReplyDeleteEvent) {
        }

        @Override // com.coolapk.market.view.user.UserReceivedReplyListFragment
        @Subscribe
        public void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        }

        public static AtMeCommentFragment newInstance() {
            Bundle bundle = new Bundle();
            AtMeCommentFragment atMeCommentFragment = new AtMeCommentFragment();
            atMeCommentFragment.setArguments(bundle);
            return atMeCommentFragment;
        }

        @Override // com.coolapk.market.view.user.UserReceivedReplyListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
        public Observable<List<Entity>> onCreateRequest(final boolean z, int i) {
            FeedReply feedReply = (FeedReply) EntityUtils.findFirstItem(getDataList(), "feed_reply");
            FeedReply feedReply2 = (FeedReply) EntityUtils.findLastItem(getDataList(), "feed_reply");
            DataManager instance = DataManager.getInstance();
            String str = null;
            String id = feedReply != null ? feedReply.getId() : null;
            if (feedReply2 != null) {
                str = feedReply2.getId();
            }
            return instance.getNotificationAtCommentMeList(i, id, str).map(RxUtils.checkResult()).doOnNext(new Action1<Result<List<Entity>>>() {
                /* class com.coolapk.market.view.notification.NotificationActivity.AtMeCommentFragment.AnonymousClass1 */

                public void call(Result<List<Entity>> result) {
                    if (z) {
                        AppHolder.getAppNotification().clearByPage(2);
                    }
                }
            }).map(RxUtils.checkResultToData());
        }
    }
}
