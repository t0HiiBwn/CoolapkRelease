package com.coolapk.market.widget.video;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.cover.CompleteCover;
import com.coolapk.market.widget.video.cover.ControllerCover;
import com.coolapk.market.widget.video.cover.ErrorCover;
import com.coolapk.market.widget.video.cover.GestureCover;
import com.coolapk.market.widget.video.cover.LoadingCover;
import com.coolapk.market.widget.video.cover.SimpleControllerCover;
import com.coolapk.market.widget.video.cover.ThemeableCover;
import com.coolapk.market.widget.video.util.FixTouchSuperContainer;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;
import com.kk.taurus.playerbase.receiver.BaseCover;
import com.kk.taurus.playerbase.receiver.GroupValue;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.OnReceiverEventListener;
import com.kk.taurus.playerbase.receiver.ReceiverGroup;
import com.kk.taurus.playerbase.render.IRender;
import com.kk.taurus.playerbase.widget.SuperContainer;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001PB\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001eJ\u000e\u0010/\u001a\u00020-2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020-J\u0006\u00103\u001a\u00020-J\u0010\u00104\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u00020\u0007J\u0006\u00106\u001a\u000207J\b\u00108\u001a\u0004\u0018\u000109J\b\u0010:\u001a\u00020\u001cH\u0002J\u0006\u0010;\u001a\u00020\u000fJ\b\u0010<\u001a\u00020\u000fH\u0002J\u0016\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070@H\u0002J\u001a\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001c2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010E\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001c2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010F\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001c2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0006\u0010G\u001a\u00020-J\u0006\u0010H\u001a\u00020-J\u0006\u0010I\u001a\u00020-J\u0014\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020L0KH\u0002J\b\u0010M\u001a\u00020-H\u0002J\u0006\u0010N\u001a\u00020-J\u0006\u0010O\u001a\u00020-R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020$@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006Q"}, d2 = {"Lcom/coolapk/market/widget/video/SharedPlayer;", "Lcom/kk/taurus/playerbase/event/OnErrorEventListener;", "Lcom/kk/taurus/playerbase/event/OnPlayerEventListener;", "Lcom/kk/taurus/playerbase/receiver/OnReceiverEventListener;", "()V", "coverMap", "Ljava/util/HashMap;", "", "Lcom/kk/taurus/playerbase/receiver/BaseCover;", "Lkotlin/collections/HashMap;", "dataProvider", "Lcom/coolapk/market/widget/video/CoolApkDataProvider;", "groupValueUpdateListener", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup$OnGroupValueUpdateListener;", "isBackgroundPlaying", "", "()Z", "setBackgroundPlaying", "(Z)V", "isFloatingScreen", "setFloatingScreen", "isHandleByActivity", "setHandleByActivity", "isInForeground", "isPausedByUser", "isPlayerReset", "isRenderStarted", "liveRetryRemainCount", "", "<set-?>", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "playerBridge", "getPlayerBridge", "()Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "relationAssist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "Lcom/coolapk/market/widget/video/VideoModel;", "videoModel", "getVideoModel", "()Lcom/coolapk/market/widget/video/VideoModel;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "attachPlayerBridge", "", "bridge", "changeAppTheme", "appTheme", "Lcom/coolapk/market/AppTheme;", "destroy", "detachPlayerBridge", "getOrCreateCover", "coverKey", "getRenderAspect", "", "getRenderingBitmap", "Landroid/graphics/Bitmap;", "getState", "isInPlaybackState", "isPlaying", "obtainReceiverGroup", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup;", "coverKeys", "", "onErrorEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onReceiverEvent", "pause", "reset", "resume", "saveReceiverGroupKeys", "", "", "tmpDetachPlayerBridge", "tryAutoResume", "tryFixAutoPlayBug", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SharedPlayer.kt */
public final class SharedPlayer implements OnErrorEventListener, OnPlayerEventListener, OnReceiverEventListener {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_RETRY_COUNT_IF_WHEN_LIVE = 3;
    private final HashMap<String, BaseCover> coverMap = new HashMap<>();
    private final CoolApkDataProvider dataProvider;
    private final IReceiverGroup.OnGroupValueUpdateListener groupValueUpdateListener;
    private boolean isBackgroundPlaying;
    private boolean isFloatingScreen;
    private boolean isHandleByActivity;
    private boolean isPausedByUser;
    private boolean isPlayerReset = true;
    private boolean isRenderStarted;
    private int liveRetryRemainCount = 3;
    private VideoPlayerBridge playerBridge;
    private RelationAssist relationAssist;
    private VideoModel videoModel = VideoModel.Companion.getNO_VIDEO();

