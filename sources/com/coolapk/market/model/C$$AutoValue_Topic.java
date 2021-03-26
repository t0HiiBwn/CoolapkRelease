package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Topic  reason: invalid class name */
abstract class C$$AutoValue_Topic extends Topic {
    private final String adLinkUrl;
    private final String adPicUrl;
    private final String bgColor;
    private final int click;
    private final int commentNum;
    private final String cover;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final int followNum;
    private final int hotNum;
    private final String hotNumText;
    private final String id;
    private final String intro;
    private final int isLive;
    private final int isRecommend;
    private final Long lastUpdate;
    private final long liveEndAt;
    private final String livePresenterNames;
    private final long liveStartAt;
    private final int livingStatus;
    private final String logo;
    private final String phoneInfo;
    private final String phonePrice;
    private final String pic;
    private final List<RelatedData> recentFollowList;
    private final List<NewHeadLine> recommendRows;
    private final String selectedTab;
    private final String showDate;
    private final String subTitle;
    private final List<ConfigPage> tabApiList;
    private final String tagCategory;
    private final List<String> tagPics;
    private final int tagType;
    private final String title;
    private final int topFeedId;
    private final List<String> topIds;
    private final String url;
    private final UserAction userAction;
    private final String videoUrl;
    private final int voteNum1;
    private final int voteNum2;
    private final int voteNum3;
    private final int voteNum4;
    private final int voteNum5;

    C$$AutoValue_Topic(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, String str9, String str10, int i, int i2, int i3, int i4, String str11, UserAction userAction2, String str12, int i5, String str13, List<RelatedData> list, int i6, long j, long j2, String str14, List<NewHeadLine> list2, int i7, String str15, String str16, int i8, int i9, int i10, int i11, int i12, int i13, String str17, String str18, String str19, String str20, String str21, String str22, List<String> list3, List<String> list4, List<ConfigPage> list5, String str23, int i14, String str24, String str25) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityId = str4;
        this.entityFixed = num;
        this.pic = str5;
        this.subTitle = str6;
        this.extraData = str7;
        this.dateline = l2;
        this.lastUpdate = l3;
        Objects.requireNonNull(str8, "Null id");
        this.id = str8;
        this.logo = str9;
        this.description = str10;
        this.followNum = i;
        this.commentNum = i2;
        this.click = i3;
        this.isRecommend = i4;
        this.title = str11;
        this.userAction = userAction2;
        this.intro = str12;
        this.isLive = i5;
        this.livePresenterNames = str13;
        Objects.requireNonNull(list, "Null recentFollowList");
        this.recentFollowList = list;
        this.livingStatus = i6;
        this.liveStartAt = j;
        this.liveEndAt = j2;
        this.url = str14;
        Objects.requireNonNull(list2, "Null recommendRows");
        this.recommendRows = list2;
        this.tagType = i7;
        this.cover = str15;
        this.tagCategory = str16;
        this.topFeedId = i8;
        this.voteNum1 = i9;
        this.voteNum2 = i10;
        this.voteNum3 = i11;
        this.voteNum4 = i12;
        this.voteNum5 = i13;
        this.phoneInfo = str17;
        this.adLinkUrl = str18;
        this.adPicUrl = str19;
        this.showDate = str20;
        this.phonePrice = str21;
        this.videoUrl = str22;
        Objects.requireNonNull(list3, "Null tagPics");
        this.tagPics = list3;
        Objects.requireNonNull(list4, "Null topIds");
        this.topIds = list4;
        Objects.requireNonNull(list5, "Null tabApiList");
        this.tabApiList = list5;
        this.selectedTab = str23;
        this.hotNum = i14;
        this.hotNumText = str24;
        this.bgColor = str25;
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

    @Override // com.coolapk.market.model.Topic, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Topic, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Topic, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("follownum")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("commentnum")
    public int getCommentNum() {
        return this.commentNum;
    }

