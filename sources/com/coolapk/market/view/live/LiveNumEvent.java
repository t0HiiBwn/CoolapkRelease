package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/live/LiveNumEvent;", "", "followNum", "", "visitNum", "discussNum", "followNumFormat", "", "visitNumFormat", "discussNumFormat", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDiscussNum", "()I", "getDiscussNumFormat", "()Ljava/lang/String;", "getFollowNum", "getFollowNumFormat", "getVisitNum", "getVisitNumFormat", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveNumEvent.kt */
public final class LiveNumEvent {
    private final int discussNum;
    private final String discussNumFormat;
    private final int followNum;
    private final String followNumFormat;
    private final int visitNum;
    private final String visitNumFormat;

    public LiveNumEvent(int i, int i2, int i3, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "followNumFormat");
        Intrinsics.checkNotNullParameter(str2, "visitNumFormat");
        Intrinsics.checkNotNullParameter(str3, "discussNumFormat");
        this.followNum = i;
        this.visitNum = i2;
        this.discussNum = i3;
        this.followNumFormat = str;
        this.visitNumFormat = str2;
        this.discussNumFormat = str3;
    }

    public final int getFollowNum() {
        return this.followNum;
    }

    public final int getVisitNum() {
        return this.visitNum;
    }

    public final int getDiscussNum() {
        return this.discussNum;
    }

    public final String getFollowNumFormat() {
        return this.followNumFormat;
    }

    public final String getVisitNumFormat() {
        return this.visitNumFormat;
    }

    public final String getDiscussNumFormat() {
        return this.discussNumFormat;
    }
}
