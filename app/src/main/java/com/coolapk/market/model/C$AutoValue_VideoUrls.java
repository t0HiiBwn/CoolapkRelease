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

/* renamed from: com.coolapk.market.model.$AutoValue_VideoUrls  reason: invalid class name */
abstract class C$AutoValue_VideoUrls extends C$$AutoValue_VideoUrls {
    C$AutoValue_VideoUrls(List<String> list, List<Integer> list2) {
        super(list, list2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_VideoUrls$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<VideoUrls> {
        private List<Integer> defaultDurationList = Collections.emptyList();
        private List<String> defaultUrlList = Collections.emptyList();
        private final TypeAdapter<List<Integer>> durationListAdapter;
        private final TypeAdapter<List<String>> urlListAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.urlListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.durationListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
        }

        public GsonTypeAdapter setDefaultUrlList(List<String> list) {
            this.defaultUrlList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultDurationList(List<Integer> list) {
            this.defaultDurationList = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, VideoUrls videoUrls) throws IOException {
            if (videoUrls == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("urlList");
            this.urlListAdapter.write(jsonWriter, videoUrls.getUrlList());
            jsonWriter.name("durationList");
            this.durationListAdapter.write(jsonWriter, videoUrls.getDurationList());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public VideoUrls read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            List<String> list = this.defaultUrlList;
            List<Integer> list2 = this.defaultDurationList;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("durationList")) {
                        list2 = this.durationListAdapter.read(jsonReader);
                    } else if (!nextName.equals("urlList")) {
                        jsonReader.skipValue();
                    } else {
                        list = this.urlListAdapter.read(jsonReader);
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_VideoUrls(list, list2);
        }
    }
}
