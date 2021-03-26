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

/* renamed from: com.coolapk.market.model.$AutoValue_AppCategory  reason: invalid class name */
abstract class C$AutoValue_AppCategory extends C$$AutoValue_AppCategory {
    C$AutoValue_AppCategory(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, String str10, String str11, String str12, String str13, List<String> list, String str14) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, l, l2, str9, str10, str11, str12, str13, list, str14);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_AppCategory$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<AppCategory> {
        private final TypeAdapter<String> apkTypeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultApkType = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private String defaultKeywords = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private List<String> defaultTagList = Collections.emptyList();
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> keywordsAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<List<String>> tagListAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.keywordsAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.tagListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.apkTypeAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKeywords(String str) {
            this.defaultKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTagList(List<String> list) {
            this.defaultTagList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultApkType(String str) {
            this.defaultApkType = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, AppCategory appCategory) throws IOException {
            if (appCategory == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, appCategory.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, appCategory.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, appCategory.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, appCategory.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, appCategory.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, appCategory.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, appCategory.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, appCategory.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, appCategory.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, appCategory.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, appCategory.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, appCategory.getId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, appCategory.getTitle());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, appCategory.getLogo());
            jsonWriter.name("keywords");
            this.keywordsAdapter.write(jsonWriter, appCategory.getKeywords());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, appCategory.getDescription());
            jsonWriter.name("tagList");
            this.tagListAdapter.write(jsonWriter, appCategory.getTagList());
            jsonWriter.name("apkType");
            this.apkTypeAdapter.write(jsonWriter, appCategory.getApkType());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public AppCategory read(JsonReader jsonReader) throws IOException {
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
            String str5 = this.defaultUrl;
            String str6 = this.defaultPic;
            String str7 = this.defaultSubTitle;
            String str8 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str9 = this.defaultId;
            String str10 = this.defaultTitle;
            String str11 = this.defaultLogo;
            String str12 = this.defaultKeywords;
            String str13 = this.defaultDescription;
            List<String> list = this.defaultTagList;
            String str14 = this.defaultApkType;
            String str15 = str2;
            String str16 = str3;
            String str17 = str4;
            Integer num2 = num;
            String str18 = str5;
            String str19 = str6;
            String str20 = str7;
            String str21 = str8;
            Long l3 = l;
            Long l4 = l2;
            String str22 = str9;
            String str23 = str10;
            String str24 = str11;
            String str25 = str;
            String str26 = str12;
            String str27 = str13;
            List<String> list2 = list;
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
                        case -1549236392:
                            if (nextName.equals("tagList")) {
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
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -798552202:
                            if (nextName.equals("apkType")) {
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
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 17;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str17 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str20 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str27 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str16 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            list2 = this.tagListAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str15 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str25 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str14 = this.apkTypeAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str21 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str22 = this.idAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str19 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str24 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str23 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str26 = this.keywordsAdapter.read(jsonReader);
                            continue;
                        case 16:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 17:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_AppCategory(str25, str15, str16, str17, num2, str18, str19, str20, str21, l3, l4, str22, str23, str24, str26, str27, list2, str14);
        }
    }
}
