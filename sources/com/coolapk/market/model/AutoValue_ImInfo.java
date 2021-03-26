package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class AutoValue_ImInfo extends C$AutoValue_ImInfo {
    AutoValue_ImInfo(String str, String str2) {
        super(str, str2);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<ImInfo> {
        private String defaultUserId = null;
        private String defaultUserSig = null;
        private final TypeAdapter<String> userIdAdapter;
        private final TypeAdapter<String> userSigAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.userIdAdapter = gson.getAdapter(String.class);
            this.userSigAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultUserId(String str) {
            this.defaultUserId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserSig(String str) {
            this.defaultUserSig = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, ImInfo imInfo) throws IOException {
            if (imInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("userId");
            this.userIdAdapter.write(jsonWriter, imInfo.userId());
            jsonWriter.name("userSig");
            this.userSigAdapter.write(jsonWriter, imInfo.userSig());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ImInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultUserId;
            String str2 = this.defaultUserSig;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("userId")) {
                        str = this.userIdAdapter.read(jsonReader);
                    } else if (!nextName.equals("userSig")) {
                        jsonReader.skipValue();
                    } else {
                        str2 = this.userSigAdapter.read(jsonReader);
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ImInfo(str, str2);
        }
    }
}
