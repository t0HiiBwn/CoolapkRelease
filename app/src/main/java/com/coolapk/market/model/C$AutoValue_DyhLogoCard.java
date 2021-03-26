package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_DyhLogoCard  reason: invalid class name */
abstract class C$AutoValue_DyhLogoCard extends C$$AutoValue_DyhLogoCard {
    C$AutoValue_DyhLogoCard(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Long l2, Long l3, String str8, String str9, String str10, List<Entity> list, String str11, String str12) {
        super(str, str2, num, str3, str4, str5, str6, str7, l2, l3, str8, str9, str10, list, str11, str12);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DyhLogoCard$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<DyhLogoCard> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private List<Entity> defaultEntities = null;
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
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<List<Entity>> entitiesAdapter;
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
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.entitiesAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Entity.class));
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntities(List<Entity> list) {
            this.defaultEntities = list;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, DyhLogoCard dyhLogoCard) throws IOException {
            if (dyhLogoCard == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, dyhLogoCard.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, dyhLogoCard.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, dyhLogoCard.getEntityFixed());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, dyhLogoCard.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, dyhLogoCard.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, dyhLogoCard.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, dyhLogoCard.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, dyhLogoCard.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, dyhLogoCard.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, dyhLogoCard.getLastUpdate());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, dyhLogoCard.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, dyhLogoCard.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, dyhLogoCard.getDescription());
            jsonWriter.name("entities");
            this.entitiesAdapter.write(jsonWriter, dyhLogoCard.getEntities());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, dyhLogoCard.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, dyhLogoCard.getEntityType());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public DyhLogoCard read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTemplate;
            String str2 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str3 = this.defaultPic;
            String str4 = this.defaultLogo;
            String str5 = this.defaultSubTitle;
            String str6 = this.defaultId;
            String str7 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str8 = this.defaultTitle;
            String str9 = this.defaultUrl;
            String str10 = this.defaultDescription;
            List<Entity> list = this.defaultEntities;
            String str11 = this.defaultEntityTypeName;
            String str12 = this.defaultEntityType;
            String str13 = str2;
            Integer num2 = num;
            String str14 = str3;
            String str15 = str4;
            String str16 = str5;
            String str17 = str6;
            String str18 = str7;
            Long l4 = l2;
            Long l5 = l3;
            String str19 = str8;
            String str20 = str9;
            String str21 = str10;
            List<Entity> list2 = list;
            String str22 = str;
            String str23 = str11;
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
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
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
                    }
                    switch (c) {
                        case 0:
                            list2 = this.entitiesAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str13 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str16 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str21 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str22 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str12 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str23 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str18 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str17 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str14 = this.picAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str20 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str15 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str19 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 14:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 15:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_DyhLogoCard(str22, str13, num2, str14, str15, str16, str17, str18, l4, l5, str19, str20, str21, list2, str23, str12);
        }
    }
}
