package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FunThings  reason: invalid class name */
abstract class C$AutoValue_FunThings extends C$$AutoValue_FunThings {
    C$AutoValue_FunThings(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, UserInfo userInfo, String str10, String str11, String str12, String str13, String str14, String str15, int i, String str16, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str17, int i9, int i10, Long l3, UserAction userAction, String str18) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, l, l2, str9, userInfo, str10, str11, str12, str13, str14, str15, i, str16, i2, i3, i4, i5, i6, i7, i8, str17, i9, i10, l3, userAction, str18);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FunThings$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FunThings> {
        private final TypeAdapter<Integer> copyNumAdapter;
        private final TypeAdapter<String> coverPicAdapter;
        private final TypeAdapter<Long> createdateAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultCopyNum = 0;
        private String defaultCoverPic = null;
        private Long defaultCreatedate = null;
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
        private int defaultFavNum = 0;
        private int defaultFollowNum = 0;
        private String defaultId = null;
        private int defaultIsAdded = 0;
        private int defaultIsOpen = 0;
        private int defaultItemNum = 0;
        private Long defaultLastUpdate = null;
        private int defaultLikeNum = 0;
        private String defaultLogo = null;
        private String defaultMessage = null;
        private String defaultPic = null;
        private int defaultRecommend = 0;
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
        private final TypeAdapter<Integer> favNumAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isAddedAdapter;
        private final TypeAdapter<Integer> isOpenAdapter;
        private final TypeAdapter<Integer> itemNumAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
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
            this.descriptionAdapter = gson.getAdapter(String.class);
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
            this.isAddedAdapter = gson.getAdapter(Integer.class);
            this.sourceIdAdapter = gson.getAdapter(String.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.copyNumAdapter = gson.getAdapter(Integer.class);
            this.replyNumAdapter = gson.getAdapter(Integer.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.favNumAdapter = gson.getAdapter(Integer.class);
            this.shareNumAdapter = gson.getAdapter(Integer.class);
            this.itemNumAdapter = gson.getAdapter(Integer.class);
            this.coverPicAdapter = gson.getAdapter(String.class);
            this.isOpenAdapter = gson.getAdapter(Integer.class);
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.createdateAdapter = gson.getAdapter(Long.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.messageAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
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

        public GsonTypeAdapter setDefaultIsAdded(int i) {
            this.defaultIsAdded = i;
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

        public GsonTypeAdapter setDefaultFavNum(int i) {
            this.defaultFavNum = i;
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

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreatedate(Long l) {
            this.defaultCreatedate = l;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, FunThings funThings) throws IOException {
            if (funThings == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, funThings.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, funThings.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, funThings.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, funThings.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, funThings.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, funThings.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, funThings.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, funThings.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, funThings.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, funThings.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, funThings.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, funThings.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, funThings.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, funThings.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, funThings.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, funThings.getId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, funThings.getTitle());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, funThings.getLogo());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, funThings.getUid());
            jsonWriter.name("isAdded");
            this.isAddedAdapter.write(jsonWriter, Integer.valueOf(funThings.getIsAdded()));
            jsonWriter.name("source_id");
            this.sourceIdAdapter.write(jsonWriter, funThings.getSourceId());
            jsonWriter.name("follow_num");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getFollowNum()));
            jsonWriter.name("copy_num");
            this.copyNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getCopyNum()));
            jsonWriter.name("reply_num");
            this.replyNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getReplyNum()));
            jsonWriter.name("like_num");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getLikeNum()));
            jsonWriter.name("fav_num");
            this.favNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getFavNum()));
            jsonWriter.name("share_num");
            this.shareNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getShareNum()));
            jsonWriter.name("item_num");
            this.itemNumAdapter.write(jsonWriter, Integer.valueOf(funThings.getItemNum()));
            jsonWriter.name("cover");
            this.coverPicAdapter.write(jsonWriter, funThings.getCoverPic());
            jsonWriter.name("is_open");
            this.isOpenAdapter.write(jsonWriter, Integer.valueOf(funThings.getIsOpen()));
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(funThings.getRecommend()));
            jsonWriter.name("createdate");
            this.createdateAdapter.write(jsonWriter, funThings.getCreatedate());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, funThings.getUserAction());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, funThings.getMessage());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FunThings read(JsonReader jsonReader) throws IOException {
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
            String str7 = this.defaultSubTitle;
            String str8 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str9 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str10 = this.defaultDeprecatedUserName;
            String str11 = this.defaultDisplayUserName;
            String str12 = this.defaultId;
            String str13 = this.defaultTitle;
            String str14 = this.defaultLogo;
            String str15 = this.defaultUid;
            int i = this.defaultIsAdded;
            String str16 = this.defaultSourceId;
            int i2 = this.defaultFollowNum;
            int i3 = this.defaultCopyNum;
            int i4 = this.defaultReplyNum;
            int i5 = this.defaultLikeNum;
            int i6 = this.defaultFavNum;
            int i7 = this.defaultShareNum;
            int i8 = this.defaultItemNum;
            String str17 = this.defaultCoverPic;
            int i9 = this.defaultIsOpen;
            int i10 = this.defaultRecommend;
            Long l3 = this.defaultCreatedate;
            UserAction userAction = this.defaultUserAction;
            String str18 = this.defaultMessage;
            String str19 = str2;
            String str20 = str3;
            Integer num2 = num;
            String str21 = str4;
            String str22 = str5;
            String str23 = str6;
            String str24 = str7;
            String str25 = str8;
            Long l4 = l;
            Long l5 = l2;
            String str26 = str9;
            UserInfo userInfo2 = userInfo;
            String str27 = str10;
            String str28 = str;
            String str29 = str11;
            String str30 = str12;
            String str31 = str13;
            String str32 = str14;
            String str33 = str15;
            int i11 = i;
            String str34 = str16;
            int i12 = i2;
            int i13 = i3;
            int i14 = i4;
            int i15 = i5;
            int i16 = i6;
            int i17 = i7;
            int i18 = i8;
            String str35 = str17;
            int i19 = i9;
            int i20 = i10;
            Long l6 = l3;
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
                        case -1074962334:
                            if (nextName.equals("fav_num")) {
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
                        case -505624644:
                            if (nextName.equals("copy_num")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -433362767:
                            if (nextName.equals("reply_num")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
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
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 94852023:
                            if (nextName.equals("cover")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
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
                        case 2054065654:
                            if (nextName.equals("isAdded")) {
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
                            str20 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str24 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i12 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str22 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str34 = this.sourceIdAdapter.read(jsonReader);
                            continue;
                        case 5:
                            i17 = this.shareNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            str19 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str29 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            i16 = this.favNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            str28 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            i13 = this.copyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            i14 = this.replyNumAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str27 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str25 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str30 = this.idAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str23 = this.picAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str33 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str21 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str32 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str35 = this.coverPicAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str31 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str18 = this.messageAdapter.read(jsonReader);
                            continue;
                        case 24:
                            i20 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case 25:
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str26 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 27:
                            i15 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 28:
                            i18 = this.itemNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 29:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 30:
                            l6 = this.createdateAdapter.read(jsonReader);
                            continue;
                        case 31:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            i11 = this.isAddedAdapter.read(jsonReader).intValue();
                            continue;
                        case '!':
                            i19 = this.isOpenAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FunThings(str28, str19, str20, num2, str21, str22, str23, str24, str25, l4, l5, str26, userInfo2, str27, str29, str30, str31, str32, str33, i11, str34, i12, i13, i14, i15, i16, i17, i18, str35, i19, i20, l6, userAction2, str18);
        }
    }
}
