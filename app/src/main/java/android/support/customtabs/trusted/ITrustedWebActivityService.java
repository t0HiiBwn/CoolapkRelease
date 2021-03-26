package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITrustedWebActivityService extends IInterface {
    Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException;

    void cancelNotification(Bundle bundle) throws RemoteException;

    Bundle getActiveNotifications() throws RemoteException;

    Bundle getSmallIconBitmap() throws RemoteException;

    int getSmallIconId() throws RemoteException;

    Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {
        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";
        static final int TRANSACTION_areNotificationsEnabled = 6;
        static final int TRANSACTION_cancelNotification = 3;
        static final int TRANSACTION_getActiveNotifications = 5;
        static final int TRANSACTION_getSmallIconBitmap = 7;
        static final int TRANSACTION_getSmallIconId = 4;
        static final int TRANSACTION_notifyNotificationWithChannel = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
        }

        public static ITrustedWebActivityService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITrustedWebActivityService)) {
                return new Proxy(iBinder);
            }
            return (ITrustedWebActivityService) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 2:
                        parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle notifyNotificationWithChannel = notifyNotificationWithChannel(bundle);
                        parcel2.writeNoException();
                        if (notifyNotificationWithChannel != null) {
                            parcel2.writeInt(1);
                            notifyNotificationWithChannel.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        cancelNotification(bundle);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                        int smallIconId = getSmallIconId();
                        parcel2.writeNoException();
                        parcel2.writeInt(smallIconId);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                        Bundle activeNotifications = getActiveNotifications();
                        parcel2.writeNoException();
                        if (activeNotifications != null) {
                            parcel2.writeInt(1);
                            activeNotifications.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle areNotificationsEnabled = areNotificationsEnabled(bundle);
                        parcel2.writeNoException();
                        if (areNotificationsEnabled != null) {
                            parcel2.writeInt(1);
                            areNotificationsEnabled.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                        Bundle smallIconBitmap = getSmallIconBitmap();
                        parcel2.writeNoException();
                        if (smallIconBitmap != null) {
                            parcel2.writeInt(1);
                            smallIconBitmap.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("android.support.customtabs.trusted.ITrustedWebActivityService");
                return true;
            }
        }

        private static class Proxy implements ITrustedWebActivityService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.trusted.ITrustedWebActivityService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityService
            public void cancelNotification(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle getActiveNotifications() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityService
            public int getSmallIconId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle getSmallIconBitmap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