    @Override // com.coolapk.market.model.Topic
    public int getClick() {
        return this.click;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("is_recommend")
    public int getIsRecommend() {
        return this.isRecommend;
    }

    @Override // com.coolapk.market.model.Topic, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Topic
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("intro")
    public String getIntro() {
        return this.intro;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("is_live")
    public int getIsLive() {
        return this.isLive;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("livePresenterNames")
    public String getLivePresenterNames() {
        return this.livePresenterNames;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("recent_follow_list")
    public List<RelatedData> getRecentFollowList() {
        return this.recentFollowList;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("live_status")
    public int getLivingStatus() {
        return this.livingStatus;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("live_start_at")
    public long getLiveStartAt() {
        return this.liveStartAt;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("live_end_at")
    public long getLiveEndAt() {
        return this.liveEndAt;
    }

    @Override // com.coolapk.market.model.Topic, com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("recommendRows")
    public List<NewHeadLine> getRecommendRows() {
        return this.recommendRows;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("tag_type")
    public int getTagType() {
        return this.tagType;
    }

    @Override // com.coolapk.market.model.Topic
    public String getCover() {
        return this.cover;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("tag_category")
    public String getTagCategory() {
        return this.tagCategory;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("top_feed_id")
    public int getTopFeedId() {
        return this.topFeedId;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("votenum1")
    public int getVoteNum1() {
        return this.voteNum1;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("votenum2")
    public int getVoteNum2() {
        return this.voteNum2;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("votenum3")
    public int getVoteNum3() {
        return this.voteNum3;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("votenum4")
    public int getVoteNum4() {
        return this.voteNum4;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("votenum5")
    public int getVoteNum5() {
        return this.voteNum5;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("phone_info")
    public String getPhoneInfo() {
        return this.phoneInfo;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("ad_link_url")
    public String getAdLinkUrl() {
        return this.adLinkUrl;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("ad_pic_url")
    public String getAdPicUrl() {
        return this.adPicUrl;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("show_date")
    public String getShowDate() {
        return this.showDate;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("phone_price")
    public String getPhonePrice() {
        return this.phonePrice;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("video_url")
    public String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("tag_pics")
    public List<String> getTagPics() {
        return this.tagPics;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("top_ids")
    public List<String> getTopIds() {
        return this.topIds;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("tabList")
    public List<ConfigPage> getTabApiList() {
        return this.tabApiList;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("selectedTab")
    public String getSelectedTab() {
        return this.selectedTab;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("hot_num")
    public int getHotNum() {
        return this.hotNum;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("hot_num_txt")
    public String getHotNumText() {
        return this.hotNumText;
    }

    @Override // com.coolapk.market.model.Topic
    @SerializedName("bgColor")
    public String getBgColor() {
        return this.bgColor;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Topic{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", logo=" + this.logo + ", description=" + this.description + ", followNum=" + this.followNum + ", commentNum=" + this.commentNum + ", click=" + this.click + ", isRecommend=" + this.isRecommend + ", title=" + this.title + ", userAction=" + this.userAction + ", intro=" + this.intro + ", isLive=" + this.isLive + ", livePresenterNames=" + this.livePresenterNames + ", recentFollowList=" + this.recentFollowList + ", livingStatus=" + this.livingStatus + ", liveStartAt=" + this.liveStartAt + ", liveEndAt=" + this.liveEndAt + ", url=" + this.url + ", recommendRows=" + this.recommendRows + ", tagType=" + this.tagType + ", cover=" + this.cover + ", tagCategory=" + this.tagCategory + ", topFeedId=" + this.topFeedId + ", voteNum1=" + this.voteNum1 + ", voteNum2=" + this.voteNum2 + ", voteNum3=" + this.voteNum3 + ", voteNum4=" + this.voteNum4 + ", voteNum5=" + this.voteNum5 + ", phoneInfo=" + this.phoneInfo + ", adLinkUrl=" + this.adLinkUrl + ", adPicUrl=" + this.adPicUrl + ", showDate=" + this.showDate + ", phonePrice=" + this.phonePrice + ", videoUrl=" + this.videoUrl + ", tagPics=" + this.tagPics + ", topIds=" + this.topIds + ", tabApiList=" + this.tabApiList + ", selectedTab=" + this.selectedTab + ", hotNum=" + this.hotNum + ", hotNumText=" + this.hotNumText + ", bgColor=" + this.bgColor + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        Long l2;
        Long l3;
        String str6;
        String str7;
        String str8;
        UserAction userAction2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        String str22 = this.entityTypeName;
        if (str22 != null ? str22.equals(topic.getEntityTypeName()) : topic.getEntityTypeName() == null) {
            if (this.entityType.equals(topic.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(topic.getEntityTemplate()) : topic.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(topic.getEntityId()) : topic.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(topic.getEntityFixed()) : topic.getEntityFixed() == null) && ((str3 = this.pic) != null ? str3.equals(topic.getPic()) : topic.getPic() == null) && ((str4 = this.subTitle) != null ? str4.equals(topic.getSubTitle()) : topic.getSubTitle() == null) && ((str5 = this.extraData) != null ? str5.equals(topic.getExtraData()) : topic.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(topic.getDateline()) : topic.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(topic.getLastUpdate()) : topic.getLastUpdate() == null) && this.id.equals(topic.getId()) && ((str6 = this.logo) != null ? str6.equals(topic.getLogo()) : topic.getLogo() == null) && ((str7 = this.description) != null ? str7.equals(topic.getDescription()) : topic.getDescription() == null) && this.followNum == topic.getFollowNum() && this.commentNum == topic.getCommentNum() && this.click == topic.getClick() && this.isRecommend == topic.getIsRecommend() && ((str8 = this.title) != null ? str8.equals(topic.getTitle()) : topic.getTitle() == null) && ((userAction2 = this.userAction) != null ? userAction2.equals(topic.getUserAction()) : topic.getUserAction() == null) && ((str9 = this.intro) != null ? str9.equals(topic.getIntro()) : topic.getIntro() == null) && this.isLive == topic.getIsLive() && ((str10 = this.livePresenterNames) != null ? str10.equals(topic.getLivePresenterNames()) : topic.getLivePresenterNames() == null) && this.recentFollowList.equals(topic.getRecentFollowList()) && this.livingStatus == topic.getLivingStatus() && this.liveStartAt == topic.getLiveStartAt() && this.liveEndAt == topic.getLiveEndAt() && ((str11 = this.url) != null ? str11.equals(topic.getUrl()) : topic.getUrl() == null) && this.recommendRows.equals(topic.getRecommendRows()) && this.tagType == topic.getTagType() && ((str12 = this.cover) != null ? str12.equals(topic.getCover()) : topic.getCover() == null) && ((str13 = this.tagCategory) != null ? str13.equals(topic.getTagCategory()) : topic.getTagCategory() == null) && this.topFeedId == topic.getTopFeedId() && this.voteNum1 == topic.getVoteNum1() && this.voteNum2 == topic.getVoteNum2() && this.voteNum3 == topic.getVoteNum3() && this.voteNum4 == topic.getVoteNum4() && this.voteNum5 == topic.getVoteNum5() && ((str14 = this.phoneInfo) != null ? str14.equals(topic.getPhoneInfo()) : topic.getPhoneInfo() == null) && ((str15 = this.adLinkUrl) != null ? str15.equals(topic.getAdLinkUrl()) : topic.getAdLinkUrl() == null) && ((str16 = this.adPicUrl) != null ? str16.equals(topic.getAdPicUrl()) : topic.getAdPicUrl() == null) && ((str17 = this.showDate) != null ? str17.equals(topic.getShowDate()) : topic.getShowDate() == null) && ((str18 = this.phonePrice) != null ? str18.equals(topic.getPhonePrice()) : topic.getPhonePrice() == null) && ((str19 = this.videoUrl) != null ? str19.equals(topic.getVideoUrl()) : topic.getVideoUrl() == null) && this.tagPics.equals(topic.getTagPics()) && this.topIds.equals(topic.getTopIds()) && this.tabApiList.equals(topic.getTabApiList()) && ((str20 = this.selectedTab) != null ? str20.equals(topic.getSelectedTab()) : topic.getSelectedTab() == null) && this.hotNum == topic.getHotNum() && ((str21 = this.hotNumText) != null ? str21.equals(topic.getHotNumText()) : topic.getHotNumText() == null)) {
                String str23 = this.bgColor;
                if (str23 == null) {
                    if (topic.getBgColor() == null) {
                        return true;
                    }
                } else if (str23.equals(topic.getBgColor())) {
                    return true;
                }
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
        String str4 = this.pic;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode8 = (hashCode7 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode9 = (((hashCode8 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str7 = this.logo;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.description;
        int hashCode11 = (((((((((hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003) ^ this.followNum) * 1000003) ^ this.commentNum) * 1000003) ^ this.click) * 1000003) ^ this.isRecommend) * 1000003;
        String str9 = this.title;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode13 = (hashCode12 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003;
        String str10 = this.intro;
        int hashCode14 = (((hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.isLive) * 1000003;
        String str11 = this.livePresenterNames;
        int hashCode15 = str11 == null ? 0 : str11.hashCode();
        long j = this.liveStartAt;
        long j2 = this.liveEndAt;
        int hashCode16 = ((int) (((long) (((int) (((long) ((((((hashCode14 ^ hashCode15) * 1000003) ^ this.recentFollowList.hashCode()) * 1000003) ^ this.livingStatus) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003;
        String str12 = this.url;
        int hashCode17 = (((((hashCode16 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.recommendRows.hashCode()) * 1000003) ^ this.tagType) * 1000003;
        String str13 = this.cover;
        int hashCode18 = (hashCode17 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.tagCategory;
        int hashCode19 = (((((((((((((hashCode18 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.topFeedId) * 1000003) ^ this.voteNum1) * 1000003) ^ this.voteNum2) * 1000003) ^ this.voteNum3) * 1000003) ^ this.voteNum4) * 1000003) ^ this.voteNum5) * 1000003;
        String str15 = this.phoneInfo;
        int hashCode20 = (hashCode19 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.adLinkUrl;
        int hashCode21 = (hashCode20 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.adPicUrl;
        int hashCode22 = (hashCode21 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.showDate;
        int hashCode23 = (hashCode22 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.phonePrice;
        int hashCode24 = (hashCode23 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.videoUrl;
        int hashCode25 = (((((((hashCode24 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003) ^ this.tagPics.hashCode()) * 1000003) ^ this.topIds.hashCode()) * 1000003) ^ this.tabApiList.hashCode()) * 1000003;
        String str21 = this.selectedTab;
        int hashCode26 = (((hashCode25 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003) ^ this.hotNum) * 1000003;
        String str22 = this.hotNumText;
        int hashCode27 = (hashCode26 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
        String str23 = this.bgColor;
        if (str23 != null) {
            i = str23.hashCode();
        }
        return hashCode27 ^ i;
    }
}
