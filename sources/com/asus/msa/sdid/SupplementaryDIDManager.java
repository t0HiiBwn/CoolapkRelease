package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public boolean isBinded = false;
    public Context mContext;
    public IDidAidlInterface mDidService;
    public IDIDBinderStatusListener mListener;
    public ServiceConnection mServiceConnection = new ServiceConnection() {
        /* class com.asus.msa.sdid.SupplementaryDIDManager.AnonymousClass1 */

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean unused = SupplementaryDIDManager.DEBUG;
            SupplementaryDIDManager.this.mDidService = IDidAidlInterface.Stub.asInterface(iBinder);
            SupplementaryDIDManager.this.notifyAllListeners(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SupplementaryDIDManager.this.notifyAllListeners(false);
        }
    };

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void notifyAllListeners(boolean z) {
        if (z) {
            try {
                this.mListener.onSuccess(this.mDidService);
            } catch (Exception e) {
                if (DEBUG) {
                    e.getMessage();
                }
            }
        } else {
            this.mListener.onError();
        }
    }

    public void deInit() {
        ServiceConnection serviceConnection;
        Context context;
        try {
            if (this.isBinded && (serviceConnection = this.mServiceConnection) != null && (context = this.mContext) != null) {
                this.isBinded = false;
                context.unbindService(serviceConnection);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void init(IDIDBinderStatusListener iDIDBinderStatusListener) {
        try {
            this.mListener = iDIDBinderStatusListener;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
        } catch (Exception unused) {
            notifyAllListeners(false);
        }
    }

    public void showLog(boolean z) {
        DEBUG = z;
    }
}
