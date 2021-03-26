package com.umeng.cconfig;

public class RemoteConfigSettings {
    private final boolean autoUpdateConfig;

    private RemoteConfigSettings(Builder builder) {
        this.autoUpdateConfig = builder.autoUpdateConfig;
    }

    public boolean isAutoUpdateModeEnabled() {
        return this.autoUpdateConfig;
    }

    public static class Builder {
        private boolean autoUpdateConfig = false;

        public Builder setAutoUpdateModeEnabled(boolean z) {
            this.autoUpdateConfig = z;
            return this;
        }

        public RemoteConfigSettings build() {
            return new RemoteConfigSettings(this);
        }
    }
}
