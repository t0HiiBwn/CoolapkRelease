package com.coolapk.market.view.video;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.FloatWindowUtil;
import com.coolapk.market.util.SettingsCompat;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.FloatWindowBridge;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.receiver.GroupValue;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.render.AspectRatio;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\r\u0010/\u001a\u00020,H\u0010¢\u0006\u0002\b0J\u0017\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0010¢\u0006\u0002\b3J\b\u00104\u001a\u00020,H\u0016J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\b\u00108\u001a\u00020\u001cH\u0016J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;H\u0016J'\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020>2\u0010\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@H\u0016¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u001cH\u0016J\u0010\u0010F\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010G\u001a\u00020,H\u0016J\u001a\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020,H\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8@X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006N"}, d2 = {"Lcom/coolapk/market/view/video/BaseVideoDetailViewPart;", "B", "Landroidx/databinding/ViewDataBinding;", "DATA", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "assist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "getAssist$presentation_coolapkAppRelease", "()Lcom/kk/taurus/playerbase/assist/RelationAssist;", "setAssist$presentation_coolapkAppRelease", "(Lcom/kk/taurus/playerbase/assist/RelationAssist;)V", "audioManager", "Landroid/media/AudioManager;", "data", "Lcom/coolapk/market/widget/video/VideoModel;", "getData$presentation_coolapkAppRelease", "()Lcom/coolapk/market/widget/video/VideoModel;", "setData$presentation_coolapkAppRelease", "(Lcom/coolapk/market/widget/video/VideoModel;)V", "detailActivity", "Lcom/coolapk/market/view/video/VideoDetailListActivity;", "isAvailable", "", "isAvailable$presentation_coolapkAppRelease", "()Z", "isLandScape", "isLandScape$presentation_coolapkAppRelease", "setLandScape$presentation_coolapkAppRelease", "(Z)V", "onAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "player", "Lcom/coolapk/market/widget/video/SharedPlayer;", "receiverGroup", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup;", "getReceiverGroup$presentation_coolapkAppRelease", "()Lcom/kk/taurus/playerbase/receiver/IReceiverGroup;", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "attachPlayerBridge", "attachPlayerBridge$presentation_coolapkAppRelease", "detachPlayerBridge", "sourceBridge", "detachPlayerBridge$presentation_coolapkAppRelease", "enterFloatingWindows", "handleActivityPause", "handleActivityResume", "handleActivityStop", "handleBackPress", "handleConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onAction", "actionType", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onAnimationEvent", "isOpenAnimation", "isStartEvent", "onAttach", "onDetach", "onEvent", "eventCode", "", "bundle", "Landroid/os/Bundle;", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseVideoDetailViewPart.kt */
public abstract class BaseVideoDetailViewPart<B extends ViewDataBinding, DATA> extends BindingViewPart<B, DATA> implements VideoPlayerBridge {
    private final Activity activity;
    public RelationAssist assist;
    private AudioManager audioManager;
    private VideoModel data = VideoModel.Companion.getNO_VIDEO();
    private final VideoDetailListActivity detailActivity;
    private boolean isLandScape;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
    private SharedPlayer player;

