package com.coolapk.market.view.demo;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.view.demo.DemoContract;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public class DemoPresenter extends DemoContract.Presenter {
    private static final String KEY_APK_TYPE = "DemoPresenter.APK_TYPE";
    private static final String TAG = "DemoPresenter";
    private String apkType;
    private final DemoContract.View view;

    public DemoPresenter(DemoContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.apkType = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getAppList(this.apkType, i, this.view.findFirstItem(), this.view.findLastItem()).flatMap(new Func1<Result<List<Entity>>, Observable<Result<List<Entity>>>>() {
            /* class com.coolapk.market.view.demo.DemoPresenter.AnonymousClass1 */

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

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        super.onInitPresenterState(bundle);
        if (bundle != null) {
            this.apkType = bundle.getString("DemoPresenter.APK_TYPE");
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("DemoPresenter.APK_TYPE", this.apkType);
    }
}
