package com.coolapk.market;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.coolapk.market.event.PostButtonEvent;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.PicCategory;
import com.coolapk.market.service.autoinstall.AutoInstallSetting;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityConvertUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.view.ad.AdConst;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppSetting implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final Map<String, Boolean> sDefaultValueMap = Collections.unmodifiableMap(new HashMap<String, Boolean>() {
        /* class com.coolapk.market.AppSetting.AnonymousClass1 */

        {
            put("limited_background_enabled", false);
            put("install_silent_enabled", false);
            put("auto_install_on_downloaded", true);
            put("download_only_when_wifi", true);
            put("delete_file_on_installed", true);
            put("auto_download_on_cloud_install", true);
            put("download_filename_cn_enabled", false);
            put("navigation_bar_color", false);
            put("check_beta_version_enabled", false);
            put("global_auto_install_accessibility_service", false);
            put("clear_cache_on_exit", false);
            put("push_service_enabled", true);
            put("show_upgrade_notification_enabled", true);
            put("show_notice_notification_enabled", true);
            put("show_installed_notification_enabled", true);
            put("notification_sound", true);
            put("notification_vibrate", false);
            put("floating_notification", true);
            put("notification_ignore_like_and_follow", false);
            put("auto_switch_night_mode", false);
            put("transparent_status_bar", true);
            put("auto_hide_bottom_navigation", false);
            put("auto_disable_image_load", false);
            put("always_load_app_icon", true);
            put("webview_disallow_data_download", false);
            put("webview_disable_image_load", false);
            put("webview_disable_external_client_request", false);
            put("use_internal_webview", true);
            put("show_hide_apps", false);
            put("DISABLE_XPOSED", true);
            put("TIP_APP_MANAGER", false);
            put("TIP_FEED_ADD", false);
            put("TIP_BBAR_SHOW", false);
            put("TIP_TAB_COOLPIC_SHOW", false);
            put("TIP_TAB_HEADLINE", false);
            put("show_fast_return_view", false);
            put("use_channel_center_beta", false);
            put("app_header_search_background_transparent", false);
            put("statistic_toast", false);
            put("auto_load_video_when_wifi", true);
            put("developer_api", true);
            put("weekly_no_ad_splash", true);
            put("set_night_mode_to_pure_black", false);
            put("follow_system_day_night_mode", true);
            put("disable_show_upgrade_app_card", false);
            put("disable_show_center_upgrade_app_card", false);
            put("feed_pic_water_mark", true);
            put("cool_picture_watermark_option", false);
            put("settings_upload_init", false);
            put("share_goods_dialog", true);
            put("read_clipboard", true);
            put("user_space_show_recent_like", true);
            put("record_hit_history", true);
            put("record_recent_history", true);
            put("tpns_keep_alive", true);
        }
    });
    private final AppMetadata appMetadata;
    private List<PicCategory> categoryList;
    private EntityCard configCard;
    private JSONObject configJson;
    private String downloadDir;
    private EntityCard imageCard;
    private boolean isAlwaysLoadAppIconEnabled = true;
    private boolean isAutoDisableImageLoad = false;
    private boolean isAutoLoadVideoWhenWifi = true;
    private Boolean isShowCenterUpgradeCard;
    private Boolean isShowUpgradeCard;
    private Boolean isWifiAvailable;
    private long lastCheckCountTime;
    private List<String> searchHint;

    public AppSetting(Context context, AppMetadata appMetadata2) {
        this.appMetadata = appMetadata2;
        DataManager instance = DataManager.getInstance();
        this.downloadDir = instance.getPreferencesString("download_dir", appMetadata2.getDefaultDownloadDir().getAbsolutePath());
        instance.registerPreferenceChangeListener(this);
        this.isAutoDisableImageLoad = getBooleanPref("auto_disable_image_load");
        this.isAlwaysLoadAppIconEnabled = getBooleanPref("always_load_app_icon");
        this.isAutoLoadVideoWhenWifi = getBooleanPref("auto_load_video_when_wifi");
        this.imageCard = getImageCard();
    }

    public static Map<String, Boolean> getDefaultMap() {
        return sDefaultValueMap;
    }

    public void setConfigCard(EntityCard entityCard) {
        this.configCard = entityCard;
        DataManager.getInstance().getPreferencesEditor().putString("CONFIG_CARD_JSON", DataManager.getInstance().getGson().toJson(entityCard)).apply();
    }

    public EntityCard getConfigCard() {
        if (this.configCard == null) {
            if (DataManager.getInstance().getPreferencesLong("CONFIG_CARD_JSON_VERSION", 0) < 1) {
                DataManager.getInstance().getPreferencesEditor().putLong("CONFIG_CARD_JSON_VERSION", 1).remove("CONFIG_CARD_JSON").apply();
            }
            String preferencesString = DataManager.getInstance().getPreferencesString("CONFIG_CARD_JSON", null);
            if (TextUtils.isEmpty(preferencesString)) {
                preferencesString = "{\"entityType\":\"card\",\"entityTemplate\":\"configCard\",\"title\":\"客户端配置\",\"url\":\"\",\"entities\":[{\"id\":412,\"title\":\"关注\",\"page_name\":\"V9_HOME_TAB_FOLLOW\",\"url\":\"/page?url=V9_HOME_TAB_FOLLOW\",\"entityType\":\"page\",\"entityId\":412,\"page_visibility\":1,\"order\":0,\"page_fixed\":1},{\"id\":420,\"title\":\"头条\",\"page_name\":\"V9_HOME_TAB_HEADLINE\",\"url\":\"/main/headline\",\"entityType\":\"page\",\"entityId\":420,\"page_visibility\":1,\"order\":1,\"page_fixed\":1},{\"id\":415,\"title\":\"热榜\",\"page_name\":\"V9_HOME_TAB_RANKING\",\"url\":\"/page?url=V9_HOME_TAB_RANKING\",\"entityType\":\"page\",\"entityId\":415,\"page_visibility\":1,\"order\":2,\"page_fixed\":0},{\"id\":413,\"title\":\"视频\",\"page_name\":\"V9_HOME_TAB_SHIPIN\",\"url\":\"/page?url=V9_HOME_TAB_SHIPIN\",\"entityType\":\"page\",\"entityId\":413,\"page_visibility\":1,\"order\":3,\"page_fixed\":0}],\"entityId\":6390,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V9_HOME_TAB_HEADLINE\\\"}\"}";
            }
            this.configCard = (EntityCard) EntityConvertUtils.handleType(DataManager.getInstance().getGson(), new JsonParser().parse(preferencesString).getAsJsonObject(), "card");
        }
        return this.configCard;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.ConfigPage> */
    public List<ConfigPage> getConfigPages() {
        return getConfigCard().getEntities();
    }

    public String getSelectedHomeTab() {
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(this.configCard);
        if (jsonExtraData != null) {
            return jsonExtraData.optString("selectedHomeTab");
        }
        return null;
    }

    public static String getCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        return externalCacheDir.getPath();
    }

    public void releaseResource() {
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    public boolean isCheckCoolapkBetaVersion() {
        return getBooleanPref("check_beta_version_enabled");
    }

    public boolean isWifiAvailable() {
        Boolean bool = this.isWifiAvailable;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void setWifiAvailable(boolean z) {
        this.isWifiAvailable = Boolean.valueOf(z);
    }

    public Boolean isWifiAvailableNullable() {
        return this.isWifiAvailable;
    }

    public String getDownloadDir() {
        return this.downloadDir;
    }

    public void setDownloadDir(String str) {
        this.downloadDir = str;
        DataManager.getInstance().getPreferencesEditor().putString("download_dir", str).apply();
    }

    public boolean isAutoInstallOnDownloaded() {
        return getBooleanPref("auto_install_on_downloaded");
    }

    public void setDefaultWaterMarkPosition() {
        DataManager.getInstance().getPreferencesEditor().putString("picture_watermark_position", "9").apply();
    }

    public void setDefaultWaterMarkType() {
        DataManager.getInstance().getPreferencesEditor().putString("watermark_icon_type", "0").apply();
    }

    public void setDefaultPhotoViewOption() {
        DataManager.getInstance().getPreferencesEditor().putString("photo_view_options", "AUTO").apply();
    }

    public void setDefaultLanguage() {
        DataManager.getInstance().getPreferencesEditor().putString("language", "system").apply();
    }

    public void setDefaultPostButton(Context context) {
        DataManager.getInstance().getPreferencesEditor().putString("POST_BUTTON_SETTING_KEY", "PLUS").apply();
        File file = new File(BitmapUtil.generateFileOutputPath(context, "post_button_custom"));
        if (file.exists()) {
            file.delete();
        }
        EventBus.getDefault().post(new PostButtonEvent());
    }

    public void setDefaultAotuNightTime() {
        DataManager.getInstance().getPreferencesEditor().putInt("auto_night_mode_time_end", 360).apply();
        DataManager.getInstance().getPreferencesEditor().putInt("auto_night_mode_time_start", 1320).apply();
    }

    public boolean isInstallSilent() {
        return getBooleanPref("install_silent_enabled");
    }

    public boolean getBooleanPref(String str) {
        Map<String, Boolean> map = sDefaultValueMap;
        if (map.containsKey(str)) {
            return DataManager.getInstance().getPreferencesBoolean(str, map.get(str).booleanValue());
        }
        throw new RuntimeException(String.format("key %s don't have a default value", str));
    }

    public boolean isDownloadOnlyWhenWifi() {
        return getBooleanPref("download_only_when_wifi");
    }

    public boolean shouldDeleteAfterInstalling() {
        return getBooleanPref("delete_file_on_installed");
    }

    public boolean shouldAutoDownloadOnCloudInstall() {
        return getBooleanPref("auto_download_on_cloud_install");
    }

    public boolean isDownloadFileNameCNEnable() {
        return getBooleanPref("download_filename_cn_enabled");
    }

    public boolean shouldDisableXposed() {
        return getBooleanPref("DISABLE_XPOSED");
    }

    public boolean isAutoDisableImageLoadEnabled() {
        return this.isAutoDisableImageLoad;
    }

    public boolean isAlwaysLoadAppIconEnabled() {
        return this.isAlwaysLoadAppIconEnabled;
    }

    public boolean isTransparentStatusBar() {
        return getBooleanPref("transparent_status_bar");
    }

    public boolean isShowFastReturnView() {
        return getBooleanPref("show_fast_return_view");
    }

    public boolean isAppHeaderSearchBackgroundTransparent() {
        return getBooleanPref("app_header_search_background_transparent");
    }

    public boolean isAutoLoadVideoWhenWifi() {
        return this.isAutoLoadVideoWhenWifi;
    }

    public boolean isShowUpgradeCard() {
        Boolean bool = this.isShowUpgradeCard;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void setShowUpgradeCard(boolean z) {
        this.isShowUpgradeCard = Boolean.valueOf(z);
    }

    public boolean isSettingsUploadInit() {
        return getBooleanPref("settings_upload_init");
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0179: APUT  (r1v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r0v3 java.lang.String) */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String str2;
        StatisticHelper.getInstance().recordSettingEvent(str);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2109613278:
                if (str.equals("POST_BUTTON_SETTING_LONG_CLICK_KEY")) {
                    c = 0;
                    break;
                }
                break;
            case -1887959918:
                if (str.equals("push_service_enabled")) {
                    c = 1;
                    break;
                }
                break;
            case -1822585659:
                if (str.equals("auto_switch_night_mode")) {
                    c = 2;
                    break;
                }
                break;
            case -1288298131:
                if (str.equals("auto_load_video_when_wifi")) {
                    c = 3;
                    break;
                }
                break;
            case -1141626970:
                if (str.equals("use_channel_center_beta")) {
                    c = 4;
                    break;
                }
                break;
            case -1134679708:
                if (str.equals("app_header_search_background_transparent")) {
                    c = 5;
                    break;
                }
                break;
            case -990428126:
                if (str.equals("POST_BUTTON_SETTING_KEY")) {
                    c = 6;
                    break;
                }
                break;
            case -969993349:
                if (str.equals("auto_hide_bottom_navigation")) {
                    c = 7;
                    break;
                }
                break;
            case -200203236:
                if (str.equals("disable_show_upgrade_app_card")) {
                    c = '\b';
                    break;
                }
                break;
            case -101299028:
                if (str.equals("global_auto_install_accessibility_service")) {
                    c = '\t';
                    break;
                }
                break;
            case 266738532:
                if (str.equals("set_night_mode_to_pure_black")) {
                    c = '\n';
                    break;
                }
                break;
            case 755630931:
                if (str.equals("transparent_status_bar")) {
                    c = 11;
                    break;
                }
                break;
            case 919093747:
                if (str.equals("show_fast_return_view")) {
                    c = '\f';
                    break;
                }
                break;
            case 1109391446:
                if (str.equals("download_dir")) {
                    c = '\r';
                    break;
                }
                break;
            case 1283516751:
                if (str.equals("clear_cache_on_exit")) {
                    c = 14;
                    break;
                }
                break;
            case 1477516177:
                if (str.equals("auto_disable_image_load")) {
                    c = 15;
                    break;
                }
                break;
            case 1557288160:
                if (str.equals("always_load_app_icon")) {
                    c = 16;
                    break;
                }
                break;
            case 1819209676:
                if (str.equals("navigation_bar_color")) {
                    c = 17;
                    break;
                }
                break;
        }
        String str3 = null;
        switch (c) {
            case 0:
                SettingSynchronized.INSTANCE.uploadSetting(str, DataManager.getInstance().getPreferencesString(str, "SEARCH"), 1);
                str2 = null;
                break;
            case 1:
            case 4:
            case 7:
            case 11:
            case 17:
                EventBus.getDefault().post(new SettingEvent(str));
                str2 = null;
                break;
            case 2:
            case 5:
            case '\b':
            case '\n':
            case '\f':
                SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                str2 = null;
                break;
            case 3:
                this.isAutoLoadVideoWhenWifi = getBooleanPref(str);
                str2 = null;
                break;
            case 6:
                String preferencesString = DataManager.getInstance().getPreferencesString(str, "PLUS");
                if (!TextUtils.equals(preferencesString, "CUSTOM")) {
                    SettingSynchronized.INSTANCE.uploadSetting(str, preferencesString, 1);
                }
                str2 = null;
                break;
            case '\t':
                AutoInstallSetting.setInvokeGlobal(getBooleanPref(str));
                str2 = null;
                break;
            case '\r':
                str2 = sharedPreferences.getString(str, this.appMetadata.getDefaultDownloadDir().getAbsolutePath());
                this.downloadDir = str2;
                break;
            case 14:
                SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                str2 = null;
                break;
            case 15:
                this.isAutoDisableImageLoad = getBooleanPref(str);
                str2 = null;
                break;
            case 16:
                this.isAlwaysLoadAppIconEnabled = getBooleanPref(str);
                str2 = null;
                break;
            default:
                return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            str3 = str2.toString();
        }
        objArr[1] = str3;
        LogUtils.v("Key change: %s, %s", objArr);
    }

    public void setSplashCard(EntityCard entityCard) {
        PreferencesUtils.EditorHelper preferencesEditor = DataManager.getInstance().getPreferencesEditor();
        if (entityCard == null) {
            preferencesEditor.putBoolean("IS_SPLASH_IMAGE_SHOW_BEFORE", true);
            preferencesEditor.remove("SPLASH_IMAGE_INFO");
        } else {
            EntityCard imageCard2 = getImageCard();
            this.imageCard = entityCard;
            if (imageCard2 == null || !TextUtils.equals(imageCard2.getPic(), entityCard.getPic())) {
                preferencesEditor.putBoolean("IS_SPLASH_IMAGE_SHOW_BEFORE", false);
            }
            preferencesEditor.putString("SPLASH_IMAGE_INFO", EntityExtendsKt.toJson(entityCard));
        }
        preferencesEditor.apply();
    }

    public EntityCard getImageCard() {
        if (this.imageCard == null) {
            String preferencesString = DataManager.getInstance().getPreferencesString("SPLASH_IMAGE_INFO", null);
            if (!TextUtils.isEmpty(preferencesString)) {
                EntityCard entityCard = (EntityCard) EntityExtendsKt.jsonToEntity(preferencesString);
                this.imageCard = entityCard;
                return entityCard;
            }
        }
        return this.imageCard;
    }

    public void markImageLoaded() {
        if (getImageCard() != null) {
            DataManager.getInstance().getPreferencesEditor().putBoolean("IS_SPLASH_IMAGE_SHOW_BEFORE", true).apply();
        }
    }

    public boolean isSplashShowBefore() {
        return DataManager.getInstance().getPreferencesBoolean("IS_SPLASH_IMAGE_SHOW_BEFORE", false);
    }

    public File getSplashImageFile(Context context) {
        EntityCard imageCard2 = getImageCard();
        if (imageCard2 == null) {
            return null;
        }
        String pic = imageCard2.getPic();
        if (TextUtils.isEmpty(pic)) {
            pic = "EMPTY";
        }
        return new File(BitmapUtil.generateFileOutputPath(context, pic));
    }

    public boolean shouldShowSplash(Context context) {
        File splashImageFile = getSplashImageFile(context);
        return splashImageFile != null && splashImageFile.exists() && !isSplashShowBefore();
    }

    public void setSearchHintCard(EntityCard entityCard) {
        if (entityCard != null) {
            try {
                if (CollectionUtils.isNotEmpty(entityCard.getEntities())) {
                    ArrayList arrayList = new ArrayList();
                    for (Entity entity : entityCard.getEntities()) {
                        arrayList.add(entity.getTitle().trim());
                    }
                    if (this.searchHint == null) {
                        this.searchHint = new ArrayList();
                    }
                    if (!this.searchHint.isEmpty()) {
                        this.searchHint.clear();
                    }
                    this.searchHint.addAll(arrayList);
                    DataManager.getInstance().getPreferencesEditor().putString("SEARCH_HINT_ARRAY", new JSONArray((Collection) this.searchHint).toString()).apply();
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        List<String> list = this.searchHint;
        if (list != null) {
            list.clear();
        }
        DataManager.getInstance().getPreferencesEditor().remove("SEARCH_HINT_ARRAY").apply();
    }

    public List<String> getSearchHint() {
        if (!CollectionUtils.isEmpty(this.searchHint)) {
            return this.searchHint;
        }
        String preferencesString = DataManager.getInstance().getPreferencesString("SEARCH_HINT_ARRAY", null);
        if (!TextUtils.isEmpty(preferencesString)) {
            try {
                JSONArray jSONArray = new JSONArray(preferencesString);
                this.searchHint = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.searchHint.add(jSONArray.getString(i));
                }
                return this.searchHint;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    public void setConfigJson(JSONObject jSONObject) {
        this.configJson = jSONObject;
        DataManager.getInstance().getPreferencesEditor().putString("config_json", jSONObject.toString()).apply();
    }

    public JSONObject getConfigJson() {
        if (this.configJson == null) {
            try {
                this.configJson = new JSONObject(DataManager.getInstance().getPreferencesString("config_json", ""));
            } catch (Exception e) {
                e.printStackTrace();
                this.configJson = new JSONObject();
            }
        }
        return this.configJson;
    }

    public String getQQAppId() {
        String optString = getConfigJson().optString("SplashAd.Type", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        String[] split = optString.split("\\|");
        if (split.length < 2 || !AdConst.isQQPlatform(split[0].trim())) {
            return null;
        }
        return split[1].trim();
    }

    public File getMediaPlayerJsFile() {
        String optString = getConfigJson().optString("MediaPlayer.jar");
        if (optString == null || optString.isEmpty()) {
            return null;
        }
        return new File(AppHolder.getApplication().getFilesDir(), Uri.parse("https://" + DataManager.getInstance().getDataConfig().getApiHost() + optString).getLastPathSegment());
    }

    public void markCheckCount() {
        this.lastCheckCountTime = System.currentTimeMillis();
    }

    public long getLastCheckCountTime() {
        return this.lastCheckCountTime;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a A[RETURN] */
    public boolean shouldLoadSourcePhoto() {
        char c;
        String preferencesString = DataManager.getInstance().getPreferencesString("photo_view_options", "AUTO");
        int hashCode = preferencesString.hashCode();
        if (hashCode != -1986416409) {
            if (hashCode != -1843176421) {
                if (hashCode == 2020783 && preferencesString.equals("AUTO")) {
                    c = 1;
                    if (c != 2) {
                        return false;
                    }
                    if (c != 3) {
                        return isWifiAvailable();
                    }
                    return true;
                }
            } else if (preferencesString.equals("SOURCE")) {
                c = 3;
                if (c != 2) {
                }
            }
        } else if (preferencesString.equals("NORMAL")) {
            c = 2;
            if (c != 2) {
            }
        }
        c = 65535;
        if (c != 2) {
        }
    }

    public void resetPicCategoryList(List<PicCategory> list) {
        if (this.categoryList == null) {
            this.categoryList = new ArrayList();
        }
        this.categoryList.clear();
        this.categoryList.addAll(list);
    }

    public List<PicCategory> getPicCategoryList() {
        if (this.categoryList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.categoryList);
        return arrayList;
    }
}
