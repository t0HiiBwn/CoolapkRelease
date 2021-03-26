package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedQuestion  reason: invalid class name */
abstract class C$AutoValue_FeedQuestion extends C$$AutoValue_FeedQuestion {
    C$AutoValue_FeedQuestion(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, UserInfo userInfo, String str13, String str14, String str15, int i2, String str16, int i3, String str17, int i4, int i5, String str18) {
        super(str, str2, str3, i, str4, num, str5, str6, str7, str8, str9, str10, str11, l, l2, str12, userInfo, str13, str14, str15, i2, str16, i3, str17, i4, i5, str18);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedQuestion$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedQuestion> {
        private final TypeAdapter<Integer> blockStatusAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultBlockStatus = 0;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityType = null;
        private int defaultEntityTypeId = 0;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private String defaultId = null;
        private Long defaultLastUpdate = null;
        private String defaultLogo = null;
        private String defaultMessage = null;
        private int defaultMessageStatus = 0;
        private String defaultMessageTitle = null;
        private String defaultPic = null;
        private int defaultQuestionAnswerNum = 0;
        private int defaultQuestionFollowNum = 0;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeAdapter;
        private final TypeAdapter<Integer> entityTypeIdAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<Integer> messageStatusAdapter;
        private final TypeAdapter<String> messageTitleAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> questionAnswerNumAdapter;
        private final TypeAdapter<Integer> questionFollowNumAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.entityTypeAdapter = gson.getAdapter(String.class);
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
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.blockStatusAdapter = gson.getAdapter(Integer.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.messageStatusAdapter = gson.getAdapter(Integer.class);
            this.messageTitleAdapter = gson.getAdapter(String.class);
            this.questionAnswerNumAdapter = gson.getAdapter(Integer.class);
            this.questionFollowNumAdapter = gson.getAdapter(Integer.class);
            this.uidAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntityType(String str) {
            this.defaultEntityType = str;
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

        public GsonTypeAdapter setDefaultDeprecatedUserAvatar(String str) {
            this.defaultDeprecatedUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserInfo(UserInfo userInfo) {
            this.defaultUserInfo = userInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultDeprecatedUserName(String str) {
            this.defaultDeprecatedUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayUserName(String str) {
            this.defaultDisplayUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBlockStatus(int i) {
            this.defaultBlockStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageStatus(int i) {
            this.defaultMessageStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageTitle(String str) {
            this.defaultMessageTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultQuestionAnswerNum(int i) {
            this.defaultQuestionAnswerNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultQuestionFollowNum(int i) {
            this.defaultQuestionFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, FeedQuestion feedQuestion) throws IOException {
            if (feedQuestion == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, feedQuestion.getEntityTypeName());
            jsonWriter.name("entityType");
            this.entityTypeAdapter.write(jsonWriter, feedQuestion.getEntityType());
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, feedQuestion.getEntityTemplate());
            jsonWriter.name("entityTypeId");
            this.entityTypeIdAdapter.write(jsonWriter, Integer.valueOf(feedQuestion.getEntityTypeId()));
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, feedQuestion.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, feedQuestion.getEntityFixed());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, feedQuestion.getTitle());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, feedQuestion.getUrl());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, feedQuestion.getDescription());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, feedQuestion.getPic());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, feedQuestion.getLogo());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, feedQuestion.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, feedQuestion.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, feedQuestion.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, feedQuestion.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, feedQuestion.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, feedQuestion.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, feedQuestion.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, feedQuestion.getDisplayUserName());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, feedQuestion.getMessage());
            jsonWriter.name("block_status");
            this.blockStatusAdapter.write(jsonWriter, Integer.valueOf(feedQuestion.getBlockStatus()));
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, feedQuestion.getId());
            jsonWriter.name("message_status");
            this.messageStatusAdapter.write(jsonWriter, Integer.valueOf(feedQuestion.getMessageStatus()));
            jsonWriter.name("message_title");
            this.messageTitleAdapter.write(jsonWriter, feedQuestion.getMessageTitle());
            jsonWriter.name("question_answer_num");
            this.questionAnswerNumAdapter.write(jsonWriter, Integer.valueOf(feedQuestion.getQuestionAnswerNum()));
            jsonWriter.name("question_follow_num");
            this.questionFollowNumAdapter.write(jsonWriter, Integer.valueOf(feedQuestion.getQuestionFollowNum()));
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, feedQuestion.getUid());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedQuestion read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTypeName;
            String str2 = this.defaultEntityType;
            String str3 = this.defaultEntityTemplate;
            int i = this.defaultEntityTypeId;
            String str4 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str5 = this.defaultTitle;
            String str6 = this.defaultUrl;
            String str7 = this.defaultDescription;
            String str8 = this.defaultPic;
            String str9 = this.defaultLogo;
            String str10 = this.defaultSubTitle;
            String str11 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str12 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str13 = this.defaultDeprecatedUserName;
            String str14 = this.defaultDisplayUserName;
            String str15 = this.defaultMessage;
            int i2 = this.defaultBlockStatus;
            String str16 = this.defaultId;
            int i3 = this.defaultMessageStatus;
            String str17 = this.defaultMessageTitle;
            int i4 = this.defaultQuestionAnswerNum;
            int i5 = this.defaultQuestionFollowNum;
            String str18 = this.defaultUid;
            String str19 = str2;
            String str20 = str3;
            int i6 = i;
            String str21 = str4;
            Integer num2 = num;
            String str22 = str5;
            String str23 = str6;
            String str24 = str7;
            String str25 = str8;
            String str26 = str9;
            String str27 = str10;
            String str28 = str11;
            Long l3 = l;
            String str29 = str;
            Long l4 = l2;
            String str30 = str12;
            UserInfo userInfo2 = userInfo;
            String str31 = str13;
            String str32 = str14;
            String str33 = str15;
            int i7 = i2;
            String str34 = str16;
            int i8 = i3;
            String str35 = str17;
            int i9 = i4;
            int i10 = i5;
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
                        case -1559845903:
                            if (nextName.equals("question_follow_num")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1482998339:
                            if (nextName.equals("entityType")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
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
                        case -1213783008:
                            if (nextName.equals("message_title")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -601407516:
                            if (nextName.equals("block_status")) {
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
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 767740856:
                            if (nextName.equals("entityTypeId")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 1008404266:
                            if (nextName.equals("message_status")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 1426643326:
                            if (nextName.equals("question_answer_num")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = 26;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str21 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str27 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str24 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str20 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i10 = this.questionFollowNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str19 = this.entityTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str32 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str35 = this.messageTitleAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str29 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i7 = this.blockStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str31 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str28 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str34 = this.idAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str25 = this.picAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str18 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str23 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str26 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str22 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 20:
                            i6 = this.entityTypeIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            str33 = this.messageAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i8 = this.messageStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            str30 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 24:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 25:
                            i9 = this.questionAnswerNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 26:
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedQuestion(str29, str19, str20, i6, str21, num2, str22, str23, str24, str25, str26, str27, str28, l3, l4, str30, userInfo2, str31, str32, str33, i7, str34, i8, str35, i9, i10, str18);
        }
    }
}
