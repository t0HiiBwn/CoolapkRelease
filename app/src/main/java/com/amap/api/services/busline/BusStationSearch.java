package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.av;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

public class BusStationSearch {
    private IBusStationSearch a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        if (this.a == null) {
            try {
                this.a = new av(context, busStationQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void searchBusStationAsyn() {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }

    public BusStationQuery getQuery() {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }
}
