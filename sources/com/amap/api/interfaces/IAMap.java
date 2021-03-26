package com.amap.api.interfaces;

import android.location.Location;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import java.util.List;

public interface IAMap {
    void AMapInvalidate();

    Circle addCircle(CircleOptions circleOptions) throws RemoteException;

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    Marker addMarker(MarkerOptions markerOptions) throws RemoteException;

    Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException;

    Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException;

    Text addText(TextOptions textOptions) throws RemoteException;

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void animateCamera(CameraUpdate cameraUpdate) throws RemoteException;

    void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException;

    void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) throws RemoteException;

    void clear() throws RemoteException;

    void destroy();

    Projection getAMapProjection() throws RemoteException;

    UiSettings getAMapUiSettings() throws RemoteException;

    CameraPosition getCameraPosition() throws RemoteException;

    int getLogoPosition();

    Handler getMainHandler();

    LatLngBounds getMapBounds();

    int getMapHeight();

    List<Marker> getMapScreenMarkers() throws RemoteException;

    void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener);

    int getMapType() throws RemoteException;

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation() throws RemoteException;

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    float getScalePerPixel();

    View getView() throws RemoteException;

    float getZoomLevel();

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isTrafficEnabled() throws RemoteException;

    void moveCamera(CameraUpdate cameraUpdate) throws RemoteException;

    void onPause();

    void onResume();

    void redrawInfoWindow();

    boolean removeGLOverlay(String str) throws RemoteException;

    boolean removeMarker(String str);

    void removecache() throws RemoteException;

    void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException;

    void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException;

    void setLocationSource(LocationSource locationSource) throws RemoteException;

    void setLogoPosition(int i);

    void setMapLanguage(String str) throws RemoteException;

    void setMapType(int i) throws RemoteException;

    void setMyLocationEnabled(boolean z) throws RemoteException;

    void setMyLocationRotateAngle(float f) throws RemoteException;

    void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException;

    void setMyLocationType(int i);

    void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;

    void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException;

    void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException;

    void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException;

    void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException;

    void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    void setTrafficEnabled(boolean z) throws RemoteException;

    void setZOrderOnTop(boolean z) throws RemoteException;

    void setZoomPosition(int i);

    void showCompassEnabled(boolean z);

    void showMyLocationButtonEnabled(boolean z);

    void showMyLocationOverlay(Location location);

    void showScaleEnabled(boolean z);

    void showZoomControlsEnabled(boolean z);

    void stopAnimation() throws RemoteException;
}
