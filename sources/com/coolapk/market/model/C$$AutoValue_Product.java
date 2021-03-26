package com.coolapk.market.model;

import com.coolapk.market.model.Product;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Product  reason: invalid class name */
abstract class C$$AutoValue_Product extends Product {
    private final int allowRating;
    private final String bgColor;
    private final int blockStatus;
    private final String brandId;
    private final int buyCount;
    private final int categoryId;
    private final int configNum;
    private final List<ProductConfig> configRows;
    private final List<ProductCoupon> couponList;
    private final String couponTitle;
    private final List<String> coverPicList;
    private final String createTime;
    private final String createUid;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final int feedAnswerNum;
    private final int feedArticleNum;
    private final int feedCommentNum;
    private final int feedVideoNum;
    private final int followNum;
    private final int hotNum;
    private final String hotNumText;
    private final String id;
    private final int isOwner;
    private final Long lastUpdate;
    private final String logo;
    private final int ownerBuyCount;
    private final int ownerRatingTotalNum;
    private final int ownerStar1Count;
    private final int ownerStar2Count;
    private final int ownerStar3Count;
    private final int ownerStar4Count;
    private final int ownerStar5Count;
    private final float ownerStarAverageScore;
    private final int ownerStarTotalCount;
    private final String pic;
    private final String priceCurrency;
    private final float priceMax;
    private final float priceMin;
    private final float ratingAverageScore;
    private final float ratingAverageScore1;
    private final float ratingAverageScore10;
    private final float ratingAverageScore2;
    private final float ratingAverageScore3;
    private final float ratingAverageScore4;
    private final float ratingAverageScore5;
    private final float ratingAverageScore6;
    private final float ratingAverageScore7;
    private final float ratingAverageScore8;
    private final float ratingAverageScore9;
    private final int ratingTotalNum;
    private final List<RelatedData> recentFollowList;
    private final int recommendImageNum;
    private final List<NewHeadLine> recommendRows;
    private final int recommendVideoNum;
    private final int releaseStatus;
    private final String releaseTime;
    private final String secondHandFeedNum;
    private final String secondHandSthType;
    private final String selectedTab;
    private final String seriesId;
    private final int shareNum;
    private final String shareUrl;
    private final int star1Count;
    private final int star2Count;
    private final int star3Count;
    private final int star4Count;
    private final int star5Count;
    private final float starAverageScore;
    private final int starTotalCount;
    private final int status;
    private final String subTitle;
    private final List<ConfigPage> tabApiList;
    private final List<String> tagArr;
    private final String title;
    private final List<String> topIds;
    private final String type;
    private final String updateTime;
    private final String updateUid;
    private final String url;
    private final UserAction userAction;
    private final int voteBuryNum;
    private final int voteDigNum;
    private final float voteDigPercentage;
    private final int wishCount;

    C$$AutoValue_Product(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, String str13, List<String> list, int i, float f, float f2, String str14, int i2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int i3, int i4, int i5, List<String> list2, int i6, int i7, int i8, int i9, int i10, int i11, String str15, int i12, String str16, int i13, int i14, int i15, String str17, String str18, String str19, String str20, List<ProductConfig> list3, UserAction userAction2, List<ConfigPage> list4, String str21, float f14, String str22, float f15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, float f16, int i27, int i28, int i29, String str23, String str24, List<ProductCoupon> list5, String str25, List<String> list6, List<RelatedData> list7, int i30, String str26, String str27, int i31, int i32, int i33, int i34, int i35, List<NewHeadLine> list8) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.id = str10;
        this.extraData = str11;
        this.dateline = l;
        this.lastUpdate = l2;
        this.brandId = str12;
        this.seriesId = str13;
        Objects.requireNonNull(list, "Null coverPicList");
        this.coverPicList = list;
        this.configNum = i;
        this.priceMin = f;
        this.priceMax = f2;
        this.priceCurrency = str14;
        this.followNum = i2;
        this.ratingAverageScore = f3;
        this.ratingAverageScore1 = f4;
        this.ratingAverageScore2 = f5;
        this.ratingAverageScore3 = f6;
        this.ratingAverageScore4 = f7;
        this.ratingAverageScore5 = f8;
        this.ratingAverageScore6 = f9;
        this.ratingAverageScore7 = f10;
        this.ratingAverageScore8 = f11;
        this.ratingAverageScore9 = f12;
        this.ratingAverageScore10 = f13;
        this.ratingTotalNum = i3;
        this.voteDigNum = i4;
        this.voteBuryNum = i5;
        Objects.requireNonNull(list2, "Null tagArr");
        this.tagArr = list2;
        this.feedCommentNum = i6;
        this.feedAnswerNum = i7;
        this.feedArticleNum = i8;
        this.feedVideoNum = i9;
        this.recommendImageNum = i10;
        this.recommendVideoNum = i11;
        this.releaseTime = str15;
        this.shareNum = i12;
        this.shareUrl = str16;
        this.blockStatus = i13;
        this.releaseStatus = i14;
        this.status = i15;
        this.createUid = str17;
        this.createTime = str18;
        this.updateTime = str19;
        this.updateUid = str20;
        Objects.requireNonNull(list3, "Null configRows");
        this.configRows = list3;
        Objects.requireNonNull(userAction2, "Null userAction");
        this.userAction = userAction2;
        Objects.requireNonNull(list4, "Null tabApiList");
        this.tabApiList = list4;
        this.selectedTab = str21;
        this.voteDigPercentage = f14;
        this.secondHandFeedNum = str22;
        this.starAverageScore = f15;
        this.starTotalCount = i16;
        this.star1Count = i17;
        this.star2Count = i18;
        this.star3Count = i19;
        this.star4Count = i20;
        this.star5Count = i21;
        this.ownerStar1Count = i22;
        this.ownerStar2Count = i23;
        this.ownerStar3Count = i24;
        this.ownerStar4Count = i25;
        this.ownerStar5Count = i26;
        this.ownerStarAverageScore = f16;
        this.ownerStarTotalCount = i27;
        this.ownerRatingTotalNum = i28;
        this.ownerBuyCount = i29;
        this.secondHandSthType = str23;
        this.couponTitle = str24;
        this.couponList = list5;
        this.type = str25;
        Objects.requireNonNull(list6, "Null topIds");
        this.topIds = list6;
        Objects.requireNonNull(list7, "Null recentFollowList");
        this.recentFollowList = list7;
        this.hotNum = i30;
        this.hotNumText = str26;
        this.bgColor = str27;
        this.allowRating = i31;
        this.wishCount = i32;
        this.buyCount = i33;
        this.categoryId = i34;
        this.isOwner = i35;
        Objects.requireNonNull(list8, "Null recommendRows");
        this.recommendRows = list8;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
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
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
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

