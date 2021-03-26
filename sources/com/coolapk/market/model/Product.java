package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_Product;
import com.coolapk.market.model.C$AutoValue_Product;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public abstract class Product implements Entity {

    public static abstract class Builder {
        public abstract Product build();

        public abstract Builder setAllowRating(int i);

        public abstract Builder setBgColor(String str);

        public abstract Builder setBlockStatus(int i);

        public abstract Builder setBrandId(String str);

        public abstract Builder setBuyCount(int i);

        public abstract Builder setCategoryId(int i);

        public abstract Builder setConfigNum(int i);

        public abstract Builder setConfigRows(List<ProductConfig> list);

        public abstract Builder setCouponList(List<ProductCoupon> list);

        public abstract Builder setCouponTitle(String str);

        public abstract Builder setCoverPicList(List<String> list);

        public abstract Builder setCreateTime(String str);

        public abstract Builder setCreateUid(String str);

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFeedAnswerNum(int i);

        public abstract Builder setFeedArticleNum(int i);

        public abstract Builder setFeedCommentNum(int i);

        public abstract Builder setFeedVideoNum(int i);

        public abstract Builder setFollowNum(int i);

        public abstract Builder setHotNum(int i);

        public abstract Builder setHotNumText(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsOwner(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLogo(String str);

        public abstract Builder setOwnerBuyCount(int i);

        public abstract Builder setOwnerRatingTotalNum(int i);

        public abstract Builder setOwnerStar1Count(int i);

        public abstract Builder setOwnerStar2Count(int i);

        public abstract Builder setOwnerStar3Count(int i);

        public abstract Builder setOwnerStar4Count(int i);

        public abstract Builder setOwnerStar5Count(int i);

        public abstract Builder setOwnerStarAverageScore(float f);

        public abstract Builder setOwnerStarTotalCount(int i);

        public abstract Builder setPic(String str);

        public abstract Builder setPriceCurrency(String str);

        public abstract Builder setPriceMax(float f);

        public abstract Builder setPriceMin(float f);

        public abstract Builder setRatingAverageScore(float f);

        public abstract Builder setRatingAverageScore1(float f);

        public abstract Builder setRatingAverageScore10(float f);

        public abstract Builder setRatingAverageScore2(float f);

        public abstract Builder setRatingAverageScore3(float f);

        public abstract Builder setRatingAverageScore4(float f);

        public abstract Builder setRatingAverageScore5(float f);

        public abstract Builder setRatingAverageScore6(float f);

        public abstract Builder setRatingAverageScore7(float f);

        public abstract Builder setRatingAverageScore8(float f);

        public abstract Builder setRatingAverageScore9(float f);

        public abstract Builder setRatingTotalNum(int i);

        public abstract Builder setRecentFollowList(List<RelatedData> list);

        public abstract Builder setRecommendImageNum(int i);

        public abstract Builder setRecommendRows(List<NewHeadLine> list);

        public abstract Builder setRecommendVideoNum(int i);

        public abstract Builder setReleaseStatus(int i);

        public abstract Builder setReleaseTime(String str);

        public abstract Builder setSecondHandFeedNum(String str);

        public abstract Builder setSecondHandSthType(String str);

        public abstract Builder setSelectedTab(String str);

        public abstract Builder setSeriesId(String str);

        public abstract Builder setShareNum(int i);

        public abstract Builder setShareUrl(String str);

        public abstract Builder setStar1Count(int i);

        public abstract Builder setStar2Count(int i);

        public abstract Builder setStar3Count(int i);

        public abstract Builder setStar4Count(int i);

        public abstract Builder setStar5Count(int i);

        public abstract Builder setStarAverageScore(float f);

        public abstract Builder setStarTotalCount(int i);

        public abstract Builder setStatus(int i);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTabApiList(List<ConfigPage> list);

        public abstract Builder setTagArr(List<String> list);

        public abstract Builder setTitle(String str);

        public abstract Builder setTopIds(List<String> list);

        public abstract Builder setType(String str);

        public abstract Builder setUpdateTime(String str);

        public abstract Builder setUpdateUid(String str);

        public abstract Builder setUrl(String str);

        public abstract Builder setUserAction(UserAction userAction);

        public abstract Builder setVoteBuryNum(int i);

        public abstract Builder setVoteDigNum(int i);

        public abstract Builder setVoteDigPercentage(float f);

        public abstract Builder setWishCount(int i);
    }

    @SerializedName("allow_rating")
    public abstract int getAllowRating();

    @SerializedName("bgColor")
    public abstract String getBgColor();

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @SerializedName("brand_id")
    public abstract String getBrandId();

    @SerializedName("buy_count")
    public abstract int getBuyCount();

    @SerializedName("category_id")
    public abstract int getCategoryId();

    @SerializedName("config_num")
    public abstract int getConfigNum();

    @SerializedName("configRows")
    public abstract List<ProductConfig> getConfigRows();

    @SerializedName("coupon_list")
    public abstract List<ProductCoupon> getCouponList();

    @SerializedName("get_coupon_title")
    public abstract String getCouponTitle();

    @SerializedName("coverArr")
    public abstract List<String> getCoverPicList();

    @SerializedName("create_time")
    public abstract String getCreateTime();

    @SerializedName("create_uid")
    public abstract String getCreateUid();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "product";
    }

    @SerializedName("feed_answer_num")
    public abstract int getFeedAnswerNum();

    @SerializedName("feed_tuwen_num")
    public abstract int getFeedArticleNum();

    @SerializedName("feed_comment_num")
    public abstract int getFeedCommentNum();

    @SerializedName("feed_video_num")
    public abstract int getFeedVideoNum();

    @SerializedName("follow_num")
    public abstract int getFollowNum();

    @SerializedName("hot_num")
    public abstract int getHotNum();

    @SerializedName("hot_num_txt")
    public abstract String getHotNumText();

    @SerializedName("is_owner")
    public abstract int getIsOwner();

    @SerializedName("owner_buy_count")
    public abstract int getOwnerBuyCount();

    @SerializedName("owner_rating_total_num")
    public abstract int getOwnerRatingTotalNum();

    @SerializedName("owner_star_1_count")
    public abstract int getOwnerStar1Count();

    @SerializedName("owner_star_2_count")
    public abstract int getOwnerStar2Count();

    @SerializedName("owner_star_3_count")
    public abstract int getOwnerStar3Count();

    @SerializedName("owner_star_4_count")
    public abstract int getOwnerStar4Count();

    @SerializedName("owner_star_5_count")
    public abstract int getOwnerStar5Count();

    @SerializedName("owner_star_average_score")
    public abstract float getOwnerStarAverageScore();

    @SerializedName("owner_star_total_count")
    public abstract int getOwnerStarTotalCount();

    @SerializedName("price_currency")
    public abstract String getPriceCurrency();

    @SerializedName("price_max")
    public abstract float getPriceMax();

    @SerializedName("price_min")
    public abstract float getPriceMin();

    @SerializedName("rating_average_score")
    public abstract float getRatingAverageScore();

    @SerializedName("rating_average_score_1")
    public abstract float getRatingAverageScore1();

    @SerializedName("rating_average_score_10")
    public abstract float getRatingAverageScore10();

    @SerializedName("rating_average_score_2")
    public abstract float getRatingAverageScore2();

    @SerializedName("rating_average_score_3")
    public abstract float getRatingAverageScore3();

    @SerializedName("rating_average_score_4")
    public abstract float getRatingAverageScore4();

    @SerializedName("rating_average_score_5")
    public abstract float getRatingAverageScore5();

    @SerializedName("rating_average_score_6")
    public abstract float getRatingAverageScore6();

    @SerializedName("rating_average_score_7")
    public abstract float getRatingAverageScore7();

    @SerializedName("rating_average_score_8")
    public abstract float getRatingAverageScore8();

    @SerializedName("rating_average_score_9")
    public abstract float getRatingAverageScore9();

    @SerializedName("rating_total_num")
    public abstract int getRatingTotalNum();

    @SerializedName("recent_follow_list")
    public abstract List<RelatedData> getRecentFollowList();

    @SerializedName("recommend_image_num")
    public abstract int getRecommendImageNum();

    @SerializedName("recommendRows")
    public abstract List<NewHeadLine> getRecommendRows();

    @SerializedName("recommend_video_num")
    public abstract int getRecommendVideoNum();

    @SerializedName("release_status")
    public abstract int getReleaseStatus();

    @SerializedName("release_time")
    public abstract String getReleaseTime();

    @SerializedName("sale_num")
    public abstract String getSecondHandFeedNum();

    public abstract String getSecondHandSthType();

    @SerializedName("selectedTab")
    public abstract String getSelectedTab();

    @SerializedName("series_id")
    public abstract String getSeriesId();

    @SerializedName("share_num")
    public abstract int getShareNum();

    @SerializedName("sell_url")
    public abstract String getShareUrl();

    @SerializedName("star_1_count")
    public abstract int getStar1Count();

    @SerializedName("star_2_count")
    public abstract int getStar2Count();

    @SerializedName("star_3_count")
    public abstract int getStar3Count();

    @SerializedName("star_4_count")
    public abstract int getStar4Count();

    @SerializedName("star_5_count")
    public abstract int getStar5Count();

    @SerializedName("star_average_score")
    public abstract float getStarAverageScore();

    @SerializedName("star_total_count")
    public abstract int getStarTotalCount();

    @SerializedName("status")
    public abstract int getStatus();

    @SerializedName("tabList")
    public abstract List<ConfigPage> getTabApiList();

    @SerializedName("tagArr")
    public abstract List<String> getTagArr();

    @SerializedName("top_ids")
    public abstract List<String> getTopIds();

    public abstract String getType();

    @SerializedName("update_time")
    public abstract String getUpdateTime();

    @SerializedName("update_uid")
    public abstract String getUpdateUid();

    @SerializedName("userAction")
    public abstract UserAction getUserAction();

    @SerializedName("vote_bury_num")
    public abstract int getVoteBuryNum();

    @SerializedName("vote_dig_num")
    public abstract int getVoteDigNum();

    @SerializedName("vote_dig_percentage")
    public abstract float getVoteDigPercentage();

    @SerializedName("wish_count")
    public abstract int getWishCount();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getSecondHandNumText() {
        if (TextUtils.equals(getSecondHandFeedNum(), "0") || TextUtils.isEmpty(getSecondHandFeedNum())) {
            return getTitle();
        }
        return getTitle() + "(" + getSecondHandFeedNum() + ")";
    }

    public String getSquareLogo() {
        if (TextUtils.isEmpty(getLogo())) {
            return getLogo();
        }
        return getLogo() + ".t.jpg";
    }

    public static TypeAdapter<Product> typeAdapter(Gson gson) {
        return new C$AutoValue_Product.GsonTypeAdapter(gson).setDefaultUserAction(UserAction.EMPTY_ACTION);
    }

    public boolean isReleased() {
        return getReleaseStatus() == 1;
    }

    public Builder builder() {
        return newBuilder(this);
    }

    public static Builder newBuilder(Product product) {
        return new C$$AutoValue_Product.Builder(product);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_Product.Builder().setId("").setTitle("").setLogo("").setEntityTemplate("").setEntityTypeName("").setReleaseStatus(0).setExtraData("").setCoverPicList(null).setConfigNum(0).setPriceMax(0.0f).setPriceMin(0.0f).setFollowNum(0).setRatingAverageScore(0.0f).setRatingAverageScore1(0.0f).setRatingAverageScore2(0.0f).setRatingAverageScore3(0.0f).setRatingAverageScore4(0.0f).setRatingAverageScore5(0.0f).setRatingAverageScore6(0.0f).setRatingAverageScore7(0.0f).setRatingAverageScore8(0.0f).setRatingAverageScore9(0.0f).setRatingAverageScore10(0.0f).setRatingTotalNum(0).setVoteDigNum(0).setVoteBuryNum(0).setTagArr(null).setFeedAnswerNum(0).setFeedArticleNum(0).setFeedCommentNum(0).setFeedVideoNum(0).setRecommendImageNum(0).setRecommendVideoNum(0).setShareNum(0).setShareUrl("").setHotNumText("").setStatus(0).setConfigRows(null).setBlockStatus(0).setUserAction(UserAction.EMPTY_ACTION).setTabApiList(new ArrayList()).setSecondHandSthType("").setSecondHandFeedNum("").setVoteDigPercentage(0.0f).setTopIds(new ArrayList()).setRecentFollowList(new ArrayList()).setStarAverageScore(0.0f).setStarTotalCount(0).setHotNum(0).setRecommendRows(new ArrayList()).setAllowRating(1).setStar1Count(0).setStar2Count(0).setStar3Count(0).setStar4Count(0).setStar5Count(0).setWishCount(0).setBuyCount(0).setOwnerStar1Count(0).setOwnerStar2Count(0).setOwnerStar3Count(0).setOwnerStar4Count(0).setOwnerStar5Count(0).setOwnerStarAverageScore(0.0f).setOwnerStarTotalCount(0).setOwnerRatingTotalNum(0).setOwnerBuyCount(0).setCategoryId(0).setIsOwner(0);
    }
}
