package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_LiveUser  reason: invalid class name */
abstract class C$AutoValue_LiveUser extends C$$AutoValue_LiveUser {
    C$AutoValue_LiveUser(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l2, Long l3, String str13, String str14, String str15, int i2, int i3, User user) {
        super(str, str2, str3, i, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, l2, l3, str13, str14, str15, i2, i3, user);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LiveUser$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<LiveUser> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private int defaultDisallowPost = 0;
        private int defaultDisallowPostPic = 0;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLiveId = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private String defaultUserAvatar = null;
        private User defaultUserInfo = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> disallowPostAdapter;
        private final TypeAdapter<Integer> disallowPostPicAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> liveIdAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> userAvatarAdapter;
        private final TypeAdapter<User> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityTypeIdAdapter = gson.getAdapter(Integer.class);
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
            this.userAvatarAdapter = gson.getAdapter(String.class);
            this.disallowPostAdapter = gson.getAdapter(Integer.class);
            this.disallowPostPicAdapter = gson.getAdapter(Integer.class);
            this.userInfoAdapter = gson.getAdapter(User.class);
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

        public GsonTypeAdapter setDefaultLiveId(String str) {
            this.defaultLiveId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAvatar(String str) {
            this.defaultUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisallowPost(int i) {
            this.defaultDisallowPost = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDisallowPostPic(int i) {
            this.defaultDisallowPostPic = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(User user) {
            this.defaultUserInfo = user;
            return this;
        }

        public void write(JsonWriter jsonWriter, LiveUser liveUser) throws IOException {
            if (liveUser == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, liveUser.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, liveUser.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, liveUser.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(liveUser.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, liveUser.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, liveUser.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, liveUser.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, liveUser.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, liveUser.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, liveUser.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, liveUser.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, liveUser.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, liveUser.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, liveUser.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, liveUser.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, liveUser.getLastUpdate());
            jsonWriter.name("live_id");
            this.liveIdAdapter.write(jsonWriter, liveUser.getLiveId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, liveUser.getUid());
            jsonWriter.name("userAvatar");
            this.userAvatarAdapter.write(jsonWriter, liveUser.getUserAvatar());
            jsonWriter.name("disallow_post");
            this.disallowPostAdapter.write(jsonWriter, Integer.valueOf(liveUser.getDisallowPost()));
            jsonWriter.name("disallow_post_pic");
            this.disallowPostPicAdapter.write(jsonWriter, Integer.valueOf(liveUser.getDisallowPostPic()));
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, liveUser.getUserInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public LiveUser read(JsonReader jsonReader) throws IOException {
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
            String str13 = this.defaultLiveId;
            String str14 = this.defaultUid;
            String str15 = this.defaultUserAvatar;
            int i2 = this.defaultDisallowPost;
            int i3 = this.defaultDisallowPostPic;
            User user = this.defaultUserInfo;
            String str16 = str2;
            String str17 = str3;
            int i4 = i;
            String str18 = str4;
            Integer num2 = num;
            String str19 = str5;
            String str20 = str6;
            String str21 = str7;
            String str22 = str8;
            String str23 = str9;
            String str24 = str10;
            String str25 = str11;
            String str26 = str12;
            String str27 = str;
            Long l4 = l2;
            Long l5 = l3;
            String str28 = str13;
            String str29 = str14;
            String str30 = str15;
            int i5 = i2;
            int i6 = i3;
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
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -439550236:
                            if (nextName.equals("disallow_post")) {
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
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 184289614:
                            if (nextName.equals("live_id")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 668454319:
                            if (nextName.equals("disallow_post_pic")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 21;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str18 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str24 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str21 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str17 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str16 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str27 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i5 = this.disallowPostAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            user = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str26 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str25 = this.idAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str22 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str29 = this.uidAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str20 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str23 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str19 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str28 = this.liveIdAdapter.read(jsonReader);
                            continue;
                        case 17:
                            i6 = this.disallowPostPicAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            i4 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            str30 = this.userAvatarAdapter.read(jsonReader);
                            continue;
                        case 20:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 21:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_LiveUser(str27, str16, str17, i4, str18, num2, str19, str20, str21, str22, str23, str24, str25, str26, l4, l5, str28, str29, str30, i5, i6, user);
        }
    }
}
