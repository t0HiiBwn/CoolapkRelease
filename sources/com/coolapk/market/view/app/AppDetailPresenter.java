package com.coolapk.market.view.app;

import android.content.pm.PackageManager;
import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.PermissionItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.app.AppDetailContract;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;

public class AppDetailPresenter implements AppDetailContract.Presenter {
    private static final String KEY_DATA = "DATA";
    private ArrayList<PermissionItem> permissionList;
    private AppDetailContract.View view;

    public AppDetailPresenter(AppDetailContract.View view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.app.AppDetailContract.Presenter
    public void loadPermission(List<String> list, PackageManager packageManager) {
        DataManager.getInstance().getPermissionList(list, packageManager).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<List<PermissionItem>>() {
            /* class com.coolapk.market.view.app.AppDetailPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AppDetailPresenter.this.view.onLoadPermissionComplete(null, th);
            }

            public void onNext(List<PermissionItem> list) {
                AppDetailPresenter.this.permissionList = new ArrayList(list);
                AppDetailPresenter.this.view.onLoadPermissionComplete(list, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AppDetailContract.Presenter
    public List<PermissionItem> getPermissionList() {
        return this.permissionList;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.permissionList = bundle.getParcelableArrayList("DATA");
        }
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("DATA", this.permissionList);
    }
}