    @Override // com.coolapk.market.model.Product
    @SerializedName("brand_id")
    public String getBrandId() {
        return this.brandId;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("series_id")
    public String getSeriesId() {
        return this.seriesId;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("coverArr")
    public List<String> getCoverPicList() {
        return this.coverPicList;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("config_num")
    public int getConfigNum() {
        return this.configNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("price_min")
    public float getPriceMin() {
        return this.priceMin;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("price_max")
    public float getPriceMax() {
        return this.priceMax;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("price_currency")
    public String getPriceCurrency() {
        return this.priceCurrency;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("follow_num")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score")
    public float getRatingAverageScore() {
        return this.ratingAverageScore;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_1")
    public float getRatingAverageScore1() {
        return this.ratingAverageScore1;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_2")
    public float getRatingAverageScore2() {
        return this.ratingAverageScore2;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_3")
    public float getRatingAverageScore3() {
        return this.ratingAverageScore3;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_4")
    public float getRatingAverageScore4() {
        return this.ratingAverageScore4;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_5")
    public float getRatingAverageScore5() {
        return this.ratingAverageScore5;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_6")
    public float getRatingAverageScore6() {
        return this.ratingAverageScore6;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_7")
    public float getRatingAverageScore7() {
        return this.ratingAverageScore7;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_8")
    public float getRatingAverageScore8() {
        return this.ratingAverageScore8;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_9")
    public float getRatingAverageScore9() {
        return this.ratingAverageScore9;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_average_score_10")
    public float getRatingAverageScore10() {
        return this.ratingAverageScore10;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("rating_total_num")
    public int getRatingTotalNum() {
        return this.ratingTotalNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("vote_dig_num")
    public int getVoteDigNum() {
        return this.voteDigNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("vote_bury_num")
    public int getVoteBuryNum() {
        return this.voteBuryNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("tagArr")
    public List<String> getTagArr() {
        return this.tagArr;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("feed_comment_num")
    public int getFeedCommentNum() {
        return this.feedCommentNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("feed_answer_num")
    public int getFeedAnswerNum() {
        return this.feedAnswerNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("feed_tuwen_num")
    public int getFeedArticleNum() {
        return this.feedArticleNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("feed_video_num")
    public int getFeedVideoNum() {
        return this.feedVideoNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("recommend_image_num")
    public int getRecommendImageNum() {
        return this.recommendImageNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("recommend_video_num")
    public int getRecommendVideoNum() {
        return this.recommendVideoNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("release_time")
    public String getReleaseTime() {
        return this.releaseTime;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("share_num")
    public int getShareNum() {
        return this.shareNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("sell_url")
    public String getShareUrl() {
        return this.shareUrl;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("release_status")
    public int getReleaseStatus() {
        return this.releaseStatus;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("status")
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("create_uid")
    public String getCreateUid() {
        return this.createUid;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("create_time")
    public String getCreateTime() {
        return this.createTime;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("update_time")
    public String getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("update_uid")
    public String getUpdateUid() {
        return this.updateUid;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("configRows")
    public List<ProductConfig> getConfigRows() {
        return this.configRows;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("userAction")
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("tabList")
    public List<ConfigPage> getTabApiList() {
        return this.tabApiList;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("selectedTab")
    public String getSelectedTab() {
        return this.selectedTab;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("vote_dig_percentage")
    public float getVoteDigPercentage() {
        return this.voteDigPercentage;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("sale_num")
    public String getSecondHandFeedNum() {
        return this.secondHandFeedNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_average_score")
    public float getStarAverageScore() {
        return this.starAverageScore;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_total_count")
    public int getStarTotalCount() {
        return this.starTotalCount;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_1_count")
    public int getStar1Count() {
        return this.star1Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_2_count")
    public int getStar2Count() {
        return this.star2Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_3_count")
    public int getStar3Count() {
        return this.star3Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_4_count")
    public int getStar4Count() {
        return this.star4Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("star_5_count")
    public int getStar5Count() {
        return this.star5Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_1_count")
    public int getOwnerStar1Count() {
        return this.ownerStar1Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_2_count")
    public int getOwnerStar2Count() {
        return this.ownerStar2Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_3_count")
    public int getOwnerStar3Count() {
        return this.ownerStar3Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_4_count")
    public int getOwnerStar4Count() {
        return this.ownerStar4Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_5_count")
    public int getOwnerStar5Count() {
        return this.ownerStar5Count;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_average_score")
    public float getOwnerStarAverageScore() {
        return this.ownerStarAverageScore;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_star_total_count")
    public int getOwnerStarTotalCount() {
        return this.ownerStarTotalCount;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_rating_total_num")
    public int getOwnerRatingTotalNum() {
        return this.ownerRatingTotalNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("owner_buy_count")
    public int getOwnerBuyCount() {
        return this.ownerBuyCount;
    }

    @Override // com.coolapk.market.model.Product
    public String getSecondHandSthType() {
        return this.secondHandSthType;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("get_coupon_title")
    public String getCouponTitle() {
        return this.couponTitle;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("coupon_list")
    public List<ProductCoupon> getCouponList() {
        return this.couponList;
    }

    @Override // com.coolapk.market.model.Product
    public String getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("top_ids")
    public List<String> getTopIds() {
        return this.topIds;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("recent_follow_list")
    public List<RelatedData> getRecentFollowList() {
        return this.recentFollowList;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("hot_num")
    public int getHotNum() {
        return this.hotNum;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("hot_num_txt")
    public String getHotNumText() {
        return this.hotNumText;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("bgColor")
    public String getBgColor() {
        return this.bgColor;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("allow_rating")
    public int getAllowRating() {
        return this.allowRating;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("wish_count")
    public int getWishCount() {
        return this.wishCount;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("buy_count")
    public int getBuyCount() {
        return this.buyCount;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("category_id")
    public int getCategoryId() {
        return this.categoryId;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("is_owner")
    public int getIsOwner() {
        return this.isOwner;
    }

    @Override // com.coolapk.market.model.Product
    @SerializedName("recommendRows")
    public List<NewHeadLine> getRecommendRows() {
        return this.recommendRows;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Product{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", brandId=" + this.brandId + ", seriesId=" + this.seriesId + ", coverPicList=" + this.coverPicList + ", configNum=" + this.configNum + ", priceMin=" + this.priceMin + ", priceMax=" + this.priceMax + ", priceCurrency=" + this.priceCurrency + ", followNum=" + this.followNum + ", ratingAverageScore=" + this.ratingAverageScore + ", ratingAverageScore1=" + this.ratingAverageScore1 + ", ratingAverageScore2=" + this.ratingAverageScore2 + ", ratingAverageScore3=" + this.ratingAverageScore3 + ", ratingAverageScore4=" + this.ratingAverageScore4 + ", ratingAverageScore5=" + this.ratingAverageScore5 + ", ratingAverageScore6=" + this.ratingAverageScore6 + ", ratingAverageScore7=" + this.ratingAverageScore7 + ", ratingAverageScore8=" + this.ratingAverageScore8 + ", ratingAverageScore9=" + this.ratingAverageScore9 + ", ratingAverageScore10=" + this.ratingAverageScore10 + ", ratingTotalNum=" + this.ratingTotalNum + ", voteDigNum=" + this.voteDigNum + ", voteBuryNum=" + this.voteBuryNum + ", tagArr=" + this.tagArr + ", feedCommentNum=" + this.feedCommentNum + ", feedAnswerNum=" + this.feedAnswerNum + ", feedArticleNum=" + this.feedArticleNum + ", feedVideoNum=" + this.feedVideoNum + ", recommendImageNum=" + this.recommendImageNum + ", recommendVideoNum=" + this.recommendVideoNum + ", releaseTime=" + this.releaseTime + ", shareNum=" + this.shareNum + ", shareUrl=" + this.shareUrl + ", blockStatus=" + this.blockStatus + ", releaseStatus=" + this.releaseStatus + ", status=" + this.status + ", createUid=" + this.createUid + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", updateUid=" + this.updateUid + ", configRows=" + this.configRows + ", userAction=" + this.userAction + ", tabApiList=" + this.tabApiList + ", selectedTab=" + this.selectedTab + ", voteDigPercentage=" + this.voteDigPercentage + ", secondHandFeedNum=" + this.secondHandFeedNum + ", starAverageScore=" + this.starAverageScore + ", starTotalCount=" + this.starTotalCount + ", star1Count=" + this.star1Count + ", star2Count=" + this.star2Count + ", star3Count=" + this.star3Count + ", star4Count=" + this.star4Count + ", star5Count=" + this.star5Count + ", ownerStar1Count=" + this.ownerStar1Count + ", ownerStar2Count=" + this.ownerStar2Count + ", ownerStar3Count=" + this.ownerStar3Count + ", ownerStar4Count=" + this.ownerStar4Count + ", ownerStar5Count=" + this.ownerStar5Count + ", ownerStarAverageScore=" + this.ownerStarAverageScore + ", ownerStarTotalCount=" + this.ownerStarTotalCount + ", ownerRatingTotalNum=" + this.ownerRatingTotalNum + ", ownerBuyCount=" + this.ownerBuyCount + ", secondHandSthType=" + this.secondHandSthType + ", couponTitle=" + this.couponTitle + ", couponList=" + this.couponList + ", type=" + this.type + ", topIds=" + this.topIds + ", recentFollowList=" + this.recentFollowList + ", hotNum=" + this.hotNum + ", hotNumText=" + this.hotNumText + ", bgColor=" + this.bgColor + ", allowRating=" + this.allowRating + ", wishCount=" + this.wishCount + ", buyCount=" + this.buyCount + ", categoryId=" + this.categoryId + ", isOwner=" + this.isOwner + ", recommendRows=" + this.recommendRows + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        List<ProductCoupon> list;
        String str12;
        String str13;
        String str14;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        String str15 = this.entityTypeName;
        if (str15 != null ? str15.equals(product.getEntityTypeName()) : product.getEntityTypeName() == null) {
            String str16 = this.entityTemplate;
            if (str16 != null ? str16.equals(product.getEntityTemplate()) : product.getEntityTemplate() == null) {
                String str17 = this.entityId;
                if (str17 != null ? str17.equals(product.getEntityId()) : product.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(product.getEntityFixed()) : product.getEntityFixed() == null) {
                        String str18 = this.title;
                        if (str18 != null ? str18.equals(product.getTitle()) : product.getTitle() == null) {
                            String str19 = this.url;
                            if (str19 != null ? str19.equals(product.getUrl()) : product.getUrl() == null) {
                                String str20 = this.description;
                                if (str20 != null ? str20.equals(product.getDescription()) : product.getDescription() == null) {
                                    String str21 = this.pic;
                                    if (str21 != null ? str21.equals(product.getPic()) : product.getPic() == null) {
                                        String str22 = this.logo;
                                        if (str22 != null ? str22.equals(product.getLogo()) : product.getLogo() == null) {
                                            String str23 = this.subTitle;
                                            if (str23 != null ? str23.equals(product.getSubTitle()) : product.getSubTitle() == null) {
                                                String str24 = this.id;
                                                if (str24 != null ? str24.equals(product.getId()) : product.getId() == null) {
                                                    String str25 = this.extraData;
                                                    if (str25 != null ? str25.equals(product.getExtraData()) : product.getExtraData() == null) {
                                                        Long l = this.dateline;
                                                        if (l != null ? l.equals(product.getDateline()) : product.getDateline() == null) {
                                                            Long l2 = this.lastUpdate;
                                                            if (l2 != null ? l2.equals(product.getLastUpdate()) : product.getLastUpdate() == null) {
                                                                String str26 = this.brandId;
                                                                if (str26 != null ? str26.equals(product.getBrandId()) : product.getBrandId() == null) {
                                                                    String str27 = this.seriesId;
                                                                    if (str27 != null ? str27.equals(product.getSeriesId()) : product.getSeriesId() == null) {
                                                                        if (this.coverPicList.equals(product.getCoverPicList()) && this.configNum == product.getConfigNum() && Float.floatToIntBits(this.priceMin) == Float.floatToIntBits(product.getPriceMin()) && Float.floatToIntBits(this.priceMax) == Float.floatToIntBits(product.getPriceMax()) && ((str = this.priceCurrency) != null ? str.equals(product.getPriceCurrency()) : product.getPriceCurrency() == null) && this.followNum == product.getFollowNum() && Float.floatToIntBits(this.ratingAverageScore) == Float.floatToIntBits(product.getRatingAverageScore()) && Float.floatToIntBits(this.ratingAverageScore1) == Float.floatToIntBits(product.getRatingAverageScore1()) && Float.floatToIntBits(this.ratingAverageScore2) == Float.floatToIntBits(product.getRatingAverageScore2()) && Float.floatToIntBits(this.ratingAverageScore3) == Float.floatToIntBits(product.getRatingAverageScore3()) && Float.floatToIntBits(this.ratingAverageScore4) == Float.floatToIntBits(product.getRatingAverageScore4()) && Float.floatToIntBits(this.ratingAverageScore5) == Float.floatToIntBits(product.getRatingAverageScore5()) && Float.floatToIntBits(this.ratingAverageScore6) == Float.floatToIntBits(product.getRatingAverageScore6()) && Float.floatToIntBits(this.ratingAverageScore7) == Float.floatToIntBits(product.getRatingAverageScore7()) && Float.floatToIntBits(this.ratingAverageScore8) == Float.floatToIntBits(product.getRatingAverageScore8()) && Float.floatToIntBits(this.ratingAverageScore9) == Float.floatToIntBits(product.getRatingAverageScore9()) && Float.floatToIntBits(this.ratingAverageScore10) == Float.floatToIntBits(product.getRatingAverageScore10()) && this.ratingTotalNum == product.getRatingTotalNum() && this.voteDigNum == product.getVoteDigNum() && this.voteBuryNum == product.getVoteBuryNum() && this.tagArr.equals(product.getTagArr()) && this.feedCommentNum == product.getFeedCommentNum() && this.feedAnswerNum == product.getFeedAnswerNum() && this.feedArticleNum == product.getFeedArticleNum() && this.feedVideoNum == product.getFeedVideoNum() && this.recommendImageNum == product.getRecommendImageNum() && this.recommendVideoNum == product.getRecommendVideoNum() && ((str2 = this.releaseTime) != null ? str2.equals(product.getReleaseTime()) : product.getReleaseTime() == null) && this.shareNum == product.getShareNum() && ((str3 = this.shareUrl) != null ? str3.equals(product.getShareUrl()) : product.getShareUrl() == null) && this.blockStatus == product.getBlockStatus() && this.releaseStatus == product.getReleaseStatus() && this.status == product.getStatus() && ((str4 = this.createUid) != null ? str4.equals(product.getCreateUid()) : product.getCreateUid() == null) && ((str5 = this.createTime) != null ? str5.equals(product.getCreateTime()) : product.getCreateTime() == null) && ((str6 = this.updateTime) != null ? str6.equals(product.getUpdateTime()) : product.getUpdateTime() == null) && ((str7 = this.updateUid) != null ? str7.equals(product.getUpdateUid()) : product.getUpdateUid() == null) && this.configRows.equals(product.getConfigRows()) && this.userAction.equals(product.getUserAction()) && this.tabApiList.equals(product.getTabApiList()) && ((str8 = this.selectedTab) != null ? str8.equals(product.getSelectedTab()) : product.getSelectedTab() == null) && Float.floatToIntBits(this.voteDigPercentage) == Float.floatToIntBits(product.getVoteDigPercentage()) && ((str9 = this.secondHandFeedNum) != null ? str9.equals(product.getSecondHandFeedNum()) : product.getSecondHandFeedNum() == null) && Float.floatToIntBits(this.starAverageScore) == Float.floatToIntBits(product.getStarAverageScore()) && this.starTotalCount == product.getStarTotalCount() && this.star1Count == product.getStar1Count() && this.star2Count == product.getStar2Count() && this.star3Count == product.getStar3Count() && this.star4Count == product.getStar4Count() && this.star5Count == product.getStar5Count() && this.ownerStar1Count == product.getOwnerStar1Count() && this.ownerStar2Count == product.getOwnerStar2Count() && this.ownerStar3Count == product.getOwnerStar3Count() && this.ownerStar4Count == product.getOwnerStar4Count() && this.ownerStar5Count == product.getOwnerStar5Count() && Float.floatToIntBits(this.ownerStarAverageScore) == Float.floatToIntBits(product.getOwnerStarAverageScore()) && this.ownerStarTotalCount == product.getOwnerStarTotalCount() && this.ownerRatingTotalNum == product.getOwnerRatingTotalNum() && this.ownerBuyCount == product.getOwnerBuyCount() && ((str10 = this.secondHandSthType) != null ? str10.equals(product.getSecondHandSthType()) : product.getSecondHandSthType() == null) && ((str11 = this.couponTitle) != null ? str11.equals(product.getCouponTitle()) : product.getCouponTitle() == null) && ((list = this.couponList) != null ? list.equals(product.getCouponList()) : product.getCouponList() == null) && ((str12 = this.type) != null ? str12.equals(product.getType()) : product.getType() == null) && this.topIds.equals(product.getTopIds()) && this.recentFollowList.equals(product.getRecentFollowList()) && this.hotNum == product.getHotNum() && ((str13 = this.hotNumText) != null ? str13.equals(product.getHotNumText()) : product.getHotNumText() == null) && ((str14 = this.bgColor) != null ? str14.equals(product.getBgColor()) : product.getBgColor() == null) && this.allowRating == product.getAllowRating() && this.wishCount == product.getWishCount() && this.buyCount == product.getBuyCount() && this.categoryId == product.getCategoryId() && this.isOwner == product.getIsOwner() && this.recommendRows.equals(product.getRecommendRows())) {
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.url;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.description;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.id;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode13 = (hashCode12 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode14 = (hashCode13 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str12 = this.brandId;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.seriesId;
        int hashCode16 = (((((((((hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.coverPicList.hashCode()) * 1000003) ^ this.configNum) * 1000003) ^ Float.floatToIntBits(this.priceMin)) * 1000003) ^ Float.floatToIntBits(this.priceMax)) * 1000003;
        String str14 = this.priceCurrency;
        int hashCode17 = (((((((((((((((((((((((((((((((((((((((((((((hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.followNum) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore1)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore2)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore3)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore4)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore5)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore6)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore7)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore8)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore9)) * 1000003) ^ Float.floatToIntBits(this.ratingAverageScore10)) * 1000003) ^ this.ratingTotalNum) * 1000003) ^ this.voteDigNum) * 1000003) ^ this.voteBuryNum) * 1000003) ^ this.tagArr.hashCode()) * 1000003) ^ this.feedCommentNum) * 1000003) ^ this.feedAnswerNum) * 1000003) ^ this.feedArticleNum) * 1000003) ^ this.feedVideoNum) * 1000003) ^ this.recommendImageNum) * 1000003) ^ this.recommendVideoNum) * 1000003;
        String str15 = this.releaseTime;
        int hashCode18 = (((hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.shareNum) * 1000003;
        String str16 = this.shareUrl;
        int hashCode19 = (((((((hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.blockStatus) * 1000003) ^ this.releaseStatus) * 1000003) ^ this.status) * 1000003;
        String str17 = this.createUid;
        int hashCode20 = (hashCode19 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.createTime;
        int hashCode21 = (hashCode20 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.updateTime;
        int hashCode22 = (hashCode21 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.updateUid;
        int hashCode23 = (((((((hashCode22 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003) ^ this.configRows.hashCode()) * 1000003) ^ this.userAction.hashCode()) * 1000003) ^ this.tabApiList.hashCode()) * 1000003;
        String str21 = this.selectedTab;
        int hashCode24 = (((hashCode23 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003) ^ Float.floatToIntBits(this.voteDigPercentage)) * 1000003;
        String str22 = this.secondHandFeedNum;
        int hashCode25 = (((((((((((((((((((((((((((((((((hashCode24 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003) ^ Float.floatToIntBits(this.starAverageScore)) * 1000003) ^ this.starTotalCount) * 1000003) ^ this.star1Count) * 1000003) ^ this.star2Count) * 1000003) ^ this.star3Count) * 1000003) ^ this.star4Count) * 1000003) ^ this.star5Count) * 1000003) ^ this.ownerStar1Count) * 1000003) ^ this.ownerStar2Count) * 1000003) ^ this.ownerStar3Count) * 1000003) ^ this.ownerStar4Count) * 1000003) ^ this.ownerStar5Count) * 1000003) ^ Float.floatToIntBits(this.ownerStarAverageScore)) * 1000003) ^ this.ownerStarTotalCount) * 1000003) ^ this.ownerRatingTotalNum) * 1000003) ^ this.ownerBuyCount) * 1000003;
        String str23 = this.secondHandSthType;
        int hashCode26 = (hashCode25 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        String str24 = this.couponTitle;
        int hashCode27 = (hashCode26 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        List<ProductCoupon> list = this.couponList;
        int hashCode28 = (hashCode27 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str25 = this.type;
        int hashCode29 = (((((((hashCode28 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003) ^ this.topIds.hashCode()) * 1000003) ^ this.recentFollowList.hashCode()) * 1000003) ^ this.hotNum) * 1000003;
        String str26 = this.hotNumText;
        int hashCode30 = (hashCode29 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
        String str27 = this.bgColor;
        if (str27 != null) {
            i = str27.hashCode();
        }
        return ((((((((((((hashCode30 ^ i) * 1000003) ^ this.allowRating) * 1000003) ^ this.wishCount) * 1000003) ^ this.buyCount) * 1000003) ^ this.categoryId) * 1000003) ^ this.isOwner) * 1000003) ^ this.recommendRows.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Product$Builder */
    /* compiled from: $$AutoValue_Product */
    static final class Builder extends Product.Builder {
        private Integer allowRating;
        private String bgColor;
        private Integer blockStatus;
        private String brandId;
        private Integer buyCount;
        private Integer categoryId;
        private Integer configNum;
        private List<ProductConfig> configRows;
        private List<ProductCoupon> couponList;
        private String couponTitle;
        private List<String> coverPicList;
        private String createTime;
        private String createUid;
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private Integer feedAnswerNum;
        private Integer feedArticleNum;
        private Integer feedCommentNum;
        private Integer feedVideoNum;
        private Integer followNum;
        private Integer hotNum;
        private String hotNumText;
        private String id;
        private Integer isOwner;
        private Long lastUpdate;
        private String logo;
        private Integer ownerBuyCount;
        private Integer ownerRatingTotalNum;
        private Integer ownerStar1Count;
        private Integer ownerStar2Count;
        private Integer ownerStar3Count;
        private Integer ownerStar4Count;
        private Integer ownerStar5Count;
        private Float ownerStarAverageScore;
        private Integer ownerStarTotalCount;
        private String pic;
        private String priceCurrency;
        private Float priceMax;
        private Float priceMin;
        private Float ratingAverageScore;
        private Float ratingAverageScore1;
        private Float ratingAverageScore10;
        private Float ratingAverageScore2;
        private Float ratingAverageScore3;
        private Float ratingAverageScore4;
        private Float ratingAverageScore5;
        private Float ratingAverageScore6;
        private Float ratingAverageScore7;
        private Float ratingAverageScore8;
        private Float ratingAverageScore9;
        private Integer ratingTotalNum;
        private List<RelatedData> recentFollowList;
        private Integer recommendImageNum;
        private List<NewHeadLine> recommendRows;
        private Integer recommendVideoNum;
        private Integer releaseStatus;
        private String releaseTime;
        private String secondHandFeedNum;
        private String secondHandSthType;
        private String selectedTab;
        private String seriesId;
        private Integer shareNum;
        private String shareUrl;
        private Integer star1Count;
        private Integer star2Count;
        private Integer star3Count;
        private Integer star4Count;
        private Integer star5Count;
        private Float starAverageScore;
        private Integer starTotalCount;
        private Integer status;
        private String subTitle;
        private List<ConfigPage> tabApiList;
        private List<String> tagArr;
        private String title;
        private List<String> topIds;
        private String type;
        private String updateTime;
        private String updateUid;
        private String url;
        private UserAction userAction;
        private Integer voteBuryNum;
        private Integer voteDigNum;
        private Float voteDigPercentage;
        private Integer wishCount;

        Builder() {
        }

        Builder(Product product) {
            this.entityTypeName = product.getEntityTypeName();
            this.entityTemplate = product.getEntityTemplate();
            this.entityId = product.getEntityId();
            this.entityFixed = product.getEntityFixed();
            this.title = product.getTitle();
            this.url = product.getUrl();
            this.description = product.getDescription();
            this.pic = product.getPic();
            this.logo = product.getLogo();
            this.subTitle = product.getSubTitle();
            this.id = product.getId();
            this.extraData = product.getExtraData();
            this.dateline = product.getDateline();
            this.lastUpdate = product.getLastUpdate();
            this.brandId = product.getBrandId();
            this.seriesId = product.getSeriesId();
            this.coverPicList = product.getCoverPicList();
            this.configNum = Integer.valueOf(product.getConfigNum());
            this.priceMin = Float.valueOf(product.getPriceMin());
            this.priceMax = Float.valueOf(product.getPriceMax());
            this.priceCurrency = product.getPriceCurrency();
            this.followNum = Integer.valueOf(product.getFollowNum());
            this.ratingAverageScore = Float.valueOf(product.getRatingAverageScore());
            this.ratingAverageScore1 = Float.valueOf(product.getRatingAverageScore1());
            this.ratingAverageScore2 = Float.valueOf(product.getRatingAverageScore2());
            this.ratingAverageScore3 = Float.valueOf(product.getRatingAverageScore3());
            this.ratingAverageScore4 = Float.valueOf(product.getRatingAverageScore4());
            this.ratingAverageScore5 = Float.valueOf(product.getRatingAverageScore5());
            this.ratingAverageScore6 = Float.valueOf(product.getRatingAverageScore6());
            this.ratingAverageScore7 = Float.valueOf(product.getRatingAverageScore7());
            this.ratingAverageScore8 = Float.valueOf(product.getRatingAverageScore8());
            this.ratingAverageScore9 = Float.valueOf(product.getRatingAverageScore9());
            this.ratingAverageScore10 = Float.valueOf(product.getRatingAverageScore10());
            this.ratingTotalNum = Integer.valueOf(product.getRatingTotalNum());
            this.voteDigNum = Integer.valueOf(product.getVoteDigNum());
            this.voteBuryNum = Integer.valueOf(product.getVoteBuryNum());
            this.tagArr = product.getTagArr();
            this.feedCommentNum = Integer.valueOf(product.getFeedCommentNum());
            this.feedAnswerNum = Integer.valueOf(product.getFeedAnswerNum());
            this.feedArticleNum = Integer.valueOf(product.getFeedArticleNum());
            this.feedVideoNum = Integer.valueOf(product.getFeedVideoNum());
            this.recommendImageNum = Integer.valueOf(product.getRecommendImageNum());
            this.recommendVideoNum = Integer.valueOf(product.getRecommendVideoNum());
            this.releaseTime = product.getReleaseTime();
            this.shareNum = Integer.valueOf(product.getShareNum());
            this.shareUrl = product.getShareUrl();
            this.blockStatus = Integer.valueOf(product.getBlockStatus());
            this.releaseStatus = Integer.valueOf(product.getReleaseStatus());
            this.status = Integer.valueOf(product.getStatus());
            this.createUid = product.getCreateUid();
            this.createTime = product.getCreateTime();
            this.updateTime = product.getUpdateTime();
            this.updateUid = product.getUpdateUid();
            this.configRows = product.getConfigRows();
            this.userAction = product.getUserAction();
            this.tabApiList = product.getTabApiList();
            this.selectedTab = product.getSelectedTab();
            this.voteDigPercentage = Float.valueOf(product.getVoteDigPercentage());
            this.secondHandFeedNum = product.getSecondHandFeedNum();
            this.starAverageScore = Float.valueOf(product.getStarAverageScore());
            this.starTotalCount = Integer.valueOf(product.getStarTotalCount());
            this.star1Count = Integer.valueOf(product.getStar1Count());
            this.star2Count = Integer.valueOf(product.getStar2Count());
            this.star3Count = Integer.valueOf(product.getStar3Count());
            this.star4Count = Integer.valueOf(product.getStar4Count());
            this.star5Count = Integer.valueOf(product.getStar5Count());
            this.ownerStar1Count = Integer.valueOf(product.getOwnerStar1Count());
            this.ownerStar2Count = Integer.valueOf(product.getOwnerStar2Count());
            this.ownerStar3Count = Integer.valueOf(product.getOwnerStar3Count());
            this.ownerStar4Count = Integer.valueOf(product.getOwnerStar4Count());
            this.ownerStar5Count = Integer.valueOf(product.getOwnerStar5Count());
            this.ownerStarAverageScore = Float.valueOf(product.getOwnerStarAverageScore());
            this.ownerStarTotalCount = Integer.valueOf(product.getOwnerStarTotalCount());
            this.ownerRatingTotalNum = Integer.valueOf(product.getOwnerRatingTotalNum());
            this.ownerBuyCount = Integer.valueOf(product.getOwnerBuyCount());
            this.secondHandSthType = product.getSecondHandSthType();
            this.couponTitle = product.getCouponTitle();
            this.couponList = product.getCouponList();
            this.type = product.getType();
            this.topIds = product.getTopIds();
            this.recentFollowList = product.getRecentFollowList();
            this.hotNum = Integer.valueOf(product.getHotNum());
            this.hotNumText = product.getHotNumText();
            this.bgColor = product.getBgColor();
            this.allowRating = Integer.valueOf(product.getAllowRating());
            this.wishCount = Integer.valueOf(product.getWishCount());
            this.buyCount = Integer.valueOf(product.getBuyCount());
            this.categoryId = Integer.valueOf(product.getCategoryId());
            this.isOwner = Integer.valueOf(product.getIsOwner());
            this.recommendRows = product.getRecommendRows();
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setBrandId(String str) {
            this.brandId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setSeriesId(String str) {
            this.seriesId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setCoverPicList(List<String> list) {
            this.coverPicList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setConfigNum(int i) {
            this.configNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setPriceMin(float f) {
            this.priceMin = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setPriceMax(float f) {
            this.priceMax = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setPriceCurrency(String str) {
            this.priceCurrency = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setFollowNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore(float f) {
            this.ratingAverageScore = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore1(float f) {
            this.ratingAverageScore1 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore2(float f) {
            this.ratingAverageScore2 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore3(float f) {
            this.ratingAverageScore3 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore4(float f) {
            this.ratingAverageScore4 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore5(float f) {
            this.ratingAverageScore5 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore6(float f) {
            this.ratingAverageScore6 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore7(float f) {
            this.ratingAverageScore7 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore8(float f) {
            this.ratingAverageScore8 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore9(float f) {
            this.ratingAverageScore9 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingAverageScore10(float f) {
            this.ratingAverageScore10 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRatingTotalNum(int i) {
            this.ratingTotalNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setVoteDigNum(int i) {
            this.voteDigNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setVoteBuryNum(int i) {
            this.voteBuryNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setTagArr(List<String> list) {
            this.tagArr = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setFeedCommentNum(int i) {
            this.feedCommentNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setFeedAnswerNum(int i) {
            this.feedAnswerNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setFeedArticleNum(int i) {
            this.feedArticleNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setFeedVideoNum(int i) {
            this.feedVideoNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRecommendImageNum(int i) {
            this.recommendImageNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRecommendVideoNum(int i) {
            this.recommendVideoNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setReleaseTime(String str) {
            this.releaseTime = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setShareNum(int i) {
            this.shareNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setShareUrl(String str) {
            this.shareUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setBlockStatus(int i) {
            this.blockStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setReleaseStatus(int i) {
            this.releaseStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStatus(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setCreateUid(String str) {
            this.createUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setCreateTime(String str) {
            this.createTime = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setUpdateTime(String str) {
            this.updateTime = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setUpdateUid(String str) {
            this.updateUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setConfigRows(List<ProductConfig> list) {
            this.configRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setUserAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setTabApiList(List<ConfigPage> list) {
            this.tabApiList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setSelectedTab(String str) {
            this.selectedTab = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setVoteDigPercentage(float f) {
            this.voteDigPercentage = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setSecondHandFeedNum(String str) {
            this.secondHandFeedNum = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStarAverageScore(float f) {
            this.starAverageScore = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStarTotalCount(int i) {
            this.starTotalCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStar1Count(int i) {
            this.star1Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStar2Count(int i) {
            this.star2Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStar3Count(int i) {
            this.star3Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStar4Count(int i) {
            this.star4Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setStar5Count(int i) {
            this.star5Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStar1Count(int i) {
            this.ownerStar1Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStar2Count(int i) {
            this.ownerStar2Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStar3Count(int i) {
            this.ownerStar3Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStar4Count(int i) {
            this.ownerStar4Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStar5Count(int i) {
            this.ownerStar5Count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStarAverageScore(float f) {
            this.ownerStarAverageScore = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerStarTotalCount(int i) {
            this.ownerStarTotalCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerRatingTotalNum(int i) {
            this.ownerRatingTotalNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setOwnerBuyCount(int i) {
            this.ownerBuyCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setSecondHandSthType(String str) {
            this.secondHandSthType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setCouponTitle(String str) {
            this.couponTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setCouponList(List<ProductCoupon> list) {
            this.couponList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setType(String str) {
            this.type = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setTopIds(List<String> list) {
            this.topIds = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRecentFollowList(List<RelatedData> list) {
            this.recentFollowList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setHotNum(int i) {
            this.hotNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setHotNumText(String str) {
            this.hotNumText = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setBgColor(String str) {
            this.bgColor = str;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setAllowRating(int i) {
            this.allowRating = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setWishCount(int i) {
            this.wishCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setBuyCount(int i) {
            this.buyCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setCategoryId(int i) {
            this.categoryId = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setIsOwner(int i) {
            this.isOwner = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product.Builder setRecommendRows(List<NewHeadLine> list) {
            this.recommendRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Product.Builder
        public Product build() {
            String str = "";
            if (this.coverPicList == null) {
                str = str + " coverPicList";
            }
            if (this.configNum == null) {
                str = str + " configNum";
            }
            if (this.priceMin == null) {
                str = str + " priceMin";
            }
            if (this.priceMax == null) {
                str = str + " priceMax";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.ratingAverageScore == null) {
                str = str + " ratingAverageScore";
            }
            if (this.ratingAverageScore1 == null) {
                str = str + " ratingAverageScore1";
            }
            if (this.ratingAverageScore2 == null) {
                str = str + " ratingAverageScore2";
            }
            if (this.ratingAverageScore3 == null) {
                str = str + " ratingAverageScore3";
            }
            if (this.ratingAverageScore4 == null) {
                str = str + " ratingAverageScore4";
            }
            if (this.ratingAverageScore5 == null) {
                str = str + " ratingAverageScore5";
            }
            if (this.ratingAverageScore6 == null) {
                str = str + " ratingAverageScore6";
            }
            if (this.ratingAverageScore7 == null) {
                str = str + " ratingAverageScore7";
            }
            if (this.ratingAverageScore8 == null) {
                str = str + " ratingAverageScore8";
            }
            if (this.ratingAverageScore9 == null) {
                str = str + " ratingAverageScore9";
            }
            if (this.ratingAverageScore10 == null) {
                str = str + " ratingAverageScore10";
            }
            if (this.ratingTotalNum == null) {
                str = str + " ratingTotalNum";
            }
            if (this.voteDigNum == null) {
                str = str + " voteDigNum";
            }
            if (this.voteBuryNum == null) {
                str = str + " voteBuryNum";
            }
            if (this.tagArr == null) {
                str = str + " tagArr";
            }
            if (this.feedCommentNum == null) {
                str = str + " feedCommentNum";
            }
            if (this.feedAnswerNum == null) {
                str = str + " feedAnswerNum";
            }
            if (this.feedArticleNum == null) {
                str = str + " feedArticleNum";
            }
            if (this.feedVideoNum == null) {
                str = str + " feedVideoNum";
            }
            if (this.recommendImageNum == null) {
                str = str + " recommendImageNum";
            }
            if (this.recommendVideoNum == null) {
                str = str + " recommendVideoNum";
            }
            if (this.shareNum == null) {
                str = str + " shareNum";
            }
            if (this.blockStatus == null) {
                str = str + " blockStatus";
            }
            if (this.releaseStatus == null) {
                str = str + " releaseStatus";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (this.configRows == null) {
                str = str + " configRows";
            }
            if (this.userAction == null) {
                str = str + " userAction";
            }
            if (this.tabApiList == null) {
                str = str + " tabApiList";
            }
            if (this.voteDigPercentage == null) {
                str = str + " voteDigPercentage";
            }
            if (this.starAverageScore == null) {
                str = str + " starAverageScore";
            }
            if (this.starTotalCount == null) {
                str = str + " starTotalCount";
            }
            if (this.star1Count == null) {
                str = str + " star1Count";
            }
            if (this.star2Count == null) {
                str = str + " star2Count";
            }
            if (this.star3Count == null) {
                str = str + " star3Count";
            }
            if (this.star4Count == null) {
                str = str + " star4Count";
            }
            if (this.star5Count == null) {
                str = str + " star5Count";
            }
            if (this.ownerStar1Count == null) {
                str = str + " ownerStar1Count";
            }
            if (this.ownerStar2Count == null) {
                str = str + " ownerStar2Count";
            }
            if (this.ownerStar3Count == null) {
                str = str + " ownerStar3Count";
            }
            if (this.ownerStar4Count == null) {
                str = str + " ownerStar4Count";
            }
            if (this.ownerStar5Count == null) {
                str = str + " ownerStar5Count";
            }
            if (this.ownerStarAverageScore == null) {
                str = str + " ownerStarAverageScore";
            }
            if (this.ownerStarTotalCount == null) {
                str = str + " ownerStarTotalCount";
            }
            if (this.ownerRatingTotalNum == null) {
                str = str + " ownerRatingTotalNum";
            }
            if (this.ownerBuyCount == null) {
                str = str + " ownerBuyCount";
            }
            if (this.topIds == null) {
                str = str + " topIds";
            }
            if (this.recentFollowList == null) {
                str = str + " recentFollowList";
            }
            if (this.hotNum == null) {
                str = str + " hotNum";
            }
            if (this.allowRating == null) {
                str = str + " allowRating";
            }
            if (this.wishCount == null) {
                str = str + " wishCount";
            }
            if (this.buyCount == null) {
                str = str + " buyCount";
            }
            if (this.categoryId == null) {
                str = str + " categoryId";
            }
            if (this.isOwner == null) {
                str = str + " isOwner";
            }
            if (this.recommendRows == null) {
                str = str + " recommendRows";
            }
            if (str.isEmpty()) {
                return new AutoValue_Product(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.brandId, this.seriesId, this.coverPicList, this.configNum.intValue(), this.priceMin.floatValue(), this.priceMax.floatValue(), this.priceCurrency, this.followNum.intValue(), this.ratingAverageScore.floatValue(), this.ratingAverageScore1.floatValue(), this.ratingAverageScore2.floatValue(), this.ratingAverageScore3.floatValue(), this.ratingAverageScore4.floatValue(), this.ratingAverageScore5.floatValue(), this.ratingAverageScore6.floatValue(), this.ratingAverageScore7.floatValue(), this.ratingAverageScore8.floatValue(), this.ratingAverageScore9.floatValue(), this.ratingAverageScore10.floatValue(), this.ratingTotalNum.intValue(), this.voteDigNum.intValue(), this.voteBuryNum.intValue(), this.tagArr, this.feedCommentNum.intValue(), this.feedAnswerNum.intValue(), this.feedArticleNum.intValue(), this.feedVideoNum.intValue(), this.recommendImageNum.intValue(), this.recommendVideoNum.intValue(), this.releaseTime, this.shareNum.intValue(), this.shareUrl, this.blockStatus.intValue(), this.releaseStatus.intValue(), this.status.intValue(), this.createUid, this.createTime, this.updateTime, this.updateUid, this.configRows, this.userAction, this.tabApiList, this.selectedTab, this.voteDigPercentage.floatValue(), this.secondHandFeedNum, this.starAverageScore.floatValue(), this.starTotalCount.intValue(), this.star1Count.intValue(), this.star2Count.intValue(), this.star3Count.intValue(), this.star4Count.intValue(), this.star5Count.intValue(), this.ownerStar1Count.intValue(), this.ownerStar2Count.intValue(), this.ownerStar3Count.intValue(), this.ownerStar4Count.intValue(), this.ownerStar5Count.intValue(), this.ownerStarAverageScore.floatValue(), this.ownerStarTotalCount.intValue(), this.ownerRatingTotalNum.intValue(), this.ownerBuyCount.intValue(), this.secondHandSthType, this.couponTitle, this.couponList, this.type, this.topIds, this.recentFollowList, this.hotNum.intValue(), this.hotNumText, this.bgColor, this.allowRating.intValue(), this.wishCount.intValue(), this.buyCount.intValue(), this.categoryId.intValue(), this.isOwner.intValue(), this.recommendRows);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
