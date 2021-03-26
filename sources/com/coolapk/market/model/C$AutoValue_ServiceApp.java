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

/* renamed from: com.coolapk.market.model.$AutoValue_ServiceApp  reason: invalid class name */
abstract class C$AutoValue_ServiceApp extends C$$AutoValue_ServiceApp {
    C$AutoValue_ServiceApp(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, long j, long j2, String str16, String str17, int i2, int i3, String str18, String str19, String str20, String str21, String str22, String str23, float f, String str24, String str25, String str26, String str27, List<String> list, List<String> list2, String str28, String str29, String str30, String str31, int i4, String str32, int i5, List<Gift> list3, int i6, int i7, int i8, int i9, int i10, int i11, UserAction userAction, List<RelatedData> list4, List<RelatedData> list5, List<User> list6, List<RelatedData> list7, String str33, String str34, List<String> list8, String str35, String str36, List<String> list9, List<ServiceApp> list10, List<ServiceApp> list11, List<Album> list12, String str37, int i12, User user, String str38, String str39, String str40, int i13, List<MenuCard> list13, String str41, int i14, int i15, int i16, Collection collection, CollectionItem collectionItem, boolean z, String str42, String str43, List<CouponInfo> list14, List<ConfigPage> list15, String str44, int i17, String str45, String str46, List<NewHeadLine> list16, List<String> list17, String str47) {
        super(str, str2, num, str3, str4, str5, str6, str7, str8, l, l2, str9, str10, str11, str12, str13, str14, i, str15, j, j2, str16, str17, i2, i3, str18, str19, str20, str21, str22, str23, f, str24, str25, str26, str27, list, list2, str28, str29, str30, str31, i4, str32, i5, list3, i6, i7, i8, i9, i10, i11, userAction, list4, list5, list6, list7, str33, str34, list8, str35, str36, list9, list10, list11, list12, str37, i12, user, str38, str39, str40, i13, list13, str41, i14, i15, i16, collection, collectionItem, z, str42, str43, list14, list15, str44, i17, str45, str46, list16, list17, str47);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ServiceApp$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ServiceApp> {
        private final TypeAdapter<List<Album>> albumRowsAdapter;
        private final TypeAdapter<Long> apkLengthAdapter;
        private final TypeAdapter<String> apkRomVersionAdapter;
        private final TypeAdapter<String> apkSizeAdapter;
        private final TypeAdapter<String> apkSubTitleAdapter;
        private final TypeAdapter<String> apkTypeAdapter;
        private final TypeAdapter<String> apkUrlAdapter;
        private final TypeAdapter<String> appNameAdapter;
        private final TypeAdapter<String> bgColorAdapter;
        private final TypeAdapter<String> categoryIdAdapter;
        private final TypeAdapter<String> categoryNameAdapter;
        private final TypeAdapter<String> changeHistoryAdapter;
        private final TypeAdapter<String> changeLogAdapter;
        private final TypeAdapter<Collection> collectionInfoAdapter;
        private final TypeAdapter<CollectionItem> collectionItemAdapter;
        private final TypeAdapter<Integer> commentBlockNumAdapter;
        private final TypeAdapter<String> commentCountAdapter;
        private final TypeAdapter<Integer> commentStatusAdapter;
        private final TypeAdapter<List<CouponInfo>> couponInfoAdapter;
        private final TypeAdapter<String> coverAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private List<Album> defaultAlbumRows = null;
        private long defaultApkLength = 0;
        private String defaultApkRomVersion = null;
        private String defaultApkSize = null;
        private String defaultApkSubTitle = null;
        private String defaultApkType = null;
        private String defaultApkUrl = null;
        private String defaultAppName = null;
        private String defaultBgColor = null;
        private String defaultCategoryId = null;
        private String defaultCategoryName = null;
        private String defaultChangeHistory = null;
        private String defaultChangeLog = null;
        private Collection defaultCollectionInfo = null;
        private CollectionItem defaultCollectionItem = null;
        private int defaultCommentBlockNum = 0;
        private String defaultCommentCount = null;
        private int defaultCommentStatus = 0;
        private List<CouponInfo> defaultCouponInfo = null;
        private String defaultCover = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private String defaultDeveloperName = null;
        private User defaultDeveloperProfile = null;
        private List<ServiceApp> defaultDeveloperRows = null;
        private int defaultDigest = 0;
        private List<RelatedData> defaultDiscoveryRows = null;
        private String defaultDisplayVersionName = null;
        private String defaultDownCount = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtendFile = null;
        private String defaultExtendName = null;
        private String defaultExtraAnalysisData = null;
        private String defaultExtraData = null;
        private String defaultExtraFlag = null;
        private String defaultExtraFromApi = null;
        private String defaultFollowCount = null;
        private List<RelatedData> defaultFollowerRows = null;
        private int defaultGiftCount = 0;
        private List<Gift> defaultGiftRows = null;
        private boolean defaultHasCoupon = false;
        private int defaultHotNum = 0;
        private String defaultId = null;
        private String defaultIntroduce = null;
        private int defaultIsDownloadApp = 0;
        private int defaultIsForumApp = 0;
        private String defaultKeywords = null;
        private String defaultLanguage = null;
        private Long defaultLastUpdate = null;
        private String defaultLoginUserRate = null;
        private String defaultLogo = null;
        private List<MenuCard> defaultMenuCards = null;
        private String defaultOpenLink = null;
        private String defaultPackageName = null;
        private List<String> defaultPermissions = null;
        private String defaultPic = null;
        private long defaultPublicUpdate = 0;
        private List<RelatedData> defaultRatingRows = null;
        private float defaultRatingStar = 0.0f;
        private List<User> defaultRecentFollowList = null;
        private int defaultRecommend = 0;
        private List<NewHeadLine> defaultRecommendRows = Collections.emptyList();
        private List<ServiceApp> defaultRelatedRows = null;
        private String defaultRemark = null;
        private String defaultRequestContext = null;
        private String defaultReviewer = null;
        private String defaultScore = null;
        private List<String> defaultScreenList = null;
        private String defaultSelectedTab = null;
        private String defaultSubTitle = null;
        private int defaultSupportAndroidVersion = 0;
        private List<ConfigPage> defaultTabApiList = null;
        private List<String> defaultTagList = null;
        private String defaultTargetId = null;
        private List<String> defaultThumbList = null;
        private String defaultTitle = null;
        private List<String> defaultTopIds = Collections.emptyList();
        private int defaultUpDown = 0;
        private String defaultUpdateFlag = null;
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
        private int defaultVersionCode = 0;
        private String defaultVersionName = null;
        private int defaultVotenum = 0;
        private int defaultVotenum1 = 0;
        private int defaultVotenum2 = 0;
        private int defaultVotenum3 = 0;
        private int defaultVotenum4 = 0;
        private int defaultVotenum5 = 0;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> developerNameAdapter;
        private final TypeAdapter<User> developerProfileAdapter;
        private final TypeAdapter<List<ServiceApp>> developerRowsAdapter;
        private final TypeAdapter<Integer> digestAdapter;
        private final TypeAdapter<List<RelatedData>> discoveryRowsAdapter;
        private final TypeAdapter<String> displayVersionNameAdapter;
        private final TypeAdapter<String> downCountAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extendFileAdapter;
        private final TypeAdapter<String> extendNameAdapter;
        private final TypeAdapter<String> extraAnalysisDataAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> extraFlagAdapter;
        private final TypeAdapter<String> extraFromApiAdapter;
        private final TypeAdapter<String> followCountAdapter;
        private final TypeAdapter<List<RelatedData>> followerRowsAdapter;
        private final TypeAdapter<Integer> giftCountAdapter;
        private final TypeAdapter<List<Gift>> giftRowsAdapter;
        private final TypeAdapter<Boolean> hasCouponAdapter;
        private final TypeAdapter<Integer> hotNumAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> introduceAdapter;
        private final TypeAdapter<Integer> isDownloadAppAdapter;
        private final TypeAdapter<Integer> isForumAppAdapter;
        private final TypeAdapter<String> keywordsAdapter;
        private final TypeAdapter<String> languageAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> loginUserRateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<List<MenuCard>> menuCardsAdapter;
        private final TypeAdapter<String> openLinkAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<List<String>> permissionsAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Long> publicUpdateAdapter;
        private final TypeAdapter<List<RelatedData>> ratingRowsAdapter;
        private final TypeAdapter<Float> ratingStarAdapter;
        private final TypeAdapter<List<User>> recentFollowListAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
        private final TypeAdapter<List<NewHeadLine>> recommendRowsAdapter;
        private final TypeAdapter<List<ServiceApp>> relatedRowsAdapter;
        private final TypeAdapter<String> remarkAdapter;
        private final TypeAdapter<String> requestContextAdapter;
        private final TypeAdapter<String> reviewerAdapter;
        private final TypeAdapter<String> scoreAdapter;
        private final TypeAdapter<List<String>> screenListAdapter;
        private final TypeAdapter<String> selectedTabAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<Integer> supportAndroidVersionAdapter;
        private final TypeAdapter<List<ConfigPage>> tabApiListAdapter;
        private final TypeAdapter<List<String>> tagListAdapter;
        private final TypeAdapter<String> targetIdAdapter;
        private final TypeAdapter<List<String>> thumbListAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<List<String>> topIdsAdapter;
        private final TypeAdapter<Integer> upDownAdapter;
        private final TypeAdapter<String> updateFlagAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<Integer> versionCodeAdapter;
        private final TypeAdapter<String> versionNameAdapter;
        private final TypeAdapter<Integer> votenum1Adapter;
        private final TypeAdapter<Integer> votenum2Adapter;
        private final TypeAdapter<Integer> votenum3Adapter;
        private final TypeAdapter<Integer> votenum4Adapter;
        private final TypeAdapter<Integer> votenum5Adapter;
        private final TypeAdapter<Integer> votenumAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.targetIdAdapter = gson.getAdapter(String.class);
            this.apkTypeAdapter = gson.getAdapter(String.class);
            this.displayVersionNameAdapter = gson.getAdapter(String.class);
            this.versionNameAdapter = gson.getAdapter(String.class);
            this.versionCodeAdapter = gson.getAdapter(Integer.class);
            this.apkSizeAdapter = gson.getAdapter(String.class);
            this.publicUpdateAdapter = gson.getAdapter(Long.class);
            this.apkLengthAdapter = gson.getAdapter(Long.class);
            this.extraFlagAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.digestAdapter = gson.getAdapter(Integer.class);
            this.changeLogAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.coverAdapter = gson.getAdapter(String.class);
            this.followCountAdapter = gson.getAdapter(String.class);
            this.commentCountAdapter = gson.getAdapter(String.class);
            this.downCountAdapter = gson.getAdapter(String.class);
            this.ratingStarAdapter = gson.getAdapter(Float.class);
            this.scoreAdapter = gson.getAdapter(String.class);
            this.updateFlagAdapter = gson.getAdapter(String.class);
            this.appNameAdapter = gson.getAdapter(String.class);
            this.apkRomVersionAdapter = gson.getAdapter(String.class);
            this.thumbListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.screenListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.introduceAdapter = gson.getAdapter(String.class);
            this.loginUserRateAdapter = gson.getAdapter(String.class);
            this.remarkAdapter = gson.getAdapter(String.class);
            this.reviewerAdapter = gson.getAdapter(String.class);
            this.supportAndroidVersionAdapter = gson.getAdapter(Integer.class);
            this.languageAdapter = gson.getAdapter(String.class);
            this.giftCountAdapter = gson.getAdapter(Integer.class);
            this.giftRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Gift.class));
            this.votenumAdapter = gson.getAdapter(Integer.class);
            this.votenum1Adapter = gson.getAdapter(Integer.class);
            this.votenum2Adapter = gson.getAdapter(Integer.class);
            this.votenum3Adapter = gson.getAdapter(Integer.class);
            this.votenum4Adapter = gson.getAdapter(Integer.class);
            this.votenum5Adapter = gson.getAdapter(Integer.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.discoveryRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.followerRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.recentFollowListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, User.class));
            this.ratingRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
            this.categoryIdAdapter = gson.getAdapter(String.class);
            this.categoryNameAdapter = gson.getAdapter(String.class);
            this.tagListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.apkUrlAdapter = gson.getAdapter(String.class);
            this.developerNameAdapter = gson.getAdapter(String.class);
            this.permissionsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.developerRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ServiceApp.class));
            this.relatedRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ServiceApp.class));
            this.albumRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Album.class));
            this.keywordsAdapter = gson.getAdapter(String.class);
            this.upDownAdapter = gson.getAdapter(Integer.class);
            this.developerProfileAdapter = gson.getAdapter(User.class);
            this.extendFileAdapter = gson.getAdapter(String.class);
            this.extendNameAdapter = gson.getAdapter(String.class);
            this.changeHistoryAdapter = gson.getAdapter(String.class);
            this.commentBlockNumAdapter = gson.getAdapter(Integer.class);
            this.menuCardsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, MenuCard.class));
            this.extraAnalysisDataAdapter = gson.getAdapter(String.class);
            this.isDownloadAppAdapter = gson.getAdapter(Integer.class);
            this.isForumAppAdapter = gson.getAdapter(Integer.class);
            this.commentStatusAdapter = gson.getAdapter(Integer.class);
            this.collectionInfoAdapter = gson.getAdapter(Collection.class);
            this.collectionItemAdapter = gson.getAdapter(CollectionItem.class);
            this.hasCouponAdapter = gson.getAdapter(Boolean.class);
            this.extraFromApiAdapter = gson.getAdapter(String.class);
            this.apkSubTitleAdapter = gson.getAdapter(String.class);
            this.couponInfoAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, CouponInfo.class));
            this.tabApiListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ConfigPage.class));
            this.selectedTabAdapter = gson.getAdapter(String.class);
            this.hotNumAdapter = gson.getAdapter(Integer.class);
            this.bgColorAdapter = gson.getAdapter(String.class);
            this.requestContextAdapter = gson.getAdapter(String.class);
            this.recommendRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, NewHeadLine.class));
            this.topIdsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.openLinkAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
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

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetId(String str) {
            this.defaultTargetId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkType(String str) {
            this.defaultApkType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayVersionName(String str) {
            this.defaultDisplayVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionName(String str) {
            this.defaultVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionCode(int i) {
            this.defaultVersionCode = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkSize(String str) {
            this.defaultApkSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPublicUpdate(long j) {
            this.defaultPublicUpdate = j;
            return this;
        }

        public GsonTypeAdapter setDefaultApkLength(long j) {
            this.defaultApkLength = j;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraFlag(String str) {
            this.defaultExtraFlag = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDigest(int i) {
            this.defaultDigest = i;
            return this;
        }

        public GsonTypeAdapter setDefaultChangeLog(String str) {
            this.defaultChangeLog = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCover(String str) {
            this.defaultCover = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowCount(String str) {
            this.defaultFollowCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentCount(String str) {
            this.defaultCommentCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDownCount(String str) {
            this.defaultDownCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingStar(float f) {
            this.defaultRatingStar = f;
            return this;
        }

        public GsonTypeAdapter setDefaultScore(String str) {
            this.defaultScore = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateFlag(String str) {
            this.defaultUpdateFlag = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAppName(String str) {
            this.defaultAppName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkRomVersion(String str) {
            this.defaultApkRomVersion = str;
            return this;
        }

        public GsonTypeAdapter setDefaultThumbList(List<String> list) {
            this.defaultThumbList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultScreenList(List<String> list) {
            this.defaultScreenList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultIntroduce(String str) {
            this.defaultIntroduce = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLoginUserRate(String str) {
            this.defaultLoginUserRate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRemark(String str) {
            this.defaultRemark = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReviewer(String str) {
            this.defaultReviewer = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSupportAndroidVersion(int i) {
            this.defaultSupportAndroidVersion = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLanguage(String str) {
            this.defaultLanguage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftCount(int i) {
            this.defaultGiftCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftRows(List<Gift> list) {
            this.defaultGiftRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultVotenum(int i) {
            this.defaultVotenum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVotenum1(int i) {
            this.defaultVotenum1 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVotenum2(int i) {
            this.defaultVotenum2 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVotenum3(int i) {
            this.defaultVotenum3 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVotenum4(int i) {
            this.defaultVotenum4 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVotenum5(int i) {
            this.defaultVotenum5 = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultDiscoveryRows(List<RelatedData> list) {
            this.defaultDiscoveryRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowerRows(List<RelatedData> list) {
            this.defaultFollowerRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultRecentFollowList(List<User> list) {
            this.defaultRecentFollowList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingRows(List<RelatedData> list) {
            this.defaultRatingRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryId(String str) {
            this.defaultCategoryId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryName(String str) {
            this.defaultCategoryName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTagList(List<String> list) {
            this.defaultTagList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultApkUrl(String str) {
            this.defaultApkUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDeveloperName(String str) {
            this.defaultDeveloperName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPermissions(List<String> list) {
            this.defaultPermissions = list;
            return this;
        }

        public GsonTypeAdapter setDefaultDeveloperRows(List<ServiceApp> list) {
            this.defaultDeveloperRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultRelatedRows(List<ServiceApp> list) {
            this.defaultRelatedRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultAlbumRows(List<Album> list) {
            this.defaultAlbumRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultKeywords(String str) {
            this.defaultKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUpDown(int i) {
            this.defaultUpDown = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDeveloperProfile(User user) {
            this.defaultDeveloperProfile = user;
            return this;
        }

        public GsonTypeAdapter setDefaultExtendFile(String str) {
            this.defaultExtendFile = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtendName(String str) {
            this.defaultExtendName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultChangeHistory(String str) {
            this.defaultChangeHistory = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentBlockNum(int i) {
            this.defaultCommentBlockNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMenuCards(List<MenuCard> list) {
            this.defaultMenuCards = list;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraAnalysisData(String str) {
            this.defaultExtraAnalysisData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsDownloadApp(int i) {
            this.defaultIsDownloadApp = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsForumApp(int i) {
            this.defaultIsForumApp = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentStatus(int i) {
            this.defaultCommentStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCollectionInfo(Collection collection) {
            this.defaultCollectionInfo = collection;
            return this;
        }

        public GsonTypeAdapter setDefaultCollectionItem(CollectionItem collectionItem) {
            this.defaultCollectionItem = collectionItem;
            return this;
        }

        public GsonTypeAdapter setDefaultHasCoupon(boolean z) {
            this.defaultHasCoupon = z;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraFromApi(String str) {
            this.defaultExtraFromApi = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkSubTitle(String str) {
            this.defaultApkSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCouponInfo(List<CouponInfo> list) {
            this.defaultCouponInfo = list;
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

        public GsonTypeAdapter setDefaultHotNum(int i) {
            this.defaultHotNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBgColor(String str) {
            this.defaultBgColor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRequestContext(String str) {
            this.defaultRequestContext = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendRows(List<NewHeadLine> list) {
            this.defaultRecommendRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultTopIds(List<String> list) {
            this.defaultTopIds = list;
            return this;
        }

        public GsonTypeAdapter setDefaultOpenLink(String str) {
            this.defaultOpenLink = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, ServiceApp serviceApp) throws IOException {
            if (serviceApp == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, serviceApp.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, serviceApp.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, serviceApp.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, serviceApp.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, serviceApp.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, serviceApp.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, serviceApp.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, serviceApp.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, serviceApp.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, serviceApp.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, serviceApp.getLastUpdate());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, serviceApp.getEntityTypeName());
            jsonWriter.name("packageName");
            this.packageNameAdapter.write(jsonWriter, serviceApp.getPackageName());
            jsonWriter.name("target_id");
            this.targetIdAdapter.write(jsonWriter, serviceApp.getTargetId());
            jsonWriter.name("apktype");
            this.apkTypeAdapter.write(jsonWriter, serviceApp.getApkType());
            jsonWriter.name("version");
            this.displayVersionNameAdapter.write(jsonWriter, serviceApp.getDisplayVersionName());
            jsonWriter.name("apkversionname");
            this.versionNameAdapter.write(jsonWriter, serviceApp.getVersionName());
            jsonWriter.name("apkversioncode");
            this.versionCodeAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getVersionCode()));
            jsonWriter.name("apksize");
            this.apkSizeAdapter.write(jsonWriter, serviceApp.getApkSize());
            jsonWriter.name("pubdate");
            this.publicUpdateAdapter.write(jsonWriter, Long.valueOf(serviceApp.getPublicUpdate()));
            jsonWriter.name("apklength");
            this.apkLengthAdapter.write(jsonWriter, Long.valueOf(serviceApp.getApkLength()));
            jsonWriter.name("extraFlag");
            this.extraFlagAdapter.write(jsonWriter, serviceApp.getExtraFlag());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, serviceApp.getDescription());
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getRecommend()));
            jsonWriter.name("digest");
            this.digestAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getDigest()));
            jsonWriter.name("changelog");
            this.changeLogAdapter.write(jsonWriter, serviceApp.getChangeLog());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, serviceApp.getLogo());
            jsonWriter.name("cover");
            this.coverAdapter.write(jsonWriter, serviceApp.getCover());
            jsonWriter.name("followCount");
            this.followCountAdapter.write(jsonWriter, serviceApp.getFollowCount());
            jsonWriter.name("commentCount");
            this.commentCountAdapter.write(jsonWriter, serviceApp.getCommentCount());
            jsonWriter.name("downCount");
            this.downCountAdapter.write(jsonWriter, serviceApp.getDownCount());
            jsonWriter.name("rating_star");
            this.ratingStarAdapter.write(jsonWriter, Float.valueOf(serviceApp.getRatingStar()));
            jsonWriter.name("score");
            this.scoreAdapter.write(jsonWriter, serviceApp.getScore());
            jsonWriter.name("updateFlag");
            this.updateFlagAdapter.write(jsonWriter, serviceApp.getUpdateFlag());
            jsonWriter.name("shorttitle");
            this.appNameAdapter.write(jsonWriter, serviceApp.getAppName());
            jsonWriter.name("apkRomVersion");
            this.apkRomVersionAdapter.write(jsonWriter, serviceApp.getApkRomVersion());
            jsonWriter.name("thumbList");
            this.thumbListAdapter.write(jsonWriter, serviceApp.getThumbList());
            jsonWriter.name("screenList");
            this.screenListAdapter.write(jsonWriter, serviceApp.getScreenList());
            jsonWriter.name("introduce");
            this.introduceAdapter.write(jsonWriter, serviceApp.getIntroduce());
            jsonWriter.name("star");
            this.loginUserRateAdapter.write(jsonWriter, serviceApp.getLoginUserRate());
            jsonWriter.name("remark");
            this.remarkAdapter.write(jsonWriter, serviceApp.getRemark());
            jsonWriter.name("reviewer");
            this.reviewerAdapter.write(jsonWriter, serviceApp.getReviewer());
            jsonWriter.name("sdkversion");
            this.supportAndroidVersionAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getSupportAndroidVersion()));
            jsonWriter.name("language");
            this.languageAdapter.write(jsonWriter, serviceApp.getLanguage());
            jsonWriter.name("giftCount");
            this.giftCountAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getGiftCount()));
            jsonWriter.name("giftRows");
            this.giftRowsAdapter.write(jsonWriter, serviceApp.getGiftRows());
            jsonWriter.name("votenum");
            this.votenumAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getVotenum()));
            jsonWriter.name("votenum1");
            this.votenum1Adapter.write(jsonWriter, Integer.valueOf(serviceApp.getVotenum1()));
            jsonWriter.name("votenum2");
            this.votenum2Adapter.write(jsonWriter, Integer.valueOf(serviceApp.getVotenum2()));
            jsonWriter.name("votenum3");
            this.votenum3Adapter.write(jsonWriter, Integer.valueOf(serviceApp.getVotenum3()));
            jsonWriter.name("votenum4");
            this.votenum4Adapter.write(jsonWriter, Integer.valueOf(serviceApp.getVotenum4()));
            jsonWriter.name("votenum5");
            this.votenum5Adapter.write(jsonWriter, Integer.valueOf(serviceApp.getVotenum5()));
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, serviceApp.getUserAction());
            jsonWriter.name("discoveryRows");
            this.discoveryRowsAdapter.write(jsonWriter, serviceApp.getDiscoveryRows());
            jsonWriter.name("followerRows");
            this.followerRowsAdapter.write(jsonWriter, serviceApp.getFollowerRows());
            jsonWriter.name("recent_follow_list");
            this.recentFollowListAdapter.write(jsonWriter, serviceApp.getRecentFollowList());
            jsonWriter.name("ratingRows");
            this.ratingRowsAdapter.write(jsonWriter, serviceApp.getRatingRows());
            jsonWriter.name("catid");
            this.categoryIdAdapter.write(jsonWriter, serviceApp.getCategoryId());
            jsonWriter.name("catName");
            this.categoryNameAdapter.write(jsonWriter, serviceApp.getCategoryName());
            jsonWriter.name("tagList");
            this.tagListAdapter.write(jsonWriter, serviceApp.getTagList());
            jsonWriter.name("apkUrl");
            this.apkUrlAdapter.write(jsonWriter, serviceApp.getApkUrl());
            jsonWriter.name("developername");
            this.developerNameAdapter.write(jsonWriter, serviceApp.getDeveloperName());
            jsonWriter.name("permissions");
            this.permissionsAdapter.write(jsonWriter, serviceApp.getPermissions());
            jsonWriter.name("developerRows");
            this.developerRowsAdapter.write(jsonWriter, serviceApp.getDeveloperRows());
            jsonWriter.name("relatedRows");
            this.relatedRowsAdapter.write(jsonWriter, serviceApp.getRelatedRows());
            jsonWriter.name("albumRows");
            this.albumRowsAdapter.write(jsonWriter, serviceApp.getAlbumRows());
            jsonWriter.name("keywords");
            this.keywordsAdapter.write(jsonWriter, serviceApp.getKeywords());
            jsonWriter.name("upDown");
            this.upDownAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getUpDown()));
            jsonWriter.name("developerProfile");
            this.developerProfileAdapter.write(jsonWriter, serviceApp.getDeveloperProfile());
            jsonWriter.name("extendfile");
            this.extendFileAdapter.write(jsonWriter, serviceApp.getExtendFile());
            jsonWriter.name("extendname");
            this.extendNameAdapter.write(jsonWriter, serviceApp.getExtendName());
            jsonWriter.name("changehistory");
            this.changeHistoryAdapter.write(jsonWriter, serviceApp.getChangeHistory());
            jsonWriter.name("comment_block_num");
            this.commentBlockNumAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getCommentBlockNum()));
            jsonWriter.name("extendedMenus");
            this.menuCardsAdapter.write(jsonWriter, serviceApp.getMenuCards());
            jsonWriter.name("extraAnalysisData");
            this.extraAnalysisDataAdapter.write(jsonWriter, serviceApp.getExtraAnalysisData());
            jsonWriter.name("is_download_app");
            this.isDownloadAppAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getIsDownloadApp()));
            jsonWriter.name("is_forum_app");
            this.isForumAppAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getIsForumApp()));
            jsonWriter.name("comment_status");
            this.commentStatusAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getCommentStatus()));
            jsonWriter.name("collection_info");
            this.collectionInfoAdapter.write(jsonWriter, serviceApp.getCollectionInfo());
            jsonWriter.name("collection_item_info");
            this.collectionItemAdapter.write(jsonWriter, serviceApp.getCollectionItem());
            jsonWriter.name("hasCoupon");
            this.hasCouponAdapter.write(jsonWriter, Boolean.valueOf(serviceApp.getHasCoupon()));
            jsonWriter.name("extra_fromApi");
            this.extraFromApiAdapter.write(jsonWriter, serviceApp.getExtraFromApi());
            jsonWriter.name("subtitle");
            this.apkSubTitleAdapter.write(jsonWriter, serviceApp.getApkSubTitle());
            jsonWriter.name("couponInfo");
            this.couponInfoAdapter.write(jsonWriter, serviceApp.getCouponInfo());
            jsonWriter.name("tabList");
            this.tabApiListAdapter.write(jsonWriter, serviceApp.getTabApiList());
            jsonWriter.name("selectedTab");
            this.selectedTabAdapter.write(jsonWriter, serviceApp.getSelectedTab());
            jsonWriter.name("hot_num");
            this.hotNumAdapter.write(jsonWriter, Integer.valueOf(serviceApp.getHotNum()));
            jsonWriter.name("bgColor");
            this.bgColorAdapter.write(jsonWriter, serviceApp.getBgColor());
            jsonWriter.name("requestContext");
            this.requestContextAdapter.write(jsonWriter, serviceApp.getRequestContext());
            jsonWriter.name("recommendRows");
            this.recommendRowsAdapter.write(jsonWriter, serviceApp.getRecommendRows());
            jsonWriter.name("top_ids");
            this.topIdsAdapter.write(jsonWriter, serviceApp.getTopIds());
            jsonWriter.name("open_link");
            this.openLinkAdapter.write(jsonWriter, serviceApp.getOpenLink());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ServiceApp read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTemplate;
            String str2 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str3 = this.defaultTitle;
            String str4 = this.defaultUrl;
            String str5 = this.defaultPic;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultId;
            String str8 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str9 = this.defaultEntityTypeName;
            String str10 = this.defaultPackageName;
            String str11 = this.defaultTargetId;
            String str12 = this.defaultApkType;
            String str13 = this.defaultDisplayVersionName;
            String str14 = this.defaultVersionName;
            int i = this.defaultVersionCode;
            String str15 = this.defaultApkSize;
            long j = this.defaultPublicUpdate;
            long j2 = this.defaultApkLength;
            String str16 = this.defaultExtraFlag;
            String str17 = this.defaultDescription;
            int i2 = this.defaultRecommend;
            int i3 = this.defaultDigest;
            String str18 = this.defaultChangeLog;
            String str19 = this.defaultLogo;
            String str20 = this.defaultCover;
            String str21 = this.defaultFollowCount;
            String str22 = this.defaultCommentCount;
            String str23 = this.defaultDownCount;
            float f = this.defaultRatingStar;
            String str24 = this.defaultScore;
            String str25 = this.defaultUpdateFlag;
            String str26 = this.defaultAppName;
            String str27 = this.defaultApkRomVersion;
            List<String> list = this.defaultThumbList;
            List<String> list2 = this.defaultScreenList;
            String str28 = this.defaultIntroduce;
            String str29 = this.defaultLoginUserRate;
            String str30 = this.defaultRemark;
            String str31 = this.defaultReviewer;
            int i4 = this.defaultSupportAndroidVersion;
            String str32 = this.defaultLanguage;
            int i5 = this.defaultGiftCount;
            List<Gift> list3 = this.defaultGiftRows;
            int i6 = this.defaultVotenum;
            int i7 = this.defaultVotenum1;
            int i8 = this.defaultVotenum2;
            int i9 = this.defaultVotenum3;
            int i10 = this.defaultVotenum4;
            int i11 = this.defaultVotenum5;
            UserAction userAction = this.defaultUserAction;
            List<RelatedData> list4 = this.defaultDiscoveryRows;
            List<RelatedData> list5 = this.defaultFollowerRows;
            List<User> list6 = this.defaultRecentFollowList;
            List<RelatedData> list7 = this.defaultRatingRows;
            String str33 = this.defaultCategoryId;
            String str34 = this.defaultCategoryName;
            List<String> list8 = this.defaultTagList;
            String str35 = this.defaultApkUrl;
            String str36 = this.defaultDeveloperName;
            List<String> list9 = this.defaultPermissions;
            List<ServiceApp> list10 = this.defaultDeveloperRows;
            List<ServiceApp> list11 = this.defaultRelatedRows;
            List<Album> list12 = this.defaultAlbumRows;
            String str37 = this.defaultKeywords;
            int i12 = this.defaultUpDown;
            User user = this.defaultDeveloperProfile;
            String str38 = this.defaultExtendFile;
            String str39 = this.defaultExtendName;
            String str40 = this.defaultChangeHistory;
            int i13 = this.defaultCommentBlockNum;
            List<MenuCard> list13 = this.defaultMenuCards;
            String str41 = this.defaultExtraAnalysisData;
            int i14 = this.defaultIsDownloadApp;
            int i15 = this.defaultIsForumApp;
            int i16 = this.defaultCommentStatus;
            Collection collection = this.defaultCollectionInfo;
            CollectionItem collectionItem = this.defaultCollectionItem;
            boolean z = this.defaultHasCoupon;
            String str42 = this.defaultExtraFromApi;
            String str43 = this.defaultApkSubTitle;
            List<CouponInfo> list14 = this.defaultCouponInfo;
            List<ConfigPage> list15 = this.defaultTabApiList;
            String str44 = this.defaultSelectedTab;
            int i17 = this.defaultHotNum;
            String str45 = this.defaultBgColor;
            String str46 = this.defaultRequestContext;
            List<NewHeadLine> list16 = this.defaultRecommendRows;
            List<String> list17 = this.defaultTopIds;
            String str47 = this.defaultOpenLink;
            String str48 = str17;
            Integer num2 = num;
            String str49 = str3;
            String str50 = str4;
            String str51 = str5;
            String str52 = str6;
            String str53 = str7;
            String str54 = str8;
            Long l3 = l;
            Long l4 = l2;
            String str55 = str9;
            String str56 = str10;
            String str57 = str11;
            String str58 = str;
            String str59 = str12;
            String str60 = str13;
            String str61 = str14;
            int i18 = i;
            String str62 = str2;
            String str63 = str15;
            long j3 = j;
            long j4 = j2;
            String str64 = str16;
            int i19 = i2;
            int i20 = i3;
            String str65 = str18;
            String str66 = str19;
            String str67 = str20;
            String str68 = str21;
            String str69 = str22;
            String str70 = str23;
            float f2 = f;
            String str71 = str24;
            String str72 = str25;
            String str73 = str26;
            String str74 = str27;
            List<String> list18 = list;
            List<String> list19 = list2;
            String str75 = str28;
            String str76 = str29;
            String str77 = str30;
            String str78 = str31;
            int i21 = i4;
            String str79 = str32;
            int i22 = i5;
            List<Gift> list20 = list3;
            int i23 = i6;
            int i24 = i7;
            int i25 = i8;
            int i26 = i9;
            int i27 = i10;
            int i28 = i11;
            UserAction userAction2 = userAction;
            List<RelatedData> list21 = list4;
            List<RelatedData> list22 = list5;
            List<User> list23 = list6;
            List<RelatedData> list24 = list7;
            String str80 = str33;
            String str81 = str34;
            List<String> list25 = list8;
            String str82 = str35;
            String str83 = str36;
            List<String> list26 = list9;
            List<ServiceApp> list27 = list10;
            List<ServiceApp> list28 = list11;
            List<Album> list29 = list12;
            String str84 = str37;
            int i29 = i12;
            User user2 = user;
            String str85 = str38;
            String str86 = str39;
            String str87 = str40;
            int i30 = i13;
            List<MenuCard> list30 = list13;
            String str88 = str41;
            int i31 = i14;
            int i32 = i15;
            int i33 = i16;
            Collection collection2 = collection;
            CollectionItem collectionItem2 = collectionItem;
            boolean z2 = z;
            String str89 = str42;
            String str90 = str43;
            List<CouponInfo> list31 = list14;
            List<ConfigPage> list32 = list15;
            String str91 = str44;
            int i34 = i17;
            String str92 = str45;
            String str93 = str46;
            List<NewHeadLine> list33 = list16;
            List<String> list34 = list17;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2116869207:
                            if (nextName.equals("discoveryRows")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -2060497896:
                            if (nextName.equals("subtitle")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -2034122113:
                            if (nextName.equals("developerProfile")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1940063007:
                            if (nextName.equals("extra_fromApi")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1875192041:
                            if (nextName.equals("followerRows")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1823369322:
                            if (nextName.equals("extendfile")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1823138651:
                            if (nextName.equals("extendname")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1716761884:
                            if (nextName.equals("changehistory")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1655467179:
                            if (nextName.equals("votenum1")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1655467178:
                            if (nextName.equals("votenum2")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -1655467177:
                            if (nextName.equals("votenum3")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1655467176:
                            if (nextName.equals("votenum4")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1655467175:
                            if (nextName.equals("votenum5")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -1613589672:
                            if (nextName.equals("language")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1553853997:
                            if (nextName.equals("tabList")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -1549236392:
                            if (nextName.equals("tagList")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -1515525949:
                            if (nextName.equals("developerRows")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -1514705579:
                            if (nextName.equals("developername")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -1411232333:
                            if (nextName.equals("apkUrl")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -1331913276:
                            if (nextName.equals("digest")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -1142011723:
                            if (nextName.equals("recommendRows")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -1139551026:
                            if (nextName.equals("top_ids")) {
                                c = 26;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 27;
                                break;
                            }
                            break;
                        case -934624384:
                            if (nextName.equals("remark")) {
                                c = 28;
                                break;
                            }
                            break;
                        case -904614880:
                            if (nextName.equals("requestContext")) {
                                c = 29;
                                break;
                            }
                            break;
                        case -839786019:
                            if (nextName.equals("upDown")) {
                                c = 30;
                                break;
                            }
                            break;
                        case -815576439:
                            if (nextName.equals("target_id")) {
                                c = 31;
                                break;
                            }
                            break;
                        case -797643747:
                            if (nextName.equals("apksize")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case -797598890:
                            if (nextName.equals("apktype")) {
                                c = '!';
                                break;
                            }
                            break;
                        case -734823584:
                            if (nextName.equals("hasCoupon")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case -590800682:
                            if (nextName.equals("extraAnalysisData")) {
                                c = '#';
                                break;
                            }
                            break;
                        case -417607894:
                            if (nextName.equals("screenList")) {
                                c = '$';
                                break;
                            }
                            break;
                        case -296345643:
                            if (nextName.equals("updateFlag")) {
                                c = '%';
                                break;
                            }
                            break;
                        case -261190139:
                            if (nextName.equals("reviewer")) {
                                c = '&';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case -253722724:
                            if (nextName.equals("extraFlag")) {
                                c = '(';
                                break;
                            }
                            break;
                        case -235611093:
                            if (nextName.equals("pubdate")) {
                                c = ')';
                                break;
                            }
                            break;
                        case -204859874:
                            if (nextName.equals("bgColor")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 3540562:
                            if (nextName.equals("star")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 71288274:
                            if (nextName.equals("comment_status")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 94433137:
                            if (nextName.equals("catid")) {
                                c = '1';
                                break;
                            }
                            break;
                        case 94852023:
                            if (nextName.equals("cover")) {
                                c = '2';
                                break;
                            }
                            break;
                        case 109264530:
                            if (nextName.equals("score")) {
                                c = '3';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '4';
                                break;
                            }
                            break;
                        case 220498682:
                            if (nextName.equals("selectedTab")) {
                                c = '5';
                                break;
                            }
                            break;
                        case 249406696:
                            if (nextName.equals("albumRows")) {
                                c = '6';
                                break;
                            }
                            break;
                        case 351608024:
                            if (nextName.equals("version")) {
                                c = '7';
                                break;
                            }
                            break;
                        case 375357151:
                            if (nextName.equals("is_download_app")) {
                                c = '8';
                                break;
                            }
                            break;
                        case 405440436:
                            if (nextName.equals("rating_star")) {
                                c = '9';
                                break;
                            }
                            break;
                        case 406262265:
                            if (nextName.equals("collection_item_info")) {
                                c = ':';
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = ';';
                                break;
                            }
                            break;
                        case 544617919:
                            if (nextName.equals("giftCount")) {
                                c = '<';
                                break;
                            }
                            break;
                        case 555127681:
                            if (nextName.equals("catName")) {
                                c = '=';
                                break;
                            }
                            break;
                        case 609299956:
                            if (nextName.equals("couponInfo")) {
                                c = '>';
                                break;
                            }
                            break;
                        case 639334492:
                            if (nextName.equals("votenum")) {
                                c = '?';
                                break;
                            }
                            break;
                        case 667683678:
                            if (nextName.equals("sdkversion")) {
                                c = '@';
                                break;
                            }
                            break;
                        case 683233012:
                            if (nextName.equals("comment_block_num")) {
                                c = 'A';
                                break;
                            }
                            break;
                        case 739957038:
                            if (nextName.equals("is_forum_app")) {
                                c = 'B';
                                break;
                            }
                            break;
                        case 769627632:
                            if (nextName.equals("commentCount")) {
                                c = 'C';
                                break;
                            }
                            break;
                        case 849299241:
                            if (nextName.equals("giftRows")) {
                                c = 'D';
                                break;
                            }
                            break;
                        case 871991583:
                            if (nextName.equals("introduce")) {
                                c = 'E';
                                break;
                            }
                            break;
                        case 892646436:
                            if (nextName.equals("apkRomVersion")) {
                                c = 'F';
                                break;
                            }
                            break;
                        case 908759025:
                            if (nextName.equals("packageName")) {
                                c = 'G';
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
                                c = 'H';
                                break;
                            }
                            break;
                        case 1060168111:
                            if (nextName.equals("collection_info")) {
                                c = 'I';
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = 'J';
                                break;
                            }
                            break;
                        case 1099006100:
                            if (nextName.equals("hot_num")) {
                                c = 'K';
                                break;
                            }
                            break;
                        case 1112966308:
                            if (nextName.equals("relatedRows")) {
                                c = 'L';
                                break;
                            }
                            break;
                        case 1133704324:
                            if (nextName.equals("permissions")) {
                                c = 'M';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 'N';
                                break;
                            }
                            break;
                        case 1274859917:
                            if (nextName.equals("downCount")) {
                                c = 'O';
                                break;
                            }
                            break;
                        case 1320549161:
                            if (nextName.equals("apkversioncode")) {
                                c = 'P';
                                break;
                            }
                            break;
                        case 1320863687:
                            if (nextName.equals("apkversionname")) {
                                c = 'Q';
                                break;
                            }
                            break;
                        case 1329527700:
                            if (nextName.equals("thumbList")) {
                                c = 'R';
                                break;
                            }
                            break;
                        case 1455272340:
                            if (nextName.equals("changelog")) {
                                c = 'S';
                                break;
                            }
                            break;
                        case 1546100943:
                            if (nextName.equals("open_link")) {
                                c = 'T';
                                break;
                            }
                            break;
                        case 1570622430:
                            if (nextName.equals("followCount")) {
                                c = 'U';
                                break;
                            }
                            break;
                        case 1585056604:
                            if (nextName.equals("shorttitle")) {
                                c = 'V';
                                break;
                            }
                            break;
                        case 1691718971:
                            if (nextName.equals("extendedMenus")) {
                                c = 'W';
                                break;
                            }
                            break;
                        case 1706281096:
                            if (nextName.equals("recent_follow_list")) {
                                c = 'X';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 'Y';
                                break;
                            }
                            break;
                        case 2059055106:
                            if (nextName.equals("apklength")) {
                                c = 'Z';
                                break;
                            }
                            break;
                        case 2090897686:
                            if (nextName.equals("ratingRows")) {
                                c = '[';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            list21 = this.discoveryRowsAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str62 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str52 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str90 = this.apkSubTitleAdapter.read(jsonReader);
                            continue;
                        case 4:
                            user2 = this.developerProfileAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str89 = this.extraFromApiAdapter.read(jsonReader);
                            continue;
                        case 6:
                            list22 = this.followerRowsAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str85 = this.extendFileAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str86 = this.extendNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str48 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str87 = this.changeHistoryAdapter.read(jsonReader);
                            continue;
                        case 11:
                            i24 = this.votenum1Adapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            i25 = this.votenum2Adapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            i26 = this.votenum3Adapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            i27 = this.votenum4Adapter.read(jsonReader).intValue();
                            continue;
                        case 15:
                            i28 = this.votenum5Adapter.read(jsonReader).intValue();
                            continue;
                        case 16:
                            str79 = this.languageAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str58 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 18:
                            list32 = this.tabApiListAdapter.read(jsonReader);
                            continue;
                        case 19:
                            list25 = this.tagListAdapter.read(jsonReader);
                            continue;
                        case 20:
                            list27 = this.developerRowsAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str83 = this.developerNameAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str82 = this.apkUrlAdapter.read(jsonReader);
                            continue;
                        case 23:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 24:
                            i20 = this.digestAdapter.read(jsonReader).intValue();
                            continue;
                        case 25:
                            list33 = this.recommendRowsAdapter.read(jsonReader);
                            continue;
                        case 26:
                            list34 = this.topIdsAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str55 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str77 = this.remarkAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str93 = this.requestContextAdapter.read(jsonReader);
                            continue;
                        case 30:
                            i29 = this.upDownAdapter.read(jsonReader).intValue();
                            continue;
                        case 31:
                            str57 = this.targetIdAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str63 = this.apkSizeAdapter.read(jsonReader);
                            continue;
                        case '!':
                            str59 = this.apkTypeAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            z2 = this.hasCouponAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '#':
                            str88 = this.extraAnalysisDataAdapter.read(jsonReader);
                            continue;
                        case '$':
                            list19 = this.screenListAdapter.read(jsonReader);
                            continue;
                        case '%':
                            str72 = this.updateFlagAdapter.read(jsonReader);
                            continue;
                        case '&':
                            str78 = this.reviewerAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str54 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '(':
                            str64 = this.extraFlagAdapter.read(jsonReader);
                            continue;
                        case ')':
                            j3 = this.publicUpdateAdapter.read(jsonReader).longValue();
                            continue;
                        case '*':
                            str92 = this.bgColorAdapter.read(jsonReader);
                            continue;
                        case '+':
                            str53 = this.idAdapter.read(jsonReader);
                            continue;
                        case ',':
                            str51 = this.picAdapter.read(jsonReader);
                            continue;
                        case '-':
                            str50 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '.':
                            str66 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '/':
                            str76 = this.loginUserRateAdapter.read(jsonReader);
                            continue;
                        case '0':
                            i33 = this.commentStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '1':
                            str80 = this.categoryIdAdapter.read(jsonReader);
                            continue;
                        case '2':
                            str67 = this.coverAdapter.read(jsonReader);
                            continue;
                        case '3':
                            str71 = this.scoreAdapter.read(jsonReader);
                            continue;
                        case '4':
                            str49 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '5':
                            str91 = this.selectedTabAdapter.read(jsonReader);
                            continue;
                        case '6':
                            list29 = this.albumRowsAdapter.read(jsonReader);
                            continue;
                        case '7':
                            str60 = this.displayVersionNameAdapter.read(jsonReader);
                            continue;
                        case '8':
                            i31 = this.isDownloadAppAdapter.read(jsonReader).intValue();
                            continue;
                        case '9':
                            f2 = this.ratingStarAdapter.read(jsonReader).floatValue();
                            continue;
                        case ':':
                            collectionItem2 = this.collectionItemAdapter.read(jsonReader);
                            continue;
                        case ';':
                            str84 = this.keywordsAdapter.read(jsonReader);
                            continue;
                        case '<':
                            i22 = this.giftCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '=':
                            str81 = this.categoryNameAdapter.read(jsonReader);
                            continue;
                        case '>':
                            list31 = this.couponInfoAdapter.read(jsonReader);
                            continue;
                        case '?':
                            i23 = this.votenumAdapter.read(jsonReader).intValue();
                            continue;
                        case '@':
                            i21 = this.supportAndroidVersionAdapter.read(jsonReader).intValue();
                            continue;
                        case 'A':
                            i30 = this.commentBlockNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'B':
                            i32 = this.isForumAppAdapter.read(jsonReader).intValue();
                            continue;
                        case 'C':
                            str69 = this.commentCountAdapter.read(jsonReader);
                            continue;
                        case 'D':
                            list20 = this.giftRowsAdapter.read(jsonReader);
                            continue;
                        case 'E':
                            str75 = this.introduceAdapter.read(jsonReader);
                            continue;
                        case 'F':
                            str74 = this.apkRomVersionAdapter.read(jsonReader);
                            continue;
                        case 'G':
                            str56 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case 'H':
                            i19 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case 'I':
                            collection2 = this.collectionInfoAdapter.read(jsonReader);
                            continue;
                        case 'J':
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case 'K':
                            i34 = this.hotNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'L':
                            list28 = this.relatedRowsAdapter.read(jsonReader);
                            continue;
                        case 'M':
                            list26 = this.permissionsAdapter.read(jsonReader);
                            continue;
                        case 'N':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 'O':
                            str70 = this.downCountAdapter.read(jsonReader);
                            continue;
                        case 'P':
                            i18 = this.versionCodeAdapter.read(jsonReader).intValue();
                            continue;
                        case 'Q':
                            str61 = this.versionNameAdapter.read(jsonReader);
                            continue;
                        case 'R':
                            list18 = this.thumbListAdapter.read(jsonReader);
                            continue;
                        case 'S':
                            str65 = this.changeLogAdapter.read(jsonReader);
                            continue;
                        case 'T':
                            str47 = this.openLinkAdapter.read(jsonReader);
                            continue;
                        case 'U':
                            str68 = this.followCountAdapter.read(jsonReader);
                            continue;
                        case 'V':
                            str73 = this.appNameAdapter.read(jsonReader);
                            continue;
                        case 'W':
                            list30 = this.menuCardsAdapter.read(jsonReader);
                            continue;
                        case 'X':
                            list23 = this.recentFollowListAdapter.read(jsonReader);
                            continue;
                        case 'Y':
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 'Z':
                            j4 = this.apkLengthAdapter.read(jsonReader).longValue();
                            continue;
                        case '[':
                            list24 = this.ratingRowsAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ServiceApp(str58, str62, num2, str49, str50, str51, str52, str53, str54, l3, l4, str55, str56, str57, str59, str60, str61, i18, str63, j3, j4, str64, str48, i19, i20, str65, str66, str67, str68, str69, str70, f2, str71, str72, str73, str74, list18, list19, str75, str76, str77, str78, i21, str79, i22, list20, i23, i24, i25, i26, i27, i28, userAction2, list21, list22, list23, list24, str80, str81, list25, str82, str83, list26, list27, list28, list29, str84, i29, user2, str85, str86, str87, i30, list30, str88, i31, i32, i33, collection2, collectionItem2, z2, str89, str90, list31, list32, str91, i34, str92, str93, list33, list34, str47);
        }
    }
}
