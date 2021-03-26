package com.coolapk.market.view.feedv8;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pic", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleRatingContentHolder.kt */
final class ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ List $modelList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1(List list) {
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
        Intrinsics.checkNotNullParameter(str, "pic");
        for (String str2 : StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank(str2)) {
                this.$modelList.add(new ArticleImage(str2, ""));
                this.$modelList.add(new ArticleText(""));
            }
        }
    }
}
