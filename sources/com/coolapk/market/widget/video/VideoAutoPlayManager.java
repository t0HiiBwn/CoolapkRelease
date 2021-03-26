package com.coolapk.market.widget.video;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.ItemVideoViewPartBinding;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010!\u001a\u00020\fJ\b\u0010\"\u001a\u00020\u001eH\u0002J\u0006\u0010#\u001a\u00020\u001eJ\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u001eH\u0007J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010!\u001a\u00020\fJ\b\u0010(\u001a\u00020\u001eH\u0007J\b\u0010)\u001a\u00020\u001eH\u0007J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0007J,\u0010+\u001a\u00020\u001e*\u00020\u001b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0002J\u0014\u00101\u001a\u00020\u0017*\u0002022\u0006\u00103\u001a\u000204H\u0002J\f\u00105\u001a\u00020\u0017*\u000206H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/coolapk/market/widget/video/VideoAutoPlayManager;", "", "()V", "appSetting", "Lcom/coolapk/market/AppSetting;", "kotlin.jvm.PlatformType", "autoResumeVisibleRunnable", "Ljava/lang/Runnable;", "availableViewPartMap", "", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "", "Lcom/coolapk/market/viewholder/v8/VideoViewPart;", "checkVisibleRunnable", "fragmentList", "", "handler", "Landroid/os/Handler;", "lastVisibleFragment", "pauseThreshold", "", "playThreshold", "shouldAutoLoad", "", "getShouldAutoLoad", "()Z", "tmpRect1", "Landroid/graphics/Rect;", "tmpRect2", "addToMonitorList", "", "fragment", "addToVideoViewPartList", "videoViewPart", "autoResumeVisiblePlayer", "checkVisibleNow", "pauseInvisiblePlayer", "removeAutoResumeVisiblePlayerRunnable", "removeFromMonitorList", "removeFromVideoViewPartList", "requestAutoResumeVisiblePlayer", "requestCheckVisible", "requestPauseInvisiblePlayer", "insetRect", "left", "", "top", "right", "bottom", "isChildViewOf", "Landroid/view/View;", "assumeParent", "Landroid/view/ViewGroup;", "isVisibleToUser", "Landroidx/fragment/app/Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoAutoPlayManager.kt */
public final class VideoAutoPlayManager {
    public static final VideoAutoPlayManager INSTANCE = new VideoAutoPlayManager();
    private static final AppSetting appSetting = AppHolder.getAppSetting();
    private static final Runnable autoResumeVisibleRunnable = VideoAutoPlayManager$autoResumeVisibleRunnable$1.INSTANCE;
    private static final Map<EntityListFragment, Set<VideoViewPart>> availableViewPartMap = new HashMap();
    private static final Runnable checkVisibleRunnable = VideoAutoPlayManager$checkVisibleRunnable$1.INSTANCE;
    private static final List<EntityListFragment> fragmentList = new ArrayList();
    private static final Handler handler = new Handler();
    private static EntityListFragment lastVisibleFragment = null;
    private static final float pauseThreshold = 0.4f;
    private static final float playThreshold = 0.7f;
    private static final Rect tmpRect1 = new Rect();
    private static final Rect tmpRect2 = new Rect();

    private VideoAutoPlayManager() {
    }

    private final boolean getShouldAutoLoad() {
        AppSetting appSetting2 = appSetting;
        Intrinsics.checkNotNullExpressionValue(appSetting2, "appSetting");
        return appSetting2.isAutoLoadVideoWhenWifi() && appSetting2.isWifiAvailable();
    }

    public final void addToMonitorList(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        fragmentList.add(entityListFragment);
    }

    public final void removeFromMonitorList(EntityListFragment entityListFragment) {
        SharedPlayer optSharePlayer;
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        VideoPlayerBridge videoPlayerBridge = null;
        if (Intrinsics.areEqual(lastVisibleFragment, entityListFragment)) {
            lastVisibleFragment = null;
        }
        availableViewPartMap.remove(entityListFragment);
        List<EntityListFragment> list = fragmentList;
        list.remove(entityListFragment);
        if (list.size() == 0) {
            SharedPlayer optSharePlayer2 = VideoManager.INSTANCE.optSharePlayer();
            if (optSharePlayer2 != null) {
                videoPlayerBridge = optSharePlayer2.getPlayerBridge();
            }
            if (videoPlayerBridge == null && (optSharePlayer = VideoManager.INSTANCE.optSharePlayer()) != null) {
                optSharePlayer.destroy();
            }
        }
    }

