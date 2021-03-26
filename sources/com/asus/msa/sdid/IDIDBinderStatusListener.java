package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

public interface IDIDBinderStatusListener extends IInterface {

    public static abstract class Stub extends Binder implements IDIDBinderStatusListener {
        public static final String DESCRIPTOR = "com.asus.msa.sdid.IDIDBinderStatusListener";
        public static final int TRANSACTION_onError = 2;
        public static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IDIDBinderStatusListener {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.asus.msa.sdid.IDIDBinderStatusListener";
            }

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public void onError() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public void onSuccess(IDidAidlInterface iDidAidlInterface) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
                    obtain.writeStrongBinder(iDidAidlInterface != null ? iDidAidlInterface.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
        }

        public static IDIDBinderStatusListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDIDBinderStatusListener)) ? new Proxy(iBinder) : (IDIDBinderStatusListener) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
                onSuccess(IDidAidlInterface.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i == 2) {
                parcel.enforceInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
                onError();
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.asus.msa.sdid.IDIDBinderStatusListener");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onError();

    void onSuccess(IDidAidlInterface iDidAidlInterface);
}
