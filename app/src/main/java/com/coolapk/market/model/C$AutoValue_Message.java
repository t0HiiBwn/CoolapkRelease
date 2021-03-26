package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Message  reason: invalid class name */
abstract class C$AutoValue_Message extends C$$AutoValue_Message {
    C$AutoValue_Message(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, UserInfo userInfo, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, int i2, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, NotifyCount notifyCount, int i3, int i4, Integer num2, String str27, UserInfo userInfo2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, l2, l3, str11, userInfo, str12, str13, str14, str15, str16, str17, str18, i, i2, str19, str20, str21, str22, str23, str24, str25, str26, notifyCount, i3, i4, num2, str27, userInfo2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Message$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Message> {
        private final TypeAdapter<String> UKeyAdapter;
        private final TypeAdapter<Long> datelineAdapter;
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
        private String defaultFromUid = null;
        private String defaultFromUserAvatar = null;
        private String defaultFromUserName = null;
        private String defaultId = null;
        private int defaultIsLast = 0;
        private Integer defaultIsLong = null;
        private int defaultIsNew = 0;
        private int defaultIsTop = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMessage = null;
        private String defaultMessageCard = null;
        private String defaultMessageExtra = null;
        private String defaultMessagePic = null;
        private String defaultMessageUid = null;
        private String defaultMessageUserAvatar = null;
        private UserInfo defaultMessageUserInfo = null;
        private String defaultMessageUserName = null;
        private NotifyCount defaultNotifyCount = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUKey = null;
        private String defaultUid = null;
        private int defaultUnreadNum = 0;
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
        private final TypeAdapter<String> fromUidAdapter;
        private final TypeAdapter<String> fromUserAvatarAdapter;
        private final TypeAdapter<String> fromUserNameAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isLastAdapter;
        private final TypeAdapter<Integer> isLongAdapter;
        private final TypeAdapter<Integer> isNewAdapter;
        private final TypeAdapter<Integer> isTopAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> messageCardAdapter;
        private final TypeAdapter<String> messageExtraAdapter;
        private final TypeAdapter<String> messagePicAdapter;
        private final TypeAdapter<String> messageUidAdapter;
        private final TypeAdapter<String> messageUserAvatarAdapter;
        private final TypeAdapter<UserInfo> messageUserInfoAdapter;
        private final TypeAdapter<String> messageUserNameAdapter;
        private final TypeAdapter<NotifyCount> notifyCountAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<Integer> unreadNumAdapter;
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
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.UKeyAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.fromUidAdapter = gson.getAdapter(String.class);
            this.fromUserNameAdapter = gson.getAdapter(String.class);
            this.isLastAdapter = gson.getAdapter(Integer.class);
            this.isNewAdapter = gson.getAdapter(Integer.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.messagePicAdapter = gson.getAdapter(String.class);
            this.messageExtraAdapter = gson.getAdapter(String.class);
            this.messageCardAdapter = gson.getAdapter(String.class);
            this.messageUidAdapter = gson.getAdapter(String.class);
            this.messageUserNameAdapter = gson.getAdapter(String.class);
            this.fromUserAvatarAdapter = gson.getAdapter(String.class);
            this.messageUserAvatarAdapter = gson.getAdapter(String.class);
            this.notifyCountAdapter = gson.getAdapter(NotifyCount.class);
            this.unreadNumAdapter = gson.getAdapter(Integer.class);
            this.isTopAdapter = gson.getAdapter(Integer.class);
            this.isLongAdapter = gson.getAdapter(Integer.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.messageUserInfoAdapter = gson.getAdapter(UserInfo.class);
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

        public GsonTypeAdapter setDefaultUKey(String str) {
            this.defaultUKey = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFromUid(String str) {
            this.defaultFromUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFromUserName(String str) {
            this.defaultFromUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsLast(int i) {
            this.defaultIsLast = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsNew(int i) {
            this.defaultIsNew = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessagePic(String str) {
            this.defaultMessagePic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageExtra(String str) {
            this.defaultMessageExtra = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageCard(String str) {
            this.defaultMessageCard = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageUid(String str) {
            this.defaultMessageUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageUserName(String str) {
            this.defaultMessageUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFromUserAvatar(String str) {
            this.defaultFromUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageUserAvatar(String str) {
            this.defaultMessageUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultNotifyCount(NotifyCount notifyCount) {
            this.defaultNotifyCount = notifyCount;
            return this;
        }

        public GsonTypeAdapter setDefaultUnreadNum(int i) {
            this.defaultUnreadNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsTop(int i) {
            this.defaultIsTop = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsLong(Integer num) {
            this.defaultIsLong = num;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageUserInfo(UserInfo userInfo) {
            this.defaultMessageUserInfo = userInfo;
            return this;
        }

        public void write(JsonWriter jsonWriter, Message message) throws IOException {
            if (message == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, message.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, message.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, message.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, message.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, message.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, message.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, message.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, message.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, message.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, message.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, message.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, message.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, message.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, message.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, message.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, message.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, message.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, message.getId());
            jsonWriter.name("ukey");
            this.UKeyAdapter.write(jsonWriter, message.getUKey());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, message.getUid());
            jsonWriter.name("fromuid");
            this.fromUidAdapter.write(jsonWriter, message.getFromUid());
            jsonWriter.name("fromusername");
            this.fromUserNameAdapter.write(jsonWriter, message.getFromUserName());
            jsonWriter.name("islast");
            this.isLastAdapter.write(jsonWriter, Integer.valueOf(message.getIsLast()));
            jsonWriter.name("isnew");
            this.isNewAdapter.write(jsonWriter, Integer.valueOf(message.getIsNew()));
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, message.getMessage());
            jsonWriter.name("message_pic");
            this.messagePicAdapter.write(jsonWriter, message.getMessagePic());
            jsonWriter.name("message_extra");
            this.messageExtraAdapter.write(jsonWriter, message.getMessageExtra());
            jsonWriter.name("message_card");
            this.messageCardAdapter.write(jsonWriter, message.getMessageCard());
            jsonWriter.name("messageUid");
            this.messageUidAdapter.write(jsonWriter, message.getMessageUid());
            jsonWriter.name("messageUsername");
            this.messageUserNameAdapter.write(jsonWriter, message.getMessageUserName());
            jsonWriter.name("fromUserAvatar");
            this.fromUserAvatarAdapter.write(jsonWriter, message.getFromUserAvatar());
            jsonWriter.name("messageUserAvatar");
            this.messageUserAvatarAdapter.write(jsonWriter, message.getMessageUserAvatar());
            jsonWriter.name("notifyCount");
            this.notifyCountAdapter.write(jsonWriter, message.getNotifyCount());
            jsonWriter.name("unreadNum");
            this.unreadNumAdapter.write(jsonWriter, Integer.valueOf(message.getUnreadNum()));
            jsonWriter.name("is_top");
            this.isTopAdapter.write(jsonWriter, Integer.valueOf(message.getIsTop()));
            jsonWriter.name("isLong");
            this.isLongAdapter.write(jsonWriter, message.getIsLong());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, message.getEntityType());
            jsonWriter.name("messageUserInfo");
            this.messageUserInfoAdapter.write(jsonWriter, message.getMessageUserInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Message read(JsonReader jsonReader) throws IOException {
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
            String str10 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str11 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str12 = this.defaultDeprecatedUserName;
            String str13 = this.defaultDisplayUserName;
            String str14 = this.defaultId;
            String str15 = this.defaultUKey;
            String str16 = this.defaultUid;
            String str17 = this.defaultFromUid;
            String str18 = this.defaultFromUserName;
            int i = this.defaultIsLast;
            int i2 = this.defaultIsNew;
            String str19 = this.defaultMessage;
            String str20 = this.defaultMessagePic;
            String str21 = this.defaultMessageExtra;
            String str22 = this.defaultMessageCard;
            String str23 = this.defaultMessageUid;
            String str24 = this.defaultMessageUserName;
            String str25 = this.defaultFromUserAvatar;
            String str26 = this.defaultMessageUserAvatar;
            NotifyCount notifyCount = this.defaultNotifyCount;
            int i3 = this.defaultUnreadNum;
            int i4 = this.defaultIsTop;
            Integer num2 = this.defaultIsLong;
            String str27 = this.defaultEntityType;
            UserInfo userInfo2 = this.defaultMessageUserInfo;
            String str28 = str2;
            String str29 = str3;
            Integer num3 = num;
            String str30 = str4;
            String str31 = str5;
            String str32 = str6;
            String str33 = str7;
            String str34 = str8;
            String str35 = str9;
            String str36 = str10;
            Long l4 = l2;
            Long l5 = l3;
            String str37 = str11;
            String str38 = str;
            UserInfo userInfo3 = userInfo;
            String str39 = str12;
            String str40 = str13;
            String str41 = str14;
            String str42 = str15;
            String str43 = str16;
            String str44 = str17;
            String str45 = str18;
            int i5 = i;
            int i6 = i2;
            String str46 = str19;
            String str47 = str20;
            String str48 = str21;
            String str49 = str22;
            String str50 = str23;
            String str51 = str24;
            String str52 = str25;
            String str53 = str26;
            NotifyCount notifyCount2 = notifyCount;
            int i7 = i3;
            int i8 = i4;
            Integer num4 = num2;
            String str54 = str27;
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
                        case -1768624314:
                            if (nextName.equals("notifyCount")) {
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
                        case -1690731831:
                            if (nextName.equals("messageUid")) {
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
                        case -1502778025:
                            if (nextName.equals("unreadNum")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1489814450:
                            if (nextName.equals("fromUserAvatar")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
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
                        case -1286594488:
                            if (nextName.equals("message_card")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1227188776:
                            if (nextName.equals("message_extra")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -1180327226:
                            if (nextName.equals("isLong")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1179756352:
                            if (nextName.equals("is_top")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1179387200:
                            if (nextName.equals("islast")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -872774318:
                            if (nextName.equals("message_pic")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -594307994:
                            if (nextName.equals("fromuid")) {
                                c = 18;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 19;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 3591626:
                            if (nextName.equals("ukey")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 100504630:
                            if (nextName.equals("isnew")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 411112555:
                            if (nextName.equals("messageUserAvatar")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 532501568:
                            if (nextName.equals("messageUserInfo")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 533591549:
                            if (nextName.equals("messageUsername")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '#';
                                break;
                            }
                            break;
                        case 1539593856:
                            if (nextName.equals("fromusername")) {
                                c = '$';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '%';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str29 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str35 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            notifyCount2 = this.notifyCountAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str32 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str50 = this.messageUidAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str28 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i7 = this.unreadNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str52 = this.fromUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str54 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str40 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str49 = this.messageCardAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str48 = this.messageExtraAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            num4 = this.isLongAdapter.read(jsonReader);
                            continue;
                        case 14:
                            i8 = this.isTopAdapter.read(jsonReader).intValue();
                            continue;
                        case 15:
                            i5 = this.isLastAdapter.read(jsonReader).intValue();
                            continue;
                        case 16:
                            str38 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str47 = this.messagePicAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str44 = this.fromUidAdapter.read(jsonReader);
                            continue;
                        case 19:
                            userInfo3 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str39 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str36 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str41 = this.idAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str33 = this.picAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str43 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str31 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str34 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str42 = this.UKeyAdapter.read(jsonReader);
                            continue;
                        case 28:
                            i6 = this.isNewAdapter.read(jsonReader).intValue();
                            continue;
                        case 29:
                            str30 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str53 = this.messageUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 31:
                            userInfo2 = this.messageUserInfoAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str51 = this.messageUserNameAdapter.read(jsonReader);
                            continue;
                        case '!':
                            str46 = this.messageAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            str37 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '#':
                            num3 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '$':
                            str45 = this.fromUserNameAdapter.read(jsonReader);
                            continue;
                        case '%':
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Message(str38, str28, str29, num3, str30, str31, str32, str33, str34, str35, str36, l4, l5, str37, userInfo3, str39, str40, str41, str42, str43, str44, str45, i5, i6, str46, str47, str48, str49, str50, str51, str52, str53, notifyCount2, i7, i8, num4, str54, userInfo2);
        }
    }
}
