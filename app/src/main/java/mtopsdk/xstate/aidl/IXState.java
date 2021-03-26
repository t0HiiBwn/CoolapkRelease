package mtopsdk.xstate.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IXState extends IInterface {
    String getValue(String str) throws RemoteException;

    void init() throws RemoteException;

    String removeKey(String str) throws RemoteException;

    void setValue(String str, String str2) throws RemoteException;

    void unInit() throws RemoteException;

    public static abstract class Stub extends Binder implements IXState {
        private static final String DESCRIPTOR = "mtopsdk.xstate.aidl.IXState";
        static final int TRANSACTION_getValue = 1;
        static final int TRANSACTION_init = 4;
        static final int TRANSACTION_removeKey = 2;
        static final int TRANSACTION_setValue = 3;
        static final int TRANSACTION_unInit = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "mtopsdk.xstate.aidl.IXState");
        }

        public static IXState asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("mtopsdk.xstate.aidl.IXState");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXState)) {
                return new a(iBinder);
            }
            return (IXState) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                String value = getValue(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(value);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                String removeKey = removeKey(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(removeKey);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                setValue(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                init();
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                unInit();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("mtopsdk.xstate.aidl.IXState");
                return true;
            }
        }

        static class a implements IXState {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public final String getValue(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("mtopsdk.xstate.aidl.IXState");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public final String removeKey(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("mtopsdk.xstate.aidl.IXState");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public final void setValue(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("mtopsdk.xstate.aidl.IXState");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public final void init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("mtopsdk.xstate.aidl.IXState");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // mtopsdk.xstate.aidl.IXState
            public final void unInit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("mtopsdk.xstate.aidl.IXState");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
