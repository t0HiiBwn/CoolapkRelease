package com.coolapk.market.view.node.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.imageloader.Size;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.State;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.DownloadExtendDialog;
import com.coolapk.market.view.app.VersionLowerAlertDialog;
import com.coolapk.market.view.main.SceneRelatedAppsHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010=\u001a\u0004\u0018\u00010\u0010J\n\u0010>\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010?\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010@\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010A\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010B\u001a\u0004\u0018\u00010CH\u0007J>\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2\u0006\u0010F\u001a\u0002HE2!\u0010G\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002HE0HH\u0002¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\u001eH\u0007J\u000e\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QJ\u000e\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020\u0014J\u000e\u0010T\u001a\u00020O2\u0006\u0010K\u001a\u000203R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0006j\b\u0012\u0004\u0012\u00020\u0010`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R-\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0019`\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b \u0010\"R\u0011\u0010#\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000eR\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030)¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0011\u00105\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0011\u00107\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u00109\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0011\u0010;\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'¨\u0006U"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "Landroidx/databinding/BaseObservable;", "appContext", "Landroid/app/Application;", "(Landroid/app/Application;)V", "appCategoryList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/AppCategory;", "Lkotlin/collections/ArrayList;", "getAppCategoryList", "()Ljava/util/ArrayList;", "appScore", "Landroidx/databinding/ObservableFloat;", "getAppScore", "()Landroidx/databinding/ObservableFloat;", "appTagList", "", "getAppTagList", "couponList", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/model/CouponInfo;", "getCouponList", "()Landroidx/databinding/ObservableArrayList;", "imageSizeCache", "Ljava/util/HashMap;", "Lcom/coolapk/market/imageloader/Size;", "Lkotlin/collections/HashMap;", "getImageSizeCache", "()Ljava/util/HashMap;", "isDarkTheme", "", "()Z", "isFavor", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "isFollow", "myScore", "Landroidx/databinding/ObservableInt;", "getMyScore", "()Landroidx/databinding/ObservableInt;", "ratingFeedUrl", "Landroidx/databinding/ObservableField;", "getRatingFeedUrl", "()Landroidx/databinding/ObservableField;", "ratingStar", "getRatingStar", "sceneRelatedHelper", "Lcom/coolapk/market/view/main/SceneRelatedAppsHelper;", "getSceneRelatedHelper", "()Lcom/coolapk/market/view/main/SceneRelatedAppsHelper;", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "getServiceApp", "showAllChangeLog", "getShowAllChangeLog", "showAllCoupon", "getShowAllCoupon", "showAllIntroduce", "getShowAllIntroduce", "voteNum", "getVoteNum", "getAppHotNumString", "getAppSubtitle", "getChangeLogSubtitle", "getDeveloperAvatar", "getDeveloperName", "getDeveloperUserInfo", "Lcom/coolapk/market/model/UserInfo;", "ifAppNotNull", "T", "default", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "app", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isShowDeveloper", "startDownload", "", "view", "Landroid/view/View;", "updateCouponInfo", "couponInfo", "updateServiceApp", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeViewModel.kt */
public final class AppNodeViewModel extends BaseObservable {
    private final ArrayList<AppCategory> appCategoryList = new ArrayList<>();
    private final Application appContext;
    private final ObservableFloat appScore = new ObservableFloat(0.0f);
    private final ArrayList<String> appTagList = new ArrayList<>();
    private final ObservableArrayList<CouponInfo> couponList = new ObservableArrayList<>();
    private final HashMap<String, Size> imageSizeCache = new HashMap<>();
    private final boolean isDarkTheme = AppHolder.getAppTheme().isDarkTheme();
    private final ObservableBoolean isFavor = new ObservableBoolean(false);
    private final ObservableBoolean isFollow = new ObservableBoolean(false);
    private final ObservableInt myScore = new ObservableInt(0);
    private final ObservableField<String> ratingFeedUrl = new ObservableField<>("");
    private final ObservableFloat ratingStar = new ObservableFloat(0.0f);
    private final SceneRelatedAppsHelper sceneRelatedHelper = new SceneRelatedAppsHelper();
    private final ObservableField<ServiceApp> serviceApp = new ObservableField<>();
    private final ObservableBoolean showAllChangeLog = new ObservableBoolean(false);
    private final ObservableBoolean showAllCoupon = new ObservableBoolean(false);
    private final ObservableBoolean showAllIntroduce = new ObservableBoolean(false);
    private final ObservableInt voteNum = new ObservableInt(0);

