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

/* renamed from: com.coolapk.market.model.$AutoValue_DyhModel  reason: invalid class name */
abstract class C$AutoValue_DyhModel extends C$$AutoValue_DyhModel {
    C$AutoValue_DyhModel(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l, Long l2, String str7, UserInfo userInfo, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, EditorInfo editorInfo, String str17, String str18, int i, int i2, int i3, int i4, List<String> list, int i5, int i6, String str19, List<DyhArticle> list2, UserAction userAction, Unread unread) {
        super(str, str2, num, str3, str4, str5, str6, l, l2, str7, userInfo, str8, str9, str10, str11, str12, str13, str14, str15, str16, editorInfo, str17, str18, i, i2, i3, i4, list, i5, i6, str19, list2, userAction, unread);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DyhModel$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<DyhModel> {
        private final TypeAdapter<String> authorAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private String defaultAuthor = null;
        private Long defaultDateline = null;
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDescription = null;
        private String defaultDisplayUserName = null;
        private EditorInfo defaultEditorInfo = null;
        private List<String> defaultEditors = Collections.emptyList();
        private List<DyhArticle> defaultEntities = null;
        private Integer defaultEntityFixed = null;
        private String defaultEntityId = null;
        private String defaultEntityTemplate = null;
        private String defaultEntityTypeName = null;
        private String defaultExtraData = null;
        private int defaultFollowNum = 0;
        private String defaultFromInfo = null;
        private int defaultHasTab = 0;
        private String defaultId = null;
        private String defaultKeywords = null;
        private Long defaultLastUpdate = null;
        private int defaultLikeNum = 0;
        private String defaultLogo = null;
        private int defaultNewsNum = 0;
        private String defaultPic = null;
        private int defaultRecommend = 0;
        private int defaultStatus = 0;
        private String defaultStatusText = null;
        private String defaultSubTitle = null;
        private String defaultTitle = null;
        private String defaultUid = null;
        private Unread defaultUnread = null;
        private String defaultUrl = null;
        private UserAction defaultUserAction = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> descriptionAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<EditorInfo> editorInfoAdapter;
        private final TypeAdapter<List<String>> editorsAdapter;
        private final TypeAdapter<List<DyhArticle>> entitiesAdapter;
        private final TypeAdapter<Integer> entityFixedAdapter;
        private final TypeAdapter<String> entityIdAdapter;
        private final TypeAdapter<String> entityTemplateAdapter;
        private final TypeAdapter<String> entityTypeNameAdapter;
        private final TypeAdapter<String> extraDataAdapter;
        private final TypeAdapter<Integer> followNumAdapter;
        private final TypeAdapter<String> fromInfoAdapter;
        private final TypeAdapter<Integer> hasTabAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> keywordsAdapter;
        private final TypeAdapter<Long> lastUpdateAdapter;
        private final TypeAdapter<Integer> likeNumAdapter;
        private final TypeAdapter<String> logoAdapter;
        private final TypeAdapter<Integer> newsNumAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<Integer> recommendAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> statusTextAdapter;
        private final TypeAdapter<String> subTitleAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<Unread> unreadAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.entityTemplateAdapter = gson.getAdapter(String.class);
            this.entityIdAdapter = gson.getAdapter(String.class);
            this.entityFixedAdapter = gson.getAdapter(Integer.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.subTitleAdapter = gson.getAdapter(String.class);
            this.extraDataAdapter = gson.getAdapter(String.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
            this.lastUpdateAdapter = gson.getAdapter(Long.class);
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.entityTypeNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.descriptionAdapter = gson.getAdapter(String.class);
            this.authorAdapter = gson.getAdapter(String.class);
            this.fromInfoAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.editorInfoAdapter = gson.getAdapter(EditorInfo.class);
            this.logoAdapter = gson.getAdapter(String.class);
            this.keywordsAdapter = gson.getAdapter(String.class);
            this.hasTabAdapter = gson.getAdapter(Integer.class);
            this.likeNumAdapter = gson.getAdapter(Integer.class);
            this.newsNumAdapter = gson.getAdapter(Integer.class);
            this.recommendAdapter = gson.getAdapter(Integer.class);
            this.editorsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.followNumAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.statusTextAdapter = gson.getAdapter(String.class);
            this.entitiesAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, DyhArticle.class));
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.unreadAdapter = gson.getAdapter(Unread.class);
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

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
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

        public GsonTypeAdapter setDefaultEntityTypeName(String str) {
            this.defaultEntityTypeName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDescription(String str) {
            this.defaultDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAuthor(String str) {
            this.defaultAuthor = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFromInfo(String str) {
            this.defaultFromInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEditorInfo(EditorInfo editorInfo) {
            this.defaultEditorInfo = editorInfo;
            return this;
        }

        public GsonTypeAdapter setDefaultLogo(String str) {
            this.defaultLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultKeywords(String str) {
            this.defaultKeywords = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHasTab(int i) {
            this.defaultHasTab = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLikeNum(int i) {
            this.defaultLikeNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNewsNum(int i) {
            this.defaultNewsNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRecommend(int i) {
            this.defaultRecommend = i;
            return this;
        }

        public GsonTypeAdapter setDefaultEditors(List<String> list) {
            this.defaultEditors = list;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowNum(int i) {
            this.defaultFollowNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatusText(String str) {
            this.defaultStatusText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultEntities(List<DyhArticle> list) {
            this.defaultEntities = list;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultUnread(Unread unread) {
            this.defaultUnread = unread;
            return this;
        }

        public void write(JsonWriter jsonWriter, DyhModel dyhModel) throws IOException {
            if (dyhModel == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.entityTemplateAdapter.write(jsonWriter, dyhModel.getEntityTemplate());
            jsonWriter.name("entityId");
            this.entityIdAdapter.write(jsonWriter, dyhModel.getEntityId());
            jsonWriter.name("entityFixed");
            this.entityFixedAdapter.write(jsonWriter, dyhModel.getEntityFixed());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, dyhModel.getUrl());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, dyhModel.getPic());
            jsonWriter.name("subTitle");
            this.subTitleAdapter.write(jsonWriter, dyhModel.getSubTitle());
            jsonWriter.name("extraData");
            this.extraDataAdapter.write(jsonWriter, dyhModel.getExtraData());
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, dyhModel.getDateline());
            jsonWriter.name("lastupdate");
            this.lastUpdateAdapter.write(jsonWriter, dyhModel.getLastUpdate());
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, dyhModel.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, dyhModel.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, dyhModel.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, dyhModel.getDisplayUserName());
            jsonWriter.name("entityTypeName");
            this.entityTypeNameAdapter.write(jsonWriter, dyhModel.getEntityTypeName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, dyhModel.getId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, dyhModel.getUid());
            jsonWriter.name("description");
            this.descriptionAdapter.write(jsonWriter, dyhModel.getDescription());
            jsonWriter.name("author");
            this.authorAdapter.write(jsonWriter, dyhModel.getAuthor());
            jsonWriter.name("fromInfo");
            this.fromInfoAdapter.write(jsonWriter, dyhModel.getFromInfo());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, dyhModel.getTitle());
            jsonWriter.name("editorInfo");
            this.editorInfoAdapter.write(jsonWriter, dyhModel.getEditorInfo());
            jsonWriter.name("logo");
            this.logoAdapter.write(jsonWriter, dyhModel.getLogo());
            jsonWriter.name("keywords");
            this.keywordsAdapter.write(jsonWriter, dyhModel.getKeywords());
            jsonWriter.name("is_open_discuss");
            this.hasTabAdapter.write(jsonWriter, Integer.valueOf(dyhModel.getHasTab()));
            jsonWriter.name("likenum");
            this.likeNumAdapter.write(jsonWriter, Integer.valueOf(dyhModel.getLikeNum()));
            jsonWriter.name("newsnum");
            this.newsNumAdapter.write(jsonWriter, Integer.valueOf(dyhModel.getNewsNum()));
            jsonWriter.name("recommend");
            this.recommendAdapter.write(jsonWriter, Integer.valueOf(dyhModel.getRecommend()));
            jsonWriter.name("uniteEditor");
            this.editorsAdapter.write(jsonWriter, dyhModel.getEditors());
            jsonWriter.name("follownum");
            this.followNumAdapter.write(jsonWriter, Integer.valueOf(dyhModel.getFollowNum()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(dyhModel.getStatus()));
            jsonWriter.name("statusText");
            this.statusTextAdapter.write(jsonWriter, dyhModel.getStatusText());
            jsonWriter.name("entities");
            this.entitiesAdapter.write(jsonWriter, dyhModel.getEntities());
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, dyhModel.getUserAction());
            jsonWriter.name("unread");
            this.unreadAdapter.write(jsonWriter, dyhModel.getUnread());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public DyhModel read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultEntityTemplate;
            String str2 = this.defaultEntityId;
            Integer num = this.defaultEntityFixed;
            String str3 = this.defaultUrl;
            String str4 = this.defaultPic;
            String str5 = this.defaultSubTitle;
            String str6 = this.defaultExtraData;
            Long l = this.defaultDateline;
            Long l2 = this.defaultLastUpdate;
            String str7 = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str8 = this.defaultDeprecatedUserName;
            String str9 = this.defaultDisplayUserName;
            String str10 = this.defaultEntityTypeName;
            String str11 = this.defaultId;
            String str12 = this.defaultUid;
            String str13 = this.defaultDescription;
            String str14 = this.defaultAuthor;
            String str15 = this.defaultFromInfo;
            String str16 = this.defaultTitle;
            EditorInfo editorInfo = this.defaultEditorInfo;
            String str17 = this.defaultLogo;
            String str18 = this.defaultKeywords;
            int i = this.defaultHasTab;
            int i2 = this.defaultLikeNum;
            int i3 = this.defaultNewsNum;
            int i4 = this.defaultRecommend;
            List<String> list = this.defaultEditors;
            int i5 = this.defaultFollowNum;
            int i6 = this.defaultStatus;
            String str19 = this.defaultStatusText;
            List<DyhArticle> list2 = this.defaultEntities;
            UserAction userAction = this.defaultUserAction;
            Unread unread = this.defaultUnread;
            String str20 = str2;
            Integer num2 = num;
            String str21 = str3;
            String str22 = str4;
            String str23 = str5;
            String str24 = str6;
            Long l3 = l;
            Long l4 = l2;
            String str25 = str7;
            UserInfo userInfo2 = userInfo;
            String str26 = str8;
            String str27 = str9;
            String str28 = str10;
            String str29 = str;
            String str30 = str11;
            String str31 = str12;
            String str32 = str13;
            String str33 = str14;
            String str34 = str15;
            String str35 = str16;
            EditorInfo editorInfo2 = editorInfo;
            String str36 = str17;
            String str37 = str18;
            int i7 = i;
            int i8 = i2;
            int i9 = i3;
            int i10 = i4;
            List<String> list3 = list;
            int i11 = i5;
            int i12 = i6;
            String str38 = str19;
            List<DyhArticle> list4 = list2;
            UserAction userAction2 = userAction;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2102114367:
                            if (nextName.equals("entities")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2102099874:
                            if (nextName.equals("entityId")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -2090050568:
                            if (nextName.equals("subTitle")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1724546052:
                            if (nextName.equals("description")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1580301955:
                            if (nextName.equals("entityTemplate")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1556710469:
                            if (nextName.equals("editorInfo")) {
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
                        case -1406328437:
                            if (nextName.equals("author")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1385954593:
                            if (nextName.equals("lastupdate")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1244984456:
                            if (nextName.equals("fromInfo")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -935262744:
                            if (nextName.equals("entityTypeName")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -840272977:
                            if (nextName.equals("unread")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -253792294:
                            if (nextName.equals("extraData")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 174145679:
                            if (nextName.equals("likenum")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 248004671:
                            if (nextName.equals("statusText")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 523149226:
                            if (nextName.equals("keywords")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 765920821:
                            if (nextName.equals("follownum")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 989204668:
                            if (nextName.equals("recommend")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 1081382958:
                            if (nextName.equals("uniteEditor")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 1424279520:
                            if (nextName.equals("is_open_discuss")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 1846135763:
                            if (nextName.equals("newsnum")) {
                                c = '!';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            list4 = this.entitiesAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str20 = this.entityIdAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str23 = this.subTitleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str32 = this.descriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str29 = this.entityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            editorInfo2 = this.editorInfoAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str27 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str33 = this.authorAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            l4 = this.lastUpdateAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str34 = this.fromInfoAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str28 = this.entityTypeNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            i12 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\f':
                            unread = this.unreadAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str26 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str24 = this.extraDataAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str30 = this.idAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str22 = this.picAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str31 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str21 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str36 = this.logoAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str35 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 22:
                            i8 = this.likeNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 23:
                            str38 = this.statusTextAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str37 = this.keywordsAdapter.read(jsonReader);
                            continue;
                        case 25:
                            i11 = this.followNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 26:
                            i10 = this.recommendAdapter.read(jsonReader).intValue();
                            continue;
                        case 27:
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str25 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        case 29:
                            list3 = this.editorsAdapter.read(jsonReader);
                            continue;
                        case 30:
                            num2 = this.entityFixedAdapter.read(jsonReader);
                            continue;
                        case 31:
                            i7 = this.hasTabAdapter.read(jsonReader).intValue();
                            continue;
                        case ' ':
                            l3 = this.datelineAdapter.read(jsonReader);
                            continue;
                        case '!':
                            i9 = this.newsNumAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_DyhModel(str29, str20, num2, str21, str22, str23, str24, l3, l4, str25, userInfo2, str26, str27, str28, str30, str31, str32, str33, str34, str35, editorInfo2, str36, str37, i7, i8, i9, i10, list3, i11, i12, str38, list4, userAction2, unread);
        }
    }
}
