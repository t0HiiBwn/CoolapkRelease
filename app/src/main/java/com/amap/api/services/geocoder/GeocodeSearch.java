package com.amap.api.services.geocoder;

import android.content.Context;
import com.amap.api.col.s.az;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

public final class GeocodeSearch {
    public static final String AMAP = "autonavi";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final String GPS = "gps";
    private IGeocodeSearch a;

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(Context context) {
        if (this.a == null) {
            try {
                this.a = new az(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            return iGeocodeSearch.getFromLocation(regeocodeQuery);
        }
        return null;
    }

    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            return iGeocodeSearch.getFromLocationName(geocodeQuery);
        }
        return null;
    }

    public final void setOnGeocodeSearchListener(OnGeocodeSearchListener onGeocodeSearchListener) {
        IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.setOnGeocodeSearchListener(onGeocodeSearchListener);
        }
    }

    public final void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.getFromLocationAsyn(regeocodeQuery);
        }
    }

    public final void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.getFromLocationNameAsyn(geocodeQuery);
        }
    }
}
