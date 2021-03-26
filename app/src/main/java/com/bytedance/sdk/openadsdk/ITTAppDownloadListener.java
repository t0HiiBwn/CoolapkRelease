package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITTAppDownloadListener extends IInterface {

    public static class Default implements ITTAppDownloadListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onIdle() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onInstalled(String str, String str2) throws RemoteException {
        }
    }

    void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFinished(long j, String str, String str2) throws RemoteException;

    void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException;

    void onIdle() throws RemoteException;

    void onInstalled(String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements ITTAppDownloadListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        }

        public static ITTAppDownloadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITTAppDownloadListener)) {
                return new a(iBinder);
            }
            return (ITTAppDownloadListener) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        onIdle();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        onDownloadActive(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        onDownloadPaused(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        onDownloadFailed(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        onDownloadFinished(parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                        onInstalled(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                return true;
            }
        }

        private static class a implements ITTAppDownloadListener {
            public static ITTAppDownloadListener a;
            private IBinder b;

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onIdle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onIdle();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
                Throwable th;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (this.b.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onDownloadActive(j, j2, str, str2);
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th2) {
                        th = th2;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
                Throwable th;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (this.b.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onDownloadPaused(j, j2, str, str2);
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th2) {
                        th = th2;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
                Throwable th;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (this.b.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onDownloadFailed(j, j2, str, str2);
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th2) {
                        th = th2;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.b.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDownloadFinished(j, str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onInstalled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.b.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onInstalled(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITTAppDownloadListener iTTAppDownloadListener) {
            if (a.a != null || iTTAppDownloadListener == null) {
                return false;
            }
            a.a = iTTAppDownloadListener;
            return true;
        }

        public static ITTAppDownloadListener getDefaultImpl() {
            return a.a;
        }
    }
}