    @JvmStatic
    public static final void requestCheckVisible() {
        Handler handler2 = handler;
        Runnable runnable = checkVisibleRunnable;
        handler2.removeCallbacks(runnable);
        handler2.postDelayed(runnable, 1000);
    }

    @JvmStatic
    public static final void requestAutoResumeVisiblePlayer() {
        removeAutoResumeVisiblePlayerRunnable();
        handler.postDelayed(autoResumeVisibleRunnable, 300);
    }

    @JvmStatic
    public static final void removeAutoResumeVisiblePlayerRunnable() {
        handler.removeCallbacks(autoResumeVisibleRunnable);
    }

    @JvmStatic
    public static final void requestPauseInvisiblePlayer(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        INSTANCE.pauseInvisiblePlayer(entityListFragment);
        handler.removeCallbacks(autoResumeVisibleRunnable);
    }

    public final void addToVideoViewPartList(EntityListFragment entityListFragment, VideoViewPart videoViewPart) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        Intrinsics.checkNotNullParameter(videoViewPart, "videoViewPart");
        if (fragmentList.contains(entityListFragment)) {
            Map<EntityListFragment, Set<VideoViewPart>> map = availableViewPartMap;
            LinkedHashSet linkedHashSet = map.get(entityListFragment);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                map.put(entityListFragment, linkedHashSet);
            }
            linkedHashSet.add(videoViewPart);
        }
    }

    public final void removeFromVideoViewPartList(EntityListFragment entityListFragment, VideoViewPart videoViewPart) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        Intrinsics.checkNotNullParameter(videoViewPart, "videoViewPart");
        if (fragmentList.contains(entityListFragment)) {
            Map<EntityListFragment, Set<VideoViewPart>> map = availableViewPartMap;
            LinkedHashSet linkedHashSet = map.get(entityListFragment);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                map.put(entityListFragment, linkedHashSet);
            }
            linkedHashSet.remove(videoViewPart);
        }
    }

    public final void checkVisibleNow() {
        T t;
        Iterator<T> it2 = fragmentList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (INSTANCE.isVisibleToUser(t)) {
                break;
            }
        }
        T t2 = t;
        if (t2 == null || !Intrinsics.areEqual(t2, lastVisibleFragment)) {
            lastVisibleFragment = t2;
            SharedPlayer optSharePlayer = VideoManager.INSTANCE.optSharePlayer();
            if (optSharePlayer != null && !optSharePlayer.isInForeground() && !optSharePlayer.isHandleByActivity()) {
                if (optSharePlayer.isInPlaybackState()) {
                    boolean z = false;
                    if (t2 != null) {
                        View view = optSharePlayer.getView();
                        View view2 = t2.getView();
                        Objects.requireNonNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                        z = isChildViewOf(view, (ViewGroup) view2);
                        if (!z) {
                            Fragment parentFragment = t2.getParentFragment();
                            if (parentFragment instanceof DataListFragment) {
                                View view3 = optSharePlayer.getView();
                                View view4 = ((DataListFragment) parentFragment).getView();
                                Objects.requireNonNull(view4, "null cannot be cast to non-null type android.view.ViewGroup");
                                z = isChildViewOf(view3, (ViewGroup) view4);
                            }
                        }
                    }
                    if (z) {
                        optSharePlayer.tryAutoResume();
                    } else {
                        optSharePlayer.detachPlayerBridge();
                    }
                } else if (!optSharePlayer.getView().isAttachedToWindow() && optSharePlayer.getPlayerBridge() != null) {
                    optSharePlayer.detachPlayerBridge();
                }
            }
            if (t2 != null) {
                pauseInvisiblePlayer(t2);
                autoResumeVisiblePlayer();
            }
            handler.removeCallbacksAndMessages(null);
        }
    }

    private final void pauseInvisiblePlayer(EntityListFragment entityListFragment) {
        Set<VideoViewPart> set;
        VideoPlayerBridge playerBridge;
        boolean z;
        T t;
        boolean z2;
        if (isVisibleToUser(entityListFragment)) {
            SharedPlayer optSharePlayer = VideoManager.INSTANCE.optSharePlayer();
            if ((optSharePlayer == null || (!optSharePlayer.isInForeground() && !optSharePlayer.isHandleByActivity())) && (set = availableViewPartMap.get(entityListFragment)) != null && !set.isEmpty() && optSharePlayer != null && (playerBridge = optSharePlayer.getPlayerBridge()) != null && optSharePlayer.isInPlaybackState()) {
                Iterator<T> it2 = set.iterator();
                while (true) {
                    z = true;
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it2.next();
                    if (t == playerBridge) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                if (t == null) {
                    z = false;
                }
                Rect rect = tmpRect1;
                RecyclerView recyclerView = entityListFragment.getRecyclerView();
                recyclerView.getGlobalVisibleRect(rect);
                INSTANCE.insetRect(rect, recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
                Rect rect2 = tmpRect2;
                optSharePlayer.getView().getGlobalVisibleRect(rect2);
                if (z && rect.contains(rect2) && ((float) rect2.height()) / ((float) optSharePlayer.getView().getHeight()) > 0.4f) {
                    return;
                }
                if (getShouldAutoLoad()) {
                    optSharePlayer.reset();
                } else {
                    optSharePlayer.detachPlayerBridge();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void autoResumeVisiblePlayer() {
        EntityListFragment entityListFragment;
        Set<VideoViewPart> set;
        boolean z;
        T t;
        boolean z2;
        if (getShouldAutoLoad()) {
            SharedPlayer optSharePlayer = VideoManager.INSTANCE.optSharePlayer();
            if ((optSharePlayer == null || (!optSharePlayer.isInForeground() && !optSharePlayer.isHandleByActivity())) && (entityListFragment = lastVisibleFragment) != null && (set = availableViewPartMap.get(entityListFragment)) != null && !set.isEmpty()) {
                Rect rect = tmpRect1;
                RecyclerView recyclerView = entityListFragment.getRecyclerView();
                recyclerView.getGlobalVisibleRect(rect);
                INSTANCE.insetRect(rect, recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
                if (optSharePlayer != null) {
                    Rect rect2 = tmpRect2;
                    optSharePlayer.getView().getGlobalVisibleRect(rect2);
                    Iterator<T> it2 = set.iterator();
                    while (true) {
                        z = true;
                        if (!it2.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it2.next();
                        if (t == optSharePlayer.getPlayerBridge()) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            break;
                        }
                    }
                    if (t == null) {
                        z = false;
                    }
                    if (z && rect.contains(rect2) && ((float) rect2.height()) / ((float) optSharePlayer.getView().getHeight()) >= 0.4f) {
                        optSharePlayer.tryAutoResume();
                        return;
                    }
                }
                for (VideoViewPart videoViewPart : CollectionsKt.sortedWith(set, new VideoAutoPlayManager$autoResumeVisiblePlayer$$inlined$sortedBy$1())) {
                    Rect rect3 = tmpRect2;
                    FrameLayout frameLayout = ((ItemVideoViewPartBinding) videoViewPart.getBinding()).videoPlayer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "viewPart.binding.videoPlayer");
                    frameLayout.getGlobalVisibleRect(rect3);
                    if (((float) rect3.height()) / ((float) frameLayout.getHeight()) >= 0.7f && rect.contains(rect3)) {
                        VideoManager.INSTANCE.getSharedPlayer().attachPlayerBridge(videoViewPart);
                        return;
                    }
                }
            }
        }
    }

    private final boolean isVisibleToUser(Fragment fragment) {
        if (fragment.isVisible() && fragment.getUserVisibleHint()) {
            Fragment parentFragment = fragment.getParentFragment();
            Boolean bool = null;
            Boolean valueOf = parentFragment != null ? Boolean.valueOf(isVisibleToUser(parentFragment)) : null;
            if (valueOf == null) {
                valueOf = true;
            }
            if (valueOf.booleanValue()) {
                FragmentActivity activity = fragment.getActivity();
                if (!(activity instanceof BaseActivity)) {
                    activity = null;
                }
                BaseActivity baseActivity = (BaseActivity) activity;
                if (baseActivity != null) {
                    bool = Boolean.valueOf(baseActivity.isResume());
                }
                if (bool == null) {
                    bool = false;
                }
                if (bool.booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isChildViewOf(View view, ViewGroup viewGroup) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof View)) {
            if (viewGroup == parent) {
                return true;
            }
            parent = ((View) parent).getParent();
        }
        return false;
    }

    private final void insetRect(Rect rect, int i, int i2, int i3, int i4) {
        rect.left += i;
        rect.top += i2;
        rect.right -= i3;
        rect.bottom -= i4;
    }
}
