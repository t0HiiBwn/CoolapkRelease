package com.coolapk.market.view.feedv8.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.ShareGoodDialogBinding;
import com.coolapk.market.databinding.SubmitFeedNewGoodsBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import rx.Emitter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* compiled from: FeedGoodsHelper.kt */
public final class FeedGoodsHelper {
    public static final FeedGoodsHelper INSTANCE = new FeedGoodsHelper();

    static {
        FeedGoodsUrlUtils.INSTANCE.toString();
    }

    private FeedGoodsHelper() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feedv8.util.FeedGoodsHelper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showLoadingGoodsDialog$default(FeedGoodsHelper feedGoodsHelper, Context context, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = FeedGoodsHelper$showLoadingGoodsDialog$1.INSTANCE;
        }
        feedGoodsHelper.showLoadingGoodsDialog(context, str, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feedv8.util.FeedGoodsHelper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAddGoodsDialog$default(FeedGoodsHelper feedGoodsHelper, Context context, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "填写好物链接";
        }
        if ((i & 4) != 0) {
            function1 = FeedGoodsHelper$showAddGoodsDialog$1.INSTANCE;
        }
        feedGoodsHelper.showAddGoodsDialog(context, str, function1);
    }

    public final boolean isSupportAddGoodsUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        String host = parse.getHost();
        if (host == null) {
            host = "";
        }
        return StringsKt.endsWith$default(host, "jd.com", false, 2, (Object) null);
    }

    static /* synthetic */ void showGoodsDialog$default(FeedGoodsHelper feedGoodsHelper, Activity activity, String str, String str2, String str3, String str4, boolean z, Function2 function2, int i, Object obj) {
        feedGoodsHelper.showGoodsDialog(activity, str, str2, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? false : z, function2);
    }

    private final void showGoodsDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, Function2<? super String, ? super Dialog, ? extends Function0<Unit>> function2) {
        Activity activity2 = activity;
        boolean z2 = false;
        SubmitFeedNewGoodsBinding submitFeedNewGoodsBinding = (SubmitFeedNewGoodsBinding) DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131559160, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        Intrinsics.checkNotNullExpressionValue(submitFeedNewGoodsBinding, "binding");
        AlertDialog create = builder.setView(submitFeedNewGoodsBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        TextView textView = submitFeedNewGoodsBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        String str5 = str;
        textView.setText(str5);
        EditText editText = submitFeedNewGoodsBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setHint(str3);
        LinearLayout linearLayout = submitFeedNewGoodsBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.loadingView");
        int i = 8;
        linearLayout.setVisibility(8);
        TextView textView2 = submitFeedNewGoodsBinding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subTitleView");
        TextView textView3 = textView2;
        String str6 = str4;
        if (!(str6 == null || str6.length() == 0)) {
            i = 0;
        }
        textView3.setVisibility(i);
        TextView textView4 = submitFeedNewGoodsBinding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.subTitleView");
        textView4.setText(str6);
        FeedGoodsHelper$showGoodsDialog$1 feedGoodsHelper$showGoodsDialog$1 = new FeedGoodsHelper$showGoodsDialog$1(submitFeedNewGoodsBinding);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) null;
        EditText editText2 = submitFeedNewGoodsBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
        editText2.addTextChangedListener(new FeedGoodsHelper$showGoodsDialog$$inlined$addTextChangedListener$1(objectRef, submitFeedNewGoodsBinding, activity));
        submitFeedNewGoodsBinding.editText.setText(str2);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = (T) null;
        ViewUtil.clickListener(submitFeedNewGoodsBinding.cancelButton, new FeedGoodsHelper$showGoodsDialog$3(create));
        ViewUtil.clickListener(submitFeedNewGoodsBinding.okButton, new FeedGoodsHelper$showGoodsDialog$4(submitFeedNewGoodsBinding, objectRef2, function2, create, feedGoodsHelper$showGoodsDialog$1));
        ViewUtil.clickListener(submitFeedNewGoodsBinding.closeView, new FeedGoodsHelper$showGoodsDialog$5(objectRef2));
        if (z) {
            if (str5.length() > 0) {
                z2 = true;
            }
            if (z2) {
                submitFeedNewGoodsBinding.okButton.performClick();
            }
        }
    }

    public final Observable<FeedGoods> buildFeedGoodsLoader(String str) {
        Observable<R> flatMap = DataManager.getInstance().addGoods(str).subscribeOn(Schedulers.io()).flatMap(new FeedGoodsHelper$buildFeedGoodsLoader$1(str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…      }\n                }");
        return flatMap;
    }

    public final Observable<Pair<String, String>> loadHtmlSourceCodeFromUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Observable<Pair<String, String>> create = Observable.create(new FeedGoodsHelper$loadHtmlSourceCodeFromUrl$1(str), Emitter.BackpressureMode.LATEST);
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create({ emit….BackpressureMode.LATEST)");
        return create;
    }

    public final void showUrlInClipBoardDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        String clipBoardUrl = UserPermissionChecker.INSTANCE.getClipBoardUrl(activity2);
        if (isSupportAddGoodsUrl(clipBoardUrl)) {
            ShareGoodDialogBinding shareGoodDialogBinding = (ShareGoodDialogBinding) DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131559139, null, false, new ContextBindingComponent(activity2));
            AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
            Intrinsics.checkNotNullExpressionValue(shareGoodDialogBinding, "binding");
            AlertDialog create = builder.setView(shareGoodDialogBinding.getRoot()).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
            create.setCanceledOnTouchOutside(false);
            create.setCancelable(false);
            shareGoodDialogBinding.addOnRebindCallback(new FeedGoodsHelper$showUrlInClipBoardDialog$1());
            ViewUtil.clickListener(shareGoodDialogBinding.cancelButton, new FeedGoodsHelper$showUrlInClipBoardDialog$2(Observable.zip(buildFeedGoodsLoader(clipBoardUrl), Observable.timer(1300, TimeUnit.MILLISECONDS), FeedGoodsHelper$showUrlInClipBoardDialog$subscription$1.INSTANCE).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new FeedGoodsHelper$showUrlInClipBoardDialog$subscription$2(clipBoardUrl, shareGoodDialogBinding, activity, create)), create));
            ViewUtil.clickListener(shareGoodDialogBinding.okButton, new FeedGoodsHelper$showUrlInClipBoardDialog$3(shareGoodDialogBinding, activity, create));
        }
    }

    public final void showLoadingGoodsDialog(Context context, String str, Function1<? super FeedGoods, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fromUrl");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null) {
            activityNullable = AppHolder.getCurrentActivity();
        }
        if (activityNullable != null) {
            showGoodsDialog(activityNullable, "填写好物链接", str, "", "目前仅支持京东商品链接解析", true, new FeedGoodsHelper$showLoadingGoodsDialog$2(function1, activityNullable));
        }
    }

    public final void showAddGoodsDialog(Context context, String str, Function1<? super FeedGoods, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null) {
            activityNullable = AppHolder.getCurrentActivity();
        }
        if (activityNullable != null) {
            String clipBoardUrl = UserPermissionChecker.INSTANCE.getClipBoardUrl(activityNullable);
            showGoodsDialog$default(this, activityNullable, str, isSupportAddGoodsUrl(clipBoardUrl) ? clipBoardUrl : "", "", "目前仅支持京东商品链接解析", false, new FeedGoodsHelper$showAddGoodsDialog$2(clipBoardUrl, function1, activityNullable), 32, null);
        }
    }
}
