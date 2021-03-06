package com.coolapk.market.manager;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.Goods;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.ActivityResultAdapter;
import com.coolapk.market.util.ActivityResultAdapterKt;
import com.coolapk.market.util.ExpireCache;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriActionUtils;
import com.coolapk.market.view.app.AppCategoryTabActivity;
import com.coolapk.market.view.base.SimpleActivity;
import com.coolapk.market.view.base.SimpleAlphaActivity;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.view.feed.vote.VoteCommentConfig;
import com.coolapk.market.view.feed.vote.VoteOptionDetailActivity;
import com.coolapk.market.view.feed.vote.VoteUserListFragment;
import com.coolapk.market.view.feedv8.FeedHistoryListFragment;
import com.coolapk.market.view.goods.GoodsSearchActivity;
import com.coolapk.market.view.goods.detail.GoodsDetailActivity;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.view.main.PearGoodsFragment;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.view.photo.PhotoViewUrl;
import com.coolapk.market.view.userv9.UserDataFragment;
import com.coolapk.market.view.userv9.UserQRCodeFragment;
import com.coolapk.market.widget.Toast;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

/* compiled from: ActionManagerCompat.kt */
public final class ActionManagerCompat {
    public static final ActionManagerCompat INSTANCE = new ActionManagerCompat();

    private ActionManagerCompat() {
    }

    public static final void startGoodsDetailActivity(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        Intent intent = new Intent(context, GoodsDetailActivity.class);
        intent.putExtra("id", str);
        context.startActivity(intent);
    }

    public static /* synthetic */ void startPhotoViewActivity$default(Activity activity, String[] strArr, String[] strArr2, int i, String str, String[] strArr3, Rect[] rectArr, boolean z, String[] strArr4, int i2, Object obj) {
        startPhotoViewActivity(activity, strArr, strArr2, i, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? null : strArr3, (i2 & 64) != 0 ? null : rectArr, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? null : strArr4);
    }

    public static final void startPhotoViewActivity(Activity activity, String[] strArr, String[] strArr2, int i, String str, String[] strArr3, Rect[] rectArr, boolean z, String[] strArr4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "sources");
        Intrinsics.checkNotNullParameter(str, "feedType");
        ArrayList<PhotoViewUrl> from = PhotoViewUrl.Companion.from(strArr, strArr2, strArr3, rectArr, z ? 1 : 0, strArr4);
        Intent intent = new Intent(activity, PhotoViewActivity.class);
        intent.putExtra("index", i).putExtra("feed_type", str).putExtra("photoViewUrl", from);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static /* synthetic */ void startFeedDetailActivity$default(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, int i2, Object obj) {
        startFeedDetailActivity(context, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6);
    }