    public AppNodeViewModel(Application application) {
        Intrinsics.checkNotNullParameter(application, "appContext");
        this.appContext = application;
    }

    public final boolean isDarkTheme() {
        return this.isDarkTheme;
    }

    public final HashMap<String, Size> getImageSizeCache() {
        return this.imageSizeCache;
    }

    public final ObservableField<ServiceApp> getServiceApp() {
        return this.serviceApp;
    }

    public final ObservableBoolean isFollow() {
        return this.isFollow;
    }

    public final ObservableFloat getAppScore() {
        return this.appScore;
    }

    public final ObservableFloat getRatingStar() {
        return this.ratingStar;
    }

    public final ObservableInt getMyScore() {
        return this.myScore;
    }

    public final ObservableInt getVoteNum() {
        return this.voteNum;
    }

    public final ArrayList<AppCategory> getAppCategoryList() {
        return this.appCategoryList;
    }

    public final ArrayList<String> getAppTagList() {
        return this.appTagList;
    }

    public final ObservableBoolean getShowAllChangeLog() {
        return this.showAllChangeLog;
    }

    public final ObservableBoolean getShowAllIntroduce() {
        return this.showAllIntroduce;
    }

    public final ObservableBoolean getShowAllCoupon() {
        return this.showAllCoupon;
    }

    public final ObservableBoolean isFavor() {
        return this.isFavor;
    }

    public final ObservableArrayList<CouponInfo> getCouponList() {
        return this.couponList;
    }

    public final ObservableField<String> getRatingFeedUrl() {
        return this.ratingFeedUrl;
    }

    public final SceneRelatedAppsHelper getSceneRelatedHelper() {
        return this.sceneRelatedHelper;
    }

    public final void updateServiceApp(ServiceApp serviceApp2) {
        String str;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(serviceApp2, "app");
        this.serviceApp.set(serviceApp2);
        ObservableBoolean observableBoolean = this.isFollow;
        UserAction userAction = serviceApp2.getUserAction();
        int i = 0;
        observableBoolean.set(userAction != null && userAction.getFollow() == 1);
        ObservableFloat observableFloat = this.appScore;
        String score = serviceApp2.getScore();
        observableFloat.set(score != null ? Float.parseFloat(score) : 0.0f);
        this.ratingStar.set(serviceApp2.getRatingStar());
        ObservableInt observableInt = this.myScore;
        UserAction userAction2 = serviceApp2.getUserAction();
        observableInt.set(userAction2 != null ? userAction2.getRating() : 0);
        this.voteNum.set(serviceApp2.getVotenum());
        ObservableBoolean observableBoolean2 = this.isFavor;
        UserAction userAction3 = serviceApp2.getUserAction();
        observableBoolean2.set(userAction3 != null && userAction3.getCollect() == 1);
        ObservableField<String> observableField = this.ratingFeedUrl;
        UserAction userAction4 = serviceApp2.getUserAction();
        if (userAction4 == null || (str = userAction4.getRatingFeedUrl()) == null) {
            str = "";
        }
        observableField.set(str);
        this.couponList.clear();
        ObservableArrayList<CouponInfo> observableArrayList = this.couponList;
        if (!serviceApp2.getHasCoupon() || serviceApp2.getCouponInfo() == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = serviceApp2.getCouponInfo();
            Intrinsics.checkNotNull(arrayList);
        }
        observableArrayList.addAll(arrayList);
        this.appCategoryList.clear();
        this.appTagList.clear();
        List<String> tagList = serviceApp2.getTagList();
        List<String> list = tagList;
        if (!(list == null || list.isEmpty())) {
            ArrayList<AppCategory> arrayList2 = this.appCategoryList;
            ArrayList arrayList3 = new ArrayList();
            for (T t : tagList) {
                arrayList3.add(AppCategory.create(serviceApp2.getCategoryId(), serviceApp2.getCategoryName(), serviceApp2.getTagList(), serviceApp2.getApkType()));
            }
            arrayList2.addAll(arrayList3);
            for (T t2 : this.appCategoryList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                if (i == 0) {
                    ArrayList<String> arrayList4 = this.appTagList;
                    String title = t3.getTitle();
                    Intrinsics.checkNotNull(title);
                    arrayList4.add(title);
                }
                String str2 = t3.getTagList().get(i);
                Intrinsics.checkNotNullExpressionValue(str2, "tag");
                if (!StringsKt.isBlank(str2)) {
                    this.appTagList.add(t3.getTagList().get(i));
                }
                i = i2;
            }
        }
        notifyPropertyChanged(32);
        notifyPropertyChanged(68);
        notifyPropertyChanged(70);
        notifyPropertyChanged(72);
        notifyPropertyChanged(249);
        notifyPropertyChanged(47);
    }

