package com.coolapk.market.model;

import com.coolapk.market.model.AutoValue_LikeResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class LikeResult {
    public abstract int getCount();

    public abstract List<String> getRecentLikeList();

    public abstract List<RelatedData> getUserLikeList();

    public static TypeAdapter<LikeResult> typeAdapter(Gson gson) {
        return new AutoValue_LikeResult.GsonTypeAdapter(gson);
    }
}
