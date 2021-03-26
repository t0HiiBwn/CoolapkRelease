package com.tencent.android.tpns.mqtt.internal;

public abstract class MessageCatalog {
    private static MessageCatalog INSTANCE;

    protected abstract String getLocalizedMessage(int i);

    public static final String getMessage(int i) {
        if (INSTANCE == null) {
            if (ExceptionHelper.isClassAvailable("java.util.ResourceBundle")) {
                try {
                    INSTANCE = (MessageCatalog) Class.forName("com.tencent.android.tpns.mqtt.internal.ResourceBundleCatalog").newInstance();
                } catch (Throwable unused) {
                    return "";
                }
            } else if (ExceptionHelper.isClassAvailable("com.tencent.android.tpns.mqtt.internal.MIDPCatalog")) {
                try {
                    INSTANCE = (MessageCatalog) Class.forName("com.tencent.android.tpns.mqtt.internal.MIDPCatalog").newInstance();
                } catch (Throwable unused2) {
                    return "";
                }
            }
        }
        return INSTANCE.getLocalizedMessage(i);
    }
}
