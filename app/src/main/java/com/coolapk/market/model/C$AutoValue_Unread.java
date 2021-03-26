package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Unread  reason: invalid class name */
abstract class C$AutoValue_Unread extends C$$AutoValue_Unread {
    C$AutoValue_Unread(String str, int i) {
        super(str, i);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Unread$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Unread> {
        private int defaultUnreadNum = 0;
        private String defaultUnreadTitle = null;
        private final TypeAdapter<Integer> unreadNumAdapter;
        private final TypeAdapter<String> unreadTitleAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.unreadTitleAdapter = gson.getAdapter(String.class);
            this.unreadNumAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultUnreadTitle(String str) {
            this.defaultUnreadTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUnreadNum(int i) {
            this.defaultUnreadNum = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, Unread unread) throws IOException {
            if (unread == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("title");
            this.unreadTitleAdapter.write(jsonWriter, unread.getUnreadTitle());
            jsonWriter.name("num");
            this.unreadNumAdapter.write(jsonWriter, Integer.valueOf(unread.getUnreadNum()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Unread read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultUnreadTitle;
            int i = this.defaultUnreadNum;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("num")) {
                        i = this.unreadNumAdapter.read(jsonReader).intValue();
                    } else if (!nextName.equals("title")) {
                        jsonReader.skipValue();
                    } else {
                        str = this.unreadTitleAdapter.read(jsonReader);
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Unread(str, i);
        }
    }
}
