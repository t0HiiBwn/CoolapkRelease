package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_SecondHandInfo  reason: invalid class name */
abstract class C$AutoValue_SecondHandInfo extends C$$AutoValue_SecondHandInfo {
    C$AutoValue_SecondHandInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, String str13, String str14, int i2, Long l, Long l2, String str15, int i3, int i4, int i5, String str16) {
        super(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, i, str13, str14, i2, l, l2, str15, i3, i4, i5, str16);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_SecondHandInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<SecondHandInfo> {
        private final TypeAdapter<String> cityAdapter;
        private final TypeAdapter<String> cityCodeAdapter;
        private final TypeAdapter<String> configJsonAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultCity = null;
        private String defaultCityCode = null;
        private String defaultConfigJson = null;
        private Long defaultDateline = null;
        private String defaultErshouTypeID = null;
        private String defaultErshouTypeTitle = null;
        private int defaultExchangePriceType = 0;
        private String defaultFeedId = null;
        private Long defaultLastUpdate = null;
        private String defaultLinkNotice = null;
        private String defaultLogo = null;
        private String defaultPrice = null;
        private String defaultProductConfigSource = null;
        private String defaultProductId = null;
        private String defaultProvince = null;
        private int defaultSecondHandDealType = 0;
        private int defaultSecondHandFaceDeal = 0;
        private int defaultSecondHandStatus = 0;
        private String defaultSource = null;
        private int defaultStoreType = 0;
        private String defaultStoreTypeText = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> ershouTypeIDAdapter;
        private final TypeAdapter<String> ershouTypeTitleAdapter;
        private final TypeAdapter<Integer> exchangePriceTypeAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> linkNoticeAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> priceAdapter;
        private final TypeAdapter<String> productConfigSourceAdapter;
        private final TypeAdapter<String> productIdAdapter;
        private final TypeAdapter<String> provinceAdapter;
        private final TypeAdapter<Integer> secondHandDealTypeAdapter;
        private final TypeAdapter<Integer> secondHandFaceDealAdapter;
        private final TypeAdapter<Integer> secondHandStatusAdapter;
        private final TypeAdapter<String> sourceAdapter;
        private final TypeAdapter<Integer> storeTypeAdapter;
        private final TypeAdapter<String> storeTypeTextAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.priceAdapter = gson.getAdapter(String.class);
            this.configJsonAdapter = gson.getAdapter(String.class);
            this.productConfigSourceAdapter = gson.getAdapter(String.class);
            this.productIdAdapter = gson.getAdapter(String.class);
            this.ershouTypeTitleAdapter = gson.getAdapter(String.class);
            this.ershouTypeIDAdapter = gson.getAdapter(String.class);
            this.cityAdapter = gson.getAdapter(String.class);
            this.provinceAdapter = gson.getAdapter(String.class);
            this.cityCodeAdapter = gson.getAdapter(String.class);
            this.storeTypeAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.sourceAdapter = gson.getAdapter(String.class);
            this.secondHandStatusAdapter = gson.getAdapter(Integer.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.storeTypeTextAdapter = gson.getAdapter(String.class);
            this.secondHandDealTypeAdapter = gson.getAdapter(Integer.class);
            this.secondHandFaceDealAdapter = gson.getAdapter(Integer.class);
            this.exchangePriceTypeAdapter = gson.getAdapter(Integer.class);
            this.linkNoticeAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPrice(String str) {
            this.defaultPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultConfigJson(String str) {
            this.defaultConfigJson = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductConfigSource(String str) {
            this.defaultProductConfigSource = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductId(String str) {
            this.defaultProductId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultErshouTypeTitle(String str) {
            this.defaultErshouTypeTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultErshouTypeID(String str) {
            this.defaultErshouTypeID = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCity(String str) {
            this.defaultCity = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProvince(String str) {
            this.defaultProvince = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCityCode(String str) {
            this.defaultCityCode = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStoreType(int i) {
            this.defaultStoreType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSource(String str) {
            this.defaultSource = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSecondHandStatus(int i) {
            this.defaultSecondHandStatus = i;
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

        public GsonTypeAdapter setDefaultStoreTypeText(String str) {
            this.defaultStoreTypeText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSecondHandDealType(int i) {
            this.defaultSecondHandDealType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSecondHandFaceDeal(int i) {
            this.defaultSecondHandFaceDeal = i;
            return this;
        }

        public GsonTypeAdapter setDefaultExchangePriceType(int i) {
            this.defaultExchangePriceType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLinkNotice(String str) {
            this.defaultLinkNotice = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, SecondHandInfo secondHandInfo) throws IOException {
            if (secondHandInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("feed_id");
            this.feedIdAdapter.write(jsonWriter, secondHandInfo.getFeedId());
            jsonWriter.name("product_title");
            this.titleAdapter.write(jsonWriter, secondHandInfo.getTitle());
            jsonWriter.name("product_logo");
            this.logoAdapter.write(jsonWriter, secondHandInfo.getLogo());
            jsonWriter.name("product_price");
            this.priceAdapter.write(jsonWriter, secondHandInfo.getPrice());
            jsonWriter.name("product_config_data");
            this.configJsonAdapter.write(jsonWriter, secondHandInfo.getConfigJson());
            jsonWriter.name("product_config_source");
            this.productConfigSourceAdapter.write(jsonWriter, secondHandInfo.getProductConfigSource());
            jsonWriter.name("ershou_product_id");
            this.productIdAdapter.write(jsonWriter, secondHandInfo.getProductId());
            jsonWriter.name("ershou_type_title");
            this.ershouTypeTitleAdapter.write(jsonWriter, secondHandInfo.getErshouTypeTitle());
            jsonWriter.name("ershou_type_id");
            this.ershouTypeIDAdapter.write(jsonWriter, secondHandInfo.getErshouTypeID());
            jsonWriter.name("city");
            this.cityAdapter.write(jsonWriter, secondHandInfo.getCity());
            jsonWriter.name("province");
            this.provinceAdapter.write(jsonWriter, secondHandInfo.getProvince());
            jsonWriter.name("city_code");
            this.cityCodeAdapter.write(jsonWriter, secondHandInfo.getCityCode());
            jsonWriter.name("store_type");
            this.storeTypeAdapter.write(jsonWriter, Integer.valueOf(secondHandInfo.getStoreType()));
            jsonWriter.name("link_url");
            this.urlAdapter.write(jsonWriter, secondHandInfo.getUrl());
            jsonWriter.name("link_source");
            this.sourceAdapter.write(jsonWriter, secondHandInfo.getSource());
            jsonWriter.name("ershou_status");
            this.secondHandStatusAdapter.write(jsonWriter, Integer.valueOf(secondHandInfo.getSecondHandStatus()));
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, secondHandInfo.getDateline());
            jsonWriter.name("ershou_lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, secondHandInfo.getLastUpdate());
            jsonWriter.name("store_type_txt");
            this.storeTypeTextAdapter.write(jsonWriter, secondHandInfo.getStoreTypeText());
            jsonWriter.name("deal_type");
            this.secondHandDealTypeAdapter.write(jsonWriter, Integer.valueOf(secondHandInfo.getSecondHandDealType()));
            jsonWriter.name("is_face_deal");
            this.secondHandFaceDealAdapter.write(jsonWriter, Integer.valueOf(secondHandInfo.getSecondHandFaceDeal()));
            jsonWriter.name("exchange_price_type");
            this.exchangePriceTypeAdapter.write(jsonWriter, Integer.valueOf(secondHandInfo.getExchangePriceType()));
            jsonWriter.name("link_notice");
            this.linkNoticeAdapter.write(jsonWriter, secondHandInfo.getLinkNotice());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public SecondHandInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultFeedId;
            String str2 = this.defaultTitle;
            String str3 = this.defaultLogo;
            String str4 = this.defaultPrice;
            String str5 = this.defaultConfigJson;
            String str6 = this.defaultProductConfigSource;
            String str7 = this.defaultProductId;
            String str8 = this.defaultErshouTypeTitle;
            String str9 = this.defaultErshouTypeID;
            String str10 = this.defaultCity;
            String str11 = this.defaultProvince;
            String str12 = this.defaultCityCode;
            int i = this.defaultStoreType;
            String str13 = this.defaultUrl;
            String str14 = this.defaultSource;
            int i2 = this.defaultSecondHandStatus;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str15 = this.defaultStoreTypeText;
            int i3 = this.defaultSecondHandDealType;
            int i4 = this.defaultSecondHandFaceDeal;
            int i5 = this.defaultExchangePriceType;
            String str16 = this.defaultLinkNotice;
            String str17 = str2;
            String str18 = str3;
            String str19 = str4;
            String str20 = str5;
            String str21 = str6;
            String str22 = str7;
            String str23 = str8;
            String str24 = str9;
            String str25 = str10;
            String str26 = str11;
            String str27 = str12;
            int i6 = i;
            String str28 = str13;
            String str29 = str;
            String str30 = str14;
            int i7 = i2;
            Long l3 = l;
            Long l4 = l2;
            String str31 = str15;
            int i8 = i3;
            int i9 = i4;
            int i10 = i5;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2036869443:
                            if (nextName.equals("link_notice")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1893685248:
                            if (nextName.equals("link_source")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1349832915:
                            if (nextName.equals("deal_type")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1106708415:
                            if (nextName.equals("city_code")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -987485392:
                            if (nextName.equals("province")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -976011428:
                            if (nextName.equals("feed_id")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -684529943:
                            if (nextName.equals("ershou_status")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -209773769:
                            if (nextName.equals("product_config_data")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -33583646:
                            if (nextName.equals("ershou_product_id")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 3053931:
                            if (nextName.equals("city")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 544448524:
                            if (nextName.equals("exchange_price_type")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 713286760:
                            if (nextName.equals("product_config_source")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 921940952:
                            if (nextName.equals("store_type")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 1014329083:
                            if (nextName.equals("product_logo")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1122420310:
                            if (nextName.equals("ershou_lastupdate")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1194530730:
                            if (nextName.equals("link_url")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1211919417:
                            if (nextName.equals("is_face_deal")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1298442281:
                            if (nextName.equals("ershou_type_id")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 1383215609:
                            if (nextName.equals("product_price")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1386652424:
                            if (nextName.equals("product_title")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1428948106:
                            if (nextName.equals("ershou_type_title")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1811085705:
                            if (nextName.equals("store_type_txt")) {
                                c = 22;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str16 = this.linkNoticeAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str30 = this.sourceAdapter.read(jsonReader);
                            continue;
                        case 2:
                            i8 = this.secondHandDealTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            str27 = this.cityCodeAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str26 = this.provinceAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str29 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i7 = this.secondHandStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str20 = this.configJsonAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str22 = this.productIdAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str25 = this.cityAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i10 = this.exchangePriceTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str21 = this.productConfigSourceAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            i6 = this.storeTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case '\r':
                            str18 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str28 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i9 = this.secondHandFaceDealAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            str24 = this.ershouTypeIDAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str19 = this.priceAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str17 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str23 = this.ershouTypeTitleAdapter.read(jsonReader);
                            continue;
                        case 21:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str31 = this.storeTypeTextAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_SecondHandInfo(str29, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, i6, str28, str30, i7, l3, l4, str31, i8, i9, i10, str16);
        }
    }
}