    public void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAction(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "actionType");
    }

    public void onAnimationEvent(boolean z, boolean z2) {
    }

    public BaseVideoDetailViewPart(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.coolapk.market.view.video.VideoDetailListActivity");
        this.detailActivity = (VideoDetailListActivity) activity2;
    }

    public static final /* synthetic */ SharedPlayer access$getPlayer$p(BaseVideoDetailViewPart baseVideoDetailViewPart) {
        SharedPlayer sharedPlayer = baseVideoDetailViewPart.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return sharedPlayer;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final VideoModel getData$presentation_coolapkAppRelease() {
        return this.data;
    }

    public final void setData$presentation_coolapkAppRelease(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "<set-?>");
        this.data = videoModel;
    }

    public final boolean isLandScape$presentation_coolapkAppRelease() {
        return this.isLandScape;
    }

    public final void setLandScape$presentation_coolapkAppRelease(boolean z) {
        this.isLandScape = z;
    }

    public final RelationAssist getAssist$presentation_coolapkAppRelease() {
        RelationAssist relationAssist = this.assist;
        if (relationAssist == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assist");
        }
        return relationAssist;
    }

    public final void setAssist$presentation_coolapkAppRelease(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "<set-?>");
        this.assist = relationAssist;
    }

    public final IReceiverGroup getReceiverGroup$presentation_coolapkAppRelease() {
        RelationAssist relationAssist = this.assist;
        if (relationAssist == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assist");
        }
        IReceiverGroup receiverGroup = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup, "assist.receiverGroup");
        return receiverGroup;
    }

    public final boolean isAvailable$presentation_coolapkAppRelease() {
        BaseVideoDetailViewPart<B, DATA> baseVideoDetailViewPart = this;
        if (baseVideoDetailViewPart.player != null) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            if (Intrinsics.areEqual(sharedPlayer.getPlayerBridge(), baseVideoDetailViewPart)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        Object systemService = this.detailActivity.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
    }

    public void attachPlayerBridge$presentation_coolapkAppRelease() {
        SharedPlayer sharedPlayer = VideoManager.INSTANCE.getSharedPlayer();
        this.player = sharedPlayer;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        if (Intrinsics.areEqual(sharedPlayer.getVideoModel(), this.data)) {
            SharedPlayer sharedPlayer2 = this.player;
            if (sharedPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer2.attachPlayerBridge(this);
            return;
        }
        SharedPlayer sharedPlayer3 = this.player;
        if (sharedPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer3.attachPlayerBridge(this);
        SharedPlayer sharedPlayer4 = this.player;
        if (sharedPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer4.resume();
    }

    public void detachPlayerBridge$presentation_coolapkAppRelease(VideoPlayerBridge videoPlayerBridge) {
        if (!isAvailable$presentation_coolapkAppRelease()) {
            return;
        }
        if (videoPlayerBridge != null) {
            getReceiverGroup$presentation_coolapkAppRelease().getGroupValue().putBoolean("reset_when_mobile_network", true);
            VideoPlayerBridge.DefaultImpls.onAction$default(videoPlayerBridge, "show_pause_cover", null, 2, null);
            AppHolder.getMainThreadHandler().postDelayed(new BaseVideoDetailViewPart$detachPlayerBridge$1(this, videoPlayerBridge), 50);
            return;
        }
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer.detachPlayerBridge();
    }

    public boolean handleBackPress() {
        if (!this.isLandScape) {
            return false;
        }
        this.activity.setRequestedOrientation(1);
        return true;
    }

    public void handleConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        if (isAvailable$presentation_coolapkAppRelease()) {
            this.isLandScape = configuration.orientation == 2;
            getReceiverGroup$presentation_coolapkAppRelease().getGroupValue().putBoolean("isLandscape", this.isLandScape);
            if (this.isLandScape) {
                RelationAssist relationAssist = this.assist;
                if (relationAssist == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assist");
                }
                relationAssist.setAspectRatio(AspectRatio.AspectRatio_FIT_PARENT);
                return;
            }
            RelationAssist relationAssist2 = this.assist;
            if (relationAssist2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assist");
            }
            relationAssist2.setAspectRatio(AspectRatio.AspectRatio_FILL_WIDTH);
        }
    }

    public final void handleActivityResume() {
        if (isAvailable$presentation_coolapkAppRelease()) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.tryAutoResume();
        }
    }

    public final void handleActivityPause() {
        if (!this.activity.isFinishing() && isAvailable$presentation_coolapkAppRelease()) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.pause();
        }
    }

    public final void handleActivityStop() {
        if (!this.activity.isFinishing() && isAvailable$presentation_coolapkAppRelease()) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.reset();
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer.setHandleByActivity(true);
        this.assist = relationAssist;
        Resources resources = this.activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        boolean z = resources.getConfiguration().orientation == 2;
        this.isLandScape = z;
        if (z) {
            relationAssist.setAspectRatio(AspectRatio.AspectRatio_FIT_PARENT);
        } else {
            relationAssist.setAspectRatio(AspectRatio.AspectRatio_FILL_WIDTH);
        }
        GroupValue groupValue = getReceiverGroup$presentation_coolapkAppRelease().getGroupValue();
        groupValue.putBoolean("controller_top_enable", true);
        groupValue.putBoolean("user_click_started", true);
        groupValue.putBoolean("reset_when_mobile_network", false);
        groupValue.putBoolean("isLandscape", this.isLandScape);
        AudioManager audioManager2 = this.audioManager;
        if (audioManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        }
        audioManager2.requestAudioFocus(this.onAudioFocusChangeListener, 3, 2);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onDetach() {
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer.setHandleByActivity(false);
        AudioManager audioManager2 = this.audioManager;
        if (audioManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        }
        audioManager2.abandonAudioFocus(this.onAudioFocusChangeListener);
        this.activity.finishAfterTransition();
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onEvent(int i, Bundle bundle) {
        if (i != -124) {
            if (i == -123) {
                Toast.show$default(this.activity, "等待处理", 0, false, 12, null);
            } else if (i == -107) {
                Entity relatedEntity = this.data.getRelatedEntity();
                if (relatedEntity != null) {
                    ActionManager.shareText(this.activity, relatedEntity);
                }
            } else if (i == -104) {
                this.activity.setRequestedOrientation(this.isLandScape ? 1 : 0);
            } else if (i == -100) {
                this.activity.onBackPressed();
            }
        } else if (!SettingsCompat.canDrawOverlays(getContext())) {
            FloatWindowUtil.INSTANCE.showNeedFloatingPermissionDialog(this.detailActivity);
        } else {
            enterFloatingWindows();
        }
    }

    public void enterFloatingWindows() {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Application application2 = application;
        VideoModel videoModel = this.data;
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        FloatWindowBridge floatWindowBridge = new FloatWindowBridge(application2, videoModel, sharedPlayer.getRenderAspect());
        this.detailActivity.startCloseToFloatBridge(floatWindowBridge);
        AppHolder.getMainThreadHandler().postDelayed(new BaseVideoDetailViewPart$enterFloatingWindows$1(floatWindowBridge), 400);
    }
}
