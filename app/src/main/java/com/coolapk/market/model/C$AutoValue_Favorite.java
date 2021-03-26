package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_Favorite  reason: invalid class name */
abstract class C$AutoValue_Favorite extends C$$AutoValue_Favorite {
    C$AutoValue_Favorite(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, int i, List<String> list) {
        super(str, str2, str3, str4, num, str5, str6, str7, l2, l3, str8, userInfo, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, i, list);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Favorite$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Favorite> {
        private final TypeAdapter<String> contentAdapter;
        private final TypeAdapter<Long> datelineAdapter;
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
        private String defaultEntityTypeName = null;
        private String defaultExtra = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private int defaultIsEdit = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTag = null;
        private List<String> defaultTagList = Collections.emptyList();
        private String defaultTargetId = null;
        private String defaultTargetKey = null;
        private String defaultTargetType = null;
        private String defaultTargetUid = null;
        private String defaultTargetUserAvatar = null;
        private String defaultTargetUserName = null;
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
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isEditAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> tagAdapter;
        private final TypeAdapter<List<String>> tagListAdapter;
        private final TypeAdapter<String> targetIdAdapter;
        private final TypeAdapter<String> targetKeyAdapter;
        private final TypeAdapter<String> targetTypeAdapter;
        private final TypeAdapter<String> targetUidAdapter;
        private final TypeAdapter<String> targetUserAvatarAdapter;
        private final TypeAdapter<String> targetUserNameAdapter;
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
            this.uidAdapter = gson.getAdapter(String.class);
            this.targetTypeAdapter = gson.getAdapter(String.class);
            this.targetIdAdapter = gson.getAdapter(String.class);
            this.targetUidAdapter = gson.getAdapter(String.class);
            this.targetUserNameAdapter = gson.getAdapter(String.class);
            this.targetUserAvatarAdapter = gson.getAdapter(String.class);
            this.targetKeyAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.contentAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.extraAdapter = gson.getAdapter(String.class);
            this.tagAdapter = gson.getAdapter(String.class);
            this.isEditAdapter = gson.getAdapter(Integer.class);
            this.tagListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
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

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetType(String str) {
            this.defaultTargetType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetId(String str) {
            this.defaultTargetId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetUid(String str) {
            this.defaultTargetUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetUserName(String str) {
            this.defaultTargetUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetUserAvatar(String str) {
            this.defaultTargetUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetKey(String str) {
            this.defaultTargetKey = str;
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

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultContent(String str) {
            this.defaultContent = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtra(String str) {
            this.defaultExtra = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTag(String str) {
            this.defaultTag = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsEdit(int i) {
            this.defaultIsEdit = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTagList(List<String> list) {
            this.defaultTagList = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, Favorite favorite) throws IOException {
            if (favorite == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, favorite.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, favorite.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, favorite.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, favorite.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, favorite.getEntityFixed());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, favorite.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, favorite.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, favorite.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, favorite.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, favorite.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, favorite.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, favorite.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, favorite.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, favorite.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, favorite.getId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, favorite.getUid());
            jsonWriter.name("targetType");
            this.targetTypeAdapter.write(jsonWriter, favorite.getTargetType());
            jsonWriter.name("targetId");
            this.targetIdAdapter.write(jsonWriter, favorite.getTargetId());
            jsonWriter.name("targetUid");
            this.targetUidAdapter.write(jsonWriter, favorite.getTargetUid());
            jsonWriter.name("targetUsername");
            this.targetUserNameAdapter.write(jsonWriter, favorite.getTargetUserName());
            jsonWriter.name("targetAvatar");
            this.targetUserAvatarAdapter.write(jsonWriter, favorite.getTargetUserAvatar());
            jsonWriter.name("targetKey");
            this.targetKeyAdapter.write(jsonWriter, favorite.getTargetKey());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, favorite.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, favorite.getPic());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, favorite.getUrl());
            jsonWriter.name("content");
            this.contentAdapter.write(jsonWriter, favorite.getContent());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, favorite.getTitle());
            jsonWriter.name("extra");
            this.extraAdapter.write(jsonWriter, favorite.getExtra());
            jsonWriter.name("tag");
            this.tagAdapter.write(jsonWriter, favorite.getTag());
            jsonWriter.name("isEdit");
            this.isEditAdapter.write(jsonWriter, Integer.valueOf(favorite.getIsEdit()));
            jsonWriter.name("tags");
            this.tagListAdapter.write(jsonWriter, favorite.getTagList());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Favorite read(JsonReader jsonReader) throws IOException {
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
            String str5 = this.defaultLogo;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str8 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str9 = this.defaultDeprecatedUserName;
            String str10 = this.defaultDisplayUserName;
            String str11 = this.defaultId;
            String str12 = this.defaultUid;
            String str13 = this.defaultTargetType;
            String str14 = this.defaultTargetId;
            String str15 = this.defaultTargetUid;
            String str16 = this.defaultTargetUserName;
            String str17 = this.defaultTargetUserAvatar;
            String str18 = this.defaultTargetKey;
            String str19 = this.defaultDescription;
            String str20 = this.defaultPic;
            String str21 = this.defaultUrl;
            String str22 = this.defaultContent;
            String str23 = this.defaultTitle;
            String str24 = this.defaultExtra;
            String str25 = this.defaultTag;
            int i = this.defaultIsEdit;
            List<String> list = this.defaultTagList;
            String str26 = str2;
            String str27 = str3;
            String str28 = str4;
            Integer num2 = num;
            String str29 = str5;
            String str30 = str6;
            String str31 = str7;
            Long l4 = l2;
            Long l5 = l3;
            String str32 = str8;
            UserInfo userInfo2 = userInfo;
            String str33 = str9;
            String str34 = str10;
            String str35 = str;
            String str36 = str11;
            String str37 = str12;
            String str38 = str13;
            String str39 = str14;
            String str40 = str15;
            String str41 = str16;
            String str42 = str17;
            String str43 = str18;
            String str44 = str19;
            String str45 = str20;
            String str46 = str21;
            String str47 = str22;
            String str48 = str23;
            String str49 = str24;
            String str50 = str25;
            int i2 = i;
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
                        case -1857798777:
                            if (nextName.equals("targetUsername")) {
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
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
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
                        case -1180546476:
                            if (nextName.equals("isEdit")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1054544310:
                            if (nextName.equals("targetAvatar")) {
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
                        case -815595762:
                            if (nextName.equals("targetKey")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -815586049:
                            if (nextName.equals("targetUid")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -441951604:
                            if (nextName.equals("targetId")) {
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
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 114586:
                            if (nextName.equals("tag")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 3552281:
                            if (nextName.equals("tags")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 96965648:
                            if (nextName.equals("extra")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 486622315:
                            if (nextName.equals("targetType")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 951530617:
                            if (nextName.equals("content")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
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
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 30;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str28 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str30 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str41 = this.targetUserNameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str44 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str27 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str26 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str34 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            i2 = this.isEditAdapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            str42 = this.targetUserAvatarAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str35 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str43 = this.targetKeyAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str40 = this.targetUidAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str39 = this.targetIdAdapter.read(jsonReader);
                            continue;
                        case 14:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str33 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str31 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str36 = this.idAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str45 = this.picAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str50 = this.tagAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str37 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str46 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str29 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 23:
                            list = this.tagListAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str49 = this.extraAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str48 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str38 = this.targetTypeAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str47 = this.contentAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str32 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 29:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 30:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Favorite(str35, str26, str27, str28, num2, str29, str30, str31, l4, l5, str32, userInfo2, str33, str34, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, i2, list);
        }
    }
}
