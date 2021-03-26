package com.coolapk.market.remote;

import com.coolapk.market.model.Ads;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumCard;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.CardTitleItem;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.DeviceInfo;
import com.coolapk.market.model.DeviceParams;
import com.coolapk.market.model.DiscoveryQuery;
import com.coolapk.market.model.DocListCard;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhArticleCard;
import com.coolapk.market.model.DyhLogoCard;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.EditorInfo;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Favorite;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedGoodsAction;
import com.coolapk.market.model.FeedGoodsCategory;
import com.coolapk.market.model.FeedQuestion;
import com.coolapk.market.model.FeedRelation;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.FeedStatus;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.model.FileDetail;
import com.coolapk.market.model.ForwardFeed;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.Goods;
import com.coolapk.market.model.GoodsCategoryInfo;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.model.GridCard;
import com.coolapk.market.model.ImInfo;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.Link;
import com.coolapk.market.model.LinkCard;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.LiveProduct;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.model.LocalApp;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.model.MainSecondHandType;
import com.coolapk.market.model.MallInfo;
import com.coolapk.market.model.MenuCard;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.MessageCard;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.NodeTargetInfo;
import com.coolapk.market.model.Notification;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.model.PatchInfo;
import com.coolapk.market.model.PicCategory;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.model.ProductConfig;
import com.coolapk.market.model.ProductCoupon;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.model.ProductSeries;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.model.SimpleInfo;
import com.coolapk.market.model.TabGroupCard;
import com.coolapk.market.model.Tips;
import com.coolapk.market.model.TitleCard;
import com.coolapk.market.model.TopCard;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.Unread;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.model.UserCount;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.model.Video;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

