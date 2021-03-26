package com.amap.api.interfaces;

import android.os.RemoteException;

public interface IOverlay {
    void destroy();

    boolean equalsRemote(IOverlay iOverlay) throws RemoteException;

    String getId() throws RemoteException;

    float getZIndex() throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    void setZIndex(float f) throws RemoteException;
}
