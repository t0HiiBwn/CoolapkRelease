package com.coolapk.market.widget.video;

import android.content.Context;
import android.util.SparseIntArray;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.event.ActivityResumeEvent;
import com.coolapk.market.event.ApplicationVisibleEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.util.BitmapUtil;
import com.kk.taurus.playerbase.log.PLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0014J\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020!H\u0007J\b\u0010\"\u001a\u0004\u0018\u00010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/coolapk/market/widget/video/VideoManager;", "", "()V", "ignoreMobileNetwork", "", "getIgnoreMobileNetwork", "()Z", "setIgnoreMobileNetwork", "(Z)V", "instance", "Lcom/coolapk/market/widget/video/SharedPlayer;", "progressMap", "Landroid/util/SparseIntArray;", "getProgressMap", "()Landroid/util/SparseIntArray;", "setProgressMap", "(Landroid/util/SparseIntArray;)V", "destroySharedPlayer", "", "player", "destroySharedPlayer$presentation_coolapkAppRelease", "getSharedPlayer", "getVideoCacheDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "onActivityResume", "event", "Lcom/coolapk/market/event/ActivityResumeEvent;", "onAppThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onApplicationVisibleChange", "Lcom/coolapk/market/event/ApplicationVisibleEvent;", "optSharePlayer", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoManager.kt */
public final class VideoManager {
    public static final VideoManager INSTANCE;
    private static boolean ignoreMobileNetwork;
    private static SharedPlayer instance;
    private static SparseIntArray progressMap = new SparseIntArray();

    static {
        VideoManager videoManager = new VideoManager();
        INSTANCE = videoManager;
        PLog.LOG_OPEN = false;
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, videoManager);
    }

    private VideoManager() {
    }

    public final boolean getIgnoreMobileNetwork() {
        return ignoreMobileNetwork;
    }

    public final void setIgnoreMobileNetwork(boolean z) {
        ignoreMobileNetwork = z;
    }

    public final SparseIntArray getProgressMap() {
        return progressMap;
    }

    public final void setProgressMap(SparseIntArray sparseIntArray) {
        Intrinsics.checkNotNullParameter(sparseIntArray, "<set-?>");
        progressMap = sparseIntArray;
    }

    @Subscribe
    public final void onActivityResume(ActivityResumeEvent activityResumeEvent) {
        Intrinsics.checkNotNullParameter(activityResumeEvent, "event");
        VideoAutoPlayManager.requestCheckVisible();
        SharedPlayer optSharePlayer = optSharePlayer();
        if (optSharePlayer != null) {
            optSharePlayer.tryFixAutoPlayBug();
        }
    }

    @Subscribe
    public final void onApplicationVisibleChange(ApplicationVisibleEvent applicationVisibleEvent) {
        SharedPlayer optSharePlayer;
        Intrinsics.checkNotNullParameter(applicationVisibleEvent, "event");
        if (!applicationVisibleEvent.isShown() && (optSharePlayer = optSharePlayer()) != null) {
            if (optSharePlayer.getPlayerBridge() == null) {
                optSharePlayer.destroy();
            } else if (!optSharePlayer.isInForeground()) {
                VideoAutoPlayManager.INSTANCE.checkVisibleNow();
            }
            SharedPlayer optSharePlayer2 = optSharePlayer();
            if (optSharePlayer2 != null) {
                optSharePlayer2.tryFixAutoPlayBug();
            }
        }
    }

    @Subscribe
    public final void onAppThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        SharedPlayer optSharePlayer = optSharePlayer();
        if (optSharePlayer != null) {
            optSharePlayer.changeAppTheme(appTheme);
        }
    }

    public final File getVideoCacheDir(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(BitmapUtil.getCacheDirPath(AppHolder.getApplication()), "video_cache");
    }

    public final SharedPlayer getSharedPlayer() {
        if (instance == null) {
            synchronized (SharedPlayer.class) {
                if (instance == null) {
                    instance = new SharedPlayer();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        SharedPlayer sharedPlayer = instance;
        Intrinsics.checkNotNull(sharedPlayer);
        return sharedPlayer;
    }

    public final SharedPlayer optSharePlayer() {
        return instance;
    }

    public final void destroySharedPlayer$presentation_coolapkAppRelease(SharedPlayer sharedPlayer) {
        Intrinsics.checkNotNullParameter(sharedPlayer, "player");
        if (Intrinsics.areEqual(instance, sharedPlayer)) {
            synchronized (SharedPlayer.class) {
                if (Intrinsics.areEqual(sharedPlayer, instance)) {
                    instance = null;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
