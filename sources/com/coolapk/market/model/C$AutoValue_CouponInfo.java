package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_CouponInfo  reason: invalid class name */
abstract class C$AutoValue_CouponInfo extends C$$AutoValue_CouponInfo {
    C$AutoValue_CouponInfo(String str, String str2, String str3, String str4, int i, long j, long j2, String str5, boolean z) {
        super(str, str2, str3, str4, i, j, j2, str5, z);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_CouponInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<CouponInfo> {
        private final TypeAdapter<String> adApplinkAdapter;
        private final TypeAdapter<String> adH5urlAdapter;
        private final TypeAdapter<String> adTextAdapter;
        private final TypeAdapter<String> couponIdAdapter;
        private final TypeAdapter<Integer> couponTypeAdapter;
        private String defaultAdApplink = null;
        private String defaultAdH5url = null;
        private String defaultAdText = null;
        private String defaultCouponId = null;
        private int defaultCouponType = 0;
        private long defaultEndTime = 0;
        private boolean defaultIsClicked = false;
        private long defaultStartTime = 0;
        private String defaultTitle = null;
        private final TypeAdapter<Long> endTimeAdapter;
        private final TypeAdapter<Boolean> isClickedAdapter;
        private final TypeAdapter<Long> startTimeAdapter;
        private final TypeAdapter<String> titleAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.adApplinkAdapter = gson.getAdapter(String.class);
            this.adH5urlAdapter = gson.getAdapter(String.class);
            this.adTextAdapter = gson.getAdapter(String.class);
            this.couponIdAdapter = gson.getAdapter(String.class);
            this.couponTypeAdapter = gson.getAdapter(Integer.class);
            this.startTimeAdapter = gson.getAdapter(Long.class);
            this.endTimeAdapter = gson.getAdapter(Long.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.isClickedAdapter = gson.getAdapter(Boolean.class);
        }

        public GsonTypeAdapter setDefaultAdApplink(String str) {
            this.defaultAdApplink = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdH5url(String str) {
            this.defaultAdH5url = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdText(String str) {
            this.defaultAdText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCouponId(String str) {
            this.defaultCouponId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCouponType(int i) {
            this.defaultCouponType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStartTime(long j) {
            this.defaultStartTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultEndTime(long j) {
            this.defaultEndTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsClicked(boolean z) {
            this.defaultIsClicked = z;
            return this;
        }

        public void write(JsonWriter jsonWriter, CouponInfo couponInfo) throws IOException {
            if (couponInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("ad_applink");
            this.adApplinkAdapter.write(jsonWriter, couponInfo.getAdApplink());
            jsonWriter.name("ad_h5url");
            this.adH5urlAdapter.write(jsonWriter, couponInfo.getAdH5url());
            jsonWriter.name("ad_text");
            this.adTextAdapter.write(jsonWriter, couponInfo.getAdText());
            jsonWriter.name("couponId");
            this.couponIdAdapter.write(jsonWriter, couponInfo.getCouponId());
            jsonWriter.name("couponType");
            this.couponTypeAdapter.write(jsonWriter, Integer.valueOf(couponInfo.getCouponType()));
            jsonWriter.name("start_time");
            this.startTimeAdapter.write(jsonWriter, Long.valueOf(couponInfo.getStartTime()));
            jsonWriter.name("end_time");
            this.endTimeAdapter.write(jsonWriter, Long.valueOf(couponInfo.getEndTime()));
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, couponInfo.getTitle());
            jsonWriter.name("is_clicked");
            this.isClickedAdapter.write(jsonWriter, Boolean.valueOf(couponInfo.getIsClicked()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public CouponInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultAdApplink;
            String str2 = this.defaultAdH5url;
            String str3 = this.defaultAdText;
            String str4 = this.defaultCouponId;
            int i = this.defaultCouponType;
            long j = this.defaultStartTime;
            long j2 = this.defaultEndTime;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            int i2 = i;
            long j3 = j;
            long j4 = j2;
            String str9 = this.defaultTitle;
            boolean z = this.defaultIsClicked;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1934132718:
                            if (nextName.equals("is_clicked")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1573145462:
                            if (nextName.equals("start_time")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1372523930:
                            if (nextName.equals("ad_h5url")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1152249911:
                            if (nextName.equals("ad_text")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -673771137:
                            if (nextName.equals("ad_applink")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -370315295:
                            if (nextName.equals("couponId")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 609638528:
                            if (nextName.equals("couponType")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1725551537:
                            if (nextName.equals("end_time")) {
                                c = '\b';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            z = this.isClickedAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 1:
                            j3 = this.startTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 2:
                            str6 = this.adH5urlAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str7 = this.adTextAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str5 = this.adApplinkAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str8 = this.couponIdAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str9 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 7:
                            i2 = this.couponTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            j4 = this.endTimeAdapter.read(jsonReader).longValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_CouponInfo(str5, str6, str7, str8, i2, j3, j4, str9, z);
        }
    }
}
