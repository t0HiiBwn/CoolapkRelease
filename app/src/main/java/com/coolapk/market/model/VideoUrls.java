package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_VideoUrls;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class VideoUrls implements Parcelable {
    public abstract List<Integer> getDurationList();

    public abstract List<String> getUrlList();

    public static TypeAdapter<VideoUrls> typeAdapter(Gson gson) {
        return new C$AutoValue_VideoUrls.GsonTypeAdapter(gson);
    }
}
