package com.amap.api.interfaces;

import android.os.RemoteException;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import java.util.ArrayList;

public interface IMarker {
    void destroy();

    boolean equalsRemote(IMarker iMarker);

    int getHeight();

    ArrayList<BitmapDescriptor> getIcons() throws RemoteException;

    String getId();

    Object getObject();

    int getPeriod() throws RemoteException;

    LatLng getPosition();

    LatLng getRealPosition();

    String getSnippet();

    String getTitle();

    int getWidth();

    @Override // com.amap.api.mapcore2d.ac
    float getZIndex();

    int hashCodeRemote();

    void hideInfoWindow();

    boolean isDraggable();

    boolean isInfoWindowShown();

    boolean isViewMode() throws RemoteException;

    boolean isVisible();

    boolean remove() throws RemoteException;

    void setAnchor(float f, float f2);

    void setDraggable(boolean z);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setIcons(ArrayList<BitmapDescriptor> arrayList) throws RemoteException;

    void setObject(Object obj);

    void setPeriod(int i) throws RemoteException;

    void setPosition(LatLng latLng);

    void setPositionByPixels(int i, int i2) throws RemoteException;

    void setRotateAngle(float f) throws RemoteException;

    void setSnippet(String str);

    void setTitle(String str);

    void setVisible(boolean z);

    void setZIndex(float f);

    void showInfoWindow();
}
