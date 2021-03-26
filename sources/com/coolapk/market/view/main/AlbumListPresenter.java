package com.coolapk.market.view.main;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.main.AlbumListContract;
import java.util.List;
import rx.Observable;

public class AlbumListPresenter extends AlbumListContract.Presenter {
    private String type;
    private AlbumListContract.View view;

    public AlbumListPresenter(AlbumListContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.type = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAlbumList(i, this.view.findFirstItem(), this.view.findLastItem(), this.type);
    }
}
