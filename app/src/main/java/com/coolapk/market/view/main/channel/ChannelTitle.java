package com.coolapk.market.view.main.channel;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelTitle;", "", "type", "", "(I)V", "getType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelTitle.kt */
public final class ChannelTitle {
    private final int type;

    public static /* synthetic */ ChannelTitle copy$default(ChannelTitle channelTitle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = channelTitle.type;
        }
        return channelTitle.copy(i);
    }

    public final int component1() {
        return this.type;
    }

    public final ChannelTitle copy(int i) {
        return new ChannelTitle(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChannelTitle) && this.type == ((ChannelTitle) obj).type;
        }
        return true;
    }

    public int hashCode() {
        return this.type;
    }

    public String toString() {
        return "ChannelTitle(type=" + this.type + ")";
    }

    public ChannelTitle(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