    public final String getAppHotNumString() {
        return (String) ifAppNotNull(null, AppNodeViewModel$getAppHotNumString$1.INSTANCE);
    }

    @Bindable
    public final String getAppSubtitle() {
        return (String) ifAppNotNull(null, AppNodeViewModel$getAppSubtitle$1.INSTANCE);
    }

    @Bindable
    public final String getDeveloperAvatar() {
        return (String) ifAppNotNull(null, AppNodeViewModel$getDeveloperAvatar$1.INSTANCE);
    }

    @Bindable
    public final UserInfo getDeveloperUserInfo() {
        return (UserInfo) ifAppNotNull(null, AppNodeViewModel$getDeveloperUserInfo$1.INSTANCE);
    }

    @Bindable
    public final String getDeveloperName() {
        return (String) ifAppNotNull(null, AppNodeViewModel$getDeveloperName$1.INSTANCE);
    }

    @Bindable
    public final boolean isShowDeveloper() {
        return ((Boolean) ifAppNotNull(false, AppNodeViewModel$isShowDeveloper$1.INSTANCE)).booleanValue();
    }

    @Bindable
    public final String getChangeLogSubtitle() {
        return (String) ifAppNotNull(null, new AppNodeViewModel$getChangeLogSubtitle$1(this));
    }

    public final void updateCouponInfo(CouponInfo couponInfo) {
        Intrinsics.checkNotNullParameter(couponInfo, "couponInfo");
        Iterator<E> it2 = this.couponList.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            E next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "it");
            if (Intrinsics.areEqual(next.getCouponId(), couponInfo.getCouponId())) {
                break;
            }
            i++;
        }
        this.couponList.set(i, couponInfo);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x004b: APUT  (r6v0 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r9v1 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00e4: APUT  (r5v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r1v4 java.lang.String) */
    public final void startDownload(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Activity activity = UiUtils.getActivity(view.getContext());
        ServiceApp serviceApp2 = this.serviceApp.get();
        if (serviceApp2 != null) {
            String str = null;
            UpgradeInfo upgradeInfo = null;
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName());
            if (mobileAppExistFast != null) {
                upgradeInfo = mobileAppExistFast.getUpgradeInfo();
            }
            String packageName = serviceApp2.getPackageName();
            String[] strArr = new String[4];
            strArr[0] = serviceApp2.getDownloadUrlMd5(0);
            strArr[1] = serviceApp2.getDownloadUrlMd5(2);
            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
            strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
            State findLatestState = StateUtils.findLatestState(packageName, strArr);
            if (findLatestState == null || ((findLatestState instanceof DownloadState) && ((DownloadState) findLatestState).getState() == 0)) {
                if (!TextUtils.isEmpty(serviceApp2.getExtendFile())) {
                    DownloadExtendDialog newInstance = DownloadExtendDialog.newInstance(serviceApp2, false);
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                    return;
                } else if (serviceApp2.getSupportAndroidVersion() > Build.VERSION.SDK_INT) {
                    VersionLowerAlertDialog newInstance2 = VersionLowerAlertDialog.newInstance(serviceApp2, 0, 0);
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.requireAppCompa…().supportFragmentManager");
                    newInstance2.show(supportFragmentManager2, (String) null);
                    return;
                }
            }
            ClickInfo.Builder uninstallKey = ClickInfo.newBuilder(serviceApp2).packageName(serviceApp2.getPackageName()).targetUrl(serviceApp2.getDownloadUrl(0)).uninstallKey(serviceApp2.getPackageName());
            String[] strArr2 = new String[4];
            strArr2[0] = serviceApp2.getDownloadUrlMd5(0);
            strArr2[1] = serviceApp2.getDownloadUrlMd5(2);
            strArr2[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
            if (upgradeInfo != null) {
                str = upgradeInfo.getDownloadUrlMd5(1);
            }
            strArr2[3] = str;
            StateUtils.handleClick(activity, uninstallKey.downloadKeys(strArr2).build(), view);
        }
    }

    private final <T> T ifAppNotNull(T t, Function1<? super ServiceApp, ? extends T> function1) {
        ServiceApp serviceApp2 = this.serviceApp.get();
        if (serviceApp2 == null) {
            return t;
        }
        Intrinsics.checkNotNullExpressionValue(serviceApp2, "serviceApp.get() ?: return default");
        return (T) function1.invoke(serviceApp2);
    }
}
