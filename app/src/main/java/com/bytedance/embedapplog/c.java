package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface c extends IInterface {
    String a();

    String a(String str);

    String b(String str);

    public static abstract class a extends Binder implements c {
        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0023a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String b = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
        }

        /* renamed from: com.bytedance.embedapplog.c$a$a  reason: collision with other inner class name */
        static class C0023a implements c {
            private IBinder a;

            C0023a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.bytedance.embedapplog.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.c
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.c
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
