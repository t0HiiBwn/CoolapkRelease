package com.coolapk.market.view.settings.settingsynch;

import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.PostButtonEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.RxUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\fJ\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\fH\u0002J\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0007J\u001e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/settings/settingsynch/SettingSynchronized;", "", "()V", "KEY", "", "KEY_POST_BTN", "TYPE_BOOLEAN", "", "TYPE_INT", "TYPE_LONG", "TYPE_STRING", "onLoginEvent", "", "session", "Lcom/coolapk/market/local/LoginSession;", "parseLoadedJsonString", "jsonObject", "Lcom/google/gson/JsonObject;", "putKeyValue", "key", "value", "helper", "Lcom/coolapk/market/util/PreferencesUtils$EditorHelper;", "reSetAllSettings", "reloadSettingConfig", "reloadSettingConfigObservable", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "upLoadPostButton", "uploadAllSettings", "uploadSetting", "json", "type", "valueStringParam", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SettingSynchronized.kt */
public final class SettingSynchronized {
    public static final SettingSynchronized INSTANCE;
    private static final String KEY = "system_config";
    private static final String KEY_POST_BTN = "publish_button_picture";
    public static final int TYPE_BOOLEAN = 0;
    public static final int TYPE_INT = 2;
    public static final int TYPE_LONG = 3;
    public static final int TYPE_STRING = 1;

