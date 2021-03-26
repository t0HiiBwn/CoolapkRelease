package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_LiveMessage  reason: invalid class name */
abstract class C$AutoValue_LiveMessage extends C$$AutoValue_LiveMessage {
    C$AutoValue_LiveMessage(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, String str14, String str15, String str16, String str17, int i, User user, LiveMessage liveMessage, String str18, int i2) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, l, l2, str13, str14, str15, str16, str17, i, user, liveMessage, str18, i2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LiveMessage$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<LiveMessage> {
        private final TypeAdapter<Long> datelineAdapter;
        private final TypeAdapter<String> datelineFormatAdapter;
        private Long defaultDateline = null;
        private String defaultDatelineFormat = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private int defaultIsBroadcast = 0;
        private int defaultIsRead = 0;
        private Long defaultLastUpdate = null;
        private String defaultLiveId = null;
        private String defaultLogo = null;
        private String defaultMessage = null;
        private String defaultMessageSource = null;
        private String defaultPic = null;
        private LiveMessage defaultSourceRow = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private User defaultUserInfo = null;
        private String defaultUserName = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isBroadcastAdapter;
        private final TypeAdapter<Integer> isReadAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> liveIdAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> messageSourceAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<LiveMessage> sourceRowAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<User> userInfoAdapter;
        private final TypeAdapter<String> userNameAdapter;

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
            this.liveIdAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.userNameAdapter = gson.getAdapter(String.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.messageSourceAdapter = gson.getAdapter(String.class);
            this.isBroadcastAdapter = gson.getAdapter(Integer.class);
            this.userInfoAdapter = gson.getAdapter(User.class);
            this.sourceRowAdapter = gson.getAdapter(LiveMessage.class);
            this.datelineFormatAdapter = gson.getAdapter(String.class);
            this.isReadAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultDateline(Long l) {
            this.defaultDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l) {
            this.defaultLastUpdate = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLiveId(String str) {
            this.defaultLiveId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserName(String str) {
            this.defaultUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageSource(String str) {
            this.defaultMessageSource = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsBroadcast(int i) {
            this.defaultIsBroadcast = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(User user) {
            this.defaultUserInfo = user;
            return this;
        }

        public GsonTypeAdapter setDefaultSourceRow(LiveMessage liveMessage) {
            this.defaultSourceRow = liveMessage;
            return this;
        }

        public GsonTypeAdapter setDefaultDatelineFormat(String str) {
            this.defaultDatelineFormat = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsRead(int i) {
            this.defaultIsRead = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, LiveMessage liveMessage) throws IOException {
            if (liveMessage == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, liveMessage.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, liveMessage.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, liveMessage.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, liveMessage.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, liveMessage.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, liveMessage.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, liveMessage.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, liveMessage.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, liveMessage.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, liveMessage.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, liveMessage.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, liveMessage.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, liveMessage.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, liveMessage.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, liveMessage.getLastUpdate());
            jsonWriter.name("live_id");
            this.liveIdAdapter.write(jsonWriter, liveMessage.getLiveId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, liveMessage.getUid());
            jsonWriter.name("username");
            this.userNameAdapter.write(jsonWriter, liveMessage.getUserName());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, liveMessage.getMessage());
            jsonWriter.name("message_source");
            this.messageSourceAdapter.write(jsonWriter, liveMessage.getMessageSource());
            jsonWriter.name("is_broadcast");
            this.isBroadcastAdapter.write(jsonWriter, Integer.valueOf(liveMessage.getIsBroadcast()));
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, liveMessage.getUserInfo());
            jsonWriter.name("sourceRow");
            this.sourceRowAdapter.write(jsonWriter, liveMessage.getSourceRow());
            jsonWriter.name("datelineFormat");
            this.datelineFormatAdapter.write(jsonWriter, liveMessage.getDatelineFormat());
            jsonWriter.name("is_read");
            this.isReadAdapter.write(jsonWriter, Integer.valueOf(liveMessage.getIsRead()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public LiveMessage read(JsonReader jsonReader) throws IOException {
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
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str13 = this.defaultLiveId;
            String str14 = this.defaultUid;
            String str15 = this.defaultUserName;
            String str16 = this.defaultMessage;
            String str17 = this.defaultMessageSource;
            int i = this.defaultIsBroadcast;
            User user = this.defaultUserInfo;
            LiveMessage liveMessage = this.defaultSourceRow;
            String str18 = this.defaultDatelineFormat;
            int i2 = this.defaultIsRead;
            String str19 = str2;
            String str20 = str3;
            String str21 = str4;
            Integer num2 = num;
            String str22 = str5;
            String str23 = str6;
            String str24 = str7;
            String str25 = str8;
            String str26 = str9;
            String str27 = str10;
            String str28 = str11;
            String str29 = str12;
            Long l3 = l;
            String str30 = str;
            Long l4 = l2;
            String str31 = str13;
            String str32 = str14;
            String str33 = str15;
            String str34 = str16;
            String str35 = str17;
            int i3 = i;
            User user2 = user;
            LiveMessage liveMessage2 = liveMessage;
            String str36 = str18;
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
                        case -1698422849:
                            if (nextName.equals("sourceRow")) {
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
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1284867271:
                            if (nextName.equals("datelineFormat")) {
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
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
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
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 184289614:
                            if (nextName.equals("live_id")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1004379987:
                            if (nextName.equals("message_source")) {
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
                        case 1364984812:
                            if (nextName.equals("is_broadcast")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 2082189195:
                            if (nextName.equals("is_read")) {
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
                            str24 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            liveMessage2 = this.sourceRowAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str20 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str19 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str36 = this.datelineFormatAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str30 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            user2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str33 = this.userNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str29 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str28 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str25 = this.picAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str32 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str23 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str26 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str22 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str31 = this.liveIdAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str34 = this.messageAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str35 = this.messageSourceAdapter.read(jsonReader);
                            continue;
                        case 21:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i3 = this.isBroadcastAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 24:
                            i2 = this.isReadAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_LiveMessage(str30, str19, str20, str21, num2, str22, str23, str24, str25, str26, str27, str28, str29, l3, l4, str31, str32, str33, str34, str35, i3, user2, liveMessage2, str36, i2);
        }
    }
}
