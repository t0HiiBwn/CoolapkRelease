package com.coolapk.market.event;

import com.coolapk.market.model.FeedReply;

public class FeedReplyLikeEvent {
    private final String id;
    private final int likeNum;
    private final boolean liked;

    public FeedReplyLikeEvent(String str, int i, boolean z) {
        this.id = str;
        this.liked = z;
        this.likeNum = i;
    }

    public int getLikeNum() {
        return this.likeNum;
    }

    public String getId() {
        return this.id;
    }

    public boolean isLiked() {
        return this.liked;
    }

    public FeedReply handleEvent(FeedReply feedReply) {
        FeedReply.Builder likeNum2 = FeedReply.builder(feedReply).setLikeNum(this.likeNum);
        if (isLiked()) {
            likeNum2.setUserAction(FeedReply.ReplyUserAction.newBuilder(feedReply.getUserAction()).like(1).build());
        } else {
            likeNum2.setUserAction(FeedReply.ReplyUserAction.newBuilder(feedReply.getUserAction()).like(0).build());
        }
        return likeNum2.build();
    }
}
