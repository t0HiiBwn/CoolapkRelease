package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.coolapk.market.model.$AutoValue_AppForum  reason: invalid class name */
abstract class C$AutoValue_AppForum extends C$$AutoValue_AppForum {
    C$AutoValue_AppForum(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, int i, String str13, String str14, String str15, int i2, int i3, String str16, String str17, String str18, String str19, String str20, String str21, int i4, UserAction userAction, int i5, String str22, String str23, List<String> list, List<String> list2) {
        super(str, str2, num, str3, str4, str5, str6, str7, str8, str9, str10, l, l2, str11, str12, i, str13, str14, str15, i2, i3, str16, str17, str18, str19, str20, str21, i4, userAction, i5, str22, str23, list, list2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_AppForum$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<AppForum> {
        private final TypeAdapter<String> apkNameAdapter;
        private final TypeAdapter<String> apkSizeAdapter;
        private final TypeAdapter<Integer> apkTypeAdapter;
        private final TypeAdapter<String> appNameAdapter;
        private final TypeAdapter<String> appUrlAdapter;
        private final TypeAdapter<Integer> commentBlockNumAdapter;
        private final TypeAdapter<String> commentCountAdapter;
        private String defaultApkName = null;
        private String defaultApkSize = null;
        private int defaultApkType = 0;
        private String defaultAppName = null;
        private String defaultAppUrl = null;
        private int defaultCommentBlockNum = 0;
        private String defaultCommentCount = null;
        private String defaultDownCount = null;
        private String defaultExtendFile = null;
        private String defaultExtraAnalysisData = null;
        private String defaultFollowCount = null;
        private Long defaultGetDateline = null;
        private String defaultGetDescription = null;
        private Integer defaultGetEntityFixed = null;
        private String defaultGetEntityId = null;
        private String defaultGetEntityTemplate = null;
        private String defaultGetExtraData = null;
        private String defaultGetId = null;
        private Long defaultGetLastUpdate = null;
        private String defaultGetLogo = null;
        private String defaultGetPic = null;
        private String defaultGetSubTitle = null;
        private String defaultGetTargetId = null;
        private String defaultGetTitle = null;
        private String defaultGetUrl = null;
        private String defaultIntroduce = null;
        private int defaultIs_download_app = 0;
        private String defaultPackageName = null;
        private List<String> defaultScreenList = null;
        private int defaultSupportAndroidVersion = 0;
        private List<String> defaultThumbList = null;
        private UserAction defaultUserAction = null;
        private int defaultVersionCode = 0;
        private String defaultVersionName = null;
        private final TypeAdapter<String> downCountAdapter;
        private final TypeAdapter<String> extendFileAdapter;
        private final TypeAdapter<String> extraAnalysisDataAdapter;
        private final TypeAdapter<String> followCountAdapter;
        private final TypeAdapter<Long> getDatelineAdapter;
        private final TypeAdapter<String> getDescriptionAdapter;
        private final TypeAdapter<Integer> getEntityFixedAdapter;
        private final TypeAdapter<String> getEntityIdAdapter;
        private final TypeAdapter<String> getEntityTemplateAdapter;
        private final TypeAdapter<String> getExtraDataAdapter;
        private final TypeAdapter<String> getIdAdapter;
        private final TypeAdapter<Long> getLastUpdateAdapter;
        private final TypeAdapter<String> getLogoAdapter;
        private final TypeAdapter<String> getPicAdapter;
        private final TypeAdapter<String> getSubTitleAdapter;
        private final TypeAdapter<String> getTargetIdAdapter;
        private final TypeAdapter<String> getTitleAdapter;
        private final TypeAdapter<String> getUrlAdapter;
        private final TypeAdapter<String> introduceAdapter;
        private final TypeAdapter<Integer> is_download_appAdapter;
        private final TypeAdapter<String> packageNameAdapter;
        private final TypeAdapter<List<String>> screenListAdapter;
        private final TypeAdapter<Integer> supportAndroidVersionAdapter;
        private final TypeAdapter<List<String>> thumbListAdapter;
        private final TypeAdapter<UserAction> userActionAdapter;
        private final TypeAdapter<Integer> versionCodeAdapter;
        private final TypeAdapter<String> versionNameAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.getEntityTemplateAdapter = gson.getAdapter(String.class);
            this.getEntityIdAdapter = gson.getAdapter(String.class);
            this.getEntityFixedAdapter = gson.getAdapter(Integer.class);
            this.getTitleAdapter = gson.getAdapter(String.class);
            this.getUrlAdapter = gson.getAdapter(String.class);
            this.getDescriptionAdapter = gson.getAdapter(String.class);
            this.getPicAdapter = gson.getAdapter(String.class);
            this.getLogoAdapter = gson.getAdapter(String.class);
            this.getSubTitleAdapter = gson.getAdapter(String.class);
            this.getIdAdapter = gson.getAdapter(String.class);
            this.getExtraDataAdapter = gson.getAdapter(String.class);
            this.getDatelineAdapter = gson.getAdapter(Long.class);
            this.getLastUpdateAdapter = gson.getAdapter(Long.class);
            this.getTargetIdAdapter = gson.getAdapter(String.class);
            this.appNameAdapter = gson.getAdapter(String.class);
            this.apkTypeAdapter = gson.getAdapter(Integer.class);
            this.apkNameAdapter = gson.getAdapter(String.class);
            this.apkSizeAdapter = gson.getAdapter(String.class);
            this.versionNameAdapter = gson.getAdapter(String.class);
            this.versionCodeAdapter = gson.getAdapter(Integer.class);
            this.supportAndroidVersionAdapter = gson.getAdapter(Integer.class);
            this.extendFileAdapter = gson.getAdapter(String.class);
            this.followCountAdapter = gson.getAdapter(String.class);
            this.downCountAdapter = gson.getAdapter(String.class);
            this.commentCountAdapter = gson.getAdapter(String.class);
            this.packageNameAdapter = gson.getAdapter(String.class);
            this.appUrlAdapter = gson.getAdapter(String.class);
            this.is_download_appAdapter = gson.getAdapter(Integer.class);
            this.userActionAdapter = gson.getAdapter(UserAction.class);
            this.commentBlockNumAdapter = gson.getAdapter(Integer.class);
            this.extraAnalysisDataAdapter = gson.getAdapter(String.class);
            this.introduceAdapter = gson.getAdapter(String.class);
            this.thumbListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
            this.screenListAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
        }

        public GsonTypeAdapter setDefaultGetEntityTemplate(String str) {
            this.defaultGetEntityTemplate = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetEntityId(String str) {
            this.defaultGetEntityId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetEntityFixed(Integer num) {
            this.defaultGetEntityFixed = num;
            return this;
        }

        public GsonTypeAdapter setDefaultGetTitle(String str) {
            this.defaultGetTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetUrl(String str) {
            this.defaultGetUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetDescription(String str) {
            this.defaultGetDescription = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetPic(String str) {
            this.defaultGetPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetLogo(String str) {
            this.defaultGetLogo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetSubTitle(String str) {
            this.defaultGetSubTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetId(String str) {
            this.defaultGetId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetExtraData(String str) {
            this.defaultGetExtraData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultGetDateline(Long l) {
            this.defaultGetDateline = l;
            return this;
        }

        public GsonTypeAdapter setDefaultGetLastUpdate(Long l) {
            this.defaultGetLastUpdate = l;
            return this;
        }

        public GsonTypeAdapter setDefaultGetTargetId(String str) {
            this.defaultGetTargetId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAppName(String str) {
            this.defaultAppName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkType(int i) {
            this.defaultApkType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultApkName(String str) {
            this.defaultApkName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultApkSize(String str) {
            this.defaultApkSize = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionName(String str) {
            this.defaultVersionName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVersionCode(int i) {
            this.defaultVersionCode = i;
            return this;
        }

        public GsonTypeAdapter setDefaultSupportAndroidVersion(int i) {
            this.defaultSupportAndroidVersion = i;
            return this;
        }

        public GsonTypeAdapter setDefaultExtendFile(String str) {
            this.defaultExtendFile = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowCount(String str) {
            this.defaultFollowCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultDownCount(String str) {
            this.defaultDownCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentCount(String str) {
            this.defaultCommentCount = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPackageName(String str) {
            this.defaultPackageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAppUrl(String str) {
            this.defaultAppUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIs_download_app(int i) {
            this.defaultIs_download_app = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAction(UserAction userAction) {
            this.defaultUserAction = userAction;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentBlockNum(int i) {
            this.defaultCommentBlockNum = i;
            return this;
        }

        public GsonTypeAdapter setDefaultExtraAnalysisData(String str) {
            this.defaultExtraAnalysisData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIntroduce(String str) {
            this.defaultIntroduce = str;
            return this;
        }

        public GsonTypeAdapter setDefaultThumbList(List<String> list) {
            this.defaultThumbList = list;
            return this;
        }

        public GsonTypeAdapter setDefaultScreenList(List<String> list) {
            this.defaultScreenList = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, AppForum appForum) throws IOException {
            if (appForum == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("entityTemplate");
            this.getEntityTemplateAdapter.write(jsonWriter, appForum.getEntityTemplate());
            jsonWriter.name("entityId");
            this.getEntityIdAdapter.write(jsonWriter, appForum.getEntityId());
            jsonWriter.name("entityFixed");
            this.getEntityFixedAdapter.write(jsonWriter, appForum.getEntityFixed());
            jsonWriter.name("title");
            this.getTitleAdapter.write(jsonWriter, appForum.getTitle());
            jsonWriter.name("url");
            this.getUrlAdapter.write(jsonWriter, appForum.getUrl());
            jsonWriter.name("description");
            this.getDescriptionAdapter.write(jsonWriter, appForum.getDescription());
            jsonWriter.name("pic");
            this.getPicAdapter.write(jsonWriter, appForum.getPic());
            jsonWriter.name("logo");
            this.getLogoAdapter.write(jsonWriter, appForum.getLogo());
            jsonWriter.name("subTitle");
            this.getSubTitleAdapter.write(jsonWriter, appForum.getSubTitle());
            jsonWriter.name("id");
            this.getIdAdapter.write(jsonWriter, appForum.getId());
            jsonWriter.name("extraData");
            this.getExtraDataAdapter.write(jsonWriter, appForum.getExtraData());
            jsonWriter.name("dateline");
            this.getDatelineAdapter.write(jsonWriter, appForum.getDateline());
            jsonWriter.name("lastupdate");
            this.getLastUpdateAdapter.write(jsonWriter, appForum.getLastUpdate());
            jsonWriter.name("target_id");
            this.getTargetIdAdapter.write(jsonWriter, appForum.getTargetId());
            jsonWriter.name("shorttitle");
            this.appNameAdapter.write(jsonWriter, appForum.appName());
            jsonWriter.name("apktype");
            this.apkTypeAdapter.write(jsonWriter, Integer.valueOf(appForum.apkType()));
            jsonWriter.name("apkname");
            this.apkNameAdapter.write(jsonWriter, appForum.apkName());
            jsonWriter.name("apksize");
            this.apkSizeAdapter.write(jsonWriter, appForum.apkSize());
            jsonWriter.name("apkversionname");
            this.versionNameAdapter.write(jsonWriter, appForum.versionName());
            jsonWriter.name("apkversioncode");
            this.versionCodeAdapter.write(jsonWriter, Integer.valueOf(appForum.versionCode()));
            jsonWriter.name("sdkversion");
            this.supportAndroidVersionAdapter.write(jsonWriter, Integer.valueOf(appForum.supportAndroidVersion()));
            jsonWriter.name("extendfile");
            this.extendFileAdapter.write(jsonWriter, appForum.extendFile());
            jsonWriter.name("followCount");
            this.followCountAdapter.write(jsonWriter, appForum.followCount());
            jsonWriter.name("downCount");
            this.downCountAdapter.write(jsonWriter, appForum.downCount());
            jsonWriter.name("commentCount");
            this.commentCountAdapter.write(jsonWriter, appForum.commentCount());
            jsonWriter.name("packageName");
            this.packageNameAdapter.write(jsonWriter, appForum.packageName());
            jsonWriter.name("appUrl");
            this.appUrlAdapter.write(jsonWriter, appForum.appUrl());
            jsonWriter.name("is_download_app");
            this.is_download_appAdapter.write(jsonWriter, Integer.valueOf(appForum.is_download_app()));
            jsonWriter.name("userAction");
            this.userActionAdapter.write(jsonWriter, appForum.userAction());
            jsonWriter.name("comment_block_num");
            this.commentBlockNumAdapter.write(jsonWriter, Integer.valueOf(appForum.commentBlockNum()));
            jsonWriter.name("extraAnalysisData");
            this.extraAnalysisDataAdapter.write(jsonWriter, appForum.extraAnalysisData());
            jsonWriter.name("introduce");
            this.introduceAdapter.write(jsonWriter, appForum.introduce());
            jsonWriter.name("thumbList");
            this.thumbListAdapter.write(jsonWriter, appForum.thumbList());
            jsonWriter.name("screenList");
            this.screenListAdapter.write(jsonWriter, appForum.screenList());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public AppForum read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultGetEntityTemplate;
            String str2 = this.defaultGetEntityId;
            Integer num = this.defaultGetEntityFixed;
            String str3 = this.defaultGetTitle;
            String str4 = this.defaultGetUrl;
            String str5 = this.defaultGetDescription;
            String str6 = this.defaultGetPic;
            String str7 = this.defaultGetLogo;
            String str8 = this.defaultGetSubTitle;
            String str9 = this.defaultGetId;
            String str10 = this.defaultGetExtraData;
            Long l = this.defaultGetDateline;
            Long l2 = this.defaultGetLastUpdate;
            String str11 = this.defaultGetTargetId;
            String str12 = this.defaultAppName;
            int i = this.defaultApkType;
            String str13 = this.defaultApkName;
            String str14 = this.defaultApkSize;
            String str15 = this.defaultVersionName;
            int i2 = this.defaultVersionCode;
            int i3 = this.defaultSupportAndroidVersion;
            String str16 = this.defaultExtendFile;
            String str17 = this.defaultFollowCount;
            String str18 = this.defaultDownCount;
            String str19 = this.defaultCommentCount;
            String str20 = this.defaultPackageName;
            String str21 = this.defaultAppUrl;
            int i4 = this.defaultIs_download_app;
            UserAction userAction = this.defaultUserAction;
            int i5 = this.defaultCommentBlockNum;
            String str22 = this.defaultExtraAnalysisData;
            String str23 = this.defaultIntroduce;
            List<String> list = this.defaultThumbList;
            List<String> list2 = this.defaultScreenList;
            String str24 = str2;
            Integer num2 = num;
            String str25 = str3;
            String str26 = str4;
            String str27 = str5;
            String str28 = str6;
            String str29 = str7;
            String str30 = str8;
            String str31 = str9;
            String str32 = str10;
            Long l3 = l;
            Long l4 = l2;
            String str33 = str11;
            String str34 = str;
            String str35 = str12;
            int i6 = i;
            String str36 = str13;
            String str37 = str14;
            String str38 = str15;
            int i7 = i2;
            int i8 = i3;
            String str39 = str16;
            String str40 = str17;
            String str41 = str18;
            String str42 = str19;
            String str43 = str20;
            String str44 = str21;
            int i9 = i4;
            UserAction userAction2 = userAction;
            int i10 = i5;
            String str45 = str22;
            String str46 = str23;
            List<String> list3 = list;
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
                        case -1823369322:
                            if (nextName.equals("extendfile")) {
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
                        case -1411083378:
                            if (nextName.equals("appUrl")) {
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
                        case -815576439:
                            if (nextName.equals("target_id")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -797800793:
                            if (nextName.equals("apkname")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -797643747:
                            if (nextName.equals("apksize")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -797598890:
                            if (nextName.equals("apktype")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -590800682:
                            if (nextName.equals("extraAnalysisData")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -417607894:
                            if (nextName.equals("screenList")) {
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
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 3327403:
                            if (nextName.equals("logo")) {
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
                        case 375357151:
                            if (nextName.equals("is_download_app")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 667683678:
                            if (nextName.equals("sdkversion")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 683233012:
                            if (nextName.equals("comment_block_num")) {
                                c = 21;
                                break;
                            }
                            break;
                        case 769627632:
                            if (nextName.equals("commentCount")) {
                                c = 22;
                                break;
                            }
                            break;
                        case 871991583:
                            if (nextName.equals("introduce")) {
                                c = 23;
                                break;
                            }
                            break;
                        case 908759025:
                            if (nextName.equals("packageName")) {
                                c = 24;
                                break;
                            }
                            break;
                        case 1061163489:
                            if (nextName.equals("userAction")) {
                                c = 25;
                                break;
                            }
                            break;
                        case 1258293585:
                            if (nextName.equals("entityFixed")) {
                                c = 26;
                                break;
                            }
                            break;
                        case 1274859917:
                            if (nextName.equals("downCount")) {
                                c = 27;
                                break;
                            }
                            break;
                        case 1320549161:
                            if (nextName.equals("apkversioncode")) {
                                c = 28;
                                break;
                            }
                            break;
                        case 1320863687:
                            if (nextName.equals("apkversionname")) {
                                c = 29;
                                break;
                            }
                            break;
                        case 1329527700:
                            if (nextName.equals("thumbList")) {
                                c = 30;
                                break;
                            }
                            break;
                        case 1570622430:
                            if (nextName.equals("followCount")) {
                                c = 31;
                                break;
                            }
                            break;
                        case 1585056604:
                            if (nextName.equals("shorttitle")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '!';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str24 = this.getEntityIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str30 = this.getSubTitleAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str39 = this.extendFileAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str27 = this.getDescriptionAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str34 = this.getEntityTemplateAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str44 = this.appUrlAdapter.read(jsonReader);
                            continue;
                        case 6:
                            l4 = this.getLastUpdateAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str33 = this.getTargetIdAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str36 = this.apkNameAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str37 = this.apkSizeAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            i6 = this.apkTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 11:
                            str45 = this.extraAnalysisDataAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            list2 = this.screenListAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str32 = this.getExtraDataAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str31 = this.getIdAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str28 = this.getPicAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str26 = this.getUrlAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str29 = this.getLogoAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str25 = this.getTitleAdapter.read(jsonReader);
                            continue;
                        case 19:
                            i9 = this.is_download_appAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            i8 = this.supportAndroidVersionAdapter.read(jsonReader).intValue();
                            continue;
                        case 21:
                            i10 = this.commentBlockNumAdapter.read(jsonReader).intValue();
                            continue;
                        case 22:
                            str42 = this.commentCountAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str46 = this.introduceAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str43 = this.packageNameAdapter.read(jsonReader);
                            continue;
                        case 25:
                            userAction2 = this.userActionAdapter.read(jsonReader);
                            continue;
                        case 26:
                            num2 = this.getEntityFixedAdapter.read(jsonReader);
                            continue;
                        case 27:
                            str41 = this.downCountAdapter.read(jsonReader);
                            continue;
                        case 28:
                            i7 = this.versionCodeAdapter.read(jsonReader).intValue();
                            continue;
                        case 29:
                            str38 = this.versionNameAdapter.read(jsonReader);
                            continue;
                        case 30:
                            list3 = this.thumbListAdapter.read(jsonReader);
                            continue;
                        case 31:
                            str40 = this.followCountAdapter.read(jsonReader);
                            continue;
                        case ' ':
                            str35 = this.appNameAdapter.read(jsonReader);
                            continue;
                        case '!':
                            l3 = this.getDatelineAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_AppForum(str34, str24, num2, str25, str26, str27, str28, str29, str30, str31, str32, l3, l4, str33, str35, i6, str36, str37, str38, i7, i8, str39, str40, str41, str42, str43, str44, i9, userAction2, i10, str45, str46, list3, list2);
        }
    }
}
