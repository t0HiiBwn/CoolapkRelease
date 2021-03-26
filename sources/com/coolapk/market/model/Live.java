package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_Live;
import com.coolapk.market.model.C$AutoValue_Live;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

public abstract class Live implements Entity {
    public static final int DISCUSS_DISABLE = 1;
    public static final int DISCUSS_ENABLE = 0;
    public static final int DISCUSS_TAB_DISABLE = 1;
    public static final int DISCUSS_TAB_ENABLE = 0;
    public static final String LIVE_SHOW_TAB_DISCUSS = "discuss";
    public static final String LIVE_SHOW_TAB_INTRO = "intro";
    public static final String LIVE_SHOW_TAB_LIVE = "live";
    public static final String LIVE_SHOW_TAB_PRODUCT = "product";
    public static final String LIVE_SHOW_TAB_RELATIVE = "page";
    public static final String LIVE_SHOW_TAB_TOPIC = "topic";
    public static final int LIVE_STATE_CLOSE = -1;
    public static final int LIVE_STATE_NOT_START = 0;
    public static final int LIVE_STATE_START = 1;
    public static final int POST_DISABLE = 1;
    public static final int POST_ENABLE = 0;
    public static final int POST_PIC_DISABLE = 1;
    public static final int POST_PIC_ENABLE = 0;
    public static final int STATE_CLOSE = -1;
    public static final int STATE_EDIT = 0;
    public static final int STATE_OPEN = 1;
    private List<String> presenterUidList;

    public static abstract class Builder {
        public abstract Live build();

        public abstract Builder setCloseDiscuss(int i);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setDisableDiscussTab(int i);

        public abstract Builder setDisallowPost(int i);

        public abstract Builder setDisallowPostPic(int i);

        public abstract Builder setDiscussNum(int i);

        public abstract Builder setDiscussNumFormat(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFollowNum(int i);

        public abstract Builder setFollowNumFormat(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsFollow(int i);

        public abstract Builder setIsShowBannerTitle(int i);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLiveEndTime(long j);

        public abstract Builder setLiveStartTime(long j);

        public abstract Builder setLiveStatus(int i);

        public abstract Builder setLiveTime(long j);

        public abstract Builder setPic(String str);

        public abstract Builder setPicUrl(String str);

        public abstract Builder setPresenterUid(String str);

        public abstract Builder setPresenterUserInfo(List<User> list);

        public abstract Builder setRankScore(int i);

        public abstract Builder setRelationGroupId(String str);

        public abstract Builder setRelationPageName(String str);

        public abstract Builder setRelationProduct(LiveProduct liveProduct);

        public abstract Builder setRelationTag(String str);

        public abstract Builder setShowLiveTime(String str);

        public abstract Builder setShowTab(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);

        public abstract Builder setUserInfo(User user);

        public abstract Builder setVideoLiveInfo(String str);

        public abstract Builder setVideoLiveUrl(String str);

        public abstract Builder setVideoPlaybackUInfo(String str);

        public abstract Builder setVideoPlaybackUrl(String str);

        public abstract Builder setVisitNum(int i);

        public abstract Builder setVisitNumFormat(String str);
    }

    @SerializedName("close_discuss")
    public abstract int getCloseDiscuss();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    @SerializedName("disable_discuss_tab")
    protected abstract int getDisableDiscussTab();

    @SerializedName("disallow_post")
    protected abstract int getDisallowPost();

    @SerializedName("disallow_post_pic")
    protected abstract int getDisallowPostPic();

    @SerializedName("discuss_num")
    public abstract int getDiscussNum();

    @SerializedName("discuss_num_format")
    public abstract String getDiscussNumFormat();

    @SerializedName("follow_num")
    public abstract int getFollowNum();

    @SerializedName("follow_num_format")
    public abstract String getFollowNumFormat();

    public abstract int getIsFollow();

    @SerializedName("show_banner_title")
    public abstract int getIsShowBannerTitle();

    @SerializedName("live_end_time")
    public abstract long getLiveEndTime();

    @SerializedName("live_start_time")
    public abstract long getLiveStartTime();

    @SerializedName("live_status")
    public abstract int getLiveStatus();

    @SerializedName("live_time")
    public abstract long getLiveTime();

    @SerializedName("pic_url")
    public abstract String getPicUrl();

    @SerializedName("presenter_uid")
    public abstract String getPresenterUid();

    public abstract List<User> getPresenterUserInfo();

    @SerializedName("rank_scrore")
    public abstract int getRankScore();

    @SerializedName("relation_group_id")
    public abstract String getRelationGroupId();

    @SerializedName("relation_page_name")
    public abstract String getRelationPageName();

    @SerializedName("relation_product")
    public abstract LiveProduct getRelationProduct();

    @SerializedName("relation_tag")
    public abstract String getRelationTag();

    @SerializedName("show_live_time")
    public abstract String getShowLiveTime();

    @SerializedName("show_tab")
    public abstract String getShowTab();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public abstract String getUid();

    public abstract User getUserInfo();

    @SerializedName("video_live_info")
    public abstract String getVideoLiveInfo();

    @SerializedName("video_live_url")
    public abstract String getVideoLiveUrl();

    @SerializedName("video_playback_info")
    public abstract String getVideoPlaybackUInfo();

    @SerializedName("video_playback_url")
    public abstract String getVideoPlaybackUrl();

    @SerializedName("visit_num")
    public abstract int getVisitNum();

    @SerializedName("visit_num_format")
    public abstract String getVisitNumFormat();

    public static TypeAdapter<Live> typeAdapter(Gson gson) {
        return new C$AutoValue_Live.GsonTypeAdapter(gson);
    }

    @Override // com.coolapk.market.model.Entity
    public String getLogo() {
        return getPicUrl();
    }

    public boolean canPost() {
        return getDisallowPost() == 0;
    }

    public boolean canPostPic() {
        return getDisallowPostPic() == 0;
    }

    public boolean isDiscussTabEnable() {
        return getDisableDiscussTab() == 0;
    }

    public boolean isDiscussEnable() {
        return getCloseDiscuss() == 0;
    }

    public boolean isFollow() {
        return getIsFollow() == 1;
    }

    public List<String> getPresenterUidList() {
        if (this.presenterUidList == null) {
            this.presenterUidList = Arrays.asList(getPresenterUid().split(","));
        }
        return this.presenterUidList;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder builder(Live live) {
        return new C$$AutoValue_Live.Builder(live);
    }
}
