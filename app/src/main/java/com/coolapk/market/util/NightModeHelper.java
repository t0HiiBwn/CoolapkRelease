package com.coolapk.market.util;

import android.content.res.Configuration;
import android.os.Build;
import com.blankj.utilcode.util.RomUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.feedv8.SubmitFeedV8Activity;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import java.text.DateFormat;
import java.util.Calendar;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class NightModeHelper {
    private static NightModeHelper instance = new NightModeHelper();
    private static Boolean sSupportSystemTheme = false;
    private String PREF_LAST_CHANGE_TO_DAY = "last_change_to_day";
    private String PREF_LAST_CHANGE_TO_NIGHT = "last_change_to_night";
    private long lastCheckTime = 0;

    public static NightModeHelper getInstance() {
        return instance;
    }

    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        sSupportSystemTheme = Boolean.valueOf(28 < Build.VERSION.SDK_INT || (28 == Build.VERSION.SDK_INT && RomUtils.isMIUI()) || ((RomUtils.isFlyme() && RomUtils.getFlymeVersion() >= 8) || (28 == Build.VERSION.SDK_INT && RomUtils.isSamsung())));
    }

    public static boolean isThisRomSupportSystemTheme() {
        return sSupportSystemTheme.booleanValue();
    }

    private boolean shouldFollowSystemTheme(Configuration configuration) {
        boolean z = !AppHolder.getAppTheme().isDayTheme();
        if (!isThisRomSupportSystemTheme()) {
            return false;
        }
        int i = configuration.uiMode & 48;
        if (i != 16) {
            if (i == 32 && !z) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shouldChangeNightMode(Configuration configuration) {
        if (isThisRomSupportSystemTheme() && AppHolder.getAppSetting().getBooleanPref("follow_system_day_night_mode")) {
            return shouldFollowSystemTheme(configuration);
        }
        boolean z = false;
        if (AppHolder.getActivityStackManager().indexOfInstance(SubmitFeedV8Activity.class) >= 0) {
            return false;
        }
        if (!AppHolder.getAppSetting().getBooleanPref("auto_switch_night_mode")) {
            return CoolMarketHook.getInstance().shouldChangeNightMode(false);
        }
        if (currentTime() - this.lastCheckTime < 1000) {
            this.lastCheckTime = currentTime();
            return CoolMarketHook.getInstance().shouldChangeNightMode(false);
        }
        boolean z2 = !AppHolder.getAppTheme().isDayTheme();
        if (z2 == isNightModeTimeNow()) {
            return CoolMarketHook.getInstance().shouldChangeNightMode(false);
        }
        if (!z2 ? getLastChangeToNightModeTime() < getLastStartTime() : getLastChangeToDayModeTime() < getLastEndTime()) {
            z = true;
        }
        return CoolMarketHook.getInstance().shouldChangeNightMode(z);
    }

    @Subscribe
    public void onAppThemeChange(AppTheme appTheme) {
        if (appTheme.isDarkTheme()) {
            DataManager.getInstance().getPreferencesEditor().putLong(this.PREF_LAST_CHANGE_TO_NIGHT, Calendar.getInstance().getTimeInMillis()).apply();
        } else {
            DataManager.getInstance().getPreferencesEditor().putLong(this.PREF_LAST_CHANGE_TO_DAY, Calendar.getInstance().getTimeInMillis()).apply();
        }
    }

    private long getLastChangeToNightModeTime() {
        return DataManager.getInstance().getPreferencesLong(this.PREF_LAST_CHANGE_TO_NIGHT, 0);
    }

    private long getLastChangeToDayModeTime() {
        return DataManager.getInstance().getPreferencesLong(this.PREF_LAST_CHANGE_TO_DAY, 0);
    }

    private long currentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    private long getLastStartTime() {
        long startTimeOfToday = getStartTimeOfToday();
        Calendar instance2 = Calendar.getInstance();
        if (startTimeOfToday < instance2.getTimeInMillis()) {
            return startTimeOfToday;
        }
        instance2.clear();
        instance2.setTimeInMillis(startTimeOfToday);
        instance2.add(5, -1);
        return instance2.getTimeInMillis();
    }

    private long getLastEndTime() {
        long endTimeOfToday = getEndTimeOfToday();
        Calendar instance2 = Calendar.getInstance();
        if (endTimeOfToday < instance2.getTimeInMillis()) {
            return endTimeOfToday;
        }
        instance2.clear();
        instance2.setTimeInMillis(endTimeOfToday);
        instance2.add(5, -1);
        return instance2.getTimeInMillis();
    }

    private boolean isNightModeTimeNow() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long startTimeOfToday = getStartTimeOfToday();
        long endTimeOfToday = getEndTimeOfToday();
        return startTimeOfToday > endTimeOfToday ? timeInMillis <= endTimeOfToday || timeInMillis >= startTimeOfToday : timeInMillis > startTimeOfToday && timeInMillis < endTimeOfToday;
    }

    private long getStartTimeOfToday() {
        Calendar instance2 = Calendar.getInstance();
        int startTime = getStartTime();
        instance2.set(11, startTime / 60);
        instance2.set(12, startTime % 60);
        return instance2.getTimeInMillis();
    }

    private long getEndTimeOfToday() {
        Calendar instance2 = Calendar.getInstance();
        int endTime = getEndTime();
        instance2.set(11, endTime / 60);
        instance2.set(12, endTime % 60);
        return instance2.getTimeInMillis();
    }

    public int getEndTime() {
        return DataManager.getInstance().getPreferencesInt("auto_night_mode_time_end", 360);
    }

    public int getStartTime() {
        return DataManager.getInstance().getPreferencesInt("auto_night_mode_time_start", 1320);
    }

    public void modifyNightModeTime(int i, int i2) {
        DataManager.getInstance().getPreferencesEditor().putInt("auto_night_mode_time_start", i).putInt("auto_night_mode_time_end", i2).putLong(this.PREF_LAST_CHANGE_TO_DAY, 0).putLong(this.PREF_LAST_CHANGE_TO_NIGHT, 0).apply();
        SettingSynchronized.INSTANCE.uploadSetting("auto_night_mode_time_start", String.valueOf(i), 2);
        SettingSynchronized.INSTANCE.uploadSetting("auto_night_mode_time_end", String.valueOf(i2), 2);
    }

    public String timeMillToString(long j) {
        Calendar instance2 = Calendar.getInstance();
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
        instance2.setTimeInMillis(j);
        return dateTimeInstance.format(instance2.getTime());
    }
}
