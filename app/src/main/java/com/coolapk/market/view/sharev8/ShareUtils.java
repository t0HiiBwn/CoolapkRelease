package com.coolapk.market.view.sharev8;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActivityStackManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.IUser;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.wxapi.QQShareActivity;
import com.coolapk.market.wxapi.WXEntryActivity;
import com.coolapk.market.wxapi.WeiboShareActivity;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000fH\u0007J \u0010#\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0012H\u0007J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000fH\u0007J\u000e\u0010&\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0002J\f\u0010'\u001a\u00020(*\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareUtils;", "", "()V", "ENTITY_FOR_SHARE", "", "PACKAGE_QQ", "PACKAGE_TIM", "PACKAGE_WEIBO", "PACKAGE_WEIXIN", "PACKAGE_ZHIHU", "SHARE_REQUEST_TYPE_QQ", "SHARE_REQUEST_TYPE_WEIBO", "SHARE_REQUEST_TYPE_WEIXIN", "pendingShareEntityMap", "Ljava/util/HashMap;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/HashMap;", "pendingWeChatTimeline", "", "buildContent", "context", "Landroid/content/Context;", "message", "title", "url", "markShareSucceed", "", "shareRequestType", "shareResponseMsg", "obtainShareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "entity", "shareRequestTypeToName", "type", "shareToQQ", "shareToWechatUrl", "timeline", "shareToWeibo", "insertHostIfNeed", "roundedBitmap", "Landroid/graphics/Bitmap;", "ShareInfo", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareUtils.kt */
public final class ShareUtils {
    public static final String ENTITY_FOR_SHARE = "share_entity";
    public static final ShareUtils INSTANCE = new ShareUtils();
    public static final String PACKAGE_QQ = "com.tencent.mobileqq";
    public static final String PACKAGE_TIM = "com.tencent.tim";
    public static final String PACKAGE_WEIBO = "com.sina.weibo";
    public static final String PACKAGE_WEIXIN = "com.tencent.mm";
    public static final String PACKAGE_ZHIHU = "com.zhihu.android";
    public static final String SHARE_REQUEST_TYPE_QQ = "qq";
    public static final String SHARE_REQUEST_TYPE_WEIBO = "weibo";
    public static final String SHARE_REQUEST_TYPE_WEIXIN = "weixin";
    private static HashMap<String, Entity> pendingShareEntityMap = new HashMap<>();
    private static boolean pendingWeChatTimeline;

