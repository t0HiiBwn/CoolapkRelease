package com.coolapk.market.util.uri;

import android.content.Context;
import android.net.Uri;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.UriActionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/util/uri/FeedUriAction;", "Lcom/coolapk/market/util/UriActionUtils$PathIdUriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "pathKey", "getPathKey", "takeAction", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "any", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedUrlAction.kt */
public final class FeedUriAction extends UriActionUtils.PathIdUriAction {
    public static final Companion Companion = new Companion(null);
    private final String actionType = "feed";
    private final String pathKey = "(?:feed|discovery)";

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
        String queryParameter4 = uri.getQueryParameter("detailType");
        String queryParameter5 = uri.getQueryParameter("flags");
        if (queryParameter5 == null) {
            queryParameter5 = "";
        }
        Integer intOrNull = StringsKt.toIntOrNull(queryParameter5);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        String queryParameter6 = Intrinsics.areEqual(uri.getLastPathSegment(), "changeHistoryDetail") ? uri.getQueryParameter("id") : null;
        if (lastPathSegment != null) {
            ActionManagerCompat.startFeedDetailActivity(context, lastPathSegment, queryParameter, queryParameter2, queryParameter3, intValue, queryParameter4, queryParameter6);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/util/uri/FeedUriAction$Companion;", "", "()V", "buildUrl", "", "feed", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedUrlAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String buildUrl(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            String url = feed.getUrl();
            String str = "";
            if (url == null) {
                url = str;
            }
            Uri parse = Uri.parse(url);
            Uri.Builder appendQueryParameter = parse.buildUpon().appendQueryParameter("fromApi", feed.getExtraFromApi());
            if (EntityExtendsKt.isLoadFromHistoryApi(feed)) {
                String queryParameter = parse.getQueryParameter("flags");
                if (queryParameter != null) {
                    str = queryParameter;
                }
                Integer intOrNull = StringsKt.toIntOrNull(str);
                appendQueryParameter.appendQueryParameter("flags", String.valueOf((intOrNull != null ? intOrNull.intValue() : 0) | 32));
            }
            String uri = appendQueryParameter.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "source.buildUpon()\n     …      .build().toString()");
            return uri;
        }
    }
}
