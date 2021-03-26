package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BasePresenter;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

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
