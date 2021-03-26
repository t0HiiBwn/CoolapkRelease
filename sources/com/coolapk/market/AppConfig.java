package com.coolapk.market;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.OaidManager;
import com.coolapk.market.util.AuthUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bH\u0002¢\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0)H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b00H\u0016J\b\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000205H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/coolapk/market/AppConfig;", "Lcom/coolapk/market/local/DataConfig;", "appContext", "Landroid/app/Application;", "appMetadata", "Lcom/coolapk/market/AppMetadata;", "(Landroid/app/Application;Lcom/coolapk/market/AppMetadata;)V", "androidId", "", "apiHostList", "Ljava/util/ArrayList;", "apiIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "appMode", "appVersionCode", "", "appVersionName", "deviceId", "imeiOrMeid", "imsi", "macAddress", "getMacAddress", "()Ljava/lang/String;", "specialHosts", "Ljava/util/HashMap;", "userAgent", "createHeaders", "", "()[Ljava/lang/String;", "createUserAgent", "versionName", "versionCode", "getApiEndpoint", "getApiHost", "getApplicationContext", "Landroid/content/Context;", "getCacheDir", "getCookieCharset", "getCookieDomain", "getCookiePath", "getCoolMarketHeaders", "", "getDatabaseName", "getDatabaseVersion", "getMetaData", "Landroid/os/Bundle;", "getPreferencesName", "getSpecialHosts", "", "getUserAgent", "isDebugEnabled", "", "onNetworkResponse", "", "response", "Lokhttp3/Response;", "requestChangeApiHost", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppConfig.kt */
public final class AppConfig extends DataConfig {
    public static final Companion Companion = new Companion(null);
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final String androidId;
    private final ArrayList<String> apiHostList;
    private AtomicInteger apiIndex = new AtomicInteger(0);
    private final Application appContext;
    private final AppMetadata appMetadata;
    private final String appMode;
    private final int appVersionCode;
    private final String appVersionName;
    private final String deviceId;
    private String imeiOrMeid;
    private String imsi;
    private final String macAddress;
    private final HashMap<String, String> specialHosts;
    private final String userAgent;

