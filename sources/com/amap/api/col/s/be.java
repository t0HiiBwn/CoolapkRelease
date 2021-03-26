package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: RouteSearchCore */
public final class be implements IRouteSearch {
    private RouteSearch.OnRouteSearchListener a;
    private RouteSearch.OnTruckRouteSearchListener b;
    private RouteSearch.OnRoutePlanSearchListener c;
    private Context d;
    private Handler e = s.a();

    public be(Context context) {
        this.d = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            q.a(this.d);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(walkRouteQuery.getFromAndTo())) {
                ag.a().b(walkRouteQuery.getFromAndTo());
                RouteSearch.WalkRouteQuery clone = walkRouteQuery.clone();
                WalkRouteResult walkRouteResult = (WalkRouteResult) new ap(this.d, clone).b();
                if (walkRouteResult != null) {
                    walkRouteResult.setWalkQuery(clone);
                }
                return walkRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "RouteSearch", "calculateWalkRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.be.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    try {
                        walkRouteResult = be.this.calculateWalkRoute(walkRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = be.this.a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        be.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = be.this.a;
                    bundle.putParcelable("result", walkRouteResult);
                    obtainMessage.setData(bundle);
                    be.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            q.a(this.d);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(busRouteQuery.getFromAndTo())) {
                RouteSearch.BusRouteQuery clone = busRouteQuery.clone();
                BusRouteResult busRouteResult = (BusRouteResult) new c(this.d, clone).b();
                if (busRouteResult != null) {
                    busRouteResult.setBusQuery(clone);
                }
                return busRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "RouteSearch", "calculateBusRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.be.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    try {
                        busRouteResult = be.this.calculateBusRoute(busRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = be.this.a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        be.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = be.this.a;
                    bundle.putParcelable("result", busRouteResult);
                    obtainMessage.setData(bundle);
                    be.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            q.a(this.d);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(driveRouteQuery.getFromAndTo())) {
                ag.a().a(driveRouteQuery.getPassedByPoints());
                ag.a().b(driveRouteQuery.getAvoidpolygons());
                RouteSearch.DriveRouteQuery clone = driveRouteQuery.clone();
                DriveRouteResult driveRouteResult = (DriveRouteResult) new m(this.d, clone).b();
                if (driveRouteResult != null) {
                    driveRouteResult.setDriveQuery(clone);
                }
                return driveRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "RouteSearch", "calculateDriveRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.be.AnonymousClass3 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    try {
                        driveRouteResult = be.this.calculateDriveRoute(driveRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = be.this.a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        be.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = be.this.a;
                    bundle.putParcelable("result", driveRouteResult);
                    obtainMessage.setData(bundle);
                    be.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    private static boolean a(RouteSearch.FromAndTo fromAndTo) {
        if (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.be.AnonymousClass4 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    try {
                        rideRouteResult = be.this.calculateRideRoute(rideRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = be.this.a;
                        bundle.putParcelable("result", rideRouteResult);
                        obtainMessage.setData(bundle);
                        be.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = be.this.a;
                    bundle.putParcelable("result", rideRouteResult);
                    obtainMessage.setData(bundle);
                    be.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            q.a(this.d);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(rideRouteQuery.getFromAndTo())) {
                ag.a().a(rideRouteQuery.getFromAndTo());
                RouteSearch.RideRouteQuery clone = rideRouteQuery.clone();
                RideRouteResult rideRouteResult = (RideRouteResult) new ai(this.d, clone).b();
                if (rideRouteResult != null) {
                    rideRouteResult.setRideQuery(clone);
                }
                return rideRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "RouteSearch", "calculaterideRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            q.a(this.d);
            if (truckRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(truckRouteQuery.getFromAndTo())) {
                ag.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
                ag.a().a(truckRouteQuery.getPassedByPoints());
                RouteSearch.TruckRouteQuery clone = truckRouteQuery.clone();
                TruckRouteRestult truckRouteRestult = (TruckRouteRestult) new ao(this.d, clone).b();
                if (truckRouteRestult != null) {
                    truckRouteRestult.setTruckQuery(clone);
                }
                return truckRouteRestult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "RouteSearch", "calculateDriveRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.be.AnonymousClass5 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.what = 104;
                    obtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestult = null;
                    try {
                        truckRouteRestult = be.this.calculateTruckRoute(truckRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = be.this.b;
                        bundle.putParcelable("result", truckRouteRestult);
                        obtainMessage.setData(bundle);
                        be.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = be.this.b;
                    bundle.putParcelable("result", truckRouteRestult);
                    obtainMessage.setData(bundle);
                    be.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            q.a(this.d);
            if (drivePlanQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(drivePlanQuery.getFromAndTo())) {
                DriveRoutePlanResult driveRoutePlanResult = (DriveRoutePlanResult) new l(this.d, drivePlanQuery.clone()).b();
                if (driveRoutePlanResult != null) {
                    driveRoutePlanResult.setDrivePlanQuery(drivePlanQuery);
                }
                return driveRoutePlanResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            i.a(e2, "RouteSearch", "calculateDrivePlan");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(final RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.be.AnonymousClass6 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.what = 105;
                    obtainMessage.arg1 = 18;
                    Bundle bundle = new Bundle();
                    DriveRoutePlanResult driveRoutePlanResult = null;
                    try {
                        driveRoutePlanResult = be.this.calculateDrivePlan(drivePlanQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = be.this.c;
                        bundle.putParcelable("result", driveRoutePlanResult);
                        obtainMessage.setData(bundle);
                        be.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = be.this.c;
                    bundle.putParcelable("result", driveRoutePlanResult);
                    obtainMessage.setData(bundle);
                    be.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }
}
