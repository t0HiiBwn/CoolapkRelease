package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_Vote;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class Vote implements Parcelable {
    public static final long VOTE_END_TIME_DATE_MODE = -2;
    public static final long VOTE_END_TIME_DAY = 86400;
    public static final long VOTE_END_TIME_MONTH = 2592000;
    public static final long VOTE_END_TIME_UNSET = -1;
    public static final long VOTE_END_TIME_WEEK = 604800;
    public static final int VOTE_TYPE_MULTI = 1;
    public static final int VOTE_TYPE_PK = 0;

    @SerializedName("anonymous_status")
    public abstract int getAnonymousStatus();

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @SerializedName("create_time")
    public abstract int getCreateTime();

    @SerializedName("create_uid")
    public abstract String getCreateUid();

    @SerializedName("end_time")
    public abstract long getEndTime();

    @SerializedName("id")
    public abstract String getId();

    @SerializedName("last_update")
    public abstract String getLastUpdate();

    @SerializedName("link_page")
    public abstract String getLinkPage();

    @SerializedName("link_tag")
    public abstract String getLinkTag();

    @SerializedName("link_tag_entity")
    public abstract Topic getLinkTagEntity();

    @SerializedName("max_select_num")
    public abstract int getMaxSelectNum();

    @SerializedName("message_title")
    public abstract String getMessageTitle();

    @SerializedName("min_select_num")
    public abstract int getMinSelectNum();

    @SerializedName("recommend_ids")
    public abstract String getRecommendIds();

    @SerializedName("show_author")
    public abstract int getShowAuthor();

    @SerializedName("start_time")
    public abstract int getStartTime();

    @SerializedName("status")
    public abstract int getStatus();

    @SerializedName("top_ids")
    public abstract String getTopIds();

    @SerializedName("total_comment_num")
    public abstract int getTotalCommentNum();

    @SerializedName("total_option_num")
    public abstract int getTotalOptionNum();

    @SerializedName("total_vote_num")
    public abstract int getTotalVoteNum();

    @SerializedName("type")
    public abstract int getType();

    @SerializedName("update_time")
    public abstract int getUpdateTime();

    @SerializedName("update_uid")
    public abstract String getUpdateUid();

    @SerializedName("user_anonymous_status")
    public abstract int getUserAnonymousStatus();

    @SerializedName("user_change_vote_status")
    public abstract int getUserChangeVoteStatus();

    @SerializedName("user_selected_option")
    public abstract String getUserSelectedOptions();

    @SerializedName("user_vote_comment_status")
    public abstract int getUserVoteCommentStatus();

    @SerializedName("options")
    public abstract List<VoteOption> getVoteOptions();

    public static TypeAdapter<Vote> typeAdapter(Gson gson) {
        return new C$AutoValue_Vote.GsonTypeAdapter(gson);
    }
}
