package com.coolapk.market.model;

import com.coolapk.market.model.UserAction;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_UserAction  reason: invalid class name */
abstract class C$$AutoValue_UserAction extends UserAction {
    private final int buy;
    private final int collect;
    private final int favorite;
    private final int follow;
    private final int followAuthor;
    private final int like;
    private final int rating;
    private final String ratingFeedUrl;
    private final int wish;

    C$$AutoValue_UserAction(int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, int i8) {
        this.follow = i;
        this.rating = i2;
        this.like = i3;
        this.favorite = i4;
        this.collect = i5;
        this.ratingFeedUrl = str;
        this.followAuthor = i6;
        this.wish = i7;
        this.buy = i8;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getFollow() {
        return this.follow;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getRating() {
        return this.rating;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getLike() {
        return this.like;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getFavorite() {
        return this.favorite;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getCollect() {
        return this.collect;
    }

    @Override // com.coolapk.market.model.UserAction
    @SerializedName("rating_feed_url")
    public String getRatingFeedUrl() {
        return this.ratingFeedUrl;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getFollowAuthor() {
        return this.followAuthor;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getWish() {
        return this.wish;
    }

    @Override // com.coolapk.market.model.UserAction
    public int getBuy() {
        return this.buy;
    }

    @Override // java.lang.Object
    public String toString() {
        return "UserAction{follow=" + this.follow + ", rating=" + this.rating + ", like=" + this.like + ", favorite=" + this.favorite + ", collect=" + this.collect + ", ratingFeedUrl=" + this.ratingFeedUrl + ", followAuthor=" + this.followAuthor + ", wish=" + this.wish + ", buy=" + this.buy + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAction)) {
            return false;
        }
        UserAction userAction = (UserAction) obj;
        if (this.follow == userAction.getFollow() && this.rating == userAction.getRating() && this.like == userAction.getLike() && this.favorite == userAction.getFavorite() && this.collect == userAction.getCollect() && ((str = this.ratingFeedUrl) != null ? str.equals(userAction.getRatingFeedUrl()) : userAction.getRatingFeedUrl() == null) && this.followAuthor == userAction.getFollowAuthor() && this.wish == userAction.getWish() && this.buy == userAction.getBuy()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = (((((((((this.follow ^ 1000003) * 1000003) ^ this.rating) * 1000003) ^ this.like) * 1000003) ^ this.favorite) * 1000003) ^ this.collect) * 1000003;
        String str = this.ratingFeedUrl;
        return ((((((i ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.followAuthor) * 1000003) ^ this.wish) * 1000003) ^ this.buy;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_UserAction$Builder */
    /* compiled from: $$AutoValue_UserAction */
    static final class Builder extends UserAction.Builder {
        private Integer buy;
        private Integer collect;
        private Integer favorite;
        private Integer follow;
        private Integer followAuthor;
        private Integer like;
        private Integer rating;
        private String ratingFeedUrl;
        private Integer wish;

        Builder() {
        }

        Builder(UserAction userAction) {
            this.follow = Integer.valueOf(userAction.getFollow());
            this.rating = Integer.valueOf(userAction.getRating());
            this.like = Integer.valueOf(userAction.getLike());
            this.favorite = Integer.valueOf(userAction.getFavorite());
            this.collect = Integer.valueOf(userAction.getCollect());
            this.ratingFeedUrl = userAction.getRatingFeedUrl();
            this.followAuthor = Integer.valueOf(userAction.getFollowAuthor());
            this.wish = Integer.valueOf(userAction.getWish());
            this.buy = Integer.valueOf(userAction.getBuy());
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder follow(int i) {
            this.follow = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder rating(int i) {
            this.rating = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder like(int i) {
            this.like = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder favorite(int i) {
            this.favorite = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder collect(int i) {
            this.collect = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder ratingFeedUrl(String str) {
            this.ratingFeedUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder followAuthor(int i) {
            this.followAuthor = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder wish(int i) {
            this.wish = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction.Builder buy(int i) {
            this.buy = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserAction.Builder
        public UserAction build() {
            String str = "";
            if (this.follow == null) {
                str = str + " follow";
            }
            if (this.rating == null) {
                str = str + " rating";
            }
            if (this.like == null) {
                str = str + " like";
            }
            if (this.favorite == null) {
                str = str + " favorite";
            }
            if (this.collect == null) {
                str = str + " collect";
            }
            if (this.followAuthor == null) {
                str = str + " followAuthor";
            }
            if (this.wish == null) {
                str = str + " wish";
            }
            if (this.buy == null) {
                str = str + " buy";
            }
            if (str.isEmpty()) {
                return new AutoValue_UserAction(this.follow.intValue(), this.rating.intValue(), this.like.intValue(), this.favorite.intValue(), this.collect.intValue(), this.ratingFeedUrl, this.followAuthor.intValue(), this.wish.intValue(), this.buy.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
