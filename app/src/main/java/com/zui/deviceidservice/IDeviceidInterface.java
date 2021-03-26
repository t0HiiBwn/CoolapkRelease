package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IDeviceidInterface extends IInterface {

    public static abstract class Stub extends Binder implements IDeviceidInterface {
        private static final String DESCRIPTOR = "com.zui.deviceidservice.IDeviceidInterface";
        public static final int TRANSACTION_createAAIDForPackageName = 6;
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 3;

        public static class Proxy implements IDeviceidInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public boolean createAAIDForPackageName(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.zui.deviceidservice.IDeviceidInterface";
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getUDID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getVAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public boolean isSupport() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static IDeviceidInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String oaid = getOAID();
                        parcel2.writeNoException();
                        parcel2.writeString(oaid);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String udid = getUDID();
                        parcel2.writeNoException();
                        parcel2.writeString(udid);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        boolean isSupport = isSupport();
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupport ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String vaid = getVAID(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(vaid);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String aaid = getAAID(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(aaid);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        boolean createAAIDForPackageName = createAAIDForPackageName(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(createAAIDForPackageName ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            }
        }
    }

    boolean createAAIDForPackageName(String str);

    String getAAID(String str);

    String getOAID();

    String getUDID();

    String getVAID(String str);

    boolean isSupport();
}
