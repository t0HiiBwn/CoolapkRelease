package com.coolapk.market.event;

import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.CollectionUtils;
import java.util.List;

public class UserBlockedEvent {
    private int isInBlackList;
    private String uid;

    public UserBlockedEvent(String str, int i) {
        this.isInBlackList = i;
        this.uid = str;
    }

    public UserBlockedEvent(UserProfile userProfile) {
        this.isInBlackList = userProfile.getIsInBlackList();
        this.uid = userProfile.getUid();
    }

    public String getUid() {
        return this.uid;
    }

    public int getIsInBlackList() {
        return this.isInBlackList;
    }

    public Feed removeFromChildList(Feed feed) {
        Feed.Builder builder = null;
        if (feed.getUid().equals(this.uid)) {
            return null;
        }
        List<FeedReply> recentReplyRows = feed.getRecentReplyRows();
        int safeSize = CollectionUtils.safeSize(recentReplyRows);
        List<FeedReply> removeFeedReplyList = removeFeedReplyList(recentReplyRows);
        if (safeSize != CollectionUtils.safeSize(removeFeedReplyList)) {
            builder = Feed.newBuilder(feed);
            builder.recentReplyRows(removeFeedReplyList);
        }
        List<FeedReply> replyMeRows = feed.getReplyMeRows();
        int safeSize2 = CollectionUtils.safeSize(replyMeRows);
        List<FeedReply> removeFeedReplyList2 = removeFeedReplyList(replyMeRows);
        if (safeSize2 != CollectionUtils.safeSize(removeFeedReplyList2)) {
            if (builder == null) {
                builder = Feed.newBuilder(feed);
            }
            builder.replyMeRows(removeFeedReplyList2);
        }
        List<FeedReply> replyRows = feed.getReplyRows();
        int safeSize3 = CollectionUtils.safeSize(replyRows);
        List<FeedReply> removeFeedReplyList3 = removeFeedReplyList(replyRows);
        if (safeSize3 != CollectionUtils.safeSize(removeFeedReplyList3)) {
            if (builder == null) {
                builder = Feed.newBuilder(feed);
            }
            builder.replyRows(removeFeedReplyList3);
        }
        return builder != null ? builder.build() : feed;
    }

    public List<FeedReply> removeFeedReplyList(List<FeedReply> list) {
        if (list == null) {
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            FeedReply feedReply = list.get(i);
            FeedReply removeFeedReply = removeFeedReply(feedReply);
            if (removeFeedReply == null) {
                list.remove(i);
                i--;
            } else if (feedReply != removeFeedReply) {
                list.set(i, removeFeedReply);
            }
            i++;
        }
        return list;
    }

    private List<RelatedData> removeRelateDataList(List<RelatedData> list) {
        if (list == null) {
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).getUid().equals(this.uid)) {
                list.remove(i);
                i--;
            }
            i++;
        }
        return list;
    }

    public FeedReply removeFeedReply(FeedReply feedReply) {
        if (feedReply.getUid().equals(this.uid)) {
            return null;
        }
        List<FeedReply> replyRows = feedReply.getReplyRows();
        int safeSize = CollectionUtils.safeSize(replyRows);
        List<FeedReply> removeFeedReplyList = removeFeedReplyList(replyRows);
        return safeSize != CollectionUtils.safeSize(removeFeedReplyList) ? FeedReply.builder(feedReply).setReplyRows(removeFeedReplyList).build() : feedReply;
    }
}
