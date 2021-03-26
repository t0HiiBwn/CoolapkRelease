package com.coolapk.market.view.live;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.view.live.LiveContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u000eJ\b\u0010\u001c\u001a\u00020\fH\u0002J\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\fJ\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\fJ\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\fJ\u0011\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0.¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020\fJ\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u000eJ\u0006\u00103\u001a\u00020\u000eJ\u0006\u00104\u001a\u00020\u000eJ\u000e\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\fJ\u0010\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020:J\u0016\u0010=\u001a\u0002082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010>\u001a\u0002082\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010?\u001a\u0002082\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010@\u001a\u0002082\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/coolapk/market/view/live/LiveViewModel;", "", "context", "Landroid/content/Context;", "presenter", "Lcom/coolapk/market/view/live/LiveContract$Presenter;", "(Landroid/content/Context;Lcom/coolapk/market/view/live/LiveContract$Presenter;)V", "getContext", "()Landroid/content/Context;", "discussNum", "", "discussNumFormat", "", "followLive", "", "Ljava/lang/Boolean;", "followNum", "followNumFormat", "getPresenter", "()Lcom/coolapk/market/view/live/LiveContract$Presenter;", "videoLineKey", "getVideoLineKey", "()Ljava/lang/String;", "setVideoLineKey", "(Ljava/lang/String;)V", "visitNum", "visitNumFormat", "currentUserIsPresenter", "getDiscussNumFormat", "getDiscussTabTitle", "getFollowNum", "getFollowNumFormat", "getLive", "Lcom/coolapk/market/model/Live;", "getLivePopulateString", "getLiveShowTimeString", "getLiveStatus", "getLiveStatusSimpleColor", "getLiveStatusSimpleString", "getLiveStatusString", "getLiveSubscribeStateBackground", "getLiveSubscribeStateString", "getLiveType", "getLiveTypeString", "getPopulateNumFormat", "getViewPageTitles", "", "()[Ljava/lang/String;", "getVisitNumFormat", "isFollowLive", "isLiveClosed", "isLiveNotStart", "isLiveStart", "isPresenter", "uid", "onInitPresenterState", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "setDiscussNumFormat", "setFollowLive", "setFollowNumFormat", "setVisitNumFormat", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveViewModel.kt */
public final class LiveViewModel {
    public static final Companion Companion = new Companion(null);
    public static final int LIVE_TYPE_IMAGE_TEXT = 1;
    public static final int LIVE_TYPE_VIDEO = 2;
    private final Context context;
    private int discussNum;
    private String discussNumFormat;
    private Boolean followLive;
    private int followNum;
    private String followNumFormat;
    private final LiveContract.Presenter presenter;
    private String videoLineKey = "";
    private int visitNum;
    private String visitNumFormat;

    public LiveViewModel(Context context2, LiveContract.Presenter presenter2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(presenter2, "presenter");
        this.context = context2;
        this.presenter = presenter2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LiveContract.Presenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/live/LiveViewModel$Companion;", "", "()V", "LIVE_TYPE_IMAGE_TEXT", "", "LIVE_TYPE_VIDEO", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getVideoLineKey() {
        return this.videoLineKey;
    }

    public final void setVideoLineKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoLineKey = str;
    }

    public final void onInitPresenterState(Bundle bundle) {
        String str;
        String str2 = null;
        this.followLive = bundle != null ? Boolean.valueOf(bundle.getBoolean("followLive")) : null;
        this.discussNumFormat = bundle != null ? bundle.getString("discussNumFormat") : null;
        this.followNumFormat = bundle != null ? bundle.getString("followNumFormat") : null;
        if (bundle != null) {
            str2 = bundle.getString("visitNumFormat");
        }
        this.visitNumFormat = str2;
        int i = 0;
        this.discussNum = bundle != null ? bundle.getInt("discussNum") : 0;
        this.followNum = bundle != null ? bundle.getInt("followNum") : 0;
        if (bundle != null) {
            i = bundle.getInt("visitNum");
        }
        this.visitNum = i;
        if (bundle == null || (str = bundle.getString("videoLineKey")) == null) {
            str = "";
        }
        this.videoLineKey = str;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Boolean bool = this.followLive;
        bundle.putBoolean("followLive", bool != null ? bool.booleanValue() : false);
        bundle.putString("discussNumFormat", this.discussNumFormat);
        bundle.putString("followNumFormat", this.followNumFormat);
        bundle.putString("visitNumFormat", this.visitNumFormat);
        bundle.putInt("discussNum", this.discussNum);
        bundle.putInt("followNum", this.followNum);
        bundle.putInt("visitNum", this.visitNum);
        bundle.putString("videoLineKey", this.videoLineKey);
    }

    public final String getFollowNumFormat() {
        Live live = getLive();
        if (live == null) {
            return "";
        }
        String str = this.followNumFormat;
        if (str == null) {
            str = live.getFollowNumFormat();
            this.followNum = live.getFollowNum();
            this.followNumFormat = str;
        }
        if (str != null) {
            return str;
        }
        return "";
    }

    public final int getFollowNum() {
        return this.followNum;
    }

    public final void setFollowNumFormat(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "followNumFormat");
        this.followNum = i;
        this.followNumFormat = str;
    }

    public final String getVisitNumFormat() {
        Live live = getLive();
        if (live == null) {
            return "";
        }
        String str = this.visitNumFormat;
        if (str == null) {
            str = live.getVisitNumFormat();
            this.visitNum = live.getVisitNum();
            this.visitNumFormat = str;
        }
        if (str != null) {
            return str;
        }
        return "";
    }

    public final void setVisitNumFormat(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "visitNumFormat");
        if (i >= this.visitNum) {
            this.visitNum = i;
            this.visitNumFormat = str;
        }
    }

    public final void setFollowLive(boolean z) {
        this.followLive = Boolean.valueOf(z);
    }

    public final boolean isFollowLive() {
        Live live = getLive();
        if (live == null) {
            return false;
        }
        Boolean bool = this.followLive;
        if (bool == null) {
            bool = Boolean.valueOf(live.isFollow());
            this.followLive = bool;
        }
        return bool.booleanValue();
    }

    public final String getPopulateNumFormat() {
        int liveStatus = getLiveStatus();
        if (liveStatus != -1) {
            if (liveStatus == 0) {
                return getFollowNumFormat();
            }
            if (liveStatus != 1) {
                return "";
            }
        }
        return getVisitNumFormat();
    }

    public final Live getLive() {
        return this.presenter.getLive();
    }

    public final boolean isLiveStart() {
        return getLiveStatus() == 1;
    }

    public final boolean isLiveClosed() {
        return getLiveStatus() == -1;
    }

    public final boolean isLiveNotStart() {
        return getLiveStatus() == 0;
    }

    public final int getLiveStatus() {
        Live live = getLive();
        if (live != null) {
            return live.getLiveStatus();
        }
        return 0;
    }

    public final void setDiscussNumFormat(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "discussNumFormat");
        if (i >= this.discussNum) {
            this.discussNum = i;
            this.discussNumFormat = str;
        }
    }

    private final String getDiscussNumFormat() {
        Live live = getLive();
        String str = "";
        if (live == null) {
            return str;
        }
        String str2 = this.discussNumFormat;
        if (str2 != null) {
            return str2;
        }
        String discussNumFormat2 = live.getDiscussNumFormat();
        if (discussNumFormat2 != null) {
            str = discussNumFormat2;
        }
        this.discussNum = live.getDiscussNum();
        this.discussNumFormat = str;
        return str;
    }

    public final String getDiscussTabTitle() {
        if (!(getDiscussNumFormat().length() > 0)) {
            return "聊天室";
        }
        return getDiscussNumFormat() + "讨论";
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001a: APUT  (r0v3 java.lang.String[]), (1 ??[boolean, int, float, short, byte, char]), (r2v2 java.lang.String) */
    public final String[] getViewPageTitles() {
        String str;
        boolean z = false;
        if (getLive() == null) {
            return new String[0];
        }
        String[] strArr = new String[6];
        strArr[0] = "简介";
        strArr[1] = isLiveClosed() ? "回顾" : "直播";
        if (getDiscussNumFormat().length() > 0) {
            z = true;
        }
        if (z) {
            str = getDiscussNumFormat() + "讨论";
        } else {
            str = "聊天室";
        }
        strArr[2] = str;
        strArr[3] = "数码吧";
        strArr[4] = "话题";
        strArr[5] = "相关";
        return strArr;
    }

    public final String getLivePopulateString() {
        if (getLive() == null) {
            return "";
        }
        if (getLiveStatus() == 0) {
            return getPopulateNumFormat() + " 人预约";
        }
        return getPopulateNumFormat() + " 人气";
    }

    public final String getLiveShowTimeString() {
        Live live = getLive();
        if (live == null) {
            return "";
        }
        int liveType = getLiveType();
        if (liveType == 1) {
            return "图文直播时间: " + live.getShowLiveTime();
        } else if (liveType != 2) {
            return "";
        } else {
            return "视频直播时间: " + live.getShowLiveTime();
        }
    }

    public final String getLiveSubscribeStateString() {
        return isFollowLive() ? "成功预约提醒" : "直播前提醒我";
    }

    public final int getLiveSubscribeStateBackground() {
        return isFollowLive() ? 2131231744 : 2131231743;
    }

    public final int getLiveStatusSimpleColor() {
        int liveStatus = getLiveStatus();
        if (liveStatus == -1) {
            return Color.parseColor("#BDBDBD");
        }
        if (liveStatus == 0) {
            return Color.parseColor("#2196F3");
        }
        if (liveStatus != 1) {
            return 0;
        }
        return Color.parseColor("#0F9D58");
    }

    public final String getLiveStatusSimpleString() {
        int liveStatus = getLiveStatus();
        if (liveStatus == -1) {
            if (getLiveType() == 2) {
                Live live = getLive();
                if (!TextUtils.isEmpty(live != null ? live.getVideoPlaybackUrl() : null)) {
                    return "直播回放";
                }
            }
            return "已结束";
        } else if (liveStatus != 0) {
            return liveStatus != 1 ? "" : "直播中";
        } else {
            return "未开始";
        }
    }

    public final String getLiveStatusString() {
        int liveType = getLiveType();
        if (liveType != 1) {
            return liveType != 2 ? "" : "直播中";
        }
        return "图文直播中";
    }

    public final int getLiveType() {
        Live live = getLive();
        if (live != null) {
            return (!TextUtils.isEmpty(live.getVideoLiveUrl()) || !TextUtils.isEmpty(live.getVideoPlaybackUrl())) ? 2 : 1;
        }
        return 0;
    }

    public final String getLiveTypeString() {
        int liveType = getLiveType();
        if (liveType != 1) {
            return liveType != 2 ? "" : "视频直播";
        }
        return "文字直播";
    }

    public final boolean currentUserIsPresenter() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String uid = loginSession.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "DataManager.getInstance().loginSession.uid");
        return isPresenter(uid);
    }

    public final boolean isPresenter(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        Live live = getLive();
        if (live != null) {
            return LiveUtils.INSTANCE.isPresenter(live, str);
        }
        return false;
    }
}
