package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedGoodsCategory  reason: invalid class name */
abstract class C$AutoValue_FeedGoodsCategory extends C$$AutoValue_FeedGoodsCategory {
    C$AutoValue_FeedGoodsCategory(long j, int i, String str, String str2, String str3, String str4, long j2, String str5, long j3, String str6) {
        super(j, i, str, str2, str3, str4, j2, str5, j3, str6);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedGoodsCategory$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedGoodsCategory> {
        private final TypeAdapter<Long> createTimeAdapter;
        private final TypeAdapter<String> createUidAdapter;
        private long defaultCreateTime = 0;
        private String defaultCreateUid = null;
        private int defaultDisplayOrder = 0;
        private String defaultGoodsCount = null;
        private long defaultId = 0;
        private String defaultKeyWords = null;
        private String defaultLogo = null;
        private String defaultTitle = null;
        private long defaultUpdateTime = 0;
        private String defaultUpdateUid = null;
        private final TypeAdapter<Integer> displayOrderAdapter;
        private final TypeAdapter<String> goodsCountAdapter;
        private final TypeAdapter<Long> idAdapter;
        private final TypeAdapter<String> keyWordsAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<Long> updateTimeAdapter;
        private final TypeAdapter<String> updateUidAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.idAdapter = gson.getAdapter(Long.class);
            this.displayOrderAdapter = gson.getAdapter(Integer.class);
            this.goodsCountAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.keyWordsAdapter = gson.getAdapter(String.class);
            this.createTimeAdapter = gson.getAdapter(Long.class);
            this.createUidAdapter = gson.getAdapter(String.class);
            this.updateTimeAdapter = gson.getAdapter(Long.class);
            this.updateUidAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultId(long j) {
            this.defaultId = j;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayOrder(int i) {
            this.defaultDisplayOrder = i;
            return this;
        }

        public GsonTypeAdapter setDefaultGoodsCount(String str) {
            this.defaultGoodsCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKeyWords(String str) {
            this.defaultKeyWords = str;
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

        public void write(JsonWriter jsonWriter, FeedGoodsCategory feedGoodsCategory) throws IOException {
            if (feedGoodsCategory == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, Long.valueOf(feedGoodsCategory.getId()));
            jsonWriter.name("display_order");
            this.displayOrderAdapter.write(jsonWriter, Integer.valueOf(feedGoodsCategory.getDisplayOrder()));
            jsonWriter.name("goods_count");
            this.goodsCountAdapter.write(jsonWriter, feedGoodsCategory.getGoodsCount());
            jsonWriter.name("log");
            this.logoAdapter.write(jsonWriter, feedGoodsCategory.getLogo());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, feedGoodsCategory.getTitle());
            jsonWriter.name("keywords");
            this.keyWordsAdapter.write(jsonWriter, feedGoodsCategory.getKeyWords());
            jsonWriter.name("create_time");
            this.createTimeAdapter.write(jsonWriter, Long.valueOf(feedGoodsCategory.getCreateTime()));
            jsonWriter.name("create_uid");
            this.createUidAdapter.write(jsonWriter, feedGoodsCategory.getCreateUid());
            jsonWriter.name("update_time");
            this.updateTimeAdapter.write(jsonWriter, Long.valueOf(feedGoodsCategory.getUpdateTime()));
            jsonWriter.name("update_uid");
            this.updateUidAdapter.write(jsonWriter, feedGoodsCategory.getUpdateUid());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedGoodsCategory read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            long j = this.defaultId;
            int i = this.defaultDisplayOrder;
            String str = this.defaultGoodsCount;
            String str2 = this.defaultLogo;
            String str3 = this.defaultTitle;
            String str4 = this.defaultKeyWords;
            long j2 = this.defaultCreateTime;
            String str5 = this.defaultCreateUid;
            long j3 = j;
            int i2 = i;
            String str6 = str;
            String str7 = str2;
            String str8 = str3;
            String str9 = str4;
            long j4 = j2;
            String str10 = str5;
            long j5 = this.defaultUpdateTime;
            String str11 = this.defaultUpdateUid;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1470502511:
                            if (nextName.equals("display_order")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -573446013:
                            if (nextName.equals("update_time")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -493574096:
                            if (nextName.equals("create_time")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -295591974:
                            if (nextName.equals("update_uid")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 107332:
                            if (nextName.equals("log")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 481161958:
                            if (nextName.equals("goods_count")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 1369552525:
                            if (nextName.equals("create_uid")) {
                                c = '\t';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i2 = this.displayOrderAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            j5 = this.updateTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 2:
                            j4 = this.createTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 3:
                            str11 = this.updateUidAdapter.read(jsonReader);
                            continue;
                        case 4:
                            j3 = this.idAdapter.read(jsonReader).longValue();
                            continue;
                        case 5:
                            str7 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str8 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str6 = this.goodsCountAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str9 = this.keyWordsAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str10 = this.createUidAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedGoodsCategory(j3, i2, str6, str7, str8, str9, j4, str10, j5, str11);
        }
    }
}
