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

/* renamed from: com.coolapk.market.model.$AutoValue_DiscoveryQuery  reason: invalid class name */
abstract class C$AutoValue_DiscoveryQuery extends C$$AutoValue_DiscoveryQuery {
    C$AutoValue_DiscoveryQuery(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11, String str12, String str13, List<String> list, String str14, String str15, String str16) {
        super(str, str2, num, str3, str4, str5, str6, str7, str8, l2, l3, str9, str10, str11, str12, str13, list, str14, str15, str16);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DiscoveryQuery$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<DiscoveryQuery> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private String defaultIntroduce = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPackageName = null;
        private String defaultPic = null;
        private String defaultQuery = null;
        private String defaultReference = null;
        private List<String> defaultScreenShotList = Collections.emptyList();
        private String defaultSourceName = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> introduceAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> queryAdapter;
        private final TypeAdapter<String> referenceAdapter;
        private final TypeAdapter<List<String>> screenShotListAdapter;
        private final TypeAdapter<String> sourceNameAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.introduceAdapter = gson.getAdapter(String.class);
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.screenShotListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.sourceNameAdapter = gson.getAdapter(String.class);
            this.queryAdapter = gson.getAdapter(String.class);
            this.referenceAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
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

        public GsonTypeAdapter setDefaultIntroduce(String str) {
            this.defaultIntroduce = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultScreenShotList(List<String> list) {
            this.defaultScreenShotList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultSourceName(String str) {
            this.defaultSourceName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultQuery(String str) {
            this.defaultQuery = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReference(String str) {
            this.defaultReference = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, DiscoveryQuery discoveryQuery) throws IOException {
            if (discoveryQuery == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, discoveryQuery.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, discoveryQuery.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, discoveryQuery.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, discoveryQuery.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, discoveryQuery.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, discoveryQuery.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, discoveryQuery.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, discoveryQuery.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, discoveryQuery.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, discoveryQuery.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, discoveryQuery.getLastUpdate());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, discoveryQuery.getEntityTypeName());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, discoveryQuery.getTitle());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, discoveryQuery.getLogo());
            jsonWriter.name("intro");
            this.introduceAdapter.write(jsonWriter, discoveryQuery.getIntroduce());
            jsonWriter.name("packageName");
            this.packageNameAdapter.write(jsonWriter, discoveryQuery.getPackageName());
            jsonWriter.name("screenshotsArr");
            this.screenShotListAdapter.write(jsonWriter, discoveryQuery.getScreenShotList());
            jsonWriter.name("sourceName");
            this.sourceNameAdapter.write(jsonWriter, discoveryQuery.getSourceName());
            jsonWriter.name("query");
            this.queryAdapter.write(jsonWriter, discoveryQuery.getQuery());
            jsonWriter.name("referer");
            this.referenceAdapter.write(jsonWriter, discoveryQuery.getReference());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public DiscoveryQuery read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTemplate;
            String str2 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str3 = this.defaultUrl;
            String str4 = this.defaultDescription;
            String str5 = this.defaultPic;
            String str6 = this.defaultSubTitle;
            String str7 = this.defaultId;
            String str8 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str9 = this.defaultEntityTypeName;
            String str10 = this.defaultTitle;
            String str11 = this.defaultLogo;
            String str12 = this.defaultIntroduce;
            String str13 = this.defaultPackageName;
            List<String> list = this.defaultScreenShotList;
            String str14 = this.defaultSourceName;
            String str15 = this.defaultQuery;
            String str16 = this.defaultReference;
            String str17 = str2;
            Integer num2 = num;
            String str18 = str3;
            String str19 = str4;
            String str20 = str5;
            String str21 = str6;
            String str22 = str7;
            String str23 = str8;
            Long l4 = l2;
            Long l5 = l3;
            String str24 = str9;
            String str25 = str10;
            String str26 = str11;
            String str27 = str;
            String str28 = str12;
            String str29 = str13;
            List<String> list2 = list;
            String str30 = str14;
            String str31 = str15;
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
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1111633594:
                            if (nextName.equals("sourceName")) {
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
                        case -524965036:
                            if (nextName.equals("screenshotsArr")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 100361836:
                            if (nextName.equals("intro")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 107944136:
                            if (nextName.equals("query")) {
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
                        case 908759025:
                            if (nextName.equals("packageName")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1085069613:
                            if (nextName.equals("referer")) {
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
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 19;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str17 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str21 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str19 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str27 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str30 = this.sourceNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str24 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            list2 = this.screenShotListAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str23 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str22 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str20 = this.picAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str26 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str28 = this.introduceAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str31 = this.queryAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str25 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str29 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str16 = this.referenceAdapter.read(jsonReader);
                            continue;
                        case 18:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 19:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_DiscoveryQuery(str27, str17, num2, str18, str19, str20, str21, str22, str23, l4, l5, str24, str25, str26, str28, str29, list2, str30, str31, str16);
        }
    }
}
