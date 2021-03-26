package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_UserInfo  reason: invalid class name */
abstract class C$AutoValue_UserInfo extends C$$AutoValue_UserInfo {
    C$AutoValue_UserInfo(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, String str3, String str4, int i7, String str5, String str6, String str7, String str8, String str9, long j, String str10, int i8, String str11, String str12, String str13) {
        super(str, str2, i, i2, i3, i4, i5, i6, str3, str4, i7, str5, str6, str7, str8, str9, j, str10, i8, str11, str12, str13);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_UserInfo$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<UserInfo> {
        private final TypeAdapter<Integer> adminTypeAdapter;
        private final TypeAdapter<Integer> avatarStatusAdapter;
        private final TypeAdapter<String> bioAdapter;
        private int defaultAdminType = 0;
        private int defaultAvatarStatus = 0;
        private String defaultBio = null;
        private String defaultDisplayUserName = null;
        private String defaultFans = null;
        private String defaultFollow = null;
        private int defaultGroupId = 0;
        private int defaultLevel = 0;
        private long defaultLoginTime = 0;
        private int defaultStatus = 0;
        private String defaultUid = null;
        private String defaultUrl = null;
        private String defaultUserAvatar = null;
        private String defaultUserBigAvatar = null;
        private int defaultUserGroupId = 0;
        private String defaultUserName = null;
        private int defaultUserNameStatus = 0;
        private String defaultUserSmallAvatar = null;
        private String defaultVerifyIcon = null;
        private String defaultVerifyLabel = null;
        private int defaultVerifyStatus = 0;
        private String defaultVerifyTitle = null;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<String> fansAdapter;
        private final TypeAdapter<String> followAdapter;
        private final TypeAdapter<Integer> groupIdAdapter;
        private final TypeAdapter<Integer> levelAdapter;
        private final TypeAdapter<Long> loginTimeAdapter;
        private final TypeAdapter<Integer> statusAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<String> userAvatarAdapter;
        private final TypeAdapter<String> userBigAvatarAdapter;
        private final TypeAdapter<Integer> userGroupIdAdapter;
        private final TypeAdapter<String> userNameAdapter;
        private final TypeAdapter<Integer> userNameStatusAdapter;
        private final TypeAdapter<String> userSmallAvatarAdapter;
        private final TypeAdapter<String> verifyIconAdapter;
        private final TypeAdapter<String> verifyLabelAdapter;
        private final TypeAdapter<Integer> verifyStatusAdapter;
        private final TypeAdapter<String> verifyTitleAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.uidAdapter = gson.getAdapter(String.class);
            this.userNameAdapter = gson.getAdapter(String.class);
            this.adminTypeAdapter = gson.getAdapter(Integer.class);
            this.groupIdAdapter = gson.getAdapter(Integer.class);
            this.userGroupIdAdapter = gson.getAdapter(Integer.class);
            this.statusAdapter = gson.getAdapter(Integer.class);
            this.userNameStatusAdapter = gson.getAdapter(Integer.class);
            this.avatarStatusAdapter = gson.getAdapter(Integer.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
            this.levelAdapter = gson.getAdapter(Integer.class);
            this.userAvatarAdapter = gson.getAdapter(String.class);
            this.fansAdapter = gson.getAdapter(String.class);
            this.followAdapter = gson.getAdapter(String.class);
            this.bioAdapter = gson.getAdapter(String.class);
            this.userSmallAvatarAdapter = gson.getAdapter(String.class);
            this.loginTimeAdapter = gson.getAdapter(Long.class);
            this.userBigAvatarAdapter = gson.getAdapter(String.class);
            this.verifyStatusAdapter = gson.getAdapter(Integer.class);
            this.verifyIconAdapter = gson.getAdapter(String.class);
            this.verifyLabelAdapter = gson.getAdapter(String.class);
            this.verifyTitleAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserName(String str) {
            this.defaultUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdminType(int i) {
            this.defaultAdminType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultGroupId(int i) {
            this.defaultGroupId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserGroupId(int i) {
            this.defaultUserGroupId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStatus(int i) {
            this.defaultStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserNameStatus(int i) {
            this.defaultUserNameStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAvatarStatus(int i) {
            this.defaultAvatarStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDisplayUserName(String str) {
            this.defaultDisplayUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLevel(int i) {
            this.defaultLevel = i;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAvatar(String str) {
            this.defaultUserAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFans(String str) {
            this.defaultFans = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollow(String str) {
            this.defaultFollow = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBio(String str) {
            this.defaultBio = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserSmallAvatar(String str) {
            this.defaultUserSmallAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultLoginTime(long j) {
            this.defaultLoginTime = j;
            return this;
        }

        public GsonTypeAdapter setDefaultUserBigAvatar(String str) {
            this.defaultUserBigAvatar = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyStatus(int i) {
            this.defaultVerifyStatus = i;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyIcon(String str) {
            this.defaultVerifyIcon = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyLabel(String str) {
            this.defaultVerifyLabel = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVerifyTitle(String str) {
            this.defaultVerifyTitle = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, UserInfo userInfo) throws IOException {
            if (userInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, userInfo.getUid());
            jsonWriter.name("username");
            this.userNameAdapter.write(jsonWriter, userInfo.getUserName());
            jsonWriter.name("admintype");
            this.adminTypeAdapter.write(jsonWriter, Integer.valueOf(userInfo.getAdminType()));
            jsonWriter.name("groupid");
            this.groupIdAdapter.write(jsonWriter, Integer.valueOf(userInfo.getGroupId()));
            jsonWriter.name("usergroupid");
            this.userGroupIdAdapter.write(jsonWriter, Integer.valueOf(userInfo.getUserGroupId()));
            jsonWriter.name("status");
            this.statusAdapter.write(jsonWriter, Integer.valueOf(userInfo.getStatus()));
            jsonWriter.name("usernamestatus");
            this.userNameStatusAdapter.write(jsonWriter, Integer.valueOf(userInfo.getUserNameStatus()));
            jsonWriter.name("avatarstatus");
            this.avatarStatusAdapter.write(jsonWriter, Integer.valueOf(userInfo.getAvatarStatus()));
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, userInfo.getDisplayUserName());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, userInfo.getUrl());
            jsonWriter.name("level");
            this.levelAdapter.write(jsonWriter, Integer.valueOf(userInfo.getLevel()));
            jsonWriter.name("userAvatar");
            this.userAvatarAdapter.write(jsonWriter, userInfo.getUserAvatar());
            jsonWriter.name("fans");
            this.fansAdapter.write(jsonWriter, userInfo.getFans());
            jsonWriter.name("follow");
            this.followAdapter.write(jsonWriter, userInfo.getFollow());
            jsonWriter.name("bio");
            this.bioAdapter.write(jsonWriter, userInfo.getBio());
            jsonWriter.name("userSmallAvatar");
            this.userSmallAvatarAdapter.write(jsonWriter, userInfo.getUserSmallAvatar());
            jsonWriter.name("logintime");
            this.loginTimeAdapter.write(jsonWriter, Long.valueOf(userInfo.getLoginTime()));
            jsonWriter.name("userBigAvatar");
            this.userBigAvatarAdapter.write(jsonWriter, userInfo.getUserBigAvatar());
            jsonWriter.name("verify_status");
            this.verifyStatusAdapter.write(jsonWriter, Integer.valueOf(userInfo.getVerifyStatus()));
            jsonWriter.name("verify_icon");
            this.verifyIconAdapter.write(jsonWriter, userInfo.getVerifyIcon());
            jsonWriter.name("verify_label");
            this.verifyLabelAdapter.write(jsonWriter, userInfo.getVerifyLabel());
            jsonWriter.name("verify_title");
            this.verifyTitleAdapter.write(jsonWriter, userInfo.getVerifyTitle());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UserInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultUid;
            String str2 = this.defaultUserName;
            int i = this.defaultAdminType;
            int i2 = this.defaultGroupId;
            int i3 = this.defaultUserGroupId;
            int i4 = this.defaultStatus;
            int i5 = this.defaultUserNameStatus;
            int i6 = this.defaultAvatarStatus;
            String str3 = this.defaultDisplayUserName;
            String str4 = this.defaultUrl;
            int i7 = this.defaultLevel;
            String str5 = this.defaultUserAvatar;
            String str6 = this.defaultFans;
            String str7 = this.defaultFollow;
            String str8 = this.defaultBio;
            String str9 = this.defaultUserSmallAvatar;
            long j = this.defaultLoginTime;
            String str10 = this.defaultUserBigAvatar;
            int i8 = this.defaultVerifyStatus;
            String str11 = this.defaultVerifyIcon;
            String str12 = this.defaultVerifyLabel;
            String str13 = this.defaultVerifyTitle;
            int i9 = i8;
            int i10 = i;
            int i11 = i2;
            int i12 = i3;
            int i13 = i4;
            int i14 = i5;
            int i15 = i6;
            String str14 = str3;
            String str15 = str4;
            int i16 = i7;
            String str16 = str5;
            String str17 = str6;
            String str18 = str7;
            String str19 = str;
            String str20 = str8;
            String str21 = str2;
            String str22 = str9;
            long j2 = j;
            String str23 = str10;
            String str24 = str11;
            String str25 = str12;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1948594049:
                            if (nextName.equals("verify_icon")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1864912146:
                            if (nextName.equals("userBigAvatar")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1718327882:
                            if (nextName.equals("logintime")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1673090641:
                            if (nextName.equals("usergroupid")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1268958287:
                            if (nextName.equals("follow")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1071194040:
                            if (nextName.equals("usernamestatus")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -892481550:
                            if (nextName.equals("status")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -274175058:
                            if (nextName.equals("verify_label")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -266531054:
                            if (nextName.equals("verify_title")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 97544:
                            if (nextName.equals("bio")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
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
                        case 3135424:
                            if (nextName.equals("fans")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3566219:
                            if (nextName.equals("avatarstatus")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 22827785:
                            if (nextName.equals("admintype")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 102865796:
                            if (nextName.equals("level")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 293429210:
                            if (nextName.equals("groupid")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 308443768:
                            if (nextName.equals("verify_status")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 533143669:
                            if (nextName.equals("userSmallAvatar")) {
                                c = 20;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 21;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str24 = this.verifyIconAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str23 = this.userBigAvatarAdapter.read(jsonReader);
                            continue;
                        case 2:
                            j2 = this.loginTimeAdapter.read(jsonReader).longValue();
                            continue;
                        case 3:
                            i12 = this.userGroupIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            str14 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str18 = this.followAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i14 = this.userNameStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            i13 = this.statusAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            str25 = this.verifyLabelAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str13 = this.verifyTitleAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str21 = this.userNameAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str20 = this.bioAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str19 = this.uidAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str15 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str17 = this.fansAdapter.read(jsonReader);
                            continue;
                        case 15:
                            i15 = this.avatarStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 16:
                            i10 = this.adminTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 17:
                            i16 = this.levelAdapter.read(jsonReader).intValue();
                            continue;
                        case 18:
                            i11 = this.groupIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 19:
                            i9 = this.verifyStatusAdapter.read(jsonReader).intValue();
                            continue;
                        case 20:
                            str22 = this.userSmallAvatarAdapter.read(jsonReader);
                            continue;
                        case 21:
                            str16 = this.userAvatarAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UserInfo(str19, str21, i10, i11, i12, i13, i14, i15, str14, str15, i16, str16, str17, str18, str20, str22, j2, str23, i9, str24, str25, str13);
        }
    }
}
