package com.coolapk.market.model;

import com.coolapk.market.model.FeedReply;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedReply_ReplyUserAction  reason: invalid class name */
abstract class C$$AutoValue_FeedReply_ReplyUserAction extends FeedReply.ReplyUserAction {
    private final int like;

    C$$AutoValue_FeedReply_ReplyUserAction(int i) {
        this.like = i;
    }

    @Override // com.coolapk.market.model.FeedReply.ReplyUserAction
    public int getLike() {
        return this.like;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ReplyUserAction{like=" + this.like + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedReply.ReplyUserAction) || this.like != ((FeedReply.ReplyUserAction) obj).getLike()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.like ^ 1000003;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_FeedReply_ReplyUserAction$Builder */
    /* compiled from: $$AutoValue_FeedReply_ReplyUserAction */
    static final class Builder extends FeedReply.ReplyUserAction.Builder {
        private Integer like;

        Builder() {
        }

        Builder(FeedReply.ReplyUserAction replyUserAction) {
            this.like = Integer.valueOf(replyUserAction.getLike());
        }

        @Override // com.coolapk.market.model.FeedReply.ReplyUserAction.Builder
        public FeedReply.ReplyUserAction.Builder like(int i) {
            this.like = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.ReplyUserAction.Builder
        public FeedReply.ReplyUserAction build() {
            String str = "";
            if (this.like == null) {
                str = str + " like";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedReply_ReplyUserAction(this.like.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
