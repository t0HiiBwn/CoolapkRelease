package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_LocalApp  reason: invalid class name */
abstract class C$AutoValue_LocalApp extends C$$AutoValue_LocalApp {
    C$AutoValue_LocalApp(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, String str14) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, l2, l3, str10, str11, str12, str13, str14);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LocalApp$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<LocalApp> {
        private final TypeAdapter<String> apkIdAdapter;
        private final TypeAdapter<String> apkSizeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultApkId = null;
        private String defaultApkSize = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPackageName = null;
        private String defaultPic = null;
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
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.apkIdAdapter = gson.getAdapter(String.class);
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.apkSizeAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkId(String str) {
            this.defaultApkId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkSize(String str) {
            this.defaultApkSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, LocalApp localApp) throws IOException {
            if (localApp == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, localApp.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, localApp.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, localApp.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, localApp.getEntityFixed());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, localApp.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, localApp.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, localApp.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, localApp.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, localApp.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, localApp.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, localApp.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, localApp.getLastUpdate());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, localApp.getTitle());
            jsonWriter.name("aid");
            this.apkIdAdapter.write(jsonWriter, localApp.getApkId());
            jsonWriter.name("apkname");
            this.packageNameAdapter.write(jsonWriter, localApp.getPackageName());
            jsonWriter.name("apkSize");
            this.apkSizeAdapter.write(jsonWriter, localApp.getApkSize());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, localApp.getUrl());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public LocalApp read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultDescription;
            String str5 = this.defaultPic;
            String str6 = this.defaultLogo;
            String str7 = this.defaultSubTitle;
            String str8 = this.defaultId;
            String str9 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str10 = this.defaultTitle;
            String str11 = this.defaultApkId;
            String str12 = this.defaultPackageName;
            String str13 = this.defaultApkSize;
            String str14 = this.defaultUrl;
            String str15 = str2;
            String str16 = str3;
            Integer num2 = num;
            String str17 = str4;
            String str18 = str5;
            String str19 = str6;
            String str20 = str7;
            String str21 = str8;
            String str22 = str9;
            Long l4 = l2;
            Long l5 = l3;
            String str23 = str10;
            String str24 = str11;
            String str25 = str;
            String str26 = str12;
            String str27 = str13;
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
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -798597059:
                            if (nextName.equals("apkSize")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -797800793:
                            if (nextName.equals("apkname")) {
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
                        case 96572:
                            if (nextName.equals("aid")) {
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
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 16;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str16 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str20 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str17 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str15 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str25 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str27 = this.apkSizeAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str26 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str22 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str21 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str24 = this.apkIdAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str18 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str14 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str19 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str23 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 15:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 16:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_LocalApp(str25, str15, str16, num2, str17, str18, str19, str20, str21, str22, l4, l5, str23, str24, str26, str27, str14);
        }
    }
}
