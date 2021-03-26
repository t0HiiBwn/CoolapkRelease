package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemPickServiceAppBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.Map;

public class ServicePickAppViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558863;
    private Map<String, AlbumItem> commitApps;
    private ServiceApp serviceApp;

    public ServicePickAppViewHolder(View view, DataBindingComponent dataBindingComponent, Map<String, AlbumItem> map, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemPickServiceAppBinding itemPickServiceAppBinding = (ItemPickServiceAppBinding) getBinding();
        ViewUtil.clickListener(itemPickServiceAppBinding.itemView, this);
        this.commitApps = map;
        itemPickServiceAppBinding.itemView.setOnLongClickListener(this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        if (EntityUtils.isApkType(((Entity) obj).getEntityType())) {
            this.serviceApp = (ServiceApp) obj;
            ItemPickServiceAppBinding itemPickServiceAppBinding = (ItemPickServiceAppBinding) getBinding();
            itemPickServiceAppBinding.setApp(this.serviceApp);
            itemPickServiceAppBinding.executePendingBindings();
            itemPickServiceAppBinding.apkInfoView.setText(getContext().getString(2131886910, this.serviceApp.getScore(), this.serviceApp.getApkSizeFormat()));
            itemPickServiceAppBinding.marketInfoView.setText(getContext().getString(2131886912, this.serviceApp.getFollowCount(), this.serviceApp.getCommentCount(), this.serviceApp.getDownCount()));
            return;
        }
        throw new RuntimeException("Binding error! data should be apkType card");
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        return isEventBelongTo(event, this.serviceApp);
    }
}
