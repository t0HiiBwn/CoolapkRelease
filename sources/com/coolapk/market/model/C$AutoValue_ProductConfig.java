package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_ProductConfig  reason: invalid class name */
abstract class C$AutoValue_ProductConfig extends C$$AutoValue_ProductConfig {
    C$AutoValue_ProductConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, String str11, String str12) {
        super(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, f, str11, str12);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ProductConfig$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ProductConfig> {
        private final TypeAdapter<String> CPUAdapter;
        private final TypeAdapter<String> RAMAdapter;
        private final TypeAdapter<String> configDataAdapter;
        private String defaultCPU = null;
        private String defaultConfigData = null;
        private String defaultFingerpointType = null;
        private String defaultId = null;
        private String defaultKeywords = null;
        private String defaultPhoneMaterial = null;
        private float defaultPrice = 0.0f;
        private String defaultProductId = null;
        private String defaultRAM = null;
        private String defaultReleaseTime = null;
        private String defaultScreenMaterial = null;
        private String defaultTitle = null;
        private String defaultZolId = null;
        private final TypeAdapter<String> fingerpointTypeAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> keywordsAdapter;
        private final TypeAdapter<String> phoneMaterialAdapter;
        private final TypeAdapter<Float> priceAdapter;
        private final TypeAdapter<String> productIdAdapter;
        private final TypeAdapter<String> releaseTimeAdapter;
        private final TypeAdapter<String> screenMaterialAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> zolIdAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.idAdapter = gson.getAdapter(String.class);
            this.productIdAdapter = gson.getAdapter(String.class);
            this.zolIdAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.screenMaterialAdapter = gson.getAdapter(String.class);
            this.CPUAdapter = gson.getAdapter(String.class);
            this.releaseTimeAdapter = gson.getAdapter(String.class);
            this.RAMAdapter = gson.getAdapter(String.class);
            this.fingerpointTypeAdapter = gson.getAdapter(String.class);
            this.phoneMaterialAdapter = gson.getAdapter(String.class);
            this.priceAdapter = gson.getAdapter(Float.class);
            this.keywordsAdapter = gson.getAdapter(String.class);
            this.configDataAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultProductId(String str) {
            this.defaultProductId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultZolId(String str) {
            this.defaultZolId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultScreenMaterial(String str) {
            this.defaultScreenMaterial = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCPU(String str) {
            this.defaultCPU = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReleaseTime(String str) {
            this.defaultReleaseTime = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRAM(String str) {
            this.defaultRAM = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFingerpointType(String str) {
            this.defaultFingerpointType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPhoneMaterial(String str) {
            this.defaultPhoneMaterial = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPrice(float f) {
            this.defaultPrice = f;
            return this;
        }

        public GsonTypeAdapter setDefaultKeywords(String str) {
            this.defaultKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultConfigData(String str) {
            this.defaultConfigData = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, ProductConfig productConfig) throws IOException {
            if (productConfig == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, productConfig.getId());
            jsonWriter.name("product_id");
            this.productIdAdapter.write(jsonWriter, productConfig.getProductId());
            jsonWriter.name("zol_id");
            this.zolIdAdapter.write(jsonWriter, productConfig.getZolId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, productConfig.getTitle());
            jsonWriter.name("screen_material");
            this.screenMaterialAdapter.write(jsonWriter, productConfig.getScreenMaterial());
            jsonWriter.name("cpu");
            this.CPUAdapter.write(jsonWriter, productConfig.getCPU());
            jsonWriter.name("release_time");
            this.releaseTimeAdapter.write(jsonWriter, productConfig.getReleaseTime());
            jsonWriter.name("ram");
            this.RAMAdapter.write(jsonWriter, productConfig.getRAM());
            jsonWriter.name("fingerpoint_type");
            this.fingerpointTypeAdapter.write(jsonWriter, productConfig.getFingerpointType());
            jsonWriter.name("phone_material");
            this.phoneMaterialAdapter.write(jsonWriter, productConfig.getPhoneMaterial());
            jsonWriter.name("price");
            this.priceAdapter.write(jsonWriter, Float.valueOf(productConfig.getPrice()));
            jsonWriter.name("keywords");
            this.keywordsAdapter.write(jsonWriter, productConfig.getKeywords());
            jsonWriter.name("config_data");
            this.configDataAdapter.write(jsonWriter, productConfig.getConfigData());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ProductConfig read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultId;
            String str2 = this.defaultProductId;
            String str3 = this.defaultZolId;
            String str4 = this.defaultTitle;
            String str5 = this.defaultScreenMaterial;
            String str6 = this.defaultCPU;
            String str7 = this.defaultReleaseTime;
            String str8 = this.defaultRAM;
            String str9 = this.defaultFingerpointType;
            String str10 = this.defaultPhoneMaterial;
            float f = this.defaultPrice;
            String str11 = str;
            String str12 = str2;
            String str13 = str3;
            String str14 = str4;
            String str15 = str5;
            String str16 = str6;
            String str17 = str7;
            String str18 = str8;
            String str19 = str9;
            String str20 = str10;
            float f2 = f;
            String str21 = this.defaultKeywords;
            String str22 = this.defaultConfigData;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1965371387:
                            if (nextName.equals("release_time")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1027174502:
                            if (nextName.equals("screen_material")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -696387965:
                            if (nextName.equals("zol_id")) {
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
                        case 98728:
                            if (nextName.equals("cpu")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 112670:
                            if (nextName.equals("ram")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 17030791:
                            if (nextName.equals("config_data")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 106934601:
                            if (nextName.equals("price")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 1636368562:
                            if (nextName.equals("fingerpoint_type")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 1753008747:
                            if (nextName.equals("product_id")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 2126550232:
                            if (nextName.equals("phone_material")) {
                                c = '\f';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str17 = this.releaseTimeAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str15 = this.screenMaterialAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str13 = this.zolIdAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str11 = this.idAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str16 = this.CPUAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str18 = this.RAMAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str22 = this.configDataAdapter.read(jsonReader);
                            continue;
                        case 7:
                            f2 = this.priceAdapter.read(jsonReader).floatValue();
                            continue;
                        case '\b':
                            str14 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str21 = this.keywordsAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str19 = this.fingerpointTypeAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str12 = this.productIdAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str20 = this.phoneMaterialAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ProductConfig(str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, f2, str21, str22);
        }
    }
}
