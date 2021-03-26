package com.coolapk.market.view.feedv8;

import android.app.ProgressDialog;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/SubmitFeedV8Activity$requestLoadProductPhoneTitleLogo$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
public final class SubmitFeedV8Activity$requestLoadProductPhoneTitleLogo$1 extends EmptySubscriber<Entity> {
    final /* synthetic */ ProgressDialog $pDialog;
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$requestLoadProductPhoneTitleLogo$1(SubmitFeedV8Activity submitFeedV8Activity, ProgressDialog progressDialog) {
        this.this$0 = submitFeedV8Activity;
        this.$pDialog = progressDialog;
    }

    public void onNext(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "t");
        super.onNext((SubmitFeedV8Activity$requestLoadProductPhoneTitleLogo$1) entity);
        SubmitFeedV8Activity submitFeedV8Activity = this.this$0;
        FeedUIConfig.Builder newBuilder = submitFeedV8Activity.getUiConfig().newBuilder();
        String logo = entity.getLogo();
        String str = "";
        if (logo == null) {
            logo = str;
        }
        FeedUIConfig.Builder relativeLogo = newBuilder.relativeLogo(logo);
        String title = entity.getTitle();
        if (title != null) {
            str = title;
        }
        FeedUIConfig build = relativeLogo.relativeTitle(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "uiConfig.newBuilder().re…                 .build()");
        submitFeedV8Activity.uiConfig = build;
        SubmitFeedV8Activity.access$getContentHolder$p(this.this$0).notifyUIChange$presentation_coolapkAppRelease();
        this.$pDialog.dismiss();
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.getActivity(), th);
        this.$pDialog.dismiss();
    }
}
