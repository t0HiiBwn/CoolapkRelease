package com.coolapk.market.view.feedv8.article;

import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleViewModel.kt */
final class ArticleViewModel$insertNotTextPart$1 extends Lambda implements Function1<List<ArticleModel>, Unit> {
    final /* synthetic */ List $articleImages;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleViewModel$insertNotTextPart$1(List list) {
        super(1);
        this.$articleImages = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ArticleModel> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ArticleModel> list) {
        int i;
        Intrinsics.checkNotNullParameter(list, "it");
        ListIterator<ArticleModel> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (!(listIterator.previous() instanceof ArticleNative)) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        list.addAll(i + 1, this.$articleImages);
    }
}
