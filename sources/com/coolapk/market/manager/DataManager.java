package com.coolapk.market.manager;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.coolapk.market.download.DownloadJob;
import com.coolapk.market.download.Downloader;
import com.coolapk.market.download.NetworkExecutor;
import com.coolapk.market.download.OnDownloadListener;
import com.coolapk.market.local.AppStore;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.local.Db;
import com.coolapk.market.local.DbConst;
import com.coolapk.market.local.DbHelper;
import com.coolapk.market.local.DbOpenHelper;
import com.coolapk.market.local.DownloadStore;
import com.coolapk.market.local.FeedDraftCache;
import com.coolapk.market.local.InstallStore;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.local.UninstallStore;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.Article;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.DeviceInfo;
import com.coolapk.market.model.DiscoveryQuery;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedDraft;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.FileDetail;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.ImInfo;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.Library;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.model.PatchInfo;
import com.coolapk.market.model.PermissionItem;
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
import com.coolapk.market.model.UninstallState;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserCount;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.model.Vote;
import com.coolapk.market.network.IOSSClientWrap;
import com.coolapk.market.network.Result;
import com.coolapk.market.processor.ExpectPackageException;
import com.coolapk.market.processor.FileProcessor;
import com.coolapk.market.processor.FileProcessorFactory;
import com.coolapk.market.processor.Md5NotMatchException;
import com.coolapk.market.processor.PackageParseException;
import com.coolapk.market.processor.ProcessorCallback;
import com.coolapk.market.processor.SamePackageException;
import com.coolapk.market.processor.SignaturesException;
import com.coolapk.market.processor.UnsupportedFileException;
import com.coolapk.market.remote.CoolMarketService;
import com.coolapk.market.remote.TypeAdapterFactory;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.EntityConvertUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.RootTools;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

