package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_EditorInfo  reason: invalid class name */
abstract class C$AutoValue_EditorInfo extends C$$AutoValue_EditorInfo {
    C$AutoValue_EditorInfo(String str, int i, int i2) {
        super(str, i, i2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_EditorInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<EditorInfo> {
        private String defaultEditorLevel = null;
        private int defaultNewFollowNum = 0;
        private int defaultNewSubmitNum = 0;
        private final TypeAdapter<String> editorLevelAdapter;
        private final TypeAdapter<Integer> newFollowNumAdapter;
        private final TypeAdapter<Integer> newSubmitNumAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.editorLevelAdapter = gson.getAdapter(String.class);
            this.newSubmitNumAdapter = gson.getAdapter(Integer.class);
            this.newFollowNumAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultEditorLevel(String str) {
            this.defaultEditorLevel = str;
            return this;
        }

        public GsonTypeAdapter setDefaultNewSubmitNum(int i) {
            this.defaultNewSubmitNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNewFollowNum(int i) {
            this.defaultNewFollowNum = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, EditorInfo editorInfo) throws IOException {
            if (editorInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("editorLevel");
            this.editorLevelAdapter.write(jsonWriter, editorInfo.getEditorLevel());
            jsonWriter.name("newSubmitNum");
            this.newSubmitNumAdapter.write(jsonWriter, Integer.valueOf(editorInfo.getNewSubmitNum()));
            jsonWriter.name("newFollowNum");
            this.newFollowNumAdapter.write(jsonWriter, Integer.valueOf(editorInfo.getNewFollowNum()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public EditorInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEditorLevel;
            int i = this.defaultNewSubmitNum;
            int i2 = this.defaultNewFollowNum;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1010866665:
                            if (nextName.equals("editorLevel")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 653076110:
                            if (nextName.equals("newSubmitNum")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1070323797:
                            if (nextName.equals("newFollowNum")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.editorLevelAdapter.read(jsonReader);
                            continue;
                        case 1:
                            i = this.newSubmitNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            i2 = this.newFollowNumAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_EditorInfo(str, i, i2);
        }
    }
}
