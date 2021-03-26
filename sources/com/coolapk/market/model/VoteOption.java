package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_VoteOption;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class VoteOption implements Parcelable {
    @SerializedName("color")
    public abstract String getColor();

    @SerializedName("id")
    public abstract String getId();

    @SerializedName("order")
    public abstract int getOrder();

    @SerializedName("title")
    public abstract String getTitle();

    @SerializedName("total_comment_num")
    public abstract int getTotalCommentNum();

    @SerializedName("total_select_num")
    public abstract int getTotalSelectNum();

    @SerializedName("vote_id")
    public abstract String getVoteId();

    public static TypeAdapter<VoteOption> typeAdapter(Gson gson) {
        return new C$AutoValue_VoteOption.GsonTypeAdapter(gson);
    }
}
