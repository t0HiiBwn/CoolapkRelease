package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_Unread;
import com.coolapk.market.model.C$AutoValue_Unread;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Unread implements CardContent {

    public static abstract class Builder {
        public abstract Unread build();

        public abstract Builder unreadNum(int i);

        public abstract Builder unreadTitle(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("num")
    public abstract int getUnreadNum();

    @SerializedName("title")
    public abstract String getUnreadTitle();

    public static TypeAdapter<Unread> typeAdapter(Gson gson) {
        return new C$AutoValue_Unread.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_Unread.Builder();
    }

    public static Builder newBuilder(Unread unread) {
        if (unread == null) {
            return newBuilder();
        }
        return new C$$AutoValue_Unread.Builder(unread);
    }
}
