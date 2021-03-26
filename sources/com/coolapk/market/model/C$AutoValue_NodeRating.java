package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_NodeRating  reason: invalid class name */
abstract class C$AutoValue_NodeRating extends C$$AutoValue_NodeRating {
    C$AutoValue_NodeRating(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, String str13, int i, String str14, UserInfo userInfo, NodeTargetInfo nodeTargetInfo, int i2, int i3, int i4) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l, l2, str12, str13, i, str14, userInfo, nodeTargetInfo, i2, i3, i4);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_NodeRating$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<NodeRating> {
        private final TypeAdapter<Integer> buyStatusAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultBuyStatus = 0;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultFeedId = null;
        private String defaultId = null;
        private int defaultIsOwner = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private int defaultShowOwner = 0;
        private int defaultStar = 0;
        private String defaultSubTitle = null;
        private String defaultTargetId = null;
        private NodeTargetInfo defaultTargetInfo = null;
        private String defaultTargetType = null;
        private String defaultTitle = null;
        private String defaultUrl = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> feedIdAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isOwnerAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> showOwnerAdapter;
        private final TypeAdapter<Integer> starAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> targetIdAdapter;
        private final TypeAdapter<NodeTargetInfo> targetInfoAdapter;
        private final TypeAdapter<String> targetTypeAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTemplateAdapter = gson.getAdapter(String.class);
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
            this.targetTypeAdapter = gson.getAdapter(String.class);
            this.targetIdAdapter = gson.getAdapter(String.class);
            this.starAdapter = gson.getAdapter(Integer.class);
            this.feedIdAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.targetInfoAdapter = gson.getAdapter(NodeTargetInfo.class);
            this.buyStatusAdapter = gson.getAdapter(Integer.class);
            this.isOwnerAdapter = gson.getAdapter(Integer.class);
            this.showOwnerAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultTargetType(String str) {
            this.defaultTargetType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetId(String str) {
            this.defaultTargetId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultStar(int i) {
            this.defaultStar = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedId(String str) {
            this.defaultFeedId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(UserInfo userInfo) {
            this.defaultUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetInfo(NodeTargetInfo nodeTargetInfo) {
            this.defaultTargetInfo = nodeTargetInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultBuyStatus(int i) {
            this.defaultBuyStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsOwner(int i) {
            this.defaultIsOwner = i;
            return this;
        }

        public GsonTypeAdapter setDefaultShowOwner(int i) {
            this.defaultShowOwner = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, NodeRating nodeRating) throws IOException {
            if (nodeRating == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, nodeRating.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, nodeRating.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, nodeRating.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, nodeRating.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, nodeRating.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, nodeRating.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, nodeRating.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, nodeRating.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, nodeRating.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, nodeRating.getSubTitle());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, nodeRating.getId());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, nodeRating.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, nodeRating.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, nodeRating.getLastUpdate());
            jsonWriter.name("target_type");
            this.targetTypeAdapter.write(jsonWriter, nodeRating.getTargetType());
            jsonWriter.name("target_id");
            this.targetIdAdapter.write(jsonWriter, nodeRating.getTargetId());
            jsonWriter.name("star");
            this.starAdapter.write(jsonWriter, Integer.valueOf(nodeRating.getStar()));
            jsonWriter.name("feed_id");
            this.feedIdAdapter.write(jsonWriter, nodeRating.getFeedId());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, nodeRating.getUserInfo());
            jsonWriter.name("target_info");
            this.targetInfoAdapter.write(jsonWriter, nodeRating.getTargetInfo());
            jsonWriter.name("buy_status");
            this.buyStatusAdapter.write(jsonWriter, Integer.valueOf(nodeRating.getBuyStatus()));
            jsonWriter.name("is_owner");
            this.isOwnerAdapter.write(jsonWriter, Integer.valueOf(nodeRating.getIsOwner()));
            jsonWriter.name("show_owner");
            this.showOwnerAdapter.write(jsonWriter, Integer.valueOf(nodeRating.getShowOwner()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public NodeRating read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityTemplate;
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
            String str12 = this.defaultTargetType;
            String str13 = this.defaultTargetId;
            int i = this.defaultStar;
            String str14 = this.defaultFeedId;
            UserInfo userInfo = this.defaultUserInfo;
            NodeTargetInfo nodeTargetInfo = this.defaultTargetInfo;
            int i2 = this.defaultBuyStatus;
            int i3 = this.defaultIsOwner;
            int i4 = this.defaultShowOwner;
            String str15 = str2;
            String str16 = str3;
            Integer num2 = num;
            String str17 = str4;
            String str18 = str5;
            String str19 = str6;
            String str20 = str7;
            String str21 = str8;
            String str22 = str9;
            String str23 = str10;
            String str24 = str11;
            Long l3 = l;
            Long l4 = l2;
            String str25 = str;
            String str26 = str12;
            String str27 = str13;
            int i5 = i;
            String str28 = str14;
            UserInfo userInfo2 = userInfo;
            NodeTargetInfo nodeTargetInfo2 = nodeTargetInfo;
            int i6 = i2;
            int i7 = i3;
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
                        case -2084897124:
                            if (nextName.equals("target_info")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -2084558552:
                            if (nextName.equals("target_type")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -976011428:
                            if (nextName.equals("feed_id")) {
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
                        case -854586421:
                            if (nextName.equals("buy_status")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -815576439:
                            if (nextName.equals("target_id")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 3540562:
                            if (nextName.equals("star")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 121133918:
                            if (nextName.equals("is_owner")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1122189041:
                            if (nextName.equals("show_owner")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 22;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str16 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str22 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            nodeTargetInfo2 = this.targetInfoAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str26 = this.targetTypeAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str19 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str15 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str28 = this.feedIdAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str25 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            i6 = this.buyStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\n':
                            str27 = this.targetIdAdapter.read(jsonReader);
                            continue;
                        case 11:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str24 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str23 = this.idAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str20 = this.picAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str21 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 17:
                            i5 = this.starAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            str17 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i7 = this.isOwnerAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            i4 = this.showOwnerAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 22:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_NodeRating(str25, str15, str16, num2, str17, str18, str19, str20, str21, str22, str23, str24, l3, l4, str26, str27, i5, str28, userInfo2, nodeTargetInfo2, i6, i7, i4);
        }
    }
}
