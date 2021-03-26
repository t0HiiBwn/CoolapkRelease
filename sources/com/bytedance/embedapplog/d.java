package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface d extends IInterface {
    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();

    public static abstract class a extends Binder implements d {
        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0025a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean c = c();
                parcel2.writeNoException();
                parcel2.writeInt(c ? 1 : 0);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            }
        }

        /* renamed from: com.bytedance.embedapplog.d$a$a  reason: collision with other inner class name */
        static class C0025a implements d {
            private IBinder a;

            C0025a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.bytedance.embedapplog.d
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.d
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.d
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    boolean z = false;
                    this.a.transact(3, obtain, obtain2, 0);
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

            @Override // com.bytedance.embedapplog.d
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.d
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
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
