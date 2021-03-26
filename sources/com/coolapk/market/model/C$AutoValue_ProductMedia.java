package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_ProductMedia  reason: invalid class name */
abstract class C$AutoValue_ProductMedia extends C$$AutoValue_ProductMedia {
    C$AutoValue_ProductMedia(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i2) {
        super(str, str2, str3, i, str4, num, str5, str6, str7, str8, str9, str10, str11, l2, l3, str12, str13, str14, str15, str16, str17, str18, str19, i2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ProductMedia$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ProductMedia> {
        private final TypeAdapter<String> UIDAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultFeedId = null;
        private String defaultId = null;
        private int defaultIsRecommend = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMediaInfo = null;
        private String defaultPic = null;
        private String defaultProductId = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultType = null;
        private String defaultUID = null;
        private String defaultUrl = null;
        private String defaultUrlMd5 = null;
        private String defaultUserName = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isRecommendAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> mediaInfoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> productIdAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> typeAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> urlMd5Adapter;
        private final TypeAdapter<String> userNameAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityTypeIdAdapter = gson.getAdapter(Integer.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.productIdAdapter = gson.getAdapter(String.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.UIDAdapter = gson.getAdapter(String.class);
            this.userNameAdapter = gson.getAdapter(String.class);
            this.typeAdapter = gson.getAdapter(String.class);
            this.mediaInfoAdapter = gson.getAdapter(String.class);
            this.urlMd5Adapter = gson.getAdapter(String.class);
            this.isRecommendAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductId(String str) {
            this.defaultProductId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUID(String str) {
            this.defaultUID = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserName(String str) {
            this.defaultUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultType(String str) {
            this.defaultType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaInfo(String str) {
            this.defaultMediaInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrlMd5(String str) {
            this.defaultUrlMd5 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsRecommend(int i) {
            this.defaultIsRecommend = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, ProductMedia productMedia) throws IOException {
            if (productMedia == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, productMedia.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, productMedia.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, productMedia.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(productMedia.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, productMedia.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, productMedia.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, productMedia.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, productMedia.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, productMedia.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, productMedia.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, productMedia.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, productMedia.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, productMedia.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, productMedia.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, productMedia.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, productMedia.getId());
            jsonWriter.name("product_id");
            this.productIdAdapter.write(jsonWriter, productMedia.getProductId());
            jsonWriter.name("feed_id");
            this.feedIdAdapter.write(jsonWriter, productMedia.getFeedId());
            jsonWriter.name("uid");
            this.UIDAdapter.write(jsonWriter, productMedia.getUID());
            jsonWriter.name("username");
            this.userNameAdapter.write(jsonWriter, productMedia.getUserName());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, productMedia.getType());
            jsonWriter.name("media_info");
            this.mediaInfoAdapter.write(jsonWriter, productMedia.getMediaInfo());
            jsonWriter.name("url_md5");
            this.urlMd5Adapter.write(jsonWriter, productMedia.getUrlMd5());
            jsonWriter.name("is_recommend");
            this.isRecommendAdapter.write(jsonWriter, Integer.valueOf(productMedia.getIsRecommend()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ProductMedia read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityType;
            String str3 = this.defaultEntityTemplate;
            int i = this.defaultEntityTypeId;
            String str4 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str5 = this.defaultTitle;
            String str6 = this.defaultUrl;
            String str7 = this.defaultDescription;
            String str8 = this.defaultPic;
            String str9 = this.defaultLogo;
            String str10 = this.defaultSubTitle;
            String str11 = this.defaultExtraData;
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str12 = this.defaultId;
            String str13 = this.defaultProductId;
            String str14 = this.defaultFeedId;
            String str15 = this.defaultUID;
            String str16 = this.defaultUserName;
            String str17 = this.defaultType;
            String str18 = this.defaultMediaInfo;
            String str19 = this.defaultUrlMd5;
            int i2 = this.defaultIsRecommend;
            String str20 = str2;
            String str21 = str3;
            int i3 = i;
            String str22 = str4;
            Integer num2 = num;
            String str23 = str5;
            String str24 = str6;
            String str25 = str7;
            String str26 = str8;
            String str27 = str9;
            String str28 = str10;
            String str29 = str11;
            Long l4 = l2;
            String str30 = str;
            Long l5 = l3;
            String str31 = str12;
            String str32 = str13;
            String str33 = str14;
            String str34 = str15;
            String str35 = str16;
            String str36 = str17;
            String str37 = str18;
            String str38 = str19;
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
                        case -976011428:
                            if (nextName.equals("feed_id")) {
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
                        case -321901593:
                            if (nextName.equals("is_recommend")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
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
                        case -169850194:
                            if (nextName.equals("url_md5")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
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
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1753008747:
                            if (nextName.equals("product_id")) {
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
                        case 1939536937:
                            if (nextName.equals("media_info")) {
                                c = 23;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str22 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str28 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str25 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str21 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str20 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str33 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str30 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            i2 = this.isRecommendAdapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            str35 = this.userNameAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str29 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str38 = this.urlMd5Adapter.read(jsonReader);
                            continue;
                        case '\f':
                            str31 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str26 = this.picAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str34 = this.UIDAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str24 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str27 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str36 = this.typeAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str23 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i3 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str32 = this.productIdAdapter.read(jsonReader);
                            continue;
                        case 22:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str37 = this.mediaInfoAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ProductMedia(str30, str20, str21, i3, str22, num2, str23, str24, str25, str26, str27, str28, str29, l4, l5, str31, str32, str33, str34, str35, str36, str37, str38, i2);
        }
    }
}
