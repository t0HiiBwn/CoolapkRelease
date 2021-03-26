package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_GoodsListItem  reason: invalid class name */
abstract class C$AutoValue_GoodsListItem extends C$$AutoValue_GoodsListItem {
    C$AutoValue_GoodsListItem(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i2, Long l3) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, str10, l2, str11, str12, str13, str14, str15, str16, str17, str18, str19, i2, l3);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_GoodsListItem$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<GoodsListItem> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultFeedId = null;
        private String defaultGoodsUrl = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMallName = null;
        private String defaultNote = null;
        private String defaultPic = null;
        private String defaultPrice = null;
        private String defaultProductGoodsId = null;
        private String defaultProductGoodsLogo = null;
        private String defaultProductGoodsTitle = null;
        private int defaultSort = 0;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<String> goodsUrlAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> mallNameAdapter;
        private final TypeAdapter<String> noteAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> priceAdapter;
        private final TypeAdapter<String> productGoodsIdAdapter;
        private final TypeAdapter<String> productGoodsLogoAdapter;
        private final TypeAdapter<String> productGoodsTitleAdapter;
        private final TypeAdapter<Integer> sortAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
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
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.productGoodsIdAdapter = gson.getAdapter(String.class);
            this.productGoodsLogoAdapter = gson.getAdapter(String.class);
            this.productGoodsTitleAdapter = gson.getAdapter(String.class);
            this.goodsUrlAdapter = gson.getAdapter(String.class);
            this.priceAdapter = gson.getAdapter(String.class);
            this.mallNameAdapter = gson.getAdapter(String.class);
            this.noteAdapter = gson.getAdapter(String.class);
            this.sortAdapter = gson.getAdapter(Integer.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
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

        public GsonTypeAdapter setDefaultLastUpdate(Long l2) {
            this.defaultLastUpdate = l2;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductGoodsId(String str) {
            this.defaultProductGoodsId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductGoodsLogo(String str) {
            this.defaultProductGoodsLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductGoodsTitle(String str) {
            this.defaultProductGoodsTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsUrl(String str) {
            this.defaultGoodsUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPrice(String str) {
            this.defaultPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMallName(String str) {
            this.defaultMallName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultNote(String str) {
            this.defaultNote = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSort(int i) {
            this.defaultSort = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDateline(Long l2) {
            this.defaultDateline = l2;
            return this;
        }

        public void write(JsonWriter jsonWriter, GoodsListItem goodsListItem) throws IOException {
            if (goodsListItem == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, goodsListItem.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, goodsListItem.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(goodsListItem.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, goodsListItem.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, goodsListItem.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, goodsListItem.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, goodsListItem.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, goodsListItem.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, goodsListItem.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, goodsListItem.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, goodsListItem.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, goodsListItem.getExtraData());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, goodsListItem.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, goodsListItem.getId());
            jsonWriter.name("feed_id");
            this.feedIdAdapter.write(jsonWriter, goodsListItem.getFeedId());
            jsonWriter.name("product_goods_id");
            this.productGoodsIdAdapter.write(jsonWriter, goodsListItem.getProductGoodsId());
            jsonWriter.name("product_goods_cover");
            this.productGoodsLogoAdapter.write(jsonWriter, goodsListItem.getProductGoodsLogo());
            jsonWriter.name("product_goods_title");
            this.productGoodsTitleAdapter.write(jsonWriter, goodsListItem.getProductGoodsTitle());
            jsonWriter.name("product_goods_url");
            this.goodsUrlAdapter.write(jsonWriter, goodsListItem.getGoodsUrl());
            jsonWriter.name("price");
            this.priceAdapter.write(jsonWriter, goodsListItem.getPrice());
            jsonWriter.name("mall_name");
            this.mallNameAdapter.write(jsonWriter, goodsListItem.getMallName());
            jsonWriter.name("note");
            this.noteAdapter.write(jsonWriter, goodsListItem.getNote());
            jsonWriter.name("sort");
            this.sortAdapter.write(jsonWriter, Integer.valueOf(goodsListItem.getSort()));
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, goodsListItem.getDateline());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public GoodsListItem read(JsonReader jsonReader) throws IOException {
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
            String str4 = this.defaultTitle;
            String str5 = this.defaultUrl;
            String str6 = this.defaultDescription;
            String str7 = this.defaultPic;
            String str8 = this.defaultLogo;
            String str9 = this.defaultSubTitle;
            String str10 = this.defaultExtraData;
            Long l2 = this.defaultLastUpdate;
            String str11 = this.defaultId;
            String str12 = this.defaultFeedId;
            String str13 = this.defaultProductGoodsId;
            String str14 = this.defaultProductGoodsLogo;
            String str15 = this.defaultProductGoodsTitle;
            String str16 = this.defaultGoodsUrl;
            String str17 = this.defaultPrice;
            String str18 = this.defaultMallName;
            String str19 = this.defaultNote;
            int i2 = this.defaultSort;
            Long l3 = this.defaultDateline;
            String str20 = str2;
            int i3 = i;
            String str21 = str3;
            Integer num2 = num;
            String str22 = str4;
            String str23 = str5;
            String str24 = str6;
            String str25 = str7;
            String str26 = str8;
            String str27 = str9;
            String str28 = str10;
            Long l4 = l2;
            String str29 = str11;
            String str30 = str;
            String str31 = str12;
            String str32 = str13;
            String str33 = str14;
            String str34 = str15;
            String str35 = str16;
            String str36 = str17;
            String str37 = str18;
            String str38 = str19;
            int i4 = i2;
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
                        case -1940923946:
                            if (nextName.equals("mall_name")) {
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
                        case 3387378:
                            if (nextName.equals("note")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 3536286:
                            if (nextName.equals("sort")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 106934601:
                            if (nextName.equals("price")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 254358078:
                            if (nextName.equals("product_goods_cover")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 269877471:
                            if (nextName.equals("product_goods_title")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 465245172:
                            if (nextName.equals("product_goods_id")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1537710518:
                            if (nextName.equals("product_goods_url")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 23;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str21 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str27 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str37 = this.mallNameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str24 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str20 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str31 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str30 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str28 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str29 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str25 = this.picAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str23 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str26 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str38 = this.noteAdapter.read(jsonReader);
                            continue;
                        case 14:
                            i4 = this.sortAdapter.read(jsonReader).intValue();
                            continue;
                        case 15:
                            str36 = this.priceAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str22 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str33 = this.productGoodsLogoAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str34 = this.productGoodsTitleAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str32 = this.productGoodsIdAdapter.read(jsonReader);
                            continue;
                        case 20:
                            i3 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str35 = this.goodsUrlAdapter.read(jsonReader);
                            continue;
                        case 23:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_GoodsListItem(str30, str20, i3, str21, num2, str22, str23, str24, str25, str26, str27, str28, l4, str29, str31, str32, str33, str34, str35, str36, str37, str38, i4, l3);
        }
    }
}
