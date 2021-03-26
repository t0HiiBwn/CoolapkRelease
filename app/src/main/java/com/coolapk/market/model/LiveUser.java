package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_LiveUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class LiveUser implements Entity {
    public static final int POST_DISABLE = 1;
    public static final int POST_ENABLE = 0;
    public static final int POST_PIC_DISABLE = 1;
    public static final int POST_PIC_ENABLE = 0;

    @SerializedName("disallow_post")
    protected abstract int getDisallowPost();

    @SerializedName("disallow_post_pic")
    protected abstract int getDisallowPostPic();

    @SerializedName("live_id")
    public abstract String getLiveId();

    public abstract String getUid();

    public abstract String getUserAvatar();

    public abstract User getUserInfo();

    public static TypeAdapter<LiveUser> typeAdapter(Gson gson) {
        return new C$AutoValue_LiveUser.GsonTypeAdapter(gson);
    }

    public boolean canPost() {
        return getDisallowPost() == 0;
    }

    public boolean canPostPic() {
        return getDisallowPostPic() == 0;
    }
}
