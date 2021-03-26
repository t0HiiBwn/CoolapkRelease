package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_FeedQuestion;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FeedQuestion implements Entity, IUser {
    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    public abstract String getMessage();

    @SerializedName("message_status")
    public abstract int getMessageStatus();

    @SerializedName("message_title")
    public abstract String getMessageTitle();

    @SerializedName("question_answer_num")
    public abstract int getQuestionAnswerNum();

    @SerializedName("question_follow_num")
    public abstract int getQuestionFollowNum();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public static TypeAdapter<FeedQuestion> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedQuestion.GsonTypeAdapter(gson);
    }
}
