package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class AutoValue_LoginInfo extends C$AutoValue_LoginInfo {
    AutoValue_LoginInfo(String str, String str2, String str3, String str4, int i, NotifyCount notifyCount, String str5) {
        super(str, str2, str3, str4, i, notifyCount, str5);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<LoginInfo> {
        private final TypeAdapter<Integer> adminTypeAdapter;
        private int defaultAdminType = 0;
        private NotifyCount defaultNotifyCount = null;
        private String defaultRefreshToken = null;
        private String defaultToken = null;
        private String defaultUid = null;
        private String defaultUserAvatar = null;
        private String defaultUserName = null;
        private final TypeAdapter<NotifyCount> notifyCountAdapter;
        private final TypeAdapter<String> refreshTokenAdapter;
        private final TypeAdapter<String> tokenAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> userAvatarAdapter;
        private final TypeAdapter<String> userNameAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.uidAdapter = gson.getAdapter(String.class);
            this.userNameAdapter = gson.getAdapter(String.class);
            this.tokenAdapter = gson.getAdapter(String.class);
            this.refreshTokenAdapter = gson.getAdapter(String.class);
            this.adminTypeAdapter = gson.getAdapter(Integer.class);
            this.notifyCountAdapter = gson.getAdapter(NotifyCount.class);
            this.userAvatarAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUserName(String str) {
            this.defaultUserName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultToken(String str) {
            this.defaultToken = str;
            return this;
        }

        public GsonTypeAdapter setDefaultRefreshToken(String str) {
            this.defaultRefreshToken = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAdminType(int i) {
            this.defaultAdminType = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNotifyCount(NotifyCount notifyCount) {
            this.defaultNotifyCount = notifyCount;
            return this;
        }

        public GsonTypeAdapter setDefaultUserAvatar(String str) {
            this.defaultUserAvatar = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, LoginInfo loginInfo) throws IOException {
            if (loginInfo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, loginInfo.getUid());
            jsonWriter.name("username");
            this.userNameAdapter.write(jsonWriter, loginInfo.getUserName());
            jsonWriter.name("token");
            this.tokenAdapter.write(jsonWriter, loginInfo.getToken());
            jsonWriter.name("refreshToken");
            this.refreshTokenAdapter.write(jsonWriter, loginInfo.getRefreshToken());
            jsonWriter.name("adminType");
            this.adminTypeAdapter.write(jsonWriter, Integer.valueOf(loginInfo.getAdminType()));
            jsonWriter.name("notifyCount");
            this.notifyCountAdapter.write(jsonWriter, loginInfo.getNotifyCount());
            jsonWriter.name("userAvatar");
            this.userAvatarAdapter.write(jsonWriter, loginInfo.getUserAvatar());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public LoginInfo read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultUid;
            String str2 = this.defaultUserName;
            String str3 = this.defaultToken;
            String str4 = this.defaultRefreshToken;
            int i = this.defaultAdminType;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            int i2 = i;
            NotifyCount notifyCount = this.defaultNotifyCount;
            String str9 = this.defaultUserAvatar;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1768624314:
                            if (nextName.equals("notifyCount")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -56506402:
                            if (nextName.equals("refreshToken")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 21874473:
                            if (nextName.equals("adminType")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 110541305:
                            if (nextName.equals("token")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            notifyCount = this.notifyCountAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str6 = this.userNameAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str8 = this.refreshTokenAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str5 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i2 = this.adminTypeAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str7 = this.tokenAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str9 = this.userAvatarAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_LoginInfo(str5, str6, str7, str8, i2, notifyCount, str9);
        }
    }
}
