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

/* renamed from: com.coolapk.market.model.$AutoValue_ConfigPage  reason: invalid class name */
abstract class C$AutoValue_ConfigPage extends C$$AutoValue_ConfigPage {
    C$AutoValue_ConfigPage(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, int i, int i2, int i3, List<SimpleEntity> list) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, l, l2, str13, i, i2, i3, list);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ConfigPage$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ConfigPage> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private int defaultOrder = 0;
        private int defaultPageFixed = 0;
        private String defaultPageName = null;
        private String defaultPic = null;
        private List<SimpleEntity> defaultRawEntities = Collections.emptyList();
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private int defaultVisibility = 0;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<Integer> orderAdapter;
        private final TypeAdapter<Integer> pageFixedAdapter;
        private final TypeAdapter<String> pageNameAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<List<SimpleEntity>> rawEntitiesAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<Integer> visibilityAdapter;

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
            this.pageNameAdapter = gson.getAdapter(String.class);
            this.visibilityAdapter = gson.getAdapter(Integer.class);
            this.orderAdapter = gson.getAdapter(Integer.class);
            this.pageFixedAdapter = gson.getAdapter(Integer.class);
            this.rawEntitiesAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, SimpleEntity.class));
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

        public GsonTypeAdapter setDefaultPageName(String str) {
            this.defaultPageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVisibility(int i) {
            this.defaultVisibility = i;
            return this;
        }

        public GsonTypeAdapter setDefaultOrder(int i) {
            this.defaultOrder = i;
            return this;
        }

        public GsonTypeAdapter setDefaultPageFixed(int i) {
            this.defaultPageFixed = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRawEntities(List<SimpleEntity> list) {
            this.defaultRawEntities = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, ConfigPage configPage) throws IOException {
            if (configPage == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, configPage.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, configPage.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, configPage.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, configPage.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, configPage.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, configPage.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, configPage.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, configPage.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, configPage.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, configPage.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, configPage.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, configPage.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, configPage.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, configPage.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, configPage.getLastUpdate());
            jsonWriter.name("page_name");
            this.pageNameAdapter.write(jsonWriter, configPage.getPageName());
            jsonWriter.name("page_visibility");
            this.visibilityAdapter.write(jsonWriter, Integer.valueOf(configPage.getVisibility()));
            jsonWriter.name("order");
            this.orderAdapter.write(jsonWriter, Integer.valueOf(configPage.getOrder()));
            jsonWriter.name("page_fixed");
            this.pageFixedAdapter.write(jsonWriter, Integer.valueOf(configPage.getPageFixed()));
            jsonWriter.name("entities");
            this.rawEntitiesAdapter.write(jsonWriter, configPage.getRawEntities());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ConfigPage read(JsonReader jsonReader) throws IOException {
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
            String str13 = this.defaultPageName;
            int i = this.defaultVisibility;
            int i2 = this.defaultOrder;
            int i3 = this.defaultPageFixed;
            List<SimpleEntity> list = this.defaultRawEntities;
            String str14 = str2;
            String str15 = str3;
            String str16 = str4;
            Integer num2 = num;
            String str17 = str5;
            String str18 = str6;
            String str19 = str7;
            String str20 = str8;
            String str21 = str9;
            String str22 = str10;
            String str23 = str11;
            String str24 = str12;
            Long l3 = l;
            String str25 = str;
            Long l4 = l2;
            String str26 = str13;
            int i4 = i;
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
                        case -2102114367:
                            if (nextName.equals("entities")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
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
                        case -1721076030:
                            if (nextName.equals("page_visibility")) {
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
                        case 106006350:
                            if (nextName.equals("order")) {
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
                        case 883692091:
                            if (nextName.equals("page_name")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 1617511876:
                            if (nextName.equals("page_fixed")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 19;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            list = this.rawEntitiesAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str16 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str22 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str19 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i4 = this.visibilityAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str15 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str14 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 7:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str25 = this.entityTypeNameAdapter.read(jsonReader);
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
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str21 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            i5 = this.orderAdapter.read(jsonReader).intValue();
                            continue;
                        case 15:
                            str17 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str26 = this.pageNameAdapter.read(jsonReader);
                            continue;
                        case 17:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 18:
                            i6 = this.pageFixedAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ConfigPage(str25, str14, str15, str16, num2, str17, str18, str19, str20, str21, str22, str23, str24, l3, l4, str26, i4, i5, i6, list);
        }
    }
}
