package com.coolapk.market.view.main.channel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/main/channel/Channel;", "", "id", "", "title", "logo", "visible", "", "isFixed", "order", "", "pageName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "()Z", "getLogo", "getOrder", "()I", "getPageName", "getTitle", "getVisible", "setVisible", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: Channel.kt */
public final class Channel {
    private final String id;
    private final boolean isFixed;
    private final String logo;
    private final int order;
    private final String pageName;
    private final String title;
    private boolean visible;

    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, String str3, boolean z, boolean z2, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channel.id;
        }
        if ((i2 & 2) != 0) {
            str2 = channel.title;
        }
        if ((i2 & 4) != 0) {
            str3 = channel.logo;
        }
        if ((i2 & 8) != 0) {
            z = channel.visible;
        }
        if ((i2 & 16) != 0) {
            z2 = channel.isFixed;
        }
        if ((i2 & 32) != 0) {
            i = channel.order;
        }
        if ((i2 & 64) != 0) {
            str4 = channel.pageName;
        }
        return channel.copy(str, str2, str3, z, z2, i, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.logo;
    }

    public final boolean component4() {
        return this.visible;
    }

    public final boolean component5() {
        return this.isFixed;
    }

    public final int component6() {
        return this.order;
    }

    public final String component7() {
        return this.pageName;
    }

    public final Channel copy(String str, String str2, String str3, boolean z, boolean z2, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new Channel(str, str2, str3, z, z2, i, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return Intrinsics.areEqual(this.id, channel.id) && Intrinsics.areEqual(this.title, channel.title) && Intrinsics.areEqual(this.logo, channel.logo) && this.visible == channel.visible && this.isFixed == channel.isFixed && this.order == channel.order && Intrinsics.areEqual(this.pageName, channel.pageName);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.logo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.visible;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode3 + i3) * 31;
        boolean z2 = this.isFixed;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (((i6 + i2) * 31) + this.order) * 31;
        String str4 = this.pageName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i7 + i;
    }

    public String toString() {
        return "Channel(id=" + this.id + ", title=" + this.title + ", logo=" + this.logo + ", visible=" + this.visible + ", isFixed=" + this.isFixed + ", order=" + this.order + ", pageName=" + this.pageName + ")";
    }

    public Channel(String str, String str2, String str3, boolean z, boolean z2, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.logo = str3;
        this.visible = z;
        this.isFixed = z2;
        this.order = i;
        this.pageName = str4;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Channel(String str, String str2, String str3, boolean z, boolean z2, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : str4);
    }

    public final String getLogo() {
        return this.logo;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setVisible(boolean z) {
        this.visible = z;
    }

    public final boolean isFixed() {
        return this.isFixed;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getPageName() {
        return this.pageName;
    }
}
