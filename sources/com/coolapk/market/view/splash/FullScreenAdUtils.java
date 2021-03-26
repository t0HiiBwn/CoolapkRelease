package com.coolapk.market.view.splash;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.main.PermissionsAgreeActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ&\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0001J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/splash/FullScreenAdUtils;", "", "()V", "skipApps", "", "", "calculateAdViewFitSize", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "adViewWidth", "adViewHeight", "calculateBottomHeight", "isCoolapkSplash", "", "getSloganMinHeight", "logFile", "", "content", "setFullscreen", "window", "Landroid/view/Window;", "shouldShowAd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FullScreenAdUtils.kt */
public final class FullScreenAdUtils {
    public static final FullScreenAdUtils INSTANCE = new FullScreenAdUtils();
    private static final List<String> skipApps = CollectionsKt.listOf((Object[]) new String[]{"com.wpengapp.lightstart", "me.angeldevil.autoskip", "me.hisn.adskip", "com.dahuo.sunflower.assistant", "com.ypp.adskip", "com.microfield.startUp", "com.lgh.advertising.going", "com.lgh.accessibilitytool", "com.su.magiclaunch", "dc.xyn.fv", "com.skip.ads", "com.ext.star.wars", "com.dahuo.sunflower.xad", "me.app.xad", "com.adguard.android"});

