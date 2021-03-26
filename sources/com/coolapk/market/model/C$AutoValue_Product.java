package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_Product  reason: invalid class name */
abstract class C$AutoValue_Product extends C$$AutoValue_Product {
    C$AutoValue_Product(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, String str13, List<String> list, int i, float f, float f2, String str14, int i2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int i3, int i4, int i5, List<String> list2, int i6, int i7, int i8, int i9, int i10, int i11, String str15, int i12, String str16, int i13, int i14, int i15, String str17, String str18, String str19, String str20, List<ProductConfig> list3, UserAction userAction, List<ConfigPage> list4, String str21, float f14, String str22, float f15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, float f16, int i27, int i28, int i29, String str23, String str24, List<ProductCoupon> list5, String str25, List<String> list6, List<RelatedData> list7, int i30, String str26, String str27, int i31, int i32, int i33, int i34, int i35, List<NewHeadLine> list8) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l, l2, str12, str13, list, i, f, f2, str14, i2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, i3, i4, i5, list2, i6, i7, i8, i9, i10, i11, str15, i12, str16, i13, i14, i15, str17, str18, str19, str20, list3, userAction, list4, str21, f14, str22, f15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, f16, i27, i28, i29, str23, str24, list5, str25, list6, list7, i30, str26, str27, i31, i32, i33, i34, i35, list8);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Product$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Product> {
        private final TypeAdapter<Integer> allowRatingAdapter;
        private final TypeAdapter<String> bgColorAdapter;
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<String> brandIdAdapter;
        private final TypeAdapter<Integer> buyCountAdapter;
        private final TypeAdapter<Integer> categoryIdAdapter;
        private final TypeAdapter<Integer> configNumAdapter;
        private final TypeAdapter<List<ProductConfig>> configRowsAdapter;
        private final TypeAdapter<List<ProductCoupon>> couponListAdapter;
        private final TypeAdapter<String> couponTitleAdapter;
        private final TypeAdapter<List<String>> coverPicListAdapter;
        private final TypeAdapter<String> createTimeAdapter;
        private final TypeAdapter<String> createUidAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultAllowRating = 0;
        private String defaultBgColor = null;
        private int defaultBlockStatus = 0;
        private String defaultBrandId = null;
        private int defaultBuyCount = 0;
        private int defaultCategoryId = 0;
        private int defaultConfigNum = 0;
        private List<ProductConfig> defaultConfigRows = Collections.emptyList();
        private List<ProductCoupon> defaultCouponList = null;
        private String defaultCouponTitle = null;
        private List<String> defaultCoverPicList = Collections.emptyList();
        private String defaultCreateTime = null;
        private String defaultCreateUid = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFeedAnswerNum = 0;
        private int defaultFeedArticleNum = 0;
        private int defaultFeedCommentNum = 0;
        private int defaultFeedVideoNum = 0;
        private int defaultFollowNum = 0;
        private int defaultHotNum = 0;
        private String defaultHotNumText = null;
        private String defaultId = null;
        private int defaultIsOwner = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private int defaultOwnerBuyCount = 0;
        private int defaultOwnerRatingTotalNum = 0;
        private int defaultOwnerStar1Count = 0;
        private int defaultOwnerStar2Count = 0;
        private int defaultOwnerStar3Count = 0;
        private int defaultOwnerStar4Count = 0;
        private int defaultOwnerStar5Count = 0;
        private float defaultOwnerStarAverageScore = 0.0f;
        private int defaultOwnerStarTotalCount = 0;
        private String defaultPic = null;
        private String defaultPriceCurrency = null;
        private float defaultPriceMax = 0.0f;
        private float defaultPriceMin = 0.0f;
        private float defaultRatingAverageScore = 0.0f;
        private float defaultRatingAverageScore1 = 0.0f;
        private float defaultRatingAverageScore10 = 0.0f;
        private float defaultRatingAverageScore2 = 0.0f;
        private float defaultRatingAverageScore3 = 0.0f;
        private float defaultRatingAverageScore4 = 0.0f;
        private float defaultRatingAverageScore5 = 0.0f;
        private float defaultRatingAverageScore6 = 0.0f;
        private float defaultRatingAverageScore7 = 0.0f;
        private float defaultRatingAverageScore8 = 0.0f;
        private float defaultRatingAverageScore9 = 0.0f;
        private int defaultRatingTotalNum = 0;
        private List<RelatedData> defaultRecentFollowList = Collections.emptyList();
        private int defaultRecommendImageNum = 0;
        private List<NewHeadLine> defaultRecommendRows = Collections.emptyList();
        private int defaultRecommendVideoNum = 0;
        private int defaultReleaseStatus = 0;
        private String defaultReleaseTime = null;
        private String defaultSecondHandFeedNum = null;
        private String defaultSecondHandSthType = null;
        private String defaultSelectedTab = null;
        private String defaultSeriesId = null;
        private int defaultShareNum = 0;
        private String defaultShareUrl = null;
        private int defaultStar1Count = 0;
        private int defaultStar2Count = 0;
        private int defaultStar3Count = 0;
        private int defaultStar4Count = 0;
        private int defaultStar5Count = 0;
        private float defaultStarAverageScore = 0.0f;
        private int defaultStarTotalCount = 0;
        private int defaultStatus = 0;
        private String defaultSubTitle = null;
        private List<ConfigPage> defaultTabApiList = Collections.emptyList();
        private List<String> defaultTagArr = Collections.emptyList();
        private String defaultTitle = null;
        private List<String> defaultTopIds = Collections.emptyList();
        private String defaultType = null;
        private String defaultUpdateTime = null;
        private String defaultUpdateUid = null;
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
        private int defaultVoteBuryNum = 0;
        private int defaultVoteDigNum = 0;
        private float defaultVoteDigPercentage = 0.0f;
        private int defaultWishCount = 0;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> feedAnswerNumAdapter;
        private final TypeAdapter<Integer> feedArticleNumAdapter;
        private final TypeAdapter<Integer> feedCommentNumAdapter;
        private final TypeAdapter<Integer> feedVideoNumAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<Integer> hotNumAdapter;
        private final TypeAdapter<String> hotNumTextAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isOwnerAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<Integer> ownerBuyCountAdapter;
        private final TypeAdapter<Integer> ownerRatingTotalNumAdapter;
        private final TypeAdapter<Integer> ownerStar1CountAdapter;
        private final TypeAdapter<Integer> ownerStar2CountAdapter;
        private final TypeAdapter<Integer> ownerStar3CountAdapter;
        private final TypeAdapter<Integer> ownerStar4CountAdapter;
        private final TypeAdapter<Integer> ownerStar5CountAdapter;
        private final TypeAdapter<Float> ownerStarAverageScoreAdapter;
        private final TypeAdapter<Integer> ownerStarTotalCountAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> priceCurrencyAdapter;
        private final TypeAdapter<Float> priceMaxAdapter;
        private final TypeAdapter<Float> priceMinAdapter;
        private final TypeAdapter<Float> ratingAverageScore10Adapter;
        private final TypeAdapter<Float> ratingAverageScore1Adapter;
        private final TypeAdapter<Float> ratingAverageScore2Adapter;
        private final TypeAdapter<Float> ratingAverageScore3Adapter;
        private final TypeAdapter<Float> ratingAverageScore4Adapter;
        private final TypeAdapter<Float> ratingAverageScore5Adapter;
        private final TypeAdapter<Float> ratingAverageScore6Adapter;
        private final TypeAdapter<Float> ratingAverageScore7Adapter;
        private final TypeAdapter<Float> ratingAverageScore8Adapter;
        private final TypeAdapter<Float> ratingAverageScore9Adapter;
        private final TypeAdapter<Float> ratingAverageScoreAdapter;
        private final TypeAdapter<Integer> ratingTotalNumAdapter;
        private final TypeAdapter<List<RelatedData>> recentFollowListAdapter;
        private final TypeAdapter<Integer> recommendImageNumAdapter;
        private final TypeAdapter<List<NewHeadLine>> recommendRowsAdapter;
        private final TypeAdapter<Integer> recommendVideoNumAdapter;
        private final TypeAdapter<Integer> releaseStatusAdapter;
        private final TypeAdapter<String> releaseTimeAdapter;
        private final TypeAdapter<String> secondHandFeedNumAdapter;
        private final TypeAdapter<String> secondHandSthTypeAdapter;
        private final TypeAdapter<String> selectedTabAdapter;
        private final TypeAdapter<String> seriesIdAdapter;
        private final TypeAdapter<Integer> shareNumAdapter;
        private final TypeAdapter<String> shareUrlAdapter;
        private final TypeAdapter<Integer> star1CountAdapter;
        private final TypeAdapter<Integer> star2CountAdapter;
        private final TypeAdapter<Integer> star3CountAdapter;
        private final TypeAdapter<Integer> star4CountAdapter;
        private final TypeAdapter<Integer> star5CountAdapter;
        private final TypeAdapter<Float> starAverageScoreAdapter;
        private final TypeAdapter<Integer> starTotalCountAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<List<ConfigPage>> tabApiListAdapter;
        private final TypeAdapter<List<String>> tagArrAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<List<String>> topIdsAdapter;
        private final TypeAdapter<String> typeAdapter;
        private final TypeAdapter<String> updateTimeAdapter;
        private final TypeAdapter<String> updateUidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<Integer> voteBuryNumAdapter;
        private final TypeAdapter<Integer> voteDigNumAdapter;
        private final TypeAdapter<Float> voteDigPercentageAdapter;
        private final TypeAdapter<Integer> wishCountAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.brandIdAdapter = gson.getAdapter(String.class);
            this.seriesIdAdapter = gson.getAdapter(String.class);
            this.coverPicListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.configNumAdapter = gson.getAdapter(Integer.class);
            this.priceMinAdapter = gson.getAdapter(Float.class);
            this.priceMaxAdapter = gson.getAdapter(Float.class);
            this.priceCurrencyAdapter = gson.getAdapter(String.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.ratingAverageScoreAdapter = gson.getAdapter(Float.class);
            this.ratingAverageScore1Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore2Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore3Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore4Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore5Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore6Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore7Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore8Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore9Adapter = gson.getAdapter(Float.class);
            this.ratingAverageScore10Adapter = gson.getAdapter(Float.class);
            this.ratingTotalNumAdapter = gson.getAdapter(Integer.class);
            this.voteDigNumAdapter = gson.getAdapter(Integer.class);
            this.voteBuryNumAdapter = gson.getAdapter(Integer.class);
            this.tagArrAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.feedCommentNumAdapter = gson.getAdapter(Integer.class);
            this.feedAnswerNumAdapter = gson.getAdapter(Integer.class);
            this.feedArticleNumAdapter = gson.getAdapter(Integer.class);
            this.feedVideoNumAdapter = gson.getAdapter(Integer.class);
            this.recommendImageNumAdapter = gson.getAdapter(Integer.class);
            this.recommendVideoNumAdapter = gson.getAdapter(Integer.class);
            this.releaseTimeAdapter = gson.getAdapter(String.class);
            this.shareNumAdapter = gson.getAdapter(Integer.class);
            this.shareUrlAdapter = gson.getAdapter(String.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.releaseStatusAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.createUidAdapter = gson.getAdapter(String.class);
            this.createTimeAdapter = gson.getAdapter(String.class);
            this.updateTimeAdapter = gson.getAdapter(String.class);
            this.updateUidAdapter = gson.getAdapter(String.class);
            this.configRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ProductConfig.class));
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.tabApiListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ConfigPage.class));
            this.selectedTabAdapter = gson.getAdapter(String.class);
            this.voteDigPercentageAdapter = gson.getAdapter(Float.class);
            this.secondHandFeedNumAdapter = gson.getAdapter(String.class);
            this.starAverageScoreAdapter = gson.getAdapter(Float.class);
            this.starTotalCountAdapter = gson.getAdapter(Integer.class);
            this.star1CountAdapter = gson.getAdapter(Integer.class);
            this.star2CountAdapter = gson.getAdapter(Integer.class);
            this.star3CountAdapter = gson.getAdapter(Integer.class);
            this.star4CountAdapter = gson.getAdapter(Integer.class);
            this.star5CountAdapter = gson.getAdapter(Integer.class);
            this.ownerStar1CountAdapter = gson.getAdapter(Integer.class);
            this.ownerStar2CountAdapter = gson.getAdapter(Integer.class);
            this.ownerStar3CountAdapter = gson.getAdapter(Integer.class);
            this.ownerStar4CountAdapter = gson.getAdapter(Integer.class);
            this.ownerStar5CountAdapter = gson.getAdapter(Integer.class);
            this.ownerStarAverageScoreAdapter = gson.getAdapter(Float.class);
            this.ownerStarTotalCountAdapter = gson.getAdapter(Integer.class);
            this.ownerRatingTotalNumAdapter = gson.getAdapter(Integer.class);
            this.ownerBuyCountAdapter = gson.getAdapter(Integer.class);
            this.secondHandSthTypeAdapter = gson.getAdapter(String.class);
            this.couponTitleAdapter = gson.getAdapter(String.class);
            this.couponListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ProductCoupon.class));
            this.typeAdapter = gson.getAdapter(String.class);
            this.topIdsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.recentFollowListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.hotNumAdapter = gson.getAdapter(Integer.class);
            this.hotNumTextAdapter = gson.getAdapter(String.class);
            this.bgColorAdapter = gson.getAdapter(String.class);
            this.allowRatingAdapter = gson.getAdapter(Integer.class);
            this.wishCountAdapter = gson.getAdapter(Integer.class);
            this.buyCountAdapter = gson.getAdapter(Integer.class);
            this.categoryIdAdapter = gson.getAdapter(Integer.class);
            this.isOwnerAdapter = gson.getAdapter(Integer.class);
            this.recommendRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, NewHeadLine.class));
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTemplate(String str) {
            this.defaultEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityId(String str) {
            this.defaultEntityId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityFixed(Integer num) {
            this.defaultEntityFixed = num;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraData(String str) {
            this.defaultExtraData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDateline(Long l) {
            this.defaultDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l) {
            this.defaultLastUpdate = l;
            return this;
        }

        public GsonTypeAdapter setDefaultBrandId(String str) {
            this.defaultBrandId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSeriesId(String str) {
            this.defaultSeriesId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCoverPicList(List<String> list) {
            this.defaultCoverPicList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultConfigNum(int i) {
            this.defaultConfigNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPriceMin(float f) {
            this.defaultPriceMin = f;
            return this;
        }

        public GsonTypeAdapter setDefaultPriceMax(float f) {
            this.defaultPriceMax = f;
            return this;
        }

        public GsonTypeAdapter setDefaultPriceCurrency(String str) {
            this.defaultPriceCurrency = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore(float f) {
            this.defaultRatingAverageScore = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore1(float f) {
            this.defaultRatingAverageScore1 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore2(float f) {
            this.defaultRatingAverageScore2 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore3(float f) {
            this.defaultRatingAverageScore3 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore4(float f) {
            this.defaultRatingAverageScore4 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore5(float f) {
            this.defaultRatingAverageScore5 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore6(float f) {
            this.defaultRatingAverageScore6 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore7(float f) {
            this.defaultRatingAverageScore7 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore8(float f) {
            this.defaultRatingAverageScore8 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore9(float f) {
            this.defaultRatingAverageScore9 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingAverageScore10(float f) {
            this.defaultRatingAverageScore10 = f;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingTotalNum(int i) {
            this.defaultRatingTotalNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteDigNum(int i) {
            this.defaultVoteDigNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteBuryNum(int i) {
            this.defaultVoteBuryNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTagArr(List<String> list) {
            this.defaultTagArr = list;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedCommentNum(int i) {
            this.defaultFeedCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedAnswerNum(int i) {
            this.defaultFeedAnswerNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedArticleNum(int i) {
            this.defaultFeedArticleNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedVideoNum(int i) {
            this.defaultFeedVideoNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendImageNum(int i) {
            this.defaultRecommendImageNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendVideoNum(int i) {
            this.defaultRecommendVideoNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReleaseTime(String str) {
            this.defaultReleaseTime = str;
            return this;
        }

        public GsonTypeAdapter setDefaultShareNum(int i) {
            this.defaultShareNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShareUrl(String str) {
            this.defaultShareUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReleaseStatus(int i) {
            this.defaultReleaseStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateUid(String str) {
            this.defaultCreateUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateTime(String str) {
            this.defaultCreateTime = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateTime(String str) {
            this.defaultUpdateTime = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateUid(String str) {
            this.defaultUpdateUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultConfigRows(List<ProductConfig> list) {
            this.defaultConfigRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultTabApiList(List<ConfigPage> list) {
            this.defaultTabApiList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultSelectedTab(String str) {
            this.defaultSelectedTab = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVoteDigPercentage(float f) {
            this.defaultVoteDigPercentage = f;
            return this;
        }

        public GsonTypeAdapter setDefaultSecondHandFeedNum(String str) {
            this.defaultSecondHandFeedNum = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStarAverageScore(float f) {
            this.defaultStarAverageScore = f;
            return this;
        }

        public GsonTypeAdapter setDefaultStarTotalCount(int i) {
            this.defaultStarTotalCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStar1Count(int i) {
            this.defaultStar1Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStar2Count(int i) {
            this.defaultStar2Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStar3Count(int i) {
            this.defaultStar3Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStar4Count(int i) {
            this.defaultStar4Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStar5Count(int i) {
            this.defaultStar5Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStar1Count(int i) {
            this.defaultOwnerStar1Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStar2Count(int i) {
            this.defaultOwnerStar2Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStar3Count(int i) {
            this.defaultOwnerStar3Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStar4Count(int i) {
            this.defaultOwnerStar4Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStar5Count(int i) {
            this.defaultOwnerStar5Count = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStarAverageScore(float f) {
            this.defaultOwnerStarAverageScore = f;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerStarTotalCount(int i) {
            this.defaultOwnerStarTotalCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerRatingTotalNum(int i) {
            this.defaultOwnerRatingTotalNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOwnerBuyCount(int i) {
            this.defaultOwnerBuyCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSecondHandSthType(String str) {
            this.defaultSecondHandSthType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCouponTitle(String str) {
            this.defaultCouponTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCouponList(List<ProductCoupon> list) {
            this.defaultCouponList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultType(String str) {
            this.defaultType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTopIds(List<String> list) {
            this.defaultTopIds = list;
            return this;
        }

        public GsonTypeAdapter setDefaultRecentFollowList(List<RelatedData> list) {
            this.defaultRecentFollowList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultHotNum(int i) {
            this.defaultHotNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultHotNumText(String str) {
            this.defaultHotNumText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBgColor(String str) {
            this.defaultBgColor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAllowRating(int i) {
            this.defaultAllowRating = i;
            return this;
        }

        public GsonTypeAdapter setDefaultWishCount(int i) {
            this.defaultWishCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBuyCount(int i) {
            this.defaultBuyCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryId(int i) {
            this.defaultCategoryId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsOwner(int i) {
            this.defaultIsOwner = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendRows(List<NewHeadLine> list) {
            this.defaultRecommendRows = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, Product product) throws IOException {
            if (product == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, product.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, product.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, product.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, product.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, product.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, product.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, product.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, product.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, product.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, product.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, product.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, product.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, product.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, product.getLastUpdate());
            jsonWriter.name("brand_id");
            this.brandIdAdapter.write(jsonWriter, product.getBrandId());
            jsonWriter.name("series_id");
            this.seriesIdAdapter.write(jsonWriter, product.getSeriesId());
            jsonWriter.name("coverArr");
            this.coverPicListAdapter.write(jsonWriter, product.getCoverPicList());
            jsonWriter.name("config_num");
            this.configNumAdapter.write(jsonWriter, Integer.valueOf(product.getConfigNum()));
            jsonWriter.name("price_min");
            this.priceMinAdapter.write(jsonWriter, Float.valueOf(product.getPriceMin()));
            jsonWriter.name("price_max");
            this.priceMaxAdapter.write(jsonWriter, Float.valueOf(product.getPriceMax()));
            jsonWriter.name("price_currency");
            this.priceCurrencyAdapter.write(jsonWriter, product.getPriceCurrency());
            jsonWriter.name("follow_num");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(product.getFollowNum()));
            jsonWriter.name("rating_average_score");
            this.ratingAverageScoreAdapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore()));
            jsonWriter.name("rating_average_score_1");
            this.ratingAverageScore1Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore1()));
            jsonWriter.name("rating_average_score_2");
            this.ratingAverageScore2Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore2()));
            jsonWriter.name("rating_average_score_3");
            this.ratingAverageScore3Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore3()));
            jsonWriter.name("rating_average_score_4");
            this.ratingAverageScore4Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore4()));
            jsonWriter.name("rating_average_score_5");
            this.ratingAverageScore5Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore5()));
            jsonWriter.name("rating_average_score_6");
            this.ratingAverageScore6Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore6()));
            jsonWriter.name("rating_average_score_7");
            this.ratingAverageScore7Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore7()));
            jsonWriter.name("rating_average_score_8");
            this.ratingAverageScore8Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore8()));
            jsonWriter.name("rating_average_score_9");
            this.ratingAverageScore9Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore9()));
            jsonWriter.name("rating_average_score_10");
            this.ratingAverageScore10Adapter.write(jsonWriter, Float.valueOf(product.getRatingAverageScore10()));
            jsonWriter.name("rating_total_num");
            this.ratingTotalNumAdapter.write(jsonWriter, Integer.valueOf(product.getRatingTotalNum()));
            jsonWriter.name("vote_dig_num");
            this.voteDigNumAdapter.write(jsonWriter, Integer.valueOf(product.getVoteDigNum()));
            jsonWriter.name("vote_bury_num");
            this.voteBuryNumAdapter.write(jsonWriter, Integer.valueOf(product.getVoteBuryNum()));
            jsonWriter.name("tagArr");
            this.tagArrAdapter.write(jsonWriter, product.getTagArr());
            jsonWriter.name("feed_comment_num");
            this.feedCommentNumAdapter.write(jsonWriter, Integer.valueOf(product.getFeedCommentNum()));
            jsonWriter.name("feed_answer_num");
            this.feedAnswerNumAdapter.write(jsonWriter, Integer.valueOf(product.getFeedAnswerNum()));
            jsonWriter.name("feed_tuwen_num");
            this.feedArticleNumAdapter.write(jsonWriter, Integer.valueOf(product.getFeedArticleNum()));
            jsonWriter.name("feed_video_num");
            this.feedVideoNumAdapter.write(jsonWriter, Integer.valueOf(product.getFeedVideoNum()));
            jsonWriter.name("recommend_image_num");
            this.recommendImageNumAdapter.write(jsonWriter, Integer.valueOf(product.getRecommendImageNum()));
            jsonWriter.name("recommend_video_num");
            this.recommendVideoNumAdapter.write(jsonWriter, Integer.valueOf(product.getRecommendVideoNum()));
            jsonWriter.name("release_time");
            this.releaseTimeAdapter.write(jsonWriter, product.getReleaseTime());
            jsonWriter.name("share_num");
            this.shareNumAdapter.write(jsonWriter, Integer.valueOf(product.getShareNum()));
            jsonWriter.name("sell_url");
            this.shareUrlAdapter.write(jsonWriter, product.getShareUrl());
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(product.getBlockStatus()));
            jsonWriter.name("release_status");
            this.releaseStatusAdapter.write(jsonWriter, Integer.valueOf(product.getReleaseStatus()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(product.getStatus()));
            jsonWriter.name("create_uid");
            this.createUidAdapter.write(jsonWriter, product.getCreateUid());
            jsonWriter.name("create_time");
            this.createTimeAdapter.write(jsonWriter, product.getCreateTime());
            jsonWriter.name("update_time");
            this.updateTimeAdapter.write(jsonWriter, product.getUpdateTime());
            jsonWriter.name("update_uid");
            this.updateUidAdapter.write(jsonWriter, product.getUpdateUid());
            jsonWriter.name("configRows");
            this.configRowsAdapter.write(jsonWriter, product.getConfigRows());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, product.getUserAction());
            jsonWriter.name("tabList");
            this.tabApiListAdapter.write(jsonWriter, product.getTabApiList());
            jsonWriter.name("selectedTab");
            this.selectedTabAdapter.write(jsonWriter, product.getSelectedTab());
            jsonWriter.name("vote_dig_percentage");
            this.voteDigPercentageAdapter.write(jsonWriter, Float.valueOf(product.getVoteDigPercentage()));
            jsonWriter.name("sale_num");
            this.secondHandFeedNumAdapter.write(jsonWriter, product.getSecondHandFeedNum());
            jsonWriter.name("star_average_score");
            this.starAverageScoreAdapter.write(jsonWriter, Float.valueOf(product.getStarAverageScore()));
            jsonWriter.name("star_total_count");
            this.starTotalCountAdapter.write(jsonWriter, Integer.valueOf(product.getStarTotalCount()));
            jsonWriter.name("star_1_count");
            this.star1CountAdapter.write(jsonWriter, Integer.valueOf(product.getStar1Count()));
            jsonWriter.name("star_2_count");
            this.star2CountAdapter.write(jsonWriter, Integer.valueOf(product.getStar2Count()));
            jsonWriter.name("star_3_count");
            this.star3CountAdapter.write(jsonWriter, Integer.valueOf(product.getStar3Count()));
            jsonWriter.name("star_4_count");
            this.star4CountAdapter.write(jsonWriter, Integer.valueOf(product.getStar4Count()));
            jsonWriter.name("star_5_count");
            this.star5CountAdapter.write(jsonWriter, Integer.valueOf(product.getStar5Count()));
            jsonWriter.name("owner_star_1_count");
            this.ownerStar1CountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerStar1Count()));
            jsonWriter.name("owner_star_2_count");
            this.ownerStar2CountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerStar2Count()));
            jsonWriter.name("owner_star_3_count");
            this.ownerStar3CountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerStar3Count()));
            jsonWriter.name("owner_star_4_count");
            this.ownerStar4CountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerStar4Count()));
            jsonWriter.name("owner_star_5_count");
            this.ownerStar5CountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerStar5Count()));
            jsonWriter.name("owner_star_average_score");
            this.ownerStarAverageScoreAdapter.write(jsonWriter, Float.valueOf(product.getOwnerStarAverageScore()));
            jsonWriter.name("owner_star_total_count");
            this.ownerStarTotalCountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerStarTotalCount()));
            jsonWriter.name("owner_rating_total_num");
            this.ownerRatingTotalNumAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerRatingTotalNum()));
            jsonWriter.name("owner_buy_count");
            this.ownerBuyCountAdapter.write(jsonWriter, Integer.valueOf(product.getOwnerBuyCount()));
            jsonWriter.name("secondHandSthType");
            this.secondHandSthTypeAdapter.write(jsonWriter, product.getSecondHandSthType());
            jsonWriter.name("get_coupon_title");
            this.couponTitleAdapter.write(jsonWriter, product.getCouponTitle());
            jsonWriter.name("coupon_list");
            this.couponListAdapter.write(jsonWriter, product.getCouponList());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, product.getType());
            jsonWriter.name("top_ids");
            this.topIdsAdapter.write(jsonWriter, product.getTopIds());
            jsonWriter.name("recent_follow_list");
            this.recentFollowListAdapter.write(jsonWriter, product.getRecentFollowList());
            jsonWriter.name("hot_num");
            this.hotNumAdapter.write(jsonWriter, Integer.valueOf(product.getHotNum()));
            jsonWriter.name("hot_num_txt");
            this.hotNumTextAdapter.write(jsonWriter, product.getHotNumText());
            jsonWriter.name("bgColor");
            this.bgColorAdapter.write(jsonWriter, product.getBgColor());
            jsonWriter.name("allow_rating");
            this.allowRatingAdapter.write(jsonWriter, Integer.valueOf(product.getAllowRating()));
            jsonWriter.name("wish_count");
            this.wishCountAdapter.write(jsonWriter, Integer.valueOf(product.getWishCount()));
            jsonWriter.name("buy_count");
            this.buyCountAdapter.write(jsonWriter, Integer.valueOf(product.getBuyCount()));
            jsonWriter.name("category_id");
            this.categoryIdAdapter.write(jsonWriter, Integer.valueOf(product.getCategoryId()));
            jsonWriter.name("is_owner");
            this.isOwnerAdapter.write(jsonWriter, Integer.valueOf(product.getIsOwner()));
            jsonWriter.name("recommendRows");
            this.recommendRowsAdapter.write(jsonWriter, product.getRecommendRows());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Product read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultTitle;
            String str5 = this.defaultUrl;
            String str6 = this.defaultDescription;
            String str7 = this.defaultPic;
            String str8 = this.defaultLogo;
            String str9 = this.defaultSubTitle;
            String str10 = this.defaultId;
            String str11 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str12 = this.defaultBrandId;
            String str13 = this.defaultSeriesId;
            List<String> list = this.defaultCoverPicList;
            int i = this.defaultConfigNum;
            float f = this.defaultPriceMin;
            float f2 = this.defaultPriceMax;
            String str14 = this.defaultPriceCurrency;
            int i2 = this.defaultFollowNum;
            float f3 = this.defaultRatingAverageScore;
            float f4 = this.defaultRatingAverageScore1;
            float f5 = this.defaultRatingAverageScore2;
            float f6 = this.defaultRatingAverageScore3;
            float f7 = this.defaultRatingAverageScore4;
            float f8 = this.defaultRatingAverageScore5;
            float f9 = this.defaultRatingAverageScore6;
            float f10 = this.defaultRatingAverageScore7;
            float f11 = this.defaultRatingAverageScore8;
            float f12 = this.defaultRatingAverageScore9;
            float f13 = this.defaultRatingAverageScore10;
            int i3 = this.defaultRatingTotalNum;
            int i4 = this.defaultVoteDigNum;
            int i5 = this.defaultVoteBuryNum;
            List<String> list2 = this.defaultTagArr;
            int i6 = this.defaultFeedCommentNum;
            int i7 = this.defaultFeedAnswerNum;
            int i8 = this.defaultFeedArticleNum;
            int i9 = this.defaultFeedVideoNum;
            int i10 = this.defaultRecommendImageNum;
            int i11 = this.defaultRecommendVideoNum;
            String str15 = this.defaultReleaseTime;
            int i12 = this.defaultShareNum;
            String str16 = this.defaultShareUrl;
            int i13 = this.defaultBlockStatus;
            int i14 = this.defaultReleaseStatus;
            int i15 = this.defaultStatus;
            String str17 = this.defaultCreateUid;
            String str18 = this.defaultCreateTime;
            String str19 = this.defaultUpdateTime;
            String str20 = this.defaultUpdateUid;
            List<ProductConfig> list3 = this.defaultConfigRows;
            UserAction userAction = this.defaultUserAction;
            List<ConfigPage> list4 = this.defaultTabApiList;
            String str21 = this.defaultSelectedTab;
            float f14 = this.defaultVoteDigPercentage;
            String str22 = this.defaultSecondHandFeedNum;
            float f15 = this.defaultStarAverageScore;
            int i16 = this.defaultStarTotalCount;
            int i17 = this.defaultStar1Count;
            int i18 = this.defaultStar2Count;
            int i19 = this.defaultStar3Count;
            int i20 = this.defaultStar4Count;
            int i21 = this.defaultStar5Count;
            int i22 = this.defaultOwnerStar1Count;
            int i23 = this.defaultOwnerStar2Count;
            int i24 = this.defaultOwnerStar3Count;
            int i25 = this.defaultOwnerStar4Count;
            int i26 = this.defaultOwnerStar5Count;
            float f16 = this.defaultOwnerStarAverageScore;
            int i27 = this.defaultOwnerStarTotalCount;
            int i28 = this.defaultOwnerRatingTotalNum;
            int i29 = this.defaultOwnerBuyCount;
            String str23 = this.defaultSecondHandSthType;
            String str24 = this.defaultCouponTitle;
            List<ProductCoupon> list5 = this.defaultCouponList;
            String str25 = this.defaultType;
            List<String> list6 = this.defaultTopIds;
            List<RelatedData> list7 = this.defaultRecentFollowList;
            int i30 = this.defaultHotNum;
            String str26 = this.defaultHotNumText;
            String str27 = this.defaultBgColor;
            int i31 = this.defaultAllowRating;
            int i32 = this.defaultWishCount;
            int i33 = this.defaultBuyCount;
            int i34 = this.defaultCategoryId;
            int i35 = this.defaultIsOwner;
            List<NewHeadLine> list8 = this.defaultRecommendRows;
            String str28 = str2;
            String str29 = str3;
            Integer num2 = num;
            String str30 = str4;
            String str31 = str5;
            String str32 = str6;
            String str33 = str7;
            String str34 = str8;
            String str35 = str9;
            String str36 = str10;
            String str37 = str11;
            Long l3 = l;
            Long l4 = l2;
            String str38 = str;
            String str39 = str12;
            String str40 = str13;
            List<String> list9 = list;
            int i36 = i;
            float f17 = f;
            float f18 = f2;
            String str41 = str14;
            int i37 = i2;
            float f19 = f3;
            float f20 = f4;
            float f21 = f5;
            float f22 = f6;
            float f23 = f7;
            float f24 = f8;
            float f25 = f9;
            float f26 = f10;
            float f27 = f11;
            float f28 = f12;
            float f29 = f13;
            int i38 = i3;
            int i39 = i4;
            int i40 = i5;
            List<String> list10 = list2;
            int i41 = i6;
            int i42 = i7;
            int i43 = i8;
            int i44 = i9;
            int i45 = i10;
            int i46 = i11;
            String str42 = str15;
            int i47 = i12;
            String str43 = str16;
            int i48 = i13;
            int i49 = i14;
            int i50 = i15;
            String str44 = str17;
            String str45 = str18;
            String str46 = str19;
            String str47 = str20;
            List<ProductConfig> list11 = list3;
            UserAction userAction2 = userAction;
            List<ConfigPage> list12 = list4;
            String str48 = str21;
            float f30 = f14;
            String str49 = str22;
            float f31 = f15;
            int i51 = i16;
            int i52 = i17;
            int i53 = i18;
            int i54 = i19;
            int i55 = i20;
            int i56 = i21;
            int i57 = i22;
            int i58 = i23;
            int i59 = i24;
            int i60 = i25;
            int i61 = i26;
            float f32 = f16;
            int i62 = i27;
            int i63 = i28;
            int i64 = i29;
            String str50 = str23;
            String str51 = str24;
            List<ProductCoupon> list13 = list5;
            String str52 = str25;
            List<String> list14 = list6;
            List<RelatedData> list15 = list7;
            int i65 = i30;
            String str53 = str26;
            String str54 = str27;
            int i66 = i31;
            int i67 = i32;
            int i68 = i33;
            int i69 = i34;
            int i70 = i35;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2125416082:
                            if (nextName.equals("price_max")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2125415844:
                            if (nextName.equals("price_min")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -2026711560:
                            if (nextName.equals("follow_num")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1965371387:
                            if (nextName.equals("release_time")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1963057336:
                            if (nextName.equals("get_coupon_title")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1786532129:
                            if (nextName.equals("recommend_image_num")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1712093721:
                            if (nextName.equals("star_total_count")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1581702362:
                            if (nextName.equals("share_num")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1553853997:
                            if (nextName.equals("tabList")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -1481921949:
                            if (nextName.equals("owner_star_4_count")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1430703208:
                            if (nextName.equals("star_5_count")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1391196091:
                            if (nextName.equals("hot_num_txt")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1184609291:
                            if (nextName.equals("owner_rating_total_num")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1142011723:
                            if (nextName.equals("recommendRows")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -1139551026:
                            if (nextName.equals("top_ids")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -962300077:
                            if (nextName.equals("allow_rating")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -881269657:
                            if (nextName.equals("tagArr")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -685750636:
                            if (nextName.equals("star_1_count")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -594418268:
                            if (nextName.equals("owner_star_5_count")) {
                                c = 26;
                                break;
                            }
                            break;
                        case -573446013:
                            if (nextName.equals("update_time")) {
                                c = 27;
                                break;
                            }
                            break;
                        case -569586717:
                            if (nextName.equals("series_id")) {
                                c = 28;
                                break;
                            }
                            break;
                        case -550095530:
                            if (nextName.equals("vote_bury_num")) {
                                c = 29;
                                break;
                            }
                            break;
                        case -493574096:
                            if (nextName.equals("create_time")) {
                                c = 30;
                                break;
                            }
                            break;
                        case -465389787:
                            if (nextName.equals("feed_tuwen_num")) {
                                c = 31;
                                break;
                            }
                            break;
                        case -458115562:
                            if (nextName.equals("buy_count")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case -351797462:
                            if (nextName.equals("coverArr")) {
                                c = '!';
                                break;
                            }
                            break;
                        case -322153997:
                            if (nextName.equals("owner_star_total_count")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case -295591974:
                            if (nextName.equals("update_uid")) {
                                c = '#';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '$';
                                break;
                            }
                            break;
                        case -206485371:
                            if (nextName.equals("feed_comment_num")) {
                                c = '%';
                                break;
                            }
                            break;
                        case -204859874:
                            if (nextName.equals("bgColor")) {
                                c = '&';
                                break;
                            }
                            break;
                        case -25385773:
                            if (nextName.equals("brand_id")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 121133918:
                            if (nextName.equals("is_owner")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 150534304:
                            if (nextName.equals("owner_star_1_count")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 201753045:
                            if (nextName.equals("star_2_count")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 220498682:
                            if (nextName.equals("selectedTab")) {
                                c = '1';
                                break;
                            }
                            break;
                        case 328037758:
                            if (nextName.equals("secondHandSthType")) {
                                c = '2';
                                break;
                            }
                            break;
                        case 337421006:
                            if (nextName.equals("rating_average_score")) {
                                c = '3';
                                break;
                            }
                            break;
                        case 424577535:
                            if (nextName.equals("recommend_video_num")) {
                                c = '4';
                                break;
                            }
                            break;
                        case 454168527:
                            if (nextName.equals("owner_star_average_score")) {
                                c = '5';
                                break;
                            }
                            break;
                        case 456922819:
                            if (nextName.equals("star_average_score")) {
                                c = '6';
                                break;
                            }
                            break;
                        case 478275692:
                            if (nextName.equals("vote_dig_percentage")) {
                                c = '7';
                                break;
                            }
                            break;
                        case 765987703:
                            if (nextName.equals("wish_count")) {
                                c = '8';
                                break;
                            }
                            break;
                        case 831457339:
                            if (nextName.equals("configRows")) {
                                c = '9';
                                break;
                            }
                            break;
                        case 831843593:
                            if (nextName.equals("config_num")) {
                                c = ':';
                                break;
                            }
                            break;
                        case 987151860:
                            if (nextName.equals("vote_dig_num")) {
                                c = ';';
                                break;
                            }
                            break;
                        case 1038037985:
                            if (nextName.equals("owner_star_2_count")) {
                                c = '<';
                                break;
                            }
                            break;
                        case 1044897578:
                            if (nextName.equals("release_status")) {
                                c = '=';
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = '>';
                                break;
                            }
                            break;
                        case 1089256726:
                            if (nextName.equals("star_3_count")) {
                                c = '?';
                                break;
                            }
                            break;
                        case 1094003809:
                            if (nextName.equals("feed_video_num")) {
                                c = '@';
                                break;
                            }
                            break;
                        case 1099006100:
                            if (nextName.equals("hot_num")) {
                                c = 'A';
                                break;
                            }
                            break;
                        case 1197918978:
                            if (nextName.equals("sell_url")) {
                                c = 'B';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 'C';
                                break;
                            }
                            break;
                        case 1280954951:
                            if (nextName.equals("price_currency")) {
                                c = 'D';
                                break;
                            }
                            break;
                        case 1369552525:
                            if (nextName.equals("create_uid")) {
                                c = 'E';
                                break;
                            }
                            break;
                        case 1399398282:
                            if (nextName.equals("owner_buy_count")) {
                                c = 'F';
                                break;
                            }
                            break;
                        case 1537780732:
                            if (nextName.equals("category_id")) {
                                c = 'G';
                                break;
                            }
                            break;
                        case 1706281096:
                            if (nextName.equals("recent_follow_list")) {
                                c = 'H';
                                break;
                            }
                            break;
                        case 1720418281:
                            if (nextName.equals("rating_total_num")) {
                                c = 'I';
                                break;
                            }
                            break;
                        case 1728690455:
                            if (nextName.equals("coupon_list")) {
                                c = 'J';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 'K';
                                break;
                            }
                            break;
                        case 1885809968:
                            if (nextName.equals("rating_average_score_10")) {
                                c = 'L';
                                break;
                            }
                            break;
                        case 1925541666:
                            if (nextName.equals("owner_star_3_count")) {
                                c = 'M';
                                break;
                            }
                            break;
                        case 1936400270:
                            if (nextName.equals("sale_num")) {
                                c = 'N';
                                break;
                            }
                            break;
                        case 1976760407:
                            if (nextName.equals("star_4_count")) {
                                c = 'O';
                                break;
                            }
                            break;
                        case 2132176070:
                            if (nextName.equals("feed_answer_num")) {
                                c = 'P';
                                break;
                            }
                            break;
                        case 2139042560:
                            if (nextName.equals("rating_average_score_1")) {
                                c = 'Q';
                                break;
                            }
                            break;
                        case 2139042561:
                            if (nextName.equals("rating_average_score_2")) {
                                c = 'R';
                                break;
                            }
                            break;
                        case 2139042562:
                            if (nextName.equals("rating_average_score_3")) {
                                c = 'S';
                                break;
                            }
                            break;
                        case 2139042563:
                            if (nextName.equals("rating_average_score_4")) {
                                c = 'T';
                                break;
                            }
                            break;
                        case 2139042564:
                            if (nextName.equals("rating_average_score_5")) {
                                c = 'U';
                                break;
                            }
                            break;
                        case 2139042565:
                            if (nextName.equals("rating_average_score_6")) {
                                c = 'V';
                                break;
                            }
                            break;
                        case 2139042566:
                            if (nextName.equals("rating_average_score_7")) {
                                c = 'W';
                                break;
                            }
                            break;
                        case 2139042567:
                            if (nextName.equals("rating_average_score_8")) {
                                c = 'X';
                                break;
                            }
                            break;
                        case 2139042568:
                            if (nextName.equals("rating_average_score_9")) {
                                c = 'Y';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            f18 = this.priceMaxAdapter.read(jsonReader).floatValue();
                            continue;
                        case 1:
                            f17 = this.priceMinAdapter.read(jsonReader).floatValue();
                            continue;
                        case 2:
                            str29 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str35 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i37 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str42 = this.releaseTimeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str51 = this.couponTitleAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i45 = this.recommendImageNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            str32 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            i51 = this.starTotalCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            i47 = this.shareNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str28 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            list12 = this.tabApiListAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            i60 = this.ownerStar4CountAdapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            i56 = this.star5CountAdapter.read(jsonReader).intValue();
                            continue;
                        case 15:
                            str53 = this.hotNumTextAdapter.read(jsonReader);
                            continue;
                        case 16:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 17:
                            i63 = this.ownerRatingTotalNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            list8 = this.recommendRowsAdapter.read(jsonReader);
                            continue;
                        case 19:
                            list14 = this.topIdsAdapter.read(jsonReader);
                            continue;
                        case 20:
                            i66 = this.allowRatingAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            str38 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i50 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            list10 = this.tagArrAdapter.read(jsonReader);
                            continue;
                        case 24:
                            i52 = this.star1CountAdapter.read(jsonReader).intValue();
                            continue;
                        case 25:
                            i48 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 26:
                            i61 = this.ownerStar5CountAdapter.read(jsonReader).intValue();
                            continue;
                        case 27:
                            str46 = this.updateTimeAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str40 = this.seriesIdAdapter.read(jsonReader);
                            continue;
                        case 29:
                            i40 = this.voteBuryNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 30:
                            str45 = this.createTimeAdapter.read(jsonReader);
                            continue;
                        case 31:
                            i43 = this.feedArticleNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ' ':
                            i68 = this.buyCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '!':
                            list9 = this.coverPicListAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            i62 = this.ownerStarTotalCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '#':
                            str47 = this.updateUidAdapter.read(jsonReader);
                            continue;
                        case '$':
                            str37 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '%':
                            i41 = this.feedCommentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '&':
                            str54 = this.bgColorAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str39 = this.brandIdAdapter.read(jsonReader);
                            continue;
                        case '(':
                            str36 = this.idAdapter.read(jsonReader);
                            continue;
                        case ')':
                            str33 = this.picAdapter.read(jsonReader);
                            continue;
                        case '*':
                            str31 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '+':
                            str34 = this.logoAdapter.read(jsonReader);
                            continue;
                        case ',':
                            str52 = this.typeAdapter.read(jsonReader);
                            continue;
                        case '-':
                            str30 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '.':
                            i70 = this.isOwnerAdapter.read(jsonReader).intValue();
                            continue;
                        case '/':
                            i57 = this.ownerStar1CountAdapter.read(jsonReader).intValue();
                            continue;
                        case '0':
                            i53 = this.star2CountAdapter.read(jsonReader).intValue();
                            continue;
                        case '1':
                            str48 = this.selectedTabAdapter.read(jsonReader);
                            continue;
                        case '2':
                            str50 = this.secondHandSthTypeAdapter.read(jsonReader);
                            continue;
                        case '3':
                            f19 = this.ratingAverageScoreAdapter.read(jsonReader).floatValue();
                            continue;
                        case '4':
                            i46 = this.recommendVideoNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '5':
                            f32 = this.ownerStarAverageScoreAdapter.read(jsonReader).floatValue();
                            continue;
                        case '6':
                            f31 = this.starAverageScoreAdapter.read(jsonReader).floatValue();
                            continue;
                        case '7':
                            f30 = this.voteDigPercentageAdapter.read(jsonReader).floatValue();
                            continue;
                        case '8':
                            i67 = this.wishCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '9':
                            list11 = this.configRowsAdapter.read(jsonReader);
                            continue;
                        case ':':
                            i36 = this.configNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ';':
                            i39 = this.voteDigNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '<':
                            i58 = this.ownerStar2CountAdapter.read(jsonReader).intValue();
                            continue;
                        case '=':
                            i49 = this.releaseStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '>':
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case '?':
                            i54 = this.star3CountAdapter.read(jsonReader).intValue();
                            continue;
                        case '@':
                            i44 = this.feedVideoNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'A':
                            i65 = this.hotNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'B':
                            str43 = this.shareUrlAdapter.read(jsonReader);
                            continue;
                        case 'C':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 'D':
                            str41 = this.priceCurrencyAdapter.read(jsonReader);
                            continue;
                        case 'E':
                            str44 = this.createUidAdapter.read(jsonReader);
                            continue;
                        case 'F':
                            i64 = this.ownerBuyCountAdapter.read(jsonReader).intValue();
                            continue;
                        case 'G':
                            i69 = this.categoryIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 'H':
                            list15 = this.recentFollowListAdapter.read(jsonReader);
                            continue;
                        case 'I':
                            i38 = this.ratingTotalNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'J':
                            list13 = this.couponListAdapter.read(jsonReader);
                            continue;
                        case 'K':
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 'L':
                            f29 = this.ratingAverageScore10Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'M':
                            i59 = this.ownerStar3CountAdapter.read(jsonReader).intValue();
                            continue;
                        case 'N':
                            str49 = this.secondHandFeedNumAdapter.read(jsonReader);
                            continue;
                        case 'O':
                            i55 = this.star4CountAdapter.read(jsonReader).intValue();
                            continue;
                        case 'P':
                            i42 = this.feedAnswerNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'Q':
                            f20 = this.ratingAverageScore1Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'R':
                            f21 = this.ratingAverageScore2Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'S':
                            f22 = this.ratingAverageScore3Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'T':
                            f23 = this.ratingAverageScore4Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'U':
                            f24 = this.ratingAverageScore5Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'V':
                            f25 = this.ratingAverageScore6Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'W':
                            f26 = this.ratingAverageScore7Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'X':
                            f27 = this.ratingAverageScore8Adapter.read(jsonReader).floatValue();
                            continue;
                        case 'Y':
                            f28 = this.ratingAverageScore9Adapter.read(jsonReader).floatValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Product(str38, str28, str29, num2, str30, str31, str32, str33, str34, str35, str36, str37, l3, l4, str39, str40, list9, i36, f17, f18, str41, i37, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, i38, i39, i40, list10, i41, i42, i43, i44, i45, i46, str42, i47, str43, i48, i49, i50, str44, str45, str46, str47, list11, userAction2, list12, str48, f30, str49, f31, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, f32, i62, i63, i64, str50, str51, list13, str52, list14, list15, i65, str53, str54, i66, i67, i68, i69, i70, list8);
        }
    }
}
