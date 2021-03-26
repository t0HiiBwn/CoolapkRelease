package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Notification  reason: invalid class name */
abstract class C$AutoValue_Notification extends C$$AutoValue_Notification {
    C$AutoValue_Notification(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, String str18, UserInfo userInfo, NotifyCount notifyCount, String str19) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, l, l2, str11, str12, str13, str14, str15, str16, str17, i, str18, userInfo, notifyCount, str19);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Notification$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Notification> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultFromUid = null;
        private String defaultFromUserAvatar = null;
        private UserInfo defaultFromUserInfo = null;
        private String defaultFromUserName = null;
        private String defaultId = null;
        private int defaultIsNew = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultNote = null;
        private NotifyCount defaultNotifyCount = null;
        private String defaultPic = null;
        private String defaultSlug = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultType = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> fromUidAdapter;
        private final TypeAdapter<String> fromUserAvatarAdapter;
        private final TypeAdapter<UserInfo> fromUserInfoAdapter;
        private final TypeAdapter<String> fromUserNameAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isNewAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> noteAdapter;
        private final TypeAdapter<NotifyCount> notifyCountAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> slugAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> typeAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;

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
            this.idAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.fromUidAdapter = gson.getAdapter(String.class);
            this.fromUserNameAdapter = gson.getAdapter(String.class);
            this.fromUserAvatarAdapter = gson.getAdapter(String.class);
            this.typeAdapter = gson.getAdapter(String.class);
            this.slugAdapter = gson.getAdapter(String.class);
            this.isNewAdapter = gson.getAdapter(Integer.class);
            this.noteAdapter = gson.getAdapter(String.class);
            this.fromUserInfoAdapter = gson.getAdapter(UserInfo.class);
            this.notifyCountAdapter = gson.getAdapter(NotifyCount.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultDateline(Long l) {
            this.defaultDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l) {
            this.defaultLastUpdate = l;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
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

        public GsonTypeAdapter setDefaultFromUserAvatar(String str) {
            this.defaultFromUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultType(String str) {
            this.defaultType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSlug(String str) {
            this.defaultSlug = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsNew(int i) {
            this.defaultIsNew = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNote(String str) {
            this.defaultNote = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFromUserInfo(UserInfo userInfo) {
            this.defaultFromUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultNotifyCount(NotifyCount notifyCount) {
            this.defaultNotifyCount = notifyCount;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, Notification notification) throws IOException {
            if (notification == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, notification.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, notification.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, notification.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, notification.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, notification.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, notification.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, notification.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, notification.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, notification.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, notification.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, notification.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, notification.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, notification.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, notification.getId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, notification.getUid());
            jsonWriter.name("fromuid");
            this.fromUidAdapter.write(jsonWriter, notification.getFromUid());
            jsonWriter.name("fromusername");
            this.fromUserNameAdapter.write(jsonWriter, notification.getFromUserName());
            jsonWriter.name("fromUserAvatar");
            this.fromUserAvatarAdapter.write(jsonWriter, notification.getFromUserAvatar());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, notification.getType());
            jsonWriter.name("slug");
            this.slugAdapter.write(jsonWriter, notification.getSlug());
            jsonWriter.name("isnew");
            this.isNewAdapter.write(jsonWriter, Integer.valueOf(notification.getIsNew()));
            jsonWriter.name("note");
            this.noteAdapter.write(jsonWriter, notification.getNote());
            jsonWriter.name("fromUserInfo");
            this.fromUserInfoAdapter.write(jsonWriter, notification.getFromUserInfo());
            jsonWriter.name("notifyCount");
            this.notifyCountAdapter.write(jsonWriter, notification.getNotifyCount());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, notification.getEntityType());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Notification read(JsonReader jsonReader) throws IOException {
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
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str11 = this.defaultId;
            String str12 = this.defaultUid;
            String str13 = this.defaultFromUid;
            String str14 = this.defaultFromUserName;
            String str15 = this.defaultFromUserAvatar;
            String str16 = this.defaultType;
            String str17 = this.defaultSlug;
            int i = this.defaultIsNew;
            String str18 = this.defaultNote;
            UserInfo userInfo = this.defaultFromUserInfo;
            NotifyCount notifyCount = this.defaultNotifyCount;
            String str19 = this.defaultEntityType;
            String str20 = str2;
            String str21 = str3;
            Integer num2 = num;
            String str22 = str4;
            String str23 = str5;
            String str24 = str6;
            String str25 = str7;
            String str26 = str8;
            String str27 = str9;
            String str28 = str10;
            Long l3 = l;
            Long l4 = l2;
            String str29 = str11;
            String str30 = str;
            String str31 = str12;
            String str32 = str13;
            String str33 = str14;
            String str34 = str15;
            String str35 = str16;
            String str36 = str17;
            int i2 = i;
            String str37 = str18;
            UserInfo userInfo2 = userInfo;
            NotifyCount notifyCount2 = notifyCount;
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
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1489814450:
                            if (nextName.equals("fromUserAvatar")) {
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
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -594307994:
                            if (nextName.equals("fromuid")) {
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
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3387378:
                            if (nextName.equals("note")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 3533483:
                            if (nextName.equals("slug")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 100504630:
                            if (nextName.equals("isnew")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1539593856:
                            if (nextName.equals("fromusername")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1603148003:
                            if (nextName.equals("fromUserInfo")) {
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
                            str21 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str27 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            notifyCount2 = this.notifyCountAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str24 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str20 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str34 = this.fromUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str19 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 7:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str30 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str32 = this.fromUidAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str28 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str29 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str25 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str31 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str23 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str26 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str37 = this.noteAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str36 = this.slugAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str35 = this.typeAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i2 = this.isNewAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            str22 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 21:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str33 = this.fromUserNameAdapter.read(jsonReader);
                            continue;
                        case 23:
                            userInfo2 = this.fromUserInfoAdapter.read(jsonReader);
                            continue;
                        case 24:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Notification(str30, str20, str21, num2, str22, str23, str24, str25, str26, str27, str28, l3, l4, str29, str31, str32, str33, str34, str35, str36, i2, str37, userInfo2, notifyCount2, str19);
        }
    }
}
