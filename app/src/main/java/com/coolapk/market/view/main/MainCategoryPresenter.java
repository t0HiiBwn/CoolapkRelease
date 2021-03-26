package com.coolapk.market.view.main;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.main.MainCategoryContract;
import java.util.List;
import rx.Observable;

public class MainCategoryPresenter extends MainCategoryContract.Presenter {
    String apkType;

    public MainCategoryPresenter(MainCategoryContract.View view, String str) {
        super(view);
        this.apkType = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAppCategoryList(this.apkType);
    }
}
