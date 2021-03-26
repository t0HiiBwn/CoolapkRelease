package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_GoodsCategoryInfo  reason: invalid class name */
abstract class C$AutoValue_GoodsCategoryInfo extends C$$AutoValue_GoodsCategoryInfo {
    C$AutoValue_GoodsCategoryInfo(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_GoodsCategoryInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<GoodsCategoryInfo> {
        private final TypeAdapter<String> catIdAdapter;
        private final TypeAdapter<String> catTitleAdapter;
        private String defaultCatId = null;
        private String defaultCatTitle = null;

        public GsonTypeAdapter(Gson gson) {
            this.catIdAdapter = gson.getAdapter(String.class);
            this.catTitleAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultCatId(String str) {
            this.defaultCatId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCatTitle(String str) {
            this.defaultCatTitle = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, GoodsCategoryInfo goodsCategoryInfo) throws IOException {
            if (goodsCategoryInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("cat_id");
            this.catIdAdapter.write(jsonWriter, goodsCategoryInfo.getCatId());
            jsonWriter.name("cat_title");
            this.catTitleAdapter.write(jsonWriter, goodsCategoryInfo.getCatTitle());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public GoodsCategoryInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultCatId;
            String str2 = this.defaultCatTitle;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("cat_id")) {
                        str = this.catIdAdapter.read(jsonReader);
                    } else if (!nextName.equals("cat_title")) {
                        jsonReader.skipValue();
                    } else {
                        str2 = this.catTitleAdapter.read(jsonReader);
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_GoodsCategoryInfo(str, str2);
        }
    }
}
