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

/* renamed from: com.coolapk.market.model.$AutoValue_FeedGoods  reason: invalid class name */
abstract class C$AutoValue_FeedGoods extends C$$AutoValue_FeedGoods {
    C$AutoValue_FeedGoods(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, String str10, String str11, String str12, String str13, long j, String str14, String str15, String str16, String str17, String str18, String str19, long j2, int i2, long j3, String str20, long j4, String str21, List<FeedGoodsCategory> list, String str22, String str23, String str24, List<ConfigPage> list2, int i3) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, l, l2, str10, str11, str12, str13, j, str14, str15, str16, str17, str18, str19, j2, i2, j3, str20, j4, str21, list, str22, str23, str24, list2, i3);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedGoods$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedGoods> {
        private final TypeAdapter<String> backendCategoryNameAdapter;
        private final TypeAdapter<String> bgColorAdapter;
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<String> buyCountAdapter;
        private final TypeAdapter<Long> categoryIdAdapter;
        private final TypeAdapter<List<FeedGoodsCategory>> categoryRowsAdapter;
        private final TypeAdapter<String> coverAdapter;
        private final TypeAdapter<Long> createTimeAdapter;
        private final TypeAdapter<String> createUidAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultBackendCategoryName = null;
        private String defaultBgColor = null;
        private int defaultBlockStatus = 0;
        private String defaultBuyCount = null;
        private long defaultCategoryId = 0;
        private List<FeedGoodsCategory> defaultCategoryRows = Collections.emptyList();
        private String defaultCover = null;
        private long defaultCreateTime = 0;
        private String defaultCreateUid = null;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFromApi = 0;
        private String defaultId = null;
        private String defaultKeyWords = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMallName = null;
        private String defaultMallSku = null;
        private String defaultPic = null;
        private String defaultPrice = null;
        private long defaultSellTime = 0;
        private String defaultSellUrl = null;
        private String defaultSkuId = null;
        private String defaultSubTitle = null;
        private List<ConfigPage> defaultTabApiList = Collections.emptyList();
        private String defaultTitle = null;
        private long defaultUpdateTime = 0;
        private String defaultUpdateUid = null;
        private String defaultUrl = null;
        private String defaultWishCount = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> fromApiAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> keyWordsAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> mallNameAdapter;
        private final TypeAdapter<String> mallSkuAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> priceAdapter;
        private final TypeAdapter<Long> sellTimeAdapter;
        private final TypeAdapter<String> sellUrlAdapter;
        private final TypeAdapter<String> skuIdAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<List<ConfigPage>> tabApiListAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<Long> updateTimeAdapter;
        private final TypeAdapter<String> updateUidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> wishCountAdapter;

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
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.mallNameAdapter = gson.getAdapter(String.class);
            this.skuIdAdapter = gson.getAdapter(String.class);
            this.mallSkuAdapter = gson.getAdapter(String.class);
            this.categoryIdAdapter = gson.getAdapter(Long.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.coverAdapter = gson.getAdapter(String.class);
            this.wishCountAdapter = gson.getAdapter(String.class);
            this.buyCountAdapter = gson.getAdapter(String.class);
            this.keyWordsAdapter = gson.getAdapter(String.class);
            this.sellUrlAdapter = gson.getAdapter(String.class);
            this.sellTimeAdapter = gson.getAdapter(Long.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.createTimeAdapter = gson.getAdapter(Long.class);
            this.createUidAdapter = gson.getAdapter(String.class);
            this.updateTimeAdapter = gson.getAdapter(Long.class);
            this.updateUidAdapter = gson.getAdapter(String.class);
            this.categoryRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, FeedGoodsCategory.class));
            this.bgColorAdapter = gson.getAdapter(String.class);
            this.backendCategoryNameAdapter = gson.getAdapter(String.class);
            this.priceAdapter = gson.getAdapter(String.class);
            this.tabApiListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, ConfigPage.class));
            this.fromApiAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultMallName(String str) {
            this.defaultMallName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSkuId(String str) {
            this.defaultSkuId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMallSku(String str) {
            this.defaultMallSku = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryId(long j) {
            this.defaultCategoryId = j;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCover(String str) {
            this.defaultCover = str;
            return this;
        }

        public GsonTypeAdapter setDefaultWishCount(String str) {
            this.defaultWishCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBuyCount(String str) {
            this.defaultBuyCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKeyWords(String str) {
            this.defaultKeyWords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSellUrl(String str) {
            this.defaultSellUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSellTime(long j) {
            this.defaultSellTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateTime(long j) {
            this.defaultCreateTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultCreateUid(String str) {
            this.defaultCreateUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateTime(long j) {
            this.defaultUpdateTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultUpdateUid(String str) {
            this.defaultUpdateUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryRows(List<FeedGoodsCategory> list) {
            this.defaultCategoryRows = list;
            return this;
        }

        public GsonTypeAdapter setDefaultBgColor(String str) {
            this.defaultBgColor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBackendCategoryName(String str) {
            this.defaultBackendCategoryName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPrice(String str) {
            this.defaultPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTabApiList(List<ConfigPage> list) {
            this.defaultTabApiList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultFromApi(int i) {
            this.defaultFromApi = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, FeedGoods feedGoods) throws IOException {
            if (feedGoods == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, feedGoods.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, feedGoods.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(feedGoods.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, feedGoods.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, feedGoods.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, feedGoods.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, feedGoods.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, feedGoods.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, feedGoods.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, feedGoods.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, feedGoods.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, feedGoods.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, feedGoods.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, feedGoods.getId());
            jsonWriter.name("mall_name");
            this.mallNameAdapter.write(jsonWriter, feedGoods.getMallName());
            jsonWriter.name("sku_id");
            this.skuIdAdapter.write(jsonWriter, feedGoods.getSkuId());
            jsonWriter.name("mall_sku");
            this.mallSkuAdapter.write(jsonWriter, feedGoods.getMallSku());
            jsonWriter.name("category_id");
            this.categoryIdAdapter.write(jsonWriter, Long.valueOf(feedGoods.getCategoryId()));
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, feedGoods.getTitle());
            jsonWriter.name("cover");
            this.coverAdapter.write(jsonWriter, feedGoods.getCover());
            jsonWriter.name("wish_count");
            this.wishCountAdapter.write(jsonWriter, feedGoods.getWishCount());
            jsonWriter.name("buy_count");
            this.buyCountAdapter.write(jsonWriter, feedGoods.getBuyCount());
            jsonWriter.name("keywords");
            this.keyWordsAdapter.write(jsonWriter, feedGoods.getKeyWords());
            jsonWriter.name("sell_url");
            this.sellUrlAdapter.write(jsonWriter, feedGoods.getSellUrl());
            jsonWriter.name("sell_time");
            this.sellTimeAdapter.write(jsonWriter, Long.valueOf(feedGoods.getSellTime()));
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(feedGoods.getBlockStatus()));
            jsonWriter.name("create_time");
            this.createTimeAdapter.write(jsonWriter, Long.valueOf(feedGoods.getCreateTime()));
            jsonWriter.name("create_uid");
            this.createUidAdapter.write(jsonWriter, feedGoods.getCreateUid());
            jsonWriter.name("update_time");
            this.updateTimeAdapter.write(jsonWriter, Long.valueOf(feedGoods.getUpdateTime()));
            jsonWriter.name("update_uid");
            this.updateUidAdapter.write(jsonWriter, feedGoods.getUpdateUid());
            jsonWriter.name("categoryRows");
            this.categoryRowsAdapter.write(jsonWriter, feedGoods.getCategoryRows());
            jsonWriter.name("bgColor");
            this.bgColorAdapter.write(jsonWriter, feedGoods.getBgColor());
            jsonWriter.name("category_name");
            this.backendCategoryNameAdapter.write(jsonWriter, feedGoods.getBackendCategoryName());
            jsonWriter.name("price");
            this.priceAdapter.write(jsonWriter, feedGoods.getPrice());
            jsonWriter.name("tabList");
            this.tabApiListAdapter.write(jsonWriter, feedGoods.getTabApiList());
            jsonWriter.name("fromApi");
            this.fromApiAdapter.write(jsonWriter, Integer.valueOf(feedGoods.getFromApi()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedGoods read(JsonReader jsonReader) throws IOException {
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
            String str9 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str10 = this.defaultId;
            String str11 = this.defaultMallName;
            String str12 = this.defaultSkuId;
            String str13 = this.defaultMallSku;
            long j = this.defaultCategoryId;
            String str14 = this.defaultTitle;
            String str15 = this.defaultCover;
            String str16 = this.defaultWishCount;
            String str17 = this.defaultBuyCount;
            String str18 = this.defaultKeyWords;
            String str19 = this.defaultSellUrl;
            long j2 = this.defaultSellTime;
            int i2 = this.defaultBlockStatus;
            long j3 = this.defaultCreateTime;
            String str20 = this.defaultCreateUid;
            long j4 = this.defaultUpdateTime;
            String str21 = this.defaultUpdateUid;
            List<FeedGoodsCategory> list = this.defaultCategoryRows;
            String str22 = this.defaultBgColor;
            String str23 = this.defaultBackendCategoryName;
            String str24 = this.defaultPrice;
            List<ConfigPage> list2 = this.defaultTabApiList;
            int i3 = this.defaultFromApi;
            List<FeedGoodsCategory> list3 = list;
            int i4 = i;
            String str25 = str3;
            Integer num2 = num;
            String str26 = str4;
            String str27 = str5;
            String str28 = str6;
            String str29 = str7;
            String str30 = str8;
            String str31 = str9;
            Long l3 = l;
            Long l4 = l2;
            String str32 = str10;
            String str33 = str;
            String str34 = str11;
            String str35 = str12;
            String str36 = str2;
            String str37 = str13;
            long j5 = j;
            String str38 = str14;
            String str39 = str16;
            String str40 = str17;
            String str41 = str18;
            String str42 = str15;
            String str43 = str19;
            long j6 = j2;
            int i5 = i2;
            long j7 = j3;
            String str44 = str20;
            long j8 = j4;
            String str45 = str21;
            String str46 = str22;
            String str47 = str23;
            String str48 = str24;
            List<ConfigPage> list4 = list2;
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
                        case -1553853997:
                            if (nextName.equals("tabList")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1519255654:
                            if (nextName.equals("sell_time")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
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
                        case -900217987:
                            if (nextName.equals("sku_id")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -594357744:
                            if (nextName.equals("fromApi")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -573446013:
                            if (nextName.equals("update_time")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -493574096:
                            if (nextName.equals("create_time")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -458115562:
                            if (nextName.equals("buy_count")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -295591974:
                            if (nextName.equals("update_uid")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -204859874:
                            if (nextName.equals("bgColor")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 75942002:
                            if (nextName.equals("mall_sku")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 94852023:
                            if (nextName.equals("cover")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 106934601:
                            if (nextName.equals("price")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 338683180:
                            if (nextName.equals("category_name")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 426181623:
                            if (nextName.equals("categoryRows")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 765987703:
                            if (nextName.equals("wish_count")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 1197918978:
                            if (nextName.equals("sell_url")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 1369552525:
                            if (nextName.equals("create_uid")) {
                                c = '!';
                                break;
                            }
                            break;
                        case 1537780732:
                            if (nextName.equals("category_id")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '#';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str25 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str30 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str34 = this.mallNameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str27 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str36 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            list4 = this.tabApiListAdapter.read(jsonReader);
                            continue;
                        case 6:
                            j6 = this.sellTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 7:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str33 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str35 = this.skuIdAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i5 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            i3 = this.fromApiAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            j8 = this.updateTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case '\r':
                            j7 = this.createTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 14:
                            str40 = this.buyCountAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str45 = this.updateUidAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str31 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str46 = this.bgColorAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str32 = this.idAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str28 = this.picAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str26 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str29 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str37 = this.mallSkuAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str42 = this.coverAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str48 = this.priceAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str38 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 26:
                            str47 = this.backendCategoryNameAdapter.read(jsonReader);
                            continue;
                        case 27:
                            list3 = this.categoryRowsAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str41 = this.keyWordsAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str39 = this.wishCountAdapter.read(jsonReader);
                            continue;
                        case 30:
                            i4 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 31:
                            str43 = this.sellUrlAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case '!':
                            str44 = this.createUidAdapter.read(jsonReader);
                            continue;
                        case '\"':
                            j5 = this.categoryIdAdapter.read(jsonReader).longValue();
                            continue;
                        case '#':
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedGoods(str33, str36, i4, str25, num2, str26, str27, str28, str29, str30, str31, l3, l4, str32, str34, str35, str37, j5, str38, str42, str39, str40, str41, str43, j6, i5, j7, str44, j8, str45, list3, str46, str47, str48, list4, i3);
        }
    }
}
