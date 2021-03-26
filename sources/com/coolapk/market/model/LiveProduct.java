package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_LiveProduct;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class LiveProduct implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getId();

    public abstract String getLogo();

    public abstract String getTitle();

    public static TypeAdapter<LiveProduct> typeAdapter(Gson gson) {
        return new C$AutoValue_LiveProduct.GsonTypeAdapter(gson);
    }
}
