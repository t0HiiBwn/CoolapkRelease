package com.coolapk.market.view.live;

import com.coolapk.market.model.LiveMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageEvent;", "", "action", "", "liveMessages", "", "Lcom/coolapk/market/model/LiveMessage;", "messageType", "", "messageId", "uid", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()I", "getLiveMessages", "()Ljava/util/List;", "getMessageId", "()Ljava/lang/String;", "getMessageType", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveMessageEvent.kt */
public final class LiveMessageEvent {
    public static final int ACTION_DELETE = 2;
    public static final int ACTION_INSERT = 3;
    public static final int ACTION_REFRESH = 1;
    public static final Companion Companion = new Companion(null);
    private final int action;
    private final List<LiveMessage> liveMessages;
    private final String messageId;
    private final String messageType;
    private final String uid;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.coolapk.market.view.live.LiveMessageEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveMessageEvent copy$default(LiveMessageEvent liveMessageEvent, int i, List list, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = liveMessageEvent.action;
        }
        if ((i2 & 2) != 0) {
            list = liveMessageEvent.liveMessages;
        }
        if ((i2 & 4) != 0) {
            str = liveMessageEvent.messageType;
        }
        if ((i2 & 8) != 0) {
            str2 = liveMessageEvent.messageId;
        }
        if ((i2 & 16) != 0) {
            str3 = liveMessageEvent.uid;
        }
        return liveMessageEvent.copy(i, list, str, str2, str3);
    }

    public final int component1() {
        return this.action;
    }

    public final List<LiveMessage> component2() {
        return this.liveMessages;
    }

    public final String component3() {
        return this.messageType;
    }

    public final String component4() {
        return this.messageId;
    }

    public final String component5() {
        return this.uid;
    }

    public final LiveMessageEvent copy(int i, List<? extends LiveMessage> list, String str, String str2, String str3) {
        return new LiveMessageEvent(i, list, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveMessageEvent)) {
            return false;
        }
        LiveMessageEvent liveMessageEvent = (LiveMessageEvent) obj;
        return this.action == liveMessageEvent.action && Intrinsics.areEqual(this.liveMessages, liveMessageEvent.liveMessages) && Intrinsics.areEqual(this.messageType, liveMessageEvent.messageType) && Intrinsics.areEqual(this.messageId, liveMessageEvent.messageId) && Intrinsics.areEqual(this.uid, liveMessageEvent.uid);
    }

    public int hashCode() {
        int i = this.action * 31;
        List<LiveMessage> list = this.liveMessages;
        int i2 = 0;
        int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.messageType;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.messageId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uid;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "LiveMessageEvent(action=" + this.action + ", liveMessages=" + this.liveMessages + ", messageType=" + this.messageType + ", messageId=" + this.messageId + ", uid=" + this.uid + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.coolapk.market.model.LiveMessage> */
    /* JADX WARN: Multi-variable type inference failed */
    public LiveMessageEvent(int i, List<? extends LiveMessage> list, String str, String str2, String str3) {
        this.action = i;
        this.liveMessages = list;
        this.messageType = str;
        this.messageId = str2;
        this.uid = str3;
    }

    public final int getAction() {
        return this.action;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveMessageEvent(int i, List list, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3);
    }

    public final List<LiveMessage> getLiveMessages() {
        return this.liveMessages;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getUid() {
        return this.uid;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageEvent$Companion;", "", "()V", "ACTION_DELETE", "", "ACTION_INSERT", "ACTION_REFRESH", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveMessageEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
