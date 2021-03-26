package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleModel;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleRatingContentHolder.kt */
final class ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ List $modelList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1(List list) {
        super(1);
        this.$modelList = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke(str);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        if (this.$modelList.size() <= 0 || ((ArticleModel) CollectionsKt.last((List<? extends Object>) this.$modelList)).getType() != ArticleModel.Type.Text) {
            this.$modelList.add(new ArticleText(str));
            return;
        }
        List list = this.$modelList;
        int size = list.size() - 1;
        StringBuilder sb = new StringBuilder();
        Object last = CollectionsKt.last((List<? extends Object>) this.$modelList);
        if (!(last instanceof ArticleText)) {
            last = null;
        }
        ArticleText articleText = (ArticleText) last;
        Intrinsics.checkNotNull(articleText);
        String text = articleText.getText();
        Objects.requireNonNull(text, "null cannot be cast to non-null type kotlin.CharSequence");
        sb.append(StringsKt.trim((CharSequence) text).toString());
        sb.append("\n\n");
        sb.append(StringsKt.trim((CharSequence) str).toString());
        String sb2 = sb.toString();
        Objects.requireNonNull(sb2, "null cannot be cast to non-null type kotlin.CharSequence");
        list.set(size, new ArticleText(StringsKt.trim((CharSequence) sb2).toString()));
    }
}
