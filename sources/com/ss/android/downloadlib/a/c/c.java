package com.ss.android.downloadlib.a.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.a.c.d;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.f.b;
import org.json.JSONObject;

/* compiled from: IAidlService */
public interface c extends IInterface {
    void a(b bVar, d dVar) throws RemoteException;

    /* compiled from: IAidlService */
    public static abstract class a extends Binder implements c {
        private static String a = "";

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0093a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                b bVar = null;
                if (i != 1) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface(a);
                if (parcel.readInt() != 0) {
                    bVar = b.CREATOR.createFromParcel(parcel);
                }
                a(bVar, d.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(a);
            return true;
        }

        /* renamed from: com.ss.android.downloadlib.a.c.c$a$a  reason: collision with other inner class name */
        /* compiled from: IAidlService */
        private static class C0093a implements c {
            private IBinder a;

            C0093a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject i = k.i();
                    String unused = a.a = b.a(i.optString("r"), i.optString("s"));
                }
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.ss.android.downloadlib.a.c.c
            public void a(b bVar, d dVar) throws RemoteException {
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
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
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
