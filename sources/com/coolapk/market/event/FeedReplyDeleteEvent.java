package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import java.util.ArrayList;

public class FeedReplyDeleteEvent {
    private final FeedReply reply;

    public FeedReplyDeleteEvent(FeedReply feedReply) {
        this.reply = feedReply;
    }

    public FeedReply getFeedReply() {
        return this.reply;
    }

    public Feed handleEvent(Feed feed) {
        Feed.Builder newBuilder = Feed.newBuilder(feed);
        newBuilder.replyNum(feed.getReplyNum() - 1);
        ArrayList arrayList = new ArrayList();
        if (feed.getReplyRows() != null) {
            arrayList.addAll(feed.getReplyRows());
        }
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                break;
            } else if (arrayList.get(i).getId().equals(this.reply.getId())) {
                arrayList.remove(i);
                break;
            } else {
                i++;
            }
        }
        newBuilder.replyRows(arrayList);
        return newBuilder.build();
    }
}
