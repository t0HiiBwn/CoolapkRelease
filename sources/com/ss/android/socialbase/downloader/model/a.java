package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.v;

/* compiled from: DownloadAidlTask */
public interface a extends IInterface {
    int a(int i) throws RemoteException;

    i a(int i, int i2) throws RemoteException;

    DownloadInfo a() throws RemoteException;

    e b() throws RemoteException;

    i b(int i) throws RemoteException;

    aa c() throws RemoteException;

    l c(int i) throws RemoteException;

    ag d() throws RemoteException;

    h e() throws RemoteException;

    f f() throws RemoteException;

    v g() throws RemoteException;

    ai h() throws RemoteException;

    p i() throws RemoteException;

    j j() throws RemoteException;

    g k() throws RemoteException;

    int l() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.model.a$a  reason: collision with other inner class name */
    /* compiled from: DownloadAidlTask */
    public static abstract class AbstractBinderC0122a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0122a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0123a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                IBinder iBinder = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        DownloadInfo a = a();
                        parcel2.writeNoException();
                        if (a != null) {
                            parcel2.writeInt(1);
                            a.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        e b = b();
                        parcel2.writeNoException();
                        if (b != null) {
                            iBinder = b.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int a2 = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a2);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i a3 = a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (a3 != null) {
                            iBinder = a3.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i b2 = b(parcel.readInt());
                        parcel2.writeNoException();
                        if (b2 != null) {
                            iBinder = b2.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        aa c = c();
                        parcel2.writeNoException();
                        if (c != null) {
                            iBinder = c.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ag d = d();
                        parcel2.writeNoException();
                        if (d != null) {
                            iBinder = d.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        h e = e();
                        parcel2.writeNoException();
                        if (e != null) {
                            iBinder = e.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        f f = f();
                        parcel2.writeNoException();
                        if (f != null) {
                            iBinder = f.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        v g = g();
                        parcel2.writeNoException();
                        if (g != null) {
                            iBinder = g.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ai h = h();
                        parcel2.writeNoException();
                        if (h != null) {
                            iBinder = h.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        p i3 = i();
                        parcel2.writeNoException();
                        if (i3 != null) {
                            iBinder = i3.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        j j = j();
                        parcel2.writeNoException();
                        if (j != null) {
                            iBinder = j.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        g k = k();
                        parcel2.writeNoException();
                        if (k != null) {
                            iBinder = k.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int l = l();
                        parcel2.writeNoException();
                        parcel2.writeInt(l);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        l c2 = c(parcel.readInt());
                        parcel2.writeNoException();
                        if (c2 != null) {
                            iBinder = c2.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.model.a$a$a  reason: collision with other inner class name */
        /* compiled from: DownloadAidlTask */
        private static class C0123a implements a {
            public static a a;
            private IBinder b;

            C0123a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(1, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().a();
                    }
                    obtain2.readException();
                    DownloadInfo createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public e b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(2, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().b();
                    }
                    obtain2.readException();
                    e a2 = e.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.b.transact(3, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().a(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.b.transact(4, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().a(i, i2);
                    }
                    obtain2.readException();
                    i a2 = i.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.b.transact(5, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().b(i);
                    }
                    obtain2.readException();
                    i a2 = i.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public aa c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(6, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().c();
                    }
                    obtain2.readException();
                    aa a2 = aa.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ag d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(7, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().d();
                    }
                    obtain2.readException();
                    ag a2 = ag.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public h e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(8, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().e();
                    }
                    obtain2.readException();
                    h a2 = h.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public f f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(9, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().f();
                    }
                    obtain2.readException();
                    f a2 = f.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public v g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(10, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().g();
                    }
                    obtain2.readException();
                    v a2 = v.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ai h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(11, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().h();
                    }
                    obtain2.readException();
                    ai a2 = ai.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(12, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().i();
                    }
                    obtain2.readException();
                    p a2 = p.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public j j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(13, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().j();
                    }
                    obtain2.readException();
                    j a2 = j.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public g k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(14, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().k();
                    }
                    obtain2.readException();
                    g a2 = g.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(15, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().l();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.b.transact(16, obtain, obtain2, 0) && AbstractBinderC0122a.m() != null) {
                        return AbstractBinderC0122a.m().c(i);
                    }
                    obtain2.readException();
                    l a2 = l.a.a(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return a2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a m() {
            return C0123a.a;
        }
    }
}
