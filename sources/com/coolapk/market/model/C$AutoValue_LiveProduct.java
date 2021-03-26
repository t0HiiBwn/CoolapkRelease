package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_LiveProduct  reason: invalid class name */
abstract class C$AutoValue_LiveProduct extends C$$AutoValue_LiveProduct {
    C$AutoValue_LiveProduct(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LiveProduct$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<LiveProduct> {
        private String defaultId = null;
        private String defaultLogo = null;
        private String defaultTitle = null;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> titleAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.idAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
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

        public void write(JsonWriter jsonWriter, LiveProduct liveProduct) throws IOException {
            if (liveProduct == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, liveProduct.getId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, liveProduct.getTitle());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, liveProduct.getLogo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public LiveProduct read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultId;
            String str2 = this.defaultTitle;
            String str3 = this.defaultLogo;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.idAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str3 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str2 = this.titleAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_LiveProduct(str, str2, str3);
        }
    }
}
