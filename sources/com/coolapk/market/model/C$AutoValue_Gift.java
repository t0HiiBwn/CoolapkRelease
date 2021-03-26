package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Gift  reason: invalid class name */
abstract class C$AutoValue_Gift extends C$$AutoValue_Gift {
    C$AutoValue_Gift(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, UserInfo userInfo, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, int i2, String str28, String str29, String str30, String str31, String str32, String str33, String str34, int i3, String str35, String str36, Integer num2, Integer num3, Integer num4, String str37) {
        super(str, str2, str3, i, str4, num, str5, str6, str7, str8, l, l2, str9, userInfo, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, i2, str28, str29, str30, str31, str32, str33, str34, i3, str35, str36, num2, num3, num4, str37);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Gift$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Gift> {
        private final TypeAdapter<String> apkIdAdapter;
        private final TypeAdapter<String> apkLogoAdapter;
        private final TypeAdapter<String> apkNameAdapter;
        private final TypeAdapter<String> apkTitleAdapter;
        private final TypeAdapter<String> authorAdapter;
        private final TypeAdapter<String> contentAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultApkId = null;
        private String defaultApkLogo = null;
        private String defaultApkName = null;
        private String defaultApkTitle = null;
        private String defaultAuthor = null;
        private String defaultContent = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraAnalysisData = null;
        private String defaultExtraData = null;
        private String defaultFeedId = null;
        private Integer defaultGet = null;
        private String defaultGiftCard = null;
        private String defaultGiftData = null;
        private int defaultGiftExpires = 0;
        private String defaultGiftIntro = null;
        private String defaultGiftUseable = null;
        private String defaultGiftUsed = null;
        private String defaultId = null;
        private String defaultLabel = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultParentId = null;
        private String defaultPic = null;
        private String defaultPieId = null;
        private String defaultPieName = null;
        private String defaultRelatedPackages = null;
        private Integer defaultRequireInstalled = null;
        private Integer defaultStatus = null;
        private String defaultSubTitle = null;
        private String defaultTags = null;
        private String defaultTitle = null;
        private String defaultTotalCount = null;
        private int defaultType = 0;
        private String defaultUid = null;
        private String defaultUrl = null;
        private String defaultUseCount = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraAnalysisDataAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<Integer> getAdapter;
        private final TypeAdapter<String> giftCardAdapter;
        private final TypeAdapter<String> giftDataAdapter;
        private final TypeAdapter<Integer> giftExpiresAdapter;
        private final TypeAdapter<String> giftIntroAdapter;
        private final TypeAdapter<String> giftUseableAdapter;
        private final TypeAdapter<String> giftUsedAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> labelAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> parentIdAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> pieIdAdapter;
        private final TypeAdapter<String> pieNameAdapter;
        private final TypeAdapter<String> relatedPackagesAdapter;
        private final TypeAdapter<Integer> requireInstalledAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> tagsAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> totalCountAdapter;
        private final TypeAdapter<Integer> typeAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> useCountAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityTypeIdAdapter = gson.getAdapter(Integer.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.useCountAdapter = gson.getAdapter(String.class);
            this.totalCountAdapter = gson.getAdapter(String.class);
            this.giftDataAdapter = gson.getAdapter(String.class);
            this.giftCardAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.parentIdAdapter = gson.getAdapter(String.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.apkIdAdapter = gson.getAdapter(String.class);
            this.apkNameAdapter = gson.getAdapter(String.class);
            this.apkTitleAdapter = gson.getAdapter(String.class);
            this.apkLogoAdapter = gson.getAdapter(String.class);
            this.pieIdAdapter = gson.getAdapter(String.class);
            this.pieNameAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.authorAdapter = gson.getAdapter(String.class);
            this.typeAdapter = gson.getAdapter(Integer.class);
            this.labelAdapter = gson.getAdapter(String.class);
            this.tagsAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.contentAdapter = gson.getAdapter(String.class);
            this.relatedPackagesAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.giftUseableAdapter = gson.getAdapter(String.class);
            this.giftExpiresAdapter = gson.getAdapter(Integer.class);
            this.giftIntroAdapter = gson.getAdapter(String.class);
            this.giftUsedAdapter = gson.getAdapter(String.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.requireInstalledAdapter = gson.getAdapter(Integer.class);
            this.getAdapter = gson.getAdapter(Integer.class);
            this.extraAnalysisDataAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTemplate(String str) {
            this.defaultEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTypeId(int i) {
            this.defaultEntityTypeId = i;
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

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
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

        public GsonTypeAdapter setDefaultDateline(Long l) {
            this.defaultDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l) {
            this.defaultLastUpdate = l;
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

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUseCount(String str) {
            this.defaultUseCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTotalCount(String str) {
            this.defaultTotalCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftData(String str) {
            this.defaultGiftData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftCard(String str) {
            this.defaultGiftCard = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultParentId(String str) {
            this.defaultParentId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkId(String str) {
            this.defaultApkId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkName(String str) {
            this.defaultApkName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkTitle(String str) {
            this.defaultApkTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkLogo(String str) {
            this.defaultApkLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPieId(String str) {
            this.defaultPieId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPieName(String str) {
            this.defaultPieName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAuthor(String str) {
            this.defaultAuthor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultType(int i) {
            this.defaultType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLabel(String str) {
            this.defaultLabel = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTags(String str) {
            this.defaultTags = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultContent(String str) {
            this.defaultContent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRelatedPackages(String str) {
            this.defaultRelatedPackages = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraData(String str) {
            this.defaultExtraData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftUseable(String str) {
            this.defaultGiftUseable = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftExpires(int i) {
            this.defaultGiftExpires = i;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftIntro(String str) {
            this.defaultGiftIntro = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGiftUsed(String str) {
            this.defaultGiftUsed = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(Integer num) {
            this.defaultStatus = num;
            return this;
        }

        public GsonTypeAdapter setDefaultRequireInstalled(Integer num) {
            this.defaultRequireInstalled = num;
            return this;
        }

        public GsonTypeAdapter setDefaultGet(Integer num) {
            this.defaultGet = num;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraAnalysisData(String str) {
            this.defaultExtraAnalysisData = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, Gift gift) throws IOException {
            if (gift == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, gift.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, gift.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, gift.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(gift.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, gift.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, gift.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, gift.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, gift.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, gift.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, gift.getSubTitle());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, gift.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, gift.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, gift.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, gift.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, gift.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, gift.getDisplayUserName());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, gift.getTitle());
            jsonWriter.name("useCount");
            this.useCountAdapter.write(jsonWriter, gift.getUseCount());
            jsonWriter.name("totalCount");
            this.totalCountAdapter.write(jsonWriter, gift.getTotalCount());
            jsonWriter.name("gift_data");
            this.giftDataAdapter.write(jsonWriter, gift.getGiftData());
            jsonWriter.name("gift_card");
            this.giftCardAdapter.write(jsonWriter, gift.getGiftCard());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, gift.getId());
            jsonWriter.name("parent_id");
            this.parentIdAdapter.write(jsonWriter, gift.getParentId());
            jsonWriter.name("feed_id");
            this.feedIdAdapter.write(jsonWriter, gift.getFeedId());
            jsonWriter.name("apk_id");
            this.apkIdAdapter.write(jsonWriter, gift.getApkId());
            jsonWriter.name("apk_name");
            this.apkNameAdapter.write(jsonWriter, gift.getApkName());
            jsonWriter.name("apk_title");
            this.apkTitleAdapter.write(jsonWriter, gift.getApkTitle());
            jsonWriter.name("apk_logo");
            this.apkLogoAdapter.write(jsonWriter, gift.getApkLogo());
            jsonWriter.name("pie_id");
            this.pieIdAdapter.write(jsonWriter, gift.getPieId());
            jsonWriter.name("pieName");
            this.pieNameAdapter.write(jsonWriter, gift.getPieName());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, gift.getUid());
            jsonWriter.name("author");
            this.authorAdapter.write(jsonWriter, gift.getAuthor());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, Integer.valueOf(gift.getType()));
            jsonWriter.name("label");
            this.labelAdapter.write(jsonWriter, gift.getLabel());
            jsonWriter.name("tags");
            this.tagsAdapter.write(jsonWriter, gift.getTags());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, gift.getDescription());
            jsonWriter.name("content");
            this.contentAdapter.write(jsonWriter, gift.getContent());
            jsonWriter.name("relatedPackages");
            this.relatedPackagesAdapter.write(jsonWriter, gift.getRelatedPackages());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, gift.getExtraData());
            jsonWriter.name("giftUseable");
            this.giftUseableAdapter.write(jsonWriter, gift.getGiftUseable());
            jsonWriter.name("giftExpires");
            this.giftExpiresAdapter.write(jsonWriter, Integer.valueOf(gift.getGiftExpires()));
            jsonWriter.name("giftIntro");
            this.giftIntroAdapter.write(jsonWriter, gift.getGiftIntro());
            jsonWriter.name("giftUsed");
            this.giftUsedAdapter.write(jsonWriter, gift.getGiftUsed());
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, gift.getStatus());
            jsonWriter.name("is_require_installed");
            this.requireInstalledAdapter.write(jsonWriter, gift.getRequireInstalled());
            jsonWriter.name("isGet");
            this.getAdapter.write(jsonWriter, gift.getGet());
            jsonWriter.name("extraAnalysisData");
            this.extraAnalysisDataAdapter.write(jsonWriter, gift.getExtraAnalysisData());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Gift read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityType;
            String str3 = this.defaultEntityTemplate;
            int i = this.defaultEntityTypeId;
            String str4 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str5 = this.defaultUrl;
            String str6 = this.defaultPic;
            String str7 = this.defaultLogo;
            String str8 = this.defaultSubTitle;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str9 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str10 = this.defaultDeprecatedUserName;
            String str11 = this.defaultDisplayUserName;
            String str12 = this.defaultTitle;
            String str13 = this.defaultUseCount;
            String str14 = this.defaultTotalCount;
            String str15 = this.defaultGiftData;
            String str16 = this.defaultGiftCard;
            String str17 = this.defaultId;
            String str18 = this.defaultParentId;
            String str19 = this.defaultFeedId;
            String str20 = this.defaultApkId;
            String str21 = this.defaultApkName;
            String str22 = this.defaultApkTitle;
            String str23 = this.defaultApkLogo;
            String str24 = this.defaultPieId;
            String str25 = this.defaultPieName;
            String str26 = this.defaultUid;
            String str27 = this.defaultAuthor;
            int i2 = this.defaultType;
            String str28 = this.defaultLabel;
            String str29 = this.defaultTags;
            String str30 = this.defaultDescription;
            String str31 = this.defaultContent;
            String str32 = this.defaultRelatedPackages;
            String str33 = this.defaultExtraData;
            String str34 = this.defaultGiftUseable;
            int i3 = this.defaultGiftExpires;
            String str35 = this.defaultGiftIntro;
            String str36 = this.defaultGiftUsed;
            Integer num2 = this.defaultStatus;
            Integer num3 = this.defaultRequireInstalled;
            Integer num4 = this.defaultGet;
            String str37 = this.defaultExtraAnalysisData;
            String str38 = str2;
            String str39 = str3;
            int i4 = i;
            String str40 = str4;
            Integer num5 = num;
            String str41 = str5;
            String str42 = str6;
            String str43 = str7;
            String str44 = str8;
            Long l3 = l;
            Long l4 = l2;
            String str45 = str9;
            UserInfo userInfo2 = userInfo;
            String str46 = str;
            String str47 = str10;
            String str48 = str11;
            String str49 = str12;
            String str50 = str13;
            String str51 = str14;
            String str52 = str15;
            String str53 = str16;
            String str54 = str17;
            String str55 = str18;
            String str56 = str19;
            String str57 = str20;
            String str58 = str21;
            String str59 = str22;
            String str60 = str23;
            String str61 = str24;
            String str62 = str25;
            String str63 = str26;
            String str64 = str27;
            int i5 = i2;
            String str65 = str28;
            String str66 = str29;
            String str67 = str30;
            String str68 = str31;
            String str69 = str32;
            String str70 = str33;
            String str71 = str34;
            int i6 = i3;
            String str72 = str35;
            String str73 = str36;
            Integer num6 = num2;
            Integer num7 = num3;
            Integer num8 = num4;
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
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1713653743:
                            if (nextName.equals("giftUseable")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1648494024:
                            if (nextName.equals("relatedPackages")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1411223010:
                            if (nextName.equals("apk_id")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1406328437:
                            if (nextName.equals("author")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -988429138:
                            if (nextName.equals("pie_id")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -976011428:
                            if (nextName.equals("feed_id")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -846841525:
                            if (nextName.equals("is_require_installed")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -731385813:
                            if (nextName.equals("totalCount")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -590800682:
                            if (nextName.equals("extraAnalysisData")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -577045961:
                            if (nextName.equals("pieName")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -309069880:
                            if (nextName.equals("useCount")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 3552281:
                            if (nextName.equals("tags")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 100467148:
                            if (nextName.equals("isGet")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 102727412:
                            if (nextName.equals("label")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 550128412:
                            if (nextName.equals("giftIntro")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 570099903:
                            if (nextName.equals("gift_card")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 570129753:
                            if (nextName.equals("gift_data")) {
                                c = '#';
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 849391885:
                            if (nextName.equals("giftUsed")) {
                                c = '%';
                                break;
                            }
                            break;
                        case 951530617:
                            if (nextName.equals("content")) {
                                c = '&';
                                break;
                            }
                            break;
                        case 1024456174:
                            if (nextName.equals("apk_logo")) {
                                c = '\'';
                                break;
                            }
                            break;
                        case 1024502478:
                            if (nextName.equals("apk_name")) {
                                c = '(';
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = ')';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '*';
                                break;
                            }
                            break;
                        case 1419714532:
                            if (nextName.equals("giftExpires")) {
                                c = '+';
                                break;
                            }
                            break;
                        case 1700592245:
                            if (nextName.equals("apk_title")) {
                                c = ',';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '-';
                                break;
                            }
                            break;
                        case 2070327504:
                            if (nextName.equals("parent_id")) {
                                c = '.';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str40 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str44 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str67 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str71 = this.giftUseableAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str69 = this.relatedPackagesAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str39 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str38 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str48 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str57 = this.apkIdAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str64 = this.authorAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str61 = this.pieIdAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str56 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str46 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 14:
                            num6 = this.statusAdapter.read(jsonReader);
                            continue;
                        case 15:
                            num7 = this.requireInstalledAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str51 = this.totalCountAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str37 = this.extraAnalysisDataAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str62 = this.pieNameAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str50 = this.useCountAdapter.read(jsonReader);
                            continue;
                        case 20:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str47 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str70 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str54 = this.idAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str42 = this.picAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str63 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str41 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str43 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str66 = this.tagsAdapter.read(jsonReader);
                            continue;
                        case 29:
                            i5 = this.typeAdapter.read(jsonReader).intValue();
                            continue;
                        case 30:
                            num8 = this.getAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str65 = this.labelAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str49 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '!':
                            str72 = this.giftIntroAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            str53 = this.giftCardAdapter.read(jsonReader);
                            continue;
                        case '#':
                            str52 = this.giftDataAdapter.read(jsonReader);
                            continue;
                        case '$':
                            i4 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case '%':
                            str73 = this.giftUsedAdapter.read(jsonReader);
                            continue;
                        case '&':
                            str68 = this.contentAdapter.read(jsonReader);
                            continue;
                        case '\'':
                            str60 = this.apkLogoAdapter.read(jsonReader);
                            continue;
                        case '(':
                            str58 = this.apkNameAdapter.read(jsonReader);
                            continue;
                        case ')':
                            str45 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '*':
                            num5 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '+':
                            i6 = this.giftExpiresAdapter.read(jsonReader).intValue();
                            continue;
                        case ',':
                            str59 = this.apkTitleAdapter.read(jsonReader);
                            continue;
                        case '-':
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case '.':
                            str55 = this.parentIdAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Gift(str46, str38, str39, i4, str40, num5, str41, str42, str43, str44, l3, l4, str45, userInfo2, str47, str48, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, str61, str62, str63, str64, i5, str65, str66, str67, str68, str69, str70, str71, i6, str72, str73, num6, num7, num8, str37);
        }
    }
}
