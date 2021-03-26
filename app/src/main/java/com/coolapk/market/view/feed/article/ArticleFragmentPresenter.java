package com.coolapk.market.view.feed.article;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feed.reply.FeedArticleDetailFragment;
import com.coolapk.market.view.feedv8.ArticleModel;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00118VX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "Lcom/coolapk/market/view/feed/article/ArticlePresenter;", "fragment", "Lcom/coolapk/market/view/feed/reply/FeedArticleDetailFragment;", "(Lcom/coolapk/market/view/feed/reply/FeedArticleDetailFragment;)V", "articleModelList", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "getArticleModelList", "()Ljava/util/List;", "articleModelList$delegate", "Lkotlin/Lazy;", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "urlEntityMap", "", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "getUrlEntityMap", "()Ljava/util/Map;", "urlEntityMap$delegate", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleFragmentPresenter.kt */
public final class ArticleFragmentPresenter implements ArticlePresenter {
    private final Lazy articleModelList$delegate = LazyKt.lazy(new ArticleFragmentPresenter$articleModelList$2(this));
    private final FeedArticleDetailFragment fragment;
    private final Lazy urlEntityMap$delegate = LazyKt.lazy(new ArticleFragmentPresenter$urlEntityMap$2(this));

    @Override // com.coolapk.market.view.feed.article.ArticlePresenter
    public List<ArticleModel> getArticleModelList() {
        return (List) this.articleModelList$delegate.getValue();
    }

    @Override // com.coolapk.market.view.feed.article.ArticlePresenter
    public Map<String, Entity> getUrlEntityMap() {
        return (Map) this.urlEntityMap$delegate.getValue();
    }

    public ArticleFragmentPresenter(FeedArticleDetailFragment feedArticleDetailFragment) {
        Intrinsics.checkNotNullParameter(feedArticleDetailFragment, "fragment");
        this.fragment = feedArticleDetailFragment;
    }

    public final Feed getFeed() {
        return this.fragment.getFeed$presentation_coolapkAppRelease();
    }
}
