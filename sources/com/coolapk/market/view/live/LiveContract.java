package com.coolapk.market.view.live;

import com.coolapk.market.model.Live;
import com.coolapk.market.model.Video;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/view/live/LiveContract;", "", "Presenter", "View", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveContract.kt */
public interface LiveContract {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\n\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J*\u0010\u000b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0006H&J*\u0010\r\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0006H&J\"\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\u0012\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J*\u0010\u0014\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0006H&¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/live/LiveContract$View;", "Lcom/coolapk/market/view/base/BaseView;", "onAddToBroadcast", "", "result", "Lcom/coolapk/market/network/Result;", "", "error", "", "onBanAllPost", "onBanAllPostPic", "onBanUser", "uid", "onBanUserAndClean", "onChangeLiveStatus", "onLiveFollowed", "follow", "", "onLiveLoaded", "Lcom/coolapk/market/model/Live;", "onMessageDeleted", "messageId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveContract.kt */
    public interface View extends BaseView {
        void onAddToBroadcast(Result<String> result, Throwable th);

        void onBanAllPost(Result<String> result, Throwable th);

        void onBanAllPostPic(Result<String> result, Throwable th);

        void onBanUser(Result<String> result, Throwable th, String str);

        void onBanUserAndClean(Result<String> result, Throwable th, String str);

        void onChangeLiveStatus(Result<String> result, Throwable th);

        void onLiveFollowed(boolean z, Result<String> result, Throwable th);

        void onLiveLoaded(Result<Live> result, Throwable th);

        void onMessageDeleted(Result<String> result, Throwable th, String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 !2\u00020\u0001:\u0001!J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u000eH&J\b\u0010\u001e\u001a\u00020\tH&J\b\u0010\u001f\u001a\u00020\tH&J\b\u0010 \u001a\u00020\u0003H&¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/live/LiveContract$Presenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "addToBroadcast", "", "liveId", "", "messageId", "banAllPost", "ban", "", "banAllPostPic", "banUser", "uid", "banType", "", "banUserAndClean", "cancelAddToBroadcast", "cancelFollowLive", "cancelLoadLive", "changeLiveStatus", "status", "deleteMessage", "followLive", "isFollow", "getLive", "Lcom/coolapk/market/model/Live;", "getVideoLineMap", "", "Lcom/coolapk/market/model/Video;", "liveStatus", "isFollowLiveLoading", "isLoadingLive", "loadLive", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveContract.kt */
    public interface Presenter extends BasePresenter {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String FILED_DISABLE_DISCUSS_TAB = "disable_discuss_tab";
        public static final String FILED_DISALLOW_POST = "disallow_post";
        public static final String FILED_DISALLOW_POST_PIC = "disallow_post_pic";
        public static final String FILED_LIVE_STATUS = "LIVE_STATUS";
        public static final String FILED_STATUS = "STATUS";

        void addToBroadcast(String str, String str2);

        void banAllPost(String str, boolean z);

        void banAllPostPic(String str, boolean z);

        void banUser(String str, String str2, int i);

        void banUserAndClean(String str, String str2);

        void cancelAddToBroadcast();

        void cancelFollowLive();

        void cancelLoadLive();

        void changeLiveStatus(String str, int i);

        void deleteMessage(String str, String str2);

        void followLive(String str, boolean z);

        Live getLive();

        Map<String, Video> getVideoLineMap(int i);

        boolean isFollowLiveLoading();

        boolean isLoadingLive();

        void loadLive();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/live/LiveContract$Presenter$Companion;", "", "()V", "FILED_DISABLE_DISCUSS_TAB", "", "FILED_DISALLOW_POST", "FILED_DISALLOW_POST_PIC", "FILED_LIVE_STATUS", "FILED_STATUS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: LiveContract.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String FILED_DISABLE_DISCUSS_TAB = "disable_discuss_tab";
            public static final String FILED_DISALLOW_POST = "disallow_post";
            public static final String FILED_DISALLOW_POST_PIC = "disallow_post_pic";
            public static final String FILED_LIVE_STATUS = "LIVE_STATUS";
            public static final String FILED_STATUS = "STATUS";

            private Companion() {
            }
        }
    }
}
