package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_RelatedData  reason: invalid class name */
abstract class C$AutoValue_RelatedData extends C$$AutoValue_RelatedData {
    C$AutoValue_RelatedData(String str, UserInfo userInfo, String str2, String str3, String str4, String str5, int i) {
        super(str, userInfo, str2, str3, str4, str5, i);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_RelatedData$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<RelatedData> {
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDisplayUserName = null;
        private String defaultId = null;
        private String defaultUid = null;
        private UserInfo defaultUserInfo = null;
        private int defaultValue = 0;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;
        private final TypeAdapter<Integer> valueAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.valueAdapter = gson.getAdapter(Integer.class);
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

        public GsonTypeAdapter setDefaultId(String str) {
            this.defaultId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUid(String str) {
            this.defaultUid = str;
            return this;
        }

        public GsonTypeAdapter setDefaultValue(int i) {
            this.defaultValue = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, RelatedData relatedData) throws IOException {
            if (relatedData == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, relatedData.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, relatedData.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, relatedData.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, relatedData.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, relatedData.getId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, relatedData.getUid());
            jsonWriter.name("value");
            this.valueAdapter.write(jsonWriter, Integer.valueOf(relatedData.getValue()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public RelatedData read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultDeprecatedUserAvatar;
            UserInfo userInfo = this.defaultUserInfo;
            String str2 = this.defaultDeprecatedUserName;
            String str3 = this.defaultDisplayUserName;
            String str4 = this.defaultId;
            String str5 = str;
            UserInfo userInfo2 = userInfo;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            String str9 = this.defaultUid;
            int i = this.defaultValue;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1460853832:
                            if (nextName.equals("displayUsername")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -266803431:
                            if (nextName.equals("userInfo")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -265713450:
                            if (nextName.equals("username")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 111972721:
                            if (nextName.equals("value")) {
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
                            str7 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 1:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str6 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str8 = this.idAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str9 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 5:
                            i = this.valueAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            str5 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_RelatedData(str5, userInfo2, str6, str7, str8, str9, i);
        }
    }
}
