package com.coolapk.market.manager;

import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.AppSettingCompat;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.ConfigJsonEvent;
import com.coolapk.market.event.ConfigPageEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.imageloader.GlideImageHelper;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0007J\u0016\u0010\u0018\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010 \u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/manager/MainInitHelper;", "", "()V", "CONFIG_CARD_DEFAULT_JSON", "", "DIGIT_CONFIG_CARD_JSON", "DISCOVERY_CONFIG_CARD_JSON", "KEY_AD_GDT_APP_ID", "KEY_AD_TT_APP_ID", "KEY_DOUYIN_OPEN_VIDEO", "KEY_GOODS_CLIPBOARD_LINK_DIALOG", "KEY_MAIN_LIST_REORDER", "KEY_MEDIA_PLAYER_JAR", "KEY_MEDIA_PLAYER_JAR_MD5", "KEY_RETURN_MAIN_ACTIVITY", "KEY_SPLASH_AD_EXPIRES", "KEY_SPLASH_AD_ON_RESUME", "KEY_SPLASH_AD_TYPE", "KEY_TRIM_ACTIVITYS", "KEY_USER_PRIVACY_VERSION", "configMediaPlayerJs", "", "mediaJsLink", "loadMainInitInfo", "onMainInitDataLoaded", "entities", "", "Lcom/coolapk/market/model/Entity;", "parseConfigCard", "entity", "Lcom/coolapk/market/model/EntityCard;", "parseSearchHintCard", "parseSplashCard", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainInitHelper.kt */
public final class MainInitHelper {
    public static final String CONFIG_CARD_DEFAULT_JSON = "{\"entityType\":\"card\",\"entityTemplate\":\"configCard\",\"title\":\"客户端配置\",\"url\":\"\",\"entities\":[{\"id\":412,\"title\":\"关注\",\"page_name\":\"V9_HOME_TAB_FOLLOW\",\"url\":\"/page?url=V9_HOME_TAB_FOLLOW\",\"entityType\":\"page\",\"entityId\":412,\"page_visibility\":1,\"order\":0,\"page_fixed\":1},{\"id\":420,\"title\":\"头条\",\"page_name\":\"V9_HOME_TAB_HEADLINE\",\"url\":\"/main/headline\",\"entityType\":\"page\",\"entityId\":420,\"page_visibility\":1,\"order\":1,\"page_fixed\":1},{\"id\":415,\"title\":\"热榜\",\"page_name\":\"V9_HOME_TAB_RANKING\",\"url\":\"/page?url=V9_HOME_TAB_RANKING\",\"entityType\":\"page\",\"entityId\":415,\"page_visibility\":1,\"order\":2,\"page_fixed\":0},{\"id\":413,\"title\":\"视频\",\"page_name\":\"V9_HOME_TAB_SHIPIN\",\"url\":\"/page?url=V9_HOME_TAB_SHIPIN\",\"entityType\":\"page\",\"entityId\":413,\"page_visibility\":1,\"order\":3,\"page_fixed\":0}],\"entityId\":6390,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V9_HOME_TAB_HEADLINE\\\"}\"}";
    public static final String DIGIT_CONFIG_CARD_JSON = "{\"entityTemplate\":\"configCard\",\"entityId\":\"14468\",\"entityFixed\":0,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V8_CHANNEL_SJB\\\"}\",\"title\":\"APP配置/数码\",\"url\":\"#PageManageModel::getPageRows?pageType\\u003d10\\u0026t\\u003d1\\u0026title\\u003dAPP配置/数码\",\"entities\":[{\"entityType\":\"page\",\"entityId\":\"790\",\"title\":\"数码\",\"url\":\"/page?url\\u003dV10_DIGITAL_HOME\",\"description\":\"\",\"logo\":\"\",\"id\":\"790\",\"extraData\":\"\",\"dateline\":1575366658,\"lastupdate\":1576476480,\"page_name\":\"V10_DIGITAL_HOME\",\"page_visibility\":1,\"order\":0,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"17\",\"title\":\"手机\",\"url\":\"/page?url\\u003dV8_CHANNEL_SJB\",\"description\":\"\",\"logo\":\"\",\"id\":\"17\",\"extraData\":\"\",\"dateline\":1512460415,\"lastupdate\":1576476567,\"page_name\":\"V8_CHANNEL_SJB\",\"page_visibility\":1,\"order\":10,\"page_fixed\":0,\"entities\":[]}],\"entityTypeName\":\"APP配置/数码\",\"lastupdate\":1576476027,\"entityType\":\"card\",\"pic\":\"\"}";
    public static final String DISCOVERY_CONFIG_CARD_JSON = "{\"entityTemplate\":\"configCard\",\"entityId\":\"20131\",\"entityFixed\":0,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V11_FIND_GOOD_GOODS_HOME\\\"}\",\"title\":\"发现TAB配置\",\"url\":\"#PageManageModel::getPageRows?pageType\\u003d13\\u0026t\\u003d1\\u0026title\\u003d发现TAB配置\",\"entities\":[{\"entityType\":\"page\",\"entityId\":\"1175\",\"title\":\"酷图\",\"url\":\"/page?url\\u003dV11_FIND_COOLPIC\",\"description\":\"\",\"logo\":\"\",\"id\":\"1175\",\"extraData\":\"\",\"dateline\":1603784764,\"lastupdate\":1603784787,\"page_name\":\"V11_FIND_COOLPIC\",\"page_visibility\":1,\"order\":1,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1174\",\"title\":\"好物\",\"url\":\"/page?url\\u003dV11_FIND_GOOD_GOODS_HOME\",\"description\":\"\",\"logo\":\"\",\"id\":\"1174\",\"extraData\":\"\",\"dateline\":1603781719,\"lastupdate\":1603855291,\"page_name\":\"V11_FIND_GOOD_GOODS_HOME\",\"page_visibility\":1,\"order\":2,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1178\",\"title\":\"二手\",\"url\":\"/page?url\\u003dV11_DISCOVERY_SECOND_HAND\",\"description\":\"\",\"logo\":\"\",\"id\":\"1178\",\"extraData\":\"\",\"dateline\":1603853941,\"lastupdate\":1603856229,\"page_name\":\"V11_DISCOVERY_SECOND_HAND\",\"page_visibility\":1,\"order\":3,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1170\",\"title\":\"酷品\",\"url\":\"/page?url\\u003dV11_FIND_GOODS\",\"description\":\"\",\"logo\":\"http://image.coolapk.com/image/2019/0326/14/1553580047_072-0-o_1d6s9cea2d4b6gq1u0v1ssc1jf4i-uid-611629@96x96.png\",\"id\":\"1170\",\"extraData\":\"\",\"dateline\":1603780598,\"lastupdate\":1603784779,\"page_name\":\"V11_FIND_GOODS\",\"page_visibility\":1,\"order\":4,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1176\",\"title\":\"看看号\",\"url\":\"/page?url\\u003dV11_FIND_DYH\",\"description\":\"\",\"logo\":\"\",\"id\":\"1176\",\"extraData\":\"\",\"dateline\":1603784838,\"lastupdate\":1603784838,\"page_name\":\"V11_FIND_DYH\",\"page_visibility\":1,\"order\":5,\"page_fixed\":0,\"entities\":[]}],\"entityTypeName\":\"发现TAB配置\",\"lastupdate\":1603856451,\"entityType\":\"card\",\"pic\":\"\"}";
    public static final MainInitHelper INSTANCE = new MainInitHelper();
    public static final String KEY_AD_GDT_APP_ID = "Ad.GDT_APP_ID";
    public static final String KEY_AD_TT_APP_ID = "Ad.TT_APP_ID";
    public static final String KEY_DOUYIN_OPEN_VIDEO = "Douyin.OpenVideoByDirect2";
    public static final String KEY_GOODS_CLIPBOARD_LINK_DIALOG = "Goods.ClipboardLinkDialog";
    public static final String KEY_MAIN_LIST_REORDER = "MainList.Reorder";
    public static final String KEY_MEDIA_PLAYER_JAR = "MediaPlayer.jar";
    public static final String KEY_MEDIA_PLAYER_JAR_MD5 = "MediaPlayer.jar.md5";
    public static final String KEY_RETURN_MAIN_ACTIVITY = "Share.ReturnMainActivity";
    public static final String KEY_SPLASH_AD_EXPIRES = "SplashAd.Expires";
    public static final String KEY_SPLASH_AD_ON_RESUME = "SplashAd.onResume";
    public static final String KEY_SPLASH_AD_TYPE = "SplashAd.Type";
    public static final String KEY_TRIM_ACTIVITYS = "Trim.Activity";
    public static final String KEY_USER_PRIVACY_VERSION = "UserPrivacy.Version";

