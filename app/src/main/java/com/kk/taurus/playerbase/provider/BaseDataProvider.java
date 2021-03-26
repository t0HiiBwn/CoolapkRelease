package com.kk.taurus.playerbase.provider;

import android.os.Bundle;
import com.kk.taurus.playerbase.provider.IDataProvider;

public abstract class BaseDataProvider implements IDataProvider {
    private IDataProvider.OnProviderListener mOnProviderListener;

    @Override // com.kk.taurus.playerbase.provider.IDataProvider
    public final void setOnProviderListener(IDataProvider.OnProviderListener onProviderListener) {
        this.mOnProviderListener = onProviderListener;
    }

    protected final void onProviderDataStart() {
        IDataProvider.OnProviderListener onProviderListener = this.mOnProviderListener;
        if (onProviderListener != null) {
            onProviderListener.onProviderDataStart();
        }
    }

    protected final void onProviderMediaDataSuccess(Bundle bundle) {
        IDataProvider.OnProviderListener onProviderListener = this.mOnProviderListener;
        if (onProviderListener != null) {
            onProviderListener.onProviderDataSuccess(-77001, bundle);
        }
    }

    protected final void onProviderExtraDataSuccess(int i, Bundle bundle) {
        IDataProvider.OnProviderListener onProviderListener = this.mOnProviderListener;
        if (onProviderListener != null) {
            onProviderListener.onProviderDataSuccess(i, bundle);
        }
    }

    protected final void onProviderMediaDataError(Bundle bundle) {
        IDataProvider.OnProviderListener onProviderListener = this.mOnProviderListener;
        if (onProviderListener != null) {
            onProviderListener.onProviderError(-77003, bundle);
        }
    }

    protected final void onProviderError(int i, Bundle bundle) {
        IDataProvider.OnProviderListener onProviderListener = this.mOnProviderListener;
        if (onProviderListener != null) {
            onProviderListener.onProviderError(i, bundle);
        }
    }
}