    public static final void startFeedDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        if (str2 != null) {
            i = i | 2 | 1;
        }
        context.startActivity(new Intent(context, FeedDetailActivityV8.class).putExtra("extra_feed_id", str).putExtra("extra_reply_id", str2).putExtra("extra_notice_id", str3).putExtra("extra_detail_type", str4).putExtra("extra_from_api", str5).putExtra("extra_history_id", str6).putExtra("extra_flag", i));
    }

    public static final void startAppCategoryActivity(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(new Intent(context, AppCategoryTabActivity.class).putExtra("EXTRA_APK_TYPE", str));
    }

    public static /* synthetic */ void startDataListActivity$default(Context context, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        startDataListActivity(context, str, str2, str3, i);
    }

    public static final void startDataListActivity(Context context, String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        SimpleAlphaActivity.Builder.start$default(SimpleAlphaActivity.Companion.builder(context).fragmentClass(DataListFragment.class).title("").addArgs("URL", str).addArgs("TITLE", str2).addArgs("SUBTITLE", str3).addArgs("SELECTED_TAB", i), null, 1, null);
    }

    public static /* synthetic */ void startJDGoodsStoryActivity$default(Context context, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        startJDGoodsStoryActivity(context, str, str2, str3, i);
    }

    public static final void startJDGoodsStoryActivity(Context context, String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        SimpleAlphaActivity.Builder.start$default(SimpleAlphaActivity.Companion.builder(context).fragmentClass(PearGoodsFragment.class).title("").addArgs("URL", str).addArgs("TITLE", str2).addArgs("SUBTITLE", str3).addArgs("SELECTED_TAB", i), null, 1, null);
    }

    public static /* synthetic */ void startActivityByUrl$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        startActivityByUrl(context, str, str2, str3);
    }

    public static final void startActivityByUrl(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str4 = str;
        if (!(str4 == null || StringsKt.isBlank(str4))) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            UriActionUtils.UriAction findUriAction = UriActionUtils.findUriAction(parse);
            if (findUriAction != null) {
                findUriAction.takeAction(context, parse, new String[]{str2, str3});
                return;
            }
            LogUtils.w("UNSUPPORTED URL : " + str, new Object[0]);
        }
    }

    public static final void startUserQRCodeActivity(Context context, UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(context, "context");
        SimpleAlphaActivity.Builder.start$default(SimpleAlphaActivity.Companion.builder(context).fragmentClass(UserQRCodeFragment.class).title("?????????????????????").addArgs("PROFILE", userProfile), null, 1, null);
    }

    public final void startUserDataActivity(Context context, UserProfile userProfile) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userProfile, "userProfile");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (Intrinsics.areEqual(loginSession.getUid(), userProfile.getUid())) {
            str = "??????????????????";
        } else if (userProfile.getGender() >= 1) {
            str = "??????????????????";
        } else if (userProfile.getGender() == 0) {
            str = "??????????????????";
        } else {
            str = userProfile.getGender() <= -1 ? "TA???????????????" : "????????????";
        }
        SimpleActivity.builder(context).fragmentClass(UserDataFragment.class).title(str).addArgs("PROFILE", userProfile).start();
    }

    public static /* synthetic */ void startUCropActivity$default(Activity activity, String str, File file, float f, int i, int i2, Fragment fragment, int i3, Object obj) {
        if ((i3 & 64) != 0) {
            fragment = null;
        }
        startUCropActivity(activity, str, file, f, i, i2, fragment);
    }

    public static final void startUCropActivity(Activity activity, String str, File file, float f, int i, int i2, Fragment fragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "sourcePath");
        Intrinsics.checkNotNullParameter(file, "cropFile");
        AppTheme appTheme = AppHolder.getAppTheme();
        UCrop.Options options = new UCrop.Options();
        options.setActiveWidgetColor(appTheme.getColorAccent());
        options.setStatusBarColor(appTheme.isLightColorTheme() ? appTheme.getColorPrimaryDark() : appTheme.getColorPrimary());
        options.setToolbarColor(appTheme.getColorPrimary());
        options.setToolbarWidgetColor(appTheme.getMainTextColor());
        try {
            UCrop withOptions = UCrop.of(Uri.fromFile(new File(str)), Uri.fromFile(file)).withAspectRatio(f, 1.0f).withMaxResultSize(i, i2).withOptions(options);
            if (fragment == null) {
                withOptions.start(activity);
            } else {
                withOptions.start(activity, fragment);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.show$default(activity, "????????????, ??????????????? UCropActivity", 0, false, 12, null);
        }
    }

    public final void startVoteOptionDetailActivity(Context context, VoteCommentConfig voteCommentConfig) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Intrinsics.checkNotNullParameter(voteCommentConfig, "config");
        Intent intent = new Intent(context, VoteOptionDetailActivity.class);
        intent.putExtra("vote_comment_config", voteCommentConfig);
        Unit unit = Unit.INSTANCE;
        context.startActivity(intent);
    }

    public final void startVoteUserListActivity(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "optionId");
        new SimpleActivity.Builder(context).fragmentClass(VoteUserListFragment.class).title("???????????????").addArgs("id", str).addArgs("option_id", str2).start();
    }

    public static /* synthetic */ void startWeChatMiniProgram$default(ActionManagerCompat actionManagerCompat, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        actionManagerCompat.startWeChatMiniProgram(str, str2);
    }

    public final void startWeChatMiniProgram(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "path");
        IWXAPI wxApi = AppHolder.getWxApi();
        Intrinsics.checkNotNullExpressionValue(wxApi, "api");
        if (!wxApi.isWXAppInstalled()) {
            Toast.show$default(AppHolder.getApplication(), "????????????????????????????????????", 0, false, 12, null);
            return;
        }
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = str;
        req.path = str2;
        req.miniprogramType = 0;
        wxApi.sendReq(req);
    }

    public final void startFeedHistoryListActivity(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Intrinsics.checkNotNullParameter(str, "feedId");
        new SimpleActivity.Builder(context).fragmentClass(FeedHistoryListFragment.class).title("??????????????????").addArgs("FEED_ID", str).start();
    }

    public final void startWithGoodsBuyUrl(Context context, Goods goods) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(goods, "goods");
        StringBuilder sb = new StringBuilder();
        sb.append("GOODS_BUY_URL_");
        String goodsUrl = goods.getGoodsUrl();
        int i = 0;
        sb.append(goodsUrl != null ? goodsUrl.hashCode() : 0);
        sb.append('_');
        String goodsBuyUrl = goods.getGoodsBuyUrl();
        if (goodsBuyUrl != null) {
            i = goodsBuyUrl.hashCode();
        }
        sb.append(i);
        String sb2 = sb.toString();
        String str = (String) ExpireCache.INSTANCE.getOrNull(sb2, 14400000);
        if (Intrinsics.areEqual(str, "Waiting...")) {
            Toast.show$default(context, "????????????????????????", 0, false, 12, null);
        } else if (str != null) {
            startActivityByUrl(context, str, goods.getTitle(), goods.getSubTitle());
        } else {
            ExpireCache.INSTANCE.put(sb2, "Waiting...");
            DataManager.getInstance().getGoodsBuyUrl(goods.getGoodsUrl(), goods.getGoodsBuyUrl()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new ActionManagerCompat$startWithGoodsBuyUrl$1(sb2, context, goods));
        }
    }

    public final void startGoodsSearchActivityWithCallback(Context context, Function1<? super FeedGoods, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ActivityResultAdapter findActivityResultAdapter = ActivityResultAdapterKt.findActivityResultAdapter(context);
        if (findActivityResultAdapter != null) {
            findActivityResultAdapter.startActivityForResult(new Intent(context, GoodsSearchActivity.class), new ActionManagerCompat$startGoodsSearchActivityWithCallback$1(function1));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.manager.ActionManagerCompat */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startPhotoPickerActivityWithCallback$default(ActionManagerCompat actionManagerCompat, Context context, int i, List list, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        actionManagerCompat.startPhotoPickerActivityWithCallback(context, i, list, function1);
    }

    public static /* synthetic */ void startFeedGoodsSellPage$default(ActionManagerCompat actionManagerCompat, Context context, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 1;
        }
        actionManagerCompat.startFeedGoodsSellPage(context, str, str2, i);
    }

    public final void startFeedGoodsSellPage(Context context, String str, String str2, int i) {
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "mallName");
        if (StringsKt.startsWith$default(str2 != null ? str2 : "", "http", false, 2, (Object) null) || !ArraysKt.contains(new String[]{"??????", "??????"}, str)) {
            if (str2 != null) {
                str3 = str2;
            } else {
                str3 = "";
            }
            startActivityByUrl$default(context, str3, null, null, 12, null);
            return;
        }
        BearStoryHelper bearStoryHelper = BearStoryHelper.INSTANCE;
        if (str2 == null) {
            str2 = "";
        }
        bearStoryHelper.copyTaobaoWordAndJump(context, str2);
    }

    public final void startPhotoPickerActivityWithCallback(Context context, int i, List<String> list, Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "pickedList");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        Intrinsics.checkNotNull(activityNullable);
        ActionManager.doOnStoragePermissionPermit(activityNullable, new ActionManagerCompat$startPhotoPickerActivityWithCallback$1(activityNullable, list, i, function1));
    }
}
