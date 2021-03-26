package com.coolapk.market.view.center;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.AppTheme;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.NightModeHelper;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u0006J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001dJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u0006J\u0016\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020 J\b\u0010&\u001a\u00020 H\u0002J\u0014\u0010'\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "", "()V", "lastIgnoreUpgradeCount", "", "lastLoadedActivityMenuData", "", "getLastLoadedActivityMenuData", "()Ljava/lang/String;", "setLastLoadedActivityMenuData", "(Ljava/lang/String;)V", "saveInServeRunnable", "Ljava/lang/Runnable;", "toShowLabel", "", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "getUserProfile", "()Lcom/coolapk/market/model/UserProfile;", "setUserProfile", "(Lcom/coolapk/market/model/UserProfile;)V", "getActiveUserMenu", "", "Lcom/coolapk/market/view/center/UserMenu;", "getDefaultUserMenu", "getGroupedMenuList", "getUserMenuByType", "type", "loadMenuDataInServe", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "onDotDragAway", "", "onMenuClick", "view", "Landroid/view/View;", "userMenu", "requestRefreshUpgradeData", "requestSaveMenuDataInServe", "setActiveUserMenu", "typeList", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
public final class CenterUserMenuPresenter {
    private static final String ACTIVE_USER_MENU_KEY = "ACTIVE_USER_MENU";
    public static final Companion Companion = new Companion(null);
    public static final String LAST_UPGRADE_COUNT = "last_upgrade_count";
    public static final String SERVE_KEY_MY_SETTING_TAB = "my_setting_tab_config";
    public static final String TYPE_ADMIN = "TYPE_ADMIN";
    public static final String TYPE_ALBUM = "TYPE_ALBUM";
    public static final String TYPE_APP_MANAGER = "TYPE_APP_MANAGER";
    public static final String TYPE_ARTICLE = "TYPE_ARTICLE";
    public static final String TYPE_BACKUP = "TYPE_BACKUP";
    public static final String TYPE_BLOCK = "TYPE_BLOCK";
    public static final String TYPE_BLOCK_CONTENT = "TYPE_BLOCK_CONTENT";
    public static final String TYPE_COLLECTION = "TYPE_COLLECTION";
    public static final String TYPE_DARK_MODE = "TYPE_DARK_MODE";
    public static final String TYPE_DEV = "TYPE_DEV";
    public static final String TYPE_DIGIT = "TYPE_DIGIT";
    public static final String TYPE_DRAFT = "TYPE_DRAFT";
    public static final String TYPE_FOLLOW = "TYPE_FOLLOW";
    public static final String TYPE_GIFT = "TYPE_GIFT";
    public static final String TYPE_GOODS = "TYPE_GOODS";
    public static final String TYPE_GOODS_LIST = "TYPE_GOODS_LIST";
    public static final String TYPE_KKH = "TYPE_KKH";
    public static final String TYPE_LIKE = "TYPE_LIKE";
    public static final String TYPE_MOBILE = "TYPE_MOBILE";
    public static final String TYPE_MORE = "TYPE_MORE";
    public static final String TYPE_PIC = "TYPE_PIC";
    public static final String TYPE_QA = "TYPE_QA";
    public static final String TYPE_RATING = "TYPE_RATING";
    public static final String TYPE_REPLY = "TYPE_REPLY";
    public static final String TYPE_SETTING = "TYPE_SETTING";
    public static final String TYPE_THEMES = "TYPE_THEMES";
    private static final Map<String, UserMenu> baseMenuMap;
    private static final List<String> defaultActiveMenu;
    private static final List<List<String>> defaultGroupedMenu;
    private static final CenterUserMenuPresenter instance = new CenterUserMenuPresenter();
    private int lastIgnoreUpgradeCount;
    private String lastLoadedActivityMenuData = "";
    private Runnable saveInServeRunnable;
    private boolean toShowLabel;
    private UserProfile userProfile;

