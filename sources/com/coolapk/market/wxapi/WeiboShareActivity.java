package com.coolapk.market.wxapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.Toast;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/wxapi/WeiboShareActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/sina/weibo/sdk/share/WbShareCallback;", "()V", "shareHandler", "Lcom/sina/weibo/sdk/share/WbShareHandler;", "finish", "", "loadBitmapAndShare", "context", "Landroid/content/Context;", "logo", "", "weiboMessage", "Lcom/sina/weibo/sdk/api/WeiboMultiMessage;", "obtainWeiboShareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "entity", "Lcom/coolapk/market/model/Entity;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "onWbShareCancel", "onWbShareFail", "onWbShareSuccess", "preparedToShare", "sendWeiboRequest", "msg", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WeiboShareActivity.kt */
public final class WeiboShareActivity extends BaseActivity implements WbShareCallback {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_SHARE_ENTITY = "extra_share_entity";
    private WbShareHandler shareHandler;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/wxapi/WeiboShareActivity$Companion;", "", "()V", "EXTRA_SHARE_ENTITY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WeiboShareActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WeiboShareActivity weiboShareActivity = this;
        WeiboShareActivity weiboShareActivity2 = weiboShareActivity;
        WbSdk.install(weiboShareActivity2, new AuthInfo(weiboShareActivity2, "123216742", "https://account.coolapk.com/auth/loginByOpenId?type=weibo", "follow_app_official_microblog,"));
        WbShareHandler wbShareHandler = new WbShareHandler(weiboShareActivity);
        this.shareHandler = wbShareHandler;
        if (wbShareHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareHandler");
        }
        wbShareHandler.registerApp();
        Entity entity = (Entity) getIntent().getParcelableExtra("extra_share_entity");
        if (!isFinishing() && entity != null) {
            preparedToShare(entity);
        }
    }

    private final void preparedToShare(Entity entity) {
        ShareUtils.ShareInfo obtainWeiboShareInfo = obtainWeiboShareInfo(entity);
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        TextObject textObject = new TextObject();
        textObject.text = obtainWeiboShareInfo.getContent();
        textObject.title = obtainWeiboShareInfo.getTitle();
        textObject.actionUrl = obtainWeiboShareInfo.getUrl();
        Unit unit = Unit.INSTANCE;
        weiboMultiMessage.textObject = textObject;
        if (obtainWeiboShareInfo.getLogo().length() > 0) {
            loadBitmapAndShare(this, obtainWeiboShareInfo.getLogo(), weiboMultiMessage);
        } else {
            sendWeiboRequest(weiboMultiMessage);
        }
    }

    private final ShareUtils.ShareInfo obtainWeiboShareInfo(Entity entity) {
        String userAvatar;
        ShareUtils.ShareInfo obtainShareInfo = ShareUtils.obtainShareInfo(entity);
        String entityType = entity.getEntityType();
        if (entityType == null) {
            return obtainShareInfo;
        }
        int hashCode = entityType.hashCode();
        String str = "";
        if (hashCode != 3138974) {
            if (hashCode != 998694819 || !entityType.equals("liveTopic")) {
                return obtainShareInfo;
            }
            String logo = entity.getLogo();
            if (logo != null) {
                str = logo;
            }
            Intrinsics.checkNotNullExpressionValue(str, "entity.logo ?: \"\"");
            return ShareUtils.ShareInfo.copy$default(obtainShareInfo, null, null, null, str, 7, null);
        } else if (!entityType.equals("feed")) {
            return obtainShareInfo;
        } else {
            Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
            Feed feed = (Feed) entity;
            String messageCover = feed.getMessageCover();
            boolean z = false;
            if (!(messageCover == null || messageCover.length() == 0)) {
                ImageArgs.Companion companion = ImageArgs.Companion;
                String messageCover2 = feed.getMessageCover();
                if (messageCover2 != null) {
                    str = messageCover2;
                }
                userAvatar = companion.smallSizeProvider(str);
            } else {
                String pic = feed.getPic();
                if (!(pic == null || pic.length() == 0)) {
                    ImageArgs.Companion companion2 = ImageArgs.Companion;
                    String pic2 = feed.getPic();
                    if (pic2 != null) {
                        str = pic2;
                    }
                    userAvatar = companion2.smallSizeProvider(str);
                } else {
                    userAvatar = feed.getUserAvatar();
                    Intrinsics.checkNotNullExpressionValue(userAvatar, "feed.userAvatar");
                }
            }
            if (userAvatar.length() > 0) {
                z = true;
            }
            return z ? ShareUtils.ShareInfo.copy$default(obtainShareInfo, null, null, null, userAvatar, 7, null) : obtainShareInfo;
        }
    }

    private final void loadBitmapAndShare(Context context, String str, WeiboMultiMessage weiboMultiMessage) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("正在准备数据");
        progressDialog.show();
        Observable.timer(4000, TimeUnit.MILLISECONDS).map(WeiboShareActivity$loadBitmapAndShare$1.INSTANCE).mergeWith(Observable.create(new WeiboShareActivity$loadBitmapAndShare$loadBitmapObservable$1(context, str), Emitter.BackpressureMode.BUFFER).subscribeOn(Schedulers.io())).take(1).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super R>) new WeiboShareActivity$loadBitmapAndShare$2(this, weiboMultiMessage, progressDialog));
    }

    /* access modifiers changed from: private */
    public final void sendWeiboRequest(WeiboMultiMessage weiboMultiMessage) {
        WbShareHandler wbShareHandler = this.shareHandler;
        if (wbShareHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareHandler");
        }
        wbShareHandler.shareMessage(weiboMultiMessage, false);
        finish();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        WbShareHandler wbShareHandler = this.shareHandler;
        if (wbShareHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareHandler");
        }
        wbShareHandler.doResultIntent(intent, this);
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        ShareUtils.INSTANCE.markShareSucceed("weibo", "");
        Toast.show$default(this, "分享成功", 0, false, 12, null);
        finish();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        finish();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        finish();
    }
}
