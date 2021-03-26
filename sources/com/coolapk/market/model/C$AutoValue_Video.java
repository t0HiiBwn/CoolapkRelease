package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Video  reason: invalid class name */
abstract class C$AutoValue_Video extends C$$AutoValue_Video {
    C$AutoValue_Video(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, int i2, boolean z, String str13, String str14, String str15, boolean z2) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, str10, l, l2, str11, str12, i2, z, str13, str14, str15, z2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Video$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Video> {
        private final TypeAdapter<String> coverAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultCover = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private int defaultDuration = 0;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private boolean defaultIsLive = false;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMediaType = null;
        private String defaultName = null;
        private String defaultPic = null;
        private String defaultPlayHeaders = null;
        private boolean defaultRedirectSource = false;
        private String defaultRequestParams = null;
        private String defaultSubTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> durationAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Boolean> isLiveAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> mediaTypeAdapter;
        private final TypeAdapter<String> nameAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> playHeadersAdapter;
        private final TypeAdapter<Boolean> redirectSourceAdapter;
        private final TypeAdapter<String> requestParamsAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityTypeIdAdapter = gson.getAdapter(Integer.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.nameAdapter = gson.getAdapter(String.class);
            this.coverAdapter = gson.getAdapter(String.class);
            this.durationAdapter = gson.getAdapter(Integer.class);
            this.isLiveAdapter = gson.getAdapter(Boolean.class);
            this.mediaTypeAdapter = gson.getAdapter(String.class);
            this.requestParamsAdapter = gson.getAdapter(String.class);
            this.playHeadersAdapter = gson.getAdapter(String.class);
            this.redirectSourceAdapter = gson.getAdapter(Boolean.class);
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTemplate(String str) {
            this.defaultEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTypeId(int i) {
            this.defaultEntityTypeId = i;
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

        public GsonTypeAdapter setDefaultName(String str) {
            this.defaultName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCover(String str) {
            this.defaultCover = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDuration(int i) {
            this.defaultDuration = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsLive(boolean z) {
            this.defaultIsLive = z;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaType(String str) {
            this.defaultMediaType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRequestParams(String str) {
            this.defaultRequestParams = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPlayHeaders(String str) {
            this.defaultPlayHeaders = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRedirectSource(boolean z) {
            this.defaultRedirectSource = z;
            return this;
        }

        public void write(JsonWriter jsonWriter, Video video) throws IOException {
            if (video == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, video.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, video.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(video.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, video.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, video.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, video.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, video.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, video.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, video.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, video.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, video.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, video.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, video.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, video.getLastUpdate());
            jsonWriter.name("name");
            this.nameAdapter.write(jsonWriter, video.getName());
            jsonWriter.name("cover");
            this.coverAdapter.write(jsonWriter, video.getCover());
            jsonWriter.name("duration");
            this.durationAdapter.write(jsonWriter, Integer.valueOf(video.getDuration()));
            jsonWriter.name("isLive");
            this.isLiveAdapter.write(jsonWriter, Boolean.valueOf(video.getIsLive()));
            jsonWriter.name("mediaType");
            this.mediaTypeAdapter.write(jsonWriter, video.getMediaType());
            jsonWriter.name("requestParams");
            this.requestParamsAdapter.write(jsonWriter, video.getRequestParams());
            jsonWriter.name("playHeaders");
            this.playHeadersAdapter.write(jsonWriter, video.getPlayHeaders());
            jsonWriter.name("redirectSource");
            this.redirectSourceAdapter.write(jsonWriter, Boolean.valueOf(video.isRedirectSource()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Video read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            int i = this.defaultEntityTypeId;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultUrl;
            String str5 = this.defaultDescription;
            String str6 = this.defaultPic;
            String str7 = this.defaultLogo;
            String str8 = this.defaultSubTitle;
            String str9 = this.defaultId;
            String str10 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str11 = this.defaultName;
            String str12 = this.defaultCover;
            int i2 = this.defaultDuration;
            boolean z = this.defaultIsLive;
            String str13 = this.defaultMediaType;
            String str14 = this.defaultRequestParams;
            String str15 = this.defaultPlayHeaders;
            boolean z2 = this.defaultRedirectSource;
            String str16 = str2;
            int i3 = i;
            String str17 = str3;
            Integer num2 = num;
            String str18 = str4;
            String str19 = str5;
            String str20 = str6;
            String str21 = str7;
            String str22 = str8;
            String str23 = str9;
            String str24 = str10;
            Long l3 = l;
            Long l4 = l2;
            String str25 = str;
            String str26 = str11;
            String str27 = str12;
            int i4 = i2;
            boolean z3 = z;
            String str28 = str13;
            String str29 = str14;
            String str30 = str15;
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
                        case -1992012396:
                            if (nextName.equals("duration")) {
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
                        case -1180332746:
                            if (nextName.equals("isLive")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1044908265:
                            if (nextName.equals("redirectSource")) {
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
                        case 3373707:
                            if (nextName.equals("name")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 94852023:
                            if (nextName.equals("cover")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 218511794:
                            if (nextName.equals("playHeaders")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
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
                        case 1300001013:
                            if (nextName.equals("requestParams")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 2140463422:
                            if (nextName.equals("mediaType")) {
                                c = 21;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str17 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str22 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i4 = this.durationAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str19 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str16 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            z3 = this.isLiveAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 7:
                            z2 = this.redirectSourceAdapter.read(jsonReader).booleanValue();
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
                            str26 = this.nameAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str27 = this.coverAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str30 = this.playHeadersAdapter.read(jsonReader);
                            continue;
                        case 17:
                            i3 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str29 = this.requestParamsAdapter.read(jsonReader);
                            continue;
                        case 20:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str28 = this.mediaTypeAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Video(str25, str16, i3, str17, num2, str18, str19, str20, str21, str22, str23, str24, l3, l4, str26, str27, i4, z3, str28, str29, str30, z2);
        }
    }
}
