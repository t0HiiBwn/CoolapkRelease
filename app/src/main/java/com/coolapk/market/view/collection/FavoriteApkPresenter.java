package com.coolapk.market.view.collection;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.view.demo.DemoContract;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public class FavoriteApkPresenter extends DemoContract.Presenter {
    private String type;
    private final DemoContract.View view;

    public FavoriteApkPresenter(DemoContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.type = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getFavoriteList(this.type, i, this.view.findFirstItem(), this.view.findLastItem()).flatMap(new Func1<Result<List<Entity>>, Observable<Result<List<Entity>>>>() {
            /* class com.coolapk.market.view.collection.FavoriteApkPresenter.AnonymousClass1 */

            public Observable<Result<List<Entity>>> call(Result<List<Entity>> result) {
                List<Entity> data = result.getData();
                if (data != null) {
                    for (int size = data.size() - 1; size >= 0; size--) {
                        if (!EntityUtils.isApkType(data.get(size).getEntityType())) {
                            data.remove(size);
                        }
                    }
                }
                return Observable.just(result);
            }
        });
    }
}
