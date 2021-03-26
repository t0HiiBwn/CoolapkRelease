package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_NodeTargetInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class NodeTargetInfo implements Entity {
    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "target_info";
    }

    @SerializedName("rating_average_score")
    public abstract String getRatingAverageScore();

    @SerializedName("rating_total_num")
    public abstract String getRatingTotalNum();

    @SerializedName("score")
    public abstract String getScore();

    @SerializedName("voteCount")
    public abstract String getVoteCount();

    public static TypeAdapter<NodeTargetInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_NodeTargetInfo.GsonTypeAdapter(gson);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getRealVoteCount() {
        if (getVoteCount() != null) {
            return getVoteCount();
        }
        if (getRatingTotalNum() != null) {
            return getRatingTotalNum();
        }
        return null;
    }

    public String getRealScore() {
        if (getScore() != null) {
            return getScore();
        }
        if (getRatingAverageScore() != null) {
            return getRatingAverageScore();
        }
        return null;
    }
}
