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

final class AutoValue_LikeResult extends C$AutoValue_LikeResult {
    AutoValue_LikeResult(int i, List<String> list, List<RelatedData> list2) {
        super(i, list, list2);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<LikeResult> {
        private final TypeAdapter<Integer> countAdapter;
        private int defaultCount = 0;
        private List<String> defaultRecentLikeList = Collections.emptyList();
        private List<RelatedData> defaultUserLikeList = null;
        private final TypeAdapter<List<String>> recentLikeListAdapter;
        private final TypeAdapter<List<RelatedData>> userLikeListAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.countAdapter = gson.getAdapter(Integer.class);
            this.recentLikeListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.userLikeListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, RelatedData.class));
        }

        public GsonTypeAdapter setDefaultCount(int i) {
            this.defaultCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecentLikeList(List<String> list) {
            this.defaultRecentLikeList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultUserLikeList(List<RelatedData> list) {
            this.defaultUserLikeList = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, LikeResult likeResult) throws IOException {
            if (likeResult == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("count");
            this.countAdapter.write(jsonWriter, Integer.valueOf(likeResult.getCount()));
            jsonWriter.name("recentLikeList");
            this.recentLikeListAdapter.write(jsonWriter, likeResult.getRecentLikeList());
            jsonWriter.name("userLikeList");
            this.userLikeListAdapter.write(jsonWriter, likeResult.getUserLikeList());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public LikeResult read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultCount;
            List<String> list = this.defaultRecentLikeList;
            List<RelatedData> list2 = this.defaultUserLikeList;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -763015088:
                            if (nextName.equals("recentLikeList")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 94851343:
                            if (nextName.equals("count")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 334595520:
                            if (nextName.equals("userLikeList")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            list = this.recentLikeListAdapter.read(jsonReader);
                            continue;
                        case 1:
                            i = this.countAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            list2 = this.userLikeListAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_LikeResult(i, list, list2);
        }
    }
}
