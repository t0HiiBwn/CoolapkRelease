package com.coolapk.market.model;

import com.coolapk.market.model.FeedReply;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedReply_ReplyFeed  reason: invalid class name */
abstract class C$AutoValue_FeedReply_ReplyFeed extends C$$AutoValue_FeedReply_ReplyFeed {
    C$AutoValue_FeedReply_ReplyFeed(String str, UserInfo userInfo, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, userInfo, str2, str3, str4, str5, str6, str7, str8);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedReply_ReplyFeed$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<FeedReply.ReplyFeed> {
        private String defaultDeprecatedUserAvatar = null;
        private String defaultDeprecatedUserName = null;
        private String defaultDisplayUserName = null;
        private String defaultId = null;
        private String defaultMessage = null;
        private String defaultPic = null;
        private String defaultUid = null;
        private String defaultUrl = null;
        private UserInfo defaultUserInfo = null;
        private final TypeAdapter<String> deprecatedUserAvatarAdapter;
        private final TypeAdapter<String> deprecatedUserNameAdapter;
        private final TypeAdapter<String> displayUserNameAdapter;
        private final TypeAdapter<String> idAdapter;
        private final TypeAdapter<String> messageAdapter;
        private final TypeAdapter<String> picAdapter;
        private final TypeAdapter<String> uidAdapter;
        private final TypeAdapter<String> urlAdapter;
        private final TypeAdapter<UserInfo> userInfoAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.deprecatedUserAvatarAdapter = gson.getAdapter(String.class);
            this.userInfoAdapter = gson.getAdapter(UserInfo.class);
            this.deprecatedUserNameAdapter = gson.getAdapter(String.class);
            this.displayUserNameAdapter = gson.getAdapter(String.class);
            this.idAdapter = gson.getAdapter(String.class);
            this.uidAdapter = gson.getAdapter(String.class);
            this.messageAdapter = gson.getAdapter(String.class);
            this.picAdapter = gson.getAdapter(String.class);
            this.urlAdapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultMessage(String str) {
            this.defaultMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultPic(String str) {
            this.defaultPic = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, FeedReply.ReplyFeed replyFeed) throws IOException {
            if (replyFeed == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("userAvatar");
            this.deprecatedUserAvatarAdapter.write(jsonWriter, replyFeed.getDeprecatedUserAvatar());
            jsonWriter.name("userInfo");
            this.userInfoAdapter.write(jsonWriter, replyFeed.getUserInfo());
            jsonWriter.name("username");
            this.deprecatedUserNameAdapter.write(jsonWriter, replyFeed.getDeprecatedUserName());
            jsonWriter.name("displayUsername");
            this.displayUserNameAdapter.write(jsonWriter, replyFeed.getDisplayUserName());
            jsonWriter.name("id");
            this.idAdapter.write(jsonWriter, replyFeed.getId());
            jsonWriter.name("uid");
            this.uidAdapter.write(jsonWriter, replyFeed.getUid());
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, replyFeed.getMessage());
            jsonWriter.name("pic");
            this.picAdapter.write(jsonWriter, replyFeed.getPic());
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, replyFeed.getUrl());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public FeedReply.ReplyFeed read(JsonReader jsonReader) throws IOException {
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
            String str5 = this.defaultUid;
            String str6 = this.defaultMessage;
            String str7 = str;
            UserInfo userInfo2 = userInfo;
            String str8 = str2;
            String str9 = str3;
            String str10 = str4;
            String str11 = str5;
            String str12 = str6;
            String str13 = this.defaultPic;
            String str14 = this.defaultUrl;
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
                        case 110986:
                            if (nextName.equals("pic")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 115792:
                            if (nextName.equals("uid")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1078154500:
                            if (nextName.equals("userAvatar")) {
                                c = '\b';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str9 = this.displayUserNameAdapter.read(jsonReader);
                            continue;
                        case 1:
                            userInfo2 = this.userInfoAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str8 = this.deprecatedUserNameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str10 = this.idAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str13 = this.picAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str11 = this.uidAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str14 = this.urlAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str12 = this.messageAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str7 = this.deprecatedUserAvatarAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_FeedReply_ReplyFeed(str7, userInfo2, str8, str9, str10, str11, str12, str13, str14);
        }
    }
}
