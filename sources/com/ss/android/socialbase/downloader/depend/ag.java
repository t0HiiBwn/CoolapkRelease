package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: INotificationClickAidlCallback */
public interface ag extends IInterface {
    boolean a(DownloadInfo downloadInfo) throws RemoteException;

    boolean b(DownloadInfo downloadInfo) throws RemoteException;

    boolean c(DownloadInfo downloadInfo) throws RemoteException;

    /* compiled from: INotificationClickAidlCallback */
    public static abstract class a extends Binder implements ag {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        public static ag a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ag)) {
                return new C0097a(iBinder);
            }
            return (ag) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            DownloadInfo downloadInfo = null;
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                if (parcel.readInt() != 0) {
                    downloadInfo = DownloadInfo.CREATOR.createFromParcel(parcel);
                }
                boolean a = a(downloadInfo);
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                if (parcel.readInt() != 0) {
                    downloadInfo = DownloadInfo.CREATOR.createFromParcel(parcel);
                }
                boolean b = b(downloadInfo);
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                if (parcel.readInt() != 0) {
                    downloadInfo = DownloadInfo.CREATOR.createFromParcel(parcel);
                }
                boolean c = c(downloadInfo);
                parcel2.writeNoException();
                parcel2.writeInt(c ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                return true;
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.depend.ag$a$a  reason: collision with other inner class name */
        /* compiled from: INotificationClickAidlCallback */
        private static class C0097a implements ag {
            public static ag a;
            private IBinder b;

            C0097a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z = true;
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(downloadInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z = true;
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(downloadInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z = true;
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().c(downloadInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
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

        public static ag a() {
            return C0097a.a;
        }
    }
}
