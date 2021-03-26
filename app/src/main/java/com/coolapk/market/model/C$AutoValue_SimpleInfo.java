package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_SimpleInfo  reason: invalid class name */
abstract class C$AutoValue_SimpleInfo extends C$$AutoValue_SimpleInfo {
    C$AutoValue_SimpleInfo(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_SimpleInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<SimpleInfo> {
        private String defaultIcon = null;
        private String defaultMessage = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> iconAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.iconAdapter = gson.getAdapter(String.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultIcon(String str) {
            this.defaultIcon = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, SimpleInfo simpleInfo) throws IOException {
            if (simpleInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("icon");
            this.iconAdapter.write(jsonWriter, simpleInfo.getIcon());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, simpleInfo.getMessage());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, simpleInfo.getUrl());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public SimpleInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultIcon;
            String str2 = this.defaultMessage;
            String str3 = this.defaultUrl;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3226745:
                            if (nextName.equals("icon")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str3 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str = this.iconAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str2 = this.messageAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_SimpleInfo(str, str2, str3);
        }
    }
}
