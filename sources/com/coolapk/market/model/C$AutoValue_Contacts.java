package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Contacts  reason: invalid class name */
abstract class C$AutoValue_Contacts extends C$$AutoValue_Contacts {
    C$AutoValue_Contacts(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l2, Long l3, String str13, String str14, String str15, String str16, String str17, String str18, int i, String str19, UserInfo userInfo, UserInfo userInfo2) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, l2, l3, str13, str14, str15, str16, str17, str18, i, str19, userInfo, userInfo2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Contacts$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Contacts> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDeprecatedFollowUserName = null;
        private String defaultDeprecatedFollowerUserAvatar = null;
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
        private String defaultFollowUid = null;
        private UserInfo defaultFollowerUserInfo = null;
        private String defaultId = null;
        private int defaultIsFriend = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedFollowUserNameAdapter;
        private final TypeAdapter<String> deprecatedFollowerUserAvatarAdapter;
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
        private final TypeAdapter<String> followUidAdapter;
        private final TypeAdapter<UserInfo> followerUserInfoAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isFriendAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
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
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.followUidAdapter = gson.getAdapter(String.class);
            this.deprecatedFollowUserNameAdapter = gson.getAdapter(String.class);
            this.isFriendAdapter = gson.getAdapter(Integer.class);
            this.deprecatedFollowerUserAvatarAdapter = gson.getAdapter(String.class);
            this.followerUserInfoAdapter = gson.getAdapter(UserInfo.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
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

        public GsonTypeAdapter setDefaultFollowUid(String str) {
            this.defaultFollowUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedFollowUserName(String str) {
            this.defaultDeprecatedFollowUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsFriend(int i) {
            this.defaultIsFriend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedFollowerUserAvatar(String str) {
            this.defaultDeprecatedFollowerUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowerUserInfo(UserInfo userInfo) {
            this.defaultFollowerUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(UserInfo userInfo) {
            this.defaultUserInfo = userInfo;
            return this;
        }

        public void write(JsonWriter jsonWriter, Contacts contacts) throws IOException {
            if (contacts == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, contacts.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, contacts.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, contacts.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, contacts.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, contacts.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, contacts.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, contacts.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, contacts.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, contacts.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, contacts.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, contacts.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, contacts.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, contacts.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, contacts.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, contacts.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, contacts.getDeprecatedUserAvatar());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, contacts.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, contacts.getDisplayUserName());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, contacts.getUid());
            jsonWriter.name("fuid");
            this.followUidAdapter.write(jsonWriter, contacts.getFollowUid());
            jsonWriter.name("fusername");
            this.deprecatedFollowUserNameAdapter.write(jsonWriter, contacts.getDeprecatedFollowUserName());
            jsonWriter.name("isfriend");
            this.isFriendAdapter.write(jsonWriter, Integer.valueOf(contacts.getIsFriend()));
            jsonWriter.name("fUserAvatar");
            this.deprecatedFollowerUserAvatarAdapter.write(jsonWriter, contacts.getDeprecatedFollowerUserAvatar());
            jsonWriter.name("fUserInfo");
            this.followerUserInfoAdapter.write(jsonWriter, contacts.getFollowerUserInfo());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, contacts.getUserInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Contacts read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityType;
            String str3 = this.defaultEntityTemplate;
            String str4 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str5 = this.defaultTitle;
            String str6 = this.defaultUrl;
            String str7 = this.defaultDescription;
            String str8 = this.defaultPic;
            String str9 = this.defaultLogo;
            String str10 = this.defaultSubTitle;
            String str11 = this.defaultId;
            String str12 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str13 = this.defaultDeprecatedUserAvatar;
            String str14 = this.defaultDeprecatedUserName;
            String str15 = this.defaultDisplayUserName;
            String str16 = this.defaultUid;
            String str17 = this.defaultFollowUid;
            String str18 = this.defaultDeprecatedFollowUserName;
            int i = this.defaultIsFriend;
            String str19 = this.defaultDeprecatedFollowerUserAvatar;
            UserInfo userInfo = this.defaultFollowerUserInfo;
            UserInfo userInfo2 = this.defaultUserInfo;
            String str20 = str2;
            String str21 = str3;
            String str22 = str4;
            Integer num2 = num;
            String str23 = str5;
            String str24 = str6;
            String str25 = str7;
            String str26 = str8;
            String str27 = str9;
            String str28 = str10;
            String str29 = str11;
            String str30 = str12;
            Long l4 = l2;
            String str31 = str;
            Long l5 = l3;
            String str32 = str13;
            String str33 = str14;
            String str34 = str15;
            String str35 = str16;
            String str36 = str17;
            String str37 = str18;
            int i2 = i;
            String str38 = str19;
            UserInfo userInfo3 = userInfo;
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
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3154474:
                            if (nextName.equals("fuid")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 57525052:
                            if (nextName.equals("fusername")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 121079199:
                            if (nextName.equals("fUserInfo")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 171207178:
                            if (nextName.equals("fUserAvatar")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 323883080:
                            if (nextName.equals("isfriend")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 24;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str22 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str28 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str25 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str21 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str20 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str34 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str31 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str33 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str30 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str29 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str26 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str35 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str24 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str36 = this.followUidAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str27 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str37 = this.deprecatedFollowUserNameAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str23 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 19:
                            userInfo3 = this.followerUserInfoAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str38 = this.deprecatedFollowerUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 21:
                            i2 = this.isFriendAdapter.read(jsonReader).intValue();
                            continue;
                        case 22:
                            str32 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 23:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 24:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Contacts(str31, str20, str21, str22, num2, str23, str24, str25, str26, str27, str28, str29, str30, l4, l5, str32, str33, str34, str35, str36, str37, i2, str38, userInfo3, userInfo2);
        }
    }
}
