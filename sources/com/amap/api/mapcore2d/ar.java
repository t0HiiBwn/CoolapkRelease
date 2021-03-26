package com.amap.api.mapcore2d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import java.util.Objects;

/* compiled from: MapFragmentDelegateImp */
public class ar implements IMapFragmentDelegate {
    public static volatile Context a;
    private IAMap b;
    private AMapOptions c;

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onDestroyView() throws RemoteException {
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void setContext(Context context) {
        a(context);
    }

    private void a(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void setOptions(AMapOptions aMapOptions) {
        this.c = aMapOptions;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public IAMap getMap() throws RemoteException {
        if (this.b == null) {
            Objects.requireNonNull(a, "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            a();
            this.b = new b(a);
        }
        return this.b;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity);
        this.c = aMapOptions;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
        ck.a("MapFragmentDelegateImp", "onCreate", 113);
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (this.b == null) {
            if (a == null && layoutInflater != null) {
                setContext(layoutInflater.getContext().getApplicationContext());
            }
            Objects.requireNonNull(a, "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            a();
            this.b = new b(a);
        }
        try {
            if (!(this.c != null || bundle == null || (byteArray = bundle.getByteArray("MapOptions")) == null)) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.c = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            a(this.c);
            ck.a("MapFragmentDelegateImp", "onCreateView", 113);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.b.getView();
    }

    void a() {
        int i = a.getResources().getDisplayMetrics().densityDpi;
        q.f1243l = i;
        if (i <= 320) {
            q.j = 256;
        } else if (i <= 480) {
            q.j = 384;
        } else {
            q.j = 512;
        }
        if (i <= 120) {
            q.a = 0.5f;
        } else if (i <= 160) {
            q.a = 0.6f;
            q.a(18);
        } else if (i <= 240) {
            q.a = 0.87f;
        } else if (i <= 320) {
            q.a = 1.0f;
        } else if (i <= 480) {
            q.a = 1.5f;
        } else {
            q.a = 1.8f;
        }
        if (q.a <= 0.6f) {
            q.c = 18;
        }
    }

    void a(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions != null && this.b != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.b.moveCamera(new CameraUpdate(m.a(camera.target, camera.zoom, camera.bearing, camera.tilt)));
            }
            UiSettings aMapUiSettings = this.b.getAMapUiSettings();
            aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled().booleanValue());
            aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled().booleanValue());
            aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled().booleanValue());
            aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled().booleanValue());
            aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled().booleanValue());
            aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
            this.b.setMapType(aMapOptions.getMapType());
            this.b.setZOrderOnTop(aMapOptions.getZOrderOnTop().booleanValue());
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onResume() throws RemoteException {
        IAMap iAMap = this.b;
        if (iAMap != null) {
            iAMap.onResume();
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onPause() throws RemoteException {
        IAMap iAMap = this.b;
        if (iAMap != null) {
            iAMap.onPause();
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onDestroy() throws RemoteException {
        if (getMap() != null) {
            getMap().clear();
            getMap().destroy();
        }
        setContext(null);
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.b != null) {
            if (this.c == null) {
                this.c = new AMapOptions();
            }
            this.c = this.c.camera(getMap().getCameraPosition());
            if (bundle != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    this.c.writeToParcel(obtain, 0);
                    bundle.putByteArray("MapOptions", obtain.marshall());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