    @Override // com.coolapk.market.local.DataConfig
    public String getCookieCharset() {
        return "utf-8";
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getCookieDomain() {
        return "coolapk.com";
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getCookiePath() {
        return "/";
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getDatabaseName() {
        return "com.coolapk.market.v7.db";
    }

    @Override // com.coolapk.market.local.DataConfig
    public int getDatabaseVersion() {
        return 6;
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getPreferencesName() {
        return "coolapk_preferences_v7";
    }

    public AppConfig(Application application, AppMetadata appMetadata2) {
        Intrinsics.checkNotNullParameter(application, "appContext");
        Intrinsics.checkNotNullParameter(appMetadata2, "appMetadata");
        this.appContext = application;
        this.appMetadata = appMetadata2;
        HashMap<String, String> hashMap = new HashMap<>();
        this.specialHosts = hashMap;
        ArrayList<String> arrayList = new ArrayList<>();
        this.apiHostList = arrayList;
        LogUtils.v("AppConfig init", new Object[0]);
        String appVersionName2 = AppUtils.getAppVersionName();
        Intrinsics.checkNotNullExpressionValue(appVersionName2, "AppUtils.getAppVersionName()");
        this.appVersionName = appVersionName2;
        int appVersionCode2 = AppUtils.getAppVersionCode();
        this.appVersionCode = appVersionCode2;
        String appMode2 = appMetadata2.getAppMode();
        Intrinsics.checkNotNullExpressionValue(appMode2, "appMetadata.appMode");
        this.appMode = appMode2;
        String deviceId2 = SystemUtils.getDeviceId(application);
        Intrinsics.checkNotNullExpressionValue(deviceId2, "SystemUtils.getDeviceId(appContext)");
        this.deviceId = deviceId2;
        this.androidId = DeviceUtils.getAndroidID();
        String macAddress2 = DeviceUtils.getMacAddress();
        Intrinsics.checkNotNullExpressionValue(macAddress2, "DeviceUtils.getMacAddress()");
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
        Objects.requireNonNull(macAddress2, "null cannot be cast to non-null type java.lang.String");
        String upperCase = macAddress2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        this.macAddress = upperCase;
        this.userAgent = createUserAgent(appVersionName2, appVersionCode2, appMode2);
        arrayList.add("api.coolapk.com");
        arrayList.add("api2.coolapk.com");
        hashMap.put("/v6/live/messageList", "api-live.coolapk.com");
        LogUtils.v("AppConfig init end", new Object[0]);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/AppConfig$Companion;", "", "()V", "UTF8", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getApiHost() {
        if (isDebugEnabled()) {
            return "api-dev.coolapk.com";
        }
        if (this.apiIndex.get() >= this.apiHostList.size()) {
            ArrayList<String> arrayList = this.apiHostList;
            String str = arrayList.get(arrayList.size() - 1);
            Intrinsics.checkNotNullExpressionValue(str, "apiHostList[apiHostList.size - 1]");
            return str;
        }
        String str2 = this.apiHostList.get(this.apiIndex.get() % this.apiHostList.size());
        Intrinsics.checkNotNullExpressionValue(str2, "apiHostList[apiIndex.get() % apiHostList.size]");
        return str2;
    }

    @Override // com.coolapk.market.local.DataConfig
    public void requestChangeApiHost() {
        this.apiIndex.incrementAndGet();
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getApiEndpoint() {
        return "https://" + getApiHost() + "/v6/";
    }

    @Override // com.coolapk.market.local.DataConfig
    public Map<String, String> getSpecialHosts() {
        return this.specialHosts;
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getCacheDir() {
        File defaultCacheDir = SystemUtils.getDefaultCacheDir(this.appContext);
        Intrinsics.checkNotNullExpressionValue(defaultCacheDir, "SystemUtils.getDefaultCacheDir(appContext)");
        String absolutePath = defaultCacheDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "SystemUtils.getDefaultCa…(appContext).absolutePath");
        return absolutePath;
    }

    @Override // com.coolapk.market.local.DataConfig
    public String getUserAgent() {
        return this.userAgent;
    }

    @Override // com.coolapk.market.local.DataConfig
    public List<String> getCoolMarketHeaders() {
        String[] createHeaders = createHeaders();
        List<String> asList = Arrays.asList((String[]) Arrays.copyOf(createHeaders, createHeaders.length));
        Intrinsics.checkNotNullExpressionValue(asList, "Arrays.asList(*createHeaders())");
        return asList;
    }

    @Override // com.coolapk.market.local.DataConfig
    public boolean isDebugEnabled() {
        if (AppHolder.getAppSetting() == null) {
        }
        return false;
    }

    @Override // com.coolapk.market.local.DataConfig
    public Context getApplicationContext() {
        return this.appContext;
    }

    @Override // com.coolapk.market.local.DataConfig
    public Bundle getMetaData() {
        Bundle metaData = this.appMetadata.getMetaData();
        Intrinsics.checkNotNullExpressionValue(metaData, "appMetadata.metaData");
        return metaData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    @Override // com.coolapk.market.local.DataConfig
    public void onNetworkResponse(Response response) throws IOException {
        String str;
        JSONException e;
        String str2;
        Throwable th;
        Intrinsics.checkNotNullParameter(response, "response");
        Request request = response.request();
        String httpUrl = request.url().toString();
        String method = request.method();
        int code = response.code();
        String nowString = TimeUtils.getNowString();
        String str3 = null;
        long j = 0;
        if (code >= 400) {
            ResponseBody body = response.body();
            Headers headers = response.headers();
            Intrinsics.checkNotNull(body);
            long contentLength = body.contentLength();
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            if (StringsKt.equals("gzip", headers.get("Content-Encoding"), true)) {
                GzipSource gzipSource = null;
                try {
                    GzipSource gzipSource2 = new GzipSource(buffer.clone());
                    try {
                        buffer = new Buffer();
                        buffer.writeAll(gzipSource2);
                        gzipSource2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        gzipSource = gzipSource2;
                        if (gzipSource != null) {
                            gzipSource.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (gzipSource != null) {
                    }
                    throw th;
                }
            }
            Charset charset = UTF8;
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            if (contentLength != 0) {
                Buffer clone = buffer.clone();
                Intrinsics.checkNotNull(charset);
                str2 = clone.readString(charset);
            } else {
                str2 = str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str3 = body.string();
            }
            j = contentLength;
            str3 = str2;
            str = str3;
        } else {
            str = str3;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DATE", nowString);
            jSONObject.put("URL", httpUrl);
            jSONObject.put("METHOD", method);
            jSONObject.put("HTTP_CODE", code);
            try {
                jSONObject.put("USER_AGENT", this.userAgent);
                if (code >= 400) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("BODY", str3);
                    jSONObject2.put("responseBody.contentLength", j);
                    if (str != null) {
                        jSONObject2.put("responseBody.string", str);
                    }
                    jSONObject.put("ERROR_BODY", jSONObject2);
                }
                com.blankj.utilcode.util.LogUtils.file("HTTP_LOG", jSONObject.toString());
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    private final String[] createHeaders() {
        String str;
        Locale locale = Locale.getDefault();
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(locale, "locale");
        sb.append(locale.getLanguage());
        sb.append("-");
        sb.append(locale.getCountry());
        String sb2 = sb.toString();
        String str2 = this.androidId + "; ; ; " + this.macAddress + "; " + Build.MANUFACTURER + "; " + Build.BRAND + "; " + Build.MODEL + ";" + OaidManager.INSTANCE.getOaid();
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(de…eArray(), Base64.DEFAULT)");
        String sb3 = new StringBuilder(encodeToString).reverse().toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(device).reverse().toString()");
        String replace = new Regex("\\r\\n|\\r|\\n|=").replace(sb3, "");
        Application application = this.appContext;
        String as = AuthUtils.getAS(null);
        if (AppHolder.getAppTheme().isNightTheme()) {
            str = "1";
        } else {
            str = AppHolder.getAppTheme().isAmoledTheme() ? "2" : "0";
        }
        Intrinsics.checkNotNullExpressionValue(as, "appToken");
        String channel = this.appMetadata.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "appMetadata.channel");
        return new String[]{"User-Agent", this.userAgent, "X-Requested-With", "XMLHttpRequest", "X-Sdk-Int", valueOf, "X-Sdk-Locale", sb2, "X-App-Id", "com.coolapk.market", "X-App-Token", as, "X-App-Version", this.appVersionName, "X-App-Code", String.valueOf(this.appVersionCode), "X-Api-Version", "11", "X-App-Device", replace, "X-Dark-Mode", str, "X-App-Channel", channel, "X-App-Mode", this.appMetadata.getAppMode().toString()};
    }

    private final String createUserAgent(String str, int i, String str2) {
        String escapeHtml = Html.escapeHtml(SystemUtils.getUserAgent() + " +CoolMarket/" + str + "-" + i + "-" + str2);
        Intrinsics.checkNotNullExpressionValue(escapeHtml, "Html.escapeHtml(SystemUt…sionCode + \"-\" + appMode)");
        return escapeHtml;
    }
}
