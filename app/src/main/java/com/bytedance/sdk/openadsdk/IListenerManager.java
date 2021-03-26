package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;

public interface IListenerManager extends IInterface {

    public static class Default implements IListenerManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void broadcastDialogListener(String str, int i) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void executeFullVideoCallback(String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IListenerManager
        public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        }
    }

    void broadcastDialogListener(String str, int i) throws RemoteException;

    void broadcastPermissionListener(String str, String str2) throws RemoteException;

    void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException;

    void executeFullVideoCallback(String str, String str2) throws RemoteException;

    void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException;

    void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException;

    void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException;

    void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException;

    void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException;

    void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException;

    void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IListenerManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IListenerManager");
        }

        public static IListenerManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IListenerManager)) {
                return new a(iBinder);
            }
            return (IListenerManager) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerRewardVideoListener(parcel.readString(), IRewardAdInteractionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        executeRewardVideoCallback(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerFullVideoListener(parcel.readString(), IFullScreenVideoAdInteractionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        executeFullVideoCallback(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerTTAppDownloadListener(parcel.readString(), ITTAppDownloadListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        unregisterTTAppDownloadListener(parcel.readString(), ITTAppDownloadListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        executeAppDownloadCallback(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerDialogListener(parcel.readString(), ICommonDialogListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        broadcastDialogListener(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerPermissionListener(parcel.readString(), ICommonPermissionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        broadcastPermissionListener(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.bytedance.sdk.openadsdk.IListenerManager");
                return true;
            }
        }

        private static class a implements IListenerManager {
            public static IListenerManager a;
            private IBinder b;

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iRewardAdInteractionListener != null ? iRewardAdInteractionListener.asBinder() : null);
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerRewardVideoListener(str, iRewardAdInteractionListener);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException {
                Throwable th;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    obtain.writeInt(i2);
                    obtain.writeString(str4);
                    try {
                        if (this.b.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().executeRewardVideoCallback(str, str2, z, i, str3, i2, str4);
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

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iFullScreenVideoAdInteractionListener != null ? iFullScreenVideoAdInteractionListener.asBinder() : null);
                    if (this.b.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerFullVideoListener(str, iFullScreenVideoAdInteractionListener);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeFullVideoCallback(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.b.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().executeFullVideoCallback(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTTAppDownloadListener != null ? iTTAppDownloadListener.asBinder() : null);
                    if (this.b.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerTTAppDownloadListener(str, iTTAppDownloadListener);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTTAppDownloadListener != null ? iTTAppDownloadListener.asBinder() : null);
                    if (this.b.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().unregisterTTAppDownloadListener(str, iTTAppDownloadListener);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
                Throwable th;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    try {
                        if (this.b.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().executeAppDownloadCallback(str, str2, j, j2, str3, str4);
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

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iCommonDialogListener != null ? iCommonDialogListener.asBinder() : null);
                    if (this.b.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerDialogListener(str, iCommonDialogListener);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void broadcastDialogListener(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (this.b.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().broadcastDialogListener(str, i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iCommonPermissionListener != null ? iCommonPermissionListener.asBinder() : null);
                    if (this.b.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerPermissionListener(str, iCommonPermissionListener);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void broadcastPermissionListener(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.b.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().broadcastPermissionListener(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IListenerManager iListenerManager) {
            if (a.a != null || iListenerManager == null) {
                return false;
            }
            a.a = iListenerManager;
            return true;
        }

        public static IListenerManager getDefaultImpl() {
            return a.a;
        }
    }
}
