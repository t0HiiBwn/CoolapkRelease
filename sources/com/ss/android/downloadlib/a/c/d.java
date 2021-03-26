package com.ss.android.downloadlib.a.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.f.b;
import org.json.JSONObject;

/* compiled from: ICallback */
public interface d extends IInterface {
    void a(b bVar) throws RemoteException;

    /* compiled from: ICallback */
    public static abstract class a extends Binder implements d {
        private static String a = "";

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0094a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(a);
                return true;
            }
        }

        /* renamed from: com.ss.android.downloadlib.a.c.d$a$a  reason: collision with other inner class name */
        /* compiled from: ICallback */
        private static class C0094a implements d {
            private IBinder a;

            C0094a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject i = k.i();
                    String unused = a.a = b.a(i.optString("t"), i.optString("s"));
                }
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.ss.android.downloadlib.a.c.d
            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
