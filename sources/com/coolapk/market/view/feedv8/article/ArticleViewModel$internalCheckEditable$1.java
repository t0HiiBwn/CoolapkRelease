package com.coolapk.market.view.feedv8.article;

import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.view.feedv8.ArticleText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"checkItem", "", "start", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleViewModel.kt */
final class ArticleViewModel$internalCheckEditable$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List $modelList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleViewModel$internalCheckEditable$1(List list) {
        super(1);
        this.$modelList = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i <= 0) {
            invoke(1);
        } else if (i != this.$modelList.size()) {
            ArticleModel articleModel = (ArticleModel) this.$modelList.get(i);
            int i2 = i - 1;
            ArticleModel articleModel2 = (ArticleModel) this.$modelList.get(i2);
            boolean z = articleModel2 instanceof ArticleText;
            if (z && (articleModel instanceof ArticleText)) {
                this.$modelList.set(i2, new ArticleText(((ArticleText) articleModel2).getText() + '\n' + ((ArticleText) articleModel).getText()));
                this.$modelList.remove(i);
                invoke(i);
            } else if (!z && !(articleModel instanceof ArticleText)) {
                this.$modelList.add(i, new ArticleText(""));
                invoke(i + 2);
            } else if (i != this.$modelList.size() - 1 || (articleModel instanceof ArticleText) || (articleModel instanceof ArticleNative)) {
                invoke(i + 1);
            } else {
                this.$modelList.add(i + 1, new ArticleText(""));
            }
        }
    }
}
