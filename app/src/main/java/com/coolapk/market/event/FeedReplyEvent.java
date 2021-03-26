package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;

public class FeedReplyEvent {
    private final FeedReply reply;

    public FeedReplyEvent(FeedReply feedReply) {
        this.reply = feedReply;
    }

    public FeedReply getFeedReply() {
        return this.reply;
    }

    public Feed handleEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        newBuilder.replyNum(feed.getReplyNum() + 1);
        return newBuilder.build();
    }
}
