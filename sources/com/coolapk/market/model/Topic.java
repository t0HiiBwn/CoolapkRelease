package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_Topic;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class Topic implements Entity {
    @SerializedName("ad_link_url")
    public abstract String getAdLinkUrl();

    @SerializedName("ad_pic_url")
    public abstract String getAdPicUrl();

    @SerializedName("bgColor")
    public abstract String getBgColor();

    public abstract int getClick();

    @SerializedName("commentnum")
    public abstract int getCommentNum();

    public abstract String getCover();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    @SerializedName("follownum")
    public abstract int getFollowNum();

    @SerializedName("hot_num")
    public abstract int getHotNum();

    @SerializedName("hot_num_txt")
    public abstract String getHotNumText();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    @SerializedName("intro")
    public abstract String getIntro();

    @SerializedName("is_live")
    public abstract int getIsLive();

    @SerializedName("is_recommend")
    public abstract int getIsRecommend();

    @SerializedName("live_end_at")
    public abstract long getLiveEndAt();

    @SerializedName("livePresenterNames")
    public abstract String getLivePresenterNames();

    @SerializedName("live_start_at")
    public abstract long getLiveStartAt();

    @SerializedName("live_status")
    public abstract int getLivingStatus();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @SerializedName("phone_info")
    public abstract String getPhoneInfo();

    @SerializedName("phone_price")
    public abstract String getPhonePrice();

    @SerializedName("recent_follow_list")
    public abstract List<RelatedData> getRecentFollowList();

    @SerializedName("recommendRows")
    public abstract List<NewHeadLine> getRecommendRows();

    @SerializedName("selectedTab")
    public abstract String getSelectedTab();

    @SerializedName("show_date")
    public abstract String getShowDate();

    @SerializedName("tabList")
    public abstract List<ConfigPage> getTabApiList();

    @SerializedName("tag_category")
    public abstract String getTagCategory();

    @SerializedName("tag_pics")
    public abstract List<String> getTagPics();

    @SerializedName("tag_type")
    public abstract int getTagType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @SerializedName("top_feed_id")
    public abstract int getTopFeedId();

    @SerializedName("top_ids")
    public abstract List<String> getTopIds();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public abstract String getUrl();

    public abstract UserAction getUserAction();

    @SerializedName("video_url")
    public abstract String getVideoUrl();

    @SerializedName("votenum1")
    public abstract int getVoteNum1();

    @SerializedName("votenum2")
    public abstract int getVoteNum2();

    @SerializedName("votenum3")
    public abstract int getVoteNum3();

    @SerializedName("votenum4")
    public abstract int getVoteNum4();

    @SerializedName("votenum5")
    public abstract int getVoteNum5();

    public static TypeAdapter<Topic> typeAdapter(Gson gson) {
        return new C$AutoValue_Topic.GsonTypeAdapter(gson);
    }

    public boolean isUserFollow() {
        return getUserAction() != null && getUserAction().getFollow() > 0;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
