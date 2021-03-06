package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedTarget  reason: invalid class name */
abstract class C$AutoValue_FeedTarget extends C$$AutoValue_FeedTarget {
    C$AutoValue_FeedTarget(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, int i, float f) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l, l2, i, f);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedTarget$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedTarget> {
        private final TypeAdapter<Long> datelineAdapter;
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
        private String defaultPic = null;
        private float defaultStarAverageScore = 0.0f;
        private int defaultStarTotalCount = 0;
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
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Float> starAverageScoreAdapter;
        private final TypeAdapter<Integer> starTotalCountAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
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
            this.starTotalCountAdapter = gson.getAdapter(Integer.class);
            this.starAverageScoreAdapter = gson.getAdapter(Float.class);
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

        public GsonTypeAdapter setDefaultStarTotalCount(int i) {
            this.defaultStarTotalCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStarAverageScore(float f) {
            this.defaultStarAverageScore = f;
            return this;
        }

        public void write(JsonWriter jsonWriter, FeedTarget feedTarget) throws IOException {
            if (feedTarget == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, feedTarget.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, feedTarget.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, feedTarget.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, feedTarget.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, feedTarget.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, feedTarget.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, feedTarget.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, feedTarget.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, feedTarget.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, feedTarget.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, feedTarget.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, feedTarget.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, feedTarget.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, feedTarget.getLastUpdate());
            jsonWriter.name("star_total_count");
            this.starTotalCountAdapter.write(jsonWriter, Integer.valueOf(feedTarget.getStarTotalCount()));
            jsonWriter.name("star_average_score");
            this.starAverageScoreAdapter.write(jsonWriter, Float.valueOf(feedTarget.getStarAverageScore()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedTarget read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultTitle;
            String str5 = this.defaultUrl;
            String str6 = this.defaultDescription;
            String str7 = this.defaultPic;
            String str8 = this.defaultLogo;
            String str9 = this.defaultSubTitle;
            String str10 = this.defaultId;
            String str11 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            int i = this.defaultStarTotalCount;
            float f = this.defaultStarAverageScore;
            String str12 = str2;
            String str13 = str3;
            Integer num2 = num;
            String str14 = str4;
            String str15 = str5;
            String str16 = str6;
            String str17 = str7;
            String str18 = str8;
            String str19 = str9;
            String str20 = str10;
            String str21 = str11;
            Long l3 = l;
            Long l4 = l2;
            String str22 = str;
            int i2 = i;
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
                        case -1712093721:
                            if (nextName.equals("star_total_count")) {
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
                        case 456922819:
                            if (nextName.equals("star_average_score")) {
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
                            str13 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str19 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str16 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            i2 = this.starTotalCountAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            str12 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str22 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str21 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str20 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str17 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str15 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str18 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str14 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            f = this.starAverageScoreAdapter.read(jsonReader).floatValue();
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
            return new AutoValue_FeedTarget(str22, str12, str13, num2, str14, str15, str16, str17, str18, str19, str20, str21, l3, l4, i2, f);
        }
    }
}
