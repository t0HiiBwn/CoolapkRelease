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

/* renamed from: com.coolapk.market.model.$AutoValue_DocListCard  reason: invalid class name */
abstract class C$AutoValue_DocListCard extends C$$AutoValue_DocListCard {
    C$AutoValue_DocListCard(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Long l2, Long l3, String str8, String str9, String str10, String str11, List<Entity> list) {
        super(str, str2, num, str3, str4, str5, str6, str7, l2, l3, str8, str9, str10, str11, list);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DocListCard$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<DocListCard> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private List<Entity> defaultEntities = Collections.emptyList();
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
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<List<Entity>> entitiesAdapter;
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
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entitiesAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Entity.class));
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

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntities(List<Entity> list) {
            this.defaultEntities = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, DocListCard docListCard) throws IOException {
            if (docListCard == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, docListCard.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, docListCard.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, docListCard.getEntityFixed());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, docListCard.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, docListCard.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, docListCard.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, docListCard.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, docListCard.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, docListCard.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, docListCard.getLastUpdate());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, docListCard.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, docListCard.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, docListCard.getDescription());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, docListCard.getEntityTypeName());
            jsonWriter.name("entities");
            this.entitiesAdapter.write(jsonWriter, docListCard.getEntities());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public DocListCard read(JsonReader jsonReader) throws IOException {
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
            String str11 = this.defaultEntityTypeName;
            List<Entity> list = this.defaultEntities;
            String str12 = str2;
            Integer num2 = num;
            String str13 = str3;
            String str14 = str4;
            String str15 = str5;
            String str16 = str6;
            String str17 = str7;
            Long l4 = l2;
            Long l5 = l3;
            String str18 = str8;
            String str19 = str9;
            String str20 = str10;
            String str21 = str11;
            String str22 = str;
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
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 14;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            list = this.entitiesAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str12 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str15 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str20 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str22 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str21 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str17 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str16 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str13 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str19 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str14 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str18 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 14:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_DocListCard(str22, str12, num2, str13, str14, str15, str16, str17, l4, l5, str18, str19, str20, str21, list);
        }
    }
}
