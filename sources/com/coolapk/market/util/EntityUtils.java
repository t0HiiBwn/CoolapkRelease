package com.coolapk.market.util;

import android.text.TextUtils;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserHistory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class EntityUtils {
    public static final String ENTITY_TEMPLATE_APK_EXPANDED_CARD = "apkExpandCard";
    public static final String ENTITY_TYPE_AD = "ad";
    public static final String ENTITY_TYPE_ADS = "ads";
    public static final String ENTITY_TYPE_ALBUM = "album";
    public static final String ENTITY_TYPE_ALBUM_CARD = "albumCard";
    public static final String ENTITY_TYPE_ALBUM_COLORED_CARD = "albumColoredCard";
    public static final String ENTITY_TYPE_ALBUM_EXPAND_CARD = "albumExpandCard";
    public static final String ENTITY_TYPE_ALBUM_EXPAND_CARD_TOP_COVER = "albumExpandCardTopCover";
    public static final String ENTITY_TYPE_ALBUM_ITEM = "albumItem";
    public static final String ENTITY_TYPE_ALBUM_SCROLL_CARD = "albumScrollCard";
    public static final String ENTITY_TYPE_APK = "apk";
    public static final String ENTITY_TYPE_APK_ALBUM_CARD_1 = "apkAlbumCard_1";
    public static final String ENTITY_TYPE_APK_ALBUM_CARD_2 = "apkAlbumCard_2";
    public static final String ENTITY_TYPE_APK_EXPAND_LIST_CARD = "apkExpandListCard";
    public static final String ENTITY_TYPE_APK_LIST_CARD = "apkListCard";
    public static final String ENTITY_TYPE_APK_SCROLL_CARD = "apkScrollCard";
    public static final String ENTITY_TYPE_APK_SCROLL_CARD_WITH_BACKGROUND_CARD = "apkScrollCardWithBackground";
    public static final String ENTITY_TYPE_APP_CATEGORY = "category";
    public static final String ENTITY_TYPE_APP_FORUM = "appForum";
    public static final String ENTITY_TYPE_APP_PI = "appPi";
    public static final String ENTITY_TYPE_ARTICLE_LIST_CARD = "articleListCard";
    public static final String ENTITY_TYPE_BACKUPINFO = "back";
    public static final String ENTITY_TYPE_CAPSULE_LIST_CARD = "capsuleListCard";
    public static final String ENTITY_TYPE_CARD = "card";
    public static final String ENTITY_TYPE_CARD_ITEM = "cardItem";
    public static final String ENTITY_TYPE_COLLECTIOIN_ITEM = "collectionitem";
    public static final String ENTITY_TYPE_COLLECTION = "collection";
    public static final String ENTITY_TYPE_COLORFUL_FAT_SCROLL_CARD = "colorfulFatScrollCard";
    public static final String ENTITY_TYPE_COLORFUL_SCROLL_CARD = "colorfulScrollCard";
    public static final String ENTITY_TYPE_COMMENT = "comment";
    public static final String ENTITY_TYPE_CONFIG_CARD = "configCard";
    public static final String ENTITY_TYPE_CONTACTS = "contacts";
    public static final String ENTITY_TYPE_DEVICEPARAMS = "deviceParams";
    public static final String ENTITY_TYPE_DIALOG_CARD = "dialogCard";
    public static final String ENTITY_TYPE_DISCOVERY = "discovery";
    public static final String ENTITY_TYPE_DOC_LIST_CARD = "docListCard";
    public static final String ENTITY_TYPE_DYH = "dyh";
    public static final String ENTITY_TYPE_DYH_ARTICLE = "article";
    public static final String ENTITY_TYPE_DYH_ARTICLE_CARD = "dyhArticle";
    public static final String ENTITY_TYPE_DYH_ARTICLE_FEED = "articleFeed";
    public static final String ENTITY_TYPE_DYH_ARTICLE_ITEM = "articleItem";
    public static final String ENTITY_TYPE_DYH_ARTICLE_NEWS = "articleNews";
    public static final String ENTITY_TYPE_DYH_LOGO = "dyhLogo";
    public static final String ENTITY_TYPE_DYH_UNREAD = "dyhUnRead";
    public static final String ENTITY_TYPE_FAB_CARD = "fabCard";
    public static final String ENTITY_TYPE_FAVORITE = "favorite";
    public static final String ENTITY_TYPE_FEED = "feed";
    public static final String ENTITY_TYPE_FEED_ARTICLE_NEWS = "articleNews";
    public static final String ENTITY_TYPE_FEED_BY_DYH_HEADER = "feedByDyhHeader";
    public static final String ENTITY_TYPE_FEED_COOL_PIC_GRID_CARD = "feedCoolPictureGridCard";
    public static final String ENTITY_TYPE_FEED_COVER = "feedCover";
    public static final String ENTITY_TYPE_FEED_GOODS = "goods";
    public static final String ENTITY_TYPE_FEED_GROUP_LIST_CARD = "feedGroupListCard";
    public static final String ENTITY_TYPE_FEED_LIST_CARD = "feedListCard";
    public static final String ENTITY_TYPE_FEED_MINI = "feedMini";
    public static final String ENTITY_TYPE_FEED_MINI_COVER = "feedMiniCover";
    public static final String ENTITY_TYPE_FEED_QUESTION = "feedQuestion";
    public static final String ENTITY_TYPE_FEED_RELATION = "feedRelation";
    public static final String ENTITY_TYPE_FEED_REPLY = "feed_reply";
    public static final String ENTITY_TYPE_FEED_REPLY_CARD = "feedReplyCard";
    public static final String ENTITY_TYPE_FEED_SCROLL_CARD = "feedScrollCard";
    public static final String ENTITY_TYPE_FEED_SECONDHAND = "feedErshou";
    public static final String ENTITY_TYPE_FEED_SECONDHAND_MAIN = "mainErshouType";
    public static final String ENTITY_TYPE_FEED_SECONDHAND_SEARCH = "feedErshouSearch";
    public static final String ENTITY_TYPE_FEED_STACK_CARD = "feedStackCard";
    public static final String ENTITY_TYPE_FEED_TARGET = "feedTarget";
    public static final String ENTITY_TYPE_FEED_THREE_PIC_GRID_CARD = "feedThreePicGridCard";
    public static final String ENTITY_TYPE_FORWARD_FEED = "forwardFeed";
    public static final String ENTITY_TYPE_GIFT = "gift";
    public static final String ENTITY_TYPE_GOODS_LIST = "goodsList";
    public static final String ENTITY_TYPE_GOODS_LIST_ITEM = "goodsListItem";
    public static final String ENTITY_TYPE_GOODS_LIST_SIMPLE = "simpleGoodsList";
    public static final String ENTITY_TYPE_GRID_CARD = "gridCard";
    public static final String ENTITY_TYPE_HEADLINE = "headline";
    public static final String ENTITY_TYPE_HEAD_CARD = "headCard";
    public static final String ENTITY_TYPE_HOT_SEARCH_LIST = "hotSearch";
    public static final String ENTITY_TYPE_ICON_BUTTON_GRID_CARD = "iconButtonGridCard";
    public static final String ENTITY_TYPE_ICON_GRID_CARD = "iconGridCard";
    public static final String ENTITY_TYPE_ICON_GRID_HORIZON_CARD = "iconGridHorizonCard";
    public static final String ENTITY_TYPE_ICON_LARGE_SCROLL_CARD = "iconLargeScrollCard";
    public static final String ENTITY_TYPE_ICON_LINK_GRID_CARD = "iconLinkGridCard";
    public static final String ENTITY_TYPE_ICON_LIST_CARD = "iconListCard";
    public static final String ENTITY_TYPE_ICON_LONG_TITLE_GRID_CARD = "iconLongTitleGridCard";
    public static final String ENTITY_TYPE_ICON_MINI_GRID_CARD = "iconMiniGridCard";
    public static final String ENTITY_TYPE_ICON_MINI_LINK_GRID_CARD = "iconMiniLinkGridCard";
    public static final String ENTITY_TYPE_ICON_SCROLL_CARD = "iconScrollCard";
    public static final String ENTITY_TYPE_ICON_TAB_LINK_GRID_CARD = "iconTabLinkGridCard";
    public static final String ENTITY_TYPE_ICON_THREE_MORE_CARD = "iconThreeMoreCard";
    public static final String ENTITY_TYPE_IMAGE_APP_BIG_CARD = "apkBigImageCard";
    public static final String ENTITY_TYPE_IMAGE_APP_CARD = "apkImageCard";
    public static final String ENTITY_TYPE_IMAGE_CARD = "imageCard";
    public static final String ENTITY_TYPE_IMAGE_CAROUSEL_CARD = "imageCarouselCard";
    public static final String ENTITY_TYPE_IMAGE_CAROUSEL_CARD_1 = "imageCarouselCard_1";
    public static final String ENTITY_TYPE_IMAGE_CAROUSEL_CARD_2 = "imageCarouselCard_2";
    public static final String ENTITY_TYPE_IMAGE_ICON = "imageIcon";
    public static final String ENTITY_TYPE_IMAGE_LIST_CARD = "imageListCard";
    public static final String ENTITY_TYPE_IMAGE_SCALE_CARD = "imageScaleCard";
    public static final String ENTITY_TYPE_IMAGE_SCROLL_CARD = "imageScrollCard";
    public static final String ENTITY_TYPE_IMAGE_SQUARE_SCROLL_CARD = "imageSquareScrollCard";
    public static final String ENTITY_TYPE_IMAGE_TEXT_CARD = "imageTextCard";
    public static final String ENTITY_TYPE_IMAGE_TEXT_GRID_CARD = "imageTextGridCard";
    public static final String ENTITY_TYPE_IMAGE_TEXT_SCROLL_CARD = "imageTextScrollCard";
    public static final String ENTITY_TYPE_ITEM_GROUP_LIST_CARD = "itemGroupListCard";
    public static final String ENTITY_TYPE_ITEM_PLACE_HOLDER = "itemPlaceHolder";
    public static final String ENTITY_TYPE_LINK = "link";
    public static final String ENTITY_TYPE_LINK_CARD = "linkCard";
    public static final String ENTITY_TYPE_LIST_CARD = "listCard";
    public static final String ENTITY_TYPE_LIVE_IMAGE_TEXT_CARD = "liveImageTextCard";
    public static final String ENTITY_TYPE_LIVE_LIST_CARD = "liveListCard";
    public static final String ENTITY_TYPE_LIVE_MESSAGE = "liveMessage";
    public static final String ENTITY_TYPE_LIVE_SYSTEM_MESSAGE = "liveSystemMessage";
    public static final String ENTITY_TYPE_LIVE_TOPIC = "liveTopic";
    public static final String ENTITY_TYPE_LIVE_USER_DISALLOW = "liveUserDisallow";
    public static final String ENTITY_TYPE_MENU_ITEM = "menuItem";
    public static final String ENTITY_TYPE_MESSAGE = "message";
    public static final String ENTITY_TYPE_MESSAGE_CARD = "messageCard";
    public static final String ENTITY_TYPE_MESSAGE_EXTRA = "messageExtra";
    public static final String ENTITY_TYPE_MESSAGE_LIST_ITEM = "messageListItem";
    public static final String ENTITY_TYPE_MESSAGE_UNREAD = "messageUnRead";
    public static final String ENTITY_TYPE_NODE_RATING = "nodeRating";
    public static final String ENTITY_TYPE_NOTIFICATION = "notification";
    public static final String ENTITY_TYPE_PAGE = "page";
    public static final String ENTITY_TYPE_PEAR_GOODS = "pear_goods";
    public static final String ENTITY_TYPE_PEAR_GOODS_2 = "pearGoods";
    public static final String ENTITY_TYPE_PIC_CATEGORY = "picCategory";
    public static final String ENTITY_TYPE_PRODUCT = "product";
    public static final String ENTITY_TYPE_PRODUCT_BRAND = "productBrand";
    public static final String ENTITY_TYPE_PRODUCT_MEDIA = "productMedia";
    public static final String ENTITY_TYPE_PRODUCT_SERIES = "productSeries";
    public static final String ENTITY_TYPE_PRODUCT_TIMELINE_LIST_CARD = "productTimelineListCard";
    public static final String ENTITY_TYPE_QUICK_LINK = "quickLink";
    public static final String ENTITY_TYPE_QUICK_LINK_CARD = "quickLinkCard";
    public static final String ENTITY_TYPE_RANK_AWARD_CARD = "rankAwardCard";
    public static final String ENTITY_TYPE_RATING_CARD = "ratingCard";
    public static final String ENTITY_TYPE_READ_MORE_SCROLL_CARD = "readMoreScrollCard";
    public static final String ENTITY_TYPE_RECENT_HISTORY = "recentHistory";
    public static final String ENTITY_TYPE_REFRESH_CARD = "refreshCard";
    public static final String ENTITY_TYPE_SEARCH_HOT_LIST_CARD = "searchHotListCard";
    public static final String ENTITY_TYPE_SEARCH_WORD_CARD = "searchWord";
    public static final String ENTITY_TYPE_SECONDHAND_PRODUCT = "ershouProduct";
    public static final String ENTITY_TYPE_SELECTOR_LINK_CARD = "selectorLinkCard";
    public static final String ENTITY_TYPE_SHARE_APP = "shareApp";
    public static final String ENTITY_TYPE_SHARE_URL = "shareUrl";
    public static final String ENTITY_TYPE_SINGLE_RATING_CARD = "singleRatingCard";
    public static final String ENTITY_TYPE_SMALL_FEED_RATING = "smallFeedRating";
    public static final String ENTITY_TYPE_SORT_SELECT_CARD = "sortSelectCard";
    public static final String ENTITY_TYPE_SPONSOR_ARTICLE_NEWS = "sponsorArticleNews";
    public static final String ENTITY_TYPE_SPONSOR_CARD = "sponsorCard";
    public static final String ENTITY_TYPE_SPONSOR_FEED = "sponsorFeed";
    public static final String ENTITY_TYPE_SUB_TAB_LINK_CARD = "subTabLinkCard";
    public static final String ENTITY_TYPE_TAB_GROUP_CARD = "tabGroupCard";
    public static final String ENTITY_TYPE_TEXT_CARD = "textCard";
    public static final String ENTITY_TYPE_TEXT_CAROUSEL_CARD = "textCarouselCard";
    public static final String ENTITY_TYPE_TEXT_LINK_CARD = "textLinkCard";
    public static final String ENTITY_TYPE_TEXT_LINK_LIST_CARD = "textLinkListCard";
    public static final String ENTITY_TYPE_TEXT_TITLE_SCROLL_CARD = "textTitleScrollCard";
    public static final String ENTITY_TYPE_TITLE_CARD = "titleCard";
    public static final String ENTITY_TYPE_TOPIC = "topic";
    public static final String ENTITY_TYPE_TOP_CARD = "topCard";
    public static final String ENTITY_TYPE_TOP_CONTENT = "topContent";
    public static final String ENTITY_TYPE_TOP_GROUP_CARD = "topGroupCard";
    public static final String ENTITY_TYPE_UNLOGIN_CARD = "unLoginCard";
    public static final String ENTITY_TYPE_USER = "user";
    public static final String ENTITY_TYPE_USER_HISTORY = "history";
    public static final String ENTITY_TYPE_USET_REPORT_SPAM = "reportSpamUser";
    public static final String ENTITY_TYPE_VIDEO = "video";
    public static final String ENTITY_TYPE_VIDEO_CARD = "videoCard";
    public static final String ENTITY_TYPE_WEB_VIEW_CARD = "webViewCard";

    public interface OnDeleteListener {
        void onDelete(int i);
    }

    public interface OnMatchEntity<T extends Card<? extends Entity>> {
        boolean onMatch(T t, int i, Entity entity, int i2);
    }

    public static boolean isCardType(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith("Card");
    }

    public static boolean isEndsWithCard(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith("card");
    }

    public static boolean isApkType(String str) {
        return TextUtils.equals(str, "apk");
    }

    public static boolean isHistoryType(String str) {
        return TextUtils.equals(str, "history");
    }

    public static boolean isShareUrlType(String str) {
        return TextUtils.equals(str, "shareUrl");
    }

    public static boolean isShareAppType(String str) {
        return TextUtils.equals(str, "shareApp");
    }

    public static boolean isLinkType(String str) {
        return TextUtils.equals(str, "link");
    }

    public static boolean isLinkCardType(String str) {
        return TextUtils.equals(str, "linkCard");
    }

    public static boolean isCategoryType(String str) {
        return TextUtils.equals(str, "category");
    }

    public static boolean isGridCardType(String str) {
        return TextUtils.equals(str, "gridCard");
    }

    public static boolean isListCardType(String str) {
        return TextUtils.equals(str, "listCard");
    }

    public static boolean isDocListCardType(String str) {
        return TextUtils.equals(str, "docListCard");
    }

    public static boolean isImageListCardType(String str) {
        return TextUtils.equals(str, "imageListCard");
    }

    public static boolean isTextImageCardType(String str) {
        return TextUtils.equals(str, "imageTextCard");
    }

    public static boolean isAdsCardType(String str) {
        return TextUtils.equals(str, "ads");
    }

    public static boolean isUserReportSpamType(String str) {
        return TextUtils.equals(str, "reportSpamUser");
    }

    public static boolean isMessageCardType(String str) {
        return TextUtils.equals(str, "messageCard");
    }

    public static boolean isTopGroupCardType(String str) {
        return TextUtils.equals(str, "topGroupCard");
    }

    public static boolean isTabGroupCardType(String str) {
        return TextUtils.equals(str, "tabGroupCard");
    }

    public static boolean isFeedreply(String str) {
        return TextUtils.equals(str, "feed_reply");
    }

    public static boolean isAlbumType(String str) {
        return TextUtils.equals(str, "album");
    }

    public static boolean isAlbumItemType(String str) {
        return TextUtils.equals(str, "albumItem");
    }

    public static boolean isFeedType(String str) {
        return TextUtils.equals(str, "feed") || TextUtils.equals(str, "discovery");
    }

    public static boolean isFeedByDyhHeaderType(String str) {
        return TextUtils.equals(str, "feedByDyhHeader");
    }

    public static boolean isFeedArticleNewsType(String str) {
        return TextUtils.equals(str, "articleNews");
    }

    public static boolean isCoolPicture(String str) {
        return TextUtils.equals(str, "picture");
    }

    public static boolean isContactType(String str) {
        return TextUtils.equals(str, "contacts");
    }

    public static boolean isAlbumCardType(String str) {
        return TextUtils.equals(str, "albumCard");
    }

    public static boolean isTopicType(String str) {
        return TextUtils.equals(str, "topic");
    }

    public static boolean isUserType(String str) {
        return TextUtils.equals(str, "user");
    }

    public static boolean isGiftType(String str) {
        return TextUtils.equals(str, "gift");
    }

    public static boolean isDyhArticleFeedType(String str) {
        return TextUtils.equals(str, "articleFeed");
    }

    public static boolean isDyhUnreadType(String str) {
        return TextUtils.equals(str, "dyhUnRead");
    }

    public static boolean isDyhArticleNewsType(String str) {
        return TextUtils.equals(str, "articleNews");
    }

    public static boolean isDyhType(String str) {
        return TextUtils.equals(str, "dyh");
    }

    public static boolean isDyhArticleType(String str) {
        return TextUtils.equals(str, "article");
    }

    public static boolean isDyhArticleItemType(String str) {
        return TextUtils.equals(str, "articleItem");
    }

    public static ServiceApp findFirstApkType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isApkType(entity.getEntityType())) {
                return (ServiceApp) entity;
            }
        }
        return null;
    }

    public static ServiceApp findLastApkType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isApkType(entity.getEntityType())) {
                return (ServiceApp) entity;
            }
        }
        return null;
    }

    public static Album findFirstAlbumType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isAlbumType(entity.getEntityType())) {
                return (Album) entity;
            }
        }
        return null;
    }

    public static AlbumItem findFirstAlbumItemType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isAlbumItemType(entity.getEntityType())) {
                return (AlbumItem) entity;
            }
        }
        return null;
    }

    public static DyhModel findFirstDyhModelType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isDyhType(entity.getEntityType())) {
                return (DyhModel) entity;
            }
        }
        return null;
    }

    public static DyhModel findLastDyhModeType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isDyhType(entity.getEntityType())) {
                return (DyhModel) entity;
            }
        }
        return null;
    }

    public static FeedReply findFirstFeedReplyType(List<FeedReply> list) {
        for (FeedReply feedReply : list) {
            if (isFeedreply(feedReply.getEntityType())) {
                return feedReply;
            }
        }
        return null;
    }

    public static Album findLastAlbumType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isAlbumType(entity.getEntityType())) {
                return (Album) entity;
            }
        }
        return null;
    }

    public static AlbumItem findLastAlbumItemType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isAlbumItemType(entity.getEntityType())) {
                return (AlbumItem) entity;
            }
        }
        return null;
    }

    public static UserHistory findFirstHistoryType(List<? extends Entity> list) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity) list.get(i);
            if (isHistoryType(entity.getEntityType())) {
                return (UserHistory) entity;
            }
        }
        return null;
    }

    public static UserHistory findLastHistoryType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isHistoryType(entity.getEntityType())) {
                return (UserHistory) entity;
            }
        }
        return null;
    }

    public static FeedReply findLastFeedReplyType(List<FeedReply> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            FeedReply feedReply = list.get(size);
            if (isFeedreply(feedReply.getEntityType())) {
                return feedReply;
            }
        }
        return null;
    }

    public static Feed findFirstFeedType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isFeedType(entity.getEntityType())) {
                return (Feed) entity;
            }
        }
        return null;
    }

    public static Feed findLastFeedType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isFeedType(entity.getEntityType())) {
                return (Feed) entity;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    public static Entity findFirstFeedAndReplyType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isFeedType(entity.getEntityType()) || isFeedreply(entity.getEntityType())) {
                return entity;
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }

    public static Entity findLastFeedAndReplyType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isFeedType(entity.getEntityType()) || isFeedreply(entity.getEntityType())) {
                return entity;
            }
        }
        return null;
    }

    public static Contacts findFirstContactsType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isContactType(entity.getEntityType())) {
                return (Contacts) entity;
            }
        }
        return null;
    }

    public static Contacts findLastContactsType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isContactType(entity.getEntityType())) {
                return (Contacts) entity;
            }
        }
        return null;
    }

    public static Topic findFirstTopicType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isTopicType(entity.getEntityType())) {
                return (Topic) entity;
            }
        }
        return null;
    }

    public static Topic findLastTopicType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isTopicType(entity.getEntityType())) {
                return (Topic) entity;
            }
        }
        return null;
    }

    public static User findFirstUserType(List<? extends Entity> list) {
        for (Entity entity : list) {
            if (isUserType(entity.getEntityType())) {
                return (User) entity;
            }
        }
        return null;
    }

    public static User findLastUserType(List<? extends Entity> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            Entity entity = (Entity) list.get(size);
            if (isUserType(entity.getEntityType())) {
                return (User) entity;
            }
        }
        return null;
    }

    public static <T> T findFirstItem(List<? extends Entity> list, String str) {
        if (str == null) {
            return null;
        }
        for (Entity entity : list) {
            T t = (T) entity;
            if ("card".equals(t.getEntityType())) {
                if (str.equals(t.getEntityTemplate())) {
                    return t;
                }
            } else if (str.equals(t.getEntityType())) {
                return t;
            }
        }
        return null;
    }

    public static <T> T findLastItem(List<? extends Entity> list, String str) {
        if (str == null) {
            return null;
        }
        for (int size = list.size() - 1; size > 0; size--) {
            T t = (T) ((Entity) list.get(size));
            if ("card".equals(t.getEntityType())) {
                if (str.equals(t.getEntityTemplate())) {
                    return t;
                }
            } else if (str.equals(t.getEntityType())) {
                return t;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.coolapk.market.util.EntityUtils$OnMatchEntity<T extends com.coolapk.market.model.Card<? extends com.coolapk.market.model.Entity>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Card<? extends Entity>> void matchEntity(List<? extends Entity> list, String str, String str2, OnMatchEntity<T> onMatchEntity) {
        for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity) list.get(i);
            if (TextUtils.equals(entity.getEntityType(), str)) {
                Card card = (Card) entity;
                List entities = card.getEntities();
                for (int i2 = 0; i2 < card.getEntities().size(); i2++) {
                    Entity entity2 = (Entity) entities.get(i2);
                    if (TextUtils.equals(entity2.getEntityType(), str2) && onMatchEntity.onMatch(card, i, entity2, i2)) {
                        break;
                    }
                }
            }
        }
    }

    public <T extends Entity> T asSingleEntity(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static void removeReduplicatedEntity(List<? extends Entity> list, List<? extends Entity> list2, OnDeleteListener onDeleteListener) {
        removeReduplicatedEntity(list, list2, onDeleteListener, 0);
    }

    public static void removeReduplicatedEntity(List<? extends Entity> list, final List<? extends Entity> list2, final OnDeleteListener onDeleteListener, final int i) {
        if (!(list.isEmpty() || list2.isEmpty())) {
            final HashMap hashMap = new HashMap();
            IDProvider iDProvider = IDProvider.sInstance;
            for (Entity entity : list) {
                String id = iDProvider.getId(entity);
                if (!TextUtils.isEmpty(id)) {
                    List list3 = (List) hashMap.get(entity.getClass());
                    if (list3 == null) {
                        list3 = new ArrayList();
                        hashMap.put(entity.getClass(), list3);
                    }
                    list3.add(id);
                }
            }
            if (!hashMap.isEmpty()) {
                for (List list4 : hashMap.values()) {
                    Collections.sort(list4);
                }
                final int size = list2.size();
                Observable.range(0, size).map(new Func1<Integer, Integer>() {
                    /* class com.coolapk.market.util.EntityUtils.AnonymousClass3 */

                    public Integer call(Integer num) {
                        return Integer.valueOf((size - num.intValue()) - 1);
                    }
                }).filter(new Func1<Integer, Boolean>() {
                    /* class com.coolapk.market.util.EntityUtils.AnonymousClass2 */
                    IDProvider provider = IDProvider.sInstance;

                    public Boolean call(Integer num) {
                        List list;
                        boolean z = false;
                        if (i > 0 && num.intValue() < i) {
                            return false;
                        }
                        Entity entity = (Entity) list2.get(num.intValue());
                        String id = this.provider.getId(entity);
                        if (TextUtils.isEmpty(id) || (list = (List) hashMap.get(entity.getClass())) == null) {
                            return false;
                        }
                        if (Collections.binarySearch(list, id) >= 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                }).subscribe(new Action1<Integer>() {
                    /* class com.coolapk.market.util.EntityUtils.AnonymousClass1 */

                    public void call(Integer num) {
                        list2.remove(num.intValue());
                        OnDeleteListener onDeleteListener = onDeleteListener;
                        if (onDeleteListener != null) {
                            onDeleteListener.onDelete(num.intValue());
                        }
                    }
                });
            }
        }
    }

    private static class IDProvider {
        public static final IDProvider sInstance = new IDProvider();

        private IDProvider() {
        }

        String getId(Entity entity) {
            if (entity instanceof Feed) {
                return entity.getId();
            }
            if (entity instanceof Message) {
                return entity.getEntityId();
            }
            if (TextUtils.equals(entity.getEntityType(), "messageExtra")) {
                return entity.getEntityId();
            }
            if (entity instanceof Topic) {
                return entity.getId();
            }
            if (entity instanceof ServiceApp) {
                return ((ServiceApp) entity).getApkId();
            }
            if (entity instanceof Album) {
                return ((Album) entity).getAlbumId();
            }
            if (entity instanceof AppForum) {
                return ((AppForum) entity).id();
            }
            return null;
        }
    }
}
