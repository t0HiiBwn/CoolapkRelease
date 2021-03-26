package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.s.bf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;
    private IShareSearch a;

    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i);

        void onDrivingRouteShareUrlSearched(String str, int i);

        void onLocationShareUrlSearched(String str, int i);

        void onNaviShareUrlSearched(String str, int i);

        void onPoiShareUrlSearched(String str, int i);

        void onWalkRouteShareUrlSearched(String str, int i);
    }

    public ShareSearch(Context context) {
        if (this.a == null) {
            try {
                this.a = new bf(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public static class ShareNaviQuery {
        private ShareFromAndTo a;
        private int b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.a;
        }

        public int getNaviMode() {
            return this.b;
        }
    }

    public static class ShareWalkRouteQuery {
        private ShareFromAndTo a;
        private int b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public int getWalkMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.a;
        }
    }

    public static class ShareDrivingRouteQuery {
        private ShareFromAndTo a;
        private int b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public int getDrivingMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.a;
        }
    }

    public static class ShareBusRouteQuery {
        private ShareFromAndTo a;
        private int b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public int getBusMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.a;
        }
    }

    public static class ShareFromAndTo {
        private LatLonPoint a;
        private LatLonPoint b;
        private String c = "起点";
        private String d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        public void setFromName(String str) {
            this.c = str;
        }

        public void setToName(String str) {
            this.d = str;
        }

        public LatLonPoint getFrom() {
            return this.a;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public String getFromName() {
            return this.c;
        }

        public String getToName() {
            return this.d;
        }
    }
}
