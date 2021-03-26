package com.tencent.android.tpns.mqtt.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleCatalog extends MessageCatalog {
    private ResourceBundle bundle = ResourceBundle.getBundle("com.tencent.android.tpns.mqtt.internal.nls.messages");

    @Override // com.tencent.android.tpns.mqtt.internal.MessageCatalog
    protected String getLocalizedMessage(int i) {
        try {
            return this.bundle.getString(Integer.toString(i));
        } catch (MissingResourceException unused) {
            return "MqttException";
        }
    }
}
