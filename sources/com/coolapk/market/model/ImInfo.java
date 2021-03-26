package com.coolapk.market.model;

import com.coolapk.market.model.AutoValue_ImInfo;
import com.coolapk.market.model.C$AutoValue_ImInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class ImInfo {

    public static abstract class Builder {
        public abstract ImInfo build();

        public abstract Builder userId(String str);

        public abstract Builder userSig(String str);
    }

    public abstract String userId();

    public abstract String userSig();

    public static TypeAdapter<ImInfo> typeAdapter(Gson gson) {
        return new AutoValue_ImInfo.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$AutoValue_ImInfo.Builder();
    }
}