    private ShareUtils() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @JvmStatic
    public static final ShareInfo obtainShareInfo(Entity entity) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String encodedShareUrl;
        String str9;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Application application = AppHolder.getApplication();
        String entityType = entity.getEntityType();
        String str10 = "";
        if (entityType != null) {
            switch (entityType.hashCode()) {
                case -1741312354:
                    if (entityType.equals("collection")) {
                        Collection collection = (Collection) entity;
                        StringBuilder sb = new StringBuilder();
                        sb.append("推荐酷安用户@");
                        UserInfo userInfo = collection.getUserInfo();
                        Intrinsics.checkNotNull(userInfo);
                        Intrinsics.checkNotNullExpressionValue(userInfo, "entity.userInfo!!");
                        sb.append(userInfo.getDisplayUserName());
                        sb.append(" 的收藏单");
                        str8 = sb.toString();
                        ShareUtils shareUtils = INSTANCE;
                        str7 = shareUtils.insertHostIfNeed(collection.getUrl());
                        String valueOf = String.valueOf(collection.getTitle());
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str6 = shareUtils.buildContent(application, valueOf, str8, str7);
                        str2 = str6;
                        str3 = str8;
                        str = str7;
                        break;
                    }
                    break;
                case -732377866:
                    if (entityType.equals("article")) {
                        DyhArticle dyhArticle = (DyhArticle) entity;
                        str8 = "分享文章";
                        ShareUtils shareUtils2 = INSTANCE;
                        str7 = shareUtils2.insertHostIfNeed(dyhArticle.getRedirectUrl());
                        String allLinkAndText = StringUtils.getAllLinkAndText(dyhArticle.getMessage());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(dyhArticle.message)");
                        String reconvert = LinkTextUtils.reconvert(allLinkAndText);
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str6 = shareUtils2.buildContent(application, reconvert, str8, str7);
                        str2 = str6;
                        str3 = str8;
                        str = str7;
                        break;
                    }
                    break;
                case -672675773:
                    if (entityType.equals("share_entity")) {
                        str5 = INSTANCE.insertHostIfNeed(entity.getUrl());
                        String title = entity.getTitle();
                        if (title != null) {
                            str10 = title;
                        }
                        String allLinkAndText2 = StringUtils.getAllLinkAndText(entity.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAndText(entity.description)");
                        str4 = LinkTextUtils.reconvert(allLinkAndText2);
                        str2 = str4;
                        str = str5;
                        str3 = str10;
                        break;
                    }
                    break;
                case 96796:
                    if (entityType.equals("apk")) {
                        ServiceApp serviceApp = (ServiceApp) entity;
                        String apkType = serviceApp.getApkType();
                        if (apkType != null) {
                            int hashCode = apkType.hashCode();
                            if (hashCode != 49) {
                                if (hashCode == 50 && apkType.equals("2")) {
                                    str10 = "游戏";
                                }
                            } else if (apkType.equals("1")) {
                                str10 = "应用";
                            }
                        }
                        str8 = "推荐" + str10 + " 【" + serviceApp.getAppName() + (char) 12305;
                        ShareUtils shareUtils3 = INSTANCE;
                        str7 = shareUtils3.insertHostIfNeed(serviceApp.getUrl());
                        String allLinkAndText3 = StringUtils.getAllLinkAndText(serviceApp.getDescription());
                        Intrinsics.checkNotNullExpressionValue(allLinkAndText3, "StringUtils.getAllLinkAn…t(serviceApp.description)");
                        String reconvert2 = LinkTextUtils.reconvert(allLinkAndText3);
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str6 = shareUtils3.buildContent(application, reconvert2, str8, str7);
                        str2 = str6;
                        str3 = str8;
                        str = str7;
                        break;
                    }
                    break;
                case 99955:
                    if (entityType.equals("dyh")) {
                        DyhModel dyhModel = (DyhModel) entity;
                        str8 = "推荐酷安看看号";
                        ShareUtils shareUtils4 = INSTANCE;
                        str7 = shareUtils4.insertHostIfNeed(dyhModel.getUrl());
                        String valueOf2 = String.valueOf(dyhModel.getTitle());
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str6 = shareUtils4.buildContent(application, valueOf2, str8, str7);
                        str2 = str6;
                        str3 = str8;
                        str = str7;
                        break;
                    }
                    break;
                case 3138974:
                    if (entityType.equals("feed")) {
                        Feed feed = (Feed) entity;
                        boolean equals = TextUtils.equals(feed.getFeedType(), "comment");
                        if (!TextUtils.isEmpty(feed.getMessageTitle())) {
                            str10 = (char) 12304 + feed.getMessageTitle() + (char) 12305;
                        }
                        encodedShareUrl = EntityExtendsKt.getEncodedShareUrl(feed);
                        if (equals) {
                            str9 = "分享酷安用户@" + feed.getUserName() + " 对【" + feed.getAppName() + "】的" + feed.getFeedTypeName();
                        } else {
                            str9 = "分享酷安用户@" + feed.getUserName() + " 的" + feed.getFeedTypeName();
                        }
                        if (!(feed.getType() == 10 || feed.getType() == 11 || feed.getType() == 12)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str10);
                            String allLinkAndText4 = StringUtils.getAllLinkAndText(feed.getMessage());
                            Intrinsics.checkNotNullExpressionValue(allLinkAndText4, "StringUtils.getAllLinkAndText(feed.message)");
                            sb2.append(LinkTextUtils.reconvert(allLinkAndText4));
                            str10 = sb2.toString();
                        }
                        ShareUtils shareUtils5 = INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str2 = shareUtils5.buildContent(application, str10, str9, encodedShareUrl);
                        str3 = str9;
                        str = encodedShareUrl;
                        break;
                    }
                    break;
                case 3599307:
                    if (entityType.equals("user")) {
                        IUser iUser = (IUser) entity;
                        str8 = "推荐酷安用户 @" + iUser.getDeprecatedUserName();
                        String uid = iUser.getUid();
                        Intrinsics.checkNotNullExpressionValue(uid, "user.uid");
                        str7 = UriUtils.buildUserPageUrl(uid);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str8);
                        sb3.append(" ");
                        String uid2 = iUser.getUid();
                        Intrinsics.checkNotNullExpressionValue(uid2, "user.uid");
                        sb3.append(UriUtils.buildUserPageUrl(uid2));
                        sb3.append(" 分享自【酷安App】");
                        str6 = sb3.toString();
                        str2 = str6;
                        str3 = str8;
                        str = str7;
                        break;
                    }
                    break;
                case 92896879:
                    if (entityType.equals("album")) {
                        Album album = (Album) entity;
                        ShareUtils shareUtils6 = INSTANCE;
                        encodedShareUrl = shareUtils6.insertHostIfNeed(album.getUrl());
                        String str11 = "推荐酷安应用集： " + album.getTitle();
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str3 = str11;
                        str2 = shareUtils6.buildContent(application, str10, str11, encodedShareUrl);
                        str = encodedShareUrl;
                        break;
                    }
                    break;
                case 998694819:
                    if (entityType.equals("liveTopic")) {
                        str8 = "分享酷安直播";
                        ShareUtils shareUtils7 = INSTANCE;
                        str7 = shareUtils7.insertHostIfNeed(entity.getUrl());
                        Intrinsics.checkNotNullExpressionValue(application, "context");
                        str6 = shareUtils7.buildContent(application, (char) 12304 + entity.getTitle() + (char) 12305, str8, str7);
                        str2 = str6;
                        str3 = str8;
                        str = str7;
                        break;
                    }
                    break;
            }
            return new ShareInfo(str3, str2, str, null, 8, null);
        }
        str5 = INSTANCE.insertHostIfNeed(entity.getUrl());
        String title2 = entity.getTitle();
        if (title2 != null) {
            str10 = title2;
        }
        String allLinkAndText5 = StringUtils.getAllLinkAndText(entity.getDescription());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText5, "StringUtils.getAllLinkAndText(entity.description)");
        str4 = LinkTextUtils.reconvert(allLinkAndText5);
        str2 = str4;
        str = str5;
        str3 = str10;
        return new ShareInfo(str3, str2, str, null, 8, null);
    }

    private final String buildContent(Context context, String str, String str2, String str3) {
        if (str.length() > 240) {
            StringBuilder sb = new StringBuilder();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(0, 240);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("..");
            str = sb.toString();
        }
        return str2 + (char) 65306 + str + ' ' + str3 + "  " + context.getString(2131886685);
    }

    private final String insertHostIfNeed(String str) {
        if (str == null) {
            str = "";
        }
        boolean z = true;
        if (str.length() == 0) {
            return str;
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        String host = parse.getHost();
        if (!(host == null || host.length() == 0)) {
            z = false;
        }
        if (!z) {
            return str;
        }
        return "https://www.coolapk.com" + str;
    }

    @JvmStatic
    public static final void shareToQQ(Context context, Entity entity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        try {
            Intent intent = new Intent(context, QQShareActivity.class);
            intent.putExtra("extra_share_entity", entity);
            context.startActivity(intent);
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null) {
                activityNullable.overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pendingShareEntityMap.put("qq", entity);
    }

    @JvmStatic
    public static final void shareToWeibo(Context context, Entity entity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        try {
            Intent intent = new Intent(context, WeiboShareActivity.class);
            intent.putExtra("extra_share_entity", entity);
            context.startActivity(intent);
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null) {
                activityNullable.overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pendingShareEntityMap.put("weibo", entity);
    }

    @JvmStatic
    public static final void shareToWechatUrl(Context context, Entity entity, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        try {
            Intent intent = new Intent(context, WXEntryActivity.class);
            intent.putExtra("extra_share_entity", entity);
            intent.putExtra("extra_timeline", z);
            context.startActivity(intent);
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null) {
                activityNullable.overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pendingWeChatTimeline = z;
        pendingShareEntityMap.put("weixin", entity);
    }

    private final Bitmap roundedBitmap(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        float width = ((float) bitmap.getWidth()) / 12.0f;
        canvas.drawRoundRect(rectF, width, width, paint);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "result");
        return createBitmap;
    }

    public final void markShareSucceed(String str, String str2) {
        int hashCode;
        Intrinsics.checkNotNullParameter(str, "shareRequestType");
        Intrinsics.checkNotNullParameter(str2, "shareResponseMsg");
        Entity entity = pendingShareEntityMap.get(str);
        if (entity != null) {
            Intrinsics.checkNotNullExpressionValue(entity, "pendingShareEntityMap[shareRequestType] ?: return");
            String entityType = entity.getEntityType();
            if (entityType != null && ((hashCode = entityType.hashCode()) == -732377866 ? entityType.equals("article") : !(hashCode != 3138974 || !entityType.equals("feed")))) {
                DataManager.getInstance().shareCallback(entity.getId(), entity.getEntityType(), str, str2).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber());
            }
            if (entity instanceof Feed) {
                StatisticHelper.Companion.getInstance().recordOutsideFeedShareEvent(shareRequestTypeToName(str));
            }
            pendingShareEntityMap.remove(str);
            ActivityStackManager activityStackManager = AppHolder.getActivityStackManager();
            Activity topActivity = activityStackManager.getTopActivity();
            if (topActivity == null) {
                return;
            }
            if (topActivity instanceof ShareListActivity) {
                topActivity.finish();
                return;
            }
            Activity activityUnder$default = ActivityStackManager.getActivityUnder$default(activityStackManager, topActivity, false, 2, null);
            if (activityUnder$default instanceof ShareListActivity) {
                activityUnder$default.finish();
            }
        }
    }

    private final String shareRequestTypeToName(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -791575966) {
            if (hashCode != 3616) {
                if (hashCode == 113011944 && str.equals("weibo")) {
                    return "微博";
                }
            } else if (str.equals("qq")) {
                return "QQ";
            }
        } else if (str.equals("weixin")) {
            return pendingWeChatTimeline ? "微信朋友圈 " : "微信好友";
        }
        return "其他";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "title", "", "content", "url", "logo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getLogo", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShareUtils.kt */
    public static final class ShareInfo implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        private final String content;
        private final String logo;
        private final String title;
        private final String url;

        public static /* synthetic */ ShareInfo copy$default(ShareInfo shareInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = shareInfo.title;
            }
            if ((i & 2) != 0) {
                str2 = shareInfo.content;
            }
            if ((i & 4) != 0) {
                str3 = shareInfo.url;
            }
            if ((i & 8) != 0) {
                str4 = shareInfo.logo;
            }
            return shareInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.content;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.logo;
        }

        public final ShareInfo copy(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "content");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(str4, "logo");
            return new ShareInfo(str, str2, str3, str4);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShareInfo)) {
                return false;
            }
            ShareInfo shareInfo = (ShareInfo) obj;
            return Intrinsics.areEqual(this.title, shareInfo.title) && Intrinsics.areEqual(this.content, shareInfo.content) && Intrinsics.areEqual(this.url, shareInfo.url) && Intrinsics.areEqual(this.logo, shareInfo.logo);
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.content;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.url;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.logo;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            return "ShareInfo(title=" + this.title + ", content=" + this.content + ", url=" + this.url + ", logo=" + this.logo + ")";
        }

        public ShareInfo(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "content");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(str4, "logo");
            this.title = str;
            this.content = str2;
            this.url = str3;
            this.logo = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ShareInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? "" : str4);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getLogo() {
            return this.logo;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public ShareInfo(Parcel parcel) {
            this(r0, r2, r3, r5);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
            Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
            String readString2 = parcel.readString();
            Intrinsics.checkNotNull(readString2);
            Intrinsics.checkNotNullExpressionValue(readString2, "parcel.readString()!!");
            String readString3 = parcel.readString();
            Intrinsics.checkNotNull(readString3);
            Intrinsics.checkNotNullExpressionValue(readString3, "parcel.readString()!!");
            String readString4 = parcel.readString();
            Intrinsics.checkNotNull(readString4);
            Intrinsics.checkNotNullExpressionValue(readString4, "parcel.readString()!!");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.content);
            parcel.writeString(this.url);
            parcel.writeString(this.logo);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ShareUtils.kt */
        public static final class CREATOR implements Parcelable.Creator<ShareInfo> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            public ShareInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ShareInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ShareInfo[] newArray(int i) {
                return new ShareInfo[i];
            }
        }
    }
}
