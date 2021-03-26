package com.coolapk.market;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.NightModeHelper;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.SystemUtils;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001F\u0018\u0000 _2\u00020\u0001:\u0003_`aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u0016\u0010L\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010M\u001a\u00020NJ\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0007J\u000e\u0010S\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020RJ\u0010\u0010T\u001a\u00020\f2\b\b\u0001\u0010U\u001a\u00020\u001dJ\u0010\u0010V\u001a\u00020\u00042\b\b\u0001\u0010U\u001a\u00020\u001dJ\u000e\u0010W\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001a\u0010X\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\b\u0001\u0010U\u001a\u00020\u001dH\u0002J\u000e\u0010Y\u001a\u00020I2\u0006\u0010Q\u001a\u00020RJ(\u0010Z\u001a\u00020I2\u0006\u0010Q\u001a\u00020K2\b\b\u0001\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010[\u001a\u00020&J \u0010\\\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\b\u0001\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020&R \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0011\u0010#\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0011\u0010(\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b(\u0010'R\u001e\u0010)\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020&@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010*\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0011\u0010+\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0011\u0010,\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0011\u0010-\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b-\u0010'R\u0011\u0010.\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001e\u0010/\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020&@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0011\u00100\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b0\u0010'R\u001e\u00101\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u001e\u00103\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R \u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R \u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R \u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R \u0010=\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0007R \u0010?\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0007R \u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0007R \u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0007R\u0010\u0010E\u001a\u00020FX\u0004¢\u0006\u0004\n\u0002\u0010G¨\u0006b"}, d2 = {"Lcom/coolapk/market/AppTheme;", "", "()V", "<set-?>", "", "colorAccent", "getColorAccent", "()I", "colorControlActivated", "getColorControlActivated", "colorPickerThemeList", "", "Lcom/coolapk/market/AppTheme$ThemeItem;", "getColorPickerThemeList", "()Ljava/util/List;", "colorPrimary", "getColorPrimary", "colorPrimaryDark", "getColorPrimaryDark", "contentBackgroundColor", "getContentBackgroundColor", "contentBackgroundDividerColor", "getContentBackgroundDividerColor", "contentBackgroundDividerColorForAlbum", "getContentBackgroundDividerColorForAlbum", "contentBackgroundTranslucentColor", "getContentBackgroundTranslucentColor", "currencyColorDivider", "getCurrencyColorDivider", "", "currentThemeId", "getCurrentThemeId", "()Ljava/lang/String;", "currentThemeStyleId", "getCurrentThemeStyleId", "darkThemeId", "getDarkThemeId", "isAmoledTheme", "", "()Z", "isCustomTheme", "isCustomThemeDarkMode", "isDarkTheme", "isDayTheme", "isLightColorTheme", "isMatchLevelBarTheme", "isNightTheme", "isPureBlackNightMode", "isWhiteTheme", "lastResourceThemeId", "getLastResourceThemeId", "lastWhiteThemeId", "getLastWhiteThemeId", "mainBackgroundColor", "getMainBackgroundColor", "mainTextColor", "getMainTextColor", "sharedPreferenceListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "textColorPrimary", "getTextColorPrimary", "textColorPrimaryInverse", "getTextColorPrimaryInverse", "textColorSecondary", "getTextColorSecondary", "textColorSecondaryInverse", "getTextColorSecondaryInverse", "textColorTertiary", "getTextColorTertiary", "themeMap", "com/coolapk/market/AppTheme$themeMap$1", "Lcom/coolapk/market/AppTheme$themeMap$1;", "changeDayNightTheme", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "checkAutoTheme", "systemConfig", "Landroid/content/res/Configuration;", "getCustomThemeColor", "", "context", "Landroid/content/Context;", "getTabIndicatorColor", "getThemItemById", "themeName", "getThemeStyleId", "initActivityTheme", "initDayNightMode", "loadResource", "setCustomTheme", "darkMode", "setThemeId", "themeId", "dayTheme", "Companion", "ThemeIds", "ThemeItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppTheme.kt */
public final class AppTheme {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_APP_THEME_NAME = "white";
    private int colorAccent;
    private int colorControlActivated;
    private int colorPrimary;
    private int colorPrimaryDark;
    private int contentBackgroundColor;
    private int contentBackgroundDividerColor;
    private int contentBackgroundDividerColorForAlbum;
    private int contentBackgroundTranslucentColor;
    private int currencyColorDivider;
    private String currentThemeId;
    private boolean isCustomThemeDarkMode;
    private boolean isPureBlackNightMode;
    private String lastResourceThemeId;
    private String lastWhiteThemeId;
    private int mainBackgroundColor;
    private int mainTextColor;
    private final SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceListener;
    private int textColorPrimary;
    private int textColorPrimaryInverse;
    private int textColorSecondary;
    private int textColorSecondaryInverse;
    private int textColorTertiary;
    private final AppTheme$themeMap$1 themeMap = new AppTheme$themeMap$1();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/coolapk/market/AppTheme$ThemeIds;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: AppTheme.kt */
    public @interface ThemeIds {
    }

    @JvmStatic
    public static final boolean isCustomTheme(@ThemeIds String str) {
        return Companion.isCustomTheme(str);
    }

    @JvmStatic
    public static final boolean isDarkTheme(@ThemeIds String str) {
        return Companion.isDarkTheme(str);
    }

    @JvmStatic
    public static final boolean isNightTheme(@ThemeIds String str) {
        return Companion.isNightTheme(str);
    }

    public AppTheme() {
        AppTheme$sharedPreferenceListener$1 appTheme$sharedPreferenceListener$1 = new AppTheme$sharedPreferenceListener$1(this);
        this.sharedPreferenceListener = appTheme$sharedPreferenceListener$1;
        NightModeHelper.getInstance().init();
        String preferencesString = DataManager.getInstance().getPreferencesString("theme_name", "white");
        Intrinsics.checkNotNullExpressionValue(preferencesString, "DataManager.getInstance(…, DEFAULT_APP_THEME_NAME)");
        this.currentThemeId = preferencesString;
        String preferencesString2 = DataManager.getInstance().getPreferencesString("last_theme_name", "white");
        Intrinsics.checkNotNullExpressionValue(preferencesString2, "DataManager.getInstance(…, DEFAULT_APP_THEME_NAME)");
        this.lastWhiteThemeId = preferencesString2;
        this.isCustomThemeDarkMode = DataManager.getInstance().getPreferencesBoolean("theme_custom_theme_dark", true);
        this.isPureBlackNightMode = DataManager.getInstance().getPreferencesBoolean("set_night_mode_to_pure_black", false);
        DataManager.getInstance().registerPreferenceChangeListener(appTheme$sharedPreferenceListener$1);
        if (Intrinsics.areEqual(this.lastWhiteThemeId, "amoled") || Intrinsics.areEqual(this.lastWhiteThemeId, "night")) {
            this.lastWhiteThemeId = "white";
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putString("last_theme_name", "white");
        }
        this.lastResourceThemeId = "";
    }

    public final int getColorPrimary() {
        return this.colorPrimary;
    }

    public final int getColorPrimaryDark() {
        return this.colorPrimaryDark;
    }

    public final int getColorAccent() {
        return this.colorAccent;
    }

    public final int getTextColorPrimary() {
        return this.textColorPrimary;
    }

    public final int getTextColorPrimaryInverse() {
        return this.textColorPrimaryInverse;
    }

    public final int getTextColorSecondary() {
        return this.textColorSecondary;
    }

    public final int getTextColorSecondaryInverse() {
        return this.textColorSecondaryInverse;
    }

    public final int getTextColorTertiary() {
        return this.textColorTertiary;
    }

    public final int getMainBackgroundColor() {
        return this.mainBackgroundColor;
    }

    public final int getContentBackgroundColor() {
        return this.contentBackgroundColor;
    }

    public final int getContentBackgroundDividerColor() {
        return this.contentBackgroundDividerColor;
    }

    public final int getCurrencyColorDivider() {
        return this.currencyColorDivider;
    }

    public final int getContentBackgroundDividerColorForAlbum() {
        return this.contentBackgroundDividerColorForAlbum;
    }

    public final int getColorControlActivated() {
        return this.colorControlActivated;
    }

    public final int getMainTextColor() {
        return this.mainTextColor;
    }

    public final int getContentBackgroundTranslucentColor() {
        return this.contentBackgroundTranslucentColor;
    }

    public final String getCurrentThemeId() {
        return this.currentThemeId;
    }

    public final String getLastWhiteThemeId() {
        return this.lastWhiteThemeId;
    }

    public final String getLastResourceThemeId() {
        return this.lastResourceThemeId;
    }

    public final boolean isCustomThemeDarkMode() {
        return this.isCustomThemeDarkMode;
    }

    public final boolean isPureBlackNightMode() {
        return this.isPureBlackNightMode;
    }

    public final String getDarkThemeId() {
        return this.isPureBlackNightMode ? "amoled" : "night";
    }

    public final boolean isDayTheme() {
        return !Intrinsics.areEqual(this.currentThemeId, "night") && (!Intrinsics.areEqual(this.currentThemeId, "amoled") || !this.isPureBlackNightMode);
    }

    public final int getCurrentThemeStyleId() {
        return getThemeStyleId(this.currentThemeId);
    }

    public final boolean isDarkTheme() {
        return Companion.isDarkTheme(this.currentThemeId);
    }

    public final boolean isNightTheme() {
        return Intrinsics.areEqual(this.currentThemeId, "night");
    }

    public final boolean isAmoledTheme() {
        return Intrinsics.areEqual(this.currentThemeId, "amoled");
    }

    public final boolean isCustomTheme() {
        return Companion.isCustomTheme(this.currentThemeId);
    }

    public final boolean isLightColorTheme() {
        String str = this.currentThemeId;
        int hashCode = str.hashCode();
        return hashCode != -1778017404 ? hashCode == 113101865 && str.equals("white") : str.equals("custom_dark");
    }

    public final boolean isWhiteTheme() {
        return Intrinsics.areEqual(this.currentThemeId, "white");
    }

    public final boolean isMatchLevelBarTheme() {
        String str = this.currentThemeId;
        int hashCode = str.hashCode();
        return hashCode == -1413862040 ? str.equals("amoled") : !(hashCode == 104817688 ? !str.equals("night") : hashCode != 113101865 || !str.equals("white"));
    }

    public final List<ThemeItem> getColorPickerThemeList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getThemItemById("white"));
        if (DateUtils.isTimeLimit()) {
            arrayList.add(getThemItemById("TIME_LIMIT_THEME"));
        }
        arrayList.add(getThemItemById("green"));
        if (SystemUtils.isSmartisanPro()) {
            arrayList.add(getThemItemById("SMARTISAN_PRO"));
        }
        arrayList.add(getThemItemById("red"));
        arrayList.add(getThemItemById("pink"));
        arrayList.add(getThemItemById("indigo"));
        arrayList.add(getThemItemById("teal"));
        arrayList.add(getThemItemById("orange"));
        arrayList.add(getThemItemById("deep_purple"));
        arrayList.add(getThemItemById("blue"));
        arrayList.add(getThemItemById("brown"));
        arrayList.add(getThemItemById("blue_grey"));
        arrayList.add(getThemItemById("black"));
        arrayList.add(getThemItemById("amoled"));
        arrayList.add(getThemItemById("custom"));
        return CollectionsKt.filterNotNull(arrayList);
    }

    public final ThemeItem getThemItemById(@ThemeIds String str) {
        Intrinsics.checkNotNullParameter(str, "themeName");
        ThemeItem themeItem = (ThemeItem) this.themeMap.get((Object) str);
        if (themeItem != null) {
            return themeItem;
        }
        Object obj = this.themeMap.get((Object) "white");
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "themeMap[WHITE]!!");
        return (ThemeItem) obj;
    }

    public final int getThemeStyleId(@ThemeIds String str) {
        Intrinsics.checkNotNullParameter(str, "themeName");
        ThemeItem themeItem = (ThemeItem) this.themeMap.get((Object) str);
        if (themeItem == null) {
            Object obj = this.themeMap.get((Object) "white");
            Intrinsics.checkNotNull(obj);
            themeItem = (ThemeItem) obj;
        }
        Intrinsics.checkNotNullExpressionValue(themeItem, "themeMap[themeName] ?: themeMap[WHITE]!!");
        return themeItem.getMainStylesRes();
    }

    public final void checkAutoTheme(AppCompatActivity appCompatActivity, Configuration configuration) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(configuration, "systemConfig");
        if (NightModeHelper.getInstance().shouldChangeNightMode(configuration)) {
            changeDayNightTheme(appCompatActivity);
            AppHolder.getMainThreadHandler().post(AppTheme$checkAutoTheme$1.INSTANCE);
        }
    }

    public final void changeDayNightTheme(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        if (isDayTheme()) {
            setThemeId(appCompatActivity, this.isPureBlackNightMode ? "amoled" : "night", false);
        } else {
            setThemeId(appCompatActivity, AppHolder.getAppTheme().getThemItemById(this.lastWhiteThemeId).getThemeId(), true);
        }
    }

    public final void setThemeId(AppCompatActivity appCompatActivity, @ThemeIds String str, boolean z) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "themeId");
        LogUtils.d("set Theme for %s , theme id is %s", appCompatActivity.getClass().getSimpleName(), str, this.currentThemeId);
        this.lastResourceThemeId = this.currentThemeId;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        PreferencesUtils.EditorHelper preferencesEditor = instance.getPreferencesEditor();
        if (isDayTheme() && (!Intrinsics.areEqual(this.lastWhiteThemeId, this.currentThemeId))) {
            preferencesEditor.putString("last_theme_name", this.currentThemeId);
        }
        if (true ^ Intrinsics.areEqual(str, this.currentThemeId)) {
            preferencesEditor.putString("theme_name", str);
        }
        preferencesEditor.apply();
        initActivityTheme(appCompatActivity);
    }

    public final void initActivityTheme(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        String str = this.currentThemeId;
        initDayNightMode(appCompatActivity, str);
        appCompatActivity.setTheme(getThemeStyleId(str));
        loadResource(appCompatActivity);
    }

    private final void initDayNightMode(AppCompatActivity appCompatActivity, @ThemeIds String str) {
        AppCompatDelegate delegate = appCompatActivity.getDelegate();
        Intrinsics.checkNotNullExpressionValue(delegate, "activity.delegate");
        delegate.setLocalNightMode(Companion.isDarkTheme(str) ? 2 : 1);
    }

    public final void setCustomTheme(AppCompatActivity appCompatActivity, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putInt("theme_custom_color", i).putInt("theme_custom_color_accent", i2).putBoolean("theme_custom_theme_dark", z).apply();
        setThemeId(appCompatActivity, z ? "custom" : "custom_dark", true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("theme_custom_theme_dark", z ? "1" : "0");
        SettingSynchronized settingSynchronized = SettingSynchronized.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        settingSynchronized.uploadSetting(jSONObject2);
    }

    public final int[] getCustomThemeColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new int[]{DataManager.getInstance().getPreferencesInt("theme_custom_color", ResourceUtils.getColorInt(context, 2131099894)), DataManager.getInstance().getPreferencesInt("theme_custom_color_accent", ResourceUtils.getColorInt(context, 2131099894))};
    }

    public final void loadResource(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Intrinsics.areEqual(this.lastResourceThemeId, this.currentThemeId) || this.colorPrimary == 0 || isCustomTheme() || (i = this.colorAccent) != i) {
            if (isCustomTheme()) {
                int[] customThemeColor = getCustomThemeColor(context);
                this.colorPrimary = customThemeColor[0];
                if (isLightColorTheme()) {
                    this.colorPrimaryDark = ColorUtils.calculateOneColorPlusAnotherColor(1711276032, this.colorPrimary);
                } else {
                    this.colorPrimaryDark = ColorUtils.calculateOneColorPlusAnotherColor(805306368, this.colorPrimary);
                }
                int i2 = customThemeColor[1];
                this.colorAccent = i2;
                this.colorControlActivated = ColorUtils.adjustAlpha(i2, 0.6f);
            } else {
                this.colorPrimary = ResourceUtils.resolveData(context, 2130968780);
                this.colorPrimaryDark = ResourceUtils.resolveData(context, 2130968781);
                this.colorAccent = ResourceUtils.resolveData(context, 2130968767);
                this.colorControlActivated = ResourceUtils.resolveData(context, 2130968770);
            }
            this.mainTextColor = ResourceUtils.resolveData(context, 2130969188);
            this.textColorPrimary = ResourceUtils.resolveData(context, 16842806);
            this.textColorPrimaryInverse = ResourceUtils.resolveData(context, 16842809);
            this.textColorSecondary = ResourceUtils.resolveData(context, 16842808);
            this.textColorSecondaryInverse = ResourceUtils.resolveData(context, 16842810);
            this.textColorTertiary = ResourceUtils.resolveData(context, 16843282);
            this.mainBackgroundColor = ResourceUtils.resolveData(context, 2130969186);
            this.contentBackgroundColor = ResourceUtils.resolveData(context, 2130968800);
            this.contentBackgroundTranslucentColor = ResourceUtils.resolveData(context, 2130968804);
            this.contentBackgroundDividerColor = ResourceUtils.resolveData(context, 2130968802);
            this.currencyColorDivider = ResourceUtils.resolveData(context, 2130968851);
            this.contentBackgroundDividerColorForAlbum = ResourceUtils.resolveData(context, 2130968803);
        }
    }

    public final int getTabIndicatorColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.currentThemeId;
        if (Intrinsics.areEqual(str, "custom_dark") || Intrinsics.areEqual(str, "white")) {
            return this.colorAccent;
        }
        return ResourceUtils.resolveData(context, 2130969532);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B-\b\u0010\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bB5\b\u0010\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB%\b\u0010\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\fB\u000f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0005H\u0016R\u0012\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038G@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017¨\u0006$"}, d2 = {"Lcom/coolapk/market/AppTheme$ThemeItem;", "Landroid/os/Parcelable;", "themeId", "", "mainStylesRes", "", "color", "label", "(Ljava/lang/String;IILjava/lang/String;)V", "isTimeLimit", "", "(Ljava/lang/String;IILjava/lang/String;Z)V", "(Ljava/lang/String;II)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isCurrentTheme", "()Z", "isCustomTheme", "isDarkTheme", "isLightTheme", "<set-?>", "getLabel", "()Ljava/lang/String;", "getMainStylesRes", "()I", "getThemeId$annotations", "()V", "getThemeId", "describeContents", "getColor", "writeToParcel", "", "dest", "flags", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppTheme.kt */
    public static final class ThemeItem implements Parcelable {
        public static final Parcelable.Creator<ThemeItem> CREATOR = new AppTheme$ThemeItem$Companion$CREATOR$1();
        public static final Companion Companion = new Companion(null);
        private int color;
        private boolean isTimeLimit;
        private String label;
        private int mainStylesRes;
        private String themeId;

        @ThemeIds
        public static /* synthetic */ void getThemeId$annotations() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean isTimeLimit() {
            return this.isTimeLimit;
        }

        public final String getLabel() {
            return this.label;
        }

        @ThemeIds
        public final String getThemeId() {
            return this.themeId;
        }

        public final int getMainStylesRes() {
            return this.mainStylesRes;
        }

        public final boolean isCustomTheme() {
            return AppTheme.Companion.isCustomTheme(this.themeId);
        }

        public final boolean isDarkTheme() {
            return AppTheme.Companion.isDarkTheme(this.themeId);
        }

        public final boolean isCurrentTheme() {
            String currentThemeId = AppHolder.getAppTheme().getCurrentThemeId();
            if (isCustomTheme()) {
                return Intrinsics.areEqual(currentThemeId, "custom") || Intrinsics.areEqual(currentThemeId, "custom_dark");
            }
            return Intrinsics.areEqual(currentThemeId, this.themeId);
        }

        public final boolean isLightTheme() {
            return Intrinsics.areEqual(this.themeId, "custom_dark") || Intrinsics.areEqual(this.themeId, "white");
        }

        public ThemeItem(@ThemeIds String str, int i, int i2, String str2) {
            Intrinsics.checkNotNullParameter(str, "themeId");
            Intrinsics.checkNotNullParameter(str2, "label");
            this.themeId = str;
            this.mainStylesRes = i;
            this.color = i2;
            this.label = str2;
        }

        public ThemeItem(@ThemeIds String str, int i, int i2, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "themeId");
            Intrinsics.checkNotNullParameter(str2, "label");
            this.themeId = str;
            this.mainStylesRes = i;
            this.color = i2;
            this.label = str2;
            this.isTimeLimit = z;
        }

        public ThemeItem(@ThemeIds String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "themeId");
            this.themeId = str;
            this.mainStylesRes = i;
            this.color = i2;
            this.label = str;
        }

        public ThemeItem(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
            this.themeId = readString;
            this.mainStylesRes = parcel.readInt();
            this.color = parcel.readInt();
        }

        public final int getColor() {
            if (!isCustomTheme()) {
                return this.color;
            }
            AppTheme appTheme = AppHolder.getAppTheme();
            Application application = AppHolder.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
            return appTheme.getCustomThemeColor(application)[0];
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.themeId);
            parcel.writeInt(this.mainStylesRes);
            parcel.writeInt(this.color);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/AppTheme$ThemeItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/AppTheme$ThemeItem;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: AppTheme.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007J\u0012\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/AppTheme$Companion;", "", "()V", "DEFAULT_APP_THEME_NAME", "", "isCustomTheme", "", "name", "isDarkTheme", "isNightTheme", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppTheme.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isDarkTheme(@ThemeIds String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            int hashCode = str.hashCode();
            return hashCode != -1413862040 ? hashCode == 104817688 && str.equals("night") : str.equals("amoled");
        }

        @JvmStatic
        public final boolean isCustomTheme(@ThemeIds String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            int hashCode = str.hashCode();
            return hashCode != -1778017404 ? hashCode == -1349088399 && str.equals("custom") : str.equals("custom_dark");
        }

        @JvmStatic
        public final boolean isNightTheme(@ThemeIds String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return Intrinsics.areEqual(str, "night") || Intrinsics.areEqual(str, "amoled");
        }
    }
}
