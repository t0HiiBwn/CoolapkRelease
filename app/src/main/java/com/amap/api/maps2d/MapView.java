package com.amap.api.maps2d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.mapcore2d.ar;
import com.amap.api.mapcore2d.cm;
import com.amap.api.mapcore2d.ef;
import com.amap.api.maps2d.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private IMapFragmentDelegate a;
    private AMap b;

    public MapView(Context context) {
        super(context);
        getMapFragmentDelegate().setContext(context);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getMapFragmentDelegate().setContext(context);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getMapFragmentDelegate().setContext(context);
    }

    public MapView(Context context, AMapOptions aMapOptions) {
        super(context);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        try {
            if (this.a == null) {
                this.a = (IMapFragmentDelegate) ef.a(getContext(), cm.a(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", ar.class, null, null);
            }
        } catch (Throwable unused) {
        }
        if (this.a == null) {
            this.a = new ar();
        }
        return this.a;
    }

    public AMap getMap() {
        IMapFragmentDelegate mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            IAMap map = mapFragmentDelegate.getMap();
            if (map == null) {
                return null;
            }
            if (this.b == null) {
                this.b = new AMap(map);
            }
            return this.b;
        } catch (RemoteException e) {
            cm.a(e, "MapView", "getMap");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (RemoteException e) {
            cm.a(e, "MapView", "onCreate");
        } catch (Throwable th) {
            cm.a(th, "MapView", "onCreate");
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (RemoteException e) {
            cm.a(e, "MapView", "onResume");
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (RemoteException e) {
            cm.a(e, "MapView", "onPause");
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (RemoteException e) {
            cm.a(e, "MapView", "onDestroy");
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (RemoteException e) {
            cm.a(e, "MapView", "onLowMemory");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            cm.a(e, "MapView", "onSaveInstanceState");
        }
    }
}
