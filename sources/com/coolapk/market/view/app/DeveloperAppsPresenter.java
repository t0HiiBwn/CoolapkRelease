package com.coolapk.market.view.app;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.app.DeveloperAppsContract;
import java.util.List;
import rx.Observable;

public class DeveloperAppsPresenter extends DeveloperAppsContract.Presenter {
    private final String developer;
    private final DeveloperAppsContract.View view;

    public DeveloperAppsPresenter(DeveloperAppsContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.developer = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<ServiceApp>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAppListWithDeveloper(this.developer, i, this.view.findFirstItem(), this.view.findLastItem());
    }
}
