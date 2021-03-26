package mtopsdk.xstate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.aidl.IXState;

public class XStateService extends Service {
    private static final String TAG = "mtopsdk.XStateService";
    Object lock = new Object();
    IXState.Stub stub = null;

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        synchronized (this.lock) {
            if (this.stub == null) {
                XStateStub xStateStub = new XStateStub();
                this.stub = xStateStub;
                try {
                    xStateStub.init();
                } catch (RemoteException e) {
                    TBSdkLog.e("mtopsdk.XStateService", "[onBind]init() exception", e);
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.XStateService", "[onBind]init() error", th);
                }
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.XStateService", "[onBind] XStateService  stub= " + this.stub.hashCode());
        }
        return this.stub;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            IXState.Stub stub2 = this.stub;
            if (stub2 != null) {
                try {
                    stub2.unInit();
                } catch (RemoteException e) {
                    TBSdkLog.e("mtopsdk.XStateService", "[onDestroy]unInit() exception", e);
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.XStateService", "[onDestroy]unInit() error", th);
                }
            }
        }
    }

    class XStateStub extends IXState.Stub {
        public XStateStub() {
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public String removeKey(String str) throws RemoteException {
            return c.b(str);
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public void setValue(String str, String str2) throws RemoteException {
            c.a(str, str2);
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public void init() throws RemoteException {
            c.a(XStateService.this.getBaseContext());
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public void unInit() throws RemoteException {
            c.a();
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public String getValue(String str) throws RemoteException {
            return c.a(str);
        }
    }
}
