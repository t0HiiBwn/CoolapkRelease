package com.coolapk.market.manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.Data;
import com.blankj.utilcode.util.AppUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedDraft;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.LocationInfo;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.service.AppService;
import com.coolapk.market.service.DownloadService;
import com.coolapk.market.service.PackageService;
import com.coolapk.market.service.install.InstallJob;
import com.coolapk.market.service.work.ReportWorker;
import com.coolapk.market.service.work.StatWorker;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.CustomTabsUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.RxLogin;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.TestActivity;
import com.coolapk.market.view.album.UserAlbumListActivity;
import com.coolapk.market.view.album.albumv8.AlbumDetailActivity;
import com.coolapk.market.view.album.albumv8.AlbumEditActivity;
import com.coolapk.market.view.album.albumv8.TextViewActivity;
import com.coolapk.market.view.album.pick.AlbumPickAppTabActivity;
import com.coolapk.market.view.app.AppDetailActivity;
import com.coolapk.market.view.app.DeveloperAppsFragment;
import com.coolapk.market.view.app.GiftListFragment;
import com.coolapk.market.view.app.HistoryVersionFragment;
import com.coolapk.market.view.app.PermissionFragment;
import com.coolapk.market.view.app.RelateDataListActivity;
import com.coolapk.market.view.app.RelatedAlbumsFragment;
import com.coolapk.market.view.app.RelatedAppsFragment;
import com.coolapk.market.view.appmanager.AppManagerActivity;
import com.coolapk.market.view.appmanager.DownloadManagerActivity;
import com.coolapk.market.view.appmanager.UpgradeManagerActivity;
import com.coolapk.market.view.backupList.BackupDetailListActivity;
import com.coolapk.market.view.backupList.BackupListActivity;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.FullScreenActivity;
import com.coolapk.market.view.base.SimpleActivity;
import com.coolapk.market.view.base.SimpleAlphaActivity;
import com.coolapk.market.view.block.BlockCategoryFragment;
import com.coolapk.market.view.block.BlockNodeListFragment;
import com.coolapk.market.view.block.BlockUserListFragment;
import com.coolapk.market.view.block.BlockWordListFragment;
import com.coolapk.market.view.category.AppCategoryDetailActivity;
import com.coolapk.market.view.center.CenterMoreFragment;
import com.coolapk.market.view.center.DeveloperAppListFragment;
import com.coolapk.market.view.center.MyCardManagerActivity;
import com.coolapk.market.view.center.UserHtmlFeedListFragment;
import com.coolapk.market.view.center.UserQAListFragment;
import com.coolapk.market.view.collectionList.CollectionDetailActivity;
import com.coolapk.market.view.collectionList.CollectionListFragment;
import com.coolapk.market.view.collectionList.CollectionSelectActivity;
import com.coolapk.market.view.collectionList.CreateCollectionActivity;
import com.coolapk.market.view.contact.ContactPickActivityV9;
import com.coolapk.market.view.contact.FansListActivity;
import com.coolapk.market.view.contact.FriendListActivity;
import com.coolapk.market.view.contact.UserPickActivity;
import com.coolapk.market.view.dyhv8.DyhArticleDetailActivity;
import com.coolapk.market.view.dyhv8.DyhDetailActivity;
import com.coolapk.market.view.dyhv8.DyhIncludActivity;
import com.coolapk.market.view.dyhv8.DyhListActivity;
import com.coolapk.market.view.feed.AdminFeedFragment;
import com.coolapk.market.view.feed.AdminFeedReplyFragment;
import com.coolapk.market.view.feed.AllFeedActivity;
import com.coolapk.market.view.feed.EditorChoiceActivity;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.view.feed.FeedReplyDetailActivity;
import com.coolapk.market.view.feed.ForwardEntityActivity;
import com.coolapk.market.view.feed.LocalRelateDataListFragment;
import com.coolapk.market.view.feed.ReplyActivity;
import com.coolapk.market.view.feed.ShareWebviewActivity;
import com.coolapk.market.view.feed.SpamActivity;
import com.coolapk.market.view.feed.SpamFeedListFragment;
import com.coolapk.market.view.feed.SpamFeedReplyListFragment;
import com.coolapk.market.view.feed.folded.AllBlockFeedActivity;
import com.coolapk.market.view.feed.folded.BlockFeedListFragment;
import com.coolapk.market.view.feed.pick.NodeRecommendPickerActivity;
import com.coolapk.market.view.feed.pick.PickAppTabActivity;
import com.coolapk.market.view.feed.post.NearbyLocationActivity;
import com.coolapk.market.view.feed.reply.ArticlePreviewFragment;
import com.coolapk.market.view.feedv8.BaseFeedContentHolder;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.view.feedv8.FeedConvertUtilsKt;
import com.coolapk.market.view.feedv8.FeedEntranceV8Activity;
import com.coolapk.market.view.feedv8.FeedFollowerListFragment;
import com.coolapk.market.view.feedv8.PickPicCategoryFragment;
import com.coolapk.market.view.feedv8.QuestionTitleActivity;
import com.coolapk.market.view.feedv8.ShareFeedV8Activity;
import com.coolapk.market.view.feedv8.SubmitFeedV8Activity;
import com.coolapk.market.view.feedv8.TopicPickerActivity;
import com.coolapk.market.view.feedv8.draft.DraftListFragment;
import com.coolapk.market.view.feedv8.draft.RoughDraft;
import com.coolapk.market.view.file.FileViewActivity;
import com.coolapk.market.view.file.LogFileFragment;
import com.coolapk.market.view.goods.GoodsCouponSearchActivity;
import com.coolapk.market.view.goods.GoodsSearchActivity;
import com.coolapk.market.view.goods.MyGoodsTabListActivity;
import com.coolapk.market.view.goodsList.CreateFunThingsActivity;
import com.coolapk.market.view.goodsList.FunThingsListFragment;
import com.coolapk.market.view.goodsList.GoodGoodsEditListFragment;
import com.coolapk.market.view.goodsList.GoodsListSelectActivity;
import com.coolapk.market.view.live.BannedUserTabActivity;
import com.coolapk.market.view.live.LiveActivity;
import com.coolapk.market.view.live.LiveReplyListActivity;
import com.coolapk.market.view.main.AppForumListFragment;
import com.coolapk.market.view.main.CardSampleListFragment;
import com.coolapk.market.view.main.LatestListFragment;
import com.coolapk.market.view.main.MainActivity;
import com.coolapk.market.view.main.NewestListFragment;
import com.coolapk.market.view.main.PermissionsAgreeActivity;
import com.coolapk.market.view.main.RankFragment;
import com.coolapk.market.view.main.RecommendAlbumListFragment;
import com.coolapk.market.view.main.RecommendAppListFragment;
import com.coolapk.market.view.main.channel.ChannelManagerFragment;
import com.coolapk.market.view.message.ChattingActivity;
import com.coolapk.market.view.message.RecentContactsActivity;
import com.coolapk.market.view.node.DynamicNodePageActivity;
import com.coolapk.market.view.node.app.AppFollowerListFragment;
import com.coolapk.market.view.node.prodcut.ProductCouponActivity;
import com.coolapk.market.view.node.rating.LoginUserNodeRatingListFragment;
import com.coolapk.market.view.node.rating.NodeRatingListFragment;
import com.coolapk.market.view.notification.NotificationActivity;
import com.coolapk.market.view.photo.PhotoPickerActivity;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.view.photo.PhotoViewUrl;
import com.coolapk.market.view.photo.QRCodeActivity;
import com.coolapk.market.view.product.ProductBrandListActivity;
import com.coolapk.market.view.product.ProductBuyAndWishListActivity;
import com.coolapk.market.view.product.ProductCategoryListActivity;
import com.coolapk.market.view.product.ProductConfigsFragment;
import com.coolapk.market.view.product.ProductFansListFragment;
import com.coolapk.market.view.product.ProductMediaTabActivity;
import com.coolapk.market.view.product.ProductShareVideoActivity;
import com.coolapk.market.view.richedit.RichEditorFragment;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.coolapk.market.view.search.SuperSearchResultActivity;
import com.coolapk.market.view.sencondhand.SecondHandProductBrandListActivity;
import com.coolapk.market.view.sencondhand.SelectParamsActivity;
import com.coolapk.market.view.settings.AboutFragment;
import com.coolapk.market.view.settings.AdvancedSettingsFragment;
import com.coolapk.market.view.settings.BetaSettingsFragment;
import com.coolapk.market.view.settings.CacheCleanSettingsFragment;
import com.coolapk.market.view.settings.DebugTestSettingFragment;
import com.coolapk.market.view.settings.DownloadInstallSettingsFragment;
import com.coolapk.market.view.settings.FlowSettingsFragment;
import com.coolapk.market.view.settings.HttpInfoFragment;
import com.coolapk.market.view.settings.LibrariesFragment;
import com.coolapk.market.view.settings.LogFragment;
import com.coolapk.market.view.settings.NetworkDiagnosisFragment;
import com.coolapk.market.view.settings.NightTimeFragment;
import com.coolapk.market.view.settings.NotificationSettingsFragment;
import com.coolapk.market.view.settings.PostButtonSettingFragment;
import com.coolapk.market.view.settings.PrivacySettingsFragment;
import com.coolapk.market.view.settings.TestSettingFragment;
import com.coolapk.market.view.settings.UISettingsFragment;
import com.coolapk.market.view.settings.VXSettingsFragment;
import com.coolapk.market.view.settings.WaterMarkSettingsFragment;
import com.coolapk.market.view.sharev8.ShareImageListActivity;
import com.coolapk.market.view.sharev8.ShareListActivity;
import com.coolapk.market.view.splash.FullScreenAdActivity;
import com.coolapk.market.view.splash.SplashActivity;
import com.coolapk.market.view.theme.ThemeListActivity;
import com.coolapk.market.view.topic.TopicFollowerListFragment;
import com.coolapk.market.view.user.MyDigitTabListActivity;
import com.coolapk.market.view.user.UserApkCommentActivity;
import com.coolapk.market.view.user.UserAvatarFragment;
import com.coolapk.market.view.user.UserDiscoveryListActivity;
import com.coolapk.market.view.user.UserFeedListActivity;
import com.coolapk.market.view.user.UserFollowAppActivity;
import com.coolapk.market.view.user.UserHistoryListActivity;
import com.coolapk.market.view.user.UserLikeListFragment;
import com.coolapk.market.view.user.UserNavigationFragment;
import com.coolapk.market.view.user.UserPictureListActivity;
import com.coolapk.market.view.user.UserProfileActivity;
import com.coolapk.market.view.user.UserRatingActivity;
import com.coolapk.market.view.user.UserReceivedReplyListFragment;
import com.coolapk.market.view.user.UserReplyActivity;
import com.coolapk.market.view.user.UserReplyListFragment;
import com.coolapk.market.view.user.block.BlackListSettingFragment;
import com.coolapk.market.view.user.block.IgnoredUserListFragment;
import com.coolapk.market.view.user.block.LimitedUserListFragment;
import com.coolapk.market.view.user.block.UserBlackListFragment;
import com.coolapk.market.view.user.edit.CountyListActivity;
import com.coolapk.market.view.user.edit.EditUserInfoAcitvity;
import com.coolapk.market.view.user.profile.UserCoverFragment;
import com.coolapk.market.view.userv9.UserSpaceV9Activity;
import com.coolapk.market.view.video.UserKeyInputFragment;
import com.coolapk.market.view.video.VideoDetailListActivity;
import com.coolapk.market.view.wallpaper.PictureCategoryDetailActivity;
import com.coolapk.market.view.wallpaper.coolpic.CoolPicDetailActivity;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import com.coolapk.market.view.wallpaper.coolpic.PictureReplyDetailActivity;
import com.coolapk.market.view.wallpaper.coolpic.TipActivity;
import com.coolapk.market.view.webview.CoolBrowserActivity;
import com.coolapk.market.view.webview.DyhBrowserFragment;
import com.coolapk.market.view.webview.GiftWebViewFragment;
import com.coolapk.market.view.webview.LoginActivity;
import com.coolapk.market.view.webview.LoginFragment;
import com.coolapk.market.view.webview.MarketWebViewFragment;
import com.coolapk.market.view.webview.VideoWebViewFragment;
import com.coolapk.market.view.webview.WebHookViewFragment;
import com.coolapk.market.view.webview.WebViewActivity;
import com.coolapk.market.view.webview.WebViewFragment;
import com.coolapk.market.widget.MultiMarketDialog;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.VideoModel;
import com.hjq.permissions.XXPermissions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ActionManager {
    public static final int DOWNLOAD_FLAG_WITH_AGAIN = 1;
    public static final int DOWNLOAD_FLAG_WITH_AUTO = 3;
    public static final int DOWNLOAD_FLAG_WITH_DELETE = 2;
    public static final int DOWNLOAD_FLAG_WITH_WIFI_RESTART = 4;

    public static void closePushService(Context context) {
    }

    public static boolean shouldAskUserDownloadIntent() {
        return AppHolder.getAppSetting().getBooleanPref("download_only_when_wifi") && !AppHolder.getAppSetting().isWifiAvailable();
    }

    public static boolean startDownload(Context context, ServiceApp serviceApp, int i) {
        return startDownload(context, serviceApp, i, 0);
    }

    public static boolean startDownload(Context context, ServiceApp serviceApp, int i, int i2) {
        DownloadState downloadState = DataManager.getInstance().getDownloadState(serviceApp.getDownloadUrlMd5(i));
        Extra extra = downloadState != null ? downloadState.getExtra() : null;
        if (extra == null) {
            extra = new Extra();
        }
        extra.put("TITLE", serviceApp.getAppName());
        extra.put("PACKAGE_NAME", serviceApp.getPackageName());
        extra.put("VERSION_NAME", serviceApp.getVersionName());
        extra.put("VERSION_CODE", serviceApp.getVersionCode());
        extra.put("APK_SIZE", serviceApp.getApkSize());
        extra.put("LOGO", serviceApp.getLogo());
        extra.put("APK_ID", serviceApp.getApkId());
        extra.put("EXTRA_ANALYSIS_DATA", serviceApp.getExtraAnalysisData());
        return startDownload(context, serviceApp.getDownloadUrl(i), extra, i2);
    }

    public static boolean startDownload(Context context, AlbumItem albumItem, int i) {
        DownloadState downloadState = DataManager.getInstance().getDownloadState(albumItem.getDownloadUrlMd5());
        Extra extra = downloadState != null ? downloadState.getExtra() : null;
        if (extra == null) {
            extra = new Extra();
        }
        extra.put("TITLE", albumItem.getTitle());
        extra.put("PACKAGE_NAME", albumItem.getPackageName());
        extra.put("VERSION_NAME", albumItem.getVersionName());
        extra.put("VERSION_CODE", albumItem.getVersionCode());
        extra.put("LOGO", albumItem.getLogoUrl());
        extra.put("APK_ID", albumItem.getApkId());
        extra.put("EXTRA_ANALYSIS_DATA", albumItem.getExtraAnalysisData());
        return startDownload(context, albumItem.getDownloadUrl(), extra, i);
    }

    public static boolean startDownload(Context context, MobileApp mobileApp, int i) {
        return startDownload(context, mobileApp, i, 0, false);
    }

    public static boolean startDownload(Context context, MobileApp mobileApp, int i, int i2, boolean z) {
        if (mobileApp.getUpgradeInfo() == null) {
            LogUtils.wtf("Mobile app has no upgrade info!!!", new Object[0]);
            return false;
        }
        DownloadState downloadState = DataManager.getInstance().getDownloadState(mobileApp.getUpgradeInfo().getDownloadUrl(i));
        Extra extra = null;
        if (downloadState != null) {
            extra = downloadState.getExtra();
        }
        if (extra == null) {
            extra = new Extra();
        }
        UpgradeInfo upgradeInfo = mobileApp.getUpgradeInfo();
        extra.put("TITLE", mobileApp.getAppName());
        extra.put("PACKAGE_NAME", upgradeInfo.getPackageName());
        extra.put("VERSION_NAME", upgradeInfo.getVersionName());
        extra.put("VERSION_CODE", upgradeInfo.getVersionCode());
        extra.put("APK_SIZE", upgradeInfo.getApkSize());
        extra.put("LOGO", upgradeInfo.getLogo());
        extra.put("APK_ID", upgradeInfo.getApkId());
        extra.put("EXTRA_ANALYSIS_DATA", upgradeInfo.getExtraAnalysisData());
        return startDownload(context, mobileApp.getUpgradeInfo().getDownloadUrl(i), extra, i2, z);
    }

    public static boolean startDownload(Context context, String str, String str2, String[] strArr) {
        Extra extra = new Extra();
        if (!TextUtils.isEmpty(str2)) {
            extra.put("TITLE", str2);
        }
        if (strArr != null) {
            extra.put("HEADERS", strArr);
        }
        return startDownload(context, str, extra, 0);
    }

    public static boolean startDownload(Context context, String str, Extra extra, int i) {
        return startDownload(context, str, extra, i, false);
    }

    public static boolean startDownload(Context context, String str, Extra extra, int i, boolean z) {
        if (z || !(context instanceof Activity) || !shouldAskUserDownloadIntent()) {
            Intent intent = new Intent(context, DownloadService.class);
            intent.setAction("DownloadService.ACTION_START");
            intent.putExtra("URL", str);
            intent.putExtra("FLAG", i);
            if (extra != null) {
                intent.putExtra("EXTRA", extra);
            }
            startService(context, intent, null);
            return true;
        }
        WifiDownloadIntentDialog.newInstance(str, extra, i).show(ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager(), (String) null);
        return false;
    }

    public static void stopDownload(Context context, String str) {
        stopDownload(context, str, 0);
    }

    public static void stopDownload(Context context, String str, int i) {
        Intent intent = new Intent(context, DownloadService.class);
        intent.setAction("DownloadService.ACTION_STOP");
        intent.putExtra("URL", str);
        intent.putExtra("FLAG", i);
        startService(context, intent, null);
    }

    public static void closeDownloadService(Context context) {
        context.stopService(new Intent(context, DownloadService.class));
    }

    public static void startLoadMobileApp(Context context) {
        Intent intent = new Intent(context, AppService.class);
        intent.setAction("ACTION_LOAD_MOBILE_APP");
        startService(context, intent, "FOREGROUND");
    }

    public static void startService(Context context, Intent intent, String str) {
        if (AppUtils.isAppForeground()) {
            try {
                context.startService(intent);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (str != null) {
            try {
                intent.putExtra(str, true);
            } catch (Exception e) {
                e.printStackTrace();
                AppHolder.getThirdPartUtils().markException(e);
                return;
            }
        }
        ContextCompat.startForegroundService(context, intent);
    }

    public static void startCheckMobileAppForUpgrade(Context context, boolean z) {
        Intent intent = new Intent(context, AppService.class);
        intent.setAction("ACTION_CHECK_FOR_UPGRADE");
        intent.putExtra("NOTIFY", z);
        startService(context, intent, "FOREGROUND");
    }

    public static void startCheckMobileAppForUpgrade(Context context, String str) {
        Intent intent = new Intent(context, AppService.class);
        intent.setAction("ACTION_CHECK_FOR_UPGRADE");
        intent.putExtra("PACKAGE_NAME", str);
        startService(context, intent, "FOREGROUND");
    }

    public static void startUserSpaceActivity(Context context, String str) {
        if (!TextUtils.equals(str, "999") && !TextUtils.equals(str, "匿名酷友")) {
            Intent intent = new Intent(context, UserSpaceV9Activity.class);
            intent.putExtra("key_uid", str);
            context.startActivity(intent);
        }
    }

    public static void startUserSpaceActivity(View view, String str, String str2) {
        if (!TextUtils.equals(str, "999") && !TextUtils.equals(str, "匿名酷友")) {
            Activity activity = UiUtils.getActivity(view.getContext());
            Intent intent = new Intent(activity, UserSpaceV9Activity.class);
            intent.putExtra("key_uid", str);
            activity.startActivity(intent);
        }
    }

    public static void startUpdateMobileAppStatus(Context context, String str) {
        Intent intent = new Intent(context, AppService.class);
        intent.setAction("ACTION_UPDATE_MOBILE_APP_STATUS");
        intent.putExtra("PACKAGE_NAME", str);
        startService(context, intent, "FOREGROUND");
    }

    public static void startAutoUpgradeTask(Context context) {
        for (MobileApp mobileApp : DataManager.getInstance().getMobileAppUpgradeListFast(false)) {
            UpgradeInfo upgradeInfo = mobileApp.getUpgradeInfo();
            if (upgradeInfo != null) {
                startDownload(context, mobileApp, upgradeInfo.getDownloadUrlTypeSmart());
            }
        }
    }

    public static void closeAppService(Context context) {
        context.stopService(new Intent(context, AppService.class));
    }

    public static void install(Context context, String str, String str2, Extra extra) {
        install(context, str, str2, extra, true);
    }

    public static void install(Context context, String str, String str2, Extra extra, boolean z) {
        if (AppHolder.getAppSetting().isInstallSilent()) {
            installImmediately(context, str, str2, extra, z);
            return;
        }
        AppHolder.getInstallQueue().add(new InstallJob(str, str2, extra, z));
        startInstallQueueService(context);
    }

    public static void startInstallQueueService(Context context) {
        Intent intent = new Intent(context, PackageService.class);
        intent.setAction("ACTION_INSTALL_QUEUE");
        startService(context, intent, "FOREGROUND");
    }

    public static void installImmediately(Context context, String str, String str2, Extra extra, boolean z) {
        LogUtils.v("Start PackageService to install", new Object[0]);
        Intent intent = new Intent(context, PackageService.class);
        intent.setAction("ACTION_INSTALL");
        intent.putExtra("FROM", str2);
        intent.putExtra("FILE_PATH", str);
        intent.putExtra("EXTRA", extra);
        intent.putExtra("USE_SIGNATURES", z);
        startService(context, intent, "FOREGROUND");
    }

    public static void uninstall(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Toast.show(context, "包名为空，无法继续操作");
            return;
        }
        Intent intent = new Intent(context, PackageService.class);
        intent.setAction("ACTION_UNINSTALL");
        intent.putExtra("PACKAGE_NAME", str);
        intent.putExtra("TITLE", str2);
        startService(context, intent, "FOREGROUND");
    }

    public static void packageAdded(Context context, String str) {
        Intent intent = new Intent(context, PackageService.class);
        intent.setAction("ACTION_PACKAGE_ADDED");
        intent.putExtra("PACKAGE_NAME", str);
        startService(context, intent, "FOREGROUND");
    }

    public static void packageRemoved(Context context, String str) {
        Intent intent = new Intent(context, PackageService.class);
        intent.setAction("ACTION_PACKAGE_REMOVED");
        intent.putExtra("PACKAGE_NAME", str);
        startService(context, intent, "FOREGROUND");
    }

    public static void statInstall(Context context, String str, String str2, String str3, boolean z, String str4) {
        StatWorker.start(context, new Data.Builder().putString("ACTION", "ACTION_INSTALL").putString("PACKAGE_NAME", str).putString("APK_ID", str2).putString("EXTRA", str3).putBoolean("IS_NEW_INSTALL", z).putString("EXTRA_ANALYSIS_DATA", str4).build());
    }

    public static void statUninstall(Context context, String str, String str2, String str3, String str4) {
        StatWorker.start(context, new Data.Builder().putString("ACTION", "ACTION_UNINSTALL").putString("PACKAGE_NAME", str).putString("APK_ID", str2).putString("EXTRA", str3).putString("EXTRA_ANALYSIS_DATA", str4).build());
    }

    public static void statDownloadComplete(Context context, String str, String str2, String str3, boolean z, String str4) {
        StatWorker.start(context, new Data.Builder().putString("ACTION", "ACTION_DOWNLOAD_COMPLETE").putString("PACKAGE_NAME", str).putString("APK_ID", str2).putString("EXTRA", str3).putBoolean("IS_NEW_INSTALL", z).putString("EXTRA_ANALYSIS_DATA", str4).build());
    }

    public static void startLiveActivity(Context context, String str) {
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null) {
            activityNullable = AppHolder.getCurrentActivity();
        }
        Intent intent = new Intent(context, LiveActivity.class);
        intent.putExtra("LIVE_ID", str);
        if (activityNullable == null) {
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        activityNullable.startActivity(intent);
    }

    public static void startLiveReplyListActivity(Context context, Live live, int i) {
        context.startActivity(new Intent(context, LiveReplyListActivity.class).addFlags(65536).putExtra("LIVE", live).putExtra("UNREAD_NUM", i));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    public static void startLiveBannedUserTabActivity(Context context, String str) {
        context.startActivity(new Intent(context, BannedUserTabActivity.class).putExtra("LIVE_ID", str));
    }

    public static void startView(Context context, Uri uri, String str) {
        try {
            startRawView(context, uri, str);
        } catch (Exception unused) {
            Toast.show(context, "打开失败");
        }
    }

    public static void startRawView(Context context, Uri uri, String str) throws Exception {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(uri, str);
        context.startActivity(intent);
    }

    public static boolean openApp(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return openApp(context, str);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            intent.addFlags(268435456);
            ResolveInfo resolveInfo = null;
            Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ResolveInfo next = it2.next();
                if (TextUtils.equals(next.activityInfo.packageName, str)) {
                    resolveInfo = next;
                    break;
                }
            }
            if (resolveInfo != null) {
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
                context.startActivity(intent);
            }
            return true;
        } catch (Exception unused) {
            return openApp(context, str);
        }
    }

    public static boolean openApp(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void startPickPicCategoryFragment(Activity activity) {
        SimpleActivity.builder(activity).fragmentClass(PickPicCategoryFragment.class).title("选择酷图分类").setRequestCode(3423).start();
    }

    public static void startArticlePreviewFragment(Activity activity, String str, BaseFeedContentHolder baseFeedContentHolder) {
        AppHolder.setWeakValue("BaseFeedContentHolder", baseFeedContentHolder);
        SimpleAlphaActivity.builder(activity).fragmentClass(ArticlePreviewFragment.class).title(activity.getString(2131886144)).addArgs("ARTICLE_JSON", str).start();
    }

    public static void openApplicationInfo(Context context, String str) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", str, null));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.error(context, e);
        }
    }

    public static void startV8AlbumDetailActivity(Activity activity, Entity entity) {
        Intent intent = new Intent(activity, AlbumDetailActivity.class);
        intent.putExtra("ALBUM", (Album) entity);
        activity.startActivity(intent);
    }

    public static void startV8AlbumDetailActivity(Context context, String str, String str2, int i) {
        Intent intent = new Intent(context, AlbumDetailActivity.class);
        intent.putExtra("ALBUM_ID", str);
        intent.putExtra("ALBUM_RID", str2);
        intent.putExtra("extra_flag", i);
        context.startActivity(intent);
    }

    public static void startV8AlbumDetailActivity(Context context, String str) {
        Intent intent = new Intent(context, AlbumDetailActivity.class);
        intent.putExtra("ALBUM_ID", str);
        intent.putExtra("ALBUM_RID", "");
        context.startActivity(intent);
    }

    public static void startAppCategoryActivity(Context context, AppCategory appCategory, int i) {
        Intent intent = new Intent(context, AppCategoryDetailActivity.class);
        intent.putExtra("index", i).putExtra("category", appCategory);
        context.startActivity(intent);
    }

    public static void startNotificationActivity(final Context context, final int i) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                context.startActivity(new Intent(context, NotificationActivity.class).putExtra("tab", i));
            }
        });
    }

    public static void startAppManagerActivity(Context context) {
        startAppManagerActivity(context, -1);
    }

    public static void startAppManagerActivity(Context context, int i) {
        Intent intent = new Intent(context, AppManagerActivity.class);
        intent.putExtra("PAGE_INDEX", i);
        context.startActivity(intent);
    }

    public static void startGoodsSearchActivity(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, GoodsSearchActivity.class), i);
    }

    public static void startGoodsCouponSearchActivity(Activity activity, String str) {
        activity.startActivity(new Intent(activity, GoodsCouponSearchActivity.class).putExtra("extra_key_word", str));
    }

    public static void startLoginActivity(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class).putExtra("url", "https://account.coolapk.com/auth/login?type=coolapk"));
    }

    public static void startRegisterActivity(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class).putExtra("url", "https://account.coolapk.com/auth/login?type=register"));
    }

    public static void startLoginActivity(Context context, String str) {
        context.startActivity(new Intent(context, LoginActivity.class).putExtra("url", str));
    }

    public static void startLoginActivity(Activity activity, String str, int i) {
        activity.startActivityForResult(new Intent(activity, LoginActivity.class).putExtra("url", str), i);
    }

    public static void startAboutActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(AboutFragment.class).start();
    }

    public static void startBlockTagFeedListActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).title(context.getString(2131887084)).fragmentClass(BlockFeedListFragment.class).addArgs("tag", str).addArgs("listType", str2).start();
    }

    public static void starRegisterActivity(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class).putExtra("url", "https://account.coolapk.com/auth/login?type=register"));
    }

    public static void startWebViewActivity(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", WebViewFragment.class.getName()).putExtra("extra_bundle", bundle));
    }

    public static void startWebViewForDyhActivity(Context context, DyhArticle dyhArticle) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", dyhArticle.getRedirectUrl());
        bundle.putParcelable("extra_action_type", dyhArticle);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", DyhBrowserFragment.class.getName()).putExtra("extra_bundle", bundle));
    }

    public static void startMarketWebViewActivity(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", MarketWebViewFragment.class.getName()).putExtra("extra_bundle", bundle));
    }

    public static void startFeedReplyDetailActivity(Context context, FeedReply feedReply) {
        context.startActivity(new Intent(context, FeedReplyDetailActivity.class).putExtra("extra_feed_reply", feedReply).addFlags(65536));
        UiUtils.getActivity(context).overridePendingTransition(0, 0);
    }

    public static void startFeedReplyDetailActivity(Context context, String str) {
        context.startActivity(new Intent(context, FeedReplyDetailActivity.class).putExtra("extra_feed_reply", str).addFlags(65536));
        UiUtils.getActivity(context).overridePendingTransition(0, 0);
    }

    public static void startShareWebviewActivity(Fragment fragment, String str, ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!CollectionUtils.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        fragment.startActivityForResult(new Intent(fragment.getActivity(), ShareWebviewActivity.class).putExtra("extra_url", str).putExtra("PICKED_PHOTO_PATHS", arrayList2).addFlags(65536), 341);
        UiUtils.getActivity(fragment.getActivity()).overridePendingTransition(0, 0);
    }

    public static void startShareWebviewActivity(Activity activity, String str, ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!CollectionUtils.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        activity.startActivityForResult(new Intent(activity, ShareWebviewActivity.class).putExtra("extra_url", str).putExtra("PICKED_PHOTO_PATHS", arrayList2).addFlags(65536), 341);
        UiUtils.getActivity(activity).overridePendingTransition(0, 0);
    }

    public static void startVideoWebViewActivity(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        bundle.putString("JAVA_SCRIPT", str2);
        bundle.putString("USER_AGENT", str3);
        FullScreenActivity.builder(context).fragmentClass(VideoWebViewFragment.class).setArgs(bundle).start();
    }

    public static void startWebViewTitleActivity(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", LoginFragment.class.getName()).putExtra("extra_title", str2).putExtra("extra_bundle", bundle));
    }

    public static void startWebViewTitleActivity(Context context, String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", LoginFragment.class.getName()).putExtra("extra_title", str2).putExtra("extra_title_visable", z).putExtra("extra_bundle", bundle));
    }

    public static void startGiftWebViewActivity(Context context, String str, Gift gift, ServiceApp serviceApp) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        bundle.putParcelable("GIFT", gift);
        bundle.putParcelable("APP", serviceApp);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", GiftWebViewFragment.class.getName()).putExtra("extra_title", context.getString(2131887325)).putExtra("extra_bundle", bundle));
    }

    public static void startWebHookViewActivity(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        context.startActivity(new Intent(context, WebViewActivity.class).putExtra("extra_class_name", WebHookViewFragment.class.getName()).putExtra("extra_bundle", bundle));
    }

    public static void startThemePickerActivity(Context context) {
        context.startActivity(new Intent(context, ThemeListActivity.class));
    }

    public static void startAdvancedSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(AdvancedSettingsFragment.class).title(context.getString(2131886561)).start();
    }

    public static void startNotificationSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(NotificationSettingsFragment.class).title("消息提醒").start();
    }

    public static void startUISettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(UISettingsFragment.class).title("界面显示").start();
    }

    public static void startWaterMarkSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(WaterMarkSettingsFragment.class).title("图片设置").start();
    }

    public static void startDownloadInstallSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(DownloadInstallSettingsFragment.class).title("下载安装").start();
    }

    public static void startFlowSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(FlowSettingsFragment.class).title(context.getString(2131886574)).start();
    }

    public static void startBetaSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(BetaSettingsFragment.class).title("实验室").start();
    }

    public static void startPrivacySettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(PrivacySettingsFragment.class).title("隐私设置").start();
    }

    public static void startCacheCleanSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(CacheCleanSettingsFragment.class).title("缓存清理").start();
    }

    public static void startV8SettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(VXSettingsFragment.class).title("设置").start();
    }

    public static void startDebugTestSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(DebugTestSettingFragment.class).title("Debug Test").start();
    }

    public static void startUserKeyInputFragment(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(UserKeyInputFragment.class).addArgs("EXTRA_URL", str).addArgs("EXTRA_CODE", str2).title("输入内测邀请码").start();
    }

    public static void startDyhIncludActivity(Context context, String str) {
        Intent intent = new Intent(context, DyhIncludActivity.class);
        intent.putExtra("id", str);
        intent.addFlags(65536);
        context.startActivity(intent);
    }

    public static void startDyhIncludActivityForResult(Activity activity, int i) {
        Intent intent = new Intent(activity, DyhIncludActivity.class);
        intent.addFlags(65536);
        activity.startActivityForResult(intent, i);
    }

    public static void startRecentActivity(Activity activity, Feed feed) {
        Intent intent = new Intent(activity, RecentContactsActivity.class);
        intent.putExtra("feed", feed);
        activity.startActivity(intent);
    }

    public static void startRecentActivity(Activity activity, Entity entity) {
        Intent intent = new Intent(activity, RecentContactsActivity.class);
        intent.putExtra("entity", entity);
        activity.startActivity(intent);
    }

    public static void startSimpleActivityByName(Context context, String str, String str2, String... strArr) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "酷安";
        }
        SimpleActivity.Builder title = SimpleActivity.builder(context).fragmentName(str).title(str2);
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 != 0 && i < strArr.length - 1) {
                title.addArgs(strArr[i], strArr[i + 1]);
            }
        }
        title.start();
    }

    public static void startTestSettingsActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(TestSettingFragment.class).title(context.getString(2131886594)).start();
    }

    public static void startNetworkDiagnosisActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(NetworkDiagnosisFragment.class).title(context.getString(2131886615)).start();
    }

    public static void startHttpInfoActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(HttpInfoFragment.class).title("服务端检测").start();
    }

    public static void startDownloadLogActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(LogFragment.class).addArgs("LOG_TAG", "download").title("下载日志").start();
    }

    public static void startNetworkStateLogActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(LogFragment.class).addArgs("LOG_TAG", "network_state").title("网络状态日志").start();
    }

    public static void startApiLogActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(LogFragment.class).addArgs("LOG_TAG", "api").title("Api log").start();
    }

    public static void startInstallLogActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(LogFragment.class).addArgs("LOG_TAG", "install").title("安装日志").start();
    }

    public static void startNightTimeSettingActivity(Context context) {
        SimpleActivity.builder(context).title(context.getString(2131887345)).fragmentClass(NightTimeFragment.class).start();
    }

    public static void startAccessibilitySettingsActivity(Context context) {
        boolean z = false;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.Settings$AccessibilityInstalledServiceActivity");
            ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
            if (resolveActivity != null) {
                intent.setComponent(resolveActivity);
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            }
        } catch (Exception unused) {
        }
        if (!z) {
            Intent intent2 = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent2.setFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public static void startUserAlbumListActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserAlbumListActivity.class).putExtra("uid", str));
    }

    public static void startAlbumPickActivity(Context context, Album album) {
        Intent intent = new Intent(context, AlbumPickAppTabActivity.class);
        intent.putExtra("EXTRA_ALBUM", album);
        context.startActivity(intent);
    }

    public static void startAlbumEditActivity(Context context, Album album) {
        Intent intent = new Intent(context, AlbumEditActivity.class);
        intent.putExtra("album", album);
        context.startActivity(intent);
    }

    public static void startChattingActivity(final Context context, final String str, final String str2) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                context.startActivity(new Intent(context, ChattingActivity.class).putExtra("USER_ID", str).putExtra("TITLE", str2));
            }
        });
    }

    public static void startChattingActivity(final Context context, final Message message) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                context.startActivity(new Intent(context, ChattingActivity.class).putExtra("MESSAGE", message));
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e3 A[Catch:{ Exception -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fb  */
    public static void startExternalMarketByName(Context context, String str, String str2, String str3) {
        ComponentName componentName;
        Uri uri;
        ComponentName componentName2;
        if (str != null) {
            try {
                if (str.startsWith("market://details?id=")) {
                    uri = Uri.parse(str);
                    componentName = null;
                    if (uri == null) {
                        uri = Uri.parse("market://details?id=" + str3);
                    }
                    if (componentName != null) {
                        Intent intent = new Intent("android.intent.action.VIEW", uri);
                        intent.setComponent(componentName);
                        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                            context.startActivity(intent);
                            return;
                        }
                    }
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0);
                    MultiMarketDialog newInstance = MultiMarketDialog.newInstance();
                    newInstance.setData(queryIntentActivities, str3);
                    newInstance.show(ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager(), (String) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.toLowerCase().contains("play")) {
                if (!str2.contains("酷市场客户端")) {
                    if (str2.contains("豌豆荚")) {
                        componentName2 = new ComponentName("com.wandoujia.phoenix2", "com.wandoujia.jupiter.activity.DetailActivity");
                    } else {
                        if (!str2.contains("酷安网")) {
                            if (!str2.contains("酷市场")) {
                                if (str2.contains("360")) {
                                    componentName2 = new ComponentName("com.qihoo.appstore", "com.qihoo.appstore.activities.SearchDistributionActivity");
                                } else if (str2.contains("百度")) {
                                    componentName2 = new ComponentName("com.baidu.appsearch", "com.baidu.appsearch.UrlHandlerActivity");
                                } else if (str2.contains("小米")) {
                                    componentName2 = new ComponentName("com.xiaomi.market", "com.xiaomi.market.ui.AppDetailActivity");
                                } else if (str2.contains("应用宝")) {
                                    componentName2 = new ComponentName("com.tencent.android.qqdownloader", "com.tencent.assistant.link.LinkProxyActivity");
                                } else if (str2.contains("当乐")) {
                                    componentName2 = new ComponentName("com.diguayouxi", "com.diguayouxi.ui.SearchActivity");
                                } else if (str2.contains("网易")) {
                                    componentName2 = new ComponentName("com.netease.apper", "com.netease.apper.FinalAppPageActivity");
                                } else {
                                    throw new ClassNotFoundException("Can not found matched market");
                                }
                            }
                        }
                        startAppViewActivity(context, str3);
                        return;
                    }
                    componentName = componentName2;
                    uri = null;
                    if (uri == null) {
                    }
                    if (componentName != null) {
                    }
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0);
                    MultiMarketDialog newInstance = MultiMarketDialog.newInstance();
                    newInstance.setData(queryIntentActivities, str3);
                    newInstance.show(ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager(), (String) null);
                }
            }
            if (PackageUtils.isInstalled(context, "com.android.vending")) {
                componentName2 = new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity");
                componentName = componentName2;
                uri = null;
                if (uri == null) {
                }
                if (componentName != null) {
                }
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0);
                MultiMarketDialog newInstance = MultiMarketDialog.newInstance();
                newInstance.setData(queryIntentActivities, str3);
                newInstance.show(ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager(), (String) null);
            }
        }
        uri = null;
        componentName = null;
        if (uri == null) {
        }
        if (componentName != null) {
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0);
        MultiMarketDialog newInstance = MultiMarketDialog.newInstance();
        newInstance.setData(queryIntentActivities, str3);
        newInstance.show(ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager(), (String) null);
    }

    public static void startExternalMarketByName(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startAppForumActivity(Context context, String str) {
        startAppViewActivity(context, str);
    }

    public static void startAppViewActivity(Context context, String str) {
        startAppViewActivity(context, str, null, null, null, null);
    }

    public static void startAppViewActivity(Context context, String str, boolean z) {
        startAppViewActivity(context, str, null, null, null, "action=download_or_open");
    }

    public static void startAppViewActivity(Activity activity, View view, String str, String str2, String str3, String str4, String str5, String str6) {
        startAppViewActivity(activity, str, str4, str5, str6, null);
    }

    public static void startAppViewActivity(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent buildAppIntent = DynamicNodePageActivity.buildAppIntent(context);
        buildAppIntent.putExtra("APP_UNIQUE_ID", str);
        buildAppIntent.putExtra("EXTRA_ANALYSIS_DATA", str2);
        buildAppIntent.putExtra("EXTRA_REQUEST_CONTEXT", str3);
        buildAppIntent.putExtra("FROM_API", str4);
        buildAppIntent.putExtra("CLIENT_CONFIG", str5);
        context.startActivity(buildAppIntent);
    }

    public static void startAppForumActivity(Activity activity, View view, String str, String str2, String str3, String str4) {
        startAppViewActivity(activity, view, str, str2, str3, str4, null, null);
    }

    public static void startPictureCategoryDetailActivity(Context context, String str) {
        Intent intent = new Intent(context, PictureCategoryDetailActivity.class);
        intent.putExtra("tag", str);
        context.startActivity(intent);
    }

    public static void startTestActivity(Context context) {
        context.startActivity(new Intent(context, TestActivity.class));
    }

    public static void startPhotoPickerActivity(Activity activity, int i, List<String> list) {
        startPhotoPickerActivity(activity, i, list, 3925);
    }

    public static void startPhotoPickerActivity(final Activity activity, final boolean z) {
        doOnStoragePermissionPermit(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                activity.startActivityForResult(new Intent(activity, PhotoPickerActivity.class).putExtra("PICKED_PHOTO_PATHS", new ArrayList()).putExtra("MAX_PICK_COUNT", 1).putExtra("action_message", z), 3925);
            }
        });
    }

    public static void startPhotoPickerActivityWithCountDown(final Activity activity, final int i, final int i2, final int i3) {
        doOnStoragePermissionPermit(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                activity.startActivityForResult(new Intent(activity, PhotoPickerActivity.class).putExtra("PICKED_PHOTO_PATHS", new ArrayList()).putExtra("MAX_PICK_COUNT", i).putExtra("EXTRA_COUNT_DOWN", i2).putExtra("EXTRA_COUNT_DOWN_MAX", i3), 3925);
            }
        });
    }

    public static void startPhotoPickerActivity(final Activity activity, final int i, final List<String> list, final int i2) {
        doOnStoragePermissionPermit(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                if (!CollectionUtils.isEmpty(list) && i != 1) {
                    arrayList.addAll(list);
                }
                activity.startActivityForResult(new Intent(activity, PhotoPickerActivity.class).putExtra("PICKED_PHOTO_PATHS", arrayList).putExtra("MAX_PICK_COUNT", i), i2);
            }
        });
    }

    public static void startPhotoPickerActivity(Fragment fragment, int i, List<String> list) {
        startPhotoPickerActivity(fragment, i, list, 3925);
    }

    public static void startPhotoPickerActivity(final Fragment fragment, final int i, final List<String> list, final int i2) {
        doOnStoragePermissionPermit(fragment.getActivity(), new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass7 */

            @Override // java.lang.Runnable
            public void run() {
                ArrayList<String> arrayList = new ArrayList<>();
                if (!CollectionUtils.isEmpty(list) && i != 1) {
                    arrayList.addAll(list);
                }
                fragment.startActivityForResult(new Intent(fragment.getActivity(), PhotoPickerActivity.class).putStringArrayListExtra("PICKED_PHOTO_PATHS", arrayList).putExtra("MAX_PICK_COUNT", i), i2);
            }
        });
    }

    public static void startPhotoPickerToCoolPicActivity(final Activity activity) {
        doOnStoragePermissionPermit(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass8 */

            @Override // java.lang.Runnable
            public void run() {
                activity.startActivity(new Intent(activity, PhotoPickerActivity.class).putExtra("PICKED_PHOTO_PATHS", new ArrayList()).putExtra("MAX_PICK_COUNT", 9).putExtra("ACTION_TYPE", "action_coolpic"));
            }
        });
    }

    public static void startPhotoPickerToProductPicActivity(Activity activity, Product product) {
        activity.startActivity(new Intent(activity, PhotoPickerActivity.class).putExtra("PICKED_PHOTO_PATHS", new ArrayList()).putExtra("MAX_PICK_COUNT", 9).putExtra("EXTRA_DATA", product).putExtra("ACTION_TYPE", "action_product_photo"));
    }

    public static void startBrowserActivity(Context context, String str) {
        if (str != null) {
            Uri parse = Uri.parse(str);
            boolean z = str.startsWith("http://") || str.startsWith("https://");
            boolean isOuterBrowserUrl = BearStoryHelper.isOuterBrowserUrl(parse);
            boolean isInnerBrowserUrl = BearStoryHelper.isInnerBrowserUrl(parse);
            if (!z || isOuterBrowserUrl) {
                startView(context, parse, null);
            } else if (isInnerBrowserUrl) {
                startWebViewActivity(context, str);
            } else if (!AppHolder.getAppSetting().getBooleanPref("use_internal_webview")) {
                startView(context, parse, null);
            } else {
                boolean isBearStoryUrl = BearStoryHelper.isBearStoryUrl(parse);
                boolean isSupported = CustomTabsUtils.isSupported(context, str);
                if (isBearStoryUrl || !isSupported) {
                    startWebViewActivity(context, str);
                } else {
                    CustomTabsUtils.launchUrl(context, str);
                }
            }
        }
    }

    public static void startCoolBrowserActivity(Context context) {
        context.startActivity(new Intent(context, CoolBrowserActivity.class));
    }

    public static void startFileViewActivity(Fragment fragment, int i) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), FileViewActivity.class), i);
    }

    public static void startLogFileActivity(Context context) {
        SimpleActivity.builder(context).title("本地日志").fragmentClass(LogFileFragment.class).start();
    }

    public static void startApplicationDetailsActivity(Context context, String str) {
        try {
            Intent intent = new Intent();
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 9) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", str, null));
            } else {
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra(i == 8 ? "pkg" : "com.android.settings.ApplicationPkgName", str);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startDownloadManagerActivity(Context context) {
        Intent intent = new Intent(context, DownloadManagerActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startUserReplyListFragment(final Context context, final String str) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass9 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).title(context.getString(2131887165)).fragmentClass(UserReplyListFragment.class).addArgs("uid", str).start();
            }
        });
    }

    public static void startUserReceivedReplyListFragment(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass10 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).fragmentClass(UserReceivedReplyListFragment.class).title(context.getString(2131887188)).start();
            }
        });
    }

    public static void startUserPrivacySettingFragment(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass11 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).fragmentClass(UserBlackListFragment.class).title("黑名单管理").start();
            }
        });
    }

    public static void startUserHistoryListFragment(Context context) {
        context.startActivity(new Intent(context, UserHistoryListActivity.class));
    }

    public static void startUserBackupListFragment(Context context) {
        context.startActivity(new Intent(context, BackupListActivity.class));
    }

    public static void startUserBackupListFragmentToCreate(Context context) {
        Intent intent = new Intent(context, BackupListActivity.class);
        intent.putExtra("KEY_BACKUP_CREATE", true);
        context.startActivity(intent);
    }

    public static void startUserPictureListFragment(final Context context, final String str) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass12 */

            @Override // java.lang.Runnable
            public void run() {
                context.startActivity(new Intent(context, UserPictureListActivity.class).putExtra("uid", str));
            }
        });
    }

    public static void startBlackUserListFragment(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass13 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).fragmentClass(UserBlackListFragment.class).title(context.getString(2131887129)).start();
            }
        });
    }

    public static void startUserCenterMoreFragment(Context context) {
        SimpleActivity.builder(context).fragmentClass(CenterMoreFragment.class).title(context.getString(2131886654)).start();
    }

    public static void startIgnoreUserListFragment(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass14 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).fragmentClass(IgnoredUserListFragment.class).title(context.getString(2131887159)).start();
            }
        });
    }

    public static void startLimitedUserListFragment(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass15 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).fragmentClass(LimitedUserListFragment.class).title(context.getString(2131887161)).start();
            }
        });
    }

    public static void startUpgradeManagerActivity(Context context) {
        Intent intent = new Intent(context, UpgradeManagerActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startUserProfileActivity(Context context, String str) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        intent.putExtra("EXTRA_TITLE", str);
        context.startActivity(intent);
    }

    public static void startQrcodeActivity(final Activity activity) {
        LibraryExtentsKt.asObservable(XXPermissions.with(activity).permission("android.permission.CAMERA")).subscribe((Subscriber<? super Boolean>) new EmptySubscriber<Boolean>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass16 */

            public void onNext(Boolean bool) {
                super.onNext((AnonymousClass16) bool);
                activity.startActivity(new Intent(activity, QRCodeActivity.class));
            }
        });
    }

    public static void startNearActivity(final Activity activity, final LocationInfo locationInfo) {
        LibraryExtentsKt.asObservable(XXPermissions.with(activity).permission("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION")).subscribe((Subscriber<? super Boolean>) new EmptySubscriber<Boolean>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass17 */

            public void onNext(Boolean bool) {
                super.onNext((AnonymousClass17) bool);
                Intent intent = new Intent(activity, NearbyLocationActivity.class);
                intent.putExtra("locationInfo", locationInfo);
                intent.putExtra("KEY_BIND_TYPE", "feed");
                activity.startActivityForResult(intent, 888);
            }
        });
    }

    public static void startNearActivity(final Activity activity, final LocationInfo locationInfo, final String str) {
        LibraryExtentsKt.asObservable(XXPermissions.with(activity).permission("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION")).subscribe((Subscriber<? super Boolean>) new EmptySubscriber<Boolean>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass18 */

            public void onNext(Boolean bool) {
                super.onNext((AnonymousClass18) bool);
                Intent intent = new Intent(activity, NearbyLocationActivity.class);
                intent.putExtra("locationInfo", locationInfo);
                intent.putExtra("KEY_BIND_TYPE", str);
                activity.startActivityForResult(intent, 888);
            }
        });
    }

    public static void startSearchActivity(Context context) {
        startSearchActivity(context, null, null, "all", false, null, null, null, null);
    }

    public static void startSearchActivity(Context context, String str, String str2) {
        startSearchActivity(context, str, str2, "all", false, null, null, null, null);
    }

    public static void startSceneSearchActivity(Context context, String str, String str2) {
        startSearchActivity(context, null, null, "feed", false, null, "onlyQuickLinkWithAll", str, str2);
    }

    public static void startSearchActivity(Context context, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        Intent intent = new Intent(context, SuperSearchActivity.class);
        intent.setFlags(65536);
        intent.putExtra("KEYWORD", str);
        intent.putExtra("SEARCH_TYPE", str3);
        intent.putExtra("SEARCH_HINT", str2);
        intent.putExtra("SCENE_TITLE", str4);
        intent.putExtra("SCENE_MODE", z);
        intent.putExtra("RETURN_TYPE", str5);
        intent.putExtra("FEED_PAGE_TYPE", str6);
        intent.putExtra("FEED_PAGE_PARAM", str7);
        context.startActivity(intent);
    }

    public static void startSuperSearchResultActivity(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, SuperSearchResultActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra("searchType", str2);
        intent.putExtra("returnType", str3);
        intent.putExtra("FEED_PAGE_TYPE", str4);
        intent.putExtra("FEED_PAGE_PARAM", str5);
        context.startActivity(intent);
    }

    public static void startChangeAvatar(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass19 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).title(context.getString(2131887294)).fragmentClass(UserAvatarFragment.class).start();
            }
        });
    }

    public static void startChangeUserCover(Context context, UserProfile userProfile) {
        SimpleActivity.builder(context).title(context.getString(2131887171)).fragmentClass(UserCoverFragment.class).addArgs("extra_entity", userProfile).start();
    }

    public static void startUserNavigation(final Context context) {
        doOnLogin(context, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass20 */

            @Override // java.lang.Runnable
            public void run() {
                SimpleActivity.builder(context).fragmentClass(UserNavigationFragment.class).start();
            }
        });
    }

    public static void startFriendListActivity(Context context, String str, String str2) {
        context.startActivity(new Intent(context, FriendListActivity.class).putExtra("uid", str).putExtra("title", str2));
    }

    public static void startFansListActivity(Context context, String str, String str2) {
        context.startActivity(new Intent(context, FansListActivity.class).putExtra("uid", str).putExtra("title", str2));
    }

    public static void startUserQAListActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(UserQAListFragment.class).addArgs("uid", str).title(str2).start();
    }

    public static void startUserHtmlFeedListFragment(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(UserHtmlFeedListFragment.class).addArgs("uid", str).title(str2).start();
    }

    public static void startUserRatingActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserRatingActivity.class).putExtra("uid", str));
    }

    public static void startUserLikeListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(UserLikeListFragment.class).addArgs("uid", str).title(context.getString(2131887372)).start();
    }

    public static void startUserApkCommentActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserApkCommentActivity.class).putExtra("uid", str));
    }

    public static void startUserDiscoveryListActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserDiscoveryListActivity.class).putExtra("uid", str));
    }

    public static void startUserFeedListActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserFeedListActivity.class).putExtra("uid", str));
    }

    public static void startUserFollowAppActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserFollowAppActivity.class).putExtra("uid", str));
    }

    public static void startMyDigitTabListActivity(Context context) {
        context.startActivity(new Intent(context, MyDigitTabListActivity.class));
    }

    public static void startUserReplyActivity(Context context, String str) {
        context.startActivity(new Intent(context, UserReplyActivity.class).putExtra("uid", str));
    }

    public static void startFeedRoughDraftListFragment(Context context) {
        SimpleActivity.builder(context).fragmentClass(DraftListFragment.class).title(context.getString(2131887189)).start();
    }

    public static void startProductConfigDataActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(ProductConfigsFragment.class).addArgs("product_config_id", str).title(context.getString(2131886997)).start();
    }

    public static void startProductFansListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(ProductFansListFragment.class).addArgs("extra_id", str).title(context.getString(2131887083)).start();
    }

    public static void startProductBuyAndWishListActivity(Context context, String str, int i) {
        Intent intent = new Intent(context, ProductBuyAndWishListActivity.class);
        intent.putExtra("EXTRA_ID", str);
        intent.putExtra("EXTRA_PAGE", i);
        context.startActivity(intent);
    }

    public static void startMyGoodsTabListActivity(Context context) {
        context.startActivity(new Intent(context, MyGoodsTabListActivity.class));
    }

    public static void startTopicFollowerListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(TopicFollowerListFragment.class).addArgs("TAG", str).title(context.getString(2131887083)).start();
    }

    public static void startAppFollowerListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(AppFollowerListFragment.class).addArgs("ID", str).title(context.getString(2131887083)).start();
    }

    public static void startProductMediaTabActivity(Context context, String str, String str2, boolean z, int i) {
        Intent intent = new Intent(context, ProductMediaTabActivity.class);
        intent.putExtra("extra_product_id", str);
        intent.putExtra("PAGE_INDEX", i);
        intent.putExtra("extra_title", str2);
        intent.putExtra("extra_recommend_flag", z);
        context.startActivity(intent);
    }

    public static void startSearchUserActivity(Fragment fragment, String str, int i) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), UserPickActivity.class).putExtra("extra_keyword", str), i);
    }

    public static void startBlackListSettingActivity(Context context, UserProfile userProfile) {
        SimpleActivity.builder(context).addArgs("data", userProfile).fragmentClass(BlackListSettingFragment.class).title(context.getString(2131886433)).start();
    }

    public static void startBlackListSettingActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).addArgs("uid", str).addArgs("username", str2).fragmentClass(BlackListSettingFragment.class).title(context.getString(2131886433)).start();
    }

    public static void startPhotoViewActivity(View view, String str, String str2) {
        startPhotoViewActivity(UiUtils.getActivity(view.getContext()), new String[]{str}, new String[]{str2}, 0, null, null, new Rect[]{ViewExtendsKt.getGlobalRect(view)});
    }

    public static void startPhotoViewActivity(View view, String str, String str2, String str3) {
        startPhotoViewActivity(UiUtils.getActivity(view.getContext()), new String[]{str}, new String[]{str2}, 0, str3, null, new Rect[]{ViewExtendsKt.getGlobalRect(view)});
    }

    public static void startPhotoViewActivityInMessage(View view, String[] strArr, Rect[] rectArr, int i, String[] strArr2, String[] strArr3) {
        startPhotoViewActivityInMessage(UiUtils.getActivity(view.getContext()), strArr2, strArr3, i, null, strArr, rectArr);
    }

    public static void startPhotoViewActivityInMessage(View view, String[] strArr, Rect[] rectArr, String[] strArr2, String[] strArr3) {
        startPhotoViewActivityInMessage(UiUtils.getActivity(view.getContext()), strArr2, strArr3, 0, null, strArr, rectArr);
    }

    public static void startPhotoViewActivity(Activity activity, String[] strArr, String[] strArr2, int i) {
        startPhotoViewActivity(activity, strArr, strArr2, i, null, null, null);
    }

    public static void startPhotoViewActivity(Activity activity, String[] strArr, String[] strArr2, int i, String str, String[] strArr3, Rect[] rectArr) {
        ArrayList<PhotoViewUrl> from = PhotoViewUrl.from(strArr, strArr2, strArr3, rectArr, 0);
        Intent intent = new Intent(activity, PhotoViewActivity.class);
        intent.putExtra("index", i).putExtra("feed_type", str).putExtra("photoViewUrl", from);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void startPhotoViewActivity(Activity activity, String[] strArr, String[] strArr2, int i, String str, String[] strArr3, Rect[] rectArr, boolean z) {
        ArrayList<PhotoViewUrl> from = PhotoViewUrl.from(strArr, strArr2, strArr3, rectArr, z ? 1 : 0);
        Intent intent = new Intent(activity, PhotoViewActivity.class);
        intent.putExtra("index", i).putExtra("feed_type", str).putExtra("photoViewUrl", from);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void startPhotoViewActivityInMessage(Activity activity, String[] strArr, String[] strArr2, int i, String str, String[] strArr3, Rect[] rectArr) {
        ArrayList<PhotoViewUrl> from = PhotoViewUrl.from(strArr, strArr2, strArr3, rectArr, 1);
        Intent intent = new Intent(activity, PhotoViewActivity.class);
        intent.putExtra("index", i).putExtra("feed_type", str).putExtra("in_message", true).putExtra("photoViewUrl", from);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void startReplyActivity(final Activity activity, final FeedReply feedReply) {
        doOnLogin(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass21 */

            @Override // java.lang.Runnable
            public void run() {
                ActionManager.startReplyActivity(activity, FeedDraft.builder().setType(feedReply.getFtype() == 1 ? "dyh_article_reply" : "reply").setExtraId(feedReply.getId()).setExtraData(feedReply.getUserName()).build(), feedReply);
            }
        });
    }

    public static void startFeedEntranceV8Activity(Context context) {
        context.startActivity(new Intent(context, FeedEntranceV8Activity.class).setFlags(65536));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    public static void startFeedCommentActivity(final Activity activity, final String str, final String str2) {
        doOnLogin(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass22 */

            @Override // java.lang.Runnable
            public void run() {
                ActionManager.startReplyActivity(activity, FeedDraft.builder().setType("feed_comment").setExtraId(str).setExtraData(str2).build());
            }
        });
    }

    public static void startFeedCommentActivity(final Activity activity, final String str, final String str2, final String str3) {
        doOnLogin(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass23 */

            @Override // java.lang.Runnable
            public void run() {
                ActionManager.startReplyActivity(activity, FeedDraft.builder().setType(str).setExtraId(str2).setExtraData(str3).build());
            }
        });
    }

    public static void startLivePostMessageActivity(final Activity activity, final String str, final String str2, final String str3, final LiveMessage liveMessage, final boolean z) {
        doOnLogin(activity, new Runnable() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass24 */

            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    JSONObject jSONObject = new JSONObject();
                    LiveMessage liveMessage = liveMessage;
                    if (liveMessage != null) {
                        jSONObject.put("source_id", liveMessage.getId());
                        jSONObject.put("source_uid", liveMessage.getUid());
                        jSONObject.put("source_user_name", liveMessage.getUserName());
                        jSONObject.put("source_message", liveMessage.getMessage());
                    }
                    jSONObject.put("relation_group_id", str3);
                    jSONObject.put("is_presenter", z);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = null;
                }
                ActionManager.startReplyActivity(activity, FeedDraft.builder().setType(str).setExtraId(str2).setExtraData(str).build());
            }
        });
    }

    /* access modifiers changed from: private */
    public static void startReplyActivity(Activity activity, FeedDraft feedDraft) {
        activity.startActivity(new Intent(activity, ReplyActivity.class).putExtra("EXTRA_DRAFT", feedDraft).setFlags(65536));
        activity.overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: private */
    public static void startReplyActivity(Activity activity, FeedDraft feedDraft, Entity entity) {
        activity.startActivity(new Intent(activity, ReplyActivity.class).putExtra("EXTRA_DRAFT", feedDraft).putExtra("EXTRA_FEED_REPLY", entity).setFlags(65536));
        activity.overridePendingTransition(0, 0);
    }

    public static void startFeedDetailActivity(Context context, Feed feed, String str) {
        startFeedDetailActivity(context, feed, str, 0);
    }

    public static void startFeedDetailActivity(Context context, Feed feed, String str, int i) {
        if (str != null) {
            i = i | 2 | 1;
        }
        if (feed == null || !"album".equals(feed.getFeedType())) {
            context.startActivity(new Intent(context, FeedDetailActivityV8.class).putExtra("extra_reply_id", str).putExtra("extra_feed", feed).putExtra("extra_flag", i));
        } else {
            startV8AlbumDetailActivity(UiUtils.getActivity(context), feed.getId(), str, i);
        }
    }

    public static void startFeedDetailActivity(Context context, String str, String str2) {
        ActionManagerCompat.startFeedDetailActivity(context, str, str2, null, null, 0, null, null);
    }

    public static void startNodeRatingListActivity(Context context, String str, String str2, String str3, String str4) {
        SimpleActivity.builder(context).fragmentClass(NodeRatingListFragment.class).addArgs("target_id", str3).addArgs("target_type", str2).addArgs("target_version", str4).title(str).start();
    }

    public static void startNodeRatingListActivity(Context context, String str, String str2, String str3, String str4, int i, int i2) {
        SimpleActivity.builder(context).fragmentClass(NodeRatingListFragment.class).addArgs("target_id", str3).addArgs("target_type", str2).addArgs("target_version", str4).addArgs("show_buyStatus", i).addArgs("show_ownerStatus", i2).title(str).start();
    }

    public static void startLoginUserRatingListActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(LoginUserNodeRatingListFragment.class).addArgs("uid", str2).title(str).start();
    }

    public static void startAppForumListActivity(Context context, String str, String str2, String str3) {
        SimpleActivity.builder(context).fragmentClass(AppForumListFragment.class).addArgs("type", str).addArgs("path", str2).title(str3).start();
    }

    public static void startPickAppActivity(Fragment fragment, int i) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), PickAppTabActivity.class), i);
    }

    public static void startPickAppActivity(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, PickAppTabActivity.class), i);
    }

    public static void startDeveloperAppListActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(DeveloperAppListFragment.class).title(str).addArgs("DEVELOPER_UID", str2).start();
    }

    public static void startCardSampleListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(CardSampleListFragment.class).title("Card Sample").addArgs("NAME", str).start();
    }

    public static void startVideoDetailListActivity(Context context, VideoModel videoModel, View view, String str) {
        startVideoDetailListActivity(context, videoModel, view != null ? ViewExtendsKt.getGlobalRect(view) : null, str);
    }

    public static void startVideoDetailListActivity(Context context, VideoModel videoModel, Rect rect, String str) {
        Intent intent = new Intent(context, VideoDetailListActivity.class);
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null) {
            activityNullable = AppHolder.getCurrentActivity();
        }
        if (activityNullable == null) {
            intent.addFlags(268435456);
        } else {
            activityNullable.overridePendingTransition(0, 0);
        }
        intent.addFlags(65536);
        if (rect != null) {
            intent.putExtra("extra_video_rect", rect);
        }
        intent.putExtra("extra_video_model", videoModel);
        intent.putExtra("extra_video_source_bridge_key", str);
        if (activityNullable == null) {
            context.startActivity(intent);
        } else {
            activityNullable.startActivity(intent);
        }
    }

    public static void startCollectionListCreateActivity(Activity activity) {
        activity.startActivity(new Intent(activity, CreateCollectionActivity.class));
    }

    public static void startCollectionEditActivity(Activity activity, Collection collection) {
        Intent intent = new Intent(activity, CreateCollectionActivity.class);
        intent.putExtra("KEY_ID", collection.getId());
        intent.putExtra("KEY_EDIT_STATE", true);
        intent.putExtra("KEY_TITLE", collection.getTitle());
        intent.putExtra("KEY_DES", collection.getDescription());
        intent.putExtra("KEY_COVER", collection.getCoverPic());
        intent.putExtra("KEY_OPEN_STATE", collection.getIsOpened());
        activity.startActivity(intent);
    }

    public static void startCollectionListCreateActivityForResult(Fragment fragment, String str, int i) {
        Intent intent = new Intent(fragment.getActivity(), CreateCollectionActivity.class);
        intent.putExtra("KEY_FROM", str);
        fragment.startActivityForResult(intent, i);
    }

    public static void startCollectionListActivity(Activity activity) {
        SimpleActivity.builder(activity).fragmentClass(CollectionListFragment.class).start();
    }

    public static void startPickUserActivity(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, ContactPickActivityV9.class), i);
    }

    public static void startPickUserActivity(Activity activity, int i, int i2, String str) {
        activity.startActivityForResult(new Intent(activity, ContactPickActivityV9.class).putExtra("EXTRA_ERROR_TEXT", str).putExtra("EXTRA_MAX_COUNT", i2), i);
    }

    public static void startPickTopicActivity(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, TopicPickerActivity.class), i);
    }

    public static void startPickTopicToWriteActivity(Activity activity) {
        activity.startActivity(new Intent(activity, TopicPickerActivity.class).putExtra("KEY_ACTION_TYPE", "ACTION_TYPE_WRITE"));
    }

    public static void startPickUserActivity(Fragment fragment, int i, int i2, String str) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), ContactPickActivityV9.class).putExtra("EXTRA_ERROR_TEXT", str).putExtra("EXTRA_MAX_COUNT", i2), i);
    }

    public static void startPickTopicActivity(Fragment fragment, int i) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), TopicPickerActivity.class), i);
    }

    public static void startMainActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    public static void startMainActivity(Context context, String str) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("extra_url", str);
        intent.addFlags(65536);
        context.startActivity(intent);
    }

    public static void startNewFeedV8Activity(Activity activity) {
        startSubmitFeedV8Activity(activity, FeedArgsFactory.uiConfigForFeed(activity).build(), FeedArgsFactory.multiPartForFeed().build());
    }

    public static void startNewSecondHandActivity(Activity activity) {
        startSubmitFeedV8Activity(activity, FeedArgsFactory.uiConfigForSecondHand(activity).build(), FeedArgsFactory.multiPartForSecondHand().build());
    }

    public static void startNewSecondHandFromPhoneBaActivity(Activity activity, Product product) {
        startSubmitFeedV8Activity(activity, FeedUIConfig.builder(FeedArgsFactory.uiConfigForSecondHand(activity).build()).relativeLogo(product.getLogo()).relativeTitle(product.getTitle()).fromPhoneBaToSecondHand(true).showParamsItem(true).build(), FeedMultiPart.builder(FeedArgsFactory.multiPartForSecondHand().build()).productId(product.getId()).secondHandSthType("100").build());
    }

    public static void startAnswerFeedActivity(Activity activity, Feed feed) {
        startSubmitFeedV8Activity(activity, FeedArgsFactory.uiConfigForAnswerFeed(activity, feed), FeedArgsFactory.multiPartForAnswerFeed(activity, feed));
    }

    public static void startShareFeedV8Activity(Activity activity, String str) {
        Intent intent = new Intent(activity, ShareFeedV8Activity.class);
        intent.putExtra("text", str);
        activity.startActivity(intent);
    }

    public static void startProductShareVideoActivity(Activity activity, Product product) {
        Intent intent = new Intent(activity, ProductShareVideoActivity.class);
        intent.putExtra("extra_data", product);
        activity.startActivity(intent);
    }

    public static void startQuestionTitleV8Activity(Activity activity) {
        activity.startActivity(new Intent(activity, QuestionTitleActivity.class));
    }

    public static void startQuestionTitleV8Activity(Activity activity, FeedUIConfig feedUIConfig, FeedMultiPart feedMultiPart) {
        activity.startActivity(new Intent(activity, QuestionTitleActivity.class).putExtra("MULTI_PART", feedMultiPart).putExtra("UI_CONFIG", feedUIConfig));
    }

    public static void startForwardFeedV8Activity(Activity activity, Feed feed) {
        startSubmitFeedV8Activity(activity, FeedArgsFactory.uiConfigForForwardFeed(activity, feed), FeedArgsFactory.multiPartForForwardFeed(feed));
    }

    public static void startForwardDyhArticleV8Activity(Activity activity, DyhArticle dyhArticle) {
        startSubmitFeedV8Activity(activity, FeedArgsFactory.uiConfigForForwardDyhArticle(activity, dyhArticle), FeedArgsFactory.multiPartForForwardDyhArticle(activity, dyhArticle));
    }

    public static void startSecondEditActivity(Activity activity, Feed feed) {
        startSubmitFeedV8Activity(activity, FeedConvertUtilsKt.convertToFeedUIConfig(feed, activity), FeedConvertUtilsKt.convertToFeedMultiPart(feed));
    }

    public static void startSubmitFeedV8Activity(Activity activity, FeedUIConfig feedUIConfig, FeedMultiPart feedMultiPart) {
        doOnLogin(activity, new Runnable(activity, feedUIConfig, feedMultiPart) {
            /* class com.coolapk.market.manager.$$Lambda$ActionManager$nYR4tX6L81x20qNDfRWgxT7YVsM */
            public final /* synthetic */ Activity f$0;
            public final /* synthetic */ FeedUIConfig f$1;
            public final /* synthetic */ FeedMultiPart f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.lambda$startSubmitFeedV8Activity$0(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    static /* synthetic */ void lambda$startSubmitFeedV8Activity$0(Activity activity, FeedUIConfig feedUIConfig, FeedMultiPart feedMultiPart) {
        Intent intent = new Intent(activity, SubmitFeedV8Activity.class);
        intent.putExtra("UI_CONFIG", feedUIConfig);
        intent.putExtra("MULTI_PART", feedMultiPart);
        activity.startActivity(intent);
    }

    public static void startSubmitFeedV8Activity(Activity activity, RoughDraft roughDraft) {
        doOnLogin(activity, new Runnable(activity, roughDraft) {
            /* class com.coolapk.market.manager.$$Lambda$ActionManager$NrxVKaKiadewp9cGmrk5BKwZFdc */
            public final /* synthetic */ Activity f$0;
            public final /* synthetic */ RoughDraft f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.lambda$startSubmitFeedV8Activity$1(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$startSubmitFeedV8Activity$1(Activity activity, RoughDraft roughDraft) {
        Intent intent = new Intent(activity, SubmitFeedV8Activity.class);
        intent.putExtra("UI_CONFIG", roughDraft.getUiConfig());
        intent.putExtra("MULTI_PART", roughDraft.getMultiPart());
        intent.putExtra("DRAFT_ID", roughDraft.getId());
        activity.startActivity(intent);
    }

    public static void startNewFeedActivity(Activity activity, Feed feed) {
        if (feed == null) {
            startNewFeedV8Activity(activity);
        } else {
            startForwardFeedV8Activity(activity, feed);
        }
    }

    public static void startNewFeedForDyhActivity(Activity activity, DyhArticle dyhArticle) {
        if (dyhArticle == null) {
            startNewFeedV8Activity(activity);
        } else {
            startForwardDyhArticleV8Activity(activity, dyhArticle);
        }
    }

    public static void startAppCommentActivity(Activity activity, ServiceApp serviceApp, String str) {
        FeedUIConfig.Builder uiConfigForFeed = FeedArgsFactory.uiConfigForFeed(activity);
        FeedArgsFactoryKt.applyServiceApp(uiConfigForFeed, serviceApp);
        FeedMultiPart.Builder multiPartForFeed = FeedArgsFactory.multiPartForFeed();
        FeedArgsFactoryKt.applyServiceApp(multiPartForFeed, serviceApp).message(KotlinExtendKt.notNull(str, ""));
        startSubmitFeedV8Activity(activity, uiConfigForFeed.build(), multiPartForFeed.build());
    }

    public static void startSplashActivity(Context context, boolean z) {
        context.startActivity(new Intent(context, SplashActivity.class).putExtra("MODE", z ? "ONLY_DISPLAY" : "COUNTDOWN"));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    public static void startFullScreenAdActivity(Context context) {
        context.startActivity(new Intent(context, FullScreenAdActivity.class));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    public static void startSplashActivity(Activity activity, String str, int i) {
        activity.startActivityForResult(new Intent(activity, SplashActivity.class).putExtra("MODE", "COUNTDOWN").putExtra("MODE", str), i);
        activity.overridePendingTransition(0, 0);
    }

    public static void startTopicFeedActivity(Context context, String str) {
        Intent buildTopicIntent = DynamicNodePageActivity.buildTopicIntent(context);
        buildTopicIntent.putExtra("TOPIC_TITLE", str);
        context.startActivity(buildTopicIntent);
    }

    public static void startProjectLibraryListActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(LibrariesFragment.class).title(context.getString(2131887018)).start();
    }

    public static void startNewDiscoveryV8Activity(Activity activity, MobileApp mobileApp) {
        startSubmitFeedV8Activity(activity, FeedArgsFactory.uiConfigForDiscovery(activity, mobileApp), FeedArgsFactory.multiPartForDiscovery(activity, mobileApp));
    }

    public static void startRelatedDataList(Context context, List<RelatedData> list, String str) {
        ArrayList<? extends Parcelable> arrayList;
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.addAll(list);
            arrayList = arrayList2;
        }
        SimpleActivity.builder(context).title(str).fragmentClass(LocalRelateDataListFragment.class).addParcelableArrayList("data", arrayList).start();
    }

    public static void startIntentActivity(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setData(parse);
            boolean z = false;
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                z = true;
            }
            if (z) {
                context.startActivity(intent);
            }
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static void startActivityByUrl(Context context, String str) {
        ActionManagerCompat.startActivityByUrl(context, str, null, null);
    }

    @Deprecated
    public static void startActivityByLink(Context context, String str, String str2, String... strArr) {
        ActionManagerCompat.startActivityByUrl(context, str2, str, (strArr == null || strArr.length <= 0) ? null : strArr[0]);
    }

    public static void startRankActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(RankFragment.class).title(context.getString(2131887356)).start();
    }

    public static void startRecommendAlbumListActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(RecommendAlbumListFragment.class).title(str).addArgs("album_type", str2).start();
    }

    public static void startEditorChoiceActivity(Context context, String str) {
        context.startActivity(new Intent(context, EditorChoiceActivity.class).putExtra("title", str));
    }

    public static void startRecommendAppListActivity(Context context, String str, String str2, String str3, String str4) {
        SimpleActivity.builder(context).fragmentClass(RecommendAppListFragment.class).title(str).addArgs("apk_type", str4).addArgs("title", str).addArgs("SUBTITLE", str2).addArgs("action", str3).start();
    }

    public static void startLatestListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(LatestListFragment.class).title(str).start();
    }

    public static void startNewestListActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(NewestListFragment.class).title(str).start();
    }

    public static void startTextViewActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, TextViewActivity.class);
        intent.putExtra("TEXT", str);
        activity.startActivity(intent);
    }

    public static void startTextViewActivity(Activity activity, String str, int i, String str2) {
        Intent intent = new Intent(activity, TextViewActivity.class);
        intent.putExtra("TEXT", str);
        intent.putExtra("TEXT_SIZE", i);
        intent.putExtra("name", str2);
        activity.startActivity(intent);
    }

    public static void startAdminNewestFeedList(Activity activity) {
        SimpleActivity.builder(activity).title("全站动态").fragmentClass(AdminFeedFragment.class).start();
    }

    public static void startAdminNewestFeedReplyList(Activity activity) {
        SimpleActivity.builder(activity).title("全站回复").fragmentClass(AdminFeedReplyFragment.class).start();
    }

    public static void startSpamFeedListFragment(Activity activity) {
        SimpleActivity.builder(activity).title("动态鉴黄").fragmentClass(SpamFeedListFragment.class).start();
    }

    public static void startSpamFeedReplyListFragment(Activity activity) {
        SimpleActivity.builder(activity).title("回复鉴黄").fragmentClass(SpamFeedReplyListFragment.class).start();
    }

    public static void startSpamActivity(Context context, int i) {
        Intent intent = new Intent(context, SpamActivity.class);
        intent.putExtra("TYPE", i);
        context.startActivity(intent);
    }

    public static void startAllFeedActivity(Context context) {
        context.startActivity(new Intent(context, AllFeedActivity.class));
    }

    public static void startAllBlockListActivity(Context context) {
        context.startActivity(new Intent(context, AllBlockFeedActivity.class));
    }

    public static void startHistoryVersionActivity(Context context, String str, String str2, String str3) {
        SimpleActivity.builder(context).fragmentClass(HistoryVersionFragment.class).addArgs("APK_ID", str2).addArgs("LOGO", str3).title(str).start();
    }

    public static void startDeveloperAppsActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(DeveloperAppsFragment.class).addArgs("DEVELOPER_NAME", str).title(str).start();
    }

    public static void startRelatedAppsActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(RelatedAppsFragment.class).addArgs("KEYWORD", str).title(context.getString(2131887016)).start();
    }

    public static void startRelatedAlbumsActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(RelatedAlbumsFragment.class).addArgs("KEYWORD", str).title(context.getString(2131887017)).start();
    }

    public static void startFeedFollowerListActivity(Activity activity, String str) {
        SimpleActivity.builder(activity).title(activity.getString(2131887083)).addArgs("FEED_ID", str).fragmentClass(FeedFollowerListFragment.class).start();
    }

    public static void startShareImageListActivity(Context context, String str) {
        Intent intent = new Intent(context, ShareImageListActivity.class);
        intent.putExtra("extra_file_path", str);
        context.startActivity(intent);
        UiUtils.getActivity(context).overridePendingTransition(0, 0);
    }

    public static void shareText(Context context, Entity entity) {
        Intent intent = new Intent(context, ShareListActivity.class);
        intent.putExtra("extra_entity", entity);
        context.startActivity(intent);
        UiUtils.getActivity(context).overridePendingTransition(0, 0);
    }

    public static void shareText(Context context, String str, String str2) {
        HolderItem build = HolderItem.newBuilder().title(str).description(str2).entityType("share_entity").url(StringUtils.getExtraUrl(context, str2)).build();
        Intent intent = new Intent(context, ShareListActivity.class);
        intent.putExtra("extra_entity", build);
        context.startActivity(intent);
        UiUtils.getActivity(context).overridePendingTransition(0, 0);
    }

    public static void shareImage(Context context, File file) {
        try {
            Uri safeFileShareUrl = UriUtils.getSafeFileShareUrl(context, file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.STREAM", safeFileShareUrl);
            CoolFileUtils.grantUriPermission(context, intent, safeFileShareUrl);
            context.startActivity(Intent.createChooser(intent, context.getString(2131887044)));
        } catch (Exception e) {
            Toast.error(context, e);
        }
    }

    public static void sendLogFile(Context context, File file) {
        try {
            Uri safeFileShareUrl = UriUtils.getSafeFileShareUrl(context, file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/*");
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.STREAM", safeFileShareUrl);
            CoolFileUtils.grantUriPermission(context, intent, safeFileShareUrl);
            context.startActivity(Intent.createChooser(intent, "发送日志"));
        } catch (Exception e) {
            Toast.error(context, e);
        }
    }

    public static void startForwardEntityActivity(Context context, Entity entity) {
        Intent intent = new Intent(context, ForwardEntityActivity.class);
        if (entity instanceof Feed) {
            entity = EntityExtendsKt.toShortFeed((Feed) entity);
        }
        intent.putExtra("extra_entity", entity);
        context.startActivity(intent);
        UiUtils.getActivity(context).overridePendingTransition(0, 0);
    }

    public static void shareTextBySystem(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            intent.putExtra("android.intent.extra.TEXT", str3);
            context.startActivity(Intent.createChooser(intent, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startDiscoveryOfTheirsActivity(Context context, String str) {
        Intent intent = new Intent(context, RelateDataListActivity.class);
        intent.setAction("ACTION_DISCOVERY_OF_THEIRS");
        intent.putExtra("APK_ID", str);
        context.startActivity(intent);
    }

    public static void startRatingOfTheirsActivity(Context context, String str) {
        Intent intent = new Intent(context, RelateDataListActivity.class);
        intent.setAction("ACTION_RATING_OF_THEIRS");
        intent.putExtra("APK_ID", str);
        context.startActivity(intent);
    }

    public static void startAppDetailActivity(Context context, ServiceApp serviceApp) {
        Intent intent = new Intent(context, AppDetailActivity.class);
        intent.putExtra("APP", serviceApp);
        context.startActivity(intent);
    }

    public static void startPermissionActivity(Context context, ArrayList<String> arrayList) {
        SimpleActivity.builder(context).fragmentClass(PermissionFragment.class).addArgs("PERMISSION_LIST", arrayList).title(StringUtils.titleWithNum(context.getString(2131886985), arrayList)).start();
    }

    public static void startGiftCenterActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(GiftListFragment.class).title(context.getString(2131887326)).start();
    }

    public static void startUserGiftCenterActivity(Context context, String str) {
        SimpleActivity.builder(context).fragmentClass(GiftListFragment.class).title(context.getString(2131886940)).addArgs("UID", str).addArgs("USER_SIGN", str).start();
    }

    public static void startUserBlockContentActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(BlockCategoryFragment.class).title(context.getString(2131887131)).start();
    }

    public static void startUserBlockWordListActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(BlockWordListFragment.class).title("首页屏蔽关键词").start();
    }

    public static void startUserBlockNodeListActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(BlockNodeListFragment.class).title("首页屏蔽板块").start();
    }

    public static void startUserBlockUserListActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(BlockUserListFragment.class).title("首页屏蔽用户").start();
    }

    public static void startGiftListActivity(Context context, String str, String str2) {
        SimpleActivity.builder(context).fragmentClass(GiftListFragment.class).title(context.getString(2131887287, str2)).addArgs("APK_ID", str).start();
    }

    public static void startQuestionDetailActivity(Context context, String str) {
        startFeedDetailActivity(context, str, (String) null);
    }

    public static void startEditUserInfoActivity(Context context, String str, UserProfile userProfile) {
        Intent intent = new Intent(context, EditUserInfoAcitvity.class);
        intent.putExtra("TYPE", str);
        intent.putExtra("USER", userProfile);
        context.startActivity(intent);
    }

    public static void startEditUserInfoActivity(Context context, String str) {
        try {
            Intent intent = new Intent(context, EditUserInfoAcitvity.class);
            intent.putExtra("TYPE", str);
            context.startActivity(intent);
        } catch (AndroidRuntimeException unused) {
            Intent intent2 = new Intent(context, EditUserInfoAcitvity.class);
            intent2.putExtra("TYPE", str);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public static void startAccountSettingActivity(Context context, String str) {
        startWebViewTitleActivity(context, str, "", true);
    }

    public static void startEditUserInfoActivity(Fragment fragment, String str, UserProfile userProfile) {
        Intent intent = new Intent(fragment.getActivity(), EditUserInfoAcitvity.class);
        intent.putExtra("TYPE", str);
        intent.putExtra("USER", userProfile);
        if (TextUtils.equals(str, "EMAIL")) {
            fragment.startActivityForResult(intent, 555);
        } else if (TextUtils.equals(str, "PHONE")) {
            fragment.startActivityForResult(intent, 666);
        }
    }

    public static void startCountyListActivity(Fragment fragment) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), CountyListActivity.class), 777);
    }

    public static void startCountyListActivity(Context context) {
        context.startActivity(new Intent(context, CountyListActivity.class));
    }

    public static void startProductActivity(Context context, String str) {
        Intent buildProductIntent = DynamicNodePageActivity.buildProductIntent(context);
        buildProductIntent.putExtra("PRODUCT_ID", str);
        context.startActivity(buildProductIntent);
    }

    public static void startProductBrandListActivity(Context context) {
        context.startActivity(new Intent(context, ProductBrandListActivity.class));
    }

    public static void startDigitalCategoryListActivity(Context context, String str) {
        Intent intent = new Intent(context, ProductCategoryListActivity.class);
        intent.putExtra("extra_selected_id", str);
        context.startActivity(intent);
    }

    public static void startProductBrandListInErshouActivity(Activity activity, int i, int i2, int i3) {
        Intent intent = new Intent(activity, SecondHandProductBrandListActivity.class);
        intent.putExtra("extra_data_type", i);
        intent.putExtra("extra_data_deal_type", i2);
        activity.startActivityForResult(intent, i3);
    }

    public static void startProductBrandListInErshouActivity(Context context, int i, int i2) {
        Intent intent = new Intent(context, SecondHandProductBrandListActivity.class);
        intent.putExtra("extra_data_type", i);
        intent.putExtra("extra_data_deal_type", i2);
        context.startActivity(intent);
    }

    public static void startNodeRecommendPickerActivity(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, NodeRecommendPickerActivity.class), i);
    }

    public static void sendCheckForNetworkStateBroadcast(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.coolapk.market.CHECK_FOR_NETWORK_STATE"));
    }

    public static void doOnStoragePermissionPermit(Activity activity, final Runnable runnable) {
        LibraryExtentsKt.asObservable(XXPermissions.with(activity).permission("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")).flatMap(new Func1<Boolean, Observable<?>>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass25 */

            public Observable<?> call(Boolean bool) {
                if (bool.booleanValue()) {
                    runnable.run();
                } else {
                    Toast.show(AppHolder.getApplication(), "酷安没有获得读取存储权限");
                }
                return Observable.empty();
            }
        }).subscribe((Subscriber<? super R>) new EmptySubscriber());
    }

    public static void doOnLogin(final Context context, final Runnable runnable) {
        RxLogin.getInstance(context).requestLogin().flatMap(new Func1<Boolean, Observable<?>>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass27 */

            public Observable<?> call(Boolean bool) {
                if (bool.booleanValue()) {
                    runnable.run();
                }
                return Observable.empty();
            }
        }).subscribe((Subscriber<? super R>) new EmptySubscriber<Object>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass26 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(context, th);
            }
        });
    }

    public static void checkLogin(Context context, Runnable runnable) {
        if (checkLogin(context).booleanValue()) {
            runnable.run();
        }
    }

    public static Boolean checkLogin(Context context) {
        if (DataManager.getInstance().getLoginSession().isLogin()) {
            return true;
        }
        Toast.show(context, 2131887022);
        startLoginActivity(context);
        return false;
    }

    public static void checkShouldReturnToMainActivity(BaseActivity baseActivity) {
        if (TextUtils.equals(AppHolder.getAppSetting().getConfigJson().optString("Share.ReturnMainActivity", "true"), "true") && AppHolder.getActivityStackManager().getBottomActivity() == baseActivity && baseActivity.shouldReturnToMainActivity()) {
            baseActivity.startActivity(Intent.makeMainActivity(new ComponentName(baseActivity, MainActivity.class.getName())));
        }
    }

    public static void requestCheckNotificationCount() {
        if (System.currentTimeMillis() - AppHolder.getAppSetting().getLastCheckCountTime() >= (!AppHolder.getAppPushManager().isRegistered() ? 60000 : 300000)) {
            checkNotificationCount();
        }
    }

    public static void checkNotificationCount() {
        AppHolder.getAppSetting().markCheckCount();
        DataManager.getInstance().checkNotificationCount().subscribeOn(Schedulers.io()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<NotifyCount>() {
            /* class com.coolapk.market.manager.ActionManager.AnonymousClass28 */

            public void onNext(NotifyCount notifyCount) {
                super.onNext((AnonymousClass28) notifyCount);
                if (notifyCount != null) {
                    AppHolder.getAppNotification().updateCount(notifyCount);
                }
            }
        });
    }

    public static void openInCoolApk(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.coolapk.market", 0);
            if (packageInfo == null || packageInfo.versionCode >= 1512300) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.coolapk.com/apk/" + str)));
                return;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolapk.market", "com.coolapk.market.AppViewActivity"));
            intent.setData(Uri.parse("market://details?id=" + str));
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.coolapk.com/apk/" + str)));
        }
    }

    public static class WifiDownloadIntentDialog extends BaseDialogFragment {
        private Extra extra;
        private int flag;
        private String url;

        public static WifiDownloadIntentDialog newInstance(String str, Extra extra2, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putParcelable("extra", extra2);
            bundle.putInt("flag", i);
            WifiDownloadIntentDialog wifiDownloadIntentDialog = new WifiDownloadIntentDialog();
            wifiDownloadIntentDialog.setArguments(bundle);
            return wifiDownloadIntentDialog;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.url = getArguments().getString("url");
            this.extra = (Extra) getArguments().getParcelable("extra");
            this.flag = getArguments().getInt("flag");
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new AlertDialog.Builder(getActivity()).setMessage(2131886953).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.manager.ActionManager.WifiDownloadIntentDialog.AnonymousClass3 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActionManager.startDownload((Context) WifiDownloadIntentDialog.this.getActivity(), WifiDownloadIntentDialog.this.url, WifiDownloadIntentDialog.this.extra, WifiDownloadIntentDialog.this.flag, true);
                }
            }).setNeutralButton("不再提示", new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.manager.ActionManager.WifiDownloadIntentDialog.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DataManager.getInstance().getPreferencesEditor().putBoolean("download_only_when_wifi", false).apply();
                    ActionManager.startDownload((Context) WifiDownloadIntentDialog.this.getActivity(), WifiDownloadIntentDialog.this.url, WifiDownloadIntentDialog.this.extra, WifiDownloadIntentDialog.this.flag, true);
                }
            }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.manager.ActionManager.WifiDownloadIntentDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create();
        }
    }

    public static void reportHijack(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        ReportWorker.start(context, new Data.Builder().putString("REPORT_TYPE", "HIJACK").putString("APK_NAME", str).putString("DOWNLOAD_URL", str2).putString("REPORT_DOWNLOAD_URL", str3).putString("REPORT_PACKAGE_NAME", str4).putString("REPORT_TITLE", str5).putString("REPORT_VERSION_NAME", str6).putInt("REPORT_VERSION_CODE", i).build());
    }

    public static void reportUnknown(Context context, String str, String str2, String str3) {
        ReportWorker.start(context, new Data.Builder().putString("REPORT_TYPE", "UNKNOWN").putString("APK_NAME", str).putString("DOWNLOAD_URL", str2).putString("REPORT_DOWNLOAD_URL", str3).build());
    }

    public static void reportExposure(Context context, List<String> list) {
        ReportWorker.start(context, new Data.Builder().putString("REPORT_TYPE", "EXPOSURE").putStringArray("DATA_SET", (String[]) list.toArray(new String[0])).build());
    }

    public static void reportSponsorClose(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        ReportWorker.start(context, new Data.Builder().putString("REPORT_TYPE", "AD_CLOSE").putString("AD_ID", str).putString("AD_PLATFORM", str2).putString("AD_APP_ID", str3).putString("AD_POS_ID", str4).putString("AD_TITLE", str5).putString("AD_DESC", str6).putString("AD_PICS", str7).putString("AD_INFO", str8).putInt("AD_REASON", i).build());
    }

    public static void reportCoupon(Context context, String str, int i, String str2) {
        ReportWorker.start(context, new Data.Builder().putString("REPORT_TYPE", "COUPON").putString("COUPON_DATA", str).putInt("COUPON_INDEX", i).putString("COUPON_APK_ID", str2).build());
    }

    public static void startRichEditActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(RichEditorFragment.class).start();
    }

    public static void startUserDyhFollowList(Context context, boolean z) {
        Intent intent = new Intent(context, DyhListActivity.class);
        intent.putExtra("isFollow", z);
        context.startActivity(intent);
    }

    public static void startDyhList(Context context, String str) {
        Intent intent = new Intent(context, DyhListActivity.class);
        intent.putExtra("LIST_TYPE", str);
        context.startActivity(intent);
    }

    public static void startDyhDetailActivity(Context context, String str) {
        Intent intent = new Intent(context, DyhDetailActivity.class);
        intent.putExtra("DYH_ID", str);
        context.startActivity(intent);
    }

    public static void startDyhDetailActivity(Context context, DyhModel dyhModel) {
        Intent intent = new Intent(context, DyhDetailActivity.class);
        intent.putExtra("DYH_ID", dyhModel.getId());
        intent.putExtra("DYH_EDITOR", dyhModel.getUid().equals(DataManager.getInstance().getLoginSession().getUid()));
        context.startActivity(intent);
    }

    public static void startDyhDetailActivity(Context context, String str, boolean z) {
        Intent intent = new Intent(context, DyhDetailActivity.class);
        intent.putExtra("DYH_ID", str);
        intent.putExtra("DYH_EDITOR", z);
        context.startActivity(intent);
    }

    public static void startDyhArticleDetailActivity(Context context, String str) {
        Intent intent = new Intent(context, DyhArticleDetailActivity.class);
        intent.putExtra("extra_feed_id", str);
        context.startActivity(intent);
    }

    public static void startDyhArticleDetailActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, DyhArticleDetailActivity.class);
        intent.putExtra("extra_feed_id", str);
        intent.putExtra("extra_reply_id", str2);
        context.startActivity(intent);
    }

    public static void startPostButtonSettingActivity(Context context) {
        SimpleActivity.builder(context).title("发布按钮设置").fragmentClass(PostButtonSettingFragment.class).start();
    }

    public static void startBackupDetailListActivity(Context context, String str) {
        Intent intent = new Intent(context, BackupDetailListActivity.class);
        intent.putExtra("EXTRA_BACKUP_ID", str);
        context.startActivity(intent);
    }

    public static void startBackupListActivity(Context context) {
        context.startActivity(new Intent(context, BackupListActivity.class));
    }

    public static void startProductCouponActivity(Context context, Product product) {
        ProductCouponActivity.startActivity(context, product);
    }

    public static void startCollectionDetailActivity(Context context, String str) {
        Intent intent = new Intent(context, CollectionDetailActivity.class);
        intent.putExtra("EXTRA_COLLECTION_ID", str);
        context.startActivity(intent);
    }

    public static void startCollectionSelectActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, CollectionSelectActivity.class);
        intent.putExtra("id", str);
        intent.putExtra("type", str2);
        intent.addFlags(65536);
        context.startActivity(intent);
    }

    public static void startCollectionSelectActivity(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, CollectionSelectActivity.class);
        intent.putExtra("id", str);
        intent.putExtra("type", str2);
        intent.addFlags(65536);
        activity.startActivityForResult(intent, i);
    }

    public static void startCollectionSelectActivity(Fragment fragment, String str, String str2, int i) {
        Intent intent = new Intent(fragment.getActivity(), CollectionSelectActivity.class);
        intent.putExtra("id", str);
        intent.putExtra("type", str2);
        intent.addFlags(65536);
        fragment.startActivityForResult(intent, i);
    }

    public static void startPictureReplyListActivity(Context context, Feed feed, FeedReply feedReply, int i) {
        Intent intent = new Intent(context, PictureReplyDetailActivity.class);
        intent.putExtra("feed", feed);
        intent.addFlags(65536);
        context.startActivity(intent);
    }

    public static void startPictureTipActivity(Context context, int i) {
        Intent intent = new Intent(context, TipActivity.class);
        intent.putExtra("KEY_DATA", i);
        context.startActivity(intent);
    }

    public static void startCoolPicActivity(Context context, Feed feed, String str, String str2, String str3) {
        Intent intent = new Intent(context, CoolPicDetailActivity.class);
        intent.putExtra("feed", feed);
        intent.putExtra("listType", str);
        intent.putExtra("direction", str2);
        intent.putExtra("params", str3);
        context.startActivity(intent);
    }

    public static void startCoolPicActivity(Context context, String str) {
        Intent intent = new Intent(context, CoolPicDetailActivity.class);
        intent.putExtra("id", str);
        context.startActivity(intent);
    }

    public static void startCoolPicActivity(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, CoolPicDetailActivity.class);
        intent.putExtra("id", str);
        intent.putExtra("listType", str2);
        intent.putExtra("direction", str3);
        intent.putExtra("params", str4);
        context.startActivity(intent);
    }

    public static void startCoolPicActivity(Context context, Feed feed, String str, String str2, String str3, int i) {
        Intent intent = new Intent(context, CoolPicDetailActivity.class);
        intent.putExtra("feed", feed);
        intent.putExtra("listType", str);
        intent.putExtra("direction", str2);
        intent.putExtra("params", str3);
        intent.putExtra("index", i);
        context.startActivity(intent);
    }

    public static void startCoolPicActivity(Context context, Feed feed, String str, String str2, String str3, int i, int i2) {
        Intent intent = new Intent(context, CoolPicDetailActivity.class);
        intent.putExtra("feed", feed);
        intent.putExtra("listType", str);
        intent.putExtra("direction", str2);
        intent.putExtra("params", str3);
        intent.putExtra("index", i);
        intent.putExtra("list_index", i2);
        context.startActivity(intent);
    }

    public static void startChannelManagerActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(ChannelManagerFragment.class).title("全部频道").start();
    }

    public static void startSelectParamsAction(Activity activity, String str, String str2, List<ProductParams> list, String str3) {
        Intent intent = new Intent(activity, SelectParamsActivity.class);
        intent.putExtra("KEY_PRODUCT_ID", str);
        intent.putExtra("KEY_ERSHOU_TYPE_ID", str2);
        intent.putExtra("KEY_ERSHOU_DEAL_TYPE", str3);
        intent.putParcelableArrayListExtra("KEY_ERSHOU_PARAMS", (ArrayList) list);
        activity.startActivityForResult(intent, 5555);
    }

    public static void startSelectParamsAction(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, SelectParamsActivity.class);
        intent.putExtra("KEY_PRODUCT_ID", str);
        intent.putExtra("KEY_ERSHOU_TYPE_ID", str2);
        intent.putExtra("KEY_ERSHOU_DEAL_TYPE", str3);
        activity.startActivityForResult(intent, 5555);
    }

    public static void startFallsListFragment(Context context, String str, String str2, String str3) {
        SimpleAlphaActivity.builder(context).fragmentClass(FallsListFragment.class).addArgs("URL", str).addArgs("TITLE", str2).addArgs("SUBTITLE", str3).start();
    }

    public static void startCardManagerActivity(Context context) {
        context.startActivity(new Intent(context, MyCardManagerActivity.class));
    }

    public static void startCreateGoodsListActivity(Context context) {
        context.startActivity(new Intent(context, CreateFunThingsActivity.class));
    }

    public static void startFunThingsListActivity(Context context) {
        SimpleActivity.builder(context).fragmentClass(FunThingsListFragment.class).addArgs("UID", "").start();
    }

    public static void startFunThingsListEditActivity(Context context, Feed feed) {
        SimpleActivity.builder(context).fragmentClass(GoodGoodsEditListFragment.class).addArgs("DATA", feed).start();
    }

    public static void startGoodsListSelectActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, GoodsListSelectActivity.class);
        intent.putExtra("id", str);
        intent.putExtra("type", str2);
        intent.addFlags(65536);
        context.startActivity(intent);
    }

    public static void startPermissionsAgreeActivity(Activity activity, int i) {
        Intent intent = new Intent(activity, PermissionsAgreeActivity.class);
        intent.addFlags(65536);
        activity.startActivityForResult(intent, i);
    }
}
