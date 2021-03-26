package com.coolapk.market.view.app;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.app.RelatedAlbumsContract;
import java.util.List;
import rx.Observable;

public class RelatedAlbumsPresenter extends RelatedAlbumsContract.Presenter {
    private final String keyword;
    private final RelatedAlbumsContract.View view;

    public RelatedAlbumsPresenter(RelatedAlbumsContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.keyword = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAlbumList(this.keyword, i, this.view.findFirstItem(), this.view.findLastItem());
    }
}
