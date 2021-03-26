package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_NotifyCount  reason: invalid class name */
abstract class C$AutoValue_NotifyCount extends C$$AutoValue_NotifyCount {
    C$AutoValue_NotifyCount(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2) {
        super(i, i2, i3, i4, i5, i6, i7, i8, i9, j, j2);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_NotifyCount$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<NotifyCount> {
        private final TypeAdapter<Integer> atCommentMeAdapter;
        private final TypeAdapter<Integer> atMeAdapter;
        private final TypeAdapter<Integer> badgeAdapter;
        private final TypeAdapter<Integer> cloudInstallAdapter;
        private final TypeAdapter<Integer> commentMeAdapter;
        private final TypeAdapter<Long> datelineAdapter;
        private int defaultAtCommentMe = 0;
        private int defaultAtMe = 0;
        private int defaultBadge = 0;
        private int defaultCloudInstall = 0;
        private int defaultCommentMe = 0;
        private long defaultDateline = 0;
        private int defaultFeedLike = 0;
        private int defaultFollowMe = 0;
        private long defaultLastSplashUpdate = 0;
        private int defaultMessage = 0;
        private int defaultNotification = 0;
        private final TypeAdapter<Integer> feedLikeAdapter;
        private final TypeAdapter<Integer> followMeAdapter;
        private final TypeAdapter<Long> lastSplashUpdateAdapter;
        private final TypeAdapter<Integer> messageAdapter;
        private final TypeAdapter<Integer> notificationAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.cloudInstallAdapter = gson.getAdapter(Integer.class);
            this.notificationAdapter = gson.getAdapter(Integer.class);
            this.messageAdapter = gson.getAdapter(Integer.class);
            this.atMeAdapter = gson.getAdapter(Integer.class);
            this.atCommentMeAdapter = gson.getAdapter(Integer.class);
            this.commentMeAdapter = gson.getAdapter(Integer.class);
            this.badgeAdapter = gson.getAdapter(Integer.class);
            this.feedLikeAdapter = gson.getAdapter(Integer.class);
            this.followMeAdapter = gson.getAdapter(Integer.class);
            this.lastSplashUpdateAdapter = gson.getAdapter(Long.class);
            this.datelineAdapter = gson.getAdapter(Long.class);
        }

        public GsonTypeAdapter setDefaultCloudInstall(int i) {
            this.defaultCloudInstall = i;
            return this;
        }

        public GsonTypeAdapter setDefaultNotification(int i) {
            this.defaultNotification = i;
            return this;
        }

        public GsonTypeAdapter setDefaultMessage(int i) {
            this.defaultMessage = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAtMe(int i) {
            this.defaultAtMe = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAtCommentMe(int i) {
            this.defaultAtCommentMe = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCommentMe(int i) {
            this.defaultCommentMe = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBadge(int i) {
            this.defaultBadge = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFeedLike(int i) {
            this.defaultFeedLike = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowMe(int i) {
            this.defaultFollowMe = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLastSplashUpdate(long j) {
            this.defaultLastSplashUpdate = j;
            return this;
        }

        public GsonTypeAdapter setDefaultDateline(long j) {
            this.defaultDateline = j;
            return this;
        }

        public void write(JsonWriter jsonWriter, NotifyCount notifyCount) throws IOException {
            if (notifyCount == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("cloudInstall");
            this.cloudInstallAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getCloudInstall()));
            jsonWriter.name("notification");
            this.notificationAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getNotification()));
            jsonWriter.name("message");
            this.messageAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getMessage()));
            jsonWriter.name("atme");
            this.atMeAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getAtMe()));
            jsonWriter.name("atcommentme");
            this.atCommentMeAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getAtCommentMe()));
            jsonWriter.name("commentme");
            this.commentMeAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getCommentMe()));
            jsonWriter.name("badge");
            this.badgeAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getBadge()));
            jsonWriter.name("feedlike");
            this.feedLikeAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getFeedLike()));
            jsonWriter.name("contacts_follow");
            this.followMeAdapter.write(jsonWriter, Integer.valueOf(notifyCount.getFollowMe()));
            jsonWriter.name("lastSplashUpdate");
            this.lastSplashUpdateAdapter.write(jsonWriter, Long.valueOf(notifyCount.getLastSplashUpdate()));
            jsonWriter.name("dateline");
            this.datelineAdapter.write(jsonWriter, Long.valueOf(notifyCount.getDateline()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public NotifyCount read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultCloudInstall;
            int i2 = this.defaultNotification;
            int i3 = this.defaultMessage;
            int i4 = this.defaultAtMe;
            int i5 = this.defaultAtCommentMe;
            int i6 = this.defaultCommentMe;
            int i7 = this.defaultBadge;
            int i8 = this.defaultFeedLike;
            int i9 = this.defaultFollowMe;
            int i10 = i;
            int i11 = i2;
            int i12 = i3;
            int i13 = i4;
            int i14 = i5;
            int i15 = i6;
            int i16 = i7;
            int i17 = i8;
            int i18 = i9;
            long j = this.defaultLastSplashUpdate;
            long j2 = this.defaultDateline;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1495015369:
                            if (nextName.equals("commentme")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1177197283:
                            if (nextName.equals("contacts_follow")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1026368156:
                            if (nextName.equals("atcommentme")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -450270810:
                            if (nextName.equals("cloudInstall")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -191195595:
                            if (nextName.equals("feedlike")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3004683:
                            if (nextName.equals("atme")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 93494179:
                            if (nextName.equals("badge")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 595233003:
                            if (nextName.equals("notification")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 954925063:
                            if (nextName.equals("message")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 1582455750:
                            if (nextName.equals("lastSplashUpdate")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 1793464482:
                            if (nextName.equals("dateline")) {
                                c = '\n';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i15 = this.commentMeAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            i18 = this.followMeAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            i14 = this.atCommentMeAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            i10 = this.cloudInstallAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            i17 = this.feedLikeAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            i13 = this.atMeAdapter.read(jsonReader).intValue();
                            continue;
                        case 6:
                            i16 = this.badgeAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            i11 = this.notificationAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            i12 = this.messageAdapter.read(jsonReader).intValue();
                            continue;
                        case '\t':
                            j = this.lastSplashUpdateAdapter.read(jsonReader).longValue();
                            continue;
                        case '\n':
                            j2 = this.datelineAdapter.read(jsonReader).longValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_NotifyCount(i10, i11, i12, i13, i14, i15, i16, i17, i18, j, j2);
        }
    }
}
