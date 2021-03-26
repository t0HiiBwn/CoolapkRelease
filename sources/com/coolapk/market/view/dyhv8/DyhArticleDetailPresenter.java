package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bJ\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleDetailPresenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "view", "Lcom/coolapk/market/view/dyhv8/DyhArticleDetailView;", "(Lcom/coolapk/market/model/DyhArticle;Lcom/coolapk/market/view/dyhv8/DyhArticleDetailView;)V", "<set-?>", "getDyhArticle", "()Lcom/coolapk/market/model/DyhArticle;", "isPostingFavorite", "", "isPostingFollow", "isPostingLike", "getView", "()Lcom/coolapk/market/view/dyhv8/DyhArticleDetailView;", "favoriteDyhAarticle", "", "isFavoriting", "followAuthor", "isFollowing", "likeFeed", "isLiking", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "updateDyhArticle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailPresenter.kt */
public final class DyhArticleDetailPresenter implements BasePresenter {
    private DyhArticle dyhArticle;
    private boolean isPostingFavorite;
    private boolean isPostingFollow;
    private boolean isPostingLike;
    private final DyhArticleDetailView view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public DyhArticleDetailPresenter(DyhArticle dyhArticle2, DyhArticleDetailView dyhArticleDetailView) {
        Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
        Intrinsics.checkNotNullParameter(dyhArticleDetailView, "view");
        this.view = dyhArticleDetailView;
        this.dyhArticle = dyhArticle2;
    }

    public final DyhArticleDetailView getView() {
        return this.view;
    }

    public final DyhArticle getDyhArticle() {
        return this.dyhArticle;
    }

    public final void updateDyhArticle(DyhArticle dyhArticle2) {
        Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
        this.dyhArticle = dyhArticle2;
        this.view.onDyhArticleUpdate(dyhArticle2);
    }

    public final void likeFeed(boolean z) {
        if (!this.isPostingLike) {
            this.isPostingLike = true;
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhArticleDetailPresenter$likeFeed$1(this)).compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new DyhArticleDetailPresenter$likeFeed$2(this, z));
        }
    }

    public final void favoriteDyhAarticle(boolean z) {
        if (!this.isPostingFavorite) {
            this.isPostingFavorite = true;
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhArticleDetailPresenter$favoriteDyhAarticle$1(this.dyhArticle.getId())).compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new DyhArticleDetailPresenter$favoriteDyhAarticle$2(this, z));
        }
    }

    public final void followAuthor(boolean z) {
        if (!this.isPostingFollow) {
            this.isPostingFollow = true;
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhArticleDetailPresenter$followAuthor$1(this.dyhArticle.getDyhId())).compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new DyhArticleDetailPresenter$followAuthor$2(this, z));
        }
    }
}
