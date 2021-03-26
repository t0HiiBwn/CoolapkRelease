package com.coolapk.market.view.live;

import com.coolapk.market.view.live.CommandHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/live/LiveCommandEvent;", "", "key", "", "command", "Lcom/coolapk/market/view/live/CommandHelper$Command;", "(Ljava/lang/String;Lcom/coolapk/market/view/live/CommandHelper$Command;)V", "getCommand", "()Lcom/coolapk/market/view/live/CommandHelper$Command;", "getKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveCommandEvent.kt */
public final class LiveCommandEvent {
    private final CommandHelper.Command command;
    private final String key;

    public static /* synthetic */ LiveCommandEvent copy$default(LiveCommandEvent liveCommandEvent, String str, CommandHelper.Command command2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveCommandEvent.key;
        }
        if ((i & 2) != 0) {
            command2 = liveCommandEvent.command;
        }
        return liveCommandEvent.copy(str, command2);
    }

    public final String component1() {
        return this.key;
    }

    public final CommandHelper.Command component2() {
        return this.command;
    }

    public final LiveCommandEvent copy(String str, CommandHelper.Command command2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(command2, "command");
        return new LiveCommandEvent(str, command2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCommandEvent)) {
            return false;
        }
        LiveCommandEvent liveCommandEvent = (LiveCommandEvent) obj;
        return Intrinsics.areEqual(this.key, liveCommandEvent.key) && Intrinsics.areEqual(this.command, liveCommandEvent.command);
    }

    public int hashCode() {
        String str = this.key;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CommandHelper.Command command2 = this.command;
        if (command2 != null) {
            i = command2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LiveCommandEvent(key=" + this.key + ", command=" + this.command + ")";
    }

    public LiveCommandEvent(String str, CommandHelper.Command command2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(command2, "command");
        this.key = str;
        this.command = command2;
    }

    public final CommandHelper.Command getCommand() {
        return this.command;
    }

    public final String getKey() {
        return this.key;
    }
}
