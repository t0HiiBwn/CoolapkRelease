package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface MsaIdInterface extends IInterface {

    public static class Default implements MsaIdInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bun.lib.MsaIdInterface
        public String getAAID() {
            return null;
        }

        @Override // com.bun.lib.MsaIdInterface
        public String getOAID() {
            return null;
        }

        @Override // com.bun.lib.MsaIdInterface
        public String getVAID() {
            return null;
        }

        @Override // com.bun.lib.MsaIdInterface
        public boolean isDataArrived() {
            return false;
        }

        @Override // com.bun.lib.MsaIdInterface
        public boolean isSupported() {
            return false;
        }

        @Override // com.bun.lib.MsaIdInterface
        public void shutDown() {
        }
    }

    public static abstract class Stub extends Binder implements MsaIdInterface {
        private static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isDataArrived = 2;
        public static final int TRANSACTION_isSupported = 1;
        public static final int TRANSACTION_shutDown = 6;

        public static class Proxy implements MsaIdInterface {
            public static MsaIdInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bun.lib.MsaIdInterface
            public String getAAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getAAID();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.bun.lib.MsaIdInterface";
            }

            @Override // com.bun.lib.MsaIdInterface
            public String getOAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getOAID();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bun.lib.MsaIdInterface
            public String getVAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getVAID();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bun.lib.MsaIdInterface
            public boolean isDataArrived() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDataArrived();
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

            @Override // com.bun.lib.MsaIdInterface
            public boolean isSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupported();
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

            @Override // com.bun.lib.MsaIdInterface
            public void shutDown() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().shutDown();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.bun.lib.MsaIdInterface");
        }

        public static MsaIdInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof MsaIdInterface)) ? new Proxy(iBinder) : (MsaIdInterface) queryLocalInterface;
        }

        public static MsaIdInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MsaIdInterface msaIdInterface) {
            if (Proxy.sDefaultImpl != null || msaIdInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = msaIdInterface;
            return true;
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
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean isSupported = isSupported();
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupported ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean isDataArrived = isDataArrived();
                        parcel2.writeNoException();
                        parcel2.writeInt(isDataArrived ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String oaid = getOAID();
                        parcel2.writeNoException();
                        parcel2.writeString(oaid);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String vaid = getVAID();
                        parcel2.writeNoException();
                        parcel2.writeString(vaid);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String aaid = getAAID();
                        parcel2.writeNoException();
                        parcel2.writeString(aaid);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        shutDown();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
        }
    }

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isDataArrived();

    boolean isSupported();

    void shutDown();
}
