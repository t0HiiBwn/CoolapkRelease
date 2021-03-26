package com.coolapk.market.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0014J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/wxapi/QQShareActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/tencent/tauth/IUiListener;", "()V", "tencent", "Lcom/tencent/tauth/Tencent;", "kotlin.jvm.PlatformType", "finish", "", "obtainQQShareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "entity", "Lcom/coolapk/market/model/Entity;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "onComplete", "p0", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "Lcom/tencent/tauth/UiError;", "onSetStatusBarColor", "preparedToShare", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QQShareActivity.kt */
public final class QQShareActivity extends BaseActivity implements IUiListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_SHARE_ENTITY = "extra_share_entity";
    private final Tencent tencent = Tencent.createInstance("100336226", AppHolder.getApplication());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/wxapi/QQShareActivity$Companion;", "", "()V", "EXTRA_SHARE_ENTITY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QQShareActivity.kt */
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
        Entity entity = (Entity) getIntent().getParcelableExtra("extra_share_entity");
        if (!isFinishing() && entity != null) {
            preparedToShare(entity);
        }
    }

    private final void preparedToShare(Entity entity) {
        ShareUtils.ShareInfo obtainQQShareInfo = obtainQQShareInfo(entity);
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", obtainQQShareInfo.getTitle());
        bundle.putString("summary", obtainQQShareInfo.getContent());
        bundle.putString("targetUrl", obtainQQShareInfo.getUrl());
        bundle.putString("imageUrl", obtainQQShareInfo.getLogo());
        bundle.putString("appName", "酷安");
        this.tencent.shareToQQ(this, bundle, this);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c4, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x020b, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0244, code lost:
        if (r11 != null) goto L_0x0056;
     */
    private final ShareUtils.ShareInfo obtainQQShareInfo(Entity entity) {
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
                        str2 = title != null ? title : str4;
                        str3 = dyhArticle.getRedirectUrl();
                        if (str3 == null) {
                            str3 = str4;
                        }
                        String allLinkAndText = StringUtils.getAllLinkAndText(dyhArticle.getMessage());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(dyhArticle.message)");
                        str = LinkTextUtils.reconvert(allLinkAndText);
                        logo = dyhArticle.getLogo();
                        break;
                    }
                    break;
                case 96796:
                    if (entityType.equals("apk")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                        ServiceApp serviceApp = (ServiceApp) entity;
                        String appName = serviceApp.getAppName();
                        str2 = appName != null ? appName : str4;
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://www.coolapk.com");
                        String url = serviceApp.getUrl();
                        Intrinsics.checkNotNull(url);
                        sb.append(url);
                        str3 = sb.toString();
                        String allLinkAndText2 = StringUtils.getAllLinkAndText(serviceApp.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAn…t(serviceApp.description)");
                        str = LinkTextUtils.reconvert(allLinkAndText2);
                        logo = serviceApp.getLogo();
                        break;
                    }
                    break;
                case 99955:
                    if (entityType.equals("dyh")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.DyhModel");
                        DyhModel dyhModel = (DyhModel) entity;
                        str2 = "推荐看看号 ：" + dyhModel.getTitle();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https://www.coolapk.com");
                        String url2 = dyhModel.getUrl();
                        if (url2 == null) {
                            url2 = str4;
                        }
                        sb2.append(url2);
                        str3 = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(" ");
                        String id = dyhModel.getId();
                        if (id == null) {
                            id = str4;
                        }
                        sb3.append(UriUtils.buildDyhPageUrl(id));
                        sb3.append(" ");
                        str = sb3.toString();
                        logo = dyhModel.getLogo();
                        break;
                    }
                    break;
                case 3138974:
                    if (entityType.equals("feed")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                        Feed feed = (Feed) entity;
                        str3 = EntityExtendsKt.getEncodedShareUrl(feed);
                        String messageTitle = feed.getMessageTitle();
                        boolean z = true;
                        if (messageTitle == null || messageTitle.length() == 0) {
                            String allLinkAndText3 = StringUtils.getAllLinkAndText(feed.getMessage());
                            Intrinsics.checkNotNullExpressionValue(allLinkAndText3, "StringUtils.getAllLinkAndText(feed.message)");
                            str2 = LinkTextUtils.reconvert(allLinkAndText3);
                            str = "来自酷安用户@" + feed.getUserName();
                        } else {
                            str2 = feed.getMessageTitle();
                            if (str2 == null) {
                                str2 = str4;
                            }
                            String allLinkAndText4 = StringUtils.getAllLinkAndText(feed.getMessage());
                            Intrinsics.checkNotNullExpressionValue(allLinkAndText4, "StringUtils.getAllLinkAndText(feed.message)");
                            str = new Regex("[\\n\\r]").replace(LinkTextUtils.reconvert(allLinkAndText4), " ");
                        }
                        String messageCover = feed.getMessageCover();
                        if (messageCover == null || messageCover.length() == 0) {
                            String pic = feed.getPic();
                            if (!(pic == null || pic.length() == 0)) {
                                z = false;
                            }
                            if (z) {
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
                case 92896879:
                    if (entityType.equals("album")) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Album");
                        Album album = (Album) entity;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("https://www.coolapk.com");
                        String url3 = entity.getUrl();
                        Intrinsics.checkNotNull(url3);
                        sb4.append(url3);
                        String sb5 = sb4.toString();
                        str2 = album.getTitle();
                        if (str2 == null) {
                            str2 = str4;
                        }
                        String allLinkAndText5 = StringUtils.getAllLinkAndText(album.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText5, "StringUtils.getAllLinkAndText(album.description)");
                        str = LinkTextUtils.reconvert(allLinkAndText5);
                        String logo2 = album.getLogo();
                        if (logo2 != null) {
                            str4 = logo2;
                        }
                        str3 = sb5;
                        break;
                    }
                    break;
                case 998694819:
                    if (entityType.equals("liveTopic")) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("https://www.coolapk.com");
                        String url4 = entity.getUrl();
                        if (url4 == null) {
                            url4 = str4;
                        }
                        sb6.append(url4);
                        str3 = sb6.toString();
                        str2 = entity.getTitle();
                        if (str2 == null) {
                            str2 = str4;
                        }
                        String allLinkAndText6 = StringUtils.getAllLinkAndText(entity.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText6, "StringUtils.getAllLinkAndText(entity.description)");
                        str = LinkTextUtils.reconvert(allLinkAndText6);
                        logo = entity.getLogo();
                        break;
                    }
                    break;
            }
            if (!TextUtils.isEmpty(str) && str.length() > 240) {
                StringBuilder sb7 = new StringBuilder();
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(0, 240);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb7.append(substring);
                sb7.append("..");
                str = sb7.toString();
            }
            return new ShareUtils.ShareInfo(str2, str, str3, str4);
        }
        ShareUtils.ShareInfo obtainShareInfo = ShareUtils.obtainShareInfo(entity);
        String url5 = obtainShareInfo.getUrl();
        String title2 = obtainShareInfo.getTitle();
        String content = obtainShareInfo.getContent();
        String logo3 = entity.getLogo();
        if (logo3 != null) {
            str4 = logo3;
        }
        str = content;
        str3 = url5;
        str2 = title2;
        StringBuilder sb7 = new StringBuilder();
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, 240);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb7.append(substring);
        sb7.append("..");
        str = sb7.toString();
        return new ShareUtils.ShareInfo(str2, str, str3, str4);
    }

    @Override // com.tencent.tauth.IUiListener
    public void onCancel() {
        finish();
    }

    @Override // com.tencent.tauth.IUiListener
    public void onError(UiError uiError) {
        finish();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Tencent.onActivityResultData(i, i2, intent, this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.tencent.tauth.IUiListener
    public void onComplete(Object obj) {
        if (!(obj instanceof JSONObject)) {
            obj = null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ShareUtils shareUtils = ShareUtils.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        shareUtils.markShareSucceed("qq", jSONObject2);
        Toast.show$default(this, "分享成功", 0, false, 12, null);
        finish();
    }
}
