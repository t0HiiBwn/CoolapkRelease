package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_NotifyCount  reason: invalid class name */
abstract class C$$AutoValue_NotifyCount extends NotifyCount {
    private final int atCommentMe;
    private final int atMe;
    private final int badge;
    private final int cloudInstall;
    private final int commentMe;
    private final long dateline;
    private final int feedLike;
    private final int followMe;
    private final long lastSplashUpdate;
    private final int message;
    private final int notification;

    C$$AutoValue_NotifyCount(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2) {
        this.cloudInstall = i;
        this.notification = i2;
        this.message = i3;
        this.atMe = i4;
        this.atCommentMe = i5;
        this.commentMe = i6;
        this.badge = i7;
        this.feedLike = i8;
        this.followMe = i9;
        this.lastSplashUpdate = j;
        this.dateline = j2;
    }

    @Override // com.coolapk.market.model.NotifyCount
    public int getCloudInstall() {
        return this.cloudInstall;
    }

    @Override // com.coolapk.market.model.NotifyCount
    public int getNotification() {
        return this.notification;
    }

    @Override // com.coolapk.market.model.NotifyCount
    public int getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.NotifyCount
    @SerializedName("atme")
    public int getAtMe() {
        return this.atMe;
    }

    @Override // com.coolapk.market.model.NotifyCount
    @SerializedName("atcommentme")
    public int getAtCommentMe() {
        return this.atCommentMe;
    }

    @Override // com.coolapk.market.model.NotifyCount
    @SerializedName("commentme")
    public int getCommentMe() {
        return this.commentMe;
    }

    @Override // com.coolapk.market.model.NotifyCount
    public int getBadge() {
        return this.badge;
    }

    @Override // com.coolapk.market.model.NotifyCount
    @SerializedName("feedlike")
    public int getFeedLike() {
        return this.feedLike;
    }

    @Override // com.coolapk.market.model.NotifyCount
    @SerializedName("contacts_follow")
    public int getFollowMe() {
        return this.followMe;
    }

    @Override // com.coolapk.market.model.NotifyCount
    public long getLastSplashUpdate() {
        return this.lastSplashUpdate;
    }

    @Override // com.coolapk.market.model.NotifyCount
    @SerializedName("dateline")
    public long getDateline() {
        return this.dateline;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NotifyCount{cloudInstall=" + this.cloudInstall + ", notification=" + this.notification + ", message=" + this.message + ", atMe=" + this.atMe + ", atCommentMe=" + this.atCommentMe + ", commentMe=" + this.commentMe + ", badge=" + this.badge + ", feedLike=" + this.feedLike + ", followMe=" + this.followMe + ", lastSplashUpdate=" + this.lastSplashUpdate + ", dateline=" + this.dateline + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NotifyCount)) {
            return false;
        }
        NotifyCount notifyCount = (NotifyCount) obj;
        if (this.cloudInstall == notifyCount.getCloudInstall() && this.notification == notifyCount.getNotification() && this.message == notifyCount.getMessage() && this.atMe == notifyCount.getAtMe() && this.atCommentMe == notifyCount.getAtCommentMe() && this.commentMe == notifyCount.getCommentMe() && this.badge == notifyCount.getBadge() && this.feedLike == notifyCount.getFeedLike() && this.followMe == notifyCount.getFollowMe() && this.lastSplashUpdate == notifyCount.getLastSplashUpdate() && this.dateline == notifyCount.getDateline()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j = this.lastSplashUpdate;
        long j2 = (long) (((int) (((long) ((((((((((((((((((this.cloudInstall ^ 1000003) * 1000003) ^ this.notification) * 1000003) ^ this.message) * 1000003) ^ this.atMe) * 1000003) ^ this.atCommentMe) * 1000003) ^ this.commentMe) * 1000003) ^ this.badge) * 1000003) ^ this.feedLike) * 1000003) ^ this.followMe) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003);
        long j3 = this.dateline;
        return (int) (j2 ^ (j3 ^ (j3 >>> 32)));
    }
}