    static {
        SettingSynchronized settingSynchronized = new SettingSynchronized();
        INSTANCE = settingSynchronized;
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, settingSynchronized);
    }

    private SettingSynchronized() {
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (loginSession.isLogin()) {
            reloadSettingConfig();
        }
    }

    public final void reloadSettingConfig() {
        DataManager.getInstance().loadConfig("publish_button_picture").compose(RxUtils.applyIOSchedulers()).doOnNext(SettingSynchronized$reloadSettingConfig$1.INSTANCE).subscribe((Subscriber<? super R>) new EmptySubscriber());
        reloadSettingConfigObservable().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber());
    }

    private final Observable<Result<String>> reloadSettingConfigObservable() {
        Observable<R> map = DataManager.getInstance().loadConfig("system_config").map(SettingSynchronized$reloadSettingConfigObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…      }\n                }");
        return map;
    }

    /* access modifiers changed from: private */
    public final void parseLoadedJsonString(JsonObject jsonObject) {
        JsonObject asJsonObject;
        if (jsonObject.has("data")) {
            JsonElement jsonElement = jsonObject.get("data");
            Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonObject.get(\"data\")");
            if (jsonElement.isJsonObject()) {
                JsonElement jsonElement2 = jsonObject.get("data");
                String str = null;
                JsonElement jsonElement3 = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) ? null : asJsonObject.get("system_config");
                if (jsonElement3 != null) {
                    str = jsonElement3.getAsString();
                }
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    PreferencesUtils.EditorHelper preferencesEditor = instance.getPreferencesEditor();
                    Iterator<String> keys = jSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "jsonObj.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        SettingSynchronized settingSynchronized = INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(next, "it");
                        String obj = jSONObject.get(next).toString();
                        Intrinsics.checkNotNullExpressionValue(preferencesEditor, "helper");
                        settingSynchronized.putKeyValue(next, obj, preferencesEditor);
                    }
                    preferencesEditor.apply();
                }
            }
        }
    }

    public final void upLoadPostButton(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isLogin()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str);
            DataManager.getInstance().updateConfig("publish_button_picture", jSONObject.toString()).flatMap(SettingSynchronized$upLoadPostButton$1.INSTANCE).compose(RxUtils.apiCommonToData()).subscribe(SettingSynchronized$upLoadPostButton$2.INSTANCE, SettingSynchronized$upLoadPostButton$3.INSTANCE);
        }
    }

    public final void uploadSetting(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        uploadSetting(str, "", i);
    }

    public final void uploadSetting(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        DataManager.getInstance().updateConfig("system_config", str).compose(RxUtils.apiCommonToData()).subscribe(SettingSynchronized$uploadSetting$1.INSTANCE, SettingSynchronized$uploadSetting$2.INSTANCE);
    }

    public final void uploadSetting(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "valueStringParam");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isLogin()) {
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            if (str2.length() > 0) {
                jSONObject.put(str, str2);
                DataManager.getInstance().updateConfig("system_config", jSONObject.toString()).compose(RxUtils.apiCommonToData()).subscribe(SettingSynchronized$uploadSetting$3.INSTANCE, SettingSynchronized$uploadSetting$4.INSTANCE);
                return;
            }
            if (i == 0) {
                Boolean bool = AppSetting.getDefaultMap().get(str);
                DataManager instance2 = DataManager.getInstance();
                if (bool != null) {
                    z = bool.booleanValue();
                }
                str2 = instance2.getPreferencesBoolean(str, z) ? "1" : "0";
            } else if (i == 1) {
                str2 = DataManager.getInstance().getPreferencesString(str, "");
                Intrinsics.checkNotNullExpressionValue(str2, "value");
            } else if (i == 2) {
                str2 = String.valueOf(DataManager.getInstance().getPreferencesInt(str, 0));
            } else if (i == 3) {
                str2 = String.valueOf(DataManager.getInstance().getPreferencesLong(str, 0));
            }
            jSONObject.put(str, str2);
            DataManager.getInstance().updateConfig("system_config", jSONObject.toString()).compose(RxUtils.apiCommonToData()).subscribe(SettingSynchronized$uploadSetting$5.INSTANCE, SettingSynchronized$uploadSetting$6.INSTANCE);
        }
    }

    private final void uploadAllSettings() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("follow_system_day_night_mode");
        arrayList.add("auto_switch_night_mode");
        arrayList.add("disable_show_upgrade_app_card");
        arrayList.add("disable_show_center_upgrade_app_card");
        arrayList.add("auto_hide_bottom_navigation");
        arrayList.add("transparent_status_bar");
        arrayList.add("app_header_search_background_transparent");
        arrayList.add("navigation_bar_color");
        arrayList.add("show_fast_return_view");
        arrayList.add("set_night_mode_to_pure_black");
        arrayList.add("push_service_enabled");
        arrayList.add("show_notice_notification_enabled");
        arrayList.add("show_upgrade_notification_enabled");
        arrayList.add("show_installed_notification_enabled");
        arrayList.add("floating_notification");
        arrayList.add("notification_sound");
        arrayList.add("notification_vibrate");
        arrayList.add("download_only_when_wifi");
        arrayList.add("download_filename_cn_enabled");
        arrayList.add("auto_install_on_downloaded");
        arrayList.add("delete_file_on_installed");
        arrayList.add("auto_disable_image_load");
        arrayList.add("always_load_app_icon");
        arrayList.add("check_beta_version_enabled");
        arrayList.add("use_internal_webview");
        arrayList.add("show_hide_apps");
        arrayList.add("limited_background_enabled");
        arrayList.add("auto_load_video_when_wifi");
        arrayList.add("statistic_toast");
        arrayList.add("developer_api");
        arrayList.add("clear_cache_on_exit");
        arrayList.add("cool_picture_watermark_option");
        arrayList.add("theme_custom_theme_dark");
        ArrayList<String> arrayList2 = new ArrayList();
        arrayList2.add("POST_BUTTON_SETTING_LONG_CLICK_KEY");
        arrayList2.add("POST_BUTTON_SETTING_KEY");
        arrayList2.add("picture_watermark_position");
        arrayList2.add("photo_view_options");
        arrayList2.add("APP_MAIN_MODE_KEY");
        ArrayList<String> arrayList3 = new ArrayList();
        arrayList3.add("theme_custom_color");
        arrayList3.add("theme_custom_color_accent");
        JSONObject jSONObject = new JSONObject();
        for (String str : arrayList) {
            jSONObject.put(str, String.valueOf(AppHolder.getAppSetting().getBooleanPref(str) ? 1 : 0));
        }
        for (String str2 : arrayList2) {
            jSONObject.put(str2, DataManager.getInstance().getPreferencesString(str2, ""));
        }
        for (String str3 : arrayList3) {
            jSONObject.put(str3, DataManager.getInstance().getPreferencesInt(str3, 0));
        }
        DataManager.getInstance().updateConfig("system_config", jSONObject.toString()).compose(RxUtils.apiCommonToData()).subscribe(SettingSynchronized$uploadAllSettings$4.INSTANCE, SettingSynchronized$uploadAllSettings$5.INSTANCE);
    }

    public final void reSetAllSettings() {
        DataManager.getInstance().updateConfig("system_config", "{\"isReset\":\"1\"}").compose(RxUtils.apiCommonToData()).subscribe(SettingSynchronized$reSetAllSettings$1.INSTANCE, SettingSynchronized$reSetAllSettings$2.INSTANCE);
    }

    private final void putKeyValue(String str, String str2, PreferencesUtils.EditorHelper editorHelper) {
        switch (str.hashCode()) {
            case -2127252848:
                if (!str.equals("disable_show_center_upgrade_app_card")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -2109613278:
                if (!str.equals("POST_BUTTON_SETTING_LONG_CLICK_KEY")) {
                    return;
                }
                editorHelper.putString(str, str2);
                return;
            case -2099296341:
                if (!str.equals("APP_MAIN_MODE_KEY")) {
                    return;
                }
                editorHelper.putString(str, str2);
                return;
            case -1887959918:
                if (!str.equals("push_service_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1822585659:
                if (!str.equals("auto_switch_night_mode")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1757265931:
                if (!str.equals("limited_background_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1749622827:
                if (!str.equals("auto_night_mode_time_start")) {
                    return;
                }
                editorHelper.putInt(str, Integer.parseInt(str2));
                return;
            case -1714838396:
                if (!str.equals("floating_notification")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1541640855:
                if (!str.equals("delete_file_on_installed")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1515152347:
                if (!str.equals("developer_api")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1493631042:
                if (!str.equals("theme_custom_color_accent")) {
                    return;
                }
                editorHelper.putInt(str, Integer.parseInt(str2));
                return;
            case -1485694789:
                if (!str.equals("notification_sound")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1453740702:
                if (!str.equals("check_beta_version_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1442637777:
                if (!str.equals("use_internal_webview")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1288298131:
                if (!str.equals("auto_load_video_when_wifi")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1134679708:
                if (!str.equals("app_header_search_background_transparent")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -1035166579:
                if (!str.equals("show_hide_apps")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -990428126:
                if (str.equals("POST_BUTTON_SETTING_KEY")) {
                    editorHelper.putString(str, str2);
                    EventBus.getDefault().post(new PostButtonEvent());
                    return;
                }
                return;
            case -969993349:
                if (!str.equals("auto_hide_bottom_navigation")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -901830380:
                if (!str.equals("show_installed_notification_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -505714741:
                if (!str.equals("theme_custom_color")) {
                    return;
                }
                editorHelper.putInt(str, Integer.parseInt(str2));
                return;
            case -442257810:
                if (!str.equals("download_filename_cn_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case -388415503:
                if (!str.equals("photo_view_options")) {
                    return;
                }
                editorHelper.putString(str, str2);
                return;
            case -200203236:
                if (!str.equals("disable_show_upgrade_app_card")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 523783:
                if (!str.equals("cool_picture_watermark_option")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 98316484:
                if (!str.equals("theme_custom_theme_dark")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 266738532:
                if (!str.equals("set_night_mode_to_pure_black")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 649759259:
                if (!str.equals("notification_vibrate")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 662482821:
                if (str.equals("picture_watermark_position")) {
                    editorHelper.putBoolean("feed_pic_water_mark", !Intrinsics.areEqual(str2, "0"));
                    editorHelper.putString(str, str2);
                    return;
                }
                return;
            case 670017726:
                if (!str.equals("download_only_when_wifi")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 752624933:
                if (!str.equals("watermark_icon_type")) {
                    return;
                }
                editorHelper.putString(str, str2);
                return;
            case 755630931:
                if (!str.equals("transparent_status_bar")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 867080242:
                if (!str.equals("show_upgrade_notification_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 919093747:
                if (!str.equals("show_fast_return_view")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1226389112:
                if (!str.equals("statistic_toast")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1283516751:
                if (!str.equals("clear_cache_on_exit")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1442825394:
                if (!str.equals("show_notice_notification_enabled")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1477516177:
                if (!str.equals("auto_disable_image_load")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1549001998:
                if (!str.equals("auto_night_mode_time_end")) {
                    return;
                }
                editorHelper.putInt(str, Integer.parseInt(str2));
                return;
            case 1557288160:
                if (!str.equals("always_load_app_icon")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1819209676:
                if (!str.equals("navigation_bar_color")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            case 1954592595:
                if (!str.equals("auto_install_on_downloaded")) {
                    return;
                }
                editorHelper.putBoolean(str, Intrinsics.areEqual(str2, "1"));
                return;
            default:
                return;
        }
    }
}
