package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_RecentHistory  reason: invalid class name */
abstract class C$AutoValue_RecentHistory extends C$$AutoValue_RecentHistory {
    C$AutoValue_RecentHistory(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, int i, int i2, String str12, String str13, String str14, int i3, int i4, int i5, int i6) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, l, l2, str11, i, i2, str12, str13, str14, i3, i4, i5, i6);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_RecentHistory$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<RecentHistory> {
        private final TypeAdapter<Integer> answerNumAdapter;
        private final TypeAdapter<Integer> commentNumAdapter;
        private final TypeAdapter<Integer> countAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultAnswerNum = 0;
        private int defaultCommentNum = 0;
        private int defaultCount = 0;
        private Long defaultDateline = null;
        private String defaultDescription = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFansNum = 0;
        private int defaultFollowNum = 0;
        private String defaultId = null;
        private int defaultIsTop = 0;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultPic = null;
        private String defaultSubTitle = null;
        private String defaultTargetId = null;
        private String defaultTargetType = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> fansNumAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Integer> isTopAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> targetIdAdapter;
        private final TypeAdapter<String> targetTypeAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;

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
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.countAdapter = gson.getAdapter(Integer.class);
            this.isTopAdapter = gson.getAdapter(Integer.class);
            this.targetIdAdapter = gson.getAdapter(String.class);
            this.targetTypeAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.commentNumAdapter = gson.getAdapter(Integer.class);
            this.fansNumAdapter = gson.getAdapter(Integer.class);
            this.answerNumAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCount(int i) {
            this.defaultCount = i;
            return this;
        }

        public GsonTypeAdapter setDefaultIsTop(int i) {
            this.defaultIsTop = i;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetId(String str) {
            this.defaultTargetId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTargetType(String str) {
            this.defaultTargetType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentNum(int i) {
            this.defaultCommentNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFansNum(int i) {
            this.defaultFansNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAnswerNum(int i) {
            this.defaultAnswerNum = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, RecentHistory recentHistory) throws IOException {
            if (recentHistory == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, recentHistory.getEntityTypeName());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, recentHistory.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, recentHistory.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, recentHistory.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, recentHistory.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, recentHistory.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, recentHistory.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, recentHistory.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, recentHistory.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, recentHistory.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, recentHistory.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, recentHistory.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, recentHistory.getLastUpdate());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, recentHistory.getId());
            jsonWriter.name("count");
            this.countAdapter.write(jsonWriter, Integer.valueOf(recentHistory.getCount()));
            jsonWriter.name("is_top");
            this.isTopAdapter.write(jsonWriter, Integer.valueOf(recentHistory.getIsTop()));
            jsonWriter.name("target_id");
            this.targetIdAdapter.write(jsonWriter, recentHistory.getTargetId());
            jsonWriter.name("target_type");
            this.targetTypeAdapter.write(jsonWriter, recentHistory.getTargetType());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, recentHistory.getUid());
            jsonWriter.name("follow_num");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(recentHistory.getFollowNum()));
            jsonWriter.name("comment_num");
            this.commentNumAdapter.write(jsonWriter, Integer.valueOf(recentHistory.getCommentNum()));
            jsonWriter.name("fans_num");
            this.fansNumAdapter.write(jsonWriter, Integer.valueOf(recentHistory.getFansNum()));
            jsonWriter.name("answer_num");
            this.answerNumAdapter.write(jsonWriter, Integer.valueOf(recentHistory.getAnswerNum()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public RecentHistory read(JsonReader jsonReader) throws IOException {
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
            String str10 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str11 = this.defaultId;
            int i = this.defaultCount;
            int i2 = this.defaultIsTop;
            String str12 = this.defaultTargetId;
            String str13 = this.defaultTargetType;
            String str14 = this.defaultUid;
            int i3 = this.defaultFollowNum;
            int i4 = this.defaultCommentNum;
            int i5 = this.defaultFansNum;
            int i6 = this.defaultAnswerNum;
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
            Long l3 = l;
            Long l4 = l2;
            String str24 = str11;
            String str25 = str;
            int i7 = i;
            int i8 = i2;
            String str26 = str12;
            String str27 = str13;
            String str28 = str14;
            int i9 = i3;
            int i10 = i4;
            int i11 = i5;
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
                        case -2084558552:
                            if (nextName.equals("target_type")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -2026711560:
                            if (nextName.equals("follow_num")) {
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
                        case -1179756352:
                            if (nextName.equals("is_top")) {
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
                        case -815576439:
                            if (nextName.equals("target_id")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
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
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 94851343:
                            if (nextName.equals("count")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 824889991:
                            if (nextName.equals("fans_num")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 959777669:
                            if (nextName.equals("answer_num")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 2103869862:
                            if (nextName.equals("comment_num")) {
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
                            str27 = this.targetTypeAdapter.read(jsonReader);
                            continue;
                        case 3:
                            i9 = this.followNumAdapter.read(jsonReader).intValue();
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
                            i8 = this.isTopAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            str25 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str26 = this.targetIdAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str23 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str24 = this.idAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str20 = this.picAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str28 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str18 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str21 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 16:
                            i7 = this.countAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            str17 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 18:
                            i11 = this.fansNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            i6 = this.answerNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 21:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i10 = this.commentNumAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_RecentHistory(str25, str15, str16, num2, str17, str18, str19, str20, str21, str22, str23, l3, l4, str24, i7, i8, str26, str27, str28, i9, i10, i11, i6);
        }
    }
}
