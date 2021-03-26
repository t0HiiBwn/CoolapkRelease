package com.coolapk.market.view.feedv8.util;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.view.SourceWebView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;
import rx.functions.Cancellable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012Z\u0010\u0002\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004 \u0006**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "emitter", "Lrx/Emitter;", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$loadHtmlSourceCodeFromUrl$1<T> implements Action1<Emitter<Pair<? extends String, ? extends String>>> {
    final /* synthetic */ String $url;

    FeedGoodsHelper$loadHtmlSourceCodeFromUrl$1(String str) {
        this.$url = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Pair<? extends String, ? extends String>> emitter) {
        call((Emitter<Pair<String, String>>) emitter);
    }

    public final void call(final Emitter<Pair<String, String>> emitter) {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        final SourceWebView sourceWebView = new SourceWebView(application, null);
        sourceWebView.loadUrl(this.$url);
        sourceWebView.setCallback(new SourceWebView.SourceCallback() {
            /* class com.coolapk.market.view.feedv8.util.FeedGoodsHelper$loadHtmlSourceCodeFromUrl$1.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.Emitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.coolapk.market.widget.view.SourceWebView.SourceCallback
            public void showSource(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "url");
                Intrinsics.checkNotNullParameter(str2, "html");
                emitter.onNext(TuplesKt.to(str, str2));
                sourceWebView.setCallback(null);
                emitter.onCompleted();
            }
        });
        emitter.setCancellation(new Cancellable() {
            /* class com.coolapk.market.view.feedv8.util.FeedGoodsHelper$loadHtmlSourceCodeFromUrl$1.AnonymousClass2 */

            @Override // rx.functions.Cancellable
            public final void cancel() {
                sourceWebView.setCallback(null);
                sourceWebView.destroy();
            }
        });
    }
}