    public SharedPlayer() {
        CoolApkDataProvider coolApkDataProvider = new CoolApkDataProvider(true, false);
        this.dataProvider = coolApkDataProvider;
        Application application = AppHolder.getApplication();
        Application application2 = application;
        Intrinsics.checkNotNullExpressionValue(application, "appContext");
        this.relationAssist = new RelationAssist(application2, new FixTouchSuperContainer(application2));
        SharedPlayer sharedPlayer = this;
        this.relationAssist.setEventAssistHandler(new SharedPlayer$internalEventAssistHandler$1(this));
        this.relationAssist.setOnPlayerEventListener(sharedPlayer);
        this.relationAssist.setOnErrorEventListener(sharedPlayer);
        this.relationAssist.setOnReceiverEventListener(sharedPlayer);
        this.relationAssist.setDataProvider(coolApkDataProvider);
        this.groupValueUpdateListener = new IReceiverGroup.OnGroupValueUpdateListener(this) {
            /* class com.coolapk.market.widget.video.SharedPlayer.AnonymousClass1 */
            final /* synthetic */ SharedPlayer this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
            public String[] filterKeys() {
                return new String[]{"need_mute"};
            }

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
            public void onValueUpdate(String str, Object obj) {
                Intrinsics.checkNotNullParameter(str, "key");
                if (str.hashCode() == 1076260898 && str.equals("need_mute")) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) obj).booleanValue()) {
                        this.this$0.relationAssist.setVolume(0.0f, 0.0f);
                    } else {
                        this.this$0.relationAssist.setVolume(1.0f, 1.0f);
                    }
                }
            }
        };
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/widget/video/SharedPlayer$Companion;", "", "()V", "MAX_RETRY_COUNT_IF_WHEN_LIVE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SharedPlayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final View getView() {
        SuperContainer superContainer = this.relationAssist.getSuperContainer();
        Intrinsics.checkNotNullExpressionValue(superContainer, "relationAssist.superContainer");
        return superContainer;
    }

    public final boolean isHandleByActivity() {
        return this.isHandleByActivity;
    }

    public final void setHandleByActivity(boolean z) {
        this.isHandleByActivity = z;
    }

    public final boolean isBackgroundPlaying() {
        return this.isBackgroundPlaying;
    }

    public final void setBackgroundPlaying(boolean z) {
        this.isBackgroundPlaying = z;
    }

    public final boolean isFloatingScreen() {
        return this.isFloatingScreen;
    }

    public final void setFloatingScreen(boolean z) {
        this.isFloatingScreen = z;
    }

    public final boolean isInForeground() {
        return this.isBackgroundPlaying || this.isFloatingScreen;
    }

    public final VideoModel getVideoModel() {
        return this.videoModel;
    }

    public final VideoPlayerBridge getPlayerBridge() {
        return this.playerBridge;
    }

    @Override // com.kk.taurus.playerbase.event.OnErrorEventListener
    public void onErrorEvent(int i, Bundle bundle) {
        Serializable serializable;
        if (i == -88011) {
            if (bundle != null) {
                bundle.getInt("int_arg1");
            }
            if (bundle != null) {
                bundle.getInt("int_arg2");
            }
            this.dataProvider.invalidVideoModelResult(this.videoModel);
        } else if (i == -88000) {
            Throwable th = null;
            if (bundle != null) {
                serializable = bundle.getSerializable("serializable_extra_data");
            } else {
                serializable = null;
            }
            if (serializable instanceof Throwable) {
                th = serializable;
            }
            Throwable th2 = th;
            if (th2 != null) {
                Toast.error(AppHolder.getApplication(), th2);
            }
            this.dataProvider.invalidVideoModelResult(this.videoModel);
        }
        VideoPlayerBridge videoPlayerBridge = this.playerBridge;
        if (videoPlayerBridge != null) {
            videoPlayerBridge.onEvent(i, bundle);
        }
    }

    @Override // com.kk.taurus.playerbase.event.OnPlayerEventListener
    public void onPlayerEvent(int i, Bundle bundle) {
        int i2;
        Integer num = null;
        GroupValue groupValue = null;
        switch (i) {
            case -99031:
                if (this.playerBridge != null) {
                    SuperContainer superContainer = this.relationAssist.getSuperContainer();
                    if (bundle != null) {
                        num = Integer.valueOf(bundle.getInt("int_data"));
                    }
                    if (num == null || num.intValue() != 4) {
                        if (num == null || num.intValue() != 3) {
                            if ((num != null && num.intValue() == 0) || ((num != null && num.intValue() == -1) || ((num != null && num.intValue() == 5) || (num != null && num.intValue() == 6)))) {
                                Intrinsics.checkNotNullExpressionValue(superContainer, "view");
                                superContainer.setKeepScreenOn(false);
                                break;
                            }
                        } else {
                            Intrinsics.checkNotNullExpressionValue(superContainer, "view");
                            superContainer.setKeepScreenOn(true);
                            break;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(superContainer, "view");
                        superContainer.setKeepScreenOn(false);
                        break;
                    }
                } else {
                    return;
                }
                break;
            case -99019:
                if (bundle != null && this.videoModel.isValid()) {
                    int i3 = bundle.getInt("int_arg1");
                    if (bundle.getInt("int_arg2") > 0) {
                        VideoManager.INSTANCE.getProgressMap().put(this.videoModel.getKey(), i3);
                        break;
                    }
                } else {
                    return;
                }
                break;
            case -99016:
                if (this.videoModel.isValid()) {
                    if (this.videoModel.isLive() && (i2 = this.liveRetryRemainCount) > 0) {
                        this.liveRetryRemainCount = i2 - 1;
                        this.relationAssist.rePlay(VideoManager.INSTANCE.getProgressMap().get(this.videoModel.getKey()));
                        break;
                    } else {
                        VideoManager.INSTANCE.getProgressMap().delete(this.videoModel.getKey());
                        break;
                    }
                } else {
                    return;
                }
                break;
            case -99015:
                this.isRenderStarted = true;
                break;
            case -99008:
                this.isPlayerReset = true;
                break;
            case -99004:
                this.isPlayerReset = false;
                break;
            case -99001:
                Serializable serializable = bundle != null ? bundle.getSerializable("serializable_data") : null;
                Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.kk.taurus.playerbase.entity.DataSource");
                DataSource dataSource = (DataSource) serializable;
                IReceiverGroup receiverGroup = this.relationAssist.getReceiverGroup();
                if (receiverGroup != null) {
                    groupValue = receiverGroup.getGroupValue();
                }
                if (groupValue != null) {
                    groupValue.putObject("data_source", dataSource);
                    groupValue.putObject("need_mute", Boolean.valueOf(groupValue.getBoolean("need_mute")));
                    break;
                }
                break;
        }
        VideoPlayerBridge videoPlayerBridge = this.playerBridge;
        if (videoPlayerBridge != null) {
            videoPlayerBridge.onEvent(i, bundle);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.OnReceiverEventListener
    public void onReceiverEvent(int i, Bundle bundle) {
        GroupValue groupValue;
        boolean z = true;
        switch (i) {
            case -122:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity() ?: return");
                    IReceiverGroup receiverGroup = this.relationAssist.getReceiverGroup();
                    String string = (receiverGroup == null || (groupValue = receiverGroup.getGroupValue()) == null) ? null : groupValue.getString("view_source_url");
                    String str = string;
                    if (!(str == null || str.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        ActionManagerCompat.startActivityByUrl$default(currentActivity, string, null, null, 12, null);
                        break;
                    }
                } else {
                    return;
                }
                break;
            case -121:
                this.isPausedByUser = false;
                break;
            case -120:
                this.isPausedByUser = true;
                break;
        }
        VideoPlayerBridge videoPlayerBridge = this.playerBridge;
        if (videoPlayerBridge != null) {
            videoPlayerBridge.onEvent(i, bundle);
        }
    }

    public final void attachPlayerBridge(VideoPlayerBridge videoPlayerBridge) {
        UserAction userAction;
        Intrinsics.checkNotNullParameter(videoPlayerBridge, "bridge");
        PlayerArg playerArg = videoPlayerBridge.getPlayerArg();
        ViewGroup container = playerArg.getContainer();
        VideoModel videoModel2 = playerArg.getVideoModel();
        boolean z = !Intrinsics.areEqual(this.videoModel, videoModel2);
        this.liveRetryRemainCount = 3;
        if (z) {
            detachPlayerBridge();
            StatisticHelper.Companion.getInstance().recordVideoClickAction("视频开始播放");
        } else {
            tmpDetachPlayerBridge();
        }
        this.playerBridge = videoPlayerBridge;
        Feed feed = null;
        Map<String, Object> saveReceiverGroupKeys = !z ? saveReceiverGroupKeys() : null;
        IReceiverGroup obtainReceiverGroup = obtainReceiverGroup(playerArg.getCoverKeys());
        this.relationAssist.setReceiverGroup(obtainReceiverGroup);
        videoPlayerBridge.onAttach(this.relationAssist);
        GroupValue groupValue = obtainReceiverGroup.getGroupValue();
        groupValue.putBoolean("network_resource", videoModel2.isNetworkResource());
        groupValue.putString("view_source_url", videoModel2.getSourceUrl());
        groupValue.putBoolean("share_view_visible", videoModel2.isUserSharedFeed());
        groupValue.putBoolean("isLive", videoModel2.isLive());
        Entity relatedEntity = videoModel2.getRelatedEntity();
        if (relatedEntity instanceof Feed) {
            feed = relatedEntity;
        }
        Feed feed2 = feed;
        groupValue.putBoolean("isCollected", (feed2 == null || (userAction = feed2.getUserAction()) == null || userAction.getFavorite() != 1) ? false : true);
        groupValue.putBoolean("can_redirect_source", videoModel2.isRedirectSource());
        if (saveReceiverGroupKeys != null) {
            for (Map.Entry<String, Object> entry : saveReceiverGroupKeys.entrySet()) {
                groupValue.putObject(entry.getKey(), entry.getValue());
            }
        }
        groupValue.putBoolean("need_mute", playerArg.getNeedMute());
        if (z || this.isPlayerReset) {
            this.dataProvider.addToPendingParseList(videoModel2);
            DataSource dataSource = VideoModelKt.toDataSource(videoModel2);
            int i = VideoManager.INSTANCE.getProgressMap().get(videoModel2.getKey());
            if (i > 0) {
                dataSource.setStartPos(i);
            }
            this.relationAssist.attachContainer(container, true);
            this.relationAssist.setDataSource(dataSource);
            this.relationAssist.play();
            this.isPlayerReset = false;
        } else {
            this.relationAssist.attachContainer(container);
        }
        this.videoModel = videoModel2;
    }

    public final boolean isInPlaybackState() {
        int state = getState();
        return state == 2 || state == 3 || state == 4 || state == 6;
    }

    private final boolean isPlaying() {
        return this.relationAssist.isPlaying();
    }

    private final int getState() {
        return this.relationAssist.getState();
    }

    public final void pause() {
        if (this.playerBridge != null) {
            int state = getState();
            if (state == 2 || state == 3) {
                this.relationAssist.pause();
            }
        }
    }

    public final void reset() {
        if (this.playerBridge != null && getState() != 6) {
            this.relationAssist.reset();
        }
    }

    public final void tryAutoResume() {
        if (!this.isPausedByUser) {
            resume();
        }
    }

    public final void resume() {
        if (this.playerBridge != null) {
            int state = getState();
            if (state != 0) {
                if (state == 1) {
                    return;
                }
                if (state == 2 || state == 3 || state == 4) {
                    this.relationAssist.resume();
                } else if (state != 6) {
                    this.relationAssist.rePlay(VideoManager.INSTANCE.getProgressMap().get(this.videoModel.getKey()));
                }
            } else if (this.isPlayerReset) {
                this.relationAssist.rePlay(VideoManager.INSTANCE.getProgressMap().get(this.videoModel.getKey()));
            }
        }
    }

    private final void tmpDetachPlayerBridge() {
        VideoPlayerBridge videoPlayerBridge = this.playerBridge;
        if (videoPlayerBridge != null) {
            this.playerBridge = null;
            videoPlayerBridge.getPlayerArg().getContainer().removeAllViews();
            videoPlayerBridge.onDetach();
        }
    }

    public final void detachPlayerBridge() {
        VideoPlayerBridge videoPlayerBridge = this.playerBridge;
        if (videoPlayerBridge != null) {
            this.playerBridge = null;
            videoPlayerBridge.getPlayerArg().getContainer().removeAllViews();
            videoPlayerBridge.onDetach();
            this.liveRetryRemainCount = 0;
            this.isPausedByUser = false;
            this.relationAssist.setReceiverGroup(null);
            this.relationAssist.reset();
            this.videoModel = VideoModel.Companion.getNO_VIDEO();
        }
    }

    public final void destroy() {
        detachPlayerBridge();
        tryFixAutoPlayBug();
        this.relationAssist.destroy();
        VideoManager.INSTANCE.destroySharedPlayer$presentation_coolapkAppRelease(this);
    }

    public final Bitmap getRenderingBitmap() {
        if (this.isRenderStarted) {
            IRender render = this.relationAssist.getRender();
            Intrinsics.checkNotNullExpressionValue(render, "relationAssist.render");
            View renderView = render.getRenderView();
            if (!(renderView instanceof TextureView)) {
                renderView = null;
            }
            TextureView textureView = (TextureView) renderView;
            if (textureView != null) {
                return textureView.getBitmap();
            }
        }
        return null;
    }

    public final float getRenderAspect() {
        float width;
        int height;
        if (this.isRenderStarted) {
            IRender render = this.relationAssist.getRender();
            Intrinsics.checkNotNullExpressionValue(render, "relationAssist.render");
            View renderView = render.getRenderView();
            if (!(renderView instanceof TextureView)) {
                renderView = null;
            }
            TextureView textureView = (TextureView) renderView;
            if (textureView != null) {
                if (textureView.getRotation() == 90.0f) {
                    width = (float) textureView.getHeight();
                    height = textureView.getWidth();
                } else {
                    width = (float) textureView.getWidth();
                    height = textureView.getHeight();
                }
                return width / ((float) height);
            }
        }
        return 1.7777778f;
    }

    private final Map<String, Object> saveReceiverGroupKeys() {
        IReceiverGroup receiverGroup = this.relationAssist.getReceiverGroup();
        GroupValue groupValue = receiverGroup != null ? receiverGroup.getGroupValue() : null;
        HashMap hashMap = new HashMap();
        if (groupValue != null) {
            String[] strArr = {"loading_show", "data_source", "complete_show", "last_error_state", "last_error_extra", "ignore_following_network_event", "reset_when_mobile_network", "error_show"};
            for (int i = 0; i < 8; i++) {
                String str = strArr[i];
                Object obj = groupValue.get(str);
                if (obj != null) {
                    hashMap.put(str, obj);
                }
            }
        }
        return hashMap;
    }

    private final IReceiverGroup obtainReceiverGroup(Set<String> set) {
        ReceiverGroup receiverGroup = new ReceiverGroup();
        for (T t : set) {
            BaseCover orCreateCover = getOrCreateCover(t);
            if (orCreateCover != null) {
                receiverGroup.addReceiver(t, orCreateCover);
            }
        }
        receiverGroup.getGroupValue().registerOnGroupValueUpdateListener(this.groupValueUpdateListener);
        return receiverGroup;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final BaseCover getOrCreateCover(String str) {
        SimpleControllerCover simpleControllerCover;
        Intrinsics.checkNotNullParameter(str, "coverKey");
        if (this.coverMap.containsKey(str)) {
            BaseCover baseCover = this.coverMap.get(str);
            Intrinsics.checkNotNull(baseCover);
            return baseCover;
        }
        Application application = AppHolder.getApplication();
        switch (str.hashCode()) {
            case -1777143720:
                if (str.equals("simeple_controller_cover")) {
                    Intrinsics.checkNotNullExpressionValue(application, "appContext");
                    simpleControllerCover = new SimpleControllerCover(application);
                    break;
                }
                simpleControllerCover = null;
                break;
            case -833297728:
                if (str.equals("error_cover")) {
                    Intrinsics.checkNotNullExpressionValue(application, "appContext");
                    simpleControllerCover = new ErrorCover(application);
                    break;
                }
                simpleControllerCover = null;
                break;
            case 477623636:
                if (str.equals("controller_cover")) {
                    Intrinsics.checkNotNullExpressionValue(application, "appContext");
                    simpleControllerCover = new ControllerCover(application);
                    break;
                }
                simpleControllerCover = null;
                break;
            case 536295745:
                if (str.equals("gesture_cover")) {
                    Intrinsics.checkNotNullExpressionValue(application, "appContext");
                    simpleControllerCover = new GestureCover(application);
                    break;
                }
                simpleControllerCover = null;
                break;
            case 803060468:
                if (str.equals("loading_cover")) {
                    Intrinsics.checkNotNullExpressionValue(application, "appContext");
                    simpleControllerCover = new LoadingCover(application);
                    break;
                }
                simpleControllerCover = null;
                break;
            case 1424185649:
                if (str.equals("complete_cover")) {
                    Intrinsics.checkNotNullExpressionValue(application, "appContext");
                    simpleControllerCover = new CompleteCover(application);
                    break;
                }
                simpleControllerCover = null;
                break;
            default:
                simpleControllerCover = null;
                break;
        }
        if (simpleControllerCover != null) {
            this.coverMap.put(str, simpleControllerCover);
        }
        return simpleControllerCover;
    }

    public final void changeAppTheme(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        Collection<BaseCover> values = this.coverMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "coverMap.values");
        for (T t : values) {
            if (t instanceof ThemeableCover) {
                t.onThemeChange(appTheme);
            }
        }
    }

    public final void tryFixAutoPlayBug() {
        if (this.playerBridge == null) {
            this.relationAssist.reset();
        }
    }
}
