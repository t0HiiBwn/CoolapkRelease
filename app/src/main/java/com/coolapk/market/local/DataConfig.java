package com.coolapk.market.local;

import android.content.Context;
import android.os.Bundle;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Response;

public abstract class DataConfig {
    public abstract String getApiEndpoint();

    public abstract String getApiHost();

    public abstract Context getApplicationContext();

    public abstract String getCacheDir();

    public abstract String getCookieCharset();

    public abstract String getCookieDomain();

    public abstract String getCookiePath();

    public abstract List<String> getCoolMarketHeaders();

    public abstract String getDatabaseName();

    public abstract int getDatabaseVersion();

    public abstract Bundle getMetaData();

    public abstract String getPreferencesName();

    public abstract Map<String, String> getSpecialHosts();

    public abstract String getUserAgent();

    public abstract boolean isDebugEnabled();

    public abstract void onNetworkResponse(Response response) throws IOException;

    public abstract void requestChangeApiHost();
}
