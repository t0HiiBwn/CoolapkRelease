package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_User  reason: invalid class name */
abstract class C$AutoValue_User extends C$$AutoValue_User {
    C$AutoValue_User(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, UserInfo userInfo, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, String str18, String str19, long j, int i2, String str20) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, l2, l3, str10, userInfo, str11, str12, str13, str14, str15, str16, str17, i, str18, str19, j, i2, str20);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_User$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<User> {
        private final TypeAdapter<String> bioAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultBio = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultFans = null;
        private String defaultFollow = null;
        private String defaultId = null;
        private int defaultIsFollow = 0;
        private Long defaultLastUpdate = null;
        private int defaultLikeNum = 0;
        private long defaultLoginTime = 0;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultType = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> fansAdapter;
        private final TypeAdapter<String> followAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isFollowAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<Long> loginTimeAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> typeAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.typeAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.isFollowAdapter = gson.getAdapter(Integer.class);
            this.fansAdapter = gson.getAdapter(String.class);
            this.followAdapter = gson.getAdapter(String.class);
            this.loginTimeAdapter = gson.getAdapter(Long.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.bioAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultType(String str) {
            this.defaultType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFollow(int i) {
            this.defaultIsFollow = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFans(String str) {
            this.defaultFans = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollow(String str) {
            this.defaultFollow = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLoginTime(long j) {
            this.defaultLoginTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBio(String str) {
            this.defaultBio = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, User user) throws IOException {
            if (user == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, user.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, user.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, user.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, user.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, user.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, user.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, user.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, user.getLogo());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, user.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, user.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, user.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, user.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, user.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, user.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, user.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, user.getDisplayUserName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, user.getEntityType());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, user.getTitle());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, user.getSubTitle());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, user.getType());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, user.getUid());
            jsonWriter.name("isFollow");
            this.isFollowAdapter.write(jsonWriter, Integer.valueOf(user.getIsFollow()));
            jsonWriter.name("fans");
            this.fansAdapter.write(jsonWriter, user.getFans());
            jsonWriter.name("follow");
            this.followAdapter.write(jsonWriter, user.getFollow());
            jsonWriter.name("logintime");
            this.loginTimeAdapter.write(jsonWriter, Long.valueOf(user.getLoginTime()));
            jsonWriter.name("be_like_num");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(user.getLikeNum()));
            jsonWriter.name("bio");
            this.bioAdapter.write(jsonWriter, user.getBio());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public User read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultUrl;
            String str5 = this.defaultDescription;
            String str6 = this.defaultPic;
            String str7 = this.defaultLogo;
            String str8 = this.defaultId;
            String str9 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str10 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str11 = this.defaultDeprecatedUserName;
            String str12 = this.defaultDisplayUserName;
            String str13 = this.defaultEntityType;
            String str14 = this.defaultTitle;
            String str15 = this.defaultSubTitle;
            String str16 = this.defaultType;
            String str17 = this.defaultUid;
            int i = this.defaultIsFollow;
            String str18 = this.defaultFans;
            String str19 = this.defaultFollow;
            long j = this.defaultLoginTime;
            int i2 = this.defaultLikeNum;
            String str20 = this.defaultBio;
            String str21 = str3;
            Integer num2 = num;
            String str22 = str4;
            String str23 = str5;
            String str24 = str6;
            String str25 = str7;
            String str26 = str8;
            String str27 = str9;
            Long l4 = l2;
            Long l5 = l3;
            String str28 = str10;
            UserInfo userInfo2 = userInfo;
            String str29 = str;
            String str30 = str11;
            String str31 = str12;
            String str32 = str13;
            String str33 = str14;
            String str34 = str15;
            String str35 = str16;
            String str36 = str17;
            int i3 = i;
            String str37 = str18;
            String str38 = str2;
            String str39 = str19;
            long j2 = j;
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
                        case -1718327882:
                            if (nextName.equals("logintime")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1481955494:
                            if (nextName.equals("be_like_num")) {
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
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1268958287:
                            if (nextName.equals("follow")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -594924165:
                            if (nextName.equals("isFollow")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 97544:
                            if (nextName.equals("bio")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 3135424:
                            if (nextName.equals("fans")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 26;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str21 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str34 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str23 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            j2 = this.loginTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 4:
                            str38 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str32 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i2 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str31 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str39 = this.followAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str29 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            i3 = this.isFollowAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str30 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str27 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str26 = this.idAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str20 = this.bioAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str24 = this.picAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str36 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str22 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str37 = this.fansAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str25 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str35 = this.typeAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str33 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str28 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 25:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 26:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_User(str29, str38, str21, num2, str22, str23, str24, str25, str26, str27, l4, l5, str28, userInfo2, str30, str31, str32, str33, str34, str35, str36, i3, str37, str39, j2, i2, str20);
        }
    }
}
