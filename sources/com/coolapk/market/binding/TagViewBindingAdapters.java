package com.coolapk.market.binding;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.TagView;

public class TagViewBindingAdapters {
    public static void setTagListFromServiceApp(TagView tagView, ServiceApp serviceApp) {
        tagView.setTagListFromServiceApp(serviceApp);
    }
}
