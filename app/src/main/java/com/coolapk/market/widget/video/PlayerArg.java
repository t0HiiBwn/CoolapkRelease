package com.coolapk.market.widget.video;

import android.view.ViewGroup;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/video/PlayerArg;", "", "container", "Landroid/view/ViewGroup;", "videoModel", "Lcom/coolapk/market/widget/video/VideoModel;", "coverKeys", "", "", "needMute", "", "(Landroid/view/ViewGroup;Lcom/coolapk/market/widget/video/VideoModel;Ljava/util/Set;Z)V", "getContainer", "()Landroid/view/ViewGroup;", "getCoverKeys", "()Ljava/util/Set;", "getNeedMute", "()Z", "getVideoModel", "()Lcom/coolapk/market/widget/video/VideoModel;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoPlayerBridge.kt */
public final class PlayerArg {
    private final ViewGroup container;
    private final Set<String> coverKeys;
    private final boolean needMute;
    private final VideoModel videoModel;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.widget.video.PlayerArg */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerArg copy$default(PlayerArg playerArg, ViewGroup viewGroup, VideoModel videoModel2, Set set, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            viewGroup = playerArg.container;
        }
        if ((i & 2) != 0) {
            videoModel2 = playerArg.videoModel;
        }
        if ((i & 4) != 0) {
            set = playerArg.coverKeys;
        }
        if ((i & 8) != 0) {
            z = playerArg.needMute;
        }
        return playerArg.copy(viewGroup, videoModel2, set, z);
    }

    public final ViewGroup component1() {
        return this.container;
    }

    public final VideoModel component2() {
        return this.videoModel;
    }

    public final Set<String> component3() {
        return this.coverKeys;
    }

    public final boolean component4() {
        return this.needMute;
    }

    public final PlayerArg copy(ViewGroup viewGroup, VideoModel videoModel2, Set<String> set, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(videoModel2, "videoModel");
        Intrinsics.checkNotNullParameter(set, "coverKeys");
        return new PlayerArg(viewGroup, videoModel2, set, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerArg)) {
            return false;
        }
        PlayerArg playerArg = (PlayerArg) obj;
        return Intrinsics.areEqual(this.container, playerArg.container) && Intrinsics.areEqual(this.videoModel, playerArg.videoModel) && Intrinsics.areEqual(this.coverKeys, playerArg.coverKeys) && this.needMute == playerArg.needMute;
    }

    public int hashCode() {
        ViewGroup viewGroup = this.container;
        int i = 0;
        int hashCode = (viewGroup != null ? viewGroup.hashCode() : 0) * 31;
        VideoModel videoModel2 = this.videoModel;
        int hashCode2 = (hashCode + (videoModel2 != null ? videoModel2.hashCode() : 0)) * 31;
        Set<String> set = this.coverKeys;
        if (set != null) {
            i = set.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.needMute;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "PlayerArg(container=" + this.container + ", videoModel=" + this.videoModel + ", coverKeys=" + this.coverKeys + ", needMute=" + this.needMute + ")";
    }

    public PlayerArg(ViewGroup viewGroup, VideoModel videoModel2, Set<String> set, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(videoModel2, "videoModel");
        Intrinsics.checkNotNullParameter(set, "coverKeys");
        this.container = viewGroup;
        this.videoModel = videoModel2;
        this.coverKeys = set;
        this.needMute = z;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final VideoModel getVideoModel() {
        return this.videoModel;
    }

    public final Set<String> getCoverKeys() {
        return this.coverKeys;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerArg(ViewGroup viewGroup, VideoModel videoModel2, Set set, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, videoModel2, set, (i & 8) != 0 ? true : z);
    }

    public final boolean getNeedMute() {
        return this.needMute;
    }
}
