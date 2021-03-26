package com.coolapk.market.view.dyhv8.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.UriUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleSourceViewPart.kt */
final class DyhArticleSourceViewPart$onBindToContent$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ DyhArticle $data;
    final /* synthetic */ DyhArticleSourceViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhArticleSourceViewPart$onBindToContent$1(DyhArticleSourceViewPart dyhArticleSourceViewPart, DyhArticle dyhArticle) {
        super(1);
        this.this$0 = dyhArticleSourceViewPart;
        this.$data = dyhArticle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        if (!TextUtils.isEmpty(this.$data.getRawUrl())) {
            String rawUrl = this.$data.getRawUrl();
            Intrinsics.checkNotNull(rawUrl);
            Intrinsics.checkNotNullExpressionValue(rawUrl, "data.rawUrl!!");
            if (UriUtils.isInAppUrl(rawUrl)) {
                Context context = this.this$0.getContext();
                String rawUrl2 = this.$data.getRawUrl();
                Intrinsics.checkNotNull(rawUrl2);
                ActionManagerCompat.startActivityByUrl$default(context, rawUrl2, null, null, 12, null);
                return;
            }
        }
        ActionManager.startDyhArticleDetailActivity(this.this$0.getContext(), this.$data.getId());
    }
}
