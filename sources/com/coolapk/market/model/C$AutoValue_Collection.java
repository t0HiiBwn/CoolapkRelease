package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Collection  reason: invalid class name */
abstract class C$AutoValue_Collection extends C$$AutoValue_Collection {
    C$AutoValue_Collection(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo, String str9, String str10, String str11, String str12, String str13, String str14, int i, int i2, String str15, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str16, int i11, Long l4, UserAction userAction, String str17) {
        super(str, str2, str3, num, str4, str5, str6, str7, l2, l3, str8, userInfo, str9, str10, str11, str12, str13, str14, i, i2, str15, i3, i4, i5, i6, i7, i8, i9, i10, str16, i11, l4, userAction, str17);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Collection$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Collection> {
        private final TypeAdapter<Integer> apkNumAdapter;
        private final TypeAdapter<Integer> copyNumAdapter;
        private final TypeAdapter<String> coverPicAdapter;
        private final TypeAdapter<Long> createdateAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultApkNum = 0;
        private final TypeAdapter<Integer> defaultCollectedAdapter;
        private int defaultCopyNum = 0;
        private String defaultCoverPic = null;
        private Long defaultCreatedate = null;
        private Long defaultDateline = null;
        private int defaultDefaultCollected = 0;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFeedNum = 0;
        private int defaultFollowNum = 0;
        private String defaultId = null;
        private int defaultIsBeCollected = 0;
        private int defaultIsOpen = 0;
        private int defaultItemNum = 0;
        private Long defaultLastUpdate = null;
        private int defaultLikeNum = 0;
        private String defaultLogo = null;
        private String defaultPic = null;
        private int defaultReplyNum = 0;
        private int defaultShareNum = 0;
        private String defaultSourceId = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
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
        private final TypeAdapter<Integer> feedNumAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isBeCollectedAdapter;
        private final TypeAdapter<Integer> isOpenAdapter;
        private final TypeAdapter<Integer> itemNumAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> replyNumAdapter;
        private final TypeAdapter<Integer> shareNumAdapter;
        private final TypeAdapter<String> sourceIdAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.isBeCollectedAdapter = gson.getAdapter(Integer.class);
            this.defaultCollectedAdapter = gson.getAdapter(Integer.class);
            this.sourceIdAdapter = gson.getAdapter(String.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.copyNumAdapter = gson.getAdapter(Integer.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.feedNumAdapter = gson.getAdapter(Integer.class);
            this.apkNumAdapter = gson.getAdapter(Integer.class);
            this.shareNumAdapter = gson.getAdapter(Integer.class);
            this.itemNumAdapter = gson.getAdapter(Integer.class);
            this.coverPicAdapter = gson.getAdapter(String.class);
            this.isOpenAdapter = gson.getAdapter(Integer.class);
            this.createdateAdapter = gson.getAdapter(Long.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
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

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsBeCollected(int i) {
            this.defaultIsBeCollected = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDefaultCollected(int i) {
            this.defaultDefaultCollected = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSourceId(String str) {
            this.defaultSourceId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCopyNum(int i) {
            this.defaultCopyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultReplyNum(int i) {
            this.defaultReplyNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedNum(int i) {
            this.defaultFeedNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkNum(int i) {
            this.defaultApkNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShareNum(int i) {
            this.defaultShareNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultItemNum(int i) {
            this.defaultItemNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCoverPic(String str) {
            this.defaultCoverPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsOpen(int i) {
            this.defaultIsOpen = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreatedate(Long l2) {
            this.defaultCreatedate = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, Collection collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, collection.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, collection.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, collection.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, collection.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, collection.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, collection.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, collection.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, collection.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, collection.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, collection.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, collection.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, collection.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, collection.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, collection.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, collection.getId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, collection.getTitle());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, collection.getLogo());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, collection.getUid());
            jsonWriter.name("isBeCollected");
            this.isBeCollectedAdapter.write(jsonWriter, Integer.valueOf(collection.getIsBeCollected()));
            jsonWriter.name("defaultCollected");
            this.defaultCollectedAdapter.write(jsonWriter, Integer.valueOf(collection.getDefaultCollected()));
            jsonWriter.name("source_id");
            this.sourceIdAdapter.write(jsonWriter, collection.getSourceId());
            jsonWriter.name("follow_num");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(collection.getFollowNum()));
            jsonWriter.name("copy_num");
            this.copyNumAdapter.write(jsonWriter, Integer.valueOf(collection.getCopyNum()));
            jsonWriter.name("reply_num");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(collection.getReplyNum()));
            jsonWriter.name("like_num");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(collection.getLikeNum()));
            jsonWriter.name("feed_num");
            this.feedNumAdapter.write(jsonWriter, Integer.valueOf(collection.getFeedNum()));
            jsonWriter.name("apk_num");
            this.apkNumAdapter.write(jsonWriter, Integer.valueOf(collection.getApkNum()));
            jsonWriter.name("share_num");
            this.shareNumAdapter.write(jsonWriter, Integer.valueOf(collection.getShareNum()));
            jsonWriter.name("item_num");
            this.itemNumAdapter.write(jsonWriter, Integer.valueOf(collection.getItemNum()));
            jsonWriter.name("cover_pic");
            this.coverPicAdapter.write(jsonWriter, collection.getCoverPic());
            jsonWriter.name("is_open");
            this.isOpenAdapter.write(jsonWriter, Integer.valueOf(collection.getIsOpen()));
            jsonWriter.name("createdate");
            this.createdateAdapter.write(jsonWriter, collection.getCreatedate());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, collection.getUserAction());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, collection.getDescription());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Collection read(JsonReader jsonReader) throws IOException {
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
            String str5 = this.defaultPic;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str8 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str9 = this.defaultDeprecatedUserName;
            String str10 = this.defaultDisplayUserName;
            String str11 = this.defaultId;
            String str12 = this.defaultTitle;
            String str13 = this.defaultLogo;
            String str14 = this.defaultUid;
            int i = this.defaultIsBeCollected;
            int i2 = this.defaultDefaultCollected;
            String str15 = this.defaultSourceId;
            int i3 = this.defaultFollowNum;
            int i4 = this.defaultCopyNum;
            int i5 = this.defaultReplyNum;
            int i6 = this.defaultLikeNum;
            int i7 = this.defaultFeedNum;
            int i8 = this.defaultApkNum;
            int i9 = this.defaultShareNum;
            int i10 = this.defaultItemNum;
            String str16 = this.defaultCoverPic;
            int i11 = this.defaultIsOpen;
            Long l4 = this.defaultCreatedate;
            UserAction userAction = this.defaultUserAction;
            String str17 = this.defaultDescription;
            String str18 = str2;
            String str19 = str3;
            Integer num2 = num;
            String str20 = str4;
            String str21 = str5;
            String str22 = str6;
            String str23 = str7;
            Long l5 = l2;
            Long l6 = l3;
            String str24 = str8;
            UserInfo userInfo2 = userInfo;
            String str25 = str9;
            String str26 = str10;
            String str27 = str;
            String str28 = str11;
            String str29 = str12;
            String str30 = str13;
            String str31 = str14;
            int i12 = i;
            int i13 = i2;
            String str32 = str15;
            int i14 = i3;
            int i15 = i4;
            int i16 = i5;
            int i17 = i6;
            int i18 = i7;
            int i19 = i8;
            int i20 = i9;
            int i21 = i10;
            String str33 = str16;
            int i22 = i11;
            Long l7 = l4;
            UserAction userAction2 = userAction;
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
                        case -2026711560:
                            if (nextName.equals("follow_num")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1698410561:
                            if (nextName.equals("source_id")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1581702362:
                            if (nextName.equals("share_num")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
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
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -798234909:
                            if (nextName.equals("apk_num")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -600273400:
                            if (nextName.equals("defaultCollected")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -505624644:
                            if (nextName.equals("copy_num")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -433362767:
                            if (nextName.equals("reply_num")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -198142276:
                            if (nextName.equals("isBeCollected")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -191577755:
                            if (nextName.equals("feed_num")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
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
                        case 1103095518:
                            if (nextName.equals("like_num")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 1177850970:
                            if (nextName.equals("item_num")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 1369682602:
                            if (nextName.equals("createdate")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 1980072194:
                            if (nextName.equals("cover_pic")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 2082110527:
                            if (nextName.equals("is_open")) {
                                c = '!';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str19 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str22 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i14 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str17 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str32 = this.sourceIdAdapter.read(jsonReader);
                            continue;
                        case 5:
                            i20 = this.shareNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            str18 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str26 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            l6 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str27 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i19 = this.apkNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            i13 = this.defaultCollectedAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            i15 = this.copyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            i16 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 14:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str25 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str23 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 17:
                            i12 = this.isBeCollectedAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            i18 = this.feedNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            str28 = this.idAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str21 = this.picAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str31 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str20 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str30 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str29 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 25:
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str24 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 27:
                            i17 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 28:
                            i21 = this.itemNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 29:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 30:
                            l7 = this.createdateAdapter.read(jsonReader);
                            continue;
                        case 31:
                            l5 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str33 = this.coverPicAdapter.read(jsonReader);
                            continue;
                        case '!':
                            i22 = this.isOpenAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Collection(str27, str18, str19, num2, str20, str21, str22, str23, l5, l6, str24, userInfo2, str25, str26, str28, str29, str30, str31, i12, i13, str32, i14, i15, i16, i17, i18, i19, i20, i21, str33, i22, l7, userAction2, str17);
        }
    }
}
