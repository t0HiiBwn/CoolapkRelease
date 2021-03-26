package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDownloadDiskSpaceAidlCallback */
public interface o extends IInterface {
    void a() throws RemoteException;

    /* compiled from: IDownloadDiskSpaceAidlCallback */
    public static abstract class a extends Binder implements o {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static o a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                return new C0107a(iBinder);
            }
            return (o) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.depend.o$a$a  reason: collision with other inner class name */
        /* compiled from: IDownloadDiskSpaceAidlCallback */
        private static class C0107a implements o {
            public static o a;
            private IBinder b;

            C0107a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (this.b.transact(1, obtain, obtain2, 0) || a.b() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    a.b().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static o b() {
            return C0107a.a;
        }
    }
}
