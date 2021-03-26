package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_FeedStatus;
import com.coolapk.market.model.C$AutoValue_FeedStatus;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FeedStatus implements CardContent {

    public static abstract class Builder {
        public abstract Builder blockStatus(int i);

        public abstract Builder blockStatusText(String str);

        public abstract FeedStatus build();

        public abstract Builder isHeadlineV8(int i);

        public abstract Builder messageStatus(int i);

        public abstract Builder messageStatusText(String str);

        public abstract Builder recommend(int i);

        public abstract Builder status(int i);

        public abstract Builder statusText(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    public abstract String getBlockStatusText();

    public abstract int getIsHeadlineV8();

    @SerializedName("message_status")
    public abstract int getMessageStatus();

    public abstract String getMessageStatusText();

    public abstract int getRecommend();

    public abstract int getStatus();

    public abstract String getStatusText();

    public static Builder newBuilder() {
        return new C$$AutoValue_FeedStatus.Builder().recommend(0).blockStatus(0).messageStatus(0).isHeadlineV8(0).status(0);
    }

    public static Builder newBuilder(FeedStatus feedStatus) {
        if (feedStatus == null) {
            return newBuilder();
        }
        return new C$$AutoValue_FeedStatus.Builder(feedStatus);
    }

    public static TypeAdapter<FeedStatus> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedStatus.GsonTypeAdapter(gson);
    }
}