    private CenterUserMenuPresenter() {
        boolean z = false;
        this.lastIgnoreUpgradeCount = DataManager.getInstance().getPreferencesInt("last_upgrade_count", 0);
        this.toShowLabel = DataManager.getInstance().getMobileAppUpgradeListFast(false).size() > this.lastIgnoreUpgradeCount ? true : z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0%X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/coolapk/market/view/center/CenterUserMenuPresenter$Companion;", "", "()V", "ACTIVE_USER_MENU_KEY", "", "LAST_UPGRADE_COUNT", "SERVE_KEY_MY_SETTING_TAB", "TYPE_ADMIN", "TYPE_ALBUM", "TYPE_APP_MANAGER", "TYPE_ARTICLE", "TYPE_BACKUP", "TYPE_BLOCK", "TYPE_BLOCK_CONTENT", "TYPE_COLLECTION", "TYPE_DARK_MODE", "TYPE_DEV", "TYPE_DIGIT", "TYPE_DRAFT", "TYPE_FOLLOW", "TYPE_GIFT", "TYPE_GOODS", "TYPE_GOODS_LIST", "TYPE_KKH", "TYPE_LIKE", "TYPE_MOBILE", "TYPE_MORE", "TYPE_PIC", "TYPE_QA", "TYPE_RATING", "TYPE_REPLY", "TYPE_SETTING", "TYPE_THEMES", "baseMenuMap", "", "Lcom/coolapk/market/view/center/UserMenu;", "defaultActiveMenu", "", "defaultGroupedMenu", "", "instance", "Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "getInstance", "()Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterUserMenuPresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CenterUserMenuPresenter getInstance() {
            return CenterUserMenuPresenter.instance;
        }
    }

    static {
        int i = (int) 4278238420L;
        int i2 = (int) 4280391411L;
        int i3 = (int) 4294198070L;
        int i4 = (int) 4289098239L;
        int i5 = (int) 4294077914L;
        int i6 = (int) 4294940672L;
        List mutableListOf = CollectionsKt.mutableListOf(new UserMenu("TYPE_FOLLOW", 2131887102, 2131231658, i, false, false, null, null, false, 496, null), new UserMenu("TYPE_COLLECTION", 2131887238, 2131231664, i2, false, false, null, null, false, 496, null), new UserMenu("TYPE_ARTICLE", 2131887071, 2131231665, i3, false, false, null, null, false, 496, null), new UserMenu("TYPE_ALBUM", 2131887070, 2131231681, i2, false, false, null, null, false, 496, null), new UserMenu("TYPE_APP_MANAGER", 2131887227, 2131231680, i4, false, false, null, null, false, 496, null), new UserMenu("TYPE_THEMES", 2131887303, 2131231686, i5, false, false, null, null, false, 496, null), new UserMenu("TYPE_DARK_MODE", 2131886998, 2131689486, i4, false, false, null, null, false, 496, null), new UserMenu("TYPE_MORE", 2131886875, 2131231435, i, false, false, null, null, false, 240, null), new UserMenu("TYPE_DIGIT", 2131887073, 2131231476, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_GOODS", 2131887078, 2131231331, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_QA", 2131887081, 2131689472, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_PIC", 2131887082, 2131231387, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_KKH", 2131887104, 2131231656, i3, false, false, null, null, false, 496, null), new UserMenu("TYPE_ADMIN", 2131886997, 2131231677, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_DEV", 2131887083, 2131231378, (int) 4283215696L, false, false, null, null, false, 496, null), new UserMenu("TYPE_REPLY", 2131887103, 2131231660, i3, false, false, null, null, false, 496, null), new UserMenu("TYPE_BLOCK", 2131887068, 2131231346, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_BLOCK_CONTENT", 2131887069, 2131231286, (int) 4278241063L, false, false, null, null, false, 496, null), new UserMenu("TYPE_BACKUP", 2131887066, 2131231201, i2, false, false, null, null, false, 496, null), new UserMenu("TYPE_SETTING", 2131887301, 2131231553, (int) 4285887861L, false, false, null, null, false, 496, null), new UserMenu("TYPE_LIKE", 2131887098, 2131689494, i5, false, false, null, null, false, 496, null), new UserMenu("TYPE_RATING", 2131887122, 2131689488, i5, false, false, null, null, false, 496, null), new UserMenu("TYPE_MOBILE", 2131886877, 2131231172, i6, false, false, null, null, false, 496, null), new UserMenu("TYPE_GIFT", 2131886878, 2131231168, i3, false, false, null, null, false, 496, null), new UserMenu("TYPE_DRAFT", 2131887084, 2131231655, i4, false, false, null, null, false, 496, null), new UserMenu("TYPE_GOODS_LIST", 2131887095, 2131231333, i4, false, false, null, null, false, 496, null));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(mutableListOf, 10)), 16));
        for (Object obj : mutableListOf) {
            linkedHashMap.put(((UserMenu) obj).getType(), obj);
        }
        baseMenuMap = (Map) AppMetadataKt.runOnAppMode$default(linkedHashMap, null, CenterUserMenuPresenter$Companion$baseMenuMap$2.INSTANCE, null, CenterUserMenuPresenter$Companion$baseMenuMap$3.INSTANCE, 5, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add("TYPE_FOLLOW");
        arrayList.add("TYPE_COLLECTION");
        arrayList.add("TYPE_ARTICLE");
        arrayList.add("TYPE_ALBUM");
        arrayList.add("TYPE_APP_MANAGER");
        arrayList.add("TYPE_THEMES");
        arrayList.add("TYPE_DARK_MODE");
        arrayList.add("TYPE_MORE");
        defaultActiveMenu = (List) AppMetadataKt.runOnAppMode$default(arrayList, null, CenterUserMenuPresenter$Companion$defaultActiveMenu$2.INSTANCE, null, CenterUserMenuPresenter$Companion$defaultActiveMenu$3.INSTANCE, 5, null);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(CollectionsKt.mutableListOf("TYPE_ADMIN", "TYPE_DEV"));
        arrayList2.add(AppMetadataKt.runOnAppMode$default(CollectionsKt.mutableListOf("TYPE_FOLLOW", "TYPE_COLLECTION", "TYPE_ARTICLE", "TYPE_ALBUM", "TYPE_DIGIT", "TYPE_GOODS", "TYPE_QA", "TYPE_PIC", "TYPE_GOODS_LIST", "TYPE_KKH", "TYPE_DRAFT", "TYPE_REPLY"), null, CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$1.INSTANCE, null, CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$2.INSTANCE, 5, null));
        arrayList2.add(AppMetadataKt.runOnAppMode$default(CollectionsKt.mutableListOf("TYPE_APP_MANAGER", "TYPE_BLOCK", "TYPE_BLOCK_CONTENT", "TYPE_BACKUP", "TYPE_LIKE", "TYPE_RATING", "TYPE_MOBILE", "TYPE_GIFT"), null, CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$3.INSTANCE, null, CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$4.INSTANCE, 5, null));
        arrayList2.add(CollectionsKt.mutableListOf("TYPE_THEMES", "TYPE_DARK_MODE", "TYPE_SETTING"));
        defaultGroupedMenu = arrayList2;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final void setUserProfile(UserProfile userProfile2) {
        this.userProfile = userProfile2;
    }

    public final String getLastLoadedActivityMenuData() {
        return this.lastLoadedActivityMenuData;
    }

    public final void setLastLoadedActivityMenuData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastLoadedActivityMenuData = str;
    }

    public final void requestRefreshUpgradeData() {
        int size = DataManager.getInstance().getMobileAppUpgradeListFast(false).size();
        if (!this.toShowLabel) {
            int i = this.lastIgnoreUpgradeCount;
            if (i > size) {
                this.lastIgnoreUpgradeCount = size;
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                instance2.getPreferencesEditor().putInt("last_upgrade_count", size).apply();
            } else if (size > i) {
                this.toShowLabel = true;
                this.lastIgnoreUpgradeCount = 0;
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                instance3.getPreferencesEditor().putInt("last_upgrade_count", 0).apply();
            }
        }
    }

    public final void setActiveUserMenu(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "typeList");
        this.lastLoadedActivityMenuData = CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        instance2.getPreferencesEditor().putString("ACTIVE_USER_MENU", this.lastLoadedActivityMenuData).apply();
        requestSaveMenuDataInServe();
    }

    private final void requestSaveMenuDataInServe() {
        Handler mainThreadHandler = AppHolder.getMainThreadHandler();
        Runnable runnable = this.saveInServeRunnable;
        if (runnable != null) {
            mainThreadHandler.removeCallbacks(runnable);
        }
        CenterUserMenuPresenter$requestSaveMenuDataInServe$2 centerUserMenuPresenter$requestSaveMenuDataInServe$2 = new CenterUserMenuPresenter$requestSaveMenuDataInServe$2(this);
        this.saveInServeRunnable = centerUserMenuPresenter$requestSaveMenuDataInServe$2;
        if (centerUserMenuPresenter$requestSaveMenuDataInServe$2 != null) {
            mainThreadHandler.postDelayed(centerUserMenuPresenter$requestSaveMenuDataInServe$2, 5000);
        }
    }

    public final Observable<Result<String>> loadMenuDataInServe() {
        Observable<R> map = DataManager.getInstance().loadConfig("my_setting_tab_config").map(CenterUserMenuPresenter$loadMenuDataInServe$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…      }\n                }");
        return map;
    }

    public final UserMenu getUserMenuByType(String str) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "type");
        UserMenu userMenu = baseMenuMap.get(str);
        if (userMenu == null) {
            return null;
        }
        String type = userMenu.getType();
        switch (type.hashCode()) {
            case 107581808:
                if (!type.equals("TYPE_DEV")) {
                    return userMenu;
                }
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                LoginSession loginSession = instance2.getLoginSession();
                UserProfile userProfile2 = this.userProfile;
                if (userProfile2 != null) {
                    String uid = userProfile2.getUid();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                    if (Intrinsics.areEqual(uid, loginSession.getUid()) && userProfile2.getIsDeveloper() > 0) {
                        return userMenu;
                    }
                }
                break;
            case 304095722:
                if (!type.equals("TYPE_ADMIN")) {
                    return userMenu;
                }
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                LoginSession loginSession2 = instance3.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
                if (loginSession2.isAdmin()) {
                    return userMenu;
                }
                break;
            case 1581026762:
                if (!type.equals("TYPE_APP_MANAGER")) {
                    return userMenu;
                }
                int size = DataManager.getInstance().getMobileAppUpgradeListFast(false).size();
                boolean z = size > 0 && this.toShowLabel;
                if (z) {
                    str2 = String.valueOf(size);
                } else {
                    str2 = "";
                }
                if (z) {
                    str3 = AppHolder.getApplication().getString(2131886981, new Object[]{Integer.valueOf(size)});
                } else {
                    str3 = "";
                }
                Intrinsics.checkNotNullExpressionValue(str3, "if (showBubble) AppHolde…unt, updateCount) else \"\"");
                return UserMenu.copy$default(userMenu, null, 0, 0, 0, false, z, str2, str3, false, 287, null);
            case 1915715079:
                if (!type.equals("TYPE_DARK_MODE") || AppHolder.getAppTheme().isDayTheme()) {
                    return userMenu;
                }
                return UserMenu.copy$default(userMenu, null, 2131886691, 2131689493, (int) 4294940672L, false, false, null, null, false, 497, null);
            default:
                return userMenu;
        }
        return null;
    }

    public final void onDotDragAway(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (str.hashCode() == 1581026762 && str.equals("TYPE_APP_MANAGER")) {
            this.toShowLabel = false;
            this.lastIgnoreUpgradeCount = DataManager.getInstance().getMobileAppUpgradeListFast(false).size();
            DataManager instance2 = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
            instance2.getPreferencesEditor().putInt("last_upgrade_count", this.lastIgnoreUpgradeCount).apply();
            EventBus.getDefault().post(this);
        }
    }

    public final List<List<String>> getGroupedMenuList() {
        return defaultGroupedMenu;
    }

    public final List<UserMenu> getActiveUserMenu() {
        String str = this.lastLoadedActivityMenuData;
        boolean z = true;
        if (str.length() == 0) {
            str = DataManager.getInstance().getPreferencesString("ACTIVE_USER_MENU", "");
            Intrinsics.checkNotNullExpressionValue(str, "DataManager.getInstance(…ACTIVE_USER_MENU_KEY, \"\")");
        }
        String str2 = str;
        if (str2.length() != 0) {
            z = false;
        }
        if (z) {
            return getDefaultUserMenu();
        }
        if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "TYPE_MORE", false, 2, (Object) null)) {
            str = str + ",TYPE_MORE";
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : (Iterable) AppMetadataKt.runOnAppMode$default(StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null), null, CenterUserMenuPresenter$getActiveUserMenu$1.INSTANCE, null, CenterUserMenuPresenter$getActiveUserMenu$2.INSTANCE, 5, null)) {
            UserMenu userMenuByType = getUserMenuByType(str3);
            if (userMenuByType != null) {
                arrayList.add(userMenuByType);
            }
        }
        return arrayList;
    }

    public final List<UserMenu> getDefaultUserMenu() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = defaultActiveMenu.iterator();
        while (it2.hasNext()) {
            UserMenu userMenuByType = getUserMenuByType(it2.next());
            if (userMenuByType != null) {
                arrayList.add(userMenuByType);
            }
        }
        return arrayList;
    }

    public final void onMenuClick(View view, UserMenu userMenu) {
        Activity currentActivity;
        Activity currentActivity2;
        Activity currentActivity3;
        Activity currentActivity4;
        Activity currentActivity5;
        Activity currentActivity6;
        Activity currentActivity7;
        Activity currentActivity8;
        Activity currentActivity9;
        Activity currentActivity10;
        Activity currentActivity11;
        Activity currentActivity12;
        Activity currentActivity13;
        Activity currentActivity14;
        Activity currentActivity15;
        Activity currentActivity16;
        Activity currentActivity17;
        Activity currentActivity18;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(userMenu, "userMenu");
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession = instance2.getLoginSession();
        Activity currentActivity19 = AppHolder.getCurrentActivity();
        if (currentActivity19 != null) {
            Intrinsics.checkNotNullExpressionValue(currentActivity19, "AppHolder.getCurrentActivity() ?: return");
            String type = userMenu.getType();
            switch (type.hashCode()) {
                case -1813282621:
                    if (type.equals("TYPE_COLLECTION")) {
                        ActionManager.startCollectionListActivity(currentActivity19);
                        return;
                    }
                    return;
                case -991171029:
                    if (type.equals("TYPE_SETTING")) {
                        ActionManager.startV8SettingsActivity(currentActivity19);
                        return;
                    }
                    return;
                case -959838443:
                    if (type.equals("TYPE_GIFT") && (currentActivity = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                        Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                        if (checkLogin.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserGiftCenterActivity(currentActivity19, loginSession.getUid());
                        }
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                case -959689348:
                    if (type.equals("TYPE_LIKE")) {
                        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                        ActionManager.startUserLikeListActivity(currentActivity19, loginSession.getUid());
                        return;
                    }
                    return;
                case -959653574:
                    if (type.equals("TYPE_MORE")) {
                        ActionManager.startUserCenterMoreFragment(currentActivity19);
                        return;
                    }
                    return;
                case -135076555:
                    if (type.equals("TYPE_QA") && (currentActivity2 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                        Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                        if (checkLogin2.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserQAListActivity(currentActivity19, loginSession.getUid(), currentActivity19.getString(2131887081));
                        }
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 107581808:
                    if (type.equals("TYPE_DEV") && (currentActivity3 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin3 = ActionManager.checkLogin(currentActivity3);
                        Intrinsics.checkNotNullExpressionValue(checkLogin3, "ActionManager.checkLogin(it)");
                        if (checkLogin3.booleanValue()) {
                            String string = currentActivity19.getString(2131886699);
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startDeveloperAppListActivity(currentActivity19, string, loginSession.getUid());
                        }
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 107588707:
                    if (type.equals("TYPE_KKH") && (currentActivity4 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin4 = ActionManager.checkLogin(currentActivity4);
                        Intrinsics.checkNotNullExpressionValue(checkLogin4, "ActionManager.checkLogin(it)");
                        if (checkLogin4.booleanValue()) {
                            ActionManager.startUserDyhFollowList(currentActivity19, true);
                        }
                        Unit unit4 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 107593445:
                    if (type.equals("TYPE_PIC") && (currentActivity5 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin5 = ActionManager.checkLogin(currentActivity5);
                        Intrinsics.checkNotNullExpressionValue(checkLogin5, "ActionManager.checkLogin(it)");
                        if (checkLogin5.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserPictureListFragment(currentActivity19, loginSession.getUid());
                        }
                        Unit unit5 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 250460716:
                    if (type.equals("TYPE_GOODS_LIST") && (currentActivity6 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin6 = ActionManager.checkLogin(currentActivity6);
                        Intrinsics.checkNotNullExpressionValue(checkLogin6, "ActionManager.checkLogin(it)");
                        if (checkLogin6.booleanValue()) {
                            ActionManager.startFunThingsListActivity(currentActivity19);
                        }
                        Unit unit6 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 304095722:
                    if (type.equals("TYPE_ADMIN") && (currentActivity7 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin7 = ActionManager.checkLogin(currentActivity7);
                        Intrinsics.checkNotNullExpressionValue(checkLogin7, "ActionManager.checkLogin(it)");
                        if (checkLogin7.booleanValue()) {
                            ActionManager.startWebViewActivity(currentActivity19, UriUtils.getAdminManageUrl());
                        }
                        Unit unit7 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 304323850:
                    if (type.equals("TYPE_ALBUM") && (currentActivity8 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin8 = ActionManager.checkLogin(currentActivity8);
                        Intrinsics.checkNotNullExpressionValue(checkLogin8, "ActionManager.checkLogin(it)");
                        if (checkLogin8.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserAlbumListActivity(currentActivity19, loginSession.getUid());
                        }
                        Unit unit8 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 305259304:
                    if (type.equals("TYPE_BLOCK") && (currentActivity9 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin9 = ActionManager.checkLogin(currentActivity9);
                        Intrinsics.checkNotNullExpressionValue(checkLogin9, "ActionManager.checkLogin(it)");
                        if (checkLogin9.booleanValue()) {
                            ActionManager.startUserPrivacySettingFragment(currentActivity19);
                        }
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 307009480:
                    if (type.equals("TYPE_DIGIT") && (currentActivity10 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin10 = ActionManager.checkLogin(currentActivity10);
                        Intrinsics.checkNotNullExpressionValue(checkLogin10, "ActionManager.checkLogin(it)");
                        if (checkLogin10.booleanValue()) {
                            ActionManager.startMyDigitTabListActivity(currentActivity19);
                        }
                        Unit unit10 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 307271740:
                    if (type.equals("TYPE_DRAFT")) {
                        ActionManager.startFeedRoughDraftListFragment(currentActivity19);
                        return;
                    }
                    return;
                case 309966321:
                    if (type.equals("TYPE_GOODS") && (currentActivity11 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin11 = ActionManager.checkLogin(currentActivity11);
                        Intrinsics.checkNotNullExpressionValue(checkLogin11, "ActionManager.checkLogin(it)");
                        if (checkLogin11.booleanValue()) {
                            ActionManager.startMyGoodsTabListActivity(currentActivity19);
                        }
                        Unit unit11 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 319828357:
                    if (type.equals("TYPE_REPLY") && (currentActivity12 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin12 = ActionManager.checkLogin(currentActivity12);
                        Intrinsics.checkNotNullExpressionValue(checkLogin12, "ActionManager.checkLogin(it)");
                        if (checkLogin12.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserReplyActivity(currentActivity19, loginSession.getUid());
                        }
                        Unit unit12 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 442671682:
                    if (type.equals("TYPE_BLOCK_CONTENT") && (currentActivity13 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin13 = ActionManager.checkLogin(currentActivity13);
                        Intrinsics.checkNotNullExpressionValue(checkLogin13, "ActionManager.checkLogin(it)");
                        if (checkLogin13.booleanValue()) {
                            ActionManager.startUserBlockContentActivity(currentActivity19);
                        }
                        Unit unit13 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 585477329:
                    if (type.equals("TYPE_ARTICLE") && (currentActivity14 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin14 = ActionManager.checkLogin(currentActivity14);
                        Intrinsics.checkNotNullExpressionValue(checkLogin14, "ActionManager.checkLogin(it)");
                        if (checkLogin14.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserHtmlFeedListFragment(currentActivity19, loginSession.getUid(), currentActivity19.getString(2131887071));
                        }
                        Unit unit14 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 862595687:
                    if (type.equals("TYPE_BACKUP") && (currentActivity15 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin15 = ActionManager.checkLogin(currentActivity15);
                        Intrinsics.checkNotNullExpressionValue(checkLogin15, "ActionManager.checkLogin(it)");
                        if (checkLogin15.booleanValue()) {
                            ActionManager.startBackupListActivity(currentActivity19);
                        }
                        Unit unit15 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 990310486:
                    if (type.equals("TYPE_FOLLOW") && (currentActivity16 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin16 = ActionManager.checkLogin(currentActivity16);
                        Intrinsics.checkNotNullExpressionValue(checkLogin16, "ActionManager.checkLogin(it)");
                        if (checkLogin16.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserFollowAppActivity(currentActivity19, loginSession.getUid());
                        }
                        Unit unit16 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 1190413639:
                    if (type.equals("TYPE_MOBILE") && (currentActivity17 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin17 = ActionManager.checkLogin(currentActivity17);
                        Intrinsics.checkNotNullExpressionValue(checkLogin17, "ActionManager.checkLogin(it)");
                        if (checkLogin17.booleanValue()) {
                            ActionManager.startWebViewTitleActivity(currentActivity19, "https://m.coolapk.com/mp/do?c=userDevice&m=myDevice", currentActivity19.getString(2131886877));
                        }
                        Unit unit17 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 1321166402:
                    if (type.equals("TYPE_RATING") && (currentActivity18 = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin18 = ActionManager.checkLogin(currentActivity18);
                        Intrinsics.checkNotNullExpressionValue(checkLogin18, "ActionManager.checkLogin(it)");
                        if (checkLogin18.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startLoginUserRatingListActivity(currentActivity19, "我的评分", loginSession.getUid());
                        }
                        Unit unit18 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 1384446063:
                    if (type.equals("TYPE_THEMES")) {
                        ActionManager.startThemePickerActivity(currentActivity19);
                        return;
                    }
                    return;
                case 1581026762:
                    if (type.equals("TYPE_APP_MANAGER")) {
                        ActionManager.startAppManagerActivity(currentActivity19);
                        return;
                    }
                    return;
                case 1915715079:
                    if (type.equals("TYPE_DARK_MODE") && (currentActivity19 instanceof AppCompatActivity)) {
                        if (!AppHolder.getAppSetting().getBooleanPref("follow_system_day_night_mode")) {
                            AppHolder.getAppTheme().changeDayNightTheme((AppCompatActivity) currentActivity19);
                            ThemeUtils.startThemeChangeRevealAnimation(currentActivity19, view);
                            AppTheme.ThemeItem themItemById = AppHolder.getAppTheme().getThemItemById(AppHolder.getAppTheme().getCurrentThemeId());
                            StatisticHelper instance3 = StatisticHelper.Companion.getInstance();
                            String label = themItemById.getLabel();
                            if (label == null) {
                                label = "";
                            }
                            instance3.recordThemeEvent(label);
                            return;
                        } else if (NightModeHelper.isThisRomSupportSystemTheme()) {
                            Activity activity = currentActivity19;
                            AlertDialog create = new AlertDialog.Builder(activity).setMessage("当前夜间主题跟随系统设置，手动切换日夜模式需要关闭跟随系统，确定要取消跟随么？").setPositiveButton("取消跟随", new CenterUserMenuPresenter$onMenuClick$4(this, view, userMenu)).setNegativeButton("保持跟随", (DialogInterface.OnClickListener) null).create();
                            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
                            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
                            return;
                        } else {
                            DataManager instance4 = DataManager.getInstance();
                            Intrinsics.checkNotNullExpressionValue(instance4, "DataManager.getInstance()");
                            instance4.getPreferencesEditor().putBoolean("follow_system_day_night_mode", false).apply();
                            onMenuClick(view, userMenu);
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
