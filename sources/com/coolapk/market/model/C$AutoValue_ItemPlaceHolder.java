package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_ItemPlaceHolder  reason: invalid class name */
abstract class C$AutoValue_ItemPlaceHolder extends C$$AutoValue_ItemPlaceHolder {
    C$AutoValue_ItemPlaceHolder(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, UserInfo userInfo, String str12, String str13, String str14, String str15, DyhModel dyhModel, CollectionItem collectionItem) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, l2, l3, str11, userInfo, str12, str13, str14, str15, dyhModel, collectionItem);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ItemPlaceHolder$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ItemPlaceHolder> {
        private final TypeAdapter<CollectionItem> collectionItemInfoAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private CollectionItem defaultCollectionItemInfo = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private DyhModel defaultDyhModel = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<DyhModel> dyhModelAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
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
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
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
            this.uidAdapter = gson.getAdapter(String.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.dyhModelAdapter = gson.getAdapter(DyhModel.class);
            this.collectionItemInfoAdapter = gson.getAdapter(CollectionItem.class);
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

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
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

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDyhModel(DyhModel dyhModel) {
            this.defaultDyhModel = dyhModel;
            return this;
        }

        public GsonTypeAdapter setDefaultCollectionItemInfo(CollectionItem collectionItem) {
            this.defaultCollectionItemInfo = collectionItem;
            return this;
        }

        public void write(JsonWriter jsonWriter, ItemPlaceHolder itemPlaceHolder) throws IOException {
            if (itemPlaceHolder == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, itemPlaceHolder.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, itemPlaceHolder.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, itemPlaceHolder.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, itemPlaceHolder.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, itemPlaceHolder.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, itemPlaceHolder.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, itemPlaceHolder.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, itemPlaceHolder.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, itemPlaceHolder.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, itemPlaceHolder.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, itemPlaceHolder.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, itemPlaceHolder.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, itemPlaceHolder.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, itemPlaceHolder.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, itemPlaceHolder.getUserInfo());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, itemPlaceHolder.getUid());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, itemPlaceHolder.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, itemPlaceHolder.getDisplayUserName());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, itemPlaceHolder.getTitle());
            jsonWriter.name("dyh_info");
            this.dyhModelAdapter.write(jsonWriter, itemPlaceHolder.getDyhModel());
            jsonWriter.name("collection_item_info");
            this.collectionItemInfoAdapter.write(jsonWriter, itemPlaceHolder.getCollectionItemInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ItemPlaceHolder read(JsonReader jsonReader) throws IOException {
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
            String str8 = this.defaultSubTitle;
            String str9 = this.defaultId;
            String str10 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str11 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str12 = this.defaultUid;
            String str13 = this.defaultDeprecatedUserName;
            String str14 = this.defaultDisplayUserName;
            String str15 = this.defaultTitle;
            DyhModel dyhModel = this.defaultDyhModel;
            CollectionItem collectionItem = this.defaultCollectionItemInfo;
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
            Long l4 = l2;
            Long l5 = l3;
            String str25 = str11;
            String str26 = str;
            UserInfo userInfo2 = userInfo;
            String str27 = str12;
            String str28 = str13;
            String str29 = str14;
            String str30 = str15;
            DyhModel dyhModel2 = dyhModel;
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
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
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
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
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
                        case 406262265:
                            if (nextName.equals("collection_item_info")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1269540602:
                            if (nextName.equals("dyh_info")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 20;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str17 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str22 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str19 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str16 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str29 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str26 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str28 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str24 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str23 = this.idAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str20 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str27 = this.uidAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str21 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str30 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 16:
                            collectionItem = this.collectionItemInfoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str25 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 18:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 19:
                            dyhModel2 = this.dyhModelAdapter.read(jsonReader);
                            continue;
                        case 20:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ItemPlaceHolder(str26, str16, str17, num2, str18, str19, str20, str21, str22, str23, str24, l4, l5, str25, userInfo2, str27, str28, str29, str30, dyhModel2, collectionItem);
        }
    }
}
