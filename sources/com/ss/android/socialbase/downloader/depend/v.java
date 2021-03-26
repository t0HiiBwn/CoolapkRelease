package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.u;

/* compiled from: IDownloadForbiddenAidlHandler */
public interface v extends IInterface {
    boolean a(u uVar) throws RemoteException;

    /* compiled from: IDownloadForbiddenAidlHandler */
    public static abstract class a extends Binder implements v {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static v a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof v)) {
                return new C0110a(iBinder);
            }
            return (v) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                boolean a = a(u.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.depend.v$a$a  reason: collision with other inner class name */
        /* compiled from: IDownloadForbiddenAidlHandler */
        private static class C0110a implements v {
            public static v a;
            private IBinder b;

            C0110a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    boolean z = false;
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uVar);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static v a() {
            return C0110a.a;
        }
    }
}
