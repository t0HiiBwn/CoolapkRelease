package com.coolapk.market.widget.video.util;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Video;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.network.HttpClientFactory;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.videoparser.IVideoParser;
import com.coolapk.videoparser.SyncNetwork;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/widget/video/util/JsUrlDecodeUtils;", "", "()V", "lastInstallVideoParserPath", "", "checkReachableUrl", "", "firstUrl", "requestParams", "video", "Lcom/coolapk/market/model/Video;", "decodeRequestParams", "Lcom/coolapk/market/model/VideoUrls;", "installMediaParserIfNeed", "SyncNetworkImpl", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: JsUrlDecodeUtils.kt */
public final class JsUrlDecodeUtils {
    public static final JsUrlDecodeUtils INSTANCE = new JsUrlDecodeUtils();
    private static String lastInstallVideoParserPath = "";

    private JsUrlDecodeUtils() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/widget/video/util/JsUrlDecodeUtils$SyncNetworkImpl;", "Lcom/coolapk/videoparser/SyncNetwork;", "()V", "loadNetworkSync", "", "url", "method", "header", "", "post", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: JsUrlDecodeUtils.kt */
    public static final class SyncNetworkImpl implements SyncNetwork {
        @Override // com.coolapk.videoparser.SyncNetwork
        public String loadNetworkSync(String str, String str2, Map<String, String> map, String str3) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "method");
            Intrinsics.checkNotNullParameter(map, "header");
            Intrinsics.checkNotNullParameter(str3, "post");
            boolean z = false;
            String str4 = null;
            if (!StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
                str = "https://" + str;
            }
            if (str3.length() > 0) {
                z = true;
            }
            try {
                Request build = new Request.Builder().url(str).method(str2, z ? RequestBody.Companion.create(str3, (MediaType) null) : null).headers(Headers.Companion.of(map)).build();
                HttpClientFactory instance = HttpClientFactory.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "HttpClientFactory.getInstance()");
                ResponseBody body = instance.getVideoParamsHttpClient().newCall(build).execute().body();
                if (body != null) {
                    str4 = body.string();
                }
                if (str4 != null) {
                    return str4;
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
    }

    private final void installMediaParserIfNeed() throws Throwable {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        File mediaPlayerJsFile = appSetting.getMediaPlayerJsFile();
        if (!mediaPlayerJsFile.exists() || !mediaPlayerJsFile.canRead()) {
            throw new RuntimeException("Decoder Jar Not Found");
        }
        Intrinsics.checkNotNullExpressionValue(mediaPlayerJsFile, "file");
        String absolutePath = mediaPlayerJsFile.getAbsolutePath();
        if (!Intrinsics.areEqual(lastInstallVideoParserPath, absolutePath)) {
            AppSetting appSetting2 = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
            if (!(!Intrinsics.areEqual(appSetting2.getConfigJson().optString("MediaPlayer.jar.md5"), CoolFileUtils.getFileMd5(absolutePath)))) {
                DexInsertUtil dexInsertUtil = DexInsertUtil.INSTANCE;
                Application application = AppHolder.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
                Intrinsics.checkNotNullExpressionValue(absolutePath, "filePath");
                dexInsertUtil.installHotFix(application, absolutePath);
                lastInstallVideoParserPath = absolutePath;
                return;
            }
            throw new RuntimeException("Md5 doesn't match!!");
        }
    }

    public final VideoUrls decodeRequestParams(String str, Video video) throws Throwable {
        Intrinsics.checkNotNullParameter(str, "requestParams");
        installMediaParserIfNeed();
        Object newInstance = Class.forName("com.coolapk.videoparser.DefaultVideoParser").newInstance();
        if (newInstance != null) {
            String parse = ((IVideoParser) newInstance).parse(str, new SyncNetworkImpl());
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            VideoUrls videoUrls = (VideoUrls) instance.getGson().getAdapter(VideoUrls.class).fromJson(parse);
            if (videoUrls == null || videoUrls.getUrlList().isEmpty()) {
                throw new NullPointerException("can't parse to videoUrl: " + videoUrls);
            }
            List<String> urlList = videoUrls.getUrlList();
            Intrinsics.checkNotNullExpressionValue(urlList, "videoUrls.urlList");
            String str2 = (String) CollectionsKt.first((List<? extends Object>) urlList);
            Intrinsics.checkNotNullExpressionValue(str2, "firstUrl");
            checkReachableUrl(str2, str, video);
            return videoUrls;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.coolapk.videoparser.IVideoParser");
    }

    private final void checkReachableUrl(String str, String str2, Video video) {
        HashMap hashMap = new HashMap();
        if (video != null) {
            String playHeaders = video.getPlayHeaders();
            if (!(playHeaders == null || playHeaders.length() == 0)) {
                JSONObject jSONObject = new JSONObject(video.getPlayHeaders());
                Iterator<String> keys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "headerJson.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            }
        }
        Request build = new Request.Builder().url(str).headers(Headers.Companion.of(hashMap)).method("GET", null).build();
        HttpClientFactory instance = HttpClientFactory.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "HttpClientFactory.getInstance()");
        if (instance.getVideoParamsHttpClient().newCall(build).execute().code() != 200) {
            throw new IllegalArgumentException("Unreachable url");
        }
    }
}
