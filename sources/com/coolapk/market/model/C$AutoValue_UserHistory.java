package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_UserHistory  reason: invalid class name */
abstract class C$AutoValue_UserHistory extends C$$AutoValue_UserHistory {
    C$AutoValue_UserHistory(String str, String str2, Integer num, String str3, String str4, String str5, Long l, Long l2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        super(str, str2, num, str3, str4, str5, l, l2, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_UserHistory$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<UserHistory> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultHistoryType = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultTypeName = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> historyTypeAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> typeNameAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.historyTypeAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.typeNameAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHistoryType(String str) {
            this.defaultHistoryType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTypeName(String str) {
            this.defaultTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, UserHistory userHistory) throws IOException {
            if (userHistory == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, userHistory.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, userHistory.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, userHistory.getEntityFixed());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, userHistory.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, userHistory.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, userHistory.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, userHistory.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, userHistory.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, userHistory.getId());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, userHistory.getLogo());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, userHistory.getDescription());
            jsonWriter.name("historyType");
            this.historyTypeAdapter.write(jsonWriter, userHistory.getHistoryType());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, userHistory.getUrl());
            jsonWriter.name("typeName");
            this.typeNameAdapter.write(jsonWriter, userHistory.getTypeName());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, userHistory.getTitle());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, userHistory.getEntityTypeName());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UserHistory read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTemplate;
            String str2 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str3 = this.defaultPic;
            String str4 = this.defaultSubTitle;
            String str5 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str6 = this.defaultId;
            String str7 = this.defaultLogo;
            String str8 = this.defaultDescription;
            String str9 = this.defaultHistoryType;
            String str10 = this.defaultUrl;
            String str11 = this.defaultTypeName;
            String str12 = this.defaultTitle;
            String str13 = this.defaultEntityTypeName;
            String str14 = str2;
            Integer num2 = num;
            String str15 = str3;
            String str16 = str4;
            String str17 = str5;
            Long l3 = l;
            Long l4 = l2;
            String str18 = str6;
            String str19 = str7;
            String str20 = str8;
            String str21 = str9;
            String str22 = str10;
            String str23 = str11;
            String str24 = str;
            String str25 = str12;
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
                        case -676507419:
                            if (nextName.equals("typeName")) {
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
                        case 352026094:
                            if (nextName.equals("historyType")) {
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
                            str14 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str16 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str20 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str24 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str13 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str23 = this.typeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str17 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str18 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str15 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str22 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str19 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str25 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str21 = this.historyTypeAdapter.read(jsonReader);
                            continue;
                        case 14:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 15:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UserHistory(str24, str14, num2, str15, str16, str17, l3, l4, str18, str19, str20, str21, str22, str23, str25, str13);
        }
    }
}
