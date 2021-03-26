package com.amap.api.maps2d;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.interfaces.IAMap;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import java.util.List;

public final class AMap {
    public static final String CHINESE = "zh_cn";
    public static final String ENGLISH = "en";
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    private final IAMap a;
    private UiSettings b;
    private Projection c;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public static String getVersion() {
        return "6.0.0";
    }

    protected AMap(IAMap iAMap) {
        this.a = iAMap;
    }

    private IAMap a() {
        return this.a;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return a().getCameraPosition();
        } catch (RemoteException e) {
            cm.a(e, "AMap", "getCameraPosition");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        return a().getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return a().getMinZoomLevel();
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            a().moveCamera(cameraUpdate);
        } catch (Throwable th) {
            cm.a(th, "AMap", "moveCamera");
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            a().animateCamera(cameraUpdate);
        } catch (Throwable th) {
            cm.a(th, "AMap", "animateCamera");
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            a().animateCameraWithCallback(cameraUpdate, cancelableCallback);
        } catch (Throwable th) {
            cm.a(th, "AMap", "animateCamera");
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        if (j <= 0) {
            try {
                Log.w("AMap", "durationMs must be positive");
            } catch (Throwable th) {
                cm.a(th, "AMap", "animateCamera");
                return;
            }
        }
        a().animateCameraWithDurationAndCallback(cameraUpdate, j, cancelableCallback);
    }

    public final void stopAnimation() {
        try {
            a().stopAnimation();
        } catch (Throwable th) {
            cm.a(th, "AMap", "stopAnimation");
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return a().addPolyline(polylineOptions);
        } catch (Throwable th) {
            cm.a(th, "AMap", "addPolyline");
            return null;
        }
    }

    public final Text addText(TextOptions textOptions) {
        try {
            return this.a.addText(textOptions);
        } catch (Throwable th) {
            cm.a(th, "AMap", "addText");
            return null;
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return a().addCircle(circleOptions);
        } catch (Throwable th) {
            cm.a(th, "AMap", "addCircle");
            return null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return a().addPolygon(polygonOptions);
        } catch (Throwable th) {
            cm.a(th, "AMap", "addPolygon");
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return a().addMarker(markerOptions);
        } catch (Throwable th) {
            cm.a(th, "AMap", "addMarker");
            return null;
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return a().addGroundOverlay(groundOverlayOptions);
        } catch (Throwable th) {
            cm.a(th, "AMap", "addGroundOverlay");
            return null;
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return a().addTileOverlay(tileOverlayOptions);
        } catch (RemoteException e) {
            cm.a(e, "AMap", "addtileOverlay");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            if (a() != null) {
                a().clear();
            }
        } catch (RemoteException e) {
            cm.a(e, "AMap", "clear");
            throw new RuntimeRemoteException(e);
        } catch (Throwable th) {
            cm.a(th, "AMap", "clear");
        }
    }

    public final int getMapType() {
        try {
            return a().getMapType();
        } catch (RemoteException e) {
            cm.a(e, "AMap", "getMapType");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            a().setMapType(i);
        } catch (RemoteException e) {
            cm.a(e, "AMap", "setMapType");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationRotateAngle(float f) {
        try {
            this.a.setMyLocationRotateAngle(f);
        } catch (RemoteException e) {
            cm.a(e, "AMap", "setMyLocationRoteteAngle");
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return a().isTrafficEnabled();
        } catch (RemoteException e) {
            cm.a(e, "AMap", "isTrafficEnable");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTrafficEnabled(boolean z) {
        try {
            a().setTrafficEnabled(z);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setTradficEnabled");
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return a().isMyLocationEnabled();
        } catch (Throwable th) {
            cm.a(th, "AMap", "isMyLocationEnabled");
            return false;
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            a().setMyLocationEnabled(z);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setMyLocationEnabled");
        }
    }

    public final Location getMyLocation() {
        try {
            return a().getMyLocation();
        } catch (Throwable th) {
            cm.a(th, "AMap", "getMyLocation");
            return null;
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            a().setLocationSource(locationSource);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setLocationSource");
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            a().setMyLocationStyle(myLocationStyle);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setMyLocationStyle");
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.b == null) {
                this.b = a().getAMapUiSettings();
            }
            return this.b;
        } catch (Throwable th) {
            cm.a(th, "AMap", "getUiSettings");
            return null;
        }
    }

    public final Projection getProjection() {
        try {
            if (this.c == null) {
                this.c = a().getAMapProjection();
            }
            return this.c;
        } catch (Throwable th) {
            cm.a(th, "AMap", "getProjection");
            return null;
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            a().setOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnCameraChangeListener");
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            a().setOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMapClickListener");
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.a.setOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMapTouchListener");
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            a().setOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMyLocaitonChangeListener");
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            a().setOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMapLongClickListener");
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            a().setOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMarkerClickListener");
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            a().setOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMarkerDragListener");
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            a().setOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnInfoWindowClickListener");
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            a().setInfoWindowAdapter(infoWindowAdapter);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setInfoWindowAdapter");
        }
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            a().setOnMaploadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setOnMapLoadedListener");
        }
    }

    public void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        a().getMapScreenShot(onMapScreenShotListener);
        invalidate();
    }

    public float getScalePerPixel() {
        return a().getScalePerPixel();
    }

    public final List<Marker> getMapScreenMarkers() {
        try {
            return this.a.getMapScreenMarkers();
        } catch (Throwable th) {
            cm.a(th, "AMap", "getMapScreenaMarkers");
            return null;
        }
    }

    public void postInvalidate() {
        a().AMapInvalidate();
    }

    public void invalidate() {
        postInvalidate();
    }

    public void setMapLanguage(String str) {
        try {
            this.a.setMapLanguage(str);
        } catch (Throwable th) {
            cm.a(th, "AMap", "setMapLanguage");
        }
    }

    public void removecache() {
        try {
            this.a.removecache();
        } catch (Throwable th) {
            cm.a(th, "AMap", "removecache");
        }
    }

    public void removecache(OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.a.removecache(onCacheRemoveListener);
        } catch (Throwable th) {
            cm.a(th, "AMap", "removecache");
        }
    }

    public final void setMyLocationType(int i) {
        try {
            a().setMyLocationType(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
