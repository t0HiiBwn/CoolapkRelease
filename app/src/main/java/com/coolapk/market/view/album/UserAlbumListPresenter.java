package com.coolapk.market.view.album;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.main.AlbumListContract;
import java.util.List;
import rx.Observable;

public class UserAlbumListPresenter extends AlbumListContract.Presenter {
    private static final String KEY_UID = "UID";
    private String uid;
    private final AlbumListContract.View view;

    public UserAlbumListPresenter(AlbumListContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.uid = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getUserAlbumList(this.uid, i, this.view.findFirstItem(), this.view.findLastItem());
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        super.onInitPresenterState(bundle);
        if (bundle != null) {
            this.uid = bundle.getString("UID");
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("UID", this.uid);
    }
}
