package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_Tips  reason: invalid class name */
abstract class C$AutoValue_Tips extends C$$AutoValue_Tips {
    C$AutoValue_Tips(String str, String str2, String str3, String str4, int i) {
        super(str, str2, str3, str4, i);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_Tips$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<Tips> {
        private final TypeAdapter<String> buttonNameAdapter;
        private final TypeAdapter<Integer> closableAdapter;
        private String defaultButtonName = null;
        private int defaultClosable = 0;
        private String defaultLogo = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.titleAdapter = gson.getAdapter(String.class);
            this.buttonNameAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.closableAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultButtonName(String str) {
            this.defaultButtonName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultClosable(int i) {
            this.defaultClosable = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, Tips tips) throws IOException {
            if (tips == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, tips.getTitle());
            jsonWriter.name("buttonName");
            this.buttonNameAdapter.write(jsonWriter, tips.getButtonName());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, tips.getUrl());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, tips.getLogo());
            jsonWriter.name("closable");
            this.closableAdapter.write(jsonWriter, Integer.valueOf(tips.getClosable()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public Tips read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultTitle;
            String str2 = this.defaultButtonName;
            String str3 = this.defaultUrl;
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            String str7 = this.defaultLogo;
            int i = this.defaultClosable;
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
                        case 358362333:
                            if (nextName.equals("buttonName")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 1092709095:
                            if (nextName.equals("closable")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str6 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str7 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str4 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str5 = this.buttonNameAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i = this.closableAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_Tips(str4, str5, str6, str7, i);
        }
    }
}
