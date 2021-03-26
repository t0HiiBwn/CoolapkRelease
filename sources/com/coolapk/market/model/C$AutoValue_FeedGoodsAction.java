package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedGoodsAction  reason: invalid class name */
abstract class C$AutoValue_FeedGoodsAction extends C$$AutoValue_FeedGoodsAction {
    C$AutoValue_FeedGoodsAction(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, String str4) {
        super(i, i2, i3, i4, i5, i6, str, str2, str3, str4);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedGoodsAction$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedGoodsAction> {
        private final TypeAdapter<Integer> categoryIdAdapter;
        private final TypeAdapter<String> categoryNameAdapter;
        private int defaultCategoryId = 0;
        private String defaultCategoryName = null;
        private int defaultHotNum = 0;
        private String defaultMallName = null;
        private String defaultPrice = null;
        private int defaultRecommendStatus = 0;
        private String defaultSellUrl = null;
        private int defaultStar = 0;
        private int defaultStatus = 0;
        private int defaultWishBuyStatus = 0;
        private final TypeAdapter<Integer> hotNumAdapter;
        private final TypeAdapter<String> mallNameAdapter;
        private final TypeAdapter<String> priceAdapter;
        private final TypeAdapter<Integer> recommendStatusAdapter;
        private final TypeAdapter<String> sellUrlAdapter;
        private final TypeAdapter<Integer> starAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<Integer> wishBuyStatusAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.starAdapter = gson.getAdapter(Integer.class);
            this.wishBuyStatusAdapter = gson.getAdapter(Integer.class);
            this.categoryIdAdapter = gson.getAdapter(Integer.class);
            this.hotNumAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.recommendStatusAdapter = gson.getAdapter(Integer.class);
            this.categoryNameAdapter = gson.getAdapter(String.class);
            this.sellUrlAdapter = gson.getAdapter(String.class);
            this.priceAdapter = gson.getAdapter(String.class);
            this.mallNameAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultStar(int i) {
            this.defaultStar = i;
            return this;
        }

        public GsonTypeAdapter setDefaultWishBuyStatus(int i) {
            this.defaultWishBuyStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryId(int i) {
            this.defaultCategoryId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultHotNum(int i) {
            this.defaultHotNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommendStatus(int i) {
            this.defaultRecommendStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCategoryName(String str) {
            this.defaultCategoryName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSellUrl(String str) {
            this.defaultSellUrl = str;
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

        public void write(JsonWriter jsonWriter, FeedGoodsAction feedGoodsAction) throws IOException {
            if (feedGoodsAction == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("star");
            this.starAdapter.write(jsonWriter, Integer.valueOf(feedGoodsAction.getStar()));
            jsonWriter.name("wish_buy_status");
            this.wishBuyStatusAdapter.write(jsonWriter, Integer.valueOf(feedGoodsAction.getWishBuyStatus()));
            jsonWriter.name("category_id");
            this.categoryIdAdapter.write(jsonWriter, Integer.valueOf(feedGoodsAction.getCategoryId()));
            jsonWriter.name("hot_num");
            this.hotNumAdapter.write(jsonWriter, Integer.valueOf(feedGoodsAction.getHotNum()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(feedGoodsAction.getStatus()));
            jsonWriter.name("recommend_status");
            this.recommendStatusAdapter.write(jsonWriter, Integer.valueOf(feedGoodsAction.getRecommendStatus()));
            jsonWriter.name("category_name");
            this.categoryNameAdapter.write(jsonWriter, feedGoodsAction.getCategoryName());
            jsonWriter.name("sell_url");
            this.sellUrlAdapter.write(jsonWriter, feedGoodsAction.getSellUrl());
            jsonWriter.name("price");
            this.priceAdapter.write(jsonWriter, feedGoodsAction.getPrice());
            jsonWriter.name("mall_name");
            this.mallNameAdapter.write(jsonWriter, feedGoodsAction.getMallName());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedGoodsAction read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultStar;
            int i2 = this.defaultWishBuyStatus;
            int i3 = this.defaultCategoryId;
            int i4 = this.defaultHotNum;
            int i5 = this.defaultStatus;
            int i6 = this.defaultRecommendStatus;
            String str = this.defaultCategoryName;
            String str2 = this.defaultSellUrl;
            int i7 = i;
            int i8 = i2;
            int i9 = i3;
            int i10 = i4;
            int i11 = i5;
            int i12 = i6;
            String str3 = str;
            String str4 = str2;
            String str5 = this.defaultPrice;
            String str6 = this.defaultMallName;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1940923946:
                            if (nextName.equals("mall_name")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1142189469:
                            if (nextName.equals("wish_buy_status")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3540562:
                            if (nextName.equals("star")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 106934601:
                            if (nextName.equals("price")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 338683180:
                            if (nextName.equals("category_name")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1099006100:
                            if (nextName.equals("hot_num")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1197918978:
                            if (nextName.equals("sell_url")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1537780732:
                            if (nextName.equals("category_id")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 1823650005:
                            if (nextName.equals("recommend_status")) {
                                c = '\t';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str6 = this.mallNameAdapter.read(jsonReader);
                            continue;
                        case 1:
                            i8 = this.wishBuyStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            i11 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            i7 = this.starAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            str5 = this.priceAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str3 = this.categoryNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i10 = this.hotNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            str4 = this.sellUrlAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            i9 = this.categoryIdAdapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            i12 = this.recommendStatusAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedGoodsAction(i7, i8, i9, i10, i11, i12, str3, str4, str5, str6);
        }
    }
}
