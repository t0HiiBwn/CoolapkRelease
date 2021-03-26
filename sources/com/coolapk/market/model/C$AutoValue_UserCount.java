package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_UserCount  reason: invalid class name */
abstract class C$AutoValue_UserCount extends C$$AutoValue_UserCount {
    C$AutoValue_UserCount(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, UserInfo userInfo, String str13, String str14, String str15, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l2, l3, str12, userInfo, str13, str14, str15, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_UserCount$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<UserCount> {
        private final TypeAdapter<Integer> atMeCountAdapter;
        private final TypeAdapter<Integer> atMeInCommentCountAdapter;
        private final TypeAdapter<Integer> badgeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultAtMeCount = 0;
        private int defaultAtMeInCommentCount = 0;
        private int defaultBadge = 0;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFans = 0;
        private int defaultFeed = 0;
        private int defaultFollow = 0;
        private int defaultFollowApp = 0;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private int defaultMessage = 0;
        private int defaultNotification = 0;
        private String defaultPic = null;
        private int defaultReplyMeCount = 0;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
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
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> fansAdapter;
        private final TypeAdapter<Integer> feedAdapter;
        private final TypeAdapter<Integer> followAdapter;
        private final TypeAdapter<Integer> followAppAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<Integer> messageAdapter;
        private final TypeAdapter<Integer> notificationAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> replyMeCountAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

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
            this.followAppAdapter = gson.getAdapter(Integer.class);
            this.feedAdapter = gson.getAdapter(Integer.class);
            this.followAdapter = gson.getAdapter(Integer.class);
            this.fansAdapter = gson.getAdapter(Integer.class);
            this.notificationAdapter = gson.getAdapter(Integer.class);
            this.messageAdapter = gson.getAdapter(Integer.class);
            this.atMeCountAdapter = gson.getAdapter(Integer.class);
            this.atMeInCommentCountAdapter = gson.getAdapter(Integer.class);
            this.replyMeCountAdapter = gson.getAdapter(Integer.class);
            this.badgeAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultFollowApp(int i) {
            this.defaultFollowApp = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeed(int i) {
            this.defaultFeed = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFollow(int i) {
            this.defaultFollow = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFans(int i) {
            this.defaultFans = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNotification(int i) {
            this.defaultNotification = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(int i) {
            this.defaultMessage = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAtMeCount(int i) {
            this.defaultAtMeCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAtMeInCommentCount(int i) {
            this.defaultAtMeInCommentCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyMeCount(int i) {
            this.defaultReplyMeCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBadge(int i) {
            this.defaultBadge = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, UserCount userCount) throws IOException {
            if (userCount == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, userCount.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, userCount.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, userCount.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, userCount.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, userCount.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, userCount.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, userCount.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, userCount.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, userCount.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, userCount.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, userCount.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, userCount.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, userCount.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, userCount.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, userCount.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, userCount.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, userCount.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, userCount.getDisplayUserName());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, userCount.getUid());
            jsonWriter.name("count2");
            this.followAppAdapter.write(jsonWriter, Integer.valueOf(userCount.getFollowApp()));
            jsonWriter.name("feed");
            this.feedAdapter.write(jsonWriter, Integer.valueOf(userCount.getFeed()));
            jsonWriter.name("follow");
            this.followAdapter.write(jsonWriter, Integer.valueOf(userCount.getFollow()));
            jsonWriter.name("fans");
            this.fansAdapter.write(jsonWriter, Integer.valueOf(userCount.getFans()));
            jsonWriter.name("notification");
            this.notificationAdapter.write(jsonWriter, Integer.valueOf(userCount.getNotification()));
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, Integer.valueOf(userCount.getMessage()));
            jsonWriter.name("atme");
            this.atMeCountAdapter.write(jsonWriter, Integer.valueOf(userCount.getAtMeCount()));
            jsonWriter.name("atcommentme");
            this.atMeInCommentCountAdapter.write(jsonWriter, Integer.valueOf(userCount.getAtMeInCommentCount()));
            jsonWriter.name("commentme");
            this.replyMeCountAdapter.write(jsonWriter, Integer.valueOf(userCount.getReplyMeCount()));
            jsonWriter.name("badge");
            this.badgeAdapter.write(jsonWriter, Integer.valueOf(userCount.getBadge()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UserCount read(JsonReader jsonReader) throws IOException {
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
            int i = this.defaultFollowApp;
            int i2 = this.defaultFeed;
            int i3 = this.defaultFollow;
            int i4 = this.defaultFans;
            int i5 = this.defaultNotification;
            int i6 = this.defaultMessage;
            int i7 = this.defaultAtMeCount;
            int i8 = this.defaultAtMeInCommentCount;
            int i9 = this.defaultReplyMeCount;
            int i10 = this.defaultBadge;
            String str16 = str2;
            String str17 = str3;
            Integer num2 = num;
            String str18 = str4;
            String str19 = str5;
            String str20 = str6;
            String str21 = str7;
            String str22 = str8;
            String str23 = str9;
            String str24 = str10;
            String str25 = str11;
            Long l4 = l2;
            Long l5 = l3;
            String str26 = str;
            String str27 = str12;
            UserInfo userInfo2 = userInfo;
            String str28 = str13;
            String str29 = str14;
            String str30 = str15;
            int i11 = i;
            int i12 = i2;
            int i13 = i3;
            int i14 = i4;
            int i15 = i5;
            int i16 = i6;
            int i17 = i7;
            int i18 = i8;
            int i19 = i9;
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
                        case -1495015369:
                            if (nextName.equals("commentme")) {
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
                        case -1354575613:
                            if (nextName.equals("count2")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1268958287:
                            if (nextName.equals("follow")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1026368156:
                            if (nextName.equals("atcommentme")) {
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
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 3004683:
                            if (nextName.equals("atme")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 3135424:
                            if (nextName.equals("fans")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 3138974:
                            if (nextName.equals("feed")) {
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
                        case 93494179:
                            if (nextName.equals("badge")) {
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
                        case 595233003:
                            if (nextName.equals("notification")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 28;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str17 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str23 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str20 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str16 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i19 = this.replyMeCountAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str29 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i11 = this.followAppAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            i13 = this.followAdapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            i18 = this.atMeInCommentCountAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            str26 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str28 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str25 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str24 = this.idAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str21 = this.picAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str30 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str19 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 18:
                            i17 = this.atMeCountAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            i14 = this.fansAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            i12 = this.feedAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            str22 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i10 = this.badgeAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            str18 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 24:
                            i15 = this.notificationAdapter.read(jsonReader).intValue();
                            continue;
                        case 25:
                            i16 = this.messageAdapter.read(jsonReader).intValue();
                            continue;
                        case 26:
                            str27 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 27:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 28:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UserCount(str26, str16, str17, num2, str18, str19, str20, str21, str22, str23, str24, str25, l4, l5, str27, userInfo2, str28, str29, str30, i11, i12, i13, i14, i15, i16, i17, i18, i19, i10);
        }
    }
}