    private FullScreenAdUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0168, code lost:
        if (r7.equals("QQ_SPLASH") != false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0171, code lost:
        if (r7.equals("TT_SPLASH") != false) goto L_0x0173;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0251  */
    @JvmStatic
    public static final boolean shouldShowAd(Context context) {
        boolean z;
        boolean z2;
        LoginSession loginSession;
        int optInt;
        boolean z3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (System.currentTimeMillis() - DataManager.getInstance().getPreferencesLong("TENCENT_AD_ERROR_TIMESTAMP", 0) < TimeUnit.MINUTES.toMillis(10)) {
            INSTANCE.logFile("因为之前广告加载时出现了错误，那么我们在10分钟内不再加载广告");
            return false;
        } else if (PermissionsAgreeActivity.Companion.shouldShowByFirstInstall()) {
            return false;
        } else {
            List<String> list = skipApps;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    try {
                        z3 = context.getPackageManager().getApplicationInfo(it2.next(), 0).enabled;
                        continue;
                    } catch (Exception unused) {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    FullScreenAdUtils fullScreenAdUtils = INSTANCE;
                    fullScreenAdUtils.logFile("用户安装了" + z + "，不展示广告");
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    sb.append("now: " + currentTimeMillis + ' ');
                    AppSetting appSetting = AppHolder.getAppSetting();
                    Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                    String optString = appSetting.getConfigJson().optString("SplashAd.Type", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "AppHolder.getAppSetting(…r.KEY_SPLASH_AD_TYPE, \"\")");
                    FullScreenAdUtils fullScreenAdUtils2 = INSTANCE;
                    fullScreenAdUtils2.logFile("广告类型: " + optString);
                    sb.append("splashAdType: " + optString + ' ');
                    if (optString != null) {
                        if (optString.length() > 0) {
                            try {
                                List split$default = StringsKt.split$default((CharSequence) optString, new String[]{"|"}, false, 0, 6, (Object) null);
                                if (split$default.size() != 3) {
                                    fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                    return false;
                                }
                                String str = (String) split$default.get(0);
                                if (str != null) {
                                    String obj = StringsKt.trim((CharSequence) str).toString();
                                    int hashCode = obj.hashCode();
                                    if (hashCode != -269205242) {
                                        if (hashCode != -75272858) {
                                            if (hashCode == 1238338067 && obj.equals("COOLAPK_SPLASH")) {
                                                z2 = true;
                                                DataManager instance = DataManager.getInstance();
                                                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                                                loginSession = instance.getLoginSession();
                                                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                                                if (!loginSession.isAdmin()) {
                                                    long j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                                                    sb.append("firstInstallTime: " + j + ' ');
                                                    if (!z2 && j <= currentTimeMillis && j + TimeUnit.DAYS.toMillis(3) >= currentTimeMillis) {
                                                        fullScreenAdUtils2.logFile("符合新用户免广告条件，我们不显示广告");
                                                        fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                                        return false;
                                                    }
                                                }
                                                long preferencesLong = DataManager.getInstance().getPreferencesLong("last_weekly_no_ad_splash_time", 0);
                                                sb.append("lastRecordTime: " + preferencesLong + ' ');
                                                if (!z2 || preferencesLong < DateUtils.getWeekAgoTime() || preferencesLong > currentTimeMillis) {
                                                    AppSetting appSetting2 = AppHolder.getAppSetting();
                                                    Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
                                                    optInt = appSetting2.getConfigJson().optInt("SplashAd.Expires", 300);
                                                    sb.append("adExpire: " + optInt + ' ');
                                                    if (optInt > 0) {
                                                        long preferencesLong2 = DataManager.getInstance().getPreferencesLong("SPLASH_AD_LAST_SHOW", 0);
                                                        sb.append("lastShow: " + preferencesLong2 + ' ');
                                                        if ((((long) optInt) * 1000) + preferencesLong2 > currentTimeMillis && preferencesLong2 <= currentTimeMillis) {
                                                            fullScreenAdUtils2.logFile("仍然在广告间隔期，我们不显示广告");
                                                            fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                                            return false;
                                                        }
                                                    }
                                                    fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                                    fullScreenAdUtils2.logFile("广告展示条件符合，可以展示广告");
                                                    return true;
                                                }
                                                fullScreenAdUtils2.logFile("符合七天免广告条件，我们不显示广告");
                                                fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                                return false;
                                            }
                                        }
                                        fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                        return false;
                                    }
                                    z2 = false;
                                    DataManager instance = DataManager.getInstance();
                                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                                    loginSession = instance.getLoginSession();
                                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                                    if (!loginSession.isAdmin()) {
                                    }
                                    long preferencesLong = DataManager.getInstance().getPreferencesLong("last_weekly_no_ad_splash_time", 0);
                                    sb.append("lastRecordTime: " + preferencesLong + ' ');
                                    if (!z2) {
                                    }
                                    AppSetting appSetting2 = AppHolder.getAppSetting();
                                    Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
                                    optInt = appSetting2.getConfigJson().optInt("SplashAd.Expires", 300);
                                    sb.append("adExpire: " + optInt + ' ');
                                    if (optInt > 0) {
                                    }
                                    fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                                    fullScreenAdUtils2.logFile("广告展示条件符合，可以展示广告");
                                    return true;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            } catch (Exception e) {
                                FullScreenAdUtils fullScreenAdUtils3 = INSTANCE;
                                fullScreenAdUtils3.logFile(e);
                                fullScreenAdUtils3.logFile("开屏广告检测参数: " + ((Object) sb));
                                return false;
                            }
                        }
                    }
                    fullScreenAdUtils2.logFile("开屏广告检测参数: " + ((Object) sb));
                    return false;
                } catch (Exception e2) {
                    FullScreenAdUtils fullScreenAdUtils4 = INSTANCE;
                    fullScreenAdUtils4.logFile(e2);
                    fullScreenAdUtils4.logFile("开屏广告检测参数: " + ((Object) sb));
                    return false;
                } catch (Throwable th) {
                    FullScreenAdUtils fullScreenAdUtils5 = INSTANCE;
                    fullScreenAdUtils5.logFile("开屏广告检测参数: " + ((Object) sb));
                    throw th;
                }
            }
            z = false;
            if (!z) {
            }
        }
    }

    public final Pair<Integer, Integer> calculateAdViewFitSize(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        int screenWidth = ScreenUtils.getScreenWidth();
        int screenHeight = ScreenUtils.getScreenHeight();
        int i3 = (int) (((float) screenHeight) * 0.75f);
        if (i3 < NumberExtendsKt.getDp((Number) 400)) {
            i3 = NumberExtendsKt.getDp((Number) 400);
        }
        Integer valueOf = Integer.valueOf((int) ((((float) screenWidth) * ((float) i2)) / ((float) i)));
        if (!(valueOf.intValue() > i3)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i3 = valueOf.intValue();
        }
        int sloganMinHeight = getSloganMinHeight(context);
        int i4 = screenHeight - i3;
        if (i4 >= sloganMinHeight) {
            sloganMinHeight = i4;
        }
        return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(screenHeight - sloganMinHeight));
    }

    public final int calculateBottomHeight(Context context, boolean z, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        int screenWidth = ScreenUtils.getScreenWidth();
        int screenHeight = ScreenUtils.getScreenHeight();
        if (!z) {
            i3 = (int) (((float) screenHeight) * 0.75f);
            if (i3 < NumberExtendsKt.getDp((Number) 400)) {
                i3 = NumberExtendsKt.getDp((Number) 400);
            }
        } else {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf((int) ((((float) screenWidth) * ((float) i2)) / ((float) i)));
        if (!(valueOf.intValue() > i3)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i3 = valueOf.intValue();
        }
        if (z && i3 >= screenHeight) {
            return 0;
        }
        int sloganMinHeight = getSloganMinHeight(context);
        int i4 = screenHeight - i3;
        return i4 < sloganMinHeight ? sloganMinHeight : i4;
    }

    public final int getSloganMinHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourceUtils.getDimen(context, 2131165590);
    }

    public final void logFile(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "content");
        if (obj instanceof Throwable) {
            LogUtils.e((Throwable) obj);
        } else {
            LogUtils.d(obj.toString(), new Object[0]);
        }
        com.blankj.utilcode.util.LogUtils.file("SPLASH_LOG", obj);
    }

    public final void setFullscreen(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
    }
}
