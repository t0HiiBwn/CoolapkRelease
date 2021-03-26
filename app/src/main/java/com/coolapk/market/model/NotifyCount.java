package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_NotifyCount;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class NotifyCount implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("atcommentme")
    public abstract int getAtCommentMe();

    @SerializedName("atme")
    public abstract int getAtMe();

    public abstract int getBadge();

    public abstract int getCloudInstall();

    @SerializedName("commentme")
    public abstract int getCommentMe();

    @SerializedName("dateline")
    public abstract long getDateline();

    @SerializedName("feedlike")
    public abstract int getFeedLike();

    @SerializedName("contacts_follow")
    public abstract int getFollowMe();

    public abstract long getLastSplashUpdate();

    public abstract int getMessage();

    public abstract int getNotification();

    public static TypeAdapter<NotifyCount> typeAdapter(Gson gson) {
        return new C$AutoValue_NotifyCount.GsonTypeAdapter(gson);
    }
}
