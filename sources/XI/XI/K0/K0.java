package XI.XI.K0;

import XI.XI.XI.XI;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public class K0 implements kM {
    public XI.XI.XI.XI K0;

    /* renamed from: XI  reason: collision with root package name */
    public Context f1173XI;
    public xo kM;
    public ServiceConnection xo = new XI();

    public class XI implements ServiceConnection {
        public XI() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XI.XI.XI.XI xi;
            K0 k0 = K0.this;
            int i = XI.AbstractBinderC0004XI.f1176XI;
            if (iBinder == null) {
                xi = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                xi = (queryLocalInterface == null || !(queryLocalInterface instanceof XI.XI.XI.XI)) ? new XI.AbstractBinderC0004XI.C0005XI(iBinder) : (XI.XI.XI.XI) queryLocalInterface;
            }
            k0.K0 = xi;
            K0.this.kM.connectSuccess(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            K0.this.K0 = null;
        }
    }

    public K0(Context context) {
        this.f1173XI = context;
    }

    public boolean XI() {
        boolean z;
        XI.XI.XI.XI xi = this.K0;
        if (xi != null) {
            try {
                z = xi.isSupported();
            } catch (RemoteException e) {
                e.getMessage();
                e.printStackTrace();
            }
            String str = "isSupported:" + this.K0;
            return z;
        }
        z = false;
        String str = "isSupported:" + this.K0;
        return z;
    }
}
