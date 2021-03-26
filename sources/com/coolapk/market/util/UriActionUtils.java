package com.coolapk.market.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.EncodeUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.event.TabEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.BearStoryHelper;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.util.uri.TaoBaoAction;
import com.coolapk.market.view.base.SimpleActivity;
import com.coolapk.market.view.center.HistoryTimeV9Fragment;
import com.coolapk.market.view.center.RecentHistoryFragment;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.TopicPickerActivity;
import com.coolapk.market.view.feedv8.util.FeedGoodsHelper;
import com.coolapk.market.widget.PrivacyAlertDialog;
import com.coolapk.market.widget.Toast;
import com.hjq.permissions.XXPermissions;
import com.kepler.jd.Listener.AsyncInitListener;
import com.kepler.jd.login.KeplerApiManager;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\bÆ\u0002\u0018\u00002\u00020\u0001:%\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0006\u0010\t\u001a\u00020\nJ\t\u0010\u000b\u001a\u00020\nH\bJ\f\u0010\f\u001a\u00020\r*\u00020\bH\u0002J\f\u0010\u000e\u001a\u00020\r*\u00020\bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils;", "", "()V", "uriActionSet", "", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "findUriAction", "uri", "Landroid/net/Uri;", "init", "", "testUrl", "isCoolApkOrEmptyHost", "", "isCoolMarketScheme", "AlbumUriAction", "ApkUriAction", "AppBarUriAction", "ArticleUriAction", "CollectionUriAction", "CoolApkWebUriAction", "DeprecatedFeedUriAction", "DeprecatedUserUriAction", "DouYinAction", "DyhArticleUriAction", "DyhUriAction", "ElseUriAction", "FaXianUriAction", "GameBarUriAction", "GameUriAction", "GoodsUriAction", "JDAction", "LiveUriAction", "MainUriAction", "MarketUriAction", "PageUriAction", "PathIdUriAction", "PictureUriAction", "ProductUriAction", "RedirectWebUriAction", "SearchSpotAction", "SearchTabAction", "SellUriAction", "SharpPageUriAction", "SimpleActivityUriAction", "TabAction", "TopicUriAction", "UriAction", "UserDetailUriAction", "UserNameUriAction", "UserUriAction", "WebUriAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
public final class UriActionUtils {
    public static final UriActionUtils INSTANCE = new UriActionUtils();
    private static final Set<UriAction> uriActionSet;

