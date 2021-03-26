package com.coolapk.market.wxapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.IUser;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.Toast;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import rx.Emitter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002./B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0010H\u0014J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010,\u001a\u00020\u0019*\u00020-H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/coolapk/market/wxapi/WXEntryActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "()V", "wxApi", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "kotlin.jvm.PlatformType", "createMediaObject", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;", "entity", "Lcom/coolapk/market/model/Entity;", "shareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "timeline", "", "finish", "", "isMiniProgramSupportType", "feedType", "", "loadBitmapAndShare", "msg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "logo", "loadDefaultThumbBitmap", "", "context", "Landroid/content/Context;", "obtainWxShareInfoShareInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onReq", "baseReq", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "baseResp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "onSetStatusBarColor", "preparedToShare", "sendWxRequest", "toValidWxThumbData", "Landroid/graphics/Bitmap;", "Companion", "WechatCode", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WXEntryActivity.kt */
public final class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_IS_TIMELINE = "extra_timeline";
    public static final String EXTRA_SHARE_ENTITY = "extra_share_entity";
    public static final String TRANSACTION_CODE_SHARE = "unknown_entity";
    private final IWXAPI wxApi = AppHolder.getWxApi();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/wxapi/WXEntryActivity$Companion;", "", "()V", "EXTRA_IS_TIMELINE", "", "EXTRA_SHARE_ENTITY", "TRANSACTION_CODE_SHARE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WXEntryActivity.kt */
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
        this.wxApi.handleIntent(getIntent(), this);
        Entity entity = (Entity) getIntent().getParcelableExtra("extra_share_entity");
        if (!isFinishing() && entity != null) {
            preparedToShare(entity, getIntent().getBooleanExtra("extra_timeline", false));
        }
    }

    private final void preparedToShare(Entity entity, boolean z) {
        ShareUtils.ShareInfo obtainWxShareInfoShareInfo = obtainWxShareInfoShareInfo(entity, z);
        WXMediaMessage wXMediaMessage = new WXMediaMessage(createMediaObject(entity, obtainWxShareInfoShareInfo, z));
        wXMediaMessage.title = KotlinExtendKt.limitLength(obtainWxShareInfoShareInfo.getTitle(), 512);
        wXMediaMessage.description = KotlinExtendKt.limitLength(obtainWxShareInfoShareInfo.getContent(), 1024);
        if (obtainWxShareInfoShareInfo.getLogo().length() == 0) {
            wXMediaMessage.thumbData = loadDefaultThumbBitmap(this);
            sendWxRequest(wXMediaMessage, z);
            return;
        }
        loadBitmapAndShare(wXMediaMessage, z, obtainWxShareInfoShareInfo.getLogo());
    }

    private final WXMediaMessage.IMediaObject createMediaObject(Entity entity, ShareUtils.ShareInfo shareInfo, boolean z) {
        boolean z2;
        if (entity instanceof Feed) {
            String feedType = ((Feed) entity).getFeedType();
            Intrinsics.checkNotNullExpressionValue(feedType, "entity.feedType");
            if (isMiniProgramSupportType(feedType)) {
                z2 = true;
                boolean z3 = entity instanceof UserProfile;
                if (!z || (!z2 && !z3)) {
                    WXWebpageObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = shareInfo.getUrl();
                    return wXWebpageObject;
                }
                WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
                wXMiniProgramObject.webpageUrl = shareInfo.getUrl();
                wXMiniProgramObject.userName = "gh_39ff592c37e2";
                if (z2) {
                    wXMiniProgramObject.path = "pages/feed/detail?id=" + entity.getId();
                } else if (z3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pages/user/space?uid=");
                    Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.UserProfile");
                    sb.append(((UserProfile) entity).getUid());
                    wXMiniProgramObject.path = sb.toString();
                }
                return wXMiniProgramObject;
            }
        }
        z2 = false;
        boolean z3 = entity instanceof UserProfile;
        if (!z) {
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareInfo.getUrl();
        return wXWebpageObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    private final boolean isMiniProgramSupportType(String str) {
        switch (str.hashCode()) {
            case -1412808770:
                return str.equals("answer");
            case -1165870106:
                if (str.equals("question")) {
                }
                break;
            case -577741570:
                if (str.equals("picture")) {
                }
                break;
            case 3138974:
                if (str.equals("feed")) {
                }
                break;
            case 950398559:
                if (str.equals("comment")) {
                }
                break;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r10 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ef, code lost:
        if (r10 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0236, code lost:
        if (r10 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x026f, code lost:
        if (r10 != null) goto L_0x00ca;
     */
    private final ShareUtils.ShareInfo obtainWxShareInfoShareInfo(Entity entity, boolean z) {
        String str;
        String str2;
        String str3;
        String logo;
        String entityType = entity.getEntityType();
        String str4 = "";
        if (entityType != null) {
            switch (entityType.hashCode()) {
                case -732377866:
                    if (entityType.equals("article")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.DyhArticle");
                        DyhArticle dyhArticle = (DyhArticle) entity;
                        String title = dyhArticle.getTitle();
                        str3 = title != null ? title : str4;
                        str = dyhArticle.getRedirectUrl();
                        if (str == null) {
                            str = str4;
                        }
                        String allLinkAndText = StringUtils.getAllLinkAndText(dyhArticle.getMessage());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(dyhArticle.message)");
                        str2 = LinkTextUtils.reconvert(allLinkAndText);
                        logo = dyhArticle.getLogo();
                        break;
                    }
                    break;
                case 96796:
                    if (entityType.equals("apk")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                        ServiceApp serviceApp = (ServiceApp) entity;
                        String appName = serviceApp.getAppName();
                        str3 = appName != null ? appName : str4;
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://www.coolapk.com");
                        String url = serviceApp.getUrl();
                        Intrinsics.checkNotNull(url);
                        sb.append(url);
                        str = sb.toString();
                        String allLinkAndText2 = StringUtils.getAllLinkAndText(serviceApp.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAn…t(serviceApp.description)");
                        str2 = LinkTextUtils.reconvert(allLinkAndText2);
                        logo = serviceApp.getLogo();
                        break;
                    }
                    break;
                case 99955:
                    if (entityType.equals("dyh")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.DyhModel");
                        DyhModel dyhModel = (DyhModel) entity;
                        str3 = "推荐看看号 ：" + dyhModel.getTitle();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https://www.coolapk.com");
                        String url2 = dyhModel.getUrl();
                        if (url2 == null) {
                            url2 = str4;
                        }
                        sb2.append(url2);
                        str = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str3);
                        sb3.append(" ");
                        String id = dyhModel.getId();
                        if (id == null) {
                            id = str4;
                        }
                        sb3.append(UriUtils.buildDyhPageUrl(id));
                        sb3.append(" ");
                        str2 = sb3.toString();
                        logo = dyhModel.getLogo();
                        break;
                    }
                    break;
                case 3138974:
                    if (entityType.equals("feed")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                        Feed feed = (Feed) entity;
                        str = EntityExtendsKt.getEncodedShareUrl(feed);
                        String messageTitle = feed.getMessageTitle();
                        boolean z2 = true;
                        if (messageTitle == null || messageTitle.length() == 0) {
                            String allLinkAndText3 = StringUtils.getAllLinkAndText(feed.getMessage());
                            Intrinsics.checkNotNullExpressionValue(allLinkAndText3, "StringUtils.getAllLinkAndText(feed.message)");
                            str3 = LinkTextUtils.reconvert(allLinkAndText3);
                            str2 = "来自酷安用户@" + feed.getUserName();
                        } else {
                            str3 = feed.getMessageTitle();
                            if (str3 == null) {
                                str3 = str4;
                            }
                            String allLinkAndText4 = StringUtils.getAllLinkAndText(feed.getMessage());
                            Intrinsics.checkNotNullExpressionValue(allLinkAndText4, "StringUtils.getAllLinkAndText(feed.message)");
                            str2 = new Regex("[\\n\\r]").replace(LinkTextUtils.reconvert(allLinkAndText4), " ");
                        }
                        String messageCover = feed.getMessageCover();
                        if (messageCover == null || messageCover.length() == 0) {
                            String pic = feed.getPic();
                            if (!(pic == null || pic.length() == 0)) {
                                z2 = false;
                            }
                            if (z2) {
                                str4 = feed.getUserAvatar();
                                Intrinsics.checkNotNullExpressionValue(str4, "feed.userAvatar");
                                break;
                            } else {
                                ImageArgs.Companion companion = ImageArgs.Companion;
                                String pic2 = feed.getPic();
                                if (pic2 != null) {
                                    str4 = pic2;
                                }
                                str4 = companion.extraSmallSizeProvider(str4);
                                break;
                            }
                        } else {
                            ImageArgs.Companion companion2 = ImageArgs.Companion;
                            String messageCover2 = feed.getMessageCover();
                            if (messageCover2 != null) {
                                str4 = messageCover2;
                            }
                            str4 = companion2.extraSmallSizeProvider(str4);
                            break;
                        }
                    }
                    break;
                case 3599307:
                    if (entityType.equals("user")) {
                        ShareUtils.ShareInfo obtainShareInfo = ShareUtils.obtainShareInfo(entity);
                        String url3 = obtainShareInfo.getUrl();
                        str3 = obtainShareInfo.getTitle();
                        str2 = obtainShareInfo.getContent();
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.IUser");
                        logo = IUser.IUserGetter.getUserAvatar((IUser) entity);
                        Intrinsics.checkNotNullExpressionValue(logo, "IUser.IUserGetter.getUserAvatar(entity as IUser)");
                        str = url3;
                        str4 = logo;
                        break;
                    }
                    break;
                case 92896879:
                    if (entityType.equals("album")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Album");
                        Album album = (Album) entity;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("https://www.coolapk.com");
                        String url4 = entity.getUrl();
                        Intrinsics.checkNotNull(url4);
                        sb4.append(url4);
                        String sb5 = sb4.toString();
                        str3 = album.getTitle();
                        if (str3 == null) {
                            str3 = str4;
                        }
                        String allLinkAndText5 = StringUtils.getAllLinkAndText(album.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText5, "StringUtils.getAllLinkAndText(album.description)");
                        str2 = LinkTextUtils.reconvert(allLinkAndText5);
                        String logo2 = album.getLogo();
                        if (logo2 != null) {
                            str4 = logo2;
                        }
                        str = sb5;
                        break;
                    }
                    break;
                case 998694819:
                    if (entityType.equals("liveTopic")) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("https://www.coolapk.com");
                        String url5 = entity.getUrl();
                        if (url5 == null) {
                            url5 = str4;
                        }
                        sb6.append(url5);
                        str = sb6.toString();
                        str3 = entity.getTitle();
                        if (str3 == null) {
                            str3 = str4;
                        }
                        String allLinkAndText6 = StringUtils.getAllLinkAndText(entity.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText6, "StringUtils.getAllLinkAndText(entity.description)");
                        str2 = LinkTextUtils.reconvert(allLinkAndText6);
                        logo = entity.getLogo();
                        break;
                    }
                    break;
            }
            if (!TextUtils.isEmpty(str2) && str2.length() > 240) {
                StringBuilder sb7 = new StringBuilder();
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String substring = str2.substring(0, 240);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb7.append(substring);
                sb7.append("..");
                str2 = sb7.toString();
            }
            return new ShareUtils.ShareInfo(str3, str2, str, str4);
        }
        ShareUtils.ShareInfo obtainShareInfo2 = ShareUtils.obtainShareInfo(entity);
        String url6 = obtainShareInfo2.getUrl();
        String title2 = obtainShareInfo2.getTitle();
        String content = obtainShareInfo2.getContent();
        String logo3 = entity.getLogo();
        if (logo3 != null) {
            str4 = logo3;
        }
        str2 = content;
        str = url6;
        str3 = title2;
        StringBuilder sb7 = new StringBuilder();
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String substring = str2.substring(0, 240);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb7.append(substring);
        sb7.append("..");
        str2 = sb7.toString();
        return new ShareUtils.ShareInfo(str3, str2, str, str4);
    }

    private final void loadBitmapAndShare(WXMediaMessage wXMediaMessage, boolean z, String str) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("正在准备数据");
        progressDialog.show();
        Observable.timer(4000, TimeUnit.MILLISECONDS).map(WXEntryActivity$loadBitmapAndShare$1.INSTANCE).mergeWith(Observable.create(new WXEntryActivity$loadBitmapAndShare$loadBitmapObservable$1(this, str), Emitter.BackpressureMode.BUFFER).subscribeOn(Schedulers.io())).take(1).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super R>) new WXEntryActivity$loadBitmapAndShare$2(this, wXMediaMessage, z, progressDialog));
    }

    /* access modifiers changed from: private */
    public final void sendWxRequest(WXMediaMessage wXMediaMessage, boolean z) {
        String str;
        Entity entity = (Entity) getIntent().getParcelableExtra("extra_share_entity");
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        if (entity == null || (str = EntityExtendsKt.entityUniqueId(entity)) == null) {
            str = "unknown_entity";
        }
        req.transaction = str;
        req.message = wXMediaMessage;
        req.scene = z ? 1 : 0;
        this.wxApi.sendReq(req);
        finish();
    }

    /* access modifiers changed from: private */
    public final byte[] loadDefaultThumbBitmap(Context context) {
        try {
            Drawable drawable = context.getDrawable(2131689481);
            if (drawable == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(R.mi…_launcher) ?: return null");
            drawable.setBounds(0, 0, 120, 120);
            Bitmap drawableToBitmap = BitmapUtil.drawableToBitmap(drawable);
            Intrinsics.checkNotNullExpressionValue(drawableToBitmap, "bitmap");
            return toValidWxThumbData(drawableToBitmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final byte[] toValidWxThumbData(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(120, 120, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Intrinsics.checkNotNullExpressionValue(createBitmap, "result");
        canvas.drawBitmap(bitmap, rect, new RectF(0.0f, 0.0f, (float) createBitmap.getWidth(), (float) createBitmap.getHeight()), new Paint(1));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        int i = 90;
        createBitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream2);
        if (byteArrayOutputStream.size() > 32768) {
            byteArrayOutputStream.reset();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream2);
            while (byteArrayOutputStream.size() > 32768) {
                byteArrayOutputStream.reset();
                i -= 10;
                createBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "baos.toByteArray()");
        return byteArray;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        this.wxApi.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Intrinsics.checkNotNullParameter(baseReq, "baseReq");
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(baseResp, "baseResp");
        Bundle bundle = new Bundle();
        baseResp.toBundle(bundle);
        int type = baseResp.getType();
        if (type != 1) {
            if (type == 2 && baseResp.errCode == 0) {
                JSONObject jSONObject = KotlinExtendKt.toJSONObject(bundle);
                ShareUtils shareUtils = ShareUtils.INSTANCE;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                shareUtils.markShareSucceed("weixin", jSONObject2);
                Toast.show$default(this, "分享成功", 0, false, 12, null);
            }
        } else if (baseResp.errCode == 0) {
            EventBus.getDefault().post(new WechatCode(new SendAuth.Resp(bundle).code));
        }
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/wxapi/WXEntryActivity$WechatCode;", "", "code", "", "(Lcom/coolapk/market/wxapi/WXEntryActivity;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WXEntryActivity.kt */
    public final class WechatCode {
        private String code;

        public WechatCode(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        public final void setCode(String str) {
            this.code = str;
        }
    }
}
