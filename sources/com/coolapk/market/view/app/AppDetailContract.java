package com.coolapk.market.view.app;

import android.content.pm.PackageManager;
import com.coolapk.market.model.PermissionItem;
import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import java.util.List;

public class AppDetailContract {

    public interface Presenter extends BasePresenter {
        List<PermissionItem> getPermissionList();

        void loadPermission(List<String> list, PackageManager packageManager);
    }

    public interface View extends BaseView {
        void onLoadPermissionComplete(List<PermissionItem> list, Throwable th);
    }
}
