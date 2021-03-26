package com.kk.taurus.playerbase.provider;

import android.os.Bundle;
import com.kk.taurus.playerbase.entity.DataSource;

public interface IDataProvider {
    public static final int PROVIDER_CODE_DATA_PROVIDER_ERROR = -77003;
    public static final int PROVIDER_CODE_SUCCESS_MEDIA_DATA = -77001;

    public interface OnProviderListener {
        void onProviderDataStart();

        void onProviderDataSuccess(int i, Bundle bundle);

        void onProviderError(int i, Bundle bundle);
    }

    void cancel();

    void destroy();

    void handleSourceData(DataSource dataSource);

    void setOnProviderListener(OnProviderListener onProviderListener);
}
