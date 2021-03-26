package com.coolapk.market.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Gift;
import com.coolapk.market.util.UriActionUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bP\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0007J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0007J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0007J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0007J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0007J\u0018\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0003J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0007J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0007J\u0010\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0007J\u0012\u0010N\u001a\u0004\u0018\u00010\u00042\u0006\u0010O\u001a\u00020\u0004H\u0007J\b\u0010P\u001a\u00020\u0004H\u0007J\u0010\u0010Q\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0007J\u0010\u0010R\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0007J\b\u0010S\u001a\u00020\u0004H\u0007J\u0012\u0010S\u001a\u00020\u00042\b\b\u0002\u0010T\u001a\u00020UH\u0007J\b\u0010V\u001a\u00020\u0004H\u0007J\b\u0010W\u001a\u00020\u0004H\u0007J\b\u0010X\u001a\u00020\u0004H\u0007J\b\u0010Y\u001a\u00020\u0004H\u0007J\u0010\u0010Z\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0007J\u0010\u0010[\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020]H\u0007J\u0010\u0010^\u001a\u00020U2\u0006\u0010O\u001a\u00020\u0004H\u0007J\u0010\u0010_\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0007J\u0014\u0010`\u001a\u0004\u0018\u00010\u00042\b\u0010a\u001a\u0004\u0018\u00010bH\u0007J\b\u0010c\u001a\u00020\u0004H\u0007J\u0018\u0010d\u001a\u00020b2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0007J0\u0010i\u001a\u00020\u00042\b\b\u0002\u0010j\u001a\u00020\u00042\b\b\u0002\u0010k\u001a\u00020\u00042\b\b\u0002\u0010l\u001a\u00020\u00042\b\b\u0002\u0010m\u001a\u00020\u0004H\u0007J\u0010\u0010n\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u0004H\u0007J\u0012\u0010p\u001a\u00020q2\b\u0010O\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010r\u001a\u00020q2\u0006\u0010O\u001a\u00020\u0004H\u0007J\u0010\u0010s\u001a\u00020q2\u0006\u0010O\u001a\u00020\u0004H\u0007J\u0014\u0010t\u001a\u0004\u0018\u00010\u00042\b\u0010a\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/coolapk/market/util/UriUtils;", "", "()V", "BASE_ACCOUNT_HTTPS_URL", "", "BASE_HTTPS_URL", "BASE_M_HTTPS_URL", "BASE_REDIRECT_URL", "BASE_SHORT_HTTPS_URL", "BASE_URL", "DEPRECATED_FEED_URL", "DEPRECATED_PLAY_URL", "HOST", "HOST_FAXIAN", "HOST_PLAY", "HOST_SHORT", "OTHERMARKET", "SCHEME_COOLMARKET", "SCHEME_FILE", "SCHEME_FTP", "SCHEME_HTTP", "SCHEME_HTTPS", "SCHEME_MARKET", "SCHEME_PACKAGE", "SECONDHANDCHANNEL", "SHORT_BASE_URL", "URL_ACCOUNT_BIND_EMAIL", "URL_ACCOUNT_BIND_MOBILE", "URL_ACCOUNT_CHANGE_USERNAME", "URL_ACCOUNT_SETTING", "URL_ACTION_TYPE_ALBUM", "URL_ACTION_TYPE_APK", "URL_ACTION_TYPE_APPBA", "URL_ACTION_TYPE_ARTICLE", "URL_ACTION_TYPE_COLLECTION", "URL_ACTION_TYPE_DYH", "URL_ACTION_TYPE_DYH_ARTICLE", "URL_ACTION_TYPE_ELSE", "URL_ACTION_TYPE_FAXIAN", "URL_ACTION_TYPE_FEED", "URL_ACTION_TYPE_FEED_DEPRECATE", "URL_ACTION_TYPE_GAME", "URL_ACTION_TYPE_GAMEBA", "URL_ACTION_TYPE_GOODS", "URL_ACTION_TYPE_LIVE", "URL_ACTION_TYPE_MAIN", "URL_ACTION_TYPE_MARKET", "URL_ACTION_TYPE_PAGE", "URL_ACTION_TYPE_PICTURE", "URL_ACTION_TYPE_PRODUCT", "URL_ACTION_TYPE_SEARCH_TAB", "URL_ACTION_TYPE_SECOND_HAND", "URL_ACTION_TYPE_SELL", "URL_ACTION_TYPE_SIMPLE_ACTIVITY", "URL_ACTION_TYPE_TAB", "URL_ACTION_TYPE_TOPIC", "URL_ACTION_TYPE_USER_ID", "URL_ACTION_TYPE_USER_ID_DEPRECATE", "URL_ACTION_TYPE_USER_NAME", "URL_ACTION_TYPE_WEB", "URL_DYH_RECOMMEND", "URL_MY_DEVICE", "URL_PATH_KEY_REDIRCT_WEB", "buildAlbumUrl", "uid", "buildDyhArticleReportUrl", "articleId", "buildDyhPageUrl", "id", "buildFeedReplyReportUrl", "feedId", "buildFeedReportUrl", "buildReportUrl", "type", "buildUserPageUrl", "buildUserReportUrl", "generatePackageUri", "packageName", "getActionTypeFromUrl", "url", "getAdminManageUrl", "getAppManageUrl", "getAppReportUrl", "getCoolApkErshouAgreementUrl", "padding", "", "getCoolApkHelpUrl", "getCoolApkUserAgreementUrl", "getCoolApkUserPrivacyUrl", "getDyhBuildUrl", "getDyhEditUrl", "getGiftUrl", "gift", "Lcom/coolapk/market/model/Gift;", "getIdFromDeprecatedUrl", "getOtherMarketUrl", "getPackageNameFromUri", "uri", "Landroid/net/Uri;", "getReportManageUrl", "getSafeFileShareUrl", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "getSecondhandFilterUrl", "brand", "productId", "ershouType", "cityId", "getUserManageUrl", "userNameOrID", "isCoolApkHost", "", "isCoolMarketHost", "isInAppUrl", "trimScheme", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UriUtils.kt */
public final class UriUtils {
    public static final String BASE_ACCOUNT_HTTPS_URL = "https://account.coolapk.com";
    public static final String BASE_HTTPS_URL = "https://www.coolapk.com";
    public static final String BASE_M_HTTPS_URL = "https://m.coolapk.com";
    public static final String BASE_REDIRECT_URL = "http://coolapk.com/r/";
    public static final String BASE_SHORT_HTTPS_URL = "https://coolapk.com";
    public static final String BASE_URL = "http://www.coolapk.com";
    public static final String DEPRECATED_FEED_URL = "http://faxian.coolapk.com/";
    public static final String DEPRECATED_PLAY_URL = "http://play.coolapk.com/";
    public static final String HOST = "www.coolapk.com";
    public static final String HOST_FAXIAN = "faxian.coolapk.com";
    public static final String HOST_PLAY = "play.coolapk.com";
    public static final String HOST_SHORT = "coolapk.com";
    public static final UriUtils INSTANCE = new UriUtils();
    public static final String OTHERMARKET = "market://details?id=";
    public static final String SCHEME_COOLMARKET = "coolmarket";
    public static final String SCHEME_FILE = "file";
    public static final String SCHEME_FTP = "ftp";
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";
    public static final String SCHEME_MARKET = "market";
    public static final String SCHEME_PACKAGE = "package";
    public static final String SECONDHANDCHANNEL = "V9_CHANNEL_ERSHOU";
    public static final String SHORT_BASE_URL = "http://coolapk.com";
    public static final String URL_ACCOUNT_BIND_EMAIL = "https://account.coolapk.com/account/bind?type=email";
    public static final String URL_ACCOUNT_BIND_MOBILE = "https://account.coolapk.com/account/bind?type=mobile";
    public static final String URL_ACCOUNT_CHANGE_USERNAME = "https://account.coolapk.com/account/changeUsername";
    public static final String URL_ACCOUNT_SETTING = "https://account.coolapk.com/account/settings";
    public static final String URL_ACTION_TYPE_ALBUM = "album";
    public static final String URL_ACTION_TYPE_APK = "apk";
    public static final String URL_ACTION_TYPE_APPBA = "appba";
    public static final String URL_ACTION_TYPE_ARTICLE = "article";
    public static final String URL_ACTION_TYPE_COLLECTION = "collection";
    public static final String URL_ACTION_TYPE_DYH = "dyh";
    public static final String URL_ACTION_TYPE_DYH_ARTICLE = "dyhArticle";
    public static final String URL_ACTION_TYPE_ELSE = "else";
    public static final String URL_ACTION_TYPE_FAXIAN = "faxian";
    public static final String URL_ACTION_TYPE_FEED = "feed";
    public static final String URL_ACTION_TYPE_FEED_DEPRECATE = "feed_d";
    public static final String URL_ACTION_TYPE_GAME = "game";
    public static final String URL_ACTION_TYPE_GAMEBA = "gameba";
    public static final String URL_ACTION_TYPE_GOODS = "goods";
    public static final String URL_ACTION_TYPE_LIVE = "live";
    public static final String URL_ACTION_TYPE_MAIN = "main";
    public static final String URL_ACTION_TYPE_MARKET = "market";
    public static final String URL_ACTION_TYPE_PAGE = "page";
    public static final String URL_ACTION_TYPE_PICTURE = "picture";
    public static final String URL_ACTION_TYPE_PRODUCT = "product";
    public static final String URL_ACTION_TYPE_SEARCH_TAB = "searchTab";
    public static final String URL_ACTION_TYPE_SECOND_HAND = "ershou";
    public static final String URL_ACTION_TYPE_SELL = "tbncm";
    public static final String URL_ACTION_TYPE_SIMPLE_ACTIVITY = "SimpleActivity";
    public static final String URL_ACTION_TYPE_TAB = "tab";
    public static final String URL_ACTION_TYPE_TOPIC = "t";
    public static final String URL_ACTION_TYPE_USER_ID = "u";
    public static final String URL_ACTION_TYPE_USER_ID_DEPRECATE = "u_d";
    public static final String URL_ACTION_TYPE_USER_NAME = "n";
    public static final String URL_ACTION_TYPE_WEB = "web";
    public static final String URL_DYH_RECOMMEND = "#V8_CHANNEL_DYH_RECOMMEND";
    public static final String URL_MY_DEVICE = "/mp/do?c=userDevice&m=myDevice";
    public static final String URL_PATH_KEY_REDIRCT_WEB = "r";

    @JvmStatic
    public static final String getAdminManageUrl() {
        return "https://m.coolapk.com/ma/main?from=coolmarket";
    }

    @JvmStatic
    public static final String getCoolApkErshouAgreementUrl() {
        return "https://m.coolapk.com/mp/user/ershouAgreement";
    }

    @JvmStatic
    public static final String getCoolApkHelpUrl() {
        return "https://m.coolapk.com/mp/do?c=help&m=list";
    }

    @JvmStatic
    public static final String getCoolApkUserAgreementUrl() {
        return "https://m.coolapk.com/mp/user/agreement";
    }

    @JvmStatic
    public static final String getCoolApkUserPrivacyUrl() {
        return "https://m.coolapk.com/mp/user/privacy";
    }

    @JvmStatic
    public static final String getDyhBuildUrl() {
        return "https://m.coolapk.com/mp/do?c=dyh";
    }

    @JvmStatic
    public static final String getReportManageUrl() {
        return "https://m.coolapk.com/ma/do?c=feed&m=reportList";
    }

    private UriUtils() {
    }

    @JvmStatic
    public static final boolean isCoolMarketHost(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        DataConfig dataConfig = instance.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
        return TextUtils.equals(parse.getHost(), dataConfig.getApiHost());
    }

    @JvmStatic
    public static final boolean isCoolApkHost(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        String host = parse.getHost();
        String str3 = host;
        if (!(str3 == null || str3.length() == 0) && (StringsKt.endsWith$default(host, ".coolapk.com", false, 2, (Object) null) || Intrinsics.areEqual(host, "coolapk.com"))) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final String generatePackageUri(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return "package://" + str;
    }

    @JvmStatic
    public static final String trimScheme(String str) {
        if (str == null) {
            return null;
        }
        if (!StringsKt.startsWith$default(str, "http", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "file", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "package", false, 2, (Object) null)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(uri)");
        return parse.getPath();
    }

    @JvmStatic
    public static final String getPackageNameFromUri(Uri uri) {
        String queryParameter;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.equals("package", scheme)) {
            return uri.getPath();
        }
        if (TextUtils.equals("market", scheme)) {
            String host = uri.getHost();
            if (TextUtils.equals("details", host)) {
                return uri.getQueryParameter("id");
            }
            if (TextUtils.equals("search", host) && (queryParameter = uri.getQueryParameter("q")) != null && StringsKt.startsWith$default(queryParameter, "pname:", false, 2, (Object) null)) {
                String substring = queryParameter.substring(6);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return null;
    }

    @JvmStatic
    public static final String getActionTypeFromUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        UriActionUtils.UriAction findUriAction = UriActionUtils.findUriAction(parse);
        if (findUriAction != null) {
            return findUriAction.getActionType();
        }
        return null;
    }

    @JvmStatic
    public static final boolean isInAppUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        UriActionUtils.UriAction findUriAction = UriActionUtils.findUriAction(parse);
        String actionType = findUriAction != null ? findUriAction.getActionType() : null;
        if (actionType == null || !(!Intrinsics.areEqual(actionType, "web")) || !(!Intrinsics.areEqual(actionType, "else"))) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final int getIdFromDeprecatedUrl(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "url");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(str, "http://faxian.coolapk.com/", "", false, 4, (Object) null), "http://play.coolapk.com/", "", false, 4, (Object) null);
        try {
            if (StringsKt.endsWith$default(replace$default, ".html", false, 2, (Object) null)) {
                int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) replace$default, "-", 0, false, 6, (Object) null) + 1;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) replace$default, ".html", 0, false, 6, (Object) null);
                if (replace$default != null) {
                    String substring = replace$default.substring(lastIndexOf$default, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    i = Integer.parseInt(substring) + 150000;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                i = Integer.parseInt(replace$default);
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @JvmStatic
    public static final String getGiftUrl(Gift gift) {
        Intrinsics.checkNotNullParameter(gift, "gift");
        return "https://m.coolapk.com/mp/do?c=" + gift.getEntityType() + "&m=detail&id=" + gift.getId();
    }

    public static /* synthetic */ String getSecondhandFilterUrl$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return getSecondhandFilterUrl(str, str2, str3, str4);
    }

    @JvmStatic
    public static final String getSecondhandFilterUrl(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "brand");
        Intrinsics.checkNotNullParameter(str2, "productId");
        Intrinsics.checkNotNullParameter(str3, "ershouType");
        Intrinsics.checkNotNullParameter(str4, "cityId");
        return "#/feed/ershouList?brand=" + str + "&productId=" + str2 + "&cityId=" + str4 + "&ershouType=" + str3 + "&dataListType=staggered";
    }

    public static /* synthetic */ String getCoolApkErshouAgreementUrl$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 14;
        }
        return getCoolApkErshouAgreementUrl(i);
    }

    @JvmStatic
    public static final String getCoolApkErshouAgreementUrl(int i) {
        return "https://m.coolapk.com/mp/user/ershouAgreement?padding=" + i;
    }

    @JvmStatic
    public static final String buildUserPageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        String uri = Uri.parse("http://www.coolapk.com").buildUpon().appendEncodedPath("u").appendEncodedPath(str).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(BASE_URL).buil…              .toString()");
        return uri;
    }

    @JvmStatic
    public static final String buildDyhPageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        String uri = Uri.parse("https://www.coolapk.com").buildUpon().appendEncodedPath("dyh").appendEncodedPath(str).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(BASE_HTTPS_URL…              .toString()");
        return uri;
    }

    @JvmStatic
    public static final String buildAlbumUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        String uri = Uri.parse("http://www.coolapk.com").buildUpon().appendEncodedPath("album").appendEncodedPath(str).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(BASE_URL).buil…              .toString()");
        return uri;
    }

    @JvmStatic
    public static final String buildUserReportUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        return buildReportUrl("user", str);
    }

    @JvmStatic
    public static final String buildFeedReportUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "feedId");
        return buildReportUrl("feed", str);
    }

    @JvmStatic
    public static final String buildDyhArticleReportUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        return buildReportUrl("article", str);
    }

    @JvmStatic
    public static final String buildFeedReplyReportUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "feedId");
        return buildReportUrl("feed_reply", str);
    }

    @JvmStatic
    private static final String buildReportUrl(String str, String str2) {
        if (TextUtils.equals(str, "user")) {
            return "https://m.coolapk.com/mp/do?c=user&m=report&id=" + str2;
        }
        return "https://m.coolapk.com/mp/do?c=feed&m=report&type=" + str + "&id=" + str2;
    }

    @JvmStatic
    public static final String getUserManageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "userNameOrID");
        return "https://m.coolapk.com/ma/do?c=user&m=manage&uid=" + str;
    }

    @JvmStatic
    public static final String getAppManageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return "https://m.coolapk.com/ma/do?c=apk&m=manage&id=" + str;
    }

    @JvmStatic
    public static final String getAppReportUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return "https://m.coolapk.com/mp/apk/report?apkname=" + str;
    }

    @JvmStatic
    public static final String getOtherMarketUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return "market://details?id=" + str;
    }

    @JvmStatic
    public static final String getDyhEditUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return "https://m.coolapk.com/mp/do?c=dyh&m=manage&id=" + str;
    }

    @JvmStatic
    public static final Uri getSafeFileShareUrl(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        String absolutePath = file.getAbsolutePath();
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(context, AppHolder.getAppMetadata().getAuthority(), new File(absolutePath));
            Intrinsics.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…uthority, File(filePath))");
            return uriForFile;
        }
        Uri parse = Uri.parse("file://" + absolutePath);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(\"file://$filePath\")");
        return parse;
    }
}
