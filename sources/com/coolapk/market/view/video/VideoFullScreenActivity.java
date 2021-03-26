package com.coolapk.market.view.video;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.VideoFullScreenBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.FloatWindowUtil;
import com.coolapk.market.util.NotchUtil;
import com.coolapk.market.util.SettingsCompat;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.FloatWindowBridge;
import com.coolapk.market.widget.video.PlayerArg;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import com.coolapk.market.widget.video.util.PIPUtils;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.receiver.GroupValue;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.render.AspectRatio;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001>B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0002J'\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0016¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u0019H\u0016J\u001a\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010/H\u0016J\b\u00105\u001a\u00020\u0019H\u0014J\u001a\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00108\u001a\u00020\u0019H\u0014J\b\u00109\u001a\u00020\u0019H\u0014J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u000203H\u0014J\b\u0010<\u001a\u00020\u0019H\u0014J\b\u0010=\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/coolapk/market/view/video/VideoFullScreenActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "assist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "audioManager", "Landroid/media/AudioManager;", "binding", "Lcom/coolapk/market/databinding/VideoFullScreenBinding;", "hasEnterPIP", "", "isAvailable", "()Z", "isLandScape", "onAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "player", "Lcom/coolapk/market/widget/video/SharedPlayer;", "receiverGroup", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup;", "videoModel", "Lcom/coolapk/market/widget/video/VideoModel;", "attachPlayerBridge", "", "detachPlayerBridge", "enterFloatingWindows", "finish", "getPlayerArg", "Lcom/coolapk/market/widget/video/PlayerArg;", "isNavigationBarTranslucent", "magicalAnimationCompat", "onAction", "actionType", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onAttach", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onEvent", "eventCode", "", "bundle", "onPause", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "onResume", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "onStop", "requestFinish", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoFullScreenActivity.kt */
public final class VideoFullScreenActivity extends BaseActivity implements VideoPlayerBridge, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_TRANSITION_NAME = "videoShare";
    public static final String EXTRA_VIDEO_MODEL = "extra_video_model";
    public static final String EXTRA_VIDEO_RECT = "extra_video_rect";
    public static final String EXTRA_VIDEO_SOURCE_BRIDGE_KEY = "extra_video_source_bridge_key";
    private RelationAssist assist;
    private AudioManager audioManager;
    private VideoFullScreenBinding binding;
    private boolean hasEnterPIP;
    private boolean isLandScape;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
    private SharedPlayer player;
    private IReceiverGroup receiverGroup;
    private VideoModel videoModel;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAction(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "actionType");
    }

    public static final /* synthetic */ VideoFullScreenBinding access$getBinding$p(VideoFullScreenActivity videoFullScreenActivity) {
        VideoFullScreenBinding videoFullScreenBinding = videoFullScreenActivity.binding;
        if (videoFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return videoFullScreenBinding;
    }

    public static final /* synthetic */ SharedPlayer access$getPlayer$p(VideoFullScreenActivity videoFullScreenActivity) {
        SharedPlayer sharedPlayer = videoFullScreenActivity.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return sharedPlayer;
    }

    public static final /* synthetic */ VideoModel access$getVideoModel$p(VideoFullScreenActivity videoFullScreenActivity) {
        VideoModel videoModel2 = videoFullScreenActivity.videoModel;
        if (videoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoModel");
        }
        return videoModel2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/video/VideoFullScreenActivity$Companion;", "", "()V", "EXTRA_TRANSITION_NAME", "", "EXTRA_VIDEO_MODEL", "EXTRA_VIDEO_RECT", "EXTRA_VIDEO_SOURCE_BRIDGE_KEY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoFullScreenActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean isAvailable() {
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return Intrinsics.areEqual(sharedPlayer.getPlayerBridge(), this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        ThemeUtils.setSystemBarDrawFlags(this);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131559302);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…layout.video_full_screen)");
        this.binding = (VideoFullScreenBinding) contentView;
        setSlidrEnable(false);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_video_model");
        Intrinsics.checkNotNull(parcelableExtra);
        VideoModel videoModel2 = (VideoModel) parcelableExtra;
        this.videoModel = videoModel2;
        if (this.videoModel != null) {
            if (videoModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoModel");
            }
            if (videoModel2.isValid()) {
                this.player = VideoManager.INSTANCE.getSharedPlayer();
                Object systemService = getSystemService("audio");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                this.audioManager = (AudioManager) systemService;
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                activity.setRequestedOrientation(1);
                NotchUtil notchUtil = NotchUtil.INSTANCE;
                Window window = getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "window");
                notchUtil.blockStatusCutout(window);
                VideoFullScreenBinding videoFullScreenBinding = this.binding;
                if (videoFullScreenBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout = videoFullScreenBinding.videoContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
                linearLayout.setTransitionName("videoShare");
                VideoFullScreenBinding videoFullScreenBinding2 = this.binding;
                if (videoFullScreenBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                videoFullScreenBinding2.contentView.addOnInsetChangeListener(new VideoFullScreenActivity$onCreate$2(this));
                attachPlayerBridge();
                return;
            }
        }
        throw new IllegalStateException("video model error");
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    private final void attachPlayerBridge() {
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer.setHandleByActivity(true);
        SharedPlayer sharedPlayer2 = this.player;
        if (sharedPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        VideoModel videoModel2 = sharedPlayer2.getVideoModel();
        VideoModel videoModel3 = this.videoModel;
        if (videoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoModel");
        }
        if (Intrinsics.areEqual(videoModel2, videoModel3)) {
            SharedPlayer sharedPlayer3 = this.player;
            if (sharedPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer3.attachPlayerBridge(this);
            return;
        }
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.getSharedElementEnterTransition().addListener(new VideoFullScreenActivity$attachPlayerBridge$1(this));
    }

    private final void detachPlayerBridge() {
        if (isAvailable()) {
            VideoPlayerBridge videoPlayerBridge = (VideoPlayerBridge) AppHolder.getWeakValue(getIntent().getStringExtra("extra_video_source_bridge_key"));
            if (videoPlayerBridge != null) {
                VideoPlayerBridge.DefaultImpls.onAction$default(videoPlayerBridge, "show_pause_cover", null, 2, null);
                IReceiverGroup iReceiverGroup = this.receiverGroup;
                if (iReceiverGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("receiverGroup");
                }
                iReceiverGroup.getGroupValue().putBoolean("reset_when_mobile_network", true);
                SharedPlayer sharedPlayer = this.player;
                if (sharedPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                }
                sharedPlayer.attachPlayerBridge(videoPlayerBridge);
                return;
            }
            SharedPlayer sharedPlayer2 = this.player;
            if (sharedPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer2.detachPlayerBridge();
        }
    }

    private final void requestFinish() {
        if (!isFinishing()) {
            if (!isAvailable() || this.hasEnterPIP) {
                finish();
                return;
            }
            IReceiverGroup iReceiverGroup = this.receiverGroup;
            if (iReceiverGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("receiverGroup");
            }
            iReceiverGroup.getGroupValue().putBoolean("hide_frame_content", true);
            finishAfterTransition();
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                sharedElementReturnTransition.addListener(new VideoFullScreenActivity$requestFinish$1(this));
            }
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        detachPlayerBridge();
    }

    /* access modifiers changed from: private */
    public final void magicalAnimationCompat() {
        VideoPlayerBridge videoPlayerBridge;
        if (isAvailable() && (videoPlayerBridge = (VideoPlayerBridge) AppHolder.getWeakValue(getIntent().getStringExtra("extra_video_source_bridge_key"))) != null) {
            VideoPlayerBridge.DefaultImpls.onAction$default(videoPlayerBridge, "show_pause_cover", null, 2, null);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (isAvailable()) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.tryAutoResume();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (!isFinishing() && isAvailable() && !PIPUtils.INSTANCE.isInPicInPicMode(this)) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.reset();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (isAvailable()) {
            this.isLandScape = configuration.orientation == 2;
            IReceiverGroup iReceiverGroup = this.receiverGroup;
            if (iReceiverGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("receiverGroup");
            }
            iReceiverGroup.getGroupValue().putBoolean("isLandscape", this.isLandScape);
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

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 2) {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            activity.setRequestedOrientation(1);
            return;
        }
        requestFinish();
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        this.assist = relationAssist;
        if (this.isLandScape) {
            relationAssist.setAspectRatio(AspectRatio.AspectRatio_FIT_PARENT);
        } else {
            relationAssist.setAspectRatio(AspectRatio.AspectRatio_FILL_WIDTH);
        }
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        boolean z = resources.getConfiguration().orientation == 2;
        IReceiverGroup receiverGroup2 = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup2, "assist.receiverGroup");
        this.receiverGroup = receiverGroup2;
        if (receiverGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiverGroup");
        }
        GroupValue groupValue = receiverGroup2.getGroupValue();
        groupValue.putBoolean("controller_top_enable", true);
        groupValue.putBoolean("user_click_started", true);
        groupValue.putBoolean("reset_when_mobile_network", false);
        groupValue.putBoolean("isLandscape", z);
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
        if (!isFinishing()) {
            finish();
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onEvent(int i, Bundle bundle) {
        if (i != -124) {
            if (i == -123) {
                Toast.show$default(getActivity(), "等待处理", 0, false, 12, null);
            } else if (i != -107) {
                int i2 = 0;
                if (i == -104) {
                    Resources resources = getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    if (resources.getConfiguration().orientation == 2) {
                        i2 = 1;
                    }
                    setRequestedOrientation(i2);
                } else if (i == -100) {
                    Resources resources2 = getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                    if (resources2.getConfiguration().orientation == 2) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        BaseActivity activity = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        activity.setRequestedOrientation(1);
                        return;
                    }
                    requestFinish();
                }
            } else {
                VideoModel videoModel2 = this.videoModel;
                if (videoModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoModel");
                }
                Entity relatedEntity = videoModel2.getRelatedEntity();
                if (relatedEntity != null) {
                    ActionManager.shareText(this, relatedEntity);
                }
            }
        } else if (!SettingsCompat.canDrawOverlays(this)) {
            FloatWindowUtil.INSTANCE.showNeedFloatingPermissionDialog(this);
        } else {
            enterFloatingWindows();
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
        this.hasEnterPIP = z;
        if (isAvailable()) {
            if (z) {
                RelationAssist relationAssist = this.assist;
                if (relationAssist == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assist");
                }
                relationAssist.setAspectRatio(AspectRatio.AspectRatio_FIT_PARENT);
                IReceiverGroup iReceiverGroup = this.receiverGroup;
                if (iReceiverGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("receiverGroup");
                }
                iReceiverGroup.getGroupValue().putBoolean("hide_frame_content", true);
                return;
            }
            RelationAssist relationAssist2 = this.assist;
            if (relationAssist2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assist");
            }
            relationAssist2.setAspectRatio(AspectRatio.AspectRatio_FILL_WIDTH);
            IReceiverGroup iReceiverGroup2 = this.receiverGroup;
            if (iReceiverGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("receiverGroup");
            }
            iReceiverGroup2.getGroupValue().putBoolean("hide_frame_content", false);
        }
    }

    private final void enterFloatingWindows() {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Application application2 = application;
        VideoModel videoModel2 = this.videoModel;
        if (videoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoModel");
        }
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        new FloatWindowBridge(application2, videoModel2, sharedPlayer.getRenderAspect());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.hasEnterPIP) {
            finish();
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public PlayerArg getPlayerArg() {
        VideoFullScreenBinding videoFullScreenBinding = this.binding;
        if (videoFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoFullScreenBinding.videoContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
        LinearLayout linearLayout2 = linearLayout;
        VideoModel videoModel2 = this.videoModel;
        if (videoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoModel");
        }
        return new PlayerArg(linearLayout2, videoModel2, SetsKt.setOf((Object[]) new String[]{"controller_cover", "gesture_cover", "loading_cover", "error_cover"}), false);
    }
}
