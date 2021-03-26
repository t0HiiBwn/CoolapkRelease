package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Goods  reason: invalid class name */
abstract class C$AutoValue_Goods extends C$$AutoValue_Goods {
    C$AutoValue_Goods(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, GoodsCategoryInfo goodsCategoryInfo, int i2, MallInfo mallInfo, String str20, String str21) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, str10, l2, l3, str11, str12, str13, str14, str15, str16, str17, str18, str19, goodsCategoryInfo, i2, mallInfo, str20, str21);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Goods$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Goods> {
        private final TypeAdapter<GoodsCategoryInfo> categoryInfoAdapter;
        private final TypeAdapter<String> categoryTitleAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private GoodsCategoryInfo defaultCategoryInfo = null;
        private String defaultCategoryTitle = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultGoodIsDirect = 0;
        private String defaultGoodsBuyText = null;
        private String defaultGoodsBuyUrl = null;
        private String defaultGoodsPic = null;
        private String defaultGoodsTags = null;
        private String defaultGoodsTitle = null;
        private String defaultGoodsUrl = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private MallInfo defaultMallInfo = null;
        private String defaultMallTitle = null;
        private String defaultPic = null;
        private String defaultPromoPrice = null;
        private String defaultPromoTitle = null;
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
        private final TypeAdapter<Integer> goodIsDirectAdapter;
        private final TypeAdapter<String> goodsBuyTextAdapter;
        private final TypeAdapter<String> goodsBuyUrlAdapter;
        private final TypeAdapter<String> goodsPicAdapter;
        private final TypeAdapter<String> goodsTagsAdapter;
        private final TypeAdapter<String> goodsTitleAdapter;
        private final TypeAdapter<String> goodsUrlAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<MallInfo> mallInfoAdapter;
        private final TypeAdapter<String> mallTitleAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> promoPriceAdapter;
        private final TypeAdapter<String> promoTitleAdapter;
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
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.goodsTitleAdapter = gson.getAdapter(String.class);
            this.promoTitleAdapter = gson.getAdapter(String.class);
            this.promoPriceAdapter = gson.getAdapter(String.class);
            this.goodsPicAdapter = gson.getAdapter(String.class);
            this.goodsTagsAdapter = gson.getAdapter(String.class);
            this.goodsUrlAdapter = gson.getAdapter(String.class);
            this.goodsBuyUrlAdapter = gson.getAdapter(String.class);
            this.goodsBuyTextAdapter = gson.getAdapter(String.class);
            this.categoryInfoAdapter = gson.getAdapter(GoodsCategoryInfo.class);
            this.goodIsDirectAdapter = gson.getAdapter(Integer.class);
            this.mallInfoAdapter = gson.getAdapter(MallInfo.class);
            this.categoryTitleAdapter = gson.getAdapter(String.class);
            this.mallTitleAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultGoodsTitle(String str) {
            this.defaultGoodsTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPromoTitle(String str) {
            this.defaultPromoTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPromoPrice(String str) {
            this.defaultPromoPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsPic(String str) {
            this.defaultGoodsPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsTags(String str) {
            this.defaultGoodsTags = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsUrl(String str) {
            this.defaultGoodsUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsBuyUrl(String str) {
            this.defaultGoodsBuyUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsBuyText(String str) {
            this.defaultGoodsBuyText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryInfo(GoodsCategoryInfo goodsCategoryInfo) {
            this.defaultCategoryInfo = goodsCategoryInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodIsDirect(int i) {
            this.defaultGoodIsDirect = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMallInfo(MallInfo mallInfo) {
            this.defaultMallInfo = mallInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryTitle(String str) {
            this.defaultCategoryTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMallTitle(String str) {
            this.defaultMallTitle = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, Goods goods) throws IOException {
            if (goods == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, goods.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, goods.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(goods.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, goods.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, goods.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, goods.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, goods.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, goods.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, goods.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, goods.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, goods.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, goods.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, goods.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, goods.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, goods.getId());
            jsonWriter.name("goods_title");
            this.goodsTitleAdapter.write(jsonWriter, goods.getGoodsTitle());
            jsonWriter.name("goods_promo_title");
            this.promoTitleAdapter.write(jsonWriter, goods.getPromoTitle());
            jsonWriter.name("goods_promo_price");
            this.promoPriceAdapter.write(jsonWriter, goods.getPromoPrice());
            jsonWriter.name("goods_pic");
            this.goodsPicAdapter.write(jsonWriter, goods.getGoodsPic());
            jsonWriter.name("goods_tags");
            this.goodsTagsAdapter.write(jsonWriter, goods.getGoodsTags());
            jsonWriter.name("goods_url");
            this.goodsUrlAdapter.write(jsonWriter, goods.getGoodsUrl());
            jsonWriter.name("goods_buy_url");
            this.goodsBuyUrlAdapter.write(jsonWriter, goods.getGoodsBuyUrl());
            jsonWriter.name("goods_buy_text");
            this.goodsBuyTextAdapter.write(jsonWriter, goods.getGoodsBuyText());
            jsonWriter.name("categoryInfo");
            this.categoryInfoAdapter.write(jsonWriter, goods.getCategoryInfo());
            jsonWriter.name("goods_is_direct");
            this.goodIsDirectAdapter.write(jsonWriter, Integer.valueOf(goods.getGoodIsDirect()));
            jsonWriter.name("mallInfo");
            this.mallInfoAdapter.write(jsonWriter, goods.getMallInfo());
            jsonWriter.name("category_title");
            this.categoryTitleAdapter.write(jsonWriter, goods.getCategoryTitle());
            jsonWriter.name("mall_title");
            this.mallTitleAdapter.write(jsonWriter, goods.getMallTitle());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Goods read(JsonReader jsonReader) throws IOException {
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
            Long l2 = this.defaultDateline;
            Long l3 = this.defaultLastUpdate;
            String str11 = this.defaultId;
            String str12 = this.defaultGoodsTitle;
            String str13 = this.defaultPromoTitle;
            String str14 = this.defaultPromoPrice;
            String str15 = this.defaultGoodsPic;
            String str16 = this.defaultGoodsTags;
            String str17 = this.defaultGoodsUrl;
            String str18 = this.defaultGoodsBuyUrl;
            String str19 = this.defaultGoodsBuyText;
            GoodsCategoryInfo goodsCategoryInfo = this.defaultCategoryInfo;
            int i2 = this.defaultGoodIsDirect;
            MallInfo mallInfo = this.defaultMallInfo;
            String str20 = this.defaultCategoryTitle;
            String str21 = this.defaultMallTitle;
            String str22 = str2;
            int i3 = i;
            String str23 = str3;
            Integer num2 = num;
            String str24 = str4;
            String str25 = str5;
            String str26 = str6;
            String str27 = str7;
            String str28 = str8;
            String str29 = str9;
            String str30 = str10;
            Long l4 = l2;
            Long l5 = l3;
            String str31 = str;
            String str32 = str11;
            String str33 = str12;
            String str34 = str13;
            String str35 = str14;
            String str36 = str15;
            String str37 = str16;
            String str38 = str17;
            String str39 = str18;
            String str40 = str19;
            GoodsCategoryInfo goodsCategoryInfo2 = goodsCategoryInfo;
            int i4 = i2;
            MallInfo mallInfo2 = mallInfo;
            String str41 = str20;
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
                        case -655481099:
                            if (nextName.equals("goods_is_direct")) {
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
                        case -33313683:
                            if (nextName.equals("mall_title")) {
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
                        case 75281634:
                            if (nextName.equals("mallInfo")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 293108578:
                            if (nextName.equals("goods_tags")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 425912012:
                            if (nextName.equals("categoryInfo")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 496682031:
                            if (nextName.equals("goods_title")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1378033167:
                            if (nextName.equals("goods_buy_text")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1394924833:
                            if (nextName.equals("goods_pic")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1394929926:
                            if (nextName.equals("goods_url")) {
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
                        case 1915030487:
                            if (nextName.equals("category_title")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 2093234864:
                            if (nextName.equals("goods_promo_price")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 2096671679:
                            if (nextName.equals("goods_promo_title")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 2122664013:
                            if (nextName.equals("goods_buy_url")) {
                                c = 27;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str23 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str29 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str26 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str22 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l5 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str31 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i4 = this.goodIsDirectAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str30 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str21 = this.mallTitleAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str32 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str27 = this.picAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str25 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str28 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            mallInfo2 = this.mallInfoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str24 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str37 = this.goodsTagsAdapter.read(jsonReader);
                            continue;
                        case 16:
                            goodsCategoryInfo2 = this.categoryInfoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str33 = this.goodsTitleAdapter.read(jsonReader);
                            continue;
                        case 18:
                            i3 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str40 = this.goodsBuyTextAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str36 = this.goodsPicAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str38 = this.goodsUrlAdapter.read(jsonReader);
                            continue;
                        case 23:
                            l4 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str41 = this.categoryTitleAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str35 = this.promoPriceAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str34 = this.promoTitleAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str39 = this.goodsBuyUrlAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Goods(str31, str22, i3, str23, num2, str24, str25, str26, str27, str28, str29, str30, l4, l5, str32, str33, str34, str35, str36, str37, str38, str39, str40, goodsCategoryInfo2, i4, mallInfo2, str41, str21);
        }
    }
}
