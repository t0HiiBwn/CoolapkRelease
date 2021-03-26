package com.coolapk.market.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.coolapk.market.model.$AutoValue_UserAction  reason: invalid class name */
abstract class C$AutoValue_UserAction extends C$$AutoValue_UserAction {
    C$AutoValue_UserAction(int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, int i8) {
        super(i, i2, i3, i4, i5, str, i6, i7, i8);
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_UserAction$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<UserAction> {
        private final TypeAdapter<Integer> buyAdapter;
        private final TypeAdapter<Integer> collectAdapter;
        private int defaultBuy = 0;
        private int defaultCollect = 0;
        private int defaultFavorite = 0;
        private int defaultFollow = 0;
        private int defaultFollowAuthor = 0;
        private int defaultLike = 0;
        private int defaultRating = 0;
        private String defaultRatingFeedUrl = null;
        private int defaultWish = 0;
        private final TypeAdapter<Integer> favoriteAdapter;
        private final TypeAdapter<Integer> followAdapter;
        private final TypeAdapter<Integer> followAuthorAdapter;
        private final TypeAdapter<Integer> likeAdapter;
        private final TypeAdapter<Integer> ratingAdapter;
        private final TypeAdapter<String> ratingFeedUrlAdapter;
        private final TypeAdapter<Integer> wishAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.followAdapter = gson.getAdapter(Integer.class);
            this.ratingAdapter = gson.getAdapter(Integer.class);
            this.likeAdapter = gson.getAdapter(Integer.class);
            this.favoriteAdapter = gson.getAdapter(Integer.class);
            this.collectAdapter = gson.getAdapter(Integer.class);
            this.ratingFeedUrlAdapter = gson.getAdapter(String.class);
            this.followAuthorAdapter = gson.getAdapter(Integer.class);
            this.wishAdapter = gson.getAdapter(Integer.class);
            this.buyAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultFollow(int i) {
            this.defaultFollow = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRating(int i) {
            this.defaultRating = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLike(int i) {
            this.defaultLike = i;
            return this;
        }

        public GsonTypeAdapter setDefaultFavorite(int i) {
            this.defaultFavorite = i;
            return this;
        }

        public GsonTypeAdapter setDefaultCollect(int i) {
            this.defaultCollect = i;
            return this;
        }

        public GsonTypeAdapter setDefaultRatingFeedUrl(String str) {
            this.defaultRatingFeedUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFollowAuthor(int i) {
            this.defaultFollowAuthor = i;
            return this;
        }

        public GsonTypeAdapter setDefaultWish(int i) {
            this.defaultWish = i;
            return this;
        }

        public GsonTypeAdapter setDefaultBuy(int i) {
            this.defaultBuy = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, UserAction userAction) throws IOException {
            if (userAction == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("follow");
            this.followAdapter.write(jsonWriter, Integer.valueOf(userAction.getFollow()));
            jsonWriter.name("rating");
            this.ratingAdapter.write(jsonWriter, Integer.valueOf(userAction.getRating()));
            jsonWriter.name("like");
            this.likeAdapter.write(jsonWriter, Integer.valueOf(userAction.getLike()));
            jsonWriter.name("favorite");
            this.favoriteAdapter.write(jsonWriter, Integer.valueOf(userAction.getFavorite()));
            jsonWriter.name("collect");
            this.collectAdapter.write(jsonWriter, Integer.valueOf(userAction.getCollect()));
            jsonWriter.name("rating_feed_url");
            this.ratingFeedUrlAdapter.write(jsonWriter, userAction.getRatingFeedUrl());
            jsonWriter.name("followAuthor");
            this.followAuthorAdapter.write(jsonWriter, Integer.valueOf(userAction.getFollowAuthor()));
            jsonWriter.name("wish");
            this.wishAdapter.write(jsonWriter, Integer.valueOf(userAction.getWish()));
            jsonWriter.name("buy");
            this.buyAdapter.write(jsonWriter, Integer.valueOf(userAction.getBuy()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UserAction read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultFollow;
            int i2 = this.defaultRating;
            int i3 = this.defaultLike;
            int i4 = this.defaultFavorite;
            int i5 = this.defaultCollect;
            String str = this.defaultRatingFeedUrl;
            int i6 = this.defaultFollowAuthor;
            int i7 = i;
            int i8 = i2;
            int i9 = i3;
            int i10 = i4;
            int i11 = i5;
            String str2 = str;
            int i12 = i6;
            int i13 = this.defaultWish;
            int i14 = this.defaultBuy;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1268958287:
                            if (nextName.equals("follow")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -938102371:
                            if (nextName.equals("rating")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 97926:
                            if (nextName.equals("buy")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3321751:
                            if (nextName.equals("like")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3649703:
                            if (nextName.equals("wish")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 298179504:
                            if (nextName.equals("rating_feed_url")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 949444906:
                            if (nextName.equals("collect")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1050790300:
                            if (nextName.equals("favorite")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1392902300:
                            if (nextName.equals("followAuthor")) {
                                c = '\b';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i7 = this.followAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            i8 = this.ratingAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            i14 = this.buyAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            i9 = this.likeAdapter.read(jsonReader).intValue();
                            continue;
                        case 4:
                            i13 = this.wishAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            str2 = this.ratingFeedUrlAdapter.read(jsonReader);
                            continue;
                        case 6:
                            i11 = this.collectAdapter.read(jsonReader).intValue();
                            continue;
                        case 7:
                            i10 = this.favoriteAdapter.read(jsonReader).intValue();
                            continue;
                        case '\b':
                            i12 = this.followAuthorAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UserAction(i7, i8, i9, i10, i11, str2, i12, i13, i14);
        }
    }
}
