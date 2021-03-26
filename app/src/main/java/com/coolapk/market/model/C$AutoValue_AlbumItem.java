package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_AlbumItem  reason: invalid class name */
abstract class C$AutoValue_AlbumItem extends C$$AutoValue_AlbumItem {
    C$AutoValue_AlbumItem(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, int i, String str14, String str15, String str16, int i2, String str17, String str18) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, l2, l3, str10, str11, str12, str13, i, str14, str15, str16, i2, str17, str18);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_AlbumItem$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<AlbumItem> {
        private final TypeAdapter<String> albumIdAdapter;
        private final TypeAdapter<String> apkIdAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAlbumId = null;
        private String defaultApkId = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private int defaultDisplayOrder = 0;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraAnalysisData = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultNote = null;
        private String defaultPackageName = null;
        private String defaultPic = null;
        private String defaultSourceName = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private int defaultVersionCode = 0;
        private String defaultVersionName = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> displayOrderAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraAnalysisDataAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> noteAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> sourceNameAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<Integer> versionCodeAdapter;
        private final TypeAdapter<String> versionNameAdapter;

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
            this.albumIdAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.apkIdAdapter = gson.getAdapter(String.class);
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.versionCodeAdapter = gson.getAdapter(Integer.class);
            this.versionNameAdapter = gson.getAdapter(String.class);
            this.noteAdapter = gson.getAdapter(String.class);
            this.sourceNameAdapter = gson.getAdapter(String.class);
            this.displayOrderAdapter = gson.getAdapter(Integer.class);
            this.extraAnalysisDataAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultAlbumId(String str) {
            this.defaultAlbumId = str;
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

        public GsonTypeAdapter setDefaultVersionCode(int i) {
            this.defaultVersionCode = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionName(String str) {
            this.defaultVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultNote(String str) {
            this.defaultNote = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSourceName(String str) {
            this.defaultSourceName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayOrder(int i) {
            this.defaultDisplayOrder = i;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraAnalysisData(String str) {
            this.defaultExtraAnalysisData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, AlbumItem albumItem) throws IOException {
            if (albumItem == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, albumItem.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, albumItem.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, albumItem.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, albumItem.getEntityFixed());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, albumItem.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, albumItem.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, albumItem.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, albumItem.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, albumItem.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, albumItem.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, albumItem.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, albumItem.getLastUpdate());
            jsonWriter.name("albumid");
            this.albumIdAdapter.write(jsonWriter, albumItem.getAlbumId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, albumItem.getTitle());
            jsonWriter.name("aid");
            this.apkIdAdapter.write(jsonWriter, albumItem.getApkId());
            jsonWriter.name("apkname");
            this.packageNameAdapter.write(jsonWriter, albumItem.getPackageName());
            jsonWriter.name("apkversioncode");
            this.versionCodeAdapter.write(jsonWriter, Integer.valueOf(albumItem.getVersionCode()));
            jsonWriter.name("apkversionname");
            this.versionNameAdapter.write(jsonWriter, albumItem.getVersionName());
            jsonWriter.name("note");
            this.noteAdapter.write(jsonWriter, albumItem.getNote());
            jsonWriter.name("sourceName");
            this.sourceNameAdapter.write(jsonWriter, albumItem.getSourceName());
            jsonWriter.name("displayorder");
            this.displayOrderAdapter.write(jsonWriter, Integer.valueOf(albumItem.getDisplayOrder()));
            jsonWriter.name("extraAnalysisData");
            this.extraAnalysisDataAdapter.write(jsonWriter, albumItem.getExtraAnalysisData());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, albumItem.getUrl());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public AlbumItem read(JsonReader jsonReader) throws IOException {
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
            String str10 = this.defaultAlbumId;
            String str11 = this.defaultTitle;
            String str12 = this.defaultApkId;
            String str13 = this.defaultPackageName;
            int i = this.defaultVersionCode;
            String str14 = this.defaultVersionName;
            String str15 = this.defaultNote;
            String str16 = this.defaultSourceName;
            int i2 = this.defaultDisplayOrder;
            String str17 = this.defaultExtraAnalysisData;
            String str18 = this.defaultUrl;
            String str19 = str2;
            String str20 = str3;
            Integer num2 = num;
            String str21 = str4;
            String str22 = str5;
            String str23 = str6;
            String str24 = str7;
            String str25 = str8;
            String str26 = str9;
            Long l4 = l2;
            Long l5 = l3;
            String str27 = str10;
            String str28 = str11;
            String str29 = str;
            String str30 = str12;
            String str31 = str13;
            int i3 = i;
            String str32 = str14;
            String str33 = str15;
            String str34 = str16;
            int i4 = i2;
            String str35 = str17;
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
                        case -920409142:
                            if (nextName.equals("albumid")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -797800793:
                            if (nextName.equals("apkname")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -590800682:
                            if (nextName.equals("extraAnalysisData")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 96572:
                            if (nextName.equals("aid")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3387378:
                            if (nextName.equals("note")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
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
                        case 1320549161:
                            if (nextName.equals("apkversioncode")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1320863687:
                            if (nextName.equals("apkversionname")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1629984716:
                            if (nextName.equals("displayorder")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 22;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str20 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str24 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str21 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str19 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str34 = this.sourceNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str29 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str27 = this.albumIdAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str31 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str35 = this.extraAnalysisDataAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str26 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str25 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str30 = this.apkIdAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str22 = this.picAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str23 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str33 = this.noteAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str28 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 18:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i3 = this.versionCodeAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            str32 = this.versionNameAdapter.read(jsonReader);
                            continue;
                        case 21:
                            i4 = this.displayOrderAdapter.read(jsonReader).intValue();
                            continue;
                        case 22:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_AlbumItem(str29, str19, str20, num2, str21, str22, str23, str24, str25, str26, l4, l5, str27, str28, str30, str31, i3, str32, str33, str34, i4, str35, str18);
        }
    }
}
