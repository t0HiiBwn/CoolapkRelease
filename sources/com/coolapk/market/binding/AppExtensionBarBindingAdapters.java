package com.coolapk.market.binding;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.AppExtensionBar;

public class AppExtensionBarBindingAdapters {
    public static void setViewModel(AppExtensionBar appExtensionBar, ServiceApp serviceApp) {
        appExtensionBar.setServiceApp(serviceApp);
    }
}
