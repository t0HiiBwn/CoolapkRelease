package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_RecentHistory;
import com.coolapk.market.model.C$AutoValue_RecentHistory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class RecentHistory implements Entity {

    public static abstract class Builder {
        public abstract RecentHistory build();

        public abstract Builder setAnswerNum(int i);

        public abstract Builder setCommentNum(int i);

        public abstract Builder setCount(int i);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFansNum(int i);

        public abstract Builder setFollowNum(int i);

        public abstract Builder setId(String str);

        public abstract Builder setIsTop(int i);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLogo(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTargetId(String str);

        public abstract Builder setTargetType(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);
    }

    @SerializedName("answer_num")
    public abstract int getAnswerNum();

    @SerializedName("comment_num")
    public abstract int getCommentNum();

    public abstract int getCount();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "recentHistory";
    }

    @SerializedName("fans_num")
    public abstract int getFansNum();

    @SerializedName("follow_num")
    public abstract int getFollowNum();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    @SerializedName("is_top")
    public abstract int getIsTop();

    @SerializedName("target_id")
    public abstract String getTargetId();

    @SerializedName("target_type")
    public abstract String getTargetType();

    public abstract String getUid();

    public static TypeAdapter<RecentHistory> typeAdapter(Gson gson) {
        return new C$AutoValue_RecentHistory.GsonTypeAdapter(gson).setDefaultFollowNum(-1).setDefaultAnswerNum(-1).setDefaultCommentNum(-1).setDefaultFansNum(-1);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder newBuilder(RecentHistory recentHistory) {
        return new C$$AutoValue_RecentHistory.Builder(recentHistory);
    }
}
