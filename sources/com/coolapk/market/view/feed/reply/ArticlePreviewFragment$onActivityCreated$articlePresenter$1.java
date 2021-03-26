package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.Entity;
import com.coolapk.market.view.feed.article.ArticlePresenter;
import com.coolapk.market.view.feedv8.ArticleModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/coolapk/market/view/feed/reply/ArticlePreviewFragment$onActivityCreated$articlePresenter$1", "Lcom/coolapk/market/view/feed/article/ArticlePresenter;", "articleModelList", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "getArticleModelList", "()Ljava/util/List;", "urlEntityMap", "", "", "Lcom/coolapk/market/model/Entity;", "getUrlEntityMap", "()Ljava/util/Map;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticlePreviewFragment.kt */
public final class ArticlePreviewFragment$onActivityCreated$articlePresenter$1 implements ArticlePresenter {
    final /* synthetic */ Map $entityMap;
    final /* synthetic */ ArticlePreviewFragment this$0;

    ArticlePreviewFragment$onActivityCreated$articlePresenter$1(ArticlePreviewFragment articlePreviewFragment, Map map) {
        this.this$0 = articlePreviewFragment;
        this.$entityMap = map;
    }

    @Override // com.coolapk.market.view.feed.article.ArticlePresenter
    public List<ArticleModel> getArticleModelList() {
        return this.this$0.getArticleModelList();
    }

    @Override // com.coolapk.market.view.feed.article.ArticlePresenter
    public Map<String, Entity> getUrlEntityMap() {
        return this.$entityMap;
    }
}