public final class AutoValueGson_TypeAdapterFactory extends TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (TitleCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TitleCard.typeAdapter(gson);
        }
        if (Contacts.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Contacts.typeAdapter(gson);
        }
        if (Message.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Message.typeAdapter(gson);
        }
        if (LinkCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LinkCard.typeAdapter(gson);
        }
        if (FeedGoodsCategory.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedGoodsCategory.typeAdapter(gson);
        }
        if (ConfigPage.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ConfigPage.typeAdapter(gson);
        }
        if (Feed.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Feed.typeAdapter(gson);
        }
        if (AlbumItem.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) AlbumItem.typeAdapter(gson);
        }
        if (AppCategory.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) AppCategory.typeAdapter(gson);
        }
        if (UserHistory.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UserHistory.typeAdapter(gson);
        }
        if (ItemPlaceHolder.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ItemPlaceHolder.typeAdapter(gson);
        }
        if (FeedTarget.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedTarget.typeAdapter(gson);
        }
        if (EntityCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) EntityCard.typeAdapter(gson);
        }
        if (FunThings.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FunThings.typeAdapter(gson);
        }
        if (Link.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Link.typeAdapter(gson);
        }
        if (DiscoveryQuery.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DiscoveryQuery.typeAdapter(gson);
        }
        if (ServiceApp.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ServiceApp.typeAdapter(gson);
        }
        if (UserCount.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UserCount.typeAdapter(gson);
        }
        if (Product.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Product.typeAdapter(gson);
        }
        if (Favorite.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Favorite.typeAdapter(gson);
        }
        if (SimpleEntity.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) SimpleEntity.typeAdapter(gson);
        }
        if (Goods.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Goods.typeAdapter(gson);
        }
        if (FeedGoodsAction.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedGoodsAction.typeAdapter(gson);
        }
        if (ProductMedia.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ProductMedia.typeAdapter(gson);
        }
        if (MenuCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MenuCard.typeAdapter(gson);
        }
        if (Album.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Album.typeAdapter(gson);
        }
        if (CollectionItem.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CollectionItem.typeAdapter(gson);
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Collection.typeAdapter(gson);
        }
        if (LocalApp.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LocalApp.typeAdapter(gson);
        }
        if (LikeResult.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LikeResult.typeAdapter(gson);
        }
        if (AppForum.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) AppForum.typeAdapter(gson);
        }
        if (Video.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Video.typeAdapter(gson);
        }
        if (ProductCoupon.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ProductCoupon.typeAdapter(gson);
        }
        if (Vote.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Vote.typeAdapter(gson);
        }
        if (GridCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) GridCard.typeAdapter(gson);
        }
        if (Notification.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Notification.typeAdapter(gson);
        }
        if (MallInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MallInfo.typeAdapter(gson);
        }
        if (LiveProduct.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LiveProduct.typeAdapter(gson);
        }
        if (ProductConfig.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ProductConfig.typeAdapter(gson);
        }
        if (ForwardFeed.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ForwardFeed.typeAdapter(gson);
        }
        if (User.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) User.typeAdapter(gson);
        }
        if (DyhArticle.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DyhArticle.typeAdapter(gson);
        }
        if (VoteOption.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) VoteOption.typeAdapter(gson);
        }
        if (RecentHistory.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RecentHistory.typeAdapter(gson);
        }
        if (UserAction.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UserAction.typeAdapter(gson);
        }
        if (PicCategory.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PicCategory.typeAdapter(gson);
        }
        if (DeviceInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DeviceInfo.typeAdapter(gson);
        }
        if (DyhModel.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DyhModel.typeAdapter(gson);
        }
        if (LiveMessage.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LiveMessage.typeAdapter(gson);
        }
        if (MainSecondHandType.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MainSecondHandType.typeAdapter(gson);
        }
        if (GoodsListItem.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) GoodsListItem.typeAdapter(gson);
        }
        if (CouponInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CouponInfo.typeAdapter(gson);
        }
        if (VideoUrls.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) VideoUrls.typeAdapter(gson);
        }
        if (NodeTargetInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) NodeTargetInfo.typeAdapter(gson);
        }
        if (NotifyCount.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) NotifyCount.typeAdapter(gson);
        }
        if (UserProfile.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UserProfile.typeAdapter(gson);
        }
        if (NodeRating.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) NodeRating.typeAdapter(gson);
        }
        if (SimpleInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) SimpleInfo.typeAdapter(gson);
        }
        if (Ads.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Ads.typeAdapter(gson);
        }
        if (AlbumCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) AlbumCard.typeAdapter(gson);
        }
        if (FeedRelation.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedRelation.typeAdapter(gson);
        }
        if (LoginInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LoginInfo.typeAdapter(gson);
        }
        if (UserInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UserInfo.typeAdapter(gson);
        }
        if (EditorInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) EditorInfo.typeAdapter(gson);
        }
        if (TopCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TopCard.typeAdapter(gson);
        }
        if (MessageCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MessageCard.typeAdapter(gson);
        }
        if (DyhArticleCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DyhArticleCard.typeAdapter(gson);
        }
        if (CardTitleItem.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CardTitleItem.typeAdapter(gson);
        }
        if (PatchInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PatchInfo.typeAdapter(gson);
        }
        if (BackupInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BackupInfo.typeAdapter(gson);
        }
        if (SecondHandInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) SecondHandInfo.typeAdapter(gson);
        }
        if (TabGroupCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TabGroupCard.typeAdapter(gson);
        }
        if (Live.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Live.typeAdapter(gson);
        }
        if (Tips.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Tips.typeAdapter(gson);
        }
        if (TopGroupCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TopGroupCard.typeAdapter(gson);
        }
        if (ShareFeedInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ShareFeedInfo.typeAdapter(gson);
        }
        if (ImInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ImInfo.typeAdapter(gson);
        }
        if (ProductBrand.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ProductBrand.typeAdapter(gson);
        }
        if (NewHeadLine.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) NewHeadLine.typeAdapter(gson);
        }
        if (Topic.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Topic.typeAdapter(gson);
        }
        if (DyhLogoCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DyhLogoCard.typeAdapter(gson);
        }
        if (DocListCard.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DocListCard.typeAdapter(gson);
        }
        if (GoodsCategoryInfo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) GoodsCategoryInfo.typeAdapter(gson);
        }
        if (FeedReply.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedReply.typeAdapter(gson);
        }
        if (FeedReply.ReplyUserAction.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedReply.ReplyUserAction.typeAdapter(gson);
        }
        if (FeedReply.ReplyFeed.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedReply.ReplyFeed.typeAdapter(gson);
        }
        if (FileDetail.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FileDetail.typeAdapter(gson);
        }
        if (LiveUser.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LiveUser.typeAdapter(gson);
        }
        if (Gift.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Gift.typeAdapter(gson);
        }
        if (FeedStatus.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedStatus.typeAdapter(gson);
        }
        if (FeedGoods.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedGoods.typeAdapter(gson);
        }
        if (ProductSeries.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ProductSeries.typeAdapter(gson);
        }
        if (VersionApp.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) VersionApp.typeAdapter(gson);
        }
        if (RelatedData.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RelatedData.typeAdapter(gson);
        }
        if (DeviceParams.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DeviceParams.typeAdapter(gson);
        }
        if (Unread.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Unread.typeAdapter(gson);
        }
        if (FeedQuestion.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) FeedQuestion.typeAdapter(gson);
        }
        return null;
    }
}
