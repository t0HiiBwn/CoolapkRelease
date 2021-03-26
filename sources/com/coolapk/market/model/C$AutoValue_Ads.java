package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Ads  reason: invalid class name */
abstract class C$AutoValue_Ads extends C$$AutoValue_Ads {
    C$AutoValue_Ads(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l2, Long l3, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, String str14) {
        super(str, str2, num, str3, str4, str5, str6, l2, l3, str7, str8, i, str9, str10, str11, str12, str13, str14);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Ads$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Ads> {
        private final TypeAdapter<String> adsTypeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAdsType = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFollow = 0;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> followAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.followAdapter = gson.getAdapter(Integer.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.adsTypeAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollow(int i) {
            this.defaultFollow = i;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdsType(String str) {
            this.defaultAdsType = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, Ads ads) throws IOException {
            if (ads == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, ads.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, ads.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, ads.getEntityFixed());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, ads.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, ads.getPic());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, ads.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, ads.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, ads.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, ads.getLastUpdate());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, ads.getEntityTypeName());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, ads.getUid());
            jsonWriter.name("follow");
            this.followAdapter.write(jsonWriter, Integer.valueOf(ads.getFollow()));
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, ads.getEntityType());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, ads.getTitle());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, ads.getSubTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, ads.getUrl());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, ads.getLogo());
            jsonWriter.name("adsType");
            this.adsTypeAdapter.write(jsonWriter, ads.getAdsType());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Ads read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTemplate;
            String str2 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str3 = this.defaultDescription;
            String str4 = this.defaultPic;
            String str5 = this.defaultId;
            String str6 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str7 = this.defaultEntityTypeName;
            String str8 = this.defaultUid;
            int i = this.defaultFollow;
            String str9 = this.defaultEntityType;
            String str10 = this.defaultTitle;
            String str11 = this.defaultSubTitle;
            String str12 = this.defaultUrl;
            String str13 = this.defaultLogo;
            String str14 = this.defaultAdsType;
            String str15 = str2;
            Integer num2 = num;
            String str16 = str3;
            String str17 = str4;
            String str18 = str5;
            String str19 = str6;
            Long l4 = l2;
            Long l5 = l3;
            String str20 = str7;
            String str21 = str8;
            int i2 = i;
            String str22 = str9;
            String str23 = str10;
            String str24 = str;
            String str25 = str11;
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
                        case -1268958287:
                            if (nextName.equals("follow")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1134713846:
                            if (nextName.equals("adsType")) {
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
                            str15 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str25 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str16 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str24 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str22 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i2 = this.followAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str14 = this.adsTypeAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str20 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str19 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str18 = this.idAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str17 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str21 = this.uidAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str26 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str27 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str23 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 16:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 17:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Ads(str24, str15, num2, str16, str17, str18, str19, l4, l5, str20, str21, i2, str22, str23, str25, str26, str27, str14);
        }
    }
}
