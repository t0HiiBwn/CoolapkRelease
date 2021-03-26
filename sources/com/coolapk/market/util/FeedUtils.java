package com.coolapk.market.util;

import android.text.TextUtils;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import java.util.ArrayList;
import java.util.List;

public class FeedUtils {
    public static final int DATA_COUNT_PER_PAGE = 20;
    public static final String FEED_TYPE_ALBUM = "album";
    public static final String FEED_TYPE_ANSWER = "answer";
    public static final String FEED_TYPE_COMMENT = "comment";
    public static final String FEED_TYPE_DISCOVERY = "discovery";
    public static final String FEED_TYPE_FEED = "feed";
    public static final String FEED_TYPE_FEED_ARTICLE = "feedArticle";
    public static final String FEED_TYPE_GOODS = "goods";
    public static final String FEED_TYPE_GOODS_LIST = "goodsList";
    public static final String FEED_TYPE_PICTURE = "picture";
    public static final String FEED_TYPE_QUESTION = "question";
    public static final String FEED_TYPE_RATING = "rating";
    public static final String FEED_TYPE_SECOND_HAND = "ershou";
    public static final String FEED_TYPE_URL = "url";
    public static final String FEED_TYPE_VOTE = "vote";
    public static final String FEED_TYPE_VOTE_COMMENT = "voteComment";
    public static final int LENGTH_FOR_ANSWER_QUESTION = 75;
    public static final int LENGTH_FOR_BIG_COVER = 60;
    public static final int LENGTH_FOR_FEED = 90;
    public static final int LENGTH_FOR_HOT_REPLY = 60;
    public static final int LENGTH_FOR_NINE_PIC = 60;
    public static final int LENGTH_FOR_NO_COVER = 120;
    public static final int LENGTH_FOR_RIGHT_PIC = 35;
    public static final int LENGTH_FOR_VOTE_DESCRIPTION = 75;

    public static boolean isAlbumType(String str) {
        return TextUtils.equals(str, "album");
    }

    public static boolean isPictureType(String str) {
        return TextUtils.equals(str, "picture");
    }

    public static boolean isCommentType(String str) {
        return TextUtils.equals(str, "comment");
    }

    public static boolean isGoodsListType(String str) {
        return TextUtils.equals(str, "goodsList");
    }

    public static boolean isGoodsType(String str) {
        return TextUtils.equals(str, "goods");
    }

    public static boolean isURLType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(str, "url");
    }

    public static boolean canShowTinfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isAlbumType(str);
    }

    public static boolean isFeedType(String str) {
        return TextUtils.equals(str, "feed");
    }

    public static boolean isDiscoveryType(String str) {
        return TextUtils.equals(str, "discovery");
    }

    public static boolean showShowExtraLayout(Feed feed) {
        if (feed == null) {
            return false;
        }
        return !TextUtils.isEmpty(feed.getExtraTitle());
    }

    public static String getLikeListToString(Feed feed) {
        StringBuilder sb = new StringBuilder();
        List<String> recentLikeList = feed.getRecentLikeList();
        if (recentLikeList == null || recentLikeList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < recentLikeList.size() - 1; i++) {
            sb.append(recentLikeList.get(i));
            sb.append(", ");
        }
        sb.append(recentLikeList.get(recentLikeList.size() - 1));
        return sb.toString();
    }

    public static List<String> getMiddleSizePicList(Feed feed) {
        ArrayList arrayList = new ArrayList();
        if (!(feed == null || feed.getPicArray() == null)) {
            for (String str : feed.getPicArray()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str + ".m.jpg");
                }
            }
        }
        return arrayList;
    }

    public static List<String> getSourcePicList(Feed feed) {
        ArrayList arrayList = new ArrayList();
        if (!(feed == null || feed.getPicArray() == null)) {
            for (String str : feed.getPicArray()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static List<String> getSquarePicList(Feed feed) {
        ArrayList arrayList = new ArrayList();
        if (!(feed == null || feed.getPicArray() == null)) {
            for (String str : feed.getPicArray()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str + ".xs.jpg");
                }
            }
        }
        return arrayList;
    }

    public static Feed findFeedById(List<? extends Entity> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity) list.get(i);
            if (entity instanceof Feed) {
                Feed feed = (Feed) entity;
                if (feed.getId().equals(str)) {
                    return feed;
                }
            }
        }
        return null;
    }

    public static int findFeedIndexById(List<? extends Entity> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity) list.get(i);
            if ((entity instanceof Feed) && ((Feed) entity).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static int findFeedReplyIndexById(List<? extends Entity> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity) list.get(i);
            if ((entity instanceof FeedReply) && ((FeedReply) entity).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static int findAlbumIndexById(List<? extends Entity> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity) list.get(i);
            if ((entity instanceof Album) && ((Album) entity).getAlbumId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
