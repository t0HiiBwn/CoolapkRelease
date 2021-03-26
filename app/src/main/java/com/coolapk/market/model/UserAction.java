package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_UserAction;
import com.coolapk.market.model.C$AutoValue_UserAction;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class UserAction implements CardContent {
    public static final UserAction EMPTY_ACTION = newBuilder().build();
    public static final int PRODUCT_DISLIKE = -1;
    public static final int PRODUCT_LIKE = 1;

    public static abstract class Builder {
        public abstract UserAction build();

        public abstract Builder buy(int i);

        public abstract Builder collect(int i);

        public abstract Builder favorite(int i);

        public abstract Builder follow(int i);

        public abstract Builder followAuthor(int i);

        public abstract Builder like(int i);

        public abstract Builder rating(int i);

        public abstract Builder ratingFeedUrl(String str);

        public abstract Builder wish(int i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract int getBuy();

    public abstract int getCollect();

    public abstract int getFavorite();

    public abstract int getFollow();

    public abstract int getFollowAuthor();

    public abstract int getLike();

    public abstract int getRating();

    @SerializedName("rating_feed_url")
    public abstract String getRatingFeedUrl();

    public abstract int getWish();

    public Builder builder() {
        return newBuilder(this);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_UserAction.Builder().favorite(0).follow(0).rating(0).like(0).followAuthor(0).collect(0).wish(0).buy(0);
    }

    public static Builder newBuilder(UserAction userAction) {
        if (userAction == null) {
            return newBuilder();
        }
        return new C$$AutoValue_UserAction.Builder(userAction);
    }

    public static TypeAdapter<UserAction> typeAdapter(Gson gson) {
        return new C$AutoValue_UserAction.GsonTypeAdapter(gson);
    }
}
