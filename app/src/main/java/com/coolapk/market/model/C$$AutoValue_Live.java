package com.coolapk.market.model;

import com.coolapk.market.model.Live;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Live  reason: invalid class name */
abstract class C$$AutoValue_Live extends Live {
    private final int closeDiscuss;
    private final Long dateline;
    private final String description;
    private final int disableDiscussTab;
    private final int disallowPost;
    private final int disallowPostPic;
    private final int discussNum;
    private final String discussNumFormat;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final int followNum;
    private final String followNumFormat;
    private final String id;
    private final int isFollow;
    private final int isShowBannerTitle;
    private final Long lastUpdate;
    private final long liveEndTime;
    private final long liveStartTime;
    private final int liveStatus;
    private final long liveTime;
    private final String pic;
    private final String picUrl;
    private final String presenterUid;
    private final List<User> presenterUserInfo;
    private final int rankScore;
    private final String relationPageName;
    private final LiveProduct relationProduct;
    private final String relationTag;
    private final String showLiveTime;
    private final String showTab;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final User userInfo;
    private final String videoLiveInfo;
    private final String videoLiveUrl;
    private final String videoPlaybackUInfo;
    private final String videoPlaybackUrl;
    private final int visitNum;
    private final String visitNumFormat;

    C$$AutoValue_Live(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, LiveProduct liveProduct, int i, String str22, int i2, int i3, String str23, int i4, String str24, int i5, long j2, long j3, int i6, int i7, int i8, int i9, String str25, int i10, User user, int i11, List<User> list) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityId = str4;
        this.entityFixed = num;
        this.url = str5;
        this.pic = str6;
        this.subTitle = str7;
        this.id = str8;
        this.extraData = str9;
        this.dateline = l2;
        this.lastUpdate = l3;
        Objects.requireNonNull(str10, "Null uid");
        this.uid = str10;
        Objects.requireNonNull(str11, "Null title");
        this.title = str11;
        Objects.requireNonNull(str12, "Null presenterUid");
        this.presenterUid = str12;
        this.liveTime = j;
        Objects.requireNonNull(str13, "Null showLiveTime");
        this.showLiveTime = str13;
        Objects.requireNonNull(str14, "Null description");
        this.description = str14;
        this.picUrl = str15;
        this.videoLiveUrl = str16;
        this.videoLiveInfo = str17;
        this.videoPlaybackUrl = str18;
        this.videoPlaybackUInfo = str19;
        this.relationTag = str20;
        this.relationPageName = str21;
        this.relationProduct = liveProduct;
        this.isShowBannerTitle = i;
        Objects.requireNonNull(str22, "Null followNumFormat");
        this.followNumFormat = str22;
        this.followNum = i2;
        this.discussNum = i3;
        Objects.requireNonNull(str23, "Null discussNumFormat");
        this.discussNumFormat = str23;
        this.visitNum = i4;
        Objects.requireNonNull(str24, "Null visitNumFormat");
        this.visitNumFormat = str24;
        this.rankScore = i5;
        this.liveStartTime = j2;
        this.liveEndTime = j3;
        this.liveStatus = i6;
        this.disallowPost = i7;
        this.disallowPostPic = i8;
        this.disableDiscussTab = i9;
        Objects.requireNonNull(str25, "Null showTab");
        this.showTab = str25;
        this.closeDiscuss = i10;
        Objects.requireNonNull(user, "Null userInfo");
        this.userInfo = user;
        this.isFollow = i11;
        Objects.requireNonNull(list, "Null presenterUserInfo");
        this.presenterUserInfo = list;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.Live
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Live, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("presenter_uid")
    public String getPresenterUid() {
        return this.presenterUid;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("live_time")
    public long getLiveTime() {
        return this.liveTime;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("show_live_time")
    public String getShowLiveTime() {
        return this.showLiveTime;
    }

    @Override // com.coolapk.market.model.Live, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("pic_url")
    public String getPicUrl() {
        return this.picUrl;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("video_live_url")
    public String getVideoLiveUrl() {
        return this.videoLiveUrl;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("video_live_info")
    public String getVideoLiveInfo() {
        return this.videoLiveInfo;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("video_playback_url")
    public String getVideoPlaybackUrl() {
        return this.videoPlaybackUrl;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("video_playback_info")
    public String getVideoPlaybackUInfo() {
        return this.videoPlaybackUInfo;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("relation_tag")
    public String getRelationTag() {
        return this.relationTag;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("relation_page_name")
    public String getRelationPageName() {
        return this.relationPageName;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("relation_product")
    public LiveProduct getRelationProduct() {
        return this.relationProduct;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("show_banner_title")
    public int getIsShowBannerTitle() {
        return this.isShowBannerTitle;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("follow_num_format")
    public String getFollowNumFormat() {
        return this.followNumFormat;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("follow_num")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("discuss_num")
    public int getDiscussNum() {
        return this.discussNum;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("discuss_num_format")
    public String getDiscussNumFormat() {
        return this.discussNumFormat;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("visit_num")
    public int getVisitNum() {
        return this.visitNum;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("visit_num_format")
    public String getVisitNumFormat() {
        return this.visitNumFormat;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("rank_scrore")
    public int getRankScore() {
        return this.rankScore;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("live_start_time")
    public long getLiveStartTime() {
        return this.liveStartTime;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("live_end_time")
    public long getLiveEndTime() {
        return this.liveEndTime;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("live_status")
    public int getLiveStatus() {
        return this.liveStatus;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("disallow_post")
    protected int getDisallowPost() {
        return this.disallowPost;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("disallow_post_pic")
    protected int getDisallowPostPic() {
        return this.disallowPostPic;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("disable_discuss_tab")
    protected int getDisableDiscussTab() {
        return this.disableDiscussTab;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("show_tab")
    public String getShowTab() {
        return this.showTab;
    }

    @Override // com.coolapk.market.model.Live
    @SerializedName("close_discuss")
    public int getCloseDiscuss() {
        return this.closeDiscuss;
    }

    @Override // com.coolapk.market.model.Live
    public User getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.Live
    public int getIsFollow() {
        return this.isFollow;
    }

    @Override // com.coolapk.market.model.Live
    public List<User> getPresenterUserInfo() {
        return this.presenterUserInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Live{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", uid=" + this.uid + ", title=" + this.title + ", presenterUid=" + this.presenterUid + ", liveTime=" + this.liveTime + ", showLiveTime=" + this.showLiveTime + ", description=" + this.description + ", picUrl=" + this.picUrl + ", videoLiveUrl=" + this.videoLiveUrl + ", videoLiveInfo=" + this.videoLiveInfo + ", videoPlaybackUrl=" + this.videoPlaybackUrl + ", videoPlaybackUInfo=" + this.videoPlaybackUInfo + ", relationTag=" + this.relationTag + ", relationPageName=" + this.relationPageName + ", relationProduct=" + this.relationProduct + ", isShowBannerTitle=" + this.isShowBannerTitle + ", followNumFormat=" + this.followNumFormat + ", followNum=" + this.followNum + ", discussNum=" + this.discussNum + ", discussNumFormat=" + this.discussNumFormat + ", visitNum=" + this.visitNum + ", visitNumFormat=" + this.visitNumFormat + ", rankScore=" + this.rankScore + ", liveStartTime=" + this.liveStartTime + ", liveEndTime=" + this.liveEndTime + ", liveStatus=" + this.liveStatus + ", disallowPost=" + this.disallowPost + ", disallowPostPic=" + this.disallowPostPic + ", disableDiscussTab=" + this.disableDiscussTab + ", showTab=" + this.showTab + ", closeDiscuss=" + this.closeDiscuss + ", userInfo=" + this.userInfo + ", isFollow=" + this.isFollow + ", presenterUserInfo=" + this.presenterUserInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Long l2;
        Long l3;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        LiveProduct liveProduct;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Live)) {
            return false;
        }
        Live live = (Live) obj;
        String str15 = this.entityTypeName;
        if (str15 != null ? str15.equals(live.getEntityTypeName()) : live.getEntityTypeName() == null) {
            if (this.entityType.equals(live.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(live.getEntityTemplate()) : live.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(live.getEntityId()) : live.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(live.getEntityFixed()) : live.getEntityFixed() == null) && ((str3 = this.url) != null ? str3.equals(live.getUrl()) : live.getUrl() == null) && ((str4 = this.pic) != null ? str4.equals(live.getPic()) : live.getPic() == null) && ((str5 = this.subTitle) != null ? str5.equals(live.getSubTitle()) : live.getSubTitle() == null) && ((str6 = this.id) != null ? str6.equals(live.getId()) : live.getId() == null) && ((str7 = this.extraData) != null ? str7.equals(live.getExtraData()) : live.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(live.getDateline()) : live.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(live.getLastUpdate()) : live.getLastUpdate() == null) && this.uid.equals(live.getUid()) && this.title.equals(live.getTitle()) && this.presenterUid.equals(live.getPresenterUid()) && this.liveTime == live.getLiveTime() && this.showLiveTime.equals(live.getShowLiveTime()) && this.description.equals(live.getDescription()) && ((str8 = this.picUrl) != null ? str8.equals(live.getPicUrl()) : live.getPicUrl() == null) && ((str9 = this.videoLiveUrl) != null ? str9.equals(live.getVideoLiveUrl()) : live.getVideoLiveUrl() == null) && ((str10 = this.videoLiveInfo) != null ? str10.equals(live.getVideoLiveInfo()) : live.getVideoLiveInfo() == null) && ((str11 = this.videoPlaybackUrl) != null ? str11.equals(live.getVideoPlaybackUrl()) : live.getVideoPlaybackUrl() == null) && ((str12 = this.videoPlaybackUInfo) != null ? str12.equals(live.getVideoPlaybackUInfo()) : live.getVideoPlaybackUInfo() == null) && ((str13 = this.relationTag) != null ? str13.equals(live.getRelationTag()) : live.getRelationTag() == null) && ((str14 = this.relationPageName) != null ? str14.equals(live.getRelationPageName()) : live.getRelationPageName() == null) && ((liveProduct = this.relationProduct) != null ? liveProduct.equals(live.getRelationProduct()) : live.getRelationProduct() == null) && this.isShowBannerTitle == live.getIsShowBannerTitle() && this.followNumFormat.equals(live.getFollowNumFormat()) && this.followNum == live.getFollowNum() && this.discussNum == live.getDiscussNum() && this.discussNumFormat.equals(live.getDiscussNumFormat()) && this.visitNum == live.getVisitNum() && this.visitNumFormat.equals(live.getVisitNumFormat()) && this.rankScore == live.getRankScore() && this.liveStartTime == live.getLiveStartTime() && this.liveEndTime == live.getLiveEndTime() && this.liveStatus == live.getLiveStatus() && this.disallowPost == live.getDisallowPost() && this.disallowPostPic == live.getDisallowPostPic() && this.disableDiscussTab == live.getDisableDiscussTab() && this.showTab.equals(live.getShowTab()) && this.closeDiscuss == live.getCloseDiscuss() && this.userInfo.equals(live.getUserInfo()) && this.isFollow == live.getIsFollow() && this.presenterUserInfo.equals(live.getPresenterUserInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.entityType.hashCode()) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.subTitle;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.id;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode11 = l3 == null ? 0 : l3.hashCode();
        long j = this.liveTime;
        int hashCode12 = (((this.showLiveTime.hashCode() ^ (((int) (((long) ((((((((hashCode10 ^ hashCode11) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.presenterUid.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) * 1000003) ^ this.description.hashCode()) * 1000003;
        String str9 = this.picUrl;
        int hashCode13 = (hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.videoLiveUrl;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.videoLiveInfo;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.videoPlaybackUrl;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.videoPlaybackUInfo;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.relationTag;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.relationPageName;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        LiveProduct liveProduct = this.relationProduct;
        if (liveProduct != null) {
            i = liveProduct.hashCode();
        }
        long j2 = this.liveStartTime;
        long j3 = this.liveEndTime;
        return ((((((((((((((((this.liveStatus ^ (((int) (((j3 >>> 32) ^ j3) ^ ((long) (((int) (((long) ((((((((((((((((((i ^ hashCode19) * 1000003) ^ this.isShowBannerTitle) * 1000003) ^ this.followNumFormat.hashCode()) * 1000003) ^ this.followNum) * 1000003) ^ this.discussNum) * 1000003) ^ this.discussNumFormat.hashCode()) * 1000003) ^ this.visitNum) * 1000003) ^ this.visitNumFormat.hashCode()) * 1000003) ^ this.rankScore) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)))) * 1000003)) * 1000003) ^ this.disallowPost) * 1000003) ^ this.disallowPostPic) * 1000003) ^ this.disableDiscussTab) * 1000003) ^ this.showTab.hashCode()) * 1000003) ^ this.closeDiscuss) * 1000003) ^ this.userInfo.hashCode()) * 1000003) ^ this.isFollow) * 1000003) ^ this.presenterUserInfo.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Live$Builder */
    /* compiled from: $$AutoValue_Live */
    static final class Builder extends Live.Builder {
        private Integer closeDiscuss;
        private Long dateline;
        private String description;
        private Integer disableDiscussTab;
        private Integer disallowPost;
        private Integer disallowPostPic;
        private Integer discussNum;
        private String discussNumFormat;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private Integer followNum;
        private String followNumFormat;
        private String id;
        private Integer isFollow;
        private Integer isShowBannerTitle;
        private Long lastUpdate;
        private Long liveEndTime;
        private Long liveStartTime;
        private Integer liveStatus;
        private Long liveTime;
        private String pic;
        private String picUrl;
        private String presenterUid;
        private List<User> presenterUserInfo;
        private Integer rankScore;
        private String relationPageName;
        private LiveProduct relationProduct;
        private String relationTag;
        private String showLiveTime;
        private String showTab;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private User userInfo;
        private String videoLiveInfo;
        private String videoLiveUrl;
        private String videoPlaybackUInfo;
        private String videoPlaybackUrl;
        private Integer visitNum;
        private String visitNumFormat;

        Builder() {
        }

        Builder(Live live) {
            this.entityTypeName = live.getEntityTypeName();
            this.entityType = live.getEntityType();
            this.entityTemplate = live.getEntityTemplate();
            this.entityId = live.getEntityId();
            this.entityFixed = live.getEntityFixed();
            this.url = live.getUrl();
            this.pic = live.getPic();
            this.subTitle = live.getSubTitle();
            this.id = live.getId();
            this.extraData = live.getExtraData();
            this.dateline = live.getDateline();
            this.lastUpdate = live.getLastUpdate();
            this.uid = live.getUid();
            this.title = live.getTitle();
            this.presenterUid = live.getPresenterUid();
            this.liveTime = Long.valueOf(live.getLiveTime());
            this.showLiveTime = live.getShowLiveTime();
            this.description = live.getDescription();
            this.picUrl = live.getPicUrl();
            this.videoLiveUrl = live.getVideoLiveUrl();
            this.videoLiveInfo = live.getVideoLiveInfo();
            this.videoPlaybackUrl = live.getVideoPlaybackUrl();
            this.videoPlaybackUInfo = live.getVideoPlaybackUInfo();
            this.relationTag = live.getRelationTag();
            this.relationPageName = live.getRelationPageName();
            this.relationProduct = live.getRelationProduct();
            this.isShowBannerTitle = Integer.valueOf(live.getIsShowBannerTitle());
            this.followNumFormat = live.getFollowNumFormat();
            this.followNum = Integer.valueOf(live.getFollowNum());
            this.discussNum = Integer.valueOf(live.getDiscussNum());
            this.discussNumFormat = live.getDiscussNumFormat();
            this.visitNum = Integer.valueOf(live.getVisitNum());
            this.visitNumFormat = live.getVisitNumFormat();
            this.rankScore = Integer.valueOf(live.getRankScore());
            this.liveStartTime = Long.valueOf(live.getLiveStartTime());
            this.liveEndTime = Long.valueOf(live.getLiveEndTime());
            this.liveStatus = Integer.valueOf(live.getLiveStatus());
            this.disallowPost = Integer.valueOf(live.getDisallowPost());
            this.disallowPostPic = Integer.valueOf(live.getDisallowPostPic());
            this.disableDiscussTab = Integer.valueOf(live.getDisableDiscussTab());
            this.showTab = live.getShowTab();
            this.closeDiscuss = Integer.valueOf(live.getCloseDiscuss());
            this.userInfo = live.getUserInfo();
            this.isFollow = Integer.valueOf(live.getIsFollow());
            this.presenterUserInfo = live.getPresenterUserInfo();
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setPresenterUid(String str) {
            this.presenterUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setLiveTime(long j) {
            this.liveTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setShowLiveTime(String str) {
            this.showLiveTime = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setPicUrl(String str) {
            this.picUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setVideoLiveUrl(String str) {
            this.videoLiveUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setVideoLiveInfo(String str) {
            this.videoLiveInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setVideoPlaybackUrl(String str) {
            this.videoPlaybackUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setVideoPlaybackUInfo(String str) {
            this.videoPlaybackUInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setRelationTag(String str) {
            this.relationTag = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setRelationPageName(String str) {
            this.relationPageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setRelationProduct(LiveProduct liveProduct) {
            this.relationProduct = liveProduct;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setIsShowBannerTitle(int i) {
            this.isShowBannerTitle = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setFollowNumFormat(String str) {
            this.followNumFormat = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setFollowNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDiscussNum(int i) {
            this.discussNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDiscussNumFormat(String str) {
            this.discussNumFormat = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setVisitNum(int i) {
            this.visitNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setVisitNumFormat(String str) {
            this.visitNumFormat = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setRankScore(int i) {
            this.rankScore = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setLiveStartTime(long j) {
            this.liveStartTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setLiveEndTime(long j) {
            this.liveEndTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setLiveStatus(int i) {
            this.liveStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDisallowPost(int i) {
            this.disallowPost = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDisallowPostPic(int i) {
            this.disallowPostPic = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setDisableDiscussTab(int i) {
            this.disableDiscussTab = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setShowTab(String str) {
            this.showTab = str;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setCloseDiscuss(int i) {
            this.closeDiscuss = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setUserInfo(User user) {
            this.userInfo = user;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setIsFollow(int i) {
            this.isFollow = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live.Builder setPresenterUserInfo(List<User> list) {
            this.presenterUserInfo = list;
            return this;
        }

        @Override // com.coolapk.market.model.Live.Builder
        public Live build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.title == null) {
                str = str + " title";
            }
            if (this.presenterUid == null) {
                str = str + " presenterUid";
            }
            if (this.liveTime == null) {
                str = str + " liveTime";
            }
            if (this.showLiveTime == null) {
                str = str + " showLiveTime";
            }
            if (this.description == null) {
                str = str + " description";
            }
            if (this.isShowBannerTitle == null) {
                str = str + " isShowBannerTitle";
            }
            if (this.followNumFormat == null) {
                str = str + " followNumFormat";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.discussNum == null) {
                str = str + " discussNum";
            }
            if (this.discussNumFormat == null) {
                str = str + " discussNumFormat";
            }
            if (this.visitNum == null) {
                str = str + " visitNum";
            }
            if (this.visitNumFormat == null) {
                str = str + " visitNumFormat";
            }
            if (this.rankScore == null) {
                str = str + " rankScore";
            }
            if (this.liveStartTime == null) {
                str = str + " liveStartTime";
            }
            if (this.liveEndTime == null) {
                str = str + " liveEndTime";
            }
            if (this.liveStatus == null) {
                str = str + " liveStatus";
            }
            if (this.disallowPost == null) {
                str = str + " disallowPost";
            }
            if (this.disallowPostPic == null) {
                str = str + " disallowPostPic";
            }
            if (this.disableDiscussTab == null) {
                str = str + " disableDiscussTab";
            }
            if (this.showTab == null) {
                str = str + " showTab";
            }
            if (this.closeDiscuss == null) {
                str = str + " closeDiscuss";
            }
            if (this.userInfo == null) {
                str = str + " userInfo";
            }
            if (this.isFollow == null) {
                str = str + " isFollow";
            }
            if (this.presenterUserInfo == null) {
                str = str + " presenterUserInfo";
            }
            if (str.isEmpty()) {
                return new AutoValue_Live(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.pic, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.uid, this.title, this.presenterUid, this.liveTime.longValue(), this.showLiveTime, this.description, this.picUrl, this.videoLiveUrl, this.videoLiveInfo, this.videoPlaybackUrl, this.videoPlaybackUInfo, this.relationTag, this.relationPageName, this.relationProduct, this.isShowBannerTitle.intValue(), this.followNumFormat, this.followNum.intValue(), this.discussNum.intValue(), this.discussNumFormat, this.visitNum.intValue(), this.visitNumFormat, this.rankScore.intValue(), this.liveStartTime.longValue(), this.liveEndTime.longValue(), this.liveStatus.intValue(), this.disallowPost.intValue(), this.disallowPostPic.intValue(), this.disableDiscussTab.intValue(), this.showTab, this.closeDiscuss.intValue(), this.userInfo, this.isFollow.intValue(), this.presenterUserInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
