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

/* renamed from: com.coolapk.market.model.$AutoValue_ProductSeries  reason: invalid class name */
abstract class C$AutoValue_ProductSeries extends C$$AutoValue_ProductSeries {
    C$AutoValue_ProductSeries(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, int i2, int i3, int i4, List<Product> list) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l, l2, i2, i3, i4, list);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ProductSeries$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ProductSeries> {
        private final TypeAdapter<Integer> brandIdAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultBrandId = 0;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private int defaultDisplayOrder = 0;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private int defaultProductNum = 0;
        private List<Product> defaultProductRows = Collections.emptyList();
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> displayOrderAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> productNumAdapter;
        private final TypeAdapter<List<Product>> productRowsAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityTypeIdAdapter = gson.getAdapter(Integer.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.brandIdAdapter = gson.getAdapter(Integer.class);
            this.displayOrderAdapter = gson.getAdapter(Integer.class);
            this.productNumAdapter = gson.getAdapter(Integer.class);
            this.productRowsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, Product.class));
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTemplate(String str) {
            this.defaultEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityTypeId(int i) {
            this.defaultEntityTypeId = i;
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

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
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

        public GsonTypeAdapter setDefaultBrandId(int i) {
            this.defaultBrandId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayOrder(int i) {
            this.defaultDisplayOrder = i;
            return this;
        }

        public GsonTypeAdapter setDefaultProductNum(int i) {
            this.defaultProductNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultProductRows(List<Product> list) {
            this.defaultProductRows = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, ProductSeries productSeries) throws IOException {
            if (productSeries == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, productSeries.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, productSeries.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(productSeries.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, productSeries.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, productSeries.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, productSeries.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, productSeries.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, productSeries.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, productSeries.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, productSeries.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, productSeries.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, productSeries.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, productSeries.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, productSeries.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, productSeries.getLastUpdate());
            jsonWriter.name("brand_id");
            this.brandIdAdapter.write(jsonWriter, Integer.valueOf(productSeries.getBrandId()));
            jsonWriter.name("display_order");
            this.displayOrderAdapter.write(jsonWriter, Integer.valueOf(productSeries.getDisplayOrder()));
            jsonWriter.name("product_num");
            this.productNumAdapter.write(jsonWriter, Integer.valueOf(productSeries.getProductNum()));
            jsonWriter.name("productRows");
            this.productRowsAdapter.write(jsonWriter, productSeries.getProductRows());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ProductSeries read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            int i = this.defaultEntityTypeId;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultTitle;
            String str5 = this.defaultUrl;
            String str6 = this.defaultDescription;
            String str7 = this.defaultPic;
            String str8 = this.defaultLogo;
            String str9 = this.defaultSubTitle;
            String str10 = this.defaultId;
            String str11 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            int i2 = this.defaultBrandId;
            int i3 = this.defaultDisplayOrder;
            int i4 = this.defaultProductNum;
            List<Product> list = this.defaultProductRows;
            String str12 = str2;
            int i5 = i;
            String str13 = str3;
            Integer num2 = num;
            String str14 = str4;
            String str15 = str5;
            String str16 = str6;
            String str17 = str7;
            String str18 = str8;
            String str19 = str9;
            String str20 = str10;
            String str21 = str11;
            Long l3 = l;
            String str22 = str;
            Long l4 = l2;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
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
                        case -1491684504:
                            if (nextName.equals("productRows")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1491298250:
                            if (nextName.equals("product_num")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1470502511:
                            if (nextName.equals("display_order")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -25385773:
                            if (nextName.equals("brand_id")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 18;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str13 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str19 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str16 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str12 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            list = this.productRowsAdapter.read(jsonReader);
                            continue;
                        case 5:
                            i8 = this.productNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            i7 = this.displayOrderAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str22 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str21 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i6 = this.brandIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str20 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str17 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str15 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str18 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str14 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i5 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 18:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ProductSeries(str22, str12, i5, str13, num2, str14, str15, str16, str17, str18, str19, str20, str21, l3, l4, i6, i7, i8, list);
        }
    }
}
