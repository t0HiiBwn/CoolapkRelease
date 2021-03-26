package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_ProductCoupon  reason: invalid class name */
abstract class C$AutoValue_ProductCoupon extends C$$AutoValue_ProductCoupon {
    C$AutoValue_ProductCoupon(String str, String str2, String str3, String str4, String str5, String str6, List<String> list) {
        super(str, str2, str3, str4, str5, str6, list);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ProductCoupon$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ProductCoupon> {
        private final TypeAdapter<String> couponNameAdapter;
        private String defaultCouponName = null;
        private String defaultExpireDate = null;
        private String defaultOpenUrl = null;
        private String defaultPrice = null;
        private List<String> defaultProductRows = null;
        private String defaultUseCouponPrice = null;
        private String defaultWorthMoney = null;
        private final TypeAdapter<String> expireDateAdapter;
        private final TypeAdapter<String> openUrlAdapter;
        private final TypeAdapter<String> priceAdapter;
        private final TypeAdapter<List<String>> productRowsAdapter;
        private final TypeAdapter<String> useCouponPriceAdapter;
        private final TypeAdapter<String> worthMoneyAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.couponNameAdapter = gson.getAdapter(String.class);
            this.worthMoneyAdapter = gson.getAdapter(String.class);
            this.priceAdapter = gson.getAdapter(String.class);
            this.useCouponPriceAdapter = gson.getAdapter(String.class);
            this.expireDateAdapter = gson.getAdapter(String.class);
            this.openUrlAdapter = gson.getAdapter(String.class);
            this.productRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
        }

        public GsonTypeAdapter setDefaultCouponName(String str) {
            this.defaultCouponName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultWorthMoney(String str) {
            this.defaultWorthMoney = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPrice(String str) {
            this.defaultPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUseCouponPrice(String str) {
            this.defaultUseCouponPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExpireDate(String str) {
            this.defaultExpireDate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultOpenUrl(String str) {
            this.defaultOpenUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductRows(List<String> list) {
            this.defaultProductRows = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, ProductCoupon productCoupon) throws IOException {
            if (productCoupon == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("coupon_name");
            this.couponNameAdapter.write(jsonWriter, productCoupon.getCouponName());
            jsonWriter.name("worth_money");
            this.worthMoneyAdapter.write(jsonWriter, productCoupon.getWorthMoney());
            jsonWriter.name("price");
            this.priceAdapter.write(jsonWriter, productCoupon.getPrice());
            jsonWriter.name("useCouponPrice");
            this.useCouponPriceAdapter.write(jsonWriter, productCoupon.getUseCouponPrice());
            jsonWriter.name("expire_time");
            this.expireDateAdapter.write(jsonWriter, productCoupon.getExpireDate());
            jsonWriter.name("open_url");
            this.openUrlAdapter.write(jsonWriter, productCoupon.getOpenUrl());
            jsonWriter.name("productRows");
            this.productRowsAdapter.write(jsonWriter, productCoupon.getProductRows());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ProductCoupon read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultCouponName;
            String str2 = this.defaultWorthMoney;
            String str3 = this.defaultPrice;
            String str4 = this.defaultUseCouponPrice;
            String str5 = this.defaultExpireDate;
            String str6 = str;
            String str7 = str2;
            String str8 = str3;
            String str9 = str4;
            String str10 = str5;
            String str11 = this.defaultOpenUrl;
            List<String> list = this.defaultProductRows;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1491684504:
                            if (nextName.equals("productRows")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -504306182:
                            if (nextName.equals("open_url")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -96179731:
                            if (nextName.equals("expire_time")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 106934601:
                            if (nextName.equals("price")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 837945532:
                            if (nextName.equals("useCouponPrice")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1619099087:
                            if (nextName.equals("worth_money")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1728742148:
                            if (nextName.equals("coupon_name")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            list = this.productRowsAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str11 = this.openUrlAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str10 = this.expireDateAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str8 = this.priceAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str9 = this.useCouponPriceAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str7 = this.worthMoneyAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str6 = this.couponNameAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ProductCoupon(str6, str7, str8, str9, str10, str11, list);
        }
    }
}
