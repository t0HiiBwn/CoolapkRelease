package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_MallInfo  reason: invalid class name */
abstract class C$AutoValue_MallInfo extends C$$AutoValue_MallInfo {
    C$AutoValue_MallInfo(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3, str4, str5);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_MallInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<MallInfo> {
        private String defaultId = null;
        private String defaultMallDomain = null;
        private String defaultMallLogo = null;
        private String defaultMallTitle = null;
        private String defaultName = null;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> mallDomainAdapter;
        private final TypeAdapter<String> mallLogoAdapter;
        private final TypeAdapter<String> mallTitleAdapter;
        private final TypeAdapter<String> nameAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.idAdapter = gson.getAdapter(String.class);
            this.mallTitleAdapter = gson.getAdapter(String.class);
            this.nameAdapter = gson.getAdapter(String.class);
            this.mallLogoAdapter = gson.getAdapter(String.class);
            this.mallDomainAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMallTitle(String str) {
            this.defaultMallTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultName(String str) {
            this.defaultName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMallLogo(String str) {
            this.defaultMallLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMallDomain(String str) {
            this.defaultMallDomain = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, MallInfo mallInfo) throws IOException {
            if (mallInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, mallInfo.getId());
            jsonWriter.name("mall_title");
            this.mallTitleAdapter.write(jsonWriter, mallInfo.getMallTitle());
            jsonWriter.name("name");
            this.nameAdapter.write(jsonWriter, mallInfo.getName());
            jsonWriter.name("mall_logo");
            this.mallLogoAdapter.write(jsonWriter, mallInfo.getMallLogo());
            jsonWriter.name("mall_domain");
            this.mallDomainAdapter.write(jsonWriter, mallInfo.getMallDomain());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public MallInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultId;
            String str2 = this.defaultMallTitle;
            String str3 = this.defaultName;
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            String str7 = this.defaultMallLogo;
            String str8 = this.defaultMallDomain;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1940970250:
                            if (nextName.equals("mall_logo")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1485468337:
                            if (nextName.equals("mall_domain")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -33313683:
                            if (nextName.equals("mall_title")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3373707:
                            if (nextName.equals("name")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str7 = this.mallLogoAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str8 = this.mallDomainAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str5 = this.mallTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str4 = this.idAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str6 = this.nameAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_MallInfo(str4, str5, str6, str7, str8);
        }
    }
}
