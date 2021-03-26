package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_DeviceParams  reason: invalid class name */
abstract class C$AutoValue_DeviceParams extends C$$AutoValue_DeviceParams {
    C$AutoValue_DeviceParams(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, List<String> list, int i) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, l, l2, str11, str12, list, i);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DeviceParams$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<DeviceParams> {
        private final TypeAdapter<Integer> checkBoxAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultCheckBox = 0;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private String defaultKey = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private List<String> defaultOption = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> keyAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<List<String>> optionAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.keyAdapter = gson.getAdapter(String.class);
            this.optionAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.checkBoxAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTemplate(String str) {
            this.defaultEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityId(String str) {
            this.defaultEntityId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityFixed(Integer num) {
            this.defaultEntityFixed = num;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSubTitle(String str) {
            this.defaultSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraData(String str) {
            this.defaultExtraData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDateline(Long l) {
            this.defaultDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultLastUpdate(Long l) {
            this.defaultLastUpdate = l;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKey(String str) {
            this.defaultKey = str;
            return this;
        }

        public GsonTypeAdapter setDefaultOption(List<String> list) {
            this.defaultOption = list;
            return this;
        }

        public GsonTypeAdapter setDefaultCheckBox(int i) {
            this.defaultCheckBox = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, DeviceParams deviceParams) throws IOException {
            if (deviceParams == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, deviceParams.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, deviceParams.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, deviceParams.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, deviceParams.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, deviceParams.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, deviceParams.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, deviceParams.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, deviceParams.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, deviceParams.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, deviceParams.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, deviceParams.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, deviceParams.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, deviceParams.getLastUpdate());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, deviceParams.getTitle());
            jsonWriter.name("key");
            this.keyAdapter.write(jsonWriter, deviceParams.getKey());
            jsonWriter.name("option");
            this.optionAdapter.write(jsonWriter, deviceParams.getOption());
            jsonWriter.name("checkBox");
            this.checkBoxAdapter.write(jsonWriter, Integer.valueOf(deviceParams.getCheckBox()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public DeviceParams read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultUrl;
            String str5 = this.defaultDescription;
            String str6 = this.defaultPic;
            String str7 = this.defaultLogo;
            String str8 = this.defaultSubTitle;
            String str9 = this.defaultId;
            String str10 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str11 = this.defaultTitle;
            String str12 = this.defaultKey;
            List<String> list = this.defaultOption;
            int i = this.defaultCheckBox;
            String str13 = str2;
            String str14 = str3;
            Integer num2 = num;
            String str15 = str4;
            String str16 = str5;
            String str17 = str6;
            String str18 = str7;
            String str19 = str8;
            String str20 = str9;
            String str21 = str10;
            Long l3 = l;
            Long l4 = l2;
            String str22 = str11;
            String str23 = str;
            String str24 = str12;
            List<String> list2 = list;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1010136971:
                            if (nextName.equals("option")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 106079:
                            if (nextName.equals("key")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1536861091:
                            if (nextName.equals("checkBox")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 16;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str14 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str19 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str16 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str13 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            list2 = this.optionAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str23 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str21 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str20 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str24 = this.keyAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str17 = this.picAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str15 = this.urlAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str18 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str22 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 14:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 15:
                            i = this.checkBoxAdapter.read(jsonReader).intValue();
                            continue;
                        case 16:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_DeviceParams(str23, str13, str14, num2, str15, str16, str17, str18, str19, str20, str21, l3, l4, str22, str24, list2, i);
        }
    }
}
