package com.coolapk.market.util.uri;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriActionUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/util/uri/TaoBaoAction;", "Lcom/coolapk/market/util/UriActionUtils$UriAction;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "isInitialized", "", "taobaoDomain", "", "[Ljava/lang/String;", "isThisAction", "uri", "Landroid/net/Uri;", "takeAction", "", "context", "Landroid/content/Context;", "any", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TaoBaoAction.kt */
public final class TaoBaoAction extends UriActionUtils.UriAction {
    public static final TaoBaoAction INSTANCE = new TaoBaoAction();
    private static final String actionType = "else";
    private static boolean isInitialized;
    private static final String[] taobaoDomain = {"taobao.com", "tmall.com"};

    private TaoBaoAction() {
    }

    @Override // com.coolapk.market.util.UriActionUtils.UriAction
    public String getActionType() {
        return actionType;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.coolapk.market.util.UriActionUtils.UriAction
    public boolean isThisAction(Uri uri) {
        boolean z;
        String str;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (isInitialized) {
            String host = uri.getHost();
            if (host != null) {
                String[] strArr = taobaoDomain;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    str = null;
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArr[i];
                    Intrinsics.checkNotNullExpressionValue(host, "host");
                    if (StringsKt.endsWith$default(host, str2, false, 2, (Object) null)) {
                        str = str2;
                        break;
                    }
                    i++;
                }
                if (str != null) {
                    z = true;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return false;
    }

    @Override // com.coolapk.market.util.UriActionUtils.UriAction
    public void takeAction(Context context, Uri uri, Object[] objArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        AlibcShowParams alibcShowParams = new AlibcShowParams();
        alibcShowParams.setOpenType(OpenType.Auto);
        alibcShowParams.setClientType("taobao");
        alibcShowParams.setBackUrl("coolmarket://");
        alibcShowParams.setNativeOpenFailedMode(AlibcFailModeType.AlibcNativeFailModeJumpH5);
        AlibcTaokeParams alibcTaokeParams = new AlibcTaokeParams("", "", "");
        alibcTaokeParams.setPid("mm_1465930019_2104250368_110940950195");
        AlibcTrade.openByUrl(UiUtils.getActivityNullable(context), "", uri.toString(), null, new WebViewClient(), new WebChromeClient(), alibcShowParams, alibcTaokeParams, new HashMap(), new TaoBaoAction$takeAction$1(context, uri));
    }
}
