package com.coolapk.market.view.node;

import com.coolapk.market.model.Album;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/node/AlbumTopEvent;", "", "data", "Lcom/coolapk/market/model/Album;", "nodeType", "", "nodeId", "isTopNow", "", "(Lcom/coolapk/market/model/Album;Ljava/lang/String;Ljava/lang/String;Z)V", "getData", "()Lcom/coolapk/market/model/Album;", "()Z", "getNodeId", "()Ljava/lang/String;", "getNodeType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumUserSpaceSheetModifier.kt */
public final class AlbumTopEvent {
    private final Album data;
    private final boolean isTopNow;
    private final String nodeId;
    private final String nodeType;

    public static /* synthetic */ AlbumTopEvent copy$default(AlbumTopEvent albumTopEvent, Album album, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            album = albumTopEvent.data;
        }
        if ((i & 2) != 0) {
            str = albumTopEvent.nodeType;
        }
        if ((i & 4) != 0) {
            str2 = albumTopEvent.nodeId;
        }
        if ((i & 8) != 0) {
            z = albumTopEvent.isTopNow;
        }
        return albumTopEvent.copy(album, str, str2, z);
    }

    public final Album component1() {
        return this.data;
    }

    public final String component2() {
        return this.nodeType;
    }

    public final String component3() {
        return this.nodeId;
    }

    public final boolean component4() {
        return this.isTopNow;
    }

    public final AlbumTopEvent copy(Album album, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(album, "data");
        Intrinsics.checkNotNullParameter(str, "nodeType");
        Intrinsics.checkNotNullParameter(str2, "nodeId");
        return new AlbumTopEvent(album, str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumTopEvent)) {
            return false;
        }
        AlbumTopEvent albumTopEvent = (AlbumTopEvent) obj;
        return Intrinsics.areEqual(this.data, albumTopEvent.data) && Intrinsics.areEqual(this.nodeType, albumTopEvent.nodeType) && Intrinsics.areEqual(this.nodeId, albumTopEvent.nodeId) && this.isTopNow == albumTopEvent.isTopNow;
    }

    public int hashCode() {
        Album album = this.data;
        int i = 0;
        int hashCode = (album != null ? album.hashCode() : 0) * 31;
        String str = this.nodeType;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.nodeId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.isTopNow;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "AlbumTopEvent(data=" + this.data + ", nodeType=" + this.nodeType + ", nodeId=" + this.nodeId + ", isTopNow=" + this.isTopNow + ")";
    }

    public AlbumTopEvent(Album album, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(album, "data");
        Intrinsics.checkNotNullParameter(str, "nodeType");
        Intrinsics.checkNotNullParameter(str2, "nodeId");
        this.data = album;
        this.nodeType = str;
        this.nodeId = str2;
        this.isTopNow = z;
    }

    public final Album getData() {
        return this.data;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getNodeType() {
        return this.nodeType;
    }

    public final boolean isTopNow() {
        return this.isTopNow;
    }
}
