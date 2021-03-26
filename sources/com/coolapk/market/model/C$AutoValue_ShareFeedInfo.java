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

/* renamed from: com.coolapk.market.model.$AutoValue_ShareFeedInfo  reason: invalid class name */
abstract class C$AutoValue_ShareFeedInfo extends C$$AutoValue_ShareFeedInfo {
    C$AutoValue_ShareFeedInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, Long l, Long l2, String str8, String str9, List<String> list, String str10, String str11, int i, String str12, String str13, String str14, int i2, String str15, String str16, String str17) {
        super(str, str2, str3, num, str4, str5, str6, str7, l, l2, str8, str9, list, str10, str11, i, str12, str13, str14, i2, str15, str16, str17);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ShareFeedInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<ShareFeedInfo> {
        private final TypeAdapter<Long> datelineAdapter;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private List<String> defaultImgList = Collections.emptyList();
        private int defaultIsDiscoveryApp = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMediaInfo = null;
        private String defaultMediaPic = null;
        private int defaultMediaType = 0;
        private String defaultMediaUrl = null;
        private String defaultPackageName = null;
        private String defaultPic = null;
        private String defaultReference = null;
        private String defaultSourceName = null;
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
        private final TypeAdapter<List<String>> imgListAdapter;
        private final TypeAdapter<Integer> isDiscoveryAppAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> mediaInfoAdapter;
        private final TypeAdapter<String> mediaPicAdapter;
        private final TypeAdapter<Integer> mediaTypeAdapter;
        private final TypeAdapter<String> mediaUrlAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> referenceAdapter;
        private final TypeAdapter<String> sourceNameAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.imgListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.urlAdapter = gson.getAdapter(String.class);
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.isDiscoveryAppAdapter = gson.getAdapter(Integer.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.sourceNameAdapter = gson.getAdapter(String.class);
            this.referenceAdapter = gson.getAdapter(String.class);
            this.mediaTypeAdapter = gson.getAdapter(Integer.class);
            this.mediaUrlAdapter = gson.getAdapter(String.class);
            this.mediaPicAdapter = gson.getAdapter(String.class);
            this.mediaInfoAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
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

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultImgList(List<String> list) {
            this.defaultImgList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsDiscoveryApp(int i) {
            this.defaultIsDiscoveryApp = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSourceName(String str) {
            this.defaultSourceName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultReference(String str) {
            this.defaultReference = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaType(int i) {
            this.defaultMediaType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaUrl(String str) {
            this.defaultMediaUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaPic(String str) {
            this.defaultMediaPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMediaInfo(String str) {
            this.defaultMediaInfo = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, ShareFeedInfo shareFeedInfo) throws IOException {
            if (shareFeedInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, shareFeedInfo.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, shareFeedInfo.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, shareFeedInfo.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, shareFeedInfo.getEntityFixed());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, shareFeedInfo.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, shareFeedInfo.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, shareFeedInfo.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, shareFeedInfo.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, shareFeedInfo.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, shareFeedInfo.getLastUpdate());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, shareFeedInfo.getLogo());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, shareFeedInfo.getDescription());
            jsonWriter.name("imgList");
            this.imgListAdapter.write(jsonWriter, shareFeedInfo.getImgList());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, shareFeedInfo.getUrl());
            jsonWriter.name("packageName");
            this.packageNameAdapter.write(jsonWriter, shareFeedInfo.getPackageName());
            jsonWriter.name("is_share_app");
            this.isDiscoveryAppAdapter.write(jsonWriter, Integer.valueOf(shareFeedInfo.getIsDiscoveryApp()));
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, shareFeedInfo.getTitle());
            jsonWriter.name("sourceName");
            this.sourceNameAdapter.write(jsonWriter, shareFeedInfo.getSourceName());
            jsonWriter.name("referer");
            this.referenceAdapter.write(jsonWriter, shareFeedInfo.getReference());
            jsonWriter.name("media_type");
            this.mediaTypeAdapter.write(jsonWriter, Integer.valueOf(shareFeedInfo.getMediaType()));
            jsonWriter.name("media_url");
            this.mediaUrlAdapter.write(jsonWriter, shareFeedInfo.getMediaUrl());
            jsonWriter.name("media_pic");
            this.mediaPicAdapter.write(jsonWriter, shareFeedInfo.getMediaPic());
            jsonWriter.name("media_info");
            this.mediaInfoAdapter.write(jsonWriter, shareFeedInfo.getMediaInfo());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public ShareFeedInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
            String str3 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str4 = this.defaultPic;
            String str5 = this.defaultSubTitle;
            String str6 = this.defaultId;
            String str7 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str8 = this.defaultLogo;
            String str9 = this.defaultDescription;
            List<String> list = this.defaultImgList;
            String str10 = this.defaultUrl;
            String str11 = this.defaultPackageName;
            int i = this.defaultIsDiscoveryApp;
            String str12 = this.defaultTitle;
            String str13 = this.defaultSourceName;
            String str14 = this.defaultReference;
            int i2 = this.defaultMediaType;
            String str15 = this.defaultMediaUrl;
            String str16 = this.defaultMediaPic;
            String str17 = this.defaultMediaInfo;
            String str18 = str2;
            String str19 = str3;
            Integer num2 = num;
            String str20 = str4;
            String str21 = str5;
            String str22 = str6;
            String str23 = str7;
            Long l3 = l;
            Long l4 = l2;
            String str24 = str8;
            String str25 = str9;
            List<String> list2 = list;
            String str26 = str10;
            String str27 = str;
            String str28 = str11;
            int i3 = i;
            String str29 = str12;
            String str30 = str13;
            String str31 = str14;
            int i4 = i2;
            String str32 = str15;
            String str33 = str16;
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
                        case -1111633594:
                            if (nextName.equals("sourceName")) {
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
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 908759025:
                            if (nextName.equals("packageName")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1085069613:
                            if (nextName.equals("referer")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1402146028:
                            if (nextName.equals("is_share_app")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 1916674817:
                            if (nextName.equals("imgList")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1939536937:
                            if (nextName.equals("media_info")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1939875509:
                            if (nextName.equals("media_type")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 2140782255:
                            if (nextName.equals("media_pic")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 2140787348:
                            if (nextName.equals("media_url")) {
                                c = 22;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str19 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str21 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str25 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str18 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str30 = this.sourceNameAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str27 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str23 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str22 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str20 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str26 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str24 = this.logoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str29 = this.titleAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str28 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str31 = this.referenceAdapter.read(jsonReader);
                            continue;
                        case 15:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i3 = this.isDiscoveryAppAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 18:
                            list2 = this.imgListAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str17 = this.mediaInfoAdapter.read(jsonReader);
                            continue;
                        case 20:
                            i4 = this.mediaTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            str33 = this.mediaPicAdapter.read(jsonReader);
                            continue;
                        case 22:
                            str32 = this.mediaUrlAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_ShareFeedInfo(str27, str18, str19, num2, str20, str21, str22, str23, l3, l4, str24, str25, list2, str26, str28, i3, str29, str30, str31, i4, str32, str33, str17);
        }
    }
}
