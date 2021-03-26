package com.coolapk.market.view.appmanager;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.view.appmanager.DownloadManagerContract;
import java.util.List;
import rx.Observable;

public class DownloadManagerPresenter extends DownloadManagerContract.Presenter {
    public DownloadManagerPresenter(DownloadManagerContract.View view) {
        super(view);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<List<DownloadInfo>> onCreateRequest(boolean z, int i) {
        return Observable.just(DataManager.getInstance().getDownloadInfoList());
    }
}