    private MainInitHelper() {
    }

    @JvmStatic
    public static final void loadMainInitInfo() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getMainInit().map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new MainInitHelper$loadMainInitInfo$1());
    }

    /* access modifiers changed from: private */
    public final void onMainInitDataLoaded(List<? extends Entity> list) {
        T t;
        T t2;
        T t3;
        T t4;
        parseSearchHintCard((EntityCard) EntityUtils.findFirstItem(list, "textCard"));
        parseSplashCard((EntityCard) EntityUtils.findFirstItem(list, "imageCard"));
        List<? extends Entity> list2 = list;
        Iterator<T> it2 = list2.iterator();
        while (true) {
            t = null;
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (Intrinsics.areEqual(t2.getEntityId(), "6390")) {
                break;
            }
        }
        if (!(t2 instanceof EntityCard)) {
            t2 = null;
        }
        T t5 = t2;
        if (t5 != null) {
            parseConfigCard(t5);
        }
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it3.next();
            if (Intrinsics.areEqual(t3.getEntityId(), "20305")) {
                break;
            }
        }
        if (!(t3 instanceof EntityCard)) {
            t3 = null;
        }
        T t6 = t3;
        if (t6 != null) {
            AppSettingCompat.INSTANCE.setNewDigitConfigCard(t6);
        }
        Iterator<T> it4 = list2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                t4 = null;
                break;
            }
            t4 = it4.next();
            if (Intrinsics.areEqual(t4.getEntityId(), "20131")) {
                break;
            }
        }
        if (t4 instanceof EntityCard) {
            t = t4;
        }
        T t7 = t;
        if (t7 != null) {
            AppSettingCompat.INSTANCE.setNewDiscoveryConfigCard(t7);
        }
    }

    private final void parseSearchHintCard(EntityCard entityCard) {
        AppHolder.getAppSetting().setSearchHintCard(entityCard);
    }

    private final void parseSplashCard(EntityCard entityCard) {
        AppHolder.getAppSetting().setSplashCard(entityCard);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) null;
        if (entityCard != null) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            if (!appSetting.isSplashShowBefore()) {
                objectRef.element = (T) entityCard.getPic();
            }
        }
        File splashImageFile = AppHolder.getAppSetting().getSplashImageFile(AppHolder.getApplication());
        if (splashImageFile != null && !splashImageFile.exists() && GlideImageHelper.shouldLoadOtherImage()) {
            T t = objectRef.element;
            if (!(t == null || t.length() == 0)) {
                Observable.defer(new MainInitHelper$parseSplashCard$1(objectRef, splashImageFile)).subscribeOn(Schedulers.io()).subscribe((Subscriber) new EmptySubscriber());
            }
        }
    }

    @JvmStatic
    public static final void parseConfigCard(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "entity");
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entityCard);
        if (jsonExtraData != null) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            appSetting.setConfigJson(jsonExtraData);
            EventBus.getDefault().post(new ConfigJsonEvent());
            INSTANCE.configMediaPlayerJs(jsonExtraData.optString("MediaPlayer.jar"));
        }
        AppSetting appSetting2 = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
        appSetting2.setConfigCard(entityCard);
        EventBus.getDefault().post(new ConfigPageEvent(true));
    }

    private final void configMediaPlayerJs(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                if (!StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://");
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    DataConfig dataConfig = instance.getDataConfig();
                    Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
                    sb.append(dataConfig.getApiHost());
                    sb.append(str);
                    str = sb.toString();
                }
                AppSetting appSetting = AppHolder.getAppSetting();
                Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                File mediaPlayerJsFile = appSetting.getMediaPlayerJsFile();
                if (!mediaPlayerJsFile.exists()) {
                    Observable.defer(new MainInitHelper$configMediaPlayerJs$1(str, mediaPlayerJsFile)).subscribeOn(Schedulers.io()).subscribe((Subscriber) new EmptySubscriber());
                }
            }
        }
    }
}
