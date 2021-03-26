package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$$AutoValue_SimpleInfo;
import com.coolapk.market.model.C$AutoValue_SimpleInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class SimpleInfo implements Parcelable {

    public static abstract class Builder {
        public abstract SimpleInfo build();

        public abstract Builder setIcon(String str);

        public abstract Builder setMessage(String str);

        public abstract Builder setUrl(String str);
    }

    @SerializedName("icon")
    public abstract String getIcon();

    @SerializedName("message")
    public abstract String getMessage();

    @SerializedName("url")
    public abstract String getUrl();

    public static TypeAdapter<SimpleInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_SimpleInfo.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_SimpleInfo.Builder();
    }
}