    public final void init() {
    }

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        uriActionSet = linkedHashSet;
        linkedHashSet.add(new MarketUriAction());
        linkedHashSet.add(new MainUriAction());
        linkedHashSet.add(new LiveUriAction());
        linkedHashSet.add(new SearchSpotAction());
        linkedHashSet.add(new SearchTabAction());
        linkedHashSet.add(new TabAction());
        linkedHashSet.add(SharpPageUriAction.INSTANCE);
        linkedHashSet.add(new PageUriAction());
        linkedHashSet.add(new DeprecatedFeedUriAction());
        linkedHashSet.add(new DeprecatedUserUriAction());
        linkedHashSet.add(new UserUriAction());
        linkedHashSet.add(new UserDetailUriAction());
        linkedHashSet.add(new FeedUriAction());
        linkedHashSet.add(new GoodsUriAction());
        linkedHashSet.add(new ProductUriAction());
        linkedHashSet.add(new PictureUriAction());
        linkedHashSet.add(new TopicUriAction());
        linkedHashSet.add(new ApkUriAction());
        linkedHashSet.add(new GameUriAction());
        linkedHashSet.add(new UserNameUriAction());
        linkedHashSet.add(new FaXianUriAction());
        linkedHashSet.add(new AlbumUriAction());
        linkedHashSet.add(new AppBarUriAction());
        linkedHashSet.add(new GameBarUriAction());
        linkedHashSet.add(new DyhUriAction());
        linkedHashSet.add(new CollectionUriAction());
        linkedHashSet.add(new DyhArticleUriAction());
        linkedHashSet.add(new ArticleUriAction());
        linkedHashSet.add(new SimpleActivityUriAction());
        linkedHashSet.add(new DouYinAction());
        linkedHashSet.add(JDAction.INSTANCE);
        linkedHashSet.add(TaoBaoAction.INSTANCE);
        linkedHashSet.add(new SellUriAction());
        linkedHashSet.add(new RedirectWebUriAction());
        linkedHashSet.add(new CoolApkWebUriAction());
        linkedHashSet.add(new WebUriAction());
        linkedHashSet.add(new ElseUriAction());
    }

    private UriActionUtils() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&J-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$UriAction;", "", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "isThisAction", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static abstract class UriAction {
        public abstract String getActionType();

        public abstract boolean isThisAction(Uri uri);

        public abstract void takeAction(Context context, Uri uri, Object[] objArr);

        public static /* synthetic */ void takeAction$default(UriAction uriAction, Context context, Uri uri, Object[] objArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    objArr = null;
                }
                uriAction.takeAction(context, uri, objArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeAction");
        }

        public int hashCode() {
            return getClass().getSimpleName().hashCode();
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            return Intrinsics.areEqual(getClass().getSimpleName(), (obj == null || (cls = obj.getClass()) == null) ? null : cls.getSimpleName());
        }
    }

    @JvmStatic
    public static final UriAction findUriAction(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        if (StringsKt.isBlank(uri2)) {
            return null;
        }
        for (T t : uriActionSet) {
            if (t.isThisAction(uri)) {
                return t;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final boolean isCoolApkOrEmptyHost(Uri uri) {
        String host = uri.getHost();
        if (!(host == null || host.length() == 0) && !Intrinsics.areEqual(uri.getHost(), "coolapk.com") && !Intrinsics.areEqual(uri.getHost(), "com.coolapk.market")) {
            String host2 = uri.getHost();
            Intrinsics.checkNotNull(host2);
            Intrinsics.checkNotNullExpressionValue(host2, "host!!");
            if (!StringsKt.endsWith$default(host2, ".coolapk.com", false, 2, (Object) null) || !(!Intrinsics.areEqual(uri.getHost(), "image.coolapk.com"))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean isCoolMarketScheme(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "coolmarket");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$MarketUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class MarketUriAction extends UriAction {
        private final String actionType = "market";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return Intrinsics.areEqual(uri.getScheme(), "market");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String queryParameter = uri.getQueryParameter("id");
            String str = queryParameter;
            if (!(str == null || StringsKt.isBlank(str))) {
                ActionManager.startAppViewActivity(context, queryParameter, null, null, null, EntityExtendsKt.urlClientConfig(uri));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J5\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$SharpPageUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "startWithRealUri", "", "context", "Landroid/content/Context;", "fullUri", "any", "", "url", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;Ljava/lang/String;)V", "takeAction", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class SharpPageUriAction extends UriAction {
        public static final SharpPageUriAction INSTANCE = new SharpPageUriAction();
        private static final String actionType = "page";

        private SharpPageUriAction() {
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return StringsKt.startsWith$default(uri2, "#", false, 2, (Object) null);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            Objects.requireNonNull(uri2, "null cannot be cast to non-null type java.lang.String");
            String substring = uri2.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            Uri parse = Uri.parse(substring);
            Intrinsics.checkNotNullExpressionValue(parse, "realUri");
            startWithRealUri$default(this, context, parse, objArr, null, 8, null);
        }

        public static /* synthetic */ void startWithRealUri$default(SharpPageUriAction sharpPageUriAction, Context context, Uri uri, Object[] objArr, String str, int i, Object obj) {
            if ((i & 8) != 0) {
                str = null;
            }
            sharpPageUriAction.startWithRealUri(context, uri, objArr, str);
        }

        public final void startWithRealUri(Context context, Uri uri, Object[] objArr, String str) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "fullUri");
            Object obj3 = null;
            if (objArr != null) {
                obj = ArraysKt.getOrNull(objArr, 0);
            } else {
                obj = null;
            }
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str2 = (String) obj;
            if (objArr != null) {
                obj2 = ArraysKt.getOrNull(objArr, 1);
            } else {
                obj2 = null;
            }
            if (obj2 instanceof String) {
                obj3 = obj2;
            }
            String str3 = (String) obj3;
            String queryParameter = uri.getQueryParameter("title");
            String str4 = "";
            if (queryParameter != null) {
                str2 = queryParameter;
            } else if (str2 == null) {
                str2 = str4;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "fullUri.getQueryParamete…elvis { title.notNull() }");
            String queryParameter2 = uri.getQueryParameter("subTitle");
            if (queryParameter2 != null) {
                str3 = queryParameter2;
            } else if (str3 == null) {
                str3 = str4;
            }
            Intrinsics.checkNotNullExpressionValue(str3, "fullUri.getQueryParamete…is { subTitle.notNull() }");
            String queryParameter3 = uri.getQueryParameter("dataListType");
            String queryParameter4 = uri.getQueryParameter("selectedTab");
            if (queryParameter4 != null) {
                str4 = queryParameter4;
            }
            Integer intOrNull = StringsKt.toIntOrNull(str4);
            int intValue = intOrNull != null ? intOrNull.intValue() : -1;
            if (str == null) {
                str = uri.toString();
                Intrinsics.checkNotNullExpressionValue(str, "fullUri.toString()");
            }
            if (Intrinsics.areEqual(queryParameter3, "staggered")) {
                ActionManager.startFallsListFragment(context, str, str2, str3);
            } else if (Intrinsics.areEqual(uri.getPath(), "/goods/materialGoodsList")) {
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "fullUri.toString()");
                ActionManagerCompat.startJDGoodsStoryActivity(context, uri2, str2, str3, intValue);
            } else {
                ActionManagerCompat.startDataListActivity(context, str, str2, str3, intValue);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$SearchTabAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class SearchTabAction extends UriAction {
        private final String actionType = "searchTab";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return Intrinsics.areEqual(uri.getScheme(), "searchTab");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startSuperSearchResultActivity(context, uri.getQueryParameter("keyword"), uri.getHost(), null, null, null);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$TabAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class TabAction extends UriAction {
        private final String actionType = "tab";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return Intrinsics.areEqual(uri.getScheme(), "tab");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            EventBus eventBus = EventBus.getDefault();
            String host = uri.getHost();
            Intrinsics.checkNotNull(host);
            Intrinsics.checkNotNullExpressionValue(host, "uri.host!!");
            eventBus.post(new TabEvent(host));
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$SearchSpotAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class SearchSpotAction extends UriAction {
        private final String actionType = "tab";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return Intrinsics.areEqual(uri.getScheme(), "searchSpot");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            String str;
            boolean z;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("q");
            String queryParameter2 = uri.getQueryParameter("title");
            String queryParameter3 = uri.getQueryParameter("returnType");
            if (Intrinsics.areEqual(host, "all")) {
                str = "excludeQuickLink";
                z = false;
            } else {
                str = queryParameter3;
                z = true;
            }
            ActionManager.startSearchActivity(context, queryParameter, null, host, z, queryParameter2, str, null, null);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$PageUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class PageUriAction extends UriAction {
        private final String actionType = "page";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String str = "";
            if (UriActionUtils.INSTANCE.isCoolApkOrEmptyHost(uri)) {
                String path = uri.getPath();
                if (path != null) {
                    str = path;
                }
            } else {
                if (UriActionUtils.INSTANCE.isCoolMarketScheme(uri)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('/');
                    sb.append(uri.getAuthority());
                    String path2 = uri.getPath();
                    if (path2 != null) {
                        str = path2;
                    }
                    sb.append(str);
                    str = sb.toString();
                }
                return false;
            }
            switch (str.hashCode()) {
                case -2023810541:
                    if (str.equals("/openWxMiniProgram")) {
                        return true;
                    }
                    break;
                case -1990004378:
                    if (str.equals("/feed/replyList")) {
                        return true;
                    }
                    break;
                case -1890116338:
                    if (str.equals("/admin/allFeedList")) {
                        return true;
                    }
                    break;
                case -1886832795:
                    if (str.equals("/apk/manageList")) {
                        return true;
                    }
                    break;
                case -1878925859:
                    if (str.equals("/apk/appList")) {
                        return true;
                    }
                    break;
                case -1820669029:
                    if (str.equals("/apk/hotGameList")) {
                        return true;
                    }
                    break;
                case -1813693179:
                    if (str.equals("/member/hitHistoryList")) {
                        return true;
                    }
                    break;
                case -1782726483:
                    if (str.equals("/ershou/location")) {
                        return true;
                    }
                    break;
                case -1740164627:
                    if (str.equals("/user/dyhFollowList")) {
                        return true;
                    }
                    break;
                case -1729547509:
                    if (str.equals("/native/copyHeader")) {
                        return true;
                    }
                    break;
                case -1661818229:
                    if (str.equals("/native/userKey")) {
                        return true;
                    }
                    break;
                case -1484283111:
                    if (str.equals("/page/dataList")) {
                        return true;
                    }
                    break;
                case -1482310898:
                    if (str.equals("/main/updateList")) {
                        return true;
                    }
                    break;
                case -1395265468:
                    if (str.equals("/apk/digestList")) {
                        return true;
                    }
                    break;
                case -1234249997:
                    if (str.equals("/notification/list")) {
                        return true;
                    }
                    break;
                case -1200025995:
                    if (str.equals("/feed/writer")) {
                        return true;
                    }
                    break;
                case -1182591025:
                    if (str.equals("/apk/bizList")) {
                        return true;
                    }
                    break;
                case -1072927184:
                    if (str.equals("/user/myFollowList")) {
                        return true;
                    }
                    break;
                case -1056224192:
                    if (str.equals("/apk/recommendDayList")) {
                        return true;
                    }
                    break;
                case -1036525582:
                    if (str.equals("/apk/gameList")) {
                        return true;
                    }
                    break;
                case -913141542:
                    if (str.equals("/feed/myQaFeedList")) {
                        return true;
                    }
                    break;
                case -521276754:
                    if (str.equals("/feed/editorChoiceList")) {
                        return true;
                    }
                    break;
                case -493291010:
                    if (str.equals("/apk/categoryList")) {
                        return true;
                    }
                    break;
                case -382041911:
                    if (str.equals("/apk/updateList")) {
                        return true;
                    }
                    break;
                case -100265042:
                    if (str.equals("/account/bindEmail")) {
                        return true;
                    }
                    break;
                case 47:
                    if (str.equals("/")) {
                        return true;
                    }
                    break;
                case 13697545:
                    if (str.equals("/apk/hotList")) {
                        return true;
                    }
                    break;
                case 46838590:
                    if (str.equals("/page")) {
                        return true;
                    }
                    break;
                case 101592376:
                    if (str.equals("/account/login")) {
                        return true;
                    }
                    break;
                case 168618612:
                    if (str.equals("/account/register")) {
                        return true;
                    }
                    break;
                case 185094132:
                    if (str.equals("/apk/cpsGameList")) {
                        return true;
                    }
                    break;
                case 232023691:
                    if (str.equals("/product/categoryList")) {
                        return true;
                    }
                    break;
                case 304385090:
                    if (str.equals("/apk/giftGameList")) {
                        return true;
                    }
                    break;
                case 307400426:
                    if (str.equals("/collection/myCollectionList")) {
                        return true;
                    }
                    break;
                case 322765388:
                    if (str.equals("/native/networkDiagnosis")) {
                        return true;
                    }
                    break;
                case 350732357:
                    if (str.equals("/admin/yidunSpamList")) {
                        return true;
                    }
                    break;
                case 424646776:
                    if (str.equals("/apk/recommendList")) {
                        return true;
                    }
                    break;
                case 448576836:
                    if (str.equals("/native/about")) {
                        return true;
                    }
                    break;
                case 454362879:
                    if (str.equals("/user/myFansList")) {
                        return true;
                    }
                    break;
                case 580209494:
                    if (str.equals("/product/brandList")) {
                        return true;
                    }
                    break;
                case 601982103:
                    if (str.equals("/admin/allBlockFeedList")) {
                        return true;
                    }
                    break;
                case 682336426:
                    if (str.equals("/user/entityFollowTabList")) {
                        return true;
                    }
                    break;
                case 783381824:
                    if (str.equals("/apk/category")) {
                        return true;
                    }
                    break;
                case 787818208:
                    if (str.equals("/notification/commentMeList")) {
                        return true;
                    }
                    break;
                case 841244734:
                    if (str.equals("/notification/atMeList")) {
                        return true;
                    }
                    break;
                case 924313928:
                    if (str.equals("/appForum/mainActivity")) {
                        return true;
                    }
                    break;
                case 936544497:
                    if (str.equals("/member/recentHistoryList")) {
                        return true;
                    }
                    break;
                case 988689196:
                    if (str.equals("/apk/rankList")) {
                        return true;
                    }
                    break;
                case 1085481918:
                    if (str.equals("/message/newMessage")) {
                        return true;
                    }
                    break;
                case 1153961278:
                    if (str.equals("/native/testSettings")) {
                        return true;
                    }
                    break;
                case 1261228997:
                    if (str.equals("/native/intent")) {
                        return true;
                    }
                    break;
                case 1283614799:
                    if (str.equals("/user/userFollowList")) {
                        return true;
                    }
                    break;
                case 1291807548:
                    if (str.equals("/topic/quickList")) {
                        return true;
                    }
                    break;
                case 1417661136:
                    if (str.equals("/account/bindMobile")) {
                        return true;
                    }
                    break;
                case 1419201640:
                    if (str.equals("/user/cardManager")) {
                        return true;
                    }
                    break;
                case 1442004535:
                    if (str.equals("/notification/contactsFollowList")) {
                        return true;
                    }
                    break;
                case 1451331798:
                    if (str.equals("/ershou/ershouProductBrandList")) {
                        return true;
                    }
                    break;
                case 1451996337:
                    if (str.equals("/page/")) {
                        return true;
                    }
                    break;
                case 1453024302:
                    if (str.equals("/native/themePicker")) {
                        return true;
                    }
                    break;
                case 1485378614:
                    if (str.equals("/admin/aliSpamList")) {
                        return true;
                    }
                    break;
                case 1547737217:
                    if (str.equals("/topic/myFollowTopicList")) {
                        return true;
                    }
                    break;
                case 1549125520:
                    if (str.equals("/native/splash")) {
                        return true;
                    }
                    break;
                case 1581985328:
                    if (str.equals("/apk/giftList")) {
                        return true;
                    }
                    break;
                case 1620221430:
                    if (str.equals("/goods/couponSearch")) {
                        return true;
                    }
                    break;
                case 1689611622:
                    if (str.equals("/apk/newestList")) {
                        return true;
                    }
                    break;
                case 1724625676:
                    if (str.equals("/native/settings")) {
                        return true;
                    }
                    break;
                case 1804717741:
                    if (str.equals("/notification/atCommentMeList")) {
                        return true;
                    }
                    break;
                case 1895314807:
                    if (str.equals("/apk/developerAppList")) {
                        return true;
                    }
                    break;
                case 1929107936:
                    if (str.equals("/apk/list")) {
                        return true;
                    }
                    break;
                case 2030695832:
                    if (str.equals("/ershou/post")) {
                        return true;
                    }
                    break;
                case 2059280213:
                    if (str.equals("/message/list")) {
                        return true;
                    }
                    break;
                case 2070113041:
                    if (str.equals("/apk/topList")) {
                        return true;
                    }
                    break;
                case 2109210088:
                    if (str.equals("/notification/feedLikeList")) {
                        return true;
                    }
                    break;
            }
            return false;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Object obj;
            Object obj2;
            String str;
            int i;
            String str2;
            Activity activityNullable;
            Activity currentActivity;
            String str3;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            if (objArr != null) {
                obj = ArraysKt.getOrNull(objArr, 0);
            } else {
                obj = null;
            }
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str4 = (String) obj;
            if (objArr != null) {
                obj2 = ArraysKt.getOrNull(objArr, 1);
            } else {
                obj2 = null;
            }
            if (!(obj2 instanceof String)) {
                obj2 = null;
            }
            String str5 = (String) obj2;
            String str6 = "";
            if (UriActionUtils.INSTANCE.isCoolApkOrEmptyHost(uri)) {
                str = uri.getPath();
                if (str == null) {
                    str = str6;
                }
            } else if (UriActionUtils.INSTANCE.isCoolMarketScheme(uri)) {
                StringBuilder sb = new StringBuilder();
                sb.append('/');
                String authority = uri.getAuthority();
                if (authority == null) {
                    authority = str6;
                }
                sb.append(authority);
                String path = uri.getPath();
                if (path == null) {
                    path = str6;
                }
                sb.append(path);
                str = sb.toString();
            } else {
                return;
            }
            switch (str.hashCode()) {
                case -2023810541:
                    if (str.equals("/openWxMiniProgram") && BearStoryHelper.INSTANCE.isPearProgram(uri)) {
                        String queryParameter = uri.getQueryParameter("username");
                        String queryParameter2 = uri.getQueryParameter("path");
                        if (queryParameter2 != null) {
                            str6 = queryParameter2;
                        }
                        Uri parse = Uri.parse(str6);
                        if (Intrinsics.areEqual(String.valueOf(parse != null ? parse.getPath() : null), EncodeUtils.urlDecode(str6))) {
                            str6 = EncodeUtils.urlDecode(str6);
                            Intrinsics.checkNotNullExpressionValue(str6, "EncodeUtils.urlDecode(paramPath)");
                        }
                        if (queryParameter != null) {
                            ActionManagerCompat.INSTANCE.startWeChatMiniProgram(queryParameter, str6);
                            return;
                        }
                        return;
                    }
                    return;
                case -1990004378:
                    if (str.equals("/feed/replyList")) {
                        ActionManager.startFeedReplyDetailActivity(context, uri.getQueryParameter("id"));
                        return;
                    }
                    return;
                case -1890116338:
                    if (str.equals("/admin/allFeedList")) {
                        ActionManager.startAllFeedActivity(context);
                        return;
                    }
                    return;
                case -1886832795:
                    if (str.equals("/apk/manageList")) {
                        String queryParameter3 = uri.getQueryParameter("tab");
                        if (queryParameter3 != null) {
                            i = Integer.parseInt(queryParameter3);
                        } else {
                            i = -1;
                        }
                        ActionManager.startAppManagerActivity(context, i);
                        return;
                    }
                    return;
                case -1878925859:
                    if (!str.equals("/apk/appList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case -1820669029:
                    if (!str.equals("/apk/hotGameList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case -1813693179:
                    if (str.equals("/member/hitHistoryList")) {
                        SimpleActivity.builder(context).title(str4).fragmentClass(HistoryTimeV9Fragment.class).start();
                        return;
                    }
                    return;
                case -1782726483:
                    if (str.equals("/ershou/location")) {
                        XXPermissions permission = XXPermissions.with(context).permission("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
                        Intrinsics.checkNotNullExpressionValue(permission, "XXPermissions.with(conte…ion.ACCESS_FINE_LOCATION)");
                        LibraryExtentsKt.asObservable(permission).subscribe((Subscriber<? super Boolean>) new UriActionUtils$PageUriAction$takeAction$5(context));
                        return;
                    }
                    return;
                case -1740164627:
                    if (str.equals("/user/dyhFollowList")) {
                        ActionManager.startUserDyhFollowList(context, true);
                        return;
                    }
                    return;
                case -1729547509:
                    if (str.equals("/native/copyHeader")) {
                        DataManager instance = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                        DataConfig dataConfig = instance.getDataConfig();
                        Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
                        List<String> coolMarketHeaders = dataConfig.getCoolMarketHeaders();
                        Intrinsics.checkNotNullExpressionValue(coolMarketHeaders, "DataManager.getInstance(…aConfig.coolMarketHeaders");
                        StringUtils.copyText(context, CollectionsKt.joinToString$default(coolMarketHeaders, "\n", null, null, 0, null, null, 62, null));
                        Toast.show$default(context, "复制成功", 0, false, 12, null);
                        return;
                    }
                    return;
                case -1661818229:
                    if (str.equals("/native/userKey")) {
                        String queryParameter4 = uri.getQueryParameter("type");
                        if (queryParameter4 == null) {
                            queryParameter4 = str6;
                        }
                        String queryParameter5 = uri.getQueryParameter("code");
                        if (queryParameter5 != null) {
                            str6 = queryParameter5;
                        }
                        ActionManager.startUserKeyInputFragment(context, queryParameter4, str6);
                        return;
                    }
                    return;
                case -1484283111:
                    str2 = "url";
                    if (!str.equals("/page/dataList")) {
                        return;
                    }
                    SharpPageUriAction.INSTANCE.startWithRealUri(context, uri, objArr, uri.getQueryParameter(str2));
                    return;
                case -1482310898:
                    if (!str.equals("/main/updateList")) {
                        return;
                    }
                    ActionManager.startLatestListActivity(context, str4);
                    return;
                case -1395265468:
                    if (!str.equals("/apk/digestList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case -1234249997:
                    if (str.equals("/notification/list")) {
                        ActionManager.startNotificationActivity(context, 0);
                        return;
                    }
                    return;
                case -1200025995:
                    if (str.equals("/feed/writer") && (activityNullable = UiUtils.getActivityNullable(context)) != null) {
                        String queryParameter6 = uri.getQueryParameter("type");
                        String str7 = queryParameter6;
                        if (str7 == null || str7.length() == 0) {
                            ActionManager.startFeedEntranceV8Activity(activityNullable);
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "feed")) {
                            ActionManager.startNewFeedV8Activity(activityNullable);
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "picture")) {
                            ActionManager.startPhotoPickerToCoolPicActivity(activityNullable);
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "qrcode")) {
                            ActionManager.startQrcodeActivity(activityNullable);
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "share") || Intrinsics.areEqual(queryParameter6, "url")) {
                            ActionManager.startShareFeedV8Activity(activityNullable, str6);
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "article")) {
                            FeedUIConfig uiConfigForHtmlFeed = FeedArgsFactory.uiConfigForHtmlFeed(activityNullable);
                            FeedMultiPart.Builder multiPartForFeed = FeedArgsFactory.multiPartForFeed();
                            String urlDecode = EncodeUtils.urlDecode(uri.getQueryParameter("message"));
                            String queryParameter7 = uri.getQueryParameter("tag");
                            String str8 = urlDecode;
                            if (!(str8 == null || str8.length() == 0)) {
                                multiPartForFeed.message(urlDecode);
                            } else {
                                String str9 = queryParameter7;
                                if (!(str9 == null || str9.length() == 0)) {
                                    multiPartForFeed.message('#' + queryParameter7 + "# ");
                                }
                            }
                            ActionManager.startSubmitFeedV8Activity(activityNullable, uiConfigForHtmlFeed, multiPartForFeed.build());
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "question")) {
                            ActionManager.startQuestionTitleV8Activity(activityNullable);
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "topic")) {
                            String urlDecode2 = EncodeUtils.urlDecode(uri.getQueryParameter("message"));
                            String queryParameter8 = uri.getQueryParameter("tag");
                            String str10 = queryParameter8;
                            if (str10 == null || str10.length() == 0) {
                                String str11 = urlDecode2;
                                if (str11 == null || str11.length() == 0) {
                                    ActionManager.startPickTopicToWriteActivity(activityNullable);
                                    return;
                                }
                            }
                            String str12 = urlDecode2;
                            if (str12 == null || str12.length() == 0) {
                                urlDecode2 = '#' + queryParameter8 + '#';
                            }
                            ActionManager.startSubmitFeedV8Activity(activityNullable, FeedArgsFactory.uiConfigForFeed(activityNullable).build(), FeedArgsFactory.multiPartForFeed().message(urlDecode2 + ' ').build());
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "rating")) {
                            String queryParameter9 = uri.getQueryParameter("targetType");
                            String str13 = queryParameter9;
                            String str14 = (str13 == null || str13.length() == 0) ^ true ? queryParameter9 : null;
                            if (str14 == null) {
                                str14 = "product_phone";
                            }
                            Intrinsics.checkNotNullExpressionValue(str14, "uri.getQueryParameter(\"t…argetType.PRODUCT_PHONE }");
                            String queryParameter10 = uri.getQueryParameter("targetId");
                            String str15 = queryParameter10;
                            if (!(str15 == null || str15.length() == 0)) {
                                int hashCode = str14.hashCode();
                                if (hashCode != -309474065) {
                                    if (hashCode != 1382923806 || !str14.equals("product_phone")) {
                                        return;
                                    }
                                } else if (!str14.equals("product")) {
                                    return;
                                }
                                ActionManager.startSubmitFeedV8Activity(activityNullable, FeedArgsFactory.uiConfigForFeed(activityNullable).openKeyboardWhenInit(false).title("发点评").build(), FeedArgsFactory.multiPartForFeed().targetId(queryParameter10).targetType("product_phone").type("rating").build());
                                return;
                            }
                            return;
                        } else if (Intrinsics.areEqual(queryParameter6, "goods")) {
                            String queryParameter11 = uri.getQueryParameter("pickGoodsDialog");
                            UriActionUtils$PageUriAction$takeAction$1 uriActionUtils$PageUriAction$takeAction$1 = new UriActionUtils$PageUriAction$takeAction$1(activityNullable);
                            if (Intrinsics.areEqual(queryParameter11, "1")) {
                                FeedGoodsHelper.showAddGoodsDialog$default(FeedGoodsHelper.INSTANCE, context, null, new UriActionUtils$PageUriAction$takeAction$2(uriActionUtils$PageUriAction$takeAction$1), 2, null);
                                return;
                            } else {
                                uriActionUtils$PageUriAction$takeAction$1.invoke((FeedGoods) null);
                                return;
                            }
                        } else if (Intrinsics.areEqual(queryParameter6, "goodsList")) {
                            ActionManager.startCreateGoodsListActivity(activityNullable);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case -1182591025:
                    if (!str.equals("/apk/bizList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case -1072927184:
                    if (str.equals("/user/myFollowList")) {
                        DataManager instance2 = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                        LoginSession loginSession = instance2.getLoginSession();
                        Activity currentActivity2 = AppHolder.getCurrentActivity();
                        if (currentActivity2 != null) {
                            Boolean checkLogin = ActionManager.checkLogin(currentActivity2);
                            Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                            if (checkLogin.booleanValue()) {
                                Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                                ActionManager.startFriendListActivity(context, loginSession.getUid(), context.getString(2131887322));
                            }
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case -1056224192:
                    if (!str.equals("/apk/recommendDayList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case -1036525582:
                    if (!str.equals("/apk/gameList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case -913141542:
                    if (str.equals("/feed/myQaFeedList")) {
                        DataManager instance3 = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                        LoginSession loginSession2 = instance3.getLoginSession();
                        Activity currentActivity3 = AppHolder.getCurrentActivity();
                        if (currentActivity3 != null) {
                            Boolean checkLogin2 = ActionManager.checkLogin(currentActivity3);
                            Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                            if (checkLogin2.booleanValue()) {
                                Intrinsics.checkNotNullExpressionValue(loginSession2, "session");
                                ActionManager.startUserQAListActivity(context, loginSession2.getUid(), context.getString(2131887143));
                            }
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case -521276754:
                    if (str.equals("/feed/editorChoiceList")) {
                        ActionManager.startEditorChoiceActivity(context, str4);
                        return;
                    }
                    return;
                case -493291010:
                    if (str.equals("/apk/categoryList")) {
                        ActionManagerCompat.startAppCategoryActivity(context, uri.getQueryParameter("apkType"));
                        return;
                    }
                    return;
                case -382041911:
                    if (!str.equals("/apk/updateList")) {
                        return;
                    }
                    ActionManager.startLatestListActivity(context, str4);
                    return;
                case -100265042:
                    if (str.equals("/account/bindEmail")) {
                        ActionManager.startAccountSettingActivity(context, "https://account.coolapk.com/account/bind?type=email");
                        return;
                    }
                    return;
                case 47:
                    str.equals("/");
                    return;
                case 13697545:
                    if (!str.equals("/apk/hotList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 46838590:
                    if (!str.equals("/page")) {
                        return;
                    }
                    str2 = "url";
                    SharpPageUriAction.INSTANCE.startWithRealUri(context, uri, objArr, uri.getQueryParameter(str2));
                    return;
                case 101592376:
                    if (!str.equals("/account/login")) {
                        return;
                    }
                    if (!(context instanceof Activity) || !PrivacyAlertDialog.Companion.shouldShowByIntent()) {
                        ActionManager.startLoginActivity(context);
                        return;
                    }
                    PrivacyAlertDialog newInstance = PrivacyAlertDialog.Companion.newInstance();
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                    return;
                case 168618612:
                    if (!str.equals("/account/register")) {
                        return;
                    }
                    if (!(context instanceof Activity) || !PrivacyAlertDialog.Companion.shouldShowByIntent()) {
                        ActionManager.startRegisterActivity(context);
                        return;
                    }
                    PrivacyAlertDialog newInstance2 = PrivacyAlertDialog.Companion.newInstance();
                    FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "context.requireAppCompat…().supportFragmentManager");
                    newInstance2.show(supportFragmentManager2, (String) null);
                    return;
                case 185094132:
                    if (!str.equals("/apk/cpsGameList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 232023691:
                    if (str.equals("/product/categoryList")) {
                        String queryParameter12 = uri.getQueryParameter("id");
                        if (queryParameter12 != null) {
                            str6 = queryParameter12;
                        }
                        ActionManager.startDigitalCategoryListActivity(context, str6);
                        return;
                    }
                    return;
                case 304385090:
                    if (!str.equals("/apk/giftGameList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 307400426:
                    if (str.equals("/collection/myCollectionList") && (currentActivity = AppHolder.getCurrentActivity()) != null) {
                        Boolean checkLogin3 = ActionManager.checkLogin(currentActivity);
                        Intrinsics.checkNotNullExpressionValue(checkLogin3, "ActionManager.checkLogin(it)");
                        if (checkLogin3.booleanValue()) {
                            Activity activityNullable2 = UiUtils.getActivityNullable(context);
                            Intrinsics.checkNotNull(activityNullable2);
                            ActionManager.startCollectionListActivity(activityNullable2);
                        }
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 322765388:
                    if (str.equals("/native/networkDiagnosis")) {
                        ActionManager.startNetworkDiagnosisActivity(context);
                        return;
                    }
                    return;
                case 350732357:
                    if (str.equals("/admin/yidunSpamList")) {
                        ActionManager.startSpamActivity(context, 1);
                        return;
                    }
                    return;
                case 424646776:
                    if (!str.equals("/apk/recommendList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 448576836:
                    if (str.equals("/native/about")) {
                        ActionManager.startAboutActivity(context);
                        return;
                    }
                    return;
                case 454362879:
                    if (str.equals("/user/myFansList")) {
                        DataManager instance4 = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance4, "DataManager.getInstance()");
                        LoginSession loginSession3 = instance4.getLoginSession();
                        Activity currentActivity4 = AppHolder.getCurrentActivity();
                        if (currentActivity4 != null) {
                            Boolean checkLogin4 = ActionManager.checkLogin(currentActivity4);
                            Intrinsics.checkNotNullExpressionValue(checkLogin4, "ActionManager.checkLogin(it)");
                            if (checkLogin4.booleanValue()) {
                                Intrinsics.checkNotNullExpressionValue(loginSession3, "session");
                                ActionManager.startFansListActivity(context, loginSession3.getUid(), context.getString(2131887317));
                            }
                            Unit unit4 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case 580209494:
                    if (str.equals("/product/brandList")) {
                        ActionManager.startProductBrandListActivity(context);
                        return;
                    }
                    return;
                case 601982103:
                    if (str.equals("/admin/allBlockFeedList")) {
                        ActionManager.startAllBlockListActivity(context);
                        return;
                    }
                    return;
                case 682336426:
                    if (str.equals("/user/entityFollowTabList")) {
                        ActionManager.startUserFollowAppActivity(context, str6);
                        return;
                    }
                    return;
                case 783381824:
                    if (str.equals("/apk/category")) {
                        String queryParameter13 = uri.getQueryParameter("title");
                        String queryParameter14 = uri.getQueryParameter("catId");
                        String queryParameter15 = uri.getQueryParameter("tags");
                        List split$default = queryParameter15 != null ? StringsKt.split$default((CharSequence) queryParameter15, new String[]{","}, false, 0, 6, (Object) null) : null;
                        String queryParameter16 = uri.getQueryParameter("apkType");
                        String queryParameter17 = uri.getQueryParameter("index");
                        ActionManager.startAppCategoryActivity(context, AppCategory.create(queryParameter14, queryParameter13, split$default, queryParameter16), queryParameter17 != null ? Integer.parseInt(queryParameter17) : 0);
                        return;
                    }
                    return;
                case 787818208:
                    if (str.equals("/notification/commentMeList")) {
                        ActionManager.startNotificationActivity(context, 3);
                        return;
                    }
                    return;
                case 841244734:
                    if (str.equals("/notification/atMeList")) {
                        ActionManager.startNotificationActivity(context, 1);
                        return;
                    }
                    return;
                case 936544497:
                    if (str.equals("/member/recentHistoryList")) {
                        SimpleActivity.builder(context).title(str4).fragmentClass(RecentHistoryFragment.class).start();
                        return;
                    }
                    return;
                case 988689196:
                    if (str.equals("/apk/rankList")) {
                        ActionManager.startRankActivity(context);
                        return;
                    }
                    return;
                case 1085481918:
                    if (str.equals("/message/newMessage")) {
                        ActionManager.startChattingActivity(context, uri.getQueryParameter("uid"), uri.getQueryParameter("username"));
                        return;
                    }
                    return;
                case 1153961278:
                    if (str.equals("/native/testSettings")) {
                        ActionManager.startTestSettingsActivity(context);
                        return;
                    }
                    return;
                case 1261228997:
                    if (str.equals("/native/intent")) {
                        try {
                            context.startActivity(Intent.parseUri(uri.getQueryParameter("uri"), 0));
                            return;
                        } catch (Exception e) {
                            Toast.show$default(context, "打开失败了哦", 0, false, 12, null);
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 1283614799:
                    if (str.equals("/user/userFollowList")) {
                        String queryParameter18 = uri.getQueryParameter("uid");
                        if (queryParameter18 != null) {
                            str6 = queryParameter18;
                        }
                        String queryParameter19 = uri.getQueryParameter("title");
                        if (queryParameter19 != null) {
                            str4 = queryParameter19;
                        }
                        ActionManager.startFriendListActivity(context, str6, str4);
                        return;
                    }
                    return;
                case 1291807548:
                    if (str.equals("/topic/quickList")) {
                        String queryParameter20 = uri.getQueryParameter("quickType");
                        if (queryParameter20 != null) {
                            int hashCode2 = queryParameter20.hashCode();
                            if (hashCode2 != 3322014) {
                                if (hashCode2 == 113399775 && queryParameter20.equals("write")) {
                                    str3 = "ACTION_TYPE_WRITE";
                                    context.startActivity(new Intent(context, TopicPickerActivity.class).putExtra("KEY_ACTION_TYPE", str3));
                                    return;
                                }
                            } else if (queryParameter20.equals("list")) {
                                str3 = "ACTION_TYPE_LIST";
                                context.startActivity(new Intent(context, TopicPickerActivity.class).putExtra("KEY_ACTION_TYPE", str3));
                                return;
                            }
                        }
                        str3 = "ACTION_TYPE_RETURN";
                        context.startActivity(new Intent(context, TopicPickerActivity.class).putExtra("KEY_ACTION_TYPE", str3));
                        return;
                    }
                    return;
                case 1417661136:
                    if (str.equals("/account/bindMobile")) {
                        ActionManager.startAccountSettingActivity(context, "https://account.coolapk.com/account/bind?type=mobile");
                        return;
                    }
                    return;
                case 1419201640:
                    if (str.equals("/user/cardManager")) {
                        ActionManager.startCardManagerActivity(context);
                        return;
                    }
                    return;
                case 1442004535:
                    if (str.equals("/notification/contactsFollowList")) {
                        ActionManager.startNotificationActivity(context, 6);
                        return;
                    }
                    return;
                case 1451331798:
                    if (str.equals("/ershou/ershouProductBrandList")) {
                        ActionManager.startProductBrandListInErshouActivity(context, 3, 0);
                        return;
                    }
                    return;
                case 1451996337:
                    if (!str.equals("/page/")) {
                        return;
                    }
                    str2 = "url";
                    SharpPageUriAction.INSTANCE.startWithRealUri(context, uri, objArr, uri.getQueryParameter(str2));
                    return;
                case 1453024302:
                    if (str.equals("/native/themePicker")) {
                        ActionManager.startThemePickerActivity(context);
                        return;
                    }
                    return;
                case 1485378614:
                    if (str.equals("/admin/aliSpamList")) {
                        ActionManager.startSpamActivity(context, 0);
                        return;
                    }
                    return;
                case 1547737217:
                    if (str.equals("/topic/myFollowTopicList")) {
                        ActionManagerCompat.startDataListActivity$default(context, "#/topic/userFollowTagList", "我关注的话题", null, 0, 24, null);
                        return;
                    }
                    return;
                case 1549125520:
                    if (str.equals("/native/splash")) {
                        ActionManager.startSplashActivity(context, false);
                        return;
                    }
                    return;
                case 1581985328:
                    if (str.equals("/apk/giftList")) {
                        ActionManager.startGiftCenterActivity(context);
                        return;
                    }
                    return;
                case 1620221430:
                    if (str.equals("/goods/couponSearch")) {
                        Activity activityNullable3 = UiUtils.getActivityNullable(context);
                        if (activityNullable3 == null) {
                            activityNullable3 = AppHolder.getCurrentActivity();
                        }
                        if (activityNullable3 != null) {
                            ActionManager.startGoodsCouponSearchActivity(activityNullable3, uri.getQueryParameter("keyword"));
                            Unit unit5 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case 1689611622:
                    if (str.equals("/apk/newestList")) {
                        ActionManager.startNewestListActivity(context, str4);
                        return;
                    }
                    return;
                case 1724625676:
                    if (str.equals("/native/settings")) {
                        ActionManager.startV8SettingsActivity(context);
                        return;
                    }
                    return;
                case 1804717741:
                    if (str.equals("/notification/atCommentMeList")) {
                        ActionManager.startNotificationActivity(context, 2);
                        return;
                    }
                    return;
                case 1895314807:
                    if (!str.equals("/apk/developerAppList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 1929107936:
                    if (!str.equals("/apk/list")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 2030695832:
                    if (str.equals("/ershou/post")) {
                        StatisticHelper.Companion.getInstance().recordSecondHandChannelEvent("频道发布二手");
                        ActionManager.startNewSecondHandActivity(UiUtils.getActivityNullable(context));
                        return;
                    }
                    return;
                case 2059280213:
                    if (str.equals("/message/list")) {
                        ActionManager.startNotificationActivity(context, 4);
                        return;
                    }
                    return;
                case 2070113041:
                    if (!str.equals("/apk/topList")) {
                        return;
                    }
                    ActionManager.startRecommendAppListActivity(context, str4, str5, uri2, null);
                    return;
                case 2109210088:
                    if (str.equals("/notification/feedLikeList")) {
                        ActionManager.startNotificationActivity(context, 5);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$DeprecatedFeedUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class DeprecatedFeedUriAction extends UriAction {
        private final String actionType = "feed_d";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (!Intrinsics.areEqual(uri.getHost(), "faxian.coolapk.com") && !Intrinsics.areEqual(uri.getHost(), "play.coolapk.com")) {
                return false;
            }
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return StringsKt.endsWith$default(uri2, ".html", false, 2, (Object) null);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            ActionManagerCompat.startFeedDetailActivity$default(context, String.valueOf(UriUtils.getIdFromDeprecatedUrl(uri2)), null, null, null, 0, null, null, 252, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$DeprecatedUserUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class DeprecatedUserUriAction extends UriAction {
        private final String actionType = "u_d";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (!Intrinsics.areEqual(uri.getHost(), "faxian.coolapk.com") && !Intrinsics.areEqual(uri.getHost(), "play.coolapk.com")) {
                return false;
            }
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return !StringsKt.endsWith$default(uri2, ".html", false, 2, (Object) null);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            ActionManager.startUserSpaceActivity(context, String.valueOf(UriUtils.getIdFromDeprecatedUrl(uri2)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "pathKey", "", "getPathKey", "()Ljava/lang/String;", "regex", "Lkotlin/text/Regex;", "getRegex", "()Lkotlin/text/Regex;", "regex$delegate", "Lkotlin/Lazy;", "isThisAction", "", "uri", "Landroid/net/Uri;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static abstract class PathIdUriAction extends UriAction {
        private final Lazy regex$delegate = LazyKt.lazy(new UriActionUtils$PathIdUriAction$regex$2(this));

        public abstract String getPathKey();

        public final Regex getRegex() {
            return (Regex) this.regex$delegate.getValue();
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String str = "";
            if (UriActionUtils.INSTANCE.isCoolApkOrEmptyHost(uri)) {
                Regex regex = getRegex();
                String path = uri.getPath();
                if (path != null) {
                    str = path;
                }
                return regex.matches(str);
            } else if (!UriActionUtils.INSTANCE.isCoolMarketScheme(uri)) {
                return false;
            } else {
                Regex regex2 = getRegex();
                String schemeSpecificPart = uri.getSchemeSpecificPart();
                if (schemeSpecificPart == null) {
                    schemeSpecificPart = str;
                }
                if (!regex2.matches(schemeSpecificPart)) {
                    Regex regex3 = getRegex();
                    String path2 = uri.getPath();
                    if (path2 != null) {
                        str = path2;
                    }
                    if (!regex3.matches(str)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$UserUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class UserUriAction extends PathIdUriAction {
        private final String actionType = "u";
        private final String pathKey = "u";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startUserSpaceActivity(context, uri.getLastPathSegment());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$UserDetailUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class UserDetailUriAction extends UriAction {
        private final String actionType = "u";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return UriActionUtils.INSTANCE.isCoolMarketScheme(uri) && Intrinsics.areEqual(uri.getAuthority(), "userDetails");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startUserSpaceActivity(context, uri.getQueryParameter("id"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$LiveUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class LiveUriAction extends PathIdUriAction {
        private final String actionType = "live";
        private final String pathKey = "live";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null) {
                ActionManager.startLiveActivity(context, lastPathSegment);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$MainUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class MainUriAction extends UriAction {
        private final String actionType = "main";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String host = uri.getHost();
            if (!UriActionUtils.INSTANCE.isCoolMarketScheme(uri)) {
                return false;
            }
            if (!Intrinsics.areEqual(host, "www.coolapk.com") && !Intrinsics.areEqual(host, "com.coolapk.market")) {
                return false;
            }
            return Intrinsics.areEqual(uri.getLastPathSegment(), "main") || Intrinsics.areEqual(uri.getLastPathSegment(), "mainActivity");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            AppHolder instance = AppHolder.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "AppHolder.getInstance()");
            if (!instance.isMainActivityExist()) {
                ActionManager.startMainActivity(context);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$ProductUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class ProductUriAction extends PathIdUriAction {
        private final String actionType = "product";
        private final String pathKey = "product";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null) {
                ActionManager.startProductActivity(context, lastPathSegment);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$GoodsUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class GoodsUriAction extends PathIdUriAction {
        private final String actionType = "goods";
        private final String pathKey = "goods";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null) {
                Intrinsics.checkNotNullExpressionValue(lastPathSegment, "it");
                if (!(StringsKt.toIntOrNull(lastPathSegment) != null)) {
                    lastPathSegment = null;
                }
                if (lastPathSegment != null) {
                    Intrinsics.checkNotNullExpressionValue(lastPathSegment, "uri.lastPathSegment?.tak…ull() != null } ?: return");
                    ActionManagerCompat.startGoodsDetailActivity(context, lastPathSegment);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$PictureUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class PictureUriAction extends PathIdUriAction {
        private final String actionType = "picture";
        private final String pathKey = "picture";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String lastPathSegment = uri.getLastPathSegment();
            String queryParameter = uri.getQueryParameter("rid");
            String queryParameter2 = uri.getQueryParameter("noticeId");
            String queryParameter3 = uri.getQueryParameter("detailType");
            String queryParameter4 = uri.getQueryParameter("fromApi");
            if (lastPathSegment == null) {
                return;
            }
            if (queryParameter != null) {
                ActionManagerCompat.startFeedDetailActivity$default(context, lastPathSegment, queryParameter, queryParameter2, queryParameter3, 0, queryParameter4, null, 160, null);
            } else {
                ActionManager.startCoolPicActivity(context, lastPathSegment);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$TopicUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class TopicUriAction extends PathIdUriAction {
        private final String actionType = "t";
        private final String pathKey = "t";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String lastPathSegment = uri.getLastPathSegment();
            if (Intrinsics.areEqual(lastPathSegment, "二手交易")) {
                ActionManagerCompat.startDataListActivity$default(context, "V9_CHANNEL_ERSHOU", null, null, 0, 28, null);
            } else if (Intrinsics.areEqual(uri.getQueryParameter("type"), "8")) {
                ActionManager.startPictureCategoryDetailActivity(context, lastPathSegment);
            } else {
                ActionManager.startTopicFeedActivity(context, lastPathSegment);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$ApkUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class ApkUriAction extends PathIdUriAction {
        private final String actionType = "apk";
        private final String pathKey = "apk";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startAppViewActivity(context, uri.getLastPathSegment(), null, null, null, EntityExtendsKt.urlClientConfig(uri));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$GameUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class GameUriAction extends PathIdUriAction {
        private final String actionType = "game";
        private final String pathKey = "game";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startAppViewActivity(context, uri.getLastPathSegment(), null, null, null, EntityExtendsKt.urlClientConfig(uri));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$UserNameUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class UserNameUriAction extends PathIdUriAction {
        private final String actionType = "n";
        private final String pathKey = "n";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startUserSpaceActivity(context, uri.getLastPathSegment());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$FaXianUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class FaXianUriAction extends PathIdUriAction {
        private final String actionType = "faxian";
        private final String pathKey = "faxian";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startFeedDetailActivity(context, uri.getLastPathSegment(), uri.getQueryParameter("rid"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$AlbumUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class AlbumUriAction extends PathIdUriAction {
        private final String actionType = "album";
        private final String pathKey = "album";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startV8AlbumDetailActivity(context, uri.getLastPathSegment(), uri.getQueryParameter("rid"), 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$AppBarUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class AppBarUriAction extends PathIdUriAction {
        private final String actionType = "appba";
        private final String pathKey = "appba";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startAppForumActivity(context, uri.getLastPathSegment());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$GameBarUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class GameBarUriAction extends PathIdUriAction {
        private final String actionType = "gameba";
        private final String pathKey = "gameba";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startAppForumActivity(context, uri.getLastPathSegment());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$DyhUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class DyhUriAction extends PathIdUriAction {
        private final String actionType = "dyh";
        private final String pathKey = "dyh";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startDyhDetailActivity(context, uri.getLastPathSegment());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$DyhArticleUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class DyhArticleUriAction extends PathIdUriAction {
        private final String actionType = "dyhArticle";
        private final String pathKey = "dyhArticle";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String queryParameter = uri.getQueryParameter("id");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getLastPathSegment();
            }
            ActionManager.startDyhArticleDetailActivity(context, queryParameter);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$CollectionUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class CollectionUriAction extends PathIdUriAction {
        private final String actionType = "collection";
        private final String pathKey = "collection";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startCollectionDetailActivity(context, uri.getLastPathSegment());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$SimpleActivityUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class SimpleActivityUriAction extends PathIdUriAction {
        private final String actionType = "SimpleActivity";
        private final String pathKey = "SimpleActivity";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startSimpleActivityByName(context, uri.getLastPathSegment(), uri.getQueryParameter("title"), uri.getQueryParameter("key"), uri.getQueryParameter("value"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$ArticleUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class ArticleUriAction extends PathIdUriAction {
        private final String actionType = "article";
        private final String pathKey = "article";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            String queryParameter = uri.getQueryParameter("id");
            String queryParameter2 = uri.getQueryParameter("rid");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getLastPathSegment();
            }
            ActionManager.startDyhArticleDetailActivity(context, queryParameter, queryParameter2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$RedirectWebUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class RedirectWebUriAction extends PathIdUriAction {
        private final String actionType = "web";
        private final String pathKey = "r";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.PathIdUriAction
        public String getPathKey() {
            return this.pathKey;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startBrowserActivity(context, uri.toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$CoolApkWebUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class CoolApkWebUriAction extends UriAction {
        private final String actionType = "web";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String host = uri.getHost();
            return !(host == null || host.length() == 0) && UriActionUtils.INSTANCE.isCoolApkOrEmptyHost(uri);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (BearStoryHelper.isOuterBrowserUrl(uri)) {
                ActionManager.startView(context, uri, null);
            } else {
                ActionManager.startWebViewActivity(context, uri.toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$WebUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class WebUriAction extends UriAction {
        private final String actionType = "web";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return TextUtils.equals(uri.getScheme(), "http") || TextUtils.equals(uri.getScheme(), "https") || TextUtils.equals(uri.getScheme(), "ftp");
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startBrowserActivity(context, Uri.parse("https://www.coolapk.com/link").buildUpon().appendQueryParameter("url", uri.toString()).build().toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$ElseUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class ElseUriAction extends UriAction {
        private final String actionType = "else";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String scheme = uri.getScheme();
            return !(scheme == null || scheme.length() == 0) && !UriActionUtils.INSTANCE.isCoolMarketScheme(uri);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ActionManager.startIntentActivity(context, uri.toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$SellUriAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class SellUriAction extends UriAction {
        private final String actionType = "tbncm";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return BearStoryHelper.isBearStoryUrl(uri);
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            BearStoryHelper.INSTANCE.bearStoreUrlJump(context, uri);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$JDAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isThisAction", "", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class JDAction extends UriAction {
        public static final JDAction INSTANCE = new JDAction();
        private static final String actionType = "else";

        static {
            KeplerApiManager.asyncInitSdk(AppHolder.getApplication(), "8846824493ee6afa5f0211e574968907", "675eb946f34a4fd990689e64b5f90249", new AsyncInitListener() {
                /* class com.coolapk.market.util.UriActionUtils.JDAction.AnonymousClass1 */

                @Override // com.kepler.jd.Listener.AsyncInitListener
                public void onSuccess() {
                }

                @Override // com.kepler.jd.Listener.AsyncInitListener
                public void onFailure() {
                    LogUtils.e("Kepler, Kepler asyncInitSdk 授权失败，请检查 lib 工程资源引用;包名,签名证书是否和注册一致", new Object[0]);
                }
            });
        }

        private JDAction() {
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String host = uri.getHost();
            if (host != null) {
                return StringsKt.endsWith$default(host, "jd.com", false, 2, (Object) null);
            }
            return false;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            KeplerApiManager.getWebViewService().openAppWebViewPage(context, uri.toString(), new KeplerAttachParameter(), new UriActionUtils$JDAction$takeAction$openAppAction$1(context));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J+\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/util/UriActionUtils$DouYinAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "userAgent", "isDouYinInstalled", "", "isSupportOpenDouYin", "isThisAction", "uri", "Landroid/net/Uri;", "startDefault", "", "context", "Landroid/content/Context;", "takeAction", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UriActionUtils.kt */
    public static final class DouYinAction extends UriAction {
        private final String actionType = "else";
        private final String userAgent = "Mozilla/5.0 (Linux; Android 9; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/70.0.3538.110 Mobile Safari/537.36";

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public String getActionType() {
            return this.actionType;
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public boolean isThisAction(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return Intrinsics.areEqual(uri.getHost(), "v.douyin.com") && isSupportOpenDouYin() && isDouYinInstalled();
        }

        private final boolean isSupportOpenDouYin() {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            String optString = appSetting.getConfigJson().optString("Douyin.OpenVideoByDirect2", "");
            return Intrinsics.areEqual(optString, "1") || Intrinsics.areEqual(optString, "true");
        }

        private final boolean isDouYinInstalled() {
            try {
                Application application = AppHolder.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
                return application.getPackageManager().getPackageInfo("com.ss.android.ugc.aweme", 0) != null;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.coolapk.market.util.UriActionUtils.UriAction
        public void takeAction(Context context, Uri uri, Object[] objArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            Observable.timer(3, TimeUnit.SECONDS).map(UriActionUtils$DouYinAction$takeAction$1.INSTANCE).mergeWith(Observable.just(uri).map(new UriActionUtils$DouYinAction$takeAction$idLoader$1(this))).take(1).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new UriActionUtils$DouYinAction$takeAction$2(this, uri));
        }

        /* access modifiers changed from: private */
        public final void startDefault(Context context, Uri uri) {
            ActionManager.startBrowserActivity(context, uri.toString());
        }
    }

    public final void testUrl() {
        Class<?> cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("", null);
        linkedHashMap.put("/", "page");
        linkedHashMap.put("coolmarket://userDetails?id=390129", "u");
        linkedHashMap.put("coolmarket://feed/5274938", "feed");
        linkedHashMap.put("coolmarket://feed/5274938?rid=12345", "feed");
        linkedHashMap.put("coolmarket://apk/com.coolapk.market?rid=390129", "apk");
        linkedHashMap.put("coolmarket://afasfqwefadfas", null);
        linkedHashMap.put("coolmarket://admin/allFeedList", "page");
        linkedHashMap.put("tab://apk", "tab");
        linkedHashMap.put("searchTab://apk?keyword=王者荣耀", "searchTab");
        linkedHashMap.put("http://coolapk.com/u/10022", "u");
        linkedHashMap.put("https://coolapk.com/u/10022", "u");
        linkedHashMap.put("https://www.coolapk.com/u/10022", "u");
        linkedHashMap.put("https://m.coolapk.com/u/10022", "u");
        linkedHashMap.put("/u/10022", "u");
        linkedHashMap.put("/r/dfadfa", "web");
        linkedHashMap.put("/feed/5274938", "feed");
        linkedHashMap.put("/feed/replyList", "page");
        linkedHashMap.put("/picture/5274938", "picture");
        linkedHashMap.put("/picture/5274938?rid=234348", "picture");
        linkedHashMap.put("/t/今天酷市场V6发布了吗", "t");
        linkedHashMap.put("/t/二次元?type=8", "t");
        linkedHashMap.put("/apk/com.coolapk.market", "apk");
        linkedHashMap.put("/game/com.coolapk.market", "game");
        linkedHashMap.put("/n/liubaoyua", "n");
        linkedHashMap.put("/faxian/link/1190398", "faxian");
        linkedHashMap.put("/album/1190398", "album");
        linkedHashMap.put("/message/newMessage?uid=10022", "page");
        linkedHashMap.put("/admin/allFeedList", "page");
        linkedHashMap.put("/account/login", "page");
        linkedHashMap.put("/account/register", "page");
        linkedHashMap.put("/account/bindMobile", "page");
        linkedHashMap.put("/account/bindEmail", "page");
        linkedHashMap.put("/appba/com.coolapk.market", "appba");
        linkedHashMap.put("/gameba/com.coolapk.market", "gameba");
        linkedHashMap.put("/user/dyhFollowList", "page");
        linkedHashMap.put("/dyh/134132", "dyh");
        linkedHashMap.put("/dyhArticle/detail?id=1002?rid=15907558", "dyhArticle");
        linkedHashMap.put("/article/detail?id=1002?rid=15907558", "article");
        linkedHashMap.put("https://m.coolapk.com/xxxxx", "web");
        linkedHashMap.put("ftp://google.com/xxxxx", "web");
        linkedHashMap.put("http://google.com/xxxxx", "web");
        linkedHashMap.put("https://google.com/xxxxx", "web");
        linkedHashMap.put("original://google.com/xxxxx", "else");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
            UriAction findUriAction = findUriAction(parse);
            if (Intrinsics.areEqual(findUriAction != null ? findUriAction.getActionType() : null, str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("YES: type:");
                sb.append(str2);
                sb.append(", actionClass:");
                sb.append((findUriAction == null || (cls = findUriAction.getClass()) == null) ? null : cls.getSimpleName());
                sb.append(", url:");
                sb.append(str);
                LogUtils.w(sb.toString(), new Object[0]);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NO: type:");
                sb2.append(str2);
                sb2.append(", realType:");
                sb2.append(findUriAction != null ? findUriAction.getActionType() : null);
                sb2.append(", url:");
                sb2.append(str);
                LogUtils.w(sb2.toString(), new Object[0]);
            }
        }
    }
}
