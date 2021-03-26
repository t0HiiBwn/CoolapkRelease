package com.coolapk.market.view.node;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/node/AppNodeLoader;", "Lcom/coolapk/market/view/node/Loader;", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "(Landroid/app/Activity;Landroid/content/Intent;)V", "getActivity", "()Landroid/app/Activity;", "appUniqueId", "", "extraAnalysisData", "getIntent", "()Landroid/content/Intent;", "requestContext", "checkIdentity", "", "loadData", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "loadingPlaceHolderRes", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
public final class AppNodeLoader implements Loader {
    private final Activity activity;
    private String appUniqueId;
    private final String extraAnalysisData;
    private final Intent intent;
    private final String requestContext;

    public AppNodeLoader(Activity activity2, Intent intent2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(intent2, "intent");
        this.activity = activity2;
        this.intent = intent2;
        this.extraAnalysisData = intent2.getStringExtra("EXTRA_ANALYSIS_DATA");
        this.requestContext = intent2.getStringExtra("EXTRA_REQUEST_CONTEXT");
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    @Override // com.coolapk.market.view.node.Loader
    public int loadingPlaceHolderRes() {
        return AppHolder.getAppTheme().isDarkTheme() ? 2131230839 : 2131230840;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b  */
    @Override // com.coolapk.market.view.node.Loader
    public boolean checkIdentity() {
        String str;
        String stringExtra = this.intent.getStringExtra("APP_UNIQUE_ID");
        if (TextUtils.isEmpty(stringExtra)) {
            String str2 = null;
            Uri data = this.intent.getData();
            if (data != null) {
                String scheme = data.getScheme();
                if (TextUtils.equals("package", scheme)) {
                    stringExtra = data.getPath();
                } else if (TextUtils.equals("market", scheme)) {
                    String host = data.getHost();
                    if (TextUtils.equals("details", host)) {
                        stringExtra = data.getQueryParameter("id");
                    } else if (TextUtils.equals("search", host)) {
                        String queryParameter = data.getQueryParameter("q");
                        if (queryParameter != null && StringsKt.startsWith$default(queryParameter, "pname:", false, 2, (Object) null)) {
                            stringExtra = queryParameter.substring(6);
                            Intrinsics.checkNotNullExpressionValue(stringExtra, "(this as java.lang.String).substring(startIndex)");
                        } else if (queryParameter != null) {
                            str = queryParameter;
                            if (TextUtils.isEmpty(str)) {
                                ActionManager.startSuperSearchResultActivity(this.activity, str, "all", null, null, null);
                                this.activity.finish();
                                return false;
                            } else if (TextUtils.isEmpty(stringExtra)) {
                                Toast.show(this.activity, 2131887250);
                                this.activity.finish();
                                return false;
                            }
                        }
                    }
                }
            }
            str = str2;
            if (TextUtils.isEmpty(str)) {
            }
        }
        this.appUniqueId = stringExtra;
        return true;
    }

    @Override // com.coolapk.market.view.node.Loader
    public Observable<Result<Entity>> loadData() {
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(this.appUniqueId);
        Observable<R> map = DataManager.getInstance().getAppDetail(this.appUniqueId, (mobileAppExistFast == null || !mobileAppExistFast.isExist()) ? 0 : 1, this.extraAnalysisData, this.requestContext).map(AppNodeLoader$loadData$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…       .map { it.cast() }");
        return map;
    }
}