public class DataManager {
    public static final String APK_TYPE_ALBUM = "3";
    public static final String APK_TYPE_ALL = "0";
    public static final String APK_TYPE_APP = "1";
    public static final String APK_TYPE_GAME = "2";
    public static final String NOTIFICATION_TYPE_ALL = "all";
    public static final String NOTIFICATION_TYPE_AT_COMMENT_ME = "atcommentme";
    public static final String NOTIFICATION_TYPE_AT_ME = "atme";
    public static final String NOTIFICATION_TYPE_CONTACT_FOLLOW = "contacts_follow";
    public static final String NOTIFICATION_TYPE_FEED_LIKE = "feedlike";
    public static final String NOTIFICATION_TYPE_MESSAGE = "message";
    public static final String NOTIFICATION_TYPE_NOTIFICATION = "notification";
    private static volatile DataManager ourInstance;
    private Application appContext;
    private AppStore appStore;
    private CoolMarketService.RemoteService coolMarketService;
    private DataConfig dataConfig;
    private DbHelper database;
    private DownloadStartInterceptor downloadStartInterceptor;
    private DownloadStore downloadStore;
    private FeedDraftCache feedDraftCache;
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapterFactory(TypeAdapterFactory.create()).create();
    private InstallStore installStore;
    private LoginSession loginSession;
    private Bundle metaData;
    private IOSSClientWrap ossClientWrap;
    private PreferencesUtils preferencesUtils;
    private UninstallStore uninstallStore;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (ourInstance == null) {
            synchronized (DataManager.class) {
                if (ourInstance == null) {
                    ourInstance = new DataManager();
                }
            }
        }
        return ourInstance;
    }

    public void init(Application application, DataConfig dataConfig2, IOSSClientWrap iOSSClientWrap) {
        if (dataConfig2 != null) {
            this.appContext = application;
            this.ossClientWrap = iOSSClientWrap;
            this.dataConfig = dataConfig2;
            this.preferencesUtils = new PreferencesUtils(application, dataConfig2.getPreferencesName());
            this.database = new DbHelper(new DbOpenHelper(application, this.dataConfig.getDatabaseName(), this.dataConfig.getDatabaseVersion()));
            this.loginSession = new LoginSession(this.preferencesUtils);
            this.coolMarketService = new CoolMarketService(this.dataConfig.getApiEndpoint(), this.gson).getRemoteService();
            this.downloadStore = new DownloadStore(this.database);
            this.installStore = new InstallStore();
            this.uninstallStore = new UninstallStore();
            this.appStore = new AppStore(this.database);
            this.feedDraftCache = new FeedDraftCache();
            this.metaData = dataConfig2.getMetaData();
            LogUtils.v("Init DataManager end", new Object[0]);
            return;
        }
        throw new RuntimeException("Config can not be NULL");
    }

    public DataConfig getDataConfig() {
        DataConfig dataConfig2 = this.dataConfig;
        if (dataConfig2 != null) {
            return dataConfig2;
        }
        throw new RuntimeException("You must invoke DataManager's init()");
    }

    public boolean getMetaDataBoolean(String str, boolean z) {
        Bundle bundle = this.metaData;
        return bundle == null ? z : bundle.getBoolean(str, z);
    }

    public float getMetaDataFloat(String str, float f) {
        Bundle bundle = this.metaData;
        return bundle == null ? f : bundle.getFloat(str, f);
    }

    public int getMetaDataInt(String str, int i) {
        Bundle bundle = this.metaData;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    public long getMetaDataLong(String str, long j) {
        Bundle bundle = this.metaData;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public String getMetaDataString(String str, String str2) {
        Bundle bundle = this.metaData;
        return bundle == null ? str2 : bundle.getString(str, str2);
    }

    public LoginSession getLoginSession() {
        return this.loginSession;
    }

    public Observable<Result<String>> getHotSearchKeywords() {
        return this.coolMarketService.getHotSearchKeywords();
    }

    public Observable<Result<String>> getSuggestSearchKeywords(String str, String str2) {
        return this.coolMarketService.getSuggestSearchKeywords(str, str2);
    }

    public Observable<Result<List<Entity>>> getSuggestSearchKeywordsNew(String str, String str2) {
        return this.coolMarketService.getSuggestSearchKeywordsNew(str, str2);
    }

    public Observable<Result<String>> deleteFeed(String str, int i) {
        return this.coolMarketService.deleteFeed(str, i);
    }

    public Observable<Result<String>> deleteFeed(String str) {
        return deleteFeed(str, 0);
    }

    public Observable<Result<String>> deleteHistoryFeed(String str, int i) {
        return this.coolMarketService.deleteHistoryFeed(str, i);
    }

    public Observable<Result<LikeResult>> likeFeed(String str, int i) {
        return this.coolMarketService.likeFeed(str, i);
    }

    public Observable<Result<LikeResult>> unlikeFeed(String str, int i) {
        return this.coolMarketService.unlikeFeed(str, i);
    }

    public Observable<Result<String>> likeReply(String str) {
        return this.coolMarketService.likeReply(str);
    }

    public Observable<Result<String>> unlikeReply(String str) {
        return this.coolMarketService.unlikeReply(str);
    }

    public Observable<Result<ServiceApp>> getAppFromQrCode(String str) {
        return this.coolMarketService.getAppFromQrCode(str);
    }

    public Observable<Result<String>> deleteFeedReply(String str, int i) {
        return this.coolMarketService.deleteFeedReply(str, i);
    }

    public Observable<Result<String>> deleteFeedReply(String str) {
        return this.coolMarketService.deleteFeedReply(str, 0);
    }

    public Observable<Result<List<Entity>>> getAppCategoryList(String str) {
        return this.coolMarketService.getAppCategoryList(str);
    }

    public Observable<Result<List<Entity>>> getUserFeedList(String str, int i, String str2, String str3, int i2, Integer num) {
        return this.coolMarketService.getUserFeedList(str, i, str2, str3, i2, 1, null, num);
    }

    public Observable<Result<List<Entity>>> getUserBlockedFeedList(String str, int i, String str2, String str3, int i2) {
        return this.coolMarketService.getUserFeedList(str, i, str2, str3, i2, 0, 1, null);
    }

    public Observable<Result<String>> getApkUrl(String str) {
        return this.coolMarketService.getApkUrl(str);
    }

    public Observable<Result<List<Entity>>> getUserLikeList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserLikeList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserHitHistory(int i, String str, String str2) {
        return this.coolMarketService.getUserHitHistory(i, str, str2);
    }

    public Observable<Result<String>> delAllHistory() {
        return this.coolMarketService.delAllHistory();
    }

    public Observable<Result<String>> deleteViewHistory(String str) {
        return this.coolMarketService.deleteViewHistory(str);
    }

    public Observable<Result<List<Entity>>> getCircleFeedList(int i, String str, String str2) {
        return this.coolMarketService.getCircleFeedList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getHotFeedList(int i, String str, String str2) {
        return this.coolMarketService.getHotFeedList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getUserFollowerList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserFollowerList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserFansList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserFansList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserSpaceHomeTab(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserSpaceHomeTab(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserApkCommentList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserApkCommentList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserDiscoveryList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserDiscoveryList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserApkFollowList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserApkFollowList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserReplyToMeList(int i, String str, String str2) {
        return this.coolMarketService.getUserReplyToMeList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getUserReplyList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserReplyList(str, i, str2, str3, null);
    }

    public Observable<Result<List<Entity>>> getBlockedUserReplyList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserReplyList(str, i, str2, str3, 1);
    }

    public Observable<Result<List<Entity>>> getRecentFeedList(int i, String str, String str2) {
        return this.coolMarketService.getRecentFeedList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getTagFeedList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getTagFeedList(str, i, str2, str3, 0);
    }

    public Observable<Result<List<Entity>>> getTagFeedList(String str, int i, String str2, String str3, int i2) {
        return this.coolMarketService.getTagFeedList(str, i, str2, str3, i2);
    }

    public Observable<Result<List<Entity>>> getTagFeedList(String str, int i, String str2, String str3, String str4) {
        return this.coolMarketService.getTagFeedList(str, i, str2, str3, str4, 0);
    }

    public Observable<Result<List<Entity>>> getTagFeedList(String str, int i, String str2, String str3, String str4, int i2) {
        return this.coolMarketService.getTagFeedList(str, i, str2, str3, str4, i2);
    }

    public Observable<Result<List<Entity>>> getPhoneTopicDetail(String str, int i, String str2, String str3, String str4) {
        return this.coolMarketService.getPhoneTopicDetail(str, i, str2, str3, str4, 0);
    }

    public Observable<Result<List<Entity>>> getPhoneTopicDetail(String str, int i, String str2, String str3, String str4, int i2) {
        return this.coolMarketService.getPhoneTopicDetail(str, i, str2, str3, str4, i2);
    }

    public Observable<Result<List<Entity>>> getAlbumList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAlbumList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getAlbumList(int i, String str, String str2, String str3) {
        return this.coolMarketService.getAlbumList(i, str, str2, str3);
    }

    public Observable<Result<List<Entity>>> getMainAlbumList(int i, String str, String str2) {
        CoolMarketService.RemoteService remoteService = this.coolMarketService;
        String valueOf = String.valueOf(i);
        if (i > 1) {
            str = "";
        }
        if (i <= 1) {
            str2 = "";
        }
        return remoteService.getMainAlbumList(valueOf, str, str2);
    }

    public Observable<Result<List<Entity>>> getUserAlbumList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserAlbumList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserAlbumList(String str, int i) {
        return this.coolMarketService.getUserAlbumList(str, i);
    }

    public Observable<Result<String>> reportAddSimText(String str, String str2) {
        return this.coolMarketService.reportAddSimText(str, str2);
    }

    public Observable<Result<List<Entity>>> getFeedListByType(String str, int i, String str2, String str3) {
        return this.coolMarketService.getFeedListByType(str, i, str2, str3);
    }

    public Observable<Result<Album>> getAlbumDetail(String str) {
        return this.coolMarketService.getAlbumDetail(str, "");
    }

    public Observable<Result<Album>> getAlbumDetail(String str, String str2) {
        return this.coolMarketService.getAlbumDetail(str, str2);
    }

    public Observable<Result<Integer>> followUser(String str) {
        return this.coolMarketService.followUser(str);
    }

    public Observable<Result<Integer>> unfollowUser(String str) {
        return this.coolMarketService.unfollowUser(str);
    }

    public Observable<Result<String>> apkOffLine(String str) {
        return this.coolMarketService.apkOffLine(str);
    }

    public Observable<Result<Integer>> favoriteFeed(String str) {
        return this.coolMarketService.favoriteFeed(str);
    }

    public Observable<Result<Integer>> unFavoriteFeed(String str, String str2) {
        return this.coolMarketService.unFavoriteFeed(str, str2);
    }

    public Observable<Result<ServiceApp>> getQRCodeResult(String str) {
        return this.coolMarketService.getQRCodeResult(str);
    }

    public Observable<Result<List<FeedReply>>> getAlbumReplyList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAlbumReplyList(str, i, str2, str3);
    }

    public Observable<Result<String>> createAlbum(String str, String str2) {
        return this.coolMarketService.createAlbum(str, str2);
    }

    public Observable<Result<Integer>> collectAlbum(String str) {
        return this.coolMarketService.favoriteAlbum(str);
    }

    public Observable<Result<Integer>> unFavorite(String str, String str2) {
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1412808770:
                if (str2.equals("answer")) {
                    c = 0;
                    break;
                }
                break;
            case -1165870106:
                if (str2.equals("question")) {
                    c = 1;
                    break;
                }
                break;
            case -732377866:
                if (str2.equals("article")) {
                    c = 2;
                    break;
                }
                break;
            case -577741570:
                if (str2.equals("picture")) {
                    c = 3;
                    break;
                }
                break;
            case -121207376:
                if (str2.equals("discovery")) {
                    c = 4;
                    break;
                }
                break;
            case -23096968:
                if (str2.equals("feedArticle")) {
                    c = 5;
                    break;
                }
                break;
            case 96796:
                if (str2.equals("apk")) {
                    c = 6;
                    break;
                }
                break;
            case 116079:
                if (str2.equals("url")) {
                    c = 7;
                    break;
                }
                break;
            case 3138974:
                if (str2.equals("feed")) {
                    c = '\b';
                    break;
                }
                break;
            case 3165170:
                if (str2.equals("game")) {
                    c = '\t';
                    break;
                }
                break;
            case 92896879:
                if (str2.equals("album")) {
                    c = '\n';
                    break;
                }
                break;
            case 112202875:
                if (str2.equals("video")) {
                    c = 11;
                    break;
                }
                break;
            case 950398559:
                if (str2.equals("comment")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case '\b':
            case 11:
            case '\f':
                return this.coolMarketService.unFavoriteFeed(str, str2);
            case 6:
            case '\t':
                return this.coolMarketService.unfavoriteApp(str, str2);
            case '\n':
                return this.coolMarketService.unFavoriteAlbum(str, str2);
            default:
                return Observable.error(new RuntimeException("Unsupport type: " + str2));
        }
    }

    public Observable<Result<String>> favoritePic(String str) {
        return this.coolMarketService.favoritePic(str);
    }

    public Observable<Result<String>> unFavoritePic(String str) {
        return this.coolMarketService.unFavoritePic(str, "picture");
    }

    public Observable<Result<Integer>> unFavoriteAlbum(String str, String str2) {
        return this.coolMarketService.unFavoriteAlbum(str, str2);
    }

    public Observable<Result<String>> addToHeadline(String str) {
        return this.coolMarketService.addToHeadline(str);
    }

    public Observable<Result<String>> removeFromHeadline(String str) {
        return this.coolMarketService.removeFromHeadline(str);
    }

    public Observable<Result<String>> addToHeadlineV8(String str, String str2) {
        return this.coolMarketService.addToHeadlineV8(str, str2);
    }

    public Observable<Result<String>> removeFromHeadlineV8(String str, String str2) {
        return this.coolMarketService.removeFromHeadlineV8(str, str2);
    }

    public Observable<Result<String>> addToEditorChoice(String str, String str2) {
        return this.coolMarketService.addToEditorChoice(str, str2);
    }

    public Observable<Result<String>> removeFromEditorChoice(String str, String str2) {
        return this.coolMarketService.removeFromEditorChoice(str, str2);
    }

    public Observable<Result<String>> onlyHomeSelf(String str) {
        return this.coolMarketService.onlyHomeSelf(str);
    }

    public Observable<Result<String>> unOnlyHomeSelf(String str) {
        return this.coolMarketService.unOnlyHomeSelf(str);
    }

    public Observable<Result<DiscoveryQuery>> loadDiscoveryInfo(String str) {
        return this.coolMarketService.loadDiscoveryInfo(str);
    }

    public Observable<Result<ShareFeedInfo>> loadShareUrl(String str, String str2, String str3) {
        return this.coolMarketService.loadShareUrl(str, str2, str3);
    }

    public Observable<Result<Entity>> loadShareUrlV11(String str) {
        return this.coolMarketService.loadShareUrlV11(str);
    }

    public Observable<Result<Entity>> loadShareUrlV11(String str, String str2, String str3) {
        return this.coolMarketService.loadShareUrlV11(str, str2, str3);
    }

    public Observable<Result<SimpleInfo>> feedCensor(String str) {
        return this.coolMarketService.feedCensor(str);
    }

    public Observable<Result<String>> editAlbum(String str, String str2, String str3) {
        return this.coolMarketService.editAlbum(str, str2, str3);
    }

    public Observable<Result<String>> delApkFromAlbum(String str, String str2) {
        return this.coolMarketService.delApkFromAlbum(str, str2);
    }

    public Observable<Result<AlbumItem>> checkApkIsInAlbum(String str, String str2) {
        return this.coolMarketService.checkApkIsInAlbum(str, str2);
    }

    public Observable<Result<String>> editApkDisplayOrder(String str, String str2) {
        return this.coolMarketService.editApkDisplayOrder(str, str2);
    }

    public Observable<Result<List<Entity>>> getApkRatingList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getApkRatingList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getRecommendAppList(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        return this.coolMarketService.getRecommendAppList(str, str2, str3, str4, i, str5, str6);
    }

    public Observable<Result<List<Entity>>> getCardSampleList(String str) {
        return this.coolMarketService.getCardSampleList(str);
    }

    public Observable<Result<List<Entity>>> getDataList(String str, String str2, String str3, int i, String str4, String str5, String str6) {
        return this.coolMarketService.getDataList(str, str2, str3, i, str4, str5, str6);
    }

    public Observable<Result<List<Entity>>> getPearGoodsList(String str, String str2, String str3, int i, String str4, String str5) {
        return this.coolMarketService.getPearGoodsList(str, str2, str3, i, str4, str5);
    }

    public Observable<Result<List<Entity>>> getNewestAppList(int i, String str, String str2) {
        return this.coolMarketService.getNewestAppList(i, str, str2);
    }

    public Observable<Result<List<RelatedData>>> getDiscovererList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getDiscovererList(str, i, str2, str3);
    }

    public Observable<Result<List<RelatedData>>> getRatingUserList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getRatingUserList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getDiscoveryList(int i, String str, String str2) {
        return this.coolMarketService.getDiscoveryList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getPictureList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getPictureList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getPictureTagList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getPictureTagList(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getUserPictureList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserPictureList(str, i, str2, str3);
    }

    public Observable<Result<String>> addToSplash(String str) {
        return this.coolMarketService.addToSplash(str);
    }

    public Observable<Result<List<Entity>>> getFavoriteList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getFavoriteList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getMixFeedList(int i, String str, String str2) {
        return this.coolMarketService.getMixFeedList(i, str, str2);
    }

    public Observable<Result<Map<String, String>>> unratingApp(String str) {
        return this.coolMarketService.unratingApp(str);
    }

    public Observable<Result<Integer>> statInstall(String str, String str2, String str3, boolean z, String str4) {
        return this.coolMarketService.statDownload(str, str2, str3, z ? "1" : "0", "install", str4);
    }

    public Observable<Result<Integer>> statUninstall(String str, String str2, String str3, String str4) {
        return this.coolMarketService.statDownload(str, str2, str3, null, "uninstall", str4);
    }

    public Observable<Result<Integer>> statDownloadComplete(String str, String str2, String str3, boolean z, String str4) {
        return this.coolMarketService.statDownload(str, str2, str3, z ? "1" : "0", "downloadComplete", str4);
    }

    public Observable<Result<List<Feed>>> getAppCommentList(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        return this.coolMarketService.getAppCommentList(str, null, i, str2, str3, i2, i3, str4);
    }

    public Observable<Result<List<Feed>>> getAppCommentList(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5) {
        return this.coolMarketService.getAppCommentList(str, str2, i, str3, str4, i2, i3, str5);
    }

    public Observable<Result<List<Feed>>> getAppBlockCommentList(String str, String str2, int i, String str3, String str4, String str5) {
        return this.coolMarketService.getAppCommentList(str, str2, i, str3, str4, 1, 0, str5);
    }

    public Observable<Result<String>> getGift(String str) {
        return this.coolMarketService.getGift(str);
    }

    public Observable<Result<List<Gift>>> getAllGiftList(int i, String str, String str2) {
        return this.coolMarketService.getAllGiftList(i, str, str2);
    }

    public Observable<Result<List<Gift>>> getUserGiftList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserGiftList(str, i, str2, str3);
    }

    public Observable<Result<List<Gift>>> getGiftListByApkId(String str, int i, String str2, String str3) {
        return this.coolMarketService.getGiftListByApkId(str, i, str2, str3);
    }

    public Observable<Result<String>> delUserGift(String str, String str2) {
        return this.coolMarketService.delUserGift(str, str2);
    }

    private long getFirstInstallTime() {
        try {
            return this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Observable<Result<List<Entity>>> getMainV8List(int i, String str, String str2) {
        int i2 = this.preferencesUtils.getInt("IS_COOLAPK_FIRST_LAUNCH", 1);
        if (i2 == 1) {
            this.preferencesUtils.edit().putInt("IS_COOLAPK_FIRST_LAUNCH", 0).apply();
        }
        return this.coolMarketService.getMainV8List(i, i2, String.valueOf(getFirstInstallTime()), str, str2);
    }

    public Observable<Result<List<Entity>>> getMainList() {
        return this.coolMarketService.getMainList();
    }

    public Observable<Result<Integer>> getNewHeadlineCount(String str) {
        return this.coolMarketService.getNewHeadlineCount(str);
    }

    public Observable<Result<List<Entity>>> getHeadlineList(int i, String str, String str2) {
        return this.coolMarketService.getHeadlineList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getDeveloperAppList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getDeveloperAppList(str, i, str2, str3);
    }

    public Observable<Result<String>> getIpAddress() {
        return this.coolMarketService.getIpAddress();
    }

    public Observable<Result<String>> pingRequest() {
        return this.coolMarketService.pingRequest();
    }

    public Observable<Result<List<Topic>>> getTopicTagList(int i, String str, String str2) {
        return this.coolMarketService.getTopicTagList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getTopicList(int i, String str, String str2) {
        return this.coolMarketService.getTopicList(i, str, str2);
    }

    public Observable<Result<List<Topic>>> getUserFollowerTopicList(int i, String str, String str2) {
        return this.coolMarketService.getUserFollowerTopicList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getLatestAppList(int i, String str, String str2) {
        return this.coolMarketService.getLatestAppList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getApkFeedList(int i, String str, String str2) {
        return this.coolMarketService.getApkFeedList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getAppList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAppList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getRankAppList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getRankAppList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getAppListWithCategory(String str, String str2, String str3, int i, String str4, String str5) {
        return this.coolMarketService.getAppListWithCategory(str, str2, str3, i, str4, str5);
    }

    public Observable<Result<List<PatchInfo>>> checkForUpgradeAppList(List<MobileApp> list, boolean z) {
        String str;
        JSONObject jSONObject = new JSONObject();
        Iterator<MobileApp> it2 = list.iterator();
        while (true) {
            str = "1";
            if (!it2.hasNext()) {
                break;
            }
            MobileApp next = it2.next();
            try {
                if (!next.isSystemApp()) {
                    str = "0";
                }
                jSONObject.put(next.getPackageName(), (str + "," + next.getVersionCode()) + "," + next.getApkMd5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        CoolMarketService.RemoteService remoteService = this.coolMarketService;
        if (!z) {
            str = "0";
        }
        return remoteService.checkForUpgradeAppList(encodeToString, str);
    }

    public Observable<Result<List<Entity>>> getAppListWithTag(String str, String str2, String str3, int i, String str4, String str5) {
        return this.coolMarketService.getAppListWithTag(str, str2, str3, i, str4, str5);
    }

    public Observable<Result<List<User>>> getAppFollowerList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAppFollowerList(str, i, str2, str3);
    }

    public Observable<Result<Map<String, String>>> ratingApp(String str, int i) {
        return this.coolMarketService.ratingApp(str, i);
    }

    public Observable<Result<Map<String, String>>> unfollowApp(String str) {
        return this.coolMarketService.unfollowApp(str);
    }

    public Observable<Result<Integer>> favoriteApp(String str) {
        return this.coolMarketService.favoriteApp(str);
    }

    public Observable<Result<Integer>> unfavoriteApp(String str, String str2) {
        str2.hashCode();
        if (str2.equals("1")) {
            return this.coolMarketService.unfavoriteApp(str, "apk");
        }
        if (!str2.equals("2")) {
            return Observable.empty();
        }
        return this.coolMarketService.unfavoriteApp(str, "game");
    }

    public Observable<Result<List<VersionApp>>> getHistoryAppList(String str) {
        return this.coolMarketService.getHistoryAppList(str);
    }

    public Observable<Result<List<ServiceApp>>> getAppListWithDeveloper(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAppListWithDeveloper(str, i, str2, str3);
    }

    public Observable<Result<Map<String, String>>> followApp(String str) {
        return this.coolMarketService.followApp(str);
    }

    public Observable<Result<DownloadInfo>> getAppDownloadInfo(String str) {
        return this.coolMarketService.getAppDownloadInfo(str);
    }

    public Observable<Result<List<DownloadInfo>>> getAppDownloadInfoList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append(",");
        }
        return this.coolMarketService.getAppDownloadInfoList(sb.toString());
    }

    public Observable<Result<LoginInfo>> getAccessToken(String str) {
        return this.coolMarketService.getAccessToken(str);
    }

    public Observable<Result<List<ConfigPage>>> loadHomeTabConfig(boolean z) {
        return this.coolMarketService.loadConfig("home_tab_config", z ? 1 : 0);
    }

    public Observable<Result<Integer>> updateHomeTabConfig(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("home_tab_config", str);
        return this.coolMarketService.updateHomeTabConfig(hashMap);
    }

    public Observable<Result<List<Entity>>> getAppListWithKeyword(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getRelatedAppListWithKeyword(str, str2, "related", i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getAppListWithKeyword(String str, String str2, String str3, int i, String str4, String str5) {
        return this.coolMarketService.getAppListWithKeyword(str, str2, str3, i, str4, str5);
    }

    public Observable<Result<ServiceApp>> getAppDetail(final String str, final int i, String str2, String str3) {
        return this.coolMarketService.getAppDetail(str, i, str2, str3).flatMap(new Func1<ResponseBody, Observable<Result<ServiceApp>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass1 */

            public Observable<Result<ServiceApp>> call(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    Result result = (Result) DataManager.this.gson.fromJson(string, new TypeToken<Result<ServiceApp>>() {
                        /* class com.coolapk.market.manager.DataManager.AnonymousClass1.AnonymousClass1 */
                    }.getType());
                    if (!result.isSuccess() || result.getData() != null) {
                        return Observable.just(result);
                    }
                    String uri = Uri.parse(DataManager.this.getDataConfig().getApiEndpoint()).buildUpon().appendEncodedPath("apk/detail").appendQueryParameter("id", str).appendQueryParameter("installed", String.valueOf(i)).build().toString();
                    return Observable.error(new DataParseException(uri + "\n" + string));
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    public Observable<Result<UserCount>> getUserCount(String str) {
        return this.coolMarketService.getUserCount(str);
    }

    public Observable<Result<UserProfile>> getUserProfile(String str) {
        return this.coolMarketService.getUserProfile(str, String.valueOf(getFirstInstallTime()));
    }

    public Observable<Result<UserProfile>> getUserSpaceProfile(String str) {
        return this.coolMarketService.getUserSpaceProfile(str);
    }

    public Observable<Result<String>> deleteAvatar(String str, int i) {
        return this.coolMarketService.deleteAvatar(str, i);
    }

    public Observable<Result<ServiceApp>> getCloudInstall(String str) {
        return this.coolMarketService.getCloudInstall(str);
    }

    public Observable<Result<String>> executeUserBlock(String str, String str2, String str3) {
        return this.coolMarketService.executeUserBlock(str, str2, str3);
    }

    public Observable<Result<FeedReply>> getFeedReplyDetail(String str) {
        return this.coolMarketService.getFeedReplyDetail(str);
    }

    public Observable<Result<String>> changeAvatar(File file) {
        return this.coolMarketService.changeAvatar(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("imgFile", StringUtils.toMd5(file.getAbsolutePath()), RequestBody.create(CoolFileUtils.mediaType(file.getAbsolutePath()), file)).build());
    }

    public Observable<Result<String>> cancelRecommend(String str) {
        return this.coolMarketService.cancelRecommend(str);
    }

    public Observable<Result<String>> feedRecommend(String str) {
        return this.coolMarketService.feedRecommend(str);
    }

    public Observable<Result<NotifyCount>> checkNotificationCount() {
        return this.coolMarketService.checkNotificationCount();
    }

    public Observable<Pair<String, String>> uploadImage(List<ImageUploadOption> list) {
        return this.ossClientWrap.uploadImage(list);
    }

    @Deprecated
    public Observable<Pair<String, String>> uploadImageOld(List<ImageUploadOption> list) {
        return Observable.from(list).filter(new Func1<ImageUploadOption, Boolean>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass3 */

            public Boolean call(ImageUploadOption imageUploadOption) {
                return Boolean.valueOf(!TextUtils.isEmpty(imageUploadOption.getUrl()));
            }
        }).concatMap(new Func1<ImageUploadOption, Observable<Pair<String, String>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass2 */

            public Observable<Pair<String, String>> call(final ImageUploadOption imageUploadOption) {
                Observable<Result<String>> observable;
                Uri parse = Uri.parse(imageUploadOption.getUrl());
                if (!parse.getScheme().equals("file")) {
                    return Observable.just(Pair.create(imageUploadOption.getUrl(), imageUploadOption.getUrl()));
                }
                File file = new File(parse.getPath());
                String fileMd5 = CoolFileUtils.getFileMd5(parse.getPath());
                MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("picFile", StringUtils.toMd5(file.getAbsolutePath()), RequestBody.create(CoolFileUtils.mediaType(file.getAbsolutePath()), file));
                if (imageUploadOption.getApi().equals("LIVE")) {
                    observable = DataManager.this.coolMarketService.uploadLiveImage("picFile", imageUploadOption.getUploadDir(), fileMd5, imageUploadOption.getBundle().getString("live_id"), addFormDataPart.build());
                } else if (imageUploadOption.getApi().equals("COLLECTION")) {
                    observable = DataManager.this.coolMarketService.uploadCollectionImage("picFile", imageUploadOption.getUploadDir(), fileMd5, addFormDataPart.build());
                } else {
                    observable = DataManager.this.coolMarketService.uploadImage("picFile", imageUploadOption.getUploadDir(), fileMd5, addFormDataPart.build());
                }
                return observable.map(RxUtils.checkResultToData()).delay(300, TimeUnit.MILLISECONDS).map(new Func1<String, Pair<String, String>>() {
                    /* class com.coolapk.market.manager.DataManager.AnonymousClass2.AnonymousClass1 */

                    public Pair<String, String> call(String str) {
                        return Pair.create(imageUploadOption.getUrl(), str);
                    }
                });
            }
        }).onBackpressureBuffer(list.size() > 0 ? (long) list.size() : 1);
    }

    public Observable<Pair<String, String>> uploadLogoImage(File file) {
        return getInstance().uploadImage(Collections.singletonList(ImageUploadOption.create(CoolFileUtils.wrap(file.getAbsolutePath()), "apk_logo", "FEED", null)));
    }

    public Observable<Pair<String, String>> uploadAlbumLogoImage(AlbumItem albumItem) {
        return getInstance().uploadImage(Collections.singletonList(ImageUploadOption.create(CoolFileUtils.wrap(albumItem.getLogoUrl()), "album", "FEED", null)));
    }

    public Observable<Pair<String, File>> getBackupLogoFile(List<String> list, final Context context) {
        return Observable.from(list).map(new Func1<String, Pair<String, File>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass4 */

            public Pair<String, File> call(String str) {
                File file;
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    externalCacheDir = context.getCacheDir();
                }
                File file2 = new File(externalCacheDir.getPath());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!TextUtils.isEmpty(str)) {
                    Bitmap iconBitmap = BitmapUtil.getIconBitmap(context, str);
                    file = new File(file2, str + ".png");
                    BitmapUtil.saveBitmapToFile(file, iconBitmap, true);
                } else {
                    file = null;
                }
                return Pair.create(str, file);
            }
        });
    }

    public Observable<Map<String, String>> uploadBackupLogoImage(List<String> list, Context context) {
        final HashMap hashMap = new HashMap();
        return getBackupLogoFile(list, context).flatMap(new Func1<Pair<String, File>, Observable<Pair<String, String>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass8 */

            public Observable<Pair<String, String>> call(final Pair<String, File> pair) {
                return DataManager.getInstance().uploadImage(Collections.singletonList(ImageUploadOption.create(CoolFileUtils.wrap(((File) pair.second).getAbsolutePath()), "back_list", "FEED", null))).flatMap(new Func1<Pair<String, String>, Observable<Pair<String, String>>>() {
                    /* class com.coolapk.market.manager.DataManager.AnonymousClass8.AnonymousClass1 */

                    public Observable<Pair<String, String>> call(Pair<String, String> pair) {
                        return Observable.just(Pair.create(pair.first, pair.second));
                    }
                });
            }
        }).onBackpressureBuffer(hashMap.size() > 0 ? (long) hashMap.size() : 1).doOnNext(new Action1<Pair<String, String>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass7 */

            public void call(Pair<String, String> pair) {
                hashMap.put(pair.first, pair.second);
            }
        }).all(new Func1<Pair<String, String>, Boolean>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass6 */

            public Boolean call(Pair<String, String> pair) {
                return true;
            }
        }).defaultIfEmpty(null).flatMap(new Func1<Boolean, Observable<Map<String, String>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass5 */

            public Observable<Map<String, String>> call(Boolean bool) {
                return Observable.just(hashMap);
            }
        });
    }

    public Observable<Pair<String, String>> uploadMessageImage(String str, String str2) {
        return uploadImage(Collections.singletonList(ImageUploadOption.create(CoolFileUtils.wrap(new File(Uri.parse(str).getPath()).getAbsolutePath()), "message", "FEED", null, str2)));
    }

    public Observable<Result<JSONObject>> ossUploadPrepare(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.ossUploadPrepare(str, str2, i, str3, str4);
    }

    public Observable<String> uploadAllImage(List<ImageUploadOption> list) {
        return uploadImage(list).map(new Func1<Pair<String, String>, String>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass10 */

            public String call(Pair<String, String> pair) {
                return (String) pair.second;
            }
        }).toList().map(new Func1<List<String>, String>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass9 */

            public String call(List<String> list) {
                if (list.size() <= 0) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size() - 1; i++) {
                    String str = list.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        sb.append(",");
                    }
                }
                String str2 = list.get(list.size() - 1);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                }
                return sb.toString();
            }
        });
    }

    public Observable<Result<Feed>> postForwardFeed(String str, String str2, boolean z) {
        return this.coolMarketService.postNewFeed(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("message", null, RequestBody.create((MediaType) null, StringUtils.emptyIfNull(str))).addFormDataPart("replyWithForward", null, RequestBody.create((MediaType) null, z ? "1" : "0")).addFormDataPart("forwardid", null, RequestBody.create((MediaType) null, str2)).build());
    }

    public Observable<Result<Feed>> postNewFeed(final String str, final String str2) {
        return Observable.defer(new Func0<Observable<Result<Feed>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass11 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Feed>> call() {
                MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("message", null, RequestBody.create((MediaType) null, StringUtils.emptyIfNull(str)));
                if (!TextUtils.isEmpty(str2)) {
                    addFormDataPart.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str2));
                }
                return DataManager.this.coolMarketService.postNewFeed(addFormDataPart.build());
            }
        });
    }

    public Observable<Result<Feed>> postNewPicture(final String str, final String str2) {
        return Observable.defer(new Func0<Observable<Result<Feed>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass12 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Feed>> call() {
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                type.addFormDataPart("message", null, RequestBody.create((MediaType) null, StringUtils.emptyIfNull(str)));
                if (!TextUtils.isEmpty(str2)) {
                    type.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str2));
                }
                return DataManager.this.coolMarketService.postNewPicture(type.build());
            }
        });
    }

    public Observable<Result<Feed>> postApkComment(final String str, final String str2, final String str3) {
        return Observable.defer(new Func0<Observable<Result<Feed>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass13 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Feed>> call() {
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                type.addFormDataPart("message", null, RequestBody.create((MediaType) null, StringUtils.emptyIfNull(str2)));
                if (!TextUtils.isEmpty(str3)) {
                    type.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str3));
                }
                return DataManager.this.coolMarketService.postApkComment(str, type.build());
            }
        });
    }

    public Observable<Result<Integer>> newDiscovery(final ShareFeedInfo shareFeedInfo, final String str, final String str2) {
        return Observable.defer(new Func0<Observable<Result<Integer>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass14 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Integer>> call() {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM).addFormDataPart("query", shareFeedInfo.getUrl()).addFormDataPart("title", StringUtils.notNull(shareFeedInfo.getTitle())).addFormDataPart("message", StringUtils.notNull(str)).addFormDataPart("packageName", shareFeedInfo.getPackageName()).addFormDataPart("logo", StringUtils.notNull(shareFeedInfo.getLogo()));
                if (!TextUtils.isEmpty(shareFeedInfo.getReference())) {
                    builder.addFormDataPart("referer", shareFeedInfo.getReference());
                }
                if (!TextUtils.isEmpty(str2)) {
                    builder.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str2));
                }
                return DataManager.this.coolMarketService.newDiscovery(builder.build());
            }
        });
    }

    public Observable<Result<Feed>> postAppForumComment(final String str, final String str2, final String str3) {
        return Observable.defer(new Func0<Observable<Result<Feed>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass15 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Feed>> call() {
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                type.addFormDataPart("message", null, RequestBody.create((MediaType) null, StringUtils.emptyIfNull(str2)));
                if (!TextUtils.isEmpty(str3)) {
                    type.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str3));
                }
                return DataManager.this.coolMarketService.postAppForumComment(str, type.build());
            }
        });
    }

    public Observable<Result<Feed>> newShareFeed(final ShareFeedInfo shareFeedInfo, final String str, final String str2) {
        return Observable.defer(new Func0<Observable<Result<Feed>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass16 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Feed>> call() {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM).addFormDataPart("is_share_app", StringUtils.notNull(shareFeedInfo.getIsDiscoveryApp())).addFormDataPart("message", StringUtils.notNull(str)).addFormDataPart("description", StringUtils.notNull(shareFeedInfo.getDescription())).addFormDataPart("title", StringUtils.notNull(shareFeedInfo.getTitle())).addFormDataPart("url", StringUtils.notNull(shareFeedInfo.getUrl())).addFormDataPart("packageName", StringUtils.notNull(shareFeedInfo.getPackageName())).addFormDataPart("logo", StringUtils.notNull(shareFeedInfo.getLogo()));
                if (!TextUtils.isEmpty(str2)) {
                    builder.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str2));
                }
                return DataManager.this.coolMarketService.newShareFeed(builder.build());
            }
        });
    }

    public Observable<Result<Integer>> newDiscovery(final MobileApp mobileApp, final String str, final File file, final String str2) {
        return Observable.defer(new Func0<Observable<Result<Integer>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass17 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Integer>> call() {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM).addFormDataPart("query", mobileApp.getPackageName()).addFormDataPart("title", StringUtils.notNull(mobileApp.getAppName())).addFormDataPart("message", StringUtils.notNull(str)).addFormDataPart("packageName", mobileApp.getPackageName()).addFormDataPart("logoFile", StringUtils.toMd5(file.getAbsolutePath()), RequestBody.create(CoolFileUtils.mediaType(file.getAbsolutePath()), file));
                if (!TextUtils.isEmpty(str2)) {
                    builder.addFormDataPart("pic", null, RequestBody.create((MediaType) null, str2));
                }
                return DataManager.this.coolMarketService.newDiscovery(builder.build());
            }
        });
    }

    public Observable<Result<FeedReply>> postFeedReply(String str, String str2, String str3, boolean z) {
        return postFeedReply(str, str2, "reply", str3, z);
    }

    public Observable<Result<FeedReply>> postFeedComment(String str, String str2, String str3, boolean z) {
        return postFeedReply(str, str2, "feed", str3, z);
    }

    public Observable<Result<FeedReply>> postDyhArticleReply(String str, String str2, String str3, boolean z) {
        return postFeedReply(str, str2, "article_reply", str3, z);
    }

    public Observable<Result<FeedReply>> postDyhArticleComment(String str, String str2, String str3, boolean z) {
        return postFeedReply(str, str2, "article", str3, z);
    }

    private Observable<Result<FeedReply>> postFeedReply(final String str, final String str2, final String str3, String str4, final boolean z) {
        return uploadAllImage(ImageUploadOption.transformList(TextUtils.isEmpty(str4) ? Collections.emptyList() : Collections.singletonList(str4), "feed", "FEED", null)).flatMap(new Func1<String, Observable<Result<FeedReply>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass18 */

            public Observable<Result<FeedReply>> call(String str) {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM);
                builder.addFormDataPart("message", StringUtils.emptyIfNull(str2));
                if (!TextUtils.isEmpty(str)) {
                    builder.addFormDataPart("pic", str);
                }
                if (z) {
                    builder.addFormDataPart("replyAndForward", "1");
                }
                return DataManager.this.coolMarketService.postFeedReply(str, str3, builder.build());
            }
        });
    }

    public Observable<Result<List<LiveMessage>>> postLiveMessage(final String str, final String str2, List<String> list, final String str3, final int i, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("live_id", str);
        return uploadAllImage(ImageUploadOption.transformList(list, str4, "LIVE", bundle)).flatMap(new Func1<String, Observable<Result<List<LiveMessage>>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass19 */

            public Observable<Result<List<LiveMessage>>> call(String str) {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM).addFormDataPart("live_id", str).addFormDataPart("source_id", str3).addFormDataPart("is_broadcast", String.valueOf(i)).addFormDataPart("message", StringUtils.emptyIfNull(str2));
                if (!TextUtils.isEmpty(str)) {
                    builder.addFormDataPart("pic", str);
                }
                return DataManager.this.coolMarketService.postLiveMessage(builder.build());
            }
        });
    }

    public Observable<Result<Entity>> createFeed(FeedMultiPart feedMultiPart) {
        return this.coolMarketService.createFeed(feedMultiPart.buildRequestBody());
    }

    public Observable<Result<Entity>> changeFeed(FeedMultiPart feedMultiPart) {
        return this.coolMarketService.changeFeed(feedMultiPart.buildRequestBody());
    }

    public Observable<Result<List<Entity>>> searchUser(String str, int i, String str2, String str3) {
        return this.coolMarketService.searchUser(str, i, str2, str3);
    }

    public Observable<Result<String>> addApkToAlbum(AlbumItem albumItem) {
        return this.coolMarketService.addApkToAlbum(albumItem.getAlbumId(), albumItem.getPackageName(), albumItem.getTitle(), albumItem.getUrl(), albumItem.getNote(), albumItem.getDisplayOrder(), albumItem.getLogoUrl());
    }

    public Observable<Result<String>> addApkToAlbum(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        Log.d("hfl", str6);
        return this.coolMarketService.addApkToAlbum(str, str2, str3, str4, str5, i, str6);
    }

    public Observable<Result<List<Entity>>> getFeedReplyList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getFeedReplyList(str, "", i, str2, str3, 0, null, 0, 0);
    }

    public Observable<Result<List<FeedReply>>> getHotFeedReplyList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getHotFeedReplyList(str, i, str2, str3, 1);
    }

    public Observable<Result<List<Entity>>> getFeedReplyBolckList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getFeedReplyList(str, "", i, str2, str3, 1, "", 1, 0);
    }

    public Observable<Result<List<Entity>>> getFeedReplyDiscussList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getFeedReplyList(str, str2, i, str3, str4, 1, "", 0, 0);
    }

    public Observable<Result<List<Entity>>> getFeedReplyDiscussList(String str, String str2, int i, String str3, String str4, int i2, int i3) {
        return this.coolMarketService.getFeedReplyList(str, str2, i, str3, str4, 1, "", i2, i3);
    }

    public Observable<Result<List<Entity>>> getFeedReplyDiscussList(String str, String str2, String str3, int i, String str4, String str5, int i2, int i3) {
        return this.coolMarketService.getFeedReplyList(str, str2, i, str4, str5, 1, str3, i2, i3);
    }

    public Observable<Result<List<Entity>>> getFeedReplySubList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getFeedReplyList(str, "", i, str3, str4, 0, str2, 0, 0);
    }

    public Observable<Result<List<Entity>>> getNotificationAtCommentMeList(int i, String str, String str2) {
        return this.coolMarketService.getNotificationAtCommentMeList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getNotificationFeedLikeList(int i, String str, String str2) {
        return this.coolMarketService.getNotificationFeedLikeList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getNotificationAtMeList(int i, String str, String str2) {
        return this.coolMarketService.getNotificationAtMeList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getNotificationList(int i, String str, String str2) {
        return this.coolMarketService.getNotificationList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getNotificationFollowMeList(int i, String str, String str2) {
        return this.coolMarketService.getNotificationFollowMeList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getNotificationCommmentMeList(int i, String str, String str2) {
        return this.coolMarketService.getNotificationCommmentMeList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> searchFeed(String str, int i, String str2, String str3) {
        return this.coolMarketService.searchFeed(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getEditorChoiceList(int i, String str, String str2) {
        return this.coolMarketService.getEditorChoiceList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> searchDiscovery(String str, int i, String str2, String str3) {
        return this.coolMarketService.searchDiscovery(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> searchComment(String str, int i, String str2, String str3) {
        return this.coolMarketService.searchComment(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> searchWithFeedType(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.searchWithFeedType(str, str2, i, str3, str4);
    }

    public Observable<Result<Entity>> getFeedDetail(String str, String str2, String str3, String str4) {
        return this.coolMarketService.getFeedDetail(str, str2, str3, str4);
    }

    public Observable<Result<Entity>> getChangeHistoryDetail(String str) {
        return this.coolMarketService.getChangeHistoryDetail(str);
    }

    public Observable<Result<Entity>> getChangeFeedDetail(String str, String str2, String str3, String str4) {
        return this.coolMarketService.getChangeFeedDetail(str, str2, str3, str4);
    }

    public Observable<Result<List<Entity>>> getFeedChangeHistoryList(String str) {
        return this.coolMarketService.getFeedChangeHistoryList(str);
    }

    public Observable<Result<NotifyCount>> markConversationRead(String str) {
        return this.coolMarketService.markConversationRead(str);
    }

    public Observable<Result<List<Entity>>> receiveLongMessage(String str) {
        return this.coolMarketService.receiveLongMessage(str);
    }

    public Observable<Result<List<Entity>>> recentChatUser(int i, String str, String str2) {
        return this.coolMarketService.recentChatUser(i, str, str2);
    }

    public Observable<Result<Message>> receiveLongMessageOld(String str) {
        return this.coolMarketService.receiveLongMessageOld(str);
    }

    public Observable<Result<List<Entity>>> sendMessage(String str, String str2, String str3, String str4) {
        return this.coolMarketService.sendMessage(str, str2, str3, str4, "");
    }

    public Observable<ResponseBody> sendMessageForPic(String str, String str2) {
        return this.coolMarketService.sendMessage(str, "", str2);
    }

    public Observable<Result<List<Entity>>> sendMessage(String str, String str2, String str3, String str4, String str5) {
        return this.coolMarketService.sendMessage(str, str2, str3, str4, str5);
    }

    public Observable<ResponseBody> showImage(String str, String str2) {
        return this.coolMarketService.showImage(str, str2);
    }

    public String getMessageImageUrl(String str, String str2) {
        return Uri.parse(this.dataConfig.getApiEndpoint()).buildUpon().appendEncodedPath("message/showImage").appendQueryParameter("id", str).appendQueryParameter("type", str2).build().toString();
    }

    public Observable<Result<List<Entity>>> sendMessage(String str, String str2) {
        return this.coolMarketService.sendMessage(str, str2, "", "", "");
    }

    public Observable<Result<Message>> sendMessage2Old(String str, String str2) {
        return this.coolMarketService.sendMessage2Old(str, str2, "", "");
    }

    public Observable<Result<String>> deleteChat(String str) {
        return this.coolMarketService.deleteChat(str);
    }

    public Observable<Result<List<String>>> deleteChatMulti(String str) {
        return this.coolMarketService.deleteChatMulti(str);
    }

    public Observable<Result<List<String>>> deleteChatAll() {
        return this.coolMarketService.deleteChatMulti("all");
    }

    public Observable<Result<String>> deleteMessage(String str, String str2) {
        return this.coolMarketService.deleteMessage(str, str2);
    }

    public Observable<Result<String>> addTop(String str) {
        return this.coolMarketService.addTop(str);
    }

    public Observable<Result<String>> removeTop(String str) {
        return this.coolMarketService.removeTop(str);
    }

    public Observable<Result<List<Entity>>> sendMessageDirect(String str, String str2, String str3, String str4) {
        return this.coolMarketService.sendMessage(str, 1, str2, str3, str4);
    }

    public Observable<Result<List<Entity>>> sendMessageDirect(String str, String str2) {
        return this.coolMarketService.sendMessage(str, 1, str2, "", "");
    }

    public Observable<Result<Message>> sendMessageDirectOld(String str, String str2) {
        return this.coolMarketService.sendMessageOld(str, 1, str2, "", "");
    }

    public Observable<Result<List<Entity>>> getChatList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getChatList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getMessageList(int i, String str, String str2) {
        return this.coolMarketService.getMessageList(i, str, str2);
    }

    public Observable<Result<String>> addApkToAlbum(AlbumItem albumItem, File file) {
        if (file == null) {
            file = new File("");
        }
        return addApkToAlbum(albumItem.getAlbumId(), albumItem.getPackageName(), albumItem.getTitle(), albumItem.getUrl(), StringUtils.notNull(albumItem.getNote()), albumItem.getDisplayOrder(), file);
    }

    public Observable<Result<String>> addApkToAlbum(String str, String str2, String str3, String str4, String str5, int i, File file) {
        String absolutePath = file.getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            absolutePath = "";
        }
        RequestBody create = RequestBody.create(CoolFileUtils.mediaType(absolutePath), file);
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("packageName", str2).addFormDataPart("title", str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        return this.coolMarketService.addApkToAlbum(str, addFormDataPart.addFormDataPart("url", str4).addFormDataPart("note", str5).addFormDataPart("displayOrder", String.valueOf(i)).addFormDataPart("logoFile", null, create).build());
    }

    public Observable<Result<String>> albumRecommend(String str) {
        return this.coolMarketService.recommendAlbum(str);
    }

    public Observable<Result<List<Entity>>> getMainInit() {
        return this.coolMarketService.getMainInit();
    }

    public Observable<Result<UserProfile>> changeSignatureProfile(String str) {
        return this.coolMarketService.changeUserProfile("bio", str);
    }

    public Observable<Result<String>> chanageUserName(String str) {
        return this.coolMarketService.changeUserName(str);
    }

    public Observable<Result<String>> getChangeEmailCode(String str) {
        return this.coolMarketService.getChangeEmailCode(str);
    }

    public Observable<Result<String>> changeEmail(String str, String str2) {
        return this.coolMarketService.changeEmail(str, str2);
    }

    public Observable<Result<String>> sendChangeMobileCode(String str, String str2, String str3) {
        return this.coolMarketService.sendChangeMobileCode(str, str2, str3);
    }

    public Observable<Result<String>> changeMobile(String str, String str2, String str3) {
        return this.coolMarketService.changeMobile(str, str2, str3);
    }

    public Observable<Result<String>> checkUserNameStatus() {
        return this.coolMarketService.checkUserNameStatus();
    }

    public Observable<Result<String>> captchaImage() {
        return this.coolMarketService.captchaImage();
    }

    public Observable<Result<UserProfile>> changeWeiboProfile(String str) {
        return this.coolMarketService.changeUserProfile("weibo", str);
    }

    public Observable<Result<UserProfile>> changeProfileValue(String str, String str2) {
        return this.coolMarketService.changeUserProfile(str, str2);
    }

    public Observable<Result<Topic>> getTopicDetail(String str) {
        return this.coolMarketService.getTopicDetail(str);
    }

    public Observable<Result<Integer>> followTag(String str) {
        return this.coolMarketService.followTag(str);
    }

    public Observable<Result<Integer>> unFollowTag(String str) {
        return this.coolMarketService.unFollowTag(str);
    }

    public Observable<Result<String>> addToBlackList(String str) {
        return this.coolMarketService.addToBlackList(str);
    }

    public Observable<Result<String>> removeFromBlackList(String str) {
        return this.coolMarketService.removeFromBlackList(str);
    }

    public Observable<Result<String>> addToIgnoreList(String str) {
        return this.coolMarketService.addToIgnoreList(str);
    }

    public Observable<Result<String>> removeFromIgnoreList(String str) {
        return this.coolMarketService.removeFromIgnoreList(str);
    }

    public Observable<Result<String>> addToLimitList(String str) {
        return this.coolMarketService.addToLimitList(str);
    }

    public Observable<Result<String>> removeFromLimitList(String str) {
        return this.coolMarketService.removeFromLimitList(str);
    }

    public Observable<Result<List<Entity>>> getMyBlackListUser(int i, String str, String str2) {
        return this.coolMarketService.getMyBlackListUser(i, str, str2);
    }

    public Observable<Result<List<User>>> getMyIgnoreListUser(int i, String str, String str2) {
        return this.coolMarketService.getMyIgnoreListUser(i, str, str2);
    }

    public Observable<Result<List<User>>> getMyLimitListUser(int i, String str, String str2) {
        return this.coolMarketService.getMyLimitListUser(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getAdminNewestList(String str, int i, String str2, String str3, int i2) {
        return this.coolMarketService.getAdminNewestList(str, i, str2, str3, i2);
    }

    public Observable<Result<List<Entity>>> getAdminNewestList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAdminNewestList(str, i, str2, str3, 0);
    }

    public Observable<Result<List<Entity>>> getAdminNewestReplyList(int i, String str, String str2) {
        return this.coolMarketService.getAdminNewestReplyList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getSpamFeedList(String str, String str2, String str3, int i, String str4, String str5) {
        return this.coolMarketService.getSpamFeedList(str, str2, str3, i, str4, str5);
    }

    public Observable<Result<List<Entity>>> getSpamFeedReplyList(String str, String str2, String str3, int i, String str4, String str5) {
        return this.coolMarketService.getSpamFeedReplyList(str, str2, str3, i, str4, str5);
    }

    public Observable<Result<String>> refuseSpamFeedReply(String str, long j) {
        return this.coolMarketService.refuseSpamFeedReply(str, j);
    }

    public Observable<Result<String>> refuseSpamFeed(String str, long j) {
        return this.coolMarketService.refuseSpamFeed(str, j);
    }

    public Observable<Result<String>> feedBlock(String str, String str2, String str3) {
        return this.coolMarketService.feedBlock(str, str2, str3);
    }

    public Observable<Result<String>> feedUnBlock(String str, String str2, String str3) {
        return this.coolMarketService.feedUnBlock(str, str2, str3);
    }

    public Observable<Result<String>> feedUnBlock(String str, String str2, String str3, int i) {
        return this.coolMarketService.feedUnBlock(str, str2, str3, i);
    }

    public Observable<Result<String>> feedBlock(String str, String str2) {
        return this.coolMarketService.feedBlock(str, "feed", str2);
    }

    public Observable<Result<String>> feedReplyBlock(String str, String str2) {
        return feedBlock(str, "feed_reply", str2);
    }

    public Observable<Result<String>> feedUnReplyBlock(String str, String str2) {
        return feedUnBlock(str, "feed_reply", str2);
    }

    public Observable<Result<String>> unLinkToApk(String str) {
        return this.coolMarketService.unLinkToApk(str);
    }

    public Observable<Result<String>> deleteAllNotification(String str) {
        return this.coolMarketService.deleteAllNotification(str);
    }

    public Observable<Result<String>> deleteNotification(String str) {
        return this.coolMarketService.deleteNotification(str);
    }

    public Observable<Result<String>> clearNotificationCount(String str) {
        return this.coolMarketService.clearNotificationCount(str);
    }

    public Observable<Result<List<Entity>>> getAppForumList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAppForumList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getAppForumListWithPath(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAppForumListWithPath(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserAppForumsFollowList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserAppForumsFollowList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> searchAppForumList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.searchAppForumList(str, str2, i, str3, str4);
    }

    public Observable<Result<LoginInfo>> checkLoginInfo() {
        return this.coolMarketService.checkLoginInfo();
    }

    public Observable<Result<List<Entity>>> getQuestionList(int i, String str, String str2) {
        return this.coolMarketService.getQuestionList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getUserQuestionAndAnswerList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserQuestionAndAnswerList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getUserHtmlFeedList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserHtmlFeedList(str, i, str2, str3);
    }

    public Observable<Result<List<String>>> getTipGoodsTagList() {
        return this.coolMarketService.getTipGoodsTagList();
    }

    public Observable<Result<List<Feed>>> searchQuestion(String str, int i, String str2, String str3) {
        return this.coolMarketService.searchQuestion(str, i, str2, str3);
    }

    public Observable<Result<Integer>> followQuestion(String str) {
        return this.coolMarketService.followQuestion(str);
    }

    public Observable<Result<Integer>> unFollowQuestion(String str) {
        return this.coolMarketService.unFollowQuestion(str);
    }

    public Observable<Result<String>> inviteUserToAnswer(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb.append(",");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return this.coolMarketService.inviteUserToAnswer(sb.toString(), str);
    }

    public Observable<Result<Feed>> getQuestionDetail(String str) {
        return this.coolMarketService.getQuestionDetail(str);
    }

    public Observable<Result<List<Entity>>> getAnswerList(String str, String str2, int i, String str3, String str4, Integer num) {
        return this.coolMarketService.getAnswerList(str, str2, i, str3, str4, num);
    }

    public Observable<Result<List<Entity>>> getRelatedQuestion(String str) {
        return this.coolMarketService.getRelatedQuestion(str);
    }

    public Observable<Result<List<PicCategory>>> getPicCategoryList() {
        return this.coolMarketService.getPicCategoryList();
    }

    public Observable<Result<List<Entity>>> searchTopic(String str, int i, String str2, String str3, String str4) {
        return this.coolMarketService.searchTopic(str, i, str2, str3, str4);
    }

    public Observable<Result<Integer>> checkAnswerCount(String str, String str2) {
        return this.coolMarketService.checkAnswerCount(str, str2);
    }

    public Observable<ResponseBody> hotSearch(String str, String str2) {
        return this.coolMarketService.hotSearch(str, str2);
    }

    public Observable<Result<List<Entity>>> typeSearch(String str, String str2, int i, String str3, String str4, String str5) {
        return this.coolMarketService.typeSearch(str, str2, i, str3, str4, -1, str5);
    }

    public Observable<Result<List<Entity>>> appSearch(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        return this.coolMarketService.appSearch(str, str2, str3, str4, i, str5, str6, str7);
    }

    public Observable<Result<List<Entity>>> feedSearch(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        return this.coolMarketService.feedSearch(str, str2, str3, str4, str5, i, str6, str7, -1);
    }

    public Observable<Result<List<Entity>>> secondHandSearch(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, int i, String str8, String str9) {
        return this.coolMarketService.secondHandSearch(str2, str3, "1", str, str4, z ? "1" : "", str5, str6, str7, i, str8, str9);
    }

    public Observable<Result<List<Entity>>> secondHandSearch(String str, String str2, String str3, String str4, boolean z, String str5, int i, String str6, String str7) {
        return this.coolMarketService.secondHandSearch(str2, str3, "1", str, str4, z ? "1" : "", str5, "", "", i, str6, str7);
    }

    public Observable<Result<List<Entity>>> askSearch(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.askSearch(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> suggestSpotSearch(String str, int i, String str2, String str3, String str4) {
        return this.coolMarketService.suggestSpotSearch(str, i, str2, str3, str4);
    }

    public Observable<Result<List<Entity>>> getFeedForwardList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getFeedForwardList(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getFeedLikeList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getFeedLikeList(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getQuestionFollowerList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getQuestionFollowerList(str, i, str2, str3);
    }

    public Observable<Result<Integer>> shareCallback(String str, String str2, String str3, String str4) {
        return this.coolMarketService.shareCallback(str, str2, str3, str4, String.valueOf((int) (System.currentTimeMillis() / 1000)));
    }

    public Observable<Result<VideoUrls>> getPlayerUrl(String str) {
        return this.coolMarketService.getPlayerUrl(str);
    }

    public Observable<Result<String>> getUrlVideoInfo(String str) {
        return this.coolMarketService.getUrlVideoInfo(str);
    }

    public Observable<Result<Product>> getProductDetail(String str) {
        return this.coolMarketService.getProductDetail(str);
    }

    public Observable<Result<List<ProductBrand>>> getProductCategoryList() {
        return this.coolMarketService.getProductCategoryList();
    }

    public Observable<Result<List<ProductBrand>>> getProductBrandList() {
        return this.coolMarketService.getProductBrandList();
    }

    public Observable<Result<List<ProductBrand>>> getSecondHandProductBrandList() {
        return this.coolMarketService.getSecondHandProductBrandList();
    }

    public Observable<Result<List<Entity>>> getProductSeries(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getProductSeries(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getSecondHandProductSeries(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getSecondHandProductSeries(str, str2, i, str3, str4);
    }

    public Observable<Result<List<User>>> getProductFollowList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getProductFollowList(str, i, str2, str3);
    }

    public Observable<Result<List<User>>> getProductWishList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getProductWishList(str, i, str2, str3);
    }

    public Observable<Result<List<User>>> getProductBuyList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getProductBuyList(str, i, str2, str3);
    }

    public Observable<Result<List<User>>> getTopicFollowList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getTopicFollowList(str, i, str2, str3);
    }

    public Observable<Result<Integer>> changeProductFollowState(String str, boolean z) {
        return this.coolMarketService.changeProductFollowState(str, z ? 1 : 0);
    }

    public Observable<Result<String>> changeProductWishStatus(String str, boolean z) {
        return this.coolMarketService.changeWishStatus(str, z ? 1 : 0);
    }

    public Observable<Result<String>> changeProductBuyStatus(String str, boolean z) {
        return this.coolMarketService.changeBuyStatus(str, z ? 1 : 0);
    }

    public Observable<Result<Product>> changeProductLikeState(String str, int i) {
        return this.coolMarketService.changeProductLikeState(str, i);
    }

    public Observable<Result<List<Entity>>> getProductFeedList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getProductFeedList(str, str2, i, str3, str4);
    }

    public Observable<Result<String>> addToMediaList(String str) {
        return this.coolMarketService.addToMediaList(str);
    }

    public Observable<Result<String>> deleteFromMediaList(String str) {
        return this.coolMarketService.deleteFromMediaList(str);
    }

    public Observable<Result<List<ProductMedia>>> getMediaList(String str, String str2, boolean z, int i, String str3, String str4) {
        return this.coolMarketService.getMediaList(str, str2, z ? 1 : 0, i, str3, str4);
    }

    public Observable<Result<ProductConfig>> getProductConfig(String str) {
        return this.coolMarketService.getProductConfig(str);
    }

    public Observable<Result<Entity>> getTopicCompatProduct(String str) {
        return this.coolMarketService.getTopicCompatProduct(str);
    }

    public Observable<Result<String>> markImageError(String str, String str2, String str3) {
        return this.coolMarketService.markImageError(str, str2, str3);
    }

    public Observable<Result<String>> requestValidate(String str, String str2, String str3, String str4, String str5) {
        return this.coolMarketService.requestValidate(str, str2, str3, str4, str5);
    }

    public Observable<Result<String>> sendValidateCode(String str, String str2, String str3, String str4) {
        return this.coolMarketService.sendValidateCode(str, str2, str3, str4);
    }

    public Observable<Result<Entity>> getTargetInfo(String str, String str2) {
        return this.coolMarketService.getTargetInfo(str, str2);
    }

    public Observable<Result<List<Entity>>> getRecentHistoryList(int i, String str, String str2) {
        return this.coolMarketService.getRecentHistoryList(i, str, str2);
    }

    public Observable<Result<String>> addToTopRecentHistory(String str, String str2) {
        return this.coolMarketService.addToTopRecentHistory(str, str2);
    }

    public Observable<Result<String>> removeFromTopRecentHistory(String str) {
        return this.coolMarketService.removeFromTopRecentHistory(str);
    }

    public Observable<Result<String>> deleteRecentHistory(String str) {
        return this.coolMarketService.deleteRecentHistory(str);
    }

    public Observable<Result<String>> clearRecentHistory() {
        return this.coolMarketService.deleteAllRecentHistory();
    }

    public Observable<Result<Vote>> createUserVote(String str, Map<String, String> map, int i) {
        return this.coolMarketService.createUserVote(str, map, i);
    }

    public Observable<Result<List<Entity>>> getVoteCommentList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getVoteCommentList(str, str2, i, str3, str4);
    }

    public Observable<Result<String>> updateVoteRecommendComment(String str, String str2, int i) {
        return this.coolMarketService.updateVoteRecommendComment(str, str2, i);
    }

    public Observable<Result<List<Entity>>> getVoteUserList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getVoteUserList(str, str2, i, str3, str4);
    }

    public Observable<Result<String>> addTopToNode(String str, String str2, String str3) {
        return this.coolMarketService.addTopToNode(str, str2, str3);
    }

    public Observable<Result<String>> cancelTopFromNode(String str, String str2, String str3) {
        return this.coolMarketService.cancelTopFromNode(str, str2, str3);
    }

    public Observable<Result<String>> addToContentTopNode(String str, String str2, String str3, String str4) {
        return this.coolMarketService.addTopContentToNode(str, str2, str3, str4);
    }

    public Observable<Result<String>> removeTopContentFromNode(String str, String str2, String str3) {
        return this.coolMarketService.removeTopContentFromNode(str, str2, str3);
    }

    public Observable<Result<List<NodeRating>>> getNodeRatingList(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, int i, String str8, String str9) {
        return this.coolMarketService.getNodeRatingList(str, str2, str3, str4, str5, str6, str7, num, num2, i, str8, str9);
    }

    public Observable<Result<String>> deleteRating(String str, String str2, String str3, int i) {
        return this.coolMarketService.deleteRating(str, str2, str3, i);
    }

    public Observable<Result<String>> addReplyTopToFeed(String str, String str2) {
        return this.coolMarketService.addReplyTopToFeed(str, str2);
    }

    public Observable<Result<String>> cancelReplyTopFromFeed(String str) {
        return this.coolMarketService.cancelReplyTopFromFeed(str);
    }

    public Observable<Result<FeedGoods>> addGoods(String str) {
        return this.coolMarketService.addGoods(str);
    }

    public Observable<Result<FeedGoods>> addGoodsWithHtmlContent(String str, String str2, String str3) {
        return this.coolMarketService.addGoodsWithHtmlContent(str, str2, str3);
    }

    public Observable<Result<FeedGoods>> createGoods(int i, String str, String str2, String str3, String str4) {
        return this.coolMarketService.createGoods(i, str, str2, str3, str4);
    }

    public Observable<Result<String>> getGoodsBuyUrl(String str, String str2) {
        return this.coolMarketService.getGoodsBuyUrl(str, str2);
    }

    public Observable<Result<String>> changedFeedGoodsRecommendStatus(String str, int i) {
        return this.coolMarketService.changedFeedGoodsRecommendStatus(str, i);
    }

    public Observable<Result<FeedGoods>> getGoodsDetail(String str) {
        return this.coolMarketService.getGoodsDetail(str);
    }

    public Observable<Result<List<Entity>>> getGoodsFeedList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getGoodsFeedList(str, str2, i, str3, str4);
    }

    public PreferencesUtils.EditorHelper getPreferencesEditor() {
        return this.preferencesUtils.edit();
    }

    public boolean getPreferencesBoolean(String str, boolean z) {
        return this.preferencesUtils.getBoolean(str, z);
    }

    public float getPreferencesFloat(String str, float f) {
        return this.preferencesUtils.getFloat(str, f);
    }

    public int getPreferencesInt(String str, int i) {
        return this.preferencesUtils.getInt(str, i);
    }

    public long getPreferencesLong(String str, long j) {
        return this.preferencesUtils.getLong(str, j);
    }

    public String getPreferencesString(String str, String str2) {
        return this.preferencesUtils.getString(str, str2);
    }

    public boolean containsInPreferences(String str) {
        return this.preferencesUtils.contains(str);
    }

    public void registerPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.preferencesUtils.registerChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.preferencesUtils.unregisterChangeListener(onSharedPreferenceChangeListener);
    }

    public int getDownloadTaskCount() {
        return Downloader.getInstance().count();
    }

    public boolean isDownloadJobAlive(String str) {
        return Downloader.getInstance().isDownloadJobAlive(str);
    }

    public Observable<String> startDownload(final String str, final String str2, final String str3, final Extra extra, final NetworkExecutor networkExecutor) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass20 */

            public void call(Subscriber<? super String> subscriber) {
                try {
                    Downloader instance = Downloader.getInstance();
                    String str = str;
                    instance.start(str, str2, str3, new InternalOnDownloadListener(str, DataManager.this.downloadStore), extra, networkExecutor);
                    subscriber.onNext(str);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<String> stopDownload(String str) {
        return stopDownload(str, null);
    }

    public Observable<String> stopDownload(final String str, final Extra extra) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass21 */

            public void call(Subscriber<? super String> subscriber) {
                DownloadState downloadStateWithUrl;
                if (!subscriber.isUnsubscribed()) {
                    try {
                        if (!(extra == null || (downloadStateWithUrl = DataManager.this.downloadStore.getDownloadStateWithUrl(str)) == null || downloadStateWithUrl.isFinish())) {
                            Extra extra = downloadStateWithUrl.getExtra();
                            if (extra == null) {
                                extra = new Extra();
                            }
                            extra.copy(extra);
                            DataManager.this.downloadStore.handleAction(2, downloadStateWithUrl);
                        }
                        Downloader.getInstance().stop(str);
                        subscriber.onNext(str);
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }
            }
        });
    }

    public DownloadState getDownloadStateWithUrl(String str) {
        return this.downloadStore.getDownloadStateWithUrl(str);
    }

    public DownloadState getDownloadState(String str) {
        return this.downloadStore.getDownloadState(str);
    }

    public List<DownloadState> getDownloadStateList() {
        return this.downloadStore.getDownloadStates();
    }

    public void registerDownloadEvent(Object obj) {
        this.downloadStore.register(obj);
    }

    public void unregisterDownloadEvent(Object obj) {
        this.downloadStore.unregister(obj);
    }

    public void setDownloadStartInterceptor(DownloadStartInterceptor downloadStartInterceptor2) {
        this.downloadStartInterceptor = downloadStartInterceptor2;
    }

    public InstallState getInstallState(String str) {
        return this.installStore.getInstallState(str);
    }

    public List<InstallState> getInstallStateList() {
        return this.installStore.getInstallStateList();
    }

    public UninstallState getUninstallState(String str) {
        return this.uninstallStore.getUninstallState(str);
    }

    public void deliverInstallWait(String str) {
        LogUtils.v("Wait install file: filePath: %s", str);
        long currentTimeMillis = System.currentTimeMillis();
        this.installStore.handleAction(1, InstallState.newBuilder().state(1).updateTime(currentTimeMillis).startTime(currentTimeMillis).path(str).build());
    }

    public void clearCompleteInstallState() {
        this.installStore.handleAction(2, null);
    }

    public boolean install(Context context, String str, String str2, boolean z, boolean z2, Extra extra) {
        int i;
        boolean z3;
        String str3;
        FileNotFoundException e;
        PackageParseException e2;
        SignaturesException e3;
        Md5NotMatchException e4;
        ExpectPackageException e5;
        UnsupportedFileException e6;
        SamePackageException e7;
        Throwable th;
        String str4;
        boolean z4 = !TextUtils.isEmpty(str) && CacheUrlUtils.getCoolMarketMimeType(str) == 1;
        InternalProcessorCallback internalProcessorCallback = new InternalProcessorCallback(this.database, this.installStore, str, str2, extra);
        internalProcessorCallback.onStart();
        String str5 = null;
        try {
            FileProcessor fileProcessor = FileProcessorFactory.getFileProcessor(context, str2, z, z2, z4, internalProcessorCallback, extra);
            if (fileProcessor != null) {
                z3 = fileProcessor.process();
                try {
                    str4 = fileProcessor.getOutputFilePath();
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (PackageParseException e9) {
                    e2 = e9;
                    e2.printStackTrace();
                    i = -3;
                    str3 = e2.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                } catch (SignaturesException e10) {
                    e3 = e10;
                    e3.printStackTrace();
                    i = -4;
                    str3 = e3.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                } catch (Md5NotMatchException e11) {
                    e4 = e11;
                    e4.printStackTrace();
                    i = -5;
                    str3 = e4.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                } catch (ExpectPackageException e12) {
                    e5 = e12;
                    e5.printStackTrace();
                    i = -6;
                    str3 = e5.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                } catch (UnsupportedFileException e13) {
                    e6 = e13;
                    i = -7;
                    str3 = e6.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                } catch (SamePackageException e14) {
                    e7 = e14;
                    i = -8;
                    str3 = e7.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    i = -1;
                    str3 = th.getMessage();
                    LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
                    saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
                    internalProcessorCallback.onComplete(str5, i, str3);
                    return z3;
                }
            } else {
                str4 = null;
                z3 = false;
            }
            i = 0;
            str5 = str4;
            str3 = null;
        } catch (FileNotFoundException e15) {
            e = e15;
            z3 = false;
            e.printStackTrace();
            i = -2;
            str3 = e.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (PackageParseException e16) {
            e2 = e16;
            z3 = false;
            e2.printStackTrace();
            i = -3;
            str3 = e2.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (SignaturesException e17) {
            e3 = e17;
            z3 = false;
            e3.printStackTrace();
            i = -4;
            str3 = e3.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (Md5NotMatchException e18) {
            e4 = e18;
            z3 = false;
            e4.printStackTrace();
            i = -5;
            str3 = e4.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (ExpectPackageException e19) {
            e5 = e19;
            z3 = false;
            e5.printStackTrace();
            i = -6;
            str3 = e5.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (UnsupportedFileException e20) {
            e6 = e20;
            z3 = false;
            i = -7;
            str3 = e6.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (SamePackageException e21) {
            e7 = e21;
            z3 = false;
            i = -8;
            str3 = e7.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        } catch (Throwable th3) {
            th = th3;
            z3 = false;
            th.printStackTrace();
            i = -1;
            str3 = th.getMessage();
            LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
            saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
            internalProcessorCallback.onComplete(str5, i, str3);
            return z3;
        }
        LogUtils.v("File process is success? %s, output: %s", Boolean.valueOf(z3), str5);
        saveLog("install", str2, "Success: " + z3 + "\nErrorMessage: " + str3);
        internalProcessorCallback.onComplete(str5, i, str3);
        return z3;
    }

    public void deliverUninstallWait(String str, String str2) {
        LogUtils.v("Wait uninstall package: packageName: %s", str);
        long currentTimeMillis = System.currentTimeMillis();
        this.uninstallStore.handleAction(1, UninstallState.newBuilder().packageName(str).title(str2).startTime(currentTimeMillis).updateTime(currentTimeMillis).state(1).build());
    }

    public boolean uninstall(Context context, String str, String str2, boolean z) {
        UninstallState.Builder builder;
        int i;
        boolean z2;
        UninstallState uninstallState = this.uninstallStore.getUninstallState(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (uninstallState == null) {
            builder = UninstallState.newBuilder();
            builder.startTime(currentTimeMillis);
        } else {
            builder = UninstallState.newBuilder(uninstallState);
        }
        UninstallState build = builder.packageName(str).title(str2).updateTime(currentTimeMillis).state(2).build();
        LogUtils.v("Start uninstall package: packageName: %s", str);
        this.uninstallStore.handleAction(1, build);
        if (z) {
            boolean isAccessGivenWithTimeOut = RootTools.isAccessGivenWithTimeOut();
            LogUtils.v("Is root access given? %s", Boolean.valueOf(isAccessGivenWithTimeOut));
            if (isAccessGivenWithTimeOut) {
                LogUtils.v("Uninstall by root mode", new Object[0]);
                try {
                    z2 = PackageUtils.uninstallSilent(str, false);
                } catch (Exception e) {
                    LogUtils.e(e);
                    z2 = false;
                    i = 1;
                }
            } else {
                z2 = PackageUtils.uninstallNormal(context, str);
            }
        } else {
            z2 = PackageUtils.uninstallNormal(context, str);
        }
        i = 0;
        UninstallState build2 = UninstallState.newBuilder(build).updateTime(currentTimeMillis).state(3).errorCode(i).build();
        LogUtils.v("Complete uninstall package: packageName: %s", str);
        this.uninstallStore.handleAction(1, build2);
        return z2;
    }

    public Db getDataBase() {
        return this.database.getDb();
    }

    public void insertOrUpdateContentValuesList(String str, List<ContentValues> list) {
        this.database.insertOrUpdateContentValuesList(str, list);
        this.appStore.handleAction(1, null);
    }

    public long saveMobileApp(MobileApp mobileApp) {
        long saveMobileApp = this.database.saveMobileApp(mobileApp);
        this.appStore.handleAction(2, mobileApp);
        return saveMobileApp;
    }

    public int deleteMobileApp(String str) {
        int deleteMobileApp = this.database.deleteMobileApp(str);
        this.appStore.handleAction(3, str);
        return deleteMobileApp;
    }

    public MobileApp getMobileAppExistFast(String str) {
        return this.appStore.getMobileApp(str);
    }

    public List<MobileApp> getMobileAppExistListFast() {
        return this.appStore.getMobileAppList();
    }

    public List<MobileApp> getMobileAppExistListFast(boolean z) {
        return this.appStore.getMobileAppList(z);
    }

    public List<MobileApp> getMobileAppUpgradeListFast() {
        return getMobileAppUpgradeListFast(true);
    }

    public List<MobileApp> getMobileAppUpgradeListFast(boolean z) {
        return this.appStore.getMobileAppUpgradeList(z);
    }

    public MobileApp getMobileAppUpgradeFast(String str, boolean z) {
        return this.appStore.getMobileAppUpgrade(str, z);
    }

    public MobileApp getMobileApp(String str) {
        return this.database.getMobileApp(str);
    }

    public List<MobileApp> getMobileAppList() {
        return this.database.getMobileAppList(0);
    }

    public List<MobileApp> getMobileAppExistList() {
        return this.database.getMobileAppList(1);
    }

    public List<MobileApp> getMobileAppUpgradeList() {
        return this.database.getMobileAppList(2);
    }

    public void updateMobileAppUpgradeInfoList(List<UpgradeInfo> list) {
        this.database.updateMobileAppUpgradeInfoList(list);
        this.appStore.handleAction(1, null);
    }

    public int updateMobileAppUpgradeInfo(UpgradeInfo upgradeInfo) {
        int updateMobileAppUpgradeInfo = this.database.updateMobileAppUpgradeInfo(upgradeInfo);
        this.appStore.handleAction(4, getMobileApp(upgradeInfo.getPackageName()));
        return updateMobileAppUpgradeInfo;
    }

    public int setMobileAppNotExist() {
        int allMobileAppNotExist = this.database.setAllMobileAppNotExist();
        this.appStore.handleAction(1, null);
        return allMobileAppNotExist;
    }

    public int deleteMobileAppNotExist() {
        int deleteMobileAppNotExist = this.database.deleteMobileAppNotExist();
        this.appStore.handleAction(1, null);
        return deleteMobileAppNotExist;
    }

    public int clearMobileAppUpgradeInfo() {
        int clearMobileAppUpgradeInfo = this.database.clearMobileAppUpgradeInfo();
        this.appStore.handleAction(1, null);
        return clearMobileAppUpgradeInfo;
    }

    public int clearMobileAppUpgradeInfo(String str) {
        int clearMobileAppUpgradeInfo = this.database.clearMobileAppUpgradeInfo(str);
        this.appStore.handleAction(4, getMobileApp(str));
        return clearMobileAppUpgradeInfo;
    }

    public DownloadInfo getDownloadInfo(String str) {
        return this.database.getDownloadInfo(str);
    }

    public List<DownloadInfo> getDownloadInfoList() {
        return this.database.getDownloadInfoList(0);
    }

    public int ignoreAllUpgrade() {
        int ignoreAllUpgrade = this.database.ignoreAllUpgrade();
        this.appStore.handleAction(1, null);
        return ignoreAllUpgrade;
    }

    public int cancelAllIgnore() {
        int cancelAllIgnore = this.database.cancelAllIgnore();
        this.appStore.handleAction(1, null);
        return cancelAllIgnore;
    }

    public int cancelIgnoreUpgrade(String str) {
        int cancelIgnoreUpgrade = this.database.cancelIgnoreUpgrade(str);
        this.appStore.handleAction(4, getMobileApp(str));
        return cancelIgnoreUpgrade;
    }

    public int ignoreUpgrade(String str, int i) {
        int ignoreUpgrade = this.database.ignoreUpgrade(str, i);
        this.appStore.handleAction(4, getMobileApp(str));
        return ignoreUpgrade;
    }

    public void updateDownloadInfoApkPath(String str, String str2) {
        String md5 = StringUtils.toMd5(str);
        this.database.updateDownloadInfoApkPath(md5, str2);
        this.downloadStore.handleAction(2, getInstance().getDownloadState(md5));
    }

    public void deleteDownloadInfoList(List<DownloadInfo> list) {
        this.database.deleteDownloadInfoList(list);
    }

    public int deleteDownloadInfo(String str) {
        return this.database.deleteDownloadInfo(StringUtils.toMd5(str));
    }

    public int deleteDownloadInfo(DownloadInfo downloadInfo) {
        return this.database.deleteDownloadInfo(downloadInfo);
    }

    public void saveLog(String str, String str2, String str3) {
        this.database.saveLog(str, str2, str3);
    }

    public List<Library> getProjectLibraries() {
        return Library.LibraryProvider.getLibraryList();
    }

    public Cursor getLogs(String str) {
        return this.database.getLogs(str);
    }

    public int cleanLogs(String str) {
        return this.database.cleanLogs(str);
    }

    public void closeDatabase() {
        this.database.close();
    }

    public void addFeedDraft(FeedDraft feedDraft) {
        this.feedDraftCache.addFeedDraft(feedDraft);
    }

    public void removeDraft(FeedDraft feedDraft) {
        this.feedDraftCache.removeDraft(feedDraft);
    }

    public FeedDraft getDraftLike(FeedDraft feedDraft) {
        return this.feedDraftCache.getDraftLike(feedDraft);
    }

    public Observable<List<PermissionItem>> getPermissionList(final List<String> list, final PackageManager packageManager) {
        return Observable.create(new Observable.OnSubscribe<List<PermissionItem>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass22 */

            public void call(Subscriber<? super List<PermissionItem>> subscriber) {
                ArrayList arrayList = new ArrayList();
                List<String> list = list;
                if (list != null) {
                    for (String str : list) {
                        PermissionItem.Builder builder = PermissionItem.builder();
                        try {
                            int i = 0;
                            PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, 0);
                            int i2 = permissionInfo.protectionLevel & 15;
                            if (i2 != 0) {
                                i = i2 != 1 ? i2 != 2 ? -1 : 2 : 1;
                            }
                            builder.label(permissionInfo.loadLabel(packageManager)).sourceString(str).description(permissionInfo.loadDescription(packageManager)).group(permissionInfo.group).level(i);
                        } catch (PackageManager.NameNotFoundException unused) {
                            builder.label(str);
                        }
                        arrayList.add(builder.build());
                    }
                    Collections.sort(arrayList, new Comparator<PermissionItem>() {
                        /* class com.coolapk.market.manager.DataManager.AnonymousClass22.AnonymousClass1 */
                        private final Collator sCollator = Collator.getInstance();

                        public int compare(PermissionItem permissionItem, PermissionItem permissionItem2) {
                            int signum = Integer.signum(permissionItem2.level() - permissionItem.level());
                            return signum == 0 ? this.sCollator.compare(permissionItem.label(), permissionItem2.label()) : signum;
                        }
                    });
                }
                subscriber.onNext(arrayList);
                subscriber.onCompleted();
            }
        });
    }

    private static class InternalOnDownloadListener implements OnDownloadListener {
        private DownloadStore downloadStore;
        private final String key;

        public InternalOnDownloadListener(String str, DownloadStore downloadStore2) {
            this.downloadStore = downloadStore2;
            this.key = DownloadState.generateUriKey(str);
        }

        @Override // com.coolapk.market.download.OnDownloadListener
        public void onDownloadJobWait(DownloadJob downloadJob) {
            DownloadState.Builder builder;
            DownloadState downloadState = this.downloadStore.getDownloadState(this.key);
            if (downloadState == null) {
                builder = DownloadState.newBuilder(downloadJob.getUrl());
                builder.currentLength(0);
                builder.totalLength(0);
            } else {
                builder = DownloadState.newBuilder(downloadState);
            }
            Extra extra = downloadJob.getExtra();
            if (DataManager.getInstance().downloadStartInterceptor != null) {
                extra = DataManager.getInstance().downloadStartInterceptor.intercept(downloadJob);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.downloadStore.handleAction(1, builder.state(1).extra(extra).startTime(currentTimeMillis).updateTime(currentTimeMillis).fileName(downloadJob.getFileName()).build());
        }

        @Override // com.coolapk.market.download.OnDownloadListener
        public void onDownloadJobStart(DownloadJob downloadJob) {
            DownloadState downloadState = this.downloadStore.getDownloadState(this.key);
            if (downloadState == null) {
                LogUtils.wtf("What!? can not find download state here", new Object[0]);
                return;
            }
            this.downloadStore.handleAction(1, DownloadState.newBuilder(downloadState).state(2).updateTime(System.currentTimeMillis()).fileName(downloadJob.getFileName()).build());
        }

        @Override // com.coolapk.market.download.OnDownloadListener
        public void onDownloadJobRunning(DownloadJob downloadJob) {
            DownloadState downloadState = this.downloadStore.getDownloadState(this.key);
            if (downloadState == null) {
                LogUtils.wtf("What!? can not find download state here", new Object[0]);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.downloadStore.handleAction(1, DownloadState.newBuilder(downloadState).updateTime(currentTimeMillis).state(3).currentLength(downloadJob.getCurrentLength()).totalLength(downloadJob.getTotalLength()).filePath(downloadJob.getTemporaryFile().getAbsolutePath()).fileName(downloadJob.getFileName()).diffTime(currentTimeMillis - downloadState.getUpdateTime()).diffLength(downloadJob.getCurrentLength() - downloadState.getCurrentLength()).build());
        }

        @Override // com.coolapk.market.download.OnDownloadListener
        public void onDownloadJobSuccess(DownloadJob downloadJob) {
            DownloadState downloadState = this.downloadStore.getDownloadState(this.key);
            if (downloadState == null) {
                LogUtils.wtf("What!? can not find download state here", new Object[0]);
            } else {
                this.downloadStore.handleAction(1, DownloadState.newBuilder(downloadState).updateTime(System.currentTimeMillis()).state(4).currentLength(downloadJob.getCurrentLength()).totalLength(downloadJob.getTotalLength()).filePath(downloadJob.getStoreFile() != null ? downloadJob.getStoreFile().getAbsolutePath() : "").fileName(downloadJob.getFileName()).mimeType(CoolFileUtils.getMimeTypeFromExtension(downloadJob.getFileExtension())).build());
            }
        }

        @Override // com.coolapk.market.download.OnDownloadListener
        public void onDownloadJobCancel(DownloadJob downloadJob) {
            DownloadState downloadState = this.downloadStore.getDownloadState(this.key);
            if (downloadState == null) {
                LogUtils.wtf("What!? can not find download state here", new Object[0]);
                return;
            }
            long currentLength = downloadState.getCurrentLength();
            long totalLength = downloadState.getTotalLength();
            String mimeType = downloadState.getMimeType();
            DownloadState.Builder state = DownloadState.newBuilder(downloadState).updateTime(System.currentTimeMillis()).state(5);
            if (downloadJob.getCurrentLength() != 0) {
                currentLength = downloadJob.getCurrentLength();
            }
            DownloadState.Builder currentLength2 = state.currentLength(currentLength);
            if (downloadJob.getTotalLength() != 0) {
                totalLength = downloadJob.getTotalLength();
            }
            DownloadState.Builder fileName = currentLength2.totalLength(totalLength).filePath(downloadJob.getTemporaryFile().getAbsolutePath()).fileName(downloadJob.getFileName());
            if (downloadJob.getFileExtension() != null) {
                mimeType = CoolFileUtils.getMimeTypeFromExtension(downloadJob.getFileExtension());
            }
            this.downloadStore.handleAction(1, fileName.mimeType(mimeType).build());
        }

        @Override // com.coolapk.market.download.OnDownloadListener
        public void onDownloadJobError(DownloadJob downloadJob, Throwable th) {
            DownloadState downloadState = this.downloadStore.getDownloadState(this.key);
            if (downloadState == null) {
                LogUtils.wtf("What!? can not find download state here", new Object[0]);
                return;
            }
            long currentLength = downloadState.getCurrentLength();
            long totalLength = downloadState.getTotalLength();
            String mimeType = downloadState.getMimeType();
            DownloadState.Builder state = DownloadState.newBuilder(downloadState).updateTime(System.currentTimeMillis()).state(6);
            if (downloadJob.getCurrentLength() != 0) {
                currentLength = downloadJob.getCurrentLength();
            }
            DownloadState.Builder currentLength2 = state.currentLength(currentLength);
            if (downloadJob.getTotalLength() != 0) {
                totalLength = downloadJob.getTotalLength();
            }
            DownloadState.Builder fileName = currentLength2.totalLength(totalLength).filePath(downloadJob.getTemporaryFile().getAbsolutePath()).fileName(downloadJob.getFileName());
            if (downloadJob.getFileExtension() != null) {
                mimeType = CoolFileUtils.getMimeTypeFromExtension(downloadJob.getFileExtension());
            }
            this.downloadStore.handleAction(1, fileName.mimeType(mimeType).error(th).build());
        }
    }

    private static class InternalProcessorCallback extends ProcessorCallback {
        private final DbHelper database;
        private final Extra extra;
        private final String filePath;
        private final String from;
        private final InstallStore installStore;
        private final String key;

        public InternalProcessorCallback(DbHelper dbHelper, InstallStore installStore2, String str, String str2, Extra extra2) {
            this.database = dbHelper;
            this.installStore = installStore2;
            this.from = str;
            this.extra = extra2;
            this.filePath = str2;
            this.key = InstallState.generateUriKey(str2);
        }

        public void onStart() {
            InstallState.Builder builder;
            LogUtils.v("Start install file: from: %s, filePath: %s, extra: %s", this.from, this.filePath, this.extra);
            InstallState installState = this.installStore.getInstallState(this.key);
            long currentTimeMillis = System.currentTimeMillis();
            if (installState == null) {
                builder = InstallState.newBuilder();
                builder.startTime(currentTimeMillis);
            } else {
                builder = InstallState.newBuilder(installState);
            }
            this.installStore.handleAction(1, builder.state(2).updateTime(currentTimeMillis).from(this.from).path(this.filePath).extra(this.extra).build());
        }

        @Override // com.coolapk.market.processor.PatchFileProcessor.Callback
        public void onPatch() {
            LogUtils.v("Patch file: from: %s, filePath: %s, extra: %s", this.from, this.filePath, this.extra);
            InstallState installState = this.installStore.getInstallState(this.key);
            if (installState == null) {
                LogUtils.wtf("What!? can not find install state here", new Object[0]);
            } else {
                this.installStore.handleAction(1, InstallState.newBuilder(installState).state(3).updateTime(System.currentTimeMillis()).build());
            }
        }

        @Override // com.coolapk.market.processor.ExtendApkFileProcessor.Callback, com.coolapk.market.processor.ExtendApkFileProcessor2.Callback
        public void onUnpacking() {
            LogUtils.v("Unpacking file: from: %s, filePath: %s, extra: %s", this.from, this.filePath, this.extra);
            InstallState installState = this.installStore.getInstallState(this.key);
            if (installState == null) {
                LogUtils.wtf("What!? can not find install state here", new Object[0]);
            } else {
                this.installStore.handleAction(1, InstallState.newBuilder(installState).state(4).updateTime(System.currentTimeMillis()).build());
            }
        }

        @Override // com.coolapk.market.processor.ApkFileProcessor.Callback
        public void onVerify() {
            LogUtils.v("Verify file: from: %s, filePath: %s, extra: %s", this.from, this.filePath, this.extra);
            InstallState installState = this.installStore.getInstallState(this.key);
            if (installState == null) {
                LogUtils.wtf("What!? can not find install state here", new Object[0]);
            } else {
                this.installStore.handleAction(1, InstallState.newBuilder(installState).state(5).updateTime(System.currentTimeMillis()).build());
            }
        }

        @Override // com.coolapk.market.processor.ApkFileProcessor.Callback
        public void onInstalling() {
            LogUtils.v("Installing file: from: %s, filePath: %s, extra: %s", this.from, this.filePath, this.extra);
            InstallState installState = this.installStore.getInstallState(this.key);
            if (installState == null) {
                LogUtils.wtf("What!? can not find install state here", new Object[0]);
            } else {
                this.installStore.handleAction(1, InstallState.newBuilder(installState).state(6).updateTime(System.currentTimeMillis()).build());
            }
        }

        public void onComplete(String str, int i, String str2) {
            LogUtils.v("Complete install file: from: %s, filePath: %s, extra: %s", this.from, this.filePath, this.extra);
            InstallState installState = this.installStore.getInstallState(this.key);
            if (installState == null) {
                LogUtils.wtf("What!? can not find install state here", new Object[0]);
                return;
            }
            InstallState build = InstallState.newBuilder(installState).state(7).updateTime(System.currentTimeMillis()).apkFilePath(str).errorCode(i).errorMessage(str2).build();
            this.installStore.handleAction(1, build);
            String from2 = build.getFrom();
            if (!TextUtils.isEmpty(from2)) {
                this.database.updateDownloadInfoApkPath(StringUtils.toMd5(from2), str);
            }
        }
    }

    public Observable<ResponseBody> reportHijack(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        return this.coolMarketService.reportHijack(str, str2, str3, str4, str5, str6, i);
    }

    public Observable<ResponseBody> reportUnknown(String str, String str2, String str3) {
        return this.coolMarketService.reportUnknown(str, str2, str3);
    }

    public Observable<ResponseBody> reportExposure(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return this.coolMarketService.reportExposure(jSONArray.toString());
    }

    public Observable<ResponseBody> reportSponsorClose(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        return this.coolMarketService.reportSponsorClose(str, str2, str3, str4, str5, str6, str7, str8, i);
    }

    public Observable<ResponseBody> reportCoupon(String str, int i, String str2) {
        return this.coolMarketService.reportCoupon(str, i, str2);
    }

    public Observable<Result<String>> verifyDownloadUrl(String str, String str2, String str3) {
        return this.coolMarketService.verifyDownloadUrl(str, str2, str3);
    }

    public Observable<Result<AppForum>> getAppForumDetail(String str, int i, String str2) {
        return this.coolMarketService.getAppForumDetail(str, i, str2);
    }

    public Observable<Result<List<Feed>>> getAppForumCommentList(String str, String str2, int i, String str3, String str4, int i2) {
        return this.coolMarketService.getAppForumCommentList(str, str2, i, str3, str4, i2);
    }

    public Observable<Result<Map<String, String>>> followAppForum(String str) {
        return this.coolMarketService.followAppForum(str);
    }

    public Observable<Result<Map<String, String>>> unfollowAppForum(String str) {
        return this.coolMarketService.unfollowAppForum(str);
    }

    public Observable<Result<String>> getCountryList() {
        return this.coolMarketService.getCountryList();
    }

    public long insertArticle(String str, String str2, String str3) {
        return this.database.insertArticle(str, str2, str3);
    }

    public int updateArticle(long j, String str, String str2, String str3) {
        return this.database.updateArticle(j, str, str2, str3);
    }

    public int deleteArticle(long j) {
        return this.database.deleteArticle(j);
    }

    public List<Article> getArticles() {
        Cursor articles = this.database.getArticles();
        ArrayList arrayList = new ArrayList(articles.getCount());
        while (articles.moveToNext()) {
            try {
                arrayList.add(DbConst.ArticleTable.parseCursor(articles));
            } finally {
                articles.close();
            }
        }
        return arrayList;
    }

    public Article getLatestArticle() {
        List<Article> articles = getArticles();
        if (!CollectionUtils.isEmpty(articles)) {
            return articles.get(0);
        }
        return null;
    }

    public Gson getGson() {
        return this.gson;
    }

    public Observable<Result<DyhModel>> getDyhDetail(String str) {
        return this.coolMarketService.getDyhDetail(str);
    }

    public Observable<Result<List<Entity>>> getDyhList(int i, String str, String str2) {
        return this.coolMarketService.getDyhList("", "", i, str, str2);
    }

    public Observable<Result<List<Entity>>> getMyEditorDyhList(int i, int i2, int i3, String str, String str2) {
        return this.coolMarketService.getMyEditorDyhList(i, i2, i3, str, str2);
    }

    public Observable<Result<List<Entity>>> getMyEditorDyhList(int i, int i2, String str, String str2) {
        return this.coolMarketService.getMyEditorDyhList(i, 0, i2, str, str2);
    }

    public Observable<Result<List<Entity>>> getDyhList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getDyhList(str, "", i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getDyhList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getDyhList(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getArticleList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getArticleList(str, str2, i, str3, str4);
    }

    public Observable<Result<DyhArticle>> getDyhArticleDetail(String str) {
        return this.coolMarketService.getDyhArticleDetail(str, null);
    }

    public Observable<Result<DyhArticle>> getDyhArticleDetail(String str, String str2) {
        return this.coolMarketService.getDyhArticleDetail(str, str2);
    }

    public Observable<Result<List<Entity>>> getUserDyhList() {
        return this.coolMarketService.getUserDyhList();
    }

    public Observable<Result<List<Entity>>> getUserFollowDyhList(int i, String str, String str2) {
        return this.coolMarketService.getUserFollowDyhList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getDyhChannelList(int i, String str, String str2) {
        return this.coolMarketService.getDyhChannelList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getMianUserFollowDyhList(int i, String str, String str2) {
        return this.coolMarketService.getMainUserFollowDyhList(i, str, str2);
    }

    public Observable<Result<List<Entity>>> getFollowMore() {
        return this.coolMarketService.getFollowMore();
    }

    public Observable<Result<String>> followDyh(String str) {
        return this.coolMarketService.followDyh(str);
    }

    public Observable<Result<String>> unFollowDyh(String str) {
        return this.coolMarketService.unFollowDyh(str);
    }

    public Observable<Result<Integer>> dyhArticleLike(String str) {
        return this.coolMarketService.dyhArticleLike(str);
    }

    public Observable<Result<String>> includFeed(String str, String str2) {
        return this.coolMarketService.includFeed(str, str2, 1);
    }

    public Observable<Result<String>> includFeed(String str, String str2, int i) {
        return this.coolMarketService.includFeed(str, str2, i);
    }

    public Observable<Result<String>> includFeedRemove(String str) {
        return this.coolMarketService.changeDescendFeed(str, 2);
    }

    public Observable<Result<String>> includFeedAdd(String str) {
        return this.coolMarketService.changeDescendFeed(str, 1);
    }

    public Observable<Result<String>> includFeedShare(String str, String str2) {
        return this.coolMarketService.includFeed(str, str2, 2);
    }

    public Observable<Result<Integer>> dyhArticleUnLike(String str) {
        return this.coolMarketService.dyhArticleUnLike(str);
    }

    public Observable<Result<String>> onStick(String str, int i) {
        return this.coolMarketService.onStick(str, i);
    }

    public Observable<Result<Integer>> dyhArticleFavorite(String str) {
        return this.coolMarketService.dyhArticleFavorite(str);
    }

    public Observable<Result<Integer>> dyhArticleUnFavorite(String str) {
        return this.coolMarketService.dyhArticleUnFavorite(str);
    }

    public Observable<Result<String>> onArticleBlock(String str) {
        return this.coolMarketService.onArticleBlock(str);
    }

    public Observable<Result<String>> onArticleUnBlock(String str) {
        return this.coolMarketService.onArticleUnBlock(str);
    }

    public Observable<Result<String>> onArticleDelete(String str) {
        return this.coolMarketService.onArticleDelete(str);
    }

    public Observable<Result<String>> onArticleRemove(String str, int i, String str2) {
        return this.coolMarketService.onArticleRemove(str, i, str2);
    }

    public Observable<Result<String>> onArticleRecommend(String str) {
        return this.coolMarketService.onArticleRecommend(str);
    }

    public Observable<Result<String>> onArticleUnRecommend(String str) {
        return this.coolMarketService.onArticleUnRecommend(str);
    }

    public Observable<Result<String>> articleAddToHeadlineV8(String str, String str2) {
        return this.coolMarketService.articleAddToHeadlineV8(str, str2);
    }

    public Observable<Result<String>> articleRemoveFromHeadlineV8(String str, String str2) {
        return this.coolMarketService.articleRemoveFromHeadlineV8(str, str2);
    }

    public Observable<Result<String>> articleAddToEditorChoice(String str, String str2) {
        return this.coolMarketService.articleAddToEditorChoice(str, str2);
    }

    public Observable<Result<String>> articleRemoveFromEditorChoice(String str, String str2) {
        return this.coolMarketService.articleRemoveFromEditorChoice(str, str2);
    }

    public Observable<Result<List<AlbumItem>>> getAlbumApkList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getAlbumApkList(str, i, str2, str3);
    }

    public Observable<Result<List<AlbumItem>>> getAlbumAllApkList(String str) {
        return this.coolMarketService.getAlbumAllApkList(str);
    }

    public Observable<Result<String>> unsetMessageStatus(String str) {
        return this.coolMarketService.unsetMessageStatus(str);
    }

    public Observable<Result<String>> articleSoftRemove(String str, String str2) {
        return this.coolMarketService.articleSoftRemove(str, str2);
    }

    public Observable<Result<String>> dyhArticleRemoveInclude(String str, String str2) {
        return this.coolMarketService.dyhArticleRemoveInclude(str, str2);
    }

    public Observable<Result<String>> cancelReportSpam(String str, String str2) {
        return this.coolMarketService.cancelReportSpam(str, str2);
    }

    public Observable<ResponseBody> getUserSpamWordList() {
        return this.coolMarketService.getUserSpamWordList();
    }

    public Observable<ResponseBody> loadConfig(String str) {
        return this.coolMarketService.loadConfig(str);
    }

    public Observable<Result<String>> updateTitleConfig(String str, String str2) {
        return this.coolMarketService.updateConfig(str, str2);
    }

    public Observable<Result<JSONArray>> getAvatarCoverList() {
        return this.coolMarketService.getAvatarCoverList();
    }

    public Observable<Result<ImInfo>> getImInfo(String str) {
        return this.coolMarketService.getImInfo(str);
    }

    public Observable<Result<String>> changeAvatarCover(String str) {
        return this.coolMarketService.changeAvatarCover(str);
    }

    public Entity parseJsonToEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JsonObject asJsonObject = new JsonParser().parse(str).getAsJsonObject();
            return EntityConvertUtils.handleType(this.gson, asJsonObject, asJsonObject.get("entityType").getAsString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Entity parseJsonToEntity(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return EntityConvertUtils.handleType(this.gson, new JsonParser().parse(str).getAsJsonObject(), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Entity parseJsonToEntity(JsonObject jsonObject, String str, String str2) {
        try {
            return EntityConvertUtils.handleType(this.gson, jsonObject, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Entity> List<T> parseJsonArrayToEntity(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JsonArray asJsonArray = new JsonParser().parse(str).getAsJsonArray();
            for (int i = 0; i < asJsonArray.size(); i++) {
                arrayList.add(EntityConvertUtils.handleType(this.gson, asJsonArray.get(i).getAsJsonObject(), str2));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public List<Entity> parseJsonToEntities(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        try {
            JsonElement jsonElement = jsonObject.get("data");
            if (jsonElement == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it2 = jsonElement.getAsJsonArray().iterator();
            while (it2.hasNext()) {
                JsonObject asJsonObject = it2.next().getAsJsonObject();
                Entity handleType = EntityConvertUtils.handleType(this.gson, asJsonObject, asJsonObject.get("entityType").getAsString());
                if (handleType != null) {
                    arrayList.add(handleType);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Observable<Result<Live>> getLiveDetail(String str) {
        return this.coolMarketService.getLiveDetail(str);
    }

    public Observable<Result<List<Entity>>> getLiveTopicList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getLiveTopicList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getLiveProductList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getLiveProductList(str, i, str2, str3);
    }

    public Observable<Result<List<Entity>>> getLiveMessageList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getLiveMessageList(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getBackupList(int i, String str, String str2) {
        return this.coolMarketService.getBackupList(i, str, str2);
    }

    public Observable<Result<String>> checkBackupTitle(String str) {
        return this.coolMarketService.checkBackupTitle(str);
    }

    public Observable<ResponseBody> createBackupList(String str, int i, String str2) {
        return this.coolMarketService.createBackupList(str, i, str2);
    }

    public Observable<Result<BackupInfo>> coverPic(String str, String str2) {
        return this.coolMarketService.coverPic(str, str2);
    }

    public Observable<Result<BackupInfo>> getBackupDetail(String str) {
        return this.coolMarketService.getBackupDetail(str);
    }

    public Observable<Result<String>> deleteBackup(String str) {
        return this.coolMarketService.deleteBackup(str);
    }

    public Observable<Result<String>> checkCount() {
        return this.coolMarketService.checkCount();
    }

    public Observable<Result<DeviceInfo>> getDeviceInfo() {
        return this.coolMarketService.getDeviceInfo();
    }

    public Observable<Result<String>> followLive(String str, boolean z) {
        if (z) {
            return this.coolMarketService.followLive(str);
        }
        return this.coolMarketService.unfollowLive(str);
    }

    public Observable<Result<String>> addLiveBroadcast(String str, String str2) {
        return this.coolMarketService.addLiveBroadcast(str, str2);
    }

    public Observable<Result<List<Entity>>> getCollectionItemList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getCollectionItemList(str, i, str2, str3);
    }

    public Observable<Result<Collection>> getCollectionDetail(String str) {
        return this.coolMarketService.getCollection(str);
    }

    public Observable<Result<String>> removeUnUseItem(String str) {
        return this.coolMarketService.removeUnUseItem(str);
    }

    public Observable<ResponseBody> addToCollection(String str, String str2, String str3, String str4) {
        return this.coolMarketService.addToCollection(str, str2, str3, str4);
    }

    public Observable<Result<List<Entity>>> getCollectionList(String str, String str2, int i, String str3, int i2, String str4, String str5) {
        return this.coolMarketService.getCollectionList(str, str2, str3, i, i2, str4, str5);
    }

    public Observable<Result<List<Entity>>> getUserCollectionList(String str, int i, String str2, String str3) {
        return this.coolMarketService.getUserCollectionList(str, 0, i, str2, str3);
    }

    public Observable<Result<Collection>> createCollection(final Collection collection) {
        return Observable.defer(new Func0<Observable<Result<Collection>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass23 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Collection>> call() {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM).addFormDataPart("isOpen", String.valueOf(collection.getIsOpen())).addFormDataPart("pic", StringUtils.notNull(collection.getCoverPic())).addFormDataPart("description", StringUtils.notNull(collection.getDescription())).addFormDataPart("title", StringUtils.notNull(collection.getTitle())).addFormDataPart("sourceId", StringUtils.notNull(collection.getSourceId()));
                return DataManager.this.coolMarketService.createCollection(builder.build());
            }
        });
    }

    public Observable<Result<Collection>> updateCollection(final Collection collection) {
        return Observable.defer(new Func0<Observable<Result<Collection>>>() {
            /* class com.coolapk.market.manager.DataManager.AnonymousClass24 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<Result<Collection>> call() {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM).addFormDataPart("id", collection.getId()).addFormDataPart("isOpen", String.valueOf(collection.getIsOpen())).addFormDataPart("pic", StringUtils.notNull(collection.getCoverPic())).addFormDataPart("description", StringUtils.notNull(collection.getDescription())).addFormDataPart("title", StringUtils.notNull(collection.getTitle())).addFormDataPart("sourceId", StringUtils.notNull(collection.getSourceId()));
                return DataManager.this.coolMarketService.updateCollection(builder.build());
            }
        });
    }

    public Observable<Result<Collection>> editCollection(Collection collection) {
        CoolMarketService.RemoteService remoteService = this.coolMarketService;
        String id = collection.getId();
        String title = collection.getTitle();
        String description = collection.getDescription();
        String coverPic = collection.getCoverPic();
        return remoteService.editCollection(id, title, description, coverPic, collection.getIsOpen() + "");
    }

    public Observable<Result<String>> deleteLiveMessage(String str, String str2) {
        return this.coolMarketService.deleteLiveMessage(str, str2);
    }

    public Observable<Result<String>> deleteAllMessageByUid(String str, String str2, int i) {
        return this.coolMarketService.deleteAllMessageByUid(str, str2, i);
    }

    public Observable<Result<String>> disallowLiveUser(String str, String str2, int i) {
        return this.coolMarketService.disallowLiveUser(str, str2, i);
    }

    public Observable<Result<String>> undisallowLiveUser(String str, String str2, int i) {
        return this.coolMarketService.undisallowLiveUser(str, str2, i);
    }

    public Observable<Result<String>> changeLiveStatus(String str, String str2, int i) {
        return this.coolMarketService.changeLiveStatus(str, str2, i);
    }

    public Observable<Result<List<LiveUser>>> getLiveBannedUserList(String str, int i, int i2, String str2, String str3) {
        return this.coolMarketService.getLiveBannedUserList(str, i, i2, str2, str3);
    }

    public Observable<Result<String>> deleteCollection(String str) {
        return this.coolMarketService.deleteCollection(str);
    }

    public Observable<Result<Integer>> likeCollection(String str) {
        return this.coolMarketService.likeCollection(str);
    }

    public Observable<Result<Integer>> unLikeCollection(String str) {
        return this.coolMarketService.unLikeCollection(str);
    }

    public Observable<Result<Integer>> followCollection(String str) {
        return this.coolMarketService.followCollection(str);
    }

    public Observable<Result<Integer>> unFollowCollection(String str) {
        return this.coolMarketService.unFollowCollection(str);
    }

    public Observable<Result<String>> checkCollectionCount() {
        return this.coolMarketService.checkCollectionCount();
    }

    public Observable<Result<String>> topCollectionItem(String str, int i) {
        return this.coolMarketService.topCollectionItem(str, i);
    }

    public Observable<Result<String>> removeCollectionItem(String str) {
        return this.coolMarketService.removeCollectionItem(str);
    }

    public Observable<Result<String>> cancelFollow(String str, String str2) {
        return this.coolMarketService.cancelFollow(str, str2);
    }

    public Observable<Result<FileDetail>> getFileDetail(String str) {
        return this.coolMarketService.getFileDetail(str);
    }

    public Observable<Result<String>> deleteFeedFromUploadFileLog(String str) {
        return this.coolMarketService.deleteFeedFromUploadFileLog(str);
    }

    public Observable<Result<String>> changeFileStatus(String str, String str2) {
        return this.coolMarketService.changeFileStatus(str, str2);
    }

    public Observable<Result<String>> changeFileStatusToBlock(String str) {
        return this.coolMarketService.changeFileStatus(str, "block");
    }

    public Observable<Result<String>> changeFileStatusToFobid(String str) {
        return this.coolMarketService.changeFileStatus(str, "forbid");
    }

    public Observable<Result<List<Entity>>> getCoolPicList(String str, String str2, String str3, String str4) {
        return this.coolMarketService.getCoolPicList(str, str2, str3, str4);
    }

    public Observable<Result<List<ProductBrand>>> getershouProductBrandList() {
        return this.coolMarketService.getProductBrandList();
    }

    public Observable<Result<List<Entity>>> getershouProductSeries(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getProductSeries(str, str2, i, str3, str4);
    }

    public Observable<Result<List<Entity>>> getProductConfig(String str, String str2, String str3) {
        return this.coolMarketService.getProductConfig(str3, str2, str);
    }

    public Observable<Result<Feed>> changeStatus(String str, String str2) {
        return this.coolMarketService.changeStatus(str, str2);
    }

    public Observable<Result<Integer>> onCheckAgree() {
        return this.coolMarketService.onCheckAgree();
    }

    public Observable<Result<Integer>> agreement() {
        return this.coolMarketService.agreement();
    }

    public Observable<Result<String>> checkUrl(String str) {
        return this.coolMarketService.checkUrl(str);
    }

    public Observable<Result<String>> getAgreementDetail() {
        return this.coolMarketService.getAgreementDetail();
    }

    public Observable<Result<List<Entity>>> loadCardConfig(String str) {
        return this.coolMarketService.loadCardConfig(str);
    }

    public Observable<Result<String>> updateTitleConfig(String str) {
        return updateConfig("my_page_card_config", str);
    }

    public Observable<Result<String>> updateConfig(String str, String str2) {
        return this.coolMarketService.updateConfig(str, str2);
    }

    public Observable<ResponseBody> myPageCardManage() {
        return this.coolMarketService.myPageCardManage("my_page_card_config");
    }

    public Observable<Result<String>> updateBindGoods(String str, String str2) {
        return this.coolMarketService.updateBindGoods(str, str2);
    }

    public Observable<Result<List<Entity>>> getGoodsList(String str, String str2, int i, String str3, String str4) {
        return this.coolMarketService.getFunThingsList(str, str2, i, str3, str4);
    }

    public Observable<Result<String>> deleteFunThings(String str) {
        return this.coolMarketService.deleteFunThings(str);
    }

    public Observable<Result<String>> deleteGoods(String str, String str2) {
        return this.coolMarketService.deleteGoods(str, str2);
    }

    public Observable<Result<String>> editGoodsList(String str, String str2, String str3, String str4) {
        return this.coolMarketService.editGoodsList(str, str2, str3, str4);
    }

    public Observable<Result<String>> createFunThings(String str, String str2, String str3) {
        return this.coolMarketService.createFunThings(str, str2, str3);
    }

    public Observable<Result<String>> addGoodsOrNote(String str, String str2, String str3, boolean z) {
        if (z) {
            return editGoodsNote(str, str2, str3);
        }
        return this.coolMarketService.addGoods(str, str2, str3);
    }

    public Observable<Result<String>> addGoodsToList(String str, String str2, String str3, String str4) {
        return this.coolMarketService.addGoods(str, str3, str4);
    }

    public Observable<Result<List<Entity>>> goodsSearch(String str, String str2, String str3, int i, int i2, String str4, String str5) {
        return this.coolMarketService.goodsSearch(str, str2, str3, i, i2, str4, str5);
    }

    public Observable<Result<String>> editGoodsNote(String str, String str2, String str3) {
        return this.coolMarketService.editGoodsNote(str, str2, str3);
    }

    public Observable<Result<String>> editGoodsListDisplayOrder(String str, String str2) {
        return this.coolMarketService.editGoodsListDisplayOrder(str, str2);
    }

    public Observable<Result<FeedGoods>> getGoods(String str) {
        return this.coolMarketService.addGoods(str);
    }

    public Observable<Result<String>> getGoodsSearchHotWords() {
        return this.coolMarketService.getGoodsSearchHotWords();
    }

    public Observable<Result<String>> clearHeadlineCache() {
        return this.coolMarketService.clearHeadlineCache();
    }

    public Observable<ResponseBody> getHttpInfo() {
        return this.coolMarketService.getHttpInfo();
    }

    public Observable<Result<String>> updateEditorTitle(String str, String str2) {
        return this.coolMarketService.updateEditorTitle(str, str2);
    }
}
