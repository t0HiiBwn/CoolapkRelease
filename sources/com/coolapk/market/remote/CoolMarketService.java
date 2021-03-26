package com.coolapk.market.remote;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.DeviceInfo;
import com.coolapk.market.model.DiscoveryQuery;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.FileDetail;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.model.PatchInfo;
import com.coolapk.market.model.PicCategory;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.model.ProductConfig;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.SimpleInfo;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserCount;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.model.Vote;
import com.coolapk.market.network.HttpClientFactory;
import com.coolapk.market.network.Result;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public class CoolMarketService {
    private RemoteService remoteService;

    public interface RemoteService {
        @FormUrlEncoded
        @POST("album/addApk")
        Observable<Result<String>> addApkToAlbum(@Query("id") String str, @Field("packageName") String str2, @Field("title") String str3, @Field("url") String str4, @Field("note") String str5, @Field("displayOrder") int i, @Field("logo") String str6);

        @POST("album/addApk")
        Observable<Result<String>> addApkToAlbum(@Query("id") String str, @Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("goods/addGoods")
        Observable<Result<FeedGoods>> addGoods(@Field("url") String str);

        @FormUrlEncoded
        @POST("goodsList/addGoods")
        Observable<Result<String>> addGoods(@Field("feedId") String str, @Field("goodsId") String str2, @Field("note") String str3);

        @FormUrlEncoded
        @POST("goods/addGoods")
        Observable<Result<FeedGoods>> addGoodsWithHtmlContent(@Field("url") String str, @Field("html_url") String str2, @Field("html_content") String str3);

        @FormUrlEncoded
        @POST("live/addToBroadcast")
        Observable<Result<String>> addLiveBroadcast(@Field("id") String str, @Field("messageId") String str2);

        @FormUrlEncoded
        @POST("feed/addReplyTopToFeed")
        Observable<Result<String>> addReplyTopToFeed(@Field("replyId") String str, @Field("feedId") String str2);

        @POST("user/addToBlackList")
        Observable<Result<String>> addToBlackList(@Query("uid") String str);

        @FormUrlEncoded
        @POST("collection/addItem")
        Observable<ResponseBody> addToCollection(@Field("id") String str, @Field("cancelId") String str2, @Field("targetId") String str3, @Field("type") String str4);

        @POST("feed/addToEditorChoice")
        Observable<Result<String>> addToEditorChoice(@Query("feedId") String str, @Query("template") String str2);

        @POST("feed/addToHeadline")
        Observable<Result<String>> addToHeadline(@Query("feedId") String str);

        @POST("feed/addToHeadlineV8")
        Observable<Result<String>> addToHeadlineV8(@Query("feedId") String str, @Query("template") String str2);

        @POST("user/addToIgnoreList")
        Observable<Result<String>> addToIgnoreList(@Query("uid") String str);

        @POST("user/addToLimitList")
        Observable<Result<String>> addToLimitList(@Query("uid") String str);

        @FormUrlEncoded
        @POST("product/addRecommendMedia")
        Observable<Result<String>> addToMediaList(@Field("id") String str);

        @GET("picture/addToSplash")
        Observable<Result<String>> addToSplash(@Query("id") String str);

        @FormUrlEncoded
        @POST("user/addToTopRecentHistory")
        Observable<Result<String>> addToTopRecentHistory(@Field("targetId") String str, @Field("targetType") String str2);

        @GET("message/addTop")
        Observable<Result<String>> addTop(@Query("ukey") String str);

        @FormUrlEncoded
        @POST("feed/addTopContentToNode")
        Observable<Result<String>> addTopContentToNode(@Field("nodeType") String str, @Field("nodeId") String str2, @Field("feedId") String str3, @Field("title") String str4);

        @FormUrlEncoded
        @POST("feed/addTopToNode")
        Observable<Result<String>> addTopToNode(@Field("nodeType") String str, @Field("nodeId") String str2, @Field("feedId") String str3);

        @GET("erShou/agreement")
        Observable<Result<Integer>> agreement();

        @GET("apk/offline")
        Observable<Result<String>> apkOffLine(@Query("id") String str);

        @GET("search")
        Observable<Result<List<Entity>>> appSearch(@Query("type") String str, @Query("cat") String str2, @Query("sort") String str3, @Query("searchValue") String str4, @Query("page") int i, @Query("firstItem") String str5, @Query("lastItem") String str6, @Query("pageContext") String str7);

        @POST("dyhArticle/addToEditorChoice")
        Observable<Result<String>> articleAddToEditorChoice(@Query("artId") String str, @Query("template") String str2);

        @POST("dyhArticle/addToHeadlineV8")
        Observable<Result<String>> articleAddToHeadlineV8(@Query("artId") String str, @Query("template") String str2);

        @POST("dyhArticle/removeFromEditorChoice")
        Observable<Result<String>> articleRemoveFromEditorChoice(@Query("artId") String str, @Query("template") String str2);

        @POST("dyhArticle/removeFromHeadlineV8")
        Observable<Result<String>> articleRemoveFromHeadlineV8(@Query("artId") String str, @Query("template") String str2);

        @POST("dyhArticle/unsetMessageStatus")
        Observable<Result<String>> articleSoftRemove(@Query("id") String str, @Query("template") String str2);

        @GET("search?type=ask")
        Observable<Result<List<Entity>>> askSearch(@Query("feedType") String str, @Query("searchValue") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @FormUrlEncoded
        @POST("user/cancelFollow")
        Observable<Result<String>> cancelFollow(@Field("id") String str, @Field("type") String str2);

        @POST("feed/cancelRecommend")
        Observable<Result<String>> cancelRecommend(@Query("id") String str);

        @FormUrlEncoded
        @POST("feed/cancelReplyTopFromFeed")
        Observable<Result<String>> cancelReplyTopFromFeed(@Field("feedId") String str);

        @GET("report/cancelReportSpam")
        Observable<Result<String>> cancelReportSpam(@Query("id") String str, @Query("type") String str2);

        @FormUrlEncoded
        @POST("feed/cancelTopFromNode")
        Observable<Result<String>> cancelTopFromNode(@Field("nodeType") String str, @Field("nodeId") String str2, @Field("feedId") String str3);

        @GET("account/captchaImage")
        Observable<Result<String>> captchaImage();

        @POST("account/changeAvatar")
        Observable<Result<String>> changeAvatar(@Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("account/changeAvatarCover")
        Observable<Result<String>> changeAvatarCover(@Field("url") String str);

        @FormUrlEncoded
        @POST("product/changeBuyStatus")
        Observable<Result<String>> changeBuyStatus(@Field("id") String str, @Field("status") int i);

        @POST("dyh/changeDescend")
        Observable<Result<String>> changeDescendFeed(@Query("id") String str, @Query("type") int i);

        @FormUrlEncoded
        @POST("account/changeEmail")
        Observable<Result<String>> changeEmail(@Field("email") String str, @Field("code") String str2);

        @POST("feed/changeFeed")
        Observable<Result<Entity>> changeFeed(@Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("upload/changeFileStatus")
        Observable<Result<String>> changeFileStatus(@Field("url") String str, @Field("type") String str2);

        @FormUrlEncoded
        @POST("live/changeStatus")
        Observable<Result<String>> changeLiveStatus(@Field("id") String str, @Field("fieldName") String str2, @Field("status") int i);

        @FormUrlEncoded
        @POST("account/changeMobile")
        Observable<Result<String>> changeMobile(@Field("mobile") String str, @Field("country") String str2, @Field("code") String str3);

        @FormUrlEncoded
        @POST("product/changeFollowStatus")
        Observable<Result<Integer>> changeProductFollowState(@Field("id") String str, @Field("status") int i);

        @FormUrlEncoded
        @POST("product/changeLikeStatus")
        Observable<Result<Product>> changeProductLikeState(@Field("id") String str, @Field("status") int i);

        @FormUrlEncoded
        @POST("erShou/changeStatus")
        Observable<Result<Feed>> changeStatus(@Field("id") String str, @Field("status") String str2);

        @FormUrlEncoded
        @POST("account/changeUsername")
        Observable<Result<String>> changeUserName(@Field("username") String str);

        @POST("account/changeProfile")
        @Multipart
        Observable<Result<UserProfile>> changeUserProfile(@Part("key") String str, @Part("value") String str2);

        @FormUrlEncoded
        @POST("product/changeWishStatus")
        Observable<Result<String>> changeWishStatus(@Field("id") String str, @Field("status") int i);

        @FormUrlEncoded
        @POST("goods/changeFeedGoodsRecommendStatus")
        Observable<Result<String>> changedFeedGoodsRecommendStatus(@Field("id") String str, @Field("status") int i);

        @GET("question/checkAnswerCount")
        Observable<Result<Integer>> checkAnswerCount(@Query("feedId") String str, @Query("uid") String str2);

        @GET("album/checkApkIsInAlbum")
        Observable<Result<AlbumItem>> checkApkIsInAlbum(@Query("id") String str, @Query("apkname") String str2);

        @GET("backList/checkTitleExist")
        Observable<Result<String>> checkBackupTitle(@Query("title") String str);

        @GET("collection/checkCount")
        Observable<Result<String>> checkCollectionCount();

        @GET("backList/checkCount")
        Observable<Result<String>> checkCount();

        @POST("apk/checkUpdate")
        @Multipart
        Observable<Result<List<PatchInfo>>> checkForUpgradeAppList(@Part("pkgs") String str, @Query("coolmarket_beta") String str2);

        @GET("account/checkLoginInfo")
        Observable<Result<LoginInfo>> checkLoginInfo();

        @GET("notification/checkCount")
        Observable<Result<NotifyCount>> checkNotificationCount();

        @FormUrlEncoded
        @POST("erShou/checkUrl")
        Observable<Result<String>> checkUrl(@Field("ershou_link") String str);

        @GET("account/checkChangeUsernameStatus")
        Observable<Result<String>> checkUserNameStatus();

        @POST("user/clearHeadlineCache")
        Observable<Result<String>> clearHeadlineCache();

        @POST("notification/clearCount")
        Observable<Result<String>> clearNotificationCount(@Query("type") String str);

        @POST("apk/comment")
        @Multipart
        Observable<Result<Feed>> commentApp(@Query("id") String str, @Part("message") String str2, @Part("picFile") RequestBody requestBody);

        @FormUrlEncoded
        @POST("backList/cover")
        Observable<Result<BackupInfo>> coverPic(@Field("apkInfo") String str, @Field("id") String str2);

        @POST("album/create")
        @Multipart
        Observable<Result<String>> createAlbum(@Part("title") String str, @Part("intro") String str2);

        @FormUrlEncoded
        @POST("backList/create")
        Observable<ResponseBody> createBackupList(@Field("title") String str, @Field("cover") int i, @Field("packageInfo") String str2);

        @POST("collection/create")
        Observable<Result<Collection>> createCollection(@Body RequestBody requestBody);

        @POST("feed/createFeed")
        Observable<Result<Entity>> createFeed(@Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("goodsList/create")
        Observable<Result<String>> createFunThings(@Field("title") String str, @Field("message") String str2, @Field("cover") String str3);

        @FormUrlEncoded
        @POST("vote/createUserVote")
        Observable<Result<Vote>> createUserVote(@Field("id") String str, @FieldMap Map<String, String> map, @Field("anonymous_status") int i);

        @POST("user/clearViewHistory")
        Observable<Result<String>> delAllHistory();

        @POST("album/delApk")
        @Multipart
        Observable<Result<String>> delApkFromAlbum(@Query("id") String str, @Part("packageName") String str2);

        @GET("user/delGift")
        Observable<Result<String>> delUserGift(@Query("docId") String str, @Query("gift") String str2);

        @FormUrlEncoded
        @POST("live/deleteAllMessageByUid")
        Observable<Result<String>> deleteAllMessageByUid(@Field("liveId") String str, @Field("uid") String str2, @Field("disallowType") int i);

        @POST("notification/deleteAll")
        Observable<Result<String>> deleteAllNotification(@Query("type") String str);

        @POST("user/clearRecentHistory")
        Observable<Result<String>> deleteAllRecentHistory();

        @FormUrlEncoded
        @POST("user/deleteAvatar")
        Observable<Result<String>> deleteAvatar(@Query("uid") String str, @Field("lock") int i);

        @GET("backList/delete")
        Observable<Result<String>> deleteBackup(@Query("id") String str);

        @GET("message/deleteChat")
        Observable<Result<String>> deleteChat(@Query("ukey") String str);

        @GET("message/deleteChatMulti")
        Observable<Result<List<String>>> deleteChatMulti(@Query("ukeys") String str);

        @FormUrlEncoded
        @POST("collection/delete")
        Observable<Result<String>> deleteCollection(@Field("id") String str);

        @POST("feed/deleteFeed")
        Observable<Result<String>> deleteFeed(@Query("id") String str, @Query("notNotify") int i);

        @FormUrlEncoded
        @POST("upload/deleteFeedFromUploadFileLog")
        Observable<Result<String>> deleteFeedFromUploadFileLog(@Field("url") String str);

        @POST("feed/deleteReply")
        Observable<Result<String>> deleteFeedReply(@Query("id") String str, @Query("notNotify") int i);

        @FormUrlEncoded
        @POST("product/removeRecommendMedia")
        Observable<Result<String>> deleteFromMediaList(@Field("id") String str);

        @FormUrlEncoded
        @POST("goodsList/delete")
        Observable<Result<String>> deleteFunThings(@Field("id") String str);

        @FormUrlEncoded
        @POST("goodsList/deleteItems")
        Observable<Result<String>> deleteGoods(@Field("cancelFeedId") String str, @Field("goodsId") String str2);

        @POST("feed/deleteHistory")
        Observable<Result<String>> deleteHistoryFeed(@Query("id") String str, @Query("notNotify") int i);

        @FormUrlEncoded
        @POST("live/deleteMessage")
        Observable<Result<String>> deleteLiveMessage(@Field("id") String str, @Field("messageId") String str2);

        @GET("message/delete")
        Observable<Result<String>> deleteMessage(@Query("ukey") String str, @Query("id") String str2);

        @POST("notification/delete")
        Observable<Result<String>> deleteNotification(@Query("id") String str);

        @POST("feed/deleteRating")
        Observable<Result<String>> deleteRating(@Query("uid") String str, @Query("targetId") String str2, @Query("targetType") String str3, @Query("notNotify") int i);

        @FormUrlEncoded
        @POST("user/deleteRecentHistory")
        Observable<Result<String>> deleteRecentHistory(@Field("id") String str);

        @FormUrlEncoded
        @POST("user/deleteViewHistory")
        Observable<Result<String>> deleteViewHistory(@Field("history") String str);

        @FormUrlEncoded
        @POST("live/disallowUser")
        Observable<Result<String>> disallowLiveUser(@Field("liveId") String str, @Field("uid") String str2, @Field("disallowType") int i);

        @POST("dyhArticle/favorite")
        Observable<Result<Integer>> dyhArticleFavorite(@Query("id") String str);

        @POST("dyhArticle/like")
        Observable<Result<Integer>> dyhArticleLike(@Query("artId") String str);

        @POST("dyhArticle/delete")
        Observable<Result<String>> dyhArticleRemoveInclude(@Query("id") String str, @Query("dyhId") String str2);

        @POST("dyhArticle/unFavorite")
        Observable<Result<Integer>> dyhArticleUnFavorite(@Query("id") String str);

        @POST("dyhArticle/unLike")
        Observable<Result<Integer>> dyhArticleUnLike(@Query("artId") String str);

        @FormUrlEncoded
        @POST("album/edit")
        Observable<Result<String>> editAlbum(@Query("id") String str, @Field("title") String str2, @Field("intro") String str3);

        @FormUrlEncoded
        @POST("album/editApkDisplayOrder")
        Observable<Result<String>> editApkDisplayOrder(@Query("id") String str, @Field("displayOrder") String str2);

        @FormUrlEncoded
        @POST("collection/update")
        Observable<Result<Collection>> editCollection(@Field("id") String str, @Field("title") String str2, @Field("description") String str3, @Field("pic") String str4, @Field("isOpen") String str5);

        @FormUrlEncoded
        @POST("goodsList/edit")
        Observable<Result<String>> editGoodsList(@Field("id") String str, @Field("title") String str2, @Field("message") String str3, @Field("cover") String str4);

        @FormUrlEncoded
        @POST("goodsList/editGoodsListDisplayOrder")
        Observable<Result<String>> editGoodsListDisplayOrder(@Field("feedId") String str, @Field("displayOrder") String str2);

        @FormUrlEncoded
        @POST("goodsList/editGoodsItem")
        Observable<Result<String>> editGoodsNote(@Field("feedId") String str, @Field("goodsId") String str2, @Field("note") String str3);

        @POST("user/block")
        Observable<Result<String>> executeUserBlock(@Query("uid") String str, @Query("action") String str2, @Query("clearTypes") String str3);

        @FormUrlEncoded
        @POST("album/favorite")
        Observable<Result<Integer>> favoriteAlbum(@Field("id") String str);

        @FormUrlEncoded
        @POST("apk/favorite")
        Observable<Result<Integer>> favoriteApp(@Field("id") String str);

        @POST("feed/favorite")
        Observable<Result<Integer>> favoriteFeed(@Query("id") String str);

        @POST("picture/favorite")
        Observable<Result<String>> favoritePic(@Query("id") String str);

        @POST("feed/block")
        Observable<Result<String>> feedBlock(@Query("blockType") String str, @Query("feedType") String str2, @Query("id") String str3);

        @FormUrlEncoded
        @POST("feed/censor")
        Observable<Result<SimpleInfo>> feedCensor(@Field("feed_id") String str);

        @POST("feed/Recommend")
        Observable<Result<String>> feedRecommend(@Query("id") String str);

        @GET("search?type=feed")
        Observable<Result<List<Entity>>> feedSearch(@Query("feedType") String str, @Query("sort") String str2, @Query("searchValue") String str3, @Query("pageType") String str4, @Query("pageParam") String str5, @Query("page") int i, @Query("firstItem") String str6, @Query("lastItem") String str7, @Query("showAnonymous") int i2);

        @POST("feed/unBlock")
        Observable<Result<String>> feedUnBlock(@Query("blockType") String str, @Query("feedType") String str2, @Query("id") String str3);

        @POST("feed/unBlock")
        Observable<Result<String>> feedUnBlock(@Query("blockType") String str, @Query("feedType") String str2, @Query("id") String str3, @Query("withOnlyHomeSelf") int i);

        @GET("apk/follow")
        Observable<Result<Map<String, String>>> followApp(@Query("id") String str);

        @GET("appForum/follow")
        Observable<Result<Map<String, String>>> followAppForum(@Query("id") String str);

        @FormUrlEncoded
        @POST("collection/follow")
        Observable<Result<Integer>> followCollection(@Field("id") String str);

        @POST("dyh/follow")
        Observable<Result<String>> followDyh(@Query("dyhId") String str);

        @GET("live/follow")
        Observable<Result<String>> followLive(@Query("id") String str);

        @GET("question/follow")
        Observable<Result<Integer>> followQuestion(@Query("id") String str);

        @GET("feed/followTag")
        Observable<Result<Integer>> followTag(@Query("tag") String str);

        @POST("user/follow")
        Observable<Result<Integer>> followUser(@Query("uid") String str);

        @GET("account/accessToken")
        Observable<Result<LoginInfo>> getAccessToken(@Query("code") String str);

        @GET("feed/newestList")
        Observable<Result<List<Entity>>> getAdminNewestList(@Query("type") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("blockStatus") int i2);

        @GET("feed/newestReplyList")
        Observable<Result<List<Entity>>> getAdminNewestReplyList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("erShou/agreementDetail")
        Observable<Result<String>> getAgreementDetail();

        @GET("album/allApkList")
        Observable<Result<List<AlbumItem>>> getAlbumAllApkList(@Query("id") String str);

        @GET("album/apkList")
        Observable<Result<List<AlbumItem>>> getAlbumApkList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("album/detail")
        Observable<Result<Album>> getAlbumDetail(@Query("id") String str, @Query("rid") String str2);

        @GET("album/list")
        Observable<Result<List<Entity>>> getAlbumList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2, @Query("listType") String str3);

        @GET("album/search")
        Observable<Result<List<Entity>>> getAlbumList(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("album/replyList")
        Observable<Result<List<FeedReply>>> getAlbumReplyList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("apk/giftList")
        Observable<Result<List<Gift>>> getAllGiftList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("question/answerList")
        Observable<Result<List<Entity>>> getAnswerList(@Query("id") String str, @Query("sort") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4, @Query("blockStatus") Integer num);

        @GET("topic/apkFeedList")
        Observable<Result<List<Entity>>> getApkFeedList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/apkRatingList")
        Observable<Result<List<Entity>>> getApkRatingList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("apk/url")
        Observable<Result<String>> getApkUrl(@Query("id") String str);

        @GET("apk/categoryList")
        Observable<Result<List<Entity>>> getAppCategoryList(@Query("apkType") String str);

        @GET("apk/commentList")
        Observable<Result<List<Feed>>> getAppCommentList(@Query("id") String str, @Query("listType") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4, @Query("blockStatus") int i2, @Query("isDeveloper") int i3, @Query("fromApi") String str5);

        @FormUrlEncoded
        @POST("apk/detail")
        Observable<ResponseBody> getAppDetail(@Query("id") String str, @Query("installed") int i, @Field("extraAnalysisData") String str2, @Query("requestContext") String str3);

        @GET("apk/downloadInfo")
        Observable<Result<DownloadInfo>> getAppDownloadInfo(@Query("id") String str);

        @FormUrlEncoded
        @POST("apk/downloadInfo")
        Observable<Result<List<DownloadInfo>>> getAppDownloadInfoList(@Field("id") String str);

        @GET("apk/followerList")
        Observable<Result<List<User>>> getAppFollowerList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("appForum/commentList")
        Observable<Result<List<Feed>>> getAppForumCommentList(@Query("id") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4, @Query("blockStatus") int i2);

        @FormUrlEncoded
        @POST("appForum/detail")
        Observable<Result<AppForum>> getAppForumDetail(@Query("id") String str, @Query("installed") int i, @Field("extraAnalysisData") String str2);

        @GET("appForum/list")
        Observable<Result<List<Entity>>> getAppForumList(@Query("type") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("appForum/{listType}")
        Observable<Result<List<Entity>>> getAppForumListWithPath(@Path("listType") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("apk/qr")
        Observable<Result<ServiceApp>> getAppFromQrCode(@Query("id") String str);

        @GET("apk/index")
        Observable<Result<List<Entity>>> getAppList(@Query("apkType") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("apk/index?listType=cat")
        Observable<Result<List<Entity>>> getAppListWithCategory(@Query("catId") String str, @Query("apkType") String str2, @Query("rankType") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("apk/search?searchType=developer")
        Observable<Result<List<ServiceApp>>> getAppListWithDeveloper(@Query("developer") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("apk/search")
        Observable<Result<List<Entity>>> getAppListWithKeyword(@Query("q") String str, @Query("apkType") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("apk/search")
        Observable<Result<List<Entity>>> getAppListWithKeyword(@Query("q") String str, @Query("apkType") String str2, @Query("rankType") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("apk/search?searchType=tag")
        Observable<Result<List<Entity>>> getAppListWithTag(@Query("tag") String str, @Query("apkType") String str2, @Query("rankType") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("dyhArticle/list")
        Observable<Result<List<Entity>>> getArticleList(@Query("dyhId") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("account/avatarCoverList")
        Observable<Result<JSONArray>> getAvatarCoverList();

        @GET("backList/detail")
        Observable<Result<BackupInfo>> getBackupDetail(@Query("id") String str);

        @GET("backList/list")
        Observable<Result<List<Entity>>> getBackupList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("backList/detail")
        Observable<Result<BackupInfo>> getBackupList(@Query("id") String str);

        @GET("main/cardSample")
        Observable<Result<List<Entity>>> getCardSampleList(@Query("name") String str);

        @FormUrlEncoded
        @POST("account/getChangeEmailCode")
        Observable<Result<String>> getChangeEmailCode(@Field("email") String str);

        @GET("feed/changeDetail")
        Observable<Result<Entity>> getChangeFeedDetail(@Query("id") String str, @Query("rid") String str2, @Query("noticeId") String str3, @Query("fromApi") String str4);

        @GET("feed/changeHistoryDetail")
        Observable<Result<Entity>> getChangeHistoryDetail(@Query("id") String str);

        @GET("message/chat")
        Observable<Result<List<Entity>>> getChatList(@Query("ukey") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("topic/circleFeedList")
        Observable<Result<List<Entity>>> getCircleFeedList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("cloudInstall/task")
        Observable<Result<ServiceApp>> getCloudInstall(@Query("id") String str);

        @GET("collection/detail")
        Observable<Result<Collection>> getCollection(@Query("id") String str);

        @GET("collection/itemList")
        Observable<Result<List<Entity>>> getCollectionItemList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("collection/list")
        Observable<Result<List<Entity>>> getCollectionList(@Query("uid") String str, @Query("id") String str2, @Query("type") String str3, @Query("showDefault") int i, @Query("page") int i2, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("picture/flowList")
        Observable<Result<List<Entity>>> getCoolPicList(@Query("pageType") String str, @Query("currentId") String str2, @Query("direction") String str3, @Query("params") String str4);

        @GET("account/getSupportSmsArea")
        Observable<Result<String>> getCountryList();

        @GET("page/dataList")
        Observable<Result<List<Entity>>> getDataList(@Query("url") String str, @Query("title") String str2, @Query("subTitle") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5, @Query("pageContext") String str6);

        @GET("apk/developerAppList")
        Observable<Result<List<Entity>>> getDeveloperAppList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("device/info?need_device_title=1")
        Observable<Result<DeviceInfo>> getDeviceInfo();

        @GET("apk/discovererList")
        Observable<Result<List<RelatedData>>> getDiscovererList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("discovery/index")
        Observable<Result<List<Entity>>> getDiscoveryList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("dyhArticle/Detail")
        Observable<Result<DyhArticle>> getDyhArticleDetail(@Query("artId") String str, @Query("rid") String str2);

        @GET("dyhArticle/list")
        Observable<Result<List<DyhArticle>>> getDyhArticleList(@Query("dyhId") String str);

        @GET("dyh/dyhChannel")
        Observable<Result<List<Entity>>> getDyhChannelList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("dyh/detail")
        Observable<Result<DyhModel>> getDyhDetail(@Query("dyhId") String str);

        @GET("dyh/list")
        Observable<Result<List<Entity>>> getDyhList(@Query("type") String str, @Query("shareType") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("feed/editorChoiceList")
        Observable<Result<List<Entity>>> getEditorChoiceList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("favorite/list")
        Observable<Result<List<Entity>>> getFavoriteList(@Query("type") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("feed/changeHistoryList")
        Observable<Result<List<Entity>>> getFeedChangeHistoryList(@Query("id") String str);

        @GET("feed/detail")
        Observable<Result<Entity>> getFeedDetail(@Query("id") String str, @Query("rid") String str2, @Query("noticeId") String str3, @Query("fromApi") String str4);

        @GET("feed/forwardList")
        Observable<Result<List<Entity>>> getFeedForwardList(@Query("id") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("feed/likeList")
        Observable<Result<List<Entity>>> getFeedLikeList(@Query("id") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("topic/feedList")
        Observable<Result<List<Entity>>> getFeedListByType(@Query("type") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("feed/replyDetail")
        Observable<Result<FeedReply>> getFeedReplyDetail(@Query("id") String str);

        @GET("feed/replyList")
        Observable<Result<List<Entity>>> getFeedReplyList(@Query("id") String str, @Query("listType") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4, @Query("discussMode") int i2, @Query("feedType") String str5, @Query("blockStatus") int i3, @Query("fromFeedAuthor") int i4);

        @FormUrlEncoded
        @POST("upload/fileDetail")
        Observable<Result<FileDetail>> getFileDetail(@Field("url") String str);

        @GET("dyh/followMore")
        Observable<Result<List<Entity>>> getFollowMore();

        @GET("goodsList/list")
        Observable<Result<List<Entity>>> getFunThingsList(@Query("uid") String str, @Query("goodsId") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("apk/getGift")
        Observable<Result<String>> getGift(@Query("docId") String str);

        @GET("apk/giftList")
        Observable<Result<List<Gift>>> getGiftListByApkId(@Query("apkId") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("goods/detail")
        Observable<Result<FeedGoods>> getGoodsDetail(@Query("id") String str);

        @GET("goods/goodsFeedList")
        Observable<Result<List<Entity>>> getGoodsFeedList(@Query("type") String str, @Query("id") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("goods/searchHotWords")
        Observable<Result<String>> getGoodsSearchHotWords();

        @GET("main/headline")
        Observable<Result<List<Entity>>> getHeadlineList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("apk/downloadVersionList")
        Observable<Result<List<VersionApp>>> getHistoryAppList(@Query("id") String str);

        @GET("topic/hotFeedList")
        Observable<Result<List<Entity>>> getHotFeedList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("feed/hotReplyList")
        Observable<Result<List<FeedReply>>> getHotFeedReplyList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("discussMode") int i2);

        @GET("main/hotSearchWords")
        Observable<Result<String>> getHotSearchKeywords();

        @GET("device/httpInfo")
        Observable<ResponseBody> getHttpInfo();

        @GET("device/ip")
        Observable<Result<String>> getIpAddress();

        @GET("main/updateList")
        Observable<Result<List<Entity>>> getLatestAppList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @POST("live/disallowUserList")
        Observable<Result<List<LiveUser>>> getLiveBannedUserList(@Query("liveId") String str, @Query("disallowType") int i, @Query("page") int i2, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("live/detail")
        Observable<Result<Live>> getLiveDetail(@Query("id") String str);

        @GET("live/messageList")
        Observable<Result<List<Entity>>> getLiveMessageList(@Query("id") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("live/productFeedList")
        Observable<Result<List<Entity>>> getLiveProductList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("live/tagFeedList")
        Observable<Result<List<Entity>>> getLiveTopicList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("album/index")
        Observable<Result<List<Entity>>> getMainAlbumList(@Query("page") String str, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("main/init")
        Observable<Result<List<Entity>>> getMainInit();

        @GET("main/index")
        Observable<Result<List<Entity>>> getMainList();

        @GET("user/dyhSubscribe")
        Observable<Result<List<Entity>>> getMainUserFollowDyhList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("main/indexV8")
        Observable<Result<List<Entity>>> getMainV8List(@Query("page") int i, @Query("firstLaunch") int i2, @Query("installTime") String str, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("product/mediaList")
        Observable<Result<List<ProductMedia>>> getMediaList(@Query("id") String str, @Query("type") String str2, @Query("is_recommend") int i, @Query("page") int i2, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("message/list")
        Observable<Result<List<Entity>>> getMessageList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("topic/mixFeedList")
        Observable<Result<List<Entity>>> getMixFeedList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/blackList")
        Observable<Result<List<Entity>>> getMyBlackListUser(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/editorDyhList")
        Observable<Result<List<Entity>>> getMyEditorDyhList(@Query("showNews") int i, @Query("showType") int i2, @Query("page") int i3, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/ignoreList")
        Observable<Result<List<User>>> getMyIgnoreListUser(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/limitList")
        Observable<Result<List<User>>> getMyLimitListUser(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("main/checkHeadlineCount")
        Observable<Result<Integer>> getNewHeadlineCount(@Query("firstItem") String str);

        @GET("apk/newestList")
        Observable<Result<List<Entity>>> getNewestAppList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("page/dataList")
        Observable<Result<List<NodeRating>>> getNodeRatingList(@Query("url") String str, @Query("targetType") String str2, @Query("targetId") String str3, @Query("targetVersion") String str4, @Query("uid") String str5, @Query("ratingType") String str6, @Query("star") String str7, @Query("buyStatus") Integer num, @Query("isOwner") Integer num2, @Query("page") int i, @Query("firstItem") String str8, @Query("lastItem") String str9);

        @GET("notification/atCommentMeList")
        Observable<Result<List<Entity>>> getNotificationAtCommentMeList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("notification/atMeList")
        Observable<Result<List<Entity>>> getNotificationAtMeList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("notification/commentMeList")
        Observable<Result<List<Entity>>> getNotificationCommmentMeList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("notification/feedLikeList")
        Observable<Result<List<Entity>>> getNotificationFeedLikeList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("notification/contactsFollowList")
        Observable<Result<List<Entity>>> getNotificationFollowMeList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("notification/list")
        Observable<Result<List<Entity>>> getNotificationList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("page/dataList")
        Observable<Result<List<Entity>>> getPearGoodsList(@Query("url") String str, @Query("userIdType") String str2, @Query("userId") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("topic/deviceFeedList")
        Observable<Result<List<Entity>>> getPhoneTopicDetail(@Query("tag") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("listType") String str4, @Query("blockStatus") int i2);

        @GET("feed/pictureCategoryList")
        Observable<Result<List<PicCategory>>> getPicCategoryList();

        @GET("picture/recommendList")
        Observable<Result<List<Entity>>> getPictureList(@Query("type") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("picture/list")
        Observable<Result<List<Entity>>> getPictureTagList(@Query("tag") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @FormUrlEncoded
        @POST("player/getUrl")
        Observable<Result<VideoUrls>> getPlayerUrl(@Field("params") String str);

        @GET("product/brandList")
        Observable<Result<List<ProductBrand>>> getProductBrandList();

        @POST("product/buyList")
        Observable<Result<List<User>>> getProductBuyList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("product/categoryList")
        Observable<Result<List<ProductBrand>>> getProductCategoryList();

        @GET("product/config")
        Observable<Result<ProductConfig>> getProductConfig(@Query("id") String str);

        @GET("erShou/config")
        Observable<Result<List<Entity>>> getProductConfig(@Query("ershouTypeId") String str, @Query("ershou_deal_type") String str2, @Query("productId") String str3);

        @GET("product/detail")
        Observable<Result<Product>> getProductDetail(@Query("id") String str);

        @GET("product/feedList")
        Observable<Result<List<Entity>>> getProductFeedList(@Query("id") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @POST("product/followList")
        Observable<Result<List<User>>> getProductFollowList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("product/productList")
        Observable<Result<List<Entity>>> getProductSeries(@Query("id") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @POST("product/wishList")
        Observable<Result<List<User>>> getProductWishList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("apk/qr")
        Observable<Result<ServiceApp>> getQRCodeResult(@Query("id") String str);

        @GET("question/detail")
        Observable<Result<Feed>> getQuestionDetail(@Query("id") String str);

        @GET("question/followList ")
        Observable<Result<List<Entity>>> getQuestionFollowerList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("question/list")
        Observable<Result<List<Entity>>> getQuestionList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("apk/realRankList")
        Observable<Result<List<Entity>>> getRankAppList(@Query("apkType") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/ratingList")
        Observable<Result<List<Entity>>> getRatingList(@Query("uid") String str, @Query("type") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("apk/ratingUserList")
        Observable<Result<List<RelatedData>>> getRatingUserList(@Query("id") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("topic/recentFeedList")
        Observable<Result<List<Entity>>> getRecentFeedList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/recentHistoryList")
        Observable<Result<List<Entity>>> getRecentHistoryList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("apk/recommendList")
        Observable<Result<List<Entity>>> getRecommendAppList(@Query("apkType") String str, @Query("title") String str2, @Query("subTitle") String str3, @Query("action") String str4, @Query("page") int i, @Query("firstItem") String str5, @Query("lastItem") String str6);

        @GET("apk/search")
        Observable<Result<List<Entity>>> getRelatedAppListWithKeyword(@Query("q") String str, @Query("apkType") String str2, @Query("searchType") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("feed/relatedQuestion")
        Observable<Result<List<Entity>>> getRelatedQuestion(@Query("title") String str);

        @GET("erShou/brandList")
        Observable<Result<List<ProductBrand>>> getSecondHandProductBrandList();

        @GET("erShou/productList")
        Observable<Result<List<Entity>>> getSecondHandProductSeries(@Query("id") String str, @Query("listType") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("feed/spamFeedList?type=feed")
        Observable<Result<List<Entity>>> getSpamFeedList(@Query("channel") String str, @Query("spamType") String str2, @Query("subType") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("feed/spamFeedList?type=feed_reply")
        Observable<Result<List<Entity>>> getSpamFeedReplyList(@Query("channel") String str, @Query("spamType") String str2, @Query("subType") String str3, @Query("page") int i, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("main/suggestSearchWords")
        Observable<Result<String>> getSuggestSearchKeywords(@Query("q") String str, @Query("type") String str2);

        @GET("search/suggestSearchWordsNew")
        Observable<Result<List<Entity>>> getSuggestSearchKeywordsNew(@Query("searchValue") String str, @Query("type") String str2);

        @GET("topic/tagFeedList")
        Observable<Result<List<Entity>>> getTagFeedList(@Query("tag") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("topic/tagFeedList")
        Observable<Result<List<Entity>>> getTagFeedList(@Query("tag") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("blockStatus") int i2);

        @GET("topic/tagFeedList")
        Observable<Result<List<Entity>>> getTagFeedList(@Query("tag") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("listType") String str4, @Query("blockStatus") int i2);

        @GET("feed/targetInfo")
        Observable<Result<Entity>> getTargetInfo(@Query("targetType") String str, @Query("targetId") String str2);

        @GET("topic/newTagDetail")
        Observable<Result<Entity>> getTopicCompatProduct(@Query("tag") String str);

        @GET("topic/tagDetail")
        Observable<Result<Topic>> getTopicDetail(@Query("tag") String str);

        @POST("topic/followList")
        Observable<Result<List<User>>> getTopicFollowList(@Query("tag") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("topic/tagList")
        Observable<Result<List<Entity>>> getTopicList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("topic/tagList")
        Observable<Result<List<Topic>>> getTopicTagList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @FormUrlEncoded
        @POST("player/getInfo")
        Observable<Result<String>> getUrlVideoInfo(@Field("url") String str);

        @GET("user/albumlist")
        Observable<Result<List<Entity>>> getUserAlbumList(@Query("uid") String str, @Query("pageSize") int i);

        @GET("user/albumlist")
        Observable<Result<List<Entity>>> getUserAlbumList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/apkCommentList")
        Observable<Result<List<Entity>>> getUserApkCommentList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/apkFollowList")
        Observable<Result<List<Entity>>> getUserApkFollowList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/forumFollowList")
        Observable<Result<List<Entity>>> getUserAppForumsFollowList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("collection/list")
        Observable<Result<List<Entity>>> getUserCollectionList(@Query("uid") String str, @Query("showDefault") int i, @Query("page") int i2, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/count")
        Observable<Result<UserCount>> getUserCount(@Query("uid") String str);

        @GET("user/discoveryList")
        Observable<Result<List<Entity>>> getUserDiscoveryList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/dyhList")
        Observable<Result<List<Entity>>> getUserDyhList();

        @GET("user/fansList")
        Observable<Result<List<Entity>>> getUserFansList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/feedList")
        Observable<Result<List<Entity>>> getUserFeedList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("showAnonymous") int i2, @Query("isIncludeTop") int i3, @Query("block_status") Integer num, @Query("showDoing") Integer num2);

        @GET("user/dyhFollowList")
        Observable<Result<List<Entity>>> getUserFollowDyhList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/followList")
        Observable<Result<List<Entity>>> getUserFollowerList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/followTagList")
        Observable<Result<List<Topic>>> getUserFollowerTopicList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/giftList")
        Observable<Result<List<Gift>>> getUserGiftList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/hitHistoryList")
        Observable<Result<List<Entity>>> getUserHitHistory(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/htmlFeedList")
        Observable<Result<List<Entity>>> getUserHtmlFeedList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/likeList")
        Observable<Result<List<Entity>>> getUserLikeList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("picture/userPictures")
        Observable<Result<List<Entity>>> getUserPictureList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/profile")
        Observable<Result<UserProfile>> getUserProfile(@Query("uid") String str, @Query("installTime") String str2);

        @GET("user/questionAndAnswerList")
        Observable<Result<List<Entity>>> getUserQuestionAndAnswerList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/replyList")
        Observable<Result<List<Entity>>> getUserReplyList(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("block_status") Integer num);

        @GET("user/replyToMeList")
        Observable<Result<List<Entity>>> getUserReplyToMeList(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @GET("user/spaceHomeTab")
        Observable<Result<List<Entity>>> getUserSpaceHomeTab(@Query("uid") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("user/space")
        Observable<Result<UserProfile>> getUserSpaceProfile(@Query("uid") String str);

        @GET("user/spamWordList")
        Observable<ResponseBody> getUserSpamWordList();

        @GET("vote/commentList")
        Observable<Result<List<Entity>>> getVoteCommentList(@Query("fid") String str, @Query("extra_key") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("vote/userList")
        Observable<Result<List<Entity>>> getVoteUserList(@Query("id") String str, @Query("option_id") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("goods/search")
        Observable<Result<List<Entity>>> goodsSearch(@Query("keyword") String str, @Query("sortName") String str2, @Query("sort") String str3, @Query("isCoupon") int i, @Query("page") int i2, @Query("firstItem") String str4, @Query("lastItem") String str5);

        @GET("search?type=hotSearch")
        Observable<ResponseBody> hotSearch(@Query("refresh") String str, @Query("returnType") String str2);

        @POST("dyh/includeFeed")
        Observable<Result<String>> includFeed(@Query("dyhId") String str, @Query("feedId") String str2, @Query("type") int i);

        @POST("question/inviteAnswer")
        @Multipart
        Observable<Result<String>> inviteUserToAnswer(@Part("uid") String str, @Part("questionId") String str2);

        @POST("album/like")
        Observable<Result<Integer>> likeAlbum(@Query("id") String str);

        @FormUrlEncoded
        @POST("collection/like")
        Observable<Result<Integer>> likeCollection(@Field("id") String str);

        @POST("feed/like")
        Observable<Result<LikeResult>> likeFeed(@Query("id") String str, @Query("detail") int i);

        @POST("feed/likeReply")
        Observable<Result<String>> likeReply(@Query("id") String str);

        @GET("account/loadConfig")
        Observable<Result<List<Entity>>> loadCardConfig(@Query("key") String str);

        @GET("account/loadConfig")
        Observable<ResponseBody> loadConfig(@Query("key") String str);

        @GET("account/loadConfig")
        Observable<Result<List<ConfigPage>>> loadConfig(@Query("key") String str, @Query("reSet") int i);

        @POST("discovery/loadDiscoveryInfo")
        Observable<Result<DiscoveryQuery>> loadDiscoveryInfo(@Query("query") String str);

        @FormUrlEncoded
        @POST("feed/loadShareUrl")
        Observable<Result<ShareFeedInfo>> loadShareUrl(@Field("message") String str, @Query("url") String str2, @Query("packageName") String str3);

        @POST("feed/loadShareUrl")
        Observable<Result<Entity>> loadShareUrlV11(@Query("url") String str);

        @FormUrlEncoded
        @POST("feed/loadShareUrl")
        Observable<Result<Entity>> loadShareUrlV11(@Query("url") String str, @Field("html_url") String str2, @Field("html_content") String str3);

        @GET("message/read")
        Observable<Result<NotifyCount>> markConversationRead(@Query("ukey") String str);

        @FormUrlEncoded
        @POST("callback/imageError")
        Observable<Result<String>> markImageError(@Field("imageUrl") String str, @Field("httpStatus") String str2, @Field("type") String str3);

        @POST("message/uploadImage")
        Observable<ResponseBody> messageUploadImage(@Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("collection/moveItem")
        Observable<Result<String>> moveToCollection(@Field("id") String str, @Field("colId") String str2);

        @GET("account/myPageCardManage")
        Observable<ResponseBody> myPageCardManage(@Query("key") String str);

        @POST("discovery/newDiscovery")
        Observable<Result<Integer>> newDiscovery(@Body RequestBody requestBody);

        @POST("feed/newShareFeed")
        Observable<Result<Feed>> newShareFeed(@Body RequestBody requestBody);

        @POST("dyhArticle/block")
        Observable<Result<String>> onArticleBlock(@Query("id") String str);

        @POST("dyhArticle/delete")
        Observable<Result<String>> onArticleDelete(@Query("id") String str);

        @POST("dyhArticle/recommend")
        Observable<Result<String>> onArticleRecommend(@Query("id") String str);

        @POST("dyhArticle/remove")
        Observable<Result<String>> onArticleRemove(@Query("id") String str, @Query("type") int i, @Query("dyhId") String str2);

        @POST("dyhArticle/unBlock")
        Observable<Result<String>> onArticleUnBlock(@Query("id") String str);

        @POST("dyhArticle/unRecommend")
        Observable<Result<String>> onArticleUnRecommend(@Query("id") String str);

        @GET("erShou/checkAgree")
        Observable<Result<Integer>> onCheckAgree();

        @POST("dyhArticle/stick")
        Observable<Result<String>> onStick(@Query("id") String str, @Query("type") int i);

        @FormUrlEncoded
        @POST("feed/onlyHomeSelf")
        Observable<Result<String>> onlyHomeSelf(@Field("id") String str);

        @FormUrlEncoded
        @POST("upload/ossUploadPrepare")
        Observable<Result<JSONObject>> ossUploadPrepare(@Field("uploadBucket") String str, @Field("uploadDir") String str2, @Field("is_anonymous") int i, @Field("uploadFileList") String str3);

        @GET("device/ping")
        Observable<Result<String>> pingRequest();

        @POST("apk/comment")
        Observable<Result<Feed>> postApkComment(@Query("id") String str, @Body RequestBody requestBody);

        @POST("appForum/newComment")
        Observable<Result<Feed>> postAppForumComment(@Query("id") String str, @Body RequestBody requestBody);

        @POST("feed/reply")
        Observable<Result<FeedReply>> postFeedReply(@Query("id") String str, @Query("type") String str2, @Body RequestBody requestBody);

        @POST("live/newMessage")
        Observable<Result<List<LiveMessage>>> postLiveMessage(@Body RequestBody requestBody);

        @POST("feed/newFeed")
        Observable<Result<Feed>> postNewFeed(@Body RequestBody requestBody);

        @POST("picture/newPicture")
        Observable<Result<Feed>> postNewPicture(@Body RequestBody requestBody);

        @GET("apk/rating")
        Observable<Result<Map<String, String>>> ratingApp(@Query("id") String str, @Query("value") int i);

        @GET("message/receive")
        Observable<Result<List<Entity>>> receiveLongMessage(@Query("id") String str);

        @GET("message/receive")
        Observable<Result<Message>> receiveLongMessageOld(@Query("id") String str);

        @GET("message/recentChatUser")
        Observable<Result<List<Entity>>> recentChatUser(@Query("page") int i, @Query("firstItem") String str, @Query("lastItem") String str2);

        @POST("album/recommend")
        Observable<Result<String>> recommendAlbum(@Query("id") String str);

        @POST("feed/spamRefuse?type=feed")
        Observable<Result<String>> refuseSpamFeed(@Query("id") String str, @Query("time") long j);

        @POST("feed/spamRefuse?type=reply")
        Observable<Result<String>> refuseSpamFeedReply(@Query("id") String str, @Query("time") long j);

        @FormUrlEncoded
        @POST("collection/removeItem")
        Observable<Result<String>> removeCollectionItem(@Field("itemId") String str);

        @POST("user/removeFromBlackList")
        Observable<Result<String>> removeFromBlackList(@Query("uid") String str);

        @POST("feed/removeFromEditorChoice")
        Observable<Result<String>> removeFromEditorChoice(@Query("feedId") String str, @Query("template") String str2);

        @POST("feed/removeFromHeadline")
        Observable<Result<String>> removeFromHeadline(@Query("feedId") String str);

        @POST("feed/removeFromHeadlineV8")
        Observable<Result<String>> removeFromHeadlineV8(@Query("feedId") String str, @Query("template") String str2);

        @POST("user/removeFromIgnoreList")
        Observable<Result<String>> removeFromIgnoreList(@Query("uid") String str);

        @POST("user/removeFromLimitList")
        Observable<Result<String>> removeFromLimitList(@Query("uid") String str);

        @FormUrlEncoded
        @POST("user/removeFromTopRecentHistory")
        Observable<Result<String>> removeFromTopRecentHistory(@Field("id") String str);

        @GET("message/removeTop")
        Observable<Result<String>> removeTop(@Query("ukey") String str);

        @FormUrlEncoded
        @POST("feed/removeTopContentFromNode")
        Observable<Result<String>> removeTopContentFromNode(@Field("nodeType") String str, @Field("nodeId") String str2, @Field("url") String str3);

        @FormUrlEncoded
        @POST("collection/removeUnUseItem")
        Observable<Result<String>> removeUnUseItem(@Field("colId") String str);

        @GET("report/addSimText")
        Observable<Result<String>> reportAddSimText(@Query("id") String str, @Query("type") String str2);

        @FormUrlEncoded
        @POST("apk/reportCoupon")
        Observable<ResponseBody> reportCoupon(@Field("extraAnalysisData") String str, @Field("index") int i, @Field("apkId") String str2);

        @FormUrlEncoded
        @POST("apk/reportExposure")
        Observable<ResponseBody> reportExposure(@Field("data") String str);

        @FormUrlEncoded
        @POST("apk/downloadReport?reportType=hijack")
        Observable<ResponseBody> reportHijack(@Field("apkName") String str, @Field("downloadUrl") String str2, @Field("reportDownloadUrl") String str3, @Field("reportPackageName") String str4, @Field("reportTitle") String str5, @Field("reportVersionName") String str6, @Field("reportVersionCode") int i);

        @FormUrlEncoded
        @POST("sponsor/close")
        Observable<ResponseBody> reportSponsorClose(@Field("show_ad_id") String str, @Field("ad_type") String str2, @Field("ad_access_id") String str3, @Field("ad_template_id") String str4, @Field("title") String str5, @Field("desc") String str6, @Field("pics") String str7, @Field("info") String str8, @Field("reason") int i);

        @FormUrlEncoded
        @POST("apk/downloadReport?reportType=unknown")
        Observable<ResponseBody> reportUnknown(@Field("apkName") String str, @Field("downloadUrl") String str2, @Field("reportDownloadUrl") String str3);

        @FormUrlEncoded
        @POST("account/requestValidate")
        Observable<Result<String>> requestValidate(@Field("type") String str, @Field("code") String str2, @Field("mobile") String str3, @Field("idcard") String str4, @Field("name") String str5);

        @GET("appForum/search")
        Observable<Result<List<Entity>>> searchAppForumList(@Query("q") String str, @Query("apkType") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("comment/search")
        Observable<Result<List<Entity>>> searchComment(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("discovery/search")
        Observable<Result<List<Entity>>> searchDiscovery(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("feed/search")
        Observable<Result<List<Entity>>> searchFeed(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("question/search")
        Observable<Result<List<Feed>>> searchQuestion(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("feed/searchTag")
        Observable<Result<List<Entity>>> searchTopic(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("recentIds") String str4);

        @GET("user/search")
        Observable<Result<List<Entity>>> searchUser(@Query("q") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3);

        @GET("{feedType}/search")
        Observable<Result<List<Entity>>> searchWithFeedType(@Path("feedType") String str, @Query("q") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4);

        @GET("search?type=ershou")
        Observable<Result<List<Entity>>> secondHandSearch(@Query("sort") String str, @Query("searchValue") String str2, @Query("status") String str3, @Query("deal_type") String str4, @Query("city_code") String str5, @Query("is_link") String str6, @Query("exchange_type") String str7, @Query("ershou_type") String str8, @Query("product_id") String str9, @Query("page") int i, @Query("firstItem") String str10, @Query("lastItem") String str11);

        @FormUrlEncoded
        @POST("account/sendChangeMobileCode")
        Observable<Result<String>> sendChangeMobileCode(@Field("mobile") String str, @Field("country") String str2, @Field("code") String str3);

        @POST("message/send")
        @Multipart
        Observable<Result<List<Entity>>> sendMessage(@Query("uid") String str, @Query("quick_reply") int i, @Part("message") String str2, @Part("message_pic") String str3, @Part("message_extra") String str4);

        @POST("message/send")
        @Multipart
        Observable<Result<List<Entity>>> sendMessage(@Query("uid") String str, @Part("message") String str2, @Part("message_pic") String str3, @Part("message_extra") String str4, @Part("message_card") String str5);

        @FormUrlEncoded
        @POST("message/send")
        Observable<Result<Message>> sendMessage2Old(@Field("uid") String str, @Field("message") String str2, @Field("message_pic") String str3, @Field("message_extra") String str4);

        @POST("message/send")
        @Multipart
        Observable<Result<Message>> sendMessageOld(@Query("uid") String str, @Query("quick_reply") int i, @Part("message") String str2, @Part("message_pic") String str3, @Part("message_extra") String str4);

        @FormUrlEncoded
        @POST("account/sendValidateCode")
        Observable<Result<String>> sendValidateCode(@Field("type") String str, @Field("mobile") String str2, @Field("idcard") String str3, @Field("name") String str4);

        @POST("feed/shareCallback")
        @Multipart
        Observable<Result<Integer>> shareCallback(@Query("id") String str, @Query("type") String str2, @Part("shareRequestType") String str3, @Part("shareResponseMsg") String str4, @Part("time") String str5);

        @GET("message/showImage")
        Observable<ResponseBody> showImage(@Query("id") String str, @Query("type") String str2);

        @FormUrlEncoded
        @POST("apk/downloadStat")
        Observable<Result<Integer>> statDownload(@Query("pn") String str, @Query("aid") String str2, @Query("extra") String str3, @Query("ni") String str4, @Query("action") String str5, @Field("extraAnalysisData") String str6);

        @GET("search/searchSpotSuggest")
        Observable<Result<List<Entity>>> suggestSpotSearch(@Query("type") String str, @Query("page") int i, @Query("firstItem") String str2, @Query("lastItem") String str3, @Query("pageContext") String str4);

        @FormUrlEncoded
        @POST("collection/topItem")
        Observable<Result<String>> topCollectionItem(@Field("itemId") String str, @Field("top") int i);

        @GET("search")
        Observable<Result<List<Entity>>> typeSearch(@Query("type") String str, @Query("searchValue") String str2, @Query("page") int i, @Query("firstItem") String str3, @Query("lastItem") String str4, @Query("showAnonymous") int i2, @Query("pageContext") String str5);

        @POST("album/unFavorite")
        Observable<Result<Integer>> unFavoriteAlbum(@Query("id") String str, @Query("targetType") String str2);

        @POST("feed/unFavorite")
        Observable<Result<Integer>> unFavoriteFeed(@Query("id") String str, @Query("targetType") String str2);

        @POST("picture/unFavorite")
        Observable<Result<String>> unFavoritePic(@Query("id") String str, @Query("targetType") String str2);

        @FormUrlEncoded
        @POST("collection/unFollow")
        Observable<Result<Integer>> unFollowCollection(@Field("id") String str);

        @POST("dyh/unFollow")
        Observable<Result<String>> unFollowDyh(@Query("dyhId") String str);

        @GET("question/unFollow")
        Observable<Result<Integer>> unFollowQuestion(@Query("id") String str);

        @GET("feed/unFollowTag")
        Observable<Result<Integer>> unFollowTag(@Query("tag") String str);

        @FormUrlEncoded
        @POST("collection/unLike")
        Observable<Result<Integer>> unLikeCollection(@Field("id") String str);

        @POST("feed/unlinkToApk")
        Observable<Result<String>> unLinkToApk(@Query("id") String str);

        @FormUrlEncoded
        @POST("feed/unOnlyHomeSelf ")
        Observable<Result<String>> unOnlyHomeSelf(@Field("id") String str);

        @FormUrlEncoded
        @POST("live/unDisallowUser")
        Observable<Result<String>> undisallowLiveUser(@Field("liveId") String str, @Field("uid") String str2, @Field("disallowType") int i);

        @FormUrlEncoded
        @POST("apk/unFavorite")
        Observable<Result<Integer>> unfavoriteApp(@Field("id") String str, @Field("targetType") String str2);

        @GET("apk/unfollow")
        Observable<Result<Map<String, String>>> unfollowApp(@Query("id") String str);

        @GET("appForum/unfollow")
        Observable<Result<Map<String, String>>> unfollowAppForum(@Query("id") String str);

        @GET("live/unFollow")
        Observable<Result<String>> unfollowLive(@Query("id") String str);

        @POST("user/unfollow")
        Observable<Result<Integer>> unfollowUser(@Query("uid") String str);

        @POST("album/unlike")
        Observable<Result<Integer>> unlikeAlbum(@Query("id") String str);

        @POST("feed/unlike")
        Observable<Result<LikeResult>> unlikeFeed(@Query("id") String str, @Query("detail") int i);

        @POST("feed/unLikeReply")
        Observable<Result<String>> unlikeReply(@Query("id") String str);

        @GET("apk/unrating")
        Observable<Result<Map<String, String>>> unratingApp(@Query("id") String str);

        @GET("feed/unsetMessageStatus")
        Observable<Result<String>> unsetMessageStatus(@Query("id") String str);

        @POST("collection/update")
        Observable<Result<Collection>> updateCollection(@Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("account/updateConfig")
        Observable<Result<String>> updateConfig(@Field("key") String str, @Field("value") String str2);

        @FormUrlEncoded
        @POST("feed/updateEditorTitle")
        Observable<Result<String>> updateEditorTitle(@Field("feedId") String str, @Field("editorTitle") String str2);

        @FormUrlEncoded
        @POST("account/updateConfig")
        Observable<Result<Integer>> updateHomeTabConfig(@FieldMap HashMap<String, String> hashMap);

        @FormUrlEncoded
        @POST("account/updateConfig")
        Observable<Result<String>> updateTitleConfig(@Field("key") String str, @Field("value") String str2);

        @FormUrlEncoded
        @POST("vote/updateRecommendComment")
        Observable<Result<String>> updateVoteRecommendComment(@Field("vote_id") String str, @Field("comment_id") String str2, @Field("type") int i);

        @POST("collection/uploadImage")
        Observable<Result<String>> uploadCollectionImage(@Query("fieldName") String str, @Query("uploadDir") String str2, @Query("fileMd5") String str3, @Body RequestBody requestBody);

        @POST("feed/uploadImage")
        Observable<Result<String>> uploadImage(@Query("fieldName") String str, @Query("uploadDir") String str2, @Query("fileMd5") String str3, @Body RequestBody requestBody);

        @POST("live/uploadImage")
        Observable<Result<String>> uploadLiveImage(@Query("fieldName") String str, @Query("uploadDir") String str2, @Query("fileMd5") String str3, @Query("liveId") String str4, @Body RequestBody requestBody);

        @FormUrlEncoded
        @POST("apk/downloadVerify")
        Observable<Result<String>> verifyDownloadUrl(@Field("apkName") String str, @Field("requestUrl") String str2, @Field("downloadUrl") String str3);
    }

    public CoolMarketService(String str, Gson gson) {
        this.remoteService = newRemoteService(str, gson);
    }

    public RemoteService getRemoteService() {
        return this.remoteService;
    }

    private RemoteService newRemoteService(String str, Gson gson) {
        return (RemoteService) new Retrofit.Builder().baseUrl(str).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(ModelConverterFactory.create(gson)).addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create()).client(HttpClientFactory.getInstance().getCoolMarketHttpClient()).build().create(RemoteService.class);
    }
}
