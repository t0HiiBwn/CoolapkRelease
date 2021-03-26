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

/* renamed from: com.coolapk.market.model.$AutoValue_UserProfile  reason: invalid class name */
abstract class C$AutoValue_UserProfile extends C$$AutoValue_UserProfile {
    C$AutoValue_UserProfile(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, UserInfo userInfo, String str13, String str14, String str15, int i, String str16, String str17, int i2, String str18, int i3, int i4, float f, String str19, String str20, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str21, String str22, String str23, String str24, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, String str25, String str26, int i25, int i26, long j, long j2, int i27, List<Entity> list, String str27, String str28, int i28, Tips tips, int i29, String str29, String str30, String str31, List<String> list2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l2, l3, str12, userInfo, str13, str14, str15, i, str16, str17, i2, str18, i3, i4, f, str19, str20, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, str21, str22, str23, str24, i17, i18, i19, i20, i21, i22, i23, i24, str25, str26, i25, i26, j, j2, i27, list, str27, str28, i28, tips, i29, str29, str30, str31, list2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_UserProfile$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<UserProfile> {
        private final TypeAdapter<String> EMailAdapter;
        private final TypeAdapter<Integer> albumFavorNumAdapter;
        private final TypeAdapter<Integer> albumNumAdapter;
        private final TypeAdapter<Integer> apkCommentNumAdapter;
        private final TypeAdapter<Integer> apkDevNumAdapter;
        private final TypeAdapter<Integer> apkFollowNumAdapter;
        private final TypeAdapter<Integer> apkRatingNumAdapter;
        private final TypeAdapter<Integer> beLikeNumAdapter;
        private final TypeAdapter<Integer> birthdayAdapter;
        private final TypeAdapter<Integer> birthmonthAdapter;
        private final TypeAdapter<Integer> birthyearAdapter;
        private final TypeAdapter<String> cityAdapter;
        private final TypeAdapter<String> coverAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultAlbumFavorNum = 0;
        private int defaultAlbumNum = 0;
        private int defaultApkCommentNum = 0;
        private int defaultApkDevNum = 0;
        private int defaultApkFollowNum = 0;
        private int defaultApkRatingNum = 0;
        private int defaultBeLikeNum = 0;
        private int defaultBirthday = 0;
        private int defaultBirthmonth = 0;
        private int defaultBirthyear = 0;
        private String defaultCity = null;
        private String defaultCover = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private int defaultDiscoveryNum = 0;
        private String defaultDisplayUserName = null;
        private String defaultEMail = null;
        private int defaultEmailStatus = 0;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFansNum = 0;
        private int defaultFeedNum = 0;
        private int defaultFollowNum = 0;
        private int defaultGender = 0;
        private List<Entity> defaultHomeTabCardRows = Collections.emptyList();
        private String defaultId = null;
        private int defaultIsDeveloper = 0;
        private int defaultIsFans = 0;
        private int defaultIsFollow = 0;
        private int defaultIsInBlackList = 0;
        private int defaultIsInIgnoreList = 0;
        private int defaultIsInLimitList = 0;
        private Long defaultLastUpdate = null;
        private int defaultLevel = 0;
        private String defaultLevelDetailUrl = null;
        private int defaultLevelExperience = 0;
        private String defaultLevelTodayMessage = null;
        private long defaultLoginTime = 0;
        private String defaultLogo = null;
        private int defaultMobileStatus = 0;
        private int defaultNextLevelExperience = 0;
        private float defaultNextLevelPercentage = 0.0f;
        private String defaultPhoneNumber = null;
        private String defaultPic = null;
        private String defaultProvince = null;
        private long defaultRegDate = 0;
        private int defaultReplyNum = 0;
        private String defaultSelectedTab = null;
        private String defaultSignature = null;
        private String defaultSubTitle = null;
        private Tips defaultTips = null;
        private String defaultTitle = null;
        private List<String> defaultTopIds = Collections.emptyList();
        private String defaultUid = null;
        private String defaultUrl = null;
        private String defaultUserGroupName = null;
        private UserInfo defaultUserInfo = null;
        private int defaultUserNameStatus = 0;
        private String defaultVerifyIcon = null;
        private String defaultVerifyLabel = null;
        private int defaultVerifyStatus = 0;
        private String defaultVerifyTitle = null;
        private String defaultWeibo = null;
        private String defaultZodiacSign = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> discoveryNumAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<Integer> emailStatusAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> fansNumAdapter;
        private final TypeAdapter<Integer> feedNumAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<Integer> genderAdapter;
        private final TypeAdapter<List<Entity>> homeTabCardRowsAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isDeveloperAdapter;
        private final TypeAdapter<Integer> isFansAdapter;
        private final TypeAdapter<Integer> isFollowAdapter;
        private final TypeAdapter<Integer> isInBlackListAdapter;
        private final TypeAdapter<Integer> isInIgnoreListAdapter;
        private final TypeAdapter<Integer> isInLimitListAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Integer> levelAdapter;
        private final TypeAdapter<String> levelDetailUrlAdapter;
        private final TypeAdapter<Integer> levelExperienceAdapter;
        private final TypeAdapter<String> levelTodayMessageAdapter;
        private final TypeAdapter<Long> loginTimeAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<Integer> mobileStatusAdapter;
        private final TypeAdapter<Integer> nextLevelExperienceAdapter;
        private final TypeAdapter<Float> nextLevelPercentageAdapter;
        private final TypeAdapter<String> phoneNumberAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> provinceAdapter;
        private final TypeAdapter<Long> regDateAdapter;
        private final TypeAdapter<Integer> replyNumAdapter;
        private final TypeAdapter<String> selectedTabAdapter;
        private final TypeAdapter<String> signatureAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<Tips> tipsAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<List<String>> topIdsAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> userGroupNameAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;
        private final TypeAdapter<Integer> userNameStatusAdapter;
        private final TypeAdapter<String> verifyIconAdapter;
        private final TypeAdapter<String> verifyLabelAdapter;
        private final TypeAdapter<Integer> verifyStatusAdapter;
        private final TypeAdapter<String> verifyTitleAdapter;
        private final TypeAdapter<String> weiboAdapter;
        private final TypeAdapter<String> zodiacSignAdapter;

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
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.genderAdapter = gson.getAdapter(Integer.class);
            this.userGroupNameAdapter = gson.getAdapter(String.class);
            this.EMailAdapter = gson.getAdapter(String.class);
            this.levelAdapter = gson.getAdapter(Integer.class);
            this.signatureAdapter = gson.getAdapter(String.class);
            this.levelExperienceAdapter = gson.getAdapter(Integer.class);
            this.nextLevelExperienceAdapter = gson.getAdapter(Integer.class);
            this.nextLevelPercentageAdapter = gson.getAdapter(Float.class);
            this.levelTodayMessageAdapter = gson.getAdapter(String.class);
            this.levelDetailUrlAdapter = gson.getAdapter(String.class);
            this.apkFollowNumAdapter = gson.getAdapter(Integer.class);
            this.apkCommentNumAdapter = gson.getAdapter(Integer.class);
            this.apkRatingNumAdapter = gson.getAdapter(Integer.class);
            this.albumNumAdapter = gson.getAdapter(Integer.class);
            this.albumFavorNumAdapter = gson.getAdapter(Integer.class);
            this.discoveryNumAdapter = gson.getAdapter(Integer.class);
            this.isFollowAdapter = gson.getAdapter(Integer.class);
            this.beLikeNumAdapter = gson.getAdapter(Integer.class);
            this.feedNumAdapter = gson.getAdapter(Integer.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.fansNumAdapter = gson.getAdapter(Integer.class);
            this.isDeveloperAdapter = gson.getAdapter(Integer.class);
            this.weiboAdapter = gson.getAdapter(String.class);
            this.cityAdapter = gson.getAdapter(String.class);
            this.provinceAdapter = gson.getAdapter(String.class);
            this.coverAdapter = gson.getAdapter(String.class);
            this.birthdayAdapter = gson.getAdapter(Integer.class);
            this.birthmonthAdapter = gson.getAdapter(Integer.class);
            this.birthyearAdapter = gson.getAdapter(Integer.class);
            this.apkDevNumAdapter = gson.getAdapter(Integer.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.isInBlackListAdapter = gson.getAdapter(Integer.class);
            this.isInIgnoreListAdapter = gson.getAdapter(Integer.class);
            this.isInLimitListAdapter = gson.getAdapter(Integer.class);
            this.phoneNumberAdapter = gson.getAdapter(String.class);
            this.zodiacSignAdapter = gson.getAdapter(String.class);
            this.mobileStatusAdapter = gson.getAdapter(Integer.class);
            this.emailStatusAdapter = gson.getAdapter(Integer.class);
            this.regDateAdapter = gson.getAdapter(Long.class);
            this.loginTimeAdapter = gson.getAdapter(Long.class);
            this.isFansAdapter = gson.getAdapter(Integer.class);
            this.homeTabCardRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Entity.class));
            this.selectedTabAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.userNameStatusAdapter = gson.getAdapter(Integer.class);
            this.tipsAdapter = gson.getAdapter(Tips.class);
            this.verifyStatusAdapter = gson.getAdapter(Integer.class);
            this.verifyIconAdapter = gson.getAdapter(String.class);
            this.verifyLabelAdapter = gson.getAdapter(String.class);
            this.verifyTitleAdapter = gson.getAdapter(String.class);
            this.topIdsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
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

        public GsonTypeAdapter setDefaultDateline(Long l2) {
            this.defaultDateline = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l2) {
            this.defaultLastUpdate = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedUserAvatar(String str) {
            this.defaultDeprecatedUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(UserInfo userInfo) {
            this.defaultUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedUserName(String str) {
            this.defaultDeprecatedUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayUserName(String str) {
            this.defaultDisplayUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGender(int i) {
            this.defaultGender = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserGroupName(String str) {
            this.defaultUserGroupName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEMail(String str) {
            this.defaultEMail = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLevel(int i) {
            this.defaultLevel = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSignature(String str) {
            this.defaultSignature = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLevelExperience(int i) {
            this.defaultLevelExperience = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNextLevelExperience(int i) {
            this.defaultNextLevelExperience = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNextLevelPercentage(float f) {
            this.defaultNextLevelPercentage = f;
            return this;
        }

        public GsonTypeAdapter setDefaultLevelTodayMessage(String str) {
            this.defaultLevelTodayMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLevelDetailUrl(String str) {
            this.defaultLevelDetailUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkFollowNum(int i) {
            this.defaultApkFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkCommentNum(int i) {
            this.defaultApkCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkRatingNum(int i) {
            this.defaultApkRatingNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAlbumNum(int i) {
            this.defaultAlbumNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAlbumFavorNum(int i) {
            this.defaultAlbumFavorNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDiscoveryNum(int i) {
            this.defaultDiscoveryNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFollow(int i) {
            this.defaultIsFollow = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBeLikeNum(int i) {
            this.defaultBeLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedNum(int i) {
            this.defaultFeedNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFansNum(int i) {
            this.defaultFansNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsDeveloper(int i) {
            this.defaultIsDeveloper = i;
            return this;
        }

        public GsonTypeAdapter setDefaultWeibo(String str) {
            this.defaultWeibo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCity(String str) {
            this.defaultCity = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProvince(String str) {
            this.defaultProvince = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCover(String str) {
            this.defaultCover = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBirthday(int i) {
            this.defaultBirthday = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBirthmonth(int i) {
            this.defaultBirthmonth = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBirthyear(int i) {
            this.defaultBirthyear = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkDevNum(int i) {
            this.defaultApkDevNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyNum(int i) {
            this.defaultReplyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsInBlackList(int i) {
            this.defaultIsInBlackList = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsInIgnoreList(int i) {
            this.defaultIsInIgnoreList = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsInLimitList(int i) {
            this.defaultIsInLimitList = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPhoneNumber(String str) {
            this.defaultPhoneNumber = str;
            return this;
        }

        public GsonTypeAdapter setDefaultZodiacSign(String str) {
            this.defaultZodiacSign = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMobileStatus(int i) {
            this.defaultMobileStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultEmailStatus(int i) {
            this.defaultEmailStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRegDate(long j) {
            this.defaultRegDate = j;
            return this;
        }

        public GsonTypeAdapter setDefaultLoginTime(long j) {
            this.defaultLoginTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFans(int i) {
            this.defaultIsFans = i;
            return this;
        }

        public GsonTypeAdapter setDefaultHomeTabCardRows(List<Entity> list) {
            this.defaultHomeTabCardRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultSelectedTab(String str) {
            this.defaultSelectedTab = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserNameStatus(int i) {
            this.defaultUserNameStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTips(Tips tips) {
            this.defaultTips = tips;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyStatus(int i) {
            this.defaultVerifyStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyIcon(String str) {
            this.defaultVerifyIcon = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyLabel(String str) {
            this.defaultVerifyLabel = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyTitle(String str) {
            this.defaultVerifyTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTopIds(List<String> list) {
            this.defaultTopIds = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, UserProfile userProfile) throws IOException {
            if (userProfile == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, userProfile.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, userProfile.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, userProfile.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, userProfile.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, userProfile.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, userProfile.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, userProfile.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, userProfile.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, userProfile.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, userProfile.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, userProfile.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, userProfile.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, userProfile.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, userProfile.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, userProfile.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, userProfile.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, userProfile.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, userProfile.getDisplayUserName());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, userProfile.getUid());
            jsonWriter.name("gender");
            this.genderAdapter.write(jsonWriter, Integer.valueOf(userProfile.getGender()));
            jsonWriter.name("userGroupName");
            this.userGroupNameAdapter.write(jsonWriter, userProfile.getUserGroupName());
            jsonWriter.name("email");
            this.EMailAdapter.write(jsonWriter, userProfile.getEMail());
            jsonWriter.name("level");
            this.levelAdapter.write(jsonWriter, Integer.valueOf(userProfile.getLevel()));
            jsonWriter.name("bio");
            this.signatureAdapter.write(jsonWriter, userProfile.getSignature());
            jsonWriter.name("experience");
            this.levelExperienceAdapter.write(jsonWriter, Integer.valueOf(userProfile.getLevelExperience()));
            jsonWriter.name("next_level_experience");
            this.nextLevelExperienceAdapter.write(jsonWriter, Integer.valueOf(userProfile.getNextLevelExperience()));
            jsonWriter.name("next_level_percentage");
            this.nextLevelPercentageAdapter.write(jsonWriter, Float.valueOf(userProfile.getNextLevelPercentage()));
            jsonWriter.name("level_today_message");
            this.levelTodayMessageAdapter.write(jsonWriter, userProfile.getLevelTodayMessage());
            jsonWriter.name("level_detail_url");
            this.levelDetailUrlAdapter.write(jsonWriter, userProfile.getLevelDetailUrl());
            jsonWriter.name("apkFollowNum");
            this.apkFollowNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getApkFollowNum()));
            jsonWriter.name("apkCommentNum");
            this.apkCommentNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getApkCommentNum()));
            jsonWriter.name("apkRatingNum");
            this.apkRatingNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getApkRatingNum()));
            jsonWriter.name("albumNum");
            this.albumNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getAlbumNum()));
            jsonWriter.name("albumFavorNum");
            this.albumFavorNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getAlbumFavorNum()));
            jsonWriter.name("discoveryNum");
            this.discoveryNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getDiscoveryNum()));
            jsonWriter.name("isFollow");
            this.isFollowAdapter.write(jsonWriter, Integer.valueOf(userProfile.getIsFollow()));
            jsonWriter.name("be_like_num");
            this.beLikeNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getBeLikeNum()));
            jsonWriter.name("feed");
            this.feedNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getFeedNum()));
            jsonWriter.name("follow");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getFollowNum()));
            jsonWriter.name("fans");
            this.fansNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getFansNum()));
            jsonWriter.name("isDeveloper");
            this.isDeveloperAdapter.write(jsonWriter, Integer.valueOf(userProfile.getIsDeveloper()));
            jsonWriter.name("weibo");
            this.weiboAdapter.write(jsonWriter, userProfile.getWeibo());
            jsonWriter.name("city");
            this.cityAdapter.write(jsonWriter, userProfile.getCity());
            jsonWriter.name("province");
            this.provinceAdapter.write(jsonWriter, userProfile.getProvince());
            jsonWriter.name("cover");
            this.coverAdapter.write(jsonWriter, userProfile.getCover());
            jsonWriter.name("birthday");
            this.birthdayAdapter.write(jsonWriter, Integer.valueOf(userProfile.getBirthday()));
            jsonWriter.name("birthmonth");
            this.birthmonthAdapter.write(jsonWriter, Integer.valueOf(userProfile.getBirthmonth()));
            jsonWriter.name("birthyear");
            this.birthyearAdapter.write(jsonWriter, Integer.valueOf(userProfile.getBirthyear()));
            jsonWriter.name("apkDevNum");
            this.apkDevNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getApkDevNum()));
            jsonWriter.name("replyNum");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(userProfile.getReplyNum()));
            jsonWriter.name("isBlackList");
            this.isInBlackListAdapter.write(jsonWriter, Integer.valueOf(userProfile.getIsInBlackList()));
            jsonWriter.name("isIgnoreList");
            this.isInIgnoreListAdapter.write(jsonWriter, Integer.valueOf(userProfile.getIsInIgnoreList()));
            jsonWriter.name("isLimitList");
            this.isInLimitListAdapter.write(jsonWriter, Integer.valueOf(userProfile.getIsInLimitList()));
            jsonWriter.name("mobile");
            this.phoneNumberAdapter.write(jsonWriter, userProfile.getPhoneNumber());
            jsonWriter.name("astro");
            this.zodiacSignAdapter.write(jsonWriter, userProfile.getZodiacSign());
            jsonWriter.name("mobilestatus");
            this.mobileStatusAdapter.write(jsonWriter, Integer.valueOf(userProfile.getMobileStatus()));
            jsonWriter.name("emailstatus");
            this.emailStatusAdapter.write(jsonWriter, Integer.valueOf(userProfile.getEmailStatus()));
            jsonWriter.name("regdate");
            this.regDateAdapter.write(jsonWriter, Long.valueOf(userProfile.getRegDate()));
            jsonWriter.name("logintime");
            this.loginTimeAdapter.write(jsonWriter, Long.valueOf(userProfile.getLoginTime()));
            jsonWriter.name("isFans");
            this.isFansAdapter.write(jsonWriter, Integer.valueOf(userProfile.getIsFans()));
            jsonWriter.name("homeTabCardRows");
            this.homeTabCardRowsAdapter.write(jsonWriter, userProfile.getHomeTabCardRows());
            jsonWriter.name("selectedTab");
            this.selectedTabAdapter.write(jsonWriter, userProfile.getSelectedTab());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, userProfile.getEntityType());
            jsonWriter.name("usernamestatus");
            this.userNameStatusAdapter.write(jsonWriter, Integer.valueOf(userProfile.getUserNameStatus()));
            jsonWriter.name("tips");
            this.tipsAdapter.write(jsonWriter, userProfile.getTips());
            jsonWriter.name("verify_status");
            this.verifyStatusAdapter.write(jsonWriter, Integer.valueOf(userProfile.getVerifyStatus()));
            jsonWriter.name("verify_icon");
            this.verifyIconAdapter.write(jsonWriter, userProfile.getVerifyIcon());
            jsonWriter.name("verify_label");
            this.verifyLabelAdapter.write(jsonWriter, userProfile.getVerifyLabel());
            jsonWriter.name("verify_title");
            this.verifyTitleAdapter.write(jsonWriter, userProfile.getVerifyTitle());
            jsonWriter.name("top_ids");
            this.topIdsAdapter.write(jsonWriter, userProfile.getTopIds());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UserProfile read(JsonReader jsonReader) throws IOException {
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
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str12 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str13 = this.defaultDeprecatedUserName;
            String str14 = this.defaultDisplayUserName;
            String str15 = this.defaultUid;
            int i = this.defaultGender;
            String str16 = this.defaultUserGroupName;
            String str17 = this.defaultEMail;
            int i2 = this.defaultLevel;
            String str18 = this.defaultSignature;
            int i3 = this.defaultLevelExperience;
            int i4 = this.defaultNextLevelExperience;
            float f = this.defaultNextLevelPercentage;
            String str19 = this.defaultLevelTodayMessage;
            String str20 = this.defaultLevelDetailUrl;
            int i5 = this.defaultApkFollowNum;
            int i6 = this.defaultApkCommentNum;
            int i7 = this.defaultApkRatingNum;
            int i8 = this.defaultAlbumNum;
            int i9 = this.defaultAlbumFavorNum;
            int i10 = this.defaultDiscoveryNum;
            int i11 = this.defaultIsFollow;
            int i12 = this.defaultBeLikeNum;
            int i13 = this.defaultFeedNum;
            int i14 = this.defaultFollowNum;
            int i15 = this.defaultFansNum;
            int i16 = this.defaultIsDeveloper;
            String str21 = this.defaultWeibo;
            String str22 = this.defaultCity;
            String str23 = this.defaultProvince;
            String str24 = this.defaultCover;
            int i17 = this.defaultBirthday;
            int i18 = this.defaultBirthmonth;
            int i19 = this.defaultBirthyear;
            int i20 = this.defaultApkDevNum;
            int i21 = this.defaultReplyNum;
            int i22 = this.defaultIsInBlackList;
            int i23 = this.defaultIsInIgnoreList;
            int i24 = this.defaultIsInLimitList;
            String str25 = this.defaultPhoneNumber;
            String str26 = this.defaultZodiacSign;
            int i25 = this.defaultMobileStatus;
            int i26 = this.defaultEmailStatus;
            long j = this.defaultRegDate;
            long j2 = this.defaultLoginTime;
            int i27 = this.defaultIsFans;
            List<Entity> list = this.defaultHomeTabCardRows;
            String str27 = this.defaultSelectedTab;
            String str28 = this.defaultEntityType;
            int i28 = this.defaultUserNameStatus;
            Tips tips = this.defaultTips;
            int i29 = this.defaultVerifyStatus;
            String str29 = this.defaultVerifyIcon;
            String str30 = this.defaultVerifyLabel;
            String str31 = this.defaultVerifyTitle;
            List<String> list2 = this.defaultTopIds;
            List<Entity> list3 = list;
            String str32 = str3;
            Integer num2 = num;
            String str33 = str4;
            String str34 = str5;
            String str35 = str6;
            String str36 = str7;
            String str37 = str8;
            String str38 = str9;
            String str39 = str10;
            String str40 = str11;
            Long l4 = l2;
            Long l5 = l3;
            String str41 = str;
            String str42 = str12;
            UserInfo userInfo2 = userInfo;
            String str43 = str13;
            String str44 = str14;
            String str45 = str15;
            int i30 = i;
            String str46 = str16;
            String str47 = str17;
            int i31 = i2;
            String str48 = str18;
            int i32 = i3;
            int i33 = i4;
            float f2 = f;
            String str49 = str19;
            String str50 = str20;
            int i34 = i5;
            int i35 = i6;
            int i36 = i7;
            int i37 = i8;
            int i38 = i9;
            int i39 = i10;
            int i40 = i11;
            int i41 = i12;
            int i42 = i13;
            int i43 = i14;
            int i44 = i15;
            int i45 = i16;
            String str51 = str21;
            String str52 = str22;
            String str53 = str23;
            String str54 = str24;
            int i46 = i17;
            int i47 = i18;
            int i48 = i19;
            int i49 = i20;
            int i50 = i21;
            int i51 = i22;
            int i52 = i23;
            int i53 = i24;
            String str55 = str25;
            String str56 = str26;
            int i54 = i25;
            String str57 = str2;
            int i55 = i26;
            long j3 = j;
            long j4 = j2;
            int i56 = i27;
            String str58 = str27;
            String str59 = str28;
            int i57 = i28;
            Tips tips2 = tips;
            int i58 = i29;
            String str60 = str29;
            String str61 = str30;
            String str62 = str31;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2091764527:
                            if (nextName.equals("next_level_experience")) {
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
                        case -1948594049:
                            if (nextName.equals("verify_icon")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1784488141:
                            if (nextName.equals("isBlackList")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1718327882:
                            if (nextName.equals("logintime")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1520560157:
                            if (nextName.equals("apkCommentNum")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1499603180:
                            if (nextName.equals("mobilestatus")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1497893234:
                            if (nextName.equals("emailstatus")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1487706121:
                            if (nextName.equals("albumFavorNum")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -1481955494:
                            if (nextName.equals("be_like_num")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -1372431121:
                            if (nextName.equals("isLimitList")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1268958287:
                            if (nextName.equals("follow")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1257536019:
                            if (nextName.equals("apkRatingNum")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -1249512767:
                            if (nextName.equals("gender")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -1243355558:
                            if (nextName.equals("isIgnoreList")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -1208449668:
                            if (nextName.equals("birthyear")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -1180519414:
                            if (nextName.equals("isFans")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -1139551026:
                            if (nextName.equals("top_ids")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -1071194040:
                            if (nextName.equals("usernamestatus")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -1068855134:
                            if (nextName.equals("mobile")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -987485392:
                            if (nextName.equals("province")) {
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
                        case -836185255:
                            if (nextName.equals("apkFollowNum")) {
                                c = 28;
                                break;
                            }
                            break;
                        case -594924165:
                            if (nextName.equals("isFollow")) {
                                c = 29;
                                break;
                            }
                            break;
                        case -429637572:
                            if (nextName.equals("replyNum")) {
                                c = 30;
                                break;
                            }
                            break;
                        case -274175058:
                            if (nextName.equals("verify_label")) {
                                c = 31;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case -266531054:
                            if (nextName.equals("verify_title")) {
                                c = '!';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '#';
                                break;
                            }
                            break;
                        case -85567126:
                            if (nextName.equals("experience")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 97544:
                            if (nextName.equals("bio")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 3053931:
                            if (nextName.equals("city")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 3135424:
                            if (nextName.equals("fans")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 3138974:
                            if (nextName.equals("feed")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 3560248:
                            if (nextName.equals("tips")) {
                                c = '.';
                                break;
                            }
                            break;
                        case 93122623:
                            if (nextName.equals("astro")) {
                                c = '/';
                                break;
                            }
                            break;
                        case 94852023:
                            if (nextName.equals("cover")) {
                                c = '0';
                                break;
                            }
                            break;
                        case 96619420:
                            if (nextName.equals("email")) {
                                c = '1';
                                break;
                            }
                            break;
                        case 102865796:
                            if (nextName.equals("level")) {
                                c = '2';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '3';
                                break;
                            }
                            break;
                        case 113011944:
                            if (nextName.equals("weibo")) {
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
                        case 308443768:
                            if (nextName.equals("verify_status")) {
                                c = '6';
                                break;
                            }
                            break;
                        case 353868828:
                            if (nextName.equals("level_detail_url")) {
                                c = '7';
                                break;
                            }
                            break;
                        case 480826911:
                            if (nextName.equals("userGroupName")) {
                                c = '8';
                                break;
                            }
                            break;
                        case 881421198:
                            if (nextName.equals("level_today_message")) {
                                c = '9';
                                break;
                            }
                            break;
                        case 914103405:
                            if (nextName.equals("apkDevNum")) {
                                c = ':';
                                break;
                            }
                            break;
                        case 932866399:
                            if (nextName.equals("homeTabCardRows")) {
                                c = ';';
                                break;
                            }
                            break;
                        case 1069376125:
                            if (nextName.equals("birthday")) {
                                c = '<';
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = '=';
                                break;
                            }
                            break;
                        case 1085947458:
                            if (nextName.equals("regdate")) {
                                c = '>';
                                break;
                            }
                            break;
                        case 1097738688:
                            if (nextName.equals("isDeveloper")) {
                                c = '?';
                                break;
                            }
                            break;
                        case 1178636214:
                            if (nextName.equals("discoveryNum")) {
                                c = '@';
                                break;
                            }
                            break;
                        case 1181994273:
                            if (nextName.equals("birthmonth")) {
                                c = 'A';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 'B';
                                break;
                            }
                            break;
                        case 1366937089:
                            if (nextName.equals("next_level_percentage")) {
                                c = 'C';
                                break;
                            }
                            break;
                        case 1532062359:
                            if (nextName.equals("albumNum")) {
                                c = 'D';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 'E';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str32 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            i33 = this.nextLevelExperienceAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            str38 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str60 = this.verifyIconAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i51 = this.isInBlackListAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str35 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 6:
                            j4 = this.loginTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 7:
                            str57 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            i35 = this.apkCommentNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            i54 = this.mobileStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            i55 = this.emailStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            i38 = this.albumFavorNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            str59 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            i41 = this.beLikeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            str44 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 15:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i53 = this.isInLimitListAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            i43 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            i36 = this.apkRatingNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            i30 = this.genderAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            i52 = this.isInIgnoreListAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            i48 = this.birthyearAdapter.read(jsonReader).intValue();
                            continue;
                        case 22:
                            i56 = this.isFansAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            list2 = this.topIdsAdapter.read(jsonReader);
                            continue;
                        case 24:
                            i57 = this.userNameStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 25:
                            str55 = this.phoneNumberAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str53 = this.provinceAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str41 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 28:
                            i34 = this.apkFollowNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 29:
                            i40 = this.isFollowAdapter.read(jsonReader).intValue();
                            continue;
                        case 30:
                            i50 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 31:
                            str61 = this.verifyLabelAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '!':
                            str62 = this.verifyTitleAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            str43 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case '#':
                            str40 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '$':
                            i32 = this.levelExperienceAdapter.read(jsonReader).intValue();
                            continue;
                        case '%':
                            str39 = this.idAdapter.read(jsonReader);
                            continue;
                        case '&':
                            str48 = this.signatureAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str36 = this.picAdapter.read(jsonReader);
                            continue;
                        case '(':
                            str45 = this.uidAdapter.read(jsonReader);
                            continue;
                        case ')':
                            str34 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '*':
                            str52 = this.cityAdapter.read(jsonReader);
                            continue;
                        case '+':
                            i44 = this.fansNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ',':
                            i42 = this.feedNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '-':
                            str37 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '.':
                            tips2 = this.tipsAdapter.read(jsonReader);
                            continue;
                        case '/':
                            str56 = this.zodiacSignAdapter.read(jsonReader);
                            continue;
                        case '0':
                            str54 = this.coverAdapter.read(jsonReader);
                            continue;
                        case '1':
                            str47 = this.EMailAdapter.read(jsonReader);
                            continue;
                        case '2':
                            i31 = this.levelAdapter.read(jsonReader).intValue();
                            continue;
                        case '3':
                            str33 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '4':
                            str51 = this.weiboAdapter.read(jsonReader);
                            continue;
                        case '5':
                            str58 = this.selectedTabAdapter.read(jsonReader);
                            continue;
                        case '6':
                            i58 = this.verifyStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '7':
                            str50 = this.levelDetailUrlAdapter.read(jsonReader);
                            continue;
                        case '8':
                            str46 = this.userGroupNameAdapter.read(jsonReader);
                            continue;
                        case '9':
                            str49 = this.levelTodayMessageAdapter.read(jsonReader);
                            continue;
                        case ':':
                            i49 = this.apkDevNumAdapter.read(jsonReader).intValue();
                            continue;
                        case ';':
                            list3 = this.homeTabCardRowsAdapter.read(jsonReader);
                            continue;
                        case '<':
                            i46 = this.birthdayAdapter.read(jsonReader).intValue();
                            continue;
                        case '=':
                            str42 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '>':
                            j3 = this.regDateAdapter.read(jsonReader).longValue();
                            continue;
                        case '?':
                            i45 = this.isDeveloperAdapter.read(jsonReader).intValue();
                            continue;
                        case '@':
                            i39 = this.discoveryNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'A':
                            i47 = this.birthmonthAdapter.read(jsonReader).intValue();
                            continue;
                        case 'B':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 'C':
                            f2 = this.nextLevelPercentageAdapter.read(jsonReader).floatValue();
                            continue;
                        case 'D':
                            i37 = this.albumNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 'E':
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UserProfile(str41, str57, str32, num2, str33, str34, str35, str36, str37, str38, str39, str40, l4, l5, str42, userInfo2, str43, str44, str45, i30, str46, str47, i31, str48, i32, i33, f2, str49, str50, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, i44, i45, str51, str52, str53, str54, i46, i47, i48, i49, i50, i51, i52, i53, str55, str56, i54, i55, j3, j4, i56, list3, str58, str59, i57, tips2, i58, str60, str61, str62, list2);
        }
    }
}
