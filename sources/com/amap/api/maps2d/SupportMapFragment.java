package com.amap.api.maps2d;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.mapcore2d.ar;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {
    private AMap a;
    private IMapFragmentDelegate b;

    public static SupportMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public static SupportMapFragment newInstance(AMapOptions aMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MapOptions", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.b == null) {
            this.b = new ar();
        }
        this.b.setContext(getActivity());
        return this.b;
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
            if (this.a == null) {
                this.a = new AMap(map);
            }
            return this.a;
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "getMap");
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate().onInflate(activity, new AMapOptions(), bundle);
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onInflate");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (RemoteException e) {
                cm.a(e, "SupportMapFragment", "onCreateView");
                return null;
            }
        }
        return getMapFragmentDelegate().onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            getMapFragmentDelegate().onResume();
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onResume");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            getMapFragmentDelegate().onPause();
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onPause");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            getMapFragmentDelegate().onDestroyView();
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onDestroyView");
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onLowMemory");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            cm.a(e, "SupportMapFragment", "onSaveInstanceState");
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
