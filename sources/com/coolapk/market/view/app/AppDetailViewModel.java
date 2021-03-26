package com.coolapk.market.view.app;

import android.content.Context;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.PermissionItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.app.AppDetailContract;
import java.util.List;

public class AppDetailViewModel extends BaseObservable {
    private final Context context;
    private final DeveloperCard developerCard;
    private final AppDetailContract.Presenter presenter;
    private final RelatedAlbumCard relatedAlbumCard;
    private final RelatedAppCard relatedAppCard;
    private final ServiceApp serviceApp;

    public AppDetailViewModel(Context context2, ServiceApp serviceApp2, AppDetailContract.Presenter presenter2) {
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.serviceApp = serviceApp2;
        this.presenter = presenter2;
        this.developerCard = new DeveloperCard(applicationContext, serviceApp2);
        this.relatedAppCard = new RelatedAppCard(applicationContext, serviceApp2);
        this.relatedAlbumCard = new RelatedAlbumCard(applicationContext, serviceApp2);
    }

    @Bindable
    public ServiceApp getServiceApp() {
        return this.serviceApp;
    }

    @Bindable
    public DeveloperCard getDeveloperCard() {
        return this.developerCard;
    }

    @Bindable
    public RelatedAppCard getRelatedAppCard() {
        return this.relatedAppCard;
    }

    @Bindable
    public RelatedAlbumCard getRelatedAlbumCard() {
        return this.relatedAlbumCard;
    }

    public void notifyDataChanged() {
        notifyPropertyChanged(242);
        notifyPropertyChanged(219);
        notifyPropertyChanged(146);
        notifyPropertyChanged(218);
        notifyPropertyChanged(179);
        notifyPropertyChanged(69);
        notifyPropertyChanged(231);
        notifyPropertyChanged(230);
    }

    @Bindable
    public String getPermissionString() {
        List<PermissionItem> permissionList = this.presenter.getPermissionList();
        if (permissionList == null) {
            return null;
        }
        if (permissionList.isEmpty()) {
            return this.context.getString(2131886889);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(permissionList.size(), 5); i++) {
            CharSequence label = permissionList.get(i).label();
            if (sb.length() != 0) {
                sb.append('\n');
            }
            sb.append(label);
        }
        return sb.toString();
    }

    @Bindable
    public boolean isHasPermission() {
        return !CollectionUtils.isEmpty(this.serviceApp.getPermissions());
    }

    @Bindable
    public int getPermissionCount() {
        return StringUtils.safeNum(this.serviceApp.getPermissions());
    }

    @Bindable
    public String getLastUpdateFormat() {
        if (getServiceApp() != null) {
            return DateUtils.getTimeDescription(this.context, getServiceApp().getLastUpdate());
        }
        return null;
    }
}
