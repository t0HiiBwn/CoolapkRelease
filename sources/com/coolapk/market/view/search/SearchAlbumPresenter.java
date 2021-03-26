package com.coolapk.market.view.search;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.main.AlbumListContract;
import com.coolapk.market.view.search.SearchAlbumContract;
import java.util.List;
import rx.Observable;

public class SearchAlbumPresenter extends SearchAlbumContract.Presenter {
    private final String keyword;
    private final AlbumListContract.View view;

    public SearchAlbumPresenter(AlbumListContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.keyword = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAlbumList(this.keyword, i, this.view.findFirstItem(), this.view.findLastItem());
    }

    @Override // com.coolapk.market.view.search.SearchAlbumContract.Presenter
    public String getKeyword() {
        return this.keyword;
    }
}
