package com.coolapk.market.view.app;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.app.RelatedAppsContract;
import java.util.List;
import rx.Observable;

public class RelatedAppsPresenter extends RelatedAppsContract.Presenter {
    private final String keyword;
    private final RelatedAppsContract.View view;

    public RelatedAppsPresenter(RelatedAppsContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.keyword = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAppListWithKeyword(this.keyword, "0", i, this.view.findFirstItem(), this.view.findLastItem());
    }
}
