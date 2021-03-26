package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_MainSecondHandType  reason: invalid class name */
abstract class C$AutoValue_MainSecondHandType extends C$$AutoValue_MainSecondHandType {
    C$AutoValue_MainSecondHandType(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, int i) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, l, l2, str13, i);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_MainSecondHandType$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<MainSecondHandType> {
        private final TypeAdapter<Integer> configTypeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultConfigType = 0;
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
        private String defaultPic = null;
        private String defaultSecondHandFeedNum = null;
        private String defaultSubTitle = null;
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
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> secondHandFeedNumAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

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
            this.secondHandFeedNumAdapter = gson.getAdapter(String.class);
            this.configTypeAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultSecondHandFeedNum(String str) {
            this.defaultSecondHandFeedNum = str;
            return this;
        }

        public GsonTypeAdapter setDefaultConfigType(int i) {
            this.defaultConfigType = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, MainSecondHandType mainSecondHandType) throws IOException {
            if (mainSecondHandType == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, mainSecondHandType.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, mainSecondHandType.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, mainSecondHandType.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, mainSecondHandType.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, mainSecondHandType.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, mainSecondHandType.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, mainSecondHandType.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, mainSecondHandType.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, mainSecondHandType.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, mainSecondHandType.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, mainSecondHandType.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, mainSecondHandType.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, mainSecondHandType.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, mainSecondHandType.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, mainSecondHandType.getLastUpdate());
            jsonWriter.name("sale_num");
            this.secondHandFeedNumAdapter.write(jsonWriter, mainSecondHandType.getSecondHandFeedNum());
            jsonWriter.name("is_config");
            this.configTypeAdapter.write(jsonWriter, Integer.valueOf(mainSecondHandType.getConfigType()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public MainSecondHandType read(JsonReader jsonReader) throws IOException {
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
            String str13 = this.defaultSecondHandFeedNum;
            int i = this.defaultConfigType;
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
                        case -890753033:
                            if (nextName.equals("is_config")) {
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
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1936400270:
                            if (nextName.equals("sale_num")) {
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
                            str22 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str19 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str15 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str14 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str25 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i = this.configTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            str24 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str23 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str20 = this.picAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str21 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str17 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 14:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 15:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str26 = this.secondHandFeedNumAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_MainSecondHandType(str25, str14, str15, str16, num2, str17, str18, str19, str20, str21, str22, str23, str24, l3, l4, str26, i);
        }
    }
}
